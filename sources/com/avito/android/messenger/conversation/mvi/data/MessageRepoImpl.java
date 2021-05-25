package com.avito.android.messenger.conversation.mvi.data;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.core.Some;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Logs;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelMetaInfo;
import ru.avito.android.persistence.messenger.ChannelMetaInfoDao;
import ru.avito.android.persistence.messenger.IsReadStatus;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageEntity;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.avito.android.persistence.messenger.MessageMetaInfoDao;
import ru.avito.android.persistence.messenger.TransferStatus;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010o\u001a\u00020l\u0012\u0006\u0010w\u001a\u00020t\u0012\u0006\u0010s\u001a\u00020p\u0012\u0006\u0010{\u001a\u00020x\u0012\u0006\u0010k\u001a\u00020h¢\u0006\u0004\b|\u0010}J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\u000f\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\tJM\u0010\u0013\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014JE\u0010\u0015\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J3\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J+\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\tJ#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 JE\u0010\"\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\u0002`\u000e0\u00190!2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#J+\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\tJ+\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'J+\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010\tJ+\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010\tJ#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010\u001cJ%\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010\tJ+\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010'J+\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010'JE\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010/\u001a\u00020+2\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100!2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b4\u00105J%\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b4\u0010'J-\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100!2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u00107J%\u00108\u001a\b\u0012\u0004\u0012\u0002000\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b8\u0010\tJ\u0017\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020\u0007H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020:2\u0006\u00109\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0002H\u0016¢\u0006\u0004\b>\u0010?J\u001d\u0010A\u001a\u00020:2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020:2\u0006\u00109\u001a\u00020\u0007H\u0016¢\u0006\u0004\bC\u0010<J'\u0010D\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\bD\u0010EJ'\u0010G\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0016¢\u0006\u0004\bG\u0010EJ%\u0010I\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\bI\u0010JJ\u001d\u0010L\u001a\u00020:2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\bL\u0010BJ\u001f\u0010N\u001a\u00020:2\u0006\u0010F\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u0010H\u0016¢\u0006\u0004\bN\u0010OJ-\u0010R\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010Q\u001a\u00020\u0010H\u0016¢\u0006\u0004\bR\u0010SJ'\u0010T\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0010H\u0016¢\u0006\u0004\bT\u0010UJ'\u0010V\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0010H\u0016¢\u0006\u0004\bV\u0010UJ'\u0010X\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010W\u001a\u00020\u0010H\u0016¢\u0006\u0004\bX\u0010UJ'\u0010Y\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0010H\u0016¢\u0006\u0004\bY\u0010UJ3\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00190!2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\bZ\u0010#J3\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00190\u00052\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b[\u0010 J/\u0010]\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\\\u001a\u00020\u0010H\u0016¢\u0006\u0004\b]\u0010^J'\u0010_\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b_\u0010EJ1\u0010a\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010`\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\ba\u0010bJ'\u0010c\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\bc\u0010EJ/\u0010d\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0002H\u0016¢\u0006\u0004\bd\u0010bJ/\u0010e\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\\\u001a\u00020\u0010H\u0016¢\u0006\u0004\be\u0010^J'\u0010f\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\bf\u0010EJ'\u0010g\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\bg\u0010ER\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010z¨\u0006~"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/data/MessageRepoImpl;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "", ChannelContext.Item.USER_ID, "channelId", "Lio/reactivex/Observable;", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "getAllMessages", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getAllPendingMessages", "()Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "getAllMessagesAndMetaInfo", "", Sort.DATE, "limit", "getMessagesAndMetaInfoBefore", "(JLjava/lang/String;Ljava/lang/String;J)Lio/reactivex/Observable;", "getMessagesAndMetaInfoAfter", "(JLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getMessagesBefore", "getMessagesAfter", "Larrow/core/Option;", "getLastMessage", "observeFirstPendingMessage", "(Ljava/lang/String;)Lio/reactivex/Observable;", "localUserId", "localMessageId", "getMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lio/reactivex/Single;", "getMessageAndMetaInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "remoteId", "getMessageWithRemoteId", "getMessagesWithIncompleteBodies", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "getUnsentMessages", "getLatestLocallyReadTimestamp", "getLatestReadLocallyMessage", "", "getUnreadMessagesCount", "getLastSyncedMessageTimestamp", "getOldestMessageTimestampInChannel", "ordinal", "", "ensureHasMessage", "getFirstPageTimestamp", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)Lio/reactivex/Single;", "getMessageCount", "(Ljava/lang/String;)Lio/reactivex/Single;", "getMessageCountBefore", "(JLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "hasIncomingMessages", "message", "Lio/reactivex/Completable;", "createMessage", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Lio/reactivex/Completable;", MessageMetaInfo.COLUMN_PATH, "createFileMessage", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)Lio/reactivex/Completable;", "messages", "createMessages", "(Ljava/util/List;)Lio/reactivex/Completable;", "updateMessage", "deleteMessageMetaInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "localId", "deleteMessageAndMetaInfo", "channelIds", "deleteMessagesWithChannelIds", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Completable;", "localIds", "markMessagesAsFailed", "newTimestamp", "resetMessageForResend", "(Ljava/lang/String;J)Lio/reactivex/Completable;", "messageIds", "timestamp", "markMessagesAsRead", "(Ljava/lang/String;Ljava/util/List;J)Lio/reactivex/Completable;", "markIncomingMessagesAsReadInChannel", "(Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/Completable;", "markOutgoingMessagesAsReadInChannel", "readLocallyTimeStamp", "setIsReadLocallyForMessagesInChannel", "updateLastSyncedMessageTimestamp", "getMessageMetaInfo", "observeMessageMetaInfo", "bytesTransferred", "setFileDownloadProgress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/Completable;", "setFileDownloadStarted", "internalPath", "setFileDownloadInternalPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "setFileDownloadCanceled", "setFileDownloadedSuccessfully", "setFileUploadInProgress", "setFileUploadedSuccessfully", "setFileTransferFailed", "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", "e", "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", "errorHandler", "Lru/avito/android/persistence/messenger/MessageDao;", AuthSource.SEND_ABUSE, "Lru/avito/android/persistence/messenger/MessageDao;", "messageDao", "Lru/avito/android/persistence/messenger/ChannelMetaInfoDao;", "c", "Lru/avito/android/persistence/messenger/ChannelMetaInfoDao;", "channelMetaInfoDao", "Lru/avito/android/persistence/messenger/MessageMetaInfoDao;", AuthSource.BOOKING_ORDER, "Lru/avito/android/persistence/messenger/MessageMetaInfoDao;", "messageMetaInfoDao", "Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverter;", "d", "Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverter;", "messageEntityConverter", "<init>", "(Lru/avito/android/persistence/messenger/MessageDao;Lru/avito/android/persistence/messenger/MessageMetaInfoDao;Lru/avito/android/persistence/messenger/ChannelMetaInfoDao;Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverter;Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageRepoImpl implements MessageRepo {
    public final MessageDao a;
    public final MessageMetaInfoDao b;
    public final ChannelMetaInfoDao c;
    public final MessageEntityConverter d;
    public final DatabaseErrorHandler e;

    public static final class a implements Action {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ LocalMessage b;
        public final /* synthetic */ MessageMetaInfo c;

        public a(MessageRepoImpl messageRepoImpl, LocalMessage localMessage, MessageMetaInfo messageMetaInfo) {
            this.a = messageRepoImpl;
            this.b = localMessage;
            this.c = messageMetaInfo;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            MessageDao messageDao = this.a.a;
            MessageRepoImpl messageRepoImpl = this.a;
            messageDao.insertFileMessage(messageRepoImpl.d.toMessageEntity(this.b), this.c);
        }
    }

    public static final class a0 implements Action {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public a0(MessageRepoImpl messageRepoImpl, long j, String str) {
            this.a = messageRepoImpl;
            this.b = j;
            this.c = str;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.a.resetFailedFlagForMessages(this.b, this.c);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ LocalMessage b;

        public b(MessageRepoImpl messageRepoImpl, LocalMessage localMessage) {
            this.a = messageRepoImpl;
            this.b = localMessage;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            MessageDao messageDao = this.a.a;
            MessageRepoImpl messageRepoImpl = this.a;
            messageDao.insertMessage(messageRepoImpl.d.toMessageEntity(this.b));
        }
    }

    public static final class b0<V> implements Callable<Object> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;

        public b0(MessageRepoImpl messageRepoImpl, String str, String str2, String str3, long j) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = j;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.b.updateOrInsertProgressAndStatus(this.b, this.c, this.d, this.e, TransferStatus.IN_PROGRESS);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ List b;

        public c(MessageRepoImpl messageRepoImpl, List list) {
            this.a = messageRepoImpl;
            this.b = list;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            MessageDao messageDao = this.a.a;
            List<LocalMessage> list = this.b;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            for (LocalMessage localMessage : list) {
                arrayList.add(this.a.d.toMessageEntity(localMessage));
            }
            messageDao.insertMessages(arrayList);
        }
    }

    public static final class c0<V> implements Callable<Object> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public c0(MessageRepoImpl messageRepoImpl, String str, String str2, long j) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = j;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Integer.valueOf(this.a.a.setNewIsReadStatusForMessagesInChannel(this.b, this.c, IsReadStatus.IS_NOT_READ, IsReadStatus.IS_READ_LOCALLY, Long.valueOf(this.d)));
        }
    }

    public static final class d<V> implements Callable<Object> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public d(MessageRepoImpl messageRepoImpl, String str, String str2, String str3) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.a.deleteMessageAndMetaInfo(this.b, this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    public static final class d0<V> implements Callable<Object> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public d0(MessageRepoImpl messageRepoImpl, String str, String str2, long j) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = j;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.c.getLastSyncedMessageTimestamp(this.b, this.c) == null) {
                return Long.valueOf(this.a.c.createChannelMetaInfo(new ChannelMetaInfo(this.b, this.c, this.d)));
            }
            Integer valueOf = Integer.valueOf(this.a.c.updateLastSyncedMessageTimestamp(this.b, this.c, this.d));
            if (valueOf.intValue() == 0) {
                StringBuilder L = a2.b.a.a.a.L("updateLastSyncedMessageTimestamp(");
                L.append(this.b);
                L.append(", ");
                L.append(this.c);
                L.append(", ");
                Logs.warning$default("MessageRepo", a2.b.a.a.a.l(L, this.d, ") FAILED"), null, 4, null);
                return valueOf;
            }
            StringBuilder L2 = a2.b.a.a.a.L("updateLastSyncedMessageTimestamp(");
            L2.append(this.b);
            L2.append(", ");
            L2.append(this.c);
            L2.append(", ");
            Logs.verbose$default("MessageRepo", a2.b.a.a.a.l(L2, this.d, ") SUCCESS"), null, 4, null);
            return valueOf;
        }
    }

    public static final class e<V> implements Callable<Object> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public e(MessageRepoImpl messageRepoImpl, String str, String str2, String str3) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Integer.valueOf(this.a.a.deleteMessageMetaInfo(this.b, this.c, this.d));
        }
    }

    public static final class e0 implements Action {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ LocalMessage b;

        public e0(MessageRepoImpl messageRepoImpl, LocalMessage localMessage) {
            this.a = messageRepoImpl;
            this.b = localMessage;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            MessageDao messageDao = this.a.a;
            MessageRepoImpl messageRepoImpl = this.a;
            messageDao.updateMessage(messageRepoImpl.d.toMessageEntity(this.b));
        }
    }

    public static final class f<V> implements Callable<Object> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;

        public f(MessageRepoImpl messageRepoImpl, String str, List list) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = list;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Integer.valueOf(this.a.a.deleteMessagesWithChannelIds(this.b, this.c));
        }
    }

    public static final class g<T, R> implements Function<List<? extends MessageEntity>, ObservableSource<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>>> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public g(MessageRepoImpl messageRepoImpl, String str, String str2) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>> apply(List<? extends MessageEntity> list) {
            List<? extends MessageEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messageEntities");
            return MessageRepoImpl.access$toListOfMessagesAndMetaInfoObservable(this.a, list2, this.b, this.c);
        }
    }

    public static final class h<V> implements Callable<Option<? extends Long>> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public h(MessageRepoImpl messageRepoImpl, String str, String str2, int i, String str3, boolean z) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = str3;
            this.f = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Option<? extends Long> call() {
            Long l;
            Long firstPageTimestamp = this.a.a.getFirstPageTimestamp(this.b, this.c, this.d);
            if (this.e == null) {
                return OptionKt.toOption(firstPageTimestamp);
            }
            Long messageCreationTimestamp = this.a.a.getMessageCreationTimestamp(this.b, this.c, this.e);
            if (messageCreationTimestamp != null) {
                l = Long.valueOf(t6.v.e.coerceAtMost(messageCreationTimestamp.longValue(), firstPageTimestamp != null ? firstPageTimestamp.longValue() : Long.MAX_VALUE));
            } else {
                l = null;
            }
            if (this.f) {
                return OptionKt.toOption(l);
            }
            if (l != null) {
                firstPageTimestamp = l;
            }
            return OptionKt.toOption(firstPageTimestamp);
        }
    }

    public static final class i<T, R> implements Function<List<? extends MessageEntity>, Option<? extends LocalMessage>> {
        public final /* synthetic */ MessageRepoImpl a;

        public i(MessageRepoImpl messageRepoImpl) {
            this.a = messageRepoImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends LocalMessage> apply(List<? extends MessageEntity> list) {
            LocalMessage localMessage;
            Option<? extends LocalMessage> some;
            List<? extends MessageEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messageList");
            MessageEntity messageEntity = (MessageEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            return (messageEntity == null || (localMessage = this.a.d.toLocalMessage(messageEntity)) == null || (some = OptionKt.some(localMessage)) == null) ? OptionKt.none() : some;
        }
    }

    public static final class j<V> implements Callable<Option<? extends Long>> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public j(MessageRepoImpl messageRepoImpl, String str, String str2) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Option<? extends Long> call() {
            return OptionKt.toOption(this.a.c.getLastSyncedMessageTimestamp(this.b, this.c));
        }
    }

    public static final class k<T, R> implements Function<List<? extends MessageEntity>, Option<? extends LocalMessage>> {
        public final /* synthetic */ MessageRepoImpl a;

        public k(MessageRepoImpl messageRepoImpl) {
            this.a = messageRepoImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends LocalMessage> apply(List<? extends MessageEntity> list) {
            List<? extends MessageEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messages");
            MessageEntity messageEntity = (MessageEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            return OptionKt.toOption(messageEntity != null ? this.a.d.toLocalMessage(messageEntity) : null);
        }
    }

    public static final class l<V> implements Callable<Long> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;

        public l(MessageRepoImpl messageRepoImpl, String str) {
            this.a = messageRepoImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Long call() {
            return Long.valueOf(this.a.a.getMessageCount(this.b));
        }
    }

    public static final class m<V> implements Callable<Long> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public m(MessageRepoImpl messageRepoImpl, String str, String str2) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Long call() {
            return Long.valueOf(this.a.a.getMessageCount(this.b, this.c));
        }
    }

    public static final class n<V> implements Callable<Long> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public n(MessageRepoImpl messageRepoImpl, long j, String str, String str2) {
            this.a = messageRepoImpl;
            this.b = j;
            this.c = str;
            this.d = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Long call() {
            return Long.valueOf(this.a.a.getMessageCountBefore(this.b, this.c, this.d));
        }
    }

    public static final class o<T, R> implements Function<List<? extends MessageMetaInfo>, Option<? extends MessageMetaInfo>> {
        public static final o a = new o();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends MessageMetaInfo> apply(List<? extends MessageMetaInfo> list) {
            List<? extends MessageMetaInfo> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return OptionKt.toOption(CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2));
        }
    }

    public static final class p<T, R> implements Function<List<? extends MessageEntity>, Option<? extends LocalMessage>> {
        public final /* synthetic */ MessageRepoImpl a;

        public p(MessageRepoImpl messageRepoImpl) {
            this.a = messageRepoImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends LocalMessage> apply(List<? extends MessageEntity> list) {
            List<? extends MessageEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messages");
            MessageEntity messageEntity = (MessageEntity) CollectionsKt___CollectionsKt.singleOrNull((List<? extends Object>) list2);
            return OptionKt.toOption(messageEntity != null ? this.a.d.toLocalMessage(messageEntity) : null);
        }
    }

    public static final class q<T, R> implements Function<List<? extends MessageEntity>, ObservableSource<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>>> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public q(MessageRepoImpl messageRepoImpl, String str, String str2) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>> apply(List<? extends MessageEntity> list) {
            List<? extends MessageEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messageEntities");
            return MessageRepoImpl.access$toListOfMessagesAndMetaInfoObservable(this.a, list2, this.b, this.c);
        }
    }

    public static final class r<T, R> implements Function<List<? extends MessageEntity>, ObservableSource<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>>> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public r(MessageRepoImpl messageRepoImpl, String str, String str2) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>> apply(List<? extends MessageEntity> list) {
            List<? extends MessageEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messageEntities");
            return MessageRepoImpl.access$toListOfMessagesAndMetaInfoObservable(this.a, list2, this.b, this.c);
        }
    }

    public static final class s<V> implements Callable<Option<? extends Long>> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public s(MessageRepoImpl messageRepoImpl, String str, String str2) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Option<? extends Long> call() {
            return OptionKt.toOption(this.a.a.getOldestMessageTimestampInChannel(this.b, this.c));
        }
    }

    public static final class t<T, R> implements Function<Long, Boolean> {
        public static final t a = new t();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(Long l) {
            Long l2 = l;
            Intrinsics.checkNotNullParameter(l2, "incomingMessageCount");
            return Boolean.valueOf(l2.longValue() > 0);
        }
    }

    public static final class u<V> implements Callable<Object> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public u(MessageRepoImpl messageRepoImpl, String str, String str2, long j) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = j;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Integer.valueOf(this.a.a.markIncomingMessagesAsReadInChannel(this.b, this.c, this.d, IsReadStatus.IS_READ));
        }
    }

    public static final class v implements Action {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ List b;

        public v(MessageRepoImpl messageRepoImpl, List list) {
            this.a = messageRepoImpl;
            this.b = list;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            MessageDao messageDao = this.a.a;
            Object[] array = this.b.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            messageDao.markMessagesAsFailed((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    public static final class w<V> implements Callable<Object> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;
        public final /* synthetic */ long d;

        public w(MessageRepoImpl messageRepoImpl, String str, List list, long j) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = list;
            this.d = j;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Integer.valueOf(this.a.a.markMessagesAsRead(this.b, this.c, this.d, IsReadStatus.IS_READ));
        }
    }

    public static final class x<V> implements Callable<Object> {
        public final /* synthetic */ MessageRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public x(MessageRepoImpl messageRepoImpl, String str, String str2, long j) {
            this.a = messageRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = j;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Integer.valueOf(this.a.a.markOutgoingMessagesAsReadInChannel(this.b, this.c, this.d, IsReadStatus.IS_READ));
        }
    }

    public static final class y<T, R> implements Function<List<? extends LocalMessage>, Option<? extends LocalMessage>> {
        public static final y a = new y();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends LocalMessage> apply(List<? extends LocalMessage> list) {
            List<? extends LocalMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return OptionKt.toOption(CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2));
        }
    }

    public static final class z<T, R> implements Function<List<? extends MessageMetaInfo>, Option<? extends MessageMetaInfo>> {
        public static final z a = new z();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends MessageMetaInfo> apply(List<? extends MessageMetaInfo> list) {
            List<? extends MessageMetaInfo> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return OptionKt.toOption(CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2));
        }
    }

    @Inject
    public MessageRepoImpl(@NotNull MessageDao messageDao, @NotNull MessageMetaInfoDao messageMetaInfoDao, @NotNull ChannelMetaInfoDao channelMetaInfoDao, @NotNull MessageEntityConverter messageEntityConverter, @NotNull DatabaseErrorHandler databaseErrorHandler) {
        Intrinsics.checkNotNullParameter(messageDao, "messageDao");
        Intrinsics.checkNotNullParameter(messageMetaInfoDao, "messageMetaInfoDao");
        Intrinsics.checkNotNullParameter(channelMetaInfoDao, "channelMetaInfoDao");
        Intrinsics.checkNotNullParameter(messageEntityConverter, "messageEntityConverter");
        Intrinsics.checkNotNullParameter(databaseErrorHandler, "errorHandler");
        this.a = messageDao;
        this.b = messageMetaInfoDao;
        this.c = channelMetaInfoDao;
        this.d = messageEntityConverter;
        this.e = databaseErrorHandler;
    }

    public static final List access$toListOfMessagesAndMetaInfo(MessageRepoImpl messageRepoImpl, List list, List list2) {
        Objects.requireNonNull(messageRepoImpl);
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(t6.n.q.mapCapacity(t6.n.e.collectionSizeOrDefault(list2, 10)), 16));
        for (Object obj : list2) {
            linkedHashMap.put(((MessageMetaInfo) obj).getLocalMessageId(), obj);
        }
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MessageEntity messageEntity = (MessageEntity) it.next();
            arrayList.add(TuplesKt.to(messageRepoImpl.d.toLocalMessage(messageEntity), linkedHashMap.get(messageEntity.getLocalId())));
        }
        return arrayList;
    }

    public static final Observable access$toListOfMessagesAndMetaInfoObservable(MessageRepoImpl messageRepoImpl, List list, String str, String str2) {
        Objects.requireNonNull(messageRepoImpl);
        if (!list.isEmpty()) {
            MessageMetaInfoDao messageMetaInfoDao = messageRepoImpl.b;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((MessageEntity) it.next()).getLocalId());
            }
            Observable<R> map = messageMetaInfoDao.getMetaInfoForMessages(str, str2, arrayList).map(new a2.a.a.o1.d.a0.b.b(messageRepoImpl, list));
            Intrinsics.checkNotNullExpressionValue(map, "messageMetaInfoDao.getMe…foList)\n                }");
            return map;
        }
        Observable just = Observable.just(CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just;
    }

    public static final LocalMessage access$toLocalMessage(MessageRepoImpl messageRepoImpl, MessageEntity messageEntity) {
        Objects.requireNonNull(messageRepoImpl);
        return messageRepoImpl.d.toLocalMessage(messageEntity);
    }

    public static final MessageEntity access$toMessageEntity(MessageRepoImpl messageRepoImpl, LocalMessage localMessage) {
        Objects.requireNonNull(messageRepoImpl);
        return messageRepoImpl.d.toMessageEntity(localMessage);
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable createFileMessage(@NotNull LocalMessage localMessage, @NotNull String str) {
        Intrinsics.checkNotNullParameter(localMessage, "message");
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        Completable fromAction = Completable.fromAction(new a(this, localMessage, new MessageMetaInfo(localMessage.userId, localMessage.channelId, localMessage.localId, str, null, 0, null, 64, null)));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…essageMetaInfo)\n        }");
        return a2.b.a.a.a.N1(this, "createFileMessage", t6.n.r.mapOf(TuplesKt.to("message", localMessage), TuplesKt.to(MessageMetaInfo.COLUMN_PATH, str)), fromAction, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable createMessage(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "message");
        Completable fromAction = Completable.fromAction(new b(this, localMessage));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…essageEntity())\n        }");
        return a2.b.a.a.a.N1(this, "createMessage", t6.n.q.mapOf(TuplesKt.to("message", localMessage)), fromAction, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable createMessages(@NotNull List<LocalMessage> list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        Completable fromAction = Completable.fromAction(new c(this, list));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…sageEntity() })\n        }");
        StringBuilder sb = new StringBuilder((list.size() * 3) + 1);
        StringBuilder L = a2.b.a.a.a.L("(size=");
        L.append(list.size());
        L.append(")[");
        sb.append(L.toString());
        int i2 = 0;
        for (T t2 : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            sb.append("\n\t");
            sb.append((Object) t2);
            if (i2 < list.size() - 1) {
                sb.append(",");
            }
            i2 = i3;
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return a2.b.a.a.a.N1(this, "createMessages", t6.n.q.mapOf(TuplesKt.to("messages", sb2)), fromAction, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable deleteMessageAndMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "localId");
        Completable fromCallable = Completable.fromCallable(new d(this, str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…d\n            )\n        }");
        return a2.b.a.a.a.N1(this, "deleteMessageAndMetaInfo", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to("localId", str3)), fromCallable, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable deleteMessageMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "localMessageId");
        Completable fromCallable = Completable.fromCallable(new e(this, str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…d\n            )\n        }");
        return a2.b.a.a.a.N1(this, "deleteMessage", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3)), fromCallable, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable deleteMessagesWithChannelIds(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(list, "channelIds");
        Completable fromCallable = Completable.fromCallable(new f(this, str, list));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…Id, channelIds)\n        }");
        return a2.b.a.a.a.N1(this, "deleteMessagesWithChannelIds", t6.n.r.mapOf(TuplesKt.to("localId", str), TuplesKt.to("channelIds", list)), fromCallable, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<List<LocalMessage>> getAllMessages(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> map = this.a.getAllMessagesSortedByIsPendingAndCreatedDesc(str, str2).map(new MessageRepoImpl$mapToLocalMessages$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "map { messageEntities ->…ocalMessage() }\n        }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "getAllMessages", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getAllMessagesAndMetaInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> switchMap = this.a.getAllMessagesSortedByIsPendingAndCreatedDesc(str, str2).switchMap(new g(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(switchMap, "messageDao.getAllMessage… channelId)\n            }");
        Observable<R> retryWhen = switchMap.retryWhen(new MessageRepoImpl$trackError$1(this, "getAllMessagesAndMetaInfo", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<List<LocalMessage>> getAllPendingMessages() {
        Observable<R> map = this.a.getAllPendingMessages().map(new MessageRepoImpl$mapToLocalMessages$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "map { messageEntities ->…ocalMessage() }\n        }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "getAllPendingMessages", t6.n.r.emptyMap()));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0049: APUT  
      (r2v3 kotlin.Pair[])
      (3 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0044: INVOKE  (r11v6 kotlin.Pair) = ("remoteId"), (r14v1 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Single<Option<Long>> getFirstPageTimestamp(@NotNull String str, @NotNull String str2, int i2, @Nullable String str3, boolean z2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Single fromCallable = Single.fromCallable(new h(this, str, str2, i2, str3, z2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …)\n            }\n        }");
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(ChannelContext.Item.USER_ID, str);
        pairArr[1] = TuplesKt.to("channelId", str2);
        pairArr[2] = TuplesKt.to("ordinal", Integer.valueOf(i2));
        if (str3 == null) {
            str3 = "";
        }
        pairArr[3] = TuplesKt.to("remoteId", str3);
        Single<Option<Long>> retryWhen = fromCallable.retryWhen(new MessageRepoImpl$trackError$2(this, "getTimeStampOfMessage", t6.n.r.mapOf(pairArr)));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<Option<LocalMessage>> getLastMessage(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> map = this.a.getLastMessageSortedByIsPendingAndCreatedDesc(str, str2).map(new i(this));
        Intrinsics.checkNotNullExpressionValue(map, "messageDao.getLastMessag…) ?: none()\n            }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "getLastMessage", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Single<Option<Long>> getLastSyncedMessageTimestamp(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Single fromCallable = Single.fromCallable(new j(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …lId).toOption()\n        }");
        Single<Option<Long>> retryWhen = fromCallable.retryWhen(new MessageRepoImpl$trackError$2(this, "getLastSyncedMessageTimestamp", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<Option<Long>> getLatestLocallyReadTimestamp(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> map = this.a.getTimestampOfLatestIncomingMessageWithLocalReadStatus(str, str2, IsReadStatus.IS_READ_LOCALLY).map(MessageRepoImpl$mapToOption$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "map { it.singleOrNull().toOption() }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "getLatestLocallyReadTimestamp", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<Option<LocalMessage>> getLatestReadLocallyMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Observable<R> map = this.a.getLatestIncomingMessageWithLocalReadStatus(str, IsReadStatus.IS_READ_LOCALLY).map(new MessageRepoImpl$mapToLocalMessages$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "map { messageEntities ->…ocalMessage() }\n        }");
        Observable<R> map2 = map.map(MessageRepoImpl$mapToOption$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map2, "map { it.singleOrNull().toOption() }");
        Observable<R> retryWhen = map2.retryWhen(new MessageRepoImpl$trackError$1(this, "getLatestReadLocallyMessage", t6.n.q.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<Option<LocalMessage>> getMessage(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "localUserId", str2, "channelId", str3, "localMessageId");
        Observable<R> map = this.a.getMessage(str, str2, str3).map(new k(this));
        Intrinsics.checkNotNullExpressionValue(map, "messageDao.getMessage(\n ….toOption()\n            }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "getMessage", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Single<Option<Pair<LocalMessage, MessageMetaInfo>>> getMessageAndMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "localUserId", str2, "channelId", str3, "localMessageId");
        Observable combineLatest = Observable.combineLatest(this.a.getMessage(str, str2, str3), this.b.getMessageMetaInfo(str, str2, str3), new BiFunction<T1, T2, R>(this) { // from class: com.avito.android.messenger.conversation.mvi.data.MessageRepoImpl$getMessageAndMetaInfo$$inlined$combineLatestWith$1
            public final /* synthetic */ MessageRepoImpl a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                T2 t22 = t2;
                MessageEntity messageEntity = (MessageEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) t1);
                Option option = OptionKt.toOption(messageEntity != null ? this.a.d.toLocalMessage(messageEntity) : null);
                if (option instanceof None) {
                    return (R) None.INSTANCE;
                }
                if (option instanceof Some) {
                    return (R) new Some(TuplesKt.to((LocalMessage) ((Some) option).getT(), CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) t22)));
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        Single firstOrError = combineLatest.firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "messageDao.getMessage(\n …          .firstOrError()");
        Single<Option<Pair<LocalMessage, MessageMetaInfo>>> retryWhen = firstOrError.retryWhen(new MessageRepoImpl$trackError$2(this, "getMessageAndMetaInfo", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Single<Long> getMessageCount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Single fromCallable = Single.fromCallable(new l(this, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …geCount(userId)\n        }");
        Single<Long> retryWhen = fromCallable.retryWhen(new MessageRepoImpl$trackError$2(this, "getMessageCount", t6.n.q.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Single<Long> getMessageCountBefore(long j2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Single fromCallable = Single.fromCallable(new n(this, j2, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …rId, channelId)\n        }");
        Single<Long> retryWhen = fromCallable.retryWhen(new MessageRepoImpl$trackError$2(this, "getMessageCountBefore", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to(Sort.DATE, Long.valueOf(j2)))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Single<Option<MessageMetaInfo>> getMessageMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "localUserId", str2, "channelId", str3, "localMessageId");
        Single<R> map = this.b.getMessageMetaInfo(str, str2, str3).firstOrError().map(o.a);
        Intrinsics.checkNotNullExpressionValue(map, "messageMetaInfoDao.getMe…irstOrNull().toOption() }");
        Single<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$2(this, "getMessageMetaInfo", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<Option<LocalMessage>> getMessageWithRemoteId(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "remoteId");
        Observable<R> map = this.a.findByRemoteId(str, str2).map(new p(this));
        Intrinsics.checkNotNullExpressionValue(map, "messageDao.findByRemoteI….toOption()\n            }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "getMessageWithRemoteId", t6.n.q.mapOf(TuplesKt.to("remoteId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<List<LocalMessage>> getMessagesAfter(long j2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> map = this.a.getMessagesAfterSortedByIsPendingAndCreatedDesc(j2, str, str2).map(new MessageRepoImpl$mapToLocalMessages$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "map { messageEntities ->…ocalMessage() }\n        }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "getMessagesAfter", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to(Sort.DATE, Long.valueOf(j2)))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getMessagesAndMetaInfoAfter(long j2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> switchMap = this.a.getMessagesAfterSortedByIsPendingAndCreatedDesc(j2, str, str2).switchMap(new q(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(switchMap, "messageDao.getMessagesAf… channelId)\n            }");
        Observable<R> retryWhen = switchMap.retryWhen(new MessageRepoImpl$trackError$1(this, "getMessagesAndMetaInfoAfter", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to(Sort.DATE, Long.valueOf(j2)))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<List<Pair<LocalMessage, MessageMetaInfo>>> getMessagesAndMetaInfoBefore(long j2, @NotNull String str, @NotNull String str2, long j3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> switchMap = this.a.getMessagesBeforeSortedByIsPendingAndCreatedDesc(j2, str, str2, j3).switchMap(new r(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(switchMap, "messageDao.getMessagesBe… channelId)\n            }");
        Observable<R> retryWhen = switchMap.retryWhen(new MessageRepoImpl$trackError$1(this, "getMessagesAndMetaInfoBefore", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to(Sort.DATE, Long.valueOf(j2)), TuplesKt.to("limit", Long.valueOf(j3)))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<List<LocalMessage>> getMessagesBefore(long j2, @NotNull String str, @NotNull String str2, long j3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> map = this.a.getMessagesBeforeSortedByIsPendingAndCreatedDesc(j2, str, str2, j3).map(new MessageRepoImpl$mapToLocalMessages$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "map { messageEntities ->…ocalMessage() }\n        }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "getMessagesBefore", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to(Sort.DATE, Long.valueOf(j2)), TuplesKt.to("limit", Long.valueOf(j3)))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Single<List<LocalMessage>> getMessagesWithIncompleteBodies(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable map = MessageDao.DefaultImpls.getMessagesWithIncompleteBodies$default(this.a, str, str2, 0, 4, null).map(new MessageRepoImpl$mapToLocalMessages$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "map { messageEntities ->…ocalMessage() }\n        }");
        Single firstOrError = map.firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "messageDao.getMessagesWi…          .firstOrError()");
        Single<List<LocalMessage>> retryWhen = firstOrError.retryWhen(new MessageRepoImpl$trackError$2(this, "getMessagesWithIncompleteBodies", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Single<Option<Long>> getOldestMessageTimestampInChannel(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Single fromCallable = Single.fromCallable(new s(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …lId).toOption()\n        }");
        Single<Option<Long>> retryWhen = fromCallable.retryWhen(new MessageRepoImpl$trackError$2(this, "getOldestMessageTimestampInChannel", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<Integer> getUnreadMessagesCount(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<Integer> retryWhen = MessageDao.DefaultImpls.getUnreadMessagesCount$default(this.a, str, str2, null, 4, null).retryWhen(new MessageRepoImpl$trackError$1(this, "getUnreadMessagesCount", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<List<LocalMessage>> getUnsentMessages(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> map = this.a.getUnsentMessages(str, str2).map(new MessageRepoImpl$mapToLocalMessages$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "map { messageEntities ->…ocalMessage() }\n        }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "getUnsentMessages", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<Boolean> hasIncomingMessages(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> map = this.a.getIncomingMessageCount(str, str2).map(t.a);
        Intrinsics.checkNotNullExpressionValue(map, "messageDao.getIncomingMe…geCount > 0\n            }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "hasIncomingMessages", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable markIncomingMessagesAsReadInChannel(@NotNull String str, @NotNull String str2, long j2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable fromCallable = Completable.fromCallable(new u(this, str, str2, j2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…D\n            )\n        }");
        return a2.b.a.a.a.N1(this, "markIncomingMessagesAsReadInChannel", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to("timestamp", Long.valueOf(j2))), fromCallable, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable markMessagesAsFailed(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "localIds");
        Completable fromAction = Completable.fromAction(new v(this, list));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…toTypedArray())\n        }");
        return a2.b.a.a.a.N1(this, "markMessagesAsFailed", t6.n.q.mapOf(TuplesKt.to("localIds", list)), fromAction, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable markMessagesAsRead(@NotNull String str, @NotNull List<String> list, long j2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(list, "messageIds");
        Completable fromCallable = Completable.fromCallable(new w(this, str, list, j2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…Status.IS_READ)\n        }");
        return a2.b.a.a.a.N1(this, "markMessagesAsRead", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("messageIds", list), TuplesKt.to("timestamp", Long.valueOf(j2))), fromCallable, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable markOutgoingMessagesAsReadInChannel(@NotNull String str, @NotNull String str2, long j2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable fromCallable = Completable.fromCallable(new x(this, str, str2, j2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…D\n            )\n        }");
        return a2.b.a.a.a.N1(this, "markOutgoingMessagesAsReadInChannel", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to("timestamp", Long.valueOf(j2))), fromCallable, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<Option<LocalMessage>> observeFirstPendingMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Observable<R> map = this.a.getFirstPendingMessage(str).map(new MessageRepoImpl$mapToLocalMessages$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "map { messageEntities ->…ocalMessage() }\n        }");
        Observable<R> map2 = map.map(y.a);
        Intrinsics.checkNotNullExpressionValue(map2, "messageDao.getFirstPendi…irstOrNull().toOption() }");
        Observable<R> retryWhen = map2.retryWhen(new MessageRepoImpl$trackError$1(this, "observeFirstPendingMessage", t6.n.q.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Observable<Option<MessageMetaInfo>> observeMessageMetaInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "localUserId", str2, "channelId", str3, "localMessageId");
        Observable<R> map = this.b.getMessageMetaInfo(str, str2, str3).map(z.a);
        Intrinsics.checkNotNullExpressionValue(map, "messageMetaInfoDao.getMe…irstOrNull().toOption() }");
        Observable<R> retryWhen = map.retryWhen(new MessageRepoImpl$trackError$1(this, "observeMessageMetaInfo", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …odName, extras)\n        }");
        return retryWhen;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable resetMessageForResend(@NotNull String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "localId");
        Completable fromAction = Completable.fromAction(new a0(this, j2, str));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…stamp, localId)\n        }");
        return a2.b.a.a.a.N1(this, "resetMessageForResend", t6.n.r.mapOf(TuplesKt.to("localId", str), TuplesKt.to("newTimestamp", Long.valueOf(j2))), fromAction, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable setFileDownloadCanceled(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "localUserId", str2, "channelId", str3, "localMessageId");
        return a2.b.a.a.a.N1(this, "setFileDownloadCanceled", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3)), this.b.updateProgressAndStatusAndInternalPath(str, str2, str3, 0, TransferStatus.NONE, null), "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable setFileDownloadInternalPath(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
        a2.b.a.a.a.Z0(str, "localUserId", str2, "channelId", str3, "localMessageId");
        return a2.b.a.a.a.N1(this, "setFileDownloadInternalPath", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3), TuplesKt.to("internalPath", String.valueOf(str4))), this.b.updateInternalPath(str, str2, str3, str4), "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable setFileDownloadProgress(@NotNull String str, @NotNull String str2, @NotNull String str3, long j2) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "localMessageId");
        Completable fromCallable = Completable.fromCallable(new b0(this, str, str2, str3, j2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…S\n            )\n        }");
        return a2.b.a.a.a.N1(this, "setFileDownloadProgress", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3), TuplesKt.to("bytesTransferred", Long.valueOf(j2))), fromCallable, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable setFileDownloadStarted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "localMessageId");
        return a2.b.a.a.a.N1(this, "setFileDownloadStarted", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3)), this.b.insertOrReplace(new MessageMetaInfo(str, str2, str3, null, null, 0, TransferStatus.IN_PROGRESS)), "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable setFileDownloadedSuccessfully(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a2.b.a.a.a.b1(str, "localUserId", str2, "channelId", str3, "localMessageId", str4, MessageMetaInfo.COLUMN_PATH);
        return a2.b.a.a.a.N1(this, "setFileDownloadedSuccessfully", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3), TuplesKt.to(MessageMetaInfo.COLUMN_PATH, str4)), this.b.updateProgressAndStatusAndPath(str, str2, str3, 0, TransferStatus.SUCCESS, str4), "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable setFileTransferFailed(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "localUserId", str2, "channelId", str3, "localMessageId");
        return a2.b.a.a.a.N1(this, "setFileTransferFailed", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3)), this.b.updateProgressAndStatus(str, str2, str3, 0, TransferStatus.ERROR), "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable setFileUploadInProgress(@NotNull String str, @NotNull String str2, @NotNull String str3, long j2) {
        a2.b.a.a.a.Z0(str, "localUserId", str2, "channelId", str3, "localMessageId");
        return a2.b.a.a.a.N1(this, "setFileUploadInProgress", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3), TuplesKt.to("bytesTransferred", Long.valueOf(j2))), this.b.updateProgressAndStatus(str, str2, str3, j2, TransferStatus.IN_PROGRESS), "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable setFileUploadedSuccessfully(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "localUserId", str2, "channelId", str3, "localMessageId");
        return a2.b.a.a.a.N1(this, "setFileTransferredSuccessfully", t6.n.r.mapOf(TuplesKt.to("localUserId", str), TuplesKt.to("channelId", str2), TuplesKt.to("localMessageId", str3)), this.b.updateProgressAndStatus(str, str2, str3, 0, TransferStatus.SUCCESS), "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable setIsReadLocallyForMessagesInChannel(@NotNull String str, @NotNull String str2, long j2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable fromCallable = Completable.fromCallable(new c0(this, str, str2, j2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…p\n            )\n        }");
        return a2.b.a.a.a.N1(this, "setIsReadLocallyForMessagesInChannel", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to("readLocallyTimeStamp", Long.valueOf(j2))), fromCallable, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable updateLastSyncedMessageTimestamp(@NotNull String str, @NotNull String str2, long j2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable fromCallable = Completable.fromCallable(new d0(this, str, str2, j2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…)\n            }\n        }");
        return a2.b.a.a.a.N1(this, "updateLastSyncedMessageTimestamp", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to("timestamp", Long.valueOf(j2))), fromCallable, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter
    @NotNull
    public Completable updateMessage(@NotNull LocalMessage localMessage) {
        Intrinsics.checkNotNullParameter(localMessage, "message");
        Completable fromAction = Completable.fromAction(new e0(this, localMessage));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…essageEntity())\n        }");
        return a2.b.a.a.a.N1(this, "updateMessage", t6.n.q.mapOf(TuplesKt.to("message", localMessage)), fromAction, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageRepoReader
    @NotNull
    public Single<Long> getMessageCount(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Single fromCallable = Single.fromCallable(new m(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …rId, channelId)\n        }");
        Single<Long> retryWhen = fromCallable.retryWhen(new MessageRepoImpl$trackError$2(this, "getMessageCount", t6.n.r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2))));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "retryWhen { errors ->\n  …trategy.BUFFER)\n        }");
        return retryWhen;
    }
}
