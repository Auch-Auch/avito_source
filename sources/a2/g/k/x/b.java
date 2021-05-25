package a2.g.k.x;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
public final class b implements Runnable {
    public final /* synthetic */ String a;

    public b(String str) {
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z = true;
        GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_indexing_session", this.a), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        JSONArray jSONArray = new JSONArray();
        String str = Build.MODEL;
        if (str == null) {
            str = "";
        }
        jSONArray.put(str);
        if (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) {
            jSONArray.put("");
        } else {
            jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
        }
        String str2 = "0";
        jSONArray.put(str2);
        if (AppEventUtility.isEmulator()) {
            str2 = "1";
        }
        jSONArray.put(str2);
        Locale currentLocale = Utility.getCurrentLocale();
        jSONArray.put(currentLocale.getLanguage() + "_" + currentLocale.getCountry());
        String jSONArray2 = jSONArray.toString();
        if (CodelessManager.d == null) {
            CodelessManager.d = UUID.randomUUID().toString();
        }
        parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.d);
        parameters.putString(Constants.EXTINFO, jSONArray2);
        newPostRequest.setParameters(parameters);
        JSONObject jSONObject = newPostRequest.executeAndWait().getJSONObject();
        if (jSONObject == null || !jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false)) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        CodelessManager.f = valueOf;
        if (!valueOf.booleanValue()) {
            CodelessManager.d = null;
        } else {
            ViewIndexer viewIndexer = CodelessManager.c;
            if (viewIndexer != null) {
                viewIndexer.schedule();
            }
        }
        CodelessManager.g = Boolean.FALSE;
    }
}
