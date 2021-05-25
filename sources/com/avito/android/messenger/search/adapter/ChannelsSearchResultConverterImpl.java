package com.avito.android.messenger.search.adapter;

import com.avito.android.Features;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProvider;
import com.avito.android.messenger.search.adapter.ChannelsSearchListItem;
import com.avito.android.messenger.widget.chat_list_element.ChatListElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.ChatAvatar;
import com.avito.android.remote.model.messenger.PublicProfile;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.StatusCode;
import java.util.Iterator;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/search/adapter/ChannelsSearchResultConverterImpl;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchResultConverter;", "", "currentUserId", "", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults$Result;", "items", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem;", "convert", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;", "messagePreviewProvider", "Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "dateFormatter", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;Lcom/avito/android/date_time_formatter/RelativeDateFormatter;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsSearchResultConverterImpl implements ChannelsSearchResultConverter {
    public final LocalMessagePreviewProvider a;
    public final RelativeDateFormatter b;
    public final Features c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StatusCode.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            StatusCode statusCode = StatusCode.ERROR;
            iArr[2] = 1;
            StatusCode statusCode2 = StatusCode.SENDING;
            iArr[1] = 2;
            StatusCode statusCode3 = StatusCode.READ;
            iArr[3] = 3;
        }
    }

    @Inject
    public ChannelsSearchResultConverterImpl(@NotNull LocalMessagePreviewProvider localMessagePreviewProvider, @NotNull RelativeDateFormatter relativeDateFormatter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(localMessagePreviewProvider, "messagePreviewProvider");
        Intrinsics.checkNotNullParameter(relativeDateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = localMessagePreviewProvider;
        this.b = relativeDateFormatter;
        this.c = features;
    }

    public static final ChatListElement.LastMessageType access$determineLastMessageType(ChannelsSearchResultConverterImpl channelsSearchResultConverterImpl, Channel channel) {
        Objects.requireNonNull(channelsSearchResultConverterImpl);
        LocalMessage lastMessage = channel.getLastMessage();
        if (lastMessage == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        } else if (Intrinsics.areEqual(lastMessage.fromId, lastMessage.userId)) {
            int ordinal = lastMessage.getDeliveryStatus().ordinal();
            if (ordinal == 1) {
                return ChatListElement.LastMessageType.OUTGOING_ERROR;
            }
            if (ordinal == 2) {
                return ChatListElement.LastMessageType.OUTGOING_ERROR;
            }
            if (ordinal != 3) {
                return ChatListElement.LastMessageType.OUTGOING_DELIVERED;
            }
            return ChatListElement.LastMessageType.OUTGOING_READ;
        } else if (lastMessage.isRead) {
            return ChatListElement.LastMessageType.INCOMING_READ;
        } else {
            return ChatListElement.LastMessageType.INCOMING_UNREAD;
        }
    }

    public static final ChatListElement.FeatureImage access$getFeatureImage(ChannelsSearchResultConverterImpl channelsSearchResultConverterImpl, Channel channel, String str) {
        T t;
        PublicProfile publicProfile;
        ChatAvatar avatar;
        Objects.requireNonNull(channelsSearchResultConverterImpl);
        ChannelContext context = channel.getContext();
        if (context instanceof ChannelContext.Item) {
            ChannelContext context2 = channel.getContext();
            Objects.requireNonNull(context2, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.context.ChannelContext.Item");
            return new ChatListElement.FeatureImage.Item(((ChannelContext.Item) context2).getImage());
        } else if (context instanceof ChannelContext.System) {
            ChannelContext context3 = channel.getContext();
            Objects.requireNonNull(context3, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.context.ChannelContext.System");
            return new ChatListElement.FeatureImage.System(((ChannelContext.System) context3).getImage());
        } else {
            Image image = null;
            if (context instanceof ChannelContext.UserToUser) {
                Iterator<T> it = channel.getUsers().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Intrinsics.areEqual(t.getId(), str)) {
                        break;
                    }
                }
                T t2 = t;
                if (!(t2 == null || (publicProfile = t2.getPublicProfile()) == null || (avatar = publicProfile.getAvatar()) == null)) {
                    image = avatar.getImage();
                }
                return new ChatListElement.FeatureImage.UserToUser(image, channel.getDisplayInfo().getAvatar());
            } else if (context instanceof ChannelContext.Unknown) {
                return new ChatListElement.FeatureImage.Item(null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final ChannelsSearchListItem.Channel.ItemInfo access$getItemInfo$p(ChannelsSearchResultConverterImpl channelsSearchResultConverterImpl, ChannelContext channelContext) {
        Objects.requireNonNull(channelsSearchResultConverterImpl);
        if (channelContext instanceof ChannelContext.Item) {
            ChannelContext.Item item = (ChannelContext.Item) channelContext;
            String title = item.getTitle();
            Objects.requireNonNull(title, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt__StringsKt.trim(title).toString();
            String price = item.getPrice();
            Objects.requireNonNull(price, "null cannot be cast to non-null type kotlin.CharSequence");
            return new ChannelsSearchListItem.Channel.ItemInfo(obj, StringsKt__StringsKt.trim(price).toString());
        } else if ((channelContext instanceof ChannelContext.UserToUser) || (channelContext instanceof ChannelContext.System) || (channelContext instanceof ChannelContext.Unknown)) {
            return null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean access$isSupportChannel(ChannelsSearchResultConverterImpl channelsSearchResultConverterImpl, Channel channel) {
        Objects.requireNonNull(channelsSearchResultConverterImpl);
        return (channel.getContext() instanceof ChannelContext.System) && channel.getTags().contains("s") && channelsSearchResultConverterImpl.c.getMessengerPinSupportChat().invoke().booleanValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x023d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f2  */
    @Override // com.avito.android.messenger.search.adapter.ChannelsSearchResultConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.messenger.search.adapter.ChannelsSearchListItem> convert(@org.jetbrains.annotations.NotNull java.lang.String r26, @org.jetbrains.annotations.NotNull java.util.List<com.avito.android.messenger.search.ChannelsSearchInteractor.SearchResults.Result> r27) {
        /*
        // Method dump skipped, instructions count: 604
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.search.adapter.ChannelsSearchResultConverterImpl.convert(java.lang.String, java.util.List):java.util.List");
    }
}
