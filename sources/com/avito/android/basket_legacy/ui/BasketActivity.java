package com.avito.android.basket_legacy.ui;

import a2.a.a.r.a.b;
import a2.a.a.r.a.c;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ComponentProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.MnzPaidServicesLegacyScreen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.basket.R;
import com.avito.android.basket_legacy.LegacyPaidServicesTracker;
import com.avito.android.basket_legacy.di.fees.FeesBasketModule;
import com.avito.android.basket_legacy.di.shared.BasketDependencies;
import com.avito.android.basket_legacy.di.shared.DaggerSharedBasketComponent;
import com.avito.android.basket_legacy.di.shared.SharedBasketComponent;
import com.avito.android.basket_legacy.di.shared.SharedModule;
import com.avito.android.basket_legacy.di.vas.PerformanceVasModule;
import com.avito.android.basket_legacy.ui.Router;
import com.avito.android.basket_legacy.utils.BasketStep;
import com.avito.android.basket_legacy.utils.ProgressState;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel;
import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModel;
import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModelFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.fees.PackageFeeListener;
import com.avito.android.fees.PackageParamsFragment;
import com.avito.android.fees.SingleFeeFragment;
import com.avito.android.fees.SingleFeeListener;
import com.avito.android.fees.refactor.MvvmPackageFeeFragment;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertFeesEntity;
import com.avito.android.remote.model.SingleFee;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.Constants;
import com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment;
import com.avito.android.vas_performance.ui.LegacyVisualVasFragment;
import dagger.Lazy;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u0006:\u0001fB\u0007¢\u0006\u0004\be\u0010\u0013J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u0013J%\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\"\u0010\u0011J\u000f\u0010#\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010\u0013J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010'J\u0017\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100R(\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010R\u001a\u00020\u00038\u0016@\u0016X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0018\u0010Y\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010PR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010_\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d¨\u0006g"}, d2 = {"Lcom/avito/android/basket_legacy/ui/BasketActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/ComponentProvider;", "Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent;", "Lcom/avito/android/fees/PackageFeeListener;", "Lcom/avito/android/basket_legacy/ui/Router;", "Lcom/avito/android/fees/SingleFeeListener;", "Landroidx/fragment/app/Fragment;", "fragment", "", "addToStack", "", AuthSource.SEND_ABUSE, "(Landroidx/fragment/app/Fragment;Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onActivationDone", "()V", "onBackPressed", "enableAppRater", "finishFlow", "(Z)V", "startVasSelection", "onPerformanceVasCompleted", "onVisualVasCompleted", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "location", "", "restrictions", "onPackageSelected", "(Lcom/avito/android/remote/model/AdvertFeesEntity;Ljava/util/List;)V", "outState", "onSaveInstanceState", "showInfo", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "showPayment", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onDeepLinkClick", "Landroid/view/Menu;", "menu", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "Ldagger/Lazy;", "Lcom/avito/android/basket_legacy/viewmodels/activity/BasketViewModel;", "viewModelProvider", "Ldagger/Lazy;", "getViewModelProvider", "()Ldagger/Lazy;", "setViewModelProvider", "(Ldagger/Lazy;)V", "Lcom/avito/android/basket_legacy/LegacyPaidServicesTracker;", "tracker", "Lcom/avito/android/basket_legacy/LegacyPaidServicesTracker;", "getTracker", "()Lcom/avito/android/basket_legacy/LegacyPaidServicesTracker;", "setTracker", "(Lcom/avito/android/basket_legacy/LegacyPaidServicesTracker;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "l", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "o", "Z", "isFees", "", "k", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "component", "Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent;", "getComponent", "()Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent;", "setComponent", "(Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent;)V", "n", "openedFrom", "Landroid/content/Intent;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/content/Intent;", "basketUpIntent", "Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModelFactory;", "factory", "Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModelFactory;", "getFactory", "()Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModelFactory;", "setFactory", "(Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModelFactory;)V", "<init>", "Companion", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class BasketActivity extends BaseActivity implements ComponentProvider<SharedBasketComponent>, PackageFeeListener, Router, SingleFeeListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String ITEM_ID = "item_id";
    @NotNull
    public static final String KEY_FEES = "fees_required";
    @NotNull
    public static final String KEY_OPENED_FROM = "opened_from";
    @NotNull
    public static final String KEY_VAS_CONTEXT = "vas_context";
    @NotNull
    public static final String KEY_VAS_TYPE = "vas_type";
    @NotNull
    public static final String STATE_BASKET = "state";
    @NotNull
    public static final String VAS_CONTEXT_DEFAULT = "default";
    @NotNull
    public static final String VAS_TYPE_PERFORMANCE = "performance";
    @Inject
    public Analytics analytics;
    public SharedBasketComponent component;
    @Inject
    public SharedBasketViewModelFactory factory;
    public String k;
    public ProgressOverlay l;
    public Intent m;
    public String n;
    public boolean o;
    @Inject
    public LegacyPaidServicesTracker tracker;
    @Inject
    public Lazy<BasketViewModel> viewModelProvider;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/avito/android/basket_legacy/ui/BasketActivity$Companion;", "", "", "ITEM_ID", "Ljava/lang/String;", "KEY_FEES", "KEY_OPENED_FROM", "KEY_VAS_CONTEXT", "KEY_VAS_TYPE", "STATE_BASKET", "VAS_CONTEXT_DEFAULT", "VAS_TYPE_PERFORMANCE", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ProgressState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            VasType.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            VasType vasType = VasType.PERFORMANCE;
            iArr2[0] = 1;
            VasType vasType2 = VasType.VISUAL;
            iArr2[1] = 2;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BasketActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BasketActivity basketActivity) {
            super(0);
            this.a = basketActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModelProvider().get().onRetryClicked();
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ String access$getAdvertId$p(BasketActivity basketActivity) {
        String str = basketActivity.k;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
        }
        return str;
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(BasketActivity basketActivity) {
        ProgressOverlay progressOverlay = basketActivity.l;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final void access$openBasket(BasketActivity basketActivity) {
        Objects.requireNonNull(basketActivity);
        basketActivity.a(LegacyCheckoutFragment.Companion.newInstance(basketActivity.n), true);
    }

    public static final void access$openFees(BasketActivity basketActivity, String str, List list, String str2) {
        Objects.requireNonNull(basketActivity);
        basketActivity.a(MvvmPackageFeeFragment.Companion.newInstance$default(MvvmPackageFeeFragment.Companion, str, list, str2, basketActivity.getString(R.string.basket_title), false, 16, null), false);
    }

    public static final void access$openLfSingleFee(BasketActivity basketActivity, String str, SingleFee singleFee, String str2, Action action) {
        Objects.requireNonNull(basketActivity);
        basketActivity.a(new SingleFeeFragment.Factory().create(str, singleFee, str2, action), false);
    }

    public static final void access$openVas(BasketActivity basketActivity, BasketStep.VasChoice vasChoice) {
        Fragment fragment;
        Objects.requireNonNull(basketActivity);
        int ordinal = vasChoice.getType().ordinal();
        if (ordinal == 0) {
            fragment = LegacyPerformanceVasFragment.Companion.newInstance(vasChoice.getCanGoBack());
        } else if (ordinal == 1) {
            fragment = LegacyVisualVasFragment.Companion.newInstance();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        basketActivity.a(fragment, vasChoice.getCanGoBack());
    }

    public final void a(Fragment fragment, boolean z) {
        FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);
        Intrinsics.checkNotNullExpressionValue(replace, "supportFragmentManager\n …R.id.container, fragment)");
        if (z) {
            replace.addToBackStack(fragment.getClass().getCanonicalName());
        }
        replace.commitAllowingStateLoss();
    }

    @Override // com.avito.android.basket_legacy.ui.Router
    public void finishFlow(boolean z) {
        setResult(-1);
        Intent intent = this.m;
        if (intent != null) {
            intent.putExtra(Constants.SHOW_APP_RATER, z);
            startActivity(intent);
        }
        finish();
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
    public final SharedBasketViewModelFactory getFactory() {
        SharedBasketViewModelFactory sharedBasketViewModelFactory = this.factory;
        if (sharedBasketViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("factory");
        }
        return sharedBasketViewModelFactory;
    }

    @NotNull
    public final LegacyPaidServicesTracker getTracker() {
        LegacyPaidServicesTracker legacyPaidServicesTracker = this.tracker;
        if (legacyPaidServicesTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return legacyPaidServicesTracker;
    }

    @NotNull
    public final Lazy<BasketViewModel> getViewModelProvider() {
        Lazy<BasketViewModel> lazy = this.viewModelProvider;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        }
        return lazy;
    }

    @Override // com.avito.android.fees.PackageFeeListener
    public void onActivationDone() {
        Lazy<BasketViewModel> lazy = this.viewModelProvider;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        }
        lazy.get().onLfPackageSelected();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() == 0 && (intent = this.m) != null) {
            startActivity(intent);
        }
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("item_id");
        if (stringExtra != null) {
            this.k = stringExtra;
            this.m = (Intent) getIntent().getParcelableExtra(Constants.UP_INTENT);
            boolean booleanExtra = getIntent().getBooleanExtra(KEY_FEES, true);
            List parcelableList = bundle != null ? Bundles.getParcelableList(bundle, "state") : null;
            String stringExtra2 = getIntent().getStringExtra(KEY_VAS_CONTEXT);
            if (stringExtra2 == null) {
                stringExtra2 = "default";
            }
            String stringExtra3 = getIntent().getStringExtra(KEY_VAS_TYPE);
            if (stringExtra3 == null) {
                stringExtra3 = "performance";
            }
            this.n = getIntent().getStringExtra(KEY_OPENED_FROM);
            String str = this.k;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
            }
            String str2 = this.n;
            Timer B1 = a2.b.a.a.a.B1();
            setComponent(DaggerSharedBasketComponent.builder().basketDependencies((BasketDependencies) ComponentDependenciesKt.getDependencies(BasketDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).sharedModule(new SharedModule(str, booleanExtra, stringExtra2, stringExtra3, this, parcelableList)).packageFeesModule(new FeesBasketModule()).performanceVasModule(new PerformanceVasModule(str2)).withScreen(MnzPaidServicesLegacyScreen.INSTANCE).withSubComponents(true).build());
            getComponent().inject(this);
            LegacyPaidServicesTracker legacyPaidServicesTracker = this.tracker;
            if (legacyPaidServicesTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            legacyPaidServicesTracker.trackDiInject(B1.elapsed());
            LegacyPaidServicesTracker legacyPaidServicesTracker2 = this.tracker;
            if (legacyPaidServicesTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            legacyPaidServicesTracker2.startInit();
            super.onCreate(bundle);
            setContentView(R.layout.basket_activity);
            View findViewById = findViewById(R.id.container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.container)");
            ViewGroup viewGroup = (ViewGroup) findViewById;
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, 0, analytics2, false, 0, 26, null);
            this.l = progressOverlay;
            if (progressOverlay == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
            }
            progressOverlay.setOnRefreshListener(new a(this));
            Lazy<BasketViewModel> lazy = this.viewModelProvider;
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
            }
            lazy.get().getRouterEvents().observe(this, new a2.a.a.r.a.a(this));
            Lazy<BasketViewModel> lazy2 = this.viewModelProvider;
            if (lazy2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
            }
            lazy2.get().getProgressEvents().observe(this, new b(this));
            Lazy<BasketViewModel> lazy3 = this.viewModelProvider;
            if (lazy3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
            }
            lazy3.get().getStartActivityEvents().observe(this, new c(this));
            LegacyPaidServicesTracker legacyPaidServicesTracker3 = this.tracker;
            if (legacyPaidServicesTracker3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            legacyPaidServicesTracker3.trackInit();
            return;
        }
        throw new RuntimeException("advertId must be set");
    }

    @Override // com.avito.android.ui.activity.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        String str;
        Intrinsics.checkNotNullParameter(menu, "menu");
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            Intrinsics.checkNotNullExpressionValue(supportActionBar, "it");
            if (this.o) {
                str = getString(com.avito.android.fees.R.string.package_params);
            } else {
                str = getString(com.avito.android.fees.R.string.placement);
            }
            supportActionBar.setTitle(str);
            supportActionBar.setHomeAsUpIndicator(com.avito.android.ui_components.R.drawable.ic_close_24_blue);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.avito.android.fees.SingleFeeListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Lazy<BasketViewModel> lazy = this.viewModelProvider;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        }
        lazy.get().onDeeplinkClicked(deepLink);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        Router.DefaultImpls.finishFlow$default(this, false, 1, null);
        return true;
    }

    @Override // com.avito.android.fees.PackageFeeListener
    public void onPackageSelected(@NotNull AdvertFeesEntity advertFeesEntity, @NotNull List<AdvertFeesEntity> list) {
        Intrinsics.checkNotNullParameter(advertFeesEntity, "location");
        Intrinsics.checkNotNullParameter(list, "restrictions");
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PackageParamsFragment.Factory().create(advertFeesEntity, list)).addToBackStack(null).setTransition(4097).commitAllowingStateLoss();
    }

    @Override // com.avito.android.vas_performance.VasCompletionListener
    public void onPerformanceVasCompleted() {
        Lazy<BasketViewModel> lazy = this.viewModelProvider;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        }
        lazy.get().onPerformanceVasSelected();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SharedBasketViewModelFactory sharedBasketViewModelFactory = this.factory;
        if (sharedBasketViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("factory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, sharedBasketViewModelFactory).get(SharedBasketViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        Bundles.putParcelableList(bundle, "state", ((SharedBasketViewModel) viewModel).getSelectedServices());
    }

    @Override // com.avito.android.vas_performance.VasCompletionListener
    public void onVisualVasCompleted() {
        Lazy<BasketViewModel> lazy = this.viewModelProvider;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        }
        lazy.get().onVisualVasSelected();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public void setComponent(@NotNull SharedBasketComponent sharedBasketComponent) {
        Intrinsics.checkNotNullParameter(sharedBasketComponent, "<set-?>");
        this.component = sharedBasketComponent;
    }

    public final void setFactory(@NotNull SharedBasketViewModelFactory sharedBasketViewModelFactory) {
        Intrinsics.checkNotNullParameter(sharedBasketViewModelFactory, "<set-?>");
        this.factory = sharedBasketViewModelFactory;
    }

    public final void setTracker(@NotNull LegacyPaidServicesTracker legacyPaidServicesTracker) {
        Intrinsics.checkNotNullParameter(legacyPaidServicesTracker, "<set-?>");
        this.tracker = legacyPaidServicesTracker;
    }

    public final void setViewModelProvider(@NotNull Lazy<BasketViewModel> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.viewModelProvider = lazy;
    }

    @Override // com.avito.android.fees.SingleFeeListener
    public void showInfo() {
        Lazy<BasketViewModel> lazy = this.viewModelProvider;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        }
        lazy.get().onShowSingleFeeInfoClicked();
    }

    @Override // com.avito.android.fees.SingleFeeListener
    public void showPayment(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Lazy<BasketViewModel> lazy = this.viewModelProvider;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
        }
        lazy.get().onSingleFeeSelected();
    }

    @Override // com.avito.android.basket_legacy.ui.Router
    public void startVasSelection() {
        getSupportFragmentManager().popBackStack(LegacyVisualVasFragment.class.getCanonicalName(), 1);
    }

    @Override // com.avito.android.ComponentProvider
    @NotNull
    public SharedBasketComponent getComponent() {
        SharedBasketComponent sharedBasketComponent = this.component;
        if (sharedBasketComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        return sharedBasketComponent;
    }
}
