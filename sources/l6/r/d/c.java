package l6.r.d;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.transition.TransitionManager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.ref.WeakReference;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class c extends a {
    public final WeakReference<CollapsingToolbarLayout> f;
    public final WeakReference<Toolbar> g;

    public c(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull AppBarConfiguration appBarConfiguration) {
        super(collapsingToolbarLayout.getContext(), appBarConfiguration);
        this.f = new WeakReference<>(collapsingToolbarLayout);
        this.g = new WeakReference<>(toolbar);
    }

    @Override // l6.r.d.a
    public void a(Drawable drawable, @StringRes int i) {
        Toolbar toolbar = this.g.get();
        if (toolbar != null) {
            boolean z = drawable == null && toolbar.getNavigationIcon() != null;
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(i);
            if (z) {
                TransitionManager.beginDelayedTransition(toolbar);
            }
        }
    }

    @Override // l6.r.d.a
    public void b(CharSequence charSequence) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.f.get();
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(charSequence);
        }
    }

    @Override // l6.r.d.a, androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.f.get();
        Toolbar toolbar = this.g.get();
        if (collapsingToolbarLayout == null || toolbar == null) {
            navController.removeOnDestinationChangedListener(this);
        } else {
            super.onDestinationChanged(navController, navDestination, bundle);
        }
    }
}
