package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverter;
import com.avito.android.messenger.channels.mvi.data.ChannelEntityConverterImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelRepo;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoReader;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter;
import com.avito.android.messenger.channels.mvi.data.DraftRepo;
import com.avito.android.messenger.channels.mvi.data.DraftRepoImpl;
import com.avito.android.messenger.channels.mvi.data.DraftRepoReader;
import com.avito.android.messenger.channels.mvi.data.DraftRepoWriter;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverter;
import com.avito.android.messenger.channels.mvi.data.UserEntityConverterImpl;
import com.avito.android.messenger.channels.mvi.data.UserRepo;
import com.avito.android.messenger.channels.mvi.data.UserRepoImpl;
import com.avito.android.messenger.channels.mvi.data.UserRepoReader;
import com.avito.android.messenger.channels.mvi.data.UserRepoWriter;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverter;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverterImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoReader;
import com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.ChannelDao;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.ChannelTagDao;
import ru.avito.android.persistence.messenger.DraftDao;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.android.persistence.messenger.UserDao;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/di/MessengerRepoModule;", "", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "database", "Lru/avito/android/persistence/messenger/MessageDao;", "provideMessageDao$messenger_release", "(Lru/avito/android/persistence/messenger/MessengerDatabase;)Lru/avito/android/persistence/messenger/MessageDao;", "provideMessageDao", "Lru/avito/android/persistence/messenger/MessageMetaInfoDao;", "provideMessageMetaInfoDao$messenger_release", "(Lru/avito/android/persistence/messenger/MessengerDatabase;)Lru/avito/android/persistence/messenger/MessageMetaInfoDao;", "provideMessageMetaInfoDao", "Lru/avito/android/persistence/messenger/ChannelMetaInfoDao;", "provideChannelMetaInfoDao$messenger_release", "(Lru/avito/android/persistence/messenger/MessengerDatabase;)Lru/avito/android/persistence/messenger/ChannelMetaInfoDao;", "provideChannelMetaInfoDao", "Lru/avito/android/persistence/messenger/ChannelDao;", "provideChannelDao$messenger_release", "(Lru/avito/android/persistence/messenger/MessengerDatabase;)Lru/avito/android/persistence/messenger/ChannelDao;", "provideChannelDao", "Lru/avito/android/persistence/messenger/DraftDao;", "provideDraftDao$messenger_release", "(Lru/avito/android/persistence/messenger/MessengerDatabase;)Lru/avito/android/persistence/messenger/DraftDao;", "provideDraftDao", "Lru/avito/android/persistence/messenger/UserDao;", "provideUserDao$messenger_release", "(Lru/avito/android/persistence/messenger/MessengerDatabase;)Lru/avito/android/persistence/messenger/UserDao;", "provideUserDao", "Lru/avito/android/persistence/messenger/ChannelTagDao;", "provideChannelTagDao$messenger_release", "(Lru/avito/android/persistence/messenger/MessengerDatabase;)Lru/avito/android/persistence/messenger/ChannelTagDao;", "provideChannelTagDao", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class MessengerRepoModule {
    @NotNull
    public static final MessengerRepoModule INSTANCE = new MessengerRepoModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u001bH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u001bH'¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020$H'¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020%H'¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020%H'¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020.H'¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u0002022\u0006\u0010\u0012\u001a\u00020/H'¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u0002052\u0006\u0010\u0012\u001a\u00020/H'¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u0002092\u0006\u0010\u0012\u001a\u000208H'¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/avito/android/messenger/di/MessengerRepoModule$Declarations;", "", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoImpl;", "implementation", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "bindMessageRepo", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoImpl;)Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverterImpl;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverter;", "bindMessageEntityConverter", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverterImpl;)Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverter;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;", "bindMessageRepoReader", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;)Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoReader;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;", "bindMessageRepoWriter", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;)Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoWriter;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverterImpl;", "impl", "Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverter;", "bindChannelEntityConverter", "(Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverterImpl;)Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverter;", "Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverterImpl;", "Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;", "bindUserEntityConverter", "(Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverterImpl;)Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoImpl;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "bindChannelRepo", "(Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoImpl;)Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;", "bindChannelRepoReader", "(Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;)Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoReader;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoWriter;", "bindChannelRepoWriter", "(Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;)Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoWriter;", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoImpl;", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;", "bindDraftRepo", "(Lcom/avito/android/messenger/channels/mvi/data/DraftRepoImpl;)Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoReader;", "bindDraftRepoReader", "(Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;)Lcom/avito/android/messenger/channels/mvi/data/DraftRepoReader;", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "bindDraftRepoWriter", "(Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;)Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "Lcom/avito/android/messenger/channels/mvi/data/UserRepoImpl;", "Lcom/avito/android/messenger/channels/mvi/data/UserRepo;", "bindUserRepo", "(Lcom/avito/android/messenger/channels/mvi/data/UserRepoImpl;)Lcom/avito/android/messenger/channels/mvi/data/UserRepo;", "Lcom/avito/android/messenger/channels/mvi/data/UserRepoReader;", "bindUserRepoReader", "(Lcom/avito/android/messenger/channels/mvi/data/UserRepo;)Lcom/avito/android/messenger/channels/mvi/data/UserRepoReader;", "Lcom/avito/android/messenger/channels/mvi/data/UserRepoWriter;", "bindUserRepoWriter", "(Lcom/avito/android/messenger/channels/mvi/data/UserRepo;)Lcom/avito/android/messenger/channels/mvi/data/UserRepoWriter;", "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandlerImpl;", "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", "bindErrorTracker", "(Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandlerImpl;)Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        ChannelEntityConverter bindChannelEntityConverter(@NotNull ChannelEntityConverterImpl channelEntityConverterImpl);

        @Reusable
        @Binds
        @NotNull
        ChannelRepo bindChannelRepo(@NotNull ChannelRepoImpl channelRepoImpl);

        @Binds
        @NotNull
        ChannelRepoReader bindChannelRepoReader(@NotNull ChannelRepo channelRepo);

        @Binds
        @NotNull
        ChannelRepoWriter bindChannelRepoWriter(@NotNull ChannelRepo channelRepo);

        @Binds
        @NotNull
        DraftRepo bindDraftRepo(@NotNull DraftRepoImpl draftRepoImpl);

        @Binds
        @NotNull
        DraftRepoReader bindDraftRepoReader(@NotNull DraftRepo draftRepo);

        @Binds
        @NotNull
        DraftRepoWriter bindDraftRepoWriter(@NotNull DraftRepo draftRepo);

        @Reusable
        @Binds
        @NotNull
        DatabaseErrorHandler bindErrorTracker(@NotNull DatabaseErrorHandlerImpl databaseErrorHandlerImpl);

        @Reusable
        @Binds
        @NotNull
        MessageEntityConverter bindMessageEntityConverter(@NotNull MessageEntityConverterImpl messageEntityConverterImpl);

        @Reusable
        @Binds
        @NotNull
        MessageRepo bindMessageRepo(@NotNull MessageRepoImpl messageRepoImpl);

        @Binds
        @NotNull
        MessageRepoReader bindMessageRepoReader(@NotNull MessageRepo messageRepo);

        @Binds
        @NotNull
        MessageRepoWriter bindMessageRepoWriter(@NotNull MessageRepo messageRepo);

        @Reusable
        @Binds
        @NotNull
        UserEntityConverter bindUserEntityConverter(@NotNull UserEntityConverterImpl userEntityConverterImpl);

        @Reusable
        @Binds
        @NotNull
        UserRepo bindUserRepo(@NotNull UserRepoImpl userRepoImpl);

        @Binds
        @NotNull
        UserRepoReader bindUserRepoReader(@NotNull UserRepo userRepo);

        @Binds
        @NotNull
        UserRepoWriter bindUserRepoWriter(@NotNull UserRepo userRepo);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ChannelDao provideChannelDao$messenger_release(@NotNull MessengerDatabase messengerDatabase) {
        Intrinsics.checkNotNullParameter(messengerDatabase, "database");
        return messengerDatabase.getChannelDao();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ChannelMetaInfoDao provideChannelMetaInfoDao$messenger_release(@NotNull MessengerDatabase messengerDatabase) {
        Intrinsics.checkNotNullParameter(messengerDatabase, "database");
        return messengerDatabase.getChannelMetaInfoDao();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ChannelTagDao provideChannelTagDao$messenger_release(@NotNull MessengerDatabase messengerDatabase) {
        Intrinsics.checkNotNullParameter(messengerDatabase, "database");
        return messengerDatabase.getChannelTagDao();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final DraftDao provideDraftDao$messenger_release(@NotNull MessengerDatabase messengerDatabase) {
        Intrinsics.checkNotNullParameter(messengerDatabase, "database");
        return messengerDatabase.getDraftDao();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final MessageDao provideMessageDao$messenger_release(@NotNull MessengerDatabase messengerDatabase) {
        Intrinsics.checkNotNullParameter(messengerDatabase, "database");
        return messengerDatabase.getMessageDao();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final MessageMetaInfoDao provideMessageMetaInfoDao$messenger_release(@NotNull MessengerDatabase messengerDatabase) {
        Intrinsics.checkNotNullParameter(messengerDatabase, "database");
        return messengerDatabase.getMessageMetaInfoDao();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final UserDao provideUserDao$messenger_release(@NotNull MessengerDatabase messengerDatabase) {
        Intrinsics.checkNotNullParameter(messengerDatabase, "database");
        return messengerDatabase.getUserDao();
    }
}
