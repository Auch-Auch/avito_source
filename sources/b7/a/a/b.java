package b7.a.a;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
public final class b extends Service {
    public static final Binder a = new Binder();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return a;
    }
}
