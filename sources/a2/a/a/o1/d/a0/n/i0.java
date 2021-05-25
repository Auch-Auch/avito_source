package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.BiFunction;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import t6.n.z;
public final class i0<T1, T2, R> implements BiFunction<MissingUsersSyncAgentImpl.ThrottleState, MissingUsersSyncAgentImpl.ThrottleState, MissingUsersSyncAgentImpl.ThrottleState> {
    public final /* synthetic */ l0 a;

    public i0(l0 l0Var) {
        this.a = l0Var;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.BiFunction
    public MissingUsersSyncAgentImpl.ThrottleState apply(MissingUsersSyncAgentImpl.ThrottleState throttleState, MissingUsersSyncAgentImpl.ThrottleState throttleState2) {
        MissingUsersSyncAgentImpl.ThrottleState throttleState3 = throttleState;
        MissingUsersSyncAgentImpl.ThrottleState throttleState4 = throttleState2;
        Intrinsics.checkNotNullParameter(throttleState3, "prevState");
        Intrinsics.checkNotNullParameter(throttleState4, "newState");
        long timestamp = throttleState4.getTimestamp() - throttleState3.getTimestamp();
        if (timestamp >= 5000) {
            String tag = this.a.a.a.getTAG();
            Logs.debug$default(tag, timestamp + "ms since prev request. All ids will be requested. NewIds = " + throttleState4.getIdsToRequest(), null, 4, null);
            return new MissingUsersSyncAgentImpl.ThrottleState(throttleState4.getTimestamp(), throttleState4.getIdsToRequest(), throttleState4.getIdsToRequest());
        }
        Set minus = z.minus((Set) throttleState4.getIdsToRequest(), (Iterable) throttleState3.getAlreadyRequestedIds());
        String tag2 = this.a.a.a.getTAG();
        Logs.debug$default(tag2, timestamp + "ms since prev request. Only new ids for 5000ms interval will be requested. NewIds = " + minus, null, 4, null);
        return new MissingUsersSyncAgentImpl.ThrottleState(throttleState3.getTimestamp(), z.plus((Set) throttleState3.getAlreadyRequestedIds(), (Iterable) throttleState4.getIdsToRequest()), minus);
    }
}
