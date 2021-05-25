package a2.m.a.b.j;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionCallback;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import java.util.ArrayList;
import java.util.List;
@RequiresApi(21)
public class c extends BaseAction {
    public final List<BaseAction> e;
    public final List<BaseAction> f;

    public class a implements ActionCallback {
        public a() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
        public void onActionStateChanged(@NonNull Action action, int i) {
            if (i == Integer.MAX_VALUE) {
                c.this.f.remove(action);
            }
            if (c.this.f.isEmpty()) {
                c.this.setState(Integer.MAX_VALUE);
            }
        }
    }

    public c(@NonNull List<BaseAction> list) {
        this.e = new ArrayList(list);
        this.f = new ArrayList(list);
        for (BaseAction baseAction : list) {
            baseAction.addCallback(new a());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onAbort(@NonNull ActionHolder actionHolder) {
        super.onAbort(actionHolder);
        for (BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onAbort(actionHolder);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        for (BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureProgressed(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        super.onCaptureProgressed(actionHolder, captureRequest, captureResult);
        for (BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onCaptureProgressed(actionHolder, captureRequest, captureResult);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureStarted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        super.onCaptureStarted(actionHolder, captureRequest);
        for (BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onCaptureStarted(actionHolder, captureRequest);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@NonNull ActionHolder actionHolder) {
        super.onStart(actionHolder);
        for (BaseAction baseAction : this.e) {
            if (!baseAction.isCompleted()) {
                baseAction.onStart(actionHolder);
            }
        }
    }
}
