package a2.g.k.a0;

import android.content.SharedPreferences;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public final class b {
    public static final Map<String, String> a = new HashMap();
    public static SharedPreferences b;
    public static final AtomicBoolean c = new AtomicBoolean(false);

    public static void a(String str, String str2) {
        AtomicBoolean atomicBoolean = c;
        if (!atomicBoolean.get() && !atomicBoolean.get()) {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
            b = sharedPreferences;
            a.putAll(Utility.JsonStrToMap(sharedPreferences.getString("SUGGESTED_EVENTS_HISTORY", "")));
            atomicBoolean.set(true);
        }
        Map<String, String> map = a;
        map.put(str, str2);
        b.edit().putString("SUGGESTED_EVENTS_HISTORY", Utility.mapToJsonStr(map)).apply();
    }

    @Nullable
    public static String b(View view, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("text", str);
            JSONArray jSONArray = new JSONArray();
            while (view != null) {
                jSONArray.put(view.getClass().getSimpleName());
                view = ViewHierarchy.getParentOfView(view);
            }
            jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, jSONArray);
        } catch (JSONException unused) {
        }
        return Utility.sha256hash(jSONObject.toString());
    }
}
