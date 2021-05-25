package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.sumsub.sns.R2;
import com.yandex.metrica.impl.ob.t;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
public final class al {
    public static final EnumSet<a> a;
    private static final EnumSet<a> b;
    private static final EnumSet<a> c;
    private static final EnumSet<a> d;
    private static final EnumSet<a> e;
    private static final EnumSet<a> f = EnumSet.of(a.EVENT_TYPE_DIAGNOSTIC, a.EVENT_TYPE_DIAGNOSTIC_STATBOX, a.EVENT_TYPE_DIAGNOSTIC_DISABLE_STAT_SENDING);
    private static final EnumSet<a> g;
    private static final EnumSet<a> h;

    @SuppressLint({"UseSparseArrays"})
    public enum a {
        EVENT_TYPE_UNDEFINED(-1, "Unrecognized action"),
        EVENT_TYPE_INIT(0, "First initialization event"),
        EVENT_TYPE_REGULAR(1, "Regular event"),
        EVENT_TYPE_UPDATE_FOREGROUND_TIME(3, "Update foreground time"),
        EVENT_TYPE_EXCEPTION_USER(5, "Error from developer"),
        EVENT_TYPE_ALIVE(7, "App is still alive"),
        EVENT_TYPE_SET_USER_INFO(9, "User info"),
        EVENT_TYPE_REPORT_USER_INFO(10, "Report user info"),
        EVENT_TYPE_SEND_USER_PROFILE(40961, "Send user profile"),
        EVENT_TYPE_SET_USER_PROFILE_ID(40962, "Set user profile ID"),
        EVENT_TYPE_SEND_REVENUE_EVENT(40976, "Send revenue event"),
        EVENT_TYPE_PURGE_BUFFER(256, "Forcible buffer clearing"),
        EVENT_TYPE_PREV_SESSION_NATIVE_CRASH(768, "Native crash of app, read from file"),
        EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH(769, "Native crash of app, caught by FileObserver"),
        EVENT_TYPE_STARTUP(1536, "Sending the startup due to lack of data"),
        EVENT_TYPE_IDENTITY(1792, "System identification"),
        EVENT_TYPE_IDENTITY_LIGHT(1793, "Identity light"),
        EVENT_TYPE_DIAGNOSTIC(2048, "Diagnostic event"),
        EVENT_TYPE_DIAGNOSTIC_STATBOX(2049, "Diagnostic statbox event"),
        EVENT_TYPE_DIAGNOSTIC_DISABLE_STAT_SENDING(2050, "Disable stat send"),
        EVENT_TYPE_STATBOX(2304, "Event with statistical data"),
        EVENT_TYPE_REFERRER_RECEIVED_FROM_BROADCAST(4096, "Referrer received"),
        EVENT_TYPE_SEND_REFERRER(4097, "Send referrer"),
        EVENT_TYPE_REFERRER_OBTAINED_FROM_SERVICES(4098, "Referrer obtained"),
        EVENT_TYPE_APP_ENVIRONMENT_UPDATED(R2.styleable.StateListDrawable_android_constantSize, "App Environment Updated"),
        EVENT_TYPE_APP_ENVIRONMENT_CLEARED(5632, "App Environment Cleared"),
        EVENT_TYPE_EXCEPTION_UNHANDLED(5888, "Crash of App"),
        EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE(5889, "Crash of App, read from file"),
        EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT(5890, "Crash of App, passed to server via intent"),
        EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF(5891, "Crash of App"),
        EVENT_TYPE_EXCEPTION_USER_PROTOBUF(5892, "Error from developer"),
        EVENT_TYPE_ANR(5968, "ANR"),
        EVENT_TYPE_ACTIVATION(6144, "Activation of metrica"),
        EVENT_TYPE_FIRST_ACTIVATION(6145, "First activation of metrica"),
        EVENT_TYPE_START(6400, "Start of new session"),
        EVENT_TYPE_CUSTOM_EVENT(8192, "Custom event"),
        EVENT_TYPE_APP_OPEN(8208, "App open event"),
        EVENT_TYPE_APP_UPDATE(8224, "App update event"),
        EVENT_TYPE_PERMISSIONS(12288, "Permissions changed event"),
        EVENT_TYPE_APP_FEATURES(12289, "Features, required by application"),
        EVENT_TYPE_UPDATE_PRE_ACTIVATION_CONFIG(16384, "Update pre-activation config"),
        EVENT_TYPE_CLEANUP(12290, "Cleanup database"),
        EVENT_TYPE_VIEW_TREE(12291, "View tree event");
        
