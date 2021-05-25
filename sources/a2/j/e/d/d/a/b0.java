package a2.j.e.d.d.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
public class b0 implements SuccessContinuation<Void, Boolean> {
    public b0(u uVar) {
    }

    /* Return type fixed from 'com.google.android.gms.tasks.Task' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.tasks.SuccessContinuation
    @NonNull
    public Task<Boolean> then(@Nullable Void r1) throws Exception {
        return Tasks.forResult(Boolean.TRUE);
    }
}
