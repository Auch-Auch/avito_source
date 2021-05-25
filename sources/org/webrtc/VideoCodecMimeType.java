package org.webrtc;

import com.google.android.exoplayer2.util.MimeTypes;
public enum VideoCodecMimeType {
    VP8(MimeTypes.VIDEO_VP8),
    VP9(MimeTypes.VIDEO_VP9),
    H264(MimeTypes.VIDEO_H264);
    
    private final String mimeType;

    private VideoCodecMimeType(String str) {
        this.mimeType = str;
    }

    public String mimeType() {
        return this.mimeType;
    }
}
