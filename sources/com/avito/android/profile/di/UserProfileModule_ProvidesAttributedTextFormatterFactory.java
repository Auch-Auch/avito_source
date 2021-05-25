package com.avito.android.profile.di;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserProfileModule_ProvidesAttributedTextFormatterFactory implements Factory<AttributedTextFormatter> {
    public final UserProfileModule a;

    public UserProfileModule_ProvidesAttributedTextFormatterFactory(UserProfileModule userProfileModule) {
        this.a = userProfileModule;
    }

    public static UserProfileModule_ProvidesAttributedTextFormatterFactory create(UserProfileModule userProfileModule) {
        return new UserProfileModule_ProvidesAttributedTextFormatterFactory(userProfileModule);
    }

    public static AttributedTextFormatter providesAttributedTextFormatter(UserProfileModule userProfileModule) {
        return (AttributedTextFormatter) Preconditions.checkNotNullFromProvides(userProfileModule.providesAttributedTextFormatter());
    }

    @Override // javax.inject.Provider
    public AttributedTextFormatter get() {
        return providesAttributedTextFormatter(this.a);
    }
}
