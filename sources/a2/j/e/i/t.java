package a2.j.e.i;

import com.google.firebase.iid.MessengerIpcClient;
public final /* synthetic */ class t implements Runnable {
    public final MessengerIpcClient.b a;

    public t(MessengerIpcClient.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessengerIpcClient.b bVar = this.a;
        synchronized (bVar) {
            if (bVar.a == 1) {
                bVar.c(1, "Timed out while binding");
            }
        }
    }
}
