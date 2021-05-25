package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.ChannelDisplayInfo;
import com.avito.android.remote.model.messenger.InputState;
import com.avito.android.remote.model.messenger.ReadOnlyState;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.messenger.deal_action.DealAction;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelEntity;
import ru.avito.android.persistence.messenger.ChannelTag;
import ru.avito.android.persistence.messenger.MessageEntity;
import ru.avito.android.persistence.messenger.UserEntity;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
import ru.avito.messenger.api.entity.context.ChannelDealAction;
import t6.n.e;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\b)\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0016¢\u0006\u0004\b\f\u0010\rJ=\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverterImpl;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverter;", "", ChannelContext.Item.USER_ID, "Lcom/avito/android/remote/model/messenger/Channel;", "channel", "Lcom/avito/android/messenger/channels/mvi/data/ChannelDbEntities;", "toChannelDbEntities", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/Channel;)Lcom/avito/android/messenger/channels/mvi/data/ChannelDbEntities;", "", ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS, "Lcom/avito/android/messenger/channels/mvi/data/ChannelsDbEntities;", "toChannelsDbEntities", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/messenger/channels/mvi/data/ChannelsDbEntities;", "Lru/avito/android/persistence/messenger/ChannelEntity;", "channelEntity", "Lru/avito/android/persistence/messenger/UserEntity;", "users", "", "Lru/avito/android/persistence/messenger/ChannelTag;", "channelTags", "Lru/avito/android/persistence/messenger/MessageEntity;", "lastMessage", "toChannel", "(Lru/avito/android/persistence/messenger/ChannelEntity;Ljava/util/List;Ljava/util/Collection;Lru/avito/android/persistence/messenger/MessageEntity;)Lcom/avito/android/remote/model/messenger/Channel;", "Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;", "userEntityConverter", "Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverter;", "messageEntityConverter", "Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "c", "Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "channelContextSerializer", "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "d", "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "channelPropertySerializer", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageEntityConverter;Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelEntityConverterImpl implements ChannelEntityConverter {
    public final MessageEntityConverter a;
    public final UserEntityConverter b;
    public final ChannelContextSerializer c;
    public final ChannelPropertySerializer d;

    @Inject
    public ChannelEntityConverterImpl(@NotNull MessageEntityConverter messageEntityConverter, @NotNull UserEntityConverter userEntityConverter, @NotNull ChannelContextSerializer channelContextSerializer, @NotNull ChannelPropertySerializer channelPropertySerializer) {
        Intrinsics.checkNotNullParameter(messageEntityConverter, "messageEntityConverter");
        Intrinsics.checkNotNullParameter(userEntityConverter, "userEntityConverter");
        Intrinsics.checkNotNullParameter(channelContextSerializer, "channelContextSerializer");
        Intrinsics.checkNotNullParameter(channelPropertySerializer, "channelPropertySerializer");
        this.a = messageEntityConverter;
        this.b = userEntityConverter;
        this.c = channelContextSerializer;
        this.d = channelPropertySerializer;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelEntityConverter
    @NotNull
    public Channel toChannel(@NotNull ChannelEntity channelEntity, @NotNull List<UserEntity> list, @NotNull Collection<ChannelTag> collection, @Nullable MessageEntity messageEntity) {
        Intrinsics.checkNotNullParameter(channelEntity, "channelEntity");
        Intrinsics.checkNotNullParameter(list, "users");
        Intrinsics.checkNotNullParameter(collection, "channelTags");
        TreeSet sortedSetOf = x.sortedSetOf(new String[0]);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            sortedSetOf.add(it.next().getTag());
        }
        String channelId = channelEntity.getChannelId();
        String type = channelEntity.getType();
        LocalMessage localMessage = messageEntity != null ? this.a.toLocalMessage(messageEntity) : null;
        UserEntityConverter userEntityConverter = this.b;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(userEntityConverter.toUser(it2.next()));
        }
        long created = channelEntity.getCreated();
        long updated = channelEntity.getUpdated();
        ChannelContext deserialize = this.c.deserialize(channelEntity.getContextType(), channelEntity.getJsonContext());
        String jsonReadOnlyState = channelEntity.getJsonReadOnlyState();
        ReadOnlyState readOnlyState = jsonReadOnlyState != null ? (ReadOnlyState) this.d.deserialize(ReadOnlyState.class, jsonReadOnlyState) : null;
        boolean isDeleted = channelEntity.isDeleted();
        boolean isRead = channelEntity.isRead();
        boolean isSpam = channelEntity.isSpam();
        boolean isAnswered = channelEntity.isAnswered();
        String jsonContextActions = channelEntity.getJsonContextActions();
        PlatformActions platformActions = (PlatformActions) (jsonContextActions != null ? (ChannelContextActions) this.d.deserialize(ChannelContextActions.class, jsonContextActions) : null);
        String jsonDealAction = channelEntity.getJsonDealAction();
        DealAction dealAction = (DealAction) (jsonDealAction != null ? (ChannelDealAction) this.d.deserialize(ChannelDealAction.class, jsonDealAction) : null);
        String flow = channelEntity.getFlow();
        String suspectMessageId = channelEntity.getSuspectMessageId();
        ChannelDisplayInfo channelDisplayInfo = (ChannelDisplayInfo) this.d.deserialize(ChannelDisplayInfo.class, channelEntity.getJsonDisplayInfo());
        String jsonInputState = channelEntity.getJsonInputState();
        return new Channel(channelId, type, localMessage, arrayList, created, updated, deserialize, readOnlyState, isDeleted, isRead, isSpam, isAnswered, sortedSetOf, platformActions, dealAction, flow, suspectMessageId, channelDisplayInfo, jsonInputState != null ? (InputState) this.d.deserialize(InputState.class, jsonInputState) : null);
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelEntityConverter
    @NotNull
    public ChannelDbEntities toChannelDbEntities(@NotNull String str, @NotNull Channel channel) {
        String str2;
        MessageEntity messageEntity;
        T t;
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(channel, "channel");
        List<User> users = channel.getUsers();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(users, 10));
        Iterator<T> it = users.iterator();
        while (it.hasNext()) {
            arrayList.add(this.b.toUserEntity(str, channel.getChannelId(), it.next()));
        }
        LocalMessage lastMessage = channel.getLastMessage();
        MessageEntity messageEntity2 = lastMessage != null ? this.a.toMessageEntity(lastMessage) : null;
        String channelId = channel.getChannelId();
        String type = channel.getType();
        long created = channel.getCreated();
        long updated = channel.getUpdated();
        String serializeType = this.c.serializeType(channel.getContext());
        String serialize = this.c.serialize(channel.getContext());
        ReadOnlyState readOnlyState = channel.getReadOnlyState();
        String serialize2 = readOnlyState != null ? this.d.serialize(ReadOnlyState.class, readOnlyState) : null;
        boolean isDeleted = channel.isDeleted();
        boolean isRead = channel.isRead();
        boolean isSpam = channel.isSpam();
        boolean isAnswered = channel.isAnswered();
        PlatformActions contextActions = channel.getContextActions();
        String serialize3 = contextActions != null ? this.d.serialize(ChannelContextActions.class, contextActions) : null;
        DealAction dealAction = channel.getDealAction();
        if (dealAction != null) {
            messageEntity = messageEntity2;
            str2 = this.d.serialize(ChannelDealAction.class, dealAction);
        } else {
            messageEntity = messageEntity2;
            str2 = null;
        }
        String flow = channel.getFlow();
        String suspectMessageId = channel.getSuspectMessageId();
        ChannelContext context = channel.getContext();
        if (!(context instanceof ChannelContext.Item)) {
            context = null;
        }
        ChannelContext.Item item = (ChannelContext.Item) context;
        String id = item != null ? item.getId() : null;
        Iterator<T> it2 = channel.getUsers().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (!Intrinsics.areEqual(t.getId(), str)) {
                break;
            }
        }
        T t2 = t;
        String id2 = t2 != null ? t2.getId() : null;
        String serialize4 = this.d.serialize(ChannelDisplayInfo.class, channel.getDisplayInfo());
        InputState inputState = channel.getInputState();
        ChannelEntity channelEntity = new ChannelEntity(str, channelId, type, created, updated, serializeType, serialize, serialize2, isDeleted, isRead, isSpam, isAnswered, serialize3, str2, flow, suspectMessageId, id, id2, serialize4, inputState != null ? this.d.serialize(InputState.class, inputState) : null);
        SortedSet<String> tags = channel.getTags();
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(tags, 10));
        for (T t3 : tags) {
            String channelId2 = channel.getChannelId();
            Intrinsics.checkNotNullExpressionValue(t3, "tag");
            arrayList2.add(new ChannelTag(str, channelId2, t3));
        }
        return new ChannelDbEntities(channelEntity, arrayList, arrayList2, messageEntity);
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelEntityConverter
    @NotNull
    public ChannelsDbEntities toChannelsDbEntities(@NotNull String str, @NotNull List<Channel> list) {
        ArrayList arrayList;
        String str2;
        String str3;
        LinkedHashSet linkedHashSet;
        T t;
        ArrayList arrayList2;
        MessageEntity messageEntity;
        ChannelEntityConverterImpl channelEntityConverterImpl = this;
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS);
        ArrayList arrayList3 = new ArrayList();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        ArrayList arrayList4 = new ArrayList();
        for (T t2 : list) {
            String channelId = t2.getChannelId();
            String type = t2.getType();
            long created = t2.getCreated();
            long updated = t2.getUpdated();
            String serializeType = this.c.serializeType(t2.getContext());
            String serialize = this.c.serialize(t2.getContext());
            ReadOnlyState readOnlyState = t2.getReadOnlyState();
            if (readOnlyState != null) {
                arrayList = arrayList4;
                str2 = this.d.serialize(ReadOnlyState.class, readOnlyState);
            } else {
                arrayList = arrayList4;
                str2 = null;
            }
            boolean isDeleted = t2.isDeleted();
            boolean isRead = t2.isRead();
            boolean isSpam = t2.isSpam();
            boolean isAnswered = t2.isAnswered();
            PlatformActions contextActions = t2.getContextActions();
            if (contextActions != null) {
                linkedHashSet = linkedHashSet3;
                str3 = this.d.serialize(ChannelContextActions.class, contextActions);
            } else {
                linkedHashSet = linkedHashSet3;
                str3 = null;
            }
            DealAction dealAction = t2.getDealAction();
            String serialize2 = dealAction != null ? this.d.serialize(ChannelDealAction.class, dealAction) : null;
            String flow = t2.getFlow();
            String suspectMessageId = t2.getSuspectMessageId();
            ChannelContext context = t2.getContext();
            if (!(context instanceof ChannelContext.Item)) {
                context = null;
            }
            ChannelContext.Item item = (ChannelContext.Item) context;
            String id = item != null ? item.getId() : null;
            Iterator<T> it = t2.getUsers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (!Intrinsics.areEqual(t.getId(), str4)) {
                    break;
                }
            }
            T t3 = t;
            String id2 = t3 != null ? t3.getId() : null;
            String serialize3 = this.d.serialize(ChannelDisplayInfo.class, t2.getDisplayInfo());
            InputState inputState = t2.getInputState();
            arrayList3.add(new ChannelEntity(str, channelId, type, created, updated, serializeType, serialize, str2, isDeleted, isRead, isSpam, isAnswered, str3, serialize2, flow, suspectMessageId, id, id2, serialize3, inputState != null ? this.d.serialize(InputState.class, inputState) : null));
            Iterator<T> it2 = t2.getUsers().iterator();
            while (it2.hasNext()) {
                linkedHashSet2.add(this.b.toUserEntity(str, t2.getChannelId(), it2.next()));
            }
            for (T t4 : t2.getTags()) {
                String channelId2 = t2.getChannelId();
                Intrinsics.checkNotNullExpressionValue(t4, "tag");
                linkedHashSet.add(new ChannelTag(str, channelId2, t4));
            }
            LocalMessage lastMessage = t2.getLastMessage();
            if (lastMessage == null || (messageEntity = this.a.toMessageEntity(lastMessage)) == null) {
                arrayList2 = arrayList;
            } else {
                arrayList2 = arrayList;
                arrayList2.add(messageEntity);
            }
            arrayList3 = arrayList3;
            linkedHashSet3 = linkedHashSet;
            channelEntityConverterImpl = this;
            linkedHashSet2 = linkedHashSet2;
            arrayList4 = arrayList2;
            str4 = str;
        }
        return new ChannelsDbEntities(arrayList3, linkedHashSet2, linkedHashSet3, arrayList4);
    }
}
