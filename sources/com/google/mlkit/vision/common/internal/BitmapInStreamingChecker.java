package com.google.mlkit.vision.common.internal;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.vision.common.InputImage;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
@KeepForSdk
public class BitmapInStreamingChecker {
    public static final GmsLogger c = new GmsLogger("StreamingFormatChecker", "");
    public final LinkedList<Long> a = new LinkedList<>();
    public long b = -1;

    @KeepForSdk
    public void check(InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.a.add(Long.valueOf(elapsedRealtime));
            if (this.a.size() > 5) {
                this.a.removeFirst();
            }
            if (this.a.size() == 5 && elapsedRealtime - this.a.peekFirst().longValue() < 5000) {
                long j = this.b;
                if (j == -1 || elapsedRealtime - j >= TimeUnit.SECONDS.toMillis(5)) {
                    this.b = elapsedRealtime;
                    c.w("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
                }
            }
        }
    }
}
