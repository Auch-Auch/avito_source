package com.sumsub.camera.selfie.with.document.presentation;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SNSSelfieWithDocumentPickerActivity$$special$$inlined$viewModels$1 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ ComponentActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSSelfieWithDocumentPickerActivity$$special$$inlined$viewModels$1(ComponentActivity componentActivity) {
        super(0);
        this.a = componentActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.a.getDefaultViewModelProviderFactory();
        Intrinsics.checkExpressionValueIsNotNull(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
