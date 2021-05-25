package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzadj;
public class MediaView extends FrameLayout {
    private MediaContent zzbnc;
    private boolean zzbnd;
    private zzadh zzbne;
    private ImageView.ScaleType zzbnf;
    private boolean zzbng;
    private zzadj zzbnh;

    public MediaView(Context context) {
        super(context);
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzbng = true;
        this.zzbnf = scaleType;
        zzadj zzadj = this.zzbnh;
        if (zzadj != null) {
            zzadj.setImageScaleType(scaleType);
        }
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzbnd = true;
        this.zzbnc = mediaContent;
        zzadh zzadh = this.zzbne;
        if (zzadh != null) {
            zzadh.setMediaContent(mediaContent);
        }
    }

    public final synchronized void zza(zzadh zzadh) {
        this.zzbne = zzadh;
        if (this.zzbnd) {
            zzadh.setMediaContent(this.zzbnc);
        }
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final synchronized void zza(zzadj zzadj) {
        this.zzbnh = zzadj;
        if (this.zzbng) {
            zzadj.setImageScaleType(this.zzbnf);
        }
    }
}
