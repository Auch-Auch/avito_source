package com.avito.android.shop.awards;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.shop.awards.di.AwardsComponent;
import com.avito.android.shop.awards.di.DaggerAwardsComponent;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.ToastsKt;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b6\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0007R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/avito/android/shop/awards/AwardsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/shop/awards/AwardsRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "closeAwards", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onStart", "onStop", "onDestroy", "outState", "onSaveInstanceState", "Lcom/avito/android/shop/awards/AwardsInteractor;", "interactor", "Lcom/avito/android/shop/awards/AwardsInteractor;", "getInteractor", "()Lcom/avito/android/shop/awards/AwardsInteractor;", "setInteractor", "(Lcom/avito/android/shop/awards/AwardsInteractor;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "intentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/shop/awards/AwardsPresenter;", "presenter", "Lcom/avito/android/shop/awards/AwardsPresenter;", "getPresenter", "()Lcom/avito/android/shop/awards/AwardsPresenter;", "setPresenter", "(Lcom/avito/android/shop/awards/AwardsPresenter;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class AwardsActivity extends BaseActivity implements AwardsRouter {
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory intentFactory;
    @Inject
    public AwardsInteractor interactor;
    @Inject
    public AwardsPresenter presenter;

    @Override // com.avito.android.shop.awards.AwardsRouter
    public void closeAwards() {
        finish();
    }

    @Override // com.avito.android.shop.awards.AwardsRouter
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory = this.intentFactory;
        if (deepLinkIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent intent = deepLinkIntentFactory.getIntent(deepLink);
        if (intent == null) {
            ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
            return;
        }
        try {
            startActivity(IntentsKt.makeSafeForExternalApps(intent));
        } catch (Exception unused) {
            ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
        }
    }

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DeepLinkIntentFactory getIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory = this.intentFactory;
        if (deepLinkIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return deepLinkIntentFactory;
    }

    @NotNull
    public final AwardsInteractor getInteractor() {
        AwardsInteractor awardsInteractor = this.interactor;
        if (awardsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return awardsInteractor;
    }

    @NotNull
    public final AwardsPresenter getPresenter() {
        AwardsPresenter awardsPresenter = this.presenter;
        if (awardsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return awardsPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.avito.android.shop.R.layout.awards_activity);
        Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "key_presenter") : null;
        SellerVerification.AwardsItem awardsItem = (SellerVerification.AwardsItem) getIntent().getParcelableExtra("awards");
        boolean booleanExtra = getIntent().getBooleanExtra("arrow_back_navigation", false);
        AwardsComponent.Factory factory = DaggerAwardsComponent.factory();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        Intrinsics.checkNotNull(awardsItem);
        factory.create(resources, awardsItem, kundle, (ShopDetailedDependencies) ComponentDependenciesKt.getDependencies(ShopDetailedDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).inject(this);
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        AwardsPresenter awardsPresenter = this.presenter;
        if (awardsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        AwardsViewImpl awardsViewImpl = new AwardsViewImpl(viewGroup, awardsPresenter, simpleRecyclerAdapter, analytics2, booleanExtra);
        AwardsPresenter awardsPresenter2 = this.presenter;
        if (awardsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        awardsPresenter2.attachView(awardsViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AwardsPresenter awardsPresenter = this.presenter;
        if (awardsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        awardsPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        AwardsPresenter awardsPresenter = this.presenter;
        if (awardsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "key_presenter", awardsPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        AwardsPresenter awardsPresenter = this.presenter;
        if (awardsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        awardsPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AwardsPresenter awardsPresenter = this.presenter;
        if (awardsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        awardsPresenter.detachRouter();
        super.onStop();
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "<set-?>");
        this.intentFactory = deepLinkIntentFactory;
    }

    public final void setInteractor(@NotNull AwardsInteractor awardsInteractor) {
        Intrinsics.checkNotNullParameter(awardsInteractor, "<set-?>");
        this.interactor = awardsInteractor;
    }

    public final void setPresenter(@NotNull AwardsPresenter awardsPresenter) {
        Intrinsics.checkNotNullParameter(awardsPresenter, "<set-?>");
        this.presenter = awardsPresenter;
    }
}
