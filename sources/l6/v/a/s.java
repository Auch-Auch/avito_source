package l6.v.a;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;
public class s {
    @VisibleForTesting
    public final SimpleArrayMap<RecyclerView.ViewHolder, a> a = new SimpleArrayMap<>();
    @VisibleForTesting
    public final LongSparseArray<RecyclerView.ViewHolder> b = new LongSparseArray<>();

    public static class a {
        public static Pools.Pool<a> d = new Pools.SimplePool(20);
        public int a;
        @Nullable
        public RecyclerView.ItemAnimator.ItemHolderInfo b;
        @Nullable
        public RecyclerView.ItemAnimator.ItemHolderInfo c;

        public static a a() {
            a acquire = d.acquire();
            return acquire == null ? new a() : acquire;
        }

        public static void b(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.release(aVar);
        }
    }

    public interface b {
    }

    public void a(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.a.get(viewHolder);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(viewHolder, aVar);
        }
        aVar.a |= 1;
    }

    public void b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = this.a.get(viewHolder);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(viewHolder, aVar);
        }
        aVar.c = itemHolderInfo;
        aVar.a |= 8;
    }

    public void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = this.a.get(viewHolder);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(viewHolder, aVar);
        }
        aVar.b = itemHolderInfo;
        aVar.a |= 4;
    }

    public boolean d(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.a.get(viewHolder);
        if (aVar == null || (aVar.a & 1) == 0) {
            return false;
        }
        return true;
    }

    public final RecyclerView.ItemAnimator.ItemHolderInfo e(RecyclerView.ViewHolder viewHolder, int i) {
        a valueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int indexOfKey = this.a.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (valueAt = this.a.valueAt(indexOfKey)) != null) {
            int i2 = valueAt.a;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                valueAt.a = i3;
                if (i == 4) {
                    itemHolderInfo = valueAt.b;
                } else if (i == 8) {
                    itemHolderInfo = valueAt.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    this.a.removeAt(indexOfKey);
                    a.b(valueAt);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    public void f(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.a.get(viewHolder);
        if (aVar != null) {
            aVar.a &= -2;
        }
    }

    public void g(RecyclerView.ViewHolder viewHolder) {
        int size = this.b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (viewHolder == this.b.valueAt(size)) {
                this.b.removeAt(size);
                break;
            } else {
                size--;
            }
        }
        a remove = this.a.remove(viewHolder);
        if (remove != null) {
            a.b(remove);
        }
    }
}
