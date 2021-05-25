package com.avito.android.di.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.connection_quality.BandwidthSamplerInterceptor;
import com.avito.android.di.module.HttpClientModule;
import com.avito.android.remote.AvitoCallAdapterFactory;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import com.avito.android.remote.CallAdapterFactoryResourceProviderImpl;
import com.avito.android.remote.interceptor.ApiAnalyticsInterceptor;
import com.avito.android.remote.interceptor.CertificatePinningInterceptor;
import com.avito.android.remote.interceptor.DateInterceptor;
import com.avito.android.remote.interceptor.HeadersInterceptor;
import com.avito.android.remote.interceptor.RequestParamsInterceptor;
import com.avito.android.remote.interceptor.ServerTimeInterceptor;
import com.avito.android.remote.interceptor.SessionInterceptor;
import com.avito.android.remote.interceptor.SupportedFeaturesInterceptor;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import com.avito.android.remote.interceptors.FirewallErrorInterceptor;
import com.avito.android.remote.parse.AvitoResponseParserConverter;
import com.avito.android.remote.parse.ParsingAnalytics;
import com.avito.android.remote.parse.adapter.stream_gson.GsonMigrationConverter;
import com.avito.android.remote.parse.adapter.stream_gson.StreamGsonResponseParserConverter;
import com.avito.android.remote.request.RequestBodyConverter;
import com.avito.android.remote.social.AvitoSocialTypeToStringMapper;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.OkHttpInjector;
import com.avito.android.util.PreferencesCookieJar;
import com.avito.android.util.Strings;
import com.avito.android.util.preferences.Names;
import com.avito.android.util.preferences.PreferenceFactoryImpl;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.Gson;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b?\u0010@JW\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\u0001\u00105\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u0002012\b\u00104\u001a\u0004\u0018\u000103H\u0017¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00152\u0006\u00108\u001a\u000207H\u0017¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u0002012\u0006\u0010<\u001a\u00020;H\u0017¢\u0006\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/avito/android/di/module/ApiModule;", "", "Lcom/avito/android/Features;", "features", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "httpClient", "streamGson", "Lretrofit2/CallAdapter$Factory;", "callAdapterFactory", "Lretrofit2/Retrofit;", "provideAvitoRetrofit", "(Lcom/avito/android/Features;Lcom/google/gson/Gson;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/grafana/GraphitePrefix;Lcom/avito/android/util/BuildInfo;Ldagger/Lazy;Lcom/google/gson/Gson;Lretrofit2/CallAdapter$Factory;)Lretrofit2/Retrofit;", "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "resourceProvider", "provideAvitoCallAdapterFactory", "(Lcom/google/gson/Gson;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/Features;Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;)Lretrofit2/CallAdapter$Factory;", "Lokhttp3/CertificatePinner;", "certificatePinner", "Lcom/avito/android/remote/interceptor/SessionInterceptor;", "sessionInterceptor", "Lcom/avito/android/remote/interceptor/RequestParamsInterceptor;", "requestParamsInterceptor", "Lcom/avito/android/remote/interceptor/CertificatePinningInterceptor;", "pinningInterceptor", "Lcom/avito/android/remote/interceptor/DateInterceptor;", "dateInterceptor", "Lcom/avito/android/connection_quality/BandwidthSamplerInterceptor;", "bandwidthSamplerInterceptor", "Lcom/avito/android/remote/interceptor/ServerTimeInterceptor;", "serverTimeInterceptor", "Lcom/avito/android/remote/interceptor/SupportedFeaturesInterceptor;", "featuresInterceptor", "Lcom/avito/android/remote/interceptor/UserAgentInterceptor;", "userAgentInterceptor", "Lcom/avito/android/remote/interceptors/FirewallErrorInterceptor;", "firewallErrorInterceptor", "Lcom/avito/android/remote/interceptor/ApiAnalyticsInterceptor;", "apiAnalyticsInterceptor", "Lcom/avito/android/remote/interceptor/HeadersInterceptor;", "headersInterceptor", "Lokhttp3/CookieJar;", "preferencesCookieJar", "Lcom/avito/android/util/OkHttpInjector;", "debugInjector", "provideOkHttpClient", "(Lcom/avito/android/Features;Lokhttp3/CertificatePinner;Lcom/avito/android/remote/interceptor/SessionInterceptor;Lcom/avito/android/remote/interceptor/RequestParamsInterceptor;Lcom/avito/android/remote/interceptor/CertificatePinningInterceptor;Lcom/avito/android/remote/interceptor/DateInterceptor;Lcom/avito/android/connection_quality/BandwidthSamplerInterceptor;Lcom/avito/android/remote/interceptor/ServerTimeInterceptor;Lokhttp3/OkHttpClient;Lcom/avito/android/remote/interceptor/SupportedFeaturesInterceptor;Lcom/avito/android/remote/interceptor/UserAgentInterceptor;Lcom/avito/android/remote/interceptors/FirewallErrorInterceptor;Lcom/avito/android/remote/interceptor/ApiAnalyticsInterceptor;Lcom/avito/android/remote/interceptor/HeadersInterceptor;Lokhttp3/CookieJar;Lcom/avito/android/util/OkHttpInjector;)Lokhttp3/OkHttpClient;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "provideCallAdapterResourceProvider", "(Landroid/app/Application;)Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "Landroid/content/Context;", "context", "providePreferencesCookieJar", "(Landroid/content/Context;)Lokhttp3/CookieJar;", "<init>", "()V", "Bindings", "core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ServerTimeModule.class, HttpClientModule.class, RetrofitFactoryModule.class, CoreJsonModule.class, CoreOptimalJsonModule.class, ApiInterceptorsModule.class, ApiConnectionQualityModule.class, Bindings.class})
public class ApiModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/ApiModule$Bindings;", "", "Lcom/avito/android/remote/social/AvitoSocialTypeToStringMapper;", "impl", "Lcom/avito/android/social/SocialTypeToStringMapper;", "bindSocialMapper", "(Lcom/avito/android/remote/social/AvitoSocialTypeToStringMapper;)Lcom/avito/android/social/SocialTypeToStringMapper;", "core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Reusable
        @Binds
        @NotNull
        SocialTypeToStringMapper bindSocialMapper(@NotNull AvitoSocialTypeToStringMapper avitoSocialTypeToStringMapper);
    }

    @Provides
    @NotNull
    public CallAdapter.Factory provideAvitoCallAdapterFactory(@NotNull Gson gson, @NotNull BuildInfo buildInfo, @NotNull Features features, @NotNull CallAdapterFactoryResourceProvider callAdapterFactoryResourceProvider) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(callAdapterFactoryResourceProvider, "resourceProvider");
        return AvitoCallAdapterFactory.Companion.create(gson, buildInfo, features, callAdapterFactoryResourceProvider);
    }

    @Provides
    @NotNull
    @Singleton
    public Retrofit provideAvitoRetrofit(@NotNull Features features, @NotNull Gson gson, @NotNull Analytics analytics, @NotNull GraphitePrefix graphitePrefix, @NotNull BuildInfo buildInfo, @NotNull Lazy<OkHttpClient> lazy, @StreamGson @NotNull Gson gson2, @NotNull CallAdapter.Factory factory) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(lazy, "httpClient");
        Intrinsics.checkNotNullParameter(gson2, "streamGson");
        Intrinsics.checkNotNullParameter(factory, "callAdapterFactory");
        Retrofit.Builder callFactory = new Retrofit.Builder().baseUrl(Strings.ensureEndsWith(features.getApiUrl().getValue(), "/")).addConverterFactory(new GsonMigrationConverter(new Converter.Factory(gson2, analytics, graphitePrefix, features) { // from class: com.avito.android.di.module.ApiModule$provideAvitoRetrofit$streamConverterFactory$1
            public final /* synthetic */ Gson a;
            public final /* synthetic */ Analytics b;
            public final /* synthetic */ GraphitePrefix c;
            public final /* synthetic */ Features d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // retrofit2.Converter.Factory
            @NotNull
            public Converter<?, RequestBody> requestBodyConverter(@Nullable Type type, @Nullable Annotation[] annotationArr, @Nullable Annotation[] annotationArr2, @Nullable Retrofit retrofit) {
                return new RequestBodyConverter(type, annotationArr);
            }

            @Override // retrofit2.Converter.Factory
            @NotNull
            public Converter<ResponseBody, ?> responseBodyConverter(@Nullable Type type, @NotNull Annotation[] annotationArr, @Nullable Retrofit retrofit) {
                Intrinsics.checkNotNullParameter(annotationArr, "annotations");
                Gson gson3 = this.a;
                Intrinsics.checkNotNull(type);
                return new StreamGsonResponseParserConverter(gson3, type, new ParsingAnalytics.Impl(this.b, this.c, this.d, annotationArr));
            }
        })).addConverterFactory(new Converter.Factory(gson, analytics, graphitePrefix, features) { // from class: com.avito.android.di.module.ApiModule$provideAvitoRetrofit$converterFactory$1
            public final /* synthetic */ Gson a;
            public final /* synthetic */ Analytics b;
            public final /* synthetic */ GraphitePrefix c;
            public final /* synthetic */ Features d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // retrofit2.Converter.Factory
            @NotNull
            public Converter<?, RequestBody> requestBodyConverter(@Nullable Type type, @Nullable Annotation[] annotationArr, @Nullable Annotation[] annotationArr2, @Nullable Retrofit retrofit) {
                return new RequestBodyConverter(type, annotationArr);
            }

            @Override // retrofit2.Converter.Factory
            @NotNull
            public Converter<ResponseBody, ?> responseBodyConverter(@Nullable Type type, @NotNull Annotation[] annotationArr, @Nullable Retrofit retrofit) {
                Intrinsics.checkNotNullParameter(annotationArr, "annotations");
                Gson gson3 = this.a;
                Intrinsics.checkNotNull(type);
                return new AvitoResponseParserConverter(gson3, type, new ParsingAnalytics.Impl(this.b, this.c, this.d, annotationArr));
            }
        }).addCallAdapterFactory(factory).callFactory(new Call.Factory(lazy) { // from class: com.avito.android.di.module.ApiModule$provideAvitoRetrofit$builder$1
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
        if (buildInfo.isDebug()) {
            callFactory.validateEagerly(true);
        }
        Retrofit build = callFactory.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder\n            .build()");
        return build;
    }

    @Provides
    @NotNull
    public CallAdapterFactoryResourceProvider provideCallAdapterResourceProvider(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        return new CallAdapterFactoryResourceProviderImpl(resources);
    }

    @Provides
    @Singleton
    @NotNull
    public OkHttpClient provideOkHttpClient(@NotNull Features features, @NotNull CertificatePinner certificatePinner, @NotNull SessionInterceptor sessionInterceptor, @NotNull RequestParamsInterceptor requestParamsInterceptor, @NotNull CertificatePinningInterceptor certificatePinningInterceptor, @NotNull DateInterceptor dateInterceptor, @NotNull BandwidthSamplerInterceptor bandwidthSamplerInterceptor, @NotNull ServerTimeInterceptor serverTimeInterceptor, @HttpClientModule.BasicClient @NotNull OkHttpClient okHttpClient, @NotNull SupportedFeaturesInterceptor supportedFeaturesInterceptor, @NotNull UserAgentInterceptor userAgentInterceptor, @NotNull FirewallErrorInterceptor firewallErrorInterceptor, @NotNull ApiAnalyticsInterceptor apiAnalyticsInterceptor, @NotNull HeadersInterceptor headersInterceptor, @NotNull CookieJar cookieJar, @Nullable OkHttpInjector okHttpInjector) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(certificatePinner, "certificatePinner");
        Intrinsics.checkNotNullParameter(sessionInterceptor, "sessionInterceptor");
        Intrinsics.checkNotNullParameter(requestParamsInterceptor, "requestParamsInterceptor");
        Intrinsics.checkNotNullParameter(certificatePinningInterceptor, "pinningInterceptor");
        Intrinsics.checkNotNullParameter(dateInterceptor, "dateInterceptor");
        Intrinsics.checkNotNullParameter(bandwidthSamplerInterceptor, "bandwidthSamplerInterceptor");
        Intrinsics.checkNotNullParameter(serverTimeInterceptor, "serverTimeInterceptor");
        Intrinsics.checkNotNullParameter(okHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(supportedFeaturesInterceptor, "featuresInterceptor");
        Intrinsics.checkNotNullParameter(userAgentInterceptor, "userAgentInterceptor");
        Intrinsics.checkNotNullParameter(firewallErrorInterceptor, "firewallErrorInterceptor");
        Intrinsics.checkNotNullParameter(apiAnalyticsInterceptor, "apiAnalyticsInterceptor");
        Intrinsics.checkNotNullParameter(headersInterceptor, "headersInterceptor");
        Intrinsics.checkNotNullParameter(cookieJar, "preferencesCookieJar");
        OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
        newBuilder.interceptors().clear();
        OkHttpClient.Builder addInterceptor = newBuilder.addInterceptor(bandwidthSamplerInterceptor).addInterceptor(sessionInterceptor).addInterceptor(requestParamsInterceptor).addInterceptor(userAgentInterceptor).addInterceptor(serverTimeInterceptor).addInterceptor(supportedFeaturesInterceptor).addInterceptor(headersInterceptor).addInterceptor(firewallErrorInterceptor);
        if (features.getUseApiAnalytics().invoke().booleanValue()) {
            addInterceptor.addInterceptor(apiAnalyticsInterceptor);
        }
        addInterceptor.addNetworkInterceptor(dateInterceptor);
        newBuilder.cookieJar(cookieJar);
        if (features.getCertificatePinningEnabled().getValue().booleanValue()) {
            newBuilder.certificatePinner(certificatePinner);
            newBuilder.addInterceptor(certificatePinningInterceptor);
        }
        if (okHttpInjector != null) {
            okHttpInjector.inject(newBuilder);
        }
        return newBuilder.build();
    }

    @Provides
    @Reusable
    @NotNull
    public CookieJar providePreferencesCookieJar(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PreferencesCookieJar(new PreferenceFactoryImpl().getCustomPreferences(context, Names.COOKIE_STORE_NAME));
    }
}
