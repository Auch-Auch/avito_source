package ru.avito.android.persistence.messenger;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
public final class MessengerDatabase_Impl extends MessengerDatabase {
    public volatile MessageDao i;
    public volatile ChannelMetaInfoDao j;
    public volatile ChannelDao k;
    public volatile DraftDao l;
    public volatile UserDao m;
    public volatile ChannelTagDao n;
    public volatile MessageMetaInfoDao o;

    public class a extends RoomOpenHelper.Delegate {
        public a(int i) {
            super(i);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `message` (`local_id` TEXT NOT NULL, `channel_id` TEXT NOT NULL, `remote_id` TEXT, `created` INTEGER NOT NULL, `type` TEXT NOT NULL, `user_id` TEXT NOT NULL, `from_id` TEXT NOT NULL, `json_body` TEXT NOT NULL, `is_read` INTEGER NOT NULL, `is_spam` INTEGER NOT NULL, `is_failed` INTEGER NOT NULL, `read_timestamp` INTEGER, `preview_text` TEXT, `is_supported` INTEGER NOT NULL, `is_complete` INTEGER NOT NULL, `is_read_status` TEXT NOT NULL, `read_locally_timestamp` INTEGER, PRIMARY KEY(`local_id`, `channel_id`, `user_id`))");
            supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_message_remote_id` ON `message` (`remote_id`)");
            supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_message_created` ON `message` (`created`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `channel_meta_data` (`local_user_id` TEXT NOT NULL, `channel_id` TEXT NOT NULL, `last_synced_message_timestamp` INTEGER NOT NULL, PRIMARY KEY(`local_user_id`, `channel_id`))");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `local_user_id_and_channel_id` ON `channel_meta_data` (`local_user_id`, `channel_id`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `channel` (`user_id` TEXT NOT NULL, `channel_id` TEXT NOT NULL, `type` TEXT NOT NULL, `created` INTEGER NOT NULL, `updated` INTEGER NOT NULL, `context_type` TEXT NOT NULL, `json_context` TEXT NOT NULL, `json_read_only_state` TEXT, `is_deleted` INTEGER NOT NULL, `is_read` INTEGER NOT NULL, `is_spam` INTEGER NOT NULL, `is_answered` INTEGER NOT NULL, `json_context_actions` TEXT, `json_deal_action` TEXT, `flow` TEXT, `suspect_message_id` TEXT, `item_id` TEXT, `interlocutor_id` TEXT, `json_display_info` TEXT NOT NULL, `json_input_state` TEXT, PRIMARY KEY(`user_id`, `channel_id`))");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `user_id_and_channel_id` ON `channel` (`user_id`, `channel_id`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `user` (`local_user_id` TEXT NOT NULL, `user_id` TEXT NOT NULL, `channel_id` TEXT NOT NULL, `name` TEXT, `last_action_time` INTEGER, `time_diff` INTEGER, `json_public_profile` TEXT, PRIMARY KEY(`local_user_id`, `user_id`, `channel_id`))");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `user_and_channel_ids` ON `user` (`local_user_id`, `user_id`, `channel_id`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `draft` (`local_user_id` TEXT NOT NULL, `channel_id` TEXT NOT NULL, `interlocutor_id` TEXT NOT NULL, `text` TEXT NOT NULL, PRIMARY KEY(`local_user_id`, `channel_id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `channel_tag` (`local_user_id` TEXT NOT NULL, `channel_id` TEXT NOT NULL, `tag` TEXT NOT NULL, PRIMARY KEY(`local_user_id`, `channel_id`, `tag`))");
            supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `tag_local_user_id_and_channel_id` ON `channel_tag` (`local_user_id`, `channel_id`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `message_meta_info` (`local_user_id` TEXT NOT NULL, `channel_id` TEXT NOT NULL, `local_message_id` TEXT NOT NULL, `path` TEXT, `internal_path` TEXT, `progress` INTEGER NOT NULL, `transfer_status` TEXT NOT NULL, PRIMARY KEY(`local_user_id`, `channel_id`, `local_message_id`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a0f6921d97bbdc7f0f5e8829c38a9bb6')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `message`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `channel_meta_data`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `channel`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `user`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `draft`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `channel_tag`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `message_meta_info`");
            List<RoomDatabase.Callback> list = MessengerDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    MessengerDatabase_Impl.this.mCallbacks.get(i).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            List<RoomDatabase.Callback> list = MessengerDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    MessengerDatabase_Impl.this.mCallbacks.get(i).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            MessengerDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
            MessengerDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            List<RoomDatabase.Callback> list = MessengerDatabase_Impl.this.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    MessengerDatabase_Impl.this.mCallbacks.get(i).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(17);
            hashMap.put(MessageEntity.COLUMN_LOCAL_ID, new TableInfo.Column(MessageEntity.COLUMN_LOCAL_ID, "TEXT", true, 1, null, 1));
            hashMap.put("channel_id", new TableInfo.Column("channel_id", "TEXT", true, 2, null, 1));
            hashMap.put(MessageEntity.COLUMN_REMOTE_ID, new TableInfo.Column(MessageEntity.COLUMN_REMOTE_ID, "TEXT", false, 0, null, 1));
            hashMap.put("created", new TableInfo.Column("created", "INTEGER", true, 0, null, 1));
            hashMap.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
            hashMap.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 3, null, 1));
            hashMap.put("from_id", new TableInfo.Column("from_id", "TEXT", true, 0, null, 1));
            hashMap.put("json_body", new TableInfo.Column("json_body", "TEXT", true, 0, null, 1));
            hashMap.put(ChannelEntity.COLUMN_IS_READ, new TableInfo.Column(ChannelEntity.COLUMN_IS_READ, "INTEGER", true, 0, null, 1));
            hashMap.put(ChannelEntity.COLUMN_IS_SPAM, new TableInfo.Column(ChannelEntity.COLUMN_IS_SPAM, "INTEGER", true, 0, null, 1));
            hashMap.put("is_failed", new TableInfo.Column("is_failed", "INTEGER", true, 0, null, 1));
            hashMap.put("read_timestamp", new TableInfo.Column("read_timestamp", "INTEGER", false, 0, null, 1));
            hashMap.put("preview_text", new TableInfo.Column("preview_text", "TEXT", false, 0, null, 1));
            hashMap.put("is_supported", new TableInfo.Column("is_supported", "INTEGER", true, 0, null, 1));
            hashMap.put("is_complete", new TableInfo.Column("is_complete", "INTEGER", true, 0, null, 1));
            hashMap.put("is_read_status", new TableInfo.Column("is_read_status", "TEXT", true, 0, null, 1));
            hashMap.put("read_locally_timestamp", new TableInfo.Column("read_locally_timestamp", "INTEGER", false, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new TableInfo.Index("index_message_remote_id", false, Arrays.asList(MessageEntity.COLUMN_REMOTE_ID)));
            hashSet2.add(new TableInfo.Index("index_message_created", false, Arrays.asList("created")));
            TableInfo tableInfo = new TableInfo("message", hashMap, hashSet, hashSet2);
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "message");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "message(ru.avito.android.persistence.messenger.MessageEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(3);
            hashMap2.put("local_user_id", new TableInfo.Column("local_user_id", "TEXT", true, 1, null, 1));
            hashMap2.put("channel_id", new TableInfo.Column("channel_id", "TEXT", true, 2, null, 1));
            hashMap2.put(ChannelMetaInfo.COLUMN_LAST_SYNCED_MESSAGE_TIMESTAMP, new TableInfo.Column(ChannelMetaInfo.COLUMN_LAST_SYNCED_MESSAGE_TIMESTAMP, "INTEGER", true, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(1);
            hashSet4.add(new TableInfo.Index("local_user_id_and_channel_id", true, Arrays.asList("local_user_id", "channel_id")));
            TableInfo tableInfo2 = new TableInfo("channel_meta_data", hashMap2, hashSet3, hashSet4);
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "channel_meta_data");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "channel_meta_data(ru.avito.android.persistence.messenger.ChannelMetaInfo).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(20);
            hashMap3.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 1, null, 1));
            hashMap3.put("channel_id", new TableInfo.Column("channel_id", "TEXT", true, 2, null, 1));
            hashMap3.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
            hashMap3.put("created", new TableInfo.Column("created", "INTEGER", true, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_UPDATED, new TableInfo.Column(ChannelEntity.COLUMN_UPDATED, "INTEGER", true, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_CONTEXT_TYPE, new TableInfo.Column(ChannelEntity.COLUMN_CONTEXT_TYPE, "TEXT", true, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_JSON_CONTEXT, new TableInfo.Column(ChannelEntity.COLUMN_JSON_CONTEXT, "TEXT", true, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_JSON_READ_ONLY_STATE, new TableInfo.Column(ChannelEntity.COLUMN_JSON_READ_ONLY_STATE, "TEXT", false, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_IS_DELETED, new TableInfo.Column(ChannelEntity.COLUMN_IS_DELETED, "INTEGER", true, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_IS_READ, new TableInfo.Column(ChannelEntity.COLUMN_IS_READ, "INTEGER", true, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_IS_SPAM, new TableInfo.Column(ChannelEntity.COLUMN_IS_SPAM, "INTEGER", true, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_IS_ANSWERED, new TableInfo.Column(ChannelEntity.COLUMN_IS_ANSWERED, "INTEGER", true, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS, new TableInfo.Column(ChannelEntity.COLUMN_JSON_CONTEXT_ACTIONS, "TEXT", false, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_JSON_DEAL_ACTION, new TableInfo.Column(ChannelEntity.COLUMN_JSON_DEAL_ACTION, "TEXT", false, 0, null, 1));
            hashMap3.put("flow", new TableInfo.Column("flow", "TEXT", false, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID, new TableInfo.Column(ChannelEntity.COLUMN_SUSPECT_MESSAGE_ID, "TEXT", false, 0, null, 1));
            hashMap3.put("item_id", new TableInfo.Column("item_id", "TEXT", false, 0, null, 1));
            hashMap3.put("interlocutor_id", new TableInfo.Column("interlocutor_id", "TEXT", false, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_JSON_DISPLAY_INFO, new TableInfo.Column(ChannelEntity.COLUMN_JSON_DISPLAY_INFO, "TEXT", true, 0, null, 1));
            hashMap3.put(ChannelEntity.COLUMN_JSON_INPUT_STATE, new TableInfo.Column(ChannelEntity.COLUMN_JSON_INPUT_STATE, "TEXT", false, 0, null, 1));
            HashSet hashSet5 = new HashSet(0);
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new TableInfo.Index("user_id_and_channel_id", true, Arrays.asList("user_id", "channel_id")));
            TableInfo tableInfo3 = new TableInfo("channel", hashMap3, hashSet5, hashSet6);
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "channel");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "channel(ru.avito.android.persistence.messenger.ChannelEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(7);
            hashMap4.put("local_user_id", new TableInfo.Column("local_user_id", "TEXT", true, 1, null, 1));
            hashMap4.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 2, null, 1));
            hashMap4.put("channel_id", new TableInfo.Column("channel_id", "TEXT", true, 3, null, 1));
            hashMap4.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
            hashMap4.put(UserEntity.COLUMN_LAST_ACTION_TIME, new TableInfo.Column(UserEntity.COLUMN_LAST_ACTION_TIME, "INTEGER", false, 0, null, 1));
            hashMap4.put(UserEntity.COLUMN_TIME_DIFF, new TableInfo.Column(UserEntity.COLUMN_TIME_DIFF, "INTEGER", false, 0, null, 1));
            hashMap4.put(UserEntity.COLUMN_JSON_PUBLIC_PROFILE, new TableInfo.Column(UserEntity.COLUMN_JSON_PUBLIC_PROFILE, "TEXT", false, 0, null, 1));
            HashSet hashSet7 = new HashSet(0);
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new TableInfo.Index("user_and_channel_ids", true, Arrays.asList("local_user_id", "user_id", "channel_id")));
            TableInfo tableInfo4 = new TableInfo("user", hashMap4, hashSet7, hashSet8);
            TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "user");
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "user(ru.avito.android.persistence.messenger.UserEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            HashMap hashMap5 = new HashMap(4);
            hashMap5.put("local_user_id", new TableInfo.Column("local_user_id", "TEXT", true, 1, null, 1));
            hashMap5.put("channel_id", new TableInfo.Column("channel_id", "TEXT", true, 2, null, 1));
            hashMap5.put("interlocutor_id", new TableInfo.Column("interlocutor_id", "TEXT", true, 0, null, 1));
            hashMap5.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, 1));
            TableInfo tableInfo5 = new TableInfo(AnalyticFieldsName.draft, hashMap5, new HashSet(0), new HashSet(0));
            TableInfo read5 = TableInfo.read(supportSQLiteDatabase, AnalyticFieldsName.draft);
            if (!tableInfo5.equals(read5)) {
                return new RoomOpenHelper.ValidationResult(false, "draft(ru.avito.android.persistence.messenger.DraftEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
            }
            HashMap hashMap6 = new HashMap(3);
            hashMap6.put("local_user_id", new TableInfo.Column("local_user_id", "TEXT", true, 1, null, 1));
            hashMap6.put("channel_id", new TableInfo.Column("channel_id", "TEXT", true, 2, null, 1));
            hashMap6.put("tag", new TableInfo.Column("tag", "TEXT", true, 3, null, 1));
            HashSet hashSet9 = new HashSet(0);
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new TableInfo.Index("tag_local_user_id_and_channel_id", false, Arrays.asList("local_user_id", "channel_id")));
            TableInfo tableInfo6 = new TableInfo("channel_tag", hashMap6, hashSet9, hashSet10);
            TableInfo read6 = TableInfo.read(supportSQLiteDatabase, "channel_tag");
            if (!tableInfo6.equals(read6)) {
                return new RoomOpenHelper.ValidationResult(false, "channel_tag(ru.avito.android.persistence.messenger.ChannelTag).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
            }
            HashMap hashMap7 = new HashMap(7);
            hashMap7.put("local_user_id", new TableInfo.Column("local_user_id", "TEXT", true, 1, null, 1));
            hashMap7.put("channel_id", new TableInfo.Column("channel_id", "TEXT", true, 2, null, 1));
            hashMap7.put(MessageMetaInfo.COLUMN_LOCAL_MESSAGE_ID, new TableInfo.Column(MessageMetaInfo.COLUMN_LOCAL_MESSAGE_ID, "TEXT", true, 3, null, 1));
            hashMap7.put(MessageMetaInfo.COLUMN_PATH, new TableInfo.Column(MessageMetaInfo.COLUMN_PATH, "TEXT", false, 0, null, 1));
            hashMap7.put(MessageMetaInfo.COLUMN_INTERNAL_PATH, new TableInfo.Column(MessageMetaInfo.COLUMN_INTERNAL_PATH, "TEXT", false, 0, null, 1));
            hashMap7.put("progress", new TableInfo.Column("progress", "INTEGER", true, 0, null, 1));
            hashMap7.put(MessageMetaInfo.COLUMN_TRANSFER_STATUS, new TableInfo.Column(MessageMetaInfo.COLUMN_TRANSFER_STATUS, "TEXT", true, 0, null, 1));
            TableInfo tableInfo7 = new TableInfo(MessageMetaInfo.TABLE_NAME, hashMap7, new HashSet(0), new HashSet(0));
            TableInfo read7 = TableInfo.read(supportSQLiteDatabase, MessageMetaInfo.TABLE_NAME);
            if (tableInfo7.equals(read7)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "message_meta_info(ru.avito.android.persistence.messenger.MessageMetaInfo).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        String str = "VACUUM";
        String str2 = "PRAGMA wal_checkpoint(FULL)";
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `message`");
            writableDatabase.execSQL("DELETE FROM `channel_meta_data`");
            writableDatabase.execSQL("DELETE FROM `channel`");
            writableDatabase.execSQL("DELETE FROM `user`");
            writableDatabase.execSQL("DELETE FROM `draft`");
            writableDatabase.execSQL("DELETE FROM `channel_tag`");
            writableDatabase.execSQL("DELETE FROM `message_meta_info`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query(str2).close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL(str);
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "message", "channel_meta_data", "channel", "user", AnalyticFieldsName.draft, "channel_tag", MessageMetaInfo.TABLE_NAME);
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(27), "a0f6921d97bbdc7f0f5e8829c38a9bb6", "ffb9bb5a2f62dc739fb7d3fd6123097f")).build());
    }

    @Override // ru.avito.android.persistence.messenger.MessengerDatabase
    public ChannelDao getChannelDao() {
        ChannelDao channelDao;
        if (this.k != null) {
            return this.k;
        }
        synchronized (this) {
            if (this.k == null) {
                this.k = new ChannelDao_Impl(this);
            }
            channelDao = this.k;
        }
        return channelDao;
    }

    @Override // ru.avito.android.persistence.messenger.MessengerDatabase
    public ChannelMetaInfoDao getChannelMetaInfoDao() {
        ChannelMetaInfoDao channelMetaInfoDao;
        if (this.j != null) {
            return this.j;
        }
        synchronized (this) {
            if (this.j == null) {
                this.j = new ChannelMetaInfoDao_Impl(this);
            }
            channelMetaInfoDao = this.j;
        }
        return channelMetaInfoDao;
    }

    @Override // ru.avito.android.persistence.messenger.MessengerDatabase
    public ChannelTagDao getChannelTagDao() {
        ChannelTagDao channelTagDao;
        if (this.n != null) {
            return this.n;
        }
        synchronized (this) {
            if (this.n == null) {
                this.n = new ChannelTagDao_Impl(this);
            }
            channelTagDao = this.n;
        }
        return channelTagDao;
    }

    @Override // ru.avito.android.persistence.messenger.MessengerDatabase
    public DraftDao getDraftDao() {
        DraftDao draftDao;
        if (this.l != null) {
            return this.l;
        }
        synchronized (this) {
            if (this.l == null) {
                this.l = new DraftDao_Impl(this);
            }
            draftDao = this.l;
        }
        return draftDao;
    }

    @Override // ru.avito.android.persistence.messenger.MessengerDatabase
    public MessageDao getMessageDao() {
        MessageDao messageDao;
        if (this.i != null) {
            return this.i;
        }
        synchronized (this) {
            if (this.i == null) {
                this.i = new MessageDao_Impl(this);
            }
            messageDao = this.i;
        }
        return messageDao;
    }

    @Override // ru.avito.android.persistence.messenger.MessengerDatabase
    public MessageMetaInfoDao getMessageMetaInfoDao() {
        MessageMetaInfoDao messageMetaInfoDao;
        if (this.o != null) {
            return this.o;
        }
        synchronized (this) {
            if (this.o == null) {
                this.o = new MessageMetaInfoDao_Impl(this);
            }
            messageMetaInfoDao = this.o;
        }
        return messageMetaInfoDao;
    }

    @Override // ru.avito.android.persistence.messenger.MessengerDatabase
    public UserDao getUserDao() {
        UserDao userDao;
        if (this.m != null) {
            return this.m;
        }
        synchronized (this) {
            if (this.m == null) {
                this.m = new UserDao_Impl(this);
            }
            userDao = this.m;
        }
        return userDao;
    }
}
