package yaku.math;

/**
 * @author Elijah Bare
 */
public class Physics {

    /**
     * Calculates the displacement of a falling object using the free fall kinematic equation,
     * given the initial and final positions in meters.
     *
     * @param start The initial position in meters.
     * @param stop  The final position in meters.
     * @return The displacement in meters.
     */
    public static double getFallDisplacement(double start, double stop) {
        double hangTime = (stop - start) / 1000;

        // displacement = (vi + vf) * t / 2
        return (0 + 0.5 * -9.8 * hangTime * hangTime);
    }

    /**
     * Calculates the displacement of a falling object using the free fall kinematic equation,
     * given the initial and final positions in meters and the gravitational acceleration in m/s^2.
     *
     * @param start      The initial position in meters.
     * @param stop       The final position in meters.
     * @param gravAccel  The gravitational acceleration in m/s^2.
     * @return The displacement in meters.
     */
    public static double getFallDisplacement(double start, double stop, double gravAccel) {
        double hangTime = (stop - start) / 1000;

        // displacement = (vi + vf) * t / 2
        return (0 + 0.5 * -gravAccel * hangTime * hangTime);
    }

    /**
     * Calculates the final velocity of a falling object using the free fall kinematic equation,
     * given the initial and final positions in meters.
     *
     * @param start The initial position in meters.
     * @param stop  The final position in meters.
     * @return The final velocity in m/s.
     */
    public static double getFallFinalVelocity(double start, double stop) {
        double hangTime = (stop - start) / 1000;

        // final velocity = initial velocity + acceleration * time
        return 0 + -9.8 * hangTime;
    }

    /**
     * Calculates the final velocity of a falling object using the free fall kinematic equation,
     * given the initial and final positions in meters and the gravitational acceleration in m/s^2.
     *
     * @param start      The initial position in meters.
     * @param stop       The final position in meters.
     * @param gravAccel  The gravitational acceleration in m/s^2.
     * @return The final velocity in m/s.
     */
    public static double getFallFinalVelocity(double start, double stop, double gravAccel) {
        double hangTime = (stop - start) / 1000;

        // final velocity = initial velocity + acceleration * time
        return 0 + -gravAccel * hangTime;
    }


    /**
     * Calculates the displacement of a moving object using the constant velocity kinematic equation,
     * given the initial position, velocity, and time.
     *
     * @param initialPosition The initial position in meters.
     * @param velocity        The constant velocity in m/s.
     * @param time            The time in seconds.
     * @return The displacement in meters.
     */
    public static double getDisplacement(double initialPosition, double velocity, double time) {
        // displacement = initial position + velocity * time
        return initialPosition + velocity * time;
    }

    /**
     * Calculates the final velocity of a moving object using the constant acceleration kinematic equation,
     * given the initial velocity, acceleration, and time.
     *
     * @param initialVelocity The initial velocity in m/s.
     * @param acceleration    The constant acceleration in m/s^2.
     * @param time            The time in seconds.
     * @return The final velocity in m/s.
     */
    public static double getFinalVelocity(double initialVelocity, double acceleration, double time) {
        // final velocity = initial velocity + acceleration * time
        return initialVelocity + acceleration * time;
    }

    /**
     * Calculates the displacement of an object using the average velocity kinematic equation,
     * given the initial velocity, time, and acceleration.
     *
     * @param initialVelocity The initial velocity in m/s.
     * @param time            The time in seconds.
     * @param acceleration    The acceleration in m/s^2.
     * @return The displacement in meters.
     */
    public static double getDisplacementAvgVelocity(double initialVelocity, double time, double acceleration) {
        // displacement = initial velocity * time + 0.5 * acceleration * time^2
        return initialVelocity * time + 0.5 * acceleration * time * time;
    }

    /**
     * Calculates the time taken for an object to reach its final velocity using the constant acceleration kinematic equation,
     * given the initial velocity, final velocity, and acceleration.
     *
     * @param initialVelocity The initial velocity in m/s.
     * @param finalVelocity   The final velocity in m/s.
     * @param acceleration    The constant acceleration in m/s^2.
     * @return The time taken in seconds.
     */
    public static double getTimeTaken(double initialVelocity, double finalVelocity, double acceleration) {
        // time = (final velocity - initial velocity) / acceleration
        return (finalVelocity - initialVelocity) / acceleration;
    }
}
