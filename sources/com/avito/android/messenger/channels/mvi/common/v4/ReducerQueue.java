package com.avito.android.messenger.channels.mvi.common.v4;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦\u0002¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "", "StateT", "Lio/reactivex/disposables/Disposable;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "value", "", "plusAssign", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;)V", "Lio/reactivex/Observable;", "getStream", "()Lio/reactivex/Observable;", "stream", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface ReducerQueue<StateT> extends Disposable {
    @NotNull
    Observable<Reducible<StateT>> getStream();

    void plusAssign(@NotNull Reducible<StateT> reducible);
}
