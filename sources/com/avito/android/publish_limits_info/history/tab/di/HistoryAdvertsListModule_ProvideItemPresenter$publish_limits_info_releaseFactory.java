package com.avito.android.publish_limits_info.history.tab.di;

import com.avito.android.publish_limits_info.history.tab.info.InfoItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class HistoryAdvertsListModule_ProvideItemPresenter$publish_limits_info_releaseFactory implements Factory<InfoItemPresenter> {

    public static final class a {
        public static final HistoryAdvertsListModule_ProvideItemPresenter$publish_limits_info_releaseFactory a = new HistoryAdvertsListModule_ProvideItemPresenter$publish_limits_info_releaseFactory();
    }

    public static HistoryAdvertsListModule_ProvideItemPresenter$publish_limits_info_releaseFactory create() {
        return a.a;
    }

    public static InfoItemPresenter provideItemPresenter$publish_limits_info_release() {
        return (InfoItemPresenter) Preconditions.checkNotNullFromProvides(HistoryAdvertsListModule.INSTANCE.provideItemPresenter$publish_limits_info_release());
    }

    @Override // javax.inject.Provider
    public InfoItemPresenter get() {
        return provideItemPresenter$publish_limits_info_release();
    }
}
