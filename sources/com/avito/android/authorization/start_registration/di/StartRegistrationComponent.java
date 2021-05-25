package com.avito.android.authorization.start_registration.di;

import android.content.res.Resources;
import com.avito.android.authorization.start_registration.StartRegistrationActivity;
import com.avito.android.code_confirmation.di.CodeConfirmationModule;
import com.avito.android.code_confirmation.di.CodeConfirmationSource;
import com.avito.android.di.PerActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/authorization/start_registration/di/StartRegistrationComponent;", "", "Lcom/avito/android/authorization/start_registration/StartRegistrationActivity;", "activity", "", "inject", "(Lcom/avito/android/authorization/start_registration/StartRegistrationActivity;)V", "Builder", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {StartRegistrationDependencies.class}, modules = {StartRegistrationModule.class, CodeConfirmationModule.class})
@PerActivity
public interface StartRegistrationComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/authorization/start_registration/di/StartRegistrationComponent$Builder;", "", "Lcom/avito/android/authorization/start_registration/di/StartRegistrationDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/authorization/start_registration/di/StartRegistrationDependencies;)Lcom/avito/android/authorization/start_registration/di/StartRegistrationComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/authorization/start_registration/di/StartRegistrationComponent$Builder;", "Lcom/avito/android/util/Kundle;", "presenter", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/authorization/start_registration/di/StartRegistrationComponent$Builder;", "", "src", "withSrc", "(Ljava/lang/String;)Lcom/avito/android/authorization/start_registration/di/StartRegistrationComponent$Builder;", "", "retry", "withRetry", "(Z)Lcom/avito/android/authorization/start_registration/di/StartRegistrationComponent$Builder;", "Lcom/avito/android/authorization/start_registration/di/StartRegistrationComponent;", "build", "()Lcom/avito/android/authorization/start_registration/di/StartRegistrationComponent;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        StartRegistrationComponent build();

        @NotNull
        Builder dependentOn(@NotNull StartRegistrationDependencies startRegistrationDependencies);

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

    void inject(@NotNull StartRegistrationActivity startRegistrationActivity);
}
