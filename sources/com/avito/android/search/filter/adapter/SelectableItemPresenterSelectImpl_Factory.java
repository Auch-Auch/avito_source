package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.SelectDialogPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectableItemPresenterSelectImpl_Factory implements Factory<SelectableItemPresenterSelectImpl> {
    public final Provider<SelectDialogPresenter> a;

    public SelectableItemPresenterSelectImpl_Factory(Provider<SelectDialogPresenter> provider) {
        this.a = provider;
    }

    public static SelectableItemPresenterSelectImpl_Factory create(Provider<SelectDialogPresenter> provider) {
        return new SelectableItemPresenterSelectImpl_Factory(provider);
    }

    public static SelectableItemPresenterSelectImpl newInstance(SelectDialogPresenter selectDialogPresenter) {
        return new SelectableItemPresenterSelectImpl(selectDialogPresenter);
    }

    @Override // javax.inject.Provider
    public SelectableItemPresenterSelectImpl get() {
        return newInstance(this.a.get());
    }
}
