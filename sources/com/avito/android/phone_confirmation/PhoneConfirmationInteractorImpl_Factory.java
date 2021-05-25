package com.avito.android.phone_confirmation;

import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhoneConfirmationInteractorImpl_Factory implements Factory<PhoneConfirmationInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<TimeSource> b;
    public final Provider<PhoneConfirmationTimeStorage> c;
    public final Provider<PhoneConfirmationScreenState> d;
    public final Provider<Formatter<String>> e;

    public PhoneConfirmationInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<TimeSource> provider2, Provider<PhoneConfirmationTimeStorage> provider3, Provider<PhoneConfirmationScreenState> provider4, Provider<Formatter<String>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PhoneConfirmationInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<TimeSource> provider2, Provider<PhoneConfirmationTimeStorage> provider3, Provider<PhoneConfirmationScreenState> provider4, Provider<Formatter<String>> provider5) {
        return new PhoneConfirmationInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PhoneConfirmationInteractorImpl newInstance(ProfileApi profileApi, TimeSource timeSource, PhoneConfirmationTimeStorage phoneConfirmationTimeStorage, PhoneConfirmationScreenState phoneConfirmationScreenState, Formatter<String> formatter) {
        return new PhoneConfirmationInteractorImpl(profileApi, timeSource, phoneConfirmationTimeStorage, phoneConfirmationScreenState, formatter);
    }

    @Override // javax.inject.Provider
    public PhoneConfirmationInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
