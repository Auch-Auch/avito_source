package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
@AutoHandleExceptions
public final class IntegrityManager {
    public static final String INTEGRITY_TYPE_ADDRESS = "address";
    public static final String INTEGRITY_TYPE_HEALTH = "health";
    public static final String INTEGRITY_TYPE_NONE = "none";
    public static boolean a = false;
    public static boolean b = false;

    public static boolean a(String str) {
        String str2;
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        String[] predict = ModelManager.predict(ModelManager.Task.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
        if (predict == null) {
            str2 = "none";
        } else {
            str2 = predict[0];
        }
        return !"none".equals(str2);
    }

    public static void enable() {
        a = true;
        b = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
    }

    public static void processParameters(Map<String, String> map) {
        if (a && map.size() != 0) {
            try {
                ArrayList arrayList = new ArrayList(map.keySet());
                JSONObject jSONObject = new JSONObject();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    String str2 = map.get(str);
                    if (a(str) || a(str2)) {
                        map.remove(str);
                        if (!b) {
                            str2 = "";
                        }
                        jSONObject.put(str, str2);
                    }
                }
                if (jSONObject.length() != 0) {
                    map.put("_onDeviceParams", jSONObject.toString());
                }
            } catch (Exception unused) {
            }
        }
    }
}
