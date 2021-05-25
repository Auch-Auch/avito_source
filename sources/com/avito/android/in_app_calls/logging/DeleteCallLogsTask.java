package com.avito.android.in_app_calls.logging;

import android.app.Application;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B!\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/in_app_calls/logging/DeleteCallLogsTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "logFileProvider", "Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/server_time/TimeSource;", "<init>", "(Lcom/avito/android/in_app_calls/logging/LogFileProvider;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/util/SchedulersFactory3;)V", "Companion", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteCallLogsTask implements ApplicationBackgroundStartupTask {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final LogFileProvider logFileProvider;
    public final SchedulersFactory3 schedulers;
    public final TimeSource timeSource;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/in_app_calls/logging/DeleteCallLogsTask$Companion;", "", "", "LOG_LIFE_TIME_HOURS", "J", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ DeleteCallLogsTask a;

        public a(DeleteCallLogsTask deleteCallLogsTask) {
            this.a = deleteCallLogsTask;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            for (T t : this.a.logFileProvider.listAllLogs()) {
                StringBuilder L = a2.b.a.a.a.L("Log file: ");
                L.append(t.getName());
                L.append(", modified: ");
                L.append(t.lastModified());
                Logs.debug$default("DeleteCallLogsTask", L.toString(), null, 4, null);
                if (this.a.timeSource.now() - t.lastModified() > TimeUnit.HOURS.toMillis(48)) {
                    Logs.debug$default("DeleteCallLogsTask", "Delete this log", null, 4, null);
                    t.delete();
                }
            }
        }
    }

    public static final class b implements Action {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            Logs.debug$default("DeleteCallLogsTask", "Old log files deleted", null, 4, null);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.debug$default("DeleteCallLogsTask", "Failed to delete log files", null, 4, null);
        }
    }

    @Inject
    public DeleteCallLogsTask(@NotNull LogFileProvider logFileProvider2, @NotNull TimeSource timeSource2, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(logFileProvider2, "logFileProvider");
        Intrinsics.checkNotNullParameter(timeSource2, "timeSource");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.logFileProvider = logFileProvider2;
        this.timeSource = timeSource2;
        this.schedulers = schedulersFactory3;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Completable.fromAction(new a(this)).doOnComplete(b.a).doOnError(c.a).onErrorComplete().subscribeOn(this.schedulers.io()).subscribe();
    }
}
