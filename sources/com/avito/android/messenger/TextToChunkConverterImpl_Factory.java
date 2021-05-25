package com.avito.android.messenger;

import dagger.internal.Factory;
public final class TextToChunkConverterImpl_Factory implements Factory<TextToChunkConverterImpl> {

    public static final class a {
        public static final TextToChunkConverterImpl_Factory a = new TextToChunkConverterImpl_Factory();
    }

    public static TextToChunkConverterImpl_Factory create() {
        return a.a;
    }

    public static TextToChunkConverterImpl newInstance() {
        return new TextToChunkConverterImpl();
    }

    @Override // javax.inject.Provider
    public TextToChunkConverterImpl get() {
        return newInstance();
    }
}
