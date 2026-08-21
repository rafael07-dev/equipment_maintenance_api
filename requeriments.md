OncoMédica – Sistema de Gestión de Mantenimientos e Inventario

**OncoMédica** es una aplicación profesional diseñada para clínicas, enfocada en la **gestión de inventarios de equipos médicos** y **mantenimientos técnicos**, con funcionalidades en tiempo real y principios sólidos de arquitectura limpia y buenas prácticas.


----------------------------------------------------------------
MODELOS DE DOMINIO
----------------------------------------------------------------

EQUIPMENT (Equipo médico)
-------------------------
- id                  : Integer
- equipmentName       : String   (nombre del equipo)
- imageUrl            : String   (ruta/URL de la imagen)
- type                : String   (tipo de equipo)
- inventoryCode       : String   (código de inventario)
- brand               : String   (marca)
- model               : String   (modelo)
- series              : String   (serie)
- location            : String   (ubicación)
- area                : String   (área)
- frequency           : String   (frecuencia de mantenimiento)
- floor               : String   (piso)
- tower               : String   (torre)
- maintenances        : List<Maintenance>
- maintenanceSchedules: List<MaintenanceSchedule>
- orderList           : List<Order>

MAINTENANCE (Mantenimiento)
---------------------------
- id                 : Long
- equipment          : Equipment
- maintenanceStaff   : MaintenanceStaff
- scheduledDate      : LocalDateTime (fecha programada)
- startDate          : LocalDateTime (fecha de inicio)
- startTime          : LocalDateTime (hora de inicio)
- deliveryDate       : LocalDateTime (fecha de entrega)
- deliveryTime       : LocalDateTime (hora de entrega)
- timeUsed           : LocalDateTime (tiempo usado)
- registrationDate   : LocalDateTime (fecha de registro)
- dateOfCompletion   : LocalDateTime (fecha de finalización)
- type               : String  (tipo de mantenimiento)
- observations       : String  (observaciones)
- staffObservations  : String  (observaciones del personal)
- done               : boolean (finalizado)
- evidenceImg        : String  (imagen de evidencia)

MAINTENANCE_SCHEDULE (Cronograma de mantenimiento)
--------------------------------------------------
- id                  : Integer
- equipment           : Equipment
- responsible         : MaintenanceStaff (responsable)
- monthlyMaintenances : List<MonthlyMaintenance>

MAINTENANCE_STAFF (Personal de mantenimiento)
---------------------------------------------
- id                   : Integer
- firstName            : String  (nombre)
- lastName             : String  (apellido)
- email                : String
- occupation           : String  (ocupación/cargo)
- availability         : boolean ("available" o "busy")
- maintenanceCompleted : Integer (mantenimientos completados)
- signaturePath        : String  (ruta de la firma)
- orderList            : List<Order>

MONTHLY_MAINTENANCE (Mantenimiento mensual)
-------------------------------------------
- id                 : Integer
- maintenanceSchedule: MaintenanceSchedule
- month              : Integer (mes)
- year               : Integer (año)
- maintenanceTypes   : List<MonthlyMaintenanceType>

MONTHLY_MAINTENANCE_TYPE (Tipo de mantenimiento mensual)
--------------------------------------------------------
- id                  : int
- maintenanceTypeEnum : MaintenanceTypeEnum
- monthlyMaintenance  : MonthlyMaintenance
- quantity            : Integer (cantidad)

ORDER (Orden)
-------------
- id              : Integer
- creationDate    : LocalDateTime (fecha de creación)
- maintenanceStaff: MaintenanceStaff
- equipment       : Equipment
- maintenance     : Maintenance
- status          : OrderStatus

----------------------------------------------------------------
2. ENUMS (domain/model/)
----------------------------------------------------------------

MAINTENANCE_TYPE_ENUM (Tipos de mantenimiento)
----------------------------------------------
- MC
- MP
- CA
- CL
- VA

ORDER_STATUS (Estado de la orden)
---------------------------------
- PENDING
- COMPLETED

