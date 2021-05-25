package com.avito.android.search.filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InlineMultiselectItemBlueprint_Factory implements Factory<InlineMultiselectItemBlueprint> {
    public final Provider<InlineMultiselectItemPresenter> a;

    public InlineMultiselectItemBlueprint_Factory(Provider<InlineMultiselectItemPresenter> provider) {
        this.a = provider;
    }

    public static InlineMultiselectItemBlueprint_Factory create(Provider<InlineMultiselectItemPresenter> provider) {
        return new InlineMultiselectItemBlueprint_Factory(provider);
    }

    public static InlineMultiselectItemBlueprint newInstance(InlineMultiselectItemPresenter inlineMultiselectItemPresenter) {
        return new InlineMultiselectItemBlueprint(inlineMultiselectItemPresenter);
    }

    @Override // javax.inject.Provider
    public InlineMultiselectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
