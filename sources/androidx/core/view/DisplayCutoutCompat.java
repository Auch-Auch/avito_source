package androidx.core.view;

import a2.b.a.a.a;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.List;
public final class DisplayCutoutCompat {
    public final Object a;

    public DisplayCutoutCompat(Rect rect, List<Rect> list) {
        this.a = Build.VERSION.SDK_INT >= 28 ? new DisplayCutout(rect, list) : null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        DisplayCutoutCompat displayCutoutCompat = (DisplayCutoutCompat) obj;
        Object obj2 = this.a;
        if (obj2 != null) {
            return obj2.equals(displayCutoutCompat.a);
        }
        if (displayCutoutCompat.a == null) {
            return true;
        }
        return false;
    }

    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.a).getBoundingRects();
        }
        return null;
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.a).getSafeInsetBottom();
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.a).getSafeInsetLeft();
        }
        return 0;
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.a).getSafeInsetRight();
        }
        return 0;
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.a).getSafeInsetTop();
        }
        return 0;
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return a.r(a.L("DisplayCutoutCompat{"), this.a, "}");
    }

    public DisplayCutoutCompat(Object obj) {
        this.a = obj;
    }
}
