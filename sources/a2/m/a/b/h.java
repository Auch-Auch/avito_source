package a2.m.a.b;

import com.google.android.gms.tasks.OnSuccessListener;
import com.otaliastudios.cameraview.engine.CameraEngine;
public class h implements OnSuccessListener<Void> {
    public final /* synthetic */ CameraEngine a;

    public h(CameraEngine cameraEngine) {
        this.a = cameraEngine;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Void r1) {
        this.a.c.dispatchOnCameraClosed();
    }
}
