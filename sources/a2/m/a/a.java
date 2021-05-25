package a2.m.a;

import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.VideoResult;
public class a extends CameraListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ CameraView b;

    public a(CameraView cameraView, int i) {
        this.b = cameraView;
        this.a = i;
    }

    @Override // com.otaliastudios.cameraview.CameraListener
    public void onCameraError(@NonNull CameraException cameraException) {
        super.onCameraError(cameraException);
        if (cameraException.getReason() == 5) {
            this.b.setVideoMaxDuration(this.a);
            this.b.removeCameraListener(this);
        }
    }

    @Override // com.otaliastudios.cameraview.CameraListener
    public void onVideoTaken(@NonNull VideoResult videoResult) {
        this.b.setVideoMaxDuration(this.a);
        this.b.removeCameraListener(this);
    }
}
