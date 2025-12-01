# MartingaleMC

A Minecraft Fabric mod that automates coinflip gambling using the Martingale strategy.

**Developed with Google Antigravity.**

> [!WARNING]
> The SMP where this mod was tested features no house edge (0% tax) which means that most strategies function as mathematically "fair". 
> In other coinflip systems, Martingale will **not work** and is guaranteed to lose money long-term.

## Overview
This mod listens to chat messages to track your coinflip wins and losses, automatically adjusting your bet size.

**Current Strategy**: The mod currently implements the **Martingale system** (double on loss, reset on win).
**Future Plans**: This project will be expanded to feature a wide variety of other gambling methods and strategies in upcoming releases.

## Usage
1.  **Start Automation**:
    ```
    /mgc start <initial_bet>
    ```
    Example: `/mgc start 100`

2.  **Stop Automation**:
    ```
    /mgc stop
    ```

## Installation
1.  Download the latest release `.jar`.
2.  Place it in your Minecraft `mods` folder.
3.  Ensure you have the Fabric Loader installed.

## Building
```bash
./gradlew build
```
