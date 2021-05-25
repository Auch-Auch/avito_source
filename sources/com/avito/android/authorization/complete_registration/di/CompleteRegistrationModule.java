package com.avito.android.authorization.complete_registration.di;

import com.avito.android.authorization.complete_registration.CompleteRegistrationInteractor;
import com.avito.android.authorization.complete_registration.CompleteRegistrationInteractorImpl;
import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter;
import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenterImpl;
import com.avito.android.authorization.smart_lock.di.SmartLockSaverModule;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/authorization/complete_registration/di/CompleteRegistrationModule;", "", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractorImpl;", "interactor", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractor;", "bindCompleteRegistrationInteractor", "(Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractorImpl;)Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractor;", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenterImpl;", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter;", "bindCompleteRegistrationPresenter", "(Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenterImpl;)Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter;", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SmartLockSaverModule.class, DialogRouterModule.class})
public interface CompleteRegistrationModule {
    @PerActivity
    @Binds
    @NotNull
    CompleteRegistrationInteractor bindCompleteRegistrationInteractor(@NotNull CompleteRegistrationInteractorImpl completeRegistrationInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    CompleteRegistrationPresenter bindCompleteRegistrationPresenter(@NotNull CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl);
}
