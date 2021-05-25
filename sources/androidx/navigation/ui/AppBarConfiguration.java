package androidx.navigation.ui;

import android.annotation.SuppressLint;
import android.view.Menu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavGraph;
import java.util.HashSet;
import java.util.Set;
public final class AppBarConfiguration {
    @NonNull
    public final Set<Integer> a;
    @Nullable
    public final DrawerLayout b;
    @Nullable
    public final OnNavigateUpListener c;

    public interface OnNavigateUpListener {
        boolean onNavigateUp();
    }

    public AppBarConfiguration(Set set, DrawerLayout drawerLayout, OnNavigateUpListener onNavigateUpListener, a aVar) {
        this.a = set;
        this.b = drawerLayout;
        this.c = onNavigateUpListener;
    }

    @Nullable
    public DrawerLayout getDrawerLayout() {
        return this.b;
    }

    @Nullable
    public OnNavigateUpListener getFallbackOnNavigateUpListener() {
        return this.c;
    }

    @NonNull
    public Set<Integer> getTopLevelDestinations() {
        return this.a;
    }

    public static final class Builder {
        @NonNull
        public final Set<Integer> a;
        @Nullable
        public DrawerLayout b;
        @Nullable
        public OnNavigateUpListener c;

        public Builder(@NonNull NavGraph navGraph) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            NavGraph navGraph2 = navGraph;
            while (navGraph2 instanceof NavGraph) {
                NavGraph navGraph3 = navGraph2;
                navGraph2 = navGraph3.findNode(navGraph3.getStartDestination());
            }
            hashSet.add(Integer.valueOf(navGraph2.getId()));
        }

        @NonNull
        @SuppressLint({"SyntheticAccessor"})
        public AppBarConfiguration build() {
            return new AppBarConfiguration(this.a, this.b, this.c, null);
        }

        @NonNull
        public Builder setDrawerLayout(@Nullable DrawerLayout drawerLayout) {
            this.b = drawerLayout;
            return this;
        }

        @NonNull
        public Builder setFallbackOnNavigateUpListener(@Nullable OnNavigateUpListener onNavigateUpListener) {
            this.c = onNavigateUpListener;
            return this;
        }

        public Builder(@NonNull Menu menu) {
            this.a = new HashSet();
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                this.a.add(Integer.valueOf(menu.getItem(i).getItemId()));
            }
        }

        public Builder(@NonNull int... iArr) {
            this.a = new HashSet();
            for (int i : iArr) {
                this.a.add(Integer.valueOf(i));
            }
        }

        public Builder(@NonNull Set<Integer> set) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            hashSet.addAll(set);
        }
    }
}
