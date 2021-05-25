package com.avito.android.photo_wizard.converter;

import dagger.internal.Factory;
public final class DocumentTypesConverterImpl_Factory implements Factory<DocumentTypesConverterImpl> {

    public static final class a {
        public static final DocumentTypesConverterImpl_Factory a = new DocumentTypesConverterImpl_Factory();
    }

    public static DocumentTypesConverterImpl_Factory create() {
        return a.a;
    }

    public static DocumentTypesConverterImpl newInstance() {
        return new DocumentTypesConverterImpl();
    }

    @Override // javax.inject.Provider
    public DocumentTypesConverterImpl get() {
        return newInstance();
    }
}
