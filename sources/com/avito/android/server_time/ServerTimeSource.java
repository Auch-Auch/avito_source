package com.avito.android.server_time;

import android.os.SystemClock;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Flowables;
import com.avito.android.util.Logs;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/server_time/ServerTimeSource;", "Lcom/avito/android/server_time/TimeSource;", "", "now", "()J", "timeout", "", "sleep", "(J)V", "Ljava/util/TimeZone;", "getTimeZone", "()Ljava/util/TimeZone;", "timeZone", AuthSource.BOOKING_ORDER, "Lcom/avito/android/server_time/TimeSource;", "timeSource", AuthSource.SEND_ABUSE, "J", "serverTimeDiff", "Lio/reactivex/Observable;", "timeDiffObservable", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lio/reactivex/Observable;)V", "server-time_release"}, k = 1, mv = {1, 4, 2})
public class ServerTimeSource implements TimeSource {
    public long a;
    public final TimeSource b;

    public static final class a extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ ServerTimeSource a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ServerTimeSource serverTimeSource) {
            super(1);
            this.a = serverTimeSource;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Long l) {
            Long l2 = l;
            ServerTimeSource serverTimeSource = this.a;
            Intrinsics.checkNotNullExpressionValue(l2, "it");
            serverTimeSource.a = l2.longValue();
            Logs.debug$default("ServerTimeSource", "Updated serverTimeDiff: " + this.a.a, null, 4, null);
            return Unit.INSTANCE;
        }
    }

    public ServerTimeSource(@NotNull TimeSource timeSource, @NotNull Observable<Long> observable) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(observable, "timeDiffObservable");
        this.b = timeSource;
        Flowable<Long> flowable = observable.toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable, "timeDiffObservable\n     …kpressureStrategy.LATEST)");
        Flowables.subscribeOnNext(flowable, new a(this));
    }

    @Override // com.avito.android.server_time.TimeSource
    @NotNull
    public TimeZone getTimeZone() {
        return this.b.getTimeZone();
    }

    @Override // com.avito.android.server_time.TimeSource
    public long now() {
        return this.b.now() - this.a;
    }

    @Override // com.avito.android.server_time.TimeSource
    public void sleep(long j) {
        SystemClock.sleep(j);
    }
}
