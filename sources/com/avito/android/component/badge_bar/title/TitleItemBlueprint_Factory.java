package com.avito.android.component.badge_bar.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TitleItemBlueprint_Factory implements Factory<TitleItemBlueprint> {
    public final Provider<TitleItemPresenter> a;

    public TitleItemBlueprint_Factory(Provider<TitleItemPresenter> provider) {
        this.a = provider;
    }

    public static TitleItemBlueprint_Factory create(Provider<TitleItemPresenter> provider) {
        return new TitleItemBlueprint_Factory(provider);
    }

    public static TitleItemBlueprint newInstance(TitleItemPresenter titleItemPresenter) {
        return new TitleItemBlueprint(titleItemPresenter);
    }

    @Override // javax.inject.Provider
    public TitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
