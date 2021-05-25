package a2.a.a.o1.c;

import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgent;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<ChannelSyncOnPushAgent.State, Boolean> {
    public static final d a = new d();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(ChannelSyncOnPushAgent.State state) {
        ChannelSyncOnPushAgent.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "it");
        return Boolean.valueOf(state2.getUnprocessedRequestsCount() > 0);
    }
}
