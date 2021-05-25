package com.facebook.internal.instrument.errorreport;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ErrorReportData {
    public String a;
    @Nullable
    public String b;
    @Nullable
    public Long c;

    public ErrorReportData(String str) {
        this.c = Long.valueOf(System.currentTimeMillis() / 1000);
        this.b = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ERROR_REPORT_PREFIX);
        stringBuffer.append(this.c);
        stringBuffer.append(".json");
        this.a = stringBuffer.toString();
    }

    public void clear() {
        InstrumentUtility.deleteFile(this.a);
    }

    public int compareTo(ErrorReportData errorReportData) {
        Long l = this.c;
        if (l == null) {
            return -1;
        }
        Long l2 = errorReportData.c;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    @Nullable
    public JSONObject getParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l = this.c;
            if (l != null) {
                jSONObject.put("timestamp", l);
            }
            jSONObject.put("error_message", this.b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean isValid() {
        return (this.b == null || this.c == null) ? false : true;
    }

    public void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.a, toString());
        }
    }

    @Nullable
    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return null;
        }
        return parameters.toString();
    }

    public ErrorReportData(File file) {
        String name = file.getName();
        this.a = name;
        JSONObject readFile = InstrumentUtility.readFile(name, true);
        if (readFile != null) {
            this.c = Long.valueOf(readFile.optLong("timestamp", 0));
            this.b = readFile.optString("error_message", null);
        }
    }
}
