package com.avito.android.profile.cards.verification_platform;

import com.avito.android.deep_linking.links.DeepLink;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class VerificationPlatformCardPresenterImpl_Factory implements Factory<VerificationPlatformCardPresenterImpl> {
    public final Provider<Consumer<DeepLink>> a;

    public VerificationPlatformCardPresenterImpl_Factory(Provider<Consumer<DeepLink>> provider) {
        this.a = provider;
    }

    public static VerificationPlatformCardPresenterImpl_Factory create(Provider<Consumer<DeepLink>> provider) {
        return new VerificationPlatformCardPresenterImpl_Factory(provider);
    }

    public static VerificationPlatformCardPresenterImpl newInstance(Consumer<DeepLink> consumer) {
        return new VerificationPlatformCardPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public VerificationPlatformCardPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
