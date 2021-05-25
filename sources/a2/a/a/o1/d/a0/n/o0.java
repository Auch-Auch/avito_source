package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class o0<T> implements Consumer<Throwable> {
    public final /* synthetic */ MissingUsersSyncAgentImpl a;

    public o0(MissingUsersSyncAgentImpl missingUsersSyncAgentImpl) {
        this.a = missingUsersSyncAgentImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.debug(this.a.getTAG(), "Something has broken in subscribeToMissingUsersRequests", th);
    }
}
