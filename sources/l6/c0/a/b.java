package l6.c0.a;

import androidx.viewpager2.adapter.FragmentStateAdapter;
public class b implements Runnable {
    public final /* synthetic */ FragmentStateAdapter a;

    public b(FragmentStateAdapter fragmentStateAdapter) {
        this.a = fragmentStateAdapter;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentStateAdapter fragmentStateAdapter = this.a;
        fragmentStateAdapter.i = false;
        fragmentStateAdapter.b();
    }
}
