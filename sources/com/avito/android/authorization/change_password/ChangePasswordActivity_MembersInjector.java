package com.avito.android.authorization.change_password;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ChangePasswordActivity_MembersInjector implements MembersInjector<ChangePasswordActivity> {
    public final Provider<ChangePasswordPresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<Analytics> c;

    public ChangePasswordActivity_MembersInjector(Provider<ChangePasswordPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<ChangePasswordActivity> create(Provider<ChangePasswordPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3) {
        return new ChangePasswordActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.authorization.change_password.ChangePasswordActivity.analytics")
    public static void injectAnalytics(ChangePasswordActivity changePasswordActivity, Analytics analytics) {
        changePasswordActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.authorization.change_password.ChangePasswordActivity.intentFactory")
    public static void injectIntentFactory(ChangePasswordActivity changePasswordActivity, ActivityIntentFactory activityIntentFactory) {
        changePasswordActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.change_password.ChangePasswordActivity.presenter")
    public static void injectPresenter(ChangePasswordActivity changePasswordActivity, ChangePasswordPresenter changePasswordPresenter) {
        changePasswordActivity.presenter = changePasswordPresenter;
    }

    public void injectMembers(ChangePasswordActivity changePasswordActivity) {
        injectPresenter(changePasswordActivity, this.a.get());
        injectIntentFactory(changePasswordActivity, this.b.get());
        injectAnalytics(changePasswordActivity, this.c.get());
    }
}
