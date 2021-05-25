package com.avito.android.stub;

import a2.b.a.a.a;
import com.avito.android.remote.messenger.PhoneNumberResponse;
import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.messenger.ChatListBannersResponse;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context_actions.RecommendationsResponse;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggests;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.google.gson.Gson;
import com.vk.sdk.api.VKApiConst;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.MessengerImageUploadApi;
import ru.avito.messenger.api.AvitoMessengerApi;
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
import ru.avito.messenger.config.MessengerConfigProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/stub/StubMessengerModule;", "", "Lru/avito/messenger/Messenger;", "Lru/avito/messenger/api/AvitoMessengerApi;", "provideMessenger", "()Lru/avito/messenger/Messenger;", "provideAvitoMessengerApi", "()Lru/avito/messenger/api/AvitoMessengerApi;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class StubMessengerModule {
    @NotNull
    public static final StubMessengerModule INSTANCE = new StubMessengerModule();

    @Provides
    @Reusable
    @NotNull
    public final AvitoMessengerApi provideAvitoMessengerApi() {
        return new AvitoMessengerApi() { // from class: com.avito.android.stub.StubMessengerModule$provideAvitoMessengerApi$1
            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Unit> addToBlackList(@NotNull List<BlacklistUserRequest> list, @Nullable Long l) {
                Intrinsics.checkNotNullParameter(list, "users");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<RawJson> callMethod(@NotNull String str, @NotNull RawJson rawJson) {
                Intrinsics.checkNotNullParameter(str, "methodName");
                Intrinsics.checkNotNullParameter(rawJson, "params");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Boolean> clearHistory(@NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(list, "channelIds");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Unit> confirmChatAsNonSpam(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str2, "messageId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Unit> confirmChatAsSpam(long j, @NotNull String str, @Nullable Long l) {
                Intrinsics.checkNotNullParameter(str, "messageId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.api.AvitoMessengerApi
            @NotNull
            public Single<Channel> createChat(@NotNull String str, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(str, "itemId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.api.AvitoMessengerApi
            @NotNull
            public Single<Channel> createChatWithAvito(@Nullable String str) {
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<CreateFileResponse> createFile(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessage> deleteMessage(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "remoteId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatListBannersResponse> getBanners(@NotNull String str, int i) {
                Intrinsics.checkNotNullParameter(str, "key");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<BlockedUsersResponse> getBlacklist(int i, @Nullable Integer num) {
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<BlacklistReasons> getBlacklistReasons() {
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<BodyImagesResponse> getBodyImages(@NotNull Collection<String> collection) {
                Intrinsics.checkNotNullParameter(collection, "imageIds");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<List<BodyItem>> getBodyItems(@NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(list, "itemIds");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Channel> getChatById(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChannelsCounters> getChatCounters() {
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChannelsResponse> getChats(int i, @Nullable Integer num, @NotNull Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(map, "filters");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<GeoSearchSuggests> getFavoritePlaces(@NotNull String str, @NotNull String str2, @Nullable GeoPoint geoPoint, @Nullable Integer num) {
                Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
                Intrinsics.checkNotNullParameter(str2, "channelId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<GetFileResponse> getFile(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, MessageBody.File.FILE_ID);
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "not implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<FoldersCountersResponse> getFolderCounters(@NotNull Map<String, ? extends Collection<String>> map) {
                Intrinsics.checkNotNullParameter(map, "folders");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<MessageBody.Location> getGeoCodedLocationForCoordinates(double d, double d2, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, MessageBody.Location.KIND);
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<GeoMarker[]> getGeoMarkers(@NotNull String str, @NotNull RawJson rawJson) {
                Intrinsics.checkNotNullParameter(str, "methodName");
                Intrinsics.checkNotNullParameter(rawJson, "params");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<GeoSearchSuggests> getGeoSearchSuggests(@NotNull String str, @NotNull String str2, @Nullable GeoPoint geoPoint) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str2, "query");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<List<BodyItem>> getItemsForAttach(@Nullable Long l, @Nullable Integer num, @Nullable Integer num2, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, VKApiConst.Q);
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.api.AvitoMessengerApi
            @NotNull
            public Single<PhoneNumberResponse> getPhoneByChannelId(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<RecommendationsResponse> getRecommendations(@NotNull String str, @NotNull RawJson rawJson) {
                Intrinsics.checkNotNullParameter(str, "methodName");
                Intrinsics.checkNotNullParameter(rawJson, "params");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Map<String, List<String>>> getReplySuggest(@NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(list, "channelIds");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.api.AvitoMessengerApi
            @NotNull
            public Single<Map<String, String>> getUnknownMessageBodies(@NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(list, "types");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<GetLastActionTimesResponse> getUserLastActionTimes(@NotNull List<Long> list) {
                Intrinsics.checkNotNullParameter(list, "userIds");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<GetUsersResponse> getUsers(@NotNull String str, @NotNull List<Long> list) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(list, "userIds");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessagesResponse> latestMessages(@NotNull String str, @Nullable Integer num) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Boolean> markChannelAsRead(@NotNull String str, long j) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Boolean> markMessagesAsRead(@NotNull String str, @NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(list, "messageIds");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessagesResponse> messagesAfter(@NotNull String str, long j, @Nullable Integer num) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessagesResponse> messagesBefore(@NotNull String str, @Nullable Long l, @Nullable Long l2, @Nullable Integer num) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<SuccessResponse> removeFromBlackList(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChannelsSearchResponse> searchChats(int i, @Nullable Integer num, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "query");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessage> sendCallMessage(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str2, "targetUserId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessage> sendFileMessage(@NotNull String str, @NotNull String str2, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str2, MessageBody.File.FILE_ID);
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "not implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessage> sendImageMessage(@NotNull String str, @Nullable String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str3, "imageId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessage> sendItemMessage(@NotNull String str, @Nullable String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str3, "itemId");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessage> sendLinkMessage(@NotNull String str, @NotNull String str2, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str2, "url");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessage> sendLocationMessage(@NotNull String str, double d, double d2, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str2, "title");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Unit> sendPing() {
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessage> sendReactionMessage(@NotNull String str, @Nullable String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str3, "text");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<ChatMessage> sendTextMessage(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable List<String> list) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(str3, "text");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Unit> sendTyping(@NotNull String str, @NotNull List<Long> list) {
                Intrinsics.checkNotNullParameter(str, "channelId");
                Intrinsics.checkNotNullParameter(list, "userIds");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Unit> setOptions(@NotNull Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(map, "options");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }

            @Override // ru.avito.messenger.MessengerApi
            @NotNull
            public Single<Unit> updateFolderTags(@NotNull Collection<String> collection, @NotNull Collection<String> collection2, @NotNull Collection<String> collection3) {
                Intrinsics.checkNotNullParameter(collection, "channelIds");
                Intrinsics.checkNotNullParameter(collection2, "addTags");
                Intrinsics.checkNotNullParameter(collection3, "removeTags");
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "Not yet implemented"));
            }
        };
    }

    @Provides
    @Reusable
    @NotNull
    public final Messenger<AvitoMessengerApi> provideMessenger() {
        return new Messenger<AvitoMessengerApi>() { // from class: com.avito.android.stub.StubMessengerModule$provideMessenger$1
            @NotNull
            public final MessengerImageUploadApi a = ;

            @Override // ru.avito.messenger.Messenger
            @NotNull
            public MessengerClient<AvitoMessengerApi> getClient() {
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "not implemented"));
            }

            @Override // ru.avito.messenger.Messenger
            @NotNull
            public MessengerConfigProvider getConfigProvider() {
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "not implemented"));
            }

            @Override // ru.avito.messenger.Messenger
            @NotNull
            public Gson getGson() {
                throw new NotImplementedError(a.c3("An operation is not implemented: ", "not implemented"));
            }

            @Override // ru.avito.messenger.Messenger
            @NotNull
            public MessengerImageUploadApi getImageUploadApi() {
                return this.a;
            }
        };
    }
}
