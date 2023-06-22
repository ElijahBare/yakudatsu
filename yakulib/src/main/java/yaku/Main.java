package yaku;

import yaku.logic.Lock;
import yaku.logic.Timer;
import yaku.string.StringUtils;

/**
 * @author Elijah Bare
 */

public class Main {
    public static void main(String[] args) {
        StringUtils.printNewlines(3);
        StringUtils.printWait("Lock Test:" + testLock(), 500);
        StringUtils.printNewlines(1);
        StringUtils.printWait("Timer Test:" + testTimer(), 500);
        StringUtils.printNewlines(3);

    }

    public static boolean testTimer() {
        Timer timer = new Timer();

        // wait for 100 milliseconds
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!timer.hasReached(100)) {
            System.out.println("Timer test failed: Delay check");
            return false;
        }

        return true;
    }


    public static boolean testLock() {
        Lock lock = new Lock(false);

        lock.lock();
        if (!lock.isLocked()) {
            System.out.println("Failed: Lock acquisition");
            return false;
        }
        lock.unlock();
        if (lock.isLocked()) {
            System.out.println("Failed: Lock release");
            return false;
        }

        lock.lock(3000);
        long startTime = System.currentTimeMillis();
        lock.waitHere();
        long elapsedTime = System.currentTimeMillis() - startTime;
        long expectedTime = 3000L;
        long tolerance = 100L; // give or take 100 milliseconds

        if (elapsedTime < expectedTime - tolerance || elapsedTime > expectedTime + tolerance) {
            System.out.println("Failed: Lock with timeout. Elapsed time: " + elapsedTime + "ms");
            return false;
        }


        if (lock.isLocked()) {
            System.out.println("Failed: Lock synchronization");
            return false;
        }

        return true;
    }


    //TODO test physics
    //TODO test colors
    //TODO test Pathfinding
}
