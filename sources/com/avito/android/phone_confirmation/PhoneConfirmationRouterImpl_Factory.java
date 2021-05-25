package com.avito.android.phone_confirmation;

import android.app.Activity;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneConfirmationRouterImpl_Factory implements Factory<PhoneConfirmationRouterImpl> {
    public final Provider<Activity> a;

    public PhoneConfirmationRouterImpl_Factory(Provider<Activity> provider) {
        this.a = provider;
    }

    public static PhoneConfirmationRouterImpl_Factory create(Provider<Activity> provider) {
        return new PhoneConfirmationRouterImpl_Factory(provider);
    }

    public static PhoneConfirmationRouterImpl newInstance(Activity activity) {
        return new PhoneConfirmationRouterImpl(activity);
    }

    @Override // javax.inject.Provider
    public PhoneConfirmationRouterImpl get() {
        return newInstance(this.a.get());
    }
}
