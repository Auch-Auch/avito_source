package com.yandex.metrica;

import android.content.ContentValues;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.avito.android.remote.model.category_parameters.DateTimeParameterKt;
import com.yandex.metrica.impl.ob.ab;
import com.yandex.metrica.impl.ob.dl;
import com.yandex.metrica.impl.ob.qp;
@Deprecated
public class CounterConfiguration implements Parcelable {
    public static final Parcelable.Creator<CounterConfiguration> CREATOR = new b();
    public final ContentValues a;

    public enum a {
        MAIN("main"),
        MANUAL("manual"),
        APPMETRICA("appmetrica"),
        COMMUTATION("commutation"),
        SELF_DIAGNOSTIC_MAIN("self_diagnostic_main"),
        SELF_DIAGNOSTIC_MANUAL("self_diagnostic_manual");
        
        @NonNull
        public final String g;

        /* access modifiers changed from: public */
        a(String str) {
            this.g = str;
        }

        @NonNull
        public String a() {
            return this.g;
        }

        @NonNull
        public static a a(@Nullable String str) {
            a[] values = values();
            for (int i = 0; i < 6; i++) {
                a aVar = values[i];
                if (aVar.g.equals(str)) {
                    return aVar;
                }
            }
            return MAIN;
        }
    }

    public static class b implements Parcelable.Creator<CounterConfiguration> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public CounterConfiguration createFromParcel(Parcel parcel) {
            return new CounterConfiguration((ContentValues) parcel.readBundle(ab.class.getClassLoader()).getParcelable("com.yandex.metrica.CounterConfiguration.data"));
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public CounterConfiguration[] newArray(int i) {
            return new CounterConfiguration[i];
        }
    }

    public CounterConfiguration(@NonNull CounterConfiguration counterConfiguration) {
        synchronized (counterConfiguration) {
            this.a = new ContentValues(counterConfiguration.a);
            s();
        }
    }

    @VisibleForTesting
    public synchronized void a(int i) {
        this.a.put("CFG_DISPATCH_PERIOD", Integer.valueOf(i));
    }

    @VisibleForTesting
    public synchronized void b(int i) {
        ContentValues contentValues = this.a;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        contentValues.put("CFG_MAX_REPORTS_COUNT", Integer.valueOf(i));
    }

    @VisibleForTesting
    public synchronized void c(int i) {
        this.a.put("CFG_SESSION_TIMEOUT", Integer.valueOf(i));
    }

    @Nullable
    public String d() {
        return this.a.getAsString("CFG_DEVICE_SIZE_TYPE");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.a.getAsString("CFG_API_KEY");
    }

    @Nullable
    public Boolean f() {
        return this.a.getAsBoolean("CFG_LOCATION_TRACKING");
    }

    public String g() {
        return this.a.getAsString("CFG_APP_VERSION");
    }

    public String h() {
        return this.a.getAsString("CFG_APP_VERSION_CODE");
    }

    @Nullable
    public Boolean i() {
        return this.a.getAsBoolean("CFG_COLLECT_INSTALLED_APPS");
    }

    @Nullable
    public Boolean j() {
        return this.a.getAsBoolean("CFG_IS_LOG_ENABLED");
    }

    public Location k() {
        if (this.a.containsKey("CFG_MANUAL_LOCATION")) {
            return qp.a(this.a.getAsByteArray("CFG_MANUAL_LOCATION"));
        }
        return null;
    }

    @Nullable
    public Boolean l() {
        return this.a.getAsBoolean("CFG_AUTO_PRELOAD_INFO_DETECTION");
    }

    @Nullable
    public Boolean m() {
        return this.a.getAsBoolean("CFG_NATIVE_CRASHES_ENABLED");
    }

    @Nullable
    public Boolean n() {
        return this.a.getAsBoolean("CFG_LOCATION_ALLOWED_BY_BRIDGE");
    }

    @Nullable
    public Boolean o() {
        return this.a.getAsBoolean("CFG_IS_FIRST_ACTIVATION_AS_UPDATE");
    }

    @Nullable
    public Integer p() {
        return this.a.getAsInteger("MAX_REPORTS_IN_DB_COUNT");
    }

    public Boolean q() {
        return this.a.getAsBoolean("CFG_STATISTICS_SENDING");
    }

