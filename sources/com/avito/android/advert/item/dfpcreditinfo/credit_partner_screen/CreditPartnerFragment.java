package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen;

import a2.a.a.f.x.t.j.b;
import a2.a.a.f.x.t.j.c;
import a2.a.a.f.x.t.j.d;
import a2.a.a.f.x.t.j.e;
import a2.a.a.f.x.t.j.f;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di.DaggerCreditPartnerComponent;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractorKt;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.design.widget.circular_progress.CircularProgressBar;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.ui.view.PowerWebViewWrapper;
import com.avito.android.ui.view.PowerWebViewWrapperImpl;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.google.android.material.snackbar.Snackbar;
import com.vk.sdk.api.VKApiConst;
import com.yatatsu.powerwebview.PowerWebView;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0016J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onBackPressed", "()Z", "onDestroy", "()V", "Landroidx/appcompat/widget/Toolbar;", "k", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/design/widget/circular_progress/CircularProgressBar;", "l", "Lcom/avito/android/design/widget/circular_progress/CircularProgressBar;", "progress", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", VKApiConst.Q, "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/SravniWebAnalyticsHandler;", "sravniWebAnalyticsHandler", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/SravniWebAnalyticsHandler;", "getSravniWebAnalyticsHandler", "()Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/SravniWebAnalyticsHandler;", "setSravniWebAnalyticsHandler", "(Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/SravniWebAnalyticsHandler;)V", "Lcom/google/android/material/snackbar/Snackbar;", "o", "Lcom/google/android/material/snackbar/Snackbar;", "retrySnackbar", "Lcom/yatatsu/powerwebview/PowerWebView;", "j", "Lcom/yatatsu/powerwebview/PowerWebView;", "webView", "Lcom/avito/android/ui/view/PowerWebViewWrapper;", "n", "Lcom/avito/android/ui/view/PowerWebViewWrapper;", "powerWebView", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "p", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Landroid/widget/ImageView;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/ImageView;", "partnerLogo", "<init>", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CreditPartnerFragment extends TabBaseFragment implements OnBackPressedListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String SRAVNI_TAG = "SravniCreditPartner";
    @NotNull
    public static final String TINKOFF_TAG = "TinkoffCreditPartner";
    public PowerWebView j;
    public Toolbar k;
    public CircularProgressBar l;
    public ImageView m;
    public PowerWebViewWrapper n;
    public Snackbar o;
    public final CompositeDisposable p = new CompositeDisposable();
    @NotNull
    public NavigationState q = new NavigationState(false);
    @Inject
    public SravniWebAnalyticsHandler sravniWebAnalyticsHandler;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerFragment$Companion;", "", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerArguments;", "arguments", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerFragment;", "newInstance", "(Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerArguments;)Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerFragment;", "", "SRAVNI_TAG", "Ljava/lang/String;", "TINKOFF_TAG", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ CreditPartnerArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(CreditPartnerArguments creditPartnerArguments) {
                super(1);
                this.a = creditPartnerArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final CreditPartnerFragment newInstance(@NotNull CreditPartnerArguments creditPartnerArguments) {
            Intrinsics.checkNotNullParameter(creditPartnerArguments, "arguments");
            return (CreditPartnerFragment) FragmentsKt.arguments$default(new CreditPartnerFragment(), 0, new a(creditPartnerArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            CreditPartner.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final void access$showErrorSnackbar(CreditPartnerFragment creditPartnerFragment, boolean z) {
        Snackbar snackbar;
        View view = creditPartnerFragment.getView();
        if (view != null) {
            snackbar = Views.showSnackBar$default(view, z ? R.string.something_went_wrong : R.string.connection_problem, -2, Integer.valueOf(R.string.try_again), 0, new f(creditPartnerFragment), (Function0) null, 0, 104, (Object) null);
        } else {
            snackbar = null;
        }
        creditPartnerFragment.o = snackbar;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.q;
    }

    @NotNull
    public final SravniWebAnalyticsHandler getSravniWebAnalyticsHandler() {
        SravniWebAnalyticsHandler sravniWebAnalyticsHandler2 = this.sravniWebAnalyticsHandler;
        if (sravniWebAnalyticsHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sravniWebAnalyticsHandler");
        }
        return sravniWebAnalyticsHandler2;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        PowerWebViewWrapper powerWebViewWrapper = this.n;
        if (powerWebViewWrapper != null) {
            return powerWebViewWrapper.goBack();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(com.avito.android.advert_details.R.layout.credit_partner_form_fragment, viewGroup, false);
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Snackbar snackbar = this.o;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        this.o = null;
        PowerWebView powerWebView = this.j;
        if (powerWebView != null) {
            powerWebView.destroy();
        }
        SravniWebAnalyticsHandler sravniWebAnalyticsHandler2 = this.sravniWebAnalyticsHandler;
        if (sravniWebAnalyticsHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sravniWebAnalyticsHandler");
        }
        sravniWebAnalyticsHandler2.destroy();
        this.p.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        CreditPartnerArguments creditPartnerArguments;
        PowerWebViewWrapper powerWebViewWrapper;
        Drawable drawable;
        View view2;
        Context context;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (creditPartnerArguments = (CreditPartnerArguments) arguments.getParcelable("arguments")) == null) {
            throw new IllegalArgumentException("CreditPartnerArguments must be specified");
        }
        View findViewById = view.findViewById(com.avito.android.advert_details.R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.k = (Toolbar) findViewById;
        View findViewById2 = view.findViewById(com.avito.android.advert_details.R.id.progress);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.design.widget.circular_progress.CircularProgressBar");
        this.l = (CircularProgressBar) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.advert_details.R.id.credit_partner_logo);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.m = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(com.avito.android.advert_details.R.id.web_view);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.yatatsu.powerwebview.PowerWebView");
        PowerWebView powerWebView = (PowerWebView) findViewById4;
        this.j = powerWebView;
        this.n = new PowerWebViewWrapperImpl(powerWebView);
        Toolbar toolbar = this.k;
        if (!(toolbar == null || (view2 = getView()) == null || (context = view2.getContext()) == null)) {
            Toolbars.setBackIconByAttr(toolbar, com.avito.android.lib.design.R.attr.black);
            int i = com.avito.android.lib.design.R.attr.blue;
            Toolbars.tintMenuByAttr(toolbar, i);
            Drawable overflowIcon = toolbar.getOverflowIcon();
            if (overflowIcon != null) {
                overflowIcon.setTint(Contexts.getColorByAttr(context, i));
            }
            toolbar.setTitle(context.getString(com.avito.android.advert_details.R.string.advert_details_credit_application));
            Toolbars.upClicks(toolbar).subscribe(new b(this));
        }
        PowerWebView powerWebView2 = this.j;
        if (powerWebView2 != null && (powerWebViewWrapper = this.n) != null) {
            CreditPartner partner = creditPartnerArguments.getPartner();
            boolean z = partner == CreditPartner.SRAVNI;
            String str = z ? SRAVNI_TAG : TINKOFF_TAG;
            if (z) {
                SravniWebAnalyticsHandler sravniWebAnalyticsHandler2 = this.sravniWebAnalyticsHandler;
                if (sravniWebAnalyticsHandler2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sravniWebAnalyticsHandler");
                }
                sravniWebAnalyticsHandler2.attach(powerWebView2, powerWebViewWrapper);
            }
            ImageView imageView = this.m;
            if (imageView != null) {
                int ordinal = partner.ordinal();
                if (ordinal == 0) {
                    drawable = ContextCompat.getDrawable(requireContext(), com.avito.android.advert_details.R.drawable.sravni_credit_partner_logo);
                } else if (ordinal == 1) {
                    drawable = ContextCompat.getDrawable(requireContext(), com.avito.android.advert_details.R.drawable.tinkoff_credit_partner_logo);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                imageView.setImageDrawable(drawable);
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            powerWebView2.setBackgroundColor(Contexts.getColorByAttr(requireContext, com.avito.android.lib.design.R.attr.transparentBlack));
            powerWebView2.setLayerType(2, null);
            powerWebView2.setHorizontalScrollBarEnabled(false);
            powerWebView2.setHttpErrorHandlerDelegate(new PartnerHttpErrorHandlerDelegate(str, new c(this)));
            CompositeDisposable compositeDisposable = this.p;
            Disposable subscribe = powerWebViewWrapper.getStateChangeEvents().subscribe(new d(this, powerWebView2, str), new e(str));
            Intrinsics.checkNotNullExpressionValue(subscribe, "powerWebView.stateChange… { Logs.error(tag, it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            String uri = creditPartnerArguments.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "args.url.toString()");
            powerWebView2.loadUrl(uri);
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.q = navigationState;
    }

    public final void setSravniWebAnalyticsHandler(@NotNull SravniWebAnalyticsHandler sravniWebAnalyticsHandler2) {
        Intrinsics.checkNotNullParameter(sravniWebAnalyticsHandler2, "<set-?>");
        this.sravniWebAnalyticsHandler = sravniWebAnalyticsHandler2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        CreditPartnerArguments creditPartnerArguments;
        Bundle arguments = getArguments();
        if (arguments == null || (creditPartnerArguments = (CreditPartnerArguments) arguments.getParcelable("arguments")) == null) {
            throw new IllegalArgumentException("CreditPartnerArguments must be specified");
        }
        DaggerCreditPartnerComponent.builder().dependencies((CoreComponentDependencies) ComponentDependenciesKt.getDependencies(CoreComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withAdvertId(creditPartnerArguments.getAdvertId()).withBrokerState(new Kundle().putString(CreditBrokerAnalyticsInteractorKt.KEY_SESSION, creditPartnerArguments.getBrokerSession())).build().inject(this);
        return true;
    }
}
