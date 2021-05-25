package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
public final class DownloadNotificationHelper {
    public final NotificationCompat.Builder a;

    public DownloadNotificationHelper(Context context, String str) {
        this.a = new NotificationCompat.Builder(context.getApplicationContext(), str);
    }

    public final Notification a(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str, @StringRes int i2) {
        return b(context, i, pendingIntent, str, i2, 0, 0, false, false, true);
    }

    public final Notification b(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str, @StringRes int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        String str2;
        this.a.setSmallIcon(i);
        NotificationCompat.Builder builder = this.a;
        NotificationCompat.BigTextStyle bigTextStyle = null;
        if (i2 == 0) {
            str2 = null;
        } else {
            str2 = context.getResources().getString(i2);
        }
        builder.setContentTitle(str2);
        this.a.setContentIntent(pendingIntent);
        NotificationCompat.Builder builder2 = this.a;
        if (str != null) {
            bigTextStyle = new NotificationCompat.BigTextStyle().bigText(str);
        }
        builder2.setStyle(bigTextStyle);
        this.a.setProgress(i3, i4, z);
        this.a.setOngoing(z2);
        this.a.setShowWhen(z3);
        return this.a.build();
    }

    public Notification buildDownloadCompletedNotification(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        return a(context, i, pendingIntent, str, R.string.exo_download_completed);
    }

    public Notification buildDownloadFailedNotification(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        return a(context, i, pendingIntent, str, R.string.exo_download_failed);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Notification buildProgressNotification(android.content.Context r21, @androidx.annotation.DrawableRes int r22, @androidx.annotation.Nullable android.app.PendingIntent r23, @androidx.annotation.Nullable java.lang.String r24, java.util.List<com.google.android.exoplayer2.offline.Download> r25) {
        /*
            r20 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 1
            r8 = 0
        L_0x0009:
            int r9 = r25.size()
            if (r3 >= r9) goto L_0x0045
            r9 = r25
            java.lang.Object r10 = r9.get(r3)
            com.google.android.exoplayer2.offline.Download r10 = (com.google.android.exoplayer2.offline.Download) r10
            int r11 = r10.state
            r12 = 5
            if (r11 != r12) goto L_0x001e
            r5 = 1
            goto L_0x0042
        L_0x001e:
            r12 = 7
            if (r11 == r12) goto L_0x0025
            r12 = 2
            if (r11 == r12) goto L_0x0025
            goto L_0x0042
        L_0x0025:
            float r4 = r10.getPercentDownloaded()
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x0031
            float r2 = r2 + r4
            r7 = 0
        L_0x0031:
            long r10 = r10.getBytesDownloaded()
            r12 = 0
            int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x003d
            r4 = 1
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            r8 = r8 | r4
            int r6 = r6 + 1
            r4 = 1
        L_0x0042:
            int r3 = r3 + 1
            goto L_0x0009
        L_0x0045:
            if (r4 == 0) goto L_0x004b
            int r3 = com.google.android.exoplayer2.ui.R.string.exo_download_downloading
        L_0x0049:
            r14 = r3
            goto L_0x0051
        L_0x004b:
            if (r5 == 0) goto L_0x0050
            int r3 = com.google.android.exoplayer2.ui.R.string.exo_download_removing
            goto L_0x0049
        L_0x0050:
            r14 = 0
        L_0x0051:
            if (r4 == 0) goto L_0x0061
            float r3 = (float) r6
            float r2 = r2 / r3
            int r2 = (int) r2
            if (r7 == 0) goto L_0x005b
            if (r8 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r0 = 0
        L_0x005c:
            r17 = r0
            r16 = r2
            goto L_0x0065
        L_0x0061:
            r16 = 0
            r17 = 1
        L_0x0065:
            r15 = 100
            r18 = 1
            r19 = 0
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            android.app.Notification r0 = r9.b(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DownloadNotificationHelper.buildProgressNotification(android.content.Context, int, android.app.PendingIntent, java.lang.String, java.util.List):android.app.Notification");
    }
}
