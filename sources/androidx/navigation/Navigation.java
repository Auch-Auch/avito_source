package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;
public final class Navigation {

    public static class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Bundle b;

        public a(int i, Bundle bundle) {
            this.a = i;
            this.b = bundle;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(this.a, this.b);
        }
    }

    public static class b implements View.OnClickListener {
        public final /* synthetic */ NavDirections a;

        public b(NavDirections navDirections) {
            this.a = navDirections;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(this.a);
        }
    }

    @Nullable
    public static NavController a(@NonNull View view) {
        NavController navController;
        while (view != null) {
            Object tag = view.getTag(R.id.nav_controller_view_tag);
            if (tag instanceof WeakReference) {
                navController = (NavController) ((WeakReference) tag).get();
            } else {
                navController = tag instanceof NavController ? (NavController) tag : null;
            }
            if (navController != null) {
                return navController;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@IdRes int i) {
        return createNavigateOnClickListener(i, null);
    }

    @NonNull
    public static NavController findNavController(@NonNull Activity activity, @IdRes int i) {
        NavController a3 = a(ActivityCompat.requireViewById(activity, i));
        if (a3 != null) {
            return a3;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i);
    }

    public static void setViewNavController(@NonNull View view, @Nullable NavController navController) {
        view.setTag(R.id.nav_controller_view_tag, navController);
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@IdRes int i, @Nullable Bundle bundle) {
        return new a(i, bundle);
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@NonNull NavDirections navDirections) {
        return new b(navDirections);
    }

    @NonNull
    public static NavController findNavController(@NonNull View view) {
        NavController a3 = a(view);
        if (a3 != null) {
            return a3;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }
}
