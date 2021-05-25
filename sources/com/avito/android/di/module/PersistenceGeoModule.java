package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.geo.GeoStorage;
import com.avito.android.geo.PrefGeoStorage;
import com.avito.android.util.preferences.Names;
import com.avito.android.util.preferences.PreferenceFactory;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/di/module/PersistenceGeoModule;", "", "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "Landroid/app/Application;", "context", "Lcom/avito/android/geo/GeoStorage;", "provideGeoStorage", "(Lcom/avito/android/util/preferences/PreferenceFactory;Landroid/app/Application;)Lcom/avito/android/geo/GeoStorage;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PersistenceGeoModule {
    @Provides
    @Singleton
    @NotNull
    public final GeoStorage provideGeoStorage(@NotNull PreferenceFactory preferenceFactory, @NotNull Application application) {
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        Intrinsics.checkNotNullParameter(application, "context");
        return new PrefGeoStorage(preferenceFactory.getCustomPreferences(application, Names.GEO));
    }
}
