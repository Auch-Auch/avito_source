package a2.j.e.i;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.firebase.iid.MessengerIpcClient;
import java.util.Objects;
public final /* synthetic */ class s implements Handler.Callback {
    public final MessengerIpcClient.b a;

    public s(MessengerIpcClient.b bVar) {
        this.a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        MessengerIpcClient.e<?> eVar;
        MessengerIpcClient.b bVar = this.a;
        Objects.requireNonNull(bVar);
        int i = message.arg1;
        Log.isLoggable("MessengerIpcClient", 3);
        synchronized (bVar) {
            eVar = bVar.e.get(i);
            if (eVar == null) {
                return true;
            }
            bVar.e.remove(i);
            bVar.e();
        }
        Bundle data = message.getData();
        if (data.getBoolean(MessengerIpcClient.KEY_UNSUPPORTED, false)) {
            eVar.a(new MessengerIpcClient.RequestFailedException(4, "Not supported by GmsCore"));
            return true;
        }
        eVar.c(data);
        return true;
    }
}
