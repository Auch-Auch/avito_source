package com.avito.android.messenger.channels.mvi.common;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001R\u0016\u0010\u0005\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "", "StateT", "getStateBlocking", "()Ljava/lang/Object;", "stateBlocking", "Lio/reactivex/Observable;", "getStateObservable", "()Lio/reactivex/Observable;", "stateObservable", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface MviEntity<StateT> {
    @NotNull
    StateT getStateBlocking();

    @NotNull
    Observable<StateT> getStateObservable();
}
