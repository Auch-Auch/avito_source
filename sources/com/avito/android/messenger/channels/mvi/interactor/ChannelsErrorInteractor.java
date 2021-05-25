package com.avito.android.messenger.channels.mvi.interactor;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsErrorInteractor;", "", "", "loggedOut", "()V", "Lio/reactivex/Observable;", "getLoggedOutStream", "()Lio/reactivex/Observable;", "loggedOutStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsErrorInteractor {
    @NotNull
    Observable<Unit> getLoggedOutStream();

    void loggedOut();
}
