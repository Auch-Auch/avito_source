package a2.g.k.a0;

import android.util.Patterns;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import com.avito.android.util.preferences.Preference;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public final class a {
    public static Map<String, String> a = null;
    public static Map<String, String> b = null;
    public static Map<String, String> c = null;
    public static JSONObject d = null;
    public static boolean e = false;

    @Nullable
    public static float[] a(JSONObject jSONObject, String str) {
        if (!e) {
            return null;
        }
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        try {
            String lowerCase = str.toLowerCase();
            JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
            String optString = jSONObject.optString(ViewHierarchyConstants.SCREEN_NAME_KEY);
            JSONArray jSONArray = new JSONArray();
            g(jSONObject2, jSONArray);
            j(fArr, f(jSONObject2));
            JSONObject b2 = b(jSONObject2);
            if (b2 == null) {
                return null;
            }
            j(fArr, e(b2, jSONArray, optString, jSONObject2.toString(), lowerCase));
            return fArr;
        } catch (JSONException unused) {
        }
    }

    @Nullable
    public static JSONObject b(JSONObject jSONObject) {
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return jSONObject;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            if (optJSONArray == null) {
                return null;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject b2 = b(optJSONArray.getJSONObject(i));
                if (b2 != null) {
                    return b2;
                }
            }
            return null;
        } catch (JSONException unused) {
        }
    }

    public static void c(File file) {
        try {
            d = new JSONObject();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            d = new JSONObject(new String(bArr, "UTF-8"));
            HashMap hashMap = new HashMap();
            a = hashMap;
            hashMap.put(ViewHierarchyConstants.ENGLISH, "1");
            a.put(ViewHierarchyConstants.GERMAN, ExifInterface.GPS_MEASUREMENT_2D);
            a.put(ViewHierarchyConstants.SPANISH, ExifInterface.GPS_MEASUREMENT_3D);
            a.put(ViewHierarchyConstants.JAPANESE, "4");
            HashMap hashMap2 = new HashMap();
            b = hashMap2;
            hashMap2.put(ViewHierarchyConstants.VIEW_CONTENT, "0");
            b.put(ViewHierarchyConstants.SEARCH, "1");
            b.put(ViewHierarchyConstants.ADD_TO_CART, ExifInterface.GPS_MEASUREMENT_2D);
            b.put(ViewHierarchyConstants.ADD_TO_WISHLIST, ExifInterface.GPS_MEASUREMENT_3D);
            b.put(ViewHierarchyConstants.INITIATE_CHECKOUT, "4");
            b.put(ViewHierarchyConstants.ADD_PAYMENT_INFO, "5");
            b.put(ViewHierarchyConstants.PURCHASE, "6");
            b.put(ViewHierarchyConstants.LEAD, "7");
            b.put(ViewHierarchyConstants.COMPLETE_REGISTRATION, "8");
            HashMap hashMap3 = new HashMap();
            c = hashMap3;
            hashMap3.put(ViewHierarchyConstants.BUTTON_TEXT, "1");
            c.put(ViewHierarchyConstants.PAGE_TITLE, ExifInterface.GPS_MEASUREMENT_2D);
            c.put(ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, ExifInterface.GPS_MEASUREMENT_3D);
            c.put(ViewHierarchyConstants.BUTTON_ID, "4");
            e = true;
        } catch (Exception unused) {
        }
    }

    public static boolean d(String[] strArr, String[] strArr2) {
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (str2.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float[] e(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        float[] fArr = new float[30];
        float f = 0.0f;
        Arrays.fill(fArr, 0.0f);
        int length = jSONArray.length();
        fArr[3] = (float) (length > 1 ? length - 1 : 0);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if ((jSONArray.getJSONObject(i).optInt(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY) & 32) > 0) {
                    fArr[9] = fArr[9] + 1.0f;
                }
            } catch (JSONException unused) {
            }
        }
        fArr[13] = -1.0f;
        fArr[14] = -1.0f;
        String L2 = a2.b.a.a.a.L2(str, '|', str3);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        k(jSONObject, sb2, sb);
        String sb3 = sb.toString();
        String sb4 = sb2.toString();
        fArr[15] = i(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
        fArr[16] = i(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.PAGE_TITLE, L2) ? 1.0f : 0.0f;
        fArr[17] = i(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_ID, sb3) ? 1.0f : 0.0f;
        fArr[18] = str2.contains(Preference.PASSWORD) ? 1.0f : 0.0f;
        fArr[19] = h("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", str2) ? 1.0f : 0.0f;
        fArr[20] = h("(?i)(sign in)|login|signIn", str2) ? 1.0f : 0.0f;
        fArr[21] = h("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", str2) ? 1.0f : 0.0f;
        fArr[22] = i(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
        fArr[24] = i(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.PAGE_TITLE, L2) ? 1.0f : 0.0f;
        fArr[25] = h("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", sb4) ? 1.0f : 0.0f;
        fArr[27] = h("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", L2) ? 1.0f : 0.0f;
        fArr[28] = i(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
        if (i(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.PAGE_TITLE, L2)) {
            f = 1.0f;
        }
        fArr[29] = f;
        return fArr;
    }

    public static float[] f(JSONObject jSONObject) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        String lowerCase = jSONObject.optString("text").toLowerCase();
        String lowerCase2 = jSONObject.optString("hint").toLowerCase();
        String lowerCase3 = jSONObject.optString(ViewHierarchyConstants.CLASS_NAME_KEY).toLowerCase();
        int optInt = jSONObject.optInt(ViewHierarchyConstants.INPUT_TYPE_KEY, -1);
        String[] strArr = {lowerCase, lowerCase2};
        if (d(new String[]{"$", "amount", "price", "total"}, strArr)) {
            fArr[0] = (float) (((double) fArr[0]) + 1.0d);
        }
        if (d(new String[]{Preference.PASSWORD, "pwd"}, strArr)) {
            fArr[1] = (float) (((double) fArr[1]) + 1.0d);
        }
        if (d(new String[]{"tel", "phone"}, strArr)) {
            fArr[2] = (float) (((double) fArr[2]) + 1.0d);
        }
        if (d(new String[]{"search"}, strArr)) {
            fArr[4] = (float) (((double) fArr[4]) + 1.0d);
        }
        if (optInt >= 0) {
            fArr[5] = (float) (((double) fArr[5]) + 1.0d);
        }
        if (optInt == 3 || optInt == 2) {
            fArr[6] = (float) (((double) fArr[6]) + 1.0d);
        }
        if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
            fArr[7] = (float) (((double) fArr[7]) + 1.0d);
        }
        if (lowerCase3.contains("checkbox")) {
            fArr[8] = (float) (((double) fArr[8]) + 1.0d);
        }
        if (d(new String[]{Tracker.Events.CREATIVE_COMPLETE, "confirm", PaymentStateKt.PAYMENT_STATE_DONE, "submit"}, new String[]{lowerCase})) {
            fArr[10] = (float) (((double) fArr[10]) + 1.0d);
        }
        if (lowerCase3.contains("radio") && lowerCase3.contains(PhonePageSourceKt.PHONE_SOURCE_BUTTON)) {
            fArr[12] = (float) (((double) fArr[12]) + 1.0d);
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                j(fArr, f(optJSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
        return fArr;
    }

    public static boolean g(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        boolean z2;
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int i = 0;
            while (true) {
                if (i >= optJSONArray.length()) {
                    z = false;
                    z2 = false;
                    break;
                } else if (optJSONArray.getJSONObject(i).optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                    z = true;
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    jSONArray.put(optJSONArray.getJSONObject(i2));
                }
            } else {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (g(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z2 = true;
                    }
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean h(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }

    public static boolean i(String str, String str2, String str3, String str4) {
        return h(d.optJSONObject("rulesForLanguage").optJSONObject(a.get(str)).optJSONObject("rulesForEvent").optJSONObject(b.get(str2)).optJSONObject("positiveRules").optString(c.get(str3)), str4);
    }

    public static void j(float[] fArr, float[] fArr2) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] + fArr2[i];
        }
    }

    public static void k(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        String lowerCase = jSONObject.optString("text", "").toLowerCase();
        String lowerCase2 = jSONObject.optString("hint", "").toLowerCase();
        if (!lowerCase.isEmpty()) {
            sb.append(lowerCase);
            sb.append(" ");
        }
        if (!lowerCase2.isEmpty()) {
            sb2.append(lowerCase2);
            sb2.append(" ");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    k(optJSONArray.getJSONObject(i), sb, sb2);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
