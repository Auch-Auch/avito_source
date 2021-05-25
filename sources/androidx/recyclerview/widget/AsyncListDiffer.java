package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
public class AsyncListDiffer<T> {
    public static final Executor h = new b();
    public final ListUpdateCallback a;
    public final AsyncDifferConfig<T> b;
    public Executor c;
    public final List<ListListener<T>> d;
    @Nullable
    public List<T> e;
    @NonNull
    public List<T> f;
    public int g;

    public interface ListListener<T> {
        void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2);
    }

    public class a implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Runnable d;

        /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$a$a  reason: collision with other inner class name */
        public class C0121a extends DiffUtil.Callback {
            public C0121a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                Object obj = a.this.a.get(i);
                Object obj2 = a.this.b.get(i2);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.b.getDiffCallback().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                Object obj = a.this.a.get(i);
                Object obj2 = a.this.b.get(i2);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                return AsyncListDiffer.this.b.getDiffCallback().areItemsTheSame(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            @Nullable
            public Object getChangePayload(int i, int i2) {
                Object obj = a.this.a.get(i);
                Object obj2 = a.this.b.get(i2);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.b.getDiffCallback().getChangePayload(obj, obj2);
                }
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return a.this.b.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return a.this.a.size();
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ DiffUtil.DiffResult a;

            public b(DiffUtil.DiffResult diffResult) {
                this.a = diffResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                if (asyncListDiffer.g == aVar.c) {
                    List<T> list = aVar.b;
                    DiffUtil.DiffResult diffResult = this.a;
                    Runnable runnable = aVar.d;
                    List<T> list2 = asyncListDiffer.f;
                    asyncListDiffer.e = list;
                    asyncListDiffer.f = Collections.unmodifiableList(list);
                    diffResult.dispatchUpdatesTo(asyncListDiffer.a);
                    asyncListDiffer.a(list2, runnable);
                }
            }
        }

        public a(List list, List list2, int i, Runnable runnable) {
            this.a = list;
            this.b = list2;
            this.c = i;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncListDiffer.this.c.execute(new b(DiffUtil.calculateDiff(new C0121a())));
        }
    }

    public static class b implements Executor {
        public final Handler a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.a.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    public final void a(@NonNull List<T> list, @Nullable Runnable runnable) {
        for (ListListener<T> listListener : this.d) {
            listListener.onCurrentListChanged(list, this.f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addListListener(@NonNull ListListener<T> listListener) {
        this.d.add(listListener);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.f;
    }

    public void removeListListener(@NonNull ListListener<T> listListener) {
        this.d.remove(listListener);
    }

    public void submitList(@Nullable List<T> list) {
        submitList(list, null);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        int i = this.g + 1;
        this.g = i;
        List<T> list2 = this.e;
        if (list != list2) {
            List<T> list3 = this.f;
            if (list == null) {
                int size = list2.size();
                this.e = null;
                this.f = Collections.emptyList();
                this.a.onRemoved(0, size);
                a(list3, runnable);
            } else if (list2 == null) {
                this.e = list;
                this.f = Collections.unmodifiableList(list);
                this.a.onInserted(0, list.size());
                a(list3, runnable);
            } else {
                this.b.getBackgroundThreadExecutor().execute(new a(list2, list, i, runnable));
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.d = new CopyOnWriteArrayList();
        this.f = Collections.emptyList();
        this.a = listUpdateCallback;
        this.b = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.c = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.c = h;
        }
    }
}
