package com.otaliastudios.cameraview.video.encoding;

import a2.b.a.a.a;
import com.google.android.exoplayer2.util.MimeTypes;
public class AudioConfig {
    public final int a = (44100 * 2);
    public int bitRate;
    public int channels = 1;
    public String encoder;
    public String mimeType = MimeTypes.AUDIO_AAC;
    public int samplingFrequency = 44100;

    public int a() {
        int i = this.channels;
        if (i == 1) {
            return 16;
        }
        if (i == 2) {
            return 12;
        }
        StringBuilder L = a.L("Invalid number of channels: ");
        L.append(this.channels);
        throw new RuntimeException(L.toString());
    }

    public int b() {
        return this.a * this.channels;
    }
}
