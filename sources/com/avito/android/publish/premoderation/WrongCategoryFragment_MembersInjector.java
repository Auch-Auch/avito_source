package com.avito.android.publish.premoderation;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class WrongCategoryFragment_MembersInjector implements MembersInjector<WrongCategoryFragment> {
    public final Provider<WrongCategoryPresenter> a;

    public WrongCategoryFragment_MembersInjector(Provider<WrongCategoryPresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<WrongCategoryFragment> create(Provider<WrongCategoryPresenter> provider) {
        return new WrongCategoryFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.publish.premoderation.WrongCategoryFragment.presenter")
    public static void injectPresenter(WrongCategoryFragment wrongCategoryFragment, WrongCategoryPresenter wrongCategoryPresenter) {
        wrongCategoryFragment.presenter = wrongCategoryPresenter;
    }

    public void injectMembers(WrongCategoryFragment wrongCategoryFragment) {
        injectPresenter(wrongCategoryFragment, this.a.get());
    }
}
