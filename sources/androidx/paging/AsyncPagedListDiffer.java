package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.Executor;
import l6.s.f;
import l6.s.g;
import l6.s.h;
public class AsyncPagedListDiffer<T> {
    public final ListUpdateCallback a;
    public final AsyncDifferConfig<T> b;
    public Executor c = ArchTaskExecutor.getMainThreadExecutor();
    @Nullable
    public c<T> d;
    public boolean e;
    public PagedList<T> f;
    public PagedList<T> g;
    public int h;
    public PagedList.Callback i = new a();

    public class a extends PagedList.Callback {
        public a() {
        }

        @Override // androidx.paging.PagedList.Callback
        public void onChanged(int i, int i2) {
            AsyncPagedListDiffer.this.a.onChanged(i, i2, null);
        }

        @Override // androidx.paging.PagedList.Callback
        public void onInserted(int i, int i2) {
            AsyncPagedListDiffer.this.a.onInserted(i, i2);
        }

        @Override // androidx.paging.PagedList.Callback
        public void onRemoved(int i, int i2) {
            AsyncPagedListDiffer.this.a.onRemoved(i, i2);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ PagedList a;
        public final /* synthetic */ PagedList b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PagedList d;

        public class a implements Runnable {
            public final /* synthetic */ DiffUtil.DiffResult a;

            public a(DiffUtil.DiffResult diffResult) {
                this.a = diffResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int convertOldPositionToNew;
                b bVar = b.this;
                AsyncPagedListDiffer asyncPagedListDiffer = AsyncPagedListDiffer.this;
                if (asyncPagedListDiffer.h == bVar.c) {
                    PagedList<T> pagedList = bVar.d;
                    PagedList pagedList2 = bVar.b;
                    DiffUtil.DiffResult diffResult = this.a;
                    int i2 = bVar.a.f;
                    PagedList<T> pagedList3 = asyncPagedListDiffer.g;
                    if (pagedList3 == null || asyncPagedListDiffer.f != null) {
                        throw new IllegalStateException("must be in snapshot state to apply diff");
                    }
                    asyncPagedListDiffer.f = pagedList;
                    asyncPagedListDiffer.g = null;
                    ListUpdateCallback listUpdateCallback = asyncPagedListDiffer.a;
                    f<T> fVar = pagedList3.e;
                    f<T> fVar2 = pagedList.e;
                    int c = fVar.c();
                    int c2 = fVar2.c();
                    int b2 = fVar.b();
                    int b3 = fVar2.b();
                    if (c == 0 && c2 == 0 && b2 == 0 && b3 == 0) {
                        diffResult.dispatchUpdatesTo(listUpdateCallback);
                    } else {
                        if (c > c2) {
                            int i3 = c - c2;
                            listUpdateCallback.onRemoved(fVar.size() - i3, i3);
                        } else if (c < c2) {
                            listUpdateCallback.onInserted(fVar.size(), c2 - c);
                        }
                        if (b2 > b3) {
                            listUpdateCallback.onRemoved(0, b2 - b3);
                        } else if (b2 < b3) {
                            listUpdateCallback.onInserted(0, b3 - b2);
                        }
                        if (b3 != 0) {
                            diffResult.dispatchUpdatesTo(new h(b3, listUpdateCallback));
                        } else {
                            diffResult.dispatchUpdatesTo(listUpdateCallback);
                        }
                    }
                    pagedList.addWeakCallback(pagedList2, asyncPagedListDiffer.i);
                    f<T> fVar3 = pagedList3.e;
                    f<T> fVar4 = pagedList2.e;
                    int b4 = fVar3.b();
                    int i4 = i2 - b4;
                    int size = (fVar3.size() - b4) - fVar3.c();
                    if (i4 >= 0 && i4 < size) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= 30) {
                                break;
                            }
                            int i6 = ((i5 / 2) * (i5 % 2 == 1 ? -1 : 1)) + i4;
                            if (i6 >= 0 && i6 < fVar3.e && (convertOldPositionToNew = diffResult.convertOldPositionToNew(i6)) != -1) {
                                i = convertOldPositionToNew + fVar4.a;
                                break;
                            }
                            i5++;
                        }
                    }
                    i = Math.max(0, Math.min(i2, fVar4.size() - 1));
                    PagedList<T> pagedList4 = asyncPagedListDiffer.f;
                    pagedList4.f = Math.max(0, Math.min(pagedList4.size(), i));
                    c<T> cVar = asyncPagedListDiffer.d;
                    if (cVar != null) {
                        PagedListAdapter.this.onCurrentListChanged(asyncPagedListDiffer.f);
                    }
                }
            }
        }

        public b(PagedList pagedList, PagedList pagedList2, int i, PagedList pagedList3) {
            this.a = pagedList;
            this.b = pagedList2;
            this.c = i;
            this.d = pagedList3;
        }

        @Override // java.lang.Runnable
        public void run() {
            f<T> fVar = this.a.e;
            f<T> fVar2 = this.b.e;
            DiffUtil.ItemCallback<T> diffCallback = AsyncPagedListDiffer.this.b.getDiffCallback();
            int b2 = fVar.b();
            AsyncPagedListDiffer.this.c.execute(new a(DiffUtil.calculateDiff(new g(fVar, b2, fVar2, diffCallback, (fVar.size() - b2) - fVar.c(), (fVar2.size() - fVar2.b()) - fVar2.c()), true)));
        }
    }

    public interface c<T> {
    }

    public AsyncPagedListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this.a = new AdapterListUpdateCallback(adapter);
        this.b = new AsyncDifferConfig.Builder(itemCallback).build();
    }

    @Nullable
    public PagedList<T> getCurrentList() {
        PagedList<T> pagedList = this.g;
        if (pagedList != null) {
            return pagedList;
        }
        return this.f;
    }

    @Nullable
    public T getItem(int i2) {
        PagedList<T> pagedList = this.f;
        if (pagedList == null) {
            PagedList<T> pagedList2 = this.g;
            if (pagedList2 != null) {
                return pagedList2.get(i2);
            }
            throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
        }
        pagedList.loadAround(i2);
        return this.f.get(i2);
    }

    public int getItemCount() {
        PagedList<T> pagedList = this.f;
        if (pagedList != null) {
            return pagedList.size();
        }
        PagedList<T> pagedList2 = this.g;
        if (pagedList2 == null) {
            return 0;
        }
        return pagedList2.size();
    }

    public void submitList(PagedList<T> pagedList) {
        if (pagedList != null) {
            if (this.f == null && this.g == null) {
                this.e = pagedList.d();
            } else if (pagedList.d() != this.e) {
                throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
            }
        }
        int i2 = this.h + 1;
        this.h = i2;
        PagedList<T> pagedList2 = this.f;
        if (pagedList != pagedList2) {
            if (pagedList == null) {
                int itemCount = getItemCount();
                PagedList<T> pagedList3 = this.f;
                if (pagedList3 != null) {
                    pagedList3.removeWeakCallback(this.i);
                    this.f = null;
                } else if (this.g != null) {
                    this.g = null;
                }
                this.a.onRemoved(0, itemCount);
                c<T> cVar = this.d;
                if (cVar != null) {
                    PagedListAdapter.this.onCurrentListChanged(null);
                }
            } else if (pagedList2 == null && this.g == null) {
                this.f = pagedList;
                pagedList.addWeakCallback(null, this.i);
                this.a.onInserted(0, pagedList.size());
                c<T> cVar2 = this.d;
                if (cVar2 != null) {
                    PagedListAdapter.this.onCurrentListChanged(pagedList);
                }
            } else {
                if (pagedList2 != null) {
                    pagedList2.removeWeakCallback(this.i);
                    this.g = (PagedList) this.f.snapshot();
                    this.f = null;
                }
                PagedList<T> pagedList4 = this.g;
                if (pagedList4 == null || this.f != null) {
                    throw new IllegalStateException("must be in snapshot state to diff");
                }
                this.b.getBackgroundThreadExecutor().execute(new b(pagedList4, (PagedList) pagedList.snapshot(), i2, pagedList));
            }
        }
    }

    public AsyncPagedListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.a = listUpdateCallback;
        this.b = asyncDifferConfig;
    }
}
