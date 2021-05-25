package com.avito.android.analytics.di;

import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics.provider.pixel.PixelApi;
import com.avito.android.analytics.provider.pixel.PixelEventObserver;
import com.avito.android.analytics.provider.pixel.PixelEventTracker;
import com.avito.android.analytics.provider.pixel.PixelEventTrackerImpl;
import com.avito.android.analytics.provider.pixel.PixelEventTrackerKt;
import com.avito.android.analytics.provider.pixel.PixelInteractor;
import com.avito.android.analytics.provider.pixel.PixelInteractorImpl;
import com.avito.android.analytics.provider.pixel.PixelParameterEncoder;
import com.avito.android.analytics.provider.pixel.PixelParameterEncoderImpl;
import com.avito.android.analytics.provider.pixel.PixelParameterFormatter;
import com.avito.android.analytics.provider.pixel.PixelParameterFormatterImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DefaultRandomizationGenerator;
import com.avito.android.util.RandomizationGenerator;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Named;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00052\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/analytics/di/PixelModule;", "", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "httpClient", "Lcom/avito/android/analytics/provider/pixel/PixelApi;", "providePixelApi$analytics_release", "(Ldagger/Lazy;)Lcom/avito/android/analytics/provider/pixel/PixelApi;", "providePixelApi", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "", "provideVersionName$analytics_release", "(Lcom/avito/android/util/BuildInfo;)Ljava/lang/String;", "provideVersionName", "<init>", "()V", "Declarations", "PixelHttpClient", "analytics_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class PixelModule {
    @NotNull
    public static final PixelModule INSTANCE = new PixelModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/analytics/di/PixelModule$Declarations;", "", "Lcom/avito/android/analytics/provider/pixel/PixelEventObserver;", "pixelEventObserver", "Lcom/avito/android/analytics/EventObserver;", "bindPixelEventObserver", "(Lcom/avito/android/analytics/provider/pixel/PixelEventObserver;)Lcom/avito/android/analytics/EventObserver;", "Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatterImpl;", "pixelParameterFormatter", "Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatter;", "bindPixelParameterFormatter", "(Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatterImpl;)Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatter;", "Lcom/avito/android/analytics/provider/pixel/PixelParameterEncoderImpl;", "pixelParameterEncoder", "Lcom/avito/android/analytics/provider/pixel/PixelParameterEncoder;", "bindPixelParameterEncoder", "(Lcom/avito/android/analytics/provider/pixel/PixelParameterEncoderImpl;)Lcom/avito/android/analytics/provider/pixel/PixelParameterEncoder;", "Lcom/avito/android/util/DefaultRandomizationGenerator;", "randomizationGenerator", "Lcom/avito/android/util/RandomizationGenerator;", "bindRandomizationGenerator", "(Lcom/avito/android/util/DefaultRandomizationGenerator;)Lcom/avito/android/util/RandomizationGenerator;", "Lcom/avito/android/analytics/provider/pixel/PixelInteractorImpl;", "pixelInteractor", "Lcom/avito/android/analytics/provider/pixel/PixelInteractor;", "bindPixelInteractor", "(Lcom/avito/android/analytics/provider/pixel/PixelInteractorImpl;)Lcom/avito/android/analytics/provider/pixel/PixelInteractor;", "Lcom/avito/android/analytics/provider/pixel/PixelEventTrackerImpl;", "pixelEventTracker", "Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;", "bindPixelEventTracker", "(Lcom/avito/android/analytics/provider/pixel/PixelEventTrackerImpl;)Lcom/avito/android/analytics/provider/pixel/PixelEventTracker;", "analytics_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @Singleton
        EventObserver bindPixelEventObserver(@NotNull PixelEventObserver pixelEventObserver);

        @Singleton
        @Binds
        @NotNull
        PixelEventTracker bindPixelEventTracker(@NotNull PixelEventTrackerImpl pixelEventTrackerImpl);

        @Singleton
        @Binds
        @NotNull
        PixelInteractor bindPixelInteractor(@NotNull PixelInteractorImpl pixelInteractorImpl);

        @Singleton
        @Binds
        @NotNull
        PixelParameterEncoder bindPixelParameterEncoder(@NotNull PixelParameterEncoderImpl pixelParameterEncoderImpl);

        @Singleton
        @Binds
        @NotNull
        PixelParameterFormatter bindPixelParameterFormatter(@NotNull PixelParameterFormatterImpl pixelParameterFormatterImpl);

        @Singleton
        @Binds
        @NotNull
        RandomizationGenerator bindRandomizationGenerator(@NotNull DefaultRandomizationGenerator defaultRandomizationGenerator);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/analytics/di/PixelModule$PixelHttpClient;", "", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface PixelHttpClient {
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final PixelApi providePixelApi$analytics_release(@PixelHttpClient @NotNull Lazy<OkHttpClient> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "httpClient");
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://www.avito.ru/stat/");
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.callFactory(new Call.Factory(lazy) { // from class: com.avito.android.analytics.di.PixelModule$providePixelApi$$inlined$with$lambda$1
            public final /* synthetic */ Lazy a;

            {
                this.a = r1;
            }

            @Override // okhttp3.Call.Factory
            @NotNull
            public Call newCall(@NotNull Request request) {
                Intrinsics.checkNotNullParameter(request, "request");
                return ((OkHttpClient) this.a.get()).newCall(request);
            }
        });
        Retrofit build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build()");
        return (PixelApi) build.create(PixelApi.class);
    }

    @Provides
    @JvmStatic
    @Named(PixelEventTrackerKt.VERSION_NAME)
    @NotNull
    @Singleton
    public static final String provideVersionName$analytics_release(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return buildInfo.getVersionName();
    }
}
