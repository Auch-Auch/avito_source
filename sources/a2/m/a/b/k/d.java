package a2.m.a.b.k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator;
public class d implements Continuation<T, Task<T>> {
    public final /* synthetic */ CameraStateOrchestrator.b a;

    public d(CameraStateOrchestrator.b bVar) {
        this.a = bVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(@NonNull Task task) throws Exception {
        if (task.isSuccessful() || this.a.e) {
            CameraStateOrchestrator.b bVar = this.a;
            CameraStateOrchestrator.this.a = bVar.c;
        }
        return task;
    }
}
