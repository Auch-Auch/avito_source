package com.avito.android.messenger.config;

import com.avito.android.messenger.di.MessengerModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.Preferences;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.config.MessengerConfig;
import ru.avito.messenger.config.MessengerConfigStorage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/config/PersistentMessengerConfigStorage;", "Lru/avito/messenger/config/MessengerConfigStorage;", "Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "Lio/reactivex/Completable;", "saveConfig", "(Lru/avito/messenger/config/MessengerConfig;)Lio/reactivex/Completable;", "defaultConfig", "Lio/reactivex/Single;", "loadConfig", "(Lru/avito/messenger/config/MessengerConfig;)Lio/reactivex/Single;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/config/MessengerConfig;", "currentConfig", "Lcom/avito/android/util/preferences/Preferences;", "c", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "lock", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PersistentMessengerConfigStorage implements MessengerConfigStorage {
    public final Object a = new Object();
    public volatile MessengerConfig b;
    public final Preferences c;

    public static final class a<V> implements Callable<MessengerConfig> {
        public final /* synthetic */ PersistentMessengerConfigStorage a;
        public final /* synthetic */ MessengerConfig b;

        public a(PersistentMessengerConfigStorage persistentMessengerConfigStorage, MessengerConfig messengerConfig) {
            this.a = persistentMessengerConfigStorage;
            this.b = messengerConfig;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public MessengerConfig call() {
            MessengerConfig messengerConfig = this.a.b;
            if (messengerConfig == null) {
                PersistentMessengerConfigStorage persistentMessengerConfigStorage = this.a;
                synchronized (persistentMessengerConfigStorage.a) {
                    MessengerConfig messengerConfig2 = persistentMessengerConfigStorage.b;
                    if (messengerConfig2 == null) {
                        messengerConfig2 = PersistentMessengerConfigStorage.access$getFromPreferences(persistentMessengerConfigStorage, this.b);
                        persistentMessengerConfigStorage.b = messengerConfig2;
                    }
                    messengerConfig = messengerConfig2;
                }
            }
            return messengerConfig;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ PersistentMessengerConfigStorage a;
        public final /* synthetic */ MessengerConfig b;

        public b(PersistentMessengerConfigStorage persistentMessengerConfigStorage, MessengerConfig messengerConfig) {
            this.a = persistentMessengerConfigStorage;
            this.b = messengerConfig;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            synchronized (this.a.a) {
                if (!Intrinsics.areEqual(this.b, this.a.b)) {
                    PersistentMessengerConfigStorage.access$storeToPreferences(this.a, this.b);
                    this.a.b = this.b;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Inject
    public PersistentMessengerConfigStorage(@MessengerModule.MessengerPreferences @NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.c = preferences;
    }

    public static final MessengerConfig access$getFromPreferences(PersistentMessengerConfigStorage persistentMessengerConfigStorage, MessengerConfig messengerConfig) {
        Objects.requireNonNull(persistentMessengerConfigStorage);
        try {
            return new MessengerConfig(persistentMessengerConfigStorage.c.getLong(PersistentMessengerConfigStorageKt.KEY_TIME_TO_MODIFY_MESSAGE, messengerConfig.getTimeToModifyMessage()));
        } catch (Exception e) {
            Logs.warning("PersistentMessengerConfigStorage", "Failed to load config from preferences", e);
            return messengerConfig;
        }
    }

    public static final void access$storeToPreferences(PersistentMessengerConfigStorage persistentMessengerConfigStorage, MessengerConfig messengerConfig) {
        Objects.requireNonNull(persistentMessengerConfigStorage);
        try {
            persistentMessengerConfigStorage.c.putLong(PersistentMessengerConfigStorageKt.KEY_TIME_TO_MODIFY_MESSAGE, messengerConfig.getTimeToModifyMessage());
        } catch (Exception e) {
            Logs.warning("PersistentMessengerConfigStorage", "Failed to save config to preferences", e);
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
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…}\n            }\n        }");
        return fromAction;
    }
}
