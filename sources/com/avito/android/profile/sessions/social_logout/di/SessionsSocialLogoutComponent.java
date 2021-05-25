package com.avito.android.profile.sessions.social_logout.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutFragment;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/di/SessionsSocialLogoutComponent;", "", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutFragment;", "fragment", "", "inject", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutFragment;)V", "Factory", "profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SessionsSocialLogoutDependencies.class}, modules = {SessionsSocialLogoutModule.class, ErrorHelperModule.class})
@PerFragment
public interface SessionsSocialLogoutComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/di/SessionsSocialLogoutComponent$Factory;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$SessionParams;", "params", "Lcom/avito/android/profile/sessions/social_logout/di/SessionsSocialLogoutDependencies;", "dependencies", "Lcom/avito/android/profile/sessions/social_logout/di/SessionsSocialLogoutComponent;", "create", "(Landroid/content/res/Resources;Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$SessionParams;Lcom/avito/android/profile/sessions/social_logout/di/SessionsSocialLogoutDependencies;)Lcom/avito/android/profile/sessions/social_logout/di/SessionsSocialLogoutComponent;", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        SessionsSocialLogoutComponent create(@BindsInstance @NotNull Resources resources, @BindsInstance @NotNull SessionsSocialLogoutPresenter.SessionParams sessionParams, @NotNull SessionsSocialLogoutDependencies sessionsSocialLogoutDependencies);
    }

    void inject(@NotNull SessionsSocialLogoutFragment sessionsSocialLogoutFragment);
}
