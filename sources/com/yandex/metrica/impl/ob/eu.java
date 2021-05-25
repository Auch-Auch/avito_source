package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.j;
import java.util.List;
import java.util.Map;
import java.util.UUID;
public class eu implements Parcelable {
    public static final Parcelable.Creator<eu> CREATOR = new Parcelable.Creator<eu>() { // from class: com.yandex.metrica.impl.ob.eu.1
        /* renamed from: a */
        public eu createFromParcel(Parcel parcel) {
            Bundle readBundle = parcel.readBundle(ab.class.getClassLoader());
            return new eu((ContentValues) readBundle.getParcelable("CFG_KEY_PROCESS_ENVIRONMENT"), (ResultReceiver) readBundle.getParcelable("CFG_KEY_PROCESS_ENVIRONMENT_RECEIVER"));
        }

        /* renamed from: a */
        public eu[] newArray(int i) {
            return new eu[i];
        }
    };
    public static final String a = UUID.randomUUID().toString();
    @NonNull
    private final ContentValues b;
    @Nullable
    private ResultReceiver c;

    public eu(Context context, @Nullable ResultReceiver resultReceiver) {
        ContentValues contentValues = new ContentValues();
        this.b = contentValues;
        contentValues.put("PROCESS_CFG_PROCESS_ID", Integer.valueOf(Process.myPid()));
        contentValues.put("PROCESS_CFG_PROCESS_SESSION_ID", a);
        contentValues.put("PROCESS_CFG_SDK_API_LEVEL", (Integer) 87);
        contentValues.put("PROCESS_CFG_PACKAGE_NAME", context.getPackageName());
        this.c = resultReceiver;
    }

    @Nullable
    public static eu a(Bundle bundle) {
        if (bundle != null) {
            try {
                return (eu) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private void b(@NonNull j jVar) {
        if (dl.a((Object) jVar.d)) {
            a(jVar.d);
        }
    }

    private void c(@NonNull j jVar) {
        if (dl.a((Object) jVar.b)) {
            a(abq.c(jVar.b));
        }
    }

    private void d(@NonNull j jVar) {
        if (dl.a((Object) jVar.c)) {
            a(jVar.c);
            b(bd.API.d);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String e() {
        return this.b.getAsString("PROCESS_CFG_INSTALL_REFERRER_SOURCE");
    }

    @NonNull
    public Integer f() {
        return this.b.getAsInteger("PROCESS_CFG_PROCESS_ID");
    }

    @NonNull
    public String g() {
        return this.b.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
    }

    public int h() {
        return this.b.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue();
    }

    @NonNull
    public String i() {
        return this.b.getAsString("PROCESS_CFG_PACKAGE_NAME");
    }

    @Nullable
    public ResultReceiver j() {
        return this.c;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a.L("ProcessConfiguration{mParamsMapping=");
        L.append(this.b);
        L.append(", mDataResultReceiver=");
        L.append(this.c);
        L.append('}');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("CFG_KEY_PROCESS_ENVIRONMENT", this.b);
        bundle.putParcelable("CFG_KEY_PROCESS_ENVIRONMENT_RECEIVER", this.c);
        parcel.writeBundle(bundle);
    }

    public void a(@Nullable j jVar) {
        if (jVar != null) {
            synchronized (this) {
                b(jVar);
                c(jVar);
                d(jVar);
            }
        }
    }

    @Nullable
    public List<String> b() {
        String asString = this.b.getAsString("PROCESS_CFG_CUSTOM_HOSTS");
        if (TextUtils.isEmpty(asString)) {
            return null;
        }
        return abc.c(asString);
    }

    @Nullable
    public Map<String, String> c() {
        return abc.a(this.b.getAsString("PROCESS_CFG_CLIDS"));
    }

    @Nullable
    public String d() {
        return this.b.getAsString("PROCESS_CFG_DISTRIBUTION_REFERRER");
    }

    public synchronized void b(@Nullable String str) {
        this.b.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
    }

    public boolean a() {
        return this.b.containsKey("PROCESS_CFG_CUSTOM_HOSTS");
    }

    public synchronized void b(@NonNull Bundle bundle) {
        bundle.putParcelable("PROCESS_CFG_OBJ", this);
    }

    public eu(eu euVar) {
        synchronized (euVar) {
            this.b = new ContentValues(euVar.b);
            this.c = euVar.c;
        }
    }

    public synchronized void a(@Nullable List<String> list) {
        this.b.put("PROCESS_CFG_CUSTOM_HOSTS", abc.a(list));
    }

    public synchronized void a(@Nullable Map<String, String> map) {
        this.b.put("PROCESS_CFG_CLIDS", abc.b(map));
    }

    public synchronized void a(@Nullable String str) {
        this.b.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
    }

    public eu(@NonNull ContentValues contentValues, @Nullable ResultReceiver resultReceiver) {
        this.b = contentValues == null ? new ContentValues() : contentValues;
        this.c = resultReceiver;
    }
}
