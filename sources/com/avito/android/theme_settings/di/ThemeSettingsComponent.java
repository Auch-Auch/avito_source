package com.avito.android.theme_settings.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.theme_settings.ThemeSettingsFragment;
import com.avito.android.theme_settings.item.switcher.di.SwitcherItemModule;
import com.avito.android.theme_settings.item.theme_checkmark.di.ThemeCheckmarkItemModule;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/theme_settings/di/ThemeSettingsComponent;", "", "Lcom/avito/android/theme_settings/ThemeSettingsFragment;", "fragment", "", "inject", "(Lcom/avito/android/theme_settings/ThemeSettingsFragment;)V", "Factory", "settings_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ThemeSettingsDependencies.class}, modules = {ThemeSettingsModule.class, ThemeCheckmarkItemModule.class, SwitcherItemModule.class})
@PerFragment
public interface ThemeSettingsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/theme_settings/di/ThemeSettingsComponent$Factory;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/content/Context;", "context", "Lcom/avito/android/theme_settings/di/ThemeSettingsDependencies;", "dependencies", "Lcom/avito/android/theme_settings/di/ThemeSettingsComponent;", "create", "(Landroidx/fragment/app/Fragment;Landroid/content/Context;Lcom/avito/android/theme_settings/di/ThemeSettingsDependencies;)Lcom/avito/android/theme_settings/di/ThemeSettingsComponent;", "settings_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        ThemeSettingsComponent create(@BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull Context context, @NotNull ThemeSettingsDependencies themeSettingsDependencies);
    }

    void inject(@NotNull ThemeSettingsFragment themeSettingsFragment);
}
