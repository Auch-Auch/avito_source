package com.facebook.internal.instrument;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.avito.android.util.preferences.Preference;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class InstrumentData {
    public String a;
    public Type b;
    @Nullable
    public JSONArray c;
    @Nullable
    public String d;
    @Nullable
    public String e;
    @Nullable
    public String f;
    @Nullable
    public Long g;

    public static class Builder {
        public static InstrumentData build(Throwable th, Type type) {
            return new InstrumentData(th, type, null);
        }

        public static InstrumentData load(File file) {
            return new InstrumentData(file, (a) null);
        }

        public static InstrumentData build(JSONArray jSONArray) {
            return new InstrumentData(jSONArray, (a) null);
        }
    }

    public enum Type {
        Unknown,
        Analysis,
        CrashReport,
        CrashShield,
        ThreadCheck;

        public String getLogPrefix() {
            int ordinal = ordinal();
            if (ordinal == 1) {
                return InstrumentUtility.ANALYSIS_REPORT_PREFIX;
            }
            if (ordinal == 2) {
                return InstrumentUtility.CRASH_REPORT_PREFIX;
            }
            if (ordinal != 3) {
                return ordinal != 4 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : InstrumentUtility.THREAD_CHECK_PREFIX;
            }
            return InstrumentUtility.CRASH_SHIELD_PREFIX;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 1) {
                return "Analysis";
            }
            if (ordinal == 2) {
                return "CrashReport";
            }
            if (ordinal != 3) {
                return ordinal != 4 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "ThreadCheck";
            }
            return "CrashShield";
        }
    }

    public InstrumentData(JSONArray jSONArray, a aVar) {
        this.b = Type.Analysis;
        this.g = Long.valueOf(System.currentTimeMillis() / 1000);
        this.c = jSONArray;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ANALYSIS_REPORT_PREFIX);
        stringBuffer.append(this.g.toString());
        stringBuffer.append(".json");
        this.a = stringBuffer.toString();
    }

    public void clear() {
        InstrumentUtility.deleteFile(this.a);
    }

    public int compareTo(InstrumentData instrumentData) {
        Long l = this.g;
        if (l == null) {
            return -1;
        }
        Long l2 = instrumentData.g;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    public boolean isValid() {
        int ordinal = this.b.ordinal();
        if (ordinal != 1) {
            if ((ordinal != 2 && ordinal != 3 && ordinal != 4) || this.f == null || this.g == null) {
                return false;
            }
            return true;
        } else if (this.c == null || this.g == null) {
            return false;
        } else {
            return true;
        }
    }

    public void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.a, toString());
        }
    }

    @Nullable
    public String toString() {
        JSONObject jSONObject;
        int ordinal = this.b.ordinal();
        if (ordinal != 1) {
            if (ordinal == 2 || ordinal == 3 || ordinal == 4) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(MonitorLogServerProtocol.PARAM_DEVICE_OS_VERSION, Build.VERSION.RELEASE);
                    jSONObject.put(MonitorLogServerProtocol.PARAM_DEVICE_MODEL, Build.MODEL);
                    String str = this.d;
                    if (str != null) {
                        jSONObject.put(Preference.APP_VERSION, str);
                    }
                    Long l = this.g;
                    if (l != null) {
                        jSONObject.put("timestamp", l);
                    }
                    String str2 = this.e;
                    if (str2 != null) {
                        jSONObject.put("reason", str2);
                    }
                    String str3 = this.f;
                    if (str3 != null) {
                        jSONObject.put("callstack", str3);
                    }
                    Type type = this.b;
                    if (type != null) {
                        jSONObject.put("type", type);
                    }
                } catch (JSONException unused) {
                }
            }
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            JSONArray jSONArray = this.c;
            if (jSONArray != null) {
                jSONObject.put("feature_names", jSONArray);
            }
            Long l2 = this.g;
            if (l2 != null) {
                jSONObject.put("timestamp", l2);
            }
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public InstrumentData(Throwable th, Type type, a aVar) {
        this.b = type;
        this.d = Utility.getAppVersion();
        this.e = InstrumentUtility.getCause(th);
        this.f = InstrumentUtility.getStackTrace(th);
        this.g = Long.valueOf(System.currentTimeMillis() / 1000);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(type.getLogPrefix());
        stringBuffer.append(this.g.toString());
        stringBuffer.append(".json");
        this.a = stringBuffer.toString();
    }

    public InstrumentData(File file, a aVar) {
        Type type;
        String name = file.getName();
        this.a = name;
        if (name.startsWith(InstrumentUtility.CRASH_REPORT_PREFIX)) {
            type = Type.CrashReport;
        } else if (name.startsWith(InstrumentUtility.CRASH_SHIELD_PREFIX)) {
            type = Type.CrashShield;
        } else if (name.startsWith(InstrumentUtility.THREAD_CHECK_PREFIX)) {
            type = Type.ThreadCheck;
        } else if (name.startsWith(InstrumentUtility.ANALYSIS_REPORT_PREFIX)) {
            type = Type.Analysis;
        } else {
            type = Type.Unknown;
        }
        this.b = type;
        JSONObject readFile = InstrumentUtility.readFile(this.a, true);
        if (readFile != null) {
            this.g = Long.valueOf(readFile.optLong("timestamp", 0));
            this.d = readFile.optString(Preference.APP_VERSION, null);
            this.e = readFile.optString("reason", null);
            this.f = readFile.optString("callstack", null);
            this.c = readFile.optJSONArray("feature_names");
        }
    }
}
