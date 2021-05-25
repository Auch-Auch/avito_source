package com.avito.android.profile.cards.verification_platform;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationPlatformCardBlueprint_Factory implements Factory<VerificationPlatformCardBlueprint> {
    public final Provider<VerificationPlatformCardPresenter> a;

    public VerificationPlatformCardBlueprint_Factory(Provider<VerificationPlatformCardPresenter> provider) {
        this.a = provider;
    }

    public static VerificationPlatformCardBlueprint_Factory create(Provider<VerificationPlatformCardPresenter> provider) {
        return new VerificationPlatformCardBlueprint_Factory(provider);
    }

    public static VerificationPlatformCardBlueprint newInstance(VerificationPlatformCardPresenter verificationPlatformCardPresenter) {
        return new VerificationPlatformCardBlueprint(verificationPlatformCardPresenter);
    }

    @Override // javax.inject.Provider
    public VerificationPlatformCardBlueprint get() {
        return newInstance(this.a.get());
    }
}
