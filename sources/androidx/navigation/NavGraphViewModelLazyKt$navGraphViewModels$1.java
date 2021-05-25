package androidx.navigation;

import androidx.lifecycle.ViewModelProvider;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class NavGraphViewModelLazyKt$navGraphViewModels$1 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Lazy b;
    public final /* synthetic */ KProperty c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$1(Function0 function0, Lazy lazy, KProperty kProperty) {
        super(0);
        this.a = function0;
        this.b = lazy;
        this.c = kProperty;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory factory;
        Function0 function0 = this.a;
        if (function0 != null && (factory = (ViewModelProvider.Factory) function0.invoke()) != null) {
            return factory;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.b.getValue();
        Intrinsics.checkExpressionValueIsNotNull(navBackStackEntry, "backStackEntry");
        ViewModelProvider.Factory defaultViewModelProviderFactory = navBackStackEntry.getDefaultViewModelProviderFactory();
        Intrinsics.checkExpressionValueIsNotNull(defaultViewModelProviderFactory, "backStackEntry.defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
