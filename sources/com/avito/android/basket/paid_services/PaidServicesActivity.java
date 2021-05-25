package com.avito.android.basket.paid_services;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.ComponentProvider;
import com.avito.android.analytics.screens.MnzPaidServicesScreen;
import com.avito.android.basket.R;
import com.avito.android.basket.paid_services.di.DaggerPaidServicesComponent;
import com.avito.android.basket.paid_services.di.PaidServicesComponent;
import com.avito.android.basket.paid_services.di.PaidServicesDependencies;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.paid_services.routing.DialogInfo;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.dialog.TariffDialogActivityKt;
import com.avito.android.tariff.routing.PaidServiceDeeplinkHandler;
import com.avito.android.tariff.routing.RoutingAction;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.IntentsKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 22\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u00012B\u0007¢\u0006\u0004\b1\u0010\u000bJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00038\u0016@\u0016X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/avito/android/basket/paid_services/PaidServicesActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/ComponentProvider;", "Lcom/avito/android/basket/paid_services/di/PaidServicesComponent;", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "Lcom/avito/android/paid_services/routing/DialogInfo;", "dialogInfo", "finishFlow", "(Lcom/avito/android/paid_services/routing/DialogInfo;)V", "", "activityResult", "finishFlowWithResult", "(Lcom/avito/android/paid_services/routing/DialogInfo;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "navigate", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "", "addToStack", AuthSource.BOOKING_ORDER, "(Landroid/content/Intent;Z)V", "Landroidx/fragment/app/Fragment;", "fragment", AuthSource.SEND_ABUSE, "(Landroidx/fragment/app/Fragment;Z)V", "Lcom/avito/android/tariff/routing/PaidServiceDeeplinkHandler;", "deeplinkHandler", "Lcom/avito/android/tariff/routing/PaidServiceDeeplinkHandler;", "getDeeplinkHandler", "()Lcom/avito/android/tariff/routing/PaidServiceDeeplinkHandler;", "setDeeplinkHandler", "(Lcom/avito/android/tariff/routing/PaidServiceDeeplinkHandler;)V", "component", "Lcom/avito/android/basket/paid_services/di/PaidServicesComponent;", "getComponent", "()Lcom/avito/android/basket/paid_services/di/PaidServicesComponent;", "setComponent", "(Lcom/avito/android/basket/paid_services/di/PaidServicesComponent;)V", "<init>", "Companion", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class PaidServicesActivity extends BaseActivity implements ComponentProvider<PaidServicesComponent>, PaidServicesRouter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_DEEPLINK = "deeplink";
    public PaidServicesComponent component;
    @Inject
    public PaidServiceDeeplinkHandler deeplinkHandler;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/basket/paid_services/PaidServicesActivity$Companion;", "", "", "KEY_DEEPLINK", "Ljava/lang/String;", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public final void a(Fragment fragment, boolean z) {
        FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);
        Intrinsics.checkNotNullExpressionValue(replace, "supportFragmentManager\n …R.id.container, fragment)");
        if (z) {
            replace.addToBackStack(fragment.getClass().getCanonicalName());
        }
        replace.commitAllowingStateLoss();
    }

    public final void b(Intent intent, boolean z) {
        DeepLink deepLink = intent != null ? (DeepLink) intent.getParcelableExtra("deeplink") : null;
        if (deepLink != null) {
            PaidServiceDeeplinkHandler paidServiceDeeplinkHandler = this.deeplinkHandler;
            if (paidServiceDeeplinkHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deeplinkHandler");
            }
            RoutingAction resolveDeeplink$default = PaidServiceDeeplinkHandler.DefaultImpls.resolveDeeplink$default(paidServiceDeeplinkHandler, deepLink, false, 2, null);
            if (resolveDeeplink$default instanceof RoutingAction.FragmentRoutingAction) {
                a(((RoutingAction.FragmentRoutingAction) resolveDeeplink$default).getFragment(), z);
            }
        }
    }

    @Override // com.avito.android.paid_services.routing.PaidServicesRouter
    public void finishFlow(@Nullable DialogInfo dialogInfo) {
        Intent createTariffDialogActivityIntent = dialogInfo != null ? TariffDialogActivityKt.createTariffDialogActivityIntent(this, dialogInfo) : null;
        Intent upIntent = getUpIntent();
        if (upIntent == null || !IntentsKt.getHasNestedIntentSupport(upIntent) || createTariffDialogActivityIntent == null) {
            boolean z = false;
            Object[] array = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Intent[]{getUpIntent(), createTariffDialogActivityIntent}).toArray(new Intent[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Intent[] intentArr = (Intent[]) array;
            if (intentArr.length == 0) {
                z = true;
            }
            if (!z) {
                startActivities(intentArr);
            }
        } else {
            IntentsKt.setNestedIntent(upIntent, createTariffDialogActivityIntent);
            startActivity(upIntent);
        }
        finish();
    }

    @Override // com.avito.android.paid_services.routing.PaidServicesRouter
    public void finishFlowWithResult(@Nullable DialogInfo dialogInfo, int i) {
        setResult(i);
        finishFlow(dialogInfo);
    }

    @NotNull
    public final PaidServiceDeeplinkHandler getDeeplinkHandler() {
        PaidServiceDeeplinkHandler paidServiceDeeplinkHandler = this.deeplinkHandler;
        if (paidServiceDeeplinkHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkHandler");
        }
        return paidServiceDeeplinkHandler;
    }

    @Override // com.avito.android.paid_services.routing.PaidServicesRouter
    public void navigate(@NotNull DeepLink deepLink) {
        RoutingAction.ActivityRoutingAction activityRoutingAction;
        Intent intent;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        PaidServiceDeeplinkHandler paidServiceDeeplinkHandler = this.deeplinkHandler;
        if (paidServiceDeeplinkHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deeplinkHandler");
        }
        RoutingAction resolveDeeplink$default = PaidServiceDeeplinkHandler.DefaultImpls.resolveDeeplink$default(paidServiceDeeplinkHandler, deepLink, false, 2, null);
        if (resolveDeeplink$default instanceof RoutingAction.FragmentRoutingAction) {
            a(((RoutingAction.FragmentRoutingAction) resolveDeeplink$default).getFragment(), true);
        } else if ((resolveDeeplink$default instanceof RoutingAction.ActivityRoutingAction) && (intent = (activityRoutingAction = (RoutingAction.ActivityRoutingAction) resolveDeeplink$default).getIntent()) != null) {
            startActivity(intent);
            if (activityRoutingAction.getShouldFinish()) {
                finish();
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent upIntent;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() == 0 && (upIntent = getUpIntent()) != null) {
            startActivity(upIntent);
        }
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PaidServicesComponent.Builder screen = DaggerPaidServicesComponent.builder().dependencies((PaidServicesDependencies) ComponentDependenciesKt.getDependencies(PaidServicesDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).screen(MnzPaidServicesScreen.INSTANCE);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        setComponent(screen.resources(resources).build());
        getComponent().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.basket_activity);
        if (bundle == null) {
            b(getIntent(), false);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        b(intent, true);
    }

    public void setComponent(@NotNull PaidServicesComponent paidServicesComponent) {
        Intrinsics.checkNotNullParameter(paidServicesComponent, "<set-?>");
        this.component = paidServicesComponent;
    }

    public final void setDeeplinkHandler(@NotNull PaidServiceDeeplinkHandler paidServiceDeeplinkHandler) {
        Intrinsics.checkNotNullParameter(paidServiceDeeplinkHandler, "<set-?>");
        this.deeplinkHandler = paidServiceDeeplinkHandler;
    }

    @Override // com.avito.android.ComponentProvider
    @NotNull
    public PaidServicesComponent getComponent() {
        PaidServicesComponent paidServicesComponent = this.component;
        if (paidServicesComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        return paidServicesComponent;
    }
}
