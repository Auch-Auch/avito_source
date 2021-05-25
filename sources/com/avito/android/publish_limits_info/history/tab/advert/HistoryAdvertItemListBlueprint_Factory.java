package com.avito.android.publish_limits_info.history.tab.advert;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class HistoryAdvertItemListBlueprint_Factory implements Factory<HistoryAdvertItemListBlueprint> {
    public final Provider<HistoryAdvertItemPresenter> a;

    public HistoryAdvertItemListBlueprint_Factory(Provider<HistoryAdvertItemPresenter> provider) {
        this.a = provider;
    }

    public static HistoryAdvertItemListBlueprint_Factory create(Provider<HistoryAdvertItemPresenter> provider) {
        return new HistoryAdvertItemListBlueprint_Factory(provider);
    }

    public static HistoryAdvertItemListBlueprint newInstance(HistoryAdvertItemPresenter historyAdvertItemPresenter) {
        return new HistoryAdvertItemListBlueprint(historyAdvertItemPresenter);
    }

    @Override // javax.inject.Provider
    public HistoryAdvertItemListBlueprint get() {
        return newInstance(this.a.get());
    }
}
