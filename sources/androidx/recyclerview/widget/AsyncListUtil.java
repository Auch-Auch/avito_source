package androidx.recyclerview.widget;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.TileList;
import l6.v.a.m;
import l6.v.a.n;
import l6.v.a.o;
public class AsyncListUtil<T> {
    public final Class<T> a;
    public final int b;
    public final DataCallback<T> c;
    public final ViewCallback d;
    public final TileList<T> e;
    public final ThreadUtil$MainThreadCallback<T> f;
    public final ThreadUtil$BackgroundCallback<T> g;
    public final int[] h = new int[2];
    public final int[] i = new int[2];
    public final int[] j = new int[2];
    public boolean k;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public final SparseIntArray p = new SparseIntArray();
    public final ThreadUtil$MainThreadCallback<T> q;
    public final ThreadUtil$BackgroundCallback<T> r;

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i, int i2);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            int i4 = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = i4 + i2;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i);
    }

    public class a implements ThreadUtil$MainThreadCallback<T> {
        public a() {
        }

        @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            TileList.Tile<T> tile2;
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            int i2 = 0;
            if (!(i == asyncListUtil.o)) {
                asyncListUtil.g.recycleTile(tile);
                return;
            }
            TileList<T> tileList = asyncListUtil.e;
            int indexOfKey = tileList.b.indexOfKey(tile.mStartPosition);
            if (indexOfKey < 0) {
                tileList.b.put(tile.mStartPosition, tile);
                tile2 = null;
            } else {
                TileList.Tile<T> valueAt = tileList.b.valueAt(indexOfKey);
                tileList.b.setValueAt(indexOfKey, tile);
                if (tileList.c == valueAt) {
                    tileList.c = tile;
                }
                tile2 = valueAt;
            }
            if (tile2 != null) {
                AsyncListUtil.this.g.recycleTile(tile2);
            }
            int i3 = tile.mStartPosition + tile.mItemCount;
            while (i2 < AsyncListUtil.this.p.size()) {
                int keyAt = AsyncListUtil.this.p.keyAt(i2);
                if (tile.mStartPosition > keyAt || keyAt >= i3) {
                    i2++;
                } else {
                    AsyncListUtil.this.p.removeAt(i2);
                    AsyncListUtil.this.d.onItemLoaded(keyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
        public void removeTile(int i, int i2) {
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            if (i == asyncListUtil.o) {
                TileList<T> tileList = asyncListUtil.e;
                TileList.Tile<T> tile = tileList.b.get(i2);
                if (tileList.c == tile) {
                    tileList.c = null;
                }
                tileList.b.delete(i2);
                if (tile != null) {
                    AsyncListUtil.this.g.recycleTile(tile);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
        public void updateItemCount(int i, int i2) {
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            if (i == asyncListUtil.o) {
                asyncListUtil.m = i2;
                asyncListUtil.d.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.n = asyncListUtil2.o;
                for (int i3 = 0; i3 < AsyncListUtil.this.e.b.size(); i3++) {
                    AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                    asyncListUtil3.g.recycleTile(asyncListUtil3.e.b.valueAt(i3));
                }
                AsyncListUtil.this.e.b.clear();
                AsyncListUtil asyncListUtil4 = AsyncListUtil.this;
                asyncListUtil4.k = false;
                asyncListUtil4.a();
            }
        }
    }

    public class b implements ThreadUtil$BackgroundCallback<T> {
        public TileList.Tile<T> a;
        public final SparseBooleanArray b = new SparseBooleanArray();
        public int c;
        public int d;
        public int e;
        public int f;

        public b() {
        }

        public final void a(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.g.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.b;
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
        public void loadTile(int i, int i2) {
            if (!this.b.get(i)) {
                TileList.Tile<T> tile = this.a;
                if (tile != null) {
                    this.a = tile.a;
                } else {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    tile = new TileList.Tile<>(asyncListUtil.a, asyncListUtil.b);
                }
                tile.mStartPosition = i;
                int min = Math.min(AsyncListUtil.this.b, this.d - i);
                tile.mItemCount = min;
                AsyncListUtil.this.c.fillData(tile.mItems, tile.mStartPosition, min);
                int maxCachedTiles = AsyncListUtil.this.c.getMaxCachedTiles();
                while (this.b.size() >= maxCachedTiles) {
                    int keyAt = this.b.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.b;
                    int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i3 = this.e - keyAt;
                    int i4 = keyAt2 - this.f;
                    if (i3 <= 0 || (i3 < i4 && i2 != 2)) {
                        if (i4 <= 0 || (i3 >= i4 && i2 != 1)) {
                            break;
                        }
                        this.b.delete(keyAt2);
                        AsyncListUtil.this.f.removeTile(this.c, keyAt2);
                    } else {
                        this.b.delete(keyAt);
                        AsyncListUtil.this.f.removeTile(this.c, keyAt);
                    }
                }
                this.b.put(tile.mStartPosition, true);
                AsyncListUtil.this.f.addTile(this.c, tile);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.c.recycleData(tile.mItems, tile.mItemCount);
            tile.a = this.a;
            this.a = tile;
        }

        @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
        public void refresh(int i) {
            this.c = i;
            this.b.clear();
            int refreshData = AsyncListUtil.this.c.refreshData();
            this.d = refreshData;
            AsyncListUtil.this.f.updateItemCount(this.c, refreshData);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i <= i2) {
                int i6 = AsyncListUtil.this.b;
                int i7 = i - (i % i6);
                int i8 = i2 - (i2 % i6);
                int i9 = i3 - (i3 % i6);
                this.e = i9;
                int i10 = i4 - (i4 % i6);
                this.f = i10;
                if (i5 == 1) {
                    a(i9, i8, i5, true);
                    a(i8 + AsyncListUtil.this.b, this.f, i5, false);
                    return;
                }
                a(i7, i10, i5, false);
                a(this.e, i7 - AsyncListUtil.this.b, i5, true);
            }
        }
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i2, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        a aVar = new a();
        this.q = aVar;
        b bVar = new b();
        this.r = bVar;
        this.a = cls;
        this.b = i2;
        this.c = dataCallback;
        this.d = viewCallback;
        this.e = new TileList<>(i2);
        o oVar = new o();
        this.f = new m(oVar, aVar);
        this.g = new n(oVar, bVar);
        refresh();
    }

    public void a() {
        this.d.getItemRangeInto(this.h);
        int[] iArr = this.h;
        if (iArr[0] <= iArr[1] && iArr[0] >= 0 && iArr[1] < this.m) {
            if (!this.k) {
                this.l = 0;
            } else {
                int i2 = iArr[0];
                int[] iArr2 = this.i;
                if (i2 > iArr2[1] || iArr2[0] > iArr[1]) {
                    this.l = 0;
                } else if (iArr[0] < iArr2[0]) {
                    this.l = 1;
                } else if (iArr[0] > iArr2[0]) {
                    this.l = 2;
                }
            }
            int[] iArr3 = this.i;
            iArr3[0] = iArr[0];
            iArr3[1] = iArr[1];
            this.d.extendRangeInto(iArr, this.j, this.l);
            int[] iArr4 = this.j;
            iArr4[0] = Math.min(this.h[0], Math.max(iArr4[0], 0));
            int[] iArr5 = this.j;
            iArr5[1] = Math.max(this.h[1], Math.min(iArr5[1], this.m - 1));
            ThreadUtil$BackgroundCallback<T> threadUtil$BackgroundCallback = this.g;
            int[] iArr6 = this.h;
            int i3 = iArr6[0];
            int i4 = iArr6[1];
            int[] iArr7 = this.j;
            threadUtil$BackgroundCallback.updateRange(i3, i4, iArr7[0], iArr7[1], this.l);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if ((r4 <= r6 && r6 < r4 + r1.mItemCount) == false) goto L_0x001c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T getItem(int r6) {
        /*
            r5 = this;
            if (r6 < 0) goto L_0x0052
            int r0 = r5.m
            if (r6 >= r0) goto L_0x0052
            androidx.recyclerview.widget.TileList<T> r0 = r5.e
            androidx.recyclerview.widget.TileList$Tile<T> r1 = r0.c
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001c
            int r4 = r1.mStartPosition
            if (r4 > r6) goto L_0x0019
            int r1 = r1.mItemCount
            int r4 = r4 + r1
            if (r6 >= r4) goto L_0x0019
            r1 = 1
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            if (r1 != 0) goto L_0x0036
        L_0x001c:
            int r1 = r0.a
            int r1 = r6 % r1
            int r1 = r6 - r1
            android.util.SparseArray<androidx.recyclerview.widget.TileList$Tile<T>> r4 = r0.b
            int r1 = r4.indexOfKey(r1)
            if (r1 >= 0) goto L_0x002c
            r0 = 0
            goto L_0x0040
        L_0x002c:
            android.util.SparseArray<androidx.recyclerview.widget.TileList$Tile<T>> r4 = r0.b
            java.lang.Object r1 = r4.valueAt(r1)
            androidx.recyclerview.widget.TileList$Tile r1 = (androidx.recyclerview.widget.TileList.Tile) r1
            r0.c = r1
        L_0x0036:
            androidx.recyclerview.widget.TileList$Tile<T> r0 = r0.c
            T[] r1 = r0.mItems
            int r0 = r0.mStartPosition
            int r0 = r6 - r0
            r0 = r1[r0]
        L_0x0040:
            if (r0 != 0) goto L_0x0051
            int r1 = r5.o
            int r4 = r5.n
            if (r1 == r4) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r2 = 0
        L_0x004a:
            if (r2 != 0) goto L_0x0051
            android.util.SparseIntArray r1 = r5.p
            r1.put(r6, r3)
        L_0x0051:
            return r0
        L_0x0052:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r6 = " is not within 0 and "
            r1.append(r6)
            int r6 = r5.m
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AsyncListUtil.getItem(int):java.lang.Object");
    }

    public int getItemCount() {
        return this.m;
    }

    public void onRangeChanged() {
        if (!(this.o != this.n)) {
            a();
            this.k = true;
        }
    }

    public void refresh() {
        this.p.clear();
        ThreadUtil$BackgroundCallback<T> threadUtil$BackgroundCallback = this.g;
        int i2 = this.o + 1;
        this.o = i2;
        threadUtil$BackgroundCallback.refresh(i2);
    }
}
