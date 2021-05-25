package com.facebook.internal.instrument.crashreport;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String b = CrashHandler.class.getCanonicalName();
    @Nullable
    public static CrashHandler c;
    @Nullable
    public final Thread.UncaughtExceptionHandler a;

    public static class a implements Comparator<InstrumentData> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(InstrumentData instrumentData, InstrumentData instrumentData2) {
            return instrumentData.compareTo(instrumentData2);
        }
    }

    public static class b implements GraphRequest.Callback {
        public final /* synthetic */ ArrayList a;

        public b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            try {
                if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                    for (int i = 0; this.a.size() > i; i++) {
                        ((InstrumentData) this.a.get(i)).clear();
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    public CrashHandler(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    public static void a() {
        if (!Utility.isDataProcessingRestricted()) {
            File[] listExceptionReportFiles = InstrumentUtility.listExceptionReportFiles();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (File file : listExceptionReportFiles) {
                InstrumentData load = InstrumentData.Builder.load(file);
                if (load.isValid()) {
                    arrayList.add(load);
                }
            }
            Collections.sort(arrayList, new a());
            JSONArray jSONArray = new JSONArray();
            while (i < arrayList.size() && i < 5) {
                jSONArray.put(arrayList.get(i));
                i++;
            }
            InstrumentUtility.sendReports("crash_reports", jSONArray, new b(arrayList));
        }
    }

    public static synchronized void enable() {
        synchronized (CrashHandler.class) {
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                a();
            }
            if (c == null) {
                CrashHandler crashHandler = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler());
                c = crashHandler;
                Thread.setDefaultUncaughtExceptionHandler(crashHandler);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (InstrumentUtility.isSDKRelatedException(th)) {
            ExceptionAnalyzer.execute(th);
            InstrumentData.Builder.build(th, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
