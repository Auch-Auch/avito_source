package com.avito.android.user_stats.di;

import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class UserStatsTabModule_ProvideItemPresentersSetFactory implements Factory<Set<ItemPresenter<?, ?>>> {
    public final Provider<ChartItemPresenter> a;
    public final Provider<DescriptionItemPresenter> b;

    public UserStatsTabModule_ProvideItemPresentersSetFactory(Provider<ChartItemPresenter> provider, Provider<DescriptionItemPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserStatsTabModule_ProvideItemPresentersSetFactory create(Provider<ChartItemPresenter> provider, Provider<DescriptionItemPresenter> provider2) {
        return new UserStatsTabModule_ProvideItemPresentersSetFactory(provider, provider2);
    }

    public static Set<ItemPresenter<?, ?>> provideItemPresentersSet(ChartItemPresenter chartItemPresenter, DescriptionItemPresenter descriptionItemPresenter) {
        return (Set) Preconditions.checkNotNullFromProvides(UserStatsTabModule.INSTANCE.provideItemPresentersSet(chartItemPresenter, descriptionItemPresenter));
    }

    @Override // javax.inject.Provider
    public Set<ItemPresenter<?, ?>> get() {
        return provideItemPresentersSet(this.a.get(), this.b.get());
    }
}
