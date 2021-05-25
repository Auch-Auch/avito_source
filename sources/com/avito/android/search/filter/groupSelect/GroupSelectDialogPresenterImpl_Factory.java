package com.avito.android.search.filter.groupSelect;

import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.select.group_select.GroupSelectPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupSelectDialogPresenterImpl_Factory implements Factory<GroupSelectDialogPresenterImpl> {
    public final Provider<GroupSelectPresenter> a;
    public final Provider<FiltersChangeProvider> b;

    public GroupSelectDialogPresenterImpl_Factory(Provider<GroupSelectPresenter> provider, Provider<FiltersChangeProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static GroupSelectDialogPresenterImpl_Factory create(Provider<GroupSelectPresenter> provider, Provider<FiltersChangeProvider> provider2) {
        return new GroupSelectDialogPresenterImpl_Factory(provider, provider2);
    }

    public static GroupSelectDialogPresenterImpl newInstance(GroupSelectPresenter groupSelectPresenter, FiltersChangeProvider filtersChangeProvider) {
        return new GroupSelectDialogPresenterImpl(groupSelectPresenter, filtersChangeProvider);
    }

    @Override // javax.inject.Provider
    public GroupSelectDialogPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
