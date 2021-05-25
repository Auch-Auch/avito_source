package com.avito.android.tariff.region;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.button.Button;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.region.di.DaggerRegionComponent;
import com.avito.android.tariff.region.recycler.RegionDecoration;
import com.avito.android.tariff.region.viewmodel.RegionViewModel;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedRecyclerView;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedValue;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.view.ViewLayoutChangeEvent;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Objects;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r*\u0001<\u0018\u0000 h2\u00020\u0001:\u0001hB\u0007¢\u0006\u0004\bg\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R5\u0010\u0019\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0017¢\u0006\u0002\b\u00180\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8B@BX\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010\n\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u00103\u001a\u00020-2\u0006\u0010 \u001a\u00020-8B@BX\u0002¢\u0006\u0012\n\u0004\b.\u0010\"\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR+\u0010M\u001a\u00020G2\u0006\u0010 \u001a\u00020G8B@BX\u0002¢\u0006\u0012\n\u0004\bH\u0010\"\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR+\u0010T\u001a\u00020N2\u0006\u0010 \u001a\u00020N8B@BX\u0002¢\u0006\u0012\n\u0004\bI\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010V\u001a\u00020U8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR+\u0010f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\bc\u0010\"\u001a\u0004\bd\u0010*\"\u0004\be\u0010,¨\u0006i"}, d2 = {"Lcom/avito/android/tariff/region/RegionFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onDestroyView", "()V", "onDetach", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "Landroidx/appcompat/widget/Toolbar;", "<set-?>", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar", "f", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "setProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progressOverlay", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", a2.g.r.g.a, "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "Lio/reactivex/disposables/Disposable;", "h", "Lio/reactivex/disposables/Disposable;", "subscription", "com/avito/android/tariff/region/RegionFragment$touchEventsListener$1", "i", "Lcom/avito/android/tariff/region/RegionFragment$touchEventsListener$1;", "touchEventsListener", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/lib/design/button/Button;", "d", AuthSource.SEND_ABUSE, "()Lcom/avito/android/lib/design/button/Button;", "setButton", "(Lcom/avito/android/lib/design/button/Button;)V", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/tariff/region/viewmodel/RegionViewModel;", "viewModel", "Lcom/avito/android/tariff/region/viewmodel/RegionViewModel;", "getViewModel", "()Lcom/avito/android/tariff/region/viewmodel/RegionViewModel;", "setViewModel", "(Lcom/avito/android/tariff/region/viewmodel/RegionViewModel;)V", "e", "getContentView", "setContentView", "contentView", "<init>", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class RegionFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] j = {a2.b.a.a.a.u0(RegionFragment.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0), a2.b.a.a.a.u0(RegionFragment.class, "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;", 0), a2.b.a.a.a.u0(RegionFragment.class, "progressOverlay", "getProgressOverlay()Lcom/avito/android/progress_overlay/ProgressOverlay;", 0), a2.b.a.a.a.u0(RegionFragment.class, PhonePageSourceKt.PHONE_SOURCE_BUTTON, "getButton()Lcom/avito/android/lib/design/button/Button;", 0), a2.b.a.a.a.u0(RegionFragment.class, "contentView", "getContentView()Landroid/view/ViewGroup;", 0), a2.b.a.a.a.u0(RegionFragment.class, "container", "getContainer()Landroid/view/ViewGroup;", 0)};
    public final AutoClearedRecyclerView a = new AutoClearedRecyclerView();
    @Inject
    public AdapterPresenter adapterPresenter;
    public final AutoClearedValue b = new AutoClearedValue();
    public final AutoClearedValue c = new AutoClearedValue();
    public final AutoClearedValue d = new AutoClearedValue();
    public final AutoClearedValue e = new AutoClearedValue();
    public final AutoClearedValue f = new AutoClearedValue();
    public PaidServicesRouter g;
    public Disposable h;
    public final RegionFragment$touchEventsListener$1 i;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public RegionViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/tariff/region/RegionFragment$Companion;", "", "", "checkoutContext", "Lcom/avito/android/tariff/region/RegionFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/tariff/region/RegionFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final RegionFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "checkoutContext");
            RegionFragment regionFragment = new RegionFragment();
            Bundle bundle = new Bundle();
            bundle.putString("checkout_context", str);
            regionFragment.setArguments(bundle);
            return regionFragment;
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((RegionFragment) this.b).getViewModel().onSelectButtonClick();
            } else if (i == 1) {
                ((RegionFragment) this.b).requireActivity().onBackPressed();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RegionFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(RegionFragment regionFragment) {
            super(0);
            this.a = regionFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<ViewLayoutChangeEvent, Integer> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(ViewLayoutChangeEvent viewLayoutChangeEvent) {
            ViewLayoutChangeEvent viewLayoutChangeEvent2 = viewLayoutChangeEvent;
            Intrinsics.checkNotNullParameter(viewLayoutChangeEvent2, "it");
            return Integer.valueOf(viewLayoutChangeEvent2.getTop());
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
        public final /* synthetic */ RegionFragment a;

        public e(RegionFragment regionFragment) {
            this.a = regionFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Integer num) {
            Intrinsics.checkNotNullParameter(num, "it");
            RegionFragment regionFragment = this.a;
            return Integer.valueOf(RegionFragment.access$heightWithMargins(regionFragment, RegionFragment.access$getContainer$p(regionFragment)));
        }
    }

    public static final class f<T> implements Consumer<Integer> {
        public final /* synthetic */ RegionFragment a;

        public f(RegionFragment regionFragment) {
            this.a = regionFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            RecyclerView access$getRecyclerView$p = RegionFragment.access$getRecyclerView$p(this.a);
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            access$getRecyclerView$p.addItemDecoration(new RegionDecoration(resources, num2.intValue()));
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ RegionFragment a;

        public g(RegionFragment regionFragment) {
            this.a = regionFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RecyclerView access$getRecyclerView$p = RegionFragment.access$getRecyclerView$p(this.a);
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            access$getRecyclerView$p.addItemDecoration(new RegionDecoration(resources, 0));
        }
    }

    public RegionFragment() {
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.h = empty;
        this.i = new RegionFragment$touchEventsListener$1();
    }

    public static final ViewGroup access$getContainer$p(RegionFragment regionFragment) {
        return (ViewGroup) regionFragment.f.getValue((Fragment) regionFragment, j[5]);
    }

    public static final ViewGroup access$getContentView$p(RegionFragment regionFragment) {
        return (ViewGroup) regionFragment.e.getValue((Fragment) regionFragment, j[4]);
    }

    public static final ProgressOverlay access$getProgressOverlay$p(RegionFragment regionFragment) {
        return (ProgressOverlay) regionFragment.c.getValue((Fragment) regionFragment, j[2]);
    }

    public static final RecyclerView access$getRecyclerView$p(RegionFragment regionFragment) {
        return (RecyclerView) regionFragment.a.getValue((Fragment) regionFragment, j[0]);
    }

    public static final int access$heightWithMargins(RegionFragment regionFragment, View view) {
        Objects.requireNonNull(regionFragment);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static final void access$setButton$p(RegionFragment regionFragment, Button button) {
        regionFragment.d.setValue((Fragment) regionFragment, j[3], (KProperty<?>) button);
    }

    public static final void access$setContainer$p(RegionFragment regionFragment, ViewGroup viewGroup) {
        regionFragment.f.setValue((Fragment) regionFragment, j[5], (KProperty<?>) viewGroup);
    }

    public static final void access$setContentView$p(RegionFragment regionFragment, ViewGroup viewGroup) {
        regionFragment.e.setValue((Fragment) regionFragment, j[4], (KProperty<?>) viewGroup);
    }

    public static final void access$setProgressOverlay$p(RegionFragment regionFragment, ProgressOverlay progressOverlay) {
        regionFragment.c.setValue((Fragment) regionFragment, j[2], (KProperty<?>) progressOverlay);
    }

    public static final void access$setRecyclerView$p(RegionFragment regionFragment, RecyclerView recyclerView) {
        regionFragment.a.setValue((Fragment) regionFragment, j[0], (KProperty<?>) recyclerView);
    }

    public final Button a() {
        return (Button) this.d.getValue((Fragment) this, j[3]);
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
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
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
    public final RegionViewModel getViewModel() {
        RegionViewModel regionViewModel = this.viewModel;
        if (regionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return regionViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        Kundle kundle;
        super.onCreate(bundle);
        Context context = getContext();
        ComponentProvider componentProvider = null;
        if (!(context instanceof PaidServicesRouter)) {
            context = null;
        }
        PaidServicesRouter paidServicesRouter = (PaidServicesRouter) context;
        if (paidServicesRouter != null) {
            this.g = paidServicesRouter;
            Context context2 = getContext();
            if (context2 instanceof ComponentProvider) {
                componentProvider = context2;
            }
            ComponentProvider componentProvider2 = componentProvider;
            if (componentProvider2 != null) {
                TariffStepDependencies tariffStepDependencies = (TariffStepDependencies) componentProvider2.getComponent();
                Bundle arguments = getArguments();
                if (arguments == null || (string = arguments.getString("checkout_context")) == null) {
                    throw new IllegalStateException("checkout context must be set");
                }
                Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…out context must be set\")");
                if (bundle == null || (kundle = Bundles.getKundle(bundle, "region_view_model")) == null) {
                    kundle = Kundle.Companion.getEMPTY();
                }
                DaggerRegionComponent.builder().dependencies(tariffStepDependencies).checkoutContext(string).fragment(this).savedState(kundle).build().inject(this);
                RegionViewModel regionViewModel = this.viewModel;
                if (regionViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
                if (set == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
                }
                regionViewModel.observeItemClicks(set);
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
        return layoutInflater.inflate(R.layout.region_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.h.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.g = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        RegionViewModel regionViewModel = this.viewModel;
        if (regionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Bundles.putKundle(bundle, "region_view_model", regionViewModel.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.progress_placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.progress_placeholder)");
        AutoClearedValue autoClearedValue = this.e;
        KProperty<?>[] kPropertyArr = j;
        autoClearedValue.setValue((Fragment) this, kPropertyArr[4], (KProperty<?>) ((ViewGroup) findViewById));
        View findViewById2 = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.container)");
        this.f.setValue((Fragment) this, kPropertyArr[5], (KProperty<?>) ((ViewGroup) findViewById2));
        View findViewById3 = view.findViewById(R.id.select_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.select_button)");
        this.d.setValue((Fragment) this, kPropertyArr[3], (KProperty<?>) ((Button) findViewById3));
        a().setOnClickListener(new a(0, this));
        int i2 = R.id.recycler_view;
        View findViewById4 = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.recycler_view)");
        this.a.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) ((RecyclerView) findViewById4));
        RecyclerView recyclerView = (RecyclerView) this.a.getValue((Fragment) this, kPropertyArr[0]);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2));
        View findViewById5 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.toolbar)");
        this.b.setValue((Fragment) this, kPropertyArr[1], (KProperty<?>) ((Toolbar) findViewById5));
        ((Toolbar) this.b.getValue((Fragment) this, kPropertyArr[1])).setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        ((Toolbar) this.b.getValue((Fragment) this, kPropertyArr[1])).setNavigationOnClickListener(new a(1, this));
        this.c.setValue((Fragment) this, kPropertyArr[2], (KProperty<?>) new ProgressOverlay((ViewGroup) this.e.getValue((Fragment) this, kPropertyArr[4]), i2, null, false, 0, 28, null));
        ((ProgressOverlay) this.c.getValue((Fragment) this, kPropertyArr[2])).setOnRefreshListener(new b(this));
        RegionViewModel regionViewModel = this.viewModel;
        if (regionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        regionViewModel.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.h.a(this));
        RegionViewModel regionViewModel2 = this.viewModel;
        if (regionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> routingEvents = regionViewModel2.getRoutingEvents();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        routingEvents.observe(viewLifecycleOwner, new a2.a.a.e3.h.b(this));
        RegionViewModel regionViewModel3 = this.viewModel;
        if (regionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        regionViewModel3.getButtonTextChanges().observe(getViewLifecycleOwner(), new n2(0, this));
        RegionViewModel regionViewModel4 = this.viewModel;
        if (regionViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        regionViewModel4.getListChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.h.c(this));
        RegionViewModel regionViewModel5 = this.viewModel;
        if (regionViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<String> messageEvents = regionViewModel5.getMessageEvents();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        messageEvents.observe(viewLifecycleOwner2, new n2(1, this));
        RegionViewModel regionViewModel6 = this.viewModel;
        if (regionViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        regionViewModel6.getLoadingEvents().observe(getViewLifecycleOwner(), new a2.a.a.e3.h.d(this));
        Disposable subscribe = RxView.layoutChangeEvents(a()).map(c.a).filter(d.a).firstElement().map(new e(this)).subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "button.layoutChangeEvent…rces, 0)) }\n            )");
        this.h = subscribe;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setViewModel(@NotNull RegionViewModel regionViewModel) {
        Intrinsics.checkNotNullParameter(regionViewModel, "<set-?>");
        this.viewModel = regionViewModel;
    }
}
