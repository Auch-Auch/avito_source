package com.avito.android.express_cv.new_cv;

import a2.a.a.p0.o.a;
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
import com.avito.android.express_cv.NewCvDataProvider;
import com.avito.android.express_cv.StickDisclaimerToBottomItemDecorator;
import com.avito.android.express_cv.di.ExpressCvComponent;
import com.avito.android.express_cv.new_cv.di.DaggerNewCvComponent;
import com.avito.android.express_cv.new_cv.di.NewCvComponent;
import com.avito.android.express_cv.new_cv.di.NewCvModule;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X.¢\u0006\u0006\n\u0004\b2\u00103R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/avito/android/express_cv/new_cv/NewCvFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/ComponentProvider;", "Lcom/avito/android/express_cv/di/ExpressCvComponent;", "e", "Lcom/avito/android/ComponentProvider;", "componentProvider", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/express_cv/NewCvDataProvider;", "viewModel", "Lcom/avito/android/express_cv/NewCvDataProvider;", "getViewModel", "()Lcom/avito/android/express_cv/NewCvDataProvider;", "setViewModel", "(Lcom/avito/android/express_cv/NewCvDataProvider;)V", "<init>", "()V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class NewCvFragment extends BaseFragment {
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
    public NewCvDataProvider viewModel;

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(NewCvFragment newCvFragment) {
        RecyclerView recyclerView = newCvFragment.c;
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
    public final NewCvDataProvider getViewModel() {
        NewCvDataProvider newCvDataProvider = this.viewModel;
        if (newCvDataProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return newCvDataProvider;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.e = (ComponentProvider) context;
        Intrinsics.checkNotNull(context.getDrawable(R.drawable.recycler_view_divider));
        getResources().getDimensionPixelSize(R.dimen.publish_card_padding_horizontal);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(com.avito.android.express_cv.R.layout.cv_tab_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ComponentProvider<ExpressCvComponent> componentProvider = this.e;
        if (componentProvider != null) {
            ExpressCvComponent component = componentProvider.getComponent();
            Objects.requireNonNull(component, "null cannot be cast to non-null type com.avito.android.express_cv.new_cv.di.NewCvComponentDependencies");
            NewCvComponent.Builder builder = DaggerNewCvComponent.builder();
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            builder.newCvModule(new NewCvModule(context)).dependencies(component).build().inject(this);
            View findViewById = view.findViewById(com.avito.android.express_cv.R.id.recycler_view);
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
            RecyclerView recyclerView2 = this.c;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            DeviceMetrics deviceMetrics2 = this.deviceMetrics;
            if (deviceMetrics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
            }
            NewCvFragmentKt.addCvPaddingsIfNeeded(recyclerView2, deviceMetrics2);
            NewCvDataProvider newCvDataProvider = this.viewModel;
            if (newCvDataProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            newCvDataProvider.getNewCvItems().observe(getViewLifecycleOwner(), new a(this));
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

    public final void setViewModel(@NotNull NewCvDataProvider newCvDataProvider) {
        Intrinsics.checkNotNullParameter(newCvDataProvider, "<set-?>");
        this.viewModel = newCvDataProvider;
    }
}
