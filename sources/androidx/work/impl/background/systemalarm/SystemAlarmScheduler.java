package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmScheduler implements Scheduler {
    public static final String b = Logger.tagWithPrefix("SystemAlarmScheduler");
    public final Context a;

    public SystemAlarmScheduler(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String str) {
        Context context = this.a;
        String str2 = CommandHandler.d;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        this.a.startService(intent);
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(@NonNull WorkSpec... workSpecArr) {
        for (WorkSpec workSpec : workSpecArr) {
            Logger.get().debug(b, String.format("Scheduling work with workSpecId %s", workSpec.id), new Throwable[0]);
            this.a.startService(CommandHandler.c(this.a, workSpec.id));
        }
    }
}
