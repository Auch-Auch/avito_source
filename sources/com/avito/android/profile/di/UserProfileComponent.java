package com.avito.android.profile.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.code_confirmation.di.CodeConfirmationModule;
import com.avito.android.code_confirmation.di.CodeConfirmationSource;
import com.avito.android.di.PerActivity;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.profile.UserProfileFragment;
import com.avito.android.util.UrlParams;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/di/UserProfileComponent;", "", "Lcom/avito/android/profile/UserProfileFragment;", "activity", "", "inject", "(Lcom/avito/android/profile/UserProfileFragment;)V", "Builder", "profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {UserProfileDependencies.class}, modules = {UserProfileModule.class, CodeConfirmationModule.class, DialogModule.class, ErrorHelperModule.class})
@PerActivity
public interface UserProfileComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u000e\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/profile/di/UserProfileComponent$Builder;", "", "Lcom/avito/android/profile/di/UserProfileDependencies;", "dependencies", "(Lcom/avito/android/profile/di/UserProfileDependencies;)Lcom/avito/android/profile/di/UserProfileComponent$Builder;", "Lcom/avito/android/profile/di/UserProfileModule;", "userProfileModule", "plus", "(Lcom/avito/android/profile/di/UserProfileModule;)Lcom/avito/android/profile/di/UserProfileComponent$Builder;", "Lcom/avito/android/code_confirmation/di/CodeConfirmationModule;", "codeConfirmationModule", "(Lcom/avito/android/code_confirmation/di/CodeConfirmationModule;)Lcom/avito/android/profile/di/UserProfileComponent$Builder;", "Landroid/app/Activity;", "activity", "with", "(Landroid/app/Activity;)Lcom/avito/android/profile/di/UserProfileComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/profile/di/UserProfileComponent$Builder;", "", "src", "withSrc", "(Ljava/lang/String;)Lcom/avito/android/profile/di/UserProfileComponent$Builder;", "", "retry", "withRetry", "(Z)Lcom/avito/android/profile/di/UserProfileComponent$Builder;", "Landroidx/lifecycle/ViewModelStoreOwner;", UrlParams.OWNER, "withViewModelStoreOwner", "(Landroidx/lifecycle/ViewModelStoreOwner;)Lcom/avito/android/profile/di/UserProfileComponent$Builder;", "Lcom/avito/android/profile/di/UserProfileComponent;", "build", "()Lcom/avito/android/profile/di/UserProfileComponent;", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        UserProfileComponent build();

        @NotNull
        Builder dependencies(@NotNull UserProfileDependencies userProfileDependencies);

        @NotNull
        Builder plus(@NotNull CodeConfirmationModule codeConfirmationModule);

        @NotNull
        Builder plus(@NotNull UserProfileModule userProfileModule);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withRetry(boolean z);

        @BindsInstance
        @NotNull
        Builder withSrc(@CodeConfirmationSource @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withViewModelStoreOwner(@NotNull ViewModelStoreOwner viewModelStoreOwner);
    }

    void inject(@NotNull UserProfileFragment userProfileFragment);
}
