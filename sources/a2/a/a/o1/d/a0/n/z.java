package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgentImpl;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class z<V> implements Callable<Object> {
    public final /* synthetic */ MessageSyncAgentImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;

    public z(MessageSyncAgentImpl messageSyncAgentImpl, String str, String str2, List list) {
        this.a = messageSyncAgentImpl;
        this.b = str;
        this.c = str2;
        this.d = list;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        this.a.o.syncMissingUsers(this.b, this.c, this.d);
        return Unit.INSTANCE;
    }
}
