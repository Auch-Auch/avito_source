package com.avito.android.analytics.clickstream;

import dagger.internal.Factory;
public final class ProtobufDiskEventConverter_Factory implements Factory<ProtobufDiskEventConverter> {

    public static final class a {
        public static final ProtobufDiskEventConverter_Factory a = new ProtobufDiskEventConverter_Factory();
    }

    public static ProtobufDiskEventConverter_Factory create() {
        return a.a;
    }

    public static ProtobufDiskEventConverter newInstance() {
        return new ProtobufDiskEventConverter();
    }

    @Override // javax.inject.Provider
    public ProtobufDiskEventConverter get() {
        return newInstance();
    }
}
