package com.avito.android.profile.password_change.di;

import com.avito.android.profile.password_change.PasswordChangePresenter;
import com.avito.android.profile.password_change.PasswordChangePresenterImpl;
import com.avito.android.profile.password_change.PasswordChangeResourceProvider;
import com.avito.android.profile.password_change.PasswordChangeResourceProviderImpl;
import com.avito.android.profile.password_change.business.PasswordChangeInteractor;
import com.avito.android.profile.password_change.business.PasswordChangeInteractorImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile/password_change/di/PasswordChangeModule;", "", "Lcom/avito/android/profile/password_change/PasswordChangePresenterImpl;", "presenter", "Lcom/avito/android/profile/password_change/PasswordChangePresenter;", "bindPasswordChangePresenter", "(Lcom/avito/android/profile/password_change/PasswordChangePresenterImpl;)Lcom/avito/android/profile/password_change/PasswordChangePresenter;", "Lcom/avito/android/profile/password_change/business/PasswordChangeInteractorImpl;", "interactor", "Lcom/avito/android/profile/password_change/business/PasswordChangeInteractor;", "bindPasswordChangeInteractor", "(Lcom/avito/android/profile/password_change/business/PasswordChangeInteractorImpl;)Lcom/avito/android/profile/password_change/business/PasswordChangeInteractor;", "Lcom/avito/android/profile/password_change/PasswordChangeResourceProviderImpl;", "impl", "Lcom/avito/android/profile/password_change/PasswordChangeResourceProvider;", "bindPasswordChangeResourceProvider", "(Lcom/avito/android/profile/password_change/PasswordChangeResourceProviderImpl;)Lcom/avito/android/profile/password_change/PasswordChangeResourceProvider;", "profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface PasswordChangeModule {
    @Binds
    @NotNull
    PasswordChangeInteractor bindPasswordChangeInteractor(@NotNull PasswordChangeInteractorImpl passwordChangeInteractorImpl);

    @Binds
    @NotNull
    PasswordChangePresenter bindPasswordChangePresenter(@NotNull PasswordChangePresenterImpl passwordChangePresenterImpl);

    @Binds
    @NotNull
    PasswordChangeResourceProvider bindPasswordChangeResourceProvider(@NotNull PasswordChangeResourceProviderImpl passwordChangeResourceProviderImpl);
}
