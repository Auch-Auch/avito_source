package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import java.util.HashMap;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CommandHandler implements ExecutionListener {
    public static final String d = Logger.tagWithPrefix("CommandHandler");
    public final Context a;
    public final Map<String, ExecutionListener> b = new HashMap();
    public final Object c = new Object();

    public CommandHandler(@NonNull Context context) {
        this.a = context;
    }

    public static Intent a(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent b(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x016a  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(@androidx.annotation.NonNull android.content.Intent r11, int r12, @androidx.annotation.NonNull androidx.work.impl.background.systemalarm.SystemAlarmDispatcher r13) {
        /*
        // Method dump skipped, instructions count: 860
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemalarm.CommandHandler.d(android.content.Intent, int, androidx.work.impl.background.systemalarm.SystemAlarmDispatcher):void");
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String str, boolean z) {
        synchronized (this.c) {
            ExecutionListener remove = this.b.remove(str);
            if (remove != null) {
                remove.onExecuted(str, z);
            }
        }
    }
}
