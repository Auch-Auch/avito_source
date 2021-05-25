package com.avito.android.messenger.conversation;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u00002\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u00000\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "shared", "Lio/reactivex/ObservableSource;", "apply", "(Lio/reactivex/Observable;)Lio/reactivex/ObservableSource;", "com/avito/android/util/Observables$debounceAfter$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelFragment$bindChannelMenuView$$inlined$debounceAfter$2<T, R> implements Function<Observable<T>, ObservableSource<T>> {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;
    public final /* synthetic */ TimeUnit c;
    public final /* synthetic */ Scheduler d;

    public ChannelFragment$bindChannelMenuView$$inlined$debounceAfter$2(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.a = j;
        this.b = j2;
        this.c = timeUnit;
        this.d = scheduler;
    }

    public final ObservableSource<T> apply(@NotNull Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "shared");
        return Observable.merge(observable.take(this.a), observable.skip(this.a).debounce(this.b, this.c, this.d));
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Observable) ((Observable) obj));
    }
}
