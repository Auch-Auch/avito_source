package com.avito.android.hints;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.hints.di.DaggerHintsComponent;
import com.avito.android.hints.di.HintsComponent;
import com.avito.android.hints.di.HintsDependencies;
import com.avito.android.hints.viewmodel.HintViewModel;
import com.avito.android.hints.viewmodel.HintViewModelImpl;
import com.avito.android.lib.design.page_indicator.PageIndicator;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001R\u0018\u0000 i2\u00020\u0001:\u0001iB\u0007¢\u0006\u0004\bh\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b^\u0010_R\"\u0010b\u001a\u00020a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g¨\u0006j"}, d2 = {"Lcom/avito/android/hints/HintsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "", "closeActivity", "()V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/avito/android/hints/viewmodel/HintViewModel;", g.a, "Lcom/avito/android/hints/viewmodel/HintViewModel;", "viewModel", "Landroidx/core/widget/NestedScrollView;", "e", "Landroidx/core/widget/NestedScrollView;", "nestedScrollView", "Lio/reactivex/disposables/Disposable;", "j", "Lio/reactivex/disposables/Disposable;", "disposable", "", "k", "[I", "visibleItems", "Lru/avito/component/bottom_sheet/BottomSheet;", "f", "Lru/avito/component/bottom_sheet/BottomSheet;", "bottomSheet", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "i", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "", "l", "I", "lastCompletelyVisiblePage", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "d", "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "pageIndicator", "", AuthSource.OPEN_CHANNEL_LIST, "Z", "needToRequestLayout", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "contentView", "Lcom/avito/android/hints/HintDecoration;", "h", "Lcom/avito/android/hints/HintDecoration;", "decoration", "com/avito/android/hints/HintsDialogFragment$scrollListener$1", "n", "Lcom/avito/android/hints/HintsDialogFragment$scrollListener$1;", "scrollListener", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "<init>", "Companion", "hints_release"}, k = 1, mv = {1, 4, 2})
public final class HintsDialogFragment extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public ViewGroup a;
    @Inject
    public AdapterPresenter adapterPresenter;
    public RecyclerView b;
    public ProgressOverlay c;
    public PageIndicator d;
    public NestedScrollView e;
    public BottomSheet f;
    public HintViewModel g;
    public HintDecoration h;
    public LinearLayoutManager i;
    @Inject
    public ItemBinder itemBinder;
    public Disposable j;
    public final int[] k;
    public int l;
    public boolean m;
    public final HintsDialogFragment$scrollListener$1 n;
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/hints/HintsDialogFragment$Companion;", "", "", "hintType", "Lcom/avito/android/hints/HintsDialogFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/hints/HintsDialogFragment;", "KEY_HINT_TYPE", "Ljava/lang/String;", "<init>", "()V", "hints_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final HintsDialogFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "hintType");
            HintsDialogFragment hintsDialogFragment = new HintsDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("hint", str);
            hintsDialogFragment.setArguments(bundle);
            return hintsDialogFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ HintsDialogFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HintsDialogFragment hintsDialogFragment) {
            super(0);
            this.a = hintsDialogFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            HintsDialogFragment.access$getViewModel$p(this.a).onRetryClicked();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function<ViewLayoutChangeEvent, Integer> {
        public final /* synthetic */ HintsDialogFragment a;

        public b(HintsDialogFragment hintsDialogFragment) {
            this.a = hintsDialogFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(ViewLayoutChangeEvent viewLayoutChangeEvent) {
            Intrinsics.checkNotNullParameter(viewLayoutChangeEvent, "it");
            return Integer.valueOf(HintsDialogFragment.access$getPageIndicator$p(this.a).getTop());
        }
    }

    public static final class c<T, R> implements Function<Integer, Integer> {
        public final /* synthetic */ HintsDialogFragment a;

        public c(HintsDialogFragment hintsDialogFragment) {
            this.a = hintsDialogFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullParameter(num2, "it");
            return Integer.valueOf(HintsDialogFragment.access$getNestedScrollView$p(this.a).getBottom() - num2.intValue());
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

    public static final class e<T> implements Consumer<Integer> {
        public final /* synthetic */ HintsDialogFragment a;

        public e(HintsDialogFragment hintsDialogFragment) {
            this.a = hintsDialogFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            HintsDialogFragment hintsDialogFragment = this.a;
            Resources resources = hintsDialogFragment.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            hintsDialogFragment.h = new HintDecoration(resources, num2.intValue());
            HintsDialogFragment.access$getRecyclerView$p(this.a).addItemDecoration(HintsDialogFragment.access$getDecoration$p(this.a));
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public HintsDialogFragment() {
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.j = empty;
        int[] iArr = new int[2];
        for (int i2 = 0; i2 < 2; i2++) {
            iArr[i2] = -1;
        }
        this.k = iArr;
        this.l = -1;
        this.n = new HintsDialogFragment$scrollListener$1(this);
    }

    public static final /* synthetic */ BottomSheet access$getBottomSheet$p(HintsDialogFragment hintsDialogFragment) {
        BottomSheet bottomSheet = hintsDialogFragment.f;
        if (bottomSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSheet");
        }
        return bottomSheet;
    }

    public static final /* synthetic */ HintDecoration access$getDecoration$p(HintsDialogFragment hintsDialogFragment) {
        HintDecoration hintDecoration = hintsDialogFragment.h;
        if (hintDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoration");
        }
        return hintDecoration;
    }

    public static final /* synthetic */ LinearLayoutManager access$getLayoutManager$p(HintsDialogFragment hintsDialogFragment) {
        LinearLayoutManager linearLayoutManager = hintsDialogFragment.i;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        return linearLayoutManager;
    }

    public static final /* synthetic */ NestedScrollView access$getNestedScrollView$p(HintsDialogFragment hintsDialogFragment) {
        NestedScrollView nestedScrollView = hintsDialogFragment.e;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
        }
        return nestedScrollView;
    }

    public static final /* synthetic */ PageIndicator access$getPageIndicator$p(HintsDialogFragment hintsDialogFragment) {
        PageIndicator pageIndicator = hintsDialogFragment.d;
        if (pageIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageIndicator");
        }
        return pageIndicator;
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(HintsDialogFragment hintsDialogFragment) {
        ProgressOverlay progressOverlay = hintsDialogFragment.c;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(HintsDialogFragment hintsDialogFragment) {
        RecyclerView recyclerView = hintsDialogFragment.b;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ HintViewModel access$getViewModel$p(HintsDialogFragment hintsDialogFragment) {
        HintViewModel hintViewModel = hintsDialogFragment.g;
        if (hintViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return hintViewModel;
    }

    public final void closeActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "it");
            if (!activity.isFinishing() && !activity.isChangingConfigurations()) {
                activity.finish();
            }
        }
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
    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return factory;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("hint")) == null) {
            throw new IllegalStateException("type must be set");
        }
        Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…ption(\"type must be set\")");
        HintsComponent.Builder hintType = DaggerHintsComponent.builder().dependencies((HintsDependencies) ComponentDependenciesKt.getDependencies(HintsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).hintType(string);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        hintType.resources(resources).build().inject(this);
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, factory).get(HintViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…iewModelImpl::class.java)");
        this.g = (HintViewModel) viewModel;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.Theme_Avito_Dialog_FullScreen);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            window.setBackgroundDrawable(new ColorDrawable(Contexts.getColorByAttr(requireContext, com.avito.android.lib.design.R.attr.blackAlpha24)));
        }
        View inflate = layoutInflater.inflate(R.layout.hints_dialog_fragment, viewGroup, false);
        BottomSheet.Companion companion = BottomSheet.Companion;
        View findViewById = inflate.findViewById(R.id.hints_bottom_sheet_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.hints_bottom_sheet_layout)");
        BottomSheet create = companion.create(findViewById);
        create.setContentView(R.layout.hints_content);
        create.setPeekHeight(new BottomSheet.PeekHeight.Relative(1.0f, 0, 2, null));
        Views.conceal(create.getView());
        if (getResources().getBoolean(R.bool.is_tablet)) {
            create.setHideable(false);
            create.setNotchVisibility(BottomSheet.NotchVisibility.ALWAYS_HIDDEN);
        }
        this.f = create;
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        NestedScrollView nestedScrollView = this.e;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
        }
        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) null);
        RecyclerView recyclerView = this.b;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.removeOnScrollListener(this.n);
        this.j.dispose();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        closeActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        this.b = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.container)");
        this.a = (ViewGroup) findViewById2;
        View findViewById3 = view.findViewById(R.id.page_indicator);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.page_indicator)");
        this.d = (PageIndicator) findViewById3;
        View findViewById4 = view.findViewById(R.id.nested_scroll_view);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.nested_scroll_view)");
        this.e = (NestedScrollView) findViewById4;
        ViewGroup viewGroup = this.a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        int i2 = R.id.progress_overlay_container;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i2, null, false, Contexts.getColorByAttr(requireContext, com.avito.android.lib.design.R.attr.transparentBlack), 12, null);
        this.c = progressOverlay;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        progressOverlay.setOnRefreshListener(new a(this));
        RecyclerView recyclerView = this.b;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        recyclerView2.setAdapter(new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2));
        this.i = new LinearLayoutManager(requireContext(), 0, false);
        RecyclerView recyclerView3 = this.b;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        LinearLayoutManager linearLayoutManager = this.i;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView3.setLayoutManager(linearLayoutManager);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        RecyclerView recyclerView4 = this.b;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        pagerSnapHelper.attachToRecyclerView(recyclerView4);
        RecyclerView recyclerView5 = this.b;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.LayoutManager layoutManager = recyclerView5.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.setMeasurementCacheEnabled(false);
        }
        PageIndicator pageIndicator = this.d;
        if (pageIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageIndicator");
        }
        RecyclerView recyclerView6 = this.b;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        pageIndicator.attachToRecyclerView(recyclerView6);
        NestedScrollView nestedScrollView = this.e;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
        }
        nestedScrollView.setOnScrollChangeListener(new a2.a.a.z0.d(this));
        RecyclerView recyclerView7 = this.b;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView7.addOnScrollListener(this.n);
        HintViewModel hintViewModel = this.g;
        if (hintViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        BottomSheet bottomSheet = this.f;
        if (bottomSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSheet");
        }
        hintViewModel.observeVisibilityChanges(InteropKt.toV2(bottomSheet.getVisibilityObservable()));
        HintViewModel hintViewModel2 = this.g;
        if (hintViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        hintViewModel2.getDataChanges().observe(requireActivity(), new a2.a.a.z0.a(this));
        HintViewModel hintViewModel3 = this.g;
        if (hintViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        hintViewModel3.getProgressChanges().observe(requireActivity(), new a2.a.a.z0.b(this));
        HintViewModel hintViewModel4 = this.g;
        if (hintViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        hintViewModel4.getCloseEvents().observe(requireActivity(), new a2.a.a.z0.c(this));
        PageIndicator pageIndicator2 = this.d;
        if (pageIndicator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageIndicator");
        }
        Disposable subscribe = RxView.layoutChangeEvents(pageIndicator2).map(new b(this)).map(new c(this)).filter(d.a).firstElement().subscribe(new e(this), f.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "pageIndicator.layoutChan…     }, { Timber.e(it) })");
        this.j = subscribe;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}
