package com.avito.android.serp.adapter.title;

import dagger.internal.Factory;
public final class GroupTitleItemPresenterImpl_Factory implements Factory<GroupTitleItemPresenterImpl> {

    public static final class a {
        public static final GroupTitleItemPresenterImpl_Factory a = new GroupTitleItemPresenterImpl_Factory();
    }

    public static GroupTitleItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static GroupTitleItemPresenterImpl newInstance() {
        return new GroupTitleItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public GroupTitleItemPresenterImpl get() {
        return newInstance();
    }
}
