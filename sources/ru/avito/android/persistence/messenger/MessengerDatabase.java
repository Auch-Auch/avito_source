package ru.avito.android.persistence.messenger;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.IsReadStatus;
import ru.avito.android.persistence.messenger.TransferStatus;
@TypeConverters({IsReadStatus.Converter.class, TransferStatus.Converter.class})
@Database(entities = {MessageEntity.class, ChannelMetaInfo.class, ChannelEntity.class, UserEntity.class, DraftEntity.class, ChannelTag.class, MessageMetaInfo.class}, exportSchema = true, version = 27)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lru/avito/android/persistence/messenger/MessengerDatabase;", "Landroidx/room/RoomDatabase;", "Lru/avito/android/persistence/messenger/MessageDao;", "getMessageDao", "()Lru/avito/android/persistence/messenger/MessageDao;", "Lru/avito/android/persistence/messenger/ChannelMetaInfoDao;", "getChannelMetaInfoDao", "()Lru/avito/android/persistence/messenger/ChannelMetaInfoDao;", "Lru/avito/android/persistence/messenger/ChannelDao;", "getChannelDao", "()Lru/avito/android/persistence/messenger/ChannelDao;", "Lru/avito/android/persistence/messenger/DraftDao;", "getDraftDao", "()Lru/avito/android/persistence/messenger/DraftDao;", "Lru/avito/android/persistence/messenger/UserDao;", "getUserDao", "()Lru/avito/android/persistence/messenger/UserDao;", "Lru/avito/android/persistence/messenger/ChannelTagDao;", "getChannelTagDao", "()Lru/avito/android/persistence/messenger/ChannelTagDao;", "Lru/avito/android/persistence/messenger/MessageMetaInfoDao;", "getMessageMetaInfoDao", "()Lru/avito/android/persistence/messenger/MessageMetaInfoDao;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class MessengerDatabase extends RoomDatabase {
    @NotNull
    public abstract ChannelDao getChannelDao();

    @NotNull
    public abstract ChannelMetaInfoDao getChannelMetaInfoDao();

    @NotNull
    public abstract ChannelTagDao getChannelTagDao();

    @NotNull
    public abstract DraftDao getDraftDao();

    @NotNull
    public abstract MessageDao getMessageDao();

    @NotNull
    public abstract MessageMetaInfoDao getMessageMetaInfoDao();

    @NotNull
    public abstract UserDao getUserDao();
}
