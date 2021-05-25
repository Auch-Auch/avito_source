package com.avito.android.authorization.change_password.di;

import com.avito.android.authorization.change_password.ChangePasswordInteractor;
import com.avito.android.authorization.change_password.ChangePasswordInteractorImpl;
import com.avito.android.authorization.change_password.ChangePasswordPresenter;
import com.avito.android.authorization.change_password.ChangePasswordPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.error_helper.di.ErrorHelperModule;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/authorization/change_password/di/ChangePasswordModule;", "", "Lcom/avito/android/authorization/change_password/ChangePasswordInteractorImpl;", "interactor", "Lcom/avito/android/authorization/change_password/ChangePasswordInteractor;", "bindChangePasswordInteractor", "(Lcom/avito/android/authorization/change_password/ChangePasswordInteractorImpl;)Lcom/avito/android/authorization/change_password/ChangePasswordInteractor;", "Lcom/avito/android/authorization/change_password/ChangePasswordPresenterImpl;", "presenter", "Lcom/avito/android/authorization/change_password/ChangePasswordPresenter;", "bindChangePasswordPresenter", "(Lcom/avito/android/authorization/change_password/ChangePasswordPresenterImpl;)Lcom/avito/android/authorization/change_password/ChangePasswordPresenter;", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ErrorHelperModule.class})
public interface ChangePasswordModule {
    @PerActivity
    @Binds
    @NotNull
    ChangePasswordInteractor bindChangePasswordInteractor(@NotNull ChangePasswordInteractorImpl changePasswordInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    ChangePasswordPresenter bindChangePasswordPresenter(@NotNull ChangePasswordPresenterImpl changePasswordPresenterImpl);
}
