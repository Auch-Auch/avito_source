package com.avito.android.shop.info;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.shop.R;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.info.di.DaggerShopInfoComponent;
import com.avito.android.shop.info.di.ShopInfoComponent;
import com.avito.android.shop.info.di.ShopInfoModule;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b/\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0007R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/avito/android/shop/info/ShopInfoActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/shop/info/ShopInfoRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "closeShopInfo", "()V", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "openAwards", "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;)V", "onStart", "onStop", "onDestroy", "outState", "onSaveInstanceState", "Lcom/avito/android/shop/info/ShopInfoPresenter;", "presenter", "Lcom/avito/android/shop/info/ShopInfoPresenter;", "getPresenter", "()Lcom/avito/android/shop/info/ShopInfoPresenter;", "setPresenter", "(Lcom/avito/android/shop/info/ShopInfoPresenter;)V", "Lcom/avito/android/shop/info/ShopInfoInteractor;", "interactor", "Lcom/avito/android/shop/info/ShopInfoInteractor;", "getInteractor", "()Lcom/avito/android/shop/info/ShopInfoInteractor;", "setInteractor", "(Lcom/avito/android/shop/info/ShopInfoInteractor;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopInfoActivity extends BaseActivity implements ShopInfoRouter {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public ShopInfoInteractor interactor;
    @Inject
    public ShopInfoPresenter presenter;

    @Override // com.avito.android.shop.info.ShopInfoRouter
    public void closeShopInfo() {
        finish();
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
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
    public final ShopInfoInteractor getInteractor() {
        ShopInfoInteractor shopInfoInteractor = this.interactor;
        if (shopInfoInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return shopInfoInteractor;
    }

    @NotNull
    public final ShopInfoPresenter getPresenter() {
        ShopInfoPresenter shopInfoPresenter = this.presenter;
        if (shopInfoPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return shopInfoPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.shop_info_activity);
        Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "key_presenter") : null;
        String stringExtra = getIntent().getStringExtra("shop_id");
        ShopInfoComponent.Builder shopDetailedDependencies = DaggerShopInfoComponent.builder().shopDetailedDependencies((ShopDetailedDependencies) ComponentDependenciesKt.getDependencies(ShopDetailedDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "this.resources");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "shopId");
        shopDetailedDependencies.shopInfoModule(new ShopInfoModule(resources, stringExtra, kundle)).build().inject(this);
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        ShopInfoPresenter shopInfoPresenter = this.presenter;
        if (shopInfoPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ShopInfoViewImpl shopInfoViewImpl = new ShopInfoViewImpl(viewGroup, shopInfoPresenter, analytics2);
        ShopInfoPresenter shopInfoPresenter2 = this.presenter;
        if (shopInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopInfoPresenter2.attachView(shopInfoViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ShopInfoPresenter shopInfoPresenter = this.presenter;
        if (shopInfoPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopInfoPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ShopInfoPresenter shopInfoPresenter = this.presenter;
        if (shopInfoPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "key_presenter", shopInfoPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ShopInfoPresenter shopInfoPresenter = this.presenter;
        if (shopInfoPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopInfoPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ShopInfoPresenter shopInfoPresenter = this.presenter;
        if (shopInfoPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        shopInfoPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.shop.info.ShopInfoRouter
    public void openAwards(@NotNull SellerVerification.AwardsItem awardsItem) {
        Intrinsics.checkNotNullParameter(awardsItem, "awards");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.showAwardsIntent(awardsItem, true));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setInteractor(@NotNull ShopInfoInteractor shopInfoInteractor) {
        Intrinsics.checkNotNullParameter(shopInfoInteractor, "<set-?>");
        this.interactor = shopInfoInteractor;
    }

    public final void setPresenter(@NotNull ShopInfoPresenter shopInfoPresenter) {
        Intrinsics.checkNotNullParameter(shopInfoPresenter, "<set-?>");
        this.presenter = shopInfoPresenter;
    }
}
