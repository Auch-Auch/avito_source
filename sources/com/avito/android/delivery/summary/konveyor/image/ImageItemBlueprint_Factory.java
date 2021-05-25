package com.avito.android.delivery.summary.konveyor.image;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ImageItemBlueprint_Factory implements Factory<ImageItemBlueprint> {
    public final Provider<ImageItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public ImageItemBlueprint_Factory(Provider<ImageItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ImageItemBlueprint_Factory create(Provider<ImageItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new ImageItemBlueprint_Factory(provider, provider2);
    }

    public static ImageItemBlueprint newInstance(ImageItemPresenter imageItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new ImageItemBlueprint(imageItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public ImageItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
