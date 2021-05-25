package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.util.Logs;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.messaging.Constants;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/app/task/InitRxTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask$Priority;", Constants.FirelogAnalytics.PARAM_PRIORITY, "Lcom/avito/android/app/task/ApplicationBlockingStartupTask$Priority;", "getPriority", "()Lcom/avito/android/app/task/ApplicationBlockingStartupTask$Priority;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class InitRxTask implements ApplicationBlockingStartupTask {
    @NotNull
    public final ApplicationBlockingStartupTask.Priority priority = ApplicationBlockingStartupTask.Priority.CRITICAL;

    public static final class a<T> implements Consumer<Throwable> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof UndeliverableException) {
                Logs.error("InitRx2Task", "Undeliverable exception handled", th2);
            } else {
                Intrinsics.checkNotNullExpressionValue(th2, "error");
                throw th2;
            }
        }
    }

    public static final class b<T> implements io.reactivex.rxjava3.functions.Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof io.reactivex.rxjava3.exceptions.UndeliverableException) {
                Logs.error("InitRx3Task", "Undeliverable exception handled", th2);
            } else {
                Intrinsics.checkNotNullExpressionValue(th2, "error");
                throw th2;
            }
        }
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        RxJavaPlugins.setErrorHandler(a.a);
        io.reactivex.rxjava3.plugins.RxJavaPlugins.setErrorHandler(b.a);
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return this.priority;
    }
}
