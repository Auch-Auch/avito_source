package com.google.firebase.iid;

import a2.j.e.i.s;
import a2.j.e.i.t;
import a2.j.e.i.u;
import a2.j.e.i.v;
import a2.j.e.i.w;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.p002firebaseiid.zza;
import com.google.android.gms.internal.p002firebaseiid.zze;
import com.google.android.gms.internal.p002firebaseiid.zzf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
public class MessengerIpcClient {
    public static final String KEY_ACK = "ack";
    public static final String KEY_DATA = "data";
    public static final String KEY_ONE_WAY = "oneWay";
    public static final String KEY_PACKAGE = "pkg";
    public static final String KEY_UNSUPPORTED = "unsupported";
    @GuardedBy("MessengerIpcClient.class")
    public static MessengerIpcClient e;
    public final Context a;
    public final ScheduledExecutorService b;
    @GuardedBy("this")
    public b c = new b(null);
    @GuardedBy("this")
    public int d = 1;

    public static class RequestFailedException extends Exception {
        public final int a;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ErrorCode {
            public static final int CONNECTION_TIMEOUT = 1;
            public static final int FAILED_TO_CONNECT = 0;
            public static final int REMOTE_ERROR = 2;
            public static final int REQUEST_TIMEOUT = 3;
            public static final int UNSUPPORTED = 4;
        }

        public RequestFailedException(int i, String str) {
            super(str);
            this.a = i;
        }

        public int getErrorCode() {
            return this.a;
        }
    }

    @KeepForSdk
    @Retention(RetentionPolicy.SOURCE)
    public @interface What {
        @KeepForSdk
        public static final int FCM_ACK = 2;
        public static final int IID_TOKEN_REQUEST = 1;
        public static final int LEGACY_IID_TOKEN_REQUEST = 0;
    }

    public class b implements ServiceConnection {
        @GuardedBy("this")
        public int a = 0;
        public final Messenger b = new Messenger(new zze(Looper.getMainLooper(), new s(this)));
        public c c;
        @GuardedBy("this")
        public final Queue<e<?>> d = new ArrayDeque();
        @GuardedBy("this")
        public final SparseArray<e<?>> e = new SparseArray<>();

        public b(a aVar) {
        }

