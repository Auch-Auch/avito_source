package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationMessageDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationMessageParamsDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.MessageDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.SenderTypeDomain;
import ru.sravni.android.bankproduct.utils.date.DateUtilKt;
import t6.n.d;
import t6.n.e;
import t6.n.q;
import t6.n.s;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b$\u0010%J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001c\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\"\u0010 ¨\u0006&"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageContainer;", "", "", "isConsistienceCorrect", "()Z", "", AnalyticFieldsName.orderId, "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "findChatViewCrad", "(Ljava/lang/Integer;)Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "newCard", "formContainer", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;)Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageContainer;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/ConversationMessageDomain;", "conversationMessages", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatDiff;", "countDiff", "(Ljava/util/List;)Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatDiff;", "Lru/sravni/android/bankproduct/domain/chat/entity/SenderTypeDomain;", "own", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageEnum;", AuthSource.SEND_ABUSE, "(Lru/sravni/android/bankproduct/domain/chat/entity/SenderTypeDomain;)Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageEnum;", "c", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatDiff;", "getChatDiff", "()Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatDiff;", "chatDiff", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getSourceMessages", "()Ljava/util/List;", "sourceMessages", "getResultMessages", "resultMessages", "<init>", "(Ljava/util/List;Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatDiff;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MessageContainer {
    @NotNull
    public final List<ChatViewCard> a;
    @NotNull
    public final List<ChatViewCard> b;
    @NotNull
    public final ChatDiff c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SenderTypeDomain.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            SenderTypeDomain senderTypeDomain = SenderTypeDomain.USER;
            iArr[0] = 1;
            SenderTypeDomain senderTypeDomain2 = SenderTypeDomain.DOCUMENT;
            iArr[2] = 2;
        }
    }

    public MessageContainer(@NotNull List<ChatViewCard> list, @NotNull ChatDiff chatDiff) {
        Intrinsics.checkParameterIsNotNull(list, "sourceMessages");
        Intrinsics.checkParameterIsNotNull(chatDiff, "chatDiff");
        this.b = list;
        this.c = chatDiff;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : list) {
            linkedHashMap.put(Integer.valueOf(t.getOrderId()), t);
        }
        if (!this.c.isEmpty()) {
            for (T t2 : this.c.getMutated()) {
                linkedHashMap.put(Integer.valueOf(t2.getOrderId()), t2);
            }
            Iterator<T> it = this.c.getRemoved().iterator();
            while (it.hasNext()) {
                linkedHashMap.remove(Integer.valueOf(it.next().intValue()));
            }
            for (T t3 : this.c.getAddedToEnd()) {
                linkedHashMap.put(Integer.valueOf(t3.getOrderId()), t3);
            }
        }
        List<Pair> list2 = s.toList(q.toSortedMap(linkedHashMap));
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
        for (Pair pair : list2) {
            arrayList.add((ChatViewCard) pair.getSecond());
        }
        this.a = arrayList;
    }

    public final ViewHolderMessageEnum a(SenderTypeDomain senderTypeDomain) {
        int ordinal = senderTypeDomain.ordinal();
        if (ordinal == 0) {
            return ViewHolderMessageEnum.USER;
        }
        if (ordinal != 2) {
            return ViewHolderMessageEnum.SRAVNI;
        }
        return ViewHolderMessageEnum.DOCUMENT;
    }

    @NotNull
    public final ChatDiff countDiff(@NotNull List<ConversationMessageDomain> list) {
        Boolean disableRollback;
        Boolean disableRollback2;
        Intrinsics.checkParameterIsNotNull(list, "conversationMessages");
        List<ChatViewCard> list2 = this.a;
        ArrayList<ChatViewCard> arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.getType() == ViewHolderMessageEnum.BOT_FACE) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ChatViewCard chatViewCard : arrayList) {
            linkedHashMap.put(Integer.valueOf(chatViewCard.getOrderId()), new Pair(chatViewCard, null));
        }
        for (T t : list) {
            Pair pair = (Pair) linkedHashMap.get(Integer.valueOf(t.getMessageOrderId()));
            if (pair == null) {
                linkedHashMap.put(Integer.valueOf(t.getMessageOrderId()), new Pair(null, t));
            } else {
                linkedHashMap.put(Integer.valueOf(t.getMessageOrderId()), new Pair(pair.getFirst(), t));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Set<Number> keySet = linkedHashMap.keySet();
        Intrinsics.checkExpressionValueIsNotNull(keySet, "diffCountSet.keys");
        for (Number number : keySet) {
            Pair pair2 = (Pair) linkedHashMap.get(Integer.valueOf(number.intValue()));
            ChatViewCard chatViewCard2 = pair2 != null ? (ChatViewCard) pair2.getFirst() : null;
            ConversationMessageDomain conversationMessageDomain = pair2 != null ? (ConversationMessageDomain) pair2.getSecond() : null;
            if (chatViewCard2 == null && conversationMessageDomain != null) {
                ViewHolderMessageEnum a3 = a(conversationMessageDomain.getSender());
                int messageOrderId = conversationMessageDomain.getMessageOrderId();
                String text = conversationMessageDomain.getText();
                List<MessageDomain> message = conversationMessageDomain.getMessage();
                ViewHolderMessageStatusEnum viewHolderMessageStatusEnum = ViewHolderMessageStatusEnum.SUCCESS;
                ConversationMessageParamsDomain conversationMessageParamsDomain = conversationMessageDomain.getConversationMessageParamsDomain();
                boolean booleanValue = (conversationMessageParamsDomain == null || (disableRollback2 = conversationMessageParamsDomain.getDisableRollback()) == null) ? false : disableRollback2.booleanValue();
                Date createdTime = conversationMessageDomain.getCreatedTime();
                arrayList2.add(new ChatViewCard(a3, messageOrderId, text, message, viewHolderMessageStatusEnum, null, booleanValue, createdTime != null ? DateUtilKt.toChatCreatedTime(createdTime) : null, 32, null));
            }
            if (chatViewCard2 != null && conversationMessageDomain == null) {
                arrayList3.add(Integer.valueOf(chatViewCard2.getOrderId()));
            }
            if (!(chatViewCard2 == null || conversationMessageDomain == null)) {
                if ((!Intrinsics.areEqual(chatViewCard2.getText(), conversationMessageDomain.getText())) || chatViewCard2.getStatus() != ViewHolderMessageStatusEnum.SUCCESS) {
                    ViewHolderMessageEnum a4 = a(conversationMessageDomain.getSender());
                    int messageOrderId2 = conversationMessageDomain.getMessageOrderId();
                    String text2 = conversationMessageDomain.getText();
                    List<MessageDomain> message2 = conversationMessageDomain.getMessage();
                    ViewHolderMessageStatusEnum viewHolderMessageStatusEnum2 = ViewHolderMessageStatusEnum.SUCCESS;
                    ConversationMessageParamsDomain conversationMessageParamsDomain2 = conversationMessageDomain.getConversationMessageParamsDomain();
                    boolean booleanValue2 = (conversationMessageParamsDomain2 == null || (disableRollback = conversationMessageParamsDomain2.getDisableRollback()) == null) ? false : disableRollback.booleanValue();
                    Date createdTime2 = conversationMessageDomain.getCreatedTime();
                    arrayList4.add(new ChatViewCard(a4, messageOrderId2, text2, message2, viewHolderMessageStatusEnum2, null, booleanValue2, createdTime2 != null ? DateUtilKt.toChatCreatedTime(createdTime2) : null, 32, null));
                }
            }
        }
        return new ChatDiff(arrayList3, arrayList2, arrayList4);
    }

    @Nullable
    public final ChatViewCard findChatViewCrad(@Nullable Integer num) {
        T t;
        boolean z;
        Iterator<T> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            int orderId = t.getOrderId();
            if (num != null && orderId == num.intValue()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return t;
    }

    @NotNull
    public final MessageContainer formContainer(@Nullable ChatViewCard chatViewCard) {
        ChatViewCard findChatViewCrad = findChatViewCrad(chatViewCard != null ? Integer.valueOf(chatViewCard.getOrderId()) : null);
        if (!(findChatViewCrad == null && chatViewCard == null)) {
            if (findChatViewCrad == null && chatViewCard != null) {
                return new MessageContainer(this.a, new ChatDiff(null, d.listOf(chatViewCard), null, 5, null));
            }
            if (!(findChatViewCrad == null || chatViewCard == null)) {
                return new MessageContainer(this.a, new ChatDiff(null, null, d.listOf(chatViewCard), 3, null));
            }
        }
        return this;
    }

    @NotNull
    public final ChatDiff getChatDiff() {
        return this.c;
    }

    @NotNull
    public final List<ChatViewCard> getResultMessages() {
        return this.a;
    }

    @NotNull
    public final List<ChatViewCard> getSourceMessages() {
        return this.b;
    }

    public final boolean isConsistienceCorrect() {
        T t;
        List<ChatViewCard> addedToEnd = this.c.getAddedToEnd();
        if (addedToEnd == null || addedToEnd.isEmpty()) {
            List<Integer> removed = this.c.getRemoved();
            if (removed == null || removed.isEmpty()) {
                return true;
            }
        }
        Iterator<T> it = this.c.getAddedToEnd().iterator();
        T t2 = null;
        if (!it.hasNext()) {
            t = null;
        } else {
            t = it.next();
            if (it.hasNext()) {
                int orderId = t.getOrderId();
                do {
                    T next = it.next();
                    int orderId2 = next.getOrderId();
                    if (orderId > orderId2) {
                        t = next;
                        orderId = orderId2;
                    }
                } while (it.hasNext());
            }
        }
        T t3 = t;
        int i = -1;
        int orderId3 = t3 != null ? t3.getOrderId() : -1;
        Iterator<T> it2 = this.b.iterator();
        if (it2.hasNext()) {
            t2 = it2.next();
            if (it2.hasNext()) {
                int orderId4 = t2.getOrderId();
                do {
                    T next2 = it2.next();
                    int orderId5 = next2.getOrderId();
                    if (orderId4 < orderId5) {
                        t2 = next2;
                        orderId4 = orderId5;
                    }
                } while (it2.hasNext());
            }
        }
        T t4 = t2;
        int orderId6 = t4 != null ? t4.getOrderId() : -1;
        if (orderId3 < orderId6) {
            return false;
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.max((Iterable<? extends Comparable>) this.c.getRemoved());
        if (num != null) {
            i = num.intValue();
        }
        return i <= orderId6;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageContainer(List list, ChatDiff chatDiff, int i, j jVar) {
        this(list, (i & 2) != 0 ? new ChatDiff(null, null, null, 7, null) : chatDiff);
    }
}
