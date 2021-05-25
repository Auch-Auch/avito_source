package com.avito.android.publish.select.di;

import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SelectModule_ProvideCheckableItemPresenterFactory implements Factory<CheckableItemPresenter> {
    public final SelectModule a;

    public SelectModule_ProvideCheckableItemPresenterFactory(SelectModule selectModule) {
        this.a = selectModule;
    }

    public static SelectModule_ProvideCheckableItemPresenterFactory create(SelectModule selectModule) {
        return new SelectModule_ProvideCheckableItemPresenterFactory(selectModule);
    }

    public static CheckableItemPresenter provideCheckableItemPresenter(SelectModule selectModule) {
        return (CheckableItemPresenter) Preconditions.checkNotNullFromProvides(selectModule.provideCheckableItemPresenter());
    }

    @Override // javax.inject.Provider
    public CheckableItemPresenter get() {
        return provideCheckableItemPresenter(this.a);
    }
}
