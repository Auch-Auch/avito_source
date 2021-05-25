package com.avito.android.authorization.reset_password;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ResetPasswordActivity_MembersInjector implements MembersInjector<ResetPasswordActivity> {
    public final Provider<ResetPasswordPresenter> a;
    public final Provider<DialogRouter> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<Analytics> d;

    public ResetPasswordActivity_MembersInjector(Provider<ResetPasswordPresenter> provider, Provider<DialogRouter> provider2, Provider<ActivityIntentFactory> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<ResetPasswordActivity> create(Provider<ResetPasswordPresenter> provider, Provider<DialogRouter> provider2, Provider<ActivityIntentFactory> provider3, Provider<Analytics> provider4) {
        return new ResetPasswordActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.authorization.reset_password.ResetPasswordActivity.analytics")
    public static void injectAnalytics(ResetPasswordActivity resetPasswordActivity, Analytics analytics) {
        resetPasswordActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.authorization.reset_password.ResetPasswordActivity.dialogRouter")
    public static void injectDialogRouter(ResetPasswordActivity resetPasswordActivity, DialogRouter dialogRouter) {
        resetPasswordActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.reset_password.ResetPasswordActivity.intentFactory")
    public static void injectIntentFactory(ResetPasswordActivity resetPasswordActivity, ActivityIntentFactory activityIntentFactory) {
        resetPasswordActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.reset_password.ResetPasswordActivity.presenter")
    public static void injectPresenter(ResetPasswordActivity resetPasswordActivity, ResetPasswordPresenter resetPasswordPresenter) {
        resetPasswordActivity.presenter = resetPasswordPresenter;
    }

    public void injectMembers(ResetPasswordActivity resetPasswordActivity) {
        injectPresenter(resetPasswordActivity, this.a.get());
        injectDialogRouter(resetPasswordActivity, this.b.get());
        injectIntentFactory(resetPasswordActivity, this.c.get());
        injectAnalytics(resetPasswordActivity, this.d.get());
    }
}
