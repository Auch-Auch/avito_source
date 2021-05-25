package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\b¢\u0006\u0004\b\t\u0010\n¨\u0006\r²\u0006\u001a\u0010\f\u001a\u00020\u000b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\n@\nX\u0002"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "", "navGraphId", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lkotlin/Lazy;", "navGraphViewModels", "(Landroidx/fragment/app/Fragment;ILkotlin/jvm/functions/Function0;)Lkotlin/Lazy;", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "navigation-fragment-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class NavGraphViewModelLazyKt {
    public static final /* synthetic */ KProperty[] a = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(NavGraphViewModelLazyKt.class, "navigation-fragment-ktx_release"), "backStackEntry", "<v#0>"))};

    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> navGraphViewModels(@NotNull Fragment fragment, @IdRes int i, @Nullable Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$navGraphViewModels");
        Lazy lazy = c.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i));
        KProperty0 kProperty0 = NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$1.INSTANCE;
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(lazy, kProperty0);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, new NavGraphViewModelLazyKt$navGraphViewModels$1(function0, lazy, kProperty0));
    }

    public static /* synthetic */ Lazy navGraphViewModels$default(Fragment fragment, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function0 = null;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$this$navGraphViewModels");
        Lazy lazy = c.lazy(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(fragment, i));
        KProperty0 kProperty0 = NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$1.INSTANCE;
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(lazy, kProperty0);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, new NavGraphViewModelLazyKt$navGraphViewModels$1(function0, lazy, kProperty0));
    }
}
