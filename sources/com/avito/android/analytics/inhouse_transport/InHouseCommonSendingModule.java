package com.avito.android.analytics.inhouse_transport;

import android.os.Looper;
import com.avito.android.util.BuildInfo;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0013\b\u0001\u0010\n\u001a\r\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/InHouseCommonSendingModule;", "", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lokhttp3/OkHttpClient;", "provideHttpClient", "(Lcom/avito/android/util/BuildInfo;)Lokhttp3/OkHttpClient;", "", "Lokhttp3/Interceptor;", "Lkotlin/jvm/JvmSuppressWildcards;", "interceptors", "provideInHouseGzipHttpClient", "(Lcom/avito/android/util/BuildInfo;Ljava/util/Set;)Lokhttp3/OkHttpClient;", "<init>", "()V", "InHouseGzipHttpClient", "InHouseHttpClient", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class InHouseCommonSendingModule {
    @NotNull
    public static final InHouseCommonSendingModule INSTANCE = new InHouseCommonSendingModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/InHouseCommonSendingModule$InHouseGzipHttpClient;", "", "<init>", "()V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface InHouseGzipHttpClient {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/InHouseCommonSendingModule$InHouseHttpClient;", "", "<init>", "()V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface InHouseHttpClient {
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    @InHouseHttpClient
    public static final OkHttpClient provideHttpClient(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        if (!buildInfo.isDebug() || (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            return builder.readTimeout(30, timeUnit).connectTimeout(30, timeUnit).protocols(CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1})).build();
        }
        throw new IllegalStateException("Initializing OkHttpClient on main thread.".toString());
    }

    @Provides
    @JvmStatic
    @Reusable
    @InHouseGzipHttpClient
    @NotNull
    public static final OkHttpClient provideInHouseGzipHttpClient(@NotNull BuildInfo buildInfo, @InHouseGzipHttpClient @NotNull Set<Interceptor> set) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(set, "interceptors");
        if (!buildInfo.isDebug() || (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder addInterceptor = builder.readTimeout(30, timeUnit).connectTimeout(30, timeUnit).addInterceptor(new GzipRequestInterceptor());
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                addInterceptor.addInterceptor(it.next());
            }
            return addInterceptor.protocols(CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1})).build();
        }
        throw new IllegalStateException("Initializing OkHttpClient on main thread.".toString());
    }
}
