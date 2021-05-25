package a2.f.a.a;

import android.content.Context;
import android.os.PowerManager;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobUtil;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class g {
    public static final JobCat a = new JobCat("WakeLockUtil");
    public static final SparseArray<PowerManager.WakeLock> b = new SparseArray<>();
    public static int c = 1;

    @Nullable
    public static PowerManager.WakeLock a(@NonNull Context context, @NonNull String str, long j) {
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, str);
        newWakeLock.setReferenceCounted(false);
        if (b(context, newWakeLock, j)) {
            return newWakeLock;
        }
        return null;
    }

    public static boolean b(@NonNull Context context, @Nullable PowerManager.WakeLock wakeLock, long j) {
        if (wakeLock == null || wakeLock.isHeld() || !JobUtil.hasWakeLockPermission(context)) {
            return false;
        }
        try {
            wakeLock.acquire(j);
            return true;
        } catch (Exception e) {
            a.e(e);
            return false;
        }
    }

    public static void c(@Nullable PowerManager.WakeLock wakeLock) {
        if (wakeLock != null) {
            try {
                if (wakeLock.isHeld()) {
                    wakeLock.release();
                }
            } catch (Exception e) {
                a.e(e);
            }
        }
    }
}