        public static final HashMap<Integer, a> R = new HashMap<>();
        private final int S;
        private final String T;

        /* access modifiers changed from: public */
        static {
            a[] values = values();
            for (int i = 0; i < 43; i++) {
                a aVar = values[i];
                R.put(Integer.valueOf(aVar.a()), aVar);
            }
        }

        private a(int i, String str) {
            this.S = i;
            this.T = str;
        }

        public int a() {
            return this.S;
        }

        public String b() {
            return this.T;
        }

        @NonNull
        public static a a(int i) {
            a aVar = R.get(Integer.valueOf(i));
            return aVar == null ? EVENT_TYPE_UNDEFINED : aVar;
        }
    }

    static {
        a aVar = a.EVENT_TYPE_UNDEFINED;
        a aVar2 = a.EVENT_TYPE_REFERRER_RECEIVED_FROM_BROADCAST;
        a aVar3 = a.EVENT_TYPE_SEND_REFERRER;
        a aVar4 = a.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        a aVar5 = a.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        a aVar6 = a.EVENT_TYPE_ACTIVATION;
        a aVar7 = a.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH;
        b = EnumSet.of(aVar, a.EVENT_TYPE_PURGE_BUFFER, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
        a aVar8 = a.EVENT_TYPE_SET_USER_INFO;
        a aVar9 = a.EVENT_TYPE_REPORT_USER_INFO;
        a aVar10 = a.EVENT_TYPE_INIT;
        a aVar11 = a.EVENT_TYPE_APP_UPDATE;
        c = EnumSet.of(aVar8, aVar9, a.EVENT_TYPE_IDENTITY, aVar, aVar10, aVar11, aVar3, a.EVENT_TYPE_ALIVE, a.EVENT_TYPE_STARTUP, aVar4, aVar5, aVar6, aVar7);
        a aVar12 = a.EVENT_TYPE_UPDATE_FOREGROUND_TIME;
        a aVar13 = a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        d = EnumSet.of(aVar12, aVar8, aVar9, aVar13);
        a = EnumSet.of(aVar10, a.EVENT_TYPE_FIRST_ACTIVATION, aVar2, aVar3, aVar11, a.EVENT_TYPE_CLEANUP);
        a aVar14 = a.EVENT_TYPE_EXCEPTION_UNHANDLED;
        a aVar15 = a.EVENT_TYPE_REGULAR;
        e = EnumSet.of(aVar14, aVar13, a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT, a.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, a.EVENT_TYPE_EXCEPTION_USER, a.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, aVar7, a.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH, aVar15);
        g = EnumSet.of(aVar15);
        h = EnumSet.of(aVar7);
    }

    public static boolean a(a aVar) {
        return !b.contains(aVar);
    }

    public static boolean b(a aVar) {
        return !c.contains(aVar);
    }

    public static boolean c(int i) {
        return g.contains(a.a(i));
    }

    public static boolean d(int i) {
        return f.contains(a.a(i));
    }

    public static boolean e(int i) {
        return !h.contains(a.a(i));
    }

    public static aa f(String str, @NonNull abl abl) {
        return new t("", str, a.EVENT_TYPE_REFERRER_RECEIVED_FROM_BROADCAST.a(), abl);
    }

    public static aa g(String str, @NonNull abl abl) {
        return c("open", str, abl);
    }

    public static aa h(String str, @NonNull abl abl) {
        return c("referral", str, abl);
    }

    public static aa i(@NonNull String str, @NonNull abl abl) {
        return new t(str, "", a.EVENT_TYPE_CLEANUP.a(), abl);
    }

    public static boolean a(int i) {
        return d.contains(a.a(i));
    }

    public static boolean b(int i) {
        return e.contains(a.a(i));
    }

    public static aa c(String str, @NonNull abl abl) {
        return new t(str, a.EVENT_TYPE_REGULAR.a(), abl);
    }

    public static aa d(String str, @NonNull abl abl) {
        return new t(str, a.EVENT_TYPE_START.a(), abl);
    }

    public static aa e(String str, @NonNull abl abl) {
        return new t(str, a.EVENT_TYPE_UPDATE_FOREGROUND_TIME.a(), abl);
    }

    public static aa a(@NonNull String str, @NonNull abl abl) {
        return a(a.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH, str, abl);
    }

    public static aa b(@NonNull String str, @NonNull abl abl) {
        return a(a.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH, str, abl);
    }

    public static aa c(String str, String str2, @NonNull abl abl) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("link", str2);
        return new t(abc.b(hashMap), "", a.EVENT_TYPE_APP_OPEN.a(), abl);
    }

