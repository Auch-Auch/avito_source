package com.avito.android.abuse.details;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AbuseDetailsActivity_MembersInjector implements MembersInjector<AbuseDetailsActivity> {
    public final Provider<AbuseDetailsPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<Features> d;
    public final Provider<Analytics> e;
    public final Provider<ActivityIntentFactory> f;

    public AbuseDetailsActivity_MembersInjector(Provider<AbuseDetailsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Features> provider4, Provider<Analytics> provider5, Provider<ActivityIntentFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<AbuseDetailsActivity> create(Provider<AbuseDetailsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Features> provider4, Provider<Analytics> provider5, Provider<ActivityIntentFactory> provider6) {
        return new AbuseDetailsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.abuse.details.AbuseDetailsActivity.adapterPresenter")
    public static void injectAdapterPresenter(AbuseDetailsActivity abuseDetailsActivity, AdapterPresenter adapterPresenter) {
        abuseDetailsActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.abuse.details.AbuseDetailsActivity.analytics")
    public static void injectAnalytics(AbuseDetailsActivity abuseDetailsActivity, Analytics analytics) {
        abuseDetailsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.abuse.details.AbuseDetailsActivity.features")
    public static void injectFeatures(AbuseDetailsActivity abuseDetailsActivity, Features features) {
        abuseDetailsActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.abuse.details.AbuseDetailsActivity.intentFactory")
    public static void injectIntentFactory(AbuseDetailsActivity abuseDetailsActivity, ActivityIntentFactory activityIntentFactory) {
        abuseDetailsActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.abuse.details.AbuseDetailsActivity.itemBinder")
    public static void injectItemBinder(AbuseDetailsActivity abuseDetailsActivity, ItemBinder itemBinder) {
        abuseDetailsActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.abuse.details.AbuseDetailsActivity.presenter")
    public static void injectPresenter(AbuseDetailsActivity abuseDetailsActivity, AbuseDetailsPresenter abuseDetailsPresenter) {
        abuseDetailsActivity.presenter = abuseDetailsPresenter;
    }

    public void injectMembers(AbuseDetailsActivity abuseDetailsActivity) {
        injectPresenter(abuseDetailsActivity, this.a.get());
        injectAdapterPresenter(abuseDetailsActivity, this.b.get());
        injectItemBinder(abuseDetailsActivity, this.c.get());
        injectFeatures(abuseDetailsActivity, this.d.get());
        injectAnalytics(abuseDetailsActivity, this.e.get());
        injectIntentFactory(abuseDetailsActivity, this.f.get());
    }
}
