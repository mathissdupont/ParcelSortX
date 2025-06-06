# 📦 ParcelSortX - Smart Package Sorting and Routing Simulation

ParcelSortX is a simulation project designed to model a smart logistics center where parcels are received, sorted, and dispatched based on their city, size, and priority. It serves as an educational tool to practice and demonstrate classical data structures in a dynamic simulation environment.

## 🎯 Project Goals

- Apply **queues, stacks, BSTs, hash tables, and circular linked lists** in a real-world logistics simulation.
- Emphasize modular, efficient, and structured programming practices.
- Track system performance with logging and generate detailed simulation reports.

---

## 🔧 Features

- 🌀 **ArrivalBuffer (Queue)**: FIFO parcel intake simulation.
- 🔁 **ReturnStack (Stack)**: Reprocessing mechanism for misrouted parcels.
- 🌳 **DestinationSorter (BST)**: Sorting hub by destination cities.
- #️⃣ **ParcelTracker (Hash Table)**: Tracks parcel metadata and status.
- 🔄 **TerminalRotator (Circular Linked List)**: Rotating dispatch terminals.

---

## 📂 Folder Structure

ParcelSortX/
│
├── src/ # All source code files
│ ├── main.java
│ └── ...
│
├── config.txt # Simulation configuration
├── report.txt # Final summary report
├── log.txt # Per-tick simulation logs
├── README.md # Project description and instructions
└── ParcelSortX_Report.pdf # Project documentation (PDF)
