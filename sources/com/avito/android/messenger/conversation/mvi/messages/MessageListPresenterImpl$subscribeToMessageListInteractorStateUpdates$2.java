package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.channels.mvi.common.v3.EventInstance;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0012\u001a\u0003\u0012¿\u0001\u0012¼\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\f \u0002*^\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\f\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000f0\u0005j\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n`\u000f \u0002*Æ\u0001\u0012¿\u0001\u0012¼\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\f \u0002*^\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\f\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000f0\u0005j\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n`\u000f\u0018\u00010\u00040\u00042\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lio/reactivex/Observable;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListInteractor$State;", "kotlin.jvm.PlatformType", "obs", "Lio/reactivex/ObservableSource;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "deps", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventInstance;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$PartialState;", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventDispatchable;", "apply", "(Lio/reactivex/Observable;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2<T, R> implements Function<Observable<MessageListInteractor.State>, ObservableSource<Function2<? super Long, ? super MessageListPresenterImpl.EventDeps, ? extends EventInstance<MessageListPresenterImpl.Event, MessageListPresenterImpl.PartialState, MessageListPresenterImpl.EventDeps>>>> {
    public final /* synthetic */ MessageListPresenterImpl a;
    public final /* synthetic */ Scheduler b;

    public MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2(MessageListPresenterImpl messageListPresenterImpl, Scheduler scheduler) {
        this.a = messageListPresenterImpl;
        this.b = scheduler;
    }

    public final ObservableSource<Function2<Long, MessageListPresenterImpl.EventDeps, EventInstance<MessageListPresenterImpl.Event, MessageListPresenterImpl.PartialState, MessageListPresenterImpl.EventDeps>>> apply(@NotNull Observable<MessageListInteractor.State> observable) {
        Intrinsics.checkNotNullParameter(observable, "obs");
        Observable<U> ofType = observable.ofType(MessageListInteractor.State.Empty.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Observable<U> ofType2 = observable.ofType(MessageListInteractor.State.FirstPageLoadError.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType2, "ofType(R::class.java)");
        Observable<U> ofType3 = observable.ofType(MessageListInteractor.State.FirstPageLoadingInProgress.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType3, "ofType(R::class.java)");
        MessageListPresenterImpl messageListPresenterImpl = this.a;
        Scheduler scheduler = this.b;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Observable<U> ofType4 = observable.ofType(MessageListInteractor.State.FirstPageLoaded.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType4, "ofType(R::class.java)");
        Observable<R> subscribeOn = ofType4.observeOn(scheduler).map(MessageListPresenterImpl$subscribeToMessageUpdates$1.INSTANCE).distinctUntilChanged().switchMap(new MessageListPresenterImpl$subscribeToMessageUpdates$2(scheduler)).subscribeOn(scheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "ofType<MessageListIntera…  .subscribeOn(scheduler)");
        Observable<U> ofType5 = observable.ofType(MessageListInteractor.State.FirstPageLoaded.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType5, "ofType(R::class.java)");
        Observable<R> subscribeOn2 = ofType5.observeOn(scheduler).map(MessageListPresenterImpl$subscribeToMessageUpdates$3.INSTANCE).distinctUntilChanged().switchMap(new MessageListPresenterImpl$subscribeToMessageUpdates$4(scheduler)).startWith((Observable<R>) ((R) CollectionsKt__CollectionsKt.emptyList())).subscribeOn(scheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn2, "ofType<MessageListIntera…  .subscribeOn(scheduler)");
        Observable<U> ofType6 = observable.ofType(MessageListInteractor.State.FirstPageLoaded.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType6, "ofType(R::class.java)");
        Observable<R> subscribeOn3 = ofType6.observeOn(scheduler).map(MessageListPresenterImpl$subscribeToMessageUpdates$5.INSTANCE).distinctUntilChanged().takeUntil(MessageListPresenterImpl$subscribeToMessageUpdates$6.INSTANCE).subscribeOn(scheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn3, "ofType<MessageListIntera…  .subscribeOn(scheduler)");
        Observable combineLatest = Observable.combineLatest(subscribeOn, subscribeOn2, subscribeOn3, new Function3<T1, T2, T3, R>() { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2$subscribeToMessageUpdates$$inlined$combineLatestWith$1
            @Override // io.reactivex.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                Intrinsics.checkNotNullParameter(t3, "t3");
                return (R) new Triple(t1, t2, t3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…neFunction(t1, t2, t3) })");
        Observable<R> subscribeOn4 = combineLatest.doOnNext(new MessageListPresenterImpl$subscribeToMessageUpdates$7(messageListPresenterImpl, atomicInteger)).concatMap(new MessageListPresenterImpl$subscribeToMessageUpdates$8(messageListPresenterImpl, atomicBoolean)).subscribeOn(scheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn4, "ofType<MessageListIntera…  .subscribeOn(scheduler)");
        MessageListPresenterImpl messageListPresenterImpl2 = this.a;
        Observable<U> ofType7 = observable.ofType(MessageListInteractor.State.FirstPageLoaded.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType7, "ofType(R::class.java)");
        Observable<R> map = ofType7.distinctUntilChanged(MessageListPresenterImpl$subscribeToPaginationStateUpdates$1.INSTANCE).map(new MessageListPresenterImpl$subscribeToPaginationStateUpdates$2(messageListPresenterImpl2));
        Intrinsics.checkNotNullExpressionValue(map, "ofType<MessageListIntera….exhaustive\n            }");
        return Observable.merge(CollectionsKt__CollectionsKt.listOf((Object[]) new Observable[]{ofType.map(new Function<MessageListInteractor.State.Empty, Function2<? super Long, ? super MessageListPresenterImpl.EventDeps, ? extends MessageListPresenterImpl.Event.MessagesLoadedEmpty.Instance>>(this) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2.1
            public final /* synthetic */ MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2 a;

            {
                this.a = r1;
            }

            public final Function2<Long, MessageListPresenterImpl.EventDeps, MessageListPresenterImpl.Event.MessagesLoadedEmpty.Instance> apply(@NotNull MessageListInteractor.State.Empty empty) {
                Intrinsics.checkNotNullParameter(empty, "it");
                MessageListPresenterImpl.Event.MessagesLoadedEmpty messagesLoadedEmpty = MessageListPresenterImpl.Event.MessagesLoadedEmpty.INSTANCE;
                return new MessageListPresenterImpl$Event$MessagesLoadedEmpty$invoke$1(new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.1.1
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).q;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                    }
                }, new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.1.2
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).r;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                    }
                }, new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.1.3
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).s;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).s = (MessageListPresenterImpl.PartialState.List.Bottom) obj;
                    }
                });
            }
        }), ofType2.map(new Function<MessageListInteractor.State.FirstPageLoadError, Function2<? super Long, ? super MessageListPresenterImpl.EventDeps, ? extends MessageListPresenterImpl.Event.MessagesLoadingError.Instance>>(this) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2.2
            public final /* synthetic */ MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2 a;

            {
                this.a = r1;
            }

            public final Function2<Long, MessageListPresenterImpl.EventDeps, MessageListPresenterImpl.Event.MessagesLoadingError.Instance> apply(@NotNull MessageListInteractor.State.FirstPageLoadError firstPageLoadError) {
                Intrinsics.checkNotNullParameter(firstPageLoadError, "it");
                MessageListPresenterImpl.Event.MessagesLoadingError messagesLoadingError = MessageListPresenterImpl.Event.MessagesLoadingError.INSTANCE;
                return new MessageListPresenterImpl$Event$MessagesLoadingError$invoke$1(new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.2.1
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).q;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                    }
                }, new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.2.2
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).r;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                    }
                }, new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.2.3
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).s;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).s = (MessageListPresenterImpl.PartialState.List.Bottom) obj;
                    }
                });
            }
        }), ofType3.map(new Function<MessageListInteractor.State.FirstPageLoadingInProgress, Function2<? super Long, ? super MessageListPresenterImpl.EventDeps, ? extends MessageListPresenterImpl.Event.MessagesLoadingStart.Instance>>(this) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2.3
            public final /* synthetic */ MessageListPresenterImpl$subscribeToMessageListInteractorStateUpdates$2 a;

            {
                this.a = r1;
            }

            public final Function2<Long, MessageListPresenterImpl.EventDeps, MessageListPresenterImpl.Event.MessagesLoadingStart.Instance> apply(@NotNull MessageListInteractor.State.FirstPageLoadingInProgress firstPageLoadingInProgress) {
                Intrinsics.checkNotNullParameter(firstPageLoadingInProgress, "it");
                MessageListPresenterImpl.Event.MessagesLoadingStart messagesLoadingStart = MessageListPresenterImpl.Event.MessagesLoadingStart.INSTANCE;
                return new MessageListPresenterImpl$Event$MessagesLoadingStart$invoke$1(false, new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.3.1
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).p;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).p = (MessageListPresenterImpl.PartialState.Context) obj;
                    }
                }, new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.3.2
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).q;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).q = (MessageListPresenterImpl.PartialState.List.Top) obj;
                    }
                }, new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.3.3
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).r;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).r = (MessageListPresenterImpl.PartialState.List.Middle) obj;
                    }
                }, new MutablePropertyReference0Impl(this.a.a) { // from class: com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl.subscribeToMessageListInteractorStateUpdates.2.3.4
                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                    @Nullable
                    public Object get() {
                        return ((MessageListPresenterImpl) this.receiver).s;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                    public void set(@Nullable Object obj) {
                        ((MessageListPresenterImpl) this.receiver).s = (MessageListPresenterImpl.PartialState.List.Bottom) obj;
                    }
                });
            }
        }), subscribeOn4, map}));
    }
}
