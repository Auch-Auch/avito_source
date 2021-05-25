package com.avito.android.app.arch_components;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00072\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "getViewModel", "(Landroidx/fragment/app/FragmentActivity;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ViewModelFactoryKt {
    public static final /* synthetic */ <T extends ViewModel> T getViewModel(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$this$getViewModel");
        ViewModelProvider of = ViewModelProviders.of(fragmentActivity, factory);
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) of.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(t, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        return t;
    }

    public static /* synthetic */ ViewModel getViewModel$default(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory, int i, Object obj) {
        if ((i & 1) != 0) {
            factory = null;
        }
        Intrinsics.checkNotNullParameter(fragmentActivity, "$this$getViewModel");
        ViewModelProvider of = ViewModelProviders.of(fragmentActivity, factory);
        Intrinsics.reifiedOperationMarker(4, "T");
        ViewModel viewModel = of.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        return viewModel;
    }

    public static final /* synthetic */ <T extends ViewModel> T getViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "$this$getViewModel");
        ViewModelProvider of = ViewModelProviders.of(fragment, factory);
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) of.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(t, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        return t;
    }

    public static /* synthetic */ ViewModel getViewModel$default(Fragment fragment, ViewModelProvider.Factory factory, int i, Object obj) {
        if ((i & 1) != 0) {
            factory = null;
        }
        Intrinsics.checkNotNullParameter(fragment, "$this$getViewModel");
        ViewModelProvider of = ViewModelProviders.of(fragment, factory);
        Intrinsics.reifiedOperationMarker(4, "T");
        ViewModel viewModel = of.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        return viewModel;
    }
}
