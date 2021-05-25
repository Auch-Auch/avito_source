package com.avito.android.messenger.util;

import dagger.internal.Factory;
public final class EntityConverterImpl_Factory implements Factory<EntityConverterImpl> {

    public static final class a {
        public static final EntityConverterImpl_Factory a = new EntityConverterImpl_Factory();
    }

    public static EntityConverterImpl_Factory create() {
        return a.a;
    }

    public static EntityConverterImpl newInstance() {
        return new EntityConverterImpl();
    }

    @Override // javax.inject.Provider
    public EntityConverterImpl get() {
        return newInstance();
    }
}
