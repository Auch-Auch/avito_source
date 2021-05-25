package com.avito.android.di.module;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.app.ActivityProvider;
import com.avito.android.certificate_pinning.CertificatePinningErrorRouter;
import com.avito.android.certificate_pinning.CertificatePinningErrorRouterImpl;
import com.avito.android.certificate_pinning.Pin;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.interceptor.CertificatePinningInterceptor;
import com.avito.android.remote.interceptor.CertificatePinningInterceptorImpl;
import com.avito.android.server_time.ServerTimeSource;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CertificatePinner;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/di/module/CertificatePinningModule;", "", "Lokhttp3/CertificatePinner;", "provideCertificatePinner", "()Lokhttp3/CertificatePinner;", "Lcom/avito/android/server_time/ServerTimeSource;", "timeSource", "Lcom/avito/android/certificate_pinning/CertificatePinningErrorRouter;", "router", "Lcom/avito/android/remote/interceptor/CertificatePinningInterceptor;", "provideCertificatePinningInterceptor", "(Lcom/avito/android/server_time/ServerTimeSource;Lcom/avito/android/certificate_pinning/CertificatePinningErrorRouter;)Lcom/avito/android/remote/interceptor/CertificatePinningInterceptor;", "Lcom/avito/android/app/ActivityProvider;", "activityProvider", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "provideCertificatePinningRouter", "(Lcom/avito/android/app/ActivityProvider;Lcom/avito/android/ActivityIntentFactory;)Lcom/avito/android/certificate_pinning/CertificatePinningErrorRouter;", "", "Lcom/avito/android/certificate_pinning/Pin;", AuthSource.SEND_ABUSE, "()Ljava/util/List;", "<init>", "()V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CertificatePinningModule {
    @NotNull
    public static final CertificatePinningModule INSTANCE = new CertificatePinningModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final CertificatePinner provideCertificatePinner() {
        CertificatePinner.Builder builder = new CertificatePinner.Builder();
        for (T t : INSTANCE.a()) {
            builder.add(t.getHostPattern(), t.getHash());
        }
        return builder.build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final CertificatePinningInterceptor provideCertificatePinningInterceptor(@NotNull ServerTimeSource serverTimeSource, @NotNull CertificatePinningErrorRouter certificatePinningErrorRouter) {
        Intrinsics.checkNotNullParameter(serverTimeSource, "timeSource");
        Intrinsics.checkNotNullParameter(certificatePinningErrorRouter, "router");
        return new CertificatePinningInterceptorImpl(serverTimeSource, certificatePinningErrorRouter, INSTANCE.a(), true);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final CertificatePinningErrorRouter provideCertificatePinningRouter(@NotNull ActivityProvider activityProvider, @NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "intentFactory");
        return new CertificatePinningErrorRouterImpl(activityProvider, activityIntentFactory);
    }

    public final List<Pin> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pin("avito.ru", 1672531200, "sha256/Zh1hedUtrVdDQxf3ztZGuc6wYGYk/xxnZ/tBsfbty80="));
        arrayList.add(new Pin("*.avito.ru", 1672531200, "sha256/Zh1hedUtrVdDQxf3ztZGuc6wYGYk/xxnZ/tBsfbty80="));
        arrayList.add(new Pin("avito.ru", 1672531200, "sha256/moeH0MG5BB7vZaGnv0iyR2SHaF+IXP9nlTocCx7fO8w="));
        arrayList.add(new Pin("*.avito.ru", 1672531200, "sha256/moeH0MG5BB7vZaGnv0iyR2SHaF+IXP9nlTocCx7fO8w="));
        return arrayList;
    }
}
