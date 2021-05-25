package a2.j.b.b.a1.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.yandex.mobile.ads.video.tracking.Tracker;
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public a(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public static a a(String str) {
        char c2;
        Assertions.checkArgument(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < split.length; i5++) {
            String lowerInvariant = Util.toLowerInvariant(split[i5].trim());
            lowerInvariant.hashCode();
            switch (lowerInvariant.hashCode()) {
                case 100571:
                    if (lowerInvariant.equals("end")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3556653:
                    if (lowerInvariant.equals("text")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (lowerInvariant.equals(Tracker.Events.CREATIVE_START)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109780401:
                    if (lowerInvariant.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                i2 = i5;
            } else if (c2 == 1) {
                i4 = i5;
            } else if (c2 == 2) {
                i = i5;
            } else if (c2 == 3) {
                i3 = i5;
            }
        }
        if (i == -1 || i2 == -1) {
            return null;
        }
        return new a(i, i2, i3, i4, split.length);
    }
}
