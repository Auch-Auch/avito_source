package a2.g.k.y;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker;
import java.lang.reflect.Method;
import java.util.HashMap;
public final class b implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        HashMap<String, Method> hashMap = d.a;
        InAppPurchaseActivityLifecycleTracker.g = d.e(applicationContext, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder});
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
