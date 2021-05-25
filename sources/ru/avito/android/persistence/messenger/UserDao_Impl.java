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
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
public final class UserDao_Impl extends UserDao {
    public final RoomDatabase a;
    public final EntityInsertionAdapter<UserEntity> b;
    public final SharedSQLiteStatement c;

    public class a extends EntityInsertionAdapter<UserEntity> {
        public a(UserDao_Impl userDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, UserEntity userEntity) {
            UserEntity userEntity2 = userEntity;
            if (userEntity2.getLocalUserId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, userEntity2.getLocalUserId());
            }
            if (userEntity2.getUserId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, userEntity2.getUserId());
            }
            if (userEntity2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, userEntity2.getChannelId());
            }
            if (userEntity2.getName() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, userEntity2.getName());
            }
            if (userEntity2.getLastActionTime() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, userEntity2.getLastActionTime().longValue());
            }
            if (userEntity2.getTimeDiff() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindLong(6, userEntity2.getTimeDiff().longValue());
            }
            if (userEntity2.getJsonPublicProfile() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, userEntity2.getJsonPublicProfile());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `user` (`local_user_id`,`user_id`,`channel_id`,`name`,`last_action_time`,`time_diff`,`json_public_profile`) VALUES (?,?,?,?,?,?,?)";
        }
    }

    public class b extends SharedSQLiteStatement {
        public b(UserDao_Impl userDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            UPDATE user\n                SET last_action_time = ?,\n                    time_diff = ?\n            WHERE user_id = ?\n        ";
        }
    }

    public class c implements Callable<Void> {
        public final /* synthetic */ Long a;
        public final /* synthetic */ Long b;
        public final /* synthetic */ String c;

        public c(Long l, Long l2, String str) {
            this.a = l;
            this.b = l2;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SupportSQLiteStatement acquire = UserDao_Impl.this.c.acquire();
            Long l = this.a;
            if (l == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindLong(1, l.longValue());
            }
            Long l2 = this.b;
            if (l2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindLong(2, l2.longValue());
            }
            String str = this.c;
            if (str == null) {
                acquire.bindNull(3);
            } else {
                acquire.bindString(3, str);
            }
            UserDao_Impl.this.a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                UserDao_Impl.this.a.setTransactionSuccessful();
                UserDao_Impl.this.a.endTransaction();
                UserDao_Impl.this.c.release(acquire);
                return null;
            } catch (Throwable th) {
                UserDao_Impl.this.a.endTransaction();
                UserDao_Impl.this.c.release(acquire);
                throw th;
            }
        }
    }

    public class d implements Callable<List<UserEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public d(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<UserEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(UserDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_LAST_ACTION_TIME);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_TIME_DIFF);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_JSON_PUBLIC_PROFILE);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    String string4 = query.getString(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow6));
                    }
                    arrayList.add(new UserEntity(string, string2, string3, string4, l, l2, query.getString(columnIndexOrThrow7)));
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

    public class e implements Callable<List<UserEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public e(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<UserEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(UserDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_LAST_ACTION_TIME);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_TIME_DIFF);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_JSON_PUBLIC_PROFILE);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    String string4 = query.getString(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow6));
                    }
                    arrayList.add(new UserEntity(string, string2, string3, string4, l, l2, query.getString(columnIndexOrThrow7)));
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

    public class f implements Callable<List<UserEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public f(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<UserEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(UserDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_LAST_ACTION_TIME);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_TIME_DIFF);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_JSON_PUBLIC_PROFILE);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    String string4 = query.getString(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow6));
                    }
                    arrayList.add(new UserEntity(string, string2, string3, string4, l, l2, query.getString(columnIndexOrThrow7)));
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

    public class g implements Callable<List<UserIdAndLastActionTime>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public g(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<UserIdAndLastActionTime> call() throws Exception {
            Cursor query = DBUtil.query(UserDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new UserIdAndLastActionTime(query.getString(columnIndexOrThrow), null, null));
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

    public class h implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public h(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(UserDao_Impl.this.a, this.a, false, null);
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(query.getString(0));
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

    public class i implements Callable<List<UserEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public i(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<UserEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(UserDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_LAST_ACTION_TIME);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_TIME_DIFF);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, UserEntity.COLUMN_JSON_PUBLIC_PROFILE);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    String string4 = query.getString(columnIndexOrThrow4);
                    if (query.isNull(columnIndexOrThrow5)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow6));
                    }
                    arrayList.add(new UserEntity(string, string2, string3, string4, l, l2, query.getString(columnIndexOrThrow7)));
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

    public UserDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new b(this, roomDatabase);
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public Observable<List<UserEntity>> getAllUsers() {
        return RxRoom.createObservable(this.a, false, new String[]{"user"}, new d(RoomSQLiteQuery.acquire("\n        SELECT * FROM user\n    ", 0)));
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public Observable<List<String>> getIdsOfUsersWithLastActionTimeOlderOrEqualTo(long j, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT user_id", "\n", "            FROM user", "\n");
        a2.b.a.a.a.n1(V, "            WHERE ", "\n", "                ((last_action_time IS NULL) OR", "\n");
        a2.b.a.a.a.n1(V, "                (last_action_time <= ", "?", ")) AND", "\n");
        V.append("                user_id IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("        ");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(V.toString(), size + 1);
        acquire.bindLong(1, j);
        int i2 = 2;
        for (String str : collection) {
            if (str == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str);
            }
            i2++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"user"}, new h(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public Observable<List<UserIdAndLastActionTime>> getUserLastActionTimes(Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT user_id, MAX(last_action_time)", "\n", "            FROM user", "\n");
        V.append("            WHERE user_id IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(a2.b.a.a.a.u(V, "            GROUP BY user_id", "\n", "        "), size + 0);
        int i2 = 1;
        for (String str : collection) {
            if (str == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str);
            }
            i2++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"user"}, new g(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public Single<List<UserEntity>> getUsersExistedInDbFromGivenIds(String str, String str2, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT ", "*", " ", "\n");
        V.append("            FROM user");
        V.append("\n");
        V.append("            WHERE user_id IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(") ");
        V.append("\n");
        V.append("            AND channel_id = ");
        V.append("?");
        V.append("\n");
        String v = a2.b.a.a.a.v(V, "            AND local_user_id = ", "?", "\n", "        ");
        int i2 = size + 2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(v, i2);
        int i3 = 1;
        for (String str3 : collection) {
            if (str3 == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str3);
            }
            i3++;
        }
        int i4 = size + 1;
        if (str2 == null) {
            acquire.bindNull(i4);
        } else {
            acquire.bindString(i4, str2);
        }
        if (str == null) {
            acquire.bindNull(i2);
        } else {
            acquire.bindString(i2, str);
        }
        return RxRoom.createSingle(new i(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public Observable<List<UserEntity>> getUsersForChannel(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT user.* \n            FROM user\n            WHERE\n                user.local_user_id = ?\n                AND user.channel_id = ?\n        ", 2);
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
        return RxRoom.createObservable(this.a, false, new String[]{"user"}, new f(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public Observable<List<UserEntity>> getUsersForChannels(String str, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "        SELECT ", "*", " FROM user", "\n");
        a2.b.a.a.a.n1(V, "        WHERE", "\n", "            local_user_id = ", "?");
        V.append("\n");
        V.append("            AND channel_id IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(a2.b.a.a.a.t(V, "\n", "    "), size + 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        int i2 = 2;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str2);
            }
            i2++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"user"}, new e(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public long insertUser(UserEntity userEntity) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(userEntity);
            this.a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public List<Long> insertUsers(Collection<UserEntity> collection) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.b.insertAndReturnIdsList(collection);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public Completable updateUserLastActionTime(String str, Long l, Long l2) {
        return Completable.fromCallable(new c(l, l2, str));
    }

    @Override // ru.avito.android.persistence.messenger.UserDao
    public void updateUserLastActionTimes(Collection<UserIdAndLastActionTime> collection) {
        this.a.beginTransaction();
        try {
            super.updateUserLastActionTimes(collection);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
