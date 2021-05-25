package ru.avito.messenger;

import io.reactivex.Completable;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lru/avito/messenger/MessengerConnection;", "", "", "force", "Lio/reactivex/Completable;", "connect", "(Z)Lio/reactivex/Completable;", "Lio/reactivex/Observable;", "Lru/avito/messenger/MessengerState;", "state", "()Lio/reactivex/Observable;", "", "reconnects", "allReconnects", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerConnection {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Completable connect$default(MessengerConnection messengerConnection, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return messengerConnection.connect(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connect");
        }
    }

    @NotNull
    Observable<Boolean> allReconnects();

    @NotNull
    Completable connect(boolean z);

    @NotNull
    Observable<Unit> reconnects();

    @NotNull
    Observable<MessengerState> state();
}
