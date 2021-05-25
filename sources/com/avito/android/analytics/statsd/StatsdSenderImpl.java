package com.avito.android.analytics.statsd;

import a2.a.a.i.j.b;
import a2.a.a.i.j.c;
import a2.a.a.i.j.d;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.analytics.inhouse_transport.UploadResult;
import com.avito.android.analytics.statsd.StatsdCommonModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdSenderImpl;", "Lcom/avito/android/analytics/statsd/StatsdSender;", "Lio/reactivex/Single;", "Lcom/avito/android/analytics/inhouse_transport/UploadResult;", "send", "()Lio/reactivex/Single;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lcom/avito/android/analytics/statsd/StatsdRecord;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "storage", "Lcom/avito/android/analytics/statsd/StatsdApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/statsd/StatsdApi;", "api", "<init>", "(Lcom/avito/android/analytics/statsd/StatsdApi;Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;Lcom/avito/android/util/SchedulersFactory;)V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
public final class StatsdSenderImpl implements StatsdSender {
    public final StatsdApi a;
    public final InHouseEventStorage<StatsdRecord> b;
    public final SchedulersFactory c;

    public static final class a<T, R> implements Function<List<? extends StatsdRecord>, SingleSource<? extends UploadResult>> {
        public final /* synthetic */ StatsdSenderImpl a;

        public a(StatsdSenderImpl statsdSenderImpl) {
            this.a = statsdSenderImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends UploadResult> apply(List<? extends StatsdRecord> list) {
            List<? extends StatsdRecord> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "events");
            return StatsdSenderImpl.access$uploadEvents(this.a, list2).doOnSuccess(new b(this, list2));
        }
    }

    @Inject
    public StatsdSenderImpl(@NotNull StatsdApi statsdApi, @StatsdCommonModule.Statsd @NotNull InHouseEventStorage<StatsdRecord> inHouseEventStorage, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(statsdApi, "api");
        Intrinsics.checkNotNullParameter(inHouseEventStorage, "storage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = statsdApi;
        this.b = inHouseEventStorage;
        this.c = schedulersFactory;
    }

    public static final void access$handleRecoverableError(StatsdSenderImpl statsdSenderImpl, UploadResult uploadResult, List list) {
        Objects.requireNonNull(statsdSenderImpl);
        if (uploadResult instanceof UploadResult.RecoverableError) {
            statsdSenderImpl.b.addAll(list);
        }
    }

    public static final Single access$uploadEvents(StatsdSenderImpl statsdSenderImpl, List list) {
        Objects.requireNonNull(statsdSenderImpl);
        if (list.isEmpty()) {
            return Singles.toSingle(new UploadResult.Success());
        }
        Single<R> onErrorReturn = statsdSenderImpl.a.sendEvents(list).subscribeOn(statsdSenderImpl.c.io()).map(c.a).onErrorReturn(d.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.sendEvents(events)\n …          }\n            }");
        return onErrorReturn;
    }

    @Override // com.avito.android.analytics.statsd.StatsdSender
    @NotNull
    public Single<UploadResult> send() {
        Single fromCallable = Single.fromCallable(new a2.a.a.i.j.a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …torage.extractAll()\n    }");
        return a2.b.a.a.a.V1(this.c, fromCallable.flatMap(new a(this)), "extractEvents()\n        …scribeOn(schedulers.io())");
    }
}
