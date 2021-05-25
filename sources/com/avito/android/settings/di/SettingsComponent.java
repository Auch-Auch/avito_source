package com.avito.android.settings.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.settings.ui.SettingsFragment;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/settings/di/SettingsComponent;", "", "Lcom/avito/android/settings/ui/SettingsFragment;", "fragment", "", "inject", "(Lcom/avito/android/settings/ui/SettingsFragment;)V", "Factory", "settings_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SettingsDependencies.class, LocationDependencies.class}, modules = {SettingsModule.class, SavedLocationInteractorModule.class})
@PerFragment
public interface SettingsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JE\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/settings/di/SettingsComponent$Factory;", "", "Lcom/avito/android/settings/di/SettingsDependencies;", "settingsDependencies", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "Lcom/avito/android/util/Kundle;", "state", "Landroid/content/res/Resources;", "resources", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", "settingsItemsStream", "Lcom/avito/android/settings/di/SettingsComponent;", "create", "(Lcom/avito/android/settings/di/SettingsDependencies;Lcom/avito/android/location/di/LocationDependencies;Lcom/avito/android/util/Kundle;Landroid/content/res/Resources;Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/settings/di/SettingsComponent;", "settings_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        SettingsComponent create(@NotNull SettingsDependencies settingsDependencies, @NotNull LocationDependencies locationDependencies, @BindsInstance @Nullable Kundle kundle, @BindsInstance @NotNull Resources resources, @BindsInstance @NotNull PublishRelay<String> publishRelay);
    }

    void inject(@NotNull SettingsFragment settingsFragment);
}
