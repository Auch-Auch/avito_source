package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\n¢\u0006\u0004\b\u000b\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\n¢\u0006\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/navigation/NavGraph;", "", "id", "Landroidx/navigation/NavDestination;", "get", "(Landroidx/navigation/NavGraph;I)Landroidx/navigation/NavDestination;", "", "contains", "(Landroidx/navigation/NavGraph;I)Z", "node", "", "plusAssign", "(Landroidx/navigation/NavGraph;Landroidx/navigation/NavDestination;)V", "other", "(Landroidx/navigation/NavGraph;Landroidx/navigation/NavGraph;)V", "minusAssign", "navigation-common-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class NavGraphKt {
    public static final boolean contains(@NotNull NavGraph navGraph, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(navGraph, "$this$contains");
        return navGraph.findNode(i) != null;
    }

    @NotNull
    public static final NavDestination get(@NotNull NavGraph navGraph, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(navGraph, "$this$get");
        NavDestination findNode = navGraph.findNode(i);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + i + " was found in " + navGraph);
    }

    public static final void minusAssign(@NotNull NavGraph navGraph, @NotNull NavDestination navDestination) {
        Intrinsics.checkParameterIsNotNull(navGraph, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(navDestination, "node");
        navGraph.remove(navDestination);
    }

    public static final void plusAssign(@NotNull NavGraph navGraph, @NotNull NavDestination navDestination) {
        Intrinsics.checkParameterIsNotNull(navGraph, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(navDestination, "node");
        navGraph.addDestination(navDestination);
    }

    public static final void plusAssign(@NotNull NavGraph navGraph, @NotNull NavGraph navGraph2) {
        Intrinsics.checkParameterIsNotNull(navGraph, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(navGraph2, "other");
        navGraph.addAll(navGraph2);
    }
}