    @NonNull
    public a r() {
        return a.a(this.a.getAsString("CFG_REPORTER_TYPE"));
    }

    public final void s() {
        if (!this.a.containsKey("CFG_REPORTER_TYPE")) {
            if (this.a.containsKey("CFG_MAIN_REPORTER")) {
                if (this.a.getAsBoolean("CFG_MAIN_REPORTER").booleanValue()) {
                    a(a.MAIN);
                } else if ("20799a27-fa80-4b36-b2db-0f8141f24180".equals(e())) {
                    a(a.APPMETRICA);
                } else {
                    a(a.MANUAL);
                }
            } else if (this.a.containsKey("CFG_COMMUTATION_REPORTER") && this.a.getAsBoolean("CFG_COMMUTATION_REPORTER").booleanValue()) {
                a(a.COMMUTATION);
            }
        }
    }

    @Override // java.lang.Object
    public synchronized String toString() {
        return "CounterConfiguration{mParamsMapping=" + this.a + '}';
    }

    @Override // android.os.Parcelable
    public synchronized void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.yandex.metrica.CounterConfiguration.data", this.a);
        parcel.writeBundle(bundle);
    }

    public final synchronized void d(String str) {
        this.a.put("CFG_APP_VERSION", str);
    }

    public synchronized void e(boolean z) {
        this.a.put("CFG_AUTO_PRELOAD_INFO_DETECTION", Boolean.valueOf(z));
    }

    public synchronized void f(boolean z) {
        this.a.put("CFG_PERMISSIONS_COLLECTING", Boolean.valueOf(z));
    }

    public final synchronized void g(boolean z) {
        this.a.put("CFG_IS_FIRST_ACTIVATION_AS_UPDATE", Boolean.valueOf(z));
    }

    public final synchronized void h(boolean z) {
        this.a.put("CFG_STATISTICS_SENDING", Boolean.valueOf(z));
    }

    @Nullable
    public Integer a() {
        return this.a.getAsInteger("CFG_DISPATCH_PERIOD");
    }

    @Nullable
    public Integer b() {
        return this.a.getAsInteger("CFG_MAX_REPORTS_COUNT");
    }

    @Nullable
    public Integer c() {
        return this.a.getAsInteger("CFG_SESSION_TIMEOUT");
    }

    public final synchronized void a(@Nullable String str) {
        ContentValues contentValues = this.a;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        contentValues.put("CFG_DEVICE_SIZE_TYPE", str);
    }

    @VisibleForTesting
    public synchronized void b(String str) {
        this.a.put("CFG_API_KEY", str);
    }

    public synchronized void c(String str) {
        this.a.put("CFG_UUID", str);
    }

    public synchronized void d(int i) {
        this.a.put("CFG_APP_VERSION_CODE", String.valueOf(i));
    }

    public CounterConfiguration() {
        this.a = new ContentValues();
    }

    public synchronized void a(boolean z) {
        this.a.put("CFG_LOCATION_TRACKING", Boolean.valueOf(z));
    }

    public synchronized void b(boolean z) {
        this.a.put("CFG_LOCATION_ALLOWED_BY_BRIDGE", Boolean.valueOf(z));
    }

    public synchronized void c(boolean z) {
        this.a.put("CFG_COLLECT_INSTALLED_APPS", Boolean.valueOf(z));
    }

    public synchronized void d(boolean z) {
        this.a.put("CFG_IS_LOG_ENABLED", Boolean.valueOf(z));
    }

    public CounterConfiguration(@NonNull String str) {
        this();
        synchronized (this) {
            b(str);
        }
    }

    public static CounterConfiguration c(Bundle bundle) {
        CounterConfiguration counterConfiguration = null;
        if (bundle != null) {
            try {
                counterConfiguration = (CounterConfiguration) bundle.getParcelable("COUNTER_CFG_OBJ");
            } catch (Throwable unused) {
                return null;
            }
        }
        if (counterConfiguration == null) {
            counterConfiguration = new CounterConfiguration();
        }
        counterConfiguration.b(bundle);
        return counterConfiguration;
    }

    public final synchronized void a(Location location) {
        this.a.put("CFG_MANUAL_LOCATION", qp.a(location));
    }

    public synchronized void b(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getInt("CFG_DISPATCH_PERIOD") != 0) {
                a(bundle.getInt("CFG_DISPATCH_PERIOD"));
            }
            if (bundle.getInt("CFG_SESSION_TIMEOUT") != 0) {
                c(bundle.getInt("CFG_SESSION_TIMEOUT"));
            }
            if (bundle.getInt("CFG_MAX_REPORTS_COUNT") != 0) {
                b(bundle.getInt("CFG_MAX_REPORTS_COUNT"));
            }
            if (bundle.getString("CFG_API_KEY") != null && !DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME.equals(bundle.getString("CFG_API_KEY"))) {
                b(bundle.getString("CFG_API_KEY"));
            }
        }
    }

    public synchronized void a(@NonNull a aVar) {
        this.a.put("CFG_REPORTER_TYPE", aVar.a());
    }

    public CounterConfiguration(j jVar) {
        this();
        synchronized (this) {
            String str = jVar.apiKey;
            if (dl.a((Object) str)) {
                b(str);
            }
            Integer num = jVar.sessionTimeout;
            if (dl.a(num)) {
                c(num.intValue());
            }
            if (dl.a(jVar.location)) {
                a(jVar.location);
            }
            if (dl.a(jVar.locationTracking)) {
                a(jVar.locationTracking.booleanValue());
            }
            if (dl.a(jVar.installedAppCollecting)) {
                c(jVar.installedAppCollecting.booleanValue());
            }
            if (dl.a((Object) jVar.a)) {
                a(jVar.a);
            }
            Integer num2 = jVar.f;
            if (dl.a(num2)) {
                a(num2.intValue());
            }
            Integer num3 = jVar.g;
            if (dl.a(num3)) {
                b(num3.intValue());
            }
            if (!TextUtils.isEmpty(jVar.appVersion)) {
                d(jVar.appVersion);
            }
            if (dl.a(jVar.e)) {
                d(jVar.e.intValue());
            }
            if (dl.a(jVar.j)) {
                e(jVar.j.booleanValue());
            }
            if (dl.a(jVar.k)) {
                f(jVar.k.booleanValue());
            }
            if (dl.a(jVar.firstActivationAsUpdate)) {
                g(jVar.firstActivationAsUpdate.booleanValue());
            }
            Boolean bool = jVar.statisticsSending;
            if (dl.a(bool)) {
                h(bool.booleanValue());
            }
            Integer num4 = jVar.maxReportsInDatabaseCount;
            if (dl.a(num4)) {
                this.a.put("MAX_REPORTS_IN_DB_COUNT", num4);
            }
            Boolean bool2 = jVar.nativeCrashReporting;
            if (dl.a(bool2)) {
                this.a.put("CFG_NATIVE_CRASHES_ENABLED", bool2);
            }
            a(a.MAIN);
        }
    }

    public synchronized void a(Bundle bundle) {
        bundle.putParcelable("COUNTER_CFG_OBJ", this);
    }

    public CounterConfiguration(@NonNull f fVar) {
        this();
        synchronized (this) {
            String str = fVar.apiKey;
            if (dl.a((Object) str)) {
                b(str);
            }
            Integer num = fVar.sessionTimeout;
            if (dl.a(num)) {
                c(num.intValue());
            }
            Integer num2 = fVar.a;
            if (dl.a(num2)) {
                a(num2.intValue());
            }
            Integer num3 = fVar.b;
            if (dl.a(num3)) {
                b(num3.intValue());
            }
            Boolean bool = fVar.logs;
            if (dl.a(bool)) {
                d(bool.booleanValue());
            }
            Boolean bool2 = fVar.statisticsSending;
            if (dl.a(bool2)) {
                h(bool2.booleanValue());
            }
            Integer num4 = fVar.maxReportsInDatabaseCount;
            if (dl.a(num4)) {
                this.a.put("MAX_REPORTS_IN_DB_COUNT", num4);
            }
            if ("20799a27-fa80-4b36-b2db-0f8141f24180".equals(fVar.apiKey)) {
                a(a.APPMETRICA);
            } else {
                a(a.MANUAL);
            }
        }
    }

    @VisibleForTesting
    public CounterConfiguration(ContentValues contentValues) {
        this.a = contentValues;
        s();
    }
}
