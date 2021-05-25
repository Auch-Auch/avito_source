package a2.j.b.d.e;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.ViewUtils;
public class a implements ViewUtils.OnApplyWindowInsetsListener {
    public a(BottomNavigationView bottomNavigationView) {
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    @NonNull
    public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
        relativePadding.bottom = windowInsetsCompat.getSystemWindowInsetBottom() + relativePadding.bottom;
        boolean z = true;
        if (ViewCompat.getLayoutDirection(view) != 1) {
            z = false;
        }
        int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
        int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
        relativePadding.start += z ? systemWindowInsetRight : systemWindowInsetLeft;
        int i = relativePadding.end;
        if (!z) {
            systemWindowInsetLeft = systemWindowInsetRight;
        }
        relativePadding.end = i + systemWindowInsetLeft;
        relativePadding.applyToView(view);
        return windowInsetsCompat;
    }
}
