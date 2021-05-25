package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.util.GooglePlayServicesInfo;
import com.avito.android.util.GooglePlayServicesInfoImpl;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.GoogleApiAvailability;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/module/GooglePlayServicesInfoModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/GooglePlayServicesInfo;", "provideGooglePlayServicesInfo", "(Landroid/app/Application;)Lcom/avito/android/util/GooglePlayServicesInfo;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class GooglePlayServicesInfoModule {
    @NotNull
    public static final GooglePlayServicesInfoModule INSTANCE = new GooglePlayServicesInfoModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final GooglePlayServicesInfo provideGooglePlayServicesInfo(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "GoogleApiAvailability.getInstance()");
        return new GooglePlayServicesInfoImpl(application, instance);
    }
}
