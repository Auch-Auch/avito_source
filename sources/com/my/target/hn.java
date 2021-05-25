package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import com.my.target.hj;
@SuppressLint({"ViewConstructor"})
public class hn extends hk {
    public hn(@NonNull View view, @NonNull View view2, @NonNull hj.a aVar, @Nullable View view3, @NonNull ho hoVar, @NonNull Context context) {
        super(view, view2, aVar, view3, hoVar, context);
        addView(this.a);
        addView(this.g);
        addView(this.h);
        addView(this.l);
        addView(this.u);
        addView(view2);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0073: APUT  (r12v7 int[]), (0 ??[int, short, byte, char]), (r13v3 int) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x008d: APUT  (r13v6 int[]), (0 ??[int, short, byte, char]), (r14v1 int) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x040d: APUT  (r7v0 int[]), (0 ??[int, short, byte, char]), (r9v2 int) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0427: APUT  (r9v5 int[]), (0 ??[int, short, byte, char]), (r6v3 int) */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0248  */
    @Override // com.my.target.hk, android.view.ViewGroup, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
        // Method dump skipped, instructions count: 1227
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hn.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0092: APUT  (r6v17 int[]), (0 ??[int, short, byte, char]), (r7v5 int) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0174: APUT  (r1v11 int[]), (0 ??[int, short, byte, char]), (r5v2 int) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bc, code lost:
        if (android.text.TextUtils.isEmpty(r10.r.getText()) == false) goto L_0x00e0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01c2  */
    @Override // com.my.target.hk, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 512
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hn.onMeasure(int, int):void");
    }

    @Override // com.my.target.hk, com.my.target.hj
    public void setBanner(@NonNull ce ceVar) {
        String str;
        fy fyVar;
        ImageData image;
        Bitmap bitmap;
        super.setBanner(ceVar);
        cf<VideoData> videoBanner = ceVar.getVideoBanner();
        if (videoBanner != null) {
            this.e.setVisibility(0);
            this.a.setVisibility(0);
            this.a.setOnClickListener(this);
            if (videoBanner.isAutoMute()) {
                this.a.a(this.w, false);
                fyVar = this.a;
                str = "sound_off";
            } else {
                this.a.a(this.v, false);
                fyVar = this.a;
                str = "sound_on";
            }
            fyVar.setContentDescription(str);
            this.g.setImageBitmap(this.x);
            this.P = 0;
            View view = this.L;
            if (view != null) {
                view.setOnClickListener(this);
            }
            this.m.setOnClickListener(this);
            VideoData mediaData = videoBanner.getMediaData();
            ImageData preview = videoBanner.getPreview();
            if (mediaData != null) {
                this.M = mediaData.getWidth();
                this.N = mediaData.getHeight();
            }
            if ((this.M <= 0 || this.N <= 0) && preview != null) {
                this.M = preview.getWidth();
                this.N = preview.getHeight();
            }
            if ((this.M <= 0 || this.N <= 0) && (image = ceVar.getImage()) != null) {
                this.M = image.getWidth();
                int height = image.getHeight();
                this.N = height;
                if ((this.M <= 0 || height <= 0) && (bitmap = image.getBitmap()) != null) {
                    this.M = bitmap.getWidth();
                    this.N = bitmap.getHeight();
                }
            }
        }
    }
}
