package q6.a.a;

import eu.davidea.flexibleadapter.SelectableAdapter;
public class b implements Runnable {
    public final /* synthetic */ SelectableAdapter a;

    public b(SelectableAdapter selectableAdapter) {
        this.a = selectableAdapter;
    }

    @Override // java.lang.Runnable
    public void run() {
        SelectableAdapter selectableAdapter = this.a;
        selectableAdapter.mSelectAll = false;
        selectableAdapter.mLastItemInActionMode = false;
    }
}
