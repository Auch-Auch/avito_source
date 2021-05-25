package com.avito.android.user_stats.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserStatsPlotModule_ProvideAdapterFactory implements Factory<SimpleAdapterPresenter> {
    public final Provider<ItemBinder> a;

    public UserStatsPlotModule_ProvideAdapterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static UserStatsPlotModule_ProvideAdapterFactory create(Provider<ItemBinder> provider) {
        return new UserStatsPlotModule_ProvideAdapterFactory(provider);
    }

    public static SimpleAdapterPresenter provideAdapter(ItemBinder itemBinder) {
        return (SimpleAdapterPresenter) Preconditions.checkNotNullFromProvides(UserStatsPlotModule.INSTANCE.provideAdapter(itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleAdapterPresenter get() {
        return provideAdapter(this.a.get());
    }
}
