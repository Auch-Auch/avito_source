package com.avito.android.booking.item.subtitle;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SubtitleItemBlueprint_Factory implements Factory<SubtitleItemBlueprint> {
    public final Provider<SubtitleItemPresenter> a;

    public SubtitleItemBlueprint_Factory(Provider<SubtitleItemPresenter> provider) {
        this.a = provider;
    }

    public static SubtitleItemBlueprint_Factory create(Provider<SubtitleItemPresenter> provider) {
        return new SubtitleItemBlueprint_Factory(provider);
    }

    public static SubtitleItemBlueprint newInstance(SubtitleItemPresenter subtitleItemPresenter) {
        return new SubtitleItemBlueprint(subtitleItemPresenter);
    }

    @Override // javax.inject.Provider
    public SubtitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
