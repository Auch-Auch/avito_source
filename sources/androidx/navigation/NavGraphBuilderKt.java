package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\b¢\u0006\u0004\b\n\u0010\u000b\u001aA\u0010\n\u001a\u00020\u0006*\u00020\u00052\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\b¢\u0006\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"Landroidx/navigation/NavigatorProvider;", "", "id", "startDestination", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "Landroidx/navigation/NavGraph;", "navigation", "(Landroidx/navigation/NavigatorProvider;IILkotlin/jvm/functions/Function1;)Landroidx/navigation/NavGraph;", "(Landroidx/navigation/NavGraphBuilder;IILkotlin/jvm/functions/Function1;)V", "navigation-common-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class NavGraphBuilderKt {
    @NotNull
    public static final NavGraph navigation(@NotNull NavigatorProvider navigatorProvider, @IdRes int i, @IdRes int i2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(navigatorProvider, "$this$navigation");
        Intrinsics.checkParameterIsNotNull(function1, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        function1.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigatorProvider, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkParameterIsNotNull(navigatorProvider, "$this$navigation");
        Intrinsics.checkParameterIsNotNull(function1, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        function1.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static final void navigation(@NotNull NavGraphBuilder navGraphBuilder, @IdRes int i, @IdRes int i2, @NotNull Function1<? super NavGraphBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(navGraphBuilder, "$this$navigation");
        Intrinsics.checkParameterIsNotNull(function1, "builder");
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), i, i2);
        function1.invoke(navGraphBuilder2);
        navGraphBuilder.destination(navGraphBuilder2);
    }
}
