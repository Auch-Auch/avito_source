package com.avito.android.delivery.map.point_info.konveyor.service.single;

import com.avito.android.delivery.utils.DrawableFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ServiceItemBlueprint_Factory implements Factory<ServiceItemBlueprint> {
    public final Provider<ServiceItemPresenter> a;
    public final Provider<DrawableFactory> b;
    public final Provider<AttributedTextFormatter> c;

    public ServiceItemBlueprint_Factory(Provider<ServiceItemPresenter> provider, Provider<DrawableFactory> provider2, Provider<AttributedTextFormatter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ServiceItemBlueprint_Factory create(Provider<ServiceItemPresenter> provider, Provider<DrawableFactory> provider2, Provider<AttributedTextFormatter> provider3) {
        return new ServiceItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static ServiceItemBlueprint newInstance(ServiceItemPresenter serviceItemPresenter, DrawableFactory drawableFactory, AttributedTextFormatter attributedTextFormatter) {
        return new ServiceItemBlueprint(serviceItemPresenter, drawableFactory, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public ServiceItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
