package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.facebook.applinks.AppLinkData;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.firebase.messaging.Constants;
public class AlarmManagerScheduler implements WorkScheduler {
    public final Context a;
    public final EventStore b;
    public AlarmManager c;
    public final SchedulerConfig d;
    public final Clock e;

    public AlarmManagerScheduler(Context context, EventStore eventStore, Clock clock, SchedulerConfig schedulerConfig) {
        this.a = context;
        this.b = eventStore;
        this.c = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.e = clock;
        this.d = schedulerConfig;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void schedule(TransportContext transportContext, int i) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", transportContext.getBackendName());
        builder.appendQueryParameter(Constants.FirelogAnalytics.PARAM_PRIORITY, String.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
        if (transportContext.getExtras() != null) {
            builder.appendQueryParameter(AppLinkData.ARGUMENTS_EXTRAS_KEY, Base64.encodeToString(transportContext.getExtras(), 0));
        }
        Intent intent = new Intent(this.a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i);
        if (PendingIntent.getBroadcast(this.a, 0, intent, 536870912) != null) {
            Logging.d("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long nextCallTime = this.b.getNextCallTime(transportContext);
        long scheduleDelay = this.d.getScheduleDelay(transportContext.getPriority(), nextCallTime, i);
        Logging.d("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Long.valueOf(scheduleDelay), Long.valueOf(nextCallTime), Integer.valueOf(i));
        this.c.set(3, this.e.getTime() + scheduleDelay, PendingIntent.getBroadcast(this.a, 0, intent, 0));
    }
}
