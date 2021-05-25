package a2.f.a.a.i.a.h;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.evernote.android.job.patched.internal.JobRequest;
import com.evernote.android.job.patched.internal.util.JobCat;
import com.evernote.android.job.patched.internal.v14.PlatformAlarmServiceExact;
@TargetApi(21)
public final class a {
    public static final JobCat a = new JobCat("TransientBundleCompat");

    public static void a(@NonNull Context context, int i, @Nullable PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            try {
                pendingIntent = PendingIntent.getService(context, i, PlatformAlarmServiceExact.createIntent(context, i, null), 536870912);
                if (pendingIntent == null) {
                    return;
                }
            } catch (Exception e) {
                a.e(e);
                return;
            }
        }
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public static boolean b(@NonNull Context context, @NonNull JobRequest jobRequest) {
        PendingIntent service = PendingIntent.getService(context, jobRequest.getJobId(), PlatformAlarmServiceExact.createIntent(context, jobRequest.getJobId(), null), 536870912);
        if (service == null) {
            return false;
        }
        try {
            a.i("Delegating transient job %s to API 14", jobRequest);
            service.send();
            if (!jobRequest.isPeriodic()) {
                a(context, jobRequest.getJobId(), service);
            }
            return true;
        } catch (PendingIntent.CanceledException e) {
            a.e(e);
            return false;
        }
    }
}
