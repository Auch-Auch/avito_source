package ru.avito.messenger.api;

import com.avito.android.jsonrpc.annotations.JsonRpcMethod;
import com.avito.android.jsonrpc.annotations.JsonRpcParam;
import com.avito.android.remote.messenger.PhoneNumberResponse;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.api.entity.Channel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r0\u00052\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u0002H'¢\u0006\u0004\b\u0012\u0010\n¨\u0006\u0014"}, d2 = {"Lru/avito/messenger/api/AvitoMessengerApi;", "Lru/avito/messenger/MessengerApi;", "", "itemId", "source", "Lio/reactivex/Single;", "Lru/avito/messenger/api/entity/Channel;", "createChat", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "createChatWithAvito", "(Ljava/lang/String;)Lio/reactivex/Single;", "", "types", "", "getUnknownMessageBodies", "(Ljava/util/List;)Lio/reactivex/Single;", "channelId", "Lcom/avito/android/remote/messenger/PhoneNumberResponse;", "getPhoneByChannelId", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface AvitoMessengerApi extends MessengerApi {
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String GET_PHONE_BY_CHANNEL_ID = "messenger.getPhoneByChannelId.v1";
    @NotNull
    public static final String GET_PHONE_BY_CHANNEL_ID_CHANNEL_ID = "channelId";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lru/avito/messenger/api/AvitoMessengerApi$Companion;", "", "", "GET_PHONE_BY_CHANNEL_ID", "Ljava/lang/String;", "GET_PHONE_BY_CHANNEL_ID_CHANNEL_ID", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String GET_PHONE_BY_CHANNEL_ID = "messenger.getPhoneByChannelId.v1";
        @NotNull
        public static final String GET_PHONE_BY_CHANNEL_ID_CHANNEL_ID = "channelId";
        public static final /* synthetic */ Companion a = new Companion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single createChat$default(AvitoMessengerApi avitoMessengerApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return avitoMessengerApi.createChat(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createChat");
        }

        public static /* synthetic */ Single createChatWithAvito$default(AvitoMessengerApi avitoMessengerApi, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return avitoMessengerApi.createChatWithAvito(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createChatWithAvito");
        }
    }

    @JsonRpcMethod("avito.chatCreateByItemId")
    @NotNull
    Single<Channel> createChat(@JsonRpcParam("itemId") @NotNull String str, @JsonRpcParam("source") @Nullable String str2);

    @JsonRpcMethod("messenger.chatCreateByAvito")
    @NotNull
    Single<Channel> createChatWithAvito(@JsonRpcParam("source") @Nullable String str);

    @JsonRpcMethod("messenger.getPhoneByChannelId.v1")
    @NotNull
    Single<PhoneNumberResponse> getPhoneByChannelId(@JsonRpcParam("channelId") @NotNull String str);

    @JsonRpcMethod("avito.getMessageBodyUnknown")
    @NotNull
    Single<Map<String, String>> getUnknownMessageBodies(@JsonRpcParam("messageTypes") @NotNull List<String> list);
}
