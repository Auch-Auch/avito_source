package ru.avito.messenger;

import com.avito.android.jsonrpc.annotations.JsonRpcBody;
import com.avito.android.jsonrpc.annotations.JsonRpcMethod;
import com.avito.android.jsonrpc.annotations.JsonRpcMethodCall;
import com.avito.android.jsonrpc.annotations.JsonRpcMethodName;
import com.avito.android.jsonrpc.annotations.JsonRpcParam;
import com.avito.android.jsonrpc.annotations.JsonRpcParamsMap;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.messenger.ChatListBannersResponse;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context_actions.RecommendationsResponse;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggests;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.preferences.GeoContract;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.BlacklistReasons;
import ru.avito.messenger.api.entity.BlacklistUserRequest;
import ru.avito.messenger.api.entity.BlockedUsersResponse;
import ru.avito.messenger.api.entity.BodyImagesResponse;
import ru.avito.messenger.api.entity.Channel;
import ru.avito.messenger.api.entity.ChannelsCounters;
import ru.avito.messenger.api.entity.ChannelsResponse;
import ru.avito.messenger.api.entity.ChannelsSearchResponse;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.ChatMessagesResponse;
import ru.avito.messenger.api.entity.CreateFileResponse;
import ru.avito.messenger.api.entity.FoldersCountersResponse;
import ru.avito.messenger.api.entity.GetFileResponse;
import ru.avito.messenger.api.entity.GetLastActionTimesResponse;
import ru.avito.messenger.api.entity.GetUsersResponse;
import ru.avito.messenger.api.entity.SuccessResponse;
import ru.avito.messenger.api.entity.body.item.BodyItem;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u000b\u0010\bJ)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\r\u0010\bJG\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u0002H'¢\u0006\u0004\b\u0016\u0010\u0017J5\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u0017J5\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u0002H'¢\u0006\u0004\b\u001b\u0010\u0017J)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u0002H'¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b \u0010\u0017JU\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\"\u001a\u00020!2\b\b\u0001\u0010#\u001a\u00020!2\b\b\u0001\u0010$\u001a\u00020\u00022\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u0002H'¢\u0006\u0004\b)\u0010*J5\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010+\u001a\u00020\u00022\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b,\u0010\u0017J\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00062\b\b\u0001\u0010+\u001a\u00020\u0002H'¢\u0006\u0004\b.\u0010*JC\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00062\b\b\u0001\u00100\u001a\u00020/2\n\b\u0001\u00101\u001a\u0004\u0018\u00010/2\u0016\b\u0003\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000102H'¢\u0006\u0004\b5\u00106J/\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\u000e\b\u0001\u00108\u001a\b\u0012\u0004\u0012\u0002070\u0011H'¢\u0006\u0004\b:\u0010;J5\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u00062\b\b\u0001\u00100\u001a\u00020/2\n\b\u0001\u00101\u001a\u0004\u0018\u00010/2\b\b\u0001\u0010<\u001a\u00020\u0002H'¢\u0006\u0004\b>\u0010?J+\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\n\b\u0003\u00101\u001a\u0004\u0018\u00010/H'¢\u0006\u0004\bA\u0010BJC\u0010E\u001a\b\u0012\u0004\u0012\u00020@0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\n\b\u0001\u0010C\u001a\u0004\u0018\u0001072\n\b\u0001\u0010D\u001a\u0004\u0018\u0001072\n\b\u0003\u00101\u001a\u0004\u0018\u00010/H'¢\u0006\u0004\bE\u0010FJ5\u0010G\u001a\b\u0012\u0004\u0012\u00020@0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010D\u001a\u0002072\n\b\u0003\u00101\u001a\u0004\u0018\u00010/H'¢\u0006\u0004\bG\u0010HJ)\u0010K\u001a\b\u0012\u0004\u0012\u00020J0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010I\u001a\u000207H'¢\u0006\u0004\bK\u0010LJ/\u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\u000e\b\u0001\u00108\u001a\b\u0012\u0004\u0012\u0002070\u0011H'¢\u0006\u0004\bN\u0010;J%\u0010P\u001a\b\u0012\u0004\u0012\u00020J0\u00062\u000e\b\u0001\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H'¢\u0006\u0004\bP\u0010QJ\u001f\u0010S\u001a\b\u0012\u0004\u0012\u00020R0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u0002H'¢\u0006\u0004\bS\u0010*J+\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00110\u00062\u000e\b\u0001\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H'¢\u0006\u0004\bV\u0010QJ%\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0\u00062\u000e\b\u0001\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00020WH'¢\u0006\u0004\bZ\u0010[J1\u0010_\u001a\b\u0012\u0004\u0012\u00020M0\u00062\u000e\b\u0001\u0010]\u001a\b\u0012\u0004\u0012\u00020\\0\u00112\n\b\u0003\u0010^\u001a\u0004\u0018\u000107H'¢\u0006\u0004\b_\u0010`J\u001f\u0010c\u001a\b\u0012\u0004\u0012\u00020b0\u00062\b\b\u0001\u0010a\u001a\u00020\u0002H'¢\u0006\u0004\bc\u0010*J\u0015\u0010e\u001a\b\u0012\u0004\u0012\u00020d0\u0006H'¢\u0006\u0004\be\u0010fJ5\u0010h\u001a\b\u0012\u0004\u0012\u00020M0\u00062\b\b\u0001\u0010a\u001a\u0002072\b\b\u0001\u0010g\u001a\u00020\u00022\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u000107H'¢\u0006\u0004\bh\u0010iJ)\u0010j\u001a\b\u0012\u0004\u0012\u00020M0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010g\u001a\u00020\u0002H'¢\u0006\u0004\bj\u0010\u001eJ%\u0010l\u001a\b\u0012\u0004\u0012\u00020k0\u00062\u000e\b\u0001\u00108\u001a\b\u0012\u0004\u0012\u0002070\u0011H'¢\u0006\u0004\bl\u0010QJ+\u0010n\u001a\b\u0012\u0004\u0012\u00020m0\u00062\b\b\u0001\u00100\u001a\u00020/2\n\b\u0001\u00101\u001a\u0004\u0018\u00010/H'¢\u0006\u0004\bn\u0010oJ\u0015\u0010p\u001a\b\u0012\u0004\u0012\u00020M0\u0006H'¢\u0006\u0004\bp\u0010fJ/\u0010r\u001a\b\u0012\u0004\u0012\u00020J0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\u000e\b\u0001\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H'¢\u0006\u0004\br\u0010;J7\u0010s\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0011020\u00062\u000e\b\u0001\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H'¢\u0006\u0004\bs\u0010QJ-\u0010u\u001a\b\u0012\u0004\u0012\u00020M0\u00062\u0016\b\u0001\u0010t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000102H'¢\u0006\u0004\bu\u0010vJ\u0015\u0010x\u001a\b\u0012\u0004\u0012\u00020w0\u0006H'¢\u0006\u0004\bx\u0010fJ1\u0010{\u001a\b\u0012\u0004\u0012\u00020z0\u00062\u001a\b\u0001\u0010y\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020W02H'¢\u0006\u0004\b{\u0010vJI\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00110\u00062\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u0001072\n\b\u0001\u00101\u001a\u0004\u0018\u00010/2\n\b\u0001\u00100\u001a\u0004\u0018\u00010/2\b\b\u0001\u0010|\u001a\u00020\u0002H'¢\u0006\u0004\b}\u0010~J6\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200\u00062\b\b\u0001\u0010\"\u001a\u00020!2\b\b\u0001\u0010#\u001a\u00020!2\b\b\u0003\u0010%\u001a\u00020\u0002H'¢\u0006\u0006\b\u0001\u0010\u0001J;\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010<\u001a\u00020\u00022\f\b\u0001\u0010\u0001\u001a\u0005\u0018\u00010\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001JG\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00062\b\b\u0001\u0010a\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\f\b\u0001\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\b\u0001\u00101\u001a\u0004\u0018\u00010/H'¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\t\b\u0001\u0010\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u0001\u0010*J/\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00062\t\b\u0001\u0010\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0001\u001a\u00020/H'¢\u0006\u0006\b\u0001\u0010\u0001JJ\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020M0\u00062\u000e\b\u0001\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020W2\u000f\b\u0001\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020W2\u000f\b\u0001\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020WH'¢\u0006\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lru/avito/messenger/MessengerApi;", "", "", "methodName", "Lcom/avito/android/remote/model/RawJson;", "params", "Lio/reactivex/Single;", "callMethod", "(Ljava/lang/String;Lcom/avito/android/remote/model/RawJson;)Lio/reactivex/Single;", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "getGeoMarkers", "Lcom/avito/android/remote/model/messenger/context_actions/RecommendationsResponse;", "getRecommendations", "channelId", MessageBody.RANDOM_ID, "text", "", "templates", "Lru/avito/messenger/api/entity/ChatMessage;", "sendTextMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Single;", "sendReactionMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "itemId", "sendItemMessage", "imageId", "sendImageMessage", "targetUserId", "sendCallMessage", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "url", "sendLinkMessage", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "title", MessageBody.Location.KIND, "sendLocationMessage", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Lru/avito/messenger/api/entity/CreateFileResponse;", "createFile", "(Ljava/lang/String;)Lio/reactivex/Single;", MessageBody.File.FILE_ID, "sendFileMessage", "Lru/avito/messenger/api/entity/GetFileResponse;", "getFile", "", "offset", "limit", "", "filters", "Lru/avito/messenger/api/entity/ChannelsResponse;", "getChats", "(ILjava/lang/Integer;Ljava/util/Map;)Lio/reactivex/Single;", "", "userIds", "Lru/avito/messenger/api/entity/GetUsersResponse;", "getUsers", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Single;", "query", "Lru/avito/messenger/api/entity/ChannelsSearchResponse;", "searchChats", "(ILjava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Single;", "Lru/avito/messenger/api/entity/ChatMessagesResponse;", "latestMessages", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "before", "after", "messagesBefore", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lio/reactivex/Single;", "messagesAfter", "(Ljava/lang/String;JLjava/lang/Integer;)Lio/reactivex/Single;", "lastMessageTime", "", "markChannelAsRead", "(Ljava/lang/String;J)Lio/reactivex/Single;", "", "sendTyping", "channelIds", "clearHistory", "(Ljava/util/List;)Lio/reactivex/Single;", "Lru/avito/messenger/api/entity/Channel;", "getChatById", "itemIds", "Lru/avito/messenger/api/entity/body/item/BodyItem;", "getBodyItems", "", "imageIds", "Lru/avito/messenger/api/entity/BodyImagesResponse;", "getBodyImages", "(Ljava/util/Collection;)Lio/reactivex/Single;", "Lru/avito/messenger/api/entity/BlacklistUserRequest;", "users", "reasonId", "addToBlackList", "(Ljava/util/List;Ljava/lang/Long;)Lio/reactivex/Single;", ChannelContext.Item.USER_ID, "Lru/avito/messenger/api/entity/SuccessResponse;", "removeFromBlackList", "Lru/avito/messenger/api/entity/BlacklistReasons;", "getBlacklistReasons", "()Lio/reactivex/Single;", "messageId", "confirmChatAsSpam", "(JLjava/lang/String;Ljava/lang/Long;)Lio/reactivex/Single;", "confirmChatAsNonSpam", "Lru/avito/messenger/api/entity/GetLastActionTimesResponse;", "getUserLastActionTimes", "Lru/avito/messenger/api/entity/BlockedUsersResponse;", "getBlacklist", "(ILjava/lang/Integer;)Lio/reactivex/Single;", "sendPing", "messageIds", "markMessagesAsRead", "getReplySuggest", "options", "setOptions", "(Ljava/util/Map;)Lio/reactivex/Single;", "Lru/avito/messenger/api/entity/ChannelsCounters;", "getChatCounters", "folders", "Lru/avito/messenger/api/entity/FoldersCountersResponse;", "getFolderCounters", VKApiConst.Q, "getItemsForAttach", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getGeoCodedLocationForCoordinates", "(DDLjava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "centerPoint", "Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggests;", "getGeoSearchSuggests", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;)Lio/reactivex/Single;", "itemLocation", "getFavoritePlaces", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;Ljava/lang/Integer;)Lio/reactivex/Single;", "remoteId", "deleteMessage", "key", "locationId", "Lcom/avito/android/remote/model/messenger/ChatListBannersResponse;", "getBanners", "(Ljava/lang/String;I)Lio/reactivex/Single;", "addTags", "removeTags", "updateFolderTags", "(Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Single;", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerApi {
    @NotNull
    public static final String ADD_TAGS = "addTags";
    @NotNull
    public static final String ADD_TO_BLACKLIST = "avito.blacklistAdd";
    @NotNull
    public static final String ADD_TO_BLACKLIST_REASON_ID = "reasonId";
    @NotNull
    public static final String ADD_TO_BLACKLIST_USERS = "users";
    @NotNull
    public static final String CHANNEL_ID = "channelId";
    @NotNull
    public static final String CHANNEL_IDS = "channelIds";
    @NotNull
    public static final String CREATE_FILE = "messenger.createFile.v1";
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String GET_BANNERS = "messenger.getBanners.v1";
    @NotNull
    public static final String GET_BLACKLIST = "avito.getBlacklist";
    @NotNull
    public static final String GET_BLACKLIST_LIMIT = "limit";
    @NotNull
    public static final String GET_BLACKLIST_OFFSET = "offset";
    @NotNull
    public static final String GET_BLACKLIST_REASONS = "messenger.getBlacklistReasons";
    @NotNull
    public static final String GET_CHATS = "avito.getChats.v3";
    @NotNull
    public static final String GET_CHATS_FILTERS = "filters";
    @NotNull
    public static final String GET_CHATS_FILTERS_EXCLUDE_TAGS = "excludeTags";
    @NotNull
    public static final String GET_CHATS_FILTERS_TAGS = "tags";
    @NotNull
    public static final String GET_CHATS_LIMIT = "limit";
    @NotNull
    public static final String GET_CHATS_OFFSET = "offset";
    @NotNull
    public static final String GET_CHAT_BY_ID = "avito.getChatById.v2";
    @NotNull
    public static final String GET_FILE = "messenger.getFile.v1";
    @NotNull
    public static final String GET_ITEMS_FOR_ATTACH = "avito.getItemsForAttach.v2";
    @NotNull
    public static final String GET_REPLY_SUGGEST = "suggest.getReplySuggest";
    @NotNull
    public static final String GET_USERS = "messenger.getUsers.v1";
    @NotNull
    public static final String HISTORY = "messenger.history";
    @NotNull
    public static final String KEY = "key";
    @NotNull
    public static final String LOCATION_ID = "locationId";
    @NotNull
    public static final String REMOVE_TAGS = "removeTags";
    @NotNull
    public static final String SEND_FILE_MESSAGE = "messenger.sendFile.v1";
    @NotNull
    public static final String SEND_REACTION_MESSAGE = "messenger.sendReactionMessage.v1";
    @NotNull
    public static final String TEXT = "text";
    @NotNull
    public static final String UPDATE_FOLDER_TAGS = "messenger.updateFolderTags.v1";
    @NotNull
    public static final String USER_IDS = "userIds";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b$\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0016\u0010\u001f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u0004R\u0016\u0010\"\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0016\u0010#\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lru/avito/messenger/MessengerApi$Companion;", "", "", "GET_CHAT_BY_ID", "Ljava/lang/String;", "GET_ITEMS_FOR_ATTACH", "GET_CHATS", "HISTORY", "GET_USERS", "GET_BLACKLIST_REASONS", "ADD_TO_BLACKLIST", "CREATE_FILE", "KEY", "GET_BLACKLIST_LIMIT", "ADD_TO_BLACKLIST_REASON_ID", "SEND_REACTION_MESSAGE", "GET_REPLY_SUGGEST", "GET_CHATS_FILTERS_TAGS", "GET_BLACKLIST_OFFSET", "GET_CHATS_FILTERS_EXCLUDE_TAGS", "GET_BANNERS", "GET_FILE", "SEND_FILE_MESSAGE", "GET_CHATS_LIMIT", "GET_BLACKLIST", "REMOVE_TAGS", "USER_IDS", "CHANNEL_IDS", "ADD_TAGS", "UPDATE_FOLDER_TAGS", "TEXT", "GET_CHATS_FILTERS", "CHANNEL_ID", "LOCATION_ID", "ADD_TO_BLACKLIST_USERS", "GET_CHATS_OFFSET", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String ADD_TAGS = "addTags";
        @NotNull
        public static final String ADD_TO_BLACKLIST = "avito.blacklistAdd";
        @NotNull
        public static final String ADD_TO_BLACKLIST_REASON_ID = "reasonId";
        @NotNull
        public static final String ADD_TO_BLACKLIST_USERS = "users";
        @NotNull
        public static final String CHANNEL_ID = "channelId";
        @NotNull
        public static final String CHANNEL_IDS = "channelIds";
        @NotNull
        public static final String CREATE_FILE = "messenger.createFile.v1";
        @NotNull
        public static final String GET_BANNERS = "messenger.getBanners.v1";
        @NotNull
        public static final String GET_BLACKLIST = "avito.getBlacklist";
        @NotNull
        public static final String GET_BLACKLIST_LIMIT = "limit";
        @NotNull
        public static final String GET_BLACKLIST_OFFSET = "offset";
        @NotNull
        public static final String GET_BLACKLIST_REASONS = "messenger.getBlacklistReasons";
        @NotNull
        public static final String GET_CHATS = "avito.getChats.v3";
        @NotNull
        public static final String GET_CHATS_FILTERS = "filters";
        @NotNull
        public static final String GET_CHATS_FILTERS_EXCLUDE_TAGS = "excludeTags";
        @NotNull
        public static final String GET_CHATS_FILTERS_TAGS = "tags";
        @NotNull
        public static final String GET_CHATS_LIMIT = "limit";
        @NotNull
        public static final String GET_CHATS_OFFSET = "offset";
        @NotNull
        public static final String GET_CHAT_BY_ID = "avito.getChatById.v2";
        @NotNull
        public static final String GET_FILE = "messenger.getFile.v1";
        @NotNull
        public static final String GET_ITEMS_FOR_ATTACH = "avito.getItemsForAttach.v2";
        @NotNull
        public static final String GET_REPLY_SUGGEST = "suggest.getReplySuggest";
        @NotNull
        public static final String GET_USERS = "messenger.getUsers.v1";
        @NotNull
        public static final String HISTORY = "messenger.history";
        @NotNull
        public static final String KEY = "key";
        @NotNull
        public static final String LOCATION_ID = "locationId";
        @NotNull
        public static final String REMOVE_TAGS = "removeTags";
        @NotNull
        public static final String SEND_FILE_MESSAGE = "messenger.sendFile.v1";
        @NotNull
        public static final String SEND_REACTION_MESSAGE = "messenger.sendReactionMessage.v1";
        @NotNull
        public static final String TEXT = "text";
        @NotNull
        public static final String UPDATE_FOLDER_TAGS = "messenger.updateFolderTags.v1";
        @NotNull
        public static final String USER_IDS = "userIds";
        public static final /* synthetic */ Companion a = new Companion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single addToBlackList$default(MessengerApi messengerApi, List list, Long l, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    l = null;
                }
                return messengerApi.addToBlackList(list, l);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addToBlackList");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.MessengerApi */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Single getChats$default(MessengerApi messengerApi, int i, Integer num, Map map, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    map = r.emptyMap();
                }
                return messengerApi.getChats(i, num, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChats");
        }

        public static /* synthetic */ Single getGeoCodedLocationForCoordinates$default(MessengerApi messengerApi, double d, double d2, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = "house";
                }
                return messengerApi.getGeoCodedLocationForCoordinates(d, d2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGeoCodedLocationForCoordinates");
        }

        public static /* synthetic */ Single latestMessages$default(MessengerApi messengerApi, String str, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    num = null;
                }
                return messengerApi.latestMessages(str, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: latestMessages");
        }

        public static /* synthetic */ Single messagesAfter$default(MessengerApi messengerApi, String str, long j, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    num = null;
                }
                return messengerApi.messagesAfter(str, j, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messagesAfter");
        }

        public static /* synthetic */ Single messagesBefore$default(MessengerApi messengerApi, String str, Long l, Long l2, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    num = null;
                }
                return messengerApi.messagesBefore(str, l, l2, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messagesBefore");
        }
    }

    @JsonRpcMethod("avito.blacklistAdd")
    @NotNull
    Single<Unit> addToBlackList(@JsonRpcParam("users") @NotNull List<BlacklistUserRequest> list, @JsonRpcParam("reasonId") @Nullable Long l);

    @JsonRpcMethodCall
    @NotNull
    Single<RawJson> callMethod(@JsonRpcMethodName("methodName") @NotNull String str, @JsonRpcBody @NotNull RawJson rawJson);

    @JsonRpcMethod("messenger.clearMessageHistoryMulti")
    @NotNull
    Single<Boolean> clearHistory(@JsonRpcParam("channelIds") @NotNull List<String> list);

    @JsonRpcMethod("messenger.suspectCancel")
    @NotNull
    Single<Unit> confirmChatAsNonSpam(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("messageId") @NotNull String str2);

    @JsonRpcMethod("messenger.suspectConfirm")
    @NotNull
    Single<Unit> confirmChatAsSpam(@JsonRpcParam("userId") long j, @JsonRpcParam("messageId") @NotNull String str, @JsonRpcParam("itemId") @Nullable Long l);

    @JsonRpcMethod("messenger.createFile.v1")
    @NotNull
    Single<CreateFileResponse> createFile(@JsonRpcParam("channelId") @NotNull String str);

    @JsonRpcMethod("messenger.deleteMessage.v1")
    @NotNull
    Single<ChatMessage> deleteMessage(@JsonRpcParam("messageId") @NotNull String str);

    @JsonRpcMethod("messenger.getBanners.v1")
    @NotNull
    Single<ChatListBannersResponse> getBanners(@JsonRpcParam("key") @NotNull String str, @JsonRpcParam("locationId") int i);

    @JsonRpcMethod("avito.getBlacklist")
    @NotNull
    Single<BlockedUsersResponse> getBlacklist(@JsonRpcParam("offset") int i, @JsonRpcParam("limit") @Nullable Integer num);

    @JsonRpcMethod("messenger.getBlacklistReasons")
    @NotNull
    Single<BlacklistReasons> getBlacklistReasons();

    @JsonRpcMethod("avito.getBodyImages")
    @NotNull
    Single<BodyImagesResponse> getBodyImages(@JsonRpcParam("ids") @NotNull Collection<String> collection);

    @JsonRpcMethod("avito.getBodyItems.v2")
    @NotNull
    Single<List<BodyItem>> getBodyItems(@JsonRpcParam("ids") @NotNull List<String> list);

    @JsonRpcMethod("avito.getChatById.v2")
    @NotNull
    Single<Channel> getChatById(@JsonRpcParam("channelId") @NotNull String str);

    @JsonRpcMethod("messenger.getUnreadCount.v1")
    @NotNull
    Single<ChannelsCounters> getChatCounters();

    @JsonRpcMethod("avito.getChats.v3")
    @NotNull
    Single<ChannelsResponse> getChats(@JsonRpcParam("offset") int i, @JsonRpcParam("limit") @Nullable Integer num, @JsonRpcParam("filters") @NotNull Map<String, ? extends Object> map);

    @JsonRpcMethod("messenger.favoritePlaces.v1")
    @NotNull
    Single<GeoSearchSuggests> getFavoritePlaces(@JsonRpcParam("userId") @NotNull String str, @JsonRpcParam("channelId") @NotNull String str2, @JsonRpcParam("itemLocation") @Nullable GeoPoint geoPoint, @JsonRpcParam("limit") @Nullable Integer num);

    @JsonRpcMethod("messenger.getFile.v1")
    @NotNull
    Single<GetFileResponse> getFile(@JsonRpcParam("fileId") @NotNull String str);

    @JsonRpcMethod("messenger.getUnreadCount.v2")
    @NotNull
    Single<FoldersCountersResponse> getFolderCounters(@JsonRpcParam("folders") @NotNull Map<String, ? extends Collection<String>> map);

    @JsonRpcMethod("messenger.reverseGeo.v1")
    @NotNull
    Single<MessageBody.Location> getGeoCodedLocationForCoordinates(@JsonRpcParam("lat") double d, @JsonRpcParam("lon") double d2, @JsonRpcParam("kind") @NotNull String str);

    @JsonRpcMethodCall
    @NotNull
    Single<GeoMarker[]> getGeoMarkers(@JsonRpcMethodName("methodName") @NotNull String str, @JsonRpcBody @NotNull RawJson rawJson);

    @JsonRpcMethod("messenger.geoSearch.v1")
    @NotNull
    Single<GeoSearchSuggests> getGeoSearchSuggests(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("query") @NotNull String str2, @JsonRpcParam("centerPoint") @Nullable GeoPoint geoPoint);

    @JsonRpcMethod("avito.getItemsForAttach.v2")
    @NotNull
    Single<List<BodyItem>> getItemsForAttach(@JsonRpcParam("itemId") @Nullable Long l, @JsonRpcParam("limit") @Nullable Integer num, @JsonRpcParam("offset") @Nullable Integer num2, @JsonRpcParam("q") @NotNull String str);

    @JsonRpcMethodCall
    @NotNull
    Single<RecommendationsResponse> getRecommendations(@JsonRpcMethodName("methodName") @NotNull String str, @JsonRpcBody @NotNull RawJson rawJson);

    @JsonRpcMethod("suggest.getReplySuggest")
    @NotNull
    Single<Map<String, List<String>>> getReplySuggest(@JsonRpcParam("channelIds") @NotNull List<String> list);

    @JsonRpcMethod("messenger.getLastActionTimes")
    @NotNull
    Single<GetLastActionTimesResponse> getUserLastActionTimes(@JsonRpcParam("userIds") @NotNull List<Long> list);

    @JsonRpcMethod("messenger.getUsers.v1")
    @NotNull
    Single<GetUsersResponse> getUsers(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("userIds") @NotNull List<Long> list);

    @JsonRpcMethod("messenger.history")
    @NotNull
    Single<ChatMessagesResponse> latestMessages(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("limit") @Nullable Integer num);

    @JsonRpcMethod("messenger.readChat")
    @NotNull
    Single<Boolean> markChannelAsRead(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("lastMessageTime") long j);

    @JsonRpcMethod("messenger.readMessages")
    @NotNull
    Single<Boolean> markMessagesAsRead(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("ids") @NotNull List<String> list);

    @JsonRpcMethod("messenger.history")
    @NotNull
    Single<ChatMessagesResponse> messagesAfter(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("after") long j, @JsonRpcParam("limit") @Nullable Integer num);

    @JsonRpcMethod("messenger.history")
    @NotNull
    Single<ChatMessagesResponse> messagesBefore(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("before") @Nullable Long l, @JsonRpcParam("after") @Nullable Long l2, @JsonRpcParam("limit") @Nullable Integer num);

    @JsonRpcMethod("avito.blacklistRemove")
    @NotNull
    Single<SuccessResponse> removeFromBlackList(@JsonRpcParam("userId") @NotNull String str);

    @JsonRpcMethod("messenger.search.v1")
    @NotNull
    Single<ChannelsSearchResponse> searchChats(@JsonRpcParam("offset") int i, @JsonRpcParam("limit") @Nullable Integer num, @JsonRpcParam("query") @NotNull String str);

    @JsonRpcMethod("avito.sendMissedCallMessage")
    @NotNull
    Single<ChatMessage> sendCallMessage(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("targetUserId") @NotNull String str2);

    @JsonRpcMethod("messenger.sendFile.v1")
    @NotNull
    Single<ChatMessage> sendFileMessage(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("fileId") @NotNull String str2, @JsonRpcParam("randomId") @Nullable String str3);

    @JsonRpcMethod("avito.sendImageMessage")
    @NotNull
    Single<ChatMessage> sendImageMessage(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("randomId") @Nullable String str2, @JsonRpcParam("imageId") @NotNull String str3);

    @JsonRpcMethod("avito.sendItemMessage")
    @NotNull
    Single<ChatMessage> sendItemMessage(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("randomId") @Nullable String str2, @JsonRpcParam("itemId") @NotNull String str3);

    @JsonRpcMethod("messenger.sendLinkMessage")
    @NotNull
    Single<ChatMessage> sendLinkMessage(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("url") @NotNull String str2, @JsonRpcParam("randomId") @Nullable String str3);

    @JsonRpcMethod("messenger.sendLocationMessage.v1")
    @NotNull
    Single<ChatMessage> sendLocationMessage(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("lat") double d, @JsonRpcParam("lon") double d2, @JsonRpcParam("title") @NotNull String str2, @JsonRpcParam("kind") @Nullable String str3, @JsonRpcParam("randomId") @Nullable String str4);

    @JsonRpcMethod("ping")
    @NotNull
    Single<Unit> sendPing();

    @JsonRpcMethod("messenger.sendReactionMessage.v1")
    @NotNull
    Single<ChatMessage> sendReactionMessage(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("randomId") @Nullable String str2, @JsonRpcParam("text") @NotNull String str3);

    @JsonRpcMethod("avito.sendTextMessage")
    @NotNull
    @NetworkRequestEventId(eventId = 3911)
    Single<ChatMessage> sendTextMessage(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("randomId") @Nullable String str2, @JsonRpcParam("text") @NotNull String str3, @JsonRpcParam("templates") @Nullable List<String> list);

    @JsonRpcMethod("messenger.sendTyping")
    @NotNull
    Single<Unit> sendTyping(@JsonRpcParam("channelId") @NotNull String str, @JsonRpcParam("userIds") @NotNull List<Long> list);

    @JsonRpcMethod("messenger.setOptions")
    @NotNull
    Single<Unit> setOptions(@JsonRpcParamsMap @NotNull Map<String, ? extends Object> map);

    @JsonRpcMethod("messenger.updateFolderTags.v1")
    @NotNull
    Single<Unit> updateFolderTags(@JsonRpcParam("channelIds") @NotNull Collection<String> collection, @JsonRpcParam("addTags") @NotNull Collection<String> collection2, @JsonRpcParam("removeTags") @NotNull Collection<String> collection3);
}
