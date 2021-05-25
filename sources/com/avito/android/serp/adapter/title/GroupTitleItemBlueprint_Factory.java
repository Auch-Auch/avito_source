package com.avito.android.serp.adapter.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupTitleItemBlueprint_Factory implements Factory<GroupTitleItemBlueprint> {
    public final Provider<GroupTitleItemPresenter> a;

    public GroupTitleItemBlueprint_Factory(Provider<GroupTitleItemPresenter> provider) {
        this.a = provider;
    }

    public static GroupTitleItemBlueprint_Factory create(Provider<GroupTitleItemPresenter> provider) {
        return new GroupTitleItemBlueprint_Factory(provider);
    }

    public static GroupTitleItemBlueprint newInstance(GroupTitleItemPresenter groupTitleItemPresenter) {
        return new GroupTitleItemBlueprint(groupTitleItemPresenter);
    }

    @Override // javax.inject.Provider
    public GroupTitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
