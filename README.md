# MartingaleMC

A Minecraft Fabric mod that automates coinflip gambling using the Martingale strategy.

**Developed with Google Antigravity.**

## Overview
This mod listens to chat messages to track your coinflip wins and losses, automatically adjusting your bet size according to the Martingale system (double on loss, reset on win).

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
