package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class n0<T> implements Consumer<MissingUsersSyncAgentImpl.RequestMissingUsersAction> {
    public final /* synthetic */ MissingUsersSyncAgentImpl a;

    public n0(MissingUsersSyncAgentImpl missingUsersSyncAgentImpl) {
        this.a = missingUsersSyncAgentImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(MissingUsersSyncAgentImpl.RequestMissingUsersAction requestMissingUsersAction) {
        MissingUsersSyncAgentImpl.RequestMissingUsersAction requestMissingUsersAction2 = requestMissingUsersAction;
        String tag = this.a.getTAG();
        Logs.debug$default(tag, "Sending RequestMissingUsersAction for execution " + requestMissingUsersAction2, null, 4, null);
        ReducerQueue reducerQueue = this.a.getReducerQueue();
        Intrinsics.checkNotNullExpressionValue(requestMissingUsersAction2, "action");
        reducerQueue.plusAssign(requestMissingUsersAction2);
    }
}
