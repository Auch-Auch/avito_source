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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.TransferStatus;
public final class MessageMetaInfoDao_Impl implements MessageMetaInfoDao {
    public final RoomDatabase a;
    public final EntityInsertionAdapter<MessageMetaInfo> b;
    public final EntityInsertionAdapter<MessageMetaInfo> c;
    public final SharedSQLiteStatement d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;

    public class a implements Callable<Void> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(String str, String str2, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SupportSQLiteStatement acquire = MessageMetaInfoDao_Impl.this.f.acquire();
            String str = this.a;
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            String str2 = this.b;
            if (str2 == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, str2);
            }
            String str3 = this.c;
            if (str3 == null) {
                acquire.bindNull(3);
            } else {
                acquire.bindString(3, str3);
            }
            String str4 = this.d;
            if (str4 == null) {
                acquire.bindNull(4);
            } else {
                acquire.bindString(4, str4);
            }
            MessageMetaInfoDao_Impl.this.a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MessageMetaInfoDao_Impl.this.a.setTransactionSuccessful();
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                MessageMetaInfoDao_Impl.this.f.release(acquire);
                return null;
            } catch (Throwable th) {
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                MessageMetaInfoDao_Impl.this.f.release(acquire);
                throw th;
            }
        }
    }

    public class b implements Callable<Void> {
        public final /* synthetic */ long a;
        public final /* synthetic */ TransferStatus b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(long j, TransferStatus transferStatus, String str, String str2, String str3, String str4) {
            this.a = j;
            this.b = transferStatus;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SupportSQLiteStatement acquire = MessageMetaInfoDao_Impl.this.g.acquire();
            acquire.bindLong(1, this.a);
            String transferStatusToString = TransferStatus.Converter.transferStatusToString(this.b);
            if (transferStatusToString == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, transferStatusToString);
            }
            String str = this.c;
            if (str == null) {
                acquire.bindNull(3);
            } else {
                acquire.bindString(3, str);
            }
            String str2 = this.d;
            if (str2 == null) {
                acquire.bindNull(4);
            } else {
                acquire.bindString(4, str2);
            }
            String str3 = this.e;
            if (str3 == null) {
                acquire.bindNull(5);
            } else {
                acquire.bindString(5, str3);
            }
            String str4 = this.f;
            if (str4 == null) {
                acquire.bindNull(6);
            } else {
                acquire.bindString(6, str4);
            }
            MessageMetaInfoDao_Impl.this.a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MessageMetaInfoDao_Impl.this.a.setTransactionSuccessful();
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                MessageMetaInfoDao_Impl.this.g.release(acquire);
                return null;
            } catch (Throwable th) {
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                MessageMetaInfoDao_Impl.this.g.release(acquire);
                throw th;
            }
        }
    }

    public class c implements Callable<List<MessageMetaInfo>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public c(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageMetaInfo> call() throws Exception {
            Cursor query = DBUtil.query(MessageMetaInfoDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageMetaInfo.COLUMN_LOCAL_MESSAGE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, MessageMetaInfo.COLUMN_PATH);
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, MessageMetaInfo.COLUMN_INTERNAL_PATH);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "progress");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, MessageMetaInfo.COLUMN_TRANSFER_STATUS);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new MessageMetaInfo(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6), TransferStatus.Converter.stringToTransferStatus(query.getString(columnIndexOrThrow7))));
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

    public class d implements Callable<List<MessageMetaInfo>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public d(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageMetaInfo> call() throws Exception {
            Cursor query = DBUtil.query(MessageMetaInfoDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageMetaInfo.COLUMN_LOCAL_MESSAGE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, MessageMetaInfo.COLUMN_PATH);
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, MessageMetaInfo.COLUMN_INTERNAL_PATH);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "progress");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, MessageMetaInfo.COLUMN_TRANSFER_STATUS);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new MessageMetaInfo(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6), TransferStatus.Converter.stringToTransferStatus(query.getString(columnIndexOrThrow7))));
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

    public class e extends EntityInsertionAdapter<MessageMetaInfo> {
        public e(MessageMetaInfoDao_Impl messageMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageMetaInfo messageMetaInfo) {
            MessageMetaInfo messageMetaInfo2 = messageMetaInfo;
            if (messageMetaInfo2.getLocalUserId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, messageMetaInfo2.getLocalUserId());
            }
            if (messageMetaInfo2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, messageMetaInfo2.getChannelId());
            }
            if (messageMetaInfo2.getLocalMessageId() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, messageMetaInfo2.getLocalMessageId());
            }
            if (messageMetaInfo2.getPath() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, messageMetaInfo2.getPath());
            }
            if (messageMetaInfo2.getInternalPath() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, messageMetaInfo2.getInternalPath());
            }
            supportSQLiteStatement.bindLong(6, messageMetaInfo2.getProgress());
            String transferStatusToString = TransferStatus.Converter.transferStatusToString(messageMetaInfo2.getTransferStatus());
            if (transferStatusToString == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, transferStatusToString);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `message_meta_info` (`local_user_id`,`channel_id`,`local_message_id`,`path`,`internal_path`,`progress`,`transfer_status`) VALUES (?,?,?,?,?,?,?)";
        }
    }

    public class f extends EntityInsertionAdapter<MessageMetaInfo> {
        public f(MessageMetaInfoDao_Impl messageMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageMetaInfo messageMetaInfo) {
            MessageMetaInfo messageMetaInfo2 = messageMetaInfo;
            if (messageMetaInfo2.getLocalUserId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, messageMetaInfo2.getLocalUserId());
            }
            if (messageMetaInfo2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, messageMetaInfo2.getChannelId());
            }
            if (messageMetaInfo2.getLocalMessageId() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, messageMetaInfo2.getLocalMessageId());
            }
            if (messageMetaInfo2.getPath() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, messageMetaInfo2.getPath());
            }
            if (messageMetaInfo2.getInternalPath() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, messageMetaInfo2.getInternalPath());
            }
            supportSQLiteStatement.bindLong(6, messageMetaInfo2.getProgress());
            String transferStatusToString = TransferStatus.Converter.transferStatusToString(messageMetaInfo2.getTransferStatus());
            if (transferStatusToString == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, transferStatusToString);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR IGNORE INTO `message_meta_info` (`local_user_id`,`channel_id`,`local_message_id`,`path`,`internal_path`,`progress`,`transfer_status`) VALUES (?,?,?,?,?,?,?)";
        }
    }

    public class g extends SharedSQLiteStatement {
        public g(MessageMetaInfoDao_Impl messageMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            UPDATE message_meta_info\n                SET progress = ?,\n                transfer_status = ?\n            WHERE \n                local_user_id = ? AND\n                channel_id = ? AND\n                local_message_id = ?\n        ";
        }
    }

    public class h extends SharedSQLiteStatement {
        public h(MessageMetaInfoDao_Impl messageMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            UPDATE message_meta_info\n                SET progress = ?,\n                transfer_status = ?,\n                internal_path = ?\n            WHERE \n                local_user_id = ? AND\n                channel_id = ? AND\n                local_message_id = ?\n        ";
        }
    }

    public class i extends SharedSQLiteStatement {
        public i(MessageMetaInfoDao_Impl messageMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            UPDATE message_meta_info\n                SET internal_path = ?\n            WHERE \n                local_user_id = ? AND\n                channel_id = ? AND\n                local_message_id = ?\n            \n        ";
        }
    }

    public class j extends SharedSQLiteStatement {
        public j(MessageMetaInfoDao_Impl messageMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            UPDATE message_meta_info\n                SET progress = ?,\n                    transfer_status = ?,\n                    path = ?\n            WHERE \n                local_user_id = ? AND\n                channel_id = ? AND\n                local_message_id = ?\n            \n        ";
        }
    }

    public class k implements Callable<Void> {
        public final /* synthetic */ MessageMetaInfo a;

        public k(MessageMetaInfo messageMetaInfo) {
            this.a = messageMetaInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            MessageMetaInfoDao_Impl.this.a.beginTransaction();
            try {
                MessageMetaInfoDao_Impl.this.b.insert((EntityInsertionAdapter<MessageMetaInfo>) this.a);
                MessageMetaInfoDao_Impl.this.a.setTransactionSuccessful();
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                return null;
            } catch (Throwable th) {
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                throw th;
            }
        }
    }

    public class l implements Callable<Void> {
        public final /* synthetic */ long a;
        public final /* synthetic */ TransferStatus b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public l(long j, TransferStatus transferStatus, String str, String str2, String str3) {
            this.a = j;
            this.b = transferStatus;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SupportSQLiteStatement acquire = MessageMetaInfoDao_Impl.this.d.acquire();
            acquire.bindLong(1, this.a);
            String transferStatusToString = TransferStatus.Converter.transferStatusToString(this.b);
            if (transferStatusToString == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, transferStatusToString);
            }
            String str = this.c;
            if (str == null) {
                acquire.bindNull(3);
            } else {
                acquire.bindString(3, str);
            }
            String str2 = this.d;
            if (str2 == null) {
                acquire.bindNull(4);
            } else {
                acquire.bindString(4, str2);
            }
            String str3 = this.e;
            if (str3 == null) {
                acquire.bindNull(5);
            } else {
                acquire.bindString(5, str3);
            }
            MessageMetaInfoDao_Impl.this.a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MessageMetaInfoDao_Impl.this.a.setTransactionSuccessful();
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                MessageMetaInfoDao_Impl.this.d.release(acquire);
                return null;
            } catch (Throwable th) {
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                MessageMetaInfoDao_Impl.this.d.release(acquire);
                throw th;
            }
        }
    }

    public class m implements Callable<Void> {
        public final /* synthetic */ long a;
        public final /* synthetic */ TransferStatus b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public m(long j, TransferStatus transferStatus, String str, String str2, String str3, String str4) {
            this.a = j;
            this.b = transferStatus;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SupportSQLiteStatement acquire = MessageMetaInfoDao_Impl.this.e.acquire();
            acquire.bindLong(1, this.a);
            String transferStatusToString = TransferStatus.Converter.transferStatusToString(this.b);
            if (transferStatusToString == null) {
                acquire.bindNull(2);
            } else {
                acquire.bindString(2, transferStatusToString);
            }
            String str = this.c;
            if (str == null) {
                acquire.bindNull(3);
            } else {
                acquire.bindString(3, str);
            }
            String str2 = this.d;
            if (str2 == null) {
                acquire.bindNull(4);
            } else {
                acquire.bindString(4, str2);
            }
            String str3 = this.e;
            if (str3 == null) {
                acquire.bindNull(5);
            } else {
                acquire.bindString(5, str3);
            }
            String str4 = this.f;
            if (str4 == null) {
                acquire.bindNull(6);
            } else {
                acquire.bindString(6, str4);
            }
            MessageMetaInfoDao_Impl.this.a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                MessageMetaInfoDao_Impl.this.a.setTransactionSuccessful();
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                MessageMetaInfoDao_Impl.this.e.release(acquire);
                return null;
            } catch (Throwable th) {
                MessageMetaInfoDao_Impl.this.a.endTransaction();
                MessageMetaInfoDao_Impl.this.e.release(acquire);
                throw th;
            }
        }
    }

    public MessageMetaInfoDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new e(this, roomDatabase);
        this.c = new f(this, roomDatabase);
        this.d = new g(this, roomDatabase);
        this.e = new h(this, roomDatabase);
        this.f = new i(this, roomDatabase);
        this.g = new j(this, roomDatabase);
    }

    @Override // ru.avito.android.persistence.messenger.MessageMetaInfoDao
    public Observable<List<MessageMetaInfo>> getMessageMetaInfo(String str, String str2, String str3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT * FROM message_meta_info\n            WHERE\n                local_user_id = ? AND\n                channel_id = ? AND\n                local_message_id = ?\n        ", 3);
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
        if (str3 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str3);
        }
        return RxRoom.createObservable(this.a, false, new String[]{MessageMetaInfo.TABLE_NAME}, new c(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageMetaInfoDao
    public Observable<List<MessageMetaInfo>> getMetaInfoForMessages(String str, String str2, List<String> list) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT ", "*", " FROM message_meta_info", "\n");
        a2.b.a.a.a.n1(V, "            WHERE", "\n", "                local_user_id = ", "?");
        a2.b.a.a.a.n1(V, " AND", "\n", "                channel_id = ", "?");
        V.append(" AND");
        V.append("\n");
        V.append("                local_message_id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("        ");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(V.toString(), size + 2);
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
        int i2 = 3;
        for (String str3 : list) {
            if (str3 == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str3);
            }
            i2++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{MessageMetaInfo.TABLE_NAME}, new d(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageMetaInfoDao
    public long insertIfDoesNotExist(MessageMetaInfo messageMetaInfo) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long insertAndReturnId = this.c.insertAndReturnId(messageMetaInfo);
            this.a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageMetaInfoDao
    public Completable insertOrReplace(MessageMetaInfo messageMetaInfo) {
        return Completable.fromCallable(new k(messageMetaInfo));
    }

    @Override // ru.avito.android.persistence.messenger.MessageMetaInfoDao
    public Completable updateInternalPath(String str, String str2, String str3, String str4) {
        return Completable.fromCallable(new a(str4, str, str2, str3));
    }

    @Override // ru.avito.android.persistence.messenger.MessageMetaInfoDao
    public void updateOrInsertProgressAndStatus(String str, String str2, String str3, long j2, TransferStatus transferStatus) {
        this.a.beginTransaction();
        try {
            MessageMetaInfoDao.DefaultImpls.updateOrInsertProgressAndStatus(this, str, str2, str3, j2, transferStatus);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageMetaInfoDao
    public Completable updateProgressAndStatus(String str, String str2, String str3, long j2, TransferStatus transferStatus) {
        return Completable.fromCallable(new l(j2, transferStatus, str, str2, str3));
    }

    @Override // ru.avito.android.persistence.messenger.MessageMetaInfoDao
    public Completable updateProgressAndStatusAndInternalPath(String str, String str2, String str3, long j2, TransferStatus transferStatus, String str4) {
        return Completable.fromCallable(new m(j2, transferStatus, str4, str, str2, str3));
    }

    @Override // ru.avito.android.persistence.messenger.MessageMetaInfoDao
    public Completable updateProgressAndStatusAndPath(String str, String str2, String str3, long j2, TransferStatus transferStatus, String str4) {
        return Completable.fromCallable(new b(j2, transferStatus, str4, str, str2, str3));
    }
}
