package a2.a.a.x1.q;

import android.hardware.Camera;
import com.avito.android.photo_picker.legacy.CameraInteractorKt;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
public final class b<V> implements Callable<Unit> {
    public final /* synthetic */ Camera a;
    public final /* synthetic */ Function1 b;

    public b(Camera camera, Function1 function1) {
        this.a = camera;
        this.b = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Unit call() {
        CameraInteractorKt.access$changeParams(this.a, this.b);
        return Unit.INSTANCE;
    }
}
