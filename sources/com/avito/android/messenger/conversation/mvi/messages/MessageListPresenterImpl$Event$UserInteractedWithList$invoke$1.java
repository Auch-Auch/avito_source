package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenterImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KMutableProperty0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "id", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;", "deps", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UserInteractedWithList$Instance;", "invoke", "(JLcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$EventDeps;)Lcom/avito/android/messenger/conversation/mvi/messages/MessageListPresenterImpl$Event$UserInteractedWithList$Instance;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListPresenterImpl$Event$UserInteractedWithList$invoke$1 extends Lambda implements Function2<Long, MessageListPresenterImpl.EventDeps, MessageListPresenterImpl.Event.UserInteractedWithList.Instance> {
    public final /* synthetic */ KMutableProperty0 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageListPresenterImpl$Event$UserInteractedWithList$invoke$1(KMutableProperty0 kMutableProperty0) {
        super(2);
        this.a = kMutableProperty0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ MessageListPresenterImpl.Event.UserInteractedWithList.Instance invoke(Long l, MessageListPresenterImpl.EventDeps eventDeps) {
        return invoke(l.longValue(), eventDeps);
    }

    @NotNull
    public final MessageListPresenterImpl.Event.UserInteractedWithList.Instance invoke(long j, @NotNull MessageListPresenterImpl.EventDeps eventDeps) {
        Intrinsics.checkNotNullParameter(eventDeps, "deps");
        return new MessageListPresenterImpl.Event.UserInteractedWithList.Instance(this.a, j, eventDeps);
    }
}
