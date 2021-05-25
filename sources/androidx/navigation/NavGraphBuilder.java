package androidx.navigation;

import a2.g.r.g;
import com.avito.android.util.preferences.GeoContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@NavDestinationDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0018\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavGraphBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "D", "navDestination", "", "destination", "(Landroidx/navigation/NavDestinationBuilder;)V", "unaryPlus", "(Landroidx/navigation/NavDestination;)V", "addDestination", "build", "()Landroidx/navigation/NavGraph;", "", g.a, "Ljava/util/List;", "destinations", "Landroidx/navigation/NavigatorProvider;", "h", "Landroidx/navigation/NavigatorProvider;", "getProvider", "()Landroidx/navigation/NavigatorProvider;", GeoContract.PROVIDER, "", "i", "I", "startDestination", "id", "<init>", "(Landroidx/navigation/NavigatorProvider;II)V", "navigation-common-ktx_release"}, k = 1, mv = {1, 4, 0})
public final class NavGraphBuilder extends NavDestinationBuilder<NavGraph> {
    public final List<NavDestination> g = new ArrayList();
    @NotNull
    public final NavigatorProvider h;
    public int i;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavGraphBuilder(@org.jetbrains.annotations.NotNull androidx.navigation.NavigatorProvider r3, @androidx.annotation.IdRes int r4, @androidx.annotation.IdRes int r5) {
        /*
            r2 = this;
            java.lang.String r0 = "provider"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.Class<androidx.navigation.NavGraphNavigator> r0 = androidx.navigation.NavGraphNavigator.class
            androidx.navigation.Navigator r0 = r3.getNavigator(r0)
            java.lang.String r1 = "getNavigator(clazz.java)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r2.<init>(r0, r4)
            r2.h = r3
            r2.i = r5
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.g = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavGraphBuilder.<init>(androidx.navigation.NavigatorProvider, int, int):void");
    }

    public final void addDestination(@NotNull NavDestination navDestination) {
        Intrinsics.checkParameterIsNotNull(navDestination, "destination");
        this.g.add(navDestination);
    }

    public final <D extends NavDestination> void destination(@NotNull NavDestinationBuilder<? extends D> navDestinationBuilder) {
        Intrinsics.checkParameterIsNotNull(navDestinationBuilder, "navDestination");
        this.g.add(navDestinationBuilder.build());
    }

    @NotNull
    public final NavigatorProvider getProvider() {
        return this.h;
    }

    public final void unaryPlus(@NotNull NavDestination navDestination) {
        Intrinsics.checkParameterIsNotNull(navDestination, "$this$unaryPlus");
        addDestination(navDestination);
    }

    @Override // androidx.navigation.NavDestinationBuilder
    @NotNull
    public NavGraph build() {
        NavGraph navGraph = (NavGraph) super.build();
        navGraph.addDestinations(this.g);
        int i2 = this.i;
        if (i2 != 0) {
            navGraph.setStartDestination(i2);
            return navGraph;
        }
        throw new IllegalStateException("You must set a startDestination");
    }
}
