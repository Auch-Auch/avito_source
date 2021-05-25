package com.avito.android.delivery.map.point_info.konveyor.service.multiple;

import com.avito.android.delivery.utils.DrawableFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MultiServiceItemBlueprint_Factory implements Factory<MultiServiceItemBlueprint> {
    public final Provider<MultiServiceItemPresenter> a;
    public final Provider<DrawableFactory> b;
    public final Provider<AttributedTextFormatter> c;

    public MultiServiceItemBlueprint_Factory(Provider<MultiServiceItemPresenter> provider, Provider<DrawableFactory> provider2, Provider<AttributedTextFormatter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MultiServiceItemBlueprint_Factory create(Provider<MultiServiceItemPresenter> provider, Provider<DrawableFactory> provider2, Provider<AttributedTextFormatter> provider3) {
        return new MultiServiceItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static MultiServiceItemBlueprint newInstance(MultiServiceItemPresenter multiServiceItemPresenter, DrawableFactory drawableFactory, AttributedTextFormatter attributedTextFormatter) {
        return new MultiServiceItemBlueprint(multiServiceItemPresenter, drawableFactory, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public MultiServiceItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
