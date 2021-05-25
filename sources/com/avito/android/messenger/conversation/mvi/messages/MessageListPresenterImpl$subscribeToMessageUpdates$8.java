package com.avito.android.messenger.conversation.mvi.messages;

import arrow.core.Option;
import com.avito.android.messenger.channels.mvi.common.v3.EventInstance;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0018\u001a\u0003\u0012Á\u0001\b\u0001\u0012¼\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\u0012 \u0006*^\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\u0012\u0018\u00010\u000bj\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00150\u000bj\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0010`\u0015 \u0006*È\u0001\u0012Á\u0001\b\u0001\u0012¼\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\u0012 \u0006*^\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\u0012\u0018\u00010\u000bj\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00150\u000bj\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0010`\u0015\u0018\u00010\n0\n2\u0001\u0010\t\u001a\u0001\u0012<\u0012:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005 \u0006*\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005\u0018\u00010\u00010\u0001\u0012<\u0012:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005 \u0006*\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005\u0018\u00010\u00010\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \u0006*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00070\u0000H\n¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"Lkotlin/Triple;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageAndMetaInfo;", "kotlin.jvm.PlatformType", "Larrow/core/Option;", "", "<name for destructuring parameter 0>", "Lio/reactivex/ObservableSource;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "deps", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventDispatchable;", "apply", "(Lkotlin/Triple;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToMessageUpdates$8<T, R> implements Function<Triple<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>, ? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>, ? extends Option<? extends Boolean>>, ObservableSource<? extends Function2<? super Long, ? super MessageListPresenterImpl.EventDeps, ? extends EventInstance<MessageListPresenterImpl.Event, MessageListPresenterImpl.PartialState, MessageListPresenterImpl.EventDeps>>>> {
    public final /* synthetic */ MessageListPresenterImpl a;
    public final /* synthetic */ AtomicBoolean b;

    public MessageListPresenterImpl$subscribeToMessageUpdates$8(MessageListPresenterImpl messageListPresenterImpl, AtomicBoolean atomicBoolean) {
        this.a = messageListPresenterImpl;
        this.b = atomicBoolean;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ ObservableSource<? extends Function2<? super Long, ? super MessageListPresenterImpl.EventDeps, ? extends EventInstance<MessageListPresenterImpl.Event, MessageListPresenterImpl.PartialState, MessageListPresenterImpl.EventDeps>>> apply(Triple<? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>, ? extends List<? extends Pair<? extends LocalMessage, ? extends MessageMetaInfo>>, ? extends Option<? extends Boolean>> triple) {
        return apply((Triple<? extends List<Pair<LocalMessage, MessageMetaInfo>>, ? extends List<Pair<LocalMessage, MessageMetaInfo>>, ? extends Option<Boolean>>) triple);
    }

    public final ObservableSource<? extends Function2<Long, MessageListPresenterImpl.EventDeps, EventInstance<MessageListPresenterImpl.Event, MessageListPresenterImpl.PartialState, MessageListPresenterImpl.EventDeps>>> apply(@NotNull Triple<? extends List<Pair<LocalMessage, MessageMetaInfo>>, ? extends List<Pair<LocalMessage, MessageMetaInfo>>, ? extends Option<Boolean>> triple) {
        Intrinsics.checkNotNullParameter(triple, "<name for destructuring parameter 0>");
        List list = (List) triple.component1();
        List list2 = (List) triple.component2();
        Option option = (Option) triple.component3();
        Intrinsics.checkNotNullExpressionValue(list, "firstPage");
        Intrinsics.checkNotNullExpressionValue(list2, "prevPages");
        List distinct = CollectionsKt___CollectionsKt.distinct(CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) list2));
        if (!distinct.isEmpty()) {
            MessageListPresenterImpl.Event.MessagesLoadedNonEmpty messagesLoadedNonEmpty = MessageListPresenterImpl.Event.MessagesLoadedNonEmpty.INSTANCE;
            Observable just = Observable.just(new MessageListPresenterImpl$Event$MessagesLoadedNonEmpty$invoke$1(distinct, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8.1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).o;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).o = (MessageListPresenterImpl.PartialState.Meta) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8.2
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).p;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8.3
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).q;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8.4
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).r;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                }
            }));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            boolean z = false;
            if (list.size() < 100 && list2.isEmpty() && option.isDefined() && this.b.compareAndSet(false, true) && Intrinsics.areEqual((Boolean) option.orNull(), Boolean.TRUE)) {
                z = true;
            }
            if (!z) {
                return just;
            }
            MessageListPresenterImpl.Event.PaginationStart paginationStart = MessageListPresenterImpl.Event.PaginationStart.INSTANCE;
            Observable just2 = Observable.just(new MessageListPresenterImpl$Event$PaginationStart$invoke$1(true, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8$5$1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).p;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8$5$2
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).r;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8$5$3
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).q;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                }
            }));
            Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(this)");
            Observable<T> concatWith = just.concatWith(just2);
            Intrinsics.checkNotNullExpressionValue(concatWith, "concatWith(\n            …                        )");
            return concatWith;
        }
        MessageListPresenterImpl.Event.MessagesLoadedEmpty messagesLoadedEmpty = MessageListPresenterImpl.Event.MessagesLoadedEmpty.INSTANCE;
        Observable just3 = Observable.just(new MessageListPresenterImpl$Event$MessagesLoadedEmpty$invoke$1(new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8.6
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return ((MessageListPresenterImpl) this.receiver).q;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
            }
        }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8.7
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return ((MessageListPresenterImpl) this.receiver).r;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
            }
        }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageUpdates$8.8
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return ((MessageListPresenterImpl) this.receiver).s;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                ((MessageListPresenterImpl) this.receiver).s = (MessageListPresenterImpl.PartialState.List.Bottom) obj;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(just3, "Observable.just(this)");
        return just3;
    }
}
