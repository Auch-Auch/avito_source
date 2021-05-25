package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.MultiselectDialogPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectableItemPresenterMultiselectImpl_Factory implements Factory<SelectableItemPresenterMultiselectImpl> {
    public final Provider<MultiselectDialogPresenter> a;

    public SelectableItemPresenterMultiselectImpl_Factory(Provider<MultiselectDialogPresenter> provider) {
        this.a = provider;
    }

    public static SelectableItemPresenterMultiselectImpl_Factory create(Provider<MultiselectDialogPresenter> provider) {
        return new SelectableItemPresenterMultiselectImpl_Factory(provider);
    }

    public static SelectableItemPresenterMultiselectImpl newInstance(MultiselectDialogPresenter multiselectDialogPresenter) {
        return new SelectableItemPresenterMultiselectImpl(multiselectDialogPresenter);
    }

    @Override // javax.inject.Provider
    public SelectableItemPresenterMultiselectImpl get() {
        return newInstance(this.a.get());
    }
}
