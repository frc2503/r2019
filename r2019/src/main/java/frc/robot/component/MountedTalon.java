/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.component;

import edu.wpi.first.wpilibj.Talon;

/**
 * A Talon for a motor that is mounted backwards
 */
public class MountedTalon extends Talon {

    public static enum Direction {
        kForward,
        kReverse
    }

    private Direction m_direction;

    public MountedTalon(int port, Direction direction) {
        super(port);
        m_direction = direction;
    }
    
    public MountedTalon(int port) {
        this(port, Direction.kForward);
    }

    @Override
    public void set(double speed) {
        if (m_direction == Direction.kReverse) {
            super.set(speed * -1.0);
        } else {
            super.set(speed);
        }
    }

    public Direction getDirection() {
        return m_direction;
    }

    public void setDirection(Direction direction) {
        m_direction = direction;
    }

}
