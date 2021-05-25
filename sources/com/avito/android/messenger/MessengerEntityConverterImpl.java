package com.avito.android.messenger;

import android.net.Uri;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SimpleAction;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.ChannelDisplayInfo;
import com.avito.android.remote.model.messenger.ChatAvatar;
import com.avito.android.remote.model.messenger.PublicProfile;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.messenger.deal_action.DealAction;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Collections;
import com.avito.android.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.Avatar;
import ru.avito.messenger.api.entity.ChannelInfo;
import ru.avito.messenger.api.entity.ChannelUser;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.Images;
import ru.avito.messenger.api.entity.InputState;
import ru.avito.messenger.api.entity.ReadOnlyState;
import ru.avito.messenger.api.entity.body.item.BodyItem;
import ru.avito.messenger.api.entity.body.item.Item;
import ru.avito.messenger.api.entity.body.item.Unknown;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
import ru.avito.messenger.api.entity.context.ChannelDealAction;
import t6.n.e;
import t6.n.j;
import t6.n.q;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u00100\u001a\u00020.¢\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u0013\u0010&\u001a\u00020%*\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0013\u0010)\u001a\u00020(*\u00020\u001bH\u0002¢\u0006\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010/¨\u00063"}, d2 = {"Lcom/avito/android/messenger/MessengerEntityConverterImpl;", "Lcom/avito/android/messenger/MessengerEntityConverter;", "Lru/avito/messenger/api/entity/ChatMessage;", "message", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "convertMessage", "(Lru/avito/messenger/api/entity/ChatMessage;)Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/messenger/api/entity/Channel;", "channel", "Lcom/avito/android/remote/model/messenger/Channel;", "convertChannel", "(Lru/avito/messenger/api/entity/Channel;)Lcom/avito/android/remote/model/messenger/Channel;", "Lru/avito/messenger/api/entity/ReadOnlyState;", "readOnlyState", "Lcom/avito/android/remote/model/messenger/ReadOnlyState;", "convertChannelReadOnlyState", "(Lru/avito/messenger/api/entity/ReadOnlyState;)Lcom/avito/android/remote/model/messenger/ReadOnlyState;", "Lru/avito/messenger/api/entity/InputState;", "inputState", "Lcom/avito/android/remote/model/messenger/InputState;", "convertChannelInputState", "(Lru/avito/messenger/api/entity/InputState;)Lcom/avito/android/remote/model/messenger/InputState;", "Lru/avito/messenger/api/entity/body/item/BodyItem;", "item", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "convertBody", "(Lru/avito/messenger/api/entity/body/item/BodyItem;)Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/Image;", "image", "convertImageBody", "(Lru/avito/messenger/api/entity/Image;)Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/ChannelUser;", "user", "Lcom/avito/android/remote/model/User;", "convertUser", "(Lru/avito/messenger/api/entity/ChannelUser;)Lcom/avito/android/remote/model/User;", "Lcom/avito/android/remote/model/SimpleAction;", "Lcom/avito/android/remote/model/Action;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/SimpleAction;)Lcom/avito/android/remote/model/Action;", "Lcom/avito/android/remote/model/Image;", AuthSource.BOOKING_ORDER, "(Lru/avito/messenger/api/entity/Image;)Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/messenger/TextToChunkConverter;", "Lcom/avito/android/messenger/TextToChunkConverter;", "textToChunkConverter", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "<init>", "(Lcom/avito/android/messenger/TextToChunkConverter;Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerEntityConverterImpl implements MessengerEntityConverter {
    public final TextToChunkConverter a;
    public final DeepLinkFactory b;

    @Inject
    public MessengerEntityConverterImpl(@NotNull TextToChunkConverter textToChunkConverter, @NotNull DeepLinkFactory deepLinkFactory) {
        Intrinsics.checkNotNullParameter(textToChunkConverter, "textToChunkConverter");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        this.a = textToChunkConverter;
        this.b = deepLinkFactory;
    }

    public final Action a(SimpleAction simpleAction) {
        return new Action(simpleAction.getTitle(), this.b.createFromUri(simpleAction.getUri()), null, null, simpleAction.getUri().toString(), null, 44, null);
    }

    public final Image b(ru.avito.messenger.api.entity.Image image) {
        Map<String, Uri> variants = image.getVariants();
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(variants.size()));
        for (T t : variants.entrySet()) {
            linkedHashMap.put(StringUtils.parseSize((String) t.getKey()), t.getValue());
        }
        return new Image(Collections.filterKeysNotNull(linkedHashMap));
    }

    @Override // com.avito.android.messenger.MessengerEntityConverter
    @NotNull
    public MessageBody convertBody(@NotNull BodyItem bodyItem) {
        ru.avito.messenger.api.entity.Image image;
        Intrinsics.checkNotNullParameter(bodyItem, "item");
        Image image2 = null;
        if (bodyItem instanceof Item) {
            Item item = (Item) bodyItem;
            String id = item.getId();
            String userId = item.getUserId();
            String title = item.getTitle();
            String formattedPrice = item.getFormattedPrice();
            String location = item.getLocation();
            Images images = item.getImages();
            if (!(images == null || (image = images.getImage()) == null)) {
                image2 = b(image);
            }
            return new MessageBody.Item(id, userId, title, image2, formattedPrice, location);
        } else if (bodyItem instanceof Unknown) {
            return new MessageBody.Unknown(((Unknown) bodyItem).getType(), null, 2, null);
        } else {
            return new MessageBody.Unknown("unknown", null, 2, null);
        }
    }

    @Override // com.avito.android.messenger.MessengerEntityConverter
    @NotNull
    public Channel convertChannel(@NotNull ru.avito.messenger.api.entity.Channel channel) {
        ChannelContext.Unknown unknown;
        SortedSet sortedSet;
        ChannelContext.Unknown unknown2;
        Intrinsics.checkNotNullParameter(channel, "channel");
        String channelId = channel.getChannelId();
        String type = channel.getType();
        ChatMessage lastMessage = channel.getLastMessage();
        LocalMessage convertMessage = lastMessage != null ? convertMessage(lastMessage) : null;
        List<ChannelUser> users = channel.getUsers();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(users, 10));
        Iterator<T> it = users.iterator();
        while (it.hasNext()) {
            arrayList.add(convertUser(it.next()));
        }
        Boolean isDeleted = channel.isDeleted();
        boolean booleanValue = isDeleted != null ? isDeleted.booleanValue() : false;
        Boolean isRead = channel.isRead();
        boolean booleanValue2 = isRead != null ? isRead.booleanValue() : false;
        Boolean isSpam = channel.isSpam();
        boolean booleanValue3 = isSpam != null ? isSpam.booleanValue() : false;
        long created = channel.getCreated();
        long updated = channel.getUpdated();
        ReadOnlyState readOnlyState = channel.getReadOnlyState();
        com.avito.android.remote.model.messenger.ReadOnlyState convertChannelReadOnlyState = readOnlyState != null ? convertChannelReadOnlyState(readOnlyState) : null;
        ru.avito.messenger.api.entity.context.ChannelContext context = channel.getContext();
        if (context instanceof ChannelContext) {
            unknown = (ChannelContext) context;
        } else {
            if (context instanceof ru.avito.messenger.api.entity.context.Unknown) {
                unknown2 = new ChannelContext.Unknown(((ru.avito.messenger.api.entity.context.Unknown) context).getType());
            } else {
                unknown2 = new ChannelContext.Unknown("unknown");
            }
            unknown = unknown2;
        }
        Boolean isAnswered = channel.isAnswered();
        boolean booleanValue4 = isAnswered != null ? isAnswered.booleanValue() : true;
        List<String> tags = channel.getTags();
        if (tags == null || (sortedSet = j.toSortedSet(tags)) == null) {
            sortedSet = x.sortedSetOf(new String[0]);
        }
        ChannelContextActions contextActions = channel.getContextActions();
        if (!(contextActions instanceof PlatformActions)) {
            contextActions = null;
        }
        PlatformActions platformActions = (PlatformActions) contextActions;
        ChannelDealAction dealAction = channel.getDealAction();
        if (!(dealAction instanceof DealAction)) {
            dealAction = null;
        }
        DealAction dealAction2 = (DealAction) dealAction;
        String flow = channel.getFlow();
        String suspectMessageId = channel.getSuspectMessageId();
        ChannelInfo info = channel.getInfo();
        String name = info.getName();
        ru.avito.messenger.api.entity.Image avatar = info.getAvatar();
        Image b2 = avatar != null ? b(avatar) : null;
        SimpleAction link = info.getLink();
        ChannelDisplayInfo channelDisplayInfo = new ChannelDisplayInfo(name, b2, link != null ? a(link) : null, info.getStatus(), info.getUserId());
        InputState inputState = channel.getInputState();
        return new Channel(channelId, type, convertMessage, arrayList, created, updated, unknown, convertChannelReadOnlyState, booleanValue, booleanValue2, booleanValue3, booleanValue4, sortedSet, platformActions, dealAction2, flow, suspectMessageId, channelDisplayInfo, inputState != null ? convertChannelInputState(inputState) : null);
    }

    @Override // com.avito.android.messenger.MessengerEntityConverter
    @NotNull
    public com.avito.android.remote.model.messenger.InputState convertChannelInputState(@NotNull InputState inputState) {
        Intrinsics.checkNotNullParameter(inputState, "inputState");
        return new com.avito.android.remote.model.messenger.InputState(inputState.isDisabled(), inputState.getReason(), inputState.getDescription());
    }

    @Override // com.avito.android.messenger.MessengerEntityConverter
    @NotNull
    public com.avito.android.remote.model.messenger.ReadOnlyState convertChannelReadOnlyState(@NotNull ReadOnlyState readOnlyState) {
        Intrinsics.checkNotNullParameter(readOnlyState, "readOnlyState");
        String reason = readOnlyState.getReason();
        String description = readOnlyState.getDescription();
        if (description == null) {
            description = "";
        }
        return new com.avito.android.remote.model.messenger.ReadOnlyState(reason, description);
    }

    @Override // com.avito.android.messenger.MessengerEntityConverter
    @NotNull
    public MessageBody convertImageBody(@NotNull ru.avito.messenger.api.entity.Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return new MessageBody.ImageBody(b(image));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r1 != null) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x018e  */
    @Override // com.avito.android.messenger.MessengerEntityConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.messenger.message.LocalMessage convertMessage(@org.jetbrains.annotations.NotNull ru.avito.messenger.api.entity.ChatMessage r26) {
        /*
        // Method dump skipped, instructions count: 427
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.MessengerEntityConverterImpl.convertMessage(ru.avito.messenger.api.entity.ChatMessage):com.avito.android.remote.model.messenger.message.LocalMessage");
    }

    @Override // com.avito.android.messenger.MessengerEntityConverter
    @NotNull
    public User convertUser(@NotNull ChannelUser channelUser) {
        PublicProfile publicProfile;
        ChatAvatar chatAvatar;
        Intrinsics.checkNotNullParameter(channelUser, "user");
        String id = channelUser.getId();
        String name = channelUser.getName();
        Long lastActionTime = channelUser.getLastActionTime();
        Long timeDiff = channelUser.getTimeDiff();
        ru.avito.messenger.api.entity.PublicProfile publicProfile2 = channelUser.getPublicProfile();
        Action action = null;
        if (publicProfile2 != null) {
            Avatar avatar = publicProfile2.getAvatar();
            if (avatar != null) {
                String str = avatar.getDefault();
                ru.avito.messenger.api.entity.Image image = avatar.getImage();
                chatAvatar = new ChatAvatar(str, image != null ? b(image) : null);
            } else {
                chatAvatar = null;
            }
            SimpleAction action2 = publicProfile2.getAction();
            if (action2 != null) {
                action = a(action2);
            }
            publicProfile = new PublicProfile(chatAvatar, action);
        } else {
            publicProfile = null;
        }
        return new User(id, name, lastActionTime, timeDiff, publicProfile);
    }
}
