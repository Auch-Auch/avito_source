package com.yandex.metrica.gpllibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationListener;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
public class a implements b {
    @NonNull
    public final FusedLocationProviderClient a;
    @NonNull
    public final LocationListener b;
    @NonNull
    public final LocationCallback c;
    @NonNull
    public final Looper d;
    public final long e;

    /* renamed from: com.yandex.metrica.gpllibrary.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0333a {
        public static final /* synthetic */ int[] a;

        static {
            b.values();
            int[] iArr = new int[4];
            a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        PRIORITY_NO_POWER,
        PRIORITY_LOW_POWER,
        PRIORITY_BALANCED_POWER_ACCURACY,
        PRIORITY_HIGH_ACCURACY
    }

    public a(@NonNull Context context, @NonNull LocationListener locationListener, @NonNull Looper looper, long j) throws Throwable {
        this.a = new FusedLocationProviderClient(context);
        this.b = locationListener;
        this.d = looper;
        this.e = j;
        this.c = new com.yandex.metrica.n.a(locationListener);
    }

    @Override // com.yandex.metrica.gpllibrary.b
    @SuppressLint({"MissingPermission"})
    public void a() throws Throwable {
        this.a.getLastLocation().addOnSuccessListener(new com.yandex.metrica.n.b(this.b));
    }

    @Override // com.yandex.metrica.gpllibrary.b
    public void b() throws Throwable {
        this.a.removeLocationUpdates(this.c);
    }

    @Override // com.yandex.metrica.gpllibrary.b
    @SuppressLint({"MissingPermission"})
    public void a(@NonNull b bVar) throws Throwable {
        FusedLocationProviderClient fusedLocationProviderClient = this.a;
        LocationRequest interval = LocationRequest.create().setInterval(this.e);
        int i = C0333a.a[bVar.ordinal()];
        fusedLocationProviderClient.requestLocationUpdates(interval.setPriority(i != 1 ? i != 2 ? i != 3 ? 105 : 100 : 102 : 104), this.c, this.d);
    }
}
