package com.avito.android.search.filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InlineSelectItemBlueprint_Factory implements Factory<InlineSelectItemBlueprint> {
    public final Provider<InlineSelectItemPresenter> a;

    public InlineSelectItemBlueprint_Factory(Provider<InlineSelectItemPresenter> provider) {
        this.a = provider;
    }

    public static InlineSelectItemBlueprint_Factory create(Provider<InlineSelectItemPresenter> provider) {
        return new InlineSelectItemBlueprint_Factory(provider);
    }

    public static InlineSelectItemBlueprint newInstance(InlineSelectItemPresenter inlineSelectItemPresenter) {
        return new InlineSelectItemBlueprint(inlineSelectItemPresenter);
    }

    @Override // javax.inject.Provider
    public InlineSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
