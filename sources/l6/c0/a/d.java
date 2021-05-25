package l6.c0.a;

import androidx.viewpager2.adapter.FragmentStateAdapter;
public class d extends FragmentStateAdapter.b {
    public final /* synthetic */ FragmentStateAdapter.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(FragmentStateAdapter.c cVar) {
        super(null);
        this.a = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        this.a.b(true);
    }
}
