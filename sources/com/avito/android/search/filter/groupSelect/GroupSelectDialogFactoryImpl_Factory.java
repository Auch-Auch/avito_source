package com.avito.android.search.filter.groupSelect;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupSelectDialogFactoryImpl_Factory implements Factory<GroupSelectDialogFactoryImpl> {
    public final Provider<GroupSelectDialogPresenter> a;
    public final Provider<Features> b;

    public GroupSelectDialogFactoryImpl_Factory(Provider<GroupSelectDialogPresenter> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static GroupSelectDialogFactoryImpl_Factory create(Provider<GroupSelectDialogPresenter> provider, Provider<Features> provider2) {
        return new GroupSelectDialogFactoryImpl_Factory(provider, provider2);
    }

    public static GroupSelectDialogFactoryImpl newInstance(GroupSelectDialogPresenter groupSelectDialogPresenter, Features features) {
        return new GroupSelectDialogFactoryImpl(groupSelectDialogPresenter, features);
    }

    @Override // javax.inject.Provider
    public GroupSelectDialogFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
