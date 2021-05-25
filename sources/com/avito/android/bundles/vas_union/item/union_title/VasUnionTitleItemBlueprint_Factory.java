package com.avito.android.bundles.vas_union.item.union_title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasUnionTitleItemBlueprint_Factory implements Factory<VasUnionTitleItemBlueprint> {
    public final Provider<VasUnionTitleItemPresenter> a;

    public VasUnionTitleItemBlueprint_Factory(Provider<VasUnionTitleItemPresenter> provider) {
        this.a = provider;
    }

    public static VasUnionTitleItemBlueprint_Factory create(Provider<VasUnionTitleItemPresenter> provider) {
        return new VasUnionTitleItemBlueprint_Factory(provider);
    }

    public static VasUnionTitleItemBlueprint newInstance(VasUnionTitleItemPresenter vasUnionTitleItemPresenter) {
        return new VasUnionTitleItemBlueprint(vasUnionTitleItemPresenter);
    }

    @Override // javax.inject.Provider
    public VasUnionTitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
