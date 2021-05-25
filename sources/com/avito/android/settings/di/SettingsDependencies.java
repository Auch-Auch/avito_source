package com.avito.android.settings.di;

import com.avito.android.DebugIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.SearchApi;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/settings/di/SettingsDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "()Lcom/avito/android/remote/DeviceIdProvider;", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "()Lcom/avito/android/profile/ProfileInfoStorage;", "Lcom/avito/android/DebugIntentFactory;", "debugIntentFactory", "()Lcom/avito/android/DebugIntentFactory;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "()Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/remote/SearchApi;", "searchApi", "()Lcom/avito/android/remote/SearchApi;", "Lcom/avito/android/lib/util/DarkThemeManager;", "darkThemeManager", "()Lcom/avito/android/lib/util/DarkThemeManager;", "Lcom/avito/android/lib/util/DarkThemeConfig;", "darkThemeConfig", "()Lcom/avito/android/lib/util/DarkThemeConfig;", "settings_release"}, k = 1, mv = {1, 4, 2})
public interface SettingsDependencies extends CoreComponentDependencies {
    @NotNull
    DarkThemeConfig darkThemeConfig();

    @NotNull
    DarkThemeManager darkThemeManager();

    @NotNull
    DebugIntentFactory debugIntentFactory();

    @NotNull
    DeviceIdProvider deviceIdProvider();

    @Override // com.avito.android.push.MessagingDependencies, com.avito.android.app_rater.di.AppRaterDependencies
    @NotNull
    Preferences preferences();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    ProfileInfoStorage profileInfoStorage();

    @Override // com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    SearchApi searchApi();
}
