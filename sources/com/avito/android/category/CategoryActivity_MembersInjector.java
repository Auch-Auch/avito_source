package com.avito.android.category;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CategoryActivity_MembersInjector implements MembersInjector<CategoryActivity> {
    public final Provider<CategoryPresenter> a;
    public final Provider<CategoryInteractor> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<DeviceMetrics> d;
    public final Provider<BuildInfo> e;
    public final Provider<Analytics> f;

    public CategoryActivity_MembersInjector(Provider<CategoryPresenter> provider, Provider<CategoryInteractor> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<DeviceMetrics> provider4, Provider<BuildInfo> provider5, Provider<Analytics> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<CategoryActivity> create(Provider<CategoryPresenter> provider, Provider<CategoryInteractor> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<DeviceMetrics> provider4, Provider<BuildInfo> provider5, Provider<Analytics> provider6) {
        return new CategoryActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.category.CategoryActivity.analytics")
    public static void injectAnalytics(CategoryActivity categoryActivity, Analytics analytics) {
        categoryActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.category.CategoryActivity.build")
    public static void injectBuild(CategoryActivity categoryActivity, BuildInfo buildInfo) {
        categoryActivity.build = buildInfo;
    }

    @InjectedFieldSignature("com.avito.android.category.CategoryActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(CategoryActivity categoryActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        categoryActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.category.CategoryActivity.deviceMetrics")
    public static void injectDeviceMetrics(CategoryActivity categoryActivity, DeviceMetrics deviceMetrics) {
        categoryActivity.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.category.CategoryActivity.interactor")
    public static void injectInteractor(CategoryActivity categoryActivity, CategoryInteractor categoryInteractor) {
        categoryActivity.interactor = categoryInteractor;
    }

    @InjectedFieldSignature("com.avito.android.category.CategoryActivity.presenter")
    public static void injectPresenter(CategoryActivity categoryActivity, CategoryPresenter categoryPresenter) {
        categoryActivity.presenter = categoryPresenter;
    }

    public void injectMembers(CategoryActivity categoryActivity) {
        injectPresenter(categoryActivity, this.a.get());
        injectInteractor(categoryActivity, this.b.get());
        injectDeepLinkIntentFactory(categoryActivity, this.c.get());
        injectDeviceMetrics(categoryActivity, this.d.get());
        injectBuild(categoryActivity, this.e.get());
        injectAnalytics(categoryActivity, this.f.get());
    }
}
