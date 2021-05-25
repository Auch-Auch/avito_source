package com.avito.android.advert.cpo_program;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AutotekaCpoProgramActivity_MembersInjector implements MembersInjector<AutotekaCpoProgramActivity> {
    public final Provider<AutotekaCpoProgramPresenter> a;

    public AutotekaCpoProgramActivity_MembersInjector(Provider<AutotekaCpoProgramPresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<AutotekaCpoProgramActivity> create(Provider<AutotekaCpoProgramPresenter> provider) {
        return new AutotekaCpoProgramActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.advert.cpo_program.AutotekaCpoProgramActivity.presenter")
    public static void injectPresenter(AutotekaCpoProgramActivity autotekaCpoProgramActivity, AutotekaCpoProgramPresenter autotekaCpoProgramPresenter) {
        autotekaCpoProgramActivity.presenter = autotekaCpoProgramPresenter;
    }

    public void injectMembers(AutotekaCpoProgramActivity autotekaCpoProgramActivity) {
        injectPresenter(autotekaCpoProgramActivity, this.a.get());
    }
}
