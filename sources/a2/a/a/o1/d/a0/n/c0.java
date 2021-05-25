package a2.a.a.o1.d.a0.n;

import a2.b.a.a.a;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class c0<T> implements Consumer<MissingUsersSyncAgentImpl.RequestMissingUsers> {
    public final /* synthetic */ m0 a;
    public final /* synthetic */ String b;

    public c0(m0 m0Var, String str) {
        this.a = m0Var;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(MissingUsersSyncAgentImpl.RequestMissingUsers requestMissingUsers) {
        MissingUsersSyncAgentImpl.RequestMissingUsers requestMissingUsers2 = requestMissingUsers;
        String tag = this.a.a.getTAG();
        StringBuilder Q = a.Q("Asking to request users from message list ", "userId = ");
        Q.append(this.b);
        Q.append(", channelId = ");
        Q.append(requestMissingUsers2.getChannelId());
        Q.append(", messageListSize = ");
        Q.append(requestMissingUsers2.getMessages().size());
        Q.append(' ');
        Logs.debug$default(tag, Q.toString(), null, 4, null);
    }
}
