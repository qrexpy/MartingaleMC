# Release Info

**Release Tag**: `v1.0.0`
**Release Title**: MartingaleMC v1.0.0 - Martingale Strategy Automator

## Description
First official release of the MartingaleMC mod.

### Compatibility
- **Minecraft Version**: 1.21+ (Tested on 1.21.1, compatible with 1.21.8)
- **Java Version**: Java 21
- **Mod Loader**: Fabric Loader (>= 0.16.5)
- **Dependencies**: Fabric API

### Features
- **Martingale Strategy**: Automatically doubles bet on loss (same face) and resets on win (opposite face).
- **Random Start**: Starts with a random face (Heads/Tails).
- **Commands**:
    - `/mgc start <amount>`: Start the automation.
    - `/mgc stop`: Stop the automation.

### Chat Detection
The mod listens for the following specific server messages to trigger the next bet:
- **Win**: `COINFLIP > You won!`
- **Loss**: `COINFLIP > You lost!`
