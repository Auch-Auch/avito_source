package com.avito.android.profile.password_setting.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.SessionUpdateTrackerModule;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.profile.password_setting.PasswordSettingFragment;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/password_setting/di/PasswordSettingComponent;", "", "Lcom/avito/android/profile/password_setting/PasswordSettingFragment;", "fragment", "", "inject", "(Lcom/avito/android/profile/password_setting/PasswordSettingFragment;)V", "Factory", "profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PasswordSettingDependencies.class}, modules = {PasswordSettingModule.class, DialogModule.class, ErrorHelperModule.class, SessionUpdateTrackerModule.class})
@PerFragment
public interface PasswordSettingComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/profile/password_setting/di/PasswordSettingComponent$Factory;", "", "Lcom/avito/android/profile/password_setting/di/PasswordSettingDependencies;", "dependencies", "Landroid/app/Activity;", "activity", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Kundle;", "presenterState", "Lcom/avito/android/profile/password_setting/di/PasswordSettingComponent;", "create", "(Lcom/avito/android/profile/password_setting/di/PasswordSettingDependencies;Landroid/app/Activity;Landroid/content/res/Resources;Lcom/avito/android/util/Kundle;)Lcom/avito/android/profile/password_setting/di/PasswordSettingComponent;", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        PasswordSettingComponent create(@NotNull PasswordSettingDependencies passwordSettingDependencies, @BindsInstance @NotNull Activity activity, @BindsInstance @NotNull Resources resources, @BindsInstance @Nullable Kundle kundle);
    }

    void inject(@NotNull PasswordSettingFragment passwordSettingFragment);
}
