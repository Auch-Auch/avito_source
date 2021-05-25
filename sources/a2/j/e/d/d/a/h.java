package a2.j.e.d.d.a;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
public class h implements Continuation<Void, T> {
    public final /* synthetic */ Callable a;

    public h(f fVar, Callable callable) {
        this.a = callable;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public T then(@NonNull Task<Void> task) throws Exception {
        return (T) this.a.call();
    }
}
