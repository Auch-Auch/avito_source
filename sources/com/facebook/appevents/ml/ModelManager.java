package com.facebook.appevents.ml;

import a2.g.k.z.c;
import a2.g.k.z.d;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY})
@AutoHandleExceptions
public final class ModelManager {
    public static final Map<String, b> a = new ConcurrentHashMap();
    public static final Integer b = 259200000;
    public static final List<String> c = Arrays.asList("other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);
    public static final List<String> d = Arrays.asList("none", IntegrityManager.INTEGRITY_TYPE_ADDRESS, IntegrityManager.INTEGRITY_TYPE_HEALTH);

    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        public String toKey() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                return ordinal != 1 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "app_event_pred";
            }
            return "integrity_detect";
        }

        @Nullable
        public String toUseCase() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (ordinal != 1) {
                return null;
            }
            return "MTML_APP_EVENT_PRED";
        }
    }

    public static class a implements Runnable {
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
            if (r4 != false) goto L_0x0074;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[Catch:{ Exception -> 0x009c }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0043 A[Catch:{ Exception -> 0x009c }] */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
                java.lang.String r0 = "model_request_timestamp"
                java.lang.String r1 = "models"
                android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x009c }
                java.lang.String r3 = "com.facebook.internal.MODEL_STORE"
                r4 = 0
                android.content.SharedPreferences r2 = r2.getSharedPreferences(r3, r4)     // Catch:{ Exception -> 0x009c }
                r3 = 0
                java.lang.String r3 = r2.getString(r1, r3)     // Catch:{ Exception -> 0x009c }
                if (r3 == 0) goto L_0x0023
                boolean r5 = r3.isEmpty()     // Catch:{ Exception -> 0x009c }
                if (r5 == 0) goto L_0x001d
                goto L_0x0023
            L_0x001d:
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x009c }
                r5.<init>(r3)     // Catch:{ Exception -> 0x009c }
                goto L_0x0028
            L_0x0023:
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x009c }
                r5.<init>()     // Catch:{ Exception -> 0x009c }
            L_0x0028:
                r6 = 0
                long r8 = r2.getLong(r0, r6)     // Catch:{ Exception -> 0x009c }
                com.facebook.internal.FeatureManager$Feature r3 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch:{ Exception -> 0x009c }
                boolean r3 = com.facebook.internal.FeatureManager.isEnabled(r3)     // Catch:{ Exception -> 0x009c }
                if (r3 == 0) goto L_0x0056
                int r3 = r5.length()     // Catch:{ Exception -> 0x009c }
                if (r3 == 0) goto L_0x0056
                java.util.Map<java.lang.String, com.facebook.appevents.ml.ModelManager$b> r3 = com.facebook.appevents.ml.ModelManager.a     // Catch:{ Exception -> 0x009c }
                int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r3 != 0) goto L_0x0043
                goto L_0x0054
            L_0x0043:
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x009c }
                long r6 = r6 - r8
                java.lang.Integer r3 = com.facebook.appevents.ml.ModelManager.b     // Catch:{ Exception -> 0x009c }
                int r3 = r3.intValue()     // Catch:{ Exception -> 0x009c }
                long r8 = (long) r3     // Catch:{ Exception -> 0x009c }
                int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r3 >= 0) goto L_0x0054
                r4 = 1
            L_0x0054:
                if (r4 != 0) goto L_0x0074
            L_0x0056:
                org.json.JSONObject r5 = com.facebook.appevents.ml.ModelManager.a()     // Catch:{ Exception -> 0x009c }
                if (r5 != 0) goto L_0x005d
                return
            L_0x005d:
                android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x009c }
                java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x009c }
                android.content.SharedPreferences$Editor r1 = r2.putString(r1, r3)     // Catch:{ Exception -> 0x009c }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x009c }
                android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r2)     // Catch:{ Exception -> 0x009c }
                r0.apply()     // Catch:{ Exception -> 0x009c }
            L_0x0074:
                java.util.Map<java.lang.String, com.facebook.appevents.ml.ModelManager$b> r0 = com.facebook.appevents.ml.ModelManager.a     // Catch:{ Exception -> 0x009c }
                java.util.Iterator r0 = r5.keys()     // Catch:{ Exception -> 0x009c }
            L_0x007a:
                boolean r1 = r0.hasNext()     // Catch:{ JSONException -> 0x0099 }
                if (r1 == 0) goto L_0x0099
                java.lang.Object r1 = r0.next()     // Catch:{ JSONException -> 0x0099 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x0099 }
                org.json.JSONObject r1 = r5.getJSONObject(r1)     // Catch:{ JSONException -> 0x0099 }
                com.facebook.appevents.ml.ModelManager$b r1 = com.facebook.appevents.ml.ModelManager.b.a(r1)     // Catch:{ JSONException -> 0x0099 }
                if (r1 != 0) goto L_0x0091
                goto L_0x007a
            L_0x0091:
                java.util.Map<java.lang.String, com.facebook.appevents.ml.ModelManager$b> r2 = com.facebook.appevents.ml.ModelManager.a     // Catch:{ JSONException -> 0x0099 }
                java.lang.String r3 = r1.a     // Catch:{ JSONException -> 0x0099 }
                r2.put(r3, r1)     // Catch:{ JSONException -> 0x0099 }
                goto L_0x007a
            L_0x0099:
                com.facebook.appevents.ml.ModelManager.b()
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.a.run():void");
        }
    }

    public static class b {
        public String a;
        public String b;
        @Nullable
        public String c;
        public int d;
        @Nullable
        public float[] e;
        public File f;
        @Nullable
        public Model g;
        public Runnable h;

        public b(String str, String str2, @Nullable String str3, int i, @Nullable float[] fArr) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
            this.e = fArr;
        }

        @Nullable
        public static b a(@Nullable JSONObject jSONObject) {
            float[] fArr;
            if (jSONObject == null) {
                return null;
            }
            try {
                String string = jSONObject.getString("use_case");
                String string2 = jSONObject.getString("asset_uri");
                String optString = jSONObject.optString("rules_uri", null);
                int i = jSONObject.getInt("version_id");
                JSONArray jSONArray = jSONObject.getJSONArray("thresholds");
                Map<String, b> map = ModelManager.a;
                if (jSONArray == null) {
                    fArr = null;
                } else {
                    float[] fArr2 = new float[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            fArr2[i2] = Float.parseFloat(jSONArray.getString(i2));
                        } catch (JSONException unused) {
                        }
                    }
                    fArr = fArr2;
                }
                return new b(string, string2, optString, i, fArr);
            } catch (Exception unused2) {
                return null;
            }
        }

        public static void b(String str, String str2, FileDownloadTask.Callback callback) {
            File file = new File(Utils.getMlDir(), str2);
            if (str == null || file.exists()) {
                callback.onComplete(file);
            } else {
                new FileDownloadTask(str, file, callback).execute(new String[0]);
            }
        }
    }

    public static JSONObject a() {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new String[]{"use_case", "version_id", "asset_uri", "rules_uri", "thresholds"}));
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, String.format("%s/model_asset", FacebookSdk.getApplicationId()), null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("version_id", jSONObject3.getString("version_id"));
                jSONObject4.put("use_case", jSONObject3.getString("use_case"));
                jSONObject4.put("thresholds", jSONObject3.getJSONArray("thresholds"));
                jSONObject4.put("asset_uri", jSONObject3.getString("asset_uri"));
                if (jSONObject3.has("rules_uri")) {
                    jSONObject4.put("rules_uri", jSONObject3.getString("rules_uri"));
                }
                jSONObject2.put(jSONObject3.getString("use_case"), jSONObject4);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static void b() {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        String str = null;
        int i = 0;
        for (Map.Entry<String, b> entry : a.entrySet()) {
            String key = entry.getKey();
            if (key.equals(Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                b value = entry.getValue();
                String str2 = value.b;
                i = Math.max(i, value.d);
                if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents)) {
                    Locale resourceLocale = Utility.getResourceLocale();
                    if (resourceLocale == null || resourceLocale.getLanguage().contains("en")) {
                        value.h = new a2.g.k.z.b();
                        arrayList.add(value);
                    }
                }
                str = str2;
            }
            if (key.equals(Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                b value2 = entry.getValue();
                String str3 = value2.b;
                i = Math.max(i, value2.d);
                if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                    value2.h = new c();
                    arrayList.add(value2);
                }
                str = str3;
            }
        }
        if (!(str == null || i <= 0 || arrayList.isEmpty())) {
            File mlDir = Utils.getMlDir();
            if (!(mlDir == null || (listFiles = mlDir.listFiles()) == null || listFiles.length == 0)) {
                String str4 = "MTML_" + i;
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name.startsWith("MTML") && !name.startsWith(str4)) {
                        file.delete();
                    }
                }
            }
            b.b(str, "MTML_" + i, new d(arrayList));
        }
    }

    public static void enable() {
        Utility.runOnNonUiThread(new a());
    }

    @Nullable
    public static File getRuleFile(Task task) {
        b bVar = a.get(task.toUseCase());
        if (bVar == null) {
            return null;
        }
        return bVar.f;
    }

    @Nullable
    public static String[] predict(Task task, float[][] fArr, String[] strArr) {
        b bVar = a.get(task.toUseCase());
        if (bVar == null || bVar.g == null) {
            return null;
        }
        int length = strArr.length;
        int length2 = fArr[0].length;
        MTensor mTensor = new MTensor(new int[]{length, length2});
        for (int i = 0; i < length; i++) {
            System.arraycopy(fArr[i], 0, mTensor.getData(), i * length2, length2);
        }
        MTensor predictOnMTML = bVar.g.predictOnMTML(mTensor, strArr, task.toKey());
        float[] fArr2 = bVar.e;
        if (predictOnMTML == null || fArr2 == null || predictOnMTML.getData().length == 0 || fArr2.length == 0) {
            return null;
        }
        int ordinal = task.ordinal();
        if (ordinal == 0) {
            int shape = predictOnMTML.getShape(0);
            int shape2 = predictOnMTML.getShape(1);
            float[] data = predictOnMTML.getData();
            String[] strArr2 = new String[shape];
            if (shape2 != fArr2.length) {
                return null;
            }
            for (int i2 = 0; i2 < shape; i2++) {
                strArr2[i2] = "none";
                for (int i3 = 0; i3 < fArr2.length; i3++) {
                    if (data[(i2 * shape2) + i3] >= fArr2[i3]) {
                        strArr2[i2] = d.get(i3);
                    }
                }
            }
            return strArr2;
        } else if (ordinal != 1) {
            return null;
        } else {
            int shape3 = predictOnMTML.getShape(0);
            int shape4 = predictOnMTML.getShape(1);
            float[] data2 = predictOnMTML.getData();
            String[] strArr3 = new String[shape3];
            if (shape4 != fArr2.length) {
                return null;
            }
            for (int i4 = 0; i4 < shape3; i4++) {
                strArr3[i4] = "other";
                for (int i5 = 0; i5 < fArr2.length; i5++) {
                    if (data2[(i4 * shape4) + i5] >= fArr2[i5]) {
                        strArr3[i4] = c.get(i5);
                    }
                }
            }
            return strArr3;
        }
    }
}
