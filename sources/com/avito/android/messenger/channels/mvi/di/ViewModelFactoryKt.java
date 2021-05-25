package com.avito.android.messenger.channels.mvi.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a(\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a0\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\b¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "getViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "", "additionalKey", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;Ljava/lang/String;)Landroidx/lifecycle/ViewModel;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ViewModelFactoryKt {
    public static final /* synthetic */ <T extends ViewModel> T getViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "$this$getViewModel");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModelProvider viewModelProvider = new ViewModelProvider(fragment, factory);
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) viewModelProvider.get(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(t, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return t;
    }

    public static final /* synthetic */ <T extends ViewModel> T getViewModel(Fragment fragment, ViewModelProvider.Factory factory, String str) {
        Intrinsics.checkNotNullParameter(fragment, "$this$getViewModel");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(str, "additionalKey");
        ViewModelProvider viewModelProvider = new ViewModelProvider(fragment, factory);
        StringBuilder sb = new StringBuilder();
        Intrinsics.reifiedOperationMarker(4, "T");
        String C2 = a.C2(ViewModel.class, sb, ':', str);
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) viewModelProvider.get(C2, ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(t, "ViewModelProvider(this, …ionalKey\", T::class.java)");
        return t;
    }
}
