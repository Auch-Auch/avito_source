package l6.r.d;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.ui.R;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class a implements NavController.OnDestinationChangedListener {
    public final Context a;
    public final Set<Integer> b;
    @Nullable
    public final WeakReference<DrawerLayout> c;
    public DrawerArrowDrawable d;
    public ValueAnimator e;

    public a(@NonNull Context context, @NonNull AppBarConfiguration appBarConfiguration) {
        this.a = context;
        this.b = appBarConfiguration.getTopLevelDestinations();
        DrawerLayout drawerLayout = appBarConfiguration.getDrawerLayout();
        if (drawerLayout != null) {
            this.c = new WeakReference<>(drawerLayout);
        } else {
            this.c = null;
        }
    }

    public abstract void a(Drawable drawable, @StringRes int i);

    public abstract void b(CharSequence charSequence);

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
        boolean z;
        if (!(navDestination instanceof FloatingWindow)) {
            WeakReference<DrawerLayout> weakReference = this.c;
            DrawerLayout drawerLayout = weakReference != null ? weakReference.get() : null;
            if (this.c == null || drawerLayout != null) {
                CharSequence label = navDestination.getLabel();
                if (!TextUtils.isEmpty(label)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(label);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle == null || !bundle.containsKey(group)) {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill label " + ((Object) label));
                        }
                        matcher.appendReplacement(stringBuffer, "");
                        stringBuffer.append(bundle.get(group).toString());
                    }
                    matcher.appendTail(stringBuffer);
                    b(stringBuffer);
                }
                boolean c2 = NavigationUI.c(navDestination, this.b);
                if (drawerLayout != null || !c2) {
                    boolean z2 = drawerLayout != null && c2;
                    if (this.d == null) {
                        this.d = new DrawerArrowDrawable(this.a);
                        z = false;
                    } else {
                        z = true;
                    }
                    a(this.d, z2 ? R.string.nav_app_bar_open_drawer_description : R.string.nav_app_bar_navigate_up_description);
                    float f = z2 ? 0.0f : 1.0f;
                    if (z) {
                        float progress = this.d.getProgress();
                        ValueAnimator valueAnimator = this.e;
                        if (valueAnimator != null) {
                            valueAnimator.cancel();
                        }
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d, "progress", progress, f);
                        this.e = ofFloat;
                        ofFloat.start();
                        return;
                    }
                    this.d.setProgress(f);
                    return;
                }
                a(null, 0);
                return;
            }
            navController.removeOnDestinationChangedListener(this);
        }
    }
}
