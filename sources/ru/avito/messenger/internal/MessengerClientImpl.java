package ru.avito.messenger.internal;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.RxLogger;
import com.avito.android.util.RxLoggerDelegate;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import dagger.Lazy;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.MessengerState;
import ru.avito.messenger.NetworkMonitor;
import ru.avito.messenger.api.entity.BlacklistUserRequest;
import ru.avito.messenger.api.entity.BlockedUsersResponse;
import ru.avito.messenger.api.entity.BodyImagesResponse;
import ru.avito.messenger.api.entity.Channel;
import ru.avito.messenger.api.entity.ChannelUser;
import ru.avito.messenger.api.entity.ChannelsResponse;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.FoldersCountersResponse;
import ru.avito.messenger.api.entity.GetLastActionTimesResponse;
import ru.avito.messenger.api.entity.GetUsersResponse;
import ru.avito.messenger.api.entity.Image;
import ru.avito.messenger.api.entity.SuccessResponse;
import ru.avito.messenger.api.entity.UserLastActivity;
import ru.avito.messenger.api.entity.body.item.BodyItem;
import ru.avito.messenger.api.entity.body.item.Item;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
import ru.avito.messenger.internal.entity.messenger.UserSession;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004BP\u0012\u0015\u0010\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u00010\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u00028\u0000\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u00020,\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u001b\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\nH\u0016¢\u0006\u0004\b\u0013\u0010\rJ-\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\b\b\u0001\u0010\u0002*\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\nH\u0016¢\u0006\u0004\b\u001a\u0010\rJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u001b2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010'\u001a\u00020\u0012H\u0016¢\u0006\u0004\b(\u0010)J9\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010\u00122\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/JI\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030#0\u001b2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010 2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0012002\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001200H\u0016¢\u0006\u0004\b4\u00105J\u001d\u00106\u001a\b\u0012\u0004\u0012\u0002030\u001b2\u0006\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\b6\u0010)JA\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190#0\u001b2\u0006\u0010*\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u00010,2\b\u00108\u001a\u0004\u0018\u00010,2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b9\u0010:J%\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010;\u001a\u00020,H\u0016¢\u0006\u0004\b<\u0010=J)\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0#0\u001b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00120#H\u0016¢\u0006\u0004\b@\u0010AJ/\u0010E\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020D0C0\u001b2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001200H\u0016¢\u0006\u0004\bE\u0010FJ\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b2\u0006\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\bG\u0010)J+\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\u0006\u0010*\u001a\u00020\u00122\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00120#H\u0016¢\u0006\u0004\bI\u0010JJ)\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0#0\u001b2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00120#H\u0016¢\u0006\u0004\bM\u0010AJ1\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0#0\u001b2\u0006\u0010*\u001a\u00020\u00122\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00120#H\u0016¢\u0006\u0004\bO\u0010JJ=\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\u00122\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010#H\u0016¢\u0006\u0004\bS\u0010TJ-\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\u0012H\u0016¢\u0006\u0004\bU\u0010VJ-\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016¢\u0006\u0004\bW\u0010VJ-\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\u0012H\u0016¢\u0006\u0004\bY\u0010VJ%\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012H\u0016¢\u0006\u0004\b[\u0010\\J/\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010*\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010\u00122\u0006\u0010]\u001a\u00020\u0012H\u0016¢\u0006\u0004\b^\u0010VJ/\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b`\u0010VJI\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010*\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010\u00122\u0006\u0010b\u001a\u00020a2\u0006\u0010c\u001a\u00020a2\u0006\u0010d\u001a\u00020\u00122\b\u0010e\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\bh\u0010iJ\u001f\u0010j\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016¢\u0006\u0004\bj\u0010kJ9\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020l0#0\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u00122\b\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\bm\u0010nJ#\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0q0\u001b2\u0006\u0010p\u001a\u00020oH\u0016¢\u0006\u0004\bs\u0010tJ;\u0010v\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020 0C0\u001b2\u0018\u0010u\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0012000CH\u0016¢\u0006\u0004\bv\u0010wJ\u001c\u0010y\u001a\u00020\u0007*\u00020\u00072\u0006\u0010x\u001a\u00020\u0012H\u0001¢\u0006\u0004\by\u0010zJ.\u0010y\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010x\u001a\u00020\u0012H\u0001¢\u0006\u0004\by\u0010{J.\u0010y\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u001b2\u0006\u0010x\u001a\u00020\u0012H\u0001¢\u0006\u0004\by\u0010|R\"\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0\u00110\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\rR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00028\u00008\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lru/avito/messenger/internal/MessengerClientImpl;", "Lru/avito/messenger/MessengerApi;", "T", "Lru/avito/messenger/MessengerClient;", "Lcom/avito/android/util/RxLogger;", "", "force", "Lio/reactivex/Completable;", "connect", "(Z)Lio/reactivex/Completable;", "Lio/reactivex/Observable;", "Lru/avito/messenger/MessengerState;", "state", "()Lio/reactivex/Observable;", "", "reconnects", "allReconnects", "Lorg/funktionale/option/Option;", "", "currentUserId", "", "Ljava/lang/Class;", "clazz", "observeChatEvents", "(Ljava/lang/Class;)Lio/reactivex/Observable;", "Lru/avito/messenger/api/entity/ChatMessage;", "observeMessages", "Lio/reactivex/Single;", "withMessengerApi", "()Lio/reactivex/Single;", "getFallbackApi", "()Lru/avito/messenger/MessengerApi;", "", "offset", "limit", "", "Lru/avito/messenger/api/entity/BlockedUser;", "getBlacklist", "(ILjava/lang/Integer;)Lio/reactivex/Single;", ChannelContext.Item.USER_ID, "removeFromBlacklist", "(Ljava/lang/String;)Lio/reactivex/Single;", "channelId", "itemId", "", "reasonId", "addToBlacklist", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lio/reactivex/Single;", "", "tags", "excludeTags", "Lru/avito/messenger/api/entity/Channel;", "getChannels", "(ILjava/lang/Integer;Ljava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Single;", "getChannel", "before", "after", "history", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lio/reactivex/Single;", "timestamp", "markChannelAsRead", "(Ljava/lang/String;J)Lio/reactivex/Single;", "itemIds", "Lru/avito/messenger/api/entity/body/item/BodyItem;", "getBodyItems", "(Ljava/util/List;)Lio/reactivex/Single;", "imageIds", "", "Lru/avito/messenger/api/entity/Image;", "getBodyImages", "(Ljava/util/Collection;)Lio/reactivex/Single;", "clearChat", "messageIds", "markMessagesAsRead", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Single;", "userIds", "Lru/avito/messenger/api/entity/UserLastActivity;", "getUserLastActivity", "Lru/avito/messenger/api/entity/ChannelUser;", "getUsers", "localId", "text", "templates", "sendTextMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Single;", "sendReactionMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "sendItemMessage", "imageId", "sendImageMessage", "targetUserId", "sendCallMessage", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "url", "sendLinkMessage", MessageBody.File.FILE_ID, "sendFileMessage", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "title", MessageBody.Location.KIND, "sendLocationMessage", "(Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "hideAllExchangeChats", "(Ljava/lang/String;)Lio/reactivex/Completable;", "hideExchangeChats", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Lru/avito/messenger/api/entity/body/item/Item;", "getItemsForAttach", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "markersRequest", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "getGeoMarkers", "(Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;)Lio/reactivex/Single;", "folderWithTags", "getFoldersUnreadCounterByTags", "(Ljava/util/Map;)Lio/reactivex/Single;", "message", "log", "(Lio/reactivex/Completable;Ljava/lang/String;)Lio/reactivex/Completable;", "(Lio/reactivex/Observable;Ljava/lang/String;)Lio/reactivex/Observable;", "(Lio/reactivex/Single;Ljava/lang/String;)Lio/reactivex/Single;", "Lru/avito/messenger/internal/entity/messenger/UserSession;", "getSessionObservable", "sessionObservable", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "f", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "e", "J", "connectTimeout", "c", "Lru/avito/messenger/MessengerApi;", "fallbackApi", "Ldagger/Lazy;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "connectionHolder", "Lru/avito/messenger/NetworkMonitor;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/NetworkMonitor;", "networkMonitor", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Ldagger/Lazy;Lru/avito/messenger/NetworkMonitor;Lru/avito/messenger/MessengerApi;Lcom/avito/android/util/SchedulersFactory;JLcom/avito/android/communications_common/analytics/ErrorTracker;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerClientImpl<T extends MessengerApi> implements MessengerClient<T>, RxLogger {
    public final Lazy<MessengerConnectionHolder<T>> a;
    public final NetworkMonitor b;
    public final T c;
    public final SchedulersFactory d;
    public final long e;
    public final ErrorTracker f;
    public final /* synthetic */ RxLoggerDelegate g = new RxLoggerDelegate(false, "MessengerClient");

    public static final class a<T, R> implements Function<T, SingleSource<? extends Unit>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Long d;

        public a(String str, String str2, String str3, Long l) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = l;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Unit> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.addToBlackList(t6.n.d.listOf(new BlacklistUserRequest(this.a, this.b, this.c)), this.d);
        }
    }

    public static final class a0<T, R> implements Function<T, SingleSource<? extends Boolean>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        public a0(String str, long j) {
            this.a = str;
            this.b = j;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Boolean> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.markChannelAsRead(this.a, this.b);
        }
    }

    public static final class b<T, R> implements Function<Unit, Unit> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function
        public Unit apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class b0<T, R> implements Function<Boolean, Unit> {
        public static final b0 a = new b0();

        @Override // io.reactivex.functions.Function
        public Unit apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Predicate<MessengerConnectionHolder.State> {
        public static final c a = new c();

        @Override // io.reactivex.functions.Predicate
        public boolean test(MessengerConnectionHolder.State state) {
            MessengerConnectionHolder.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            return state2 instanceof MessengerConnectionHolder.State.Connected;
        }
    }

    public static final class c0<T, R> implements Function<T, SingleSource<? extends Boolean>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;

        public c0(String str, List list) {
            this.a = str;
            this.b = list;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Boolean> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.markMessagesAsRead(this.a, this.b);
        }
    }

    public static final class d<T, R> implements Function<MessengerConnectionHolder.State, Boolean> {
        public static final d a = new d();

        @Override // io.reactivex.functions.Function
        public Boolean apply(MessengerConnectionHolder.State state) {
            MessengerConnectionHolder.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            return Boolean.valueOf(state2 instanceof MessengerConnectionHolder.State.Connected);
        }
    }

    public static final class d0<T, R> implements Function<Boolean, Unit> {
        public static final d0 a = new d0();

        @Override // io.reactivex.functions.Function
        public Unit apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class e<T, R> implements Function<MessengerConnectionHolder.State.Connected, Boolean> {
        public static final e a = new e();

        @Override // io.reactivex.functions.Function
        public Boolean apply(MessengerConnectionHolder.State.Connected connected) {
            MessengerConnectionHolder.State.Connected connected2 = connected;
            Intrinsics.checkNotNullParameter(connected2, "state");
            return Boolean.valueOf(connected2.getRecovered());
        }
    }

    public static final class e0<T, R> implements Function<Object, ObservableSource<? extends Object>> {
        public static final e0 a = new e0();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [a7.a.b.a.l] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.ObservableSource<? extends java.lang.Object> apply(java.lang.Object r3) {
            /*
                r2 = this;
                java.lang.String r0 = "event"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                boolean r0 = r3 instanceof ru.avito.messenger.internal.entity.messenger.BatchNotification
                if (r0 == 0) goto L_0x0034
                ru.avito.messenger.internal.entity.messenger.BatchNotification r3 = (ru.avito.messenger.internal.entity.messenger.BatchNotification) r3
                java.util.List r3 = r3.getMessages()
                io.reactivex.Observable r3 = io.reactivex.Observable.fromIterable(r3)
                java.lang.String r0 = "Observable.fromIterable(event.messages)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                java.lang.Class<ru.avito.messenger.internal.entity.messenger.SystemEvent> r0 = ru.avito.messenger.internal.entity.messenger.SystemEvent.class
                io.reactivex.Observable r3 = r3.ofType(r0)
                java.lang.String r0 = "ofType(R::class.java)"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
                kotlin.reflect.KProperty1 r0 = a7.a.b.a.j.a
                if (r0 == 0) goto L_0x002d
                a7.a.b.a.l r1 = new a7.a.b.a.l
                r1.<init>(r0)
                r0 = r1
            L_0x002d:
                io.reactivex.functions.Function r0 = (io.reactivex.functions.Function) r0
                io.reactivex.Observable r3 = r3.map(r0)
                goto L_0x0038
            L_0x0034:
                io.reactivex.Observable r3 = io.reactivex.Observable.just(r3)
            L_0x0038:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.MessengerClientImpl.e0.apply(java.lang.Object):java.lang.Object");
        }
    }

    public static final class f<T, R> implements Function<T, SingleSource<? extends Boolean>> {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Boolean> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.clearHistory(t6.n.d.listOf(this.a));
        }
    }

    public static final class f0<T> implements Predicate<Boolean> {
        public static final f0 a = new f0();

        @Override // io.reactivex.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "recovered");
            return !bool2.booleanValue();
        }
    }

    public static final class g<T, R> implements Function<Boolean, String> {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // io.reactivex.functions.Function
        public String apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return this.a;
        }
    }

    public static final class g0<T, R> implements Function<Boolean, Unit> {
        public static final g0 a = new g0();

        @Override // io.reactivex.functions.Function
        public Unit apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class h<V> implements Callable<Object> {
        public final /* synthetic */ MessengerClientImpl a;
        public final /* synthetic */ boolean b;

        public h(MessengerClientImpl messengerClientImpl, boolean z) {
            this.a = messengerClientImpl;
            this.b = z;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            if (this.b) {
                ((MessengerConnectionHolder) this.a.a.get()).connect();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class h0<T, R> implements Function<T, SingleSource<? extends SuccessResponse>> {
        public final /* synthetic */ String a;

        public h0(String str) {
            this.a = str;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends SuccessResponse> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.removeFromBlackList(this.a);
        }
    }

    public static final class i<T, R> implements Function<Option<? extends UserSession>, Option<? extends String>> {
        public static final i a = new i();

        @Override // io.reactivex.functions.Function
        public Option<? extends String> apply(Option<? extends UserSession> option) {
            Option<? extends UserSession> option2 = option;
            Intrinsics.checkNotNullParameter(option2, "userSession");
            if (option2.isEmpty()) {
                return Option.None.INSTANCE;
            }
            return new Option.Some(((UserSession) option2.get()).getUserId());
        }
    }

    public static final class i0<T, R> implements Function<T, SingleSource<? extends ChatMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public i0(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChatMessage> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.sendCallMessage(this.a, this.b);
        }
    }

    public static final class j<T, R> implements Function<T, SingleSource<? extends BlockedUsersResponse>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Integer b;

        public j(int i, Integer num) {
            this.a = i;
            this.b = num;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends BlockedUsersResponse> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.getBlacklist(this.a, this.b);
        }
    }

    public static final class j0<T, R> implements Function<T, SingleSource<? extends ChatMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public j0(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChatMessage> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.sendFileMessage(this.a, this.b, this.c);
        }
    }

    public static final class k<T, R> implements Function<T, SingleSource<? extends BodyImagesResponse>> {
        public final /* synthetic */ Collection a;

        public k(Collection collection) {
            this.a = collection;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends BodyImagesResponse> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.getBodyImages(this.a);
        }
    }

    public static final class k0<T, R> implements Function<T, SingleSource<? extends ChatMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k0(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChatMessage> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.sendImageMessage(this.a, this.b, this.c);
        }
    }

    public static final class l<T, R> implements Function<BodyImagesResponse, Map<String, ? extends Image>> {
        public static final l a = new l();

        @Override // io.reactivex.functions.Function
        public Map<String, ? extends Image> apply(BodyImagesResponse bodyImagesResponse) {
            BodyImagesResponse bodyImagesResponse2 = bodyImagesResponse;
            Intrinsics.checkNotNullParameter(bodyImagesResponse2, "it");
            return bodyImagesResponse2.getImages();
        }
    }

    public static final class l0<T, R> implements Function<T, SingleSource<? extends ChatMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public l0(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChatMessage> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.sendItemMessage(this.a, this.b, this.c);
        }
    }

    public static final class m<T, R> implements Function<T, SingleSource<? extends List<? extends BodyItem>>> {
        public final /* synthetic */ List a;

        public m(List list) {
            this.a = list;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends List<? extends BodyItem>> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.getBodyItems(this.a);
        }
    }

    public static final class m0<T, R> implements Function<T, SingleSource<? extends ChatMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public m0(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChatMessage> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.sendLinkMessage(this.a, this.b, this.c);
        }
    }

    public static final class n<T, R> implements Function<T, SingleSource<? extends Channel>> {
        public final /* synthetic */ String a;

        public n(String str) {
            this.a = str;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Channel> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.getChatById(this.a);
        }
    }

    public static final class n0<T, R> implements Function<T, SingleSource<? extends ChatMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ double b;
        public final /* synthetic */ double c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public n0(String str, double d2, double d3, String str2, String str3, String str4) {
            this.a = str;
            this.b = d2;
            this.c = d3;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChatMessage> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.sendLocationMessage(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    public static final class o<T, R> implements Function<T, SingleSource<? extends ChannelsResponse>> {
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Collection b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Integer d;

        public o(Collection collection, Collection collection2, int i, Integer num) {
            this.a = collection;
            this.b = collection2;
            this.c = i;
            this.d = num;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChannelsResponse> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!this.a.isEmpty()) {
                Pair pair = TuplesKt.to("tags", this.a);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            if (!this.b.isEmpty()) {
                Pair pair2 = TuplesKt.to("excludeTags", this.b);
                linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
            }
            return messengerApi.getChats(this.c, this.d, linkedHashMap);
        }
    }

    public static final class o0<T, R> implements Function<T, SingleSource<? extends ChatMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public o0(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChatMessage> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.sendReactionMessage(this.a, this.b, this.c);
        }
    }

    public static final class p<T, R> implements Function<T, SingleSource<? extends FoldersCountersResponse>> {
        public final /* synthetic */ Map a;

        public p(Map map) {
            this.a = map;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends FoldersCountersResponse> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.getFolderCounters(this.a);
        }
    }

    public static final class p0<T, R> implements Function<T, SingleSource<? extends ChatMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ List d;

        public p0(String str, String str2, String str3, List list) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = list;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends ChatMessage> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.sendTextMessage(this.a, this.b, this.c, this.d);
        }
    }

    public static final class q<T, R> implements Function<T, SingleSource<? extends GeoMarker[]>> {
        public final /* synthetic */ MarkersRequest a;

        public q(MarkersRequest markersRequest) {
            this.a = markersRequest;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends GeoMarker[]> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.getGeoMarkers(this.a.getMethod(), this.a.getParams());
        }
    }

    public static final class q0<T, R> implements Function<MessengerConnectionHolder.State, Option<? extends UserSession>> {
        public static final q0 a = new q0();

        @Override // io.reactivex.functions.Function
        public Option<? extends UserSession> apply(MessengerConnectionHolder.State state) {
            MessengerConnectionHolder.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "it");
            UserSession userSession = null;
            if (!(state2 instanceof MessengerConnectionHolder.State.Connected)) {
                state2 = null;
            }
            MessengerConnectionHolder.State.Connected connected = (MessengerConnectionHolder.State.Connected) state2;
            if (connected != null) {
                userSession = connected.getSession();
            }
            return OptionKt.toOption(userSession);
        }
    }

    public static final class r<T, R> implements Function<T, SingleSource<? extends List<? extends BodyItem>>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ Integer c;

        public r(String str, Integer num, Integer num2) {
            this.a = str;
            this.b = num;
            this.c = num2;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends List<? extends BodyItem>> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            String str = this.a;
            return messengerApi.getItemsForAttach(str != null ? Long.valueOf(Long.parseLong(str)) : null, this.b, this.c, "");
        }
    }

    public static final class r0<T, R> implements Function<MessengerConnectionHolder.State, MessengerState> {
        public static final r0 a = new r0();

        @Override // io.reactivex.functions.Function
        public MessengerState apply(MessengerConnectionHolder.State state) {
            MessengerConnectionHolder.State state2 = state;
            Intrinsics.checkNotNullParameter(state2, "state");
            if (state2 instanceof MessengerConnectionHolder.State.Disconnected) {
                if (state2.isAwaitingConnection()) {
                    return new MessengerState.Connecting(false, 1, null);
                }
                TerminationEvent terminationEvent = ((MessengerConnectionHolder.State.Disconnected) state2).getTerminationEvent();
                if (terminationEvent == null) {
                    terminationEvent = new TerminationEvent.Unknown(null, null, null, 7, null);
                }
                return new MessengerState.Disconnected(terminationEvent, 0, 2, null);
            } else if ((state2 instanceof MessengerConnectionHolder.State.Connecting.Socket) || (state2 instanceof MessengerConnectionHolder.State.Connecting.Session)) {
                return new MessengerState.Connecting(false, 1, null);
            } else {
                if (state2 instanceof MessengerConnectionHolder.State.Connected) {
                    return MessengerState.Connected.INSTANCE;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class s<T, R> implements Function<List<? extends BodyItem>, List<? extends Item>> {
        public static final s a = new s();

        @Override // io.reactivex.functions.Function
        public List<? extends Item> apply(List<? extends BodyItem> list) {
            List<? extends BodyItem> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "items");
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
            for (T t : list2) {
                Objects.requireNonNull(t, "null cannot be cast to non-null type ru.avito.messenger.api.entity.body.item.Item");
                arrayList.add(t);
            }
            return arrayList;
        }
    }

    public static final class s0<T, R> implements Function<MessengerState, String> {
        public static final s0 a = new s0();

        @Override // io.reactivex.functions.Function
        public String apply(MessengerState messengerState) {
            MessengerState messengerState2 = messengerState;
            Intrinsics.checkNotNullParameter(messengerState2, "state");
            return messengerState2.getClass().getName();
        }
    }

    public static final class t<T, R> implements Function<T, SingleSource<? extends GetLastActionTimesResponse>> {
        public final /* synthetic */ List a;

        public t(List list) {
            this.a = list;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends GetLastActionTimesResponse> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            List<T> list = this.a;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(Long.valueOf(Long.parseLong(t)));
            }
            return messengerApi.getUserLastActionTimes(arrayList);
        }
    }

    public static final class t0<T, R> implements Function<Unit, T> {
        public final /* synthetic */ MessengerClientImpl a;

        public t0(MessengerClientImpl messengerClientImpl) {
            this.a = messengerClientImpl;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return ((MessengerConnectionHolder) this.a.a.get()).getApi();
        }
    }

    public static final class u<T, R> implements Function<GetLastActionTimesResponse, List<? extends UserLastActivity>> {
        public static final u a = new u();

        @Override // io.reactivex.functions.Function
        public List<? extends UserLastActivity> apply(GetLastActionTimesResponse getLastActionTimesResponse) {
            GetLastActionTimesResponse getLastActionTimesResponse2 = getLastActionTimesResponse;
            Intrinsics.checkNotNullParameter(getLastActionTimesResponse2, "it");
            return getLastActionTimesResponse2.getUsers();
        }
    }

    public static final class v<T, R> implements Function<T, SingleSource<? extends GetUsersResponse>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;

        public v(String str, List list) {
            this.a = str;
            this.b = list;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends GetUsersResponse> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            String str = this.a;
            List<T> list = this.b;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(Long.valueOf(Long.parseLong(t)));
            }
            return messengerApi.getUsers(str, arrayList);
        }
    }

    public static final class w<T, R> implements Function<GetUsersResponse, List<? extends ChannelUser>> {
        public static final w a = new w();

        @Override // io.reactivex.functions.Function
        public List<? extends ChannelUser> apply(GetUsersResponse getUsersResponse) {
            GetUsersResponse getUsersResponse2 = getUsersResponse;
            Intrinsics.checkNotNullParameter(getUsersResponse2, "it");
            return getUsersResponse2.getUsers();
        }
    }

    public static final class x<T, R> implements Function<T, SingleSource<? extends Unit>> {
        public final /* synthetic */ String a;

        public x(String str) {
            this.a = str;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Unit> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.setOptions(t6.n.q.mapOf(TuplesKt.to("filterExchange", t6.n.r.mapOf(TuplesKt.to("enable", Boolean.TRUE), TuplesKt.to("channelId", this.a)))));
        }
    }

    public static final class y<T, R> implements Function<T, SingleSource<? extends Unit>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public y(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Unit> apply(Object obj) {
            MessengerApi messengerApi = (MessengerApi) obj;
            Intrinsics.checkNotNullParameter(messengerApi, "api");
            return messengerApi.setOptions(t6.n.q.mapOf(TuplesKt.to("addHideExchangeItem", t6.n.r.mapOf(TuplesKt.to("itemId", Long.valueOf(Long.parseLong(this.a))), TuplesKt.to("channelId", this.b)))));
        }
    }

    public static final class z<T, R> implements Function<T, SingleSource<? extends List<? extends ChatMessage>>> {
        public final /* synthetic */ Long a;
        public final /* synthetic */ Long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Integer d;

        public z(Long l, Long l2, String str, Integer num) {
            this.a = l;
            this.b = l2;
            this.c = str;
            this.d = num;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [a7.a.b.a.l] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.SingleSource<? extends java.util.List<? extends ru.avito.messenger.api.entity.ChatMessage>> apply(java.lang.Object r5) {
            /*
                r4 = this;
                ru.avito.messenger.MessengerApi r5 = (ru.avito.messenger.MessengerApi) r5
                java.lang.String r0 = "api"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.Long r0 = r4.a
                if (r0 != 0) goto L_0x0018
                java.lang.Long r1 = r4.b
                if (r1 != 0) goto L_0x0018
                java.lang.String r0 = r4.c
                java.lang.Integer r1 = r4.d
                io.reactivex.Single r5 = r5.latestMessages(r0, r1)
                goto L_0x0022
            L_0x0018:
                java.lang.String r1 = r4.c
                java.lang.Long r2 = r4.b
                java.lang.Integer r3 = r4.d
                io.reactivex.Single r5 = r5.messagesBefore(r1, r0, r2, r3)
            L_0x0022:
                kotlin.reflect.KProperty1 r0 = a7.a.b.a.h.a
                if (r0 == 0) goto L_0x002c
                a7.a.b.a.l r1 = new a7.a.b.a.l
                r1.<init>(r0)
                r0 = r1
            L_0x002c:
                io.reactivex.functions.Function r0 = (io.reactivex.functions.Function) r0
                io.reactivex.Single r5 = r5.map(r0)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.MessengerClientImpl.z.apply(java.lang.Object):java.lang.Object");
        }
    }

    public MessengerClientImpl(@NotNull Lazy<MessengerConnectionHolder<T>> lazy, @NotNull NetworkMonitor networkMonitor, @NotNull T t2, @NotNull SchedulersFactory schedulersFactory, long j2, @NotNull ErrorTracker errorTracker) {
        Intrinsics.checkNotNullParameter(lazy, "connectionHolder");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics.checkNotNullParameter(t2, "fallbackApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorTracker, "errorTracker");
        this.a = lazy;
        this.b = networkMonitor;
        this.c = t2;
        this.d = schedulersFactory;
        this.e = j2;
        this.f = errorTracker;
    }

    public static Single a(MessengerClientImpl messengerClientImpl, long j2, int i2) {
        if ((i2 & 1) != 0) {
            j2 = messengerClientImpl.e;
        }
        Single<R> flatMap = messengerClientImpl.b.networkAvailability().first(Boolean.TRUE).flatMap(new a7.a.b.a.d(messengerClientImpl, j2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "networkMonitor.networkAv…          }\n            }");
        return flatMap;
    }

    @Override // ru.avito.messenger.MessengerBlacklist
    @NotNull
    public Single<Unit> addToBlacklist(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Single<R> map = withMessengerApi().flatMap(new a(str, str2, str3, l2)).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "withMessengerApi()\n     …            .map { Unit }");
        return map;
    }

    @Override // ru.avito.messenger.MessengerConnection
    @NotNull
    public Observable<Boolean> allReconnects() {
        Observable<MessengerConnectionHolder.State> distinctUntilChanged = this.a.get().getStateObservable().observeOn(this.d.computation()).skipWhile(c.a).distinctUntilChanged(d.a);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "connectionHolder.get()\n …nHolder.State.Connected }");
        Observable<U> ofType = distinctUntilChanged.ofType(MessengerConnectionHolder.State.Connected.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Observable<R> map = ofType.map(e.a);
        Intrinsics.checkNotNullExpressionValue(map, "connectionHolder.get()\n …tate -> state.recovered }");
        return map;
    }

    @Override // ru.avito.messenger.MessengerHistory
    @NotNull
    public Single<String> clearChat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Single<R> map = withMessengerApi().flatMap(new f(str)).map(new g(str));
        Intrinsics.checkNotNullExpressionValue(map, "withMessengerApi()\n     …       .map { channelId }");
        return map;
    }

    @Override // ru.avito.messenger.MessengerConnection
    @NotNull
    public Completable connect(boolean z2) {
        Completable andThen = Completable.fromCallable(new h(this, z2)).andThen(a(this, 0, 1).ignoreElement());
        Intrinsics.checkNotNullExpressionValue(andThen, "Completable.fromCallable…reElement()\n            )");
        return log(andThen, "connect(force = " + z2 + ')');
    }

    @Override // ru.avito.messenger.MessengerSession
    @NotNull
    public Observable<Option<String>> currentUserId() {
        Observable<R> map = getSessionObservable().map(i.a);
        Intrinsics.checkNotNullExpressionValue(map, "sessionObservable.map { …ession::userId)\n        }");
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [a7.a.b.a.l] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // ru.avito.messenger.MessengerBlacklist
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Single<java.util.List<ru.avito.messenger.api.entity.BlockedUser>> getBlacklist(int r3, @org.jetbrains.annotations.Nullable java.lang.Integer r4) {
        /*
            r2 = this;
            io.reactivex.Single r0 = r2.withMessengerApi()
            ru.avito.messenger.internal.MessengerClientImpl$j r1 = new ru.avito.messenger.internal.MessengerClientImpl$j
            r1.<init>(r3, r4)
            io.reactivex.Single r3 = r0.flatMap(r1)
            kotlin.reflect.KProperty1 r4 = a7.a.b.a.e.a
            if (r4 == 0) goto L_0x0017
            a7.a.b.a.l r0 = new a7.a.b.a.l
            r0.<init>(r4)
            r4 = r0
        L_0x0017:
            io.reactivex.functions.Function r4 = (io.reactivex.functions.Function) r4
            io.reactivex.Single r3 = r3.map(r4)
            java.lang.String r4 = "withMessengerApi()\n     …ckedUsersResponse::users)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.MessengerClientImpl.getBlacklist(int, java.lang.Integer):io.reactivex.Single");
    }

    @Override // ru.avito.messenger.MessengerHistory
    @NotNull
    public Single<Map<String, Image>> getBodyImages(@NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "imageIds");
        Single<R> map = withMessengerApi().flatMap(new k(collection)).map(l.a);
        Intrinsics.checkNotNullExpressionValue(map, "withMessengerApi()\n     …       .map { it.images }");
        return map;
    }

    @Override // ru.avito.messenger.MessengerHistory
    @NotNull
    public Single<List<BodyItem>> getBodyItems(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "itemIds");
        Single<R> flatMap = withMessengerApi().flatMap(new m(list));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     …i.getBodyItems(itemIds) }");
        return flatMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.avito.messenger.internal.MessengerClientImpl<T extends ru.avito.messenger.MessengerApi> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // ru.avito.messenger.MessengerChannels
    @NotNull
    public Single<Channel> getChannel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Single flatMap = withMessengerApi().flatMap(new n(str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     ….getChatById(channelId) }");
        return log(flatMap, "getChannel(channelId = " + str + ')');
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r4v6. Raw type applied. Possible types: io.reactivex.Single<T extends ru.avito.messenger.MessengerApi>, io.reactivex.Single<java.util.List<ru.avito.messenger.api.entity.Channel>> */
    /* JADX WARN: Type inference failed for: r2v1, types: [a7.a.b.a.l] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // ru.avito.messenger.MessengerChannels
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Single<java.util.List<ru.avito.messenger.api.entity.Channel>> getChannels(int r4, @org.jetbrains.annotations.Nullable java.lang.Integer r5, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.String> r6, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.String> r7) {
        /*
            r3 = this;
            java.lang.String r0 = "tags"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "excludeTags"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            io.reactivex.Single r0 = r3.withMessengerApi()
            ru.avito.messenger.internal.MessengerClientImpl$o r1 = new ru.avito.messenger.internal.MessengerClientImpl$o
            r1.<init>(r6, r7, r4, r5)
            io.reactivex.Single r0 = r0.flatMap(r1)
            kotlin.reflect.KProperty1 r1 = a7.a.b.a.f.a
            if (r1 == 0) goto L_0x0022
            a7.a.b.a.l r2 = new a7.a.b.a.l
            r2.<init>(r1)
            r1 = r2
        L_0x0022:
            io.reactivex.functions.Function r1 = (io.reactivex.functions.Function) r1
            io.reactivex.Single r0 = r0.map(r1)
            java.lang.String r1 = "withMessengerApi()\n     …annelsResponse::channels)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getChannels(offset = "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = ", limit = "
            r1.append(r4)
            r1.append(r5)
            java.lang.String r4 = ", tags = "
            r1.append(r4)
            r1.append(r6)
            java.lang.String r4 = ", excludeTags = "
            r1.append(r4)
            r1.append(r7)
            r4 = 41
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            io.reactivex.Single r4 = r3.log(r0, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.MessengerClientImpl.getChannels(int, java.lang.Integer, java.util.Collection, java.util.Collection):io.reactivex.Single");
    }

    @Override // ru.avito.messenger.MessengerApiProvider
    @NotNull
    public T getFallbackApi() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [a7.a.b.a.l] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // ru.avito.messenger.MessengerChannels
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Single<java.util.Map<java.lang.String, java.lang.Integer>> getFoldersUnreadCounterByTags(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, ? extends java.util.Collection<java.lang.String>> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "folderWithTags"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            io.reactivex.Single r0 = r2.withMessengerApi()
            ru.avito.messenger.internal.MessengerClientImpl$p r1 = new ru.avito.messenger.internal.MessengerClientImpl$p
            r1.<init>(r3)
            io.reactivex.Single r3 = r0.flatMap(r1)
            kotlin.reflect.KProperty1 r0 = a7.a.b.a.g.a
            if (r0 == 0) goto L_0x001c
            a7.a.b.a.l r1 = new a7.a.b.a.l
            r1.<init>(r0)
            r0 = r1
        L_0x001c:
            io.reactivex.functions.Function r0 = (io.reactivex.functions.Function) r0
            io.reactivex.Single r3 = r3.map(r0)
            java.lang.String r0 = "withMessengerApi()\n     …untersResponse::counters)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.MessengerClientImpl.getFoldersUnreadCounterByTags(java.util.Map):io.reactivex.Single");
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: io.reactivex.Single<R>, java.lang.Object, io.reactivex.Single<com.avito.android.remote.model.messenger.geo.GeoMarker[]> */
    @Override // ru.avito.messenger.MessengerPlatform
    @NotNull
    public Single<GeoMarker[]> getGeoMarkers(@NotNull MarkersRequest markersRequest) {
        Intrinsics.checkNotNullParameter(markersRequest, "markersRequest");
        Single single = (Single<R>) withMessengerApi().flatMap(new q(markersRequest));
        Intrinsics.checkNotNullExpressionValue(single, "withMessengerApi()\n     …est.params)\n            }");
        return single;
    }

    @Override // ru.avito.messenger.ItemsForAttachApi
    @NotNull
    public Single<List<Item>> getItemsForAttach(@Nullable String str, @Nullable Integer num, @Nullable Integer num2) {
        Single<R> map = withMessengerApi().flatMap(new r(str, num, num2)).map(s.a);
        Intrinsics.checkNotNullExpressionValue(map, "withMessengerApi()\n     …tems.map { it as Item } }");
        return map;
    }

    @Override // ru.avito.messenger.MessengerSession
    @NotNull
    public Observable<Option<UserSession>> getSessionObservable() {
        Observable<R> map = this.a.get().getStateObservable().map(q0.a);
        Intrinsics.checkNotNullExpressionValue(map, "connectionHolder.get()\n …ed)?.session.toOption() }");
        return map;
    }

    @Override // ru.avito.messenger.MessengerUserProvider
    @NotNull
    public Single<List<UserLastActivity>> getUserLastActivity(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "userIds");
        Single<R> map = withMessengerApi().flatMap(new t(list)).map(u.a);
        Intrinsics.checkNotNullExpressionValue(map, "withMessengerApi()\n     …        .map { it.users }");
        return map;
    }

    @Override // ru.avito.messenger.MessengerUserProvider
    @NotNull
    public Single<List<ChannelUser>> getUsers(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(list, "userIds");
        Single<R> map = withMessengerApi().flatMap(new v(str, list)).map(w.a);
        Intrinsics.checkNotNullExpressionValue(map, "withMessengerApi()\n     …        .map { it.users }");
        return map;
    }

    @Override // ru.avito.messenger.MessengerExchangeApi
    @NotNull
    public Completable hideAllExchangeChats(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Completable ignoreElement = withMessengerApi().flatMap(new x(str)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "withMessengerApi()\n     …         .ignoreElement()");
        return ignoreElement;
    }

    @Override // ru.avito.messenger.MessengerExchangeApi
    @NotNull
    public Completable hideExchangeChats(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "itemId");
        Completable ignoreElement = withMessengerApi().flatMap(new y(str2, str)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "withMessengerApi()\n     …         .ignoreElement()");
        return ignoreElement;
    }

    @Override // ru.avito.messenger.MessengerHistory
    @NotNull
    public Single<List<ChatMessage>> history(@NotNull String str, @Nullable Long l2, @Nullable Long l3, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Single<R> flatMap = withMessengerApi().flatMap(new z(l2, l3, str, num));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     …::messages)\n            }");
        return flatMap;
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public Completable log(@NotNull Completable completable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(completable, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        return this.g.log(completable, str);
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public <T> Observable<T> log(@NotNull Observable<T> observable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(observable, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        return this.g.log(observable, str);
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public <T> Single<T> log(@NotNull Single<T> single, @NotNull String str) {
        Intrinsics.checkNotNullParameter(single, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        return this.g.log(single, str);
    }

    @Override // ru.avito.messenger.MessengerHistory
    @NotNull
    public Single<Unit> markChannelAsRead(@NotNull String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Single<R> map = withMessengerApi().flatMap(new a0(str, j2)).map(b0.a);
        Intrinsics.checkNotNullExpressionValue(map, "withMessengerApi()\n     …            .map { Unit }");
        return map;
    }

    @Override // ru.avito.messenger.MessengerHistory
    @NotNull
    public Single<Unit> markMessagesAsRead(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(list, "messageIds");
        if (!list.isEmpty()) {
            Single<R> map = withMessengerApi().flatMap(new c0(str, list)).map(d0.a);
            Intrinsics.checkNotNullExpressionValue(map, "withMessengerApi()\n     …            .map { Unit }");
            return map;
        }
        Single<Unit> just = Single.just(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(Unit)");
        return just;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: io.reactivex.Observable<U>, java.lang.Object, io.reactivex.Observable<T extends ru.avito.messenger.MessengerApi> */
    /* JADX WARN: Type inference failed for: r2v0, types: [a7.a.b.a.l] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // ru.avito.messenger.MessengerEventObserver
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> io.reactivex.Observable<T> observeChatEvents(@org.jetbrains.annotations.NotNull java.lang.Class<T> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            dagger.Lazy<ru.avito.messenger.internal.connection.MessengerConnectionHolder<T extends ru.avito.messenger.MessengerApi>> r0 = r3.a
            java.lang.Object r0 = r0.get()
            ru.avito.messenger.internal.connection.MessengerConnectionHolder r0 = (ru.avito.messenger.internal.connection.MessengerConnectionHolder) r0
            io.reactivex.Observable r0 = r0.getMessagesStream()
            java.lang.Class<ru.avito.messenger.internal.entity.messenger.SystemEvent> r1 = ru.avito.messenger.internal.entity.messenger.SystemEvent.class
            io.reactivex.Observable r0 = r0.ofType(r1)
            java.lang.String r1 = "ofType(R::class.java)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kotlin.reflect.KProperty1 r1 = a7.a.b.a.i.a
            if (r1 == 0) goto L_0x0026
            a7.a.b.a.l r2 = new a7.a.b.a.l
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            io.reactivex.functions.Function r1 = (io.reactivex.functions.Function) r1
            io.reactivex.Observable r0 = r0.map(r1)
            ru.avito.messenger.internal.MessengerClientImpl$e0 r1 = ru.avito.messenger.internal.MessengerClientImpl.e0.a
            io.reactivex.Observable r0 = r0.concatMap(r1)
            io.reactivex.Observable r4 = r0.ofType(r4)
            java.lang.String r0 = "connectionHolder.get()\n …           .ofType(clazz)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.MessengerClientImpl.observeChatEvents(java.lang.Class):io.reactivex.Observable");
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: io.reactivex.Observable<T extends ru.avito.messenger.MessengerApi>, io.reactivex.Observable<ru.avito.messenger.api.entity.ChatMessage> */
    @Override // ru.avito.messenger.MessengerObserver
    @NotNull
    public Observable<ChatMessage> observeMessages() {
        return (Observable<T>) observeChatEvents(ChatMessage.class);
    }

    @Override // ru.avito.messenger.MessengerConnection
    @NotNull
    public Observable<Unit> reconnects() {
        Observable<R> map = allReconnects().filter(f0.a).map(g0.a);
        Intrinsics.checkNotNullExpressionValue(map, "allReconnects()\n        …d }\n        .map { Unit }");
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [a7.a.b.a.l] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // ru.avito.messenger.MessengerBlacklist
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Single<java.lang.Boolean> removeFromBlacklist(@org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "userId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            io.reactivex.Single r0 = r2.withMessengerApi()
            ru.avito.messenger.internal.MessengerClientImpl$h0 r1 = new ru.avito.messenger.internal.MessengerClientImpl$h0
            r1.<init>(r3)
            io.reactivex.Single r3 = r0.flatMap(r1)
            kotlin.reflect.KProperty1 r0 = a7.a.b.a.k.a
            if (r0 == 0) goto L_0x001d
            a7.a.b.a.l r1 = new a7.a.b.a.l
            r1.<init>(r0)
            r0 = r1
        L_0x001d:
            io.reactivex.functions.Function r0 = (io.reactivex.functions.Function) r0
            io.reactivex.Single r3 = r3.map(r0)
            java.lang.String r0 = "withMessengerApi()\n     …SuccessResponse::success)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.MessengerClientImpl.removeFromBlacklist(java.lang.String):io.reactivex.Single");
    }

    @Override // ru.avito.messenger.MessengerSender
    @NotNull
    public Single<ChatMessage> sendCallMessage(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "targetUserId");
        Single<R> flatMap = withMessengerApi().flatMap(new i0(str, str2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     …rgetUserId)\n            }");
        return flatMap;
    }

    @Override // ru.avito.messenger.MessengerSender
    @NotNull
    public Single<ChatMessage> sendFileMessage(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, MessageBody.File.FILE_ID);
        Single<R> flatMap = withMessengerApi().flatMap(new j0(str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     …          )\n            }");
        return flatMap;
    }

    @Override // ru.avito.messenger.MessengerSender
    @NotNull
    public Single<ChatMessage> sendImageMessage(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "localId");
        Intrinsics.checkNotNullParameter(str3, "imageId");
        Single<R> flatMap = withMessengerApi().flatMap(new k0(str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     …d, imageId)\n            }");
        return flatMap;
    }

    @Override // ru.avito.messenger.MessengerSender
    @NotNull
    public Single<ChatMessage> sendItemMessage(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "localId");
        Intrinsics.checkNotNullParameter(str3, "itemId");
        Single<R> flatMap = withMessengerApi().flatMap(new l0(str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     …Id, itemId)\n            }");
        return flatMap;
    }

    @Override // ru.avito.messenger.MessengerSender
    @NotNull
    public Single<ChatMessage> sendLinkMessage(@NotNull String str, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str3, "url");
        Single<R> flatMap = withMessengerApi().flatMap(new m0(str, str3, str2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     …l, localId)\n            }");
        return flatMap;
    }

    @Override // ru.avito.messenger.MessengerSender
    @NotNull
    public Single<ChatMessage> sendLocationMessage(@NotNull String str, @Nullable String str2, double d2, double d3, @NotNull String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str3, "title");
        Single<R> flatMap = withMessengerApi().flatMap(new n0(str, d2, d3, str3, str4, str2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     …          )\n            }");
        return flatMap;
    }

    @Override // ru.avito.messenger.MessengerSender
    @NotNull
    public Single<ChatMessage> sendReactionMessage(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "localId");
        Intrinsics.checkNotNullParameter(str3, "text");
        Single<R> flatMap = withMessengerApi().flatMap(new o0(str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     …alId, text)\n            }");
        return flatMap;
    }

    @Override // ru.avito.messenger.MessengerSender
    @NotNull
    public Single<ChatMessage> sendTextMessage(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "localId");
        Intrinsics.checkNotNullParameter(str3, "text");
        Single<R> flatMap = withMessengerApi().flatMap(new p0(str, str2, str3, list));
        Intrinsics.checkNotNullExpressionValue(flatMap, "withMessengerApi()\n     … templates)\n            }");
        return flatMap;
    }

    @Override // ru.avito.messenger.MessengerConnection
    @NotNull
    public Observable<MessengerState> state() {
        Observable<R> distinctUntilChanged = this.a.get().getStateObservable().map(r0.a).distinctUntilChanged(s0.a);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "connectionHolder.get()\n …-> state.javaClass.name }");
        return distinctUntilChanged;
    }

    @Override // ru.avito.messenger.MessengerApiProvider
    @NotNull
    public Single<T> withMessengerApi() {
        Single<T> map = a(this, 0, 1).map(new t0(this));
        Intrinsics.checkNotNullExpressionValue(map, "awaitConnectAndAuthoriza…nectionHolder.get().api }");
        return map;
    }
}
