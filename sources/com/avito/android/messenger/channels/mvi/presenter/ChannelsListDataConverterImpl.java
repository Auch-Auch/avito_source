package com.avito.android.messenger.channels.mvi.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.fragment.app.Fragment;
import com.avito.android.Features;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.R;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.view.PinnedSupportChatItem;
import com.avito.android.messenger.service.user_last_activity.UsersKt;
import com.avito.android.messenger.widget.chat_list_element.ChatListElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.StatusCode;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Contexts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b2\u00103J]\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ]\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\bH\u0016¢\u0006\u0004\b\u000e\u0010\u0012JC\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00130\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0014J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00130\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverterImpl;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverter;", "", "Lru/avito/messenger/api/entity/Channel;", "", "currentUserId", "", "typingChannelIds", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "lastMessagesFromDb", "Lru/avito/android/persistence/messenger/DraftEntity;", "drafts", "Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem;", "convertToListItems", "(Ljava/util/List;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "", "Lcom/avito/android/remote/model/messenger/Channel;", "(Ljava/util/Collection;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "Lkotlin/Pair;", "(Ljava/util/List;Ljava/lang/String;Ljava/util/Set;)Ljava/util/List;", "Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem;", "convertToPinnedSupportChatItems", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Lcom/avito/android/messenger/MessengerEntityConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/MessengerEntityConverter;", "entityConverter", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;", "d", "Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;", "messagePreviewProvider", "Lcom/avito/android/server_time/TimeSource;", "e", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Landroid/content/res/Resources;", "c", "Landroid/content/res/Resources;", "resources", "", AuthSource.SEND_ABUSE, "I", "draftsColor", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/messenger/MessengerEntityConverter;Landroid/content/res/Resources;Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsListDataConverterImpl implements ChannelsListDataConverter {
    public final int a;
    public final MessengerEntityConverter b;
    public final Resources c;
    public final LocalMessagePreviewProvider d;
    public final TimeSource e;
    public final Features f;

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
    public ChannelsListDataConverterImpl(@NotNull Fragment fragment, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull Resources resources, @NotNull LocalMessagePreviewProvider localMessagePreviewProvider, @NotNull TimeSource timeSource, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "entityConverter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(localMessagePreviewProvider, "messagePreviewProvider");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = messengerEntityConverter;
        this.c = resources;
        this.d = localMessagePreviewProvider;
        this.e = timeSource;
        this.f = features;
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        this.a = Contexts.getColorByAttr(requireContext, R.attr.red);
    }

    public static final MessagePreview access$addDraftPrefix(ChannelsListDataConverterImpl channelsListDataConverterImpl, CharSequence charSequence) {
        Objects.requireNonNull(channelsListDataConverterImpl);
        SpannableStringBuilder append = new SpannableStringBuilder().append(channelsListDataConverterImpl.c.getString(com.avito.android.messenger.R.string.message_body_draft_prefix), new ForegroundColorSpan(channelsListDataConverterImpl.a), 33).append(StringsKt__StringsKt.trimStart(charSequence));
        Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder()…     .append(trimStart())");
        return new MessagePreview(append, null, 2, null);
    }

    public static final Picture access$determineAvatarImage(ChannelsListDataConverterImpl channelsListDataConverterImpl, Channel channel) {
        Objects.requireNonNull(channelsListDataConverterImpl);
        Image avatar = channel.getDisplayInfo().getAvatar();
        if (avatar != null) {
            return AvitoPictureKt.pictureOf$default(avatar, false, 0.0f, 0.0f, null, 28, null);
        }
        return null;
    }

    public static final long access$determineDate(ChannelsListDataConverterImpl channelsListDataConverterImpl, Channel channel, LocalMessage localMessage) {
        Long l;
        Objects.requireNonNull(channelsListDataConverterImpl);
        if (localMessage != null) {
            l = Long.valueOf(localMessage.created);
        } else {
            LocalMessage lastMessage = channel.getLastMessage();
            l = lastMessage != null ? Long.valueOf(lastMessage.created) : null;
        }
        if (l != null) {
            return l.longValue();
        }
        return channel.getUpdated();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7 */
    public static final boolean access$determineInterlocutorOnlineStatus(ChannelsListDataConverterImpl channelsListDataConverterImpl, Channel channel, String str) {
        User user;
        Objects.requireNonNull(channelsListDataConverterImpl);
        if (channel.getDisplayInfo().getStatus() != null) {
            return false;
        }
        List<User> users = channel.getUsers();
        ArrayList arrayList = new ArrayList();
        for (T t : users) {
            T t2 = t;
            boolean z = true;
            if (!(!Intrinsics.areEqual(t2.getId(), str)) || t2.getLastActionTime() == null) {
                z = false;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            user = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                Long lastActionTime = ((User) next).getLastActionTime();
                long longValue = lastActionTime != null ? lastActionTime.longValue() : Long.MIN_VALUE;
                do {
                    Object next2 = it.next();
                    Long lastActionTime2 = ((User) next2).getLastActionTime();
                    long longValue2 = lastActionTime2 != null ? lastActionTime2.longValue() : Long.MIN_VALUE;
                    if (longValue < longValue2) {
                        next = next2;
                        longValue = longValue2;
                    }
                } while (it.hasNext());
            }
            user = next;
        }
        User user2 = user;
        if (user2 == null) {
            return false;
        }
        return UsersKt.isOnline(user2, TimeUnit.SECONDS.convert(channelsListDataConverterImpl.e.now(), TimeUnit.MILLISECONDS));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        if (r2 != null) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.avito.android.messenger.channels.mvi.presenter.MessagePreview access$determineLastMessageText(com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl r6, com.avito.android.remote.model.messenger.Channel r7, com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType r8, com.avito.android.remote.model.messenger.message.LocalMessage r9, ru.avito.android.persistence.messenger.DraftEntity r10) {
        /*
            java.util.Objects.requireNonNull(r6)
            r0 = 2
            r1 = 0
            if (r10 == 0) goto L_0x004b
            java.lang.String r10 = r10.getText()
            if (r10 == 0) goto L_0x004b
            android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
            r2.<init>()
            android.content.res.Resources r3 = access$getResources$p(r6)
            int r4 = com.avito.android.messenger.R.string.message_body_draft_prefix
            java.lang.String r3 = r3.getString(r4)
            android.text.style.ForegroundColorSpan r4 = new android.text.style.ForegroundColorSpan
            int r5 = access$getDraftsColor$p(r6)
            r4.<init>(r5)
            r5 = 33
            android.text.SpannableStringBuilder r2 = r2.append(r3, r4, r5)
            java.lang.CharSequence r10 = kotlin.text.StringsKt__StringsKt.trimStart(r10)
            android.text.SpannableStringBuilder r10 = r2.append(r10)
            java.lang.String r2 = "SpannableStringBuilder()…     .append(trimStart())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)
            com.avito.android.messenger.channels.mvi.presenter.MessagePreview r2 = new com.avito.android.messenger.channels.mvi.presenter.MessagePreview
            r2.<init>(r10, r1, r0, r1)
            com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType r10 = com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType.DRAFT
            if (r8 != r10) goto L_0x0043
            r8 = 1
            goto L_0x0044
        L_0x0043:
            r8 = 0
        L_0x0044:
            if (r8 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r2 = r1
        L_0x0048:
            if (r2 == 0) goto L_0x004b
            goto L_0x0057
        L_0x004b:
            if (r9 == 0) goto L_0x0056
            com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProvider r8 = access$getMessagePreviewProvider$p(r6)
            com.avito.android.messenger.channels.mvi.presenter.MessagePreview r2 = r8.getPreviewText(r9)
            goto L_0x0057
        L_0x0056:
            r2 = r1
        L_0x0057:
            if (r2 == 0) goto L_0x005a
            goto L_0x006a
        L_0x005a:
            com.avito.android.remote.model.messenger.message.LocalMessage r7 = r7.getLastMessage()
            if (r7 == 0) goto L_0x0069
            com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProvider r8 = access$getMessagePreviewProvider$p(r6)
            com.avito.android.messenger.channels.mvi.presenter.MessagePreview r2 = r8.getPreviewText(r7)
            goto L_0x006a
        L_0x0069:
            r2 = r1
        L_0x006a:
            if (r2 == 0) goto L_0x006d
            goto L_0x0081
        L_0x006d:
            com.avito.android.messenger.channels.mvi.presenter.MessagePreview r2 = new com.avito.android.messenger.channels.mvi.presenter.MessagePreview
            android.content.res.Resources r6 = access$getResources$p(r6)
            int r7 = com.avito.android.messenger.R.string.message_body_description_empty
            java.lang.String r6 = r6.getString(r7)
            java.lang.String r7 = "resources.getString(R.st…e_body_description_empty)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r2.<init>(r6, r1, r0, r1)
        L_0x0081:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl.access$determineLastMessageText(com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl, com.avito.android.remote.model.messenger.Channel, com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType, com.avito.android.remote.model.messenger.message.LocalMessage, ru.avito.android.persistence.messenger.DraftEntity):com.avito.android.messenger.channels.mvi.presenter.MessagePreview");
    }

    public static final ChatListElement.LastMessageType access$determineLastMessageType(ChannelsListDataConverterImpl channelsListDataConverterImpl, Channel channel, String str, LocalMessage localMessage, DraftEntity draftEntity) {
        boolean z;
        Objects.requireNonNull(channelsListDataConverterImpl);
        if (localMessage != null) {
            z = Intrinsics.areEqual(str, localMessage.fromId);
        } else {
            LocalMessage lastMessage = channel.getLastMessage();
            z = Intrinsics.areEqual(str, lastMessage != null ? lastMessage.fromId : null);
        }
        ChatListElement.LastMessageType access$getLastMessageType = access$getLastMessageType(channelsListDataConverterImpl, z, channel, channel.getLastMessage(), localMessage);
        return (draftEntity == null || access$getLastMessageType == ChatListElement.LastMessageType.INCOMING_UNREAD) ? access$getLastMessageType : ChatListElement.LastMessageType.DRAFT;
    }

    public static final MessagePreview access$getDescription(ChannelsListDataConverterImpl channelsListDataConverterImpl, LocalMessage localMessage) {
        Objects.requireNonNull(channelsListDataConverterImpl);
        return channelsListDataConverterImpl.d.getPreviewText(localMessage);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType access$getLastMessageType(com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl r1, boolean r2, com.avito.android.remote.model.messenger.Channel r3, com.avito.android.remote.model.messenger.message.LocalMessage r4, com.avito.android.remote.model.messenger.message.LocalMessage r5) {
        /*
            java.util.Objects.requireNonNull(r1)
            if (r4 != 0) goto L_0x000a
            if (r5 != 0) goto L_0x000a
            com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType r1 = com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType.EMPTY
            goto L_0x0059
        L_0x000a:
            r1 = 0
            if (r5 == 0) goto L_0x0014
            com.avito.android.remote.model.messenger.message.StatusCode r0 = r5.getDeliveryStatus()
            if (r0 == 0) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            if (r4 == 0) goto L_0x001b
            com.avito.android.remote.model.messenger.message.StatusCode r0 = r4.getDeliveryStatus()
            goto L_0x001c
        L_0x001b:
            r0 = r1
        L_0x001c:
            if (r5 == 0) goto L_0x0021
            boolean r1 = r5.isRead
            goto L_0x0025
        L_0x0021:
            if (r4 == 0) goto L_0x0029
            boolean r1 = r4.isRead
        L_0x0025:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x0029:
            if (r1 == 0) goto L_0x0030
            boolean r1 = r1.booleanValue()
            goto L_0x0034
        L_0x0030:
            boolean r1 = r3.isRead()
        L_0x0034:
            if (r2 == 0) goto L_0x0052
            if (r0 != 0) goto L_0x0039
            goto L_0x0046
        L_0x0039:
            int r1 = r0.ordinal()
            r2 = 1
            if (r1 == r2) goto L_0x004f
            r2 = 2
            if (r1 == r2) goto L_0x004c
            r2 = 3
            if (r1 == r2) goto L_0x0049
        L_0x0046:
            com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType r1 = com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType.OUTGOING_DELIVERED
            goto L_0x0059
        L_0x0049:
            com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType r1 = com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType.OUTGOING_READ
            goto L_0x0059
        L_0x004c:
            com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType r1 = com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType.OUTGOING_ERROR
            goto L_0x0059
        L_0x004f:
            com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType r1 = com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType.OUTGOING_PENDING
            goto L_0x0059
        L_0x0052:
            if (r1 != 0) goto L_0x0057
            com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType r1 = com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType.INCOMING_UNREAD
            goto L_0x0059
        L_0x0057:
            com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType r1 = com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType.INCOMING_READ
        L_0x0059:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl.access$getLastMessageType(com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl, boolean, com.avito.android.remote.model.messenger.Channel, com.avito.android.remote.model.messenger.message.LocalMessage, com.avito.android.remote.model.messenger.message.LocalMessage):com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0491, code lost:
        if (r7 != null) goto L_0x04a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x04d8, code lost:
        if (r4.isDisabled() != true) goto L_0x04dc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x015a  */
    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.messenger.channels.mvi.view.ChannelListItem> convertToListItems(@org.jetbrains.annotations.NotNull java.util.List<ru.avito.messenger.api.entity.Channel> r33, @org.jetbrains.annotations.NotNull java.lang.String r34, @org.jetbrains.annotations.NotNull java.util.Set<java.lang.String> r35, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, com.avito.android.remote.model.messenger.message.LocalMessage> r36, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, ru.avito.android.persistence.messenger.DraftEntity> r37) {
        /*
        // Method dump skipped, instructions count: 1321
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl.convertToListItems(java.util.List, java.lang.String, java.util.Set, java.util.Map, java.util.Map):java.util.List");
    }

    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter
    @NotNull
    public List<PinnedSupportChatItem> convertToPinnedSupportChatItems(@NotNull List<Pair<Channel, DraftEntity>> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "$this$convertToPinnedSupportChatItems");
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Channel channel = (Channel) it.next().component1();
            LocalMessage lastMessage = channel.getLastMessage();
            PinnedSupportChatItem pinnedSupportChatItem = null;
            ChatListElement.LastMessageType access$getLastMessageType = access$getLastMessageType(this, Intrinsics.areEqual(str, lastMessage != null ? lastMessage.fromId : null), channel, channel.getLastMessage(), null);
            ChannelContext context = channel.getContext();
            if (!(context instanceof ChannelContext.System)) {
                context = null;
            }
            ChannelContext.System system = (ChannelContext.System) context;
            if (system != null && channel.getTags().contains("s") && this.f.getMessengerPinSupportChat().invoke().booleanValue()) {
                pinnedSupportChatItem = new PinnedSupportChatItem(channel.getChannelId(), access$getLastMessageType == ChatListElement.LastMessageType.INCOMING_UNREAD, channel.getDisplayInfo().getName(), system.getImage());
            }
            if (pinnedSupportChatItem != null) {
                arrayList.add(pinnedSupportChatItem);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:207:0x048b, code lost:
        if (r10 != null) goto L_0x049c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x04d2, code lost:
        if (r2.isDisabled() != true) goto L_0x04d6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0154  */
    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.messenger.channels.mvi.view.ChannelListItem> convertToListItems(@org.jetbrains.annotations.NotNull java.util.Collection<com.avito.android.remote.model.messenger.Channel> r33, @org.jetbrains.annotations.NotNull java.lang.String r34, @org.jetbrains.annotations.NotNull java.util.Set<java.lang.String> r35, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, com.avito.android.remote.model.messenger.message.LocalMessage> r36, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, ru.avito.android.persistence.messenger.DraftEntity> r37) {
        /*
        // Method dump skipped, instructions count: 1315
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl.convertToListItems(java.util.Collection, java.lang.String, java.util.Set, java.util.Map, java.util.Map):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x024a, code lost:
        if (r5 != null) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0343, code lost:
        if (r4 != null) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x043f, code lost:
        if (r3 != null) goto L_0x0443;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0479, code lost:
        if (r3.isDisabled() != true) goto L_0x047d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010f, code lost:
        if (r3 != null) goto L_0x0115;
     */
    @Override // com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.messenger.channels.mvi.view.ChannelListItem> convertToListItems(@org.jetbrains.annotations.NotNull java.util.List<kotlin.Pair<com.avito.android.remote.model.messenger.Channel, ru.avito.android.persistence.messenger.DraftEntity>> r30, @org.jetbrains.annotations.NotNull java.lang.String r31, @org.jetbrains.annotations.NotNull java.util.Set<java.lang.String> r32) {
        /*
        // Method dump skipped, instructions count: 1221
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverterImpl.convertToListItems(java.util.List, java.lang.String, java.util.Set):java.util.List");
    }
}
