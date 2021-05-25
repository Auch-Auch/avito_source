package x6.f;

import androidx.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.EglBase10;
import org.webrtc.EglBase10Impl;
import org.webrtc.EglBase14;
import org.webrtc.EglBase14Impl;
/* compiled from: EglBase */
public final /* synthetic */ class n0 {
    public static EglBase a() {
        return b(null, EglBase.CONFIG_PLAIN);
    }

    public static EglBase b(@Nullable EglBase.Context context, int[] iArr) {
        if (context == null) {
            if (EglBase14Impl.isEGL14Supported()) {
                return new EglBase14Impl(null, iArr);
            }
            return new EglBase10Impl(null, iArr);
        } else if (context instanceof EglBase14.Context) {
            return new EglBase14Impl(((EglBase14.Context) context).getRawContext(), iArr);
        } else {
            if (context instanceof EglBase10.Context) {
                return new EglBase10Impl(((EglBase10.Context) context).getRawContext(), iArr);
            }
            throw new IllegalArgumentException("Unrecognized Context");
        }
    }

    public static int c(int[] iArr) {
        for (int i = 0; i < iArr.length - 1; i++) {
            if (iArr[i] == 12352) {
                int i2 = iArr[i + 1];
                if (i2 == 4) {
                    return 2;
                }
                if (i2 != 64) {
                    return 1;
                }
                return 3;
            }
        }
        return 1;
    }
}
