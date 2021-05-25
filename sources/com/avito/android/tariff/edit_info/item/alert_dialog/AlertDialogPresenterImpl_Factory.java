package com.avito.android.tariff.edit_info.item.alert_dialog;

import dagger.internal.Factory;
public final class AlertDialogPresenterImpl_Factory implements Factory<AlertDialogPresenterImpl> {

    public static final class a {
        public static final AlertDialogPresenterImpl_Factory a = new AlertDialogPresenterImpl_Factory();
    }

    public static AlertDialogPresenterImpl_Factory create() {
        return a.a;
    }

    public static AlertDialogPresenterImpl newInstance() {
        return new AlertDialogPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AlertDialogPresenterImpl get() {
        return newInstance();
    }
}
