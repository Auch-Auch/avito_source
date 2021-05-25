package com.avito.android.di;

import com.avito.android.TopLocationInteractor;
import com.avito.android.TopLocationInteractorImpl;
import com.avito.android.remote.LocationApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/TopLocationModule;", "", "Lcom/avito/android/remote/LocationApi;", "locationApi", "Lcom/avito/android/TopLocationInteractor;", "provideTopLocationInteractor", "(Lcom/avito/android/remote/LocationApi;)Lcom/avito/android/TopLocationInteractor;", "<init>", "()V", "top-location_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class TopLocationModule {
    @NotNull
    public static final TopLocationModule INSTANCE = new TopLocationModule();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final TopLocationInteractor provideTopLocationInteractor(@NotNull LocationApi locationApi) {
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        return new TopLocationInteractorImpl(locationApi);
    }
}
