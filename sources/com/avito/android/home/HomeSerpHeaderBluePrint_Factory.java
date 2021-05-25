package com.avito.android.home;

import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HomeSerpHeaderBluePrint_Factory implements Factory<HomeSerpHeaderBluePrint> {
    public final Provider<SingleTextPresenter> a;

    public HomeSerpHeaderBluePrint_Factory(Provider<SingleTextPresenter> provider) {
        this.a = provider;
    }

    public static HomeSerpHeaderBluePrint_Factory create(Provider<SingleTextPresenter> provider) {
        return new HomeSerpHeaderBluePrint_Factory(provider);
    }

    public static HomeSerpHeaderBluePrint newInstance(SingleTextPresenter singleTextPresenter) {
        return new HomeSerpHeaderBluePrint(singleTextPresenter);
    }

    @Override // javax.inject.Provider
    public HomeSerpHeaderBluePrint get() {
        return newInstance(this.a.get());
    }
}
