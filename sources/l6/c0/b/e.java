package l6.c0.b;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;
public final class e extends ViewPager2.OnPageChangeCallback {
    public final LinearLayoutManager a;
    public ViewPager2.PageTransformer b;

    public e(LinearLayoutManager linearLayoutManager) {
        this.a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        if (this.b != null) {
            float f2 = -f;
            for (int i3 = 0; i3 < this.a.getChildCount(); i3++) {
                View childAt = this.a.getChildAt(i3);
                if (childAt != null) {
                    this.b.transformPage(childAt, ((float) (this.a.getPosition(childAt) - i)) + f2);
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.a.getChildCount())));
                }
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
    }
}
