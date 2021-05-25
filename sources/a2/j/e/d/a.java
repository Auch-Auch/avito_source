package a2.j.e.d;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
public class a implements AnalyticsConnector.AnalyticsConnectorListener {
    public AnalyticsEventReceiver a;
    public AnalyticsEventReceiver b;

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public void onMessageTriggered(int i, @Nullable Bundle bundle) {
        String string;
        AnalyticsEventReceiver analyticsEventReceiver;
        Logger logger = Logger.getLogger();
        logger.d("Received Analytics message: " + i + " " + bundle);
        if (bundle != null && (string = bundle.getString("name")) != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            if ("clx".equals(bundle2.getString("_o"))) {
                analyticsEventReceiver = this.a;
            } else {
                analyticsEventReceiver = this.b;
            }
            if (analyticsEventReceiver != null) {
                analyticsEventReceiver.onEvent(string, bundle2);
            }
        }
    }
}
