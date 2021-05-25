package l6.v.a;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
public class j implements Runnable {
    public final /* synthetic */ ItemTouchHelper.e a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ItemTouchHelper c;

    public j(ItemTouchHelper itemTouchHelper, ItemTouchHelper.e eVar, int i) {
        this.c = itemTouchHelper;
        this.a = eVar;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.c.r;
        if (recyclerView != null && recyclerView.isAttachedToWindow()) {
            ItemTouchHelper.e eVar = this.a;
            if (!eVar.k && eVar.e.getAdapterPosition() != -1) {
                RecyclerView.ItemAnimator itemAnimator = this.c.r.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.isRunning(null)) {
                    ItemTouchHelper itemTouchHelper = this.c;
                    int size = itemTouchHelper.p.size();
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!itemTouchHelper.p.get(i).l) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!z) {
                        this.c.m.onSwiped(this.a.e, this.b);
                        return;
                    }
                }
                this.c.r.post(this);
            }
        }
    }
}
