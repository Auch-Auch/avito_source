package androidx.navigation;

import a2.b.a.a.a;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigator;
@Navigator.Name("navigation")
public class NavGraphNavigator extends Navigator<NavGraph> {
    public final NavigatorProvider a;

    public NavGraphNavigator(@NonNull NavigatorProvider navigatorProvider) {
        this.a = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    @Nullable
    public NavDestination navigate(@NonNull NavGraph navGraph, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        String str;
        int startDestination = navGraph.getStartDestination();
        if (startDestination == 0) {
            StringBuilder L = a.L("no start destination defined via app:startDestination for ");
            if (navGraph.getId() != 0) {
                if (navGraph.d == null) {
                    navGraph.d = Integer.toString(navGraph.c);
                }
                str = navGraph.d;
            } else {
                str = "the root navigation";
            }
            L.append(str);
            throw new IllegalStateException(L.toString());
        }
        NavDestination f = navGraph.f(startDestination, false);
        if (f != null) {
            return this.a.getNavigator(f.getNavigatorName()).navigate(f, f.a(bundle), navOptions, extras);
        }
        if (navGraph.l == null) {
            navGraph.l = Integer.toString(navGraph.k);
        }
        throw new IllegalArgumentException(a.e3("navigation destination ", navGraph.l, " is not a direct child of this NavGraph"));
    }
}
