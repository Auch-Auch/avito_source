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
import java.util.List;
@RequiresApi(21)
public class a extends BaseAction {
    public final List<BaseAction> e;
    public int f = -1;

    /* renamed from: a2.m.a.b.j.a$a  reason: collision with other inner class name */
    public class C0100a implements ActionCallback {
        public C0100a() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
        public void onActionStateChanged(@NonNull Action action, int i) {
            if (i == Integer.MAX_VALUE) {
                action.removeCallback(this);
                a.this.a();
            }
        }
    }

    public a(@NonNull List<BaseAction> list) {
        this.e = list;
        a();
    }

    public final void a() {
        int i = this.f;
        boolean z = false;
        boolean z2 = i == -1;
        if (i == this.e.size() - 1) {
            z = true;
        }
        if (z) {
            setState(Integer.MAX_VALUE);
            return;
        }
        int i2 = this.f + 1;
        this.f = i2;
        this.e.get(i2).addCallback(new C0100a());
        if (!z2) {
            this.e.get(this.f).onStart(getHolder());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onAbort(@NonNull ActionHolder actionHolder) {
        super.onAbort(actionHolder);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onAbort(actionHolder);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureProgressed(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        super.onCaptureProgressed(actionHolder, captureRequest, captureResult);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onCaptureProgressed(actionHolder, captureRequest, captureResult);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureStarted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        super.onCaptureStarted(actionHolder, captureRequest);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onCaptureStarted(actionHolder, captureRequest);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@NonNull ActionHolder actionHolder) {
        super.onStart(actionHolder);
        int i = this.f;
        if (i >= 0) {
            this.e.get(i).onStart(actionHolder);
        }
    }
}
