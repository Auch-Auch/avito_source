package com.avito.android.util.text;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory implements Factory<AttributedTextFormatter> {

    public static final class a {
        public static final AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory a = new AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory();
    }

    public static AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory create() {
        return a.a;
    }

    public static AttributedTextFormatter provideAttributedTextFormatter() {
        return (AttributedTextFormatter) Preconditions.checkNotNullFromProvides(AttributedTextFormatterModule.INSTANCE.provideAttributedTextFormatter());
    }

    @Override // javax.inject.Provider
    public AttributedTextFormatter get() {
        return provideAttributedTextFormatter();
    }
}
