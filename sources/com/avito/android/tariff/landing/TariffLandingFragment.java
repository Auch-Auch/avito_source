package com.avito.android.tariff.landing;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.landing.di.DaggerLandingComponent;
import com.avito.android.tariff.landing.viewmodel.TariffLanding;
import com.avito.android.tariff.landing.viewmodel.TariffLandingViewModel;
import com.avito.android.util.Views;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedRecyclerView;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedValue;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 _2\u00020\u0001:\u0001_B\u0007¢\u0006\u0004\b^\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R+\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR5\u0010\"\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030 ¢\u0006\u0002\b!0\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R+\u00104\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020/8B@BX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0019\u001a\u0004\b\u0018\u00101\"\u0004\b2\u00103R+\u0010;\u001a\u0002052\u0006\u0010\u0017\u001a\u0002058B@BX\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0019\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R+\u0010\n\u001a\u00020<2\u0006\u0010\u0017\u001a\u00020<8B@BX\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0019\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR+\u0010R\u001a\u00020M2\u0006\u0010\u0017\u001a\u00020M8B@BX\u0002¢\u0006\u0012\n\u0004\b7\u0010N\u001a\u0004\b0\u0010O\"\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010X\u001a\u00020W8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006`"}, d2 = {"Lcom/avito/android/tariff/landing/TariffLandingFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onDetach", "Landroidx/appcompat/widget/Toolbar;", "<set-?>", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "setProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progressOverlay", "Lcom/avito/android/lib/design/button/Button;", "d", AuthSource.SEND_ABUSE, "()Lcom/avito/android/lib/design/button/Button;", "setButton", "(Lcom/avito/android/lib/design/button/Button;)V", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/widget/FrameLayout;", "e", "getContainer", "()Landroid/widget/FrameLayout;", "setContainer", "(Landroid/widget/FrameLayout;)V", "Lio/reactivex/disposables/Disposable;", a2.g.r.g.a, "Lio/reactivex/disposables/Disposable;", "subscription", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "f", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModel;", "viewModel", "Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModel;", "getViewModel", "()Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModel;", "setViewModel", "(Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModel;)V", "<init>", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffLandingFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] h = {a2.b.a.a.a.u0(TariffLandingFragment.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0), a2.b.a.a.a.u0(TariffLandingFragment.class, "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;", 0), a2.b.a.a.a.u0(TariffLandingFragment.class, "progressOverlay", "getProgressOverlay()Lcom/avito/android/progress_overlay/ProgressOverlay;", 0), a2.b.a.a.a.u0(TariffLandingFragment.class, PhonePageSourceKt.PHONE_SOURCE_BUTTON, "getButton()Lcom/avito/android/lib/design/button/Button;", 0), a2.b.a.a.a.u0(TariffLandingFragment.class, "container", "getContainer()Landroid/widget/FrameLayout;", 0)};
    public final AutoClearedRecyclerView a = new AutoClearedRecyclerView();
    @Inject
    public AdapterPresenter adapterPresenter;
    public final AutoClearedValue b = new AutoClearedValue();
    public final AutoClearedValue c = new AutoClearedValue();
    public final AutoClearedValue d = new AutoClearedValue();
    public final AutoClearedValue e = new AutoClearedValue();
    public PaidServicesRouter f;
    public Disposable g;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public TariffLandingViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/tariff/landing/TariffLandingFragment$Companion;", "", "", "checkoutContext", "Lcom/avito/android/tariff/landing/TariffLandingFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/tariff/landing/TariffLandingFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TariffLandingFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "checkoutContext");
            TariffLandingFragment tariffLandingFragment = new TariffLandingFragment();
            Bundle bundle = new Bundle();
            bundle.putString("checkout_context", str);
            tariffLandingFragment.setArguments(bundle);
            return tariffLandingFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TariffLandingFragment a;

        public a(TariffLandingFragment tariffLandingFragment) {
            this.a = tariffLandingFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.requireActivity().onBackPressed();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TariffLandingFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TariffLandingFragment tariffLandingFragment) {
            super(0);
            this.a = tariffLandingFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ TariffLandingFragment a;

        public c(TariffLandingFragment tariffLandingFragment) {
            this.a = tariffLandingFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Integer.valueOf(this.a.a().getTop());
        }
    }

    public static final class d<T> implements Predicate<Integer> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Integer num) {
            if (a2.b.a.a.a.f0(num, "it", 0) > 0) {
                return true;
            }
            return false;
        }
    }

    public static final class e<T, R> implements Function<Integer, Integer> {
        public final /* synthetic */ TariffLandingFragment a;

        public e(TariffLandingFragment tariffLandingFragment) {
            this.a = tariffLandingFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Integer num) {
            Intrinsics.checkNotNullParameter(num, "it");
            return Integer.valueOf(Views.heightWithMargins(TariffLandingFragment.access$getContainer$p(this.a)));
        }
    }

    public static final class f<T> implements Consumer<Integer> {
        public final /* synthetic */ TariffLandingFragment a;

        public f(TariffLandingFragment tariffLandingFragment) {
            this.a = tariffLandingFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            RecyclerView c = this.a.c();
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            c.addItemDecoration(new LandingDecoration(resources, num2.intValue()));
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ TariffLandingFragment a;

        public g(TariffLandingFragment tariffLandingFragment) {
            this.a = tariffLandingFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RecyclerView c = this.a.c();
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            c.addItemDecoration(new LandingDecoration(resources, 0, 2, null));
        }
    }

    public TariffLandingFragment() {
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.g = empty;
    }

    public static final FrameLayout access$getContainer$p(TariffLandingFragment tariffLandingFragment) {
        return (FrameLayout) tariffLandingFragment.e.getValue((Fragment) tariffLandingFragment, h[4]);
    }

    public static final void access$handleLoadedState(TariffLandingFragment tariffLandingFragment, TariffLanding tariffLanding) {
        tariffLandingFragment.b().showContent();
        AdapterPresenter adapterPresenter2 = tariffLandingFragment.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        adapterPresenter2.onDataSourceChanged(new ListDataSource(tariffLanding.getItems()));
        RecyclerView.Adapter adapter = tariffLandingFragment.c().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        tariffLandingFragment.a().setText(tariffLanding.getAction().getTitle());
        tariffLandingFragment.a().setOnClickListener(new a2.a.a.e3.g.a(tariffLandingFragment, tariffLanding));
    }

    public static final void access$setButton$p(TariffLandingFragment tariffLandingFragment, Button button) {
        tariffLandingFragment.d.setValue((Fragment) tariffLandingFragment, h[3], (KProperty<?>) button);
    }

    public static final void access$setContainer$p(TariffLandingFragment tariffLandingFragment, FrameLayout frameLayout) {
        tariffLandingFragment.e.setValue((Fragment) tariffLandingFragment, h[4], (KProperty<?>) frameLayout);
    }

    public static final void access$setProgressOverlay$p(TariffLandingFragment tariffLandingFragment, ProgressOverlay progressOverlay) {
        tariffLandingFragment.c.setValue((Fragment) tariffLandingFragment, h[2], (KProperty<?>) progressOverlay);
    }

    public static final void access$setRecyclerView$p(TariffLandingFragment tariffLandingFragment, RecyclerView recyclerView) {
        tariffLandingFragment.a.setValue((Fragment) tariffLandingFragment, h[0], (KProperty<?>) recyclerView);
    }

    public final Button a() {
        return (Button) this.d.getValue((Fragment) this, h[3]);
    }

    public final ProgressOverlay b() {
        return (ProgressOverlay) this.c.getValue((Fragment) this, h[2]);
    }

    public final RecyclerView c() {
        return (RecyclerView) this.a.getValue((Fragment) this, h[0]);
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Set<ItemPresenter<?, ?>> getItemPresenterSet() {
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        return set;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final TariffLandingViewModel getViewModel() {
        TariffLandingViewModel tariffLandingViewModel = this.viewModel;
        if (tariffLandingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return tariffLandingViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        PaidServicesRouter paidServicesRouter = (PaidServicesRouter) (!(context instanceof PaidServicesRouter) ? null : context);
        if (paidServicesRouter != null) {
            this.f = paidServicesRouter;
            if (!(context instanceof ComponentProvider)) {
                context = null;
            }
            ComponentProvider componentProvider = (ComponentProvider) context;
            if (componentProvider != null) {
                TariffStepDependencies tariffStepDependencies = (TariffStepDependencies) componentProvider.getComponent();
                Bundle arguments = getArguments();
                if (arguments == null || (string = arguments.getString("checkout_context")) == null) {
                    throw new IllegalStateException("checkout context must be set");
                }
                Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(CHE…out context must be set\")");
                DaggerLandingComponent.builder().dependencies(tariffStepDependencies).checkoutContext(string).fragment(this).build().inject(this);
                return;
            }
            throw new IllegalStateException("Parent activity must implement ComponentProvider");
        }
        throw new IllegalStateException("Parent activity must implement PaidServicesRouter");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.landing_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.g.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.continue_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.continue_button)");
        AutoClearedValue autoClearedValue = this.d;
        KProperty<?>[] kPropertyArr = h;
        autoClearedValue.setValue((Fragment) this, kPropertyArr[3], (KProperty<?>) ((Button) findViewById));
        View findViewById2 = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.container)");
        this.e.setValue((Fragment) this, kPropertyArr[4], (KProperty<?>) ((FrameLayout) findViewById2));
        int i = R.id.recycler_view;
        View findViewById3 = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.recycler_view)");
        this.a.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) ((RecyclerView) findViewById3));
        RecyclerView c2 = c();
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        c2.setAdapter(simpleRecyclerAdapter);
        View findViewById4 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.toolbar)");
        this.b.setValue((Fragment) this, kPropertyArr[1], (KProperty<?>) ((Toolbar) findViewById4));
        ((Toolbar) this.b.getValue((Fragment) this, kPropertyArr[1])).setNavigationOnClickListener(new a(this));
        View findViewById5 = view.findViewById(R.id.progress_placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.progress_placeholder)");
        this.c.setValue((Fragment) this, kPropertyArr[2], (KProperty<?>) new ProgressOverlay((ViewGroup) findViewById5, i, null, false, 0, 28, null));
        b().setOnRefreshListener(new b(this));
        TariffLandingViewModel tariffLandingViewModel = this.viewModel;
        if (tariffLandingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffLandingViewModel.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.g.b(this));
        TariffLandingViewModel tariffLandingViewModel2 = this.viewModel;
        if (tariffLandingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffLandingViewModel2.getRoutingEvents().observe(getViewLifecycleOwner(), new a2.a.a.e3.g.c(this));
        Disposable subscribe = RxView.layoutChanges(a()).map(new c(this)).filter(d.a).firstElement().map(new e(this)).subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "button.layoutChanges()\n …sources)) }\n            )");
        this.g = subscribe;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setViewModel(@NotNull TariffLandingViewModel tariffLandingViewModel) {
        Intrinsics.checkNotNullParameter(tariffLandingViewModel, "<set-?>");
        this.viewModel = tariffLandingViewModel;
    }
}
