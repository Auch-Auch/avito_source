package a2.j.b.d.f;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.ViewUtils;
public class b implements ViewUtils.OnApplyWindowInsetsListener {
    public final /* synthetic */ BottomSheetBehavior a;

    public b(BottomSheetBehavior bottomSheetBehavior) {
        this.a = bottomSheetBehavior;
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        this.a.k = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
        this.a.o(false);
        return windowInsetsCompat;
    }
}
