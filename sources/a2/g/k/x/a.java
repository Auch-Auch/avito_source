package a2.g.k.x;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Bundle b;

    public a(String str, Bundle bundle) {
        this.a = str;
        this.b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(this.a, this.b);
    }
}
