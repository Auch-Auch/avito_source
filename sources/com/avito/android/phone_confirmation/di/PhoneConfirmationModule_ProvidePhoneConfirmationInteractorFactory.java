package com.avito.android.phone_confirmation.di;

import com.avito.android.phone_confirmation.PhoneConfirmationInteractor;
import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PhoneConfirmationModule_ProvidePhoneConfirmationInteractorFactory implements Factory<PhoneConfirmationInteractor> {
    public final PhoneConfirmationModule a;
    public final Provider<Boolean> b;
    public final Provider<ProfileApi> c;
    public final Provider<TimeSource> d;
    public final Provider<PhoneConfirmationTimeStorage> e;
    public final Provider<PhoneConfirmationScreenState> f;
    public final Provider<Formatter<String>> g;

    public PhoneConfirmationModule_ProvidePhoneConfirmationInteractorFactory(PhoneConfirmationModule phoneConfirmationModule, Provider<Boolean> provider, Provider<ProfileApi> provider2, Provider<TimeSource> provider3, Provider<PhoneConfirmationTimeStorage> provider4, Provider<PhoneConfirmationScreenState> provider5, Provider<Formatter<String>> provider6) {
        this.a = phoneConfirmationModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static PhoneConfirmationModule_ProvidePhoneConfirmationInteractorFactory create(PhoneConfirmationModule phoneConfirmationModule, Provider<Boolean> provider, Provider<ProfileApi> provider2, Provider<TimeSource> provider3, Provider<PhoneConfirmationTimeStorage> provider4, Provider<PhoneConfirmationScreenState> provider5, Provider<Formatter<String>> provider6) {
        return new PhoneConfirmationModule_ProvidePhoneConfirmationInteractorFactory(phoneConfirmationModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PhoneConfirmationInteractor providePhoneConfirmationInteractor(PhoneConfirmationModule phoneConfirmationModule, boolean z, ProfileApi profileApi, TimeSource timeSource, PhoneConfirmationTimeStorage phoneConfirmationTimeStorage, PhoneConfirmationScreenState phoneConfirmationScreenState, Formatter<String> formatter) {
        return (PhoneConfirmationInteractor) Preconditions.checkNotNullFromProvides(phoneConfirmationModule.providePhoneConfirmationInteractor(z, profileApi, timeSource, phoneConfirmationTimeStorage, phoneConfirmationScreenState, formatter));
    }

    @Override // javax.inject.Provider
    public PhoneConfirmationInteractor get() {
        return providePhoneConfirmationInteractor(this.a, this.b.get().booleanValue(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
