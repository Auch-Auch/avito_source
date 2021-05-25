package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00050\u00052\"\u0010\u0004\u001a\u001e\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u00030\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lio/reactivex/observables/GroupedObservable;", "", "kotlin.jvm.PlatformType", "Lru/avito/messenger/api/entity/event/ChatTypingEvent;", "typingEventsByUserId", "Lio/reactivex/CompletableSource;", "apply", "(Lio/reactivex/observables/GroupedObservable;)Lio/reactivex/CompletableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$subscribeToChatTypingEvents$3<T, R> implements Function<GroupedObservable<String, ChatTypingEvent>, CompletableSource> {
    public final /* synthetic */ ChannelContextInteractorImpl a;

    public ChannelContextInteractorImpl$subscribeToChatTypingEvents$3(ChannelContextInteractorImpl channelContextInteractorImpl) {
        this.a = channelContextInteractorImpl;
    }

    public final CompletableSource apply(@NotNull GroupedObservable<String, ChatTypingEvent> groupedObservable) {
        Intrinsics.checkNotNullParameter(groupedObservable, "typingEventsByUserId");
        return groupedObservable.switchMapCompletable(new Function<ChatTypingEvent, CompletableSource>(this) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$subscribeToChatTypingEvents$3.1
            public final /* synthetic */ ChannelContextInteractorImpl$subscribeToChatTypingEvents$3 a;

            {
                this.a = r1;
            }

            public final CompletableSource apply(@NotNull final ChatTypingEvent chatTypingEvent) {
                Intrinsics.checkNotNullParameter(chatTypingEvent, "typingEvent");
                return Completable.fromAction(new Action(this) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl.subscribeToChatTypingEvents.3.1.1
                    public final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = r1;
                    }

                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        this.a.a.a.getReducerQueue().plusAssign(new ChannelContextInteractorImpl.ChatTypingStartMutator(this.a.a.a, chatTypingEvent.getFromId()));
                    }
                }).andThen(Completable.complete().delay(3000, TimeUnit.MILLISECONDS, this.a.a.getSchedulers().computation())).andThen(Completable.fromAction(new Action(this) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl.subscribeToChatTypingEvents.3.1.2
                    public final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = r1;
                    }

                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        this.a.a.a.getReducerQueue().plusAssign(new ChannelContextInteractorImpl.ChatTypingStopMutator(this.a.a.a, chatTypingEvent.getFromId()));
                    }
                }));
            }
        });
    }
}
