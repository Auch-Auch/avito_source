package com.avito.android.messenger.conversation.mvi.sync;

import io.reactivex.functions.Action;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageSyncAgentImpl$loadIncompleteMessageBodies$1 implements Action {
    public final /* synthetic */ MessageSyncAgentImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public MessageSyncAgentImpl$loadIncompleteMessageBodies$1(MessageSyncAgentImpl messageSyncAgentImpl, String str, String str2, String str3) {
        this.a = messageSyncAgentImpl;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.a.k.scheduleIncompleteMessageBodyLoading(this.b, this.c, this.d);
    }
}
