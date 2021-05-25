package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzwe;
public final class zzq extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzdoz;
    private final zzy zzdpa;

    public zzq(Context context, zzp zzp, @Nullable zzy zzy) {
        super(context);
        this.zzdpa = zzy;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zzdoz = imageButton;
        imageButton.setImageResource(17301527);
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzwe.zzpq();
        int zzc = zzbat.zzc(context, zzp.paddingLeft);
        zzwe.zzpq();
        int zzc2 = zzbat.zzc(context, 0);
        zzwe.zzpq();
        int zzc3 = zzbat.zzc(context, zzp.paddingRight);
        zzwe.zzpq();
        imageButton.setPadding(zzc, zzc2, zzc3, zzbat.zzc(context, zzp.paddingBottom));
        imageButton.setContentDescription("Interstitial close button");
        zzwe.zzpq();
        int zzc4 = zzbat.zzc(context, zzp.size + zzp.paddingLeft + zzp.paddingRight);
        zzwe.zzpq();
        addView(imageButton, new FrameLayout.LayoutParams(zzc4, zzbat.zzc(context, zzp.size + zzp.paddingBottom), 17));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzy zzy = this.zzdpa;
        if (zzy != null) {
            zzy.zzup();
        }
    }

    public final void zzal(boolean z) {
        if (z) {
            this.zzdoz.setVisibility(8);
        } else {
            this.zzdoz.setVisibility(0);
        }
    }
}
