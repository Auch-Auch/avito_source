package a2.a.a.j.a;

import com.avito.android.app.AppProcessStatistics;
import com.avito.android.app.task.ScheduleMetricSendingTask;
import java.util.concurrent.Callable;
public final class u0<V> implements Callable<Long> {
    public final /* synthetic */ ScheduleMetricSendingTask.StartupTimeHolder a;

    public u0(ScheduleMetricSendingTask.StartupTimeHolder startupTimeHolder) {
        this.a = startupTimeHolder;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Long call() {
        return Long.valueOf(new AppProcessStatistics(this.a.getStartupBeginElapsedMs()).startupElapsedMs());
    }
}
