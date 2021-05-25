package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class k0<T, R> implements Function<MissingUsersSyncAgentImpl.ThrottleState, MissingUsersSyncAgentImpl.RequestMissingUsersAction> {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ String b;

    public k0(l0 l0Var, String str) {
        this.a = l0Var;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MissingUsersSyncAgentImpl.RequestMissingUsersAction apply(MissingUsersSyncAgentImpl.ThrottleState throttleState) {
        MissingUsersSyncAgentImpl.ThrottleState throttleState2 = throttleState;
        Intrinsics.checkNotNullParameter(throttleState2, "state");
        l0 l0Var = this.a;
        MissingUsersSyncAgentImpl missingUsersSyncAgentImpl = l0Var.a.a;
        String str = l0Var.b;
        Intrinsics.checkNotNullExpressionValue(str, ChannelContext.Item.USER_ID);
        return new MissingUsersSyncAgentImpl.RequestMissingUsersAction(missingUsersSyncAgentImpl, str, this.b, throttleState2.getIdsToRequest());
    }
}
