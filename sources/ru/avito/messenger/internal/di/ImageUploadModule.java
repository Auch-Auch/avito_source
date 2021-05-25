package ru.avito.messenger.internal.di;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerImageUploadApi;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.ImageUploadConfig;
import ru.avito.messenger.internal.OkHttpMessengerImageUploader;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lru/avito/messenger/internal/di/ImageUploadModule;", "", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "client", "Lru/avito/messenger/internal/Config;", "messengerConfig", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/messenger/MessengerImageUploadApi;", "provideImageUploadApi", "(Ldagger/Lazy;Lru/avito/messenger/internal/Config;Lcom/google/gson/Gson;Lcom/avito/android/util/SchedulersFactory;)Lru/avito/messenger/MessengerImageUploadApi;", "provideImageUploadOkHttpClient", "(Lokhttp3/OkHttpClient;)Lokhttp3/OkHttpClient;", "Lru/avito/messenger/internal/ImageUploadConfig;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/internal/ImageUploadConfig;", Navigation.CONFIG, AuthSource.BOOKING_ORDER, "Lru/avito/messenger/MessengerImageUploadApi;", "messengerUploadApi", "<init>", "(Lru/avito/messenger/internal/ImageUploadConfig;Lru/avito/messenger/MessengerImageUploadApi;)V", "ImageUpload", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ConfigModule.class, GsonModule.class, SchedulersModule.class, OkHttpModule.class})
public final class ImageUploadModule {
    public final ImageUploadConfig a;
    public final MessengerImageUploadApi b;

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/messenger/internal/di/ImageUploadModule$ImageUpload;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ImageUpload {
    }

    public ImageUploadModule(@NotNull ImageUploadConfig imageUploadConfig, @Nullable MessengerImageUploadApi messengerImageUploadApi) {
        Intrinsics.checkNotNullParameter(imageUploadConfig, Navigation.CONFIG);
        this.a = imageUploadConfig;
        this.b = messengerImageUploadApi;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final MessengerImageUploadApi provideImageUploadApi(@NotNull Lazy<OkHttpClient> lazy, @NotNull Config config, @NotNull Gson gson, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(lazy, "client");
        Intrinsics.checkNotNullParameter(config, "messengerConfig");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        MessengerImageUploadApi messengerImageUploadApi = this.b;
        if (messengerImageUploadApi != null) {
            return messengerImageUploadApi;
        }
        ImageUploadConfig imageUploadConfig = this.a;
        return new OkHttpMessengerImageUploader(lazy, imageUploadConfig.getEndpoint(), imageUploadConfig.getOrigin(), config.getSessionProvider(), gson, schedulersFactory);
    }

    @Provides
    @PerMessenger
    @NotNull
    public final OkHttpClient provideImageUploadOkHttpClient(@NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
        long uploadTimeoutMs = this.a.getUploadTimeoutMs();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return newBuilder.readTimeout(uploadTimeoutMs, timeUnit).writeTimeout(this.a.getUploadTimeoutMs(), timeUnit).connectTimeout(this.a.getUploadTimeoutMs(), timeUnit).build();
    }
}
