package com.avito.android.abuse.category;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AbuseCategoryActivity_MembersInjector implements MembersInjector<AbuseCategoryActivity> {
    public final Provider<AbuseCategoryPresenter> a;
    public final Provider<AbuseCategoryInteractor> b;
    public final Provider<SimpleRecyclerAdapter> c;
    public final Provider<Analytics> d;
    public final Provider<Features> e;
    public final Provider<ActivityIntentFactory> f;

    public AbuseCategoryActivity_MembersInjector(Provider<AbuseCategoryPresenter> provider, Provider<AbuseCategoryInteractor> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<Analytics> provider4, Provider<Features> provider5, Provider<ActivityIntentFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<AbuseCategoryActivity> create(Provider<AbuseCategoryPresenter> provider, Provider<AbuseCategoryInteractor> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<Analytics> provider4, Provider<Features> provider5, Provider<ActivityIntentFactory> provider6) {
        return new AbuseCategoryActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.abuse.category.AbuseCategoryActivity.analytics")
    public static void injectAnalytics(AbuseCategoryActivity abuseCategoryActivity, Analytics analytics) {
        abuseCategoryActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.abuse.category.AbuseCategoryActivity.features")
    public static void injectFeatures(AbuseCategoryActivity abuseCategoryActivity, Features features) {
        abuseCategoryActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.abuse.category.AbuseCategoryActivity.intentFactory")
    public static void injectIntentFactory(AbuseCategoryActivity abuseCategoryActivity, ActivityIntentFactory activityIntentFactory) {
        abuseCategoryActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.abuse.category.AbuseCategoryActivity.interactor")
    public static void injectInteractor(AbuseCategoryActivity abuseCategoryActivity, AbuseCategoryInteractor abuseCategoryInteractor) {
        abuseCategoryActivity.interactor = abuseCategoryInteractor;
    }

    @InjectedFieldSignature("com.avito.android.abuse.category.AbuseCategoryActivity.presenter")
    public static void injectPresenter(AbuseCategoryActivity abuseCategoryActivity, AbuseCategoryPresenter abuseCategoryPresenter) {
        abuseCategoryActivity.presenter = abuseCategoryPresenter;
    }

    @InjectedFieldSignature("com.avito.android.abuse.category.AbuseCategoryActivity.recyclerAdapter")
    public static void injectRecyclerAdapter(AbuseCategoryActivity abuseCategoryActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        abuseCategoryActivity.recyclerAdapter = simpleRecyclerAdapter;
    }

    public void injectMembers(AbuseCategoryActivity abuseCategoryActivity) {
        injectPresenter(abuseCategoryActivity, this.a.get());
        injectInteractor(abuseCategoryActivity, this.b.get());
        injectRecyclerAdapter(abuseCategoryActivity, this.c.get());
        injectAnalytics(abuseCategoryActivity, this.d.get());
        injectFeatures(abuseCategoryActivity, this.e.get());
        injectIntentFactory(abuseCategoryActivity, this.f.get());
    }
}
