package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.ui.AppBarConfiguration;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.Set;
public final class NavigationUI {

    public static class a implements View.OnClickListener {
        public final /* synthetic */ NavController a;
        public final /* synthetic */ AppBarConfiguration b;

        public a(NavController navController, AppBarConfiguration appBarConfiguration) {
            this.a = navController;
            this.b = appBarConfiguration;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NavigationUI.navigateUp(this.a, this.b);
        }
    }

    public static class b implements View.OnClickListener {
        public final /* synthetic */ NavController a;
        public final /* synthetic */ AppBarConfiguration b;

        public b(NavController navController, AppBarConfiguration appBarConfiguration) {
            this.a = navController;
            this.b = appBarConfiguration;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NavigationUI.navigateUp(this.a, this.b);
        }
    }

    public static class c implements NavigationView.OnNavigationItemSelectedListener {
        public final /* synthetic */ NavController a;
        public final /* synthetic */ NavigationView b;

        public c(NavController navController, NavigationView navigationView) {
            this.a = navController;
            this.b = navigationView;
        }

        @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            boolean onNavDestinationSelected = NavigationUI.onNavDestinationSelected(menuItem, this.a);
            if (onNavDestinationSelected) {
                ViewParent parent = this.b.getParent();
                if (parent instanceof DrawerLayout) {
                    ((DrawerLayout) parent).closeDrawer(this.b);
                } else {
                    BottomSheetBehavior a3 = NavigationUI.a(this.b);
                    if (a3 != null) {
                        a3.setState(5);
                    }
                }
            }
            return onNavDestinationSelected;
        }
    }

    public static class d implements NavController.OnDestinationChangedListener {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ NavController b;

        public d(WeakReference weakReference, NavController navController) {
            this.a = weakReference;
            this.b = navController;
        }

        @Override // androidx.navigation.NavController.OnDestinationChangedListener
        public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
            NavigationView navigationView = (NavigationView) this.a.get();
            if (navigationView == null) {
                this.b.removeOnDestinationChangedListener(this);
                return;
            }
            Menu menu = navigationView.getMenu();
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menu.getItem(i);
                item.setChecked(NavigationUI.b(navDestination, item.getItemId()));
            }
        }
    }

    public static class e implements BottomNavigationView.OnNavigationItemSelectedListener {
        public final /* synthetic */ NavController a;

        public e(NavController navController) {
            this.a = navController;
        }

        @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            return NavigationUI.onNavDestinationSelected(menuItem, this.a);
        }
    }

    public static class f implements NavController.OnDestinationChangedListener {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ NavController b;

        public f(WeakReference weakReference, NavController navController) {
            this.a = weakReference;
            this.b = navController;
        }

        @Override // androidx.navigation.NavController.OnDestinationChangedListener
        public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
            BottomNavigationView bottomNavigationView = (BottomNavigationView) this.a.get();
            if (bottomNavigationView == null) {
                this.b.removeOnDestinationChangedListener(this);
                return;
            }
            Menu menu = bottomNavigationView.getMenu();
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menu.getItem(i);
                if (NavigationUI.b(navDestination, item.getItemId())) {
                    item.setChecked(true);
                }
            }
        }
    }

    public static BottomSheetBehavior a(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                return a((View) parent);
            }
            return null;
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (!(behavior instanceof BottomSheetBehavior)) {
            return null;
        }
        return (BottomSheetBehavior) behavior;
    }

    public static boolean b(@NonNull NavDestination navDestination, @IdRes int i) {
        while (navDestination.getId() != i && navDestination.getParent() != null) {
            navDestination = navDestination.getParent();
        }
        return navDestination.getId() == i;
    }

    public static boolean c(@NonNull NavDestination navDestination, @NonNull Set<Integer> set) {
        while (!set.contains(Integer.valueOf(navDestination.getId()))) {
            navDestination = navDestination.getParent();
            if (navDestination == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean navigateUp(@NonNull NavController navController, @Nullable DrawerLayout drawerLayout) {
        return navigateUp(navController, new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build());
    }

    public static boolean onNavDestinationSelected(@NonNull MenuItem menuItem, @NonNull NavController navController) {
        NavOptions.Builder popExitAnim = new NavOptions.Builder().setLaunchSingleTop(true).setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        if ((menuItem.getOrder() & 196608) == 0) {
            NavDestination graph = navController.getGraph();
            while (graph instanceof NavGraph) {
                NavGraph navGraph = (NavGraph) graph;
                graph = navGraph.findNode(navGraph.getStartDestination());
            }
            popExitAnim.setPopUpTo(graph.getId(), false);
        }
        try {
            navController.navigate(menuItem.getItemId(), (Bundle) null, popExitAnim.build());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static void setupActionBarWithNavController(@NonNull AppCompatActivity appCompatActivity, @NonNull NavController navController) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(@NonNull Toolbar toolbar, @NonNull NavController navController) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(@NonNull Toolbar toolbar, @NonNull NavController navController, @Nullable DrawerLayout drawerLayout) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build());
    }

    public static boolean navigateUp(@NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        DrawerLayout drawerLayout = appBarConfiguration.getDrawerLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        Set<Integer> topLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        if (drawerLayout != null && currentDestination != null && c(currentDestination, topLevelDestinations)) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        } else if (navController.navigateUp()) {
            return true;
        } else {
            if (appBarConfiguration.getFallbackOnNavigateUpListener() != null) {
                return appBarConfiguration.getFallbackOnNavigateUpListener().onNavigateUp();
            }
            return false;
        }
    }

    public static void setupActionBarWithNavController(@NonNull AppCompatActivity appCompatActivity, @NonNull NavController navController, @Nullable DrawerLayout drawerLayout) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build());
    }

    public static void setupWithNavController(@NonNull Toolbar toolbar, @NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new l6.r.d.d(toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new a(navController, appBarConfiguration));
    }

    public static void setupActionBarWithNavController(@NonNull AppCompatActivity appCompatActivity, @NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new l6.r.d.b(appCompatActivity, appBarConfiguration));
    }

    public static void setupWithNavController(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull NavController navController) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull NavController navController, @Nullable DrawerLayout drawerLayout) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build());
    }

    public static void setupWithNavController(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new l6.r.d.c(collapsingToolbarLayout, toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new b(navController, appBarConfiguration));
    }

    public static void setupWithNavController(@NonNull NavigationView navigationView, @NonNull NavController navController) {
        navigationView.setNavigationItemSelectedListener(new c(navController, navigationView));
        navController.addOnDestinationChangedListener(new d(new WeakReference(navigationView), navController));
    }

    public static void setupWithNavController(@NonNull BottomNavigationView bottomNavigationView, @NonNull NavController navController) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new e(navController));
        navController.addOnDestinationChangedListener(new f(new WeakReference(bottomNavigationView), navController));
    }
}
