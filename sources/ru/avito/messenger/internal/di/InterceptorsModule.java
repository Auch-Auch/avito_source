package ru.avito.messenger.internal.di;

import com.avito.android.remote.model.Navigation;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.RequestIdHolder;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.jsonrpc.JsonRpcCallAnalyticsInterceptor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lru/avito/messenger/internal/di/InterceptorsModule;", "", "Lru/avito/messenger/internal/Config;", Navigation.CONFIG, "Lru/avito/messenger/RequestIdHolder;", "requestIdHolder", "Lru/avito/messenger/internal/jsonrpc/JsonRpcCallAnalyticsInterceptor;", "provideJsonRpcCallAnalyticsInterceptor", "(Lru/avito/messenger/internal/Config;Lru/avito/messenger/RequestIdHolder;)Lru/avito/messenger/internal/jsonrpc/JsonRpcCallAnalyticsInterceptor;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class InterceptorsModule {
    @Provides
    @PerMessenger
    @NotNull
    public final JsonRpcCallAnalyticsInterceptor provideJsonRpcCallAnalyticsInterceptor(@NotNull Config config, @NotNull RequestIdHolder requestIdHolder) {
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(requestIdHolder, "requestIdHolder");
        return new JsonRpcCallAnalyticsInterceptor(config.getAnalytics(), requestIdHolder);
    }
}
