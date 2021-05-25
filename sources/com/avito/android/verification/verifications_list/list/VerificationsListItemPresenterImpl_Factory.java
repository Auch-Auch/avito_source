package com.avito.android.verification.verifications_list.list;

import dagger.internal.Factory;
public final class VerificationsListItemPresenterImpl_Factory implements Factory<VerificationsListItemPresenterImpl> {

    public static final class a {
        public static final VerificationsListItemPresenterImpl_Factory a = new VerificationsListItemPresenterImpl_Factory();
    }

    public static VerificationsListItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static VerificationsListItemPresenterImpl newInstance() {
        return new VerificationsListItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public VerificationsListItemPresenterImpl get() {
        return newInstance();
    }
}
