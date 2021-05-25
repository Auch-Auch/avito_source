package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001aC\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0002\b\nH\b¢\u0006\u0004\b\u0006\u0010\f¨\u0006\r"}, d2 = {"Landroidx/fragment/app/DialogFragment;", "F", "Landroidx/navigation/NavGraphBuilder;", "", "id", "", "dialog", "(Landroidx/navigation/NavGraphBuilder;I)V", "Lkotlin/Function1;", "Landroidx/navigation/fragment/DialogFragmentNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "builder", "(Landroidx/navigation/NavGraphBuilder;ILkotlin/jvm/functions/Function1;)V", "navigation-fragment-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class DialogFragmentNavigatorDestinationBuilderKt {
    public static final /* synthetic */ <F extends DialogFragment> void dialog(@NotNull NavGraphBuilder navGraphBuilder, @IdRes int i, @NotNull Function1<? super DialogFragmentNavigatorDestinationBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(navGraphBuilder, "$this$dialog");
        Intrinsics.checkParameterIsNotNull(function1, "builder");
        Navigator navigator = navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class);
        Intrinsics.checkExpressionValueIsNotNull(navigator, "getNavigator(clazz.java)");
        Intrinsics.reifiedOperationMarker(4, "F");
        DialogFragmentNavigatorDestinationBuilder dialogFragmentNavigatorDestinationBuilder = new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i, Reflection.getOrCreateKotlinClass(DialogFragment.class));
        function1.invoke(dialogFragmentNavigatorDestinationBuilder);
        navGraphBuilder.destination(dialogFragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends DialogFragment> void dialog(@NotNull NavGraphBuilder navGraphBuilder, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(navGraphBuilder, "$this$dialog");
        Navigator navigator = navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class);
        Intrinsics.checkExpressionValueIsNotNull(navigator, "getNavigator(clazz.java)");
        Intrinsics.reifiedOperationMarker(4, "F");
        navGraphBuilder.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i, Reflection.getOrCreateKotlinClass(DialogFragment.class)));
    }
}
