package com.avito.android.viewed_items.adapter;

import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class ViewedItemsBlueprint_Factory implements Factory<ViewedItemsBlueprint> {
    public final Provider<ViewedItemsListPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;

    public ViewedItemsBlueprint_Factory(Provider<ViewedItemsListPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ViewedItemsBlueprint_Factory create(Provider<ViewedItemsListPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3) {
        return new ViewedItemsBlueprint_Factory(provider, provider2, provider3);
    }

    public static ViewedItemsBlueprint newInstance(ViewedItemsListPresenter viewedItemsListPresenter, TimeSource timeSource, Locale locale) {
        return new ViewedItemsBlueprint(viewedItemsListPresenter, timeSource, locale);
    }

    @Override // javax.inject.Provider
    public ViewedItemsBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
