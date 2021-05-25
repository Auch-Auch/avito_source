package com.otaliastudios.cameraview.picture;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.engine.Camera1Engine;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.frame.ByteBufferFrameManager;
import com.otaliastudios.cameraview.internal.CropHelper;
import com.otaliastudios.cameraview.internal.RotationHelper;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import java.io.ByteArrayOutputStream;
public class Snapshot1PictureRecorder extends SnapshotPictureRecorder {
    public Camera1Engine c;
    public Camera d;
    public AspectRatio e;
    public int f;

    public class a implements Camera.PreviewCallback {

        /* renamed from: com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder$a$a  reason: collision with other inner class name */
        public class RunnableC0312a implements Runnable {
            public final /* synthetic */ byte[] a;
            public final /* synthetic */ Size b;
            public final /* synthetic */ int c;
            public final /* synthetic */ Size d;

            public RunnableC0312a(byte[] bArr, Size size, int i, Size size2) {
                this.a = bArr;
                this.b = size;
                this.c = i;
                this.d = size2;
            }

            @Override // java.lang.Runnable
            public void run() {
                YuvImage yuvImage = new YuvImage(RotationHelper.rotate(this.a, this.b, this.c), Snapshot1PictureRecorder.this.f, this.d.getWidth(), this.d.getHeight(), null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Rect computeCrop = CropHelper.computeCrop(this.d, Snapshot1PictureRecorder.this.e);
                yuvImage.compressToJpeg(computeCrop, 90, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                PictureResult.Stub stub = Snapshot1PictureRecorder.this.a;
                stub.data = byteArray;
                stub.size = new Size(computeCrop.width(), computeCrop.height());
                Snapshot1PictureRecorder snapshot1PictureRecorder = Snapshot1PictureRecorder.this;
                snapshot1PictureRecorder.a.rotation = 0;
                snapshot1PictureRecorder.dispatchResult();
            }
        }

        public a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(@NonNull byte[] bArr, Camera camera) {
            Snapshot1PictureRecorder.this.dispatchOnShutter(false);
            Snapshot1PictureRecorder snapshot1PictureRecorder = Snapshot1PictureRecorder.this;
            PictureResult.Stub stub = snapshot1PictureRecorder.a;
            int i = stub.rotation;
            Size size = stub.size;
            Size previewStreamSize = snapshot1PictureRecorder.c.getPreviewStreamSize(Reference.SENSOR);
            if (previewStreamSize != null) {
                WorkerHandler.execute(new RunnableC0312a(bArr, previewStreamSize, i, size));
                camera.setPreviewCallbackWithBuffer(null);
                camera.setPreviewCallbackWithBuffer(Snapshot1PictureRecorder.this.c);
                ByteBufferFrameManager frameManager = Snapshot1PictureRecorder.this.c.getFrameManager();
                Snapshot1PictureRecorder snapshot1PictureRecorder2 = Snapshot1PictureRecorder.this;
                frameManager.setUp(snapshot1PictureRecorder2.f, previewStreamSize, snapshot1PictureRecorder2.c.getAngles());
                return;
            }
            throw new IllegalStateException("Preview stream size should never be null here.");
        }
    }

    public Snapshot1PictureRecorder(@NonNull PictureResult.Stub stub, @NonNull Camera1Engine camera1Engine, @NonNull Camera camera, @NonNull AspectRatio aspectRatio) {
        super(stub, camera1Engine);
        this.c = camera1Engine;
        this.d = camera;
        this.e = aspectRatio;
        this.f = camera.getParameters().getPreviewFormat();
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void dispatchResult() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        super.dispatchResult();
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void take() {
        this.d.setOneShotPreviewCallback(new a());
    }
}
