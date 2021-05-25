package a2.t.a.c.n0;

import com.voximplant.sdk.call.VideoCodec;
import com.voximplant.sdk.call.VideoStreamType;
import com.voximplant.sdk.internal.Logger;
public class e2 {
    public VideoCodec a = VideoCodec.VP8;
    public boolean b = false;
    public boolean c = false;
    public boolean d = true;
    public VideoStreamType e = null;

    public void a(VideoCodec videoCodec) {
        this.a = videoCodec;
        Logger.d("PCVideoParameters: Preferred video codec: " + videoCodec);
    }
}
