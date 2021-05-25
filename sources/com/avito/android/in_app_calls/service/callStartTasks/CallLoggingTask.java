package com.avito.android.in_app_calls.service.callStartTasks;

import a2.g.r.g;
import android.content.Context;
import com.avito.android.in_app_calls.logging.CallLogWriter;
import com.avito.android.in_app_calls.logging.LogHeaderProvider;
import com.avito.android.in_app_calls.logging.LogStreamer;
import com.avito.android.in_app_calls.logging.SendCallLogsWorker;
import com.avito.android.in_app_calls.service.callStartTasks.CallStartTask;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/in_app_calls/service/callStartTasks/CallLoggingTask;", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask$TaskParams;", "params", "", "run", "(Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask$TaskParams;)V", "stop", "()V", "Lcom/avito/android/server_time/TimeSource;", "e", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/in_app_calls/logging/LogHeaderProvider;", g.a, "Lcom/avito/android/in_app_calls/logging/LogHeaderProvider;", "logHeaderProvider", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/avito/android/in_app_calls/logging/LogStreamer;", "d", "Lcom/avito/android/in_app_calls/logging/LogStreamer;", "logStreamer", "Lcom/avito/android/in_app_calls/logging/CallLogWriter;", "f", "Lcom/avito/android/in_app_calls/logging/CallLogWriter;", "callLogWriter", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", AuthSource.BOOKING_ORDER, "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask$TaskParams;", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "<init>", "(Landroid/content/Context;Lcom/avito/android/in_app_calls/logging/LogStreamer;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/in_app_calls/logging/CallLogWriter;Lcom/avito/android/in_app_calls/logging/LogHeaderProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallLoggingTask implements CallStartTask {
    public Disposable a;
    public CallStartTask.TaskParams b;
    public final Context c;
    public final LogStreamer d;
    public final TimeSource e;
    public final CallLogWriter f;
    public final LogHeaderProvider g;
    public final SchedulersFactory3 h;

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ CallLoggingTask a;
        public final /* synthetic */ CallStartTask.TaskParams b;

        public a(CallLoggingTask callLoggingTask, CallStartTask.TaskParams taskParams) {
            this.a = callLoggingTask;
            this.b = taskParams;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.f.attachLogFile(CallLoggingTask.access$generateLogFilename(this.a, this.b));
            this.a.f.writeHeader(this.a.g.provide());
            this.a.d.start();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ CallLoggingTask a;

        public b(CallLoggingTask callLoggingTask) {
            this.a = callLoggingTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            CallLogWriter callLogWriter = this.a.f;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            callLogWriter.writeLog(str2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("CallLoggingTask", "Unexpected error", th);
        }
    }

    @Inject
    public CallLoggingTask(@NotNull Context context, @NotNull LogStreamer logStreamer, @NotNull TimeSource timeSource, @NotNull CallLogWriter callLogWriter, @NotNull LogHeaderProvider logHeaderProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logStreamer, "logStreamer");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(callLogWriter, "callLogWriter");
        Intrinsics.checkNotNullParameter(logHeaderProvider, "logHeaderProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.c = context;
        this.d = logStreamer;
        this.e = timeSource;
        this.f = callLogWriter;
        this.g = logHeaderProvider;
        this.h = schedulersFactory3;
    }

    public static final String access$generateLogFilename(CallLoggingTask callLoggingTask, CallStartTask.TaskParams taskParams) {
        Objects.requireNonNull(callLoggingTask);
        return taskParams.getCallId() + '_' + callLoggingTask.e.now() + '_' + ULong.m306toStringimpl(URandomKt.nextULong(Random.Default));
    }

    @Override // com.avito.android.in_app_calls.service.callStartTasks.CallStartTask
    public void run(@NotNull CallStartTask.TaskParams taskParams) {
        Intrinsics.checkNotNullParameter(taskParams, "params");
        this.b = taskParams;
        this.a = Completable.fromCallable(new a(this, taskParams)).andThen(this.d.getLogsObservable()).subscribeOn(this.h.io()).subscribe(new b(this), c.a);
    }

    @Override // com.avito.android.in_app_calls.service.callStartTasks.CallStartTask
    public void stop() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d.stop();
        this.f.detachLogFile();
        if (this.b != null) {
            SendCallLogsWorker.Companion.scheduleWork$default(SendCallLogsWorker.Companion, this.c, 0, 2, null);
        }
    }
}
