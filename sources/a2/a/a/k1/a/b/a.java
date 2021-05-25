package a2.a.a.k1.a.b;

import androidx.recyclerview.widget.RecyclerView;
public final class a implements Runnable {
    public final /* synthetic */ RecyclerView a;

    public a(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
