package com.avito.android.authorization.start_registration.di;

import com.avito.android.authorization.reset_password.ResetPasswordResourceProvider;
import com.avito.android.authorization.reset_password.ResetPasswordResourceProviderImpl;
import com.avito.android.authorization.start_registration.StartRegistrationInteractor;
import com.avito.android.authorization.start_registration.StartRegistrationInteractorImpl;
import com.avito.android.authorization.start_registration.StartRegistrationPresenter;
import com.avito.android.authorization.start_registration.StartRegistrationPresenterImpl;
import com.avito.android.di.PerActivity;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/start_registration/di/StartRegistrationModule;", "", "Lcom/avito/android/authorization/start_registration/StartRegistrationInteractorImpl;", "interactor", "Lcom/avito/android/authorization/start_registration/StartRegistrationInteractor;", "bindStartRegistrationInteractor", "(Lcom/avito/android/authorization/start_registration/StartRegistrationInteractorImpl;)Lcom/avito/android/authorization/start_registration/StartRegistrationInteractor;", "Lcom/avito/android/authorization/start_registration/StartRegistrationPresenterImpl;", "presenter", "Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter;", "bindStartRegistrationPresenter", "(Lcom/avito/android/authorization/start_registration/StartRegistrationPresenterImpl;)Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter;", "Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProviderImpl;", "Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "bindResetPasswordResourceProvider", "(Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProviderImpl;)Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface StartRegistrationModule {
    @PerActivity
    @Binds
    @NotNull
    ResetPasswordResourceProvider bindResetPasswordResourceProvider(@NotNull ResetPasswordResourceProviderImpl resetPasswordResourceProviderImpl);

    @PerActivity
    @Binds
    @NotNull
    StartRegistrationInteractor bindStartRegistrationInteractor(@NotNull StartRegistrationInteractorImpl startRegistrationInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    StartRegistrationPresenter bindStartRegistrationPresenter(@NotNull StartRegistrationPresenterImpl startRegistrationPresenterImpl);
}
