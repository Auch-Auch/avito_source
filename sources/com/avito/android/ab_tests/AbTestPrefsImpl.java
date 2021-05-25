package com.avito.android.ab_tests;

import a2.b.a.a.a;
import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.ab_tests.AbTest;
import com.avito.android.remote.model.ab_tests.AbTestsConfigResponse;
import com.avito.android.remote.model.ab_tests.AnalyticsParams;
import com.avito.android.util.GsonsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.Preferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dagger.Lazy;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001d\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/ab_tests/AbTestPrefsImpl;", "Lcom/avito/android/ab_tests/AbTestPrefs;", "Lcom/avito/android/remote/model/ab_tests/AbTestsConfigResponse;", Navigation.CONFIG, "", "store", "(Lcom/avito/android/remote/model/ab_tests/AbTestsConfigResponse;)V", "", "key", "Lcom/avito/android/remote/model/ab_tests/AbTest;", "getAbTest", "(Ljava/lang/String;)Lcom/avito/android/remote/model/ab_tests/AbTest;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/avito/android/ab_tests/ABTestConfigTracker;", "c", "Lcom/avito/android/ab_tests/ABTestConfigTracker;", "abTestConfigTracker", "Ldagger/Lazy;", "Lcom/google/gson/Gson;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "getGson", "()Ldagger/Lazy;", "gson", "Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/util/preferences/Preferences;", "getPrefs", "()Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Ldagger/Lazy;Lcom/avito/android/ab_tests/ABTestConfigTracker;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class AbTestPrefsImpl implements AbTestPrefs {
    @NotNull
    public final Preferences a;
    @NotNull
    public final Lazy<Gson> b;
    public final ABTestConfigTracker c;

    public AbTestPrefsImpl(@NotNull Preferences preferences, @NotNull Lazy<Gson> lazy, @NotNull ABTestConfigTracker aBTestConfigTracker) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        Intrinsics.checkNotNullParameter(lazy, "gson");
        Intrinsics.checkNotNullParameter(aBTestConfigTracker, "abTestConfigTracker");
        this.a = preferences;
        this.b = lazy;
        this.c = aBTestConfigTracker;
    }

    public final String a(String str) {
        return a.c3(str, "_TEST_GROUP");
    }

    @Override // com.avito.android.ab_tests.AbTestPrefs
    @Nullable
    public AbTest getAbTest(@NotNull String str) {
        String asString;
        Type type;
        Intrinsics.checkNotNullParameter(str, "key");
        AnalyticsParams analyticsParams = null;
        if (this.a.contains(str)) {
            String asString2 = this.a.getAsString(str);
            if (asString2 != null) {
                try {
                    this.c.trackAbTestConfigGsonFallback();
                    Gson gson = this.b.get();
                    Intrinsics.checkNotNullExpressionValue(gson, "gson.get()");
                    Gson gson2 = gson;
                    Type type2 = new TypeToken<AbTest>() { // from class: com.avito.android.ab_tests.AbTestPrefsImpl$$special$$inlined$fromJson$1
                    }.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
                    if (!(type2 instanceof ParameterizedType) || !GsonsKt.isWildcard((ParameterizedType) type2)) {
                        type = GsonsKt.removeTypeWildcards(type2);
                    } else {
                        type = ((ParameterizedType) type2).getRawType();
                        Intrinsics.checkNotNullExpressionValue(type, "type.rawType");
                    }
                    Object fromJson = gson2.fromJson(asString2, type);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
                    return (AbTest) fromJson;
                } catch (Exception unused) {
                    Logs.error$default("PrefsAbConfig: error to parse abTest " + str, null, 2, null);
                }
            }
        } else if (this.a.contains(a(str)) && (asString = this.a.getAsString(a(str))) != null) {
            Preferences preferences = this.a;
            String asString3 = preferences.getAsString(str + "_AB_TOKEN");
            Preferences preferences2 = this.a;
            boolean z = preferences2.getBoolean(str + "_CLIENT_EXPOSURE", false);
            Preferences preferences3 = this.a;
            String string = preferences3.getString(str + "_CONFIG");
            if (asString3 != null) {
                analyticsParams = new AnalyticsParams(asString3, z);
            }
            return new AbTest(asString, analyticsParams, string);
        }
        return null;
    }

    @NotNull
    public final Lazy<Gson> getGson() {
        return this.b;
    }

    @NotNull
    public final Preferences getPrefs() {
        return this.a;
    }

    @Override // com.avito.android.ab_tests.AbTestPrefs
    public void store(@NotNull AbTestsConfigResponse abTestsConfigResponse) {
        AnalyticsParams analyticParams;
        AnalyticsParams analyticParams2;
        String abToken;
        String testConfig;
        String testGroup;
        Intrinsics.checkNotNullParameter(abTestsConfigResponse, Navigation.CONFIG);
        this.c.trackAbTestConfigStore();
        SharedPreferences.Editor edit = this.a.getSharedPreferences().edit();
        edit.clear();
        for (String str : abTestsConfigResponse.getAllKeys()) {
            AbTest abTest = abTestsConfigResponse.getAbTest(str);
            StringBuilder Q = a.Q(str, ": ");
            Q.append(abTest != null ? abTest.getTestGroup() : null);
            Logs.debug$default("AB_TEST", Q.toString(), null, 4, null);
            if (!(abTest == null || (testGroup = abTest.getTestGroup()) == null)) {
                edit.putString(a(str), testGroup);
            }
            if (!(abTest == null || (testConfig = abTest.getTestConfig()) == null)) {
                edit.putString(str + "_CONFIG", testConfig);
            }
            if (!(abTest == null || (analyticParams2 = abTest.getAnalyticParams()) == null || (abToken = analyticParams2.getAbToken()) == null)) {
                edit.putString(str + "_AB_TOKEN", abToken);
            }
            if (!(abTest == null || (analyticParams = abTest.getAnalyticParams()) == null)) {
                boolean clientExposure = analyticParams.getClientExposure();
                edit.putBoolean(str + "_CLIENT_EXPOSURE", clientExposure);
            }
        }
        boolean z = false;
        if (abTestsConfigResponse.getAllKeys().size() == this.a.getAll().size()) {
            Iterator<String> it = this.a.getAll().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                String next = it.next();
                AbTest abTest2 = getAbTest(next);
                AbTest abTest3 = abTestsConfigResponse.getAbTest(next);
                if (abTest3 != null) {
                    if (!Intrinsics.areEqual(abTest2, abTest3)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            edit.putLong(AbTestPrefsKt.LAST_CONFIG_UPDATE_TIMESTAMP_IN_MILLIS, System.currentTimeMillis());
        }
        this.c.trackAbTestConfigChanged(z);
        edit.apply();
    }
}
