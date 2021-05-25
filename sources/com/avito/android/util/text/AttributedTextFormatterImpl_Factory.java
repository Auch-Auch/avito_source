package com.avito.android.util.text;

import dagger.internal.Factory;
public final class AttributedTextFormatterImpl_Factory implements Factory<AttributedTextFormatterImpl> {

    public static final class a {
        public static final AttributedTextFormatterImpl_Factory a = new AttributedTextFormatterImpl_Factory();
    }

    public static AttributedTextFormatterImpl_Factory create() {
        return a.a;
    }

    public static AttributedTextFormatterImpl newInstance() {
        return new AttributedTextFormatterImpl();
    }

    @Override // javax.inject.Provider
    public AttributedTextFormatterImpl get() {
        return newInstance();
    }
}
