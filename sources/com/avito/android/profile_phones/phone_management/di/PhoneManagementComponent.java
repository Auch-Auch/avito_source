package com.avito.android.profile_phones.phone_management.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.code_confirmation.di.CodeConfirmationModule;
import com.avito.android.code_confirmation.di.CodeConfirmationSource;
import com.avito.android.di.PerActivity;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.profile_phones.phone_management.PhoneManagementActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent;", "", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementActivity;", "activity", "", "inject", "(Lcom/avito/android/profile_phones/phone_management/PhoneManagementActivity;)V", "Builder", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PhoneManagementDependencies.class}, modules = {PhoneManagementModule.class, CodeConfirmationModule.class, ErrorHelperModule.class})
@PerActivity
public interface PhoneManagementComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0012H'¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent$Builder;", "", "Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementDependencies;)Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent$Builder;", "Lcom/avito/android/util/Kundle;", "presenterState", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent$Builder;", "", "fromProfile", "withFromProfile", "(Z)Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent$Builder;", "", "src", "withSrc", "(Ljava/lang/String;)Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent$Builder;", "retry", "withRetry", "Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent;", "build", "()Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementComponent;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PhoneManagementComponent build();

        @NotNull
        Builder dependentOn(@NotNull PhoneManagementDependencies phoneManagementDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withFromProfile(@FromProfile boolean z);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withRetry(boolean z);

        @BindsInstance
        @NotNull
        Builder withSrc(@CodeConfirmationSource @NotNull String str);
    }

    void inject(@NotNull PhoneManagementActivity phoneManagementActivity);
}
