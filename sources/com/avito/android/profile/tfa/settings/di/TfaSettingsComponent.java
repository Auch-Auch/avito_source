package com.avito.android.profile.tfa.settings.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.profile.tfa.settings.TfaSettingsFragment;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/tfa/settings/di/TfaSettingsComponent;", "", "Lcom/avito/android/profile/tfa/settings/TfaSettingsFragment;", "fragment", "", "inject", "(Lcom/avito/android/profile/tfa/settings/TfaSettingsFragment;)V", "Factory", "profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {TfaSettingsDependencies.class}, modules = {TfaSettingsModule.class, ErrorHelperModule.class})
@PerFragment
public interface TfaSettingsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/profile/tfa/settings/di/TfaSettingsComponent$Factory;", "", "Landroid/app/Activity;", "activity", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Kundle;", "presenterState", "Lcom/avito/android/profile/tfa/settings/di/TfaSettingsDependencies;", "dependencies", "Lcom/avito/android/profile/tfa/settings/di/TfaSettingsComponent;", "create", "(Landroid/app/Activity;Landroid/content/res/Resources;Lcom/avito/android/util/Kundle;Lcom/avito/android/profile/tfa/settings/di/TfaSettingsDependencies;)Lcom/avito/android/profile/tfa/settings/di/TfaSettingsComponent;", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        TfaSettingsComponent create(@BindsInstance @NotNull Activity activity, @BindsInstance @NotNull Resources resources, @BindsInstance @NotNull Kundle kundle, @NotNull TfaSettingsDependencies tfaSettingsDependencies);
    }

    void inject(@NotNull TfaSettingsFragment tfaSettingsFragment);
}
