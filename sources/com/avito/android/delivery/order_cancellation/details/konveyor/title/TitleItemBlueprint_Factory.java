package com.avito.android.delivery.order_cancellation.details.konveyor.title;

import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TitleItemBlueprint_Factory implements Factory<TitleItemBlueprint> {
    public final Provider<TitlePresenter> a;

    public TitleItemBlueprint_Factory(Provider<TitlePresenter> provider) {
        this.a = provider;
    }

    public static TitleItemBlueprint_Factory create(Provider<TitlePresenter> provider) {
        return new TitleItemBlueprint_Factory(provider);
    }

    public static TitleItemBlueprint newInstance(TitlePresenter titlePresenter) {
        return new TitleItemBlueprint(titlePresenter);
    }

    @Override // javax.inject.Provider
    public TitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
