package a2.j.e.i;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.firebase.iid.MessengerIpcClient;
public final /* synthetic */ class u implements Runnable {
    public final MessengerIpcClient.b a;
    public final IBinder b;

    public u(MessengerIpcClient.b bVar, IBinder iBinder) {
        this.a = bVar;
        this.b = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessengerIpcClient.b bVar = this.a;
        IBinder iBinder = this.b;
        synchronized (bVar) {
            if (iBinder == null) {
                bVar.c(0, "Null service connection");
                return;
            }
            try {
                bVar.c = new MessengerIpcClient.c(iBinder);
                bVar.a = 2;
                MessengerIpcClient.this.b.execute(new v(bVar));
            } catch (RemoteException e) {
                bVar.c(0, e.getMessage());
            }
        }
    }
}
