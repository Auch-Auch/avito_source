package a2.j.e.i;

import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.InstanceIdResult;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
public class b0 {
    public final Executor a;
    @GuardedBy("this")
    public final Map<Pair<String, String>, Task<InstanceIdResult>> b = new ArrayMap();

    public b0(Executor executor) {
        this.a = executor;
    }
}
