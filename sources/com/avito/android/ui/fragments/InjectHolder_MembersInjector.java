package com.avito.android.ui.fragments;

import com.avito.android.Features;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class InjectHolder_MembersInjector implements MembersInjector<InjectHolder> {
    public final Provider<Features> a;

    public InjectHolder_MembersInjector(Provider<Features> provider) {
        this.a = provider;
    }

    public static MembersInjector<InjectHolder> create(Provider<Features> provider) {
        return new InjectHolder_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.ui.fragments.InjectHolder.features")
    public static void injectFeatures(InjectHolder injectHolder, Features features) {
        injectHolder.features = features;
    }

    public void injectMembers(InjectHolder injectHolder) {
        injectFeatures(injectHolder, this.a.get());
    }
}
