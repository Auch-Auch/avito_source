package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.android.app.external.ApplicationInfoProviderImpl;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/module/ExternalApplicationsModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/external/ApplicationInfoProvider;", "provideApplicationInfoProvider", "(Landroid/app/Application;)Lcom/avito/android/app/external/ApplicationInfoProvider;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public class ExternalApplicationsModule {
    @Provides
    @Singleton
    @NotNull
    public ApplicationInfoProvider provideApplicationInfoProvider(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new ApplicationInfoProviderImpl(application);
    }
}
