package ru.avito.messenger;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lru/avito/messenger/NetworkMonitorImpl;", "Lru/avito/messenger/NetworkMonitor;", "", "isNetworkAvailable", "()Z", "Lio/reactivex/Observable;", "networkAvailability", "()Lio/reactivex/Observable;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class NetworkMonitorImpl implements NetworkMonitor {
    @Override // ru.avito.messenger.NetworkMonitor
    public boolean isNetworkAvailable() {
        return false;
    }

    @Override // ru.avito.messenger.NetworkMonitor
    @NotNull
    public Observable<Boolean> networkAvailability() {
        Observable<Boolean> never = Observable.never();
        Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
        return never;
    }
}
