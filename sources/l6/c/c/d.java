package l6.c.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.trusted.TrustedWebActivityServiceConnection;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class d implements ServiceConnection {
    @NonNull
    public final Runnable a;
    @NonNull
    public final a b;
    public int c = 0;
    @Nullable
    public TrustedWebActivityServiceConnection d;
    @NonNull
    public List<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> e = new ArrayList();
    @Nullable
    public Exception f;

    public static class a {
    }

    @MainThread
    public d(@NonNull Runnable runnable) {
        a aVar = new a();
        this.a = runnable;
        this.b = aVar;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Objects.requireNonNull(this.b);
        this.d = new TrustedWebActivityServiceConnection(ITrustedWebActivityService.Stub.asInterface(iBinder), componentName);
        for (CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection> completer : this.e) {
            completer.set(this.d);
        }
        this.e.clear();
        this.c = 1;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public void onServiceDisconnected(ComponentName componentName) {
        this.d = null;
        this.a.run();
        this.c = 2;
    }
}
