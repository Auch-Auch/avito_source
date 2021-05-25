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
import java.lang.ref.WeakReference;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class d extends a {
    public final WeakReference<Toolbar> f;

    public d(@NonNull Toolbar toolbar, @NonNull AppBarConfiguration appBarConfiguration) {
        super(toolbar.getContext(), appBarConfiguration);
        this.f = new WeakReference<>(toolbar);
    }

    @Override // l6.r.d.a
    public void a(Drawable drawable, @StringRes int i) {
        Toolbar toolbar = this.f.get();
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
        this.f.get().setTitle(charSequence);
    }

    @Override // l6.r.d.a, androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
        if (this.f.get() == null) {
            navController.removeOnDestinationChangedListener(this);
        } else {
            super.onDestinationChanged(navController, navDestination, bundle);
        }
    }
}
