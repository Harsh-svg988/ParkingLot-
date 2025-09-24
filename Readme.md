# Parking Lot System - Class Diagram

```mermaid
classDiagram
    %% ===============================
    %% Parking Lot
    %% ===============================
    class ParkingLot {
        -spots: Map~String, ParkingSpot~
        -entryGates: List~EntryGate~
        -exitGates: List~ExitGate~
        +getNearestSpot(vehicle: Vehicle, entryGate: EntryGate): ParkingSpot
        +assignSpot(vehicle: Vehicle, entryGate: EntryGate): Ticket
        +releaseSpot(ticket: Ticket, exitGate: ExitGate): Bill
    }

    %% ===============================
    %% Gates
    %% ===============================
    class Gate {
        <<abstract>>
        -id: int
    }

    class EntryGate {
        +generateTicket(vehicle: Vehicle, spot: ParkingSpot): Ticket
    }

    class ExitGate {
        +generateBill(ticket: Ticket): Bill
    }

    Gate <|-- EntryGate
    Gate <|-- ExitGate

    %% ===============================
    %% Vehicle
    %% ===============================
    class Vehicle {
        -vehicleNo: String
        -sizeRequired: VehicleSize
        -needsCharging: boolean
    }

    class VehicleSize {
        <<enumeration>>
        SMALL
        MEDIUM
        LARGE
    }

    %% ===============================
    %% Parking Spot
    %% ===============================
    class ParkingSpot {
        -spotId: String
        -isAvailable: boolean
        -chargingFacility: boolean
        -rateStrategy: RateStrategy
        +assignVehicle(vehicle: Vehicle)
        +removeVehicle()
        +getFloor(): int
    }

    class SmallSpot
    class MediumSpot
    class LargeSpot
    ParkingSpot <|-- SmallSpot
    ParkingSpot <|-- MediumSpot
    ParkingSpot <|-- LargeSpot

    %% ===============================
    %% Ticket & Bill
    %% ===============================
    class Ticket {
        -ticketId: String
        -vehicleNo: String
        -spotId: String
        -entryTime: DateTime
    }

    class Bill {
        -billId: String
        -ticketId: String
        -exitTime: DateTime
        -duration: long
        -amount: double
        -usedCharging: boolean
    }

    %% ===============================
    %% Billing Strategy
    %% ===============================
    class RateStrategy {
        <<interface>>
        +calculateAmount(duration: long, spot: ParkingSpot, usedCharging: boolean): double
    }

    class SmallSpotRateStrategy
    class MediumSpotRateStrategy
    class LargeSpotRateStrategy
    RateStrategy <|.. SmallSpotRateStrategy
    RateStrategy <|.. MediumSpotRateStrategy
    RateStrategy <|.. LargeSpotRateStrategy

    %% ===============================
    %% Relationships
    %% ===============================
    ParkingLot "1" --> "*" ParkingSpot
    ParkingLot "1" --> "*" EntryGate
    ParkingLot "1" --> "*" ExitGate
    ParkingSpot "1" --> "0..1" Vehicle
    EntryGate "1" --> "1" Ticket
    ExitGate "1" --> "1" Bill
    Ticket "1" --> "1" Vehicle
    Bill "1" --> "1" Ticket
```

## Key Components

### Core Classes
- **ParkingLot**: Main system controller managing spots and gates
- **Gate**: Abstract base class for entry/exit points
- **Vehicle**: Represents vehicles with size and charging requirements
- **ParkingSpot**: Individual parking spaces with different types

### Design Patterns Used
- **Strategy Pattern**: RateStrategy for different pricing models
- **Inheritance**: Vehicle sizes and spot types
- **Composition**: ParkingLot contains spots and gates

### Features
- Electric vehicle charging facilities
- Flexible rate calculation strategies
- Ticket and billing system
- Multiple entry/exit gates