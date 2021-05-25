package com.yarolegovich.discretescrollview;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager;
import java.util.Locale;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
public class InfiniteScrollAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> implements DiscreteScrollLayoutManager.InitialPositionProvider {
    public RecyclerView.Adapter<T> c;
    public DiscreteScrollLayoutManager d;

    public class b extends RecyclerView.AdapterDataObserver {
        public b(a aVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            InfiniteScrollAdapter infiniteScrollAdapter = InfiniteScrollAdapter.this;
            int initialPosition = infiniteScrollAdapter.getInitialPosition();
            DiscreteScrollLayoutManager discreteScrollLayoutManager = infiniteScrollAdapter.d;
            if (discreteScrollLayoutManager.C != initialPosition) {
                discreteScrollLayoutManager.C = initialPosition;
                discreteScrollLayoutManager.S.requestLayout();
            }
            InfiniteScrollAdapter.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            InfiniteScrollAdapter infiniteScrollAdapter = InfiniteScrollAdapter.this;
            infiniteScrollAdapter.notifyItemRangeChanged(0, infiniteScrollAdapter.getItemCount());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            InfiniteScrollAdapter infiniteScrollAdapter = InfiniteScrollAdapter.this;
            infiniteScrollAdapter.notifyItemRangeChanged(0, infiniteScrollAdapter.getItemCount(), obj);
        }
    }

    public InfiniteScrollAdapter(@NonNull RecyclerView.Adapter<T> adapter) {
        this.c = adapter;
        adapter.registerAdapterDataObserver(new b(null));
    }

    public static <T extends RecyclerView.ViewHolder> InfiniteScrollAdapter<T> wrap(@NonNull RecyclerView.Adapter<T> adapter) {
        return new InfiniteScrollAdapter<>(adapter);
    }

    public final boolean a() {
        return this.c.getItemCount() > 1;
    }

    public final int b(int i) {
        if (i >= 1073741823) {
            return (i - LockFreeTaskQueueCore.MAX_CAPACITY_MASK) % this.c.getItemCount();
        }
        int itemCount = (LockFreeTaskQueueCore.MAX_CAPACITY_MASK - i) % this.c.getItemCount();
        if (itemCount == 0) {
            return 0;
        }
        return this.c.getItemCount() - itemCount;
    }

    public int getClosestPosition(int i) {
        int i2;
        if (i < this.c.getItemCount()) {
            int i3 = this.d.C;
            int b2 = b(i3);
            if (i == b2) {
                return i3;
            }
            int i4 = i - b2;
            int i5 = i3 + i4;
            if (i > b2) {
                i2 = i4 - this.c.getItemCount();
            } else {
                i2 = i4 + this.c.getItemCount();
            }
            int i6 = i2 + i3;
            int abs = Math.abs(i3 - i5);
            int abs2 = Math.abs(i3 - i6);
            return abs == abs2 ? i5 > i3 ? i5 : i6 : abs < abs2 ? i5 : i6;
        }
        throw new IndexOutOfBoundsException(String.format(Locale.US, "requested position is outside adapter's bounds: position=%d, size=%d", Integer.valueOf(i), Integer.valueOf(this.c.getItemCount())));
    }

    @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.InitialPositionProvider
    public int getInitialPosition() {
        if (a()) {
            return LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (a()) {
            return Integer.MAX_VALUE;
        }
        return this.c.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.c.getItemViewType(b(i));
    }

    public int getRealCurrentPosition() {
        return getRealPosition(this.d.C);
    }

    public int getRealItemCount() {
        return this.c.getItemCount();
    }

    public int getRealPosition(int i) {
        return b(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.c.onAttachedToRecyclerView(recyclerView);
        if (recyclerView instanceof DiscreteScrollView) {
            this.d = (DiscreteScrollLayoutManager) recyclerView.getLayoutManager();
            return;
        }
        throw new RuntimeException(recyclerView.getContext().getString(R.string.dsv_ex_msg_adapter_wrong_recycler));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull T t, int i) {
        if (a() && (i <= 100 || i >= 2147483547)) {
            int b2 = b(this.d.C) + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            DiscreteScrollLayoutManager discreteScrollLayoutManager = this.d;
            if (discreteScrollLayoutManager.C != b2) {
                discreteScrollLayoutManager.C = b2;
                discreteScrollLayoutManager.S.requestLayout();
                return;
            }
            return;
        }
        this.c.onBindViewHolder(t, b(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public T onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return this.c.onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.c.onDetachedFromRecyclerView(recyclerView);
        this.d = null;
    }
}
