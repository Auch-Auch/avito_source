package a2.j.e.i;

import a2.j.e.i.i0;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.iid.Metadata;
import com.google.firebase.iid.ServiceStarter;
import java.io.IOException;
import javax.annotation.Nullable;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
public class j0 implements Runnable {
    public final long a;
    public final PowerManager.WakeLock b;
    public final FirebaseInstanceId c;

    @VisibleForTesting
    public static class a extends BroadcastReceiver {
        @Nullable
        public j0 a;

        public a(j0 j0Var) {
            this.a = j0Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j0 j0Var = this.a;
            if (j0Var != null && j0Var.c()) {
                FirebaseInstanceId.j();
                j0 j0Var2 = this.a;
                j0Var2.c.d(j0Var2, 0);
                this.a.a().unregisterReceiver(this);
                this.a = null;
            }
        }
    }

    @VisibleForTesting
    public j0(FirebaseInstanceId firebaseInstanceId, long j) {
        this.c = firebaseInstanceId;
        this.a = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    public Context a() {
        return this.c.b.getApplicationContext();
    }

    public final void b(String str) {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.c.b.getName())) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(this.c.b.getName());
                if (valueOf.length() != 0) {
                    "Invoking onNewToken for app: ".concat(valueOf);
                } else {
                    new String("Invoking onNewToken for app: ");
                }
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra(AppleSignInManagerKt.EXTRA_APPLE_TOKEN, str);
            ServiceStarter.startMessagingServiceViaReceiver(a(), intent);
        }
    }

    public boolean c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @VisibleForTesting
    public boolean d() throws IOException {
        i0.a h = this.c.h();
        boolean z = true;
        if (!this.c.r(h)) {
            return true;
        }
        try {
            FirebaseInstanceId firebaseInstanceId = this.c;
            String token = firebaseInstanceId.getToken(Metadata.getDefaultSenderId(firebaseInstanceId.b), "*");
            if (token == null) {
                return false;
            }
            Log.isLoggable("FirebaseInstanceId", 3);
            if (h == null || !token.equals(h.a)) {
                b(token);
            }
            return true;
        } catch (IOException e) {
            String message = e.getMessage();
            if (!GmsRpc.ERROR_SERVICE_NOT_AVAILABLE.equals(message) && !GmsRpc.ERROR_INTERNAL_SERVER_ERROR.equals(message) && !"InternalServerError".equals(message)) {
                z = false;
            }
            if (z) {
                String.valueOf(e.getMessage()).length();
                return false;
            } else if (e.getMessage() == null) {
                return false;
            } else {
                throw e;
            }
        } catch (SecurityException unused) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (ServiceStarter.getInstance().b(a())) {
            this.b.acquire();
        }
        try {
            this.c.n(true);
            if (!this.c.isGmsCorePresent()) {
                this.c.n(false);
                if (ServiceStarter.getInstance().b(a())) {
                    this.b.release();
                }
            } else if (!ServiceStarter.getInstance().a(a()) || c()) {
                if (d()) {
                    this.c.n(false);
                } else {
                    this.c.q(this.a);
                }
                if (ServiceStarter.getInstance().b(a())) {
                    this.b.release();
                }
            } else {
                a aVar = new a(this);
                FirebaseInstanceId.j();
                aVar.a.a().registerReceiver(aVar, new IntentFilter(NetworkChangeReceiver.CONNECTIVITY_ACTION));
                if (ServiceStarter.getInstance().b(a())) {
                    this.b.release();
                }
            }
        } catch (IOException e) {
            String.valueOf(e.getMessage()).length();
            this.c.n(false);
            if (ServiceStarter.getInstance().b(a())) {
                this.b.release();
            }
        } catch (Throwable th) {
            if (ServiceStarter.getInstance().b(a())) {
                this.b.release();
            }
            throw th;
        }
    }
}