    public static aa a(a aVar, String str, @NonNull abl abl) {
        return new t(str, "", aVar.a(), abl);
    }

    public static aa b(String str, String str2, @NonNull abl abl) {
        return new t(str2, str, a.EVENT_TYPE_STATBOX.a(), abl);
    }

    public static aa a(a aVar, @NonNull abl abl) {
        return new t("", aVar.a(), abl);
    }

    public static t b(String str, byte[] bArr, @NonNull abl abl) {
        return a(bArr, str, a.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, abl);
    }

    public static aa a(String str, String str2, @NonNull abl abl) {
        return new t(str2, str, a.EVENT_TYPE_REGULAR.a(), abl);
    }

    public static aa a(@NonNull String str, @Nullable String str2) {
        return new aa(str2, str, a.EVENT_TYPE_DIAGNOSTIC.a());
    }

    public static aa a() {
        aa a3 = new aa().a(a.EVENT_TYPE_DIAGNOSTIC_DISABLE_STAT_SENDING.a());
        try {
            a3.c(abc.a().toString());
        } catch (Throwable unused) {
        }
        return a3;
    }

    public static aa a(byte[] bArr, @NonNull abl abl) {
        return new t(bArr, "", a.EVENT_TYPE_ANR.a(), abl);
    }

    public static aa a(String str, byte[] bArr, @NonNull abl abl) {
        return new t(bArr, str, a.EVENT_TYPE_EXCEPTION_USER_PROTOBUF.a(), abl);
    }

    public static aa a(String str, byte[] bArr, int i, @NonNull HashMap<t.a, Integer> hashMap, @NonNull abl abl) {
        return a(bArr, str, a.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, abl).a(hashMap).c(i);
    }

    private static t a(byte[] bArr, String str, a aVar, @NonNull abl abl) {
        return new t(bArr, str, aVar.a(), abl);
    }

    public static aa a(@Nullable vu vuVar, @NonNull abl abl) {
        if (vuVar == null) {
            return new t("", a.EVENT_TYPE_REFERRER_OBTAINED_FROM_SERVICES.a(), abl);
        }
        return new t(vuVar.a, a.EVENT_TYPE_REFERRER_OBTAINED_FROM_SERVICES.a(), abl).a(vuVar.a());
    }

    public static aa a(ch chVar, @NonNull abl abl) {
        return new t(chVar == null ? "" : chVar.a(), "", a.EVENT_TYPE_ACTIVATION.a(), abl);
    }

    public static aa a(@NonNull JSONObject jSONObject, @NonNull abl abl) {
        return new t(jSONObject.toString(), "view_tree", a.EVENT_TYPE_VIEW_TREE.a(), abl);
    }

    public static aa a(int i, String str, String str2, Map<String, Object> map, @NonNull abl abl) {
        return new t(str2, str, a.EVENT_TYPE_CUSTOM_EVENT.a(), i, abl).e(abc.b(map));
    }
}
