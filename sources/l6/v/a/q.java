package l6.v.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import l6.v.a.b;
public class q implements b.AbstractC0538b {
    public final /* synthetic */ RecyclerView a;

    public q(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public View a(int i) {
        return this.a.getChildAt(i);
    }

    public int b() {
        return this.a.getChildCount();
    }

    public void c(int i) {
        View childAt = this.a.getChildAt(i);
        if (childAt != null) {
            this.a.m(childAt);
            childAt.clearAnimation();
        }
        this.a.removeViewAt(i);
    }
}
