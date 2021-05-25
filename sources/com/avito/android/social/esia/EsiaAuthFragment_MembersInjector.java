package com.avito.android.social.esia;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class EsiaAuthFragment_MembersInjector implements MembersInjector<EsiaAuthFragment> {
    public final Provider<EsiaAuthPresenter> a;

    public EsiaAuthFragment_MembersInjector(Provider<EsiaAuthPresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<EsiaAuthFragment> create(Provider<EsiaAuthPresenter> provider) {
        return new EsiaAuthFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.social.esia.EsiaAuthFragment.presenter")
    public static void injectPresenter(EsiaAuthFragment esiaAuthFragment, EsiaAuthPresenter esiaAuthPresenter) {
        esiaAuthFragment.presenter = esiaAuthPresenter;
    }

    public void injectMembers(EsiaAuthFragment esiaAuthFragment) {
        injectPresenter(esiaAuthFragment, this.a.get());
    }
}
