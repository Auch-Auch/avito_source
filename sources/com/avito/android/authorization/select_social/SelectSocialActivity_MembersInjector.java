package com.avito.android.authorization.select_social;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SelectSocialActivity_MembersInjector implements MembersInjector<SelectSocialActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<SelectSocialPresenter> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<SocialTypeToStringMapper> e;

    public SelectSocialActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<SelectSocialPresenter> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<SocialTypeToStringMapper> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<SelectSocialActivity> create(Provider<ActivityIntentFactory> provider, Provider<SelectSocialPresenter> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<SocialTypeToStringMapper> provider5) {
        return new SelectSocialActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_social.SelectSocialActivity.adapterPresenter")
    public static void injectAdapterPresenter(SelectSocialActivity selectSocialActivity, AdapterPresenter adapterPresenter) {
        selectSocialActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_social.SelectSocialActivity.intentFactory")
    public static void injectIntentFactory(SelectSocialActivity selectSocialActivity, ActivityIntentFactory activityIntentFactory) {
        selectSocialActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_social.SelectSocialActivity.itemBinder")
    public static void injectItemBinder(SelectSocialActivity selectSocialActivity, ItemBinder itemBinder) {
        selectSocialActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_social.SelectSocialActivity.presenter")
    public static void injectPresenter(SelectSocialActivity selectSocialActivity, SelectSocialPresenter selectSocialPresenter) {
        selectSocialActivity.presenter = selectSocialPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_social.SelectSocialActivity.socialTypeToStringMapper")
    public static void injectSocialTypeToStringMapper(SelectSocialActivity selectSocialActivity, SocialTypeToStringMapper socialTypeToStringMapper) {
        selectSocialActivity.socialTypeToStringMapper = socialTypeToStringMapper;
    }

    public void injectMembers(SelectSocialActivity selectSocialActivity) {
        injectIntentFactory(selectSocialActivity, this.a.get());
        injectPresenter(selectSocialActivity, this.b.get());
        injectAdapterPresenter(selectSocialActivity, this.c.get());
        injectItemBinder(selectSocialActivity, this.d.get());
        injectSocialTypeToStringMapper(selectSocialActivity, this.e.get());
    }
}
