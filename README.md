# r2019

[![TBA](https://img.shields.io/badge/The%20Blue%20Alliance-2503-blue.svg?style=popout-square&logo=%20data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4wIKFy8il2y89AAAAnBJREFUWMO9l89qE1EUxr/vZBJNRQQXrroVfAaFuhC0UtyItrYLcWE1PodbHyBVqVmZGmi6UBRFFxWLOx9Ai4pUpRBJk+bvJDPXxSSTmWTSzM00PZvAvTfz+8653/1HaMZiakvZdjuwT8RANn2BOt8LNXjh3qbCGPHi8UVGEjC/vGmTICKESBzZ9HlqCxg3a91q8CjgB4ngUcGHiWAY+NrKzFiwW/c/jhQhk8y8WPga2L704LMaEDCJIAV7/7YH2i3LhE/AJOedFJSKP4YafeIVAAmCKO/9Chxj6JhpbWUGl68/cdubpgXLUphKGh0g8Xb9LmZvrPrgoIAk9ks7OHlq2r9RLaa21OFkS3dRBcFJASmo7v/tJZb6pGTYwTIO3PlFINztp6BW2QUAKNuK7gEv3AHBB3eqwt44AKCgXi2E94A33uWXQ6gSjzBxM2dfX6Ne1BfQNSFJNE0btiJOJONu2V/nbgfAOQDv9hlRyi4kFPyG6+7wfjgD4YToe2BwzvsB6MExHA4QICAiukVgoLP9y5CBfT5hJCQWd/4RdisOeypeW8qNhJOCfGaO2h64ejPjfsRsAZatMJWMu4CXzxdCwSOcht7Sdp3tnwJnyY2G+y4kYabhWELwe2cbiYQBAjBbgK3YOQsIpYBzZ0/j2/ey4/4D4PnMHLUr0DRtvN+4g3bLdrIU6aTgwF9l50PBY7GE3pWsP6bP1PDo4ayvLf3sC958+DkS7s0+0qW0Uv7Tt81SGx75Wl6r7EaCH8rDpF4tuHDvLhgGfmhPs0a9OBRuGMeRe3pJ/2mmW41mozR0qUV+HYd9nrfbDayvXtH65n/Sv9IsoCldoQAAAABJRU5ErkJggg==)](https://www.thebluealliance.com/team/2503)
[![Travis CI](https://img.shields.io/travis/frc2503/r2019.svg?logo=travis-ci&logoColor=green&style=popout-square)](https://travis-ci.org/frc2503/r2019)
[![Codacy](https://img.shields.io/codacy/grade/a52adf6bbffc45b79713ea58ca2f1538.svg?logo=codacy&logoColor=green&style=popout-square)](https://app.codacy.com/project/hunterkva/r2019/dashboard)

## Wiring Overview

###PWM
| Port  | Component  |
| ------------ | ------------ |
| 0  | Left Drive Talon SRs (Y-Split)  |
| 1  |  Right Drive Talon SRs (Y-Split) |
| 2  | Elevator Talon |
| 3  | Foot Talon |

### USB (Driver Station)
| Port  | Component  |
| ------------ | ------------ |
| 0  | Right Joystick  |
| 1  | Left Joystick  |
| 2  | Gamepad |

### Pneumatics Control Module
| Port  | Component  |
| ------------ | ------------ |
| 0  | Front Solenoid Forward  |
| 1  | Front Solenoid Reverse  |
| 2  | Back Solenoid Forward |
| 3  | Back Solenoid Reverse |

### Cameras (rPi)
| Device  | Camera  |
| ------------ | ------------ |
| /dev/video0  | Vision Processing Camera  |
| /dev/video1  | Driver Camera  |