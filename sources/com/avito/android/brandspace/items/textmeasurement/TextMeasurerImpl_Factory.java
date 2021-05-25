package com.avito.android.brandspace.items.textmeasurement;

import dagger.internal.Factory;
public final class TextMeasurerImpl_Factory implements Factory<TextMeasurerImpl> {

    public static final class a {
        public static final TextMeasurerImpl_Factory a = new TextMeasurerImpl_Factory();
    }

    public static TextMeasurerImpl_Factory create() {
        return a.a;
    }

    public static TextMeasurerImpl newInstance() {
        return new TextMeasurerImpl();
    }

    @Override // javax.inject.Provider
    public TextMeasurerImpl get() {
        return newInstance();
    }
}
