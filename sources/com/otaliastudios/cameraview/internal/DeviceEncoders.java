package com.otaliastudios.cameraview.internal;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.size.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class DeviceEncoders {
    public static final int MODE_PREFER_HARDWARE = 1;
    public static final int MODE_RESPECT_ORDER = 0;
    public static final CameraLogger e = CameraLogger.create(DeviceEncoders.class.getSimpleName());
    @VisibleForTesting
    public static boolean f = true;
    public final MediaCodecInfo a;
    public final MediaCodecInfo b;
    public final MediaCodecInfo.VideoCapabilities c;
    public final MediaCodecInfo.AudioCapabilities d;

    public class AudioException extends RuntimeException {
        public AudioException(DeviceEncoders deviceEncoders, String str, a aVar) {
            super(str);
        }
    }

    public class VideoException extends RuntimeException {
        public VideoException(DeviceEncoders deviceEncoders, String str, a aVar) {
            super(str);
        }
    }

    public class a implements Comparator<MediaCodecInfo> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(MediaCodecInfo mediaCodecInfo, MediaCodecInfo mediaCodecInfo2) {
            return Boolean.compare(DeviceEncoders.this.b(mediaCodecInfo2.getName()), DeviceEncoders.this.b(mediaCodecInfo.getName()));
        }
    }

    @SuppressLint({"NewApi"})
    public DeviceEncoders(int i, @NonNull String str, @NonNull String str2, int i2, int i3) {
        if (f) {
            ArrayList arrayList = new ArrayList();
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                if (mediaCodecInfo.isEncoder()) {
                    arrayList.add(mediaCodecInfo);
                }
            }
            MediaCodecInfo a3 = a(arrayList, str, i, i2);
            this.a = a3;
            CameraLogger cameraLogger = e;
            cameraLogger.i("Enabled. Found video encoder:", a3.getName());
            MediaCodecInfo a4 = a(arrayList, str2, i, i3);
            this.b = a4;
            cameraLogger.i("Enabled. Found audio encoder:", a4.getName());
            this.c = a3.getCapabilitiesForType(str).getVideoCapabilities();
            this.d = a4.getCapabilitiesForType(str2).getAudioCapabilities();
            return;
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        e.i("Disabled.");
    }

    @NonNull
    @SuppressLint({"NewApi"})
    @VisibleForTesting
    public MediaCodecInfo a(@NonNull List<MediaCodecInfo> list, @NonNull String str, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        Iterator<MediaCodecInfo> it = list.iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            MediaCodecInfo next = it.next();
            String[] supportedTypes = next.getSupportedTypes();
            int length = supportedTypes.length;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (supportedTypes[i3].equalsIgnoreCase(str)) {
                    arrayList.add(next);
                    break;
                } else {
                    i3++;
                }
            }
        }
        e.i("findDeviceEncoder -", "type:", str, "encoders:", Integer.valueOf(arrayList.size()));
        if (i == 1) {
            Collections.sort(arrayList, new a());
        }
        if (arrayList.size() >= i2 + 1) {
            return (MediaCodecInfo) arrayList.get(i2);
        }
        throw new RuntimeException(a2.b.a.a.a.c3("No encoders for type:", str));
    }

    @SuppressLint({"NewApi"})
    @VisibleForTesting
    public boolean b(@NonNull String str) {
        String lowerCase = str.toLowerCase();
        return !(lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || (!lowerCase.startsWith("omx.") && !lowerCase.startsWith("c2.")));
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public String getAudioEncoder() {
        MediaCodecInfo mediaCodecInfo = this.b;
        if (mediaCodecInfo != null) {
            return mediaCodecInfo.getName();
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public int getSupportedAudioBitRate(int i) {
        if (!f) {
            return i;
        }
        int intValue = this.d.getBitrateRange().clamp(Integer.valueOf(i)).intValue();
        e.i("getSupportedAudioBitRate -", "inputRate:", Integer.valueOf(i), "adjustedRate:", Integer.valueOf(intValue));
        return intValue;
    }

    @SuppressLint({"NewApi"})
    public int getSupportedVideoBitRate(int i) {
        if (!f) {
            return i;
        }
        int intValue = this.c.getBitrateRange().clamp(Integer.valueOf(i)).intValue();
        e.i("getSupportedVideoBitRate -", "inputRate:", Integer.valueOf(i), "adjustedRate:", Integer.valueOf(intValue));
        return intValue;
    }

    @SuppressLint({"NewApi"})
    public int getSupportedVideoFrameRate(@NonNull Size size, int i) {
        if (!f) {
            return i;
        }
        int doubleValue = (int) this.c.getSupportedFrameRatesFor(size.getWidth(), size.getHeight()).clamp(Double.valueOf((double) i)).doubleValue();
        e.i("getSupportedVideoFrameRate -", "inputRate:", Integer.valueOf(i), "adjustedRate:", Integer.valueOf(doubleValue));
        return doubleValue;
    }

    @NonNull
    @SuppressLint({"NewApi"})
    public Size getSupportedVideoSize(@NonNull Size size) {
        if (!f) {
            return size;
        }
        int width = size.getWidth();
        int height = size.getHeight();
        double d2 = ((double) width) / ((double) height);
        CameraLogger cameraLogger = e;
        cameraLogger.i("getSupportedVideoSize - started. width:", Integer.valueOf(width), "height:", Integer.valueOf(height));
        if (this.c.getSupportedWidths().getUpper().intValue() < width) {
            width = this.c.getSupportedWidths().getUpper().intValue();
            height = (int) Math.round(((double) width) / d2);
            cameraLogger.i("getSupportedVideoSize - exceeds maxWidth! width:", Integer.valueOf(width), "height:", Integer.valueOf(height));
        }
        if (this.c.getSupportedHeights().getUpper().intValue() < height) {
            height = this.c.getSupportedHeights().getUpper().intValue();
            width = (int) Math.round(((double) height) * d2);
            cameraLogger.i("getSupportedVideoSize - exceeds maxHeight! width:", Integer.valueOf(width), "height:", Integer.valueOf(height));
        }
        while (width % this.c.getWidthAlignment() != 0) {
            width--;
        }
        while (height % this.c.getHeightAlignment() != 0) {
            height--;
        }
        e.i("getSupportedVideoSize - aligned. width:", Integer.valueOf(width), "height:", Integer.valueOf(height));
        if (!this.c.getSupportedWidths().contains((Range<Integer>) Integer.valueOf(width))) {
            StringBuilder M = a2.b.a.a.a.M("Width not supported after adjustment. Desired:", width, " Range:");
            M.append(this.c.getSupportedWidths());
            throw new VideoException(this, M.toString(), null);
        } else if (this.c.getSupportedHeights().contains((Range<Integer>) Integer.valueOf(height))) {
            try {
                if (!this.c.getSupportedHeightsFor(width).contains((Range<Integer>) Integer.valueOf(height))) {
                    int intValue = this.c.getSupportedWidths().getLower().intValue();
                    int widthAlignment = this.c.getWidthAlignment();
                    int i = width;
                    while (i >= intValue) {
                        i -= 32;
                        while (i % widthAlignment != 0) {
                            i--;
                        }
                        int round = (int) Math.round(((double) i) / d2);
                        if (this.c.getSupportedHeightsFor(i).contains((Range<Integer>) Integer.valueOf(round))) {
                            e.w("getSupportedVideoSize - restarting with smaller size.");
                            return getSupportedVideoSize(new Size(i, round));
                        }
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            if (this.c.isSizeSupported(width, height)) {
                return new Size(width, height);
            }
            StringBuilder L = a2.b.a.a.a.L("Size not supported for unknown reason. Might be an aspect ratio issue. Desired size:");
            L.append(new Size(width, height));
            throw new VideoException(this, L.toString(), null);
        } else {
            StringBuilder M2 = a2.b.a.a.a.M("Height not supported after adjustment. Desired:", height, " Range:");
            M2.append(this.c.getSupportedHeights());
            throw new VideoException(this, M2.toString(), null);
        }
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public String getVideoEncoder() {
        MediaCodecInfo mediaCodecInfo = this.a;
        if (mediaCodecInfo != null) {
            return mediaCodecInfo.getName();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052 A[SYNTHETIC, Splitter:B:24:0x0052] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tryConfigureAudio(@androidx.annotation.NonNull java.lang.String r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            android.media.MediaCodecInfo r0 = r2.b
            if (r0 == 0) goto L_0x0056
            r0 = 0
            android.media.MediaFormat r3 = android.media.MediaFormat.createAudioFormat(r3, r5, r6)     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            r5 = 2
            if (r6 != r5) goto L_0x000f
            r5 = 12
            goto L_0x0011
        L_0x000f:
            r5 = 16
        L_0x0011:
            java.lang.String r6 = "channel-mask"
            r3.setInteger(r6, r5)     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            java.lang.String r5 = "bitrate"
            r3.setInteger(r5, r4)     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            android.media.MediaCodecInfo r4 = r2.b     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            android.media.MediaCodec r4 = android.media.MediaCodec.createByCodecName(r4)     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            r5 = 1
            r4.configure(r3, r0, r0, r5)     // Catch:{ Exception -> 0x002d }
            r4.release()     // Catch:{ Exception -> 0x0056 }
            goto L_0x0056
        L_0x002d:
            r3 = move-exception
            goto L_0x0033
        L_0x002f:
            r3 = move-exception
            goto L_0x0050
        L_0x0031:
            r3 = move-exception
            r4 = r0
        L_0x0033:
            com.otaliastudios.cameraview.internal.DeviceEncoders$AudioException r5 = new com.otaliastudios.cameraview.internal.DeviceEncoders$AudioException     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r6.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r1 = "Failed to configure video audio: "
            r6.append(r1)     // Catch:{ all -> 0x004e }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x004e }
            r6.append(r3)     // Catch:{ all -> 0x004e }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x004e }
            r5.<init>(r2, r3, r0)     // Catch:{ all -> 0x004e }
            throw r5     // Catch:{ all -> 0x004e }
        L_0x004e:
            r3 = move-exception
            r0 = r4
        L_0x0050:
            if (r0 == 0) goto L_0x0055
            r0.release()     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            throw r3
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.internal.DeviceEncoders.tryConfigureAudio(java.lang.String, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f A[SYNTHETIC, Splitter:B:19:0x005f] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tryConfigureVideo(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size r4, int r5, int r6) {
        /*
            r2 = this;
            android.media.MediaCodecInfo r0 = r2.a
            if (r0 == 0) goto L_0x0063
            r0 = 0
            int r1 = r4.getWidth()     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            int r4 = r4.getHeight()     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            android.media.MediaFormat r3 = android.media.MediaFormat.createVideoFormat(r3, r1, r4)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.String r4 = "color-format"
            r1 = 2130708361(0x7f000789, float:1.701803E38)
            r3.setInteger(r4, r1)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.String r4 = "bitrate"
            r3.setInteger(r4, r6)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.String r4 = "frame-rate"
            r3.setInteger(r4, r5)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.String r4 = "i-frame-interval"
            r5 = 1
            r3.setInteger(r4, r5)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            android.media.MediaCodecInfo r4 = r2.a     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            android.media.MediaCodec r4 = android.media.MediaCodec.createByCodecName(r4)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r4.configure(r3, r0, r0, r5)     // Catch:{ Exception -> 0x003a }
            r4.release()     // Catch:{ Exception -> 0x0063 }
            goto L_0x0063
        L_0x003a:
            r3 = move-exception
            goto L_0x0040
        L_0x003c:
            r3 = move-exception
            goto L_0x005d
        L_0x003e:
            r3 = move-exception
            r4 = r0
        L_0x0040:
            com.otaliastudios.cameraview.internal.DeviceEncoders$VideoException r5 = new com.otaliastudios.cameraview.internal.DeviceEncoders$VideoException     // Catch:{ all -> 0x005b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            r6.<init>()     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "Failed to configure video codec: "
            r6.append(r1)     // Catch:{ all -> 0x005b }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x005b }
            r6.append(r3)     // Catch:{ all -> 0x005b }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x005b }
            r5.<init>(r2, r3, r0)     // Catch:{ all -> 0x005b }
            throw r5     // Catch:{ all -> 0x005b }
        L_0x005b:
            r3 = move-exception
            r0 = r4
        L_0x005d:
            if (r0 == 0) goto L_0x0062
            r0.release()     // Catch:{ Exception -> 0x0062 }
        L_0x0062:
            throw r3
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.internal.DeviceEncoders.tryConfigureVideo(java.lang.String, com.otaliastudios.cameraview.size.Size, int, int):void");
    }
}
