package a2.g.s;

import a2.b.a.a.a;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public abstract class n implements Parcelable {
    public Map<String, String> a;
    public LoginClient loginClient;

    public n(LoginClient loginClient2) {
        this.loginClient = loginClient2;
    }

    public static String c(String str) throws FacebookException {
        if (str == null || str.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] split = str.split("\\.");
            if (split.length == 2) {
                return new JSONObject(new String(Base64.decode(split[1], 0), "UTF-8")).getString("user_id");
            }
        } catch (UnsupportedEncodingException | JSONException unused) {
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
    }

    public static AccessToken createAccessTokenFromWebBundle(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        String string2 = bundle.getString("granted_scopes");
        ArrayList arrayList = !Utility.isNullOrEmpty(string2) ? new ArrayList(Arrays.asList(string2.split(","))) : collection;
        String string3 = bundle.getString("denied_scopes");
        ArrayList arrayList2 = !Utility.isNullOrEmpty(string3) ? new ArrayList(Arrays.asList(string3.split(","))) : null;
        String string4 = bundle.getString("expired_scopes");
        ArrayList arrayList3 = !Utility.isNullOrEmpty(string4) ? new ArrayList(Arrays.asList(string4.split(","))) : null;
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        return new AccessToken(string, str, c(bundle.getString("signed_request")), arrayList, arrayList2, arrayList3, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString(NativeProtocol.RESULT_ARGS_GRAPH_DOMAIN));
    }

    public void a() {
    }

    public void addLoggingExtra(String str, Object obj) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, obj == null ? null : obj.toString());
    }

    public abstract String b();

    public boolean d() {
        return false;
    }

    public boolean e(int i, int i2, Intent intent) {
        return false;
    }

    public abstract int f(LoginClient.Request request);

    public String getClientState(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", b());
            putChallengeParam(jSONObject);
        } catch (JSONException e) {
            e.getMessage();
        }
        return jSONObject.toString();
    }

    public void logWebLoginCompleted(String str) {
        LoginClient loginClient2 = this.loginClient;
        String str2 = loginClient2.g.d;
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(loginClient2.e(), str2);
        Bundle y1 = a.y1(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        y1.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        y1.putString("app_id", str2);
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, null, y1);
    }

    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Utility.writeStringMapToParcel(parcel, this.a);
    }

    public n(Parcel parcel) {
        this.a = Utility.readStringMapFromParcel(parcel);
    }
}
