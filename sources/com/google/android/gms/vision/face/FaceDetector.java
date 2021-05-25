package com.google.android.gms.vision.face;

import a2.b.a.a.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.zzb;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.zzc;
import java.nio.ByteBuffer;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;
public final class FaceDetector extends Detector<Face> {
    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int CONTOUR_LANDMARKS = 2;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    public static final int SELFIE_MODE = 2;
    private final Object lock;
    private final zzc zzcr;
    @GuardedBy("lock")
    private final zzb zzcs;
    @GuardedBy("lock")
    private boolean zzct;

    public static class Builder {
        private int landmarkType = 0;
        private int mode = 0;
        private float proportionalMinFaceSize = -1.0f;
        private boolean trackingEnabled = true;
        private boolean zzcv = false;
        private int zzcw = 0;
        private final Context zzg;

        public Builder(Context context) {
            this.zzg = context;
        }

        public FaceDetector build() {
            zzf zzf = new zzf();
            zzf.mode = this.mode;
            zzf.landmarkType = this.landmarkType;
            zzf.zzcw = this.zzcw;
            zzf.zzcv = this.zzcv;
            zzf.trackingEnabled = this.trackingEnabled;
            zzf.proportionalMinFaceSize = this.proportionalMinFaceSize;
            if (FaceDetector.zza(zzf)) {
                return new FaceDetector(new zzb(this.zzg, zzf));
            }
            throw new IllegalArgumentException("Invalid build options");
        }

        public Builder setClassificationType(int i) {
            if (i == 0 || i == 1) {
                this.zzcw = i;
                return this;
            }
            throw new IllegalArgumentException(a.m2(40, "Invalid classification type: ", i));
        }

        public Builder setLandmarkType(int i) {
            if (i == 0 || i == 1 || i == 2) {
                this.landmarkType = i;
                return this;
            }
            throw new IllegalArgumentException(a.m2(34, "Invalid landmark type: ", i));
        }

        public Builder setMinFaceSize(float f) {
            if (f < 0.0f || f > 1.0f) {
                StringBuilder sb = new StringBuilder(47);
                sb.append("Invalid proportional face size: ");
                sb.append(f);
                throw new IllegalArgumentException(sb.toString());
            }
            this.proportionalMinFaceSize = f;
            return this;
        }

        public Builder setMode(int i) {
            if (i == 0 || i == 1 || i == 2) {
                this.mode = i;
                return this;
            }
            throw new IllegalArgumentException(a.m2(25, "Invalid mode: ", i));
        }

        public Builder setProminentFaceOnly(boolean z) {
            this.zzcv = z;
            return this;
        }

        public Builder setTrackingEnabled(boolean z) {
            this.trackingEnabled = z;
            return this;
        }
    }

    private FaceDetector() {
        this.zzcr = new zzc();
        this.lock = new Object();
        this.zzct = true;
        throw new IllegalStateException("Default constructor called");
    }

    /* access modifiers changed from: private */
    public static boolean zza(zzf zzf) {
        boolean z = zzf.mode == 2 || zzf.landmarkType != 2;
        if (zzf.landmarkType == 2 && zzf.zzcw == 1) {
            return false;
        }
        return z;
    }

    @Override // com.google.android.gms.vision.Detector
    public final SparseArray<Face> detect(Frame frame) {
        Face[] faceArr;
        ByteBuffer byteBuffer;
        if (frame != null) {
            if (frame.getPlanes() == null || frame.getPlanes().length != 3) {
                if (frame.getBitmap() != null) {
                    Bitmap bitmap = frame.getBitmap();
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    int i = width * height;
                    byteBuffer = ByteBuffer.allocateDirect(((((height + 1) / 2) * ((width + 1) / 2)) << 1) + i);
                    int i2 = i;
                    for (int i3 = 0; i3 < i; i3++) {
                        int i4 = i3 % width;
                        int i5 = i3 / width;
                        int pixel = bitmap.getPixel(i4, i5);
                        float red = (float) Color.red(pixel);
                        float green = (float) Color.green(pixel);
                        float blue = (float) Color.blue(pixel);
                        byteBuffer.put(i3, (byte) ((int) ((0.114f * blue) + (0.587f * green) + (0.299f * red))));
                        if (i5 % 2 == 0 && i4 % 2 == 0) {
                            float f = blue * 0.5f;
                            int i6 = i2 + 1;
                            byteBuffer.put(i2, (byte) ((int) (f + (-0.331f * green) + (-0.169f * red) + 128.0f)));
                            i2 = i6 + 1;
                            byteBuffer.put(i6, (byte) ((int) ((blue * -0.081f) + (green * -0.419f) + (red * 0.5f) + 128.0f)));
                        }
                    }
                } else {
                    byteBuffer = frame.getGrayscaleImageData();
                }
                synchronized (this.lock) {
                    if (this.zzct) {
                        faceArr = this.zzcs.zzb(byteBuffer, zzu.zzd(frame));
                    } else {
                        throw new IllegalStateException("Cannot use detector after release()");
                    }
                }
            } else {
                synchronized (this.lock) {
                    if (this.zzct) {
                        faceArr = this.zzcs.zza(frame.getPlanes(), zzu.zzd(frame));
                    } else {
                        throw new IllegalStateException("Cannot use detector after release()");
                    }
                }
            }
            HashSet hashSet = new HashSet();
            SparseArray<Face> sparseArray = new SparseArray<>(faceArr.length);
            int i7 = 0;
            for (Face face : faceArr) {
                int id = face.getId();
                i7 = Math.max(i7, id);
                if (hashSet.contains(Integer.valueOf(id))) {
                    id = i7 + 1;
                    i7 = id;
                }
                hashSet.add(Integer.valueOf(id));
                sparseArray.append(this.zzcr.zzb(id), face);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this.lock) {
                if (this.zzct) {
                    release();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.vision.Detector
    public final boolean isOperational() {
        return this.zzcs.isOperational();
    }

    @Override // com.google.android.gms.vision.Detector
    public final void release() {
        super.release();
        synchronized (this.lock) {
            if (this.zzct) {
                this.zzcs.zzq();
                this.zzct = false;
            }
        }
    }

    @Override // com.google.android.gms.vision.Detector
    public final boolean setFocus(int i) {
        boolean zzd;
        int zzc = this.zzcr.zzc(i);
        synchronized (this.lock) {
            if (this.zzct) {
                zzd = this.zzcs.zzd(zzc);
            } else {
                throw new RuntimeException("Cannot use detector after release()");
            }
        }
        return zzd;
    }

    private FaceDetector(zzb zzb) {
        this.zzcr = new zzc();
        this.lock = new Object();
        this.zzct = true;
        this.zzcs = zzb;
    }
}
