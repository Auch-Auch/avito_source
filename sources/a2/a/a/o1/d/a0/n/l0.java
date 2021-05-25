package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class l0<T, R> implements Function<GroupedObservable<String, Pair<? extends String, ? extends Set<? extends String>>>, ObservableSource<? extends MissingUsersSyncAgentImpl.RequestMissingUsersAction>> {
    public final /* synthetic */ m0 a;
    public final /* synthetic */ String b;

    public l0(m0 m0Var, String str) {
        this.a = m0Var;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends MissingUsersSyncAgentImpl.RequestMissingUsersAction> apply(GroupedObservable<String, Pair<? extends String, ? extends Set<? extends String>>> groupedObservable) {
        GroupedObservable<String, Pair<? extends String, ? extends Set<? extends String>>> groupedObservable2 = groupedObservable;
        Intrinsics.checkNotNullParameter(groupedObservable2, "channelRequestObs");
        String key = groupedObservable2.getKey();
        if (key == null) {
            return Observable.empty();
        }
        return groupedObservable2.map(g0.a).timestamp().map(h0.a).scan(new i0(this)).filter(j0.a).map(new k0(this, key));
    }
}
