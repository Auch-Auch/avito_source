package com.avito.android.authorization.start_registration;

import com.avito.android.ActivityIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class StartRegistrationActivity_MembersInjector implements MembersInjector<StartRegistrationActivity> {
    public final Provider<StartRegistrationPresenter> a;
    public final Provider<ActivityIntentFactory> b;

    public StartRegistrationActivity_MembersInjector(Provider<StartRegistrationPresenter> provider, Provider<ActivityIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<StartRegistrationActivity> create(Provider<StartRegistrationPresenter> provider, Provider<ActivityIntentFactory> provider2) {
        return new StartRegistrationActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.authorization.start_registration.StartRegistrationActivity.intentFactory")
    public static void injectIntentFactory(StartRegistrationActivity startRegistrationActivity, ActivityIntentFactory activityIntentFactory) {
        startRegistrationActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.start_registration.StartRegistrationActivity.presenter")
    public static void injectPresenter(StartRegistrationActivity startRegistrationActivity, StartRegistrationPresenter startRegistrationPresenter) {
        startRegistrationActivity.presenter = startRegistrationPresenter;
    }

    public void injectMembers(StartRegistrationActivity startRegistrationActivity) {
        injectPresenter(startRegistrationActivity, this.a.get());
        injectIntentFactory(startRegistrationActivity, this.b.get());
    }
}
