package a2.j.e.j;

import android.text.TextUtils;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
public class k {
    public static final long a = TimeUnit.HOURS.toSeconds(1);
    public static final Pattern b = Pattern.compile("\\AA[\\w-]{38}\\z");

    public long a() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (TextUtils.isEmpty(persistedInstallationEntry.getAuthToken())) {
            return true;
        }
        if (persistedInstallationEntry.getExpiresInSecs() + persistedInstallationEntry.getTokenCreationEpochInSecs() < a() + a) {
            return true;
        }
        return false;
    }
}
