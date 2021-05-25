package a2.j.b.d.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
public class h<V extends View> extends CoordinatorLayout.Behavior<V> {
    public i a;
    public int b = 0;
    public int c = 0;

    public h() {
    }

    public int getLeftAndRightOffset() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.e;
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.d;
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        i iVar = this.a;
        return iVar != null && iVar.g;
    }

    public boolean isVerticalOffsetEnabled() {
        i iVar = this.a;
        return iVar != null && iVar.f;
    }

    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        layoutChild(coordinatorLayout, v, i);
        if (this.a == null) {
            this.a = new i(v);
        }
        i iVar = this.a;
        iVar.b = iVar.a.getTop();
        iVar.c = iVar.a.getLeft();
        this.a.a();
        int i2 = this.b;
        if (i2 != 0) {
            this.a.b(i2);
            this.b = 0;
        }
        int i3 = this.c;
        if (i3 == 0) {
            return true;
        }
        i iVar2 = this.a;
        if (iVar2.g && iVar2.e != i3) {
            iVar2.e = i3;
            iVar2.a();
        }
        this.c = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        i iVar = this.a;
        if (iVar != null) {
            iVar.g = z;
        }
    }

    public boolean setLeftAndRightOffset(int i) {
        i iVar = this.a;
        if (iVar == null) {
            this.c = i;
            return false;
        } else if (!iVar.g || iVar.e == i) {
            return false;
        } else {
            iVar.e = i;
            iVar.a();
            return true;
        }
    }

    public boolean setTopAndBottomOffset(int i) {
        i iVar = this.a;
        if (iVar != null) {
            return iVar.b(i);
        }
        this.b = i;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        i iVar = this.a;
        if (iVar != null) {
            iVar.f = z;
        }
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
