package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class d0<T> implements Predicate<MissingUsersSyncAgentImpl.RequestMissingUsers> {
    public final /* synthetic */ String a;

    public d0(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(MissingUsersSyncAgentImpl.RequestMissingUsers requestMissingUsers) {
        MissingUsersSyncAgentImpl.RequestMissingUsers requestMissingUsers2 = requestMissingUsers;
        Intrinsics.checkNotNullParameter(requestMissingUsers2, "it");
        return Intrinsics.areEqual(requestMissingUsers2.getUserId(), this.a);
    }
}
