package ru.avito.android.persistence.messenger;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0010\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bf\u0010gJ+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\tJ#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H'¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\rJ1\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015JG\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b\u001b\u0010\u001dJ+\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u001b\u0010\u001eJO\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b\"\u0010#JA\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b\"\u0010$J3\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH'¢\u0006\u0004\b\"\u0010%JO\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b\"\u0010(JA\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b\"\u0010)J3\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0017H'¢\u0006\u0004\b\"\u0010*JA\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b+\u0010,J3\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b+\u0010-J%\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b+\u0010.JA\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b/\u0010,J3\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b/\u0010-J%\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b/\u0010.JG\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b1\u00102J9\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b1\u00103J+\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001fH'¢\u0006\u0004\b1\u00104JG\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b5\u0010\u001cJ9\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\b5\u0010\u001dJ+\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b5\u0010\u001eJ+\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b6\u0010\u001eJ\u0017\u00108\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0007H'¢\u0006\u0004\b8\u00109J#\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H'¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\u00172\u0006\u0010>\u001a\u00020=H'¢\u0006\u0004\b?\u0010@J#\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\f\u0010A\u001a\b\u0012\u0004\u0012\u00020=0\u0012H'¢\u0006\u0004\bB\u0010<J#\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u0012H'¢\u0006\u0004\bE\u0010<J\u0017\u0010H\u001a\u00020\u00172\u0006\u0010G\u001a\u00020FH'¢\u0006\u0004\bH\u0010IJ#\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\f\u0010J\u001a\b\u0012\u0004\u0012\u00020F0\u0012H'¢\u0006\u0004\bK\u0010<J\u001f\u0010M\u001a\u00020L2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\bM\u0010NJ\u001f\u0010O\u001a\u00020L2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\bO\u0010NJ\u001f\u0010P\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\bP\u0010QJ'\u0010P\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H'¢\u0006\u0004\bP\u0010RJ%\u0010S\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\bS\u0010TJ\u001f\u0010U\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\bU\u0010QJ%\u0010V\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H'¢\u0006\u0004\bV\u0010TJ=\u0010Y\u001a\u00020X2\u0006\u00107\u001a\u00020\u00072\f\u0010A\u001a\b\u0012\u0004\u0012\u00020=0\u00122\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u00122\b\u0010W\u001a\u0004\u0018\u00010FH\u0017¢\u0006\u0004\bY\u0010ZJG\u0010\\\u001a\u00020X2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\f\u0010A\u001a\b\u0012\u0004\u0012\u00020=0\u00122\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u00122\f\u0010[\u001a\b\u0012\u0004\u0012\u00020F0\u0012H\u0017¢\u0006\u0004\b\\\u0010]J\u001f\u0010^\u001a\u00020X2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017¢\u0006\u0004\b^\u0010_J'\u0010^\u001a\u00020X2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0017¢\u0006\u0004\b^\u0010`J%\u0010a\u001a\u00020X2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0017¢\u0006\u0004\ba\u0010bJ;\u0010c\u001a\u00020X2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0017¢\u0006\u0004\bc\u0010dJ;\u0010e\u001a\u00020X2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0017¢\u0006\u0004\be\u0010d¨\u0006h"}, d2 = {"Lru/avito/android/persistence/messenger/ChannelDao;", "", "", "localUserId", "channelId", "Lio/reactivex/Observable;", "", "Lru/avito/android/persistence/messenger/ChannelEntity;", "getChannel", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "itemId", "getChannelIdByItemId", "getAvitoChannelId", "(Ljava/lang/String;)Lio/reactivex/Observable;", "interlocutorId", "getChannelIdByItemIdAndInterlocutorId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "getAllChannels", "", "channelIds", "getChannels", "(Ljava/lang/String;Ljava/util/Collection;)Lio/reactivex/Observable;", ChannelContext.Item.USER_ID, "", "timestamp", "tags", "excludeTags", "getChannelsStartingFromTimestamp", "(Ljava/lang/String;JLjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "(Ljava/lang/String;JLjava/util/Collection;)Lio/reactivex/Observable;", "(Ljava/lang/String;J)Lio/reactivex/Observable;", "", "offset", "limit", "getNonEmptyChannelIds", "(Ljava/lang/String;IILjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "(Ljava/lang/String;IILjava/util/Collection;)Lio/reactivex/Observable;", "(Ljava/lang/String;II)Lio/reactivex/Observable;", "olderOrEqualToTimestamp", "newerOrEqualToTimestamp", "(Ljava/lang/String;JJLjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "(Ljava/lang/String;JJLjava/util/Collection;)Lio/reactivex/Observable;", "(Ljava/lang/String;JJ)Lio/reactivex/Observable;", "getIdsOfNonEmptyChannelsOlderThanTimestamp", "(Ljava/lang/String;JLjava/util/Collection;Ljava/util/Collection;)Ljava/util/List;", "(Ljava/lang/String;JLjava/util/Collection;)Ljava/util/List;", "(Ljava/lang/String;J)Ljava/util/List;", "getIdsOfNonEmptyChannelsNewerThatTimestamp", VKApiConst.POSITION, "getTimestampOfNonEmptyChannelAtPosition", "(Ljava/lang/String;ILjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "(Ljava/lang/String;ILjava/util/Collection;)Lio/reactivex/Observable;", "(Ljava/lang/String;I)Lio/reactivex/Observable;", "getEmptyChannelsNewerThanTimestamp", "getIdsOfEmptyChannelsOlderThanTimestamp", "channel", "insertChannel", "(Lru/avito/android/persistence/messenger/ChannelEntity;)J", ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS, "insertChannels", "(Ljava/util/Collection;)Ljava/util/List;", "Lru/avito/android/persistence/messenger/UserEntity;", "user", "insertUser", "(Lru/avito/android/persistence/messenger/UserEntity;)J", "users", "insertUsers", "Lru/avito/android/persistence/messenger/ChannelTag;", "channelTags", "insertChannelTags", "Lru/avito/android/persistence/messenger/MessageEntity;", "message", "insertMessageIfItDoesNotExist", "(Lru/avito/android/persistence/messenger/MessageEntity;)J", "messages", "insertMessagesIfTheyDoNotExist", "Lio/reactivex/Completable;", "setChannelIsRead", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteChannelContextActions", "deleteChannel", "(Ljava/lang/String;Ljava/lang/String;)I", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I", "deleteChannelsById", "(Ljava/lang/String;Ljava/util/Collection;)I", "deleteChannelTags", "deleteChannelsTags", "lastMessage", "", "insertChannelWithUsersAndLastMessage", "(Lru/avito/android/persistence/messenger/ChannelEntity;Ljava/util/Collection;Ljava/util/Collection;Lru/avito/android/persistence/messenger/MessageEntity;)V", "lastMessages", "insertChannelsWithUsersAndLastMessages", "(Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;)V", "deleteChannelAndTags", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "deleteChannelsAndTags", "(Ljava/lang/String;Ljava/util/Collection;)V", "deleteNonEmptyChannelsAndTagsOlderThanTimestamp", "(Ljava/lang/String;JLjava/util/Collection;Ljava/util/Collection;)V", "deleteNonEmptyChannelsAndTagsNewerThatTimestamp", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChannelDao {
    @Query("\n            DELETE FROM channel \n            WHERE \n                user_id = :userId \n                AND channel_id = :channelId\n            ")
    public abstract int deleteChannel(@NotNull String str, @NotNull String str2);

    @Query("\n            DELETE FROM channel \n            WHERE \n                user_id = :userId \n                AND interlocutor_id = :interlocutorId\n                AND item_id = :itemId\n            ")
    public abstract int deleteChannel(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Transaction
    public void deleteChannelAndTags(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        deleteChannel(str, str2);
        deleteChannelTags(str, str2);
    }

    @Query("\n            UPDATE channel\n                SET json_context_actions = NULL\n            WHERE \n                user_id = :userId\n                AND channel_id = :channelId\n        ")
    @NotNull
    public abstract Completable deleteChannelContextActions(@NotNull String str, @NotNull String str2);

    @Query("\n            DELETE FROM channel_tag\n            WHERE\n                local_user_id = :localUserId\n                AND channel_id = :channelId\n        ")
    public abstract int deleteChannelTags(@NotNull String str, @NotNull String str2);

    @Transaction
    public void deleteChannelsAndTags(@NotNull String str, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(collection, "channelIds");
        if (!collection.isEmpty()) {
            deleteChannelsById(str, collection);
            deleteChannelsTags(str, collection);
        }
    }

    @Query("\n            DELETE FROM channel\n            WHERE\n                user_id = :userId\n                AND channel_id IN (:channelIds)\n        ")
    public abstract int deleteChannelsById(@NotNull String str, @NotNull Collection<String> collection);

    @Query("\n            DELETE FROM channel_tag\n            WHERE\n                local_user_id = :localUserId\n                AND channel_id IN (:channelIds)\n        ")
    public abstract int deleteChannelsTags(@NotNull String str, @NotNull Collection<String> collection);

    @Transaction
    public void deleteNonEmptyChannelsAndTagsNewerThatTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2) {
        List<String> list;
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(collection, "tags");
        Intrinsics.checkNotNullParameter(collection2, "excludeTags");
        if (!collection.isEmpty()) {
            list = getIdsOfNonEmptyChannelsNewerThatTimestamp(str, j, collection, collection2);
        } else if (!collection2.isEmpty()) {
            list = getIdsOfNonEmptyChannelsNewerThatTimestamp(str, j, collection2);
        } else {
            list = getIdsOfNonEmptyChannelsNewerThatTimestamp(str, j);
        }
        if (!list.isEmpty()) {
            deleteChannelsById(str, list);
            deleteChannelsTags(str, list);
        }
    }

    @Transaction
    public void deleteNonEmptyChannelsAndTagsOlderThanTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2) {
        List<String> list;
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(collection, "tags");
        Intrinsics.checkNotNullParameter(collection2, "excludeTags");
        if (!collection.isEmpty()) {
            list = getIdsOfNonEmptyChannelsOlderThanTimestamp(str, j, collection, collection2);
        } else if (!collection2.isEmpty()) {
            list = getIdsOfNonEmptyChannelsOlderThanTimestamp(str, j, collection2);
        } else {
            list = getIdsOfNonEmptyChannelsOlderThanTimestamp(str, j);
        }
        if (!list.isEmpty()) {
            deleteChannelsById(str, list);
            deleteChannelsTags(str, list);
        }
    }

    @Query("\n            SELECT * FROM channel\n            WHERE user_id = :localUserId\n            ORDER BY updated DESC\n        ")
    @NotNull
    public abstract Observable<List<ChannelEntity>> getAllChannels(@NotNull String str);

    @Query("\n            SELECT channel_id FROM channel\n            WHERE user_id = :localUserId AND type = \"a2u\"\n        ")
    @NotNull
    public abstract Observable<List<String>> getAvitoChannelId(@NotNull String str);

    @Query("\n            SELECT * FROM channel\n            WHERE user_id = :localUserId AND channel_id = :channelId\n        ")
    @NotNull
    public abstract Observable<List<ChannelEntity>> getChannel(@NotNull String str, @NotNull String str2);

    @Query("\n            SELECT channel_id FROM channel\n            WHERE user_id = :localUserId AND item_id = :itemId\n        ")
    @NotNull
    public abstract Observable<List<String>> getChannelIdByItemId(@NotNull String str, @NotNull String str2);

    @Query("\n            SELECT channel_id FROM channel\n            WHERE \n                user_id = :localUserId \n                AND item_id = :itemId\n                AND interlocutor_id = :interlocutorId\n        ")
    @NotNull
    public abstract List<String> getChannelIdByItemIdAndInterlocutorId(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Query("\n            SELECT * FROM channel\n            WHERE\n                user_id = :localUserId\n                AND channel_id IN (:channelIds)\n        ")
    @NotNull
    public abstract Observable<List<ChannelEntity>> getChannels(@NotNull String str, @NotNull Collection<String> collection);

    @Query("\n            SELECT\n                c.*,\n                MAX(c.updated, IFNULL(last_messages.created, 0)) AS c_date\n            FROM channel AS c\n            LEFT JOIN (\n                    SELECT \n                        m.channel_id AS channel_id,\n                        MAX(m.created) AS created\n                    FROM message AS m\n                    WHERE m.user_id = :userId\n                    GROUP BY m.channel_id\n                ) AS last_messages\n                ON last_messages.channel_id = c.channel_id\n            WHERE \n                c.user_id = :userId\n                AND c_date >= :timestamp\n            ORDER BY c_date DESC\n        ")
    @NotNull
    public abstract Observable<List<ChannelEntity>> getChannelsStartingFromTimestamp(@NotNull String str, long j);

    @Query("\n            SELECT\n                c.*,\n                MAX(c.updated, IFNULL(last_messages.created, 0)) AS c_date\n            FROM channel AS c\n            LEFT JOIN (\n                    SELECT \n                        m.channel_id AS channel_id,\n                        MAX(m.created) AS created\n                    FROM message AS m\n                    WHERE m.user_id = :userId\n                    GROUP BY m.channel_id\n                ) AS last_messages\n                ON last_messages.channel_id = c.channel_id\n            WHERE \n                c.user_id = :userId\n                AND c_date >= :timestamp\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :userId\n                        AND c_tag.channel_id = c.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n            ORDER BY c_date DESC\n        ")
    @NotNull
    public abstract Observable<List<ChannelEntity>> getChannelsStartingFromTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection);

    @Query("\n            SELECT\n                c.*,\n                MAX(c.updated, IFNULL(last_messages.created, 0)) AS c_date\n            FROM channel AS c\n            LEFT JOIN (\n                    SELECT \n                        m.channel_id AS channel_id,\n                        MAX(m.created) AS created\n                    FROM message AS m\n                    WHERE m.user_id = :userId\n                    GROUP BY m.channel_id\n                ) AS last_messages\n                ON last_messages.channel_id = c.channel_id\n            WHERE \n                c.user_id = :userId\n                AND c_date >= :timestamp\n                AND EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :userId\n                        AND c_tag.channel_id = c.channel_id\n                        AND c_tag.tag IN (:tags)\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :userId\n                        AND c_tag.channel_id = c.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n            ORDER BY c_date DESC\n        ")
    @NotNull
    public abstract Observable<List<ChannelEntity>> getChannelsStartingFromTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @Query("\n            SELECT * FROM channel\n            WHERE \n                user_id = :localUserId\n                AND updated > :timestamp\n                AND created > :timestamp \n                AND NOT EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract Observable<List<ChannelEntity>> getEmptyChannelsNewerThanTimestamp(@NotNull String str, long j);

    @Query("\n            SELECT * FROM channel\n            WHERE \n                user_id = :localUserId\n                AND updated > :timestamp\n                AND created > :timestamp \n                AND NOT EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract Observable<List<ChannelEntity>> getEmptyChannelsNewerThanTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection);

    @Query("\n            SELECT * FROM channel\n            WHERE \n                user_id = :localUserId\n                AND updated > :timestamp\n                AND created > :timestamp \n                AND NOT EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:tags)\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract Observable<List<ChannelEntity>> getEmptyChannelsNewerThanTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @Query("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = :localUserId\n                AND updated < :timestamp\n                AND created < :timestamp \n                AND NOT EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE\n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract Observable<List<String>> getIdsOfEmptyChannelsOlderThanTimestamp(@NotNull String str, long j);

    @Query("\n            SELECT channel_id FROM channel\n            WHERE\n                user_id = :localUserId\n                AND updated > :timestamp\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract List<String> getIdsOfNonEmptyChannelsNewerThatTimestamp(@NotNull String str, long j);

    @Query("\n            SELECT channel_id FROM channel\n            WHERE\n                user_id = :localUserId\n                AND updated > :timestamp\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract List<String> getIdsOfNonEmptyChannelsNewerThatTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection);

    @Query("\n            SELECT channel_id FROM channel\n            WHERE\n                user_id = :localUserId\n                AND updated > :timestamp\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:tags)\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract List<String> getIdsOfNonEmptyChannelsNewerThatTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @Query("\n            SELECT channel_id FROM channel\n            WHERE\n                user_id = :localUserId\n                AND updated < :timestamp\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract List<String> getIdsOfNonEmptyChannelsOlderThanTimestamp(@NotNull String str, long j);

    @Query("\n            SELECT channel_id FROM channel\n            WHERE\n                user_id = :localUserId\n                AND updated < :timestamp\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract List<String> getIdsOfNonEmptyChannelsOlderThanTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection);

    @Query("\n            SELECT channel_id FROM channel\n            WHERE\n                user_id = :localUserId\n                AND updated < :timestamp\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:tags)\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n        ")
    @NotNull
    public abstract List<String> getIdsOfNonEmptyChannelsOlderThanTimestamp(@NotNull String str, long j, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @Query("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = :localUserId\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n            ORDER BY updated DESC\n            LIMIT :limit OFFSET :offset\n        ")
    @NotNull
    public abstract Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, int i, int i2);

    @Query("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = :localUserId\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n            ORDER BY updated DESC\n            LIMIT :limit OFFSET :offset\n        ")
    @NotNull
    public abstract Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, int i, int i2, @NotNull Collection<String> collection);

    @Query("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = :localUserId\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:tags)\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n            ORDER BY updated DESC\n            LIMIT :limit OFFSET :offset\n        ")
    @NotNull
    public abstract Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, int i, int i2, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @Query("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = :localUserId \n                AND updated <= :olderOrEqualToTimestamp\n                AND updated >= :newerOrEqualToTimestamp\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n            ORDER BY updated DESC\n        ")
    @NotNull
    public abstract Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, long j, long j2);

    @Query("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = :localUserId \n                AND updated <= :olderOrEqualToTimestamp\n                AND updated >= :newerOrEqualToTimestamp\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n            ORDER BY updated DESC\n        ")
    @NotNull
    public abstract Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, long j, long j2, @NotNull Collection<String> collection);

    @Query("\n            SELECT channel.channel_id FROM channel\n            WHERE \n                user_id = :localUserId \n                AND updated <= :olderOrEqualToTimestamp\n                AND updated >= :newerOrEqualToTimestamp\n                AND EXISTS (\n                    SELECT message.local_id FROM message\n                    WHERE \n                        message.user_id = :localUserId\n                        AND message.channel_id = channel.channel_id\n                        AND message.remote_id IS NOT NULL\n                    LIMIT 1\n                )\n                AND EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:tags)\n                    LIMIT 1\n                )\n                AND NOT EXISTS (\n                    SELECT tag \n                    FROM channel_tag AS c_tag\n                    WHERE\n                        c_tag.local_user_id = :localUserId\n                        AND c_tag.channel_id = channel.channel_id\n                        AND c_tag.tag IN (:excludeTags)\n                    LIMIT 1\n                )\n            ORDER BY updated DESC\n        ")
    @NotNull
    public abstract Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, long j, long j2, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @Query("\n            SELECT MIN(updated) FROM (\n                SELECT updated FROM channel\n                WHERE \n                    user_id = :localUserId\n                    AND EXISTS (\n                        SELECT message.local_id FROM message\n                        WHERE \n                            message.user_id = :localUserId\n                            AND message.channel_id = channel.channel_id\n                            AND message.remote_id IS NOT NULL\n                        LIMIT 1\n                    )\n                ORDER BY updated DESC\n                LIMIT :position + 1\n            )\n        ")
    @NotNull
    public abstract Observable<List<Long>> getTimestampOfNonEmptyChannelAtPosition(@NotNull String str, int i);

    @Query("\n            SELECT MIN(updated) FROM (\n                SELECT updated FROM channel\n                WHERE \n                    user_id = :localUserId\n                    AND EXISTS (\n                        SELECT message.local_id FROM message\n                        WHERE \n                            message.user_id = :localUserId\n                            AND message.channel_id = channel.channel_id\n                            AND message.remote_id IS NOT NULL\n                        LIMIT 1\n                    )\n                    AND NOT EXISTS (\n                        SELECT tag \n                        FROM channel_tag AS c_tag\n                        WHERE\n                            c_tag.local_user_id = :localUserId\n                            AND c_tag.channel_id = channel.channel_id\n                            AND c_tag.tag IN (:excludeTags)\n                        LIMIT 1\n                    )\n                ORDER BY updated DESC\n                LIMIT :position + 1\n            )\n        ")
    @NotNull
    public abstract Observable<List<Long>> getTimestampOfNonEmptyChannelAtPosition(@NotNull String str, int i, @NotNull Collection<String> collection);

    @Query("\n            SELECT MIN(updated) FROM (\n                SELECT updated FROM channel\n                WHERE \n                    user_id = :localUserId\n                    AND EXISTS (\n                        SELECT message.local_id FROM message\n                        WHERE \n                            message.user_id = :localUserId\n                            AND message.channel_id = channel.channel_id\n                            AND message.remote_id IS NOT NULL\n                        LIMIT 1\n                    )\n                    AND EXISTS (\n                        SELECT tag \n                        FROM channel_tag AS c_tag\n                        WHERE\n                            c_tag.local_user_id = :localUserId\n                            AND c_tag.channel_id = channel.channel_id\n                            AND c_tag.tag IN (:tags)\n                        LIMIT 1\n                    )\n                    AND NOT EXISTS (\n                        SELECT tag \n                        FROM channel_tag AS c_tag\n                        WHERE\n                            c_tag.local_user_id = :localUserId\n                            AND c_tag.channel_id = channel.channel_id\n                            AND c_tag.tag IN (:excludeTags)\n                        LIMIT 1\n                    )\n                ORDER BY updated DESC\n                LIMIT :position + 1\n            )\n        ")
    @NotNull
    public abstract Observable<List<Long>> getTimestampOfNonEmptyChannelAtPosition(@NotNull String str, int i, @NotNull Collection<String> collection, @NotNull Collection<String> collection2);

    @Insert(onConflict = 1)
    public abstract long insertChannel(@NotNull ChannelEntity channelEntity);

    @Insert(onConflict = 1)
    @NotNull
    public abstract List<Long> insertChannelTags(@NotNull Collection<ChannelTag> collection);

    @Transaction
    public void insertChannelWithUsersAndLastMessage(@NotNull ChannelEntity channelEntity, @NotNull Collection<UserEntity> collection, @NotNull Collection<ChannelTag> collection2, @Nullable MessageEntity messageEntity) {
        Intrinsics.checkNotNullParameter(channelEntity, "channel");
        Intrinsics.checkNotNullParameter(collection, "users");
        Intrinsics.checkNotNullParameter(collection2, "channelTags");
        insertChannel(channelEntity);
        insertChannelTags(collection2);
        for (UserEntity userEntity : collection) {
            insertUser(userEntity);
        }
        if (messageEntity != null) {
            insertMessageIfItDoesNotExist(messageEntity);
        }
    }

    @Insert(onConflict = 1)
    @NotNull
    public abstract List<Long> insertChannels(@NotNull Collection<ChannelEntity> collection);

    @Transaction
    public void insertChannelsWithUsersAndLastMessages(@NotNull Collection<ChannelEntity> collection, @NotNull Collection<UserEntity> collection2, @NotNull Collection<ChannelTag> collection3, @NotNull Collection<MessageEntity> collection4) {
        Intrinsics.checkNotNullParameter(collection, ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS);
        Intrinsics.checkNotNullParameter(collection2, "users");
        Intrinsics.checkNotNullParameter(collection3, "channelTags");
        Intrinsics.checkNotNullParameter(collection4, "lastMessages");
        insertChannels(collection);
        insertUsers(collection2);
        insertChannelTags(collection3);
        insertMessagesIfTheyDoNotExist(collection4);
    }

    @Insert(onConflict = 5)
    public abstract long insertMessageIfItDoesNotExist(@NotNull MessageEntity messageEntity);

    @Insert(onConflict = 5)
    @NotNull
    public abstract List<Long> insertMessagesIfTheyDoNotExist(@NotNull Collection<MessageEntity> collection);

    @Insert(onConflict = 1)
    public abstract long insertUser(@NotNull UserEntity userEntity);

    @Insert(onConflict = 1)
    @NotNull
    public abstract List<Long> insertUsers(@NotNull Collection<UserEntity> collection);

    @Query("\n            UPDATE channel\n                SET is_read = 1\n            WHERE \n                user_id = :userId\n                AND channel_id = :channelId\n        ")
    @NotNull
    public abstract Completable setChannelIsRead(@NotNull String str, @NotNull String str2);

    @Transaction
    public void deleteChannelAndTags(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "itemId");
        Intrinsics.checkNotNullParameter(str3, "interlocutorId");
        String str4 = (String) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) getChannelIdByItemIdAndInterlocutorId(str, str2, str3));
        if (str4 != null) {
            deleteChannel(str, str4);
            deleteChannelTags(str, str4);
        }
    }
}
