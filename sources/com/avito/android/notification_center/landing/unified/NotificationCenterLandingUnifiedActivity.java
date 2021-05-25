package com.avito.android.notification_center.landing.unified;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.notification_center.R;
import com.avito.android.notification_center.landing.unified.di.DaggerNotificationCenterLandingUnifiedComponent;
import com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedComponent;
import com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b6\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tR\"\u0010\u0014\u001a\u00020\u00138\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "outState", "onSaveInstanceState", "onStop", "onDestroy", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "leaveScreen", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenter;", "presenter", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenter;", "getPresenter$notification_center_release", "()Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenter;", "setPresenter$notification_center_release", "(Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$notification_center_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$notification_center_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder$notification_center_release", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder$notification_center_release", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter$notification_center_release", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter$notification_center_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory$notification_center_release", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory$notification_center_release", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingUnifiedActivity extends BaseActivity implements NotificationCenterLandingUnifiedRouter {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public NotificationCenterLandingUnifiedPresenter presenter;

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedRouter
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter$notification_center_release() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics$notification_center_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory$notification_center_release() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final ItemBinder getItemBinder$notification_center_release() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final NotificationCenterLandingUnifiedPresenter getPresenter$notification_center_release() {
        NotificationCenterLandingUnifiedPresenter notificationCenterLandingUnifiedPresenter = this.presenter;
        if (notificationCenterLandingUnifiedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return notificationCenterLandingUnifiedPresenter;
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedRouter
    public void leaveScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_id");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_ID)");
        NotificationCenterLandingUnifiedComponent.Builder withPresenterState = DaggerNotificationCenterLandingUnifiedComponent.builder().dependencies((NotificationCenterLandingUnifiedDependencies) ComponentDependenciesKt.getDependencies(NotificationCenterLandingUnifiedDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withId(stringExtra).withPresenterState(bundle != null ? (Kundle) bundle.getParcelable("key_state") : null);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        NotificationCenterLandingUnifiedComponent.Builder withResources = withPresenterState.withResources(resources);
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        NotificationCenterLandingUnifiedComponent.Builder withAdvertClickRelay = withResources.withAdvertClickRelay(create);
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        NotificationCenterLandingUnifiedComponent.Builder withAdvertFavoriteRelay = withAdvertClickRelay.withAdvertFavoriteRelay(create2);
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        NotificationCenterLandingUnifiedComponent.Builder withButtonClickRelay = withAdvertFavoriteRelay.withButtonClickRelay(create3);
        PublishRelay create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        NotificationCenterLandingUnifiedComponent.Builder withPairButtonFirstClickRelay = withButtonClickRelay.withPairButtonFirstClickRelay(create4);
        PublishRelay create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        NotificationCenterLandingUnifiedComponent.Builder withPairButtonSecondClickRelay = withPairButtonFirstClickRelay.withPairButtonSecondClickRelay(create5);
        PublishRelay create6 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "PublishRelay.create()");
        withPairButtonSecondClickRelay.withSubtitleClickRelay(create6).build().inject(this);
        setContentView(R.layout.notification_center_landing_unified);
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "contentView");
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        NotificationCenterLandingUnifiedViewImpl notificationCenterLandingUnifiedViewImpl = new NotificationCenterLandingUnifiedViewImpl(viewGroup, adapterPresenter2, itemBinder2, analytics2);
        NotificationCenterLandingUnifiedPresenter notificationCenterLandingUnifiedPresenter = this.presenter;
        if (notificationCenterLandingUnifiedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingUnifiedPresenter.attachView(notificationCenterLandingUnifiedViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NotificationCenterLandingUnifiedPresenter notificationCenterLandingUnifiedPresenter = this.presenter;
        if (notificationCenterLandingUnifiedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingUnifiedPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NotificationCenterLandingUnifiedPresenter notificationCenterLandingUnifiedPresenter = this.presenter;
        if (notificationCenterLandingUnifiedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key_state", notificationCenterLandingUnifiedPresenter.getState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        NotificationCenterLandingUnifiedPresenter notificationCenterLandingUnifiedPresenter = this.presenter;
        if (notificationCenterLandingUnifiedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingUnifiedPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        NotificationCenterLandingUnifiedPresenter notificationCenterLandingUnifiedPresenter = this.presenter;
        if (notificationCenterLandingUnifiedPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingUnifiedPresenter.detachRouter();
        super.onStop();
    }

    public final void setAdapterPresenter$notification_center_release(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics$notification_center_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory$notification_center_release(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setItemBinder$notification_center_release(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter$notification_center_release(@NotNull NotificationCenterLandingUnifiedPresenter notificationCenterLandingUnifiedPresenter) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingUnifiedPresenter, "<set-?>");
        this.presenter = notificationCenterLandingUnifiedPresenter;
    }
}
