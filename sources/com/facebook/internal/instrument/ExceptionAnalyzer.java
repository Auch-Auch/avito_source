package com.facebook.internal.instrument;

import a2.g.r.l.a;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ExceptionAnalyzer {
    public static boolean a = false;

    public static void enable() {
        a = true;
        if (FacebookSdk.getAutoLogAppEventsEnabled() && !Utility.isDataProcessingRestricted()) {
            File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
            ArrayList arrayList = new ArrayList();
            for (File file : listExceptionAnalysisReportFiles) {
                InstrumentData load = InstrumentData.Builder.load(file);
                if (load.isValid()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("crash_shield", load.toString());
                        arrayList.add(GraphRequest.newPostRequest(null, String.format("%s/instruments", FacebookSdk.getApplicationId()), jSONObject, new a(load)));
                    } catch (JSONException unused) {
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                new GraphRequestBatch(arrayList).executeAsync();
            }
        }
    }

    public static void execute(Throwable th) {
        if (a) {
            HashSet hashSet = new HashSet();
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                FeatureManager.Feature feature = FeatureManager.getFeature(stackTraceElement.getClassName());
                if (feature != FeatureManager.Feature.Unknown) {
                    FeatureManager.disableFeature(feature);
                    hashSet.add(feature.toString());
                }
            }
            if (FacebookSdk.getAutoLogAppEventsEnabled() && !hashSet.isEmpty()) {
                InstrumentData.Builder.build(new JSONArray((Collection) hashSet)).save();
            }
        }
    }
}
