package ru.avito.messenger.internal.di;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.Config;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lru/avito/messenger/internal/di/ConfigModule;", "", "Lru/avito/messenger/internal/Config;", "provideConfig", "()Lru/avito/messenger/internal/Config;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/internal/Config;", "getConfig", Navigation.CONFIG, "<init>", "(Lru/avito/messenger/internal/Config;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ConfigModule {
    @NotNull
    public final Config a;

    public ConfigModule(@NotNull Config config) {
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        this.a = config;
    }

    @NotNull
    public final Config getConfig() {
        return this.a;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final Config provideConfig() {
        return this.a;
    }
}
