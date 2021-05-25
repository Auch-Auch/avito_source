package v6.b.a;

import android.view.View;
import androidx.core.view.ViewCompat;
public class j {
    public final View a;
    public int b;
    public int c;
    public int d;

    public j(View view) {
        this.a = view;
    }

    public final void a() {
        View view = this.a;
        ViewCompat.offsetTopAndBottom(view, this.d - (view.getTop() - this.b));
        View view2 = this.a;
        ViewCompat.offsetLeftAndRight(view2, 0 - (view2.getLeft() - this.c));
    }
}
