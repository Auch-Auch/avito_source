package com.avito.android.search.filter.adapter;

import com.avito.android.blueprints.CheckBoxItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CheckBoxItemBlueprint_Factory implements Factory<CheckBoxItemBlueprint> {
    public final Provider<CheckBoxItemPresenter> a;

    public CheckBoxItemBlueprint_Factory(Provider<CheckBoxItemPresenter> provider) {
        this.a = provider;
    }

    public static CheckBoxItemBlueprint_Factory create(Provider<CheckBoxItemPresenter> provider) {
        return new CheckBoxItemBlueprint_Factory(provider);
    }

    public static CheckBoxItemBlueprint newInstance(CheckBoxItemPresenter checkBoxItemPresenter) {
        return new CheckBoxItemBlueprint(checkBoxItemPresenter);
    }

    @Override // javax.inject.Provider
    public CheckBoxItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
