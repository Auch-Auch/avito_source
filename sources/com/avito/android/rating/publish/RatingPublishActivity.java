package com.avito.android.rating.publish;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.RatingPublishScreen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.analytics.screens.tracker.ScreenTransferKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.RatingPublishLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.rating.RatingParamsKt;
import com.avito.android.rating.publish.RatingPublishPresenter;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.buyer_info.BuyerInfoFragmentKt;
import com.avito.android.rating.publish.deal_proofs.DealProofsFragmentKt;
import com.avito.android.rating.publish.deal_stage.DealStageFragmentKt;
import com.avito.android.rating.publish.di.DaggerRatingPublishComponent;
import com.avito.android.rating.publish.di.RatingPublishComponent;
import com.avito.android.rating.publish.di.RatingPublishDependencies;
import com.avito.android.rating.publish.radio_select.RadioSelectFragmentKt;
import com.avito.android.rating.publish.review_input.ReviewInputFragmentKt;
import com.avito.android.rating.publish.select_advert.SelectAdvertFragmentKt;
import com.avito.android.rating.publish.select_advert.event.RatingPublishOpenEvent;
import com.avito.android.rating.publish.select_rating.SelectRatingFragmentKt;
import com.avito.android.rating.publish.tracker.RatingPublishTracker;
import com.avito.android.ratings.RatingPublishConfig;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.Keyboards;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\bd\u0010\u000bJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010#J\u001f\u0010&\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b*\u0010.J%\u00101\u001a\u00020\u00072\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d0/H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\u00072\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\b\u0010:\u001a\u0004\u0018\u000109H\u0014¢\u0006\u0004\b;\u0010<J\u0011\u0010>\u001a\u0004\u0018\u00010=H\u0002¢\u0006\u0004\b>\u0010?J\u001f\u0010B\u001a\u00020\u00072\u0006\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020\u001dH\u0002¢\u0006\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010P\u001a\u00020O8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010c¨\u0006e"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/rating/publish/RatingPublishPresenter$Router;", "Lcom/avito/android/rating/publish/StepListener$Holder;", "Lcom/avito/android/rating/publish/RatingPublishPresenter$StepHolder;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "onExit", "onBackPressed", "outState", "onSaveInstanceState", "Lcom/avito/android/rating/publish/StepListener;", "getStepListener", "()Lcom/avito/android/rating/publish/StepListener;", "Lcom/avito/android/rating/publish/RatingPublishStep;", "ratingPublishStep", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "openScreen", "(Lcom/avito/android/rating/publish/RatingPublishStep;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;)V", "", "rawRatingPublishStep", "Lcom/avito/android/rating/publish/RatingPublishStepType;", "ratingPublishStepType", "Lcom/avito/android/remote/model/publish/NextStagePayload;", "payload", "(Ljava/lang/String;Lcom/avito/android/rating/publish/RatingPublishStepType;Lcom/avito/android/remote/model/publish/NextStagePayload;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;)V", "userKey", "message", "closeWithMessage", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "reqId", "(Lcom/avito/android/deep_linking/links/DeepLink;I)V", "", "errors", "proxyErrors", "(Ljava/util/Map;)V", "", "isLoading", "proxyLoadingState", "(Z)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "()Landroidx/fragment/app/Fragment;", "fragment", "tag", AuthSource.SEND_ABUSE, "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Landroid/os/Handler;", "k", "Landroid/os/Handler;", "handler", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/rating/publish/RatingPublishPresenter;", "presenter", "Lcom/avito/android/rating/publish/RatingPublishPresenter;", "getPresenter", "()Lcom/avito/android/rating/publish/RatingPublishPresenter;", "setPresenter", "(Lcom/avito/android/rating/publish/RatingPublishPresenter;)V", "Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;", "tracker", "Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;", "getTracker", "()Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;", "setTracker", "(Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishActivity extends BaseActivity implements RatingPublishPresenter.Router, StepListener.Holder, RatingPublishPresenter.StepHolder {
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    public final Handler k = new Handler();
    @Inject
    public RatingPublishPresenter presenter;
    @Inject
    public RatingPublishTracker tracker;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            RatingPublishStep.values();
            int[] iArr = new int[8];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            iArr[4] = 5;
            iArr[6] = 6;
            iArr[7] = 7;
            iArr[5] = 8;
            RatingPublishStepType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[2] = 2;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ RatingPublishActivity a;
        public final /* synthetic */ Map b;

        public a(RatingPublishActivity ratingPublishActivity, Map map) {
            this.a = ratingPublishActivity;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Fragment currentFragment = this.a.getCurrentFragment();
            if (!(currentFragment instanceof StepHost)) {
                currentFragment = null;
            }
            StepHost stepHost = (StepHost) currentFragment;
            if (stepHost != null) {
                stepHost.handleErrors(this.b);
            }
        }
    }

    public final void a(Fragment fragment, String str) {
        String str2;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() == 0) {
            str2 = null;
        } else {
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            FragmentManager supportFragmentManager3 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "supportFragmentManager");
            FragmentManager.BackStackEntry backStackEntryAt = supportFragmentManager2.getBackStackEntryAt(supportFragmentManager3.getBackStackEntryCount() - 1);
            Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "supportFragmentManager.g….backStackEntryCount - 1)");
            str2 = backStackEntryAt.getName();
        }
        getSupportFragmentManager().popBackStackImmediate(str, 0);
        Fragment currentFragment = getCurrentFragment();
        if (currentFragment == null || (!Intrinsics.areEqual(str, str2)) || (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(fragment.getClass()), Reflection.getOrCreateKotlinClass(currentFragment.getClass())))) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
            int i = R.anim.fade_in;
            beginTransaction.setCustomAnimations(i, 0, i, 0);
            beginTransaction.replace(R.id.fragment_container, fragment, (String) null).addToBackStack(str).commitAllowingStateLoss();
        }
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter.Router
    public void closeWithMessage(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(str2, "message");
        setResult(-1, RatingParamsKt.putMessage(RatingParamsKt.putPublishedRatingUserKey(new Intent(), str), str2));
        finish();
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter.Router
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
        if (deepLink instanceof RatingPublishLink) {
            finish();
        }
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    public final Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
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
    public final RatingPublishPresenter getPresenter() {
        RatingPublishPresenter ratingPublishPresenter = this.presenter;
        if (ratingPublishPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return ratingPublishPresenter;
    }

    @Override // com.avito.android.rating.publish.StepListener.Holder
    @NotNull
    public StepListener getStepListener() {
        RatingPublishPresenter ratingPublishPresenter = this.presenter;
        if (ratingPublishPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return ratingPublishPresenter;
    }

    @NotNull
    public final RatingPublishTracker getTracker() {
        RatingPublishTracker ratingPublishTracker = this.tracker;
        if (ratingPublishTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return ratingPublishTracker;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 0) {
            if (i2 == -1) {
                RatingPublishPresenter ratingPublishPresenter = this.presenter;
                if (ratingPublishPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                ratingPublishPresenter.onActionSuccess();
            } else {
                finish();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        T t;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t != null && t.isAdded() && (t instanceof OnBackPressedListener)) {
                break;
            }
        }
        T t2 = t;
        if (t2 == null || !t2.onBackPressed()) {
            Keyboards.hideKeyboard(this);
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
            if (supportFragmentManager2.getBackStackEntryCount() > 1) {
                getSupportFragmentManager().popBackStack();
                RatingPublishPresenter ratingPublishPresenter = this.presenter;
                if (ratingPublishPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                ratingPublishPresenter.onPopScreen();
                return;
            }
            finish();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String context;
        ScreenTransfer screenTransfer;
        Timer B1 = a2.b.a.a.a.B1();
        RatingPublishComponent.Builder with = DaggerRatingPublishComponent.builder().dependentOn((RatingPublishDependencies) ComponentDependenciesKt.getDependencies(RatingPublishDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).with(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).with((Activity) this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        with.with(resources).with((RatingPublishPresenter.StepHolder) this).build().inject(this);
        RatingPublishTracker ratingPublishTracker = this.tracker;
        if (ratingPublishTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        ratingPublishTracker.trackDiInject(B1.elapsed());
        super.onCreate(bundle);
        if (bundle == null && (screenTransfer = (ScreenTransfer) getIntent().getParcelableExtra(ScreenTransferKt.SCREEN_TRANSFER_KEY)) != null) {
            RatingPublishTracker ratingPublishTracker2 = this.tracker;
            if (ratingPublishTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            ratingPublishTracker2.recover(screenTransfer);
        }
        RatingPublishTracker ratingPublishTracker3 = this.tracker;
        if (ratingPublishTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        ratingPublishTracker3.startInit();
        setContentView(com.avito.android.rating.R.layout.activity_rating_publish);
        RatingPublishTracker ratingPublishTracker4 = this.tracker;
        if (ratingPublishTracker4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        ratingPublishTracker4.trackInit();
        RatingPublishTracker ratingPublishTracker5 = this.tracker;
        if (ratingPublishTracker5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        ratingPublishTracker5.startDraw();
        RatingPublishPresenter ratingPublishPresenter = this.presenter;
        if (ratingPublishPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        ratingPublishPresenter.attachView(new RatingPublishViewImpl(findViewById));
        if (bundle == null) {
            RatingPublishConfig ratingPublishConfig = (RatingPublishConfig) getIntent().getParcelableExtra(Navigation.CONFIG);
            if (ratingPublishConfig != null) {
                RatingPublishPresenter ratingPublishPresenter2 = this.presenter;
                if (ratingPublishPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                ratingPublishPresenter2.handleConfig(ratingPublishConfig);
            }
            if (!(ratingPublishConfig == null || (context = ratingPublishConfig.getContext()) == null)) {
                Analytics analytics2 = this.analytics;
                if (analytics2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analytics");
                }
                analytics2.track(new RatingPublishOpenEvent(context));
            }
        }
        RatingPublishTracker ratingPublishTracker6 = this.tracker;
        if (ratingPublishTracker6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        ratingPublishTracker6.trackDraw();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        RatingPublishPresenter ratingPublishPresenter = this.presenter;
        if (ratingPublishPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ratingPublishPresenter.detachView();
        super.onDestroy();
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter.Router
    public void onExit() {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        RatingPublishPresenter ratingPublishPresenter = this.presenter;
        if (ratingPublishPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", ratingPublishPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        RatingPublishPresenter ratingPublishPresenter = this.presenter;
        if (ratingPublishPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ratingPublishPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.k.removeCallbacksAndMessages(null);
        RatingPublishPresenter ratingPublishPresenter = this.presenter;
        if (ratingPublishPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ratingPublishPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter.Router
    public void openScreen(@NotNull RatingPublishStep ratingPublishStep, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData) {
        String str;
        Fragment fragment;
        Intrinsics.checkNotNullParameter(ratingPublishStep, "ratingPublishStep");
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        switch (ratingPublishStep.ordinal()) {
            case 0:
                fragment = SelectAdvertFragmentKt.createSelectAdvertFragment(ratingPublishData, ratingPublishViewData, RatingPublishScreen.INSTANCE, true);
                str = "select_advert";
                break;
            case 1:
                fragment = DealStageFragmentKt.createDealStageFragment(ratingPublishData, ratingPublishViewData);
                str = "deal_stage";
                break;
            case 2:
                fragment = SelectRatingFragmentKt.createSelectRatingFragment(ratingPublishData, ratingPublishViewData);
                str = "select_rating";
                break;
            case 3:
                fragment = ReviewInputFragmentKt.createReviewInputFragment$default(ratingPublishData, ratingPublishViewData, null, 4, null);
                str = "review_input";
                break;
            case 4:
                fragment = DealProofsFragmentKt.createDealProofsFragment(ratingPublishData, ratingPublishViewData);
                str = "deal_proofs";
                break;
            case 5:
                fragment = DealProofsFragmentKt.createDealProofsFragment(ratingPublishData, ratingPublishViewData);
                str = "images";
                break;
            case 6:
                fragment = BuyerInfoFragmentKt.createBuyerInfoFragment(ratingPublishData, ratingPublishViewData);
                str = "buyer_info";
                break;
            case 7:
                fragment = DealProofsFragmentKt.createDealProofsFragment(ratingPublishData, ratingPublishViewData);
                str = "auto_deal_proofs";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        a(fragment, str);
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter.StepHolder
    public void proxyErrors(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "errors");
        this.k.post(new a(this, map));
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter.StepHolder
    public void proxyLoadingState(boolean z) {
        Fragment currentFragment = getCurrentFragment();
        if (!(currentFragment instanceof StepHost)) {
            currentFragment = null;
        }
        StepHost stepHost = (StepHost) currentFragment;
        if (stepHost != null) {
            stepHost.handleLoading(z);
        }
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull RatingPublishPresenter ratingPublishPresenter) {
        Intrinsics.checkNotNullParameter(ratingPublishPresenter, "<set-?>");
        this.presenter = ratingPublishPresenter;
    }

    public final void setTracker(@NotNull RatingPublishTracker ratingPublishTracker) {
        Intrinsics.checkNotNullParameter(ratingPublishTracker, "<set-?>");
        this.tracker = ratingPublishTracker;
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink, int i) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivityForResult(intent, i);
        }
    }

    @Override // com.avito.android.rating.publish.RatingPublishPresenter.Router
    public void openScreen(@NotNull String str, @NotNull RatingPublishStepType ratingPublishStepType, @NotNull NextStagePayload nextStagePayload, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData) {
        Fragment fragment;
        String str2;
        Intrinsics.checkNotNullParameter(str, "rawRatingPublishStep");
        Intrinsics.checkNotNullParameter(ratingPublishStepType, "ratingPublishStepType");
        Intrinsics.checkNotNullParameter(nextStagePayload, "payload");
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        int ordinal = ratingPublishStepType.ordinal();
        if (ordinal == 0) {
            fragment = RadioSelectFragmentKt.createRadioSelectFragment(ratingPublishData, ratingPublishViewData, nextStagePayload);
            str2 = a2.b.a.a.a.L2("radio_select_type", '_', str);
        } else if (ordinal == 2) {
            fragment = ReviewInputFragmentKt.createReviewInputFragment(ratingPublishData, ratingPublishViewData, nextStagePayload);
            str2 = a2.b.a.a.a.L2("review_input", '_', str);
        } else {
            throw new IllegalStateException();
        }
        a(fragment, str2);
    }
}
