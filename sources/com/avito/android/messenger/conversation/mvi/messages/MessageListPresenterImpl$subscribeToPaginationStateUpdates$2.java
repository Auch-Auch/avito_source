package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.channels.mvi.common.v3.EventInstance;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0010\u001a¼\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\t \r*^\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\t\u0018\u00010\u0002j\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\f0\u0002j\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007`\f2\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;", "interactorState", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "deps", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventDispatchable;", "kotlin.jvm.PlatformType", "apply", "(Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State$FirstPageLoaded;)Lkotlin/jvm/functions/Function2;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToPaginationStateUpdates$2<T, R> implements Function<MessageListInteractor.State.FirstPageLoaded, Function2<? super Long, ? super MessageListPresenterImpl.EventDeps, ? extends EventInstance<MessageListPresenterImpl.Event, MessageListPresenterImpl.PartialState, MessageListPresenterImpl.EventDeps>>> {
    public final /* synthetic */ MessageListPresenterImpl a;

    public MessageListPresenterImpl$subscribeToPaginationStateUpdates$2(MessageListPresenterImpl messageListPresenterImpl) {
        this.a = messageListPresenterImpl;
    }

    public final Function2<Long, MessageListPresenterImpl.EventDeps, EventInstance<MessageListPresenterImpl.Event, MessageListPresenterImpl.PartialState, MessageListPresenterImpl.EventDeps>> apply(@NotNull MessageListInteractor.State.FirstPageLoaded firstPageLoaded) {
        Intrinsics.checkNotNullParameter(firstPageLoaded, "interactorState");
        MessageListInteractor.PaginationState paginationState = firstPageLoaded.getPaginationState();
        if (paginationState instanceof MessageListInteractor.PaginationState.InProgress) {
            MessageListPresenterImpl.Event.PaginationStart paginationStart = MessageListPresenterImpl.Event.PaginationStart.INSTANCE;
            return new MessageListPresenterImpl$Event$PaginationStart$invoke$1(false, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToPaginationStateUpdates$2.1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).p;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToPaginationStateUpdates$2.2
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).r;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToPaginationStateUpdates$2.3
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).q;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                }
            });
        } else if (paginationState instanceof MessageListInteractor.PaginationState.Error) {
            MessageListPresenterImpl.Event.PaginationError paginationError = MessageListPresenterImpl.Event.PaginationError.INSTANCE;
            return new MessageListPresenterImpl$Event$PaginationError$invoke$1(new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToPaginationStateUpdates$2.4
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).p;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToPaginationStateUpdates$2.5
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).r;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToPaginationStateUpdates$2.6
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).q;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                }
            });
        } else if (paginationState instanceof MessageListInteractor.PaginationState.Success) {
            MessageListPresenterImpl.Event.PaginationSuccess paginationSuccess = MessageListPresenterImpl.Event.PaginationSuccess.INSTANCE;
            return new MessageListPresenterImpl$Event$PaginationSuccess$invoke$1(((MessageListInteractor.PaginationState.Success) firstPageLoaded.getPaginationState()).getHasMorePages(), new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToPaginationStateUpdates$2.7
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).p;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToPaginationStateUpdates$2.8
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).r;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                }
            }, new MutablePropertyReference0Impl(this.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToPaginationStateUpdates$2.9
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return ((MessageListPresenterImpl) this.receiver).q;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                }
            });
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
