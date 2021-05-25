package a2.a.a.w0;

import android.location.Location;
import android.os.Message;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.geo.GeoProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.WeakHandler;
public abstract class a implements GeoProvider {
    @Nullable
    public final GeoProvider.GeoListener a;
    public final WeakHandler b;
    public final TimeSource c;
    @Nullable
    public Location d;
    public int e = 0;
    public final WeakHandler.MessageListener f;

    /* renamed from: a2.a.a.w0.a$a  reason: collision with other inner class name */
    public class C0009a implements WeakHandler.MessageListener {
        public C0009a() {
        }

        @Override // com.avito.android.util.WeakHandler.MessageListener
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                a.this.dismissUpdate();
            }
        }
    }

    public a(@Nullable GeoProvider.GeoListener geoListener, WeakHandler weakHandler, TimeSource timeSource) {
        C0009a aVar = new C0009a();
        this.f = aVar;
        this.a = geoListener;
        this.b = weakHandler;
        weakHandler.setListener(aVar);
        this.c = timeSource;
    }

    public abstract void a();

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0074, code lost:
        if (r9 == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007b, code lost:
        if (r0 != false) goto L_0x007d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(@androidx.annotation.Nullable android.location.Location r13) {
        /*
            r12 = this;
            java.lang.String r0 = "onLocationUpdated: "
            java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
            java.lang.String r1 = com.avito.android.util.GeoLocations.print(r13)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "BaseGeoProvider"
            com.avito.android.util.Logs.debug(r1, r0)
            if (r13 != 0) goto L_0x0019
            return
        L_0x0019:
            android.location.Location r0 = r12.d
            r1 = 120000(0x1d4c0, double:5.9288E-319)
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L_0x0024
            goto L_0x007d
        L_0x0024:
            if (r13 != r0) goto L_0x0027
            goto L_0x007f
        L_0x0027:
            long r5 = r13.getTime()
            long r7 = r0.getTime()
            long r5 = r5 - r7
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 <= 0) goto L_0x0036
            r7 = 1
            goto L_0x0037
        L_0x0036:
            r7 = 0
        L_0x0037:
            r8 = -120000(0xfffffffffffe2b40, double:NaN)
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x0040
            r8 = 1
            goto L_0x0041
        L_0x0040:
            r8 = 0
        L_0x0041:
            r9 = 0
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0049
            r5 = 1
            goto L_0x004a
        L_0x0049:
            r5 = 0
        L_0x004a:
            float r6 = r13.getAccuracy()
            float r9 = r0.getAccuracy()
            float r6 = r6 - r9
            int r6 = (int) r6
            if (r6 <= 0) goto L_0x0058
            r9 = 1
            goto L_0x0059
        L_0x0058:
            r9 = 0
        L_0x0059:
            if (r6 >= 0) goto L_0x005d
            r10 = 1
            goto L_0x005e
        L_0x005d:
            r10 = 0
        L_0x005e:
            r11 = 200(0xc8, float:2.8E-43)
            if (r6 <= r11) goto L_0x0064
            r6 = 1
            goto L_0x0065
        L_0x0064:
            r6 = 0
        L_0x0065:
            if (r7 == 0) goto L_0x0068
            goto L_0x007d
        L_0x0068:
            if (r8 == 0) goto L_0x006b
            goto L_0x007f
        L_0x006b:
            boolean r0 = com.avito.android.util.GeoLocations.fromSameProvider(r13, r0)
            if (r10 == 0) goto L_0x0072
            goto L_0x007d
        L_0x0072:
            if (r5 == 0) goto L_0x0077
            if (r9 != 0) goto L_0x0077
            goto L_0x007d
        L_0x0077:
            if (r5 == 0) goto L_0x007f
            if (r6 != 0) goto L_0x007f
            if (r0 == 0) goto L_0x007f
        L_0x007d:
            r0 = 1
            goto L_0x0080
        L_0x007f:
            r0 = 0
        L_0x0080:
            if (r0 == 0) goto L_0x008b
            r12.d = r13
            com.avito.android.geo.GeoProvider$GeoListener r0 = r12.a
            if (r0 == 0) goto L_0x008b
            r0.onLocationImproved(r13)
        L_0x008b:
            android.location.Location r13 = r12.d
            if (r13 != 0) goto L_0x0090
            goto L_0x00ae
        L_0x0090:
            long r5 = r13.getTime()
            com.avito.android.server_time.TimeSource r0 = r12.c
            long r7 = r0.now()
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            float r13 = r13.getAccuracy()
            r0 = 1120403456(0x42c80000, float:100.0)
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 >= 0) goto L_0x00ae
            int r13 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x00ae
            r3 = 1
        L_0x00ae:
            if (r3 == 0) goto L_0x00b7
            r0 = 3000(0xbb8, double:1.482E-320)
            com.avito.android.util.WeakHandler r13 = r12.b
            r13.scheduleEmptyMessageDelayed(r4, r0)
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.w0.a.b(android.location.Location):void");
    }

    public abstract void c();

    public abstract void d(@NonNull String str);

    @Override // com.avito.android.geo.GeoProvider
    @CallSuper
    public final void dismissUpdate() {
        try {
            this.b.deleteCallbacksAndMessages();
            a();
        } finally {
            GeoProvider.GeoListener geoListener = this.a;
            if (geoListener != null) {
                geoListener.onUpdateFinished(this.d);
            }
        }
    }

    @Override // com.avito.android.geo.GeoProvider
    public final void startUpdate(Location location, long j, int i) {
        this.e = i;
        b(location);
        this.b.scheduleEmptyMessageDelayed(1, j);
        c();
    }
}
