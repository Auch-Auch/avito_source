package com.avito.android.messenger.conversation.mvi.messages;

import arrow.core.Option;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2¼\u0002\u0010\t\u001a·\u0002\u0012<\u0012:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005 \u0006*\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005\u0018\u00010\u00010\u0001\u0012<\u0012:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005 \u0006*\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005\u0018\u00010\u00010\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \u0006*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0007 \u0006*\u0001\u0012<\u0012:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005 \u0006*\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005\u0018\u00010\u00010\u0001\u0012<\u0012:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005 \u0006*\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005\u0018\u00010\u00010\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \u0006*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0007\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lkotlin/Triple;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "kotlin.jvm.PlatformType", "Larrow/core/Option;", "", "<name for destructuring parameter 0>", "", "accept", "(Lkotlin/Triple;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToMessageUpdates$7<T> implements Consumer<Triple<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>, ? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>, ? extends Option<? extends Boolean>>> {
    public final /* synthetic */ MessageListPresenterImpl a;
    public final /* synthetic */ AtomicInteger b;

    public MessageListPresenterImpl$subscribeToMessageUpdates$7(MessageListPresenterImpl messageListPresenterImpl, AtomicInteger atomicInteger) {
        this.a = messageListPresenterImpl;
        this.b = atomicInteger;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Triple<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>, ? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>, ? extends Option<? extends Boolean>> triple) {
        accept((Triple<? extends List<Pair<LocalMessage, MessageMetaInfo>>, ? extends List<Pair<LocalMessage, MessageMetaInfo>>, ? extends Option<Boolean>>) triple);
    }

    public final void accept(Triple<? extends List<Pair<LocalMessage, MessageMetaInfo>>, ? extends List<Pair<LocalMessage, MessageMetaInfo>>, ? extends Option<Boolean>> triple) {
        int size;
        List list = (List) triple.component1();
        List list2 = (List) triple.component2();
        if (MessageListPresenterImpl.access$getDeps$p(this.a).getFeatures().getRequestMissingUsersForAvatars().invoke().booleanValue() && (size = list2.size() + list.size()) != this.b.get()) {
            Intrinsics.checkNotNullExpressionValue(list, "firstPage");
            Intrinsics.checkNotNullExpressionValue(list2, "prevPages");
            List<T> plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) list2);
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(plus, 10));
            for (T t : plus) {
                arrayList.add((LocalMessage) t.getFirst());
            }
            MessageListPresenterImpl messageListPresenterImpl = this.a;
            MessageListPresenterImpl.Event.SyncMissingUsersEvent syncMissingUsersEvent = MessageListPresenterImpl.Event.SyncMissingUsersEvent.INSTANCE;
            messageListPresenterImpl.dispatchCommand(new MessageListPresenterImpl$Event$SyncMissingUsersEvent$invoke$1(new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$7.1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).p;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                }
            }, arrayList));
            this.b.set(size);
        }
    }
}
