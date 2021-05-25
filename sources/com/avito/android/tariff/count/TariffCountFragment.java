package com.avito.android.tariff.count;

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
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.PriceView;
import com.avito.android.tariff.R;
import com.avito.android.tariff.count.di.DaggerTariffCountComponent;
import com.avito.android.tariff.count.recycler.CountDecoration;
import com.avito.android.tariff.count.viewmodel.TariffCountViewModel;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedRecyclerView;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedValue;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001T\u0018\u0000 h2\u00020\u0001:\u0001hB\u0007¢\u0006\u0004\bg\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8B@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010-\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020&8B@BX\u0002¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R+\u0010;\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b6\u0010(\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R+\u0010A\u001a\u00020<2\u0006\u0010\u001e\u001a\u00020<8B@BX\u0002¢\u0006\u0012\n\u0004\b!\u0010(\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR+\u0010]\u001a\u00020X2\u0006\u0010\u001e\u001a\u00020X8B@BX\u0002¢\u0006\u0012\n\u0004\bY\u0010(\u001a\u0004\b\u001f\u0010Z\"\u0004\b[\u0010\\R5\u0010a\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030_¢\u0006\u0002\b`0^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006i"}, d2 = {"Lcom/avito/android/tariff/count/TariffCountFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onDestroyView", "()V", "onDetach", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView;", "<set-?>", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", AuthSource.BOOKING_ORDER, "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "setProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progressOverlay", "Lio/reactivex/disposables/Disposable;", a2.g.r.g.a, "Lio/reactivex/disposables/Disposable;", "subscription", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "f", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "d", "getContentView", "()Landroid/view/ViewGroup;", "setContentView", "(Landroid/view/ViewGroup;)V", "contentView", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar", "Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModel;", "viewModel", "Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModel;", "getViewModel", "()Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModel;", "setViewModel", "(Lcom/avito/android/tariff/count/viewmodel/TariffCountViewModel;)V", "", "i", "I", "bottomOffset", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "com/avito/android/tariff/count/TariffCountFragment$touchEventsListener$1", "h", "Lcom/avito/android/tariff/count/TariffCountFragment$touchEventsListener$1;", "touchEventsListener", "Lcom/avito/android/tariff/PriceView;", "e", "()Lcom/avito/android/tariff/PriceView;", "setPriceView", "(Lcom/avito/android/tariff/PriceView;)V", "priceView", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "<init>", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] j = {a2.b.a.a.a.u0(TariffCountFragment.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0), a2.b.a.a.a.u0(TariffCountFragment.class, "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;", 0), a2.b.a.a.a.u0(TariffCountFragment.class, "progressOverlay", "getProgressOverlay()Lcom/avito/android/progress_overlay/ProgressOverlay;", 0), a2.b.a.a.a.u0(TariffCountFragment.class, "contentView", "getContentView()Landroid/view/ViewGroup;", 0), a2.b.a.a.a.u0(TariffCountFragment.class, "priceView", "getPriceView()Lcom/avito/android/tariff/PriceView;", 0)};
    public final AutoClearedRecyclerView a = new AutoClearedRecyclerView();
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    public final AutoClearedValue b = new AutoClearedValue();
    public final AutoClearedValue c = new AutoClearedValue();
    public final AutoClearedValue d = new AutoClearedValue();
    public final AutoClearedValue e = new AutoClearedValue();
    public PaidServicesRouter f;
    public Disposable g;
    public final TariffCountFragment$touchEventsListener$1 h;
    public int i;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public TariffCountViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/tariff/count/TariffCountFragment$Companion;", "", "", "checkoutContext", "Lcom/avito/android/tariff/count/TariffCountFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/tariff/count/TariffCountFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TariffCountFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "checkoutContext");
            TariffCountFragment tariffCountFragment = new TariffCountFragment();
            Bundle bundle = new Bundle();
            bundle.putString("checkout_context", str);
            tariffCountFragment.setArguments(bundle);
            return tariffCountFragment;
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((TariffCountFragment) this.b).getViewModel().onSelectButtonClick();
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((TariffCountFragment) this.b).getViewModel().onRetryButtonClick();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ TariffCountFragment a;

        public c(TariffCountFragment tariffCountFragment) {
            this.a = tariffCountFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.requireActivity().onBackPressed();
        }
    }

    public static final class d<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ TariffCountFragment a;

        public d(TariffCountFragment tariffCountFragment) {
            this.a = tariffCountFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Integer.valueOf(this.a.a().getTop());
        }
    }

    public static final class e<T> implements Predicate<Integer> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Integer num) {
            if (a2.b.a.a.a.f0(num, "it", 0) > 0) {
                return true;
            }
            return false;
        }
    }

    public static final class f<T, R> implements Function<Integer, Integer> {
        public final /* synthetic */ TariffCountFragment a;

        public f(TariffCountFragment tariffCountFragment) {
            this.a = tariffCountFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullParameter(num2, "it");
            return Integer.valueOf(this.a.b().getBottom() - num2.intValue());
        }
    }

    public static final class g<T> implements Consumer<Integer> {
        public final /* synthetic */ TariffCountFragment a;

        public g(TariffCountFragment tariffCountFragment) {
            this.a = tariffCountFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            TariffCountFragment tariffCountFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            tariffCountFragment.i = num2.intValue();
            RecyclerViewsKt.clearItemDecorations(this.a.b());
            RecyclerView b = this.a.b();
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            b.addItemDecoration(new CountDecoration(resources, num2.intValue()));
        }
    }

    public TariffCountFragment() {
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.g = empty;
        this.h = new TariffCountFragment$touchEventsListener$1();
    }

    public static final ViewGroup access$getContentView$p(TariffCountFragment tariffCountFragment) {
        return (ViewGroup) tariffCountFragment.d.getValue((Fragment) tariffCountFragment, j[3]);
    }

    public static final ProgressOverlay access$getProgressOverlay$p(TariffCountFragment tariffCountFragment) {
        return (ProgressOverlay) tariffCountFragment.c.getValue((Fragment) tariffCountFragment, j[2]);
    }

    public static final void access$setContentView$p(TariffCountFragment tariffCountFragment, ViewGroup viewGroup) {
        tariffCountFragment.d.setValue((Fragment) tariffCountFragment, j[3], (KProperty<?>) viewGroup);
    }

    public static final void access$setPriceView$p(TariffCountFragment tariffCountFragment, PriceView priceView) {
        tariffCountFragment.e.setValue((Fragment) tariffCountFragment, j[4], (KProperty<?>) priceView);
    }

    public static final void access$setProgressOverlay$p(TariffCountFragment tariffCountFragment, ProgressOverlay progressOverlay) {
        tariffCountFragment.c.setValue((Fragment) tariffCountFragment, j[2], (KProperty<?>) progressOverlay);
    }

    public static final void access$setRecyclerView$p(TariffCountFragment tariffCountFragment, RecyclerView recyclerView) {
        tariffCountFragment.a.setValue((Fragment) tariffCountFragment, j[0], (KProperty<?>) recyclerView);
    }

    public final PriceView a() {
        return (PriceView) this.e.getValue((Fragment) this, j[4]);
    }

    public final RecyclerView b() {
        return (RecyclerView) this.a.getValue((Fragment) this, j[0]);
    }

    @NotNull
    public final DataAwareAdapterPresenter getAdapterPresenter() {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return dataAwareAdapterPresenter;
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
    public final TariffCountViewModel getViewModel() {
        TariffCountViewModel tariffCountViewModel = this.viewModel;
        if (tariffCountViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return tariffCountViewModel;
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
            this.f = paidServicesRouter;
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
                if (bundle == null || (kundle = Bundles.getKundle(bundle, "tariff_count_vm_state")) == null) {
                    kundle = Kundle.Companion.getEMPTY();
                }
                DaggerTariffCountComponent.builder().dependencies(tariffStepDependencies).checkoutContext(string).fragment(this).savedState(kundle).build().inject(this);
                TariffCountViewModel tariffCountViewModel = this.viewModel;
                if (tariffCountViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
                if (set == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
                }
                tariffCountViewModel.observeItemClicks(set);
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
        return layoutInflater.inflate(R.layout.count_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TariffCountViewModel tariffCountViewModel = this.viewModel;
        if (tariffCountViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffCountViewModel.onDestroyView();
        this.g.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        TariffCountViewModel tariffCountViewModel = this.viewModel;
        if (tariffCountViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Bundles.putKundle(bundle, "tariff_count_vm_state", tariffCountViewModel.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        TariffCountViewModel tariffCountViewModel = this.viewModel;
        if (tariffCountViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffCountViewModel.onViewCreated();
        View findViewById = view.findViewById(R.id.progress_placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.progress_placeholder)");
        AutoClearedValue autoClearedValue = this.d;
        KProperty<?>[] kPropertyArr = j;
        autoClearedValue.setValue((Fragment) this, kPropertyArr[3], (KProperty<?>) ((ViewGroup) findViewById));
        View findViewById2 = view.findViewById(R.id.price_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.price_view)");
        this.e.setValue((Fragment) this, kPropertyArr[4], (KProperty<?>) ((PriceView) findViewById2));
        a().setButtonClickListener(new a(0, this));
        int i2 = R.id.recycler_view;
        View findViewById3 = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.recycler_view)");
        this.a.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) ((RecyclerView) findViewById3));
        RecyclerView b2 = b();
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        b2.setAdapter(simpleRecyclerAdapter);
        b().setLayoutManager(new TariffCountFragment$onViewCreated$2(this, requireContext()));
        SimpleRecyclerAdapter simpleRecyclerAdapter2 = this.recyclerAdapter;
        if (simpleRecyclerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        simpleRecyclerAdapter2.registerAdapterDataObserver(new TariffCountFragment$onViewCreated$3(this));
        View findViewById4 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.toolbar)");
        this.b.setValue((Fragment) this, kPropertyArr[1], (KProperty<?>) ((Toolbar) findViewById4));
        ((Toolbar) this.b.getValue((Fragment) this, kPropertyArr[1])).setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        ((Toolbar) this.b.getValue((Fragment) this, kPropertyArr[1])).setNavigationOnClickListener(new c(this));
        this.c.setValue((Fragment) this, kPropertyArr[2], (KProperty<?>) new ProgressOverlay((ViewGroup) this.d.getValue((Fragment) this, kPropertyArr[3]), i2, null, false, 0, 28, null));
        ((ProgressOverlay) this.c.getValue((Fragment) this, kPropertyArr[2])).setOnRefreshListener(new a(1, this));
        TariffCountViewModel tariffCountViewModel2 = this.viewModel;
        if (tariffCountViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffCountViewModel2.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.b.a(this));
        TariffCountViewModel tariffCountViewModel3 = this.viewModel;
        if (tariffCountViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> routingEvents = tariffCountViewModel3.getRoutingEvents();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        routingEvents.observe(viewLifecycleOwner, new a2.a.a.e3.b.b(this));
        TariffCountViewModel tariffCountViewModel4 = this.viewModel;
        if (tariffCountViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffCountViewModel4.getPricePanelStateChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.b.c(this));
        TariffCountViewModel tariffCountViewModel5 = this.viewModel;
        if (tariffCountViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffCountViewModel5.getListChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.b.d(this));
        TariffCountViewModel tariffCountViewModel6 = this.viewModel;
        if (tariffCountViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<String> messageEvents = tariffCountViewModel6.getMessageEvents();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        messageEvents.observe(viewLifecycleOwner2, new a2.a.a.e3.b.e(this));
        TariffCountViewModel tariffCountViewModel7 = this.viewModel;
        if (tariffCountViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffCountViewModel7.getLoadingEvents().observe(getViewLifecycleOwner(), new a2.a.a.e3.b.f(this));
        TariffCountViewModel tariffCountViewModel8 = this.viewModel;
        if (tariffCountViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffCountViewModel8.getPriceChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.b.g(this));
        RecyclerView b3 = b();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        b3.addItemDecoration(new CountDecoration(resources, this.i));
        Disposable subscribe = RxView.layoutChanges(a()).map(new d(this)).filter(e.a).firstElement().map(new f(this)).subscribe(new g(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "priceView.layoutChanges(…error(it) }\n            )");
        this.g = subscribe;
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setViewModel(@NotNull TariffCountViewModel tariffCountViewModel) {
        Intrinsics.checkNotNullParameter(tariffCountViewModel, "<set-?>");
        this.viewModel = tariffCountViewModel;
    }
}
