package com.avito.android.brandspace.items.textmeasurement;

import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
public final class ItemsMeasurerImpl_Factory implements Factory<ItemsMeasurerImpl> {
    public final Provider<Map<Class<?>, Provider<TextItemMeasurer<?>>>> a;
    public final Provider<SchedulersFactory3> b;

    public ItemsMeasurerImpl_Factory(Provider<Map<Class<?>, Provider<TextItemMeasurer<?>>>> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ItemsMeasurerImpl_Factory create(Provider<Map<Class<?>, Provider<TextItemMeasurer<?>>>> provider, Provider<SchedulersFactory3> provider2) {
        return new ItemsMeasurerImpl_Factory(provider, provider2);
    }

    public static ItemsMeasurerImpl newInstance(Map<Class<?>, Provider<TextItemMeasurer<?>>> map, SchedulersFactory3 schedulersFactory3) {
        return new ItemsMeasurerImpl(map, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ItemsMeasurerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
