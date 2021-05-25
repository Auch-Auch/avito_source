package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class m0<T, R> implements Function<String, ObservableSource<? extends MissingUsersSyncAgentImpl.RequestMissingUsersAction>> {
    public final /* synthetic */ MissingUsersSyncAgentImpl a;

    public m0(MissingUsersSyncAgentImpl missingUsersSyncAgentImpl) {
        this.a = missingUsersSyncAgentImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends MissingUsersSyncAgentImpl.RequestMissingUsersAction> apply(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
        return this.a.p.doOnNext(new c0(this, str2)).filter(new d0(str2)).map(new e0(this)).groupBy(f0.a).flatMap(new l0(this, str2));
    }
}
