package com.avito.android.authorization.phone_proving;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhoneProvingActivity_MembersInjector implements MembersInjector<PhoneProvingActivity> {
    public final Provider<PhoneProvingPresenter> a;
    public final Provider<DeepLinkIntentFactory> b;

    public PhoneProvingActivity_MembersInjector(Provider<PhoneProvingPresenter> provider, Provider<DeepLinkIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<PhoneProvingActivity> create(Provider<PhoneProvingPresenter> provider, Provider<DeepLinkIntentFactory> provider2) {
        return new PhoneProvingActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.authorization.phone_proving.PhoneProvingActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PhoneProvingActivity phoneProvingActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        phoneProvingActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.phone_proving.PhoneProvingActivity.presenter")
    public static void injectPresenter(PhoneProvingActivity phoneProvingActivity, PhoneProvingPresenter phoneProvingPresenter) {
        phoneProvingActivity.presenter = phoneProvingPresenter;
    }

    public void injectMembers(PhoneProvingActivity phoneProvingActivity) {
        injectPresenter(phoneProvingActivity, this.a.get());
        injectDeepLinkIntentFactory(phoneProvingActivity, this.b.get());
    }
}
