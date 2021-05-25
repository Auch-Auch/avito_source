package com.avito.android.shop_settings.blueprints.moderation_error;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsModerationErrorItemPresenterImpl_Factory implements Factory<ShopSettingsModerationErrorItemPresenterImpl> {
    public final Provider<AttributedTextFormatter> a;

    public ShopSettingsModerationErrorItemPresenterImpl_Factory(Provider<AttributedTextFormatter> provider) {
        this.a = provider;
    }

    public static ShopSettingsModerationErrorItemPresenterImpl_Factory create(Provider<AttributedTextFormatter> provider) {
        return new ShopSettingsModerationErrorItemPresenterImpl_Factory(provider);
    }

    public static ShopSettingsModerationErrorItemPresenterImpl newInstance(AttributedTextFormatter attributedTextFormatter) {
        return new ShopSettingsModerationErrorItemPresenterImpl(attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public ShopSettingsModerationErrorItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
