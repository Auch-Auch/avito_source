package com.avito.android.analytics.statsd;

import com.avito.android.analytics.inhouse_transport.UploadResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.short_task.ShortTask;
import com.avito.android.util.Logs;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegateImpl;", "Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegate;", "Lio/reactivex/Single;", "Lcom/avito/android/service/short_task/ShortTask$Status;", Tracker.Events.CREATIVE_START, "()Lio/reactivex/Single;", "Lcom/avito/android/analytics/statsd/StatsdSender;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/statsd/StatsdSender;", "sender", "<init>", "(Lcom/avito/android/analytics/statsd/StatsdSender;)V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
public final class SendStatsdEventsTaskDelegateImpl implements SendStatsdEventsTaskDelegate {
    public final StatsdSender a;

    public static final class a<T> implements Consumer<UploadResult> {
        public final /* synthetic */ SendStatsdEventsTaskDelegateImpl a;

        public a(SendStatsdEventsTaskDelegateImpl sendStatsdEventsTaskDelegateImpl) {
            this.a = sendStatsdEventsTaskDelegateImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(UploadResult uploadResult) {
            UploadResult uploadResult2 = uploadResult;
            SendStatsdEventsTaskDelegateImpl sendStatsdEventsTaskDelegateImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(uploadResult2, "it");
            SendStatsdEventsTaskDelegateImpl.access$logError(sendStatsdEventsTaskDelegateImpl, uploadResult2);
        }
    }

    public static final class b<T, R> implements Function<UploadResult, ShortTask.Status> {
        public final /* synthetic */ SendStatsdEventsTaskDelegateImpl a;

        public b(SendStatsdEventsTaskDelegateImpl sendStatsdEventsTaskDelegateImpl) {
            this.a = sendStatsdEventsTaskDelegateImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ShortTask.Status apply(UploadResult uploadResult) {
            UploadResult uploadResult2 = uploadResult;
            Intrinsics.checkNotNullParameter(uploadResult2, "it");
            return SendStatsdEventsTaskDelegateImpl.access$convertResultToStatus(this.a, uploadResult2);
        }
    }

    public static final class c<T, R> implements Function<Throwable, ShortTask.Status> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ShortTask.Status apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return ShortTask.Status.FAILED;
        }
    }

    @Inject
    public SendStatsdEventsTaskDelegateImpl(@NotNull StatsdSender statsdSender) {
        Intrinsics.checkNotNullParameter(statsdSender, "sender");
        this.a = statsdSender;
    }

    public static final ShortTask.Status access$convertResultToStatus(SendStatsdEventsTaskDelegateImpl sendStatsdEventsTaskDelegateImpl, UploadResult uploadResult) {
        Objects.requireNonNull(sendStatsdEventsTaskDelegateImpl);
        if (uploadResult instanceof UploadResult.Success) {
            return ShortTask.Status.SUCCESS;
        }
        if (uploadResult instanceof UploadResult.UnrecoverableError) {
            return ShortTask.Status.FAILED;
        }
        if (uploadResult instanceof UploadResult.RecoverableError) {
            return ShortTask.Status.FAILED_AND_NEED_RETRY;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void access$logError(SendStatsdEventsTaskDelegateImpl sendStatsdEventsTaskDelegateImpl, UploadResult uploadResult) {
        Objects.requireNonNull(sendStatsdEventsTaskDelegateImpl);
        if (uploadResult instanceof UploadResult.UnrecoverableError) {
            Logs.error(StatsdEventTrackerKt.LOG_TAG, ((UploadResult.UnrecoverableError) uploadResult).getCause());
        }
    }

    @Override // com.avito.android.analytics.statsd.SendStatsdEventsTaskDelegate
    @NotNull
    public Single<ShortTask.Status> start() {
        Single<R> onErrorReturn = this.a.send().doOnSuccess(new a(this)).map(new b(this)).onErrorReturn(c.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "sender.send()\n          …rReturn { Status.FAILED }");
        return onErrorReturn;
    }
}
