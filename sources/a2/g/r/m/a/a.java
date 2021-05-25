package a2.g.r.m.a;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.logging.monitor.Monitor;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class a implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Random random = Monitor.a;
        Bundle y1 = a2.b.a.a.a.y1("fields", MonitorLogServerProtocol.MONITOR_CONFIG);
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, FacebookSdk.getApplicationId(), null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(y1);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject(MonitorLogServerProtocol.MONITOR_CONFIG).getJSONArray(MonitorLogServerProtocol.SAMPLE_RATES);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("key");
                    int i2 = jSONObject2.getInt("value");
                    if ("default".equals(string)) {
                        Monitor.b = Integer.valueOf(i2);
                    } else {
                        Monitor.f.put(string, Integer.valueOf(i2));
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }
}
