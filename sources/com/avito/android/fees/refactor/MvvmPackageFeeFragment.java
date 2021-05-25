package com.avito.android.fees.refactor;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.fees.PackageFeeListener;
import com.avito.android.fees.R;
import com.avito.android.fees.refactor.di.DaggerPackageFeesComponent;
import com.avito.android.fees.refactor.di.PackageFeesComponent;
import com.avito.android.fees.refactor.di.PackageFeesDependencies;
import com.avito.android.fees.refactor.di.PackageFeesModule;
import com.avito.android.remote.FeesLoadingState;
import com.avito.android.remote.model.AdvertFeesEntity;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ToastsKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\bG\u0010\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/fees/refactor/PackageSelectionListener;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "location", "", "restrictions", "onPackageSelected", "(Lcom/avito/android/remote/model/AdvertFeesEntity;Ljava/util/List;)V", "onDetach", "()V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/fees/PackageFeeListener;", "d", "Lcom/avito/android/fees/PackageFeeListener;", "packageFeeListener", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "loadingDialog", "Lcom/avito/android/fees/refactor/PackageFeeViewModel;", "viewModel", "Lcom/avito/android/fees/refactor/PackageFeeViewModel;", "getViewModel", "()Lcom/avito/android/fees/refactor/PackageFeeViewModel;", "setViewModel", "(Lcom/avito/android/fees/refactor/PackageFeeViewModel;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "<init>", "Companion", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class MvvmPackageFeeFragment extends BaseFragment implements PackageSelectionListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public AdapterPresenter adapterPresenter;
    public RecyclerView c;
    public PackageFeeListener d;
    @Inject
    public DialogRouter dialogRouter;
    public Dialog e;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public PackageFeeViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JC\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment$Companion;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "Lcom/avito/android/remote/model/OwnedPackage;", "packages", "message", "screenTitle", "", "showArrowAsNavigationIcon", "Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment;", "newInstance", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment;", "KEY_ADVERT_ID", "Ljava/lang/String;", "KEY_MESSAGE", "KEY_NAVIGATION_ICON", "KEY_PACKAGES", "KEY_SCREEN_TITLE", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ List c;
            public final /* synthetic */ String d;
            public final /* synthetic */ boolean e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, List list, String str3, boolean z) {
                super(1);
                this.a = str;
                this.b = str2;
                this.c = list;
                this.d = str3;
                this.e = z;
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("key_fragment_item_id", this.a);
                bundle2.putString("key_fragment_message", this.b);
                Bundles.putParcelableList(bundle2, "key_fragment_packages", this.c);
                bundle2.putString("key_title", this.d);
                bundle2.putBoolean("key_navigation", this.e);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        public static /* synthetic */ MvvmPackageFeeFragment newInstance$default(Companion companion, String str, List list, String str2, String str3, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.newInstance(str, list, str2, str3, (i & 16) != 0 ? false : z);
        }

        @NotNull
        public final MvvmPackageFeeFragment newInstance(@NotNull String str, @NotNull List<OwnedPackage> list, @Nullable String str2, @Nullable String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(list, "packages");
            return (MvvmPackageFeeFragment) FragmentsKt.arguments(new MvvmPackageFeeFragment(), 5, new a(str, str2, list, str3, z));
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Observer<List<? extends Item>> {
        public final /* synthetic */ MvvmPackageFeeFragment a;

        public a(MvvmPackageFeeFragment mvvmPackageFeeFragment) {
            this.a = mvvmPackageFeeFragment;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(List<? extends Item> list) {
            List<? extends Item> list2 = list;
            if (list2 != null) {
                a2.b.a.a.a.s1(list2, this.a.getAdapterPresenter());
                RecyclerView.Adapter adapter = MvvmPackageFeeFragment.access$getRecyclerView$p(this.a).getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    public static final class b<T> implements Observer<FeesLoadingState> {
        public final /* synthetic */ MvvmPackageFeeFragment a;

        public b(MvvmPackageFeeFragment mvvmPackageFeeFragment) {
            this.a = mvvmPackageFeeFragment;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(FeesLoadingState feesLoadingState) {
            FeesLoadingState feesLoadingState2 = feesLoadingState;
            if (feesLoadingState2 instanceof FeesLoadingState.Loading) {
                MvvmPackageFeeFragment.access$showLoadingDialog(this.a);
            } else if (feesLoadingState2 instanceof FeesLoadingState.Success) {
                MvvmPackageFeeFragment.access$handleSuccessResult(this.a);
            } else if (feesLoadingState2 instanceof FeesLoadingState.Error) {
                MvvmPackageFeeFragment.access$showError(this.a, ((FeesLoadingState.Error) feesLoadingState2).getMessage());
            }
        }
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(MvvmPackageFeeFragment mvvmPackageFeeFragment) {
        RecyclerView recyclerView = mvvmPackageFeeFragment.c;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final void access$handleSuccessResult(MvvmPackageFeeFragment mvvmPackageFeeFragment) {
        Dialog dialog = mvvmPackageFeeFragment.e;
        if (dialog != null) {
            dialog.dismiss();
        }
        mvvmPackageFeeFragment.e = null;
        PackageFeeListener packageFeeListener = mvvmPackageFeeFragment.d;
        if (packageFeeListener != null) {
            packageFeeListener.onActivationDone();
        }
    }

    public static final void access$showError(MvvmPackageFeeFragment mvvmPackageFeeFragment, String str) {
        Dialog dialog = mvvmPackageFeeFragment.e;
        if (dialog != null) {
            dialog.dismiss();
        }
        mvvmPackageFeeFragment.e = null;
        Context context = mvvmPackageFeeFragment.getContext();
        if (context != null) {
            ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
        }
    }

    public static final void access$showLoadingDialog(MvvmPackageFeeFragment mvvmPackageFeeFragment) {
        if (mvvmPackageFeeFragment.e == null) {
            DialogRouter dialogRouter2 = mvvmPackageFeeFragment.dialogRouter;
            if (dialogRouter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
            }
            mvvmPackageFeeFragment.e = dialogRouter2.showSimpleWaitingDialog();
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
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
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
    public final PackageFeeViewModel getViewModel() {
        PackageFeeViewModel packageFeeViewModel = this.viewModel;
        if (packageFeeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return packageFeeViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.d = (PackageFeeListener) context;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_fees_packages, viewGroup, false);
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.d = null;
    }

    @Override // com.avito.android.fees.refactor.PackageSelectionListener
    public void onPackageSelected(@NotNull AdvertFeesEntity advertFeesEntity, @NotNull List<AdvertFeesEntity> list) {
        Intrinsics.checkNotNullParameter(advertFeesEntity, "location");
        Intrinsics.checkNotNullParameter(list, "restrictions");
        PackageFeeListener packageFeeListener = this.d;
        if (packageFeeListener != null) {
            packageFeeListener.onPackageSelected(advertFeesEntity, list);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new a2.a.a.u0.c.a(this));
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: return");
            String string = arguments.getString("key_title");
            if (string != null) {
                toolbar.setTitle(string);
            }
            toolbar.setNavigationIcon(arguments.getBoolean("key_navigation") ? com.avito.android.ui_components.R.drawable.ic_back_24_blue : com.avito.android.ui_components.R.drawable.ic_close_24_blue);
        }
        View findViewById2 = view.findViewById(R.id.packages_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.packages_container)");
        this.c = (RecyclerView) findViewById2;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        RecyclerView recyclerView = this.c;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter2, itemBinder2);
        RecyclerView recyclerView2 = this.c;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setAdapter(simpleRecyclerAdapter);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.card_margin);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.content_horizontal_padding);
        RecyclerView recyclerView3 = this.c;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.addItemDecoration(new PaddingListDecoration(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset2));
        PackageFeeViewModel packageFeeViewModel = this.viewModel;
        if (packageFeeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        packageFeeViewModel.getDataChanges().observe(getViewLifecycleOwner(), new a(this));
        PackageFeeViewModel packageFeeViewModel2 = this.viewModel;
        if (packageFeeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        packageFeeViewModel2.getProgressChanges().observe(getViewLifecycleOwner(), new b(this));
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Context context = getContext();
        if (!(context instanceof ComponentProvider)) {
            context = null;
        }
        ComponentProvider componentProvider = (ComponentProvider) context;
        if (componentProvider != null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Runti…rguments cannot be null\")");
                String string = arguments.getString("key_fragment_message");
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNullExpressionValue(string, "args.getString(KEY_MESSAGE)!!");
                List parcelableList = Bundles.getParcelableList(arguments, "key_fragment_packages");
                Intrinsics.checkNotNull(parcelableList);
                PackageFeesComponent.Builder module = DaggerPackageFeesComponent.builder().dependencies((PackageFeesDependencies) componentProvider.getComponent()).module(new PackageFeesModule(this, string, parcelableList));
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                module.activity(requireActivity).build().inject(this);
                return true;
            }
            throw new RuntimeException("arguments cannot be null");
        }
        throw new IllegalStateException("Parent activity must implement ComponentProvider");
    }

    public final void setViewModel(@NotNull PackageFeeViewModel packageFeeViewModel) {
        Intrinsics.checkNotNullParameter(packageFeeViewModel, "<set-?>");
        this.viewModel = packageFeeViewModel;
    }
}
