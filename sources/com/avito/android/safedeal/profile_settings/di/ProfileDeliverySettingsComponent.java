package com.avito.android.safedeal.profile_settings.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsComponent;", "", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsFragment;", "fragment", "", "inject", "(Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsFragment;)V", "Builder", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ProfileDeliverySettingsDependencies.class}, modules = {ProfileDeliverySettingsModule.class})
@PerFragment
public interface ProfileDeliverySettingsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsComponent$Builder;", "", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsComponent$Builder;", "Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsDependencies;", "deps", "deliveryProfileSettingsDependencies", "(Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsDependencies;)Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsComponent$Builder;", "Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsComponent;", "build", "()Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsComponent;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @NotNull
        ProfileDeliverySettingsComponent build();

        @NotNull
        Builder deliveryProfileSettingsDependencies(@NotNull ProfileDeliverySettingsDependencies profileDeliverySettingsDependencies);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull ProfileDeliverySettingsFragment profileDeliverySettingsFragment);
}
