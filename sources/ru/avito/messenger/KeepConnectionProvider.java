package ru.avito.messenger;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0007R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/avito/messenger/KeepConnectionProvider;", "", "Lio/reactivex/Observable;", "", "getShouldKeepConnection", "()Lio/reactivex/Observable;", "shouldKeepConnection", "Dummy", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface KeepConnectionProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lru/avito/messenger/KeepConnectionProvider$Dummy;", "Lru/avito/messenger/KeepConnectionProvider;", "Lio/reactivex/Observable;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getShouldKeepConnection", "()Lio/reactivex/Observable;", "shouldKeepConnection", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dummy implements KeepConnectionProvider {
        @NotNull
        public final Observable<Boolean> a;

        public Dummy() {
            Observable<Boolean> just = Observable.just(Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(true)");
            this.a = just;
        }

        @Override // ru.avito.messenger.KeepConnectionProvider
        @NotNull
        public Observable<Boolean> getShouldKeepConnection() {
            return this.a;
        }
    }

    @NotNull
    Observable<Boolean> getShouldKeepConnection();
}
