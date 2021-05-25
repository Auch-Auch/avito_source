package l6.c0.b;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
public final class c extends ViewPager2.OnPageChangeCallback {
    @NonNull
    public final List<ViewPager2.OnPageChangeCallback> a;

    public c(int i) {
        this.a = new ArrayList(i);
    }

    public final void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.a) {
                onPageChangeCallback.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, @Px int i2) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.a) {
                onPageChangeCallback.onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.a) {
                onPageChangeCallback.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
            throw null;
        }
    }
}
