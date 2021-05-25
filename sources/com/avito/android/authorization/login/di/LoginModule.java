package com.avito.android.authorization.login.di;

import android.content.res.Resources;
import com.avito.android.authorization.login.LoginInteractor;
import com.avito.android.authorization.login.LoginInteractorImpl;
import com.avito.android.authorization.login.LoginPresenter;
import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginResourceProvider;
import com.avito.android.authorization.login.LoginResourceProviderImpl;
import com.avito.android.authorization.reset_password.ResetPasswordInteractor;
import com.avito.android.authorization.reset_password.ResetPasswordInteractorImpl;
import com.avito.android.authorization.reset_password.ResetPasswordResourceProvider;
import com.avito.android.authorization.smart_lock.di.SmartLockSaverModule;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.model.text.AttributedTextCreator;
import com.avito.android.remote.model.text.AttributedTextCreatorImpl;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.shared_providers.SupportEmailResourceProviderImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/authorization/login/di/LoginModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "providesSupportEmailResourceProvider", "(Landroid/content/res/Resources;Lcom/avito/android/profile/ProfileInfoStorage;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "", "SUGGEST_KEY", "Ljava/lang/String;", "<init>", "()V", "Declarations", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SmartLockSaverModule.class, ErrorHelperModule.class, DialogRouterModule.class, Declarations.class, AttributedTextFormatterModule.class})
public final class LoginModule {
    @NotNull
    public static final LoginModule INSTANCE = new LoginModule();
    @NotNull
    public static final String SUGGEST_KEY = "suggest_key";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H'¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/authorization/login/di/LoginModule$Declarations;", "", "Lcom/avito/android/authorization/login/LoginPresenterImpl;", "presenter", "Lcom/avito/android/authorization/login/LoginPresenter;", "bindLoginPresenter", "(Lcom/avito/android/authorization/login/LoginPresenterImpl;)Lcom/avito/android/authorization/login/LoginPresenter;", "Lcom/avito/android/authorization/login/LoginInteractorImpl;", "interactor", "Lcom/avito/android/authorization/login/LoginInteractor;", "bindLoginInteractor", "(Lcom/avito/android/authorization/login/LoginInteractorImpl;)Lcom/avito/android/authorization/login/LoginInteractor;", "Lcom/avito/android/authorization/reset_password/ResetPasswordInteractorImpl;", "Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", "bindResetPasswordInteractor", "(Lcom/avito/android/authorization/reset_password/ResetPasswordInteractorImpl;)Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", "Lcom/avito/android/remote/model/text/AttributedTextCreatorImpl;", "creator", "Lcom/avito/android/remote/model/text/AttributedTextCreator;", "bindAttributedTextCreator", "(Lcom/avito/android/remote/model/text/AttributedTextCreatorImpl;)Lcom/avito/android/remote/model/text/AttributedTextCreator;", "Lcom/avito/android/authorization/login/LoginResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/authorization/login/LoginResourceProvider;", "bindLoginResourceProvider", "(Lcom/avito/android/authorization/login/LoginResourceProviderImpl;)Lcom/avito/android/authorization/login/LoginResourceProvider;", "Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "bindResetPasswordResourceProvider", "(Lcom/avito/android/authorization/login/LoginResourceProvider;)Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        AttributedTextCreator bindAttributedTextCreator(@NotNull AttributedTextCreatorImpl attributedTextCreatorImpl);

        @PerActivity
        @Binds
        @NotNull
        LoginInteractor bindLoginInteractor(@NotNull LoginInteractorImpl loginInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        LoginPresenter bindLoginPresenter(@NotNull LoginPresenterImpl loginPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        LoginResourceProvider bindLoginResourceProvider(@NotNull LoginResourceProviderImpl loginResourceProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        ResetPasswordInteractor bindResetPasswordInteractor(@NotNull ResetPasswordInteractorImpl resetPasswordInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        ResetPasswordResourceProvider bindResetPasswordResourceProvider(@NotNull LoginResourceProvider loginResourceProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SupportEmailResourceProvider providesSupportEmailResourceProvider(@NotNull Resources resources, @NotNull ProfileInfoStorage profileInfoStorage, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(profileInfoStorage, "profileInfoStorage");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new SupportEmailResourceProviderImpl(resources, profileInfoStorage, buildInfo);
    }
}
