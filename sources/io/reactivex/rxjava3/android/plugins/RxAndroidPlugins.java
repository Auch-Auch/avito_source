package io.reactivex.rxjava3.android.plugins;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import java.util.concurrent.Callable;
public final class RxAndroidPlugins {
    public static volatile Function<Callable<Scheduler>, Scheduler> a;
    public static volatile Function<Scheduler, Scheduler> b;

    public RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }

    public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler() {
        return a;
    }

    public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler() {
        return b;
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        Function<Callable<Scheduler>, Scheduler> function = a;
        if (function == null) {
            try {
                Scheduler call = callable.call();
                if (call != null) {
                    return call;
                }
                throw new NullPointerException("Scheduler Callable returned null");
            } catch (Throwable th) {
                throw Exceptions.propagate(th);
            }
        } else {
            try {
                Scheduler apply = function.apply(callable);
                Objects.requireNonNull(apply, "Scheduler Callable returned null");
                return apply;
            } catch (Throwable th2) {
                throw Exceptions.propagate(th2);
            }
        }
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler == null");
        Function<Scheduler, Scheduler> function = b;
        if (function == null) {
            return scheduler;
        }
        try {
            return function.apply(scheduler);
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    public static void reset() {
        setInitMainThreadSchedulerHandler(null);
        setMainThreadSchedulerHandler(null);
    }

    public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> function) {
        a = function;
    }

    public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> function) {
        b = function;
    }
}
