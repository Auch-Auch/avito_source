package a2.t.a.c;

import com.voximplant.sdk.internal.Client;
import com.voximplant.sdk.internal.proto.WSMessagePush;
public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ Client a;
    public final /* synthetic */ Client b;

    public /* synthetic */ w(Client client, Client client2) {
        this.a = client;
        this.b = client2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Client client = this.a;
        Client client2 = this.b;
        if (client.f.b == k0.LOGGED_IN) {
            while (!client2.k.isEmpty()) {
                WSMessagePush poll = client.k.poll();
                String requestUUID = poll != null ? poll.getRequestUUID() : null;
                if (requestUUID != null) {
                    client.d(requestUUID);
                }
                client.e.sendMessage(poll);
            }
        }
    }
}
