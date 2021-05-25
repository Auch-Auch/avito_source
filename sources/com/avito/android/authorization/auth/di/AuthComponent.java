package com.avito.android.authorization.auth.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.authorization.auth.AuthFragment;
import com.avito.android.authorization.auth.OldAuthActivity;
import com.avito.android.authorization.auth.tracker.AuthTrackersModule;
import com.avito.android.authorization.smart_lock.di.SmartLockLoaderModule;
import com.avito.android.authorization.smart_lock.di.SmartLockState;
import com.avito.android.di.PerActivity;
import com.avito.android.performance.di.PerformanceTrackersModule;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/authorization/auth/di/AuthComponent;", "", "Lcom/avito/android/authorization/auth/OldAuthActivity;", "oldAuthActivity", "", "inject", "(Lcom/avito/android/authorization/auth/OldAuthActivity;)V", "Lcom/avito/android/authorization/auth/AuthFragment;", "authFragment", "(Lcom/avito/android/authorization/auth/AuthFragment;)V", "Builder", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AuthDependencies.class}, modules = {AuthModule.class, SmartLockLoaderModule.class, PerformanceTrackersModule.class, AuthTrackersModule.class})
@PerActivity
public interface AuthComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u00002\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00002\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0013\u0010\u0011J\u0019\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/authorization/auth/di/AuthComponent$Builder;", "", "Lcom/avito/android/authorization/auth/di/AuthDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/authorization/auth/di/AuthDependencies;)Lcom/avito/android/authorization/auth/di/AuthComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/authorization/auth/di/AuthComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/authorization/auth/di/AuthComponent$Builder;", "Lcom/avito/android/util/Kundle;", "presenterState", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/authorization/auth/di/AuthComponent$Builder;", "smartLockState", "withSmartLockState", "", "src", "withSrc", "(Ljava/lang/String;)Lcom/avito/android/authorization/auth/di/AuthComponent$Builder;", "Lcom/avito/android/authorization/auth/di/AuthComponent;", "build", "()Lcom/avito/android/authorization/auth/di/AuthComponent;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AuthComponent build();

        @NotNull
        Builder dependentOn(@NotNull AuthDependencies authDependencies);

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
        Builder withSmartLockState(@SmartLockState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withSrc(@Nullable String str);
    }

    void inject(@NotNull AuthFragment authFragment);

    void inject(@NotNull OldAuthActivity oldAuthActivity);
}
