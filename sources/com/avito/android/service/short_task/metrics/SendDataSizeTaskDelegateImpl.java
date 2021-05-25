package com.avito.android.service.short_task.metrics;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.short_task.ShortTask;
import com.avito.android.util.DiskSpaceAnalyticsTraverser;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/service/short_task/metrics/SendDataSizeTaskDelegateImpl;", "Lcom/avito/android/service/short_task/metrics/SendDataSizeTaskDelegate;", "Lio/reactivex/Single;", "Lcom/avito/android/service/short_task/ShortTask$Status;", Tracker.Events.CREATIVE_START, "()Lio/reactivex/Single;", "Lcom/avito/android/util/DiskSpaceAnalyticsTraverser;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/DiskSpaceAnalyticsTraverser;", "traverser", "<init>", "(Lcom/avito/android/util/DiskSpaceAnalyticsTraverser;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class SendDataSizeTaskDelegateImpl implements SendDataSizeTaskDelegate {
    public final DiskSpaceAnalyticsTraverser a;

    public static final class a<V> implements Callable<Unit> {
        public final /* synthetic */ SendDataSizeTaskDelegateImpl a;

        public a(SendDataSizeTaskDelegateImpl sendDataSizeTaskDelegateImpl) {
            this.a = sendDataSizeTaskDelegateImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Unit call() {
            this.a.a.traverse();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function<Unit, ShortTask.Status> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ShortTask.Status apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return ShortTask.Status.SUCCESS;
        }
    }

    @Inject
    public SendDataSizeTaskDelegateImpl(@NotNull DiskSpaceAnalyticsTraverser diskSpaceAnalyticsTraverser) {
        Intrinsics.checkNotNullParameter(diskSpaceAnalyticsTraverser, "traverser");
        this.a = diskSpaceAnalyticsTraverser;
    }

    @Override // com.avito.android.service.short_task.metrics.SendDataSizeTaskDelegate
    @NotNull
    public Single<ShortTask.Status> start() {
        Single<ShortTask.Status> map = Single.fromCallable(new a(this)).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "Single.fromCallable { tr…hortTask.Status.SUCCESS }");
        return map;
    }
}
