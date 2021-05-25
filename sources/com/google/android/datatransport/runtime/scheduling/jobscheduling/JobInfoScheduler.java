package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
@RequiresApi(api = 21)
public class JobInfoScheduler implements WorkScheduler {
    public final Context a;
    public final EventStore b;
    public final SchedulerConfig c;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.a = context;
        this.b = eventStore;
        this.c = schedulerConfig;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0095, code lost:
        r3 = false;
     */
    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void schedule(com.google.android.datatransport.runtime.TransportContext r19, int r20) {
        /*
        // Method dump skipped, instructions count: 296
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler.schedule(com.google.android.datatransport.runtime.TransportContext, int):void");
    }
}
