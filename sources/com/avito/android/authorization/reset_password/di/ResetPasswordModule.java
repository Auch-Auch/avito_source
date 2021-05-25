package com.avito.android.authorization.reset_password.di;

import com.avito.android.authorization.reset_password.ResetPasswordInteractor;
import com.avito.android.authorization.reset_password.ResetPasswordInteractorImpl;
import com.avito.android.authorization.reset_password.ResetPasswordPresenter;
import com.avito.android.authorization.reset_password.ResetPasswordPresenterImpl;
import com.avito.android.authorization.reset_password.ResetPasswordResourceProvider;
import com.avito.android.authorization.reset_password.ResetPasswordResourceProviderImpl;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/authorization/reset_password/di/ResetPasswordModule;", "", "Lcom/avito/android/authorization/reset_password/ResetPasswordPresenterImpl;", "presenter", "Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter;", "bindResetPasswordPresenter", "(Lcom/avito/android/authorization/reset_password/ResetPasswordPresenterImpl;)Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter;", "Lcom/avito/android/authorization/reset_password/ResetPasswordInteractorImpl;", "interactor", "Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", "bindResetPasswordInteractor", "(Lcom/avito/android/authorization/reset_password/ResetPasswordInteractorImpl;)Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", "Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "bindResetPasswordResourceProvider", "(Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProviderImpl;)Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class})
public interface ResetPasswordModule {
    @PerActivity
    @Binds
    @NotNull
    ResetPasswordInteractor bindResetPasswordInteractor(@NotNull ResetPasswordInteractorImpl resetPasswordInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    ResetPasswordPresenter bindResetPasswordPresenter(@NotNull ResetPasswordPresenterImpl resetPasswordPresenterImpl);

    @PerActivity
    @Binds
    @NotNull
    ResetPasswordResourceProvider bindResetPasswordResourceProvider(@NotNull ResetPasswordResourceProviderImpl resetPasswordResourceProviderImpl);
}
