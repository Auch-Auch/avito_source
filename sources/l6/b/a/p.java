package l6.b.a;

import android.content.Context;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
public class p {
    public static p d;
    public final Context a;
    public final LocationManager b;
    public final a c = new a();

    public static class a {
        public boolean a;
        public long b;
    }

    @VisibleForTesting
    public p(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.a = context;
        this.b = locationManager;
    }
}
