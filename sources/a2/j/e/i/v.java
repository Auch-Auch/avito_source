package a2.j.e.i;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.iid.FirebaseIidMessengerCompat;
import com.google.firebase.iid.MessengerIpcClient;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public final /* synthetic */ class v implements Runnable {
    public final MessengerIpcClient.b a;

    public v(MessengerIpcClient.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessengerIpcClient.e<?> poll;
        MessengerIpcClient.b bVar = this.a;
        while (true) {
            synchronized (bVar) {
                if (bVar.a == 2) {
                    if (bVar.d.isEmpty()) {
                        bVar.e();
                        return;
                    }
                    poll = bVar.d.poll();
                    bVar.e.put(poll.a, poll);
                    MessengerIpcClient.this.b.schedule(new Runnable(bVar, poll) { // from class: a2.j.e.i.x
                        public final MessengerIpcClient.b a;
                        public final MessengerIpcClient.e b;

                        {
                            this.a = r1;
                            this.b = r2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            MessengerIpcClient.b bVar2 = this.a;
                            MessengerIpcClient.e eVar = this.b;
                            Objects.requireNonNull(bVar2);
                            int i = eVar.a;
                            synchronized (bVar2) {
                                MessengerIpcClient.e<?> eVar2 = bVar2.e.get(i);
                                if (eVar2 != null) {
                                    bVar2.e.remove(i);
                                    eVar2.a(new MessengerIpcClient.RequestFailedException(3, "Timed out waiting for response"));
                                    bVar2.e();
                                }
                            }
                        }
                    }, 30, TimeUnit.SECONDS);
                } else {
                    return;
                }
            }
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String.valueOf(poll).length();
            }
            Context context = MessengerIpcClient.this.a;
            Messenger messenger = bVar.b;
            Message obtain = Message.obtain();
            obtain.what = poll.c;
            obtain.arg1 = poll.a;
            obtain.replyTo = messenger;
            Bundle bundle = new Bundle();
            bundle.putBoolean(MessengerIpcClient.KEY_ONE_WAY, poll.d());
            bundle.putString(MessengerIpcClient.KEY_PACKAGE, context.getPackageName());
            bundle.putBundle("data", poll.d);
            obtain.setData(bundle);
            try {
                MessengerIpcClient.c cVar = bVar.c;
                Messenger messenger2 = cVar.a;
                if (messenger2 != null) {
                    messenger2.send(obtain);
                } else {
                    FirebaseIidMessengerCompat firebaseIidMessengerCompat = cVar.b;
                    if (firebaseIidMessengerCompat != null) {
                        firebaseIidMessengerCompat.send(obtain);
                    } else {
                        throw new IllegalStateException("Both messengers are null");
                    }
                }
            } catch (RemoteException e) {
                bVar.c(2, e.getMessage());
            }
        }
    }
}
