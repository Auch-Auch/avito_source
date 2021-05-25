package com.google.android.exoplayer2.mediacodec;

import a2.j.b.b.v0.f;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;
public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = f.a;

    List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException;
}
