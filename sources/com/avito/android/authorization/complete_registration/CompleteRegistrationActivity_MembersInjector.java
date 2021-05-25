package com.avito.android.authorization.complete_registration;

import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CompleteRegistrationActivity_MembersInjector implements MembersInjector<CompleteRegistrationActivity> {
    public final Provider<CompleteRegistrationPresenter> a;
    public final Provider<SmartLockSaver> b;
    public final Provider<Analytics> c;

    public CompleteRegistrationActivity_MembersInjector(Provider<CompleteRegistrationPresenter> provider, Provider<SmartLockSaver> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<CompleteRegistrationActivity> create(Provider<CompleteRegistrationPresenter> provider, Provider<SmartLockSaver> provider2, Provider<Analytics> provider3) {
        return new CompleteRegistrationActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.authorization.complete_registration.CompleteRegistrationActivity.analytics")
    public static void injectAnalytics(CompleteRegistrationActivity completeRegistrationActivity, Analytics analytics) {
        completeRegistrationActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.authorization.complete_registration.CompleteRegistrationActivity.presenter")
    public static void injectPresenter(CompleteRegistrationActivity completeRegistrationActivity, CompleteRegistrationPresenter completeRegistrationPresenter) {
        completeRegistrationActivity.presenter = completeRegistrationPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.complete_registration.CompleteRegistrationActivity.smartLock")
    public static void injectSmartLock(CompleteRegistrationActivity completeRegistrationActivity, SmartLockSaver smartLockSaver) {
        completeRegistrationActivity.smartLock = smartLockSaver;
    }

    public void injectMembers(CompleteRegistrationActivity completeRegistrationActivity) {
        injectPresenter(completeRegistrationActivity, this.a.get());
        injectSmartLock(completeRegistrationActivity, this.b.get());
        injectAnalytics(completeRegistrationActivity, this.c.get());
    }
}
