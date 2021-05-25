package com.facebook.internal.instrument.errorreport;

import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ErrorReportHandler {

    public static class a implements Comparator<ErrorReportData> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(ErrorReportData errorReportData, ErrorReportData errorReportData2) {
            return errorReportData.compareTo(errorReportData2);
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
                        ((ErrorReportData) this.a.get(i)).clear();
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    public static class c implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.matches(String.format("^%s[0-9]+.json$", InstrumentUtility.ERROR_REPORT_PREFIX));
        }
    }

    public static void enable() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    public static File[] listErrorReportFiles() {
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        return instrumentReportDir.listFiles(new c());
    }

    public static void save(String str) {
        try {
            new ErrorReportData(str).save();
        } catch (Exception unused) {
        }
    }

    public static void sendErrorReports() {
        if (!Utility.isDataProcessingRestricted()) {
            File[] listErrorReportFiles = listErrorReportFiles();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (File file : listErrorReportFiles) {
                ErrorReportData errorReportData = new ErrorReportData(file);
                if (errorReportData.isValid()) {
                    arrayList.add(errorReportData);
                }
            }
            Collections.sort(arrayList, new a());
            JSONArray jSONArray = new JSONArray();
            while (i < arrayList.size() && i < 1000) {
                jSONArray.put(arrayList.get(i));
                i++;
            }
            InstrumentUtility.sendReports("error_reports", jSONArray, new b(arrayList));
        }
    }
}
