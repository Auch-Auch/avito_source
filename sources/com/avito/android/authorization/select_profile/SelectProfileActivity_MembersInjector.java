package com.avito.android.authorization.select_profile;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SelectProfileActivity_MembersInjector implements MembersInjector<SelectProfileActivity> {
    public final Provider<SelectProfilePresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<Analytics> d;
    public final Provider<ActivityIntentFactory> e;

    public SelectProfileActivity_MembersInjector(Provider<SelectProfilePresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<ActivityIntentFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<SelectProfileActivity> create(Provider<SelectProfilePresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<ActivityIntentFactory> provider5) {
        return new SelectProfileActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_profile.SelectProfileActivity.adapterPresenter")
    public static void injectAdapterPresenter(SelectProfileActivity selectProfileActivity, AdapterPresenter adapterPresenter) {
        selectProfileActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_profile.SelectProfileActivity.analytics")
    public static void injectAnalytics(SelectProfileActivity selectProfileActivity, Analytics analytics) {
        selectProfileActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_profile.SelectProfileActivity.intentFactory")
    public static void injectIntentFactory(SelectProfileActivity selectProfileActivity, ActivityIntentFactory activityIntentFactory) {
        selectProfileActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_profile.SelectProfileActivity.itemBinder")
    public static void injectItemBinder(SelectProfileActivity selectProfileActivity, ItemBinder itemBinder) {
        selectProfileActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_profile.SelectProfileActivity.presenter")
    public static void injectPresenter(SelectProfileActivity selectProfileActivity, SelectProfilePresenter selectProfilePresenter) {
        selectProfileActivity.presenter = selectProfilePresenter;
    }

    public void injectMembers(SelectProfileActivity selectProfileActivity) {
        injectPresenter(selectProfileActivity, this.a.get());
        injectAdapterPresenter(selectProfileActivity, this.b.get());
        injectItemBinder(selectProfileActivity, this.c.get());
        injectAnalytics(selectProfileActivity, this.d.get());
        injectIntentFactory(selectProfileActivity, this.e.get());
    }
}
