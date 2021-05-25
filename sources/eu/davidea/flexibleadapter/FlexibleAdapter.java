package eu.davidea.flexibleadapter;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback;
import eu.davidea.flexibleadapter.helpers.StickyHeaderHelper;
import eu.davidea.flexibleadapter.items.IExpandable;
import eu.davidea.flexibleadapter.items.IFilterable;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.flexibleadapter.items.IHeader;
import eu.davidea.flexibleadapter.items.ISectionable;
import eu.davidea.flexibleadapter.utils.LayoutUtils;
import eu.davidea.flexibleadapter.utils.Logger;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
public class FlexibleAdapter<T extends IFlexible> extends AnimatorAdapter implements ItemTouchHelperCallback.AdapterCallback {
    public static final String p0;
    public static final String q0;
    public static final String r0;
    public static final String s0;
    public static final String t0;
    public static final String u0;
    public static int v0 = 1000;
    public long A;
    public long B;
    public List<FlexibleAdapter<T>.r> C;
    public List<Integer> D;
    public boolean E;
    public boolean F;
    public final int FILTER;
    public boolean G;
    public boolean H;
    public boolean I;
    public List<T> J;
    public List<T> K;
    public boolean L;
    public final int LOAD_MORE_COMPLETE;
    public boolean M;
    public int N;
    public StickyHeaderHelper O;
    public ViewGroup P;
    @SuppressLint({"UseSparseArrays"})
    public HashMap<Integer, T> Q;
    public boolean R;
    public String S;
    public String T;
    public Set<IExpandable> U;
    public final int UPDATE;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public int Z;
    public int a0;
    public boolean b0;
    public boolean c0;
    public boolean d0;
    public boolean e0;
    public boolean f0;
    public ItemTouchHelperCallback g0;
    public ItemTouchHelper h0;
    public int i0;
    public int j0;
    public int k0;
    public boolean l0;
    public boolean m0;
    public OnDeleteCompleteListener mDeleteCompleteListener;
    public EndlessScrollListener mEndlessScrollListener;
    public Handler mHandler;
    public LayoutInflater mInflater;
    public OnItemClickListener mItemClickListener;
    public OnItemLongClickListener mItemLongClickListener;
    public OnItemMoveListener mItemMoveListener;
    public OnItemSwipeListener mItemSwipeListener;
    public OnStickyHeaderChangeListener mStickyHeaderChangeListener;
    public OnUpdateListener mUpdateListener;
    public boolean n0;
    public T o0;
    public List<T> u;
    public List<T> v;
    public List<T> w;
    public Set<T> x;
    public List<q> y;
    public FlexibleAdapter<T>.p z;

    public interface EndlessScrollListener {
        void noMoreLoad(int i);

        void onLoadMore(int i, int i2);
    }

    public class HandlerCallback implements Handler.Callback {
        public HandlerCallback() {
        }

