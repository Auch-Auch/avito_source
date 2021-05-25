package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.AsyncPagedListDiffer;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
public abstract class PagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public final AsyncPagedListDiffer<T> c;
    public final AsyncPagedListDiffer.c<T> d;

    public class a implements AsyncPagedListDiffer.c<T> {
        public a() {
        }
    }

    public PagedListAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        a aVar = new a();
        this.d = aVar;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>(this, itemCallback);
        this.c = asyncPagedListDiffer;
        asyncPagedListDiffer.d = aVar;
    }

    @Nullable
    public PagedList<T> getCurrentList() {
        return this.c.getCurrentList();
    }

    @Nullable
    public T getItem(int i) {
        return this.c.getItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.getItemCount();
    }

    public void onCurrentListChanged(@Nullable PagedList<T> pagedList) {
    }

    public void submitList(PagedList<T> pagedList) {
        this.c.submitList(pagedList);
    }

    public PagedListAdapter(@NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        a aVar = new a();
        this.d = aVar;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.c = asyncPagedListDiffer;
        asyncPagedListDiffer.d = aVar;
    }
}
