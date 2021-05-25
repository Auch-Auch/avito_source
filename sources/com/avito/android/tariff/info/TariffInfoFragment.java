package com.avito.android.tariff.info;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.avito.android.tariff.info.di.DaggerTariffInfoComponent;
import com.avito.android.tariff.info.item.disclaimer.DisclaimerItem;
import com.avito.android.tariff.info.ui.TariffInfoPaddingDecoration;
import com.avito.android.tariff.info.ui.TariffInfoViewTypeProvider;
import com.avito.android.tariff.info.viewmodel.TariffInfoViewModel;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedRecyclerView;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedValue;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\bW\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158B@BX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R+\u00106\u001a\u0002002\u0006\u0010\u0016\u001a\u0002008B@BX\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR+\u0010H\u001a\u00020B2\u0006\u0010\u0016\u001a\u00020B8B@BX\u0002¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bC\u0010E\"\u0004\bF\u0010GR+\u0010O\u001a\u00020I2\u0006\u0010\u0016\u001a\u00020I8B@BX\u0002¢\u0006\u0012\n\u0004\bJ\u0010\u0018\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010Q\u001a\u00020P8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006Y"}, d2 = {"Lcom/avito/android/tariff/info/TariffInfoFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "Lcom/avito/android/lib/design/button/Button;", "<set-?>", "d", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "getButton", "()Lcom/avito/android/lib/design/button/Button;", "setButton", "(Lcom/avito/android/lib/design/button/Button;)V", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "e", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;", "viewTypeProvider", "Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;", "getViewTypeProvider", "()Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;", "setViewTypeProvider", "(Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "setProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progressOverlay", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "subscription", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModel;", "viewModel", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModel;", "getViewModel", "()Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModel;", "setViewModel", "(Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModel;)V", "<init>", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffInfoFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] g = {a2.b.a.a.a.u0(TariffInfoFragment.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0), a2.b.a.a.a.u0(TariffInfoFragment.class, "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;", 0), a2.b.a.a.a.u0(TariffInfoFragment.class, "progressOverlay", "getProgressOverlay()Lcom/avito/android/progress_overlay/ProgressOverlay;", 0), a2.b.a.a.a.u0(TariffInfoFragment.class, PhonePageSourceKt.PHONE_SOURCE_BUTTON, "getButton()Lcom/avito/android/lib/design/button/Button;", 0)};
    public final AutoClearedRecyclerView a = new AutoClearedRecyclerView();
    @Inject
    public AdapterPresenter adapterPresenter;
    public final AutoClearedValue b = new AutoClearedValue();
    public final AutoClearedValue c = new AutoClearedValue();
    public final AutoClearedValue d = new AutoClearedValue();
    public PaidServicesRouter e;
    public Disposable f;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public TariffInfoViewModel viewModel;
    @Inject
    public TariffInfoViewTypeProvider viewTypeProvider;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/tariff/info/TariffInfoFragment$Companion;", "", "", "checkoutContext", "Lcom/avito/android/tariff/info/TariffInfoFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/tariff/info/TariffInfoFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TariffInfoFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "checkoutContext");
            TariffInfoFragment tariffInfoFragment = new TariffInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("checkoutContext", str);
            tariffInfoFragment.setArguments(bundle);
            return tariffInfoFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TariffInfoFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TariffInfoFragment tariffInfoFragment) {
            super(0);
            this.a = tariffInfoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ TariffInfoFragment a;

        public b(TariffInfoFragment tariffInfoFragment) {
            this.a = tariffInfoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Integer.valueOf(TariffInfoFragment.access$getButton$p(this.a).getTop());
        }
    }

    public static final class c<T> implements Predicate<Integer> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Integer num) {
            if (a2.b.a.a.a.f0(num, "it", 0) > 0) {
                return true;
            }
            return false;
        }
    }

    public static final class d<T, R> implements Function<Integer, Integer> {
        public final /* synthetic */ TariffInfoFragment a;

        public d(TariffInfoFragment tariffInfoFragment) {
            this.a = tariffInfoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullParameter(num2, "it");
            return Integer.valueOf(this.a.a().getBottom() - num2.intValue());
        }
    }

    public static final class e<T> implements Consumer<Integer> {
        public final /* synthetic */ TariffInfoFragment a;

        public e(TariffInfoFragment tariffInfoFragment) {
            this.a = tariffInfoFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            RecyclerView a3 = this.a.a();
            TariffInfoViewTypeProvider viewTypeProvider = this.a.getViewTypeProvider();
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            a3.addItemDecoration(new TariffInfoPaddingDecoration(viewTypeProvider, num2.intValue()));
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ TariffInfoFragment a;

        public f(TariffInfoFragment tariffInfoFragment) {
            this.a = tariffInfoFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.a().addItemDecoration(new TariffInfoPaddingDecoration(this.a.getViewTypeProvider(), 0));
        }
    }

    public TariffInfoFragment() {
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.f = empty;
    }

    public static final void access$addDividerToList(TariffInfoFragment tariffInfoFragment, List list) {
        Objects.requireNonNull(tariffInfoFragment);
        Iterator it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((Item) it.next()) instanceof DisclaimerItem) {
                break;
            } else {
                i++;
            }
        }
        Drawable drawable = tariffInfoFragment.requireContext().getDrawable(R.drawable.background_info_divider);
        int dimensionPixelOffset = tariffInfoFragment.getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.standard_padding);
        tariffInfoFragment.a().addItemDecoration(new VerticalListItemDecoration.Builder(null, 1, null).setPadding(dimensionPixelOffset, dimensionPixelOffset).setDividerForItemAt(i - 1, drawable).build());
    }

    public static final Button access$getButton$p(TariffInfoFragment tariffInfoFragment) {
        return (Button) tariffInfoFragment.d.getValue((Fragment) tariffInfoFragment, g[3]);
    }

    public static final ProgressOverlay access$getProgressOverlay$p(TariffInfoFragment tariffInfoFragment) {
        return (ProgressOverlay) tariffInfoFragment.c.getValue((Fragment) tariffInfoFragment, g[2]);
    }

    public static final void access$setButton$p(TariffInfoFragment tariffInfoFragment, Button button) {
        tariffInfoFragment.d.setValue((Fragment) tariffInfoFragment, g[3], (KProperty<?>) button);
    }

    public static final void access$setProgressOverlay$p(TariffInfoFragment tariffInfoFragment, ProgressOverlay progressOverlay) {
        tariffInfoFragment.c.setValue((Fragment) tariffInfoFragment, g[2], (KProperty<?>) progressOverlay);
    }

    public static final void access$setRecyclerView$p(TariffInfoFragment tariffInfoFragment, RecyclerView recyclerView) {
        tariffInfoFragment.a.setValue((Fragment) tariffInfoFragment, g[0], (KProperty<?>) recyclerView);
    }

    public final RecyclerView a() {
        return (RecyclerView) this.a.getValue((Fragment) this, g[0]);
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
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final TariffInfoViewModel getViewModel() {
        TariffInfoViewModel tariffInfoViewModel = this.viewModel;
        if (tariffInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return tariffInfoViewModel;
    }

    @NotNull
    public final TariffInfoViewTypeProvider getViewTypeProvider() {
        TariffInfoViewTypeProvider tariffInfoViewTypeProvider = this.viewTypeProvider;
        if (tariffInfoViewTypeProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewTypeProvider");
        }
        return tariffInfoViewTypeProvider;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        PaidServicesRouter paidServicesRouter = (PaidServicesRouter) (!(context instanceof PaidServicesRouter) ? null : context);
        if (paidServicesRouter != null) {
            this.e = paidServicesRouter;
            if (!(context instanceof ComponentProvider)) {
                context = null;
            }
            ComponentProvider componentProvider = (ComponentProvider) context;
            if (componentProvider != null) {
                TariffStepDependencies tariffStepDependencies = (TariffStepDependencies) componentProvider.getComponent();
                Bundle arguments = getArguments();
                if (arguments == null || (string = arguments.getString("checkoutContext")) == null) {
                    throw new IllegalStateException("checkout context must be set");
                }
                Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…out context must be set\")");
                DaggerTariffInfoComponent.builder().dependentOn(tariffStepDependencies).with(this).with(string).build().inject(this);
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
        return layoutInflater.inflate(R.layout.tariff_info_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        int i = R.id.recycler_view;
        View findViewById = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        AutoClearedRecyclerView autoClearedRecyclerView = this.a;
        KProperty<?>[] kPropertyArr = g;
        autoClearedRecyclerView.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) ((RecyclerView) findViewById));
        RecyclerView a3 = a();
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        a3.setAdapter(simpleRecyclerAdapter);
        View findViewById2 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.toolbar)");
        this.b.setValue((Fragment) this, kPropertyArr[1], (KProperty<?>) ((Toolbar) findViewById2));
        View findViewById3 = view.findViewById(R.id.continue_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.continue_button)");
        this.d.setValue((Fragment) this, kPropertyArr[3], (KProperty<?>) ((Button) findViewById3));
        View findViewById4 = view.findViewById(R.id.progress_placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.progress_placeholder)");
        this.c.setValue((Fragment) this, kPropertyArr[2], (KProperty<?>) new ProgressOverlay((ViewGroup) findViewById4, i, null, false, 0, 28, null));
        ((ProgressOverlay) this.c.getValue((Fragment) this, kPropertyArr[2])).setOnRefreshListener(new a(this));
        TariffInfoViewModel tariffInfoViewModel = this.viewModel;
        if (tariffInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffInfoViewModel.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.f.a(this));
        TariffInfoViewModel tariffInfoViewModel2 = this.viewModel;
        if (tariffInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffInfoViewModel2.getButtonActionChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.f.c(this));
        Disposable subscribe = RxView.layoutChanges((Button) this.d.getValue((Fragment) this, kPropertyArr[3])).map(new b(this)).filter(c.a).firstElement().map(new d(this)).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "button.layoutChanges()\n …ider, 0)) }\n            )");
        this.f = subscribe;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setViewModel(@NotNull TariffInfoViewModel tariffInfoViewModel) {
        Intrinsics.checkNotNullParameter(tariffInfoViewModel, "<set-?>");
        this.viewModel = tariffInfoViewModel;
    }

    public final void setViewTypeProvider(@NotNull TariffInfoViewTypeProvider tariffInfoViewTypeProvider) {
        Intrinsics.checkNotNullParameter(tariffInfoViewTypeProvider, "<set-?>");
        this.viewTypeProvider = tariffInfoViewTypeProvider;
    }
}
