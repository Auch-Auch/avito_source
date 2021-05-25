package ru.avito.android.persistence.messenger;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
public final class DraftDao_Impl implements DraftDao {
    public final RoomDatabase a;
    public final EntityInsertionAdapter<DraftEntity> b;
    public final SharedSQLiteStatement c;
    public final SharedSQLiteStatement d;

    public class a extends EntityInsertionAdapter<DraftEntity> {
        public a(DraftDao_Impl draftDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, DraftEntity draftEntity) {
            DraftEntity draftEntity2 = draftEntity;
            if (draftEntity2.getLocalUserId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, draftEntity2.getLocalUserId());
            }
            if (draftEntity2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, draftEntity2.getChannelId());
            }
            if (draftEntity2.getInterlocutorId() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, draftEntity2.getInterlocutorId());
            }
            if (draftEntity2.getText() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, draftEntity2.getText());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `draft` (`local_user_id`,`channel_id`,`interlocutor_id`,`text`) VALUES (?,?,?,?)";
        }
    }

    public class b extends SharedSQLiteStatement {
        public b(DraftDao_Impl draftDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n        DELETE FROM draft \n        WHERE \n            local_user_id = ? \n            AND channel_id = ?\n        ";
        }
    }

    public class c extends SharedSQLiteStatement {
        public c(DraftDao_Impl draftDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            DELETE FROM draft \n            WHERE \n                local_user_id = ? \n                AND interlocutor_id = ?\n            ";
        }
    }

    public class d implements Callable<List<DraftEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public d(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<DraftEntity> call() throws Exception {
            Cursor query = DBUtil.query(DraftDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "text");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new DraftEntity(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4)));
                }
                return arrayList;
            } finally {
                query.close();
            }
        }

        @Override // java.lang.Object
        public void finalize() {
            this.a.release();
        }
    }

    public class e implements Callable<List<DraftEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public e(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<DraftEntity> call() throws Exception {
            Cursor query = DBUtil.query(DraftDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "text");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new DraftEntity(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4)));
                }
                return arrayList;
            } finally {
                query.close();
            }
        }

        @Override // java.lang.Object
        public void finalize() {
            this.a.release();
        }
    }

    public class f implements Callable<List<DraftEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public f(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<DraftEntity> call() throws Exception {
            Cursor query = DBUtil.query(DraftDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "text");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new DraftEntity(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4)));
                }
                return arrayList;
            } finally {
                query.close();
            }
        }

        @Override // java.lang.Object
        public void finalize() {
            this.a.release();
        }
    }

    public DraftDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new b(this, roomDatabase);
        this.d = new c(this, roomDatabase);
    }

    @Override // ru.avito.android.persistence.messenger.DraftDao
    public int deleteAllDraftsWithInterlocutor(String str, String str2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.d.release(acquire);
        }
    }

    @Override // ru.avito.android.persistence.messenger.DraftDao
    public int deleteDraft(String str, String str2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.c.release(acquire);
        }
    }

    @Override // ru.avito.android.persistence.messenger.DraftDao
    public Observable<List<DraftEntity>> getAllDrafts(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM draft WHERE local_user_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{AnalyticFieldsName.draft}, new e(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.DraftDao
    public Observable<List<DraftEntity>> getDraft(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM draft WHERE local_user_id = ? AND channel_id = ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        return RxRoom.createObservable(this.a, false, new String[]{AnalyticFieldsName.draft}, new d(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.DraftDao
    public Observable<List<DraftEntity>> getDraftsForChannelIds(String str, List<String> list) {
        StringBuilder V = a2.b.a.a.a.V("\n", "        SELECT ", "*", " FROM draft", "\n");
        a2.b.a.a.a.n1(V, "        WHERE local_user_id = ", "?", "\n", "            AND channel_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("        ");
        V.append("\n");
        V.append("    ");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(V.toString(), size + 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        int i = 2;
        for (String str2 : list) {
            if (str2 == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str2);
            }
            i++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{AnalyticFieldsName.draft}, new f(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.DraftDao
    public long insertDraft(DraftEntity draftEntity) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(draftEntity);
            this.a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.DraftDao
    public List<Long> insertDrafts(List<DraftEntity> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.b.insertAndReturnIdsList(list);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.a.endTransaction();
        }
    }
}