----------------------------------------------------------------
ENTIDADES DE PERSISTENCIA JPA
----------------------------------------------------------------

EquipmentEntity          -> Tabla: "equipos"
Mismos atributos que Equipment.
Relaciones:
- maintenances         : @OneToMany(mappedBy="equipment") List<MaintenanceEntity>
- maintenanceSchedules : @OneToMany(mappedBy="equipment") List<MaintenanceScheduleEntity>
- orderList            : @OneToMany(mappedBy="equipment", cascade=ALL) List<OrderEntity>

MaintenanceEntity        -> Tabla: "mantenimientos"
Mismos atributos que Maintenance.
Relaciones:
- equipment        : @ManyToOne -> equipment_id
- maintenanceStaff : @ManyToOne -> staff_id

MaintenanceScheduleEntity -> Tabla: "cronograma"
Mismos atributos que MaintenanceSchedule.
Relaciones:
- equipment          : @ManyToOne -> equipment_id
- responsible        : @ManyToOne -> responsible_id
- monthlyMaintenances: @OneToMany(mappedBy="maintenanceSchedule",
  cascade=ALL, orphanRemoval=true)

MaintenanceStaffEntity   -> Tabla: "personal_mantenimiento"
Columnas personalizadas:
- nombre                     -> firstName
- apellido                   -> lastName
- mantenimientos_completados -> maintenanceCompleted
  Relaciones:
- orderList : @OneToMany(mappedBy="maintenanceStaff", cascade=ALL) List<OrderEntity>

MonthlyMaintenanceEntity -> Sin tabla especificada (@Entity)
Relaciones:
- maintenanceSchedule: @ManyToOne -> schedule_id
- maintenanceTypes   : @OneToMany(mappedBy="monthlyMaintenance",
  cascade=ALL, orphanRemoval=true)

MonthlyMaintenanceTypeEntity -> Sin tabla especificada (@Entity)
- maintenanceTypeEnum: @Enumerated(EnumType.STRING)
- monthlyMaintenance : @ManyToOne -> monthly_maintenance_id

OrderEntity              -> Tabla: "ordenes"
- status: @Enumerated(EnumType.STRING)
  Relaciones:
- maintenanceStaff: @ManyToOne -> staff_id
- equipment       : @ManyToOne -> equipment_id
- maintenance     : @OneToOne(cascade=ALL, orphanRemoval=true) -> maintenance_id

----------------------------------------------------------------
RESUMEN DE RELACIONES
----------------------------------------------------------------

Equipment 1 --- N Maintenance
Equipment 1 --- N MaintenanceSchedule
Equipment 1 --- N Order

MaintenanceStaff 1 --- N Maintenance
MaintenanceStaff 1 --- N MaintenanceSchedule (como responsable)
MaintenanceStaff 1 --- N Order

MaintenanceSchedule 1 --- N MonthlyMaintenance
MonthlyMaintenance 1 --- N MonthlyMaintenanceType

Order N --- 1 MaintenanceStaff
Order N --- 1 Equipment
Order 1 --- 1 Maintenance

## Funcionalidades principales

- Gestión de inventario de equipos médicos.
- Registro y asignación de mantenimientos (preventivos y correctivos).
- Subida de imágenes de equipos y mantenimientos.
- Firma electrónica para órdenes de mantenimiento.
- Generación automática de órdenes de mantenimiento.
- **Notificaciones en tiempo real** cuando un mantenimiento es asignado o actualizado.
- Reportes detallados de mantenimientos.
- Gestión de personal técnico.
- Roles: técnico, administrador y futuros módulos para firmas responsables.
- Cumplimiento con buenas prácticas: SOLID, arquitectura exagonal, separación por capas.


## Tecnologías utilizadas

- **Backend**: Java 17 + Spring Boot
- **Web**: Spring Web + WebSockets
- **Persistencia**: Spring Data JPA + Hibernate + MySQL
- **Arquitectura**: Hexagonal