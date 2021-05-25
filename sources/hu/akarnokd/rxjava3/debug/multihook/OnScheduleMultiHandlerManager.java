package hu.akarnokd.rxjava3.debug.multihook;

import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
public class OnScheduleMultiHandlerManager extends MultiHandlerManager<Function<Runnable, Runnable>> implements Function<Runnable, Runnable>, BiConsumer<Runnable[], Function<Runnable, Runnable>> {
    public void append() {
        Function<? super Runnable, ? extends Runnable> scheduleHandler = RxJavaPlugins.getScheduleHandler();
        if (scheduleHandler != this) {
            if (scheduleHandler != null) {
                register(scheduleHandler);
            }
            RxJavaPlugins.setScheduleHandler(this);
        }
    }

    public void disable() {
        RxJavaPlugins.setScheduleHandler(null);
    }

    public void enable() {
        RxJavaPlugins.setScheduleHandler(this);
    }

    public void accept(Runnable[] runnableArr, Function<Runnable, Runnable> function) throws Throwable {
        runnableArr[0] = function.apply(runnableArr[0]);
    }

    public Runnable apply(Runnable runnable) throws Exception {
        Runnable[] runnableArr = {runnable};
        forEach(runnableArr, this);
        return runnableArr[0];
    }
}
