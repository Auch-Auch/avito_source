package com.avito.android.shop.awards.di;

import com.avito.android.shop.awards.item.action.ActionClickProvider;
import com.avito.android.shop.awards.item.action.ActionItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AwardsModule_ProvideActionItemPresenterFactory implements Factory<ActionItemPresenter> {
    public final Provider<ActionClickProvider> a;

    public AwardsModule_ProvideActionItemPresenterFactory(Provider<ActionClickProvider> provider) {
        this.a = provider;
    }

    public static AwardsModule_ProvideActionItemPresenterFactory create(Provider<ActionClickProvider> provider) {
        return new AwardsModule_ProvideActionItemPresenterFactory(provider);
    }

    public static ActionItemPresenter provideActionItemPresenter(ActionClickProvider actionClickProvider) {
        return (ActionItemPresenter) Preconditions.checkNotNullFromProvides(AwardsModule.provideActionItemPresenter(actionClickProvider));
    }

    @Override // javax.inject.Provider
    public ActionItemPresenter get() {
        return provideActionItemPresenter(this.a.get());
    }
}
