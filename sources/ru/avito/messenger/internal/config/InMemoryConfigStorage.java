package ru.avito.messenger.internal.config;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.GuardedBy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.config.MessengerConfig;
import ru.avito.messenger.config.MessengerConfigStorage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lru/avito/messenger/internal/config/InMemoryConfigStorage;", "Lru/avito/messenger/config/MessengerConfigStorage;", "Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "Lio/reactivex/Completable;", "saveConfig", "(Lru/avito/messenger/config/MessengerConfig;)Lio/reactivex/Completable;", "defaultConfig", "Lio/reactivex/Single;", "loadConfig", "(Lru/avito/messenger/config/MessengerConfig;)Lio/reactivex/Single;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "lock", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/config/MessengerConfig;", "currentConfig", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class InMemoryConfigStorage implements MessengerConfigStorage {
    public final Object a = new Object();
    @GuardedBy("lock")
    public MessengerConfig b;

    public static final class a<V> implements Callable<MessengerConfig> {
        public final /* synthetic */ InMemoryConfigStorage a;
        public final /* synthetic */ MessengerConfig b;

        public a(InMemoryConfigStorage inMemoryConfigStorage, MessengerConfig messengerConfig) {
            this.a = inMemoryConfigStorage;
            this.b = messengerConfig;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public MessengerConfig call() {
            MessengerConfig messengerConfig;
            MessengerConfig messengerConfig2 = this.a.b;
            if (messengerConfig2 != null) {
                return messengerConfig2;
            }
            synchronized (this.a.a) {
                messengerConfig = this.a.b;
                if (messengerConfig == null) {
                    this.a.b = this.b;
                    messengerConfig = this.b;
                }
            }
            return messengerConfig;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ InMemoryConfigStorage a;
        public final /* synthetic */ MessengerConfig b;

        public b(InMemoryConfigStorage inMemoryConfigStorage, MessengerConfig messengerConfig) {
            this.a = inMemoryConfigStorage;
            this.b = messengerConfig;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            synchronized (this.a.a) {
                this.a.b = this.b;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // ru.avito.messenger.config.MessengerConfigStorage
    @NotNull
    public Single<MessengerConfig> loadConfig(@NotNull MessengerConfig messengerConfig) {
        Intrinsics.checkNotNullParameter(messengerConfig, "defaultConfig");
        Single<MessengerConfig> fromCallable = Single.fromCallable(new a(this, messengerConfig));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …}\n            }\n        }");
        return fromCallable;
    }

    @Override // ru.avito.messenger.config.MessengerConfigStorage
    @NotNull
    public Completable saveConfig(@NotNull MessengerConfig messengerConfig) {
        Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
        Completable fromAction = Completable.fromAction(new b(this, messengerConfig));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…g\n            }\n        }");
        return fromAction;
    }
}
