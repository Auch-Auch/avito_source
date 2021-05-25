package com.avito.android.booking.item.picture;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PictureItemBlueprint_Factory implements Factory<PictureItemBlueprint> {
    public final Provider<PictureItemPresenter> a;

    public PictureItemBlueprint_Factory(Provider<PictureItemPresenter> provider) {
        this.a = provider;
    }

    public static PictureItemBlueprint_Factory create(Provider<PictureItemPresenter> provider) {
        return new PictureItemBlueprint_Factory(provider);
    }

    public static PictureItemBlueprint newInstance(PictureItemPresenter pictureItemPresenter) {
        return new PictureItemBlueprint(pictureItemPresenter);
    }

    @Override // javax.inject.Provider
    public PictureItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
