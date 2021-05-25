package a2.m.a.b;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
public class d extends BaseAction {
    public final /* synthetic */ Camera2Engine e;

    public d(Camera2Engine camera2Engine) {
        this.e = camera2Engine;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@NonNull ActionHolder actionHolder) {
        super.onStart(actionHolder);
        this.e.applyDefaultFocus(actionHolder.getBuilder(this));
        CaptureRequest.Builder builder = actionHolder.getBuilder(this);
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
        Boolean bool = Boolean.FALSE;
        builder.set(key, bool);
        actionHolder.getBuilder(this).set(CaptureRequest.CONTROL_AWB_LOCK, bool);
        actionHolder.applyBuilder(this);
        setState(Integer.MAX_VALUE);
    }
}
