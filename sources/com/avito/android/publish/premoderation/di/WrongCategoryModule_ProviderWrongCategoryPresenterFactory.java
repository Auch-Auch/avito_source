package com.avito.android.publish.premoderation.di;

import com.avito.android.publish.premoderation.WrongCategoryPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class WrongCategoryModule_ProviderWrongCategoryPresenterFactory implements Factory<WrongCategoryPresenter> {
    public final WrongCategoryModule a;

    public WrongCategoryModule_ProviderWrongCategoryPresenterFactory(WrongCategoryModule wrongCategoryModule) {
        this.a = wrongCategoryModule;
    }

    public static WrongCategoryModule_ProviderWrongCategoryPresenterFactory create(WrongCategoryModule wrongCategoryModule) {
        return new WrongCategoryModule_ProviderWrongCategoryPresenterFactory(wrongCategoryModule);
    }

    public static WrongCategoryPresenter providerWrongCategoryPresenter(WrongCategoryModule wrongCategoryModule) {
        return (WrongCategoryPresenter) Preconditions.checkNotNullFromProvides(wrongCategoryModule.providerWrongCategoryPresenter());
    }

    @Override // javax.inject.Provider
    public WrongCategoryPresenter get() {
        return providerWrongCategoryPresenter(this.a);
    }
}
