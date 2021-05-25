package com.avito.android.messenger.channels.mvi.sync;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "error", "", "accept", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2<T> implements Consumer<Throwable> {
    public final /* synthetic */ String a;

    public ChannelsBackendNotificationsHandlerImpl$subscribeAndLogErrors$2(String str) {
        this.a = str;
    }

    public final void accept(Throwable th) {
        Logs.error("ChannelsBackendNotificationsHandler", this.a + " events subscription encountered an error!", th);
    }
}
