package com.avito.android.messenger.conversation.mvi.messages;

import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "recovered", "", "accept", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageListInteractorImpl$subscribeToReconnects$1<T> implements Consumer<Boolean> {
    public final /* synthetic */ MessageListInteractorImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public MessageListInteractorImpl$subscribeToReconnects$1(MessageListInteractorImpl messageListInteractorImpl, String str, String str2) {
        this.a = messageListInteractorImpl;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Boolean bool) {
        Relay relay = this.a.getMutatorsRelay();
        String str = this.b;
        String str2 = this.c;
        Intrinsics.checkNotNullExpressionValue(bool, "recovered");
        AutoRefreshAction autoRefreshAction = new AutoRefreshAction(str, str2, bool.booleanValue(), this.a.c());
        relay.accept(new MutatorSingle(autoRefreshAction.getName(), new MessageListInteractorImpl$subscribeToReconnects$1$$special$$inlined$plusAssign$1(autoRefreshAction)));
    }
}
