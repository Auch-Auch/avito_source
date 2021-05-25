package com.avito.android.advert.item.note;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsNoteBlueprint_Factory implements Factory<AdvertDetailsNoteBlueprint> {
    public final Provider<AdvertDetailsNotePresenter> a;

    public AdvertDetailsNoteBlueprint_Factory(Provider<AdvertDetailsNotePresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsNoteBlueprint_Factory create(Provider<AdvertDetailsNotePresenter> provider) {
        return new AdvertDetailsNoteBlueprint_Factory(provider);
    }

    public static AdvertDetailsNoteBlueprint newInstance(AdvertDetailsNotePresenter advertDetailsNotePresenter) {
        return new AdvertDetailsNoteBlueprint(advertDetailsNotePresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsNoteBlueprint get() {
        return newInstance(this.a.get());
    }
}
