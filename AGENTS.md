# AGENTS.md — OncoMédica API (equipment_maintenance_api)

API de gestión de inventario de equipos médicos y mantenimientos técnicos para clínicas.
Fuentes de verdad: `requeriments.md` (funcionalidad y modelos) y `context.txt` (reglas de arquitectura).

---

## ⚠️ REGLAS IMPERATIVAS — Arquitectura Hexagonal

Estas reglas son **obligatorias**. No las violes bajo ninguna circunstancia:

1. **Pureza del dominio:** la capa `domain/` NUNCA importa `org.springframework.*`, `jakarta.persistence.*` ni librerías de infraestructura. Solo Java puro (+ Lombok).
2. **Inyección por constructor:** obligatoria en todo el código. Prohibido `@Autowired` en atributos de clase.
3. **Fechas y tiempos:**
   - `LocalDateTime` para estampas de tiempo y fechas programadas (`scheduledDate`, `startDate`).
   - `java.time.Duration` para intervalos transcurridos (`timeUsed`). Prohibido usar `LocalDateTime` para duraciones.
4. **Encapsulamiento del dominio:** las entidades protegen sus reglas con métodos explícitos de negocio (ej. `mantenimiento.completar(...)`). Evita getters/setters mutables indiscriminados.
5. **Puertos primero:** NO crees archivos en `infrastructure/` sin haber definido antes su Puerto correspondiente (`port/in` o `port/out`) en `domain/`.
6. **Dependencias hacia adentro:** `infrastructure` depende de `domain`; jamás al revés.

---

## Comandos

```bash
./mvnw compile                      # compilar
./mvnw test                         # todos los tests
./mvnw test -Dtest=NombreClaseTest  # un solo test
```

- Usar siempre el wrapper `./mvnw` (no un Maven global).
- Verificar con `./mvnw compile` después de cada cambio estructural.

## Stack y quirks del toolchain

- **Java 17 + Spring Boot 4.1.0** (Maven, `pom.xml`).
- ⚠️ **Nombres de starters de Boot 4** (difieren de Boot 3, un agente los adivinaría mal):
  - `spring-boot-starter-webmvc` (NO `spring-boot-starter-web`)
  - Tests: `spring-boot-starter-webmvc-test`, `spring-boot-starter-data-jpa-test`
  - Consola H2 es starter propio: `spring-boot-h2console`
- **BD:** H2 en desarrollo; MySQL es el objetivo para producción. Esquema gestionado por Flyway (nunca `ddl-auto=update`); usar `validate`.
- Lombok configurado con `annotationProcessorPaths` en `maven-compiler-plugin`.

## Estructura y límites de paquetes

Base: `com.imat.equipment_maintenance_api`

| Paquete | Responsabilidad | Puede depender de |
|---|---|---|
| `domain/model`, `domain/enums`, `domain/exception` | Entidades puras, enums, excepciones | Solo JDK/Lombok |
| `domain/port/in` | Casos de uso (interfaces) | `domain/model` |
| `domain/port/out` | Repositorios, Storage, Notification, Report (interfaces) | `domain/model` |
| `application/usecase` | Implementa puertos de entrada; `@Transactional` aquí | domain completo |
| `infrastructure/*` | Adaptadores: `persistence` (JPA), `web` (REST/DTOs/advice), `storage`, `notification`, `report`, `security`, `config` | domain + Spring |

Flujo: Controller → puerto de entrada → UseCase → puerto de salida → adaptador.

## Convenciones del proyecto

- **Tablas JPA en español** (definidas en `requeriments.md`): `equipos`, `mantenimientos`, `cronograma`, `personal_mantenimiento`, `ordenes`. Columnas personalizadas en staff: `nombre`, `apellido`, `mantenimientos_completados`.
- IDs de dominio siempre `Long`.
- Enums como `@Enumerated(EnumType.STRING)` en persistencia: `MaintenanceTypeEnum` (MC, MP, CA, CL, VA), `OrderStatus` (PENDING, COMPLETED), `UserRole` (ADMIN, TECHNICIAN).
- Errores HTTP vía `ProblemDetail` (RFC 7807) en `GlobalExceptionHandler`: `NotFoundException`→404, `BusinessRuleException`→422.
- Nunca exponer entidades JPA ni modelos de dominio en controllers; usar DTOs validados.
- Listados paginados desde el diseño inicial.

## Modelo canónico de dominio

- Los modelos en `domain/model/` siguen el modelo canónico de `context.txt` (sección 2): **unidireccionales** — los hijos referencian al padre (`Maintenance.equipment`, `Order.equipment`), sin colecciones inversas en `Equipment` ni `MaintenanceStaff`; la navegación se hace vía puertos de repositorio.
- `Maintenance.type` es `MaintenanceTypeEnum` (no String). `MonthlyMaintenanceType` solo tiene `id`, `type`, `quantity`. `MaintenanceStaff.available` (no `availability`). `startTime`/`deliveryTime` NO existen; solo `scheduledDate`, `startDate`, `deliveryDate`, `timeUsed` (`Duration`).

## Pendiente del plan aprobado (fases restantes)

Fase 0 (deps pom: security/validation/websocket/springdoc/openpdf/mysql/flyway/mapstruct/testcontainers + perfiles dev/prod) → Fase 2 (entidades JPA + Flyway V1) → Fase 3 (CRUDs REST) → Fase 4 (JWT + User) → Fase 5 (StoragePort local) → Fase 6 (WebSocket STOMP) → Fase 7 (órdenes automáticas + PDF) → Fase 8 (tests por capa + Swagger).
