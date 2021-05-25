package com.avito.android.messenger.conversation.mvi.messages;

import android.net.Uri;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.ChatAvatar;
import com.avito.android.remote.model.messenger.MessengerTimestamp;
import com.avito.android.remote.model.messenger.PublicProfile;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.model.messenger.message.StatusCode;
import com.avito.android.util.Formatter;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.n.d;
import t6.n.e;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!JK\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u00060\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverterImpl;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListItemConverter;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "messagesAndMetaInfo", "", "currentUserId", "Lcom/avito/android/remote/model/User;", "users", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", Tracker.Events.CREATIVE_EXPAND, "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "messages", "", "newMessagesDividerPosition", "Lcom/avito/android/messenger/conversation/ChannelItem;", "finishConversion", "(Ljava/util/List;Ljava/util/List;I)Ljava/util/List;", "Lcom/avito/android/util/Formatter;", "", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Formatter;", "dateFormatter", AuthSource.BOOKING_ORDER, "timeFormatter", "Lcom/avito/android/remote/model/Image;", "c", "Lcom/avito/android/remote/model/Image;", "avitoAvatar", "<init>", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/util/Formatter;Lcom/avito/android/remote/model/Image;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageListItemConverterImpl implements MessageListItemConverter {
    public final Formatter<Long> a;
    public final Formatter<Long> b;
    public final Image c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StatusCode.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            StatusCode statusCode = StatusCode.SENT;
            iArr[0] = 1;
            StatusCode statusCode2 = StatusCode.SENDING;
            iArr[1] = 2;
            StatusCode statusCode3 = StatusCode.ERROR;
            iArr[2] = 3;
            StatusCode statusCode4 = StatusCode.READ;
            iArr[3] = 4;
        }
    }

    public MessageListItemConverterImpl(@NotNull Formatter<Long> formatter, @NotNull Formatter<Long> formatter2, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(formatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(formatter2, "timeFormatter");
        Intrinsics.checkNotNullParameter(image, "avitoAvatar");
        this.a = formatter;
        this.b = formatter2;
        this.c = image;
    }

    public static final MessageDeliveryStatus access$determineDeliveryStatus(MessageListItemConverterImpl messageListItemConverterImpl, LocalMessage localMessage) {
        Objects.requireNonNull(messageListItemConverterImpl);
        int ordinal = localMessage.getDeliveryStatus().ordinal();
        if (ordinal == 0) {
            return MessageDeliveryStatus.SENT;
        }
        if (ordinal == 1) {
            return MessageDeliveryStatus.SENDING;
        }
        if (ordinal == 2) {
            return MessageDeliveryStatus.ERROR;
        }
        if (ordinal == 3) {
            return MessageDeliveryStatus.READ;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final List access$expandPlatformFromAvitoBody(MessageListItemConverterImpl messageListItemConverterImpl, LocalMessage localMessage, String str, String str2, String str3, boolean z, MessageMetaInfo messageMetaInfo) {
        List list;
        Pair pair;
        String str4;
        MessageDeliveryStatus messageDeliveryStatus;
        List<MessageBody.SystemMessageBody.Platform.Bubble> chunks;
        LocalMessage localMessage2 = localMessage;
        Objects.requireNonNull(messageListItemConverterImpl);
        MessageBody messageBody = localMessage2.body;
        Object obj = null;
        if (!(messageBody instanceof MessageBody.SystemMessageBody.Platform.FromAvito)) {
            messageBody = null;
        }
        MessageBody.SystemMessageBody.Platform.FromAvito fromAvito = (MessageBody.SystemMessageBody.Platform.FromAvito) messageBody;
        if (fromAvito == null || (chunks = fromAvito.getChunks()) == null || (list = CollectionsKt___CollectionsKt.reversed(chunks)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj2 : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MessageBody.SystemMessageBody.Platform.Bubble bubble = (MessageBody.SystemMessageBody.Platform.Bubble) obj2;
            String str5 = list2.size() > 1 ? localMessage2.localId + '_' + i : localMessage2.localId;
            int size = list2.size() - 1;
            int i3 = 16;
            int i4 = (list2.size() <= 1 || i >= size) ? 16 : 0;
            if (list2.size() <= 1 || i <= 0) {
                pair = TuplesKt.to(0, str3);
            } else {
                if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.GeoLocation) {
                    i3 = 4;
                } else if (!(bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Text) || !(list2.get(i - 1) instanceof MessageBody.SystemMessageBody.Platform.Bubble.Item)) {
                    i3 = 0;
                }
                pair = TuplesKt.to(Integer.valueOf(i3), obj);
            }
            int intValue = ((Number) pair.component1()).intValue();
            String str6 = (String) pair.component2();
            int i5 = intValue + 8;
            String str7 = i == size ? str2 : "";
            ChannelItem.Message.BodyOrBubble.Bubble bubble2 = new ChannelItem.Message.BodyOrBubble.Bubble(bubble);
            if (str != null) {
                str4 = str;
            } else {
                str4 = "";
            }
            int ordinal = localMessage.getDeliveryStatus().ordinal();
            if (ordinal == 0) {
                messageDeliveryStatus = MessageDeliveryStatus.SENT;
            } else if (ordinal == 1) {
                messageDeliveryStatus = MessageDeliveryStatus.SENDING;
            } else if (ordinal == 2) {
                messageDeliveryStatus = MessageDeliveryStatus.ERROR;
            } else if (ordinal == 3) {
                messageDeliveryStatus = MessageDeliveryStatus.READ;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(new ChannelItem.Message(str5, bubble2, str4, str7, str6, z, messageDeliveryStatus, true, z || localMessage2.isRead, Integer.valueOf(i4), Integer.valueOf(i5), null, null, localMessage, messageMetaInfo, 6144, null));
            localMessage2 = localMessage;
            arrayList = arrayList;
            i = i2;
            list2 = list2;
            obj = obj;
        }
        return arrayList;
    }

    public static final List access$expandPlatformFromUserBody(MessageListItemConverterImpl messageListItemConverterImpl, LocalMessage localMessage, String str, String str2, String str3, boolean z, MessageMetaInfo messageMetaInfo) {
        List list;
        MessageDeliveryStatus messageDeliveryStatus;
        List<MessageBody.SystemMessageBody.Platform.Bubble> chunks;
        LocalMessage localMessage2 = localMessage;
        Objects.requireNonNull(messageListItemConverterImpl);
        MessageBody messageBody = localMessage2.body;
        if (!(messageBody instanceof MessageBody.SystemMessageBody.Platform.FromUser)) {
            messageBody = null;
        }
        MessageBody.SystemMessageBody.Platform.FromUser fromUser = (MessageBody.SystemMessageBody.Platform.FromUser) messageBody;
        if (fromUser == null || (chunks = fromUser.getChunks()) == null || (list = CollectionsKt___CollectionsKt.reversed(chunks)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MessageBody.SystemMessageBody.Platform.Bubble bubble = (MessageBody.SystemMessageBody.Platform.Bubble) obj;
            String str4 = list2.size() > 1 ? localMessage2.localId + '_' + i : localMessage2.localId;
            String str5 = "";
            String str6 = i == list2.size() - 1 ? str2 : str5;
            ChannelItem.Message.BodyOrBubble.Bubble bubble2 = new ChannelItem.Message.BodyOrBubble.Bubble(bubble);
            if (str != null) {
                str5 = str;
            }
            int ordinal = localMessage.getDeliveryStatus().ordinal();
            if (ordinal == 0) {
                messageDeliveryStatus = MessageDeliveryStatus.SENT;
            } else if (ordinal == 1) {
                messageDeliveryStatus = MessageDeliveryStatus.SENDING;
            } else if (ordinal == 2) {
                messageDeliveryStatus = MessageDeliveryStatus.ERROR;
            } else if (ordinal == 3) {
                messageDeliveryStatus = MessageDeliveryStatus.READ;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(new ChannelItem.Message(str4, bubble2, str5, str6, str3, z, messageDeliveryStatus, true, z || localMessage2.isRead, null, null, null, null, localMessage, messageMetaInfo, 7680, null));
            localMessage2 = localMessage;
            arrayList = arrayList;
            i = i2;
            list2 = list2;
        }
        return arrayList;
    }

    public static final List access$expandSimpleBody(MessageListItemConverterImpl messageListItemConverterImpl, LocalMessage localMessage, String str, String str2, String str3, boolean z, MessageMetaInfo messageMetaInfo) {
        MessageDeliveryStatus messageDeliveryStatus;
        Objects.requireNonNull(messageListItemConverterImpl);
        String str4 = localMessage.localId;
        ChannelItem.Message.BodyOrBubble.Body body = new ChannelItem.Message.BodyOrBubble.Body(localMessage.body);
        String str5 = str != null ? str : "";
        int ordinal = localMessage.getDeliveryStatus().ordinal();
        if (ordinal == 0) {
            messageDeliveryStatus = MessageDeliveryStatus.SENT;
        } else if (ordinal == 1) {
            messageDeliveryStatus = MessageDeliveryStatus.SENDING;
        } else if (ordinal == 2) {
            messageDeliveryStatus = MessageDeliveryStatus.ERROR;
        } else if (ordinal == 3) {
            messageDeliveryStatus = MessageDeliveryStatus.READ;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return d.listOf(new ChannelItem.Message(str4, body, str5, str2, str3, z, messageDeliveryStatus, true, z || localMessage.isRead, null, null, null, null, localMessage, messageMetaInfo, 7680, null));
    }

    public static final String access$getDate(MessageListItemConverterImpl messageListItemConverterImpl, LocalMessage localMessage, LocalMessage localMessage2) {
        Objects.requireNonNull(messageListItemConverterImpl);
        String str = null;
        String access$getDateString$p = localMessage2 != null ? access$getDateString$p(messageListItemConverterImpl, localMessage2) : null;
        if (localMessage != null) {
            str = access$getDateString$p(messageListItemConverterImpl, localMessage);
        }
        return (!(Intrinsics.areEqual(access$getDateString$p, str) ^ true) || access$getDateString$p == null) ? "" : access$getDateString$p;
    }

    public static final String access$getDateString$p(MessageListItemConverterImpl messageListItemConverterImpl, LocalMessage localMessage) {
        Objects.requireNonNull(messageListItemConverterImpl);
        return messageListItemConverterImpl.a.format(Long.valueOf(MessengerTimestamp.toMillis(localMessage.created)));
    }

    public static final Image access$getUserAvatar(MessageListItemConverterImpl messageListItemConverterImpl, LocalMessage localMessage, List list, boolean z) {
        Image image;
        PublicProfile publicProfile;
        ChatAvatar avatar;
        Objects.requireNonNull(messageListItemConverterImpl);
        Object obj = null;
        if (!z) {
            return null;
        }
        if (localMessage.body instanceof MessageBody.SystemMessageBody.Platform.FromAvito) {
            return messageListItemConverterImpl.c;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(localMessage.fromId, ((User) next).getId())) {
                obj = next;
                break;
            }
        }
        User user = (User) obj;
        if (user == null || (publicProfile = user.getPublicProfile()) == null || (avatar = publicProfile.getAvatar()) == null || (image = avatar.getImage()) == null) {
            Uri uri = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
            image = ImageKt.toImage(uri);
        }
        return image;
    }

    public static final boolean access$isMine(MessageListItemConverterImpl messageListItemConverterImpl, LocalMessage localMessage, String str) {
        Objects.requireNonNull(messageListItemConverterImpl);
        return Intrinsics.areEqual(localMessage.fromId, str);
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListItemConverter
    @NotNull
    public List<ChannelItem.Message> expand(@NotNull List<Pair<LocalMessage, MessageMetaInfo>> list, @NotNull String str, @NotNull List<User> list2) {
        String str2;
        Iterator it;
        List list3;
        ArrayList arrayList;
        String str3;
        MessageDeliveryStatus messageDeliveryStatus;
        List list4;
        String str4;
        String str5;
        MessageDeliveryStatus messageDeliveryStatus2;
        List<MessageBody.SystemMessageBody.Platform.Bubble> chunks;
        List list5;
        Pair pair;
        String str6;
        String str7;
        MessageDeliveryStatus messageDeliveryStatus3;
        List<MessageBody.SystemMessageBody.Platform.Bubble> chunks2;
        MessageListItemConverterImpl messageListItemConverterImpl = this;
        List<Pair<LocalMessage, MessageMetaInfo>> list6 = list;
        String str8 = str;
        Intrinsics.checkNotNullParameter(list6, "messagesAndMetaInfo");
        Intrinsics.checkNotNullParameter(str8, "currentUserId");
        Intrinsics.checkNotNullParameter(list2, "users");
        IntRange indices = CollectionsKt__CollectionsKt.getIndices(list);
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = indices.iterator();
        while (it2.hasNext()) {
            int nextInt = ((IntIterator) it2).nextInt();
            Pair<LocalMessage, MessageMetaInfo> pair2 = list6.get(nextInt);
            LocalMessage component1 = pair2.component1();
            MessageMetaInfo component2 = pair2.component2();
            Iterator<User> it3 = list2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    str2 = null;
                    break;
                }
                User next = it3.next();
                if (Intrinsics.areEqual(component1.fromId, next.getId())) {
                    str2 = next.getName();
                    break;
                }
            }
            int i = 1;
            LocalMessage first = nextInt < list.size() - 1 ? list6.get(nextInt + 1).getFirst() : null;
            String access$getDateString$p = component1 != null ? access$getDateString$p(messageListItemConverterImpl, component1) : null;
            String str9 = (!(Intrinsics.areEqual(access$getDateString$p, first != null ? access$getDateString$p(messageListItemConverterImpl, first) : null) ^ true) || access$getDateString$p == null) ? "" : access$getDateString$p;
            String format = this.b.format(Long.valueOf(MessengerTimestamp.toMillis(component1.created)));
            boolean areEqual = Intrinsics.areEqual(component1.fromId, str8);
            MessageBody messageBody = component1.body;
            if (messageBody instanceof MessageBody.SystemMessageBody.Platform.FromAvito) {
                if (!(messageBody instanceof MessageBody.SystemMessageBody.Platform.FromAvito)) {
                    messageBody = null;
                }
                MessageBody.SystemMessageBody.Platform.FromAvito fromAvito = (MessageBody.SystemMessageBody.Platform.FromAvito) messageBody;
                if (fromAvito == null || (chunks2 = fromAvito.getChunks()) == null || (list5 = CollectionsKt___CollectionsKt.reversed(chunks2)) == null) {
                    list5 = CollectionsKt__CollectionsKt.emptyList();
                }
                List list7 = list5;
                list3 = new ArrayList(e.collectionSizeOrDefault(list7, 10));
                int i2 = 0;
                for (Object obj : list7) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    MessageBody.SystemMessageBody.Platform.Bubble bubble = (MessageBody.SystemMessageBody.Platform.Bubble) obj;
                    String str10 = list7.size() > i ? component1.localId + '_' + i2 : component1.localId;
                    int size = list7.size() - 1;
                    int i4 = 16;
                    int i5 = (list7.size() <= 1 || i2 >= size) ? 16 : 0;
                    if (list7.size() <= 1 || i2 <= 0) {
                        pair = TuplesKt.to(0, format);
                    } else {
                        if (bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.GeoLocation) {
                            i4 = 4;
                        } else if (!(bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.Text) || !(list7.get(i2 - 1) instanceof MessageBody.SystemMessageBody.Platform.Bubble.Item)) {
                            i4 = 0;
                        }
                        pair = TuplesKt.to(Integer.valueOf(i4), null);
                    }
                    int intValue = ((Number) pair.component1()).intValue();
                    String str11 = (String) pair.component2();
                    int i6 = intValue + 8;
                    if (i2 == size) {
                        str6 = str9;
                    } else {
                        str6 = "";
                    }
                    ChannelItem.Message.BodyOrBubble.Bubble bubble2 = new ChannelItem.Message.BodyOrBubble.Bubble(bubble);
                    if (str2 != null) {
                        str7 = str2;
                    } else {
                        str7 = "";
                    }
                    int ordinal = component1.getDeliveryStatus().ordinal();
                    if (ordinal == 0) {
                        messageDeliveryStatus3 = MessageDeliveryStatus.SENT;
                    } else if (ordinal == 1) {
                        messageDeliveryStatus3 = MessageDeliveryStatus.SENDING;
                    } else if (ordinal == 2) {
                        messageDeliveryStatus3 = MessageDeliveryStatus.ERROR;
                    } else if (ordinal == 3) {
                        messageDeliveryStatus3 = MessageDeliveryStatus.READ;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    list3.add(new ChannelItem.Message(str10, bubble2, str7, str6, str11, areEqual, messageDeliveryStatus3, true, areEqual || component1.isRead, Integer.valueOf(i5), Integer.valueOf(i6), null, null, component1, component2, 6144, null));
                    list3 = list3;
                    i2 = i3;
                    arrayList2 = arrayList2;
                    it2 = it2;
                    list7 = list7;
                    format = format;
                    i = 1;
                }
                it = it2;
                arrayList = arrayList2;
            } else {
                it = it2;
                if (messageBody instanceof MessageBody.SystemMessageBody.Platform.FromUser) {
                    MessageBody.SystemMessageBody.Platform.FromUser fromUser = (MessageBody.SystemMessageBody.Platform.FromUser) (!(messageBody instanceof MessageBody.SystemMessageBody.Platform.FromUser) ? null : messageBody);
                    if (fromUser == null || (chunks = fromUser.getChunks()) == null || (list4 = CollectionsKt___CollectionsKt.reversed(chunks)) == null) {
                        list4 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(list4, 10));
                    int i7 = 0;
                    for (Object obj2 : list4) {
                        int i8 = i7 + 1;
                        if (i7 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        MessageBody.SystemMessageBody.Platform.Bubble bubble3 = (MessageBody.SystemMessageBody.Platform.Bubble) obj2;
                        String str12 = list4.size() > 1 ? component1.localId + '_' + i7 : component1.localId;
                        if (i7 == list4.size() - 1) {
                            str4 = str9;
                        } else {
                            str4 = "";
                        }
                        ChannelItem.Message.BodyOrBubble.Bubble bubble4 = new ChannelItem.Message.BodyOrBubble.Bubble(bubble3);
                        if (str2 != null) {
                            str5 = str2;
                        } else {
                            str5 = "";
                        }
                        int ordinal2 = component1.getDeliveryStatus().ordinal();
                        if (ordinal2 == 0) {
                            messageDeliveryStatus2 = MessageDeliveryStatus.SENT;
                        } else if (ordinal2 == 1) {
                            messageDeliveryStatus2 = MessageDeliveryStatus.SENDING;
                        } else if (ordinal2 == 2) {
                            messageDeliveryStatus2 = MessageDeliveryStatus.ERROR;
                        } else if (ordinal2 == 3) {
                            messageDeliveryStatus2 = MessageDeliveryStatus.READ;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        arrayList3.add(new ChannelItem.Message(str12, bubble4, str5, str4, format, areEqual, messageDeliveryStatus2, true, areEqual || component1.isRead, null, null, null, null, component1, component2, 7680, null));
                        i7 = i8;
                    }
                    list3 = arrayList3;
                } else {
                    String str13 = component1.localId;
                    ChannelItem.Message.BodyOrBubble.Body body = new ChannelItem.Message.BodyOrBubble.Body(messageBody);
                    if (str2 != null) {
                        str3 = str2;
                    } else {
                        str3 = "";
                    }
                    int ordinal3 = component1.getDeliveryStatus().ordinal();
                    if (ordinal3 == 0) {
                        messageDeliveryStatus = MessageDeliveryStatus.SENT;
                    } else if (ordinal3 == 1) {
                        messageDeliveryStatus = MessageDeliveryStatus.SENDING;
                    } else if (ordinal3 == 2) {
                        messageDeliveryStatus = MessageDeliveryStatus.ERROR;
                    } else if (ordinal3 == 3) {
                        messageDeliveryStatus = MessageDeliveryStatus.READ;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    list3 = d.listOf(new ChannelItem.Message(str13, body, str3, str9, format, areEqual, messageDeliveryStatus, true, areEqual || component1.isRead, null, null, null, null, component1, component2, 7680, null));
                }
                arrayList = arrayList2;
            }
            h.addAll(arrayList, list3);
            list6 = list;
            str8 = str;
            arrayList2 = arrayList;
            it2 = it;
            messageListItemConverterImpl = this;
        }
        return arrayList2;
    }

    @Override // com.avito.android.messenger.conversation.mvi.messages.MessageListItemConverter
    @NotNull
    public List<ChannelItem> finishConversion(@NotNull List<ChannelItem.Message> list, @NotNull List<User> list2, int i) {
        String str;
        Image image;
        T t;
        PublicProfile publicProfile;
        ChatAvatar avatar;
        Image image2;
        T t2;
        PublicProfile publicProfile2;
        ChatAvatar avatar2;
        Image image3;
        List<ChannelItem.Message> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "messages");
        Intrinsics.checkNotNullParameter(list2, "users");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            str = "";
            if (i2 >= i) {
                break;
            }
            ChannelItem.Message message = i2 < list.size() - 1 ? list3.get(i2 + 1) : null;
            ChannelItem.Message message2 = i2 > 0 ? list3.get(i2 - 1) : null;
            ChannelItem.Message message3 = list3.get(i2);
            boolean z = (message3.getBodyOrBubble() instanceof ChannelItem.Message.BodyOrBubble.Bubble) || !(message3.getBodyOrBubble().getBody() instanceof MessageBody.SystemMessageBody.Text);
            boolean z2 = (message != null ? message.getBodyOrBubble() : null) == null || (message.getBodyOrBubble().getBody() instanceof MessageBody.SystemMessageBody.Text);
            boolean z3 = (message2 != null ? message2.getBodyOrBubble() : null) == null || (message2.getBodyOrBubble().getBody() instanceof MessageBody.SystemMessageBody.Text);
            boolean z4 = message == null || (Intrinsics.areEqual(message.getLocalMessage().fromId, message3.getLocalMessage().fromId) ^ true);
            boolean z5 = message2 == null || (Intrinsics.areEqual(message2.getLocalMessage().fromId, message3.getLocalMessage().fromId) ^ true);
            boolean z7 = message3.getDate().length() > 0;
            LocalMessage localMessage = message3.getLocalMessage();
            LocalMessage localMessage2 = message2 != null ? message2.getLocalMessage() : null;
            String access$getDateString$p = localMessage2 != null ? access$getDateString$p(this, localMessage2) : null;
            if ((!Intrinsics.areEqual(access$getDateString$p, localMessage != null ? access$getDateString$p(this, localMessage) : null)) && access$getDateString$p != null) {
                str = access$getDateString$p;
            }
            ChannelItem.GroupFlags groupFlags = new ChannelItem.GroupFlags(z4, z5, z7, str.length() > 0, z && z2, z && z3, i > 0 && i2 == i + -1, i > 0 && i2 == i);
            LocalMessage localMessage3 = message3.getLocalMessage();
            if (!(groupFlags.isAtUserGroupStart() || groupFlags.isAtDateGroupStart() || groupFlags.isAfterSystemMessage() || groupFlags.isFirstNewMessage())) {
                image2 = null;
            } else if (localMessage3.body instanceof MessageBody.SystemMessageBody.Platform.FromAvito) {
                image2 = this.c;
            } else {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t2 = null;
                        break;
                    }
                    T next = it.next();
                    if (Intrinsics.areEqual(localMessage3.fromId, next.getId())) {
                        t2 = next;
                        break;
                    }
                }
                T t3 = t2;
                if (t3 == null || (publicProfile2 = t3.getPublicProfile()) == null || (avatar2 = publicProfile2.getAvatar()) == null || (image3 = avatar2.getImage()) == null) {
                    Uri uri = Uri.EMPTY;
                    Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                    image2 = ImageKt.toImage(uri);
                } else {
                    image2 = image3;
                }
            }
            message3.setGroupFlags(groupFlags);
            message3.setAvatar(image2);
            arrayList.add(message3);
            i2++;
        }
        if (i > 0) {
            arrayList.add(ChannelItem.UnreadMessagesDivider.INSTANCE);
        }
        int max = Math.max(i, 0);
        int size = list.size();
        while (max < size) {
            ChannelItem.Message message4 = max < list.size() - 1 ? list3.get(max + 1) : null;
            ChannelItem.Message message5 = max > 0 ? list3.get(max - 1) : null;
            ChannelItem.Message message6 = list3.get(max);
            boolean z8 = (message6.getBodyOrBubble() instanceof ChannelItem.Message.BodyOrBubble.Bubble) || !(message6.getBodyOrBubble().getBody() instanceof MessageBody.SystemMessageBody.Text);
            boolean z9 = (message4 != null ? message4.getBodyOrBubble() : null) == null || (message4.getBodyOrBubble().getBody() instanceof MessageBody.SystemMessageBody.Text);
            boolean z10 = (message5 != null ? message5.getBodyOrBubble() : null) == null || (message5.getBodyOrBubble().getBody() instanceof MessageBody.SystemMessageBody.Text);
            boolean z11 = message4 == null || (Intrinsics.areEqual(message4.getLocalMessage().fromId, message6.getLocalMessage().fromId) ^ true);
            boolean z12 = message5 == null || (Intrinsics.areEqual(message5.getLocalMessage().fromId, message6.getLocalMessage().fromId) ^ true);
            boolean z13 = message6.getDate().length() > 0;
            LocalMessage localMessage4 = message6.getLocalMessage();
            LocalMessage localMessage5 = message5 != null ? message5.getLocalMessage() : null;
            String access$getDateString$p2 = localMessage5 != null ? access$getDateString$p(this, localMessage5) : null;
            if (!(!Intrinsics.areEqual(access$getDateString$p2, localMessage4 != null ? access$getDateString$p(this, localMessage4) : null)) || access$getDateString$p2 == null) {
                access$getDateString$p2 = str;
            }
            ChannelItem.GroupFlags groupFlags2 = new ChannelItem.GroupFlags(z11, z12, z13, access$getDateString$p2.length() > 0, z8 && z9, z8 && z10, i > 0 && max == i + -1, i > 0 && max == i);
            LocalMessage localMessage6 = message6.getLocalMessage();
            if (!(groupFlags2.isAtUserGroupStart() || groupFlags2.isAtDateGroupStart() || groupFlags2.isAfterSystemMessage() || groupFlags2.isFirstNewMessage())) {
                image = null;
            } else if (localMessage6.body instanceof MessageBody.SystemMessageBody.Platform.FromAvito) {
                image = this.c;
            } else {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it2.next();
                    if (Intrinsics.areEqual(localMessage6.fromId, t.getId())) {
                        break;
                    }
                }
                T t4 = t;
                if (t4 == null || (publicProfile = t4.getPublicProfile()) == null || (avatar = publicProfile.getAvatar()) == null || (image = avatar.getImage()) == null) {
                    Uri uri2 = Uri.EMPTY;
                    Intrinsics.checkNotNullExpressionValue(uri2, "Uri.EMPTY");
                    image = ImageKt.toImage(uri2);
                }
            }
            message6.setGroupFlags(groupFlags2);
            message6.setAvatar(image);
            arrayList.add(message6);
            max++;
            list3 = list;
        }
        return arrayList;
    }
}
