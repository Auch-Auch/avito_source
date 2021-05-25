package com.avito.android.publish.slots.profile_info.item;

import dagger.internal.Factory;
public final class UserInfoItemPresenterImpl_Factory implements Factory<UserInfoItemPresenterImpl> {

    public static final class a {
        public static final UserInfoItemPresenterImpl_Factory a = new UserInfoItemPresenterImpl_Factory();
    }

    public static UserInfoItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static UserInfoItemPresenterImpl newInstance() {
        return new UserInfoItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public UserInfoItemPresenterImpl get() {
        return newInstance();
    }
}
