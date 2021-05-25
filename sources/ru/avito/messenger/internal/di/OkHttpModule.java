package ru.avito.messenger.internal.di;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.Config;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/di/OkHttpModule;", "", "Lru/avito/messenger/internal/Config;", Navigation.CONFIG, "Lokhttp3/OkHttpClient;", "provideOkHttpClient", "(Lru/avito/messenger/internal/Config;)Lokhttp3/OkHttpClient;", "Ldagger/Lazy;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "okHttpClient", "<init>", "(Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class OkHttpModule {
    public final Lazy<OkHttpClient> a;

    public OkHttpModule(@NotNull Lazy<OkHttpClient> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "okHttpClient");
        this.a = lazy;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final OkHttpClient provideOkHttpClient(@NotNull Config config) {
        OkHttpClient.Builder builder;
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        OkHttpClient okHttpClient = this.a.get();
        if (okHttpClient == null || (builder = okHttpClient.newBuilder()) == null) {
            builder = new OkHttpClient.Builder();
        }
        long pingTimeout = config.getPingTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.pingInterval(pingTimeout, timeUnit).readTimeout(15000, timeUnit).connectTimeout(15000, timeUnit).writeTimeout(15000, timeUnit).cookieJar(CookieJar.NO_COOKIES).build();
    }
}
