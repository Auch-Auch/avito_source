package a2.g.k.x;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener;
public class d implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Bundle b;

    public d(RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener autoLoggingOnTouchListener, String str, Bundle bundle) {
        this.a = str;
        this.b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(this.a, this.b);
    }
}
