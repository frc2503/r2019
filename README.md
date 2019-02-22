# r2019

[![TBA](https://img.shields.io/badge/The%20Blue%20Alliance-2503-blue.svg?style=popout-square)](https://www.thebluealliance.com/team/2503)
[![Travis CI](https://img.shields.io/travis/frc2503/r2019.svg?style=popout-square)](https://travis-ci.org/frc2503/r2019)
[![Codacy](https://img.shields.io/codacy/grade/a52adf6bbffc45b79713ea58ca2f1538.svg?style=popout-square)](https://app.codacy.com/project/hunterkva/r2019/dashboard)

## Robot Overview

<p align="center">
  <img src="https://user-images.githubusercontent.com/46372814/53132017-fe720400-3533-11e9-9276-8d77b03415ab.png">
</p>

2503's Deep Space robot is capable of placing hatch panels on the cargo ship, placing hatch panels on the first level of either rocket, and climbing to the level 3 habitat.

## Wiring Overview

### PWM
| Port | Component                       |
| ---- | :------------------------------ |
| 0    | Left Drive Talon SRs (Y-Split)  |
| 1    | Right Drive Talon SRs (Y-Split) |
| 2    | Elevator Talon                  |
| 3    | Foot Talon                      |

### DIO
| Port | Component                    |
| ---- | :--------------------------- |
| 0    | Elevator Bottom Limit Switch |
| 1    | Elevator Top Limit Switch    |

### USB (Driver Station)
| Port | Component      |
| ---- | -------------- |
| 0    | Left Joystick  |
| 1    | Right Joystick |
| 2    | Gamepad        |

### Pneumatics Control Module
| Port | Component              |
| ---- | ---------------------- |
| 0    | Front Solenoid Forward |
| 1    | Front Solenoid Reverse |
| 2    | Back Solenoid Forward  |
| 3    | Back Solenoid Reverse  |

### Cameras (rPi)
| Device       | Camera                   |
| ------------ | ------------------------ |
| /dev/video0  | Vision Processing Camera |
| /dev/video1  | Driver Camera            |
