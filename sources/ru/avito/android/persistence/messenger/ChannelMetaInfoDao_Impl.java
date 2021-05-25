package ru.avito.android.persistence.messenger;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
public final class ChannelMetaInfoDao_Impl implements ChannelMetaInfoDao {
    public final RoomDatabase a;
    public final EntityInsertionAdapter<ChannelMetaInfo> b;
    public final EntityDeletionOrUpdateAdapter<ChannelMetaInfo> c;
    public final EntityDeletionOrUpdateAdapter<ChannelMetaInfo> d;
    public final SharedSQLiteStatement e;

    public class a extends EntityInsertionAdapter<ChannelMetaInfo> {
        public a(ChannelMetaInfoDao_Impl channelMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ChannelMetaInfo channelMetaInfo) {
            ChannelMetaInfo channelMetaInfo2 = channelMetaInfo;
            if (channelMetaInfo2.getLocalUserId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, channelMetaInfo2.getLocalUserId());
            }
            if (channelMetaInfo2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, channelMetaInfo2.getChannelId());
            }
            supportSQLiteStatement.bindLong(3, channelMetaInfo2.getLastSyncedMessageTimeStamp());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `channel_meta_data` (`local_user_id`,`channel_id`,`last_synced_message_timestamp`) VALUES (?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<ChannelMetaInfo> {
        public b(ChannelMetaInfoDao_Impl channelMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ChannelMetaInfo channelMetaInfo) {
            ChannelMetaInfo channelMetaInfo2 = channelMetaInfo;
            if (channelMetaInfo2.getLocalUserId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, channelMetaInfo2.getLocalUserId());
            }
            if (channelMetaInfo2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, channelMetaInfo2.getChannelId());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `channel_meta_data` WHERE `local_user_id` = ? AND `channel_id` = ?";
        }
    }

    public class c extends EntityDeletionOrUpdateAdapter<ChannelMetaInfo> {
        public c(ChannelMetaInfoDao_Impl channelMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ChannelMetaInfo channelMetaInfo) {
            ChannelMetaInfo channelMetaInfo2 = channelMetaInfo;
            if (channelMetaInfo2.getLocalUserId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, channelMetaInfo2.getLocalUserId());
            }
            if (channelMetaInfo2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, channelMetaInfo2.getChannelId());
            }
            supportSQLiteStatement.bindLong(3, channelMetaInfo2.getLastSyncedMessageTimeStamp());
            if (channelMetaInfo2.getLocalUserId() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, channelMetaInfo2.getLocalUserId());
            }
            if (channelMetaInfo2.getChannelId() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, channelMetaInfo2.getChannelId());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR REPLACE `channel_meta_data` SET `local_user_id` = ?,`channel_id` = ?,`last_synced_message_timestamp` = ? WHERE `local_user_id` = ? AND `channel_id` = ?";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(ChannelMetaInfoDao_Impl channelMetaInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "\n            update channel_meta_data\n            set\n                last_synced_message_timestamp = ?\n            where\n                local_user_id = ?\n                and channel_id = ?\n        ";
        }
    }

    public ChannelMetaInfoDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new b(this, roomDatabase);
        this.d = new c(this, roomDatabase);
        this.e = new d(this, roomDatabase);
    }

    @Override // ru.avito.android.persistence.messenger.ChannelMetaInfoDao
    public long createChannelMetaInfo(ChannelMetaInfo channelMetaInfo) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(channelMetaInfo);
            this.a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelMetaInfoDao
    public int deleteChannelMetaInfo(ChannelMetaInfo channelMetaInfo) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handle = this.c.handle(channelMetaInfo) + 0;
            this.a.setTransactionSuccessful();
            return handle;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelMetaInfoDao
    public ChannelMetaInfo getChannelMetaInfo(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select * from channel_meta_data\n        where\n            local_user_id = ?\n            and channel_id = ?\n    ", 2);
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
        ChannelMetaInfo channelMetaInfo = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, ChannelMetaInfo.COLUMN_LAST_SYNCED_MESSAGE_TIMESTAMP);
            if (query.moveToFirst()) {
                channelMetaInfo = new ChannelMetaInfo(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3));
            }
            return channelMetaInfo;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelMetaInfoDao
    public Long getLastSyncedMessageTimestamp(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        select last_synced_message_timestamp from channel_meta_data\n        where\n            local_user_id = ?\n            and channel_id = ?\n    ", 2);
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
        Long l = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                if (!query.isNull(0)) {
                    l = Long.valueOf(query.getLong(0));
                }
            }
            return l;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelMetaInfoDao
    public int updateChannelMetaInfo(ChannelMetaInfo channelMetaInfo) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int handle = this.d.handle(channelMetaInfo) + 0;
            this.a.setTransactionSuccessful();
            return handle;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // ru.avito.android.persistence.messenger.ChannelMetaInfoDao
    public int updateLastSyncedMessageTimestamp(String str, String str2, long j) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        acquire.bindLong(1, j);
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
}
