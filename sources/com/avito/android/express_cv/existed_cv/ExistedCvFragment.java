package com.avito.android.express_cv.existed_cv;

import a2.a.a.p0.n.a;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ComponentProvider;
import com.avito.android.express_cv.CvItemsDecoration;
import com.avito.android.express_cv.ExistedCvDataProvider;
import com.avito.android.express_cv.R;
import com.avito.android.express_cv.StickDisclaimerToBottomItemDecorator;
import com.avito.android.express_cv.di.ExpressCvComponent;
import com.avito.android.express_cv.existed_cv.di.DaggerExistedCvComponent;
import com.avito.android.express_cv.existed_cv.di.ExistedCvModule;
import com.avito.android.express_cv.new_cv.NewCvFragmentKt;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u00107\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/avito/android/express_cv/existed_cv/ExistedCvFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/express_cv/ExistedCvDataProvider;", "viewModel", "Lcom/avito/android/express_cv/ExistedCvDataProvider;", "getViewModel", "()Lcom/avito/android/express_cv/ExistedCvDataProvider;", "setViewModel", "(Lcom/avito/android/express_cv/ExistedCvDataProvider;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/ComponentProvider;", "Lcom/avito/android/express_cv/di/ExpressCvComponent;", "e", "Lcom/avito/android/ComponentProvider;", "componentProvider", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "<init>", "()V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class ExistedCvFragment extends BaseFragment {
    @Inject
    public AdapterPresenter adapterPresenter;
    public RecyclerView c;
    public LinearLayoutManager d;
    @Inject
    public DeviceMetrics deviceMetrics;
    public ComponentProvider<ExpressCvComponent> e;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public ExistedCvDataProvider viewModel;

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(ExistedCvFragment existedCvFragment) {
        RecyclerView recyclerView = existedCvFragment.c;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
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
    public final DeviceMetrics getDeviceMetrics() {
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        return deviceMetrics2;
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
    public final ExistedCvDataProvider getViewModel() {
        ExistedCvDataProvider existedCvDataProvider = this.viewModel;
        if (existedCvDataProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return existedCvDataProvider;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.e = (ComponentProvider) context;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.cv_tab_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ComponentProvider<ExpressCvComponent> componentProvider = this.e;
        if (componentProvider != null) {
            ExpressCvComponent component = componentProvider.getComponent();
            Objects.requireNonNull(component, "null cannot be cast to non-null type com.avito.android.express_cv.existed_cv.di.ExistedCvComponentDependencies");
            DaggerExistedCvComponent.builder().existedCvModule(new ExistedCvModule()).dependencies(component).build().inject(this);
            View findViewById = view.findViewById(R.id.recycler_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
            this.c = (RecyclerView) findViewById;
            this.d = new LinearLayoutManager(getContext(), 1, false);
            RecyclerView recyclerView = this.c;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            LinearLayoutManager linearLayoutManager = this.d;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            }
            recyclerView.setLayoutManager(linearLayoutManager);
            ExistedCvDataProvider existedCvDataProvider = this.viewModel;
            if (existedCvDataProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            existedCvDataProvider.getExistedCvItems().observe(getViewLifecycleOwner(), new a(this));
            RecyclerView recyclerView2 = this.c;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            DeviceMetrics deviceMetrics2 = this.deviceMetrics;
            if (deviceMetrics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
            }
            NewCvFragmentKt.addCvPaddingsIfNeeded(recyclerView2, deviceMetrics2);
            RecyclerView recyclerView3 = this.c;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "this.resources");
            recyclerView3.addItemDecoration(new CvItemsDecoration(resources));
            RecyclerView recyclerView4 = this.c;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            recyclerView4.addItemDecoration(new StickDisclaimerToBottomItemDecorator());
            return;
        }
        throw new IllegalStateException("Activity must implement ComponentProvider<ExpressCvComponent> interface");
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setDeviceMetrics(@NotNull DeviceMetrics deviceMetrics2) {
        Intrinsics.checkNotNullParameter(deviceMetrics2, "<set-?>");
        this.deviceMetrics = deviceMetrics2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setViewModel(@NotNull ExistedCvDataProvider existedCvDataProvider) {
        Intrinsics.checkNotNullParameter(existedCvDataProvider, "<set-?>");
        this.viewModel = existedCvDataProvider;
    }
}
