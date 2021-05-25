package com.avito.android.profile.di;

import android.app.Activity;
import com.avito.android.di.PerActivity;
import com.avito.android.profile.di.EditProfileModule;
import com.avito.android.profile.edit.EditProfileActivity;
import com.avito.android.util.Kundle;
import com.google.gson.Gson;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/di/EditProfileComponent;", "", "Lcom/avito/android/profile/edit/EditProfileActivity;", "activity", "", "inject", "(Lcom/avito/android/profile/edit/EditProfileActivity;)V", "Builder", "profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {EditProfileDependencies.class}, modules = {EditProfileModule.class})
@PerActivity
public interface EditProfileComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00002\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00002\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\f\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00002\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/profile/di/EditProfileComponent$Builder;", "", "Lcom/avito/android/profile/di/EditProfileDependencies;", "dependencies", "(Lcom/avito/android/profile/di/EditProfileDependencies;)Lcom/avito/android/profile/di/EditProfileComponent$Builder;", "Landroid/app/Activity;", "value", "activity", "(Landroid/app/Activity;)Lcom/avito/android/profile/di/EditProfileComponent$Builder;", "Lcom/avito/android/util/Kundle;", "presenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/profile/di/EditProfileComponent$Builder;", "interactorState", "editProfileInteractorState", "Lcom/google/gson/Gson;", "gson", "withGson", "(Lcom/google/gson/Gson;)Lcom/avito/android/profile/di/EditProfileComponent$Builder;", "Lcom/avito/android/profile/di/EditProfileComponent;", "build", "()Lcom/avito/android/profile/di/EditProfileComponent;", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @NotNull
        EditProfileComponent build();

        @NotNull
        Builder dependencies(@NotNull EditProfileDependencies editProfileDependencies);

        @BindsInstance
        @NotNull
        Builder editProfileInteractorState(@EditProfileModule.EditProfileInteractorState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder interactorState(@EditProfileModule.InteractorState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder presenterState(@EditProfileModule.PresenterState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withGson(@NotNull Gson gson);
    }

    void inject(@NotNull EditProfileActivity editProfileActivity);
}
