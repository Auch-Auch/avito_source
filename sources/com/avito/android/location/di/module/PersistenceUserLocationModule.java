package com.avito.android.location.di.module;

import com.avito.android.location.LocationInfoProvider;
import com.avito.android.location.PrefSavedLocationStorage;
import com.avito.android.location.SavedLocationMigrationHelper;
import com.avito.android.location.SavedLocationMigrationHelperImpl;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/location/di/module/PersistenceUserLocationModule;", "", "Lcom/avito/android/util/preferences/Preferences;", "prefs", "Lcom/avito/android/location/SavedLocationMigrationHelper;", "migrationHelper", "Lcom/avito/android/location/LocationInfoProvider;", "locationInfoProvider", "Lcom/avito/android/location/SavedLocationStorage;", "provideSavedLocationStorage", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/location/SavedLocationMigrationHelper;Lcom/avito/android/location/LocationInfoProvider;)Lcom/avito/android/location/SavedLocationStorage;", "provideSavedLocationMigrationHelper", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/location/SavedLocationMigrationHelper;", "<init>", "()V", "user-location_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {BackNavigationModule.class})
public final class PersistenceUserLocationModule {
    @Provides
    @NotNull
    public final SavedLocationMigrationHelper provideSavedLocationMigrationHelper(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new SavedLocationMigrationHelperImpl(preferences);
    }

    @Provides
    @NotNull
    public final SavedLocationStorage provideSavedLocationStorage(@NotNull Preferences preferences, @NotNull SavedLocationMigrationHelper savedLocationMigrationHelper, @NotNull LocationInfoProvider locationInfoProvider) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        Intrinsics.checkNotNullParameter(savedLocationMigrationHelper, "migrationHelper");
        Intrinsics.checkNotNullParameter(locationInfoProvider, "locationInfoProvider");
        return new PrefSavedLocationStorage(preferences, savedLocationMigrationHelper, locationInfoProvider);
    }
}
