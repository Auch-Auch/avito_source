package com.avito.android.extended_profile_settings.di;

import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/extended_profile_settings/di/ExtendedProfileSettingsComponent;", "", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsFragment;", "fragment", "", "inject", "(Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsFragment;)V", "Factory", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ExtendedProfileSettingsDependencies.class}, modules = {ExtendedProfileSettingsModule.class})
@PerFragment
public interface ExtendedProfileSettingsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/extended_profile_settings/di/ExtendedProfileSettingsComponent$Factory;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/extended_profile_settings/di/ExtendedProfileSettingsDependencies;", "dependencies", "Lcom/avito/android/extended_profile_settings/di/ExtendedProfileSettingsComponent;", "create", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/extended_profile_settings/di/ExtendedProfileSettingsDependencies;)Lcom/avito/android/extended_profile_settings/di/ExtendedProfileSettingsComponent;", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        ExtendedProfileSettingsComponent create(@BindsInstance @NotNull Fragment fragment, @NotNull ExtendedProfileSettingsDependencies extendedProfileSettingsDependencies);
    }

    void inject(@NotNull ExtendedProfileSettingsFragment extendedProfileSettingsFragment);
}
