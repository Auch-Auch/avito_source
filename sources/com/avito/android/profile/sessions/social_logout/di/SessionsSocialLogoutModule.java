package com.avito.android.profile.sessions.social_logout.di;

import com.avito.android.di.PerFragment;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutInteractor;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutInteractorImpl;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenterImpl;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutResourcesProvider;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutResourcesProviderImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/di/SessionsSocialLogoutModule;", "", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenterImpl;", "impl", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter;", "bindPresenter", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenterImpl;)Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutInteractorImpl;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutInteractor;", "bindInteractor", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutInteractorImpl;)Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutInteractor;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutResourcesProviderImpl;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutResourcesProvider;", "bindResourceProvider", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutResourcesProviderImpl;)Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutResourcesProvider;", "profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SessionsSocialLogoutModule {
    @PerFragment
    @Binds
    @NotNull
    SessionsSocialLogoutInteractor bindInteractor(@NotNull SessionsSocialLogoutInteractorImpl sessionsSocialLogoutInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    SessionsSocialLogoutPresenter bindPresenter(@NotNull SessionsSocialLogoutPresenterImpl sessionsSocialLogoutPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    SessionsSocialLogoutResourcesProvider bindResourceProvider(@NotNull SessionsSocialLogoutResourcesProviderImpl sessionsSocialLogoutResourcesProviderImpl);
}
