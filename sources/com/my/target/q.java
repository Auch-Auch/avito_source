package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import java.util.List;
public class q extends d<cq> {
    @NonNull
    public static q i() {
        return new q();
    }

    @Nullable
    public cq a(@NonNull cq cqVar, @NonNull a aVar, @NonNull Context context) {
        ca bX = cqVar.bX();
        if (bX == null) {
            cl bQ = cqVar.bQ();
            if (bQ == null || !bQ.bL()) {
                return null;
            }
            return cqVar;
        } else if (c(context, bX)) {
            return cqVar;
        } else {
            return null;
        }
    }

    @Nullable
    public final ImageData b(@NonNull List<ImageData> list, int i, int i2) {
        float f;
        float f2;
        ImageData imageData = null;
        if (list.size() == 0) {
            return null;
        }
        if (i2 == 0 || i == 0) {
            ae.a("[InterstitialAdResultProcessor] display size is zero");
            return null;
        }
        float f3 = (float) i;
        float f4 = (float) i2;
        float f5 = f3 / f4;
        float f6 = 0.0f;
        for (ImageData imageData2 : list) {
            if (imageData2.getWidth() > 0 && imageData2.getHeight() > 0) {
                float width = ((float) imageData2.getWidth()) / ((float) imageData2.getHeight());
                if (f5 < width) {
                    f = (float) imageData2.getWidth();
                    if (f > f3) {
                        f = f3;
                    }
                    f2 = f / width;
                } else {
                    float height = (float) imageData2.getHeight();
                    if (height > f4) {
                        height = f4;
                    }
                    f = width * height;
                    f2 = height;
                }
                float f7 = f2 * f;
                if (f7 <= f6) {
                    break;
                }
                imageData = imageData2;
                f6 = f7;
            }
        }
        return imageData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (r8.isVideoRequired() != false) goto L_0x0179;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(@androidx.annotation.NonNull android.content.Context r7, com.my.target.ca r8) {
        /*
        // Method dump skipped, instructions count: 379
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.q.c(android.content.Context, com.my.target.ca):boolean");
    }
}
