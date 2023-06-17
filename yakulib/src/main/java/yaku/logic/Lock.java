package yaku.logic;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@author TudbuT
 *@author Eljah Bare
 * <p>
 * The `Lock` class provides a simple locking mechanism with optional timeout functionality.
 * It allows multiple threads to coordinate and synchronize their execution.
 */
public class Lock {
    private final Locker locker = new Locker();
    private boolean locked = false;
    private int t = 0;
    private long ts = 0L;
    private final AtomicInteger waiting = new AtomicInteger();
    private volatile boolean[] waiterLocker = null;

    /**
     * Constructs a new `Lock` object.
     */
    public Lock() {
    }

    /**
     * Constructs a new `Lock` object with an initial locked state.
     *
     * @param locked true if the lock should be initially locked, false otherwise.
     */
    public Lock(boolean locked) {
        this.locked = locked;
    }

    /**
     * Returns the remaining time in milliseconds until the lock is released, or 0 if the lock is already released.
     *
     * @return the remaining time in milliseconds until the lock is released.
     */
    public long timeLeft() {
        this.updateLocked();
        return this.locked ? this.ts + (long) this.t - (new Date()).getTime() : 0L;
    }

    protected int checkTime(int timeout) {
        return this.locked ? this.checkNegative(Math.min((int) ((long) this.t - ((new Date()).getTime() - this.ts)),
                timeout <= 0 ? Integer.MAX_VALUE : timeout), timeout) : timeout;
    }

    protected int checkNegative(int i, int alt) {
        return i <= 0 ? alt : i;
    }

    protected void updateLocked() {
        if ((new Date()).getTime() - this.ts >= (long) this.t && this.ts != 0L) {
            this.locked = false;
        }
    }

    /**
     * Waits indefinitely until the lock is released.
     * If the lock is already released, this method returns immediately.
     */
    public void waitHere() {
        this.updateLocked();
        if (this.locked) {
            try {
                this.locker.lockHere((long) this.checkTime(0));
            } catch (InterruptedException var2) {
                Thread.currentThread().interrupt();
            }
        }
        this.updateLocked();
    }

    /**
     * Waits for a specific timeout period until the lock is released.
     * If the lock is already released, this method returns immediately.
     *
     * @param timeout the maximum time to wait in milliseconds.
     */
    public void waitHere(int timeout) {
        this.updateLocked();
        if (this.locked) {
            try {
                this.locker.lockHere((long) this.checkTime(timeout));
            } catch (InterruptedException var3) {
                Thread.currentThread().interrupt();
            }
        }
        this.updateLocked();
    }

    /**
     * Unlocks the lock, allowing other threads to acquire it.
     */
    public synchronized void unlock() {
        this.locker.unlock();
        this.locked = false;
    }

    /**
     * Locks the lock, preventing other threads from acquiring it.
     * If the lock was previously locked, it is reset and locked again.
     */
    public synchronized void lock() {
        this.t = 0;
        this.ts = 0L;
        this.locked = true;
    }

    /**
     * Locks the lock for a specific time period in milliseconds.
     * If the time is negative, it is set to 0.
     *
     * @param time the time period in milliseconds for which to lock the lock.
     */
    public synchronized void lock(int time) {
        if (time < 0) {
            time = 0;
        }
        this.locked = true;
        this.t = time;
        this.ts = (new Date()).getTime();
    }

    /**
     * Checks if the lock is currently locked.
     *
     * @return true if the lock is locked, false otherwise.
     */
    public synchronized boolean isLocked() {
        this.updateLocked();
        return this.locked;
    }


    private static class Locker {
        private Locker() {
        }

        public synchronized void lockHere() throws InterruptedException {
            this.wait();
        }

        public synchronized void lockHere(long timeout) throws InterruptedException {
            this.wait(timeout);
        }

        public synchronized void unlock() {
            this.notifyAll();
        }
    }
}
