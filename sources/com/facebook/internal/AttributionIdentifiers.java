package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
public class AttributionIdentifiers {
    public static AttributionIdentifiers f;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public long e;

    public static final class b implements ServiceConnection {
        public AtomicBoolean a = new AtomicBoolean(false);
        public final BlockingQueue<IBinder> b = new LinkedBlockingDeque();

        public b(a aVar) {
        }

        public IBinder a() throws InterruptedException {
            if (!this.a.compareAndSet(true, true)) {
                return this.b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.b.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static AttributionIdentifiers a(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.e = System.currentTimeMillis();
        f = attributionIdentifiers;
        return attributionIdentifiers;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038 A[Catch:{ Exception -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[Catch:{ Exception -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012f A[Catch:{ Exception -> 0x01f9, all -> 0x01f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0186 A[Catch:{ Exception -> 0x01f9, all -> 0x01f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x018f A[Catch:{ Exception -> 0x01f9, all -> 0x01f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0192 A[Catch:{ Exception -> 0x01f9, all -> 0x01f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0196 A[Catch:{ Exception -> 0x01f9, all -> 0x01f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x019a A[Catch:{ Exception -> 0x01f9, all -> 0x01f7 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r19) {
        /*
        // Method dump skipped, instructions count: 547
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
    }

    public static AttributionIdentifiers getCachedIdentifiers() {
        return f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isTrackingLimited(Context context) {
        AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
        return attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited();
    }

    public String getAndroidAdvertiserId() {
        if (!FacebookSdk.isInitialized() || !FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return null;
        }
        return this.b;
    }

    public String getAndroidInstallerPackage() {
        return this.c;
    }

    public String getAttributionId() {
        return this.a;
    }

    public boolean isTrackingLimited() {
        return this.d;
    }
}
