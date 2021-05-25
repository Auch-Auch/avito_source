package com.otaliastudios.cameraview.picture;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.engine.Camera1Engine;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.internal.ExifHelper;
import com.otaliastudios.cameraview.size.Size;
import java.io.ByteArrayInputStream;
import java.io.IOException;
public class Full1PictureRecorder extends FullPictureRecorder {
    public final Camera c;
    public final Camera1Engine d;

    public class a implements Camera.ShutterCallback {
        public a() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            FullPictureRecorder.LOG.i("take(): got onShutter callback.");
            Full1PictureRecorder.this.dispatchOnShutter(true);
        }
    }

    public class b implements Camera.PictureCallback {
        public b() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            int i;
            FullPictureRecorder.LOG.i("take(): got picture callback.");
            try {
                i = ExifHelper.getOrientation(new ExifInterface(new ByteArrayInputStream(bArr)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1));
            } catch (IOException unused) {
                i = 0;
            }
            PictureResult.Stub stub = Full1PictureRecorder.this.a;
            stub.data = bArr;
            stub.rotation = i;
            FullPictureRecorder.LOG.i("take(): starting preview again. ", Thread.currentThread());
            if (Full1PictureRecorder.this.d.getState().isAtLeast(CameraState.PREVIEW)) {
                camera.setPreviewCallbackWithBuffer(Full1PictureRecorder.this.d);
                Size previewStreamSize = Full1PictureRecorder.this.d.getPreviewStreamSize(Reference.SENSOR);
                if (previewStreamSize != null) {
                    Full1PictureRecorder.this.d.getFrameManager().setUp(Full1PictureRecorder.this.d.getFrameProcessingFormat(), previewStreamSize, Full1PictureRecorder.this.d.getAngles());
                    camera.startPreview();
                } else {
                    throw new IllegalStateException("Preview stream size should never be null here.");
                }
            }
            Full1PictureRecorder.this.dispatchResult();
        }
    }

    public Full1PictureRecorder(@NonNull PictureResult.Stub stub, @NonNull Camera1Engine camera1Engine, @NonNull Camera camera) {
        super(stub, camera1Engine);
        this.d = camera1Engine;
        this.c = camera;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(this.a.rotation);
        camera.setParameters(parameters);
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void dispatchResult() {
        FullPictureRecorder.LOG.i("dispatching result. Thread:", Thread.currentThread());
        super.dispatchResult();
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void take() {
        CameraLogger cameraLogger = FullPictureRecorder.LOG;
        cameraLogger.i("take() called.");
        this.c.setPreviewCallbackWithBuffer(null);
        this.d.getFrameManager().release();
        try {
            this.c.takePicture(new a(), null, null, new b());
            cameraLogger.i("take() returned.");
        } catch (Exception e) {
            this.mError = e;
            dispatchResult();
        }
    }
}
