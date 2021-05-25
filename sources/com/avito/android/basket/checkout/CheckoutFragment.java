package com.avito.android.basket.checkout;

import a2.a.a.q.a.h;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.basket.R;
import com.avito.android.basket.checkout.di.CheckoutComponent;
import com.avito.android.basket.checkout.di.CheckoutDependencies;
import com.avito.android.basket.checkout.di.DaggerCheckoutComponent;
import com.avito.android.basket.checkout.recycler.CheckoutDecoration;
import com.avito.android.basket.checkout.viewmodel.CheckoutViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.button.Button;
import com.avito.android.paid_services.routing.DialogInfo;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.android.util.MenuItemsKt;
import com.avito.android.util.Views;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedRecyclerView;
import com.avito.android.util.architecture_components.auto_clear.AutoClearedValue;
import com.avito.konveyor.adapter.AdapterPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001=\u0018\u0000 y2\u00020\u0001:\u0001yB\u0007¢\u0006\u0004\bx\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR+\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020 8B@BX\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010/\u001a\u00020)2\u0006\u0010!\u001a\u00020)8B@BX\u0002¢\u0006\u0012\n\u0004\b*\u0010#\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R5\u00107\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u000305¢\u0006\u0002\b6048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\"\u0010B\u001a\u00020A8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR+\u0010T\u001a\u00020\t2\u0006\u0010!\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\bO\u0010#\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R+\u0010d\u001a\u00020]2\u0006\u0010!\u001a\u00020]8B@BX\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR+\u0010j\u001a\u00020e2\u0006\u0010!\u001a\u00020e8B@BX\u0002¢\u0006\u0012\n\u0004\bf\u0010#\u001a\u0004\b^\u0010g\"\u0004\bh\u0010iR\"\u0010l\u001a\u00020k8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR+\u0010\n\u001a\u00020r2\u0006\u0010!\u001a\u00020r8B@BX\u0002¢\u0006\u0012\n\u0004\bs\u0010#\u001a\u0004\bt\u0010u\"\u0004\bv\u0010w¨\u0006z"}, d2 = {"Lcom/avito/android/basket/checkout/CheckoutFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onDestroyView", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "i", "Z", "isClosable", "Lcom/avito/android/lib/design/button/Button;", "<set-?>", "e", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "getButton", "()Lcom/avito/android/lib/design/button/Button;", "setButton", "(Lcom/avito/android/lib/design/button/Button;)V", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "getProgressOverlay", "()Lcom/avito/android/progress_overlay/ProgressOverlay;", "setProgressOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progressOverlay", "Landroid/view/MenuItem;", a2.g.r.g.a, "Landroid/view/MenuItem;", "closeButton", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "com/avito/android/basket/checkout/CheckoutFragment$touchEventsListener$1", "k", "Lcom/avito/android/basket/checkout/CheckoutFragment$touchEventsListener$1;", "touchEventsListener", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModel;", "viewModel", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModel;", "getViewModel", "()Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModel;", "setViewModel", "(Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModel;)V", "d", "getContentView", "()Landroid/view/ViewGroup;", "setContentView", "(Landroid/view/ViewGroup;)V", "contentView", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "h", "Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "router", "Lio/reactivex/disposables/Disposable;", "j", "Lio/reactivex/disposables/Disposable;", "subscription", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Landroid/widget/FrameLayout;", "f", "getContainer", "()Landroid/widget/FrameLayout;", "setContainer", "(Landroid/widget/FrameLayout;)V", "<init>", "Companion", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutFragment extends Fragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] l = {a2.b.a.a.a.u0(CheckoutFragment.class, "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;", 0), a2.b.a.a.a.u0(CheckoutFragment.class, "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;", 0), a2.b.a.a.a.u0(CheckoutFragment.class, "progressOverlay", "getProgressOverlay()Lcom/avito/android/progress_overlay/ProgressOverlay;", 0), a2.b.a.a.a.u0(CheckoutFragment.class, "contentView", "getContentView()Landroid/view/ViewGroup;", 0), a2.b.a.a.a.u0(CheckoutFragment.class, PhonePageSourceKt.PHONE_SOURCE_BUTTON, "getButton()Lcom/avito/android/lib/design/button/Button;", 0), a2.b.a.a.a.u0(CheckoutFragment.class, "container", "getContainer()Landroid/widget/FrameLayout;", 0)};
    public final AutoClearedRecyclerView a = new AutoClearedRecyclerView();
    @Inject
    public AdapterPresenter adapterPresenter;
    public final AutoClearedValue b = new AutoClearedValue();
    public final AutoClearedValue c = new AutoClearedValue();
    public final AutoClearedValue d = new AutoClearedValue();
    public final AutoClearedValue e = new AutoClearedValue();
    public final AutoClearedValue f = new AutoClearedValue();
    public MenuItem g;
    public PaidServicesRouter h;
    public boolean i;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;
    public Disposable j;
    public final CheckoutFragment$touchEventsListener$1 k;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public CheckoutViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/basket/checkout/CheckoutFragment$Companion;", "", "", "checkoutContext", "", "closeable", "Lcom/avito/android/basket/checkout/CheckoutFragment;", "newInstance", "(Ljava/lang/String;Z)Lcom/avito/android/basket/checkout/CheckoutFragment;", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final CheckoutFragment newInstance(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "checkoutContext");
            CheckoutFragment checkoutFragment = new CheckoutFragment();
            Bundle bundle = new Bundle();
            bundle.putString("checkout_context", str);
            bundle.putBoolean("closable", z);
            checkoutFragment.setArguments(bundle);
            return checkoutFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CheckoutFragment a;

        public a(CheckoutFragment checkoutFragment) {
            this.a = checkoutFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getViewModel().onContinueButtonClick();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CheckoutFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CheckoutFragment checkoutFragment) {
            super(0);
            this.a = checkoutFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getViewModel().onRetryButtonClick();
            return Unit.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ CheckoutFragment a;

        public c(CheckoutFragment checkoutFragment) {
            this.a = checkoutFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Integer.valueOf(CheckoutFragment.access$getContainer$p(this.a).getTop());
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
        public final /* synthetic */ CheckoutFragment a;

        public e(CheckoutFragment checkoutFragment) {
            this.a = checkoutFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Integer num) {
            Intrinsics.checkNotNullParameter(num, "it");
            return Integer.valueOf(Views.heightWithMargins(CheckoutFragment.access$getContainer$p(this.a)));
        }
    }

    public static final class f<T> implements Consumer<Integer> {
        public final /* synthetic */ CheckoutFragment a;

        public f(CheckoutFragment checkoutFragment) {
            this.a = checkoutFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            RecyclerView access$getRecyclerView$p = CheckoutFragment.access$getRecyclerView$p(this.a);
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            access$getRecyclerView$p.addItemDecoration(new CheckoutDecoration(resources));
            RecyclerView access$getRecyclerView$p2 = CheckoutFragment.access$getRecyclerView$p(this.a);
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            Views.changePadding$default(access$getRecyclerView$p2, 0, 0, 0, num2.intValue(), 7, null);
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ CheckoutFragment a;

        public g(CheckoutFragment checkoutFragment) {
            this.a = checkoutFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RecyclerView access$getRecyclerView$p = CheckoutFragment.access$getRecyclerView$p(this.a);
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            access$getRecyclerView$p.addItemDecoration(new CheckoutDecoration(resources));
        }
    }

    public CheckoutFragment() {
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.j = empty;
        this.k = new CheckoutFragment$touchEventsListener$1();
    }

    public static final Button access$getButton$p(CheckoutFragment checkoutFragment) {
        return (Button) checkoutFragment.e.getValue((Fragment) checkoutFragment, l[4]);
    }

    public static final FrameLayout access$getContainer$p(CheckoutFragment checkoutFragment) {
        return (FrameLayout) checkoutFragment.f.getValue((Fragment) checkoutFragment, l[5]);
    }

    public static final ViewGroup access$getContentView$p(CheckoutFragment checkoutFragment) {
        return (ViewGroup) checkoutFragment.d.getValue((Fragment) checkoutFragment, l[3]);
    }

    public static final ProgressOverlay access$getProgressOverlay$p(CheckoutFragment checkoutFragment) {
        return (ProgressOverlay) checkoutFragment.c.getValue((Fragment) checkoutFragment, l[2]);
    }

    public static final RecyclerView access$getRecyclerView$p(CheckoutFragment checkoutFragment) {
        return (RecyclerView) checkoutFragment.a.getValue((Fragment) checkoutFragment, l[0]);
    }

    public static final void access$setButton$p(CheckoutFragment checkoutFragment, Button button) {
        checkoutFragment.e.setValue((Fragment) checkoutFragment, l[4], (KProperty<?>) button);
    }

    public static final void access$setContainer$p(CheckoutFragment checkoutFragment, FrameLayout frameLayout) {
        checkoutFragment.f.setValue((Fragment) checkoutFragment, l[5], (KProperty<?>) frameLayout);
    }

    public static final void access$setContentView$p(CheckoutFragment checkoutFragment, ViewGroup viewGroup) {
        checkoutFragment.d.setValue((Fragment) checkoutFragment, l[3], (KProperty<?>) viewGroup);
    }

    public static final void access$setProgressOverlay$p(CheckoutFragment checkoutFragment, ProgressOverlay progressOverlay) {
        checkoutFragment.c.setValue((Fragment) checkoutFragment, l[2], (KProperty<?>) progressOverlay);
    }

    public static final void access$setRecyclerView$p(CheckoutFragment checkoutFragment, RecyclerView recyclerView) {
        checkoutFragment.a.setValue((Fragment) checkoutFragment, l[0], (KProperty<?>) recyclerView);
    }

    public final Toolbar a() {
        return (Toolbar) this.b.getValue((Fragment) this, l[1]);
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
    public final CheckoutViewModel getViewModel() {
        CheckoutViewModel checkoutViewModel = this.viewModel;
        if (checkoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkoutViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        CheckoutViewModel checkoutViewModel = this.viewModel;
        if (checkoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        checkoutViewModel.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        Kundle kundle;
        super.onCreate(bundle);
        Context context = getContext();
        PaidServicesRouter paidServicesRouter = null;
        if (!(context instanceof ComponentProvider)) {
            context = null;
        }
        ComponentProvider componentProvider = (ComponentProvider) context;
        if (componentProvider != null) {
            CheckoutDependencies checkoutDependencies = (CheckoutDependencies) componentProvider.getComponent();
            Bundle arguments = getArguments();
            if (arguments == null || (string = arguments.getString("checkout_context")) == null) {
                throw new IllegalStateException("checkout context must be set");
            }
            Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…out context must be set\")");
            Context context2 = getContext();
            if (context2 instanceof PaidServicesRouter) {
                paidServicesRouter = context2;
            }
            PaidServicesRouter paidServicesRouter2 = paidServicesRouter;
            if (paidServicesRouter2 != null) {
                this.h = paidServicesRouter2;
                Bundle arguments2 = getArguments();
                this.i = arguments2 != null ? arguments2.getBoolean("closable") : false;
                if (bundle == null || (kundle = Bundles.getKundle(bundle, "view_model_state")) == null) {
                    kundle = Kundle.Companion.getEMPTY();
                }
                CheckoutComponent.Builder checkoutContext = DaggerCheckoutComponent.builder().dependencies(checkoutDependencies).checkoutContext(string);
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                checkoutContext.resources(resources).savedState(kundle).fragment(this).build().inject(this);
                CheckoutViewModel checkoutViewModel = this.viewModel;
                if (checkoutViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
                if (set == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
                }
                checkoutViewModel.observeItemClicks(set);
                return;
            }
            throw new IllegalStateException("Parent activity must implement PaidServicesRouter");
        }
        throw new IllegalStateException("Parent activity must implement ComponentProvider");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.checkout_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.j.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        CheckoutViewModel checkoutViewModel = this.viewModel;
        if (checkoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Bundles.putKundle(bundle, "view_model_state", checkoutViewModel.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.progress_placeholder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.progress_placeholder)");
        AutoClearedValue autoClearedValue = this.d;
        KProperty<?>[] kPropertyArr = l;
        autoClearedValue.setValue((Fragment) this, kPropertyArr[3], (KProperty<?>) ((ViewGroup) findViewById));
        View findViewById2 = view.findViewById(R.id.continue_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.continue_button)");
        this.e.setValue((Fragment) this, kPropertyArr[4], (KProperty<?>) ((Button) findViewById2));
        ((Button) this.e.getValue((Fragment) this, kPropertyArr[4])).setOnClickListener(new a(this));
        View findViewById3 = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.container)");
        this.f.setValue((Fragment) this, kPropertyArr[5], (KProperty<?>) ((FrameLayout) findViewById3));
        int i2 = R.id.recycler_view;
        View findViewById4 = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.recycler_view)");
        this.a.setValue((Fragment) this, kPropertyArr[0], (KProperty<?>) ((RecyclerView) findViewById4));
        RecyclerView recyclerView = (RecyclerView) this.a.getValue((Fragment) this, kPropertyArr[0]);
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        this.c.setValue((Fragment) this, kPropertyArr[2], (KProperty<?>) new ProgressOverlay((ViewGroup) this.d.getValue((Fragment) this, kPropertyArr[3]), i2, null, false, 0, 28, null));
        ((ProgressOverlay) this.c.getValue((Fragment) this, kPropertyArr[2])).setOnRefreshListener(new b(this));
        View findViewById5 = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.toolbar)");
        this.b.setValue((Fragment) this, kPropertyArr[1], (KProperty<?>) ((Toolbar) findViewById5));
        if (this.i) {
            a().setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
            a().setNavigationOnClickListener(new b1(0, this));
        } else {
            a().setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
            a().setNavigationOnClickListener(new b1(1, this));
            a().inflateMenu(R.menu.menu_checkout);
            MenuItem findItem = a().getMenu().findItem(R.id.menu_close);
            findItem.setOnMenuItemClickListener(new h(this));
            this.g = findItem;
            MenuItemsKt.hide(findItem);
        }
        CheckoutViewModel checkoutViewModel = this.viewModel;
        if (checkoutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        checkoutViewModel.getProgressChanges().observe(getViewLifecycleOwner(), new a2.a.a.q.a.b(this));
        CheckoutViewModel checkoutViewModel2 = this.viewModel;
        if (checkoutViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        checkoutViewModel2.getButtonTextChanges().observe(getViewLifecycleOwner(), new s(0, this));
        CheckoutViewModel checkoutViewModel3 = this.viewModel;
        if (checkoutViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        checkoutViewModel3.getCloseButtonTextChanges().observe(getViewLifecycleOwner(), new s(1, this));
        CheckoutViewModel checkoutViewModel4 = this.viewModel;
        if (checkoutViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        checkoutViewModel4.getListChanges().observe(getViewLifecycleOwner(), new a2.a.a.q.a.c(this));
        CheckoutViewModel checkoutViewModel5 = this.viewModel;
        if (checkoutViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<String> messageEvents = checkoutViewModel5.getMessageEvents();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        messageEvents.observe(viewLifecycleOwner, new s(2, this));
        CheckoutViewModel checkoutViewModel6 = this.viewModel;
        if (checkoutViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DeepLink> routingEvents = checkoutViewModel6.getRoutingEvents();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        routingEvents.observe(viewLifecycleOwner2, new a2.a.a.q.a.d(this));
        CheckoutViewModel checkoutViewModel7 = this.viewModel;
        if (checkoutViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        checkoutViewModel7.getLoadingEvents().observe(getViewLifecycleOwner(), new a2.a.a.q.a.e(this));
        CheckoutViewModel checkoutViewModel8 = this.viewModel;
        if (checkoutViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<Unit> endFlowEvents = checkoutViewModel8.getEndFlowEvents();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        endFlowEvents.observe(viewLifecycleOwner3, new a2.a.a.q.a.f(this));
        CheckoutViewModel checkoutViewModel9 = this.viewModel;
        if (checkoutViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<DialogInfo> dialogEvents = checkoutViewModel9.getDialogEvents();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        dialogEvents.observe(viewLifecycleOwner4, new a2.a.a.q.a.g(this));
        CheckoutViewModel checkoutViewModel10 = this.viewModel;
        if (checkoutViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        checkoutViewModel10.getStartActivityForResultEvents().observe(getViewLifecycleOwner(), new a2.a.a.q.a.a(this));
        Disposable subscribe = RxView.layoutChanges((FrameLayout) this.f.getValue((Fragment) this, kPropertyArr[5])).map(new c(this)).filter(d.a).firstElement().map(new e(this)).subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "container.layoutChanges(…          }\n            )");
        this.j = subscribe;
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

    public final void setViewModel(@NotNull CheckoutViewModel checkoutViewModel) {
        Intrinsics.checkNotNullParameter(checkoutViewModel, "<set-?>");
        this.viewModel = checkoutViewModel;
    }
}
