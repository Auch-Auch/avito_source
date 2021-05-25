package ru.avito.android.persistence.messenger;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
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
public final class ChannelTagDao_Impl implements ChannelTagDao {
    public final RoomDatabase a;
    public final EntityDeletionOrUpdateAdapter<ChannelTag> b;

    public class a extends EntityDeletionOrUpdateAdapter<ChannelTag> {
        public a(ChannelTagDao_Impl channelTagDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
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

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `channel_tag` WHERE `local_user_id` = ? AND `channel_id` = ? AND `tag` = ?";
        }
    }

    public class b implements Callable<Void> {
        public final /* synthetic */ Collection a;

        public b(Collection collection) {
            this.a = collection;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            ChannelTagDao_Impl.this.a.beginTransaction();
            try {
                ChannelTagDao_Impl.this.b.handleMultiple(this.a);
                ChannelTagDao_Impl.this.a.setTransactionSuccessful();
                ChannelTagDao_Impl.this.a.endTransaction();
                return null;
            } catch (Throwable th) {
                ChannelTagDao_Impl.this.a.endTransaction();
                throw th;
            }
        }
    }

    public class c implements Callable<List<ChannelTag>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public c(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelTag> call() throws Exception {
            Cursor query = DBUtil.query(ChannelTagDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "tag");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new ChannelTag(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3)));
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

    public class d implements Callable<List<ChannelTag>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public d(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<ChannelTag> call() throws Exception {
            Cursor query = DBUtil.query(ChannelTagDao_Impl.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "local_user_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "channel_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "tag");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new ChannelTag(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3)));
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

    public ChannelTagDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
    }

    @Override // ru.avito.android.persistence.messenger.ChannelTagDao
    public Completable deleteChannelTags(Collection<ChannelTag> collection) {
        return Completable.fromCallable(new b(collection));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelTagDao
    public Observable<List<ChannelTag>> getChannelTags(String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n            SELECT * FROM channel_tag\n            WHERE \n                local_user_id = ? \n                AND channel_id = ?\n        ", 2);
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
        return RxRoom.createObservable(this.a, false, new String[]{"channel_tag"}, new c(acquire));
    }

    @Override // ru.avito.android.persistence.messenger.ChannelTagDao
    public Observable<List<ChannelTag>> getChannelsTags(String str, Collection<String> collection) {
        StringBuilder V = a2.b.a.a.a.V("\n", "            SELECT ", "*", " FROM channel_tag", "\n");
        a2.b.a.a.a.n1(V, "            WHERE ", "\n", "                local_user_id = ", "?");
        V.append(" ");
        V.append("\n");
        V.append("                AND channel_id IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(V, size);
        V.append(")");
        V.append("\n");
        V.append("        ");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(V.toString(), size + 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        int i = 2;
        for (String str2 : collection) {
            if (str2 == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str2);
            }
            i++;
        }
        return RxRoom.createObservable(this.a, false, new String[]{"channel_tag"}, new d(acquire));
    }
}
