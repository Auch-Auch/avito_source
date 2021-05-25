package a2.j.b.d.a;

import android.view.View;
import androidx.core.view.ViewCompat;
public class i {
    public final View a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f = true;
    public boolean g = true;

    public i(View view) {
        this.a = view;
    }

    public void a() {
        View view = this.a;
        ViewCompat.offsetTopAndBottom(view, this.d - (view.getTop() - this.b));
        View view2 = this.a;
        ViewCompat.offsetLeftAndRight(view2, this.e - (view2.getLeft() - this.c));
    }

    public boolean b(int i) {
        if (!this.f || this.d == i) {
            return false;
        }
        this.d = i;
        a();
        return true;
    }
}
