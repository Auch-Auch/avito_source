package l6.d0.a.d.a;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsTracker;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {
    public static final String e = Logger.tagWithPrefix("ConstraintsCmdHandler");
    public final Context a;
    public final int b;
    public final SystemAlarmDispatcher c;
    public final WorkConstraintsTracker d;

    public b(@NonNull Context context, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.a = context;
        this.b = i;
        this.c = systemAlarmDispatcher;
        this.d = new WorkConstraintsTracker(context, systemAlarmDispatcher.b, null);
    }
}
