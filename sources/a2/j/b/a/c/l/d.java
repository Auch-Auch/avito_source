package a2.j.b.a.c.l;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import javax.inject.Inject;
public class d {
    public final Context a;
    public final Clock b;
    public final Clock c;

    @Inject
    public d(Context context, @WallTime Clock clock, @Monotonic Clock clock2) {
        this.a = context;
        this.b = clock;
        this.c = clock2;
    }
}
