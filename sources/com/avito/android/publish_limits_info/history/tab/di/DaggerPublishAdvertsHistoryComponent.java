package com.avito.android.publish_limits_info.history.tab.di;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.publish_limits_info.history.tab.ExtraInfoClickListener;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment_MembersInjector;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryProvider;
import com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemListBlueprint;
import com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemListBlueprint_Factory;
import com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemPresenter;
import com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemPresenterImpl_Factory;
import com.avito.android.publish_limits_info.history.tab.di.PublishAdvertsHistoryComponent;
import com.avito.android.publish_limits_info.history.tab.info.InfoItemBlueprint;
import com.avito.android.publish_limits_info.history.tab.info.InfoItemBlueprint_Factory;
import com.avito.android.publish_limits_info.history.tab.info.InfoItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Collections;
import javax.inject.Provider;
public final class DaggerPublishAdvertsHistoryComponent implements PublishAdvertsHistoryComponent {
    public final PublishAdvertsHistoryDependencies a;
    public Provider<HistoryAdvertItemPresenter> b;
    public Provider<HistoryAdvertItemListBlueprint> c;
    public Provider<InfoItemPresenter> d;
    public Provider<AttributedTextFormatter> e;
    public Provider<InfoItemBlueprint> f;
    public Provider<ItemBinder> g;
    public Provider<AdapterPresenter> h;
    public Provider<SimpleRecyclerAdapter> i;

    public static final class b implements PublishAdvertsHistoryComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.publish_limits_info.history.tab.di.PublishAdvertsHistoryComponent.Factory
        public PublishAdvertsHistoryComponent create(PublishAdvertsHistoryDependencies publishAdvertsHistoryDependencies) {
            Preconditions.checkNotNull(publishAdvertsHistoryDependencies);
            return new DaggerPublishAdvertsHistoryComponent(publishAdvertsHistoryDependencies, null);
        }
    }

    public static class c implements Provider<AttributedTextFormatter> {
        public final PublishAdvertsHistoryDependencies a;

        public c(PublishAdvertsHistoryDependencies publishAdvertsHistoryDependencies) {
            this.a = publishAdvertsHistoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AttributedTextFormatter get() {
            return (AttributedTextFormatter) Preconditions.checkNotNullFromComponent(this.a.attributedTextFormatter());
        }
    }

    public DaggerPublishAdvertsHistoryComponent(PublishAdvertsHistoryDependencies publishAdvertsHistoryDependencies, a aVar) {
        this.a = publishAdvertsHistoryDependencies;
        Provider<HistoryAdvertItemPresenter> provider = DoubleCheck.provider(HistoryAdvertItemPresenterImpl_Factory.create());
        this.b = provider;
        this.c = HistoryAdvertItemListBlueprint_Factory.create(provider);
        Provider<InfoItemPresenter> provider2 = DoubleCheck.provider(HistoryAdvertsListModule_ProvideItemPresenter$publish_limits_info_releaseFactory.create());
        this.d = provider2;
        c cVar = new c(publishAdvertsHistoryDependencies);
        this.e = cVar;
        InfoItemBlueprint_Factory create = InfoItemBlueprint_Factory.create(provider2, cVar);
        this.f = create;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(HistoryAdvertsListModule_ProvideItemBinder$publish_limits_info_releaseFactory.create(this.c, create));
        this.g = provider3;
        Provider<AdapterPresenter> provider4 = DoubleCheck.provider(HistoryAdvertsListModule_ProvideAdapterPresenter$publish_limits_info_releaseFactory.create(provider3));
        this.h = provider4;
        this.i = DoubleCheck.provider(HistoryAdvertsListModule_ProvideSimpleRecyclerAdapterFactory.create(provider4, this.g));
    }

    public static PublishAdvertsHistoryComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.publish_limits_info.history.tab.di.PublishAdvertsHistoryComponent
    public void inject(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment) {
        PublishAdvertsHistoryFragment_MembersInjector.injectAdapterPresenter(publishAdvertsHistoryFragment, this.h.get());
        PublishAdvertsHistoryFragment_MembersInjector.injectAdapter(publishAdvertsHistoryFragment, this.i.get());
        PublishAdvertsHistoryFragment_MembersInjector.injectAdvertsProvider(publishAdvertsHistoryFragment, (PublishAdvertsHistoryProvider) Preconditions.checkNotNullFromComponent(this.a.historyProvider()));
        PublishAdvertsHistoryFragment_MembersInjector.injectDeepLinkIntentFactory(publishAdvertsHistoryFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        PublishAdvertsHistoryFragment_MembersInjector.injectExtraInfoClickedListener(publishAdvertsHistoryFragment, (ExtraInfoClickListener) Preconditions.checkNotNullFromComponent(this.a.extraInfoClickListener()));
        PublishAdvertsHistoryFragment_MembersInjector.injectItemPresenterSet(publishAdvertsHistoryFragment, Collections.singleton(this.d.get()));
    }
}