        public synchronized boolean a(e<?> eVar) {
            int i = this.a;
            if (i == 0) {
                this.d.add(eVar);
                d();
                return true;
            } else if (i == 1) {
                this.d.add(eVar);
                return true;
            } else if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        int i2 = this.a;
                        StringBuilder sb = new StringBuilder(26);
                        sb.append("Unknown state: ");
                        sb.append(i2);
                        throw new IllegalStateException(sb.toString());
                    }
                }
                return false;
            } else {
                this.d.add(eVar);
                MessengerIpcClient.this.b.execute(new v(this));
                return true;
            }
        }

        @GuardedBy("this")
        public void b(RequestFailedException requestFailedException) {
            for (e<?> eVar : this.d) {
                eVar.a(requestFailedException);
            }
            this.d.clear();
            for (int i = 0; i < this.e.size(); i++) {
                this.e.valueAt(i).a(requestFailedException);
            }
            this.e.clear();
        }

        public synchronized void c(int i, String str) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Disconnected: ".concat(valueOf);
                } else {
                    new String("Disconnected: ");
                }
            }
            int i2 = this.a;
            if (i2 == 0) {
                throw new IllegalStateException();
            } else if (i2 == 1 || i2 == 2) {
                Log.isLoggable("MessengerIpcClient", 2);
                this.a = 4;
                ConnectionTracker.getInstance().unbindService(MessengerIpcClient.this.a, this);
                b(new RequestFailedException(i, str));
            } else if (i2 == 3) {
                this.a = 4;
            } else if (i2 != 4) {
                int i3 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
        }

        @GuardedBy("this")
        public void d() {
            Preconditions.checkState(this.a == 0);
            Log.isLoggable("MessengerIpcClient", 2);
            this.a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (!ConnectionTracker.getInstance().bindService(MessengerIpcClient.this.a, intent, this, 1)) {
                c(0, "Unable to bind to service");
            } else {
                MessengerIpcClient.this.b.schedule(new t(this), 30, TimeUnit.SECONDS);
            }
        }

        public synchronized void e() {
            if (this.a == 2 && this.d.isEmpty() && this.e.size() == 0) {
                Log.isLoggable("MessengerIpcClient", 2);
                this.a = 3;
                ConnectionTracker.getInstance().unbindService(MessengerIpcClient.this.a, this);
            }
        }

        @Override // android.content.ServiceConnection
        @MainThread
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.isLoggable("MessengerIpcClient", 2);
            MessengerIpcClient.this.b.execute(new u(this, iBinder));
        }

        @Override // android.content.ServiceConnection
        @MainThread
        public void onServiceDisconnected(ComponentName componentName) {
            Log.isLoggable("MessengerIpcClient", 2);
            MessengerIpcClient.this.b.execute(new w(this));
        }
    }

    public static class c {
        public final Messenger a;
        public final FirebaseIidMessengerCompat b;

        public c(IBinder iBinder) throws RemoteException {
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if ("android.os.IMessenger".equals(interfaceDescriptor)) {
                this.a = new Messenger(iBinder);
                this.b = null;
            } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
                this.b = new FirebaseIidMessengerCompat(iBinder);
                this.a = null;
            } else {
                String valueOf = String.valueOf(interfaceDescriptor);
                if (valueOf.length() != 0) {
                    "Invalid interface descriptor: ".concat(valueOf);
                } else {
                    new String("Invalid interface descriptor: ");
                }
                throw new RemoteException();
            }
        }
    }

    public static class d extends e<Void> {
        public d(int i, int i2, Bundle bundle) {
            super(i, i2, bundle);
        }

        @Override // com.google.firebase.iid.MessengerIpcClient.e
        public void c(Bundle bundle) {
            if (bundle.getBoolean(MessengerIpcClient.KEY_ACK, false)) {
                b(null);
            } else {
                a(new RequestFailedException(4, "Invalid response to one way request"));
            }
        }

        @Override // com.google.firebase.iid.MessengerIpcClient.e
        public boolean d() {
            return true;
        }
    }

    public static abstract class e<T> {
        public final int a;
        public final TaskCompletionSource<T> b = new TaskCompletionSource<>();
        public final int c;
        public final Bundle d;

        public e(int i, int i2, Bundle bundle) {
            this.a = i;
            this.c = i2;
            this.d = bundle;
        }

        public void a(RequestFailedException requestFailedException) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(this);
                String valueOf2 = String.valueOf(requestFailedException);
                valueOf.length();
                valueOf2.length();
            }
            this.b.setException(requestFailedException);
        }

        public void b(T t) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(this);
                String valueOf2 = String.valueOf(t);
                valueOf.length();
                valueOf2.length();
            }
            this.b.setResult(t);
        }

        public abstract void c(Bundle bundle);

        public abstract boolean d();

        public String toString() {
            int i = this.c;
            int i2 = this.a;
            boolean d2 = d();
            StringBuilder sb = new StringBuilder(55);
            sb.append("Request { what=");
            sb.append(i);
            sb.append(" id=");
            sb.append(i2);
            sb.append(" oneWay=");
            sb.append(d2);
            sb.append("}");
            return sb.toString();
        }
    }

    public static class f extends e<Bundle> {
        public f(int i, int i2, Bundle bundle) {
            super(i, i2, bundle);
        }

        @Override // com.google.firebase.iid.MessengerIpcClient.e
        public void c(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle("data");
            if (bundle2 == null) {
                bundle2 = Bundle.EMPTY;
            }
            b(bundle2);
        }

        @Override // com.google.firebase.iid.MessengerIpcClient.e
        public boolean d() {
            return false;
        }
    }

    @VisibleForTesting
    public MessengerIpcClient(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.b = scheduledExecutorService;
        this.a = context.getApplicationContext();
    }

    @KeepForSdk
    public static synchronized MessengerIpcClient getInstance(Context context) {
        MessengerIpcClient messengerIpcClient;
        synchronized (MessengerIpcClient.class) {
            if (e == null) {
                e = new MessengerIpcClient(context, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zza));
            }
            messengerIpcClient = e;
        }
        return messengerIpcClient;
    }

    @KeepForSdk
    @VisibleForTesting
    public static synchronized void resetForTesting() {
        synchronized (MessengerIpcClient.class) {
            e = null;
        }
    }

    public final synchronized <T> Task<T> a(e<T> eVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String.valueOf(eVar).length();
        }
        if (!this.c.a(eVar)) {
            b bVar = new b(null);
            this.c = bVar;
            bVar.a(eVar);
        }
        return eVar.b.getTask();
    }

    @KeepForSdk
    public Task<Void> sendOneWayRequest(int i, Bundle bundle) {
        int i2;
        synchronized (this) {
            i2 = this.d;
            this.d = i2 + 1;
        }
        return a(new d(i2, i, bundle));
    }

    public Task<Bundle> sendRequestForResponse(int i, Bundle bundle) {
        int i2;
        synchronized (this) {
            i2 = this.d;
            this.d = i2 + 1;
        }
        return a(new f(i2, i, bundle));
    }
}
