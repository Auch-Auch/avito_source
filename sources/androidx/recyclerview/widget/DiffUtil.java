package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class DiffUtil {
    public static final Comparator<d> a = new a();

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        @Nullable
        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        public static final int NO_POSITION = -1;
        public final List<d> a;
        public final int[] b;
        public final int[] c;
        public final Callback d;
        public final int e;
        public final int f;
        public final boolean g;

        public DiffResult(Callback callback, List<d> list, int[] iArr, int[] iArr2, boolean z) {
            this.a = list;
            this.b = iArr;
            this.c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.d = callback;
            int oldListSize = callback.getOldListSize();
            this.e = oldListSize;
            int newListSize = callback.getNewListSize();
            this.f = newListSize;
            this.g = z;
            d dVar = list.isEmpty() ? null : list.get(0);
            if (!(dVar != null && dVar.a == 0 && dVar.b == 0)) {
                d dVar2 = new d();
                dVar2.a = 0;
                dVar2.b = 0;
                dVar2.d = false;
                dVar2.c = 0;
                dVar2.e = false;
                list.add(0, dVar2);
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                d dVar3 = this.a.get(size);
                int i = dVar3.a;
                int i2 = dVar3.c;
                int i3 = i + i2;
                int i4 = dVar3.b + i2;
                if (this.g) {
                    while (oldListSize > i3) {
                        int i5 = oldListSize - 1;
                        if (this.b[i5] == 0) {
                            a(oldListSize, newListSize, size, false);
                        }
                        oldListSize = i5;
                    }
                    while (newListSize > i4) {
                        int i6 = newListSize - 1;
                        if (this.c[i6] == 0) {
                            a(oldListSize, newListSize, size, true);
                        }
                        newListSize = i6;
                    }
                }
                for (int i7 = 0; i7 < dVar3.c; i7++) {
                    int i8 = dVar3.a + i7;
                    int i9 = dVar3.b + i7;
                    int i10 = this.d.areContentsTheSame(i8, i9) ? 1 : 2;
                    this.b[i8] = (i9 << 5) | i10;
                    this.c[i9] = (i8 << 5) | i10;
                }
                oldListSize = dVar3.a;
                newListSize = dVar3.b;
            }
        }

        public static b b(List<b> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                b bVar = list.get(size);
                if (bVar.a == i && bVar.c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).b += z ? 1 : -1;
                        size++;
                    }
                    return bVar;
                }
                size--;
            }
            return null;
        }

        public final boolean a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i2--;
                i4 = i;
                i5 = i2;
            } else {
                i5 = i - 1;
                i4 = i5;
            }
            while (i3 >= 0) {
                d dVar = this.a.get(i3);
                int i6 = dVar.a;
                int i7 = dVar.c;
                int i8 = i6 + i7;
                int i9 = dVar.b + i7;
                int i10 = 8;
                if (z) {
                    for (int i11 = i4 - 1; i11 >= i8; i11--) {
                        if (this.d.areItemsTheSame(i11, i5)) {
                            if (!this.d.areContentsTheSame(i11, i5)) {
                                i10 = 4;
                            }
                            this.c[i5] = (i11 << 5) | 16;
                            this.b[i11] = (i5 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i12 = i2 - 1; i12 >= i9; i12--) {
                        if (this.d.areItemsTheSame(i5, i12)) {
                            if (!this.d.areContentsTheSame(i5, i12)) {
                                i10 = 4;
                            }
                            int i13 = i - 1;
                            this.b[i13] = (i12 << 5) | 16;
                            this.c[i12] = (i13 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                }
                i4 = dVar.a;
                i2 = dVar.b;
                i3--;
            }
            return false;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i) {
            if (i < 0 || i >= this.f) {
                StringBuilder M = a2.b.a.a.a.M("Index out of bounds - passed position = ", i, ", new list size = ");
                M.append(this.f);
                throw new IndexOutOfBoundsException(M.toString());
            }
            int i2 = this.c[i];
            if ((i2 & 31) == 0) {
                return -1;
            }
            return i2 >> 5;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i) {
            if (i < 0 || i >= this.e) {
                StringBuilder M = a2.b.a.a.a.M("Index out of bounds - passed position = ", i, ", old list size = ");
                M.append(this.e);
                throw new IndexOutOfBoundsException(M.toString());
            }
            int i2 = this.b[i];
            if ((i2 & 31) == 0) {
                return -1;
            }
            return i2 >> 5;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i;
            d dVar;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i2 = this.e;
            int i3 = this.f;
            int size = this.a.size() - 1;
            while (size >= 0) {
                d dVar2 = this.a.get(size);
                int i4 = dVar2.c;
                int i5 = dVar2.a + i4;
                int i6 = dVar2.b + i4;
                int i7 = 4;
                if (i5 < i2) {
                    int i8 = i2 - i5;
                    if (!this.g) {
                        batchingListUpdateCallback.onRemoved(i5, i8);
                    } else {
                        int i9 = i8 - 1;
                        while (i9 >= 0) {
                            int[] iArr = this.b;
                            int i10 = i5 + i9;
                            int i11 = iArr[i10] & 31;
                            if (i11 == 0) {
                                i = size;
                                dVar = dVar2;
                                int i12 = 1;
                                batchingListUpdateCallback.onRemoved(i10, 1);
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((b) it.next()).b -= i12;
                                    i12 = 1;
                                }
                            } else if (i11 == i7 || i11 == 8) {
                                int i13 = iArr[i10] >> 5;
                                b b2 = b(arrayList, i13, false);
                                i = size;
                                dVar = dVar2;
                                batchingListUpdateCallback.onMoved(i10, b2.b - 1);
                                if (i11 == 4) {
                                    batchingListUpdateCallback.onChanged(b2.b - 1, 1, this.d.getChangePayload(i10, i13));
                                }
                            } else if (i11 == 16) {
                                arrayList.add(new b(i10, i10, true));
                                i = size;
                                dVar = dVar2;
                            } else {
                                StringBuilder M = a2.b.a.a.a.M("unknown flag for pos ", i10, " ");
                                M.append(Long.toBinaryString((long) i11));
                                throw new IllegalStateException(M.toString());
                            }
                            i9--;
                            i7 = 4;
                            size = i;
                            dVar2 = dVar;
                        }
                    }
                }
                d dVar3 = dVar2;
                if (i6 < i3) {
                    int i14 = i3 - i6;
                    if (this.g) {
                        while (true) {
                            i14--;
                            if (i14 < 0) {
                                break;
                            }
                            int[] iArr2 = this.c;
                            int i15 = i6 + i14;
                            int i16 = iArr2[i15] & 31;
                            if (i16 == 0) {
                                int i17 = 1;
                                batchingListUpdateCallback.onInserted(i5, 1);
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    ((b) it2.next()).b += i17;
                                    i17 = 1;
                                }
                            } else if (i16 == 4 || i16 == 8) {
                                int i18 = iArr2[i15] >> 5;
                                batchingListUpdateCallback.onMoved(b(arrayList, i18, true).b, i5);
                                if (i16 == 4) {
                                    batchingListUpdateCallback.onChanged(i5, 1, this.d.getChangePayload(i18, i15));
                                }
                            } else if (i16 == 16) {
                                arrayList.add(new b(i15, i5, false));
                            } else {
                                StringBuilder M2 = a2.b.a.a.a.M("unknown flag for pos ", i15, " ");
                                M2.append(Long.toBinaryString((long) i16));
                                throw new IllegalStateException(M2.toString());
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i5, i14);
                    }
                }
                int i19 = i4 - 1;
                while (i19 >= 0) {
                    int[] iArr3 = this.b;
                    int i20 = dVar3.a;
                    if ((iArr3[i20 + i19] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i20 + i19, 1, this.d.getChangePayload(i20 + i19, dVar3.b + i19));
                    }
                    i19--;
                    dVar3 = dVar3;
                }
                i2 = dVar3.a;
                i3 = dVar3.b;
                size--;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t, @NonNull T t2);

        public abstract boolean areItemsTheSame(@NonNull T t, @NonNull T t2);

        @Nullable
        public Object getChangePayload(@NonNull T t, @NonNull T t2) {
            return null;
        }
    }

    public static class a implements Comparator<d> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            d dVar3 = dVar;
            d dVar4 = dVar2;
            int i = dVar3.a - dVar4.a;
            return i == 0 ? dVar3.b - dVar4.b : i;
        }
    }

    public static class b {
        public int a;
        public int b;
        public boolean c;

        public b(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    public static class c {
        public int a;
        public int b;
        public int c;
        public int d;

        public c() {
        }

        public c(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public static class d {
        public int a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0090, code lost:
        if (r5[r20 - 1] < r5[r20 + 1]) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0117, code lost:
        r22 = r2;
        r20 = r3;
        r21 = r8;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0123, code lost:
        if (r2 > r9) goto L_0x01a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0125, code lost:
        r8 = r2 + r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0129, code lost:
        if (r8 == (r9 + r14)) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012d, code lost:
        if (r8 == (r6 + r14)) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012f, code lost:
        r11 = r0 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x013b, code lost:
        if (r7[r11 - 1] >= r7[r11 + 1]) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0140, code lost:
        r11 = r7[(r0 + r8) + 1] - 1;
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x014c, code lost:
        r11 = r7[(r0 + r8) - 1];
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0153, code lost:
        r15 = r11 - r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0155, code lost:
        if (r11 <= 0) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0157, code lost:
        if (r15 <= 0) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0159, code lost:
        r25 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0167, code lost:
        if (r27.areItemsTheSame((r10 + r11) - 1, (r12 + r15) - 1) == false) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0169, code lost:
        r11 = r11 - 1;
        r15 = r15 - 1;
        r10 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0171, code lost:
        r25 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0173, code lost:
        r3 = r0 + r8;
        r7[r3] = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0177, code lost:
        if (r4 != false) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0179, code lost:
        if (r8 < r6) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017b, code lost:
        if (r8 > r9) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0181, code lost:
        if (r5[r3] < r7[r3]) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0183, code lost:
        r2 = new androidx.recyclerview.widget.DiffUtil.d();
        r4 = r7[r3];
        r2.a = r4;
        r2.b = r4 - r8;
        r2.c = r5[r3] - r7[r3];
        r2.d = r13;
        r2.e = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x019c, code lost:
        r2 = r2 + 2;
        r10 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a2, code lost:
        r9 = r9 + 1;
        r15 = r15;
        r3 = r20;
        r8 = r21;
        r2 = r22;
        r11 = r11;
        r13 = r13;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.recyclerview.widget.DiffUtil.DiffResult calculateDiff(@androidx.annotation.NonNull androidx.recyclerview.widget.DiffUtil.Callback r27, boolean r28) {
        /*
        // Method dump skipped, instructions count: 653
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.calculateDiff(androidx.recyclerview.widget.DiffUtil$Callback, boolean):androidx.recyclerview.widget.DiffUtil$DiffResult");
    }
}
