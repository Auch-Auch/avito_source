package com.avito.android.publish_limits_info.history.tab;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class PublishAdvertsHistoryFragment_MembersInjector implements MembersInjector<PublishAdvertsHistoryFragment> {
    public final Provider<AdapterPresenter> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<PublishAdvertsHistoryProvider> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<ExtraInfoClickListener> e;
    public final Provider<Set<ItemPresenter<?, ?>>> f;

    public PublishAdvertsHistoryFragment_MembersInjector(Provider<AdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<PublishAdvertsHistoryProvider> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<ExtraInfoClickListener> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<PublishAdvertsHistoryFragment> create(Provider<AdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<PublishAdvertsHistoryProvider> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<ExtraInfoClickListener> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6) {
        return new PublishAdvertsHistoryFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment.adapter")
    public static void injectAdapter(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        publishAdvertsHistoryFragment.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment.adapterPresenter")
    public static void injectAdapterPresenter(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment, AdapterPresenter adapterPresenter) {
        publishAdvertsHistoryFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment.advertsProvider")
    public static void injectAdvertsProvider(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment, PublishAdvertsHistoryProvider publishAdvertsHistoryProvider) {
        publishAdvertsHistoryFragment.advertsProvider = publishAdvertsHistoryProvider;
    }

    @InjectedFieldSignature("com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        publishAdvertsHistoryFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment.extraInfoClickedListener")
    public static void injectExtraInfoClickedListener(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment, ExtraInfoClickListener extraInfoClickListener) {
        publishAdvertsHistoryFragment.extraInfoClickedListener = extraInfoClickListener;
    }

    @InjectedFieldSignature("com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment.itemPresenterSet")
    public static void injectItemPresenterSet(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment, Set<ItemPresenter<?, ?>> set) {
        publishAdvertsHistoryFragment.itemPresenterSet = set;
    }

    public void injectMembers(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment) {
        injectAdapterPresenter(publishAdvertsHistoryFragment, this.a.get());
        injectAdapter(publishAdvertsHistoryFragment, this.b.get());
        injectAdvertsProvider(publishAdvertsHistoryFragment, this.c.get());
        injectDeepLinkIntentFactory(publishAdvertsHistoryFragment, this.d.get());
        injectExtraInfoClickedListener(publishAdvertsHistoryFragment, this.e.get());
        injectItemPresenterSet(publishAdvertsHistoryFragment, this.f.get());
    }
}
