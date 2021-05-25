package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    @VisibleForTesting
    public static final TreeMap<Integer, RoomSQLiteQuery> i = new TreeMap<>();
    public volatile String a;
    @VisibleForTesting
    public final long[] b;
    @VisibleForTesting
    public final double[] c;
    @VisibleForTesting
    public final String[] d;
    @VisibleForTesting
    public final byte[][] e;
    public final int[] f;
    @VisibleForTesting
    public final int g;
    @VisibleForTesting
    public int h;

    public static class a implements SupportSQLiteProgram {
        public final /* synthetic */ RoomSQLiteQuery a;

        public a(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int i, byte[] bArr) {
            this.a.bindBlob(i, bArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int i, double d) {
            this.a.bindDouble(i, d);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int i, long j) {
            this.a.bindLong(i, j);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int i) {
            this.a.bindNull(i);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int i, String str) {
            this.a.bindString(i, str);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.a.clearBindings();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public RoomSQLiteQuery(int i2) {
        this.g = i2;
        int i3 = i2 + 1;
        this.f = new int[i3];
        this.b = new long[i3];
        this.c = new double[i3];
        this.d = new String[i3];
        this.e = new byte[i3][];
    }

    public static RoomSQLiteQuery acquire(String str, int i2) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = i;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.a = str;
                value.h = i2;
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i2);
            roomSQLiteQuery.a = str;
            roomSQLiteQuery.h = i2;
            return roomSQLiteQuery;
        }
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo(new a(acquire));
        return acquire;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i2, byte[] bArr) {
        this.f[i2] = 5;
        this.e[i2] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i2, double d2) {
        this.f[i2] = 3;
        this.c[i2] = d2;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i2, long j) {
        this.f[i2] = 2;
        this.b[i2] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i2) {
        this.f[i2] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i2, String str) {
        this.f[i2] = 4;
        this.d[i2] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i2 = 1; i2 <= this.h; i2++) {
            int i3 = this.f[i2];
            if (i3 == 1) {
                supportSQLiteProgram.bindNull(i2);
            } else if (i3 == 2) {
                supportSQLiteProgram.bindLong(i2, this.b[i2]);
            } else if (i3 == 3) {
                supportSQLiteProgram.bindDouble(i2, this.c[i2]);
            } else if (i3 == 4) {
                supportSQLiteProgram.bindString(i2, this.d[i2]);
            } else if (i3 == 5) {
                supportSQLiteProgram.bindBlob(i2, this.e[i2]);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.f, 1);
        Arrays.fill(this.d, (Object) null);
        Arrays.fill(this.e, (Object) null);
        this.a = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        int argCount = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.f, 0, this.f, 0, argCount);
        System.arraycopy(roomSQLiteQuery.b, 0, this.b, 0, argCount);
        System.arraycopy(roomSQLiteQuery.d, 0, this.d, 0, argCount);
        System.arraycopy(roomSQLiteQuery.e, 0, this.e, 0, argCount);
        System.arraycopy(roomSQLiteQuery.c, 0, this.c, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.h;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.a;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.g), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int i2 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i2;
                }
            }
        }
    }
}
