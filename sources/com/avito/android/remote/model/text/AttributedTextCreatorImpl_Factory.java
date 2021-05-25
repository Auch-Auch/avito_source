package com.avito.android.remote.model.text;

import dagger.internal.Factory;
public final class AttributedTextCreatorImpl_Factory implements Factory<AttributedTextCreatorImpl> {

    public static final class InstanceHolder {
        private static final AttributedTextCreatorImpl_Factory INSTANCE = new AttributedTextCreatorImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static AttributedTextCreatorImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AttributedTextCreatorImpl newInstance() {
        return new AttributedTextCreatorImpl();
    }

    @Override // javax.inject.Provider
    public AttributedTextCreatorImpl get() {
        return newInstance();
    }
}
