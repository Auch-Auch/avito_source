package l6.d0.a.d.b;

import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.background.systemjob.SystemJobService;
@RequiresApi(api = 23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static final String b = Logger.tagWithPrefix("SystemJobInfoConverter");
    public final ComponentName a;

    @VisibleForTesting(otherwise = 3)
    public a(@NonNull Context context) {
        this.a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }
}
