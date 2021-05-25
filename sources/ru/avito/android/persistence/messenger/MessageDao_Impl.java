package ru.avito.android.persistence.messenger;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
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
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import ru.avito.android.persistence.messenger.IsReadStatus;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.TransferStatus;
public final class MessageDao_Impl implements MessageDao {
    public final RoomDatabase a;
    public final EntityInsertionAdapter<MessageEntity> b;
    public final EntityInsertionAdapter<MessageMetaInfo> c;
    public final EntityDeletionOrUpdateAdapter<MessageEntity> d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;
    public final SharedSQLiteStatement h;
    public final SharedSQLiteStatement i;

    public class a implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public a(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class a0 implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public a0(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class b implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public b(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class c implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public c(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class d implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public d(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class e implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public e(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class f implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public f(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class g implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public g(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class h implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public h(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class i implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public i(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class j implements Callable<Integer> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public j(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Integer num = null;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                if (query.moveToFirst()) {
                    if (!query.isNull(0)) {
                        num = Integer.valueOf(query.getInt(0));
                    }
                }
                return num;
            } finally {
                query.close();
            }
        }

        @Override // java.lang.Object
        public void finalize() {
            this.a.release();
        }
    }

    public class k extends EntityInsertionAdapter<MessageEntity> {
        public k(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
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
            return "INSERT OR REPLACE INTO `message` (`local_id`,`channel_id`,`remote_id`,`created`,`type`,`user_id`,`from_id`,`json_body`,`is_read`,`is_spam`,`is_failed`,`read_timestamp`,`preview_text`,`is_supported`,`is_complete`,`is_read_status`,`read_locally_timestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class l implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public l(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class m implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public m(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class n implements Callable<Integer> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public n(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Integer num = null;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                if (query.moveToFirst()) {
                    if (!query.isNull(0)) {
                        num = Integer.valueOf(query.getInt(0));
                    }
                }
                return num;
            } finally {
                query.close();
            }
        }

        @Override // java.lang.Object
        public void finalize() {
            this.a.release();
        }
    }

    public class o implements Callable<List<Long>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public o(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<Long> call() throws Exception {
            Long l;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
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

    public class p implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public p(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class q implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public q(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class r implements Callable<List<MessageEntity>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public r(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<MessageEntity> call() throws Exception {
            Long l;
            Long l2;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_LOCAL_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, MessageEntity.COLUMN_REMOTE_ID);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "created");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "type");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "user_id");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "from_id");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "json_body");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_READ);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, ChannelEntity.COLUMN_IS_SPAM);
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "is_failed");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "read_timestamp");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "preview_text");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "is_supported");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "is_complete");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "is_read_status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "read_locally_timestamp");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    String string3 = query.getString(columnIndexOrThrow3);
                    long j = query.getLong(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    String string7 = query.getString(columnIndexOrThrow8);
                    boolean z = query.getInt(columnIndexOrThrow9) != 0;
                    boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow11) != 0;
                    if (query.isNull(columnIndexOrThrow12)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow12));
                    }
                    String string8 = query.getString(columnIndexOrThrow13);
                    boolean z4 = query.getInt(i) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow15) != 0;
                    IsReadStatus stringToIsReadStatus = IsReadStatus.Converter.stringToIsReadStatus(query.getString(columnIndexOrThrow16));
                    if (query.isNull(columnIndexOrThrow17)) {
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(query.getLong(columnIndexOrThrow17));
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                    }
                    arrayList.add(new MessageEntity(string, string2, string3, j, string4, string5, string6, string7, z, z2, z3, l, string8, z4, z5, stringToIsReadStatus, l2));
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
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

    public class s implements Callable<Long> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public s(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Long call() throws Exception {
            Long l = null;
            Cursor query = DBUtil.query(MessageDao_Impl.this.a, this.a, false, null);
            try {
                if (query.moveToFirst()) {
                    if (!query.isNull(0)) {
                        l = Long.valueOf(query.getLong(0));
                    }
                }
                return l;
            } finally {
                query.close();
            }
        }

        @Override // java.lang.Object
        public void finalize() {
            this.a.release();
        }
    }

    public class t extends EntityInsertionAdapter<MessageMetaInfo> {
        public t(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
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

    public class u extends EntityDeletionOrUpdateAdapter<MessageEntity> {
        public u(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
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
            if (messageEntity2.getLocalId() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, messageEntity2.getLocalId());
            }
            if (messageEntity2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, messageEntity2.getChannelId());
            }
            if (messageEntity2.getUserId() == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, messageEntity2.getUserId());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR REPLACE `message` SET `local_id` = ?,`channel_id` = ?,`remote_id` = ?,`created` = ?,`type` = ?,`user_id` = ?,`from_id` = ?,`json_body` = ?,`is_read` = ?,`is_spam` = ?,`is_failed` = ?,`read_timestamp` = ?,`preview_text` = ?,`is_supported` = ?,`is_complete` = ?,`is_read_status` = ?,`read_locally_timestamp` = ? WHERE `local_id` = ? AND `channel_id` = ? AND `user_id` = ?";
        }
    }

    public class v extends SharedSQLiteStatement {
        public v(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n        DELETE FROM message \n        WHERE \n            user_id = ? AND\n            channel_id = ? AND\n            local_id = ?\n        ";
        }
    }

    public class w extends SharedSQLiteStatement {
        public w(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n        DELETE FROM message_meta_info\n        WHERE \n            local_user_id = ? AND\n            channel_id = ? AND\n            local_message_id = ?\n        ";
        }
    }

    public class x extends SharedSQLiteStatement {
        public x(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            update message\n            set\n                read_timestamp = ?,\n                is_read = 1,\n                is_read_status = ?\n            where\n                user_id = ?\n                and channel_id = ?\n                and from_id = ?\n                and read_timestamp is null\n            ";
        }
    }

    public class y extends SharedSQLiteStatement {
        public y(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            update message\n            set\n                read_timestamp = ?,\n                is_read = 1,\n                is_read_status = ?\n            where\n                user_id = ?\n                and channel_id = ?\n                and from_id != ?\n                and (is_read = 0 or read_timestamp is null)\n            ";
        }
    }

    public class z extends SharedSQLiteStatement {
        public z(MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n        update message\n        set\n            is_read = 1,\n            is_read_status = ?,\n            read_locally_timestamp = ?\n        where\n            user_id = ?\n            and channel_id = ?\n            and is_read_status = ?\n        ";
        }
    }

    public MessageDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new k(this, roomDatabase);
        this.c = new t(this, roomDatabase);
        this.d = new u(this, roomDatabase);
        this.e = new v(this, roomDatabase);
        this.f = new w(this, roomDatabase);
        this.g = new x(this, roomDatabase);
        this.h = new y(this, roomDatabase);
        this.i = new z(this, roomDatabase);
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int deleteMessage(String str, String str2, String str3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
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
            this.e.release(acquire);
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public void deleteMessageAndMetaInfo(String str, String str2, String str3) {
        this.a.beginTransaction();
        try {
            MessageDao.DefaultImpls.deleteMessageAndMetaInfo(this, str, str2, str3);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int deleteMessageMetaInfo(String str, String str2, String str3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
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
            this.f.release(acquire);
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int deleteMessagesWithChannelIds(String str, List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("\n");
        newStringBuilder.append("            DELETE FROM message");
        newStringBuilder.append("\n");
        newStringBuilder.append("            WHERE ");
        a2.b.a.a.a.n1(newStringBuilder, "\n", "                user_id = ", "?", "\n");
        newStringBuilder.append("                AND channel_id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
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
        for (String str2 : list) {
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

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> findByRemoteId(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT * FROM message\n        WHERE \n            user_id = ?\n            AND remote_id = ?\n    ", 2);
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
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new r(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getAllMessages() {
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new a0(RoomSQLiteQuery.acquire("\n            SELECT * FROM message\n        ", 0)));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getAllMessagesSortedByIsPendingAndCreatedDesc(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select *\n        from message\n        where\n            user_id = ?\n            and channel_id = ?\n        order by (remote_id is null and is_failed == 0) desc, created desc\n        ", 2);
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
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new b(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getAllPendingMessages() {
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new c(RoomSQLiteQuery.acquire("\n        select *\n        from message\n        where remote_id is null and is_failed = 0\n        order by created\n        ", 0)));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Long getFirstPageTimestamp(String str, String str2, int i2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select min(created) from (\n            select created from message\n            where\n                user_id = ?\n                and channel_id = ?\n            order by created desc\n            limit ?\n        )\n        ", 3);
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
        acquire.bindLong(3, (long) i2);
        this.a.assertNotSuspendingTransaction();
        Long l2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                if (!query.isNull(0)) {
                    l2 = Long.valueOf(query.getLong(0));
                }
            }
            return l2;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getFirstPendingMessage(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            select * from message\n            where\n                user_id = ?\n                and remote_id is null\n                and is_failed = 0\n            order by created asc\n            limit 1\n        ", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new i(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<Long> getIncomingMessageCount(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select count(*)\n        from message\n        where\n            user_id = ?\n            and channel_id = ?\n            and from_id not in (?, '0')\n        ", 3);
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
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new s(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getLastMessageForChannel(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT * FROM message\n            WHERE\n                message.user_id = ?\n                AND message.channel_id = ?\n            ORDER BY message.created DESC\n            LIMIT 1\n        ", 2);
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
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new d(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getLastMessageSortedByIsPendingAndCreatedDesc(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            select * from message\n            where\n                user_id = ?\n                and channel_id = ?\n            order by (remote_id is null and is_failed == 0) desc, created desc\n            limit 1\n        ", 2);
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
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new g(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getLastMesssagesForChannels(String str, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT ", "msg.*", "\n", "            FROM message AS msg");
        a2.b.a.a.a.n1(V, "\n", "            INNER JOIN", "\n", "                (");
        a2.b.a.a.a.n1(V, "\n", "                    SELECT ", "\n", "                        m.user_id,");
        a2.b.a.a.a.n1(V, "\n", "                        m.channel_id,", "\n", "                        max(m.created) AS max_created");
        a2.b.a.a.a.n1(V, "\n", "                    FROM message AS m", "\n", "                    WHERE ");
        a2.b.a.a.a.n1(V, "\n", "                        user_id = ", "?", "\n");
        V.append("                        AND channel_id IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        a2.b.a.a.a.n1(V, "                    GROUP BY m.channel_id", "\n", "                ) AS t", "\n");
        a2.b.a.a.a.n1(V, "            ON ", "\n", "                msg.user_id = t.user_id", "\n");
        a2.b.a.a.a.n1(V, "                AND msg.channel_id = t.channel_id", "\n", "                AND msg.created = t.max_created", "\n");
        V.append("        ");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(V.toString(), size + 1);
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
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new h(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Long getLastSyncTimestamp(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select\n            ifnull(\n                first_unread_outgoing_message.timestamp - 1,\n                last_message.timestamp\n            )\n        from\n            (   -- First UNREAD outgoing message\n                select min(created) as timestamp\n                from message\n                where\n                    user_id = ?\n                    and channel_id = ?\n                    and from_id = ?\n                    and remote_id is not null\n                    and read_timestamp is null\n            ) as first_unread_outgoing_message,\n\n            (   -- Last message\n                select max(created) as timestamp\n                from message\n                where\n                    user_id = ?\n                    and channel_id = ?\n                    and remote_id is not null\n            ) as last_message\n        ", 5);
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
        if (str2 == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Long l2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                if (!query.isNull(0)) {
                    l2 = Long.valueOf(query.getLong(0));
                }
            }
            return l2;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getLatestIncomingMessageWithLocalReadStatus(String str, IsReadStatus isReadStatus) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            select *\n            from message\n            where\n                user_id = ?\n                and from_id != ?\n                and is_read_status = ?\n            order by created desc\n            limit 1\n            ", 3);
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
        String isReadStatusToString = IsReadStatus.Converter.isReadStatusToString(isReadStatus);
        if (isReadStatusToString == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, isReadStatusToString);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new p(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getMessage(String str, String str2, String str3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT * FROM message\n        WHERE\n            user_id = ? AND\n            channel_id = ? AND\n            local_id = ?\n        ", 3);
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
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new q(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public long getMessageCount(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select count(*) from message where user_id = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getLong(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public long getMessageCountBefore(long j2, String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select count(*)\n        from message\n        where\n            user_id = ?\n            and channel_id = ?\n            and created < ?\n        ", 3);
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
        acquire.bindLong(3, j2);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getLong(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Long getMessageCreationTimestamp(String str, String str2, String str3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select created as timestamp\n        from message \n        where user_id = ? \n            and channel_id = ? \n            and remote_id = ?\n        limit 1\n        ", 3);
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
        Long l2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                if (!query.isNull(0)) {
                    l2 = Long.valueOf(query.getLong(0));
                }
            }
            return l2;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getMessagesAfterSortedByIsPendingAndCreatedDesc(long j2, String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select * from message\n        where\n            created > ?\n            and user_id = ?\n            and channel_id = ?\n        order by (remote_id is null and is_failed == 0) desc, created desc\n        ", 3);
        acquire.bindLong(1, j2);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str2 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str2);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new f(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getMessagesBeforeSortedByIsPendingAndCreatedDesc(long j2, String str, String str2, long j3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select * from message\n        where\n            created < ?\n            and user_id = ?\n            and channel_id = ?\n         order by (remote_id is null and is_failed == 0) desc, created desc\n         limit ?\n        ", 4);
        acquire.bindLong(1, j2);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str2 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str2);
        }
        acquire.bindLong(4, j3);
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new e(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getMessagesWithIncompleteBodies(String str, String str2, long j2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select * from message\n        where\n            user_id = ?\n            and channel_id = ?\n            and is_complete = 0\n        order by created desc\n        limit ?\n        ", 3);
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
        acquire.bindLong(3, j2);
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new l(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Long getOldestMessageTimestampInChannel(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            select min(created)\n            from message\n            where\n                user_id = ?\n                and channel_id = ?\n        ", 2);
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
        this.a.assertNotSuspendingTransaction();
        Long l2 = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                if (!query.isNull(0)) {
                    l2 = Long.valueOf(query.getLong(0));
                }
            }
            return l2;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<Long>> getTimestampOfLatestIncomingMessageWithLocalReadStatus(String str, String str2, IsReadStatus isReadStatus) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            select max(created)\n            from message\n            where\n                user_id = ?\n                and channel_id = ?\n                and from_id != ?\n                and is_read_status = ?\n            ", 4);
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
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        String isReadStatusToString = IsReadStatus.Converter.isReadStatusToString(isReadStatus);
        if (isReadStatusToString == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, isReadStatusToString);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new o(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<Integer> getUnreadMessagesCount(String str, String str2, IsReadStatus isReadStatus) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            select count(*)\n            from message\n            where\n                user_id = ?\n                and channel_id = ?\n                and from_id != ?\n                and is_read_status = ?\n            ", 4);
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
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        String isReadStatusToString = IsReadStatus.Converter.isReadStatusToString(isReadStatus);
        if (isReadStatusToString == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, isReadStatusToString);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new n(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getUnsentMessages(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select * from message\n        where\n            user_id = ?\n            and channel_id = ?\n            and remote_id is null\n            and not is_failed\n        order by created asc\n        ", 2);
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
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new m(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public void insertFileMessage(MessageEntity messageEntity, MessageMetaInfo messageMetaInfo) {
        this.a.beginTransaction();
        try {
            MessageDao.DefaultImpls.insertFileMessage(this, messageEntity, messageMetaInfo);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public long insertMessage(MessageEntity messageEntity) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(messageEntity);
            this.a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public long insertMessageMetaInfo(MessageMetaInfo messageMetaInfo) {
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

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public List<Long> insertMessages(List<MessageEntity> list) {
        this.a.beginTransaction();
        try {
            List<Long> insertMessages = MessageDao.DefaultImpls.insertMessages(this, list);
            this.a.setTransactionSuccessful();
            return insertMessages;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int markIncomingMessagesAsReadInChannel(String str, String str2, long j2, IsReadStatus isReadStatus) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.h.acquire();
        acquire.bindLong(1, j2);
        String isReadStatusToString = IsReadStatus.Converter.isReadStatusToString(isReadStatus);
        if (isReadStatusToString == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, isReadStatusToString);
        }
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        if (str2 == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str2);
        }
        if (str == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str);
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

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int markMessagesAsFailed(String... strArr) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("\n");
        newStringBuilder.append("        update message");
        newStringBuilder.append("\n");
        newStringBuilder.append("        set is_failed = 1");
        newStringBuilder.append("\n");
        newStringBuilder.append("        where remote_id is null and local_id in (");
        StringUtil.appendPlaceholders(newStringBuilder, strArr.length);
        newStringBuilder.append(")");
        newStringBuilder.append("\n");
        newStringBuilder.append("        ");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        int i2 = 1;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str);
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

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int markMessagesAsRead(String str, List<String> list, long j2, IsReadStatus isReadStatus) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("\n");
        newStringBuilder.append("        update message");
        newStringBuilder.append("\n");
        newStringBuilder.append("        set");
        a2.b.a.a.a.n1(newStringBuilder, "\n", "            read_timestamp = ", "?", ",");
        a2.b.a.a.a.n1(newStringBuilder, "\n", "            is_read = 1,", "\n", "            is_read_status = ");
        a2.b.a.a.a.n1(newStringBuilder, "?", "\n", "        where", "\n");
        a2.b.a.a.a.n1(newStringBuilder, "            user_id = ", "?", "\n", "            and remote_id in (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        newStringBuilder.append("\n");
        newStringBuilder.append("        ");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, j2);
        String isReadStatusToString = IsReadStatus.Converter.isReadStatusToString(isReadStatus);
        if (isReadStatusToString == null) {
            compileStatement.bindNull(2);
        } else {
            compileStatement.bindString(2, isReadStatusToString);
        }
        if (str == null) {
            compileStatement.bindNull(3);
        } else {
            compileStatement.bindString(3, str);
        }
        int i2 = 4;
        for (String str2 : list) {
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

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int markOutgoingMessagesAsReadInChannel(String str, String str2, long j2, IsReadStatus isReadStatus) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.g.acquire();
        acquire.bindLong(1, j2);
        String isReadStatusToString = IsReadStatus.Converter.isReadStatusToString(isReadStatus);
        if (isReadStatusToString == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, isReadStatusToString);
        }
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        if (str2 == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str2);
        }
        if (str == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, str);
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.g.release(acquire);
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<Integer> pendingMessageCount(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            select count(*) from message\n            where\n                user_id = ?\n                and remote_id is null\n                and is_failed = 0\n            order by created asc\n        ", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new j(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int resetFailedFlagForMessages(long j2, String... strArr) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("\n");
        newStringBuilder.append("        update message");
        newStringBuilder.append("\n");
        newStringBuilder.append("        set is_failed = 0, created = ");
        a2.b.a.a.a.m1(newStringBuilder, "?", "\n", "        where remote_id is null and local_id in (");
        StringUtil.appendPlaceholders(newStringBuilder, strArr.length);
        newStringBuilder.append(")");
        newStringBuilder.append("\n");
        newStringBuilder.append("        ");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, j2);
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str);
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

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int setNewIsReadStatusForMessagesInChannel(String str, String str2, IsReadStatus isReadStatus, IsReadStatus isReadStatus2, Long l2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.i.acquire();
        String isReadStatusToString = IsReadStatus.Converter.isReadStatusToString(isReadStatus2);
        if (isReadStatusToString == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, isReadStatusToString);
        }
        if (l2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindLong(2, l2.longValue());
        }
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        if (str2 == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str2);
        }
        String isReadStatusToString2 = IsReadStatus.Converter.isReadStatusToString(isReadStatus);
        if (isReadStatusToString2 == null) {
            acquire.bindNull(5);
        } else {
            acquire.bindString(5, isReadStatusToString2);
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

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public int updateMessage(MessageEntity messageEntity) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handle = this.d.handle(messageEntity) + 0;
            this.a.setTransactionSuccessful();
            return handle;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public Observable<List<MessageEntity>> getAllMessages(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT * FROM message\n            WHERE\n                user_id = ?\n        ", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return RxRoom.createObservable(this.a, false, new String[]{"message"}, new a(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.MessageDao
    public long getMessageCount(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select count(*) from message where user_id = ? and channel_id = ?", 2);
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
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getLong(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
