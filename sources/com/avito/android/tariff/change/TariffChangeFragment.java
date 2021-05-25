package com.avito.android.tariff.change;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.avito.android.ComponentProvider;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.lib.design.button.Button;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.tariff.change.di.DaggerTariffChangeComponent;
import com.avito.android.tariff.change.page.TariffPagerAdapter;
import com.avito.android.tariff.change.page.TariffTab;
import com.avito.android.tariff.change.viewmodel.TariffChangeViewModel;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.TabLayoutsKt;
import com.avito.android.util.Views;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedValue;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.view.ViewLayoutChangeEvent;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001J\u0018\u0000 d2\u00020\u0001:\u0001dB\u0007¢\u0006\u0004\bc\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R+\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R+\u0010)\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020$8B@BX\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R+\u00107\u001a\u0002012\u0006\u0010\u0017\u001a\u0002018B@BX\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0019\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR+\u0010X\u001a\u00020R2\u0006\u0010\u0017\u001a\u00020R8B@BX\u0002¢\u0006\u0012\n\u0004\bS\u0010\u0019\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R+\u0010b\u001a\u00020]2\u0006\u0010\u0017\u001a\u00020]8B@BX\u0002¢\u0006\u0012\n\u0004\bT\u0010\u0019\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006e"}, d2 = {"Lcom/avito/android/tariff/change/TariffChangeFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onDestroyView", "()V", "onDetach", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "<set-?>", "d", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "setProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progressOverlay", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/tariff/change/page/TariffTab;", "i", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Landroidx/viewpager2/widget/ViewPager2;", AuthSource.BOOKING_ORDER, "()Landroidx/viewpager2/widget/ViewPager2;", "setViewPager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "viewPager", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModel;", "viewModel", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModel;", "getViewModel", "()Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModel;", "setViewModel", "(Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModel;)V", "Lcom/avito/android/lib/design/button/Button;", "e", "getButton", "()Lcom/avito/android/lib/design/button/Button;", "setButton", "(Lcom/avito/android/lib/design/button/Button;)V", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/tariff/change/page/TariffPagerAdapter;", "f", "Lcom/avito/android/tariff/change/page/TariffPagerAdapter;", "viewPagerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "com/avito/android/tariff/change/TariffChangeFragment$pageChangeCallback$1", "j", "Lcom/avito/android/tariff/change/TariffChangeFragment$pageChangeCallback$1;", "pageChangeCallback", "Lio/reactivex/disposables/Disposable;", "h", "Lio/reactivex/disposables/Disposable;", "subscription", "Lcom/google/android/material/tabs/TabLayout;", "c", AuthSource.SEND_ABUSE, "()Lcom/google/android/material/tabs/TabLayout;", "setTabsLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "tabsLayout", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", a2.g.r.g.a, "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar", "<init>", "Companion", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffChangeFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] k = {a2.b.a.a.a.u0(TariffChangeFragment.class, "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;", 0), a2.b.a.a.a.u0(TariffChangeFragment.class, "viewPager", "getViewPager()Landroidx/viewpager2/widget/ViewPager2;", 0), a2.b.a.a.a.u0(TariffChangeFragment.class, "tabsLayout", "getTabsLayout()Lcom/google/android/material/tabs/TabLayout;", 0), a2.b.a.a.a.u0(TariffChangeFragment.class, "progressOverlay", "getProgressOverlay()Lcom/avito/android/progress_overlay/ProgressOverlay;", 0), a2.b.a.a.a.u0(TariffChangeFragment.class, PhonePageSourceKt.PHONE_SOURCE_BUTTON, "getButton()Lcom/avito/android/lib/design/button/Button;", 0)};
    public final AutoClearedValue a = new AutoClearedValue();
    public final AutoClearedValue b = new AutoClearedValue();
    public final AutoClearedValue c = new AutoClearedValue();
    public final AutoClearedValue d = new AutoClearedValue();
    public final AutoClearedValue e = new AutoClearedValue();
    public TariffPagerAdapter f;
    public PaidServicesRouter g;
    public Disposable h;
    public final TabsDataProvider<TariffTab> i;
    @Inject
    public ItemBinder itemBinder;
    public final TariffChangeFragment$pageChangeCallback$1 j;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public TariffChangeViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/tariff/change/TariffChangeFragment$Companion;", "", "Lcom/avito/android/tariff/change/TariffChangeFragment;", "newInstance", "()Lcom/avito/android/tariff/change/TariffChangeFragment;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TariffChangeFragment newInstance() {
            TariffChangeFragment tariffChangeFragment = new TariffChangeFragment();
            tariffChangeFragment.setArguments(new Bundle());
            return tariffChangeFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TariffChangeFragment a;

        public a(TariffChangeFragment tariffChangeFragment) {
            this.a = tariffChangeFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.requireActivity().onBackPressed();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TariffChangeFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TariffChangeFragment tariffChangeFragment) {
            super(0);
            this.a = tariffChangeFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Predicate<ViewLayoutChangeEvent> {
        public final /* synthetic */ TariffChangeFragment a;

        public c(TariffChangeFragment tariffChangeFragment) {
            this.a = tariffChangeFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(ViewLayoutChangeEvent viewLayoutChangeEvent) {
            Intrinsics.checkNotNullParameter(viewLayoutChangeEvent, "it");
            return TariffChangeFragment.access$getButton$p(this.a).getHeight() > 0;
        }
    }

    public static final class d<T, R> implements Function<ViewLayoutChangeEvent, Integer> {
        public final /* synthetic */ TariffChangeFragment a;

        public d(TariffChangeFragment tariffChangeFragment) {
            this.a = tariffChangeFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(ViewLayoutChangeEvent viewLayoutChangeEvent) {
            Intrinsics.checkNotNullParameter(viewLayoutChangeEvent, "it");
            return Integer.valueOf(Views.heightWithMargins(TariffChangeFragment.access$getButton$p(this.a)));
        }
    }

    public static final class e<T> implements Consumer<Integer> {
        public final /* synthetic */ TariffChangeFragment a;

        public e(TariffChangeFragment tariffChangeFragment) {
            this.a = tariffChangeFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            TariffPagerAdapter access$getViewPagerAdapter$p = TariffChangeFragment.access$getViewPagerAdapter$p(this.a);
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            access$getViewPagerAdapter$p.updateButtonOffset(num2.intValue());
            int currentItem = this.a.b().getCurrentItem();
            TariffChangeFragment.access$getViewPagerAdapter$p(this.a).notifyDataSetChanged();
            if (currentItem >= 0) {
                this.a.b().setCurrentItem(currentItem, false);
            }
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class g implements TabLayoutMediator.TabConfigurationStrategy {
        public final /* synthetic */ TariffChangeFragment a;

        public g(TariffChangeFragment tariffChangeFragment) {
            this.a = tariffChangeFragment;
        }

        @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
        public final void onConfigureTab(@NotNull TabLayout.Tab tab, int i) {
            Intrinsics.checkNotNullParameter(tab, "<anonymous parameter 0>");
            TabAdapter<?, ?> adapter = TabLayoutsKt.getAdapter(this.a.a());
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public TariffChangeFragment() {
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.h = empty;
        this.i = new TabsDataProvider<>();
        this.j = new TariffChangeFragment$pageChangeCallback$1(this);
    }

    public static final Button access$getButton$p(TariffChangeFragment tariffChangeFragment) {
        return (Button) tariffChangeFragment.e.getValue((Fragment) tariffChangeFragment, k[4]);
    }

    public static final ProgressOverlay access$getProgressOverlay$p(TariffChangeFragment tariffChangeFragment) {
        return (ProgressOverlay) tariffChangeFragment.d.getValue((Fragment) tariffChangeFragment, k[3]);
    }

    public static final /* synthetic */ TariffPagerAdapter access$getViewPagerAdapter$p(TariffChangeFragment tariffChangeFragment) {
        TariffPagerAdapter tariffPagerAdapter = tariffChangeFragment.f;
        if (tariffPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerAdapter");
        }
        return tariffPagerAdapter;
    }

    public static final void access$setButton$p(TariffChangeFragment tariffChangeFragment, Button button) {
        tariffChangeFragment.e.setValue((Fragment) tariffChangeFragment, k[4], (KProperty<?>) button);
    }

    public static final void access$setProgressOverlay$p(TariffChangeFragment tariffChangeFragment, ProgressOverlay progressOverlay) {
        tariffChangeFragment.d.setValue((Fragment) tariffChangeFragment, k[3], (KProperty<?>) progressOverlay);
    }

    public static final void access$setTabsLayout$p(TariffChangeFragment tariffChangeFragment, TabLayout tabLayout) {
        tariffChangeFragment.c.setValue((Fragment) tariffChangeFragment, k[2], (KProperty<?>) tabLayout);
    }

    public static final void access$setViewPager$p(TariffChangeFragment tariffChangeFragment, ViewPager2 viewPager2) {
        tariffChangeFragment.b.setValue((Fragment) tariffChangeFragment, k[1], (KProperty<?>) viewPager2);
    }

    public final TabLayout a() {
        return (TabLayout) this.c.getValue((Fragment) this, k[2]);
    }

    public final ViewPager2 b() {
        return (ViewPager2) this.b.getValue((Fragment) this, k[1]);
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
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final TariffChangeViewModel getViewModel() {
        TariffChangeViewModel tariffChangeViewModel = this.viewModel;
        if (tariffChangeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return tariffChangeViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
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
                if (bundle == null || (kundle = Bundles.getKundle(bundle, "vm_state")) == null) {
                    kundle = Kundle.Companion.getEMPTY();
                }
                DaggerTariffChangeComponent.factory().create(this, tariffStepDependencies, kundle).inject(this);
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
        return layoutInflater.inflate(R.layout.tariff_change_fragment, viewGroup, false);
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
        TariffChangeViewModel tariffChangeViewModel = this.viewModel;
        if (tariffChangeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Bundles.putKundle(bundle, "vm_state", tariffChangeViewModel.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.view_pager)");
        AutoClearedValue autoClearedValue = this.b;
        KProperty<?>[] kPropertyArr = k;
        autoClearedValue.setValue((Fragment) this, kPropertyArr[1], (KProperty<?>) ((ViewPager2) findViewById));
        View findViewById2 = view.findViewById(R.id.tabs);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tabs)");
        this.c.setValue((Fragment) this, kPropertyArr[2], (KProperty<?>) ((TabLayout) findViewById2));
        View findViewById3 = view.findViewById(R.id.continue_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.continue_button)");
        this.e.setValue((Fragment) this, kPropertyArr[4], (KProperty<?>) ((Button) findViewById3));
        View findViewById4 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.toolbar)");
        this.a.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) ((Toolbar) findViewById4));
        ((Toolbar) this.a.getValue((Fragment) this, kPropertyArr[0])).setNavigationOnClickListener(new a(this));
        View findViewById5 = view.findViewById(R.id.progress_placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.progress_placeholder)");
        this.d.setValue((Fragment) this, kPropertyArr[3], (KProperty<?>) new ProgressOverlay((ViewGroup) findViewById5, R.id.recycler_view, null, false, 0, 28, null));
        ((ProgressOverlay) this.d.getValue((Fragment) this, kPropertyArr[3])).setOnRefreshListener(new b(this));
        TabsDataProvider<TariffTab> tabsDataProvider = this.i;
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        this.f = new TariffPagerAdapter(tabsDataProvider, itemBinder2);
        ViewPager2 b2 = b();
        TariffPagerAdapter tariffPagerAdapter = this.f;
        if (tariffPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerAdapter");
        }
        b2.setAdapter(tariffPagerAdapter);
        TabLayout a3 = a();
        TabsDataProvider<TariffTab> tabsDataProvider2 = this.i;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        TabLayoutsKt.setAdapter(a3, new TabLayoutAdapter(tabsDataProvider2, requireContext, 0, 4, null));
        new TabLayoutMediator(a(), b(), new g(this)).attach();
        Disposable subscribe = RxView.layoutChangeEvents((Button) this.e.getValue((Fragment) this, kPropertyArr[4])).filter(new c(this)).firstElement().map(new d(this)).subscribe(new e(this), f.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "button.layoutChangeEvent…error(it) }\n            )");
        this.h = subscribe;
        TariffChangeViewModel tariffChangeViewModel = this.viewModel;
        if (tariffChangeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffChangeViewModel.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.a.c(this));
        TariffChangeViewModel tariffChangeViewModel2 = this.viewModel;
        if (tariffChangeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffChangeViewModel2.getButtonChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.a.e(this));
        TariffChangeViewModel tariffChangeViewModel3 = this.viewModel;
        if (tariffChangeViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        tariffChangeViewModel3.getTabsListChanges().observe(getViewLifecycleOwner(), new a2.a.a.e3.a.f(this));
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setViewModel(@NotNull TariffChangeViewModel tariffChangeViewModel) {
        Intrinsics.checkNotNullParameter(tariffChangeViewModel, "<set-?>");
        this.viewModel = tariffChangeViewModel;
    }
}
