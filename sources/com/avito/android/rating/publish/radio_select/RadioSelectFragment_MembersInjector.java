package com.avito.android.rating.publish.radio_select;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.rating.publish.StepListener;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class RadioSelectFragment_MembersInjector implements MembersInjector<RadioSelectFragment> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<ItemBinder> b;
    public final Provider<RadioSelectPresenter> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<StepListener> e;
    public final Provider<Analytics> f;

    public RadioSelectFragment_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<ItemBinder> provider2, Provider<RadioSelectPresenter> provider3, Provider<AdapterPresenter> provider4, Provider<StepListener> provider5, Provider<Analytics> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<RadioSelectFragment> create(Provider<DeepLinkIntentFactory> provider, Provider<ItemBinder> provider2, Provider<RadioSelectPresenter> provider3, Provider<AdapterPresenter> provider4, Provider<StepListener> provider5, Provider<Analytics> provider6) {
        return new RadioSelectFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.radio_select.RadioSelectFragment.adapterPresenter")
    public static void injectAdapterPresenter(RadioSelectFragment radioSelectFragment, AdapterPresenter adapterPresenter) {
        radioSelectFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.radio_select.RadioSelectFragment.analytics")
    public static void injectAnalytics(RadioSelectFragment radioSelectFragment, Analytics analytics) {
        radioSelectFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.radio_select.RadioSelectFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(RadioSelectFragment radioSelectFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        radioSelectFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.radio_select.RadioSelectFragment.itemBinder")
    public static void injectItemBinder(RadioSelectFragment radioSelectFragment, ItemBinder itemBinder) {
        radioSelectFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.radio_select.RadioSelectFragment.presenter")
    public static void injectPresenter(RadioSelectFragment radioSelectFragment, RadioSelectPresenter radioSelectPresenter) {
        radioSelectFragment.presenter = radioSelectPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.radio_select.RadioSelectFragment.stepListener")
    public static void injectStepListener(RadioSelectFragment radioSelectFragment, StepListener stepListener) {
        radioSelectFragment.stepListener = stepListener;
    }

    public void injectMembers(RadioSelectFragment radioSelectFragment) {
        injectDeepLinkIntentFactory(radioSelectFragment, this.a.get());
        injectItemBinder(radioSelectFragment, this.b.get());
        injectPresenter(radioSelectFragment, this.c.get());
        injectAdapterPresenter(radioSelectFragment, this.d.get());
        injectStepListener(radioSelectFragment, this.e.get());
        injectAnalytics(radioSelectFragment, this.f.get());
    }
}
