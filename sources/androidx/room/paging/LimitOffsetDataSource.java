package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.List;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    public final RoomSQLiteQuery c;
    public final String d;
    public final String e;
    public final RoomDatabase f;
    public final InvalidationTracker.Observer g;
    public final boolean h;

    public class a extends InvalidationTracker.Observer {
        public a(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            LimitOffsetDataSource.this.invalidate();
        }
    }

    public LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z, String... strArr) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z, strArr);
    }

    public abstract List<T> convertRows(Cursor cursor);

    public int countItems() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.d, this.c.getArgCount());
        acquire.copyArgumentsFrom(this.c);
        Cursor query = this.f.query(acquire);
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            query.close();
            acquire.release();
            return 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public final RoomSQLiteQuery d(int i, int i2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.e, this.c.getArgCount() + 2);
        acquire.copyArgumentsFrom(this.c);
        acquire.bindLong(acquire.getArgCount() - 1, (long) i2);
        acquire.bindLong(acquire.getArgCount(), (long) i);
        return acquire;
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        this.f.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    @Override // androidx.paging.PositionalDataSource
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadInitial(@androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialParams r7, @androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialCallback<T> r8) {
        /*
            r6 = this;
            java.util.List r0 = java.util.Collections.emptyList()
            androidx.room.RoomDatabase r1 = r6.f
            r1.beginTransaction()
            r1 = 0
            int r2 = r6.countItems()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0032
            int r0 = androidx.paging.PositionalDataSource.computeInitialLoadPosition(r7, r2)     // Catch:{ all -> 0x0047 }
            int r7 = androidx.paging.PositionalDataSource.computeInitialLoadSize(r7, r0, r2)     // Catch:{ all -> 0x0047 }
            androidx.room.RoomSQLiteQuery r7 = r6.d(r0, r7)     // Catch:{ all -> 0x0047 }
            androidx.room.RoomDatabase r3 = r6.f     // Catch:{ all -> 0x0030 }
            android.database.Cursor r1 = r3.query(r7)     // Catch:{ all -> 0x0030 }
            java.util.List r3 = r6.convertRows(r1)     // Catch:{ all -> 0x0030 }
            androidx.room.RoomDatabase r4 = r6.f     // Catch:{ all -> 0x0030 }
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0030 }
            r5 = r3
            r3 = r7
            r7 = r0
            r0 = r5
            goto L_0x0034
        L_0x0030:
            r8 = move-exception
            goto L_0x0049
        L_0x0032:
            r7 = 0
            r3 = r1
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()
        L_0x0039:
            androidx.room.RoomDatabase r1 = r6.f
            r1.endTransaction()
            if (r3 == 0) goto L_0x0043
            r3.release()
        L_0x0043:
            r8.onResult(r0, r7, r2)
            return
        L_0x0047:
            r8 = move-exception
            r7 = r1
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            r1.close()
        L_0x004e:
            androidx.room.RoomDatabase r0 = r6.f
            r0.endTransaction()
            if (r7 == 0) goto L_0x0058
            r7.release()
        L_0x0058:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.LimitOffsetDataSource.loadInitial(androidx.paging.PositionalDataSource$LoadInitialParams, androidx.paging.PositionalDataSource$LoadInitialCallback):void");
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams loadRangeParams, @NonNull PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    public LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean z, String... strArr) {
        this.f = roomDatabase;
        this.c = roomSQLiteQuery;
        this.h = z;
        StringBuilder L = a2.b.a.a.a.L("SELECT COUNT(*) FROM ( ");
        L.append(roomSQLiteQuery.getSql());
        L.append(" )");
        this.d = L.toString();
        StringBuilder L2 = a2.b.a.a.a.L("SELECT * FROM ( ");
        L2.append(roomSQLiteQuery.getSql());
        L2.append(" ) LIMIT ? OFFSET ?");
        this.e = L2.toString();
        a aVar = new a(strArr);
        this.g = aVar;
        roomDatabase.getInvalidationTracker().addWeakObserver(aVar);
    }

    @NonNull
    public List<T> loadRange(int i, int i2) {
        RoomSQLiteQuery d2 = d(i, i2);
        if (this.h) {
            this.f.beginTransaction();
            Cursor cursor = null;
            try {
                cursor = this.f.query(d2);
                List<T> convertRows = convertRows(cursor);
                this.f.setTransactionSuccessful();
                return convertRows;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                this.f.endTransaction();
                d2.release();
            }
        } else {
            Cursor query = this.f.query(d2);
            try {
                return convertRows(query);
            } finally {
                query.close();
                d2.release();
            }
        }
    }
}
