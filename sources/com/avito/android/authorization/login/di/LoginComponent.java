package com.avito.android.authorization.login.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.authorization.login.LoginActivity;
import com.avito.android.authorization.smart_lock.di.SmartLockSaverState;
import com.avito.android.code_confirmation.di.CodeConfirmationModule;
import com.avito.android.code_confirmation.di.CodeConfirmationSource;
import com.avito.android.di.PerActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/login/di/LoginComponent;", "", "Lcom/avito/android/authorization/login/LoginActivity;", "activity", "", "inject", "(Lcom/avito/android/authorization/login/LoginActivity;)V", "Builder", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {LoginDependencies.class}, modules = {LoginModule.class, CodeConfirmationModule.class})
@PerActivity
public interface LoginComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u00002\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00002\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u0017\u001a\u00020\u0013H'¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/authorization/login/di/LoginComponent$Builder;", "", "Lcom/avito/android/authorization/login/di/LoginDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/authorization/login/di/LoginDependencies;)Lcom/avito/android/authorization/login/di/LoginComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/authorization/login/di/LoginComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/authorization/login/di/LoginComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/authorization/login/di/LoginComponent$Builder;", "withSmartLockSaverState", "", "src", "withSrc", "(Ljava/lang/String;)Lcom/avito/android/authorization/login/di/LoginComponent$Builder;", "suggestKey", "withSuggestKey", "", "retry", "withRetry", "(Z)Lcom/avito/android/authorization/login/di/LoginComponent$Builder;", "Lcom/avito/android/authorization/login/di/LoginComponent;", "build", "()Lcom/avito/android/authorization/login/di/LoginComponent;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        LoginComponent build();

        @NotNull
        Builder dependentOn(@NotNull LoginDependencies loginDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@PresenterState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withRetry(boolean z);

        @BindsInstance
        @NotNull
        Builder withSmartLockSaverState(@SmartLockSaverState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withSrc(@CodeConfirmationSource @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withSuggestKey(@Named("suggest_key") @NotNull String str);
    }

    void inject(@NotNull LoginActivity loginActivity);
}
