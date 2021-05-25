package com.avito.android.remote;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/DeviceIdProviderImpl;", "Lcom/avito/android/remote/DeviceIdProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Landroid/content/ContentResolver;", "contentResolver", "deviceIdFromFeatures", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Landroid/content/ContentResolver;Ljava/lang/String;)V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public final class DeviceIdProviderImpl implements DeviceIdProvider {
    @NotNull
    public final String a;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if ((r6.length() != 0 ? false : r1) != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        if ((r7.length() == 0) != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceIdProviderImpl(@org.jetbrains.annotations.NotNull com.avito.android.util.preferences.Preferences r5, @org.jetbrains.annotations.NotNull android.content.ContentResolver r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            r4 = this;
            java.lang.String r0 = "preferences"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "contentResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "deviceIdFromFeatures"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r4.<init>()
            boolean r0 = t6.y.m.isBlank(r7)
            if (r0 == 0) goto L_0x004c
            r7 = 0
            java.lang.String r0 = "device_id"
            java.lang.String r7 = r5.getString(r0, r7)
            r1 = 1
            r2 = 0
            if (r7 == 0) goto L_0x002e
            int r3 = r7.length()
            if (r3 != 0) goto L_0x002b
            r3 = 1
            goto L_0x002c
        L_0x002b:
            r3 = 0
        L_0x002c:
            if (r3 == 0) goto L_0x004c
        L_0x002e:
            java.lang.String r7 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)
            if (r6 == 0) goto L_0x0040
            int r7 = r6.length()
            if (r7 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            if (r1 == 0) goto L_0x0048
        L_0x0040:
            java.util.UUID r6 = java.util.UUID.randomUUID()
            java.lang.String r6 = r6.toString()
        L_0x0048:
            r7 = r6
            r5.putString(r0, r7)
        L_0x004c:
            r4.a = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.DeviceIdProviderImpl.<init>(com.avito.android.util.preferences.Preferences, android.content.ContentResolver, java.lang.String):void");
    }

    @Override // com.avito.android.remote.DeviceIdProvider
    @NotNull
    public String getValue() {
        return this.a;
    }
}
