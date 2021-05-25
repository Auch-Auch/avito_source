package l6.j.a;

import android.graphics.Rect;
import androidx.customview.widget.FocusStrategy$BoundsAdapter;
import java.util.Comparator;
public class a<T> implements Comparator<T> {
    public final Rect a = new Rect();
    public final Rect b = new Rect();
    public final boolean c;
    public final FocusStrategy$BoundsAdapter<T> d;

    public a(boolean z, FocusStrategy$BoundsAdapter<T> focusStrategy$BoundsAdapter) {
        this.c = z;
        this.d = focusStrategy$BoundsAdapter;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        Rect rect = this.a;
        Rect rect2 = this.b;
        this.d.obtainBounds(t, rect);
        this.d.obtainBounds(t2, rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        if (i3 < i4) {
            if (this.c) {
                return 1;
            }
            return -1;
        } else if (i3 <= i4) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
            int i7 = rect.right;
            int i8 = rect2.right;
            if (i7 < i8) {
                if (this.c) {
                    return 1;
                }
                return -1;
            } else if (i7 <= i8) {
                return 0;
            } else {
                if (this.c) {
                    return -1;
                }
                return 1;
            }
        } else if (this.c) {
            return -1;
        } else {
            return 1;
        }
    }
}
