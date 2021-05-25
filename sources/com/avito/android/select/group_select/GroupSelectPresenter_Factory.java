package com.avito.android.select.group_select;

import dagger.internal.Factory;
public final class GroupSelectPresenter_Factory implements Factory<GroupSelectPresenter> {

    public static final class a {
        public static final GroupSelectPresenter_Factory a = new GroupSelectPresenter_Factory();
    }

    public static GroupSelectPresenter_Factory create() {
        return a.a;
    }

    public static GroupSelectPresenter newInstance() {
        return new GroupSelectPresenter();
    }

    @Override // javax.inject.Provider
    public GroupSelectPresenter get() {
        return newInstance();
    }
}
