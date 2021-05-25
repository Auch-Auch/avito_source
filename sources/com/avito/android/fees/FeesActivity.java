package com.avito.android.fees;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.ComponentProvider;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.fees.PackageFeeFragment;
import com.avito.android.fees.PackageParamsFragment;
import com.avito.android.fees.SingleFeeFragment;
import com.avito.android.fees.di.DaggerFeesActivityComponent;
import com.avito.android.fees.di.FeesActivityComponent;
import com.avito.android.fees.di.FeesActivityDependencies;
import com.avito.android.fees.di.FeesActivityModule;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertFeesEntity;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.android.remote.model.SingleFee;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.user_advert.OfferDialogData;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010\u0013J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0017\u0010\u0013J)\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u0013J'\u0010$\u001a\u00020\u000f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J)\u0010*\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000fH\u0016¢\u0006\u0004\b,\u0010\u0013J\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000fH\u0016¢\u0006\u0004\b.\u0010\u0013J%\u00102\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/2\f\u00101\u001a\b\u0012\u0004\u0012\u00020/0\u001fH\u0016¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u000f2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u000fH\u0016¢\u0006\u0004\b8\u0010\u0013J\u0017\u00109\u001a\u00020\u000f2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b9\u00107J\u0011\u0010;\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010U\u001a\u00020\u00068\u0016@\u0016X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010c\u001a\u00020b8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010j\u001a\u00020i8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010q\u001a\u00020p8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010x\u001a\u00020w8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/fees/FeesActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/fees/FeesView;", "Lcom/avito/android/fees/PackageFeeListener;", "Lcom/avito/android/fees/SingleFeeListener;", "Lcom/avito/android/ComponentProvider;", "Lcom/avito/android/fees/di/FeesActivityComponent;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "", "onCreate", "(Landroid/os/Bundle;)V", "restoreActionBar", "()V", "onStart", "outState", "onSaveInstanceState", "onStop", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onLoadingStart", "", "Lcom/avito/android/remote/model/OwnedPackage;", "packages", "", "message", "onPackageFeeAvailable", "(Ljava/util/List;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/SingleFee;", "singleFee", "Lcom/avito/android/remote/model/Action;", "action", "onSingleFeeAvailable", "(Lcom/avito/android/remote/model/SingleFee;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "onLoadingError", "(Ljava/lang/String;)V", "onActivationDone", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "location", "restrictions", "onPackageSelected", "(Lcom/avito/android/remote/model/AdvertFeesEntity;Ljava/util/List;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "showInfo", "showPayment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/account/AccountStateProvider;", "getAccountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "setAccountStateProvider", "(Lcom/avito/android/account/AccountStateProvider;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "k", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "component", "Lcom/avito/android/fees/di/FeesActivityComponent;", "getComponent", "()Lcom/avito/android/fees/di/FeesActivityComponent;", "setComponent", "(Lcom/avito/android/fees/di/FeesActivityComponent;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$fees_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$fees_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "getAnalyticsData$fees_release", "()Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "setAnalyticsData$fees_release", "(Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "Lcom/avito/android/fees/FeesInteractor;", "feesInteractor", "Lcom/avito/android/fees/FeesInteractor;", "getFeesInteractor", "()Lcom/avito/android/fees/FeesInteractor;", "setFeesInteractor", "(Lcom/avito/android/fees/FeesInteractor;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestConfigProvider", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "getAbTestConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "setAbTestConfigProvider", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "l", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/fees/FeesPresenter;", "feesPresenter", "Lcom/avito/android/fees/FeesPresenter;", "getFeesPresenter", "()Lcom/avito/android/fees/FeesPresenter;", "setFeesPresenter", "(Lcom/avito/android/fees/FeesPresenter;)V", "<init>", "IntentFactory", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class FeesActivity extends BaseActivity implements FeesView, PackageFeeListener, SingleFeeListener, ComponentProvider<FeesActivityComponent> {
    @Inject
    public AbTestsConfigProvider abTestConfigProvider;
    @Inject
    public AccountStateProvider accountStateProvider;
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public PublishAnalyticsDataProvider analyticsData;
    public FeesActivityComponent component;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public Features features;
    @Inject
    public FeesInteractor feesInteractor;
    @Inject
    public FeesPresenter feesPresenter;
    public String k;
    public ProgressOverlay l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/fees/FeesActivity$IntentFactory;", "", "Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "isFromPublish", "skipSuccessDialogAfterPayment", "Lcom/avito/android/user_advert/OfferDialogData;", "offerDialogData", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Ljava/lang/String;ZZLcom/avito/android/user_advert/OfferDialogData;)Landroid/content/Intent;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
    public static final class IntentFactory {
        public static /* synthetic */ Intent create$default(IntentFactory intentFactory, Context context, String str, boolean z, boolean z2, OfferDialogData offerDialogData, int i, Object obj) {
            boolean z3 = (i & 4) != 0 ? false : z;
            boolean z4 = (i & 8) != 0 ? false : z2;
            if ((i & 16) != 0) {
                offerDialogData = null;
            }
            return intentFactory.create(context, str, z3, z4, offerDialogData);
        }

        @NotNull
        public final Intent create(@NotNull Context context, @NotNull String str, boolean z, boolean z2, @Nullable OfferDialogData offerDialogData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intent putExtra = new Intent(context, FeesActivity.class).putExtra("key_is_from_publish", z).putExtra("key_activity_item", str).putExtra("key_skip_success_dialog", z2).putExtra("key_offer_dialog_data", offerDialogData);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, FeesActi…OG_DATA, offerDialogData)");
            return putExtra;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FeesActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FeesActivity feesActivity) {
            super(0);
            this.a = feesActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getFeesPresenter().retry();
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final AbTestsConfigProvider getAbTestConfigProvider() {
        AbTestsConfigProvider abTestsConfigProvider = this.abTestConfigProvider;
        if (abTestsConfigProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abTestConfigProvider");
        }
        return abTestsConfigProvider;
    }

    @NotNull
    public final AccountStateProvider getAccountStateProvider() {
        AccountStateProvider accountStateProvider2 = this.accountStateProvider;
        if (accountStateProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountStateProvider");
        }
        return accountStateProvider2;
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
    public final Analytics getAnalytics$fees_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final PublishAnalyticsDataProvider getAnalyticsData$fees_release() {
        PublishAnalyticsDataProvider publishAnalyticsDataProvider = this.analyticsData;
        if (publishAnalyticsDataProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsData");
        }
        return publishAnalyticsDataProvider;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final FeesInteractor getFeesInteractor() {
        FeesInteractor feesInteractor2 = this.feesInteractor;
        if (feesInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feesInteractor");
        }
        return feesInteractor2;
    }

    @NotNull
    public final FeesPresenter getFeesPresenter() {
        FeesPresenter feesPresenter2 = this.feesPresenter;
        if (feesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feesPresenter");
        }
        return feesPresenter2;
    }

    public final Fragment getFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    @Override // com.avito.android.fees.PackageFeeListener
    public void onActivationDone() {
        Intent intent = new Intent();
        String str = this.k;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
        }
        Intent putExtra = intent.putExtra("itemId", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n            .pu…stants.ITEM_ID, advertId)");
        setResult(-1, putExtra);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            onActivationDone();
        }
        if (i == 1 && i2 == 0 && intent != null && (stringExtra = intent.getStringExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT)) != null) {
            Views.showSnackBar$default(getContainerView(), stringExtra, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ViewGroup viewGroup = (ViewGroup) findViewById(getContainerViewId());
        Intrinsics.checkNotNullExpressionValue(viewGroup, "container");
        int i = R.id.fragment_container;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, analytics2, false, 0, 24, null);
        progressOverlay.setOnRefreshListener(new a(this));
        this.l = progressOverlay;
    }

    @Override // com.avito.android.fees.SingleFeeListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        startActivity(deepLinkIntentFactory2.getIntent(deepLink));
    }

    @Override // com.avito.android.fees.FeesView
    public void onLoadingError() {
        ProgressOverlay progressOverlay = this.l;
        if (progressOverlay != null) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(progressOverlay, null, 1, null);
        }
    }

    @Override // com.avito.android.fees.FeesView
    public void onLoadingStart() {
        ProgressOverlay progressOverlay = this.l;
        if (progressOverlay != null) {
            progressOverlay.showLoading();
        }
    }

    @Override // com.avito.android.fees.FeesView
    public void onPackageFeeAvailable(@NotNull List<OwnedPackage> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "packages");
        ProgressOverlay progressOverlay = this.l;
        if (progressOverlay != null) {
            progressOverlay.showContent();
        }
        if (getFragment() == null) {
            PackageFeeFragment.Factory factory = new PackageFeeFragment.Factory();
            String str2 = this.k;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, factory.create(str2, list, str)).commitAllowingStateLoss();
        }
    }

    @Override // com.avito.android.fees.PackageFeeListener
    public void onPackageSelected(@NotNull AdvertFeesEntity advertFeesEntity, @NotNull List<AdvertFeesEntity> list) {
        Intrinsics.checkNotNullParameter(advertFeesEntity, "location");
        Intrinsics.checkNotNullParameter(list, "restrictions");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PackageParamsFragment.Factory().create(advertFeesEntity, list)).addToBackStack(null).setTransition(4097).commitAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        FeesInteractor feesInteractor2 = this.feesInteractor;
        if (feesInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feesInteractor");
        }
        feesInteractor2.onSaveState(bundle);
    }

    @Override // com.avito.android.fees.FeesView
    public void onSingleFeeAvailable(@NotNull SingleFee singleFee, @Nullable String str, @NotNull Action action) {
        Intrinsics.checkNotNullParameter(singleFee, "singleFee");
        Intrinsics.checkNotNullParameter(action, "action");
        ProgressOverlay progressOverlay = this.l;
        if (progressOverlay != null) {
            progressOverlay.showContent();
        }
        if (getFragment() == null) {
            SingleFeeFragment.Factory factory = new SingleFeeFragment.Factory();
            String str2 = this.k;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, factory.create(str2, singleFee, str, action)).commitAllowingStateLoss();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        FeesPresenter feesPresenter2 = this.feesPresenter;
        if (feesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feesPresenter");
        }
        feesPresenter2.subscribe(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        FeesPresenter feesPresenter2 = this.feesPresenter;
        if (feesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feesPresenter");
        }
        feesPresenter2.unsubscribe();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public void restoreActionBar() {
        String str;
        int i;
        Fragment fragment = getFragment();
        boolean z = fragment instanceof PackageParamsFragment;
        if (!z && !(fragment instanceof PackageFeeFragment)) {
            str = getString(R.string.placement);
        } else {
            str = getString(R.string.package_params);
        }
        Intrinsics.checkNotNullExpressionValue(str, "when (fragment) {\n      ….placement)\n            }");
        if (z || (fragment instanceof PackageFeeFragment) || (fragment instanceof SingleFeeFragment)) {
            i = R.drawable.ic_close_24_blue;
        } else {
            i = R.drawable.ic_back_24_blue;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(i);
        }
        showDefaultActionBar(str);
    }

    public final void setAbTestConfigProvider(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "<set-?>");
        this.abTestConfigProvider = abTestsConfigProvider;
    }

    public final void setAccountStateProvider(@NotNull AccountStateProvider accountStateProvider2) {
        Intrinsics.checkNotNullParameter(accountStateProvider2, "<set-?>");
        this.accountStateProvider = accountStateProvider2;
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics$fees_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAnalyticsData$fees_release(@NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "<set-?>");
        this.analyticsData = publishAnalyticsDataProvider;
    }

    public void setComponent(@NotNull FeesActivityComponent feesActivityComponent) {
        Intrinsics.checkNotNullParameter(feesActivityComponent, "<set-?>");
        this.component = feesActivityComponent;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setFeesInteractor(@NotNull FeesInteractor feesInteractor2) {
        Intrinsics.checkNotNullParameter(feesInteractor2, "<set-?>");
        this.feesInteractor = feesInteractor2;
    }

    public final void setFeesPresenter(@NotNull FeesPresenter feesPresenter2) {
        Intrinsics.checkNotNullParameter(feesPresenter2, "<set-?>");
        this.feesPresenter = feesPresenter2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("key_activity_item");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_ADVERT_ID)");
        this.k = stringExtra;
        getIntent().getBooleanExtra("key_is_from_publish", false);
        String str = this.k;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
        }
        setComponent(DaggerFeesActivityComponent.builder().dependencies((FeesActivityDependencies) ComponentDependenciesKt.getDependencies(FeesActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).feesActivityModule(new FeesActivityModule(str, bundle, this)).withActivity(this).build());
        getComponent().inject(this);
        return true;
    }

    @Override // com.avito.android.fees.SingleFeeListener
    public void showInfo() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.infoForPaidPlacementIntent());
    }

    @Override // com.avito.android.fees.SingleFeeListener
    public void showPayment(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        startActivityForResult(deepLinkIntentFactory2.getIntent(deepLink), 1);
    }

    @Override // com.avito.android.ComponentProvider
    @NotNull
    public FeesActivityComponent getComponent() {
        FeesActivityComponent feesActivityComponent = this.component;
        if (feesActivityComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        return feesActivityComponent;
    }

    @Override // com.avito.android.fees.FeesView
    public void onLoadingError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        ProgressOverlay progressOverlay = this.l;
        if (progressOverlay != null) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(progressOverlay, null, 1, null);
        }
        ToastsKt.showToast$default(this, str, 0, 2, (Object) null);
    }
}
