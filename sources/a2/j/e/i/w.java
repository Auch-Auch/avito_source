package a2.j.e.i;

import com.google.firebase.iid.MessengerIpcClient;
public final /* synthetic */ class w implements Runnable {
    public final MessengerIpcClient.b a;

    public w(MessengerIpcClient.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c(2, "Service disconnected");
    }
}
