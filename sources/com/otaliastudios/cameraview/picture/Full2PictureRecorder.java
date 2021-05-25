package com.otaliastudios.cameraview.picture;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.DngCreator;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.internal.ExifHelper;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
@RequiresApi(21)
public class Full2PictureRecorder extends FullPictureRecorder implements ImageReader.OnImageAvailableListener {
    public final ActionHolder c;
    public final Action d = new a();
    public final ImageReader e;
    public final CaptureRequest.Builder f;
    public DngCreator g;

    public class a extends BaseAction {
        public a() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            try {
                super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
            } catch (Exception e2) {
                Full2PictureRecorder.this.mError = e2;
                Full2PictureRecorder.this.dispatchResult();
            }
            Full2PictureRecorder full2PictureRecorder = Full2PictureRecorder.this;
            if (full2PictureRecorder.a.format == PictureFormat.DNG) {
                full2PictureRecorder.g = new DngCreator(actionHolder.getCharacteristics(this), totalCaptureResult);
                Full2PictureRecorder full2PictureRecorder2 = Full2PictureRecorder.this;
                full2PictureRecorder2.g.setOrientation(ExifHelper.getExifOrientation(full2PictureRecorder2.a.rotation));
                Full2PictureRecorder full2PictureRecorder3 = Full2PictureRecorder.this;
                Location location = full2PictureRecorder3.a.location;
                if (location != null) {
                    full2PictureRecorder3.g.setLocation(location);
                }
            }
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureStarted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
            super.onCaptureStarted(actionHolder, captureRequest);
            if (captureRequest.getTag() == 2) {
                FullPictureRecorder.LOG.i("onCaptureStarted:", "Dispatching picture shutter.");
                Full2PictureRecorder.this.dispatchOnShutter(false);
                setState(Integer.MAX_VALUE);
            }
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction
        public void onStart(@NonNull ActionHolder actionHolder) {
            super.onStart(actionHolder);
            Full2PictureRecorder full2PictureRecorder = Full2PictureRecorder.this;
            full2PictureRecorder.f.addTarget(full2PictureRecorder.e.getSurface());
            Full2PictureRecorder full2PictureRecorder2 = Full2PictureRecorder.this;
            PictureResult.Stub stub = full2PictureRecorder2.a;
            if (stub.format == PictureFormat.JPEG) {
                full2PictureRecorder2.f.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(stub.rotation));
            }
            Full2PictureRecorder.this.f.setTag(2);
            try {
                actionHolder.applyBuilder(this, Full2PictureRecorder.this.f);
            } catch (CameraAccessException e2) {
                Full2PictureRecorder full2PictureRecorder3 = Full2PictureRecorder.this;
                full2PictureRecorder3.a = null;
                full2PictureRecorder3.mError = e2;
                full2PictureRecorder3.dispatchResult();
                setState(Integer.MAX_VALUE);
            }
        }
    }

    public Full2PictureRecorder(@NonNull PictureResult.Stub stub, @NonNull Camera2Engine camera2Engine, @NonNull CaptureRequest.Builder builder, @NonNull ImageReader imageReader) {
        super(stub, camera2Engine);
        this.c = camera2Engine;
        this.f = builder;
        this.e = imageReader;
        imageReader.setOnImageAvailableListener(this, WorkerHandler.get().getHandler());
    }

    public final void a(@NonNull Image image) {
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        PictureResult.Stub stub = this.a;
        stub.data = bArr;
        stub.rotation = 0;
        try {
            int attributeInt = new ExifInterface(new ByteArrayInputStream(this.a.data)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            this.a.rotation = ExifHelper.getOrientation(attributeInt);
        } catch (IOException unused) {
        }
    }

    public final void b(@NonNull Image image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        try {
            this.g.writeImage(bufferedOutputStream, image);
            bufferedOutputStream.flush();
            this.a.data = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            this.g.close();
            try {
                bufferedOutputStream.close();
            } catch (IOException unused) {
            }
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // android.media.ImageReader.OnImageAvailableListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onImageAvailable(android.media.ImageReader r6) {
        /*
            r5 = this;
            com.otaliastudios.cameraview.CameraLogger r0 = com.otaliastudios.cameraview.picture.FullPictureRecorder.LOG
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "onImageAvailable started."
            r4 = 0
            r2[r4] = r3
            r0.i(r2)
            r2 = 0
            android.media.Image r6 = r6.acquireNextImage()     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            com.otaliastudios.cameraview.PictureResult$Stub r3 = r5.a     // Catch:{ Exception -> 0x0052 }
            com.otaliastudios.cameraview.controls.PictureFormat r3 = r3.format     // Catch:{ Exception -> 0x0052 }
            int r3 = r3.ordinal()     // Catch:{ Exception -> 0x0052 }
            if (r3 == 0) goto L_0x003d
            if (r3 != r1) goto L_0x0022
            r5.b(r6)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0040
        L_0x0022:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0052 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
            r1.<init>()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r3 = "Unknown format: "
            r1.append(r3)     // Catch:{ Exception -> 0x0052 }
            com.otaliastudios.cameraview.PictureResult$Stub r3 = r5.a     // Catch:{ Exception -> 0x0052 }
            com.otaliastudios.cameraview.controls.PictureFormat r3 = r3.format     // Catch:{ Exception -> 0x0052 }
            r1.append(r3)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0052 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0052 }
            throw r0     // Catch:{ Exception -> 0x0052 }
        L_0x003d:
            r5.a(r6)     // Catch:{ Exception -> 0x0052 }
        L_0x0040:
            if (r6 == 0) goto L_0x0045
            r6.close()
        L_0x0045:
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r1 = "onImageAvailable ended."
            r6[r4] = r1
            r0.i(r6)
            r5.dispatchResult()
            return
        L_0x0052:
            r0 = move-exception
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            goto L_0x0067
        L_0x0056:
            r0 = move-exception
            r6 = r2
        L_0x0058:
            r5.a = r2     // Catch:{ all -> 0x0065 }
            r5.mError = r0     // Catch:{ all -> 0x0065 }
            r5.dispatchResult()     // Catch:{ all -> 0x0065 }
            if (r6 == 0) goto L_0x0064
            r6.close()
        L_0x0064:
            return
        L_0x0065:
            r0 = move-exception
            r2 = r6
        L_0x0067:
            if (r2 == 0) goto L_0x006c
            r2.close()
        L_0x006c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.picture.Full2PictureRecorder.onImageAvailable(android.media.ImageReader):void");
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void take() {
        this.d.start(this.c);
    }
}
