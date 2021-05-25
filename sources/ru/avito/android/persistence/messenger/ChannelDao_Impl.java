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
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import ru.avito.android.persistence.messenger.IsReadStatus;
public final class ChannelDao_Impl extends ChannelDao {
    public final RoomDatabase a;
    public final EntityInsertionAdapter<ChannelEntity> b;
    public final EntityInsertionAdapter<UserEntity> c;
    public final EntityInsertionAdapter<ChannelTag> d;
    public final EntityInsertionAdapter<MessageEntity> e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;
    public final SharedSQLiteStatement h;
    public final SharedSQLiteStatement i;
    public final SharedSQLiteStatement j;

    public class a implements Callable<Void> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SupportSQLiteStatement acquire = ChannelDao_Impl.this.f.acquire();
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
            ChannelDao_Impl.this.a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                ChannelDao_Impl.this.a.setTransactionSuccessful();
                ChannelDao_Impl.this.a.endTransaction();
                ChannelDao_Impl.this.f.release(acquire);
                return null;
            } catch (Throwable th) {
                ChannelDao_Impl.this.a.endTransaction();
                ChannelDao_Impl.this.f.release(acquire);
                throw th;
            }
        }
    }

    public class a0 extends EntityInsertionAdapter<MessageEntity> {
        public a0(ChannelDao_Impl channelDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MessageEntity messageEntity) {
            MessageEntity messageEntity2 = messageEntity;
            if (messageEntity2.getLocalId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, messageEntity2.getLocalId());
            }
            if (messageEntity2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, messageEntity2.getChannelId());
            }
            if (messageEntity2.getRemoteId() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, messageEntity2.getRemoteId());
            }
            supportSQLiteStatement.bindLong(4, messageEntity2.getCreated());
            if (messageEntity2.getType() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, messageEntity2.getType());
            }
            if (messageEntity2.getUserId() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, messageEntity2.getUserId());
            }
            if (messageEntity2.getFromId() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, messageEntity2.getFromId());
            }
            if (messageEntity2.getJsonBody() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, messageEntity2.getJsonBody());
            }
            supportSQLiteStatement.bindLong(9, messageEntity2.isRead() ? 1 : 0);
            supportSQLiteStatement.bindLong(10, messageEntity2.isSpam() ? 1 : 0);
            supportSQLiteStatement.bindLong(11, messageEntity2.isFailed() ? 1 : 0);
            if (messageEntity2.getReadTimestamp() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindLong(12, messageEntity2.getReadTimestamp().longValue());
            }
            if (messageEntity2.getPreview() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, messageEntity2.getPreview());
            }
            supportSQLiteStatement.bindLong(14, messageEntity2.isSupported() ? 1 : 0);
            supportSQLiteStatement.bindLong(15, messageEntity2.isCompleteBody() ? 1 : 0);
            String isReadStatusToString = IsReadStatus.Converter.isReadStatusToString(messageEntity2.isReadStatus());
            if (isReadStatusToString == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, isReadStatusToString);
            }
            if (messageEntity2.getReadLocallyTimestamp() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindLong(17, messageEntity2.getReadLocallyTimestamp().longValue());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR IGNORE INTO `message` (`local_id`,`channel_id`,`remote_id`,`created`,`type`,`user_id`,`from_id`,`json_body`,`is_read`,`is_spam`,`is_failed`,`read_timestamp`,`preview_text`,`is_supported`,`is_complete`,`is_read_status`,`read_locally_timestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b implements Callable<Void> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SupportSQLiteStatement acquire = ChannelDao_Impl.this.g.acquire();
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
            ChannelDao_Impl.this.a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                ChannelDao_Impl.this.a.setTransactionSuccessful();
                ChannelDao_Impl.this.a.endTransaction();
                ChannelDao_Impl.this.g.release(acquire);
                return null;
            } catch (Throwable th) {
                ChannelDao_Impl.this.a.endTransaction();
                ChannelDao_Impl.this.g.release(acquire);
                throw th;
            }
        }
    }

    public class b0 extends SharedSQLiteStatement {
        public b0(ChannelDao_Impl channelDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            UPDATE channel\n                SET is_read = 1\n            WHERE \n                user_id = ?\n                AND channel_id = ?\n        ";
        }
    }

    public class c implements Callable<List<ChannelEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public c(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelEntity> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_UPDATED);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_CONTEXT_TYPE);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT);
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_READ_ONLY_STATE);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_DELETED);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_ANSWERED);
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS);
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DEAL_ACTION);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "flow");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "item_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DISPLAY_INFO);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_INPUT_STATE);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow12) != 0;
                    String string7 = query.getString(columnIndexOrThrow13);
                    String string8 = query.getString(i);
                    String string9 = query.getString(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    String string10 = query.getString(columnIndexOrThrow16);
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    String string11 = query.getString(columnIndexOrThrow17);
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    String string12 = query.getString(columnIndexOrThrow18);
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    String string13 = query.getString(columnIndexOrThrow19);
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                    String string14 = query.getString(columnIndexOrThrow20);
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    arrayList.add(new ChannelEntity(string, string2, string3, j, j2, string4, string5, string6, z, z2, z3, z4, string7, string8, string9, string10, string11, string12, string13, string14));
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i;
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

    public class c0 extends SharedSQLiteStatement {
        public c0(ChannelDao_Impl channelDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            UPDATE channel\n                SET json_context_actions = NULL\n            WHERE \n                user_id = ?\n                AND channel_id = ?\n        ";
        }
    }

    public class d implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public d(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
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

    public class d0 extends SharedSQLiteStatement {
        public d0(ChannelDao_Impl channelDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            DELETE FROM channel \n            WHERE \n                user_id = ? \n                AND channel_id = ?\n            ";
        }
    }

    public class e implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public e(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
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

    public class e0 extends SharedSQLiteStatement {
        public e0(ChannelDao_Impl channelDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            DELETE FROM channel \n            WHERE \n                user_id = ? \n                AND interlocutor_id = ?\n                AND item_id = ?\n            ";
        }
    }

    public class f implements Callable<List<ChannelEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public f(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelEntity> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_UPDATED);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_CONTEXT_TYPE);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT);
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_READ_ONLY_STATE);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_DELETED);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_ANSWERED);
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS);
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DEAL_ACTION);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "flow");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "item_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DISPLAY_INFO);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_INPUT_STATE);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow12) != 0;
                    String string7 = query.getString(columnIndexOrThrow13);
                    String string8 = query.getString(i);
                    String string9 = query.getString(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    String string10 = query.getString(columnIndexOrThrow16);
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    String string11 = query.getString(columnIndexOrThrow17);
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    String string12 = query.getString(columnIndexOrThrow18);
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    String string13 = query.getString(columnIndexOrThrow19);
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                    String string14 = query.getString(columnIndexOrThrow20);
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    arrayList.add(new ChannelEntity(string, string2, string3, j, j2, string4, string5, string6, z, z2, z3, z4, string7, string8, string9, string10, string11, string12, string13, string14));
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i;
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

    public class f0 extends SharedSQLiteStatement {
        public f0(ChannelDao_Impl channelDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            DELETE FROM channel_tag\n            WHERE\n                local_user_id = ?\n                AND channel_id = ?\n        ";
        }
    }

    public class g implements Callable<List<ChannelEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public g(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelEntity> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_UPDATED);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_CONTEXT_TYPE);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT);
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_READ_ONLY_STATE);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_DELETED);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_ANSWERED);
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS);
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DEAL_ACTION);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "flow");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "item_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DISPLAY_INFO);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_INPUT_STATE);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow12) != 0;
                    String string7 = query.getString(columnIndexOrThrow13);
                    String string8 = query.getString(i);
                    String string9 = query.getString(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    String string10 = query.getString(columnIndexOrThrow16);
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    String string11 = query.getString(columnIndexOrThrow17);
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    String string12 = query.getString(columnIndexOrThrow18);
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    String string13 = query.getString(columnIndexOrThrow19);
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                    String string14 = query.getString(columnIndexOrThrow20);
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    arrayList.add(new ChannelEntity(string, string2, string3, j, j2, string4, string5, string6, z, z2, z3, z4, string7, string8, string9, string10, string11, string12, string13, string14));
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i;
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

    public class h implements Callable<List<ChannelEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public h(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelEntity> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_UPDATED);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_CONTEXT_TYPE);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT);
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_READ_ONLY_STATE);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_DELETED);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_ANSWERED);
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS);
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DEAL_ACTION);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "flow");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "item_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DISPLAY_INFO);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_INPUT_STATE);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow12) != 0;
                    String string7 = query.getString(columnIndexOrThrow13);
                    String string8 = query.getString(i);
                    String string9 = query.getString(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    String string10 = query.getString(columnIndexOrThrow16);
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    String string11 = query.getString(columnIndexOrThrow17);
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    String string12 = query.getString(columnIndexOrThrow18);
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    String string13 = query.getString(columnIndexOrThrow19);
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                    String string14 = query.getString(columnIndexOrThrow20);
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    arrayList.add(new ChannelEntity(string, string2, string3, j, j2, string4, string5, string6, z, z2, z3, z4, string7, string8, string9, string10, string11, string12, string13, string14));
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i;
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

    public class i implements Callable<List<ChannelEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public i(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelEntity> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_UPDATED);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_CONTEXT_TYPE);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT);
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_READ_ONLY_STATE);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_DELETED);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_ANSWERED);
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS);
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DEAL_ACTION);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "flow");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "item_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DISPLAY_INFO);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_INPUT_STATE);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow12) != 0;
                    String string7 = query.getString(columnIndexOrThrow13);
                    String string8 = query.getString(i);
                    String string9 = query.getString(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    String string10 = query.getString(columnIndexOrThrow16);
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    String string11 = query.getString(columnIndexOrThrow17);
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    String string12 = query.getString(columnIndexOrThrow18);
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    String string13 = query.getString(columnIndexOrThrow19);
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                    String string14 = query.getString(columnIndexOrThrow20);
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    arrayList.add(new ChannelEntity(string, string2, string3, j, j2, string4, string5, string6, z, z2, z3, z4, string7, string8, string9, string10, string11, string12, string13, string14));
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i;
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

    public class j implements Callable<List<ChannelEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public j(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelEntity> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_UPDATED);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_CONTEXT_TYPE);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT);
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_READ_ONLY_STATE);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_DELETED);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_ANSWERED);
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS);
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DEAL_ACTION);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "flow");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "item_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DISPLAY_INFO);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_INPUT_STATE);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow12) != 0;
                    String string7 = query.getString(columnIndexOrThrow13);
                    String string8 = query.getString(i);
                    String string9 = query.getString(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    String string10 = query.getString(columnIndexOrThrow16);
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    String string11 = query.getString(columnIndexOrThrow17);
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    String string12 = query.getString(columnIndexOrThrow18);
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    String string13 = query.getString(columnIndexOrThrow19);
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                    String string14 = query.getString(columnIndexOrThrow20);
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    arrayList.add(new ChannelEntity(string, string2, string3, j, j2, string4, string5, string6, z, z2, z3, z4, string7, string8, string9, string10, string11, string12, string13, string14));
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i;
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

    public class k extends EntityInsertionAdapter<ChannelEntity> {
        public k(ChannelDao_Impl channelDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ChannelEntity channelEntity) {
            ChannelEntity channelEntity2 = channelEntity;
            if (channelEntity2.getUserId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, channelEntity2.getUserId());
            }
            if (channelEntity2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, channelEntity2.getChannelId());
            }
            if (channelEntity2.getType() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, channelEntity2.getType());
            }
            supportSQLiteStatement.bindLong(4, channelEntity2.getCreated());
            supportSQLiteStatement.bindLong(5, channelEntity2.getUpdated());
            if (channelEntity2.getContextType() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, channelEntity2.getContextType());
            }
            if (channelEntity2.getJsonContext() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, channelEntity2.getJsonContext());
            }
            if (channelEntity2.getJsonReadOnlyState() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, channelEntity2.getJsonReadOnlyState());
            }
            supportSQLiteStatement.bindLong(9, channelEntity2.isDeleted() ? 1 : 0);
            supportSQLiteStatement.bindLong(10, channelEntity2.isRead() ? 1 : 0);
            supportSQLiteStatement.bindLong(11, channelEntity2.isSpam() ? 1 : 0);
            supportSQLiteStatement.bindLong(12, channelEntity2.isAnswered() ? 1 : 0);
            if (channelEntity2.getJsonContextActions() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, channelEntity2.getJsonContextActions());
            }
            if (channelEntity2.getJsonDealAction() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, channelEntity2.getJsonDealAction());
            }
            if (channelEntity2.getFlow() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, channelEntity2.getFlow());
            }
            if (channelEntity2.getSuspectMessageId() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, channelEntity2.getSuspectMessageId());
            }
            if (channelEntity2.getItemId() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, channelEntity2.getItemId());
            }
            if (channelEntity2.getInterlocutorId() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, channelEntity2.getInterlocutorId());
            }
            if (channelEntity2.getJsonDisplayInfo() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, channelEntity2.getJsonDisplayInfo());
            }
            if (channelEntity2.getJsonInputState() == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, channelEntity2.getJsonInputState());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `channel` (`user_id`,`channel_id`,`type`,`created`,`updated`,`context_type`,`json_context`,`json_read_only_state`,`is_deleted`,`is_read`,`is_spam`,`is_answered`,`json_context_actions`,`json_deal_action`,`flow`,`suspect_message_id`,`item_id`,`interlocutor_id`,`json_display_info`,`json_input_state`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class l implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public l(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
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

    public class m implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public m(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
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

    public class n implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public n(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
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

    public class o implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public o(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
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

    public class p implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public p(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
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

    public class q implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public q(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
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

    public class r implements Callable<List<Long>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public r(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            Long l;
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(0)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(0));
                    }
                    arrayList.add(l);
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

    public class s implements Callable<List<Long>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public s(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            Long l;
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(0)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(0));
                    }
                    arrayList.add(l);
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

    public class t implements Callable<List<Long>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public t(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            Long l;
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(0)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(0));
                    }
                    arrayList.add(l);
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

    public class u implements Callable<List<ChannelEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public u(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelEntity> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_UPDATED);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_CONTEXT_TYPE);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT);
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_READ_ONLY_STATE);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_DELETED);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_ANSWERED);
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS);
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DEAL_ACTION);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "flow");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "item_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DISPLAY_INFO);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_INPUT_STATE);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow12) != 0;
                    String string7 = query.getString(columnIndexOrThrow13);
                    String string8 = query.getString(i);
                    String string9 = query.getString(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    String string10 = query.getString(columnIndexOrThrow16);
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    String string11 = query.getString(columnIndexOrThrow17);
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    String string12 = query.getString(columnIndexOrThrow18);
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    String string13 = query.getString(columnIndexOrThrow19);
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                    String string14 = query.getString(columnIndexOrThrow20);
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    arrayList.add(new ChannelEntity(string, string2, string3, j, j2, string4, string5, string6, z, z2, z3, z4, string7, string8, string9, string10, string11, string12, string13, string14));
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i;
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

    public class v extends EntityInsertionAdapter<UserEntity> {
        public v(ChannelDao_Impl channelDao_Impl, RoomDatabase roomDatabase) {
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

    public class w implements Callable<List<ChannelEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public w(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelEntity> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_UPDATED);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_CONTEXT_TYPE);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT);
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_READ_ONLY_STATE);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_DELETED);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_ANSWERED);
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS);
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DEAL_ACTION);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "flow");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "item_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DISPLAY_INFO);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_INPUT_STATE);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow12) != 0;
                    String string7 = query.getString(columnIndexOrThrow13);
                    String string8 = query.getString(i);
                    String string9 = query.getString(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    String string10 = query.getString(columnIndexOrThrow16);
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    String string11 = query.getString(columnIndexOrThrow17);
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    String string12 = query.getString(columnIndexOrThrow18);
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    String string13 = query.getString(columnIndexOrThrow19);
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                    String string14 = query.getString(columnIndexOrThrow20);
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    arrayList.add(new ChannelEntity(string, string2, string3, j, j2, string4, string5, string6, z, z2, z3, z4, string7, string8, string9, string10, string11, string12, string13, string14));
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i;
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

    public class x implements Callable<List<ChannelEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public x(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelEntity> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_UPDATED);
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_CONTEXT_TYPE);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT);
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_READ_ONLY_STATE);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_DELETED);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_ANSWERED);
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS);
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DEAL_ACTION);
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "flow");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "item_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "interlocutor_id");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_DISPLAY_INFO);
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_JSON_INPUT_STATE);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow12) != 0;
                    String string7 = query.getString(columnIndexOrThrow13);
                    String string8 = query.getString(i);
                    String string9 = query.getString(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    String string10 = query.getString(columnIndexOrThrow16);
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    String string11 = query.getString(columnIndexOrThrow17);
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    String string12 = query.getString(columnIndexOrThrow18);
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    String string13 = query.getString(columnIndexOrThrow19);
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                    String string14 = query.getString(columnIndexOrThrow20);
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    arrayList.add(new ChannelEntity(string, string2, string3, j, j2, string4, string5, string6, z, z2, z3, z4, string7, string8, string9, string10, string11, string12, string13, string14));
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i;
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

    public class y implements Callable<List<String>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public y(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<String> call() throws Exception {
            Cursor query = DBUtil.query(ChannelDao_Impl.this.a, this.a, false, null);
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

    public class z extends EntityInsertionAdapter<ChannelTag> {
        public z(ChannelDao_Impl channelDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ChannelTag channelTag) {
            ChannelTag channelTag2 = channelTag;
            if (channelTag2.getLocalUserId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, channelTag2.getLocalUserId());
            }
            if (channelTag2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, channelTag2.getChannelId());
            }
            if (channelTag2.getTag() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, channelTag2.getTag());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `channel_tag` (`local_user_id`,`channel_id`,`tag`) VALUES (?,?,?)";
        }
    }

    public ChannelDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new k(this, roomDatabase);
        this.c = new v(this, roomDatabase);
        this.d = new z(this, roomDatabase);
        this.e = new a0(this, roomDatabase);
        this.f = new b0(this, roomDatabase);
        this.g = new c0(this, roomDatabase);
        this.h = new d0(this, roomDatabase);
        this.i = new e0(this, roomDatabase);
        this.j = new f0(this, roomDatabase);
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public int deleteChannel(String str, String str2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.h.acquire();
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
            this.h.release(acquire);
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public void deleteChannelAndTags(String str, String str2) {
        this.a.beginTransaction();
        try {
            super.deleteChannelAndTags(str, str2);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Completable deleteChannelContextActions(String str, String str2) {
        return Completable.fromCallable(new b(str, str2));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public int deleteChannelTags(String str, String str2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.j.acquire();
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
            this.j.release(acquire);
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public void deleteChannelsAndTags(String str, Collection<String> collection) {
        this.a.beginTransaction();
        try {
            super.deleteChannelsAndTags(str, collection);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public int deleteChannelsById(String str, Collection<String> collection) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("\n");
        newStringBuilder.append("            DELETE FROM channel");
        newStringBuilder.append("\n");
        newStringBuilder.append("            WHERE");
        a2.b.a.a.a.n1(newStringBuilder, "\n", "                user_id = ", "?", "\n");
        newStringBuilder.append("                AND channel_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, collection.size());
        newStringBuilder.append(")");
        newStringBuilder.append("\n");
        newStringBuilder.append("        ");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        if (str == null) {
            compileStatement.bindNull(1);
        } else {
            compileStatement.bindString(1, str);
        }
        int i2 = 2;
        for (String str2 : collection) {
            if (str2 == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str2);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public int deleteChannelsTags(String str, Collection<String> collection) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("\n");
        newStringBuilder.append("            DELETE FROM channel_tag");
        newStringBuilder.append("\n");
        newStringBuilder.append("            WHERE");
        a2.b.a.a.a.n1(newStringBuilder, "\n", "                local_user_id = ", "?", "\n");
        newStringBuilder.append("                AND channel_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, collection.size());
        newStringBuilder.append(")");
        newStringBuilder.append("\n");
        newStringBuilder.append("        ");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        if (str == null) {
            compileStatement.bindNull(1);
        } else {
            compileStatement.bindString(1, str);
        }
        int i2 = 2;
        for (String str2 : collection) {
            if (str2 == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str2);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public void deleteNonEmptyChannelsAndTagsNewerThatTimestamp(String str, long j2, Collection<String> collection, Collection<String> collection2) {
        this.a.beginTransaction();
        try {
            super.deleteNonEmptyChannelsAndTagsNewerThatTimestamp(str, j2, collection, collection2);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public void deleteNonEmptyChannelsAndTagsOlderThanTimestamp(String str, long j2, Collection<String> collection, Collection<String> collection2) {
        this.a.beginTransaction();
        try {
            super.deleteNonEmptyChannelsAndTagsOlderThanTimestamp(str, j2, collection, collection2);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<ChannelEntity>> getAllChannels(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT * FROM channel\n            WHERE user_id = ?\n            ORDER BY updated DESC\n        ", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel"}, new f(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<String>> getAvitoChannelId(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT channel_id FROM channel\n            WHERE user_id = ? AND type = \"a2u\"\n        ", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel"}, new e(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<ChannelEntity>> getChannel(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT * FROM channel\n            WHERE user_id = ? AND channel_id = ?\n        ", 2);
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
        return RxRoom.createObservable(this.a, false, new String[]{"channel"}, new c(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<String>> getChannelIdByItemId(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT channel_id FROM channel\n            WHERE user_id = ? AND item_id = ?\n        ", 2);
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
        return RxRoom.createObservable(this.a, false, new String[]{"channel"}, new d(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<String> getChannelIdByItemIdAndInterlocutorId(String str, String str2, String str3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT channel_id FROM channel\n            WHERE \n                user_id = ? \n                AND item_id = ?\n                AND interlocutor_id = ?\n        ", 3);
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
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<ChannelEntity>> getChannels(String str, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT ", "*", " FROM channel", "\n");
        a2.b.a.a.a.n1(V, "            WHERE", "\n", "                user_id = ", "?");
        V.append("\n");
        V.append("                AND channel_id IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(a2.b.a.a.a.t(V, "\n", "        "), size + 1);
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
        return RxRoom.createObservable(this.a, false, new String[]{"channel"}, new g(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<ChannelEntity>> getChannelsStartingFromTimestamp(String str, long j2, Collection<String> collection, Collection<String> collection2) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT", "\n", "                ", "c.*");
        a2.b.a.a.a.n1(V, ",", "\n", "                MAX(c.updated, IFNULL(last_messages.created, 0)) AS c_date", "\n");
        a2.b.a.a.a.n1(V, "            FROM channel AS c", "\n", "            LEFT JOIN (", "\n");
        a2.b.a.a.a.n1(V, "                    SELECT ", "\n", "                        m.channel_id AS channel_id,", "\n");
        a2.b.a.a.a.n1(V, "                        MAX(m.created) AS created", "\n", "                    FROM message AS m", "\n");
        a2.b.a.a.a.n1(V, "                    WHERE m.user_id = ", "?", "\n", "                    GROUP BY m.channel_id");
        a2.b.a.a.a.n1(V, "\n", "                ) AS last_messages", "\n", "                ON last_messages.channel_id = c.channel_id");
        a2.b.a.a.a.n1(V, "\n", "            WHERE ", "\n", "                c.user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                AND c_date >= ", "?");
        a2.b.a.a.a.n1(V, "\n", "                AND EXISTS (", "\n", "                    SELECT tag ");
        a2.b.a.a.a.n1(V, "\n", "                    FROM channel_tag AS c_tag", "\n", "                    WHERE");
        a2.b.a.a.a.n1(V, "\n", "                        c_tag.local_user_id = ", "?", "\n");
        V.append("                        AND c_tag.channel_id = c.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("                    LIMIT 1");
        V.append("\n");
        V.append("                )");
        a2.b.a.a.a.n1(V, "\n", "                AND NOT EXISTS (", "\n", "                    SELECT tag ");
        a2.b.a.a.a.n1(V, "\n", "                    FROM channel_tag AS c_tag", "\n", "                    WHERE");
        a2.b.a.a.a.n1(V, "\n", "                        c_tag.local_user_id = ", "?", "\n");
        V.append("                        AND c_tag.channel_id = c.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size2 = collection2.size();
        StringUtil.appendPlaceholders(V, size2);
        V.append(")");
        V.append("\n");
        V.append("                    LIMIT 1");
        V.append("\n");
        V.append("                )");
        String v2 = a2.b.a.a.a.v(V, "\n", "            ORDER BY c_date DESC", "\n", "        ");
        int i2 = size + 5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(v2, size2 + i2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        acquire.bindLong(3, j2);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        int i3 = 5;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str2);
            }
            i3++;
        }
        if (str == null) {
            acquire.bindNull(i2);
        } else {
            acquire.bindString(i2, str);
        }
        int i4 = size + 6;
        for (String str3 : collection2) {
            if (str3 == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, str3);
            }
            i4++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new h(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<ChannelEntity>> getEmptyChannelsNewerThanTimestamp(String str, long j2, Collection<String> collection, Collection<String> collection2) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT ", "*", " FROM channel", "\n");
        a2.b.a.a.a.n1(V, "            WHERE ", "\n", "                user_id = ", "?");
        a2.b.a.a.a.n1(V, "\n", "                AND updated > ", "?", "\n");
        a2.b.a.a.a.n1(V, "                AND created > ", "?", " ", "\n");
        a2.b.a.a.a.n1(V, "                AND NOT EXISTS (", "\n", "                    SELECT message.local_id FROM message", "\n");
        a2.b.a.a.a.n1(V, "                    WHERE ", "\n", "                        message.user_id = ", "?");
        a2.b.a.a.a.n1(V, "\n", "                        AND message.channel_id = channel.channel_id", "\n", "                        AND message.remote_id IS NOT NULL");
        a2.b.a.a.a.n1(V, "\n", "                    LIMIT 1", "\n", "                )");
        a2.b.a.a.a.n1(V, "\n", "                AND EXISTS (", "\n", "                    SELECT tag ");
        a2.b.a.a.a.n1(V, "\n", "                    FROM channel_tag AS c_tag", "\n", "                    WHERE");
        a2.b.a.a.a.n1(V, "\n", "                        c_tag.local_user_id = ", "?", "\n");
        V.append("                        AND c_tag.channel_id = channel.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("                    LIMIT 1");
        V.append("\n");
        V.append("                )");
        a2.b.a.a.a.n1(V, "\n", "                AND NOT EXISTS (", "\n", "                    SELECT tag ");
        a2.b.a.a.a.n1(V, "\n", "                    FROM channel_tag AS c_tag", "\n", "                    WHERE");
        a2.b.a.a.a.n1(V, "\n", "                        c_tag.local_user_id = ", "?", "\n");
        V.append("                        AND c_tag.channel_id = channel.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size2 = collection2.size();
        StringUtil.appendPlaceholders(V, size2);
        V.append(")");
        V.append("\n");
        V.append("                    LIMIT 1");
        V.append("\n");
        V.append("                )");
        int i2 = size + 6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(a2.b.a.a.a.t(V, "\n", "        "), size2 + i2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        acquire.bindLong(3, j2);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        if (str == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str);
        }
        int i3 = 6;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str2);
            }
            i3++;
        }
        if (str == null) {
            acquire.bindNull(i2);
        } else {
            acquire.bindString(i2, str);
        }
        int i4 = size + 7;
        for (String str3 : collection2) {
            if (str3 == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, str3);
            }
            i4++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new u(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<String>> getIdsOfEmptyChannelsOlderThanTimestamp(String str, long j2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = ?\n                AND updated < ?\n                AND created < ? \n                AND NOT EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE\n                        message.user_id = ?\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n        ", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        acquire.bindLong(3, j2);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message"}, new y(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<String> getIdsOfNonEmptyChannelsNewerThatTimestamp(String str, long j2, Collection<String> collection, Collection<String> collection2) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT channel_id FROM channel", "\n", "            WHERE", "\n");
        a2.b.a.a.a.n1(V, "                user_id = ", "?", "\n", "                AND updated > ");
        a2.b.a.a.a.n1(V, "?", "\n", "                AND EXISTS (", "\n");
        a2.b.a.a.a.n1(V, "                    SELECT message.local_id FROM message", "\n", "                    WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                        message.user_id = ", "?", "\n", "                        AND message.channel_id = channel.channel_id");
        a2.b.a.a.a.n1(V, "\n", "                        AND message.remote_id IS NOT NULL", "\n", "                    LIMIT 1");
        a2.b.a.a.a.n1(V, "\n", "                )", "\n", "                AND EXISTS (");
        a2.b.a.a.a.n1(V, "\n", "                    SELECT tag ", "\n", "                    FROM channel_tag AS c_tag");
        a2.b.a.a.a.n1(V, "\n", "                    WHERE", "\n", "                        c_tag.local_user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                        AND c_tag.channel_id = channel.channel_id", "\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    LIMIT 1", "\n", "                )", "\n");
        a2.b.a.a.a.n1(V, "                AND NOT EXISTS (", "\n", "                    SELECT tag ", "\n");
        a2.b.a.a.a.n1(V, "                    FROM channel_tag AS c_tag", "\n", "                    WHERE", "\n");
        a2.b.a.a.a.n1(V, "                        c_tag.local_user_id = ", "?", "\n", "                        AND c_tag.channel_id = channel.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size2 = collection2.size();
        StringUtil.appendPlaceholders(V, size2);
        V.append(")");
        a2.b.a.a.a.n1(V, "\n", "                    LIMIT 1", "\n", "                )");
        String t2 = a2.b.a.a.a.t(V, "\n", "        ");
        int i2 = size + 5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(t2, size2 + i2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        int i3 = 5;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str2);
            }
            i3++;
        }
        if (str == null) {
            acquire.bindNull(i2);
        } else {
            acquire.bindString(i2, str);
        }
        int i4 = size + 6;
        for (String str3 : collection2) {
            if (str3 == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, str3);
            }
            i4++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<String> getIdsOfNonEmptyChannelsOlderThanTimestamp(String str, long j2, Collection<String> collection, Collection<String> collection2) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT channel_id FROM channel", "\n", "            WHERE", "\n");
        a2.b.a.a.a.n1(V, "                user_id = ", "?", "\n", "                AND updated < ");
        a2.b.a.a.a.n1(V, "?", "\n", "                AND EXISTS (", "\n");
        a2.b.a.a.a.n1(V, "                    SELECT message.local_id FROM message", "\n", "                    WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                        message.user_id = ", "?", "\n", "                        AND message.channel_id = channel.channel_id");
        a2.b.a.a.a.n1(V, "\n", "                        AND message.remote_id IS NOT NULL", "\n", "                    LIMIT 1");
        a2.b.a.a.a.n1(V, "\n", "                )", "\n", "                AND EXISTS (");
        a2.b.a.a.a.n1(V, "\n", "                    SELECT tag ", "\n", "                    FROM channel_tag AS c_tag");
        a2.b.a.a.a.n1(V, "\n", "                    WHERE", "\n", "                        c_tag.local_user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                        AND c_tag.channel_id = channel.channel_id", "\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    LIMIT 1", "\n", "                )", "\n");
        a2.b.a.a.a.n1(V, "                AND NOT EXISTS (", "\n", "                    SELECT tag ", "\n");
        a2.b.a.a.a.n1(V, "                    FROM channel_tag AS c_tag", "\n", "                    WHERE", "\n");
        a2.b.a.a.a.n1(V, "                        c_tag.local_user_id = ", "?", "\n", "                        AND c_tag.channel_id = channel.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size2 = collection2.size();
        StringUtil.appendPlaceholders(V, size2);
        V.append(")");
        a2.b.a.a.a.n1(V, "\n", "                    LIMIT 1", "\n", "                )");
        String t2 = a2.b.a.a.a.t(V, "\n", "        ");
        int i2 = size + 5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(t2, size2 + i2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        int i3 = 5;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str2);
            }
            i3++;
        }
        if (str == null) {
            acquire.bindNull(i2);
        } else {
            acquire.bindString(i2, str);
        }
        int i4 = size + 6;
        for (String str3 : collection2) {
            if (str3 == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, str3);
            }
            i4++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<String>> getNonEmptyChannelIds(String str, int i2, int i3, Collection<String> collection, Collection<String> collection2) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT channel.channel_id FROM channel", "\n", "            WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                user_id = ", "?", "\n", "                AND EXISTS (");
        a2.b.a.a.a.n1(V, "\n", "                    SELECT message.local_id FROM message", "\n", "                    WHERE ");
        a2.b.a.a.a.n1(V, "\n", "                        message.user_id = ", "?", "\n");
        a2.b.a.a.a.n1(V, "                        AND message.channel_id = channel.channel_id", "\n", "                        AND message.remote_id IS NOT NULL", "\n");
        a2.b.a.a.a.n1(V, "                    LIMIT 1", "\n", "                )", "\n");
        a2.b.a.a.a.n1(V, "                AND EXISTS (", "\n", "                    SELECT tag ", "\n");
        a2.b.a.a.a.n1(V, "                    FROM channel_tag AS c_tag", "\n", "                    WHERE", "\n");
        a2.b.a.a.a.n1(V, "                        c_tag.local_user_id = ", "?", "\n", "                        AND c_tag.channel_id = channel.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        a2.b.a.a.a.n1(V, "\n", "                    LIMIT 1", "\n", "                )");
        a2.b.a.a.a.n1(V, "\n", "                AND NOT EXISTS (", "\n", "                    SELECT tag ");
        a2.b.a.a.a.n1(V, "\n", "                    FROM channel_tag AS c_tag", "\n", "                    WHERE");
        a2.b.a.a.a.n1(V, "\n", "                        c_tag.local_user_id = ", "?", "\n");
        V.append("                        AND c_tag.channel_id = channel.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size2 = collection2.size();
        StringUtil.appendPlaceholders(V, size2);
        V.append(")");
        V.append("\n");
        V.append("                    LIMIT 1");
        V.append("\n");
        V.append("                )");
        a2.b.a.a.a.n1(V, "\n", "            ORDER BY updated DESC", "\n", "            LIMIT ");
        a2.b.a.a.a.n1(V, "?", " OFFSET ", "?", "\n");
        V.append("        ");
        String sb = V.toString();
        int i4 = size + 6 + size2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(sb, i4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        int i5 = 4;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i5);
            } else {
                acquire.bindString(i5, str2);
            }
            i5++;
        }
        int i6 = size + 4;
        if (str == null) {
            acquire.bindNull(i6);
        } else {
            acquire.bindString(i6, str);
        }
        int i7 = size + 5;
        int i8 = i7;
        for (String str3 : collection2) {
            if (str3 == null) {
                acquire.bindNull(i8);
            } else {
                acquire.bindString(i8, str3);
            }
            i8++;
        }
        acquire.bindLong(i7 + size2, (long) i3);
        acquire.bindLong(i4, (long) i2);
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new l(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<Long>> getTimestampOfNonEmptyChannelAtPosition(String str, int i2, Collection<String> collection, Collection<String> collection2) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT MIN(updated) FROM (", "\n", "                SELECT updated FROM channel", "\n");
        a2.b.a.a.a.n1(V, "                WHERE ", "\n", "                    user_id = ", "?");
        a2.b.a.a.a.n1(V, "\n", "                    AND EXISTS (", "\n", "                        SELECT message.local_id FROM message");
        a2.b.a.a.a.n1(V, "\n", "                        WHERE ", "\n", "                            message.user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                            AND message.channel_id = channel.channel_id", "\n");
        a2.b.a.a.a.n1(V, "                            AND message.remote_id IS NOT NULL", "\n", "                        LIMIT 1", "\n");
        a2.b.a.a.a.n1(V, "                    )", "\n", "                    AND EXISTS (", "\n");
        a2.b.a.a.a.n1(V, "                        SELECT tag ", "\n", "                        FROM channel_tag AS c_tag", "\n");
        a2.b.a.a.a.n1(V, "                        WHERE", "\n", "                            c_tag.local_user_id = ", "?");
        a2.b.a.a.a.n1(V, "\n", "                            AND c_tag.channel_id = channel.channel_id", "\n", "                            AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("                        LIMIT 1");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    )", "\n", "                    AND NOT EXISTS (", "\n");
        a2.b.a.a.a.n1(V, "                        SELECT tag ", "\n", "                        FROM channel_tag AS c_tag", "\n");
        a2.b.a.a.a.n1(V, "                        WHERE", "\n", "                            c_tag.local_user_id = ", "?");
        a2.b.a.a.a.n1(V, "\n", "                            AND c_tag.channel_id = channel.channel_id", "\n", "                            AND c_tag.tag IN (");
        int size2 = collection2.size();
        StringUtil.appendPlaceholders(V, size2);
        V.append(")");
        V.append("\n");
        V.append("                        LIMIT 1");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    )", "\n", "                ORDER BY updated DESC", "\n");
        a2.b.a.a.a.n1(V, "                LIMIT ", "?", " + 1", "\n");
        String u2 = a2.b.a.a.a.u(V, "            )", "\n", "        ");
        int i3 = size + 5;
        int i4 = size2 + i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(u2, i4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        int i5 = 4;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i5);
            } else {
                acquire.bindString(i5, str2);
            }
            i5++;
        }
        int i6 = size + 4;
        if (str == null) {
            acquire.bindNull(i6);
        } else {
            acquire.bindString(i6, str);
        }
        for (String str3 : collection2) {
            if (str3 == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str3);
            }
            i3++;
        }
        acquire.bindLong(i4, (long) i2);
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new r(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public long insertChannel(ChannelEntity channelEntity) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(channelEntity);
            this.a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<Long> insertChannelTags(Collection<ChannelTag> collection) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.d.insertAndReturnIdsList(collection);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public void insertChannelWithUsersAndLastMessage(ChannelEntity channelEntity, Collection<UserEntity> collection, Collection<ChannelTag> collection2, MessageEntity messageEntity) {
        this.a.beginTransaction();
        try {
            super.insertChannelWithUsersAndLastMessage(channelEntity, collection, collection2, messageEntity);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<Long> insertChannels(Collection<ChannelEntity> collection) {
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

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public void insertChannelsWithUsersAndLastMessages(Collection<ChannelEntity> collection, Collection<UserEntity> collection2, Collection<ChannelTag> collection3, Collection<MessageEntity> collection4) {
        this.a.beginTransaction();
        try {
            super.insertChannelsWithUsersAndLastMessages(collection, collection2, collection3, collection4);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public long insertMessageIfItDoesNotExist(MessageEntity messageEntity) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long insertAndReturnId = this.e.insertAndReturnId(messageEntity);
            this.a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<Long> insertMessagesIfTheyDoNotExist(Collection<MessageEntity> collection) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.e.insertAndReturnIdsList(collection);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public long insertUser(UserEntity userEntity) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long insertAndReturnId = this.c.insertAndReturnId(userEntity);
            this.a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<Long> insertUsers(Collection<UserEntity> collection) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.c.insertAndReturnIdsList(collection);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Completable setChannelIsRead(String str, String str2) {
        return Completable.fromCallable(new a(str, str2));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public void deleteChannelAndTags(String str, String str2, String str3) {
        this.a.beginTransaction();
        try {
            super.deleteChannelAndTags(str, str2, str3);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public int deleteChannel(String str, String str2, String str3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.i.acquire();
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
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.i.release(acquire);
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<Long>> getTimestampOfNonEmptyChannelAtPosition(String str, int i2, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT MIN(updated) FROM (", "\n", "                SELECT updated FROM channel", "\n");
        a2.b.a.a.a.n1(V, "                WHERE ", "\n", "                    user_id = ", "?");
        a2.b.a.a.a.n1(V, "\n", "                    AND EXISTS (", "\n", "                        SELECT message.local_id FROM message");
        a2.b.a.a.a.n1(V, "\n", "                        WHERE ", "\n", "                            message.user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                            AND message.channel_id = channel.channel_id", "\n");
        a2.b.a.a.a.n1(V, "                            AND message.remote_id IS NOT NULL", "\n", "                        LIMIT 1", "\n");
        a2.b.a.a.a.n1(V, "                    )", "\n", "                    AND NOT EXISTS (", "\n");
        a2.b.a.a.a.n1(V, "                        SELECT tag ", "\n", "                        FROM channel_tag AS c_tag", "\n");
        a2.b.a.a.a.n1(V, "                        WHERE", "\n", "                            c_tag.local_user_id = ", "?");
        a2.b.a.a.a.n1(V, "\n", "                            AND c_tag.channel_id = channel.channel_id", "\n", "                            AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("                        LIMIT 1");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    )", "\n", "                ORDER BY updated DESC", "\n");
        a2.b.a.a.a.n1(V, "                LIMIT ", "?", " + 1", "\n");
        String u2 = a2.b.a.a.a.u(V, "            )", "\n", "        ");
        int i3 = 4;
        int i4 = size + 4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(u2, i4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str2);
            }
            i3++;
        }
        acquire.bindLong(i4, (long) i2);
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new s(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<String>> getNonEmptyChannelIds(String str, int i2, int i3, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT channel.channel_id FROM channel", "\n", "            WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                user_id = ", "?", "\n", "                AND EXISTS (");
        a2.b.a.a.a.n1(V, "\n", "                    SELECT message.local_id FROM message", "\n", "                    WHERE ");
        a2.b.a.a.a.n1(V, "\n", "                        message.user_id = ", "?", "\n");
        a2.b.a.a.a.n1(V, "                        AND message.channel_id = channel.channel_id", "\n", "                        AND message.remote_id IS NOT NULL", "\n");
        a2.b.a.a.a.n1(V, "                    LIMIT 1", "\n", "                )", "\n");
        a2.b.a.a.a.n1(V, "                AND NOT EXISTS (", "\n", "                    SELECT tag ", "\n");
        a2.b.a.a.a.n1(V, "                    FROM channel_tag AS c_tag", "\n", "                    WHERE", "\n");
        a2.b.a.a.a.n1(V, "                        c_tag.local_user_id = ", "?", "\n", "                        AND c_tag.channel_id = channel.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        a2.b.a.a.a.n1(V, "\n", "                    LIMIT 1", "\n", "                )");
        a2.b.a.a.a.n1(V, "\n", "            ORDER BY updated DESC", "\n", "            LIMIT ");
        a2.b.a.a.a.n1(V, "?", " OFFSET ", "?", "\n");
        V.append("        ");
        String sb = V.toString();
        int i4 = size + 5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(sb, i4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        int i5 = 4;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i5);
            } else {
                acquire.bindString(i5, str2);
            }
            i5++;
        }
        acquire.bindLong(size + 4, (long) i3);
        acquire.bindLong(i4, (long) i2);
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new m(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<ChannelEntity>> getChannelsStartingFromTimestamp(String str, long j2, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT", "\n", "                ", "c.*");
        a2.b.a.a.a.n1(V, ",", "\n", "                MAX(c.updated, IFNULL(last_messages.created, 0)) AS c_date", "\n");
        a2.b.a.a.a.n1(V, "            FROM channel AS c", "\n", "            LEFT JOIN (", "\n");
        a2.b.a.a.a.n1(V, "                    SELECT ", "\n", "                        m.channel_id AS channel_id,", "\n");
        a2.b.a.a.a.n1(V, "                        MAX(m.created) AS created", "\n", "                    FROM message AS m", "\n");
        a2.b.a.a.a.n1(V, "                    WHERE m.user_id = ", "?", "\n", "                    GROUP BY m.channel_id");
        a2.b.a.a.a.n1(V, "\n", "                ) AS last_messages", "\n", "                ON last_messages.channel_id = c.channel_id");
        a2.b.a.a.a.n1(V, "\n", "            WHERE ", "\n", "                c.user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                AND c_date >= ", "?");
        a2.b.a.a.a.n1(V, "\n", "                AND NOT EXISTS (", "\n", "                    SELECT tag ");
        a2.b.a.a.a.n1(V, "\n", "                    FROM channel_tag AS c_tag", "\n", "                    WHERE");
        a2.b.a.a.a.n1(V, "\n", "                        c_tag.local_user_id = ", "?", "\n");
        V.append("                        AND c_tag.channel_id = c.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("                    LIMIT 1");
        V.append("\n");
        V.append("                )");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(a2.b.a.a.a.v(V, "\n", "            ORDER BY c_date DESC", "\n", "        "), size + 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        acquire.bindLong(3, j2);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        int i2 = 5;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str2);
            }
            i2++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new i(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<ChannelEntity>> getEmptyChannelsNewerThanTimestamp(String str, long j2, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT ", "*", " FROM channel", "\n");
        a2.b.a.a.a.n1(V, "            WHERE ", "\n", "                user_id = ", "?");
        a2.b.a.a.a.n1(V, "\n", "                AND updated > ", "?", "\n");
        a2.b.a.a.a.n1(V, "                AND created > ", "?", " ", "\n");
        a2.b.a.a.a.n1(V, "                AND NOT EXISTS (", "\n", "                    SELECT message.local_id FROM message", "\n");
        a2.b.a.a.a.n1(V, "                    WHERE ", "\n", "                        message.user_id = ", "?");
        a2.b.a.a.a.n1(V, "\n", "                        AND message.channel_id = channel.channel_id", "\n", "                        AND message.remote_id IS NOT NULL");
        a2.b.a.a.a.n1(V, "\n", "                    LIMIT 1", "\n", "                )");
        a2.b.a.a.a.n1(V, "\n", "                AND NOT EXISTS (", "\n", "                    SELECT tag ");
        a2.b.a.a.a.n1(V, "\n", "                    FROM channel_tag AS c_tag", "\n", "                    WHERE");
        a2.b.a.a.a.n1(V, "\n", "                        c_tag.local_user_id = ", "?", "\n");
        V.append("                        AND c_tag.channel_id = channel.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("                    LIMIT 1");
        V.append("\n");
        V.append("                )");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(a2.b.a.a.a.t(V, "\n", "        "), size + 5);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        acquire.bindLong(3, j2);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        if (str == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str);
        }
        int i2 = 6;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str2);
            }
            i2++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new w(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<String> getIdsOfNonEmptyChannelsNewerThatTimestamp(String str, long j2, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT channel_id FROM channel", "\n", "            WHERE", "\n");
        a2.b.a.a.a.n1(V, "                user_id = ", "?", "\n", "                AND updated > ");
        a2.b.a.a.a.n1(V, "?", "\n", "                AND EXISTS (", "\n");
        a2.b.a.a.a.n1(V, "                    SELECT message.local_id FROM message", "\n", "                    WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                        message.user_id = ", "?", "\n", "                        AND message.channel_id = channel.channel_id");
        a2.b.a.a.a.n1(V, "\n", "                        AND message.remote_id IS NOT NULL", "\n", "                    LIMIT 1");
        a2.b.a.a.a.n1(V, "\n", "                )", "\n", "                AND NOT EXISTS (");
        a2.b.a.a.a.n1(V, "\n", "                    SELECT tag ", "\n", "                    FROM channel_tag AS c_tag");
        a2.b.a.a.a.n1(V, "\n", "                    WHERE", "\n", "                        c_tag.local_user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                        AND c_tag.channel_id = channel.channel_id", "\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    LIMIT 1", "\n", "                )", "\n");
        V.append("        ");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(V.toString(), size + 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        int i2 = 5;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str2);
            }
            i2++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<String> getIdsOfNonEmptyChannelsOlderThanTimestamp(String str, long j2, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT channel_id FROM channel", "\n", "            WHERE", "\n");
        a2.b.a.a.a.n1(V, "                user_id = ", "?", "\n", "                AND updated < ");
        a2.b.a.a.a.n1(V, "?", "\n", "                AND EXISTS (", "\n");
        a2.b.a.a.a.n1(V, "                    SELECT message.local_id FROM message", "\n", "                    WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                        message.user_id = ", "?", "\n", "                        AND message.channel_id = channel.channel_id");
        a2.b.a.a.a.n1(V, "\n", "                        AND message.remote_id IS NOT NULL", "\n", "                    LIMIT 1");
        a2.b.a.a.a.n1(V, "\n", "                )", "\n", "                AND NOT EXISTS (");
        a2.b.a.a.a.n1(V, "\n", "                    SELECT tag ", "\n", "                    FROM channel_tag AS c_tag");
        a2.b.a.a.a.n1(V, "\n", "                    WHERE", "\n", "                        c_tag.local_user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                        AND c_tag.channel_id = channel.channel_id", "\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    LIMIT 1", "\n", "                )", "\n");
        V.append("        ");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(V.toString(), size + 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        int i2 = 5;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str2);
            }
            i2++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<Long>> getTimestampOfNonEmptyChannelAtPosition(String str, int i2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT MIN(updated) FROM (\n                SELECT updated FROM channel\n                WHERE \n                    user_id = ?\n                    AND EXISTS (\n                        SELECT message.local_id FROM message\n                        WHERE \n                            message.user_id = ?\n                            AND message.channel_id = channel.channel_id\n                            AND message.remote_id IS NOT NULL\n                        LIMIT 1\n                    )\n                ORDER BY updated DESC\n                LIMIT ? + 1\n            )\n        ", 3);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        acquire.bindLong(3, (long) i2);
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message"}, new t(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<String>> getNonEmptyChannelIds(String str, int i2, int i3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = ?\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = ?\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n            ORDER BY updated DESC\n            LIMIT ? OFFSET ?\n        ", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        acquire.bindLong(3, (long) i3);
        acquire.bindLong(4, (long) i2);
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message"}, new n(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<ChannelEntity>> getChannelsStartingFromTimestamp(String str, long j2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT\n                c.*,\n                MAX(c.updated, IFNULL(last_messages.created, 0)) AS c_date\n            FROM channel AS c\n            LEFT JOIN (\n                    SELECT \n                        m.channel_id AS channel_id,\n                        MAX(m.created) AS created\n                    FROM message AS m\n                    WHERE m.user_id = ?\n                    GROUP BY m.channel_id\n                ) AS last_messages\n                ON last_messages.channel_id = c.channel_id\n            WHERE \n                c.user_id = ?\n                AND c_date >= ?\n            ORDER BY c_date DESC\n        ", 3);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        acquire.bindLong(3, j2);
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message"}, new j(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<ChannelEntity>> getEmptyChannelsNewerThanTimestamp(String str, long j2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT * FROM channel\n            WHERE \n                user_id = ?\n                AND updated > ?\n                AND created > ? \n                AND NOT EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = ?\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n        ", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        acquire.bindLong(3, j2);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message"}, new x(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<String>> getNonEmptyChannelIds(String str, long j2, long j3, Collection<String> collection, Collection<String> collection2) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT channel.channel_id FROM channel", "\n", "            WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                user_id = ", "?", " ", "\n");
        a2.b.a.a.a.n1(V, "                AND updated <= ", "?", "\n", "                AND updated >= ");
        a2.b.a.a.a.n1(V, "?", "\n", "                AND EXISTS (", "\n");
        a2.b.a.a.a.n1(V, "                    SELECT message.local_id FROM message", "\n", "                    WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                        message.user_id = ", "?", "\n", "                        AND message.channel_id = channel.channel_id");
        a2.b.a.a.a.n1(V, "\n", "                        AND message.remote_id IS NOT NULL", "\n", "                    LIMIT 1");
        a2.b.a.a.a.n1(V, "\n", "                )", "\n", "                AND EXISTS (");
        a2.b.a.a.a.n1(V, "\n", "                    SELECT tag ", "\n", "                    FROM channel_tag AS c_tag");
        a2.b.a.a.a.n1(V, "\n", "                    WHERE", "\n", "                        c_tag.local_user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                        AND c_tag.channel_id = channel.channel_id", "\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    LIMIT 1", "\n", "                )", "\n");
        a2.b.a.a.a.n1(V, "                AND NOT EXISTS (", "\n", "                    SELECT tag ", "\n");
        a2.b.a.a.a.n1(V, "                    FROM channel_tag AS c_tag", "\n", "                    WHERE", "\n");
        a2.b.a.a.a.n1(V, "                        c_tag.local_user_id = ", "?", "\n", "                        AND c_tag.channel_id = channel.channel_id");
        V.append("\n");
        V.append("                        AND c_tag.tag IN (");
        int size2 = collection2.size();
        StringUtil.appendPlaceholders(V, size2);
        V.append(")");
        a2.b.a.a.a.n1(V, "\n", "                    LIMIT 1", "\n", "                )");
        String v2 = a2.b.a.a.a.v(V, "\n", "            ORDER BY updated DESC", "\n", "        ");
        int i2 = size + 6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(v2, size2 + i2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        acquire.bindLong(3, j3);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        if (str == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str);
        }
        int i3 = 6;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i3);
            } else {
                acquire.bindString(i3, str2);
            }
            i3++;
        }
        if (str == null) {
            acquire.bindNull(i2);
        } else {
            acquire.bindString(i2, str);
        }
        int i4 = size + 7;
        for (String str3 : collection2) {
            if (str3 == null) {
                acquire.bindNull(i4);
            } else {
                acquire.bindString(i4, str3);
            }
            i4++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new o(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<String> getIdsOfNonEmptyChannelsNewerThatTimestamp(String str, long j2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT channel_id FROM channel\n            WHERE\n                user_id = ?\n                AND updated > ?\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = ?\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n        ", 3);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public List<String> getIdsOfNonEmptyChannelsOlderThanTimestamp(String str, long j2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT channel_id FROM channel\n            WHERE\n                user_id = ?\n                AND updated < ?\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = ?\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n        ", 3);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<String>> getNonEmptyChannelIds(String str, long j2, long j3, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT channel.channel_id FROM channel", "\n", "            WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                user_id = ", "?", " ", "\n");
        a2.b.a.a.a.n1(V, "                AND updated <= ", "?", "\n", "                AND updated >= ");
        a2.b.a.a.a.n1(V, "?", "\n", "                AND EXISTS (", "\n");
        a2.b.a.a.a.n1(V, "                    SELECT message.local_id FROM message", "\n", "                    WHERE ", "\n");
        a2.b.a.a.a.n1(V, "                        message.user_id = ", "?", "\n", "                        AND message.channel_id = channel.channel_id");
        a2.b.a.a.a.n1(V, "\n", "                        AND message.remote_id IS NOT NULL", "\n", "                    LIMIT 1");
        a2.b.a.a.a.n1(V, "\n", "                )", "\n", "                AND NOT EXISTS (");
        a2.b.a.a.a.n1(V, "\n", "                    SELECT tag ", "\n", "                    FROM channel_tag AS c_tag");
        a2.b.a.a.a.n1(V, "\n", "                    WHERE", "\n", "                        c_tag.local_user_id = ");
        a2.b.a.a.a.n1(V, "?", "\n", "                        AND c_tag.channel_id = channel.channel_id", "\n");
        V.append("                        AND c_tag.tag IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    LIMIT 1", "\n", "                )", "\n");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(a2.b.a.a.a.u(V, "            ORDER BY updated DESC", "\n", "        "), size + 5);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        acquire.bindLong(3, j3);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        if (str == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str);
        }
        int i2 = 6;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str2);
            }
            i2++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message", "channel_tag"}, new p(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelDao
    public Observable<List<String>> getNonEmptyChannelIds(String str, long j2, long j3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = ? \n                AND updated <= ?\n                AND updated >= ?\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = ?\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n            ORDER BY updated DESC\n        ", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j2);
        acquire.bindLong(3, j3);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel", "message"}, new q(acquire));
    }
}
