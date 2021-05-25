package com.google.android.exoplayer2.mediacodec;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
public class MediaCodecDecoderException extends DecoderException {
    @Nullable
    public final MediaCodecInfo codecInfo;
    @Nullable
    public final String diagnosticInfo;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaCodecDecoderException(java.lang.Throwable r4, @androidx.annotation.Nullable com.google.android.exoplayer2.mediacodec.MediaCodecInfo r5) {
        /*
            r3 = this;
            java.lang.String r0 = "Decoder failed: "
            java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
            r1 = 0
            if (r5 != 0) goto L_0x000b
            r2 = r1
            goto L_0x000d
        L_0x000b:
            java.lang.String r2 = r5.name
        L_0x000d:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0, r4)
            r3.codecInfo = r5
            int r5 = com.google.android.exoplayer2.util.Util.SDK_INT
            r0 = 21
            if (r5 < r0) goto L_0x0029
            boolean r5 = r4 instanceof android.media.MediaCodec.CodecException
            if (r5 == 0) goto L_0x0029
            android.media.MediaCodec$CodecException r4 = (android.media.MediaCodec.CodecException) r4
            java.lang.String r1 = r4.getDiagnosticInfo()
        L_0x0029:
            r3.diagnosticInfo = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException.<init>(java.lang.Throwable, com.google.android.exoplayer2.mediacodec.MediaCodecInfo):void");
    }
}
