package ru.avito.messenger.internal.di;

import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.config.MessengerConfig;
import ru.avito.messenger.config.MessengerConfigProvider;
import ru.avito.messenger.config.MessengerConfigStorage;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.ConstantsKt;
import ru.avito.messenger.internal.config.SimpleConfigProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/di/MessengerConfigModule;", "", "Lru/avito/messenger/internal/Config;", Navigation.CONFIG, "Lru/avito/messenger/config/MessengerConfigStorage;", "provideMessengerConfigStorage", "(Lru/avito/messenger/internal/Config;)Lru/avito/messenger/config/MessengerConfigStorage;", "configStorage", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/messenger/config/MessengerConfigProvider;", "provideMessengerConfigProvider", "(Lru/avito/messenger/config/MessengerConfigStorage;Lcom/avito/android/util/SchedulersFactory;)Lru/avito/messenger/config/MessengerConfigProvider;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class MessengerConfigModule {
    @Provides
    @PerMessenger
    @NotNull
    public final MessengerConfigProvider provideMessengerConfigProvider(@NotNull MessengerConfigStorage messengerConfigStorage, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(messengerConfigStorage, "configStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new SimpleConfigProvider(messengerConfigStorage, schedulersFactory, new MessengerConfig(MessengerTimestamp.fromMillis(ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS)));
    }

    @Provides
    @PerMessenger
    @NotNull
    public final MessengerConfigStorage provideMessengerConfigStorage(@NotNull Config config) {
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        return config.getConfigStorage();
    }
}
