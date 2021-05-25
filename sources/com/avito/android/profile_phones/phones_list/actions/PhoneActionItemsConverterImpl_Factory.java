package com.avito.android.profile_phones.phones_list.actions;

import dagger.internal.Factory;
public final class PhoneActionItemsConverterImpl_Factory implements Factory<PhoneActionItemsConverterImpl> {

    public static final class a {
        public static final PhoneActionItemsConverterImpl_Factory a = new PhoneActionItemsConverterImpl_Factory();
    }

    public static PhoneActionItemsConverterImpl_Factory create() {
        return a.a;
    }

    public static PhoneActionItemsConverterImpl newInstance() {
        return new PhoneActionItemsConverterImpl();
    }

    @Override // javax.inject.Provider
    public PhoneActionItemsConverterImpl get() {
        return newInstance();
    }
}
