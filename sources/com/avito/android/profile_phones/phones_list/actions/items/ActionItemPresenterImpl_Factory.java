package com.avito.android.profile_phones.phones_list.actions.items;

import dagger.internal.Factory;
public final class ActionItemPresenterImpl_Factory implements Factory<ActionItemPresenterImpl> {

    public static final class a {
        public static final ActionItemPresenterImpl_Factory a = new ActionItemPresenterImpl_Factory();
    }

    public static ActionItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ActionItemPresenterImpl newInstance() {
        return new ActionItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ActionItemPresenterImpl get() {
        return newInstance();
    }
}