        @Override // android.os.Handler.Callback
        @CallSuper
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1 || i == 2) {
                FlexibleAdapter<T>.p pVar = FlexibleAdapter.this.z;
                if (pVar != null) {
                    pVar.cancel(true);
                }
                FlexibleAdapter.this.z = new p(message.what, (List) message.obj);
                FlexibleAdapter.this.z.execute(new Void[0]);
                return true;
            } else if (i != 8) {
                return false;
            } else {
                FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
                String str = FlexibleAdapter.p0;
                flexibleAdapter.r();
                return true;
            }
        }
    }

    public interface OnActionStateListener {
        void onActionStateChanged(RecyclerView.ViewHolder viewHolder, int i);
    }

    public interface OnDeleteCompleteListener {
        void onDeleteConfirmed(int i);
    }

    public interface OnItemClickListener {
        boolean onItemClick(int i);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(int i);
    }

    public interface OnItemMoveListener extends OnActionStateListener {
        void onItemMove(int i, int i2);

        boolean shouldMoveItem(int i, int i2);
    }

    public interface OnItemSwipeListener extends OnActionStateListener {
        void onItemSwipe(int i, int i2);
    }

    public interface OnStickyHeaderChangeListener {
        void onStickyHeaderChange(int i, int i2);
    }

    public interface OnUpdateListener {
        void onUpdateEmptyView(int i);
    }

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ IFlexible b;
        public final /* synthetic */ boolean c;

        public a(int i, IFlexible iFlexible, boolean z) {
            this.a = i;
            this.b = iFlexible;
            this.c = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (FlexibleAdapter.this.addItem(this.a, this.b) && this.c) {
                FlexibleAdapter.b(FlexibleAdapter.this, this.a);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ IFlexible a;
        public final /* synthetic */ boolean b;

        public b(IFlexible iFlexible, boolean z) {
            this.a = iFlexible;
            this.b = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
            IFlexible iFlexible = this.a;
            boolean z = this.b;
            String str = FlexibleAdapter.p0;
            flexibleAdapter.v(iFlexible, z);
        }
    }

    public class c implements Comparator<Integer> {
        public c(FlexibleAdapter flexibleAdapter) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }
    }

    public class d implements Comparator<Integer> {
        public d(FlexibleAdapter flexibleAdapter) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = FlexibleAdapter.this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.invalidateItemDecorations();
            }
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ IFlexible a;
        public final /* synthetic */ boolean b;

        public f(IFlexible iFlexible, boolean z) {
            this.a = iFlexible;
            this.b = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (FlexibleAdapter.this.addScrollableHeader(this.a) && this.b) {
                FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
                FlexibleAdapter.b(flexibleAdapter, flexibleAdapter.getGlobalPositionOf(this.a));
            }
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ IFlexible a;
        public final /* synthetic */ boolean b;

        public g(IFlexible iFlexible, boolean z) {
            this.a = iFlexible;
            this.b = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (FlexibleAdapter.this.addScrollableFooter(this.a) && this.b) {
                FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
                FlexibleAdapter.b(flexibleAdapter, flexibleAdapter.getGlobalPositionOf(this.a));
            }
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ IFlexible a;

        public h(IFlexible iFlexible) {
            this.a = iFlexible;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            FlexibleAdapter.this.removeScrollableHeader(this.a);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ IFlexible a;

        public i(IFlexible iFlexible) {
            this.a = iFlexible;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            FlexibleAdapter.this.removeScrollableFooter(this.a);
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ boolean a;

        public j(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
                if (flexibleAdapter.O == null) {
                    flexibleAdapter.O = new StickyHeaderHelper(flexibleAdapter, flexibleAdapter.mStickyHeaderChangeListener, flexibleAdapter.P);
                    FlexibleAdapter flexibleAdapter2 = FlexibleAdapter.this;
                    flexibleAdapter2.O.attachToRecyclerView(flexibleAdapter2.mRecyclerView);
                    FlexibleAdapter.this.c.i("Sticky headers enabled", new Object[0]);
                }
            } else if (FlexibleAdapter.this.areHeadersSticky()) {
                FlexibleAdapter.this.O.detachFromRecyclerView();
                FlexibleAdapter flexibleAdapter3 = FlexibleAdapter.this;
                flexibleAdapter3.O = null;
                flexibleAdapter3.c.i("Sticky headers disabled", new Object[0]);
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
            if (flexibleAdapter.L) {
                flexibleAdapter.c.w("Double call detected! Headers already shown OR the method showAllHeaders() was already called!", new Object[0]);
                return;
            }
            flexibleAdapter.B(false);
            FlexibleAdapter flexibleAdapter2 = FlexibleAdapter.this;
            if (flexibleAdapter2.mRecyclerView != null && flexibleAdapter2.getFlexibleLayoutManager().findFirstCompletelyVisibleItemPosition() == 0) {
                FlexibleAdapter flexibleAdapter3 = FlexibleAdapter.this;
                if (flexibleAdapter3.isHeader(flexibleAdapter3.getItem(0))) {
                    FlexibleAdapter flexibleAdapter4 = FlexibleAdapter.this;
                    if (!flexibleAdapter4.isHeader(flexibleAdapter4.getItem(1))) {
                        FlexibleAdapter.this.mRecyclerView.scrollToPosition(0);
                    }
                }
            }
        }
    }

    public class l implements Runnable {
        public l() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
            flexibleAdapter.F = true;
            for (int itemCount = (flexibleAdapter.getItemCount() - FlexibleAdapter.this.K.size()) - 1; itemCount >= Math.max(0, FlexibleAdapter.this.J.size() - 1); itemCount--) {
                IFlexible item = FlexibleAdapter.this.getItem(itemCount);
                if (FlexibleAdapter.this.isHeader(item)) {
                    FlexibleAdapter.this.q(itemCount, (IHeader) item);
                }
            }
            FlexibleAdapter flexibleAdapter2 = FlexibleAdapter.this;
            flexibleAdapter2.L = false;
            if (flexibleAdapter2.areHeadersSticky()) {
                FlexibleAdapter.this.O.clearHeaderWithAnimation();
            }
            FlexibleAdapter.this.F = false;
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlexibleAdapter.this.onLoadMore(0);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            FlexibleAdapter.this.mHandler.removeMessages(8);
            FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
            if (flexibleAdapter.n0) {
                z = flexibleAdapter.addScrollableHeader(flexibleAdapter.o0);
            } else {
                z = flexibleAdapter.addScrollableFooter(flexibleAdapter.o0);
            }
            if (z) {
                FlexibleAdapter flexibleAdapter2 = FlexibleAdapter.this;
                if (flexibleAdapter2.mEndlessScrollListener != null) {
                    flexibleAdapter2.c.d("onLoadMore     invoked!", new Object[0]);
                    FlexibleAdapter flexibleAdapter3 = FlexibleAdapter.this;
                    flexibleAdapter3.mEndlessScrollListener.onLoadMore(flexibleAdapter3.getMainItemCount(), FlexibleAdapter.this.getEndlessCurrentPage());
                    return;
                }
            }
            if (!z) {
                FlexibleAdapter.this.l0 = false;
            }
        }
    }

    public class o extends RecyclerView.AdapterDataObserver {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (FlexibleAdapter.this.areHeadersSticky()) {
                    FlexibleAdapter.this.O.updateOrClearHeader(true);
                }
            }
        }

        public o(f fVar) {
        }

        public final void a(int i) {
            int stickyPosition = FlexibleAdapter.this.getStickyPosition();
            if (stickyPosition >= 0 && stickyPosition == i) {
                FlexibleAdapter.this.c.d("updateStickyHeader position=%s", Integer.valueOf(stickyPosition));
                FlexibleAdapter.this.mRecyclerView.postDelayed(new a(), 50);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a(FlexibleAdapter.this.getStickyPosition());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            a(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
            if (flexibleAdapter.I) {
                flexibleAdapter.c(i, i2);
            }
            FlexibleAdapter.this.I = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            int i3 = -i2;
            FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
            if (flexibleAdapter.I) {
                flexibleAdapter.c(i, i3);
            }
            FlexibleAdapter.this.I = true;
        }
    }

    public class p extends AsyncTask<Void, Void, Void> {
        public final List<T> a;
        public final int b;

        public p(int i, @Nullable List<T> list) {
            ArrayList arrayList;
            this.b = i;
            if (list != null) {
                arrayList = new ArrayList(list);
            }
            this.a = arrayList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Multi-variable search result rejected for r9v6, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX DEBUG: Multi-variable search result rejected for r9v7, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX DEBUG: Multi-variable search result rejected for r9v12, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0088  */
        @Override // android.os.AsyncTask
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Void[] r9) {
            /*
                r8 = this;
                java.lang.Void[] r9 = (java.lang.Void[]) r9
                eu.davidea.flexibleadapter.FlexibleAdapter r9 = eu.davidea.flexibleadapter.FlexibleAdapter.this
                long r0 = java.lang.System.currentTimeMillis()
                r9.A = r0
                int r9 = r8.b
                r0 = 1
                r1 = 0
                r2 = 0
                if (r9 == r0) goto L_0x00a3
                r3 = 2
                if (r9 == r3) goto L_0x0016
                goto L_0x00c9
            L_0x0016:
                eu.davidea.flexibleadapter.FlexibleAdapter r9 = eu.davidea.flexibleadapter.FlexibleAdapter.this
                eu.davidea.flexibleadapter.utils.Logger r9 = r9.c
                java.lang.String r3 = "doInBackground - started FILTER"
                java.lang.Object[] r4 = new java.lang.Object[r1]
                r9.d(r3, r4)
                eu.davidea.flexibleadapter.FlexibleAdapter r9 = eu.davidea.flexibleadapter.FlexibleAdapter.this
                java.util.List<T> r3 = r8.a
                monitor-enter(r9)
                eu.davidea.flexibleadapter.utils.Logger r4 = r9.c     // Catch:{ all -> 0x00a0 }
                java.lang.String r5 = "filterItems with searchText=\"%s\""
                java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ all -> 0x00a0 }
                java.lang.String r7 = r9.S     // Catch:{ all -> 0x00a0 }
                r6[r1] = r7     // Catch:{ all -> 0x00a0 }
                r4.d(r5, r6)     // Catch:{ all -> 0x00a0 }
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00a0 }
                r4.<init>()     // Catch:{ all -> 0x00a0 }
                r9.W = r0     // Catch:{ all -> 0x00a0 }
                boolean r0 = r9.hasSearchText()     // Catch:{ all -> 0x00a0 }
                if (r0 == 0) goto L_0x0068
                java.lang.String r0 = r9.S     // Catch:{ all -> 0x00a0 }
                boolean r0 = r9.hasNewSearchText(r0)     // Catch:{ all -> 0x00a0 }
                if (r0 == 0) goto L_0x0068
                java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x00a0 }
            L_0x004c:
                boolean r3 = r0.hasNext()     // Catch:{ all -> 0x00a0 }
                if (r3 == 0) goto L_0x007f
                java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x00a0 }
                eu.davidea.flexibleadapter.items.IFlexible r3 = (eu.davidea.flexibleadapter.items.IFlexible) r3     // Catch:{ all -> 0x00a0 }
                eu.davidea.flexibleadapter.FlexibleAdapter<T>$p r5 = r9.z     // Catch:{ all -> 0x00a0 }
                if (r5 == 0) goto L_0x0064
                boolean r5 = r5.isCancelled()     // Catch:{ all -> 0x00a0 }
                if (r5 == 0) goto L_0x0064
                monitor-exit(r9)
                goto L_0x0094
            L_0x0064:
                r9.l(r3, r4)
                goto L_0x004c
            L_0x0068:
                java.lang.String r0 = r9.S
                boolean r0 = r9.hasNewSearchText(r0)
                if (r0 == 0) goto L_0x007f
                r9.y(r3)
                r9.U = r2
                java.util.List<T extends eu.davidea.flexibleadapter.items.IFlexible> r0 = r9.w
                if (r0 != 0) goto L_0x007c
                r9.z(r3)
            L_0x007c:
                r9.w = r2
                goto L_0x0080
            L_0x007f:
                r3 = r4
            L_0x0080:
                java.lang.String r0 = r9.S
                boolean r0 = r9.hasNewSearchText(r0)
                if (r0 == 0) goto L_0x0091
                java.lang.String r0 = r9.S
                r9.T = r0
                eu.davidea.flexibleadapter.Payload r0 = eu.davidea.flexibleadapter.Payload.FILTER
                r9.d(r3, r0)
            L_0x0091:
                r9.W = r1
                monitor-exit(r9)
            L_0x0094:
                eu.davidea.flexibleadapter.FlexibleAdapter r9 = eu.davidea.flexibleadapter.FlexibleAdapter.this
                eu.davidea.flexibleadapter.utils.Logger r9 = r9.c
                java.lang.String r0 = "doInBackground - ended FILTER"
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r9.d(r0, r1)
                goto L_0x00c9
            L_0x00a0:
                r0 = move-exception
                monitor-exit(r9)
                throw r0
            L_0x00a3:
                eu.davidea.flexibleadapter.FlexibleAdapter r9 = eu.davidea.flexibleadapter.FlexibleAdapter.this
                eu.davidea.flexibleadapter.utils.Logger r9 = r9.c
                java.lang.String r0 = "doInBackground - started UPDATE"
                java.lang.Object[] r3 = new java.lang.Object[r1]
                r9.d(r0, r3)
                eu.davidea.flexibleadapter.FlexibleAdapter r9 = eu.davidea.flexibleadapter.FlexibleAdapter.this
                java.util.List<T> r0 = r8.a
                r9.w(r0)
                eu.davidea.flexibleadapter.FlexibleAdapter r9 = eu.davidea.flexibleadapter.FlexibleAdapter.this
                java.util.List<T> r0 = r8.a
                eu.davidea.flexibleadapter.Payload r3 = eu.davidea.flexibleadapter.Payload.CHANGE
                r9.d(r0, r3)
                eu.davidea.flexibleadapter.FlexibleAdapter r9 = eu.davidea.flexibleadapter.FlexibleAdapter.this
                eu.davidea.flexibleadapter.utils.Logger r9 = r9.c
                java.lang.String r0 = "doInBackground - ended UPDATE"
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r9.d(r0, r1)
            L_0x00c9:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.davidea.flexibleadapter.FlexibleAdapter.p.doInBackground(java.lang.Object[]):java.lang.Object");
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            FlexibleAdapter.this.c.i("FilterAsyncTask cancelled!", new Object[0]);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r3) {
            FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
            if (flexibleAdapter.y != null) {
                int i = this.b;
                if (i == 1) {
                    flexibleAdapter.i(Payload.CHANGE);
                    FlexibleAdapter.this.onPostUpdate();
                } else if (i == 2) {
                    flexibleAdapter.i(Payload.FILTER);
                    FlexibleAdapter.this.onPostFilter();
                }
            }
            FlexibleAdapter.this.z = null;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
            if (flexibleAdapter.l0) {
                flexibleAdapter.c.w("Cannot filter while endlessLoading", new Object[0]);
                cancel(true);
            }
            if (FlexibleAdapter.this.isRestoreInTime()) {
                FlexibleAdapter flexibleAdapter2 = FlexibleAdapter.this;
                if (flexibleAdapter2.mDeleteCompleteListener != null) {
                    flexibleAdapter2.c.d("Removing all deleted items before filtering/updating", new Object[0]);
                    this.a.removeAll(FlexibleAdapter.this.getDeletedItems());
                    FlexibleAdapter flexibleAdapter3 = FlexibleAdapter.this;
                    List<T> list = flexibleAdapter3.w;
                    if (list != null) {
                        list.removeAll(flexibleAdapter3.getDeletedItems());
                    }
                    FlexibleAdapter.this.mDeleteCompleteListener.onDeleteConfirmed(3);
                }
            }
        }
    }

    /* JADX WARN: Field signature parse error: c */
    /* JADX WARN: Field signature parse error: d */
    public class r {
        public int a = -1;
        public int b = -1;
        public IFlexible c = null;
        public IFlexible d = null;

        /* JADX WARN: Failed to parse method signature: (TTTTI)V */
        public r(IFlexible iFlexible, IFlexible iFlexible2, int i) {
            this.c = iFlexible;
            this.d = iFlexible2;
            this.b = i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        public int a(boolean z) {
            if (this.a < 0) {
                this.a = FlexibleAdapter.this.getGlobalPositionOf(this.c);
            }
            IFlexible item = FlexibleAdapter.this.getItem(this.a);
            if (z && FlexibleAdapter.this.isExpandable(item)) {
                FlexibleAdapter flexibleAdapter = FlexibleAdapter.this;
                flexibleAdapter.x(this.a, flexibleAdapter.getCurrentChildren((IExpandable) item), 0);
            } else if (!FlexibleAdapter.this.isExpanded((FlexibleAdapter) item) || z) {
                this.a++;
            } else {
                this.a = ((ArrayList) FlexibleAdapter.this.m((IExpandable) item, true)).size() + 1 + this.a;
            }
            return this.a;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("RestoreInfo[item=");
            L.append(this.d);
            L.append(", refItem=");
            L.append(this.c);
            L.append("]");
            return L.toString();
        }
    }

    static {
        String simpleName = FlexibleAdapter.class.getSimpleName();
        p0 = a2.b.a.a.a.c3(simpleName, "_parentSelected");
        q0 = a2.b.a.a.a.c3(simpleName, "_childSelected");
        r0 = a2.b.a.a.a.c3(simpleName, "_headersShown");
        s0 = a2.b.a.a.a.c3(simpleName, "_stickyHeaders");
        t0 = a2.b.a.a.a.c3(simpleName, "_selectedLevel");
        u0 = a2.b.a.a.a.c3(simpleName, "_searchText");
    }

    public FlexibleAdapter(@Nullable List<T> list) {
        this(list, null);
    }

    public static void b(FlexibleAdapter flexibleAdapter, int i2) {
        RecyclerView recyclerView = flexibleAdapter.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(Math.min(Math.max(0, i2), flexibleAdapter.getItemCount() - 1));
        }
    }

    public final void A(boolean z2) {
        if (z2) {
            this.c.i("showAllHeaders at startup", new Object[0]);
            B(true);
            return;
        }
        this.c.i("showAllHeaders with insert notification (in Post!)", new Object[0]);
        this.mHandler.post(new k());
    }

    public final void B(boolean z2) {
        int i2 = 0;
        IHeader iHeader = null;
        while (i2 < getItemCount() - this.K.size()) {
            T item = getItem(i2);
            IHeader headerOf = getHeaderOf(item);
            if (headerOf != null && !headerOf.equals(iHeader) && !isExpandable(headerOf)) {
                headerOf.setHidden(true);
                iHeader = headerOf;
            }
            if (C(i2, item, z2)) {
                i2++;
            }
            i2++;
        }
        this.L = true;
    }

    public final boolean C(int i2, T t, boolean z2) {
        IHeader headerOf = getHeaderOf(t);
        if (headerOf == null || n(t) != null || !headerOf.isHidden()) {
            return false;
        }
        this.c.v("Showing header position=%s header=%s", Integer.valueOf(i2), headerOf);
        headerOf.setHidden(false);
        u(i2, Collections.singletonList(headerOf), !z2);
        return true;
    }

    public boolean addItem(@NonNull T t) {
        return addItem(getItemCount(), t);
    }

    public int addItemToSection(@NonNull ISectionable iSectionable, @Nullable IHeader iHeader, @Nullable Comparator<IFlexible> comparator) {
        int i2;
        if (iHeader == null || iHeader.isHidden()) {
            i2 = calculatePositionFor(iSectionable, comparator);
        } else {
            List<ISectionable> sectionItems = getSectionItems(iHeader);
            sectionItems.add(iSectionable);
            Collections.sort(sectionItems, comparator);
            i2 = sectionItems.indexOf(iSectionable);
        }
        return addItemToSection(iSectionable, iHeader, i2);
    }

    public void addItemWithDelay(@IntRange(from = 0) int i2, @NonNull T t, @IntRange(from = 0) long j2, boolean z2) {
        this.mHandler.postDelayed(new a(i2, t, z2), j2);
    }

    public boolean addItems(@IntRange(from = 0) int i2, @NonNull List<T> list) {
        if (list == null || list.isEmpty()) {
            this.c.e("addItems No items to add!", new Object[0]);
            return false;
        }
        int mainItemCount = getMainItemCount();
        if (i2 < 0) {
            this.c.w("addItems Position is negative! adding items to the end", new Object[0]);
            i2 = mainItemCount;
        }
        u(i2, list, true);
        if (this.L && !this.M) {
            this.M = true;
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (T t : list) {
                IHeader headerOf = getHeaderOf(t);
                if (headerOf != null) {
                    if (C(getGlobalPositionOf(t), t, false)) {
                        hashSet.add(headerOf);
                    } else {
                        hashSet2.add(headerOf);
                    }
                }
            }
            hashSet2.removeAll(hashSet);
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                notifyItemChanged(getGlobalPositionOf((IHeader) it.next()), Payload.CHANGE);
            }
            this.M = false;
        }
        if (!this.M && this.mUpdateListener != null && !this.F && mainItemCount == 0 && getItemCount() > 0) {
            this.mUpdateListener.onUpdateEmptyView(getMainItemCount());
        }
        return true;
    }

    @CallSuper
    public FlexibleAdapter<T> addListener(@NonNull Object obj) {
        if (obj == null) {
            this.c.e("Invalid listener class: null", new Object[0]);
            return this;
        }
        this.c.i("Adding listener class %s as:", LayoutUtils.getClassName(obj));
        if (obj instanceof OnItemClickListener) {
            this.c.i("- OnItemClickListener", new Object[0]);
            this.mItemClickListener = (OnItemClickListener) obj;
            for (FlexibleViewHolder flexibleViewHolder : getAllBoundViewHolders()) {
                flexibleViewHolder.getContentView().setOnClickListener(flexibleViewHolder);
            }
        }
        if (obj instanceof OnItemLongClickListener) {
            this.c.i("- OnItemLongClickListener", new Object[0]);
            this.mItemLongClickListener = (OnItemLongClickListener) obj;
            for (FlexibleViewHolder flexibleViewHolder2 : getAllBoundViewHolders()) {
                flexibleViewHolder2.getContentView().setOnLongClickListener(flexibleViewHolder2);
            }
        }
        if (obj instanceof OnItemMoveListener) {
            this.c.i("- OnItemMoveListener", new Object[0]);
            this.mItemMoveListener = (OnItemMoveListener) obj;
        }
        if (obj instanceof OnItemSwipeListener) {
            this.c.i("- OnItemSwipeListener", new Object[0]);
            this.mItemSwipeListener = (OnItemSwipeListener) obj;
        }
        if (obj instanceof OnDeleteCompleteListener) {
            this.c.i("- OnDeleteCompleteListener", new Object[0]);
            this.mDeleteCompleteListener = (OnDeleteCompleteListener) obj;
        }
        if (obj instanceof OnStickyHeaderChangeListener) {
            this.c.i("- OnStickyHeaderChangeListener", new Object[0]);
            this.mStickyHeaderChangeListener = (OnStickyHeaderChangeListener) obj;
        }
        if (obj instanceof OnUpdateListener) {
            this.c.i("- OnUpdateListener", new Object[0]);
            OnUpdateListener onUpdateListener = (OnUpdateListener) obj;
            this.mUpdateListener = onUpdateListener;
            onUpdateListener.onUpdateEmptyView(getMainItemCount());
        }
        return this;
    }

    public final boolean addScrollableFooter(@NonNull T t) {
        if (!this.K.contains(t)) {
            this.c.d("Add scrollable footer %s", LayoutUtils.getClassName(t));
            t.setSelectable(false);
            t.setDraggable(false);
            int size = t == this.o0 ? this.K.size() : 0;
            if (size <= 0 || this.K.size() <= 0) {
                this.K.add(t);
            } else {
                this.K.add(0, t);
            }
            u(getItemCount() - size, Collections.singletonList(t), true);
            return true;
        }
        this.c.w("Scrollable footer %s already added", LayoutUtils.getClassName(t));
        return false;
    }

    public final void addScrollableFooterWithDelay(@NonNull T t, @IntRange(from = 0) long j2, boolean z2) {
        this.c.d("Enqueued adding scrollable footer (%sms) %s", Long.valueOf(j2), LayoutUtils.getClassName(t));
        this.mHandler.postDelayed(new g(t, z2), j2);
    }

    public final boolean addScrollableHeader(@NonNull T t) {
        this.c.d("Add scrollable header %s", LayoutUtils.getClassName(t));
        if (!this.J.contains(t)) {
            t.setSelectable(false);
            t.setDraggable(false);
            int size = t == this.o0 ? this.J.size() : 0;
            this.J.add(t);
            this.q = true;
            u(size, Collections.singletonList(t), true);
            this.q = false;
            return true;
        }
        this.c.w("Scrollable header %s already added", LayoutUtils.getClassName(t));
        return false;
    }

    public final void addScrollableHeaderWithDelay(@NonNull T t, @IntRange(from = 0) long j2, boolean z2) {
        this.c.d("Enqueued adding scrollable header (%sms) %s", Long.valueOf(j2), LayoutUtils.getClassName(t));
        this.mHandler.postDelayed(new f(t, z2), j2);
    }

    public int addSection(@NonNull IHeader iHeader) {
        return addSection(iHeader, null);
    }

    public boolean addSubItem(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @NonNull T t) {
        return addSubItem(i2, i3, t, false, Payload.CHANGE);
    }

    public boolean addSubItems(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @NonNull List<T> list) {
        return addSubItems(i2, i3, list, false, Payload.CHANGE);
    }

    public boolean areHeadersShown() {
        return this.L;
    }

    public boolean areHeadersSticky() {
        return this.O != null;
    }

    public final void c(int i2, int i3) {
        String str;
        List<Integer> selectedPositions = getSelectedPositions();
        if (i3 > 0) {
            Collections.sort(selectedPositions, new d(this));
            str = "+";
        } else {
            str = "";
        }
        boolean z2 = false;
        for (Integer num : selectedPositions) {
            if (num.intValue() >= i2) {
                removeSelection(num.intValue());
                this.d.add(Integer.valueOf(Math.max(num.intValue() + i3, i2)));
                z2 = true;
            }
        }
        if (z2) {
            this.c.v("AdjustedSelected(%s)=%s", a2.b.a.a.a.M2(str, i3), getSelectedPositions());
        }
    }

    public int calculatePositionFor(@NonNull Object obj, @Nullable Comparator<IFlexible> comparator) {
        ISectionable iSectionable;
        IHeader header;
        if (comparator == null) {
            return 0;
        }
        if (!(obj instanceof ISectionable) || (header = (iSectionable = (ISectionable) obj).getHeader()) == null || header.isHidden()) {
            ArrayList arrayList = new ArrayList(this.u);
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
            Collections.sort(arrayList, comparator);
            this.c.v("Calculated position %s for item=%s", Integer.valueOf(Math.max(0, arrayList.indexOf(obj))), obj);
            return Math.max(0, arrayList.indexOf(obj));
        }
        List<ISectionable> sectionItems = getSectionItems(header);
        sectionItems.add(iSectionable);
        Collections.sort(sectionItems, comparator);
        int globalPositionOf = getGlobalPositionOf(iSectionable);
        int globalPositionOf2 = getGlobalPositionOf(header);
        int i2 = (globalPositionOf == -1 || globalPositionOf >= globalPositionOf2) ? 1 : 0;
        int indexOf = sectionItems.indexOf(obj) + globalPositionOf2 + i2;
        this.c.v("Calculated finalPosition=%s sectionPosition=%s relativePosition=%s fix=%s", Integer.valueOf(indexOf), Integer.valueOf(globalPositionOf2), Integer.valueOf(sectionItems.indexOf(obj)), Integer.valueOf(i2));
        return indexOf;
    }

    public void clear() {
        this.c.d("clearAll views", new Object[0]);
        removeAllScrollableHeaders();
        removeAllScrollableFooters();
        removeRange(0, getItemCount(), null);
    }

    public void clearAllBut(Integer... numArr) {
        List asList = Arrays.asList(numArr);
        this.c.d("clearAll retaining views %s", asList);
        ArrayList arrayList = new ArrayList();
        int itemCount = getItemCount() - this.K.size();
        for (int max = Math.max(0, this.J.size()); max < itemCount; max++) {
            if (!asList.contains(Integer.valueOf(getItemViewType(max)))) {
                arrayList.add(Integer.valueOf(max));
            }
        }
        removeItems(arrayList);
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter
    @CallSuper
    public void clearSelection() {
        this.e0 = false;
        this.f0 = false;
        super.clearSelection();
    }

    public int collapse(@IntRange(from = 0) int i2) {
        return collapse(i2, false);
    }

    public int collapseAll() {
        return collapseAll(this.Z);
    }

    public boolean contains(@Nullable T t) {
        return t != null && this.u.contains(t);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0073: APUT  (r2v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r6v2 java.lang.Object) */
    public final synchronized void d(@Nullable List<T> list, Payload payload) {
        this.y = new ArrayList();
        if (list == null || list.size() > this.Y) {
            Logger logger = this.c;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(getItemCount());
            objArr[1] = list != null ? Integer.valueOf(list.size()) : "0";
            objArr[2] = Integer.valueOf(this.Y);
            logger.d("NotifyDataSetChanged! oldSize=%s newSize=%s limit=%s", objArr);
            this.v = list;
            this.y.add(new q(-1, 0));
        } else {
            this.c.d("Animate changes! oldSize=%s newSize=%s limit=%s", Integer.valueOf(getItemCount()), Integer.valueOf(list.size()), Integer.valueOf(this.Y));
            ArrayList arrayList = new ArrayList(this.u);
            this.v = arrayList;
            g(arrayList, list);
            e(this.v, list);
            if (this.X) {
                f(this.v, list);
            }
        }
        if (this.z == null) {
            i(payload);
        }
    }

    public final void e(List<T> list, List<T> list2) {
        this.x = new HashSet(list);
        int i2 = 0;
        for (int i3 = 0; i3 < list2.size(); i3++) {
            FlexibleAdapter<T>.p pVar = this.z;
            if (pVar == null || !pVar.isCancelled()) {
                T t = list2.get(i3);
                if (!this.x.contains(t)) {
                    this.c.v("calculateAdditions add position=%s item=%s", Integer.valueOf(i3), t);
                    if (this.X) {
                        list.add(t);
                        this.y.add(new q(list.size(), 1));
                    } else {
                        if (i3 < list.size()) {
                            list.add(i3, t);
                        } else {
                            list.add(t);
                        }
                        this.y.add(new q(i3, 1));
                    }
                    i2++;
                }
            } else {
                return;
            }
        }
        this.x = null;
        this.c.d("calculateAdditions total new=%s", Integer.valueOf(i2));
    }

    public synchronized void emptyBin() {
        this.c.d("emptyBin!", new Object[0]);
        this.C.clear();
        this.D.clear();
    }

    public final void ensureHeaderParent() {
        if (areHeadersSticky()) {
            this.O.ensureHeaderParent();
        }
    }

    public int expand(@IntRange(from = 0) int i2) {
        return expand(i2, false);
    }

    public int expandAll() {
        return expandAll(this.Z);
    }

    public FlexibleAdapter<T> expandItemsAtStartUp() {
        this.q = true;
        this.F = true;
        for (int i2 = 0; i2 < getItemCount(); i2++) {
            T item = getItem(i2);
            if (!this.L && isHeader(item) && !item.isHidden()) {
                this.L = true;
            }
            if (isExpanded((FlexibleAdapter<T>) item)) {
                j(i2, false, true, false);
            }
        }
        this.F = false;
        this.q = false;
        return this;
    }

    public final void f(List<T> list, List<T> list2) {
        int i2 = 0;
        for (int size = list2.size() - 1; size >= 0; size--) {
            FlexibleAdapter<T>.p pVar = this.z;
            if (pVar == null || !pVar.isCancelled()) {
                int indexOf = list.indexOf(list2.get(size));
                if (indexOf >= 0 && indexOf != size) {
                    this.c.v("calculateMovedItems fromPosition=%s toPosition=%s", Integer.valueOf(indexOf), Integer.valueOf(size));
                    T remove = list.remove(indexOf);
                    if (size < list.size()) {
                        list.add(size, remove);
                    } else {
                        list.add(remove);
                    }
                    this.y.add(new q(indexOf, size, 4));
                    i2++;
                }
            } else {
                return;
            }
        }
        this.c.d("calculateMovedItems total move=%s", Integer.valueOf(i2));
    }

    public void filterItems() {
        if (this.w == null) {
            this.w = this.u;
        }
        filterItems(this.w);
    }

    public boolean filterObject(T t, String str) {
        return (t instanceof IFilterable) && ((IFilterable) t).filter(str);
    }

    public final void g(List<T> list, List<T> list2) {
        HashMap hashMap;
        if (this.V) {
            this.x = new HashSet(list);
            hashMap = new HashMap();
            for (int i2 = 0; i2 < list2.size() && ((r4 = this.z) == null || !r4.isCancelled()); i2++) {
                T t = list2.get(i2);
                if (this.x.contains(t)) {
                    hashMap.put(t, Integer.valueOf(i2));
                }
            }
        } else {
            hashMap = null;
        }
        this.x = new HashSet(list2);
        int i3 = 0;
        int i4 = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            FlexibleAdapter<T>.p pVar = this.z;
            if (pVar == null || !pVar.isCancelled()) {
                T t2 = list.get(size);
                if (!this.x.contains(t2)) {
                    this.c.v("calculateRemovals remove position=%s item=%s", Integer.valueOf(size), t2);
                    list.remove(size);
                    this.y.add(new q(size, 3));
                    i4++;
                } else if (this.V) {
                    T t3 = list2.get(((Integer) hashMap.get(t2)).intValue());
                    if (isFiltering() || t2.shouldNotifyChange(t3)) {
                        list.set(size, t3);
                        this.y.add(new q(size, 2));
                        i3++;
                    }
                }
            } else {
                return;
            }
        }
        this.x = null;
        this.c.d("calculateModifications total mod=%s", Integer.valueOf(i3));
        this.c.d("calculateRemovals total out=%s", Integer.valueOf(i4));
    }

    public final int getCardinalPositionOf(@NonNull IFlexible iFlexible) {
        int globalPositionOf = getGlobalPositionOf(iFlexible);
        return globalPositionOf > this.J.size() ? globalPositionOf - this.J.size() : globalPositionOf;
    }

    @NonNull
    public final List<T> getCurrentChildren(@Nullable IExpandable iExpandable) {
        if (iExpandable == null || !hasSubItems(iExpandable)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(iExpandable.getSubItems());
        if (!this.C.isEmpty()) {
            arrayList.removeAll(getDeletedChildren(iExpandable));
        }
        return arrayList;
    }

    @NonNull
    public final List<T> getCurrentItems() {
        return Collections.unmodifiableList(this.u);
    }

    @NonNull
    public final List<T> getDeletedChildren(IExpandable iExpandable) {
        ArrayList arrayList = new ArrayList();
        for (FlexibleAdapter<T>.r rVar : this.C) {
            IFlexible iFlexible = rVar.c;
            if (iFlexible != null && iFlexible.equals(iExpandable) && rVar.b >= 0) {
                arrayList.add(rVar.d);
            }
        }
        return arrayList;
    }

    @NonNull
    public List<T> getDeletedItems() {
        ArrayList arrayList = new ArrayList();
        for (FlexibleAdapter<T>.r rVar : this.C) {
            arrayList.add(rVar.d);
        }
        return arrayList;
    }

    public int getEndlessCurrentPage() {
        return Math.max(1, this.k0 > 0 ? getMainItemCount() / this.k0 : 0);
    }

    public int getEndlessPageSize() {
        return this.k0;
    }

    public int getEndlessTargetCount() {
        return this.j0;
    }

    @Nullable
    public IExpandable getExpandableOf(int i2) {
        return getExpandableOf((FlexibleAdapter<T>) getItem(i2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter<T extends eu.davidea.flexibleadapter.items.IFlexible> */
    /* JADX WARN: Multi-variable type inference failed */
    public final IExpandable getExpandableOfDeletedChild(@NonNull T t) {
        for (FlexibleAdapter<T>.r rVar : this.C) {
            if (rVar.d.equals(t) && isExpandable(rVar.c)) {
                return (IExpandable) rVar.c;
            }
        }
        return null;
    }

    public int getExpandablePositionOf(@NonNull T t) {
        return getGlobalPositionOf(getExpandableOf((FlexibleAdapter<T>) t));
    }

    @NonNull
    public List<T> getExpandedItems() {
        ArrayList arrayList = new ArrayList();
        for (T t : this.u) {
            if (isExpanded((FlexibleAdapter<T>) t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NonNull
    public List<Integer> getExpandedPositions() {
        ArrayList arrayList = new ArrayList();
        int itemCount = (getItemCount() - this.K.size()) - 1;
        for (int max = Math.max(0, this.J.size() - 1); max < itemCount; max++) {
            if (isExpanded((FlexibleAdapter<T>) getItem(max))) {
                arrayList.add(Integer.valueOf(max));
            }
        }
        return arrayList;
    }

    public final int getGlobalPositionOf(IFlexible iFlexible) {
        if (iFlexible != null) {
            return this.u.indexOf(iFlexible);
        }
        return -1;
    }

    @NonNull
    public List<IHeader> getHeaderItems() {
        ArrayList arrayList = new ArrayList();
        for (T t : this.u) {
            if (isHeader(t)) {
                arrayList.add((IHeader) t);
            }
        }
        return arrayList;
    }

    @Nullable
    public IHeader getHeaderOf(T t) {
        if (t == null || !(t instanceof ISectionable)) {
            return null;
        }
        return ((ISectionable) t).getHeader();
    }

    @Nullable
    public T getItem(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return null;
        }
        return this.u.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.u.size();
    }

    public final int getItemCountOfTypes(Integer... numArr) {
        List asList = Arrays.asList(numArr);
        int i2 = 0;
        for (int i3 = 0; i3 < getItemCount(); i3++) {
            if (asList.contains(Integer.valueOf(getItemViewType(i3)))) {
                i2++;
            }
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        T item = getItem(i2);
        if (item != null) {
            return (long) item.hashCode();
        }
        return -1;
    }

    public final ItemTouchHelper getItemTouchHelper() {
        s();
        return this.h0;
    }

    public final ItemTouchHelperCallback getItemTouchHelperCallback() {
        s();
        return this.g0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        T item = getItem(i2);
        if (item == null) {
            return 0;
        }
        if (!this.Q.containsKey(Integer.valueOf(item.getItemViewType()))) {
            this.Q.put(Integer.valueOf(item.getItemViewType()), item);
            this.c.i("Mapped viewType %s from %s", Integer.valueOf(item.getItemViewType()), LayoutUtils.getClassName(item));
        }
        this.R = true;
        return item.getItemViewType();
    }

    public final int getMainItemCount() {
        return hasSearchText() ? getItemCount() : (getItemCount() - this.J.size()) - this.K.size();
    }

    public int getMinCollapsibleLevel() {
        return this.Z;
    }

    public final int getSameTypePositionOf(@NonNull IFlexible iFlexible) {
        int i2 = -1;
        for (T t : this.u) {
            if (t.getItemViewType() == iFlexible.getItemViewType()) {
                i2++;
                if (t.equals(iFlexible)) {
                    break;
                }
            }
        }
        return i2;
    }

    public final List<T> getScrollableFooters() {
        return Collections.unmodifiableList(this.K);
    }

    public final List<T> getScrollableHeaders() {
        return Collections.unmodifiableList(this.J);
    }

    @NonNull
    public String getSearchText() {
        return this.S;
    }

    public IHeader getSectionHeader(@IntRange(from = 0) int i2) {
        if (!this.L) {
            return null;
        }
        while (i2 >= 0) {
            T item = getItem(i2);
            if (isHeader(item)) {
                return (IHeader) item;
            }
            i2--;
        }
        return null;
    }

    @NonNull
    public List<Integer> getSectionItemPositions(@NonNull IHeader iHeader) {
        ArrayList arrayList = new ArrayList();
        int globalPositionOf = getGlobalPositionOf(iHeader) + 1;
        T item = getItem(globalPositionOf);
        while (hasSameHeader(item, iHeader)) {
            arrayList.add(Integer.valueOf(globalPositionOf));
            globalPositionOf++;
            item = getItem(globalPositionOf);
        }
        return arrayList;
    }

    @NonNull
    public List<ISectionable> getSectionItems(@NonNull IHeader iHeader) {
        ArrayList arrayList = new ArrayList();
        int globalPositionOf = getGlobalPositionOf(iHeader) + 1;
        T item = getItem(globalPositionOf);
        while (hasSameHeader(item, iHeader)) {
            arrayList.add((ISectionable) item);
            globalPositionOf++;
            item = getItem(globalPositionOf);
        }
        return arrayList;
    }

    @NonNull
    public List<T> getSiblingsOf(@NonNull T t) {
        IExpandable expandableOf = getExpandableOf((FlexibleAdapter<T>) t);
        return expandableOf != null ? expandableOf.getSubItems() : new ArrayList();
    }

    public int getStickyHeaderElevation() {
        return this.N;
    }

    public final int getStickyPosition() {
        if (areHeadersSticky()) {
            return this.O.getStickyPosition();
        }
        return -1;
    }

    public int getSubPositionOf(@NonNull T t) {
        if ((t instanceof ISectionable) && hasHeader(t)) {
            IHeader headerOf = getHeaderOf(t);
            if (!(headerOf instanceof IExpandable)) {
                return (getGlobalPositionOf(t) - getGlobalPositionOf(headerOf)) - 1;
            }
        }
        return getSiblingsOf(t).indexOf(t);
    }

    public long getTime() {
        return this.B;
    }

    @NonNull
    public List<Integer> getUndoPositions() {
        return this.D;
    }

    public final boolean h(List<T> list, IExpandable iExpandable) {
        return list.contains(iExpandable) && list.removeAll(iExpandable.getSubItems());
    }

    public boolean hasHeader(T t) {
        return getHeaderOf(t) != null;
    }

    public boolean hasNewSearchText(String str) {
        return !this.T.equalsIgnoreCase(str);
    }

    public boolean hasSameHeader(T t, IHeader iHeader) {
        IHeader headerOf = getHeaderOf(t);
        return (headerOf == null || iHeader == null || !headerOf.equals(iHeader)) ? false : true;
    }

    public boolean hasSearchText() {
        String str = this.S;
        return str != null && !str.isEmpty();
    }

    public boolean hasSubItems(IExpandable iExpandable) {
        return (iExpandable == null || iExpandable.getSubItems() == null || iExpandable.getSubItems().size() <= 0) ? false : true;
    }

    public void hideAllHeaders() {
        this.mHandler.post(new l());
    }

    public final synchronized void i(Payload payload) {
        this.c.i("Performing %s notifications", Integer.valueOf(this.y.size()));
        this.u = this.v;
        this.q = false;
        for (q qVar : this.y) {
            int i2 = qVar.c;
            if (i2 == 1) {
                notifyItemInserted(qVar.b);
            } else if (i2 == 2) {
                notifyItemChanged(qVar.b, payload);
            } else if (i2 == 3) {
                notifyItemRemoved(qVar.b);
            } else if (i2 != 4) {
                this.c.w("notifyDataSetChanged!", new Object[0]);
                notifyDataSetChanged();
            } else {
                notifyItemMoved(qVar.a, qVar.b);
            }
        }
        this.v = null;
        this.y = null;
        this.q = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.B = currentTimeMillis;
        long j2 = currentTimeMillis - this.A;
        this.B = j2;
        this.c.i("Animate changes DONE in %sms", Long.valueOf(j2));
    }

    public final void invalidateItemDecorations(@IntRange(from = 0) long j2) {
        this.mRecyclerView.postDelayed(new e(), j2);
    }

    public boolean isAnyChildSelected() {
        return this.e0;
    }

    public boolean isAnyParentSelected() {
        return this.f0;
    }

    public boolean isAutoCollapseOnExpand() {
        return this.c0;
    }

    public boolean isAutoScrollOnExpand() {
        return this.b0;
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public boolean isEnabled(int i2) {
        T item = getItem(i2);
        return item != null && item.isEnabled();
    }

    public boolean isEndlessScrollEnabled() {
        return this.m0;
    }

    public boolean isExpandable(@Nullable T t) {
        return t instanceof IExpandable;
    }

    public boolean isExpanded(@IntRange(from = 0) int i2) {
        return isExpanded((FlexibleAdapter<T>) getItem(i2));
    }

    public boolean isFiltering() {
        return this.W;
    }

    public final boolean isHandleDragEnabled() {
        ItemTouchHelperCallback itemTouchHelperCallback = this.g0;
        return itemTouchHelperCallback != null && itemTouchHelperCallback.isHandleDragEnabled();
    }

    public boolean isHeader(T t) {
        return t != null && (t instanceof IHeader);
    }

    public final boolean isLongPressDragEnabled() {
        ItemTouchHelperCallback itemTouchHelperCallback = this.g0;
        return itemTouchHelperCallback != null && itemTouchHelperCallback.isLongPressDragEnabled();
    }

    public boolean isPermanentDelete() {
        return this.H;
    }

    public boolean isRecursiveCollapse() {
        return this.d0;
    }

    public final boolean isRestoreInTime() {
        List<FlexibleAdapter<T>.r> list = this.C;
        return list != null && !list.isEmpty();
    }

    public boolean isRestoreWithSelection() {
        return this.E;
    }

    @Override // eu.davidea.flexibleadapter.AnimatorAdapter
    public final boolean isScrollableHeaderOrFooter(int i2) {
        return isScrollableHeaderOrFooter((FlexibleAdapter<T>) getItem(i2));
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter
    public boolean isSelectable(int i2) {
        T item = getItem(i2);
        return item != null && item.isSelectable();
    }

    public final boolean isSwipeEnabled() {
        ItemTouchHelperCallback itemTouchHelperCallback = this.g0;
        return itemTouchHelperCallback != null && itemTouchHelperCallback.isItemViewSwipeEnabled();
    }

    public boolean isTopEndless() {
        return this.n0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter<T extends eu.davidea.flexibleadapter.items.IFlexible> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00fa: APUT  (r15v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r14v1 java.lang.String) */
    public final int j(int i2, boolean z2, boolean z3, boolean z4) {
        IFlexible item = getItem(i2);
        if (!isExpandable(item)) {
            return 0;
        }
        IExpandable iExpandable = (IExpandable) item;
        if (!hasSubItems(iExpandable)) {
            iExpandable.setExpanded(false);
            this.c.w("No subItems to Expand on position %s expanded %s", Integer.valueOf(i2), Boolean.valueOf(iExpandable.isExpanded()));
            return 0;
        }
        if (!z3 && !z2) {
            this.c.v("Request to Expand on position=%s expanded=%s anyParentSelected=%s", Integer.valueOf(i2), Boolean.valueOf(iExpandable.isExpanded()), Boolean.valueOf(this.f0));
        }
        if (!z3) {
            if (iExpandable.isExpanded()) {
                return 0;
            }
            if (this.f0 && iExpandable.getExpansionLevel() > this.a0) {
                return 0;
            }
        }
        if (this.c0 && !z2 && collapseAll(this.Z) > 0) {
            i2 = getGlobalPositionOf(item);
        }
        List m2 = m(iExpandable, true);
        int i3 = i2 + 1;
        this.u.addAll(i3, m2);
        ArrayList arrayList = (ArrayList) m2;
        int size = arrayList.size();
        iExpandable.setExpanded(true);
        if (!z3 && this.b0 && !z2) {
            new Handler(Looper.getMainLooper(), new q6.a.a.a(this, i2, size)).sendMessageDelayed(Message.obtain(this.mHandler), 150);
        }
        if (z4) {
            notifyItemChanged(i2, Payload.EXPANDED);
        }
        notifyItemRangeInserted(i3, size);
        if (!z3 && this.L) {
            Iterator it = arrayList.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                i4++;
                if (C(i2 + i4, (IFlexible) it.next(), false)) {
                    i4++;
                }
            }
        }
        if (!k(this.J, iExpandable)) {
            k(this.K, iExpandable);
        }
        Logger logger = this.c;
        Object[] objArr = new Object[3];
        objArr[0] = z3 ? "Initially expanded" : "Expanded";
        objArr[1] = Integer.valueOf(size);
        objArr[2] = Integer.valueOf(i2);
        logger.v("%s %s subItems on position=%s", objArr);
        return size;
    }

    public final boolean k(List<T> list, IExpandable iExpandable) {
        int indexOf = list.indexOf(iExpandable);
        if (indexOf < 0) {
            return false;
        }
        int i2 = indexOf + 1;
        if (i2 < list.size()) {
            return list.addAll(i2, iExpandable.getSubItems());
        }
        return list.addAll(iExpandable.getSubItems());
    }

    public final boolean l(T t, List<T> list) {
        boolean z2;
        FlexibleAdapter<T>.p pVar = this.z;
        if (pVar != null && pVar.isCancelled()) {
            return false;
        }
        if (this.w != null && (isScrollableHeaderOrFooter((FlexibleAdapter<T>) t) || list.contains(t))) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        if (isExpandable(t)) {
            IExpandable iExpandable = (IExpandable) t;
            if (iExpandable.isExpanded()) {
                if (this.U == null) {
                    this.U = new HashSet();
                }
                this.U.add(iExpandable);
            }
            z2 = false;
            for (T t2 : getCurrentChildren(iExpandable)) {
                if (!(t2 instanceof IExpandable) || !l(t2, arrayList)) {
                    t2.setHidden(!filterObject(t2, getSearchText()));
                    if (!t2.isHidden()) {
                        arrayList.add(t2);
                    }
                }
                z2 = true;
            }
            iExpandable.setExpanded(z2);
        } else {
            z2 = false;
        }
        if (!z2) {
            z2 = filterObject(t, getSearchText());
        }
        if (z2) {
            T headerOf = getHeaderOf(t);
            if (this.L && hasHeader(t) && !list.contains(headerOf)) {
                headerOf.setHidden(false);
                list.add(headerOf);
            }
            list.addAll(arrayList);
        }
        t.setHidden(!z2);
        return z2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter<T extends eu.davidea.flexibleadapter.items.IFlexible> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final List<T> m(IExpandable iExpandable, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (iExpandable != null && hasSubItems(iExpandable)) {
            for (IFlexible iFlexible : iExpandable.getSubItems()) {
                if (!iFlexible.isHidden()) {
                    arrayList.add(iFlexible);
                    if (z2 && isExpanded((FlexibleAdapter<T>) iFlexible)) {
                        IExpandable iExpandable2 = (IExpandable) iFlexible;
                        if (iExpandable2.getSubItems().size() > 0) {
                            arrayList.addAll(m(iExpandable2, true));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void moveItem(int i2, int i3) {
        moveItem(i2, i3, Payload.MOVE);
    }

    public final FlexibleAdapter<T>.r n(T t) {
        for (FlexibleAdapter<T>.r rVar : this.C) {
            if (rVar.d.equals(t) && rVar.a < 0) {
                return rVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter<T extends eu.davidea.flexibleadapter.items.IFlexible> */
    /* JADX WARN: Multi-variable type inference failed */
    public final int o(@NonNull IExpandable iExpandable, int i2) {
        List subItems = iExpandable.getSubItems();
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            IFlexible iFlexible = (IFlexible) subItems.get(i4);
            if (isExpanded((FlexibleAdapter<T>) iFlexible)) {
                IExpandable iExpandable2 = (IExpandable) iFlexible;
                i3 += o(iExpandable2, iExpandable2.getSubItems() != null ? iExpandable2.getSubItems().size() : 0);
            }
            i3++;
        }
        return i3;
    }

    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.AdapterCallback
    public void onActionStateChanged(RecyclerView.ViewHolder viewHolder, int i2) {
        OnItemMoveListener onItemMoveListener = this.mItemMoveListener;
        if (onItemMoveListener != null) {
            onItemMoveListener.onActionStateChanged(viewHolder, i2);
            return;
        }
        OnItemSwipeListener onItemSwipeListener = this.mItemSwipeListener;
        if (onItemSwipeListener != null) {
            onItemSwipeListener.onActionStateChanged(viewHolder, i2);
        }
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.c.v("Attached Adapter to RecyclerView", new Object[0]);
        if (this.L && areHeadersSticky()) {
            this.O.attachToRecyclerView(this.mRecyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        onBindViewHolder(viewHolder, i2, Collections.unmodifiableList(new ArrayList()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        T t = this.Q.get(Integer.valueOf(i2));
        if (t == null || !this.R) {
            throw new IllegalStateException(String.format("ViewType instance not found for viewType %s. You should implement the AutoMap properly.", Integer.valueOf(i2)));
        }
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return t.createViewHolder(this.mInflater.inflate(t.getLayoutRes(), viewGroup, false), this);
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (areHeadersSticky()) {
            this.O.detachFromRecyclerView();
            this.O = null;
        }
        super.onDetachedFromRecyclerView(recyclerView);
        this.c.v("Detached Adapter from RecyclerView", new Object[0]);
    }

    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.AdapterCallback
    @CallSuper
    public boolean onItemMove(int i2, int i3) {
        swapItems(this.u, i2, i3);
        OnItemMoveListener onItemMoveListener = this.mItemMoveListener;
        if (onItemMoveListener == null) {
            return true;
        }
        onItemMoveListener.onItemMove(i2, i3);
        return true;
    }

    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.AdapterCallback
    @CallSuper
    public void onItemSwiped(int i2, int i3) {
        OnItemSwipeListener onItemSwipeListener = this.mItemSwipeListener;
        if (onItemSwipeListener != null) {
            onItemSwipeListener.onItemSwipe(i2, i3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLoadMore(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.isEndlessScrollEnabled()
            if (r0 == 0) goto L_0x009d
            boolean r0 = r5.l0
            if (r0 != 0) goto L_0x009d
            eu.davidea.flexibleadapter.items.IFlexible r0 = r5.getItem(r6)
            T extends eu.davidea.flexibleadapter.items.IFlexible r1 = r5.o0
            if (r0 != r1) goto L_0x0014
            goto L_0x009d
        L_0x0014:
            boolean r0 = r5.n0
            r1 = 0
            if (r0 == 0) goto L_0x0029
            int r0 = r5.i0
            boolean r2 = r5.hasSearchText()
            if (r2 == 0) goto L_0x0022
            goto L_0x0036
        L_0x0022:
            java.util.List<T extends eu.davidea.flexibleadapter.items.IFlexible> r2 = r5.J
            int r2 = r2.size()
            goto L_0x003e
        L_0x0029:
            int r0 = r5.getItemCount()
            int r2 = r5.i0
            int r0 = r0 - r2
            boolean r2 = r5.hasSearchText()
            if (r2 == 0) goto L_0x0038
        L_0x0036:
            r2 = 0
            goto L_0x003e
        L_0x0038:
            java.util.List<T extends eu.davidea.flexibleadapter.items.IFlexible> r2 = r5.K
            int r2 = r2.size()
        L_0x003e:
            int r0 = r0 - r2
            boolean r2 = r5.n0
            if (r2 != 0) goto L_0x004d
            T extends eu.davidea.flexibleadapter.items.IFlexible r2 = r5.o0
            int r2 = r5.getGlobalPositionOf(r2)
            if (r6 == r2) goto L_0x0055
            if (r6 < r0) goto L_0x0055
        L_0x004d:
            boolean r2 = r5.n0
            if (r2 == 0) goto L_0x0056
            if (r6 <= 0) goto L_0x0056
            if (r6 <= r0) goto L_0x0056
        L_0x0055:
            return
        L_0x0056:
            eu.davidea.flexibleadapter.utils.Logger r3 = r5.c
            r4 = 6
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4[r1] = r2
            boolean r1 = r5.l0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2 = 1
            r4[r2] = r1
            r1 = 2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4[r1] = r6
            r6 = 3
            int r1 = r5.getItemCount()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4[r6] = r1
            r6 = 4
            int r1 = r5.i0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4[r6] = r1
            r6 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r6] = r0
            java.lang.String r6 = "onLoadMore     topEndless=%s, loading=%s, position=%s, itemCount=%s threshold=%s, currentThreshold=%s"
            r3.v(r6, r4)
            r5.l0 = r2
            android.os.Handler r6 = r5.mHandler
            eu.davidea.flexibleadapter.FlexibleAdapter$n r0 = new eu.davidea.flexibleadapter.FlexibleAdapter$n
            r0.<init>()
            r6.post(r0)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.davidea.flexibleadapter.FlexibleAdapter.onLoadMore(int):void");
    }

    public void onLoadMoreComplete(@Nullable List<T> list) {
        onLoadMoreComplete(list, 0);
    }

    @CallSuper
    public void onPostFilter() {
        OnUpdateListener onUpdateListener = this.mUpdateListener;
        if (onUpdateListener != null) {
            onUpdateListener.onUpdateEmptyView(getMainItemCount());
        }
    }

    @CallSuper
    public void onPostUpdate() {
        OnUpdateListener onUpdateListener = this.mUpdateListener;
        if (onUpdateListener != null) {
            onUpdateListener.onUpdateEmptyView(getMainItemCount());
        }
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter
    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            boolean z2 = bundle.getBoolean(r0);
            if (!z2) {
                hideAllHeaders();
            } else if (!this.L) {
                B(true);
            }
            this.L = z2;
            if (bundle.getBoolean(s0) && !areHeadersSticky()) {
                setStickyHeaders(true);
            }
            super.onRestoreInstanceState(bundle);
            if (this.J.size() > 0) {
                c(0, this.J.size());
            }
            this.f0 = bundle.getBoolean(p0);
            this.e0 = bundle.getBoolean(q0);
            this.a0 = bundle.getInt(t0);
            this.S = bundle.getString(u0);
        }
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            if (this.J.size() > 0) {
                c(0, -this.J.size());
            }
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(q0, this.e0);
            bundle.putBoolean(p0, this.f0);
            bundle.putInt(t0, this.a0);
            bundle.putString(u0, this.S);
            bundle.putBoolean(r0, this.L);
            bundle.putBoolean(s0, areHeadersSticky());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        T item = getItem(adapterPosition);
        if (item != null) {
            item.onViewAttached(this, viewHolder, adapterPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        T item = getItem(adapterPosition);
        if (item != null) {
            item.onViewDetached(this, viewHolder, adapterPosition);
        }
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (areHeadersSticky()) {
            viewHolder.itemView.setVisibility(0);
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        T item = getItem(adapterPosition);
        if (item != null) {
            item.unbindViewHolder(this, viewHolder, adapterPosition);
        }
    }

    public final boolean p(int i2, List<T> list) {
        for (T t : list) {
            i2++;
            if (isSelected(i2) || (isExpanded((FlexibleAdapter<T>) t) && p(i2, m((IExpandable) t, false)))) {
                return true;
            }
        }
        return false;
    }

    public final void q(int i2, IHeader iHeader) {
        if (i2 >= 0) {
            this.c.v("Hiding header position=%s header=$s", Integer.valueOf(i2), iHeader);
            iHeader.setHidden(true);
            this.u.remove(i2);
            notifyItemRemoved(i2);
        }
    }

    public final void r() {
        if (getGlobalPositionOf(this.o0) >= 0) {
            this.c.v("onLoadMore     remove progressItem", new Object[0]);
            if (this.n0) {
                removeScrollableHeader(this.o0);
            } else {
                removeScrollableFooter(this.o0);
            }
        }
    }

    public final void removeAllScrollableFooters() {
        if (this.K.size() > 0) {
            this.c.d("Remove all scrollable footers", new Object[0]);
            this.u.removeAll(this.K);
            notifyItemRangeRemoved(getItemCount() - this.K.size(), this.K.size());
            this.K.clear();
        }
    }

    public final void removeAllScrollableHeaders() {
        if (this.J.size() > 0) {
            this.c.d("Remove all scrollable headers", new Object[0]);
            this.u.removeAll(this.J);
            notifyItemRangeRemoved(0, this.J.size());
            this.J.clear();
        }
    }

    public void removeAllSelectedItems() {
        removeAllSelectedItems(null);
    }

    public void removeItem(@IntRange(from = 0) int i2) {
        removeItem(i2, Payload.CHANGE);
    }

    public void removeItemWithDelay(@NonNull T t, @IntRange(from = 0) long j2, boolean z2) {
        this.mHandler.postDelayed(new b(t, z2), j2);
    }

    public void removeItems(@NonNull List<Integer> list) {
        removeItems(list, Payload.REM_SUB_ITEM);
    }

    public void removeItemsOfType(Integer... numArr) {
        List asList = Arrays.asList(numArr);
        ArrayList arrayList = new ArrayList();
        int max = Math.max(0, this.J.size() - 1);
        for (int itemCount = (getItemCount() - this.K.size()) - 1; itemCount >= max; itemCount--) {
            if (asList.contains(Integer.valueOf(getItemViewType(itemCount)))) {
                arrayList.add(Integer.valueOf(itemCount));
            }
        }
        removeItems(arrayList);
    }

    public final FlexibleAdapter<T> removeListener(@NonNull Object obj) {
        if (obj == null) {
            this.c.e("No listener class to remove!", new Object[0]);
            return this;
        }
        String className = LayoutUtils.getClassName(obj);
        if ((obj instanceof OnItemClickListener) || obj == OnItemClickListener.class) {
            this.mItemClickListener = null;
            this.c.i("Removed %s as OnItemClickListener", className);
            for (FlexibleViewHolder flexibleViewHolder : getAllBoundViewHolders()) {
                flexibleViewHolder.getContentView().setOnClickListener(null);
            }
        }
        if ((obj instanceof OnItemLongClickListener) || obj == OnItemLongClickListener.class) {
            this.mItemLongClickListener = null;
            this.c.i("Removed %s as OnItemLongClickListener", className);
            for (FlexibleViewHolder flexibleViewHolder2 : getAllBoundViewHolders()) {
                flexibleViewHolder2.getContentView().setOnLongClickListener(null);
            }
        }
        if ((obj instanceof OnItemMoveListener) || obj == OnItemMoveListener.class) {
            this.mItemMoveListener = null;
            this.c.i("Removed %s as OnItemMoveListener", className);
        }
        if ((obj instanceof OnItemSwipeListener) || obj == OnItemSwipeListener.class) {
            this.mItemSwipeListener = null;
            this.c.i("Removed %s as OnItemSwipeListener", className);
        }
        if ((obj instanceof OnDeleteCompleteListener) || obj == OnDeleteCompleteListener.class) {
            this.mDeleteCompleteListener = null;
            this.c.i("Removed %s as OnDeleteCompleteListener", className);
        }
        if ((obj instanceof OnStickyHeaderChangeListener) || obj == OnStickyHeaderChangeListener.class) {
            this.mStickyHeaderChangeListener = null;
            this.c.i("Removed %s as OnStickyHeaderChangeListener", className);
        }
        if ((obj instanceof OnUpdateListener) || obj == OnUpdateListener.class) {
            this.mUpdateListener = null;
            this.c.i("Removed %s as OnUpdateListener", className);
        }
        return this;
    }

    public void removeRange(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        removeRange(i2, i3, Payload.REM_SUB_ITEM);
    }

    public final void removeScrollableFooter(@NonNull T t) {
        if (this.K.remove(t)) {
            this.c.d("Remove scrollable footer %s", LayoutUtils.getClassName(t));
            v(t, true);
        }
    }

    public final void removeScrollableFooterWithDelay(@NonNull T t, @IntRange(from = 0) long j2) {
        this.c.d("Enqueued removing scrollable footer (%sms) %s", Long.valueOf(j2), LayoutUtils.getClassName(t));
        this.mHandler.postDelayed(new i(t), j2);
    }

    public final void removeScrollableHeader(@NonNull T t) {
        if (this.J.remove(t)) {
            this.c.d("Remove scrollable header %s", LayoutUtils.getClassName(t));
            v(t, true);
        }
    }

    public final void removeScrollableHeaderWithDelay(@NonNull T t, @IntRange(from = 0) long j2) {
        this.c.d("Enqueued removing scrollable header (%sms) %s", Long.valueOf(j2), LayoutUtils.getClassName(t));
        this.mHandler.postDelayed(new h(t), j2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter<T extends eu.davidea.flexibleadapter.items.IFlexible> */
    /* JADX WARN: Multi-variable type inference failed */
    public void restoreDeletedItems() {
        this.F = true;
        int itemCount = getItemCount();
        if (getSelectedItemCount() > 0) {
            clearSelection();
        }
        for (int size = this.C.size() - 1; size >= 0; size--) {
            this.I = false;
            FlexibleAdapter<T>.r rVar = this.C.get(size);
            if (rVar.b >= 0) {
                this.c.d("Restore SubItem %s", rVar);
                addSubItem(rVar.a(true), rVar.b, rVar.d, false, Payload.UNDO);
            } else {
                this.c.d("Restore Item %s", rVar);
                addItem(rVar.a(false), rVar.d);
            }
            rVar.d.setHidden(false);
            if (this.G && isHeader(rVar.d)) {
                IHeader iHeader = (IHeader) rVar.d;
                for (ISectionable iSectionable : getSectionItems(iHeader)) {
                    t(iSectionable, iHeader, Payload.LINK);
                }
            }
        }
        if (this.E && !this.C.isEmpty()) {
            if (isExpandable(this.C.get(0).d) || getExpandableOf((FlexibleAdapter<T>) this.C.get(0).d) == null) {
                this.f0 = true;
            } else {
                this.e0 = true;
            }
            for (FlexibleAdapter<T>.r rVar2 : this.C) {
                if (rVar2.d.isSelectable()) {
                    addSelection(getGlobalPositionOf(rVar2.d));
                }
            }
            this.c.d("Selected positions after restore %s", getSelectedPositions());
        }
        this.F = false;
        if (this.mUpdateListener != null && itemCount == 0 && getItemCount() > 0) {
            this.mUpdateListener.onUpdateEmptyView(getMainItemCount());
        }
        emptyBin();
    }

    public final void s() {
        if (this.h0 != null) {
            return;
        }
        if (this.mRecyclerView != null) {
            if (this.g0 == null) {
                this.g0 = new ItemTouchHelperCallback(this);
                this.c.i("Initialized default ItemTouchHelperCallback", new Object[0]);
            }
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(this.g0);
            this.h0 = itemTouchHelper;
            itemTouchHelper.attachToRecyclerView(this.mRecyclerView);
            return;
        }
        throw new IllegalStateException("RecyclerView cannot be null. Enabling LongPressDrag or Swipe must be done after the Adapter is added to the RecyclerView.");
    }

    public void saveUndoPositions(@NonNull List<Integer> list) {
        this.D.addAll(list);
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter
    public void selectAll(Integer... numArr) {
        if (getSelectedItemCount() <= 0 || numArr.length != 0) {
            super.selectAll(numArr);
        } else {
            super.selectAll(Integer.valueOf(getItemViewType(getSelectedPositions().get(0).intValue())));
        }
    }

    public FlexibleAdapter<T> setAnimateToLimit(int i2) {
        this.c.i("Set animateToLimit=%s", Integer.valueOf(i2));
        this.Y = i2;
        return this;
    }

    public FlexibleAdapter<T> setAutoCollapseOnExpand(boolean z2) {
        this.c.i("Set autoCollapseOnExpand=%s", Boolean.valueOf(z2));
        this.c0 = z2;
        return this;
    }

    public FlexibleAdapter<T> setAutoScrollOnExpand(boolean z2) {
        this.c.i("Set setAutoScrollOnExpand=%s", Boolean.valueOf(z2));
        this.b0 = z2;
        return this;
    }

    public FlexibleAdapter<T> setDisplayHeadersAtStartUp(boolean z2) {
        if (!this.L && z2) {
            A(true);
        }
        return this;
    }

    public FlexibleAdapter<T> setEndlessPageSize(@IntRange(from = 0) int i2) {
        this.c.i("Set endlessPageSize=%s", Integer.valueOf(i2));
        this.k0 = i2;
        return this;
    }

    public FlexibleAdapter<T> setEndlessProgressItem(@Nullable T t) {
        this.m0 = t != null;
        if (t != null) {
            setEndlessScrollThreshold(this.i0);
            this.o0 = t;
            this.c.i("Set progressItem=%s", LayoutUtils.getClassName(t));
            this.c.i("Enabled EndlessScrolling", new Object[0]);
        } else {
            this.c.i("Disabled EndlessScrolling", new Object[0]);
        }
        return this;
    }

    public FlexibleAdapter<T> setEndlessScrollListener(@Nullable EndlessScrollListener endlessScrollListener, @NonNull T t) {
        this.c.i("Set endlessScrollListener=%s", LayoutUtils.getClassName(endlessScrollListener));
        this.mEndlessScrollListener = endlessScrollListener;
        return setEndlessProgressItem(t);
    }

    public FlexibleAdapter<T> setEndlessScrollThreshold(@IntRange(from = 1) int i2) {
        if (this.mRecyclerView != null) {
            i2 *= getFlexibleLayoutManager().getSpanCount();
        }
        this.i0 = i2;
        this.c.i("Set endlessScrollThreshold=%s", Integer.valueOf(i2));
        return this;
    }

    public FlexibleAdapter<T> setEndlessTargetCount(@IntRange(from = 0) int i2) {
        this.c.i("Set endlessTargetCount=%s", Integer.valueOf(i2));
        this.j0 = i2;
        return this;
    }

    public final FlexibleAdapter setHandleDragEnabled(boolean z2) {
        s();
        this.c.i("Set handleDragEnabled=%s", Boolean.valueOf(z2));
        this.g0.setHandleDragEnabled(z2);
        return this;
    }

    public final FlexibleAdapter setItemTouchHelperCallback(ItemTouchHelperCallback itemTouchHelperCallback) {
        this.g0 = itemTouchHelperCallback;
        this.h0 = null;
        s();
        this.c.i("Initialized custom ItemTouchHelperCallback", new Object[0]);
        return this;
    }

    public FlexibleAdapter<T> setLoadingMoreAtStartUp(boolean z2) {
        this.c.i("Set loadingAtStartup=%s", Boolean.valueOf(z2));
        if (z2) {
            this.mHandler.post(new m());
        }
        return this;
    }

    public final FlexibleAdapter setLongPressDragEnabled(boolean z2) {
        s();
        this.c.i("Set longPressDragEnabled=%s", Boolean.valueOf(z2));
        this.g0.setLongPressDragEnabled(z2);
        return this;
    }

    public FlexibleAdapter<T> setMinCollapsibleLevel(int i2) {
        this.c.i("Set minCollapsibleLevel=%s", Integer.valueOf(i2));
        this.Z = i2;
        return this;
    }

    public final FlexibleAdapter setNotifyChangeOfUnfilteredItems(boolean z2) {
        this.c.i("Set notifyChangeOfUnfilteredItems=%s", Boolean.valueOf(z2));
        this.V = z2;
        return this;
    }

    public final FlexibleAdapter setNotifyMoveOfFilteredItems(boolean z2) {
        this.c.i("Set notifyMoveOfFilteredItems=%s", Boolean.valueOf(z2));
        this.X = z2;
        return this;
    }

    public FlexibleAdapter<T> setPermanentDelete(boolean z2) {
        this.c.i("Set permanentDelete=%s", Boolean.valueOf(z2));
        this.H = z2;
        return this;
    }

    public FlexibleAdapter<T> setRecursiveCollapse(boolean z2) {
        this.c.i("Set setAutoCollapseSubLevels=%s", Boolean.valueOf(z2));
        this.d0 = z2;
        return this;
    }

    public FlexibleAdapter<T> setRestoreSelectionOnUndo(boolean z2) {
        this.c.i("Set restoreSelectionOnUndo=%s", Boolean.valueOf(z2));
        this.E = z2;
        return this;
    }

    public void setSearchText(@NonNull String str) {
        this.S = str != null ? str.trim().toLowerCase(Locale.getDefault()) : "";
    }

    public FlexibleAdapter<T> setStickyHeaderElevation(@IntRange(from = 0) int i2) {
        this.N = i2;
        return this;
    }

    public FlexibleAdapter<T> setStickyHeaders(boolean z2) {
        return setStickyHeaders(z2, this.P);
    }

    public final FlexibleAdapter setSwipeEnabled(boolean z2) {
        this.c.i("Set swipeEnabled=%s", Boolean.valueOf(z2));
        s();
        this.g0.setSwipeEnabled(z2);
        return this;
    }

    public void setTopEndless(boolean z2) {
        this.n0 = z2;
    }

    public FlexibleAdapter<T> setUnlinkAllItemsOnRemoveHeaders(boolean z2) {
        this.c.i("Set unlinkOnRemoveHeader=%s", Boolean.valueOf(z2));
        this.G = z2;
        return this;
    }

    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.AdapterCallback
    public boolean shouldMove(int i2, int i3) {
        OnItemMoveListener onItemMoveListener;
        T item = getItem(i3);
        return !this.J.contains(item) && !this.K.contains(item) && ((onItemMoveListener = this.mItemMoveListener) == null || onItemMoveListener.shouldMoveItem(i2, i3));
    }

    public FlexibleAdapter<T> showAllHeaders() {
        A(false);
        return this;
    }

    public void swapItems(List<T> list, int i2, int i3) {
        if (i2 >= 0 && i2 < getItemCount() && i3 >= 0 && i3 < getItemCount()) {
            this.c.v("swapItems from=%s [selected? %s] to=%s [selected? %s]", Integer.valueOf(i2), Boolean.valueOf(isSelected(i2)), Integer.valueOf(i3), Boolean.valueOf(isSelected(i3)));
            if (i2 < i3 && isExpandable(getItem(i2)) && isExpanded(i3)) {
                collapse(i3);
            }
            if (i2 < i3) {
                int i4 = i2;
                while (i4 < i3) {
                    int i5 = i4 + 1;
                    this.c.v("swapItems from=%s to=%s", Integer.valueOf(i4), Integer.valueOf(i5));
                    Collections.swap(list, i4, i5);
                    swapSelection(i4, i5);
                    i4 = i5;
                }
            } else {
                for (int i6 = i2; i6 > i3; i6--) {
                    int i7 = i6 - 1;
                    this.c.v("swapItems from=%s to=%s", Integer.valueOf(i6), Integer.valueOf(i7));
                    Collections.swap(list, i6, i7);
                    swapSelection(i6, i7);
                }
            }
            notifyItemMoved(i2, i3);
            if (this.L) {
                T item = getItem(i3);
                T item2 = getItem(i2);
                boolean z2 = item2 instanceof IHeader;
                if (!z2 || !(item instanceof IHeader)) {
                    if (z2) {
                        int i8 = i2 < i3 ? i3 + 1 : i3;
                        if (i2 >= i3) {
                            i3 = i2 + 1;
                        }
                        T item3 = getItem(i8);
                        IHeader sectionHeader = getSectionHeader(i8);
                        Payload payload = Payload.LINK;
                        t(item3, sectionHeader, payload);
                        t(getItem(i3), (IHeader) item2, payload);
                    } else if (item instanceof IHeader) {
                        int i9 = i2 < i3 ? i2 : i2 + 1;
                        if (i2 < i3) {
                            i2 = i3 + 1;
                        }
                        T item4 = getItem(i9);
                        IHeader sectionHeader2 = getSectionHeader(i9);
                        Payload payload2 = Payload.LINK;
                        t(item4, sectionHeader2, payload2);
                        t(getItem(i2), (IHeader) item, payload2);
                    } else {
                        int i10 = i2 < i3 ? i3 : i2;
                        if (i2 >= i3) {
                            i2 = i3;
                        }
                        T item5 = getItem(i10);
                        IHeader headerOf = getHeaderOf(item5);
                        if (headerOf != null) {
                            IHeader sectionHeader3 = getSectionHeader(i10);
                            if (sectionHeader3 != null && !sectionHeader3.equals(headerOf)) {
                                t(item5, sectionHeader3, Payload.LINK);
                            }
                            t(getItem(i2), headerOf, Payload.LINK);
                        }
                    }
                } else if (i2 < i3) {
                    IHeader iHeader = (IHeader) item;
                    for (ISectionable iSectionable : getSectionItems(iHeader)) {
                        t(iSectionable, iHeader, Payload.LINK);
                    }
                } else {
                    IHeader iHeader2 = (IHeader) item2;
                    for (ISectionable iSectionable2 : getSectionItems(iHeader2)) {
                        t(iSectionable2, iHeader2, Payload.LINK);
                    }
                }
            }
        }
    }

    public final void t(T t, IHeader iHeader, @Nullable Object obj) {
        if (t == null || !(t instanceof ISectionable)) {
            notifyItemChanged(getGlobalPositionOf(iHeader), obj);
            return;
        }
        ISectionable iSectionable = (ISectionable) t;
        if (iSectionable.getHeader() != null && !iSectionable.getHeader().equals(iHeader)) {
            Payload payload = Payload.UNLINK;
            if (hasHeader(iSectionable)) {
                IHeader header = iSectionable.getHeader();
                this.c.v("Unlink header %s from %s", header, iSectionable);
                iSectionable.setHeader(null);
                if (payload != null) {
                    if (!header.isHidden()) {
                        notifyItemChanged(getGlobalPositionOf(header), payload);
                    }
                    if (!iSectionable.isHidden()) {
                        notifyItemChanged(getGlobalPositionOf(iSectionable), payload);
                    }
                }
            }
        }
        if (iSectionable.getHeader() == null && iHeader != null) {
            this.c.v("Link header %s to %s", iHeader, iSectionable);
            iSectionable.setHeader(iHeader);
            if (obj != null) {
                if (!iHeader.isHidden()) {
                    notifyItemChanged(getGlobalPositionOf(iHeader), obj);
                }
                if (!t.isHidden()) {
                    notifyItemChanged(getGlobalPositionOf(t), obj);
                }
            }
        }
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter
    public void toggleSelection(@IntRange(from = 0) int i2) {
        T item = getItem(i2);
        if (item != null && item.isSelectable()) {
            IExpandable expandableOf = getExpandableOf((FlexibleAdapter<T>) item);
            boolean z2 = expandableOf != null;
            if ((isExpandable(item) || !z2) && !this.e0) {
                this.f0 = true;
                if (z2) {
                    this.a0 = expandableOf.getExpansionLevel();
                }
                super.toggleSelection(i2);
            } else if (z2 && (this.a0 == -1 || (!this.f0 && expandableOf.getExpansionLevel() + 1 == this.a0))) {
                this.e0 = true;
                this.a0 = expandableOf.getExpansionLevel() + 1;
                super.toggleSelection(i2);
            }
        }
        if (super.getSelectedItemCount() == 0) {
            this.a0 = -1;
            this.e0 = false;
            this.f0 = false;
        }
    }

    public final void u(int i2, List<T> list, boolean z2) {
        int itemCount = getItemCount();
        if (i2 < itemCount) {
            this.u.addAll(i2, list);
        } else {
            this.u.addAll(list);
            i2 = itemCount;
        }
        if (z2) {
            this.c.d("addItems on position=%s itemCount=%s", Integer.valueOf(i2), Integer.valueOf(list.size()));
            notifyItemRangeInserted(i2, list.size());
        }
    }

    @CallSuper
    public void updateDataSet(@Nullable List<T> list) {
        updateDataSet(list, false);
    }

    public void updateItem(@NonNull T t) {
        updateItem(t, null);
    }

    public final void v(T t, boolean z2) {
        boolean z3 = this.H;
        if (z2) {
            this.H = true;
        }
        removeItem(getGlobalPositionOf(t));
        this.H = z3;
    }

    public final void w(List<T> list) {
        z(list);
        IHeader iHeader = null;
        int i2 = 0;
        while (i2 < list.size()) {
            T t = list.get(i2);
            if (isExpanded((FlexibleAdapter<T>) t)) {
                IExpandable iExpandable = (IExpandable) t;
                iExpandable.setExpanded(true);
                List<T> m2 = m(iExpandable, false);
                if (i2 < list.size()) {
                    list.addAll(i2 + 1, m2);
                } else {
                    list.addAll(m2);
                }
            }
            if (!this.L && isHeader(t) && !t.isHidden()) {
                this.L = true;
            }
            IHeader headerOf = getHeaderOf(t);
            if (headerOf != null && !headerOf.equals(iHeader) && !isExpandable(headerOf)) {
                headerOf.setHidden(false);
                list.add(i2, headerOf);
                i2++;
                iHeader = headerOf;
            }
            i2++;
        }
    }

    public final int x(int i2, List<T> list, int i3) {
        int i4 = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            T t = list.get(size);
            if (isExpanded((FlexibleAdapter<T>) t) && ((IExpandable) t).getExpansionLevel() >= i3 && collapse(i2 + size, true) > 0) {
                i4++;
            }
        }
        return i4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter<T extends eu.davidea.flexibleadapter.items.IFlexible> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void y(List<T> list) {
        T headerOf;
        if (list != null) {
            Object obj = null;
            int i2 = 0;
            while (i2 < list.size()) {
                T t = list.get(i2);
                t.setHidden(false);
                if (isExpandable(t)) {
                    IExpandable iExpandable = (IExpandable) t;
                    Set<IExpandable> set = this.U;
                    if (set != null) {
                        iExpandable.setExpanded(set.contains(iExpandable));
                    }
                    if (hasSubItems(iExpandable)) {
                        List<IFlexible> subItems = iExpandable.getSubItems();
                        for (IFlexible iFlexible : subItems) {
                            iFlexible.setHidden(false);
                            if (iFlexible instanceof IExpandable) {
                                IExpandable iExpandable2 = (IExpandable) iFlexible;
                                iExpandable2.setExpanded(false);
                                y(iExpandable2.getSubItems());
                            }
                        }
                        if (iExpandable.isExpanded() && this.w == null) {
                            if (i2 < list.size()) {
                                list.addAll(i2 + 1, subItems);
                            } else {
                                list.addAll(subItems);
                            }
                            i2 += subItems.size();
                        }
                    }
                }
                if (this.L && this.w == null && (headerOf = getHeaderOf(t)) != null && !headerOf.equals(obj) && !isExpandable(headerOf)) {
                    headerOf.setHidden(false);
                    list.add(i2, headerOf);
                    i2++;
                    obj = headerOf;
                }
                i2++;
            }
        }
    }

    public final void z(List<T> list) {
        for (T t : this.J) {
            if (list.size() > 0) {
                list.add(0, t);
            } else {
                list.add(t);
            }
        }
        list.addAll(this.K);
    }

    public FlexibleAdapter(@Nullable List<T> list, @Nullable Object obj) {
        this(list, obj, false);
    }

    public boolean addItem(@IntRange(from = 0) int i2, @NonNull T t) {
        if (t == null) {
            this.c.e("addItem No item to add!", new Object[0]);
            return false;
        }
        this.c.v("addItem delegates addition to addItems!", new Object[0]);
        return addItems(i2, Collections.singletonList(t));
    }

    public int addSection(@NonNull IHeader iHeader, @Nullable Comparator<IFlexible> comparator) {
        int calculatePositionFor = calculatePositionFor(iHeader, comparator);
        addItem(calculatePositionFor, iHeader);
        return calculatePositionFor;
    }

    public boolean addSubItem(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @NonNull T t, boolean z2, @Nullable Object obj) {
        if (t != null) {
            return addSubItems(i2, i3, Collections.singletonList(t), z2, obj);
        }
        this.c.e("addSubItem No items to add!", new Object[0]);
        return false;
    }

    public boolean addSubItems(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @NonNull List<T> list, boolean z2, @Nullable Object obj) {
        T item = getItem(i2);
        boolean z3 = false;
        if (isExpandable(item)) {
            IExpandable iExpandable = (IExpandable) item;
            if (z2 && !iExpandable.isExpanded()) {
                expand(i2);
            }
            if (iExpandable.isExpanded()) {
                z3 = addItems(o(iExpandable, i3) + i2 + 1, list);
            }
            if (obj != null && !isHeader(iExpandable)) {
                notifyItemChanged(i2, obj);
            }
            return z3;
        }
        this.c.e("addSubItems Provided parentPosition doesn't belong to an Expandable item!", new Object[0]);
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: eu.davidea.flexibleadapter.FlexibleAdapter<T extends eu.davidea.flexibleadapter.items.IFlexible> */
    /* JADX WARN: Multi-variable type inference failed */
    public int collapse(@IntRange(from = 0) int i2, boolean z2) {
        IFlexible item = getItem(i2);
        if (!isExpandable(item)) {
            return 0;
        }
        IExpandable iExpandable = (IExpandable) item;
        List m2 = m(iExpandable, true);
        ArrayList arrayList = (ArrayList) m2;
        int size = arrayList.size();
        this.c.v("Request to Collapse on position=%s expanded=%s hasSubItemsSelected=%s", Integer.valueOf(i2), Boolean.valueOf(iExpandable.isExpanded()), Boolean.valueOf(p(i2, m2)));
        if (iExpandable.isExpanded() && size > 0 && (!p(i2, m2) || n(item) != null)) {
            if (this.d0) {
                x(i2 + 1, m2, iExpandable.getExpansionLevel());
            }
            this.u.removeAll(m2);
            size = arrayList.size();
            iExpandable.setExpanded(false);
            if (z2) {
                notifyItemChanged(i2, Payload.COLLAPSED);
            }
            notifyItemRangeRemoved(i2 + 1, size);
            if (this.L && !isHeader(item)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IHeader headerOf = getHeaderOf((IFlexible) it.next());
                    if (headerOf != null && !headerOf.isHidden()) {
                        q(getGlobalPositionOf(headerOf), headerOf);
                    }
                }
            }
            if (!h(this.J, iExpandable)) {
                h(this.K, iExpandable);
            }
            this.c.v("Collapsed %s subItems on position %s", Integer.valueOf(size), Integer.valueOf(i2));
        }
        return size;
    }

    public int collapseAll(int i2) {
        return x(0, this.u, i2);
    }

    public int expand(@IntRange(from = 0) int i2, boolean z2) {
        return j(i2, false, false, z2);
    }

    public int expandAll(int i2) {
        int max = Math.max(0, this.J.size() - 1);
        int i3 = 0;
        while (max < getItemCount() - this.K.size()) {
            T item = getItem(max);
            if (isExpandable(item)) {
                IExpandable iExpandable = (IExpandable) item;
                if (iExpandable.getExpansionLevel() <= i2 && j(max, true, false, true) > 0) {
                    max += iExpandable.getSubItems().size();
                    i3++;
                }
            }
            max++;
        }
        return i3;
    }

    @Nullable
    public IExpandable getExpandableOf(T t) {
        for (T t2 : this.u) {
            if (isExpandable(t2)) {
                IExpandable iExpandable = (IExpandable) t2;
                if (iExpandable.isExpanded() && hasSubItems(iExpandable)) {
                    for (IFlexible iFlexible : iExpandable.getSubItems()) {
                        if (!iFlexible.isHidden() && iFlexible.equals(t)) {
                            return iExpandable;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public boolean isExpanded(@Nullable T t) {
        return isExpandable(t) && ((IExpandable) t).isExpanded();
    }

    public void moveItem(int i2, int i3, @Nullable Object obj) {
        this.c.v("moveItem fromPosition=%s toPosition=%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (isSelected(i2)) {
            removeSelection(i2);
            addSelection(i3);
        }
        T item = getItem(i2);
        boolean isExpanded = isExpanded((FlexibleAdapter<T>) item);
        if (isExpanded) {
            collapse(i3);
        }
        this.u.remove(i2);
        u(i3, Collections.singletonList(item), false);
        notifyItemMoved(i2, i3);
        if (obj != null) {
            notifyItemChanged(i3, obj);
        }
        if (this.L) {
            C(i3, item, false);
        }
        if (isExpanded) {
            expand(i3);
        }
    }

    @Override // eu.davidea.flexibleadapter.SelectableAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List list) {
        String str;
        if (hasStableIds()) {
            StringBuilder L2 = a2.b.a.a.a.L(" itemId=");
            L2.append(viewHolder.getItemId());
            str = L2.toString();
        } else {
            str = "";
        }
        this.c.v("onViewBound    Holder=%s position=%s%s", LayoutUtils.getClassName(viewHolder), Integer.valueOf(i2), str);
        if (this.R) {
            super.onBindViewHolder(viewHolder, i2, list);
            T item = getItem(i2);
            if (item != null) {
                viewHolder.itemView.setEnabled(item.isEnabled());
                item.bindViewHolder(this, viewHolder, i2, list);
                if (areHeadersSticky() && !this.isFastScroll && this.O.getStickyPosition() >= 0 && list.isEmpty() && getFlexibleLayoutManager().findFirstVisibleItemPosition() - 1 == i2 && isHeader(item)) {
                    viewHolder.itemView.setVisibility(4);
                }
            }
            onLoadMore(i2);
            animateView(viewHolder, i2);
            return;
        }
        throw new IllegalStateException("AutoMap is not active, this method cannot be called. You should implement the AutoMap properly.");
    }

    public void onLoadMoreComplete(@Nullable List<T> list, @IntRange(from = -1) long j2) {
        int i2;
        int size = list == null ? 0 : list.size();
        int mainItemCount = getMainItemCount() + size;
        int i3 = this.k0;
        if ((i3 > 0 && size < i3) || ((i2 = this.j0) > 0 && mainItemCount >= i2)) {
            setEndlessProgressItem(null);
        }
        if (j2 <= 0 || (size != 0 && isEndlessScrollEnabled())) {
            r();
        } else {
            this.c.v("onLoadMore     enqueued removing progressItem (%sms)", Long.valueOf(j2));
            this.mHandler.sendEmptyMessageDelayed(8, j2);
        }
        if (size > 0) {
            this.c.v("onLoadMore     performing adding %s new items on page=%s", Integer.valueOf(size), Integer.valueOf(getEndlessCurrentPage()));
            addItems(this.n0 ? this.J.size() : getGlobalPositionOf(this.o0), list);
        }
        this.l0 = false;
        if (size == 0 || !isEndlessScrollEnabled()) {
            this.c.i("noMoreLoad!", new Object[0]);
            int globalPositionOf = getGlobalPositionOf(this.o0);
            if (globalPositionOf >= 0) {
                notifyItemChanged(globalPositionOf, Payload.NO_MORE_LOAD);
            }
            EndlessScrollListener endlessScrollListener = this.mEndlessScrollListener;
            if (endlessScrollListener != null) {
                endlessScrollListener.noMoreLoad(size);
            }
        }
    }

    public void removeAllSelectedItems(@Nullable Object obj) {
        removeItems(getSelectedPositions(), obj);
    }

    public void removeItem(@IntRange(from = 0) int i2, @Nullable Object obj) {
        collapse(i2);
        this.c.v("removeItem delegates removal to removeRange", new Object[0]);
        removeRange(i2, 1, obj);
    }

    public void removeItems(@Nullable List<Integer> list, @Nullable Object obj) {
        this.c.v("removeItems selectedPositions=%s payload=%s", list, obj);
        if (!(list == null || list.isEmpty())) {
            Collections.sort(list, new c(this));
            this.c.v("removeItems after reverse sort selectedPositions=%s", list);
            int intValue = list.get(0).intValue();
            this.F = true;
            int i2 = 0;
            int i3 = 0;
            for (Integer num : list) {
                if (intValue - i2 == num.intValue()) {
                    i2++;
                    i3 = num.intValue();
                } else {
                    if (i2 > 0) {
                        removeRange(i3, i2, obj);
                    }
                    intValue = num.intValue();
                    i3 = intValue;
                    i2 = 1;
                }
                collapse(num.intValue());
            }
            this.F = false;
            if (i2 > 0) {
                removeRange(i3, i2, obj);
            }
        }
    }

    public void removeRange(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @Nullable Object obj) {
        int i4;
        IExpandable expandableOf;
        int itemCount = getItemCount();
        this.c.d("removeRange positionStart=%s itemCount=%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 < 0 || (i4 = i2 + i3) > itemCount) {
            this.c.e("Cannot removeRange with positionStart OutOfBounds!", new Object[0]);
        } else if (i3 == 0 || itemCount == 0) {
            this.c.w("removeRange Nothing to delete!", new Object[0]);
        } else {
            T t = null;
            IExpandable iExpandable = null;
            for (int i5 = i2; i5 < i4; i5++) {
                t = getItem(i2);
                if (t != null) {
                    if (!this.H) {
                        if (iExpandable == null) {
                            iExpandable = getExpandableOf((FlexibleAdapter<T>) t);
                        }
                        if (iExpandable == null) {
                            if (isExpanded((FlexibleAdapter<T>) t)) {
                                collapse(i2);
                            }
                            T item = getItem(i2 - 1);
                            if (!(item == null || (expandableOf = getExpandableOf((FlexibleAdapter<T>) item)) == null)) {
                                item = expandableOf;
                            }
                            this.C.add(new r(item, t, -1));
                            this.c.v("Recycled Item %s on position=%s", a2.b.a.a.a.j2(this.C, 1), Integer.valueOf(i2));
                        } else {
                            this.C.add(new r(iExpandable, t, ((ArrayList) m(iExpandable, false)).indexOf(t)));
                            this.c.v("Recycled SubItem %s with Parent position=%s", a2.b.a.a.a.j2(this.C, 1), Integer.valueOf(getGlobalPositionOf(iExpandable)));
                        }
                    }
                    t.setHidden(true);
                    if (this.G && isHeader(t)) {
                        for (ISectionable iSectionable : getSectionItems((IHeader) t)) {
                            iSectionable.setHeader(null);
                            if (obj != null) {
                                notifyItemChanged(getGlobalPositionOf(iSectionable), Payload.UNLINK);
                            }
                        }
                    }
                    this.u.remove(i2);
                    removeSelection(i5);
                }
            }
            notifyItemRangeRemoved(i2, i3);
            int globalPositionOf = getGlobalPositionOf(getHeaderOf(t));
            if (globalPositionOf >= 0) {
                notifyItemChanged(globalPositionOf, obj);
            }
            int globalPositionOf2 = getGlobalPositionOf(iExpandable);
            if (globalPositionOf2 >= 0 && globalPositionOf2 != globalPositionOf) {
                notifyItemChanged(globalPositionOf2, obj);
            }
            if (this.mUpdateListener != null && !this.F && itemCount > 0 && getItemCount() == 0) {
                this.mUpdateListener.onUpdateEmptyView(getMainItemCount());
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0014: APUT  (r1v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r2v1 java.lang.String) */
    public FlexibleAdapter<T> setStickyHeaders(boolean z2, @Nullable ViewGroup viewGroup) {
        Logger logger = this.c;
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z2);
        objArr[1] = viewGroup != null ? " with user defined Sticky Container" : "";
        logger.i("Set stickyHeaders=%s (in Post!)%s", objArr);
        this.P = viewGroup;
        this.mHandler.post(new j(z2));
        return this;
    }

    @CallSuper
    public void updateDataSet(@Nullable List<T> list, boolean z2) {
        this.w = null;
        if (list == null) {
            list = new ArrayList<>();
        }
        if (z2) {
            this.mHandler.removeMessages(1);
            Handler handler = this.mHandler;
            handler.sendMessage(Message.obtain(handler, 1, list));
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        w(arrayList);
        this.u = arrayList;
        this.c.w("updateDataSet with notifyDataSetChanged!", new Object[0]);
        notifyDataSetChanged();
        onPostUpdate();
    }

    public void updateItem(@NonNull T t, @Nullable Object obj) {
        updateItem(getGlobalPositionOf(t), t, obj);
    }

    public static class q {
        public int a;
        public int b;
        public int c;

        public q(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        public String toString() {
            String str;
            StringBuilder L = a2.b.a.a.a.L("Notification{operation=");
            L.append(this.c);
            if (this.c == 4) {
                StringBuilder L2 = a2.b.a.a.a.L(", fromPosition=");
                L2.append(this.a);
                str = L2.toString();
            } else {
                str = "";
            }
            L.append(str);
            L.append(", position=");
            return a2.b.a.a.a.i(L, this.b, '}');
        }

        public q(int i, int i2, int i3) {
            this.b = i2;
            this.c = i3;
            this.a = i;
        }
    }

    public FlexibleAdapter(@Nullable List<T> list, @Nullable Object obj, boolean z2) {
        super(z2);
        this.UPDATE = 1;
        this.FILTER = 2;
        this.LOAD_MORE_COMPLETE = 8;
        this.mHandler = new Handler(Looper.getMainLooper(), new HandlerCallback());
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.L = false;
        this.M = false;
        this.Q = new HashMap<>();
        this.R = false;
        this.S = "";
        this.T = "";
        this.V = true;
        this.W = false;
        this.X = false;
        this.Y = v0;
        this.Z = 0;
        this.a0 = -1;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.f0 = false;
        this.i0 = 1;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = false;
        this.m0 = false;
        this.n0 = false;
        if (list == null) {
            this.u = new ArrayList();
        } else {
            this.u = new ArrayList(list);
        }
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.C = new ArrayList();
        this.D = new ArrayList();
        addListener(obj);
        registerAdapterDataObserver(new o(null));
    }

    public int expand(T t) {
        return j(getGlobalPositionOf(t), false, false, true);
    }

    public void filterItems(@IntRange(from = 0) long j2) {
        if (this.w == null) {
            this.w = this.u;
        }
        filterItems(this.w, j2);
    }

    public final boolean isScrollableHeaderOrFooter(T t) {
        return (t != null && this.J.contains(t)) || this.K.contains(t);
    }

    public void updateItem(@IntRange(from = 0) int i2, @NonNull T t, @Nullable Object obj) {
        if (t == null) {
            this.c.e("updateItem No Item to update!", new Object[0]);
            return;
        }
        int itemCount = getItemCount();
        if (i2 < 0 || i2 >= itemCount) {
            this.c.e("Cannot updateItem on position out of OutOfBounds!", new Object[0]);
            return;
        }
        this.u.set(i2, t);
        this.c.d(a2.b.a.a.a.M2("updateItem notifyItemChanged on position ", i2), new Object[0]);
        notifyItemChanged(i2, obj);
    }

    public int expand(T t, boolean z2) {
        return j(getGlobalPositionOf(t), false, z2, false);
    }

    public void filterItems(@NonNull List<T> list, @IntRange(from = 0) long j2) {
        this.mHandler.removeMessages(2);
        Handler handler = this.mHandler;
        Message obtain = Message.obtain(handler, 2, list);
        if (j2 <= 0) {
            j2 = 0;
        }
        handler.sendMessageDelayed(obtain, j2);
    }

    public void filterItems(@NonNull List<T> list) {
        this.mHandler.removeMessages(2);
        Handler handler = this.mHandler;
        handler.sendMessage(Message.obtain(handler, 2, list));
    }

    public int addItemToSection(@NonNull ISectionable iSectionable, @Nullable IHeader iHeader, @IntRange(from = 0) int i2) {
        this.c.d("addItemToSection relativePosition=%s", Integer.valueOf(i2));
        int globalPositionOf = getGlobalPositionOf(iHeader);
        if (i2 >= 0) {
            iSectionable.setHeader(iHeader);
            if (globalPositionOf < 0 || !isExpandable(iHeader)) {
                addItem(globalPositionOf + 1 + i2, iSectionable);
            } else {
                addSubItem(globalPositionOf, i2, iSectionable, false, Payload.ADD_SUB_ITEM);
            }
        }
        return getGlobalPositionOf(iSectionable);
    }
}
