package l6.s;

import androidx.recyclerview.widget.ListUpdateCallback;
public class h implements ListUpdateCallback {
    public final int a;
    public final ListUpdateCallback b;

    public h(int i, ListUpdateCallback listUpdateCallback) {
        this.a = i;
        this.b = listUpdateCallback;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        this.b.onChanged(i + this.a, i2, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.b.onInserted(i + this.a, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        ListUpdateCallback listUpdateCallback = this.b;
        int i3 = this.a;
        listUpdateCallback.onMoved(i + i3, i2 + i3);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.b.onRemoved(i + this.a, i2);
    }
}
