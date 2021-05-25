package com.my.target;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.nativeads.views.MediaAdView;
public class fz extends RelativeLayout {
    public static final int h = io.fh();
    @NonNull
    public final fx a;
    @NonNull
    public final RelativeLayout.LayoutParams b;
    @NonNull
    public final gc c;
    @NonNull
    public final ft d;
    @NonNull
    public final io e;
    @Nullable
    public ImageData f;
    @Nullable
    public ImageData g;

    public fz(Context context) {
        super(context);
        setBackgroundColor(0);
        this.e = io.af(context);
        gc gcVar = new gc(context);
        this.c = gcVar;
        int i = h;
        gcVar.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        gcVar.setLayoutParams(layoutParams);
        addView(gcVar);
        fx fxVar = new fx(context);
        this.a = fxVar;
        fxVar.a(fh.z((int) TypedValue.applyDimension(1, 28.0f, context.getResources().getDisplayMetrics())), false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.b = layoutParams2;
        layoutParams2.addRule(7, i);
        layoutParams2.addRule(6, i);
        fxVar.setLayoutParams(layoutParams2);
        ft ftVar = new ft(context);
        this.d = ftVar;
        addView(fxVar);
        addView(ftVar);
    }

    public void a(@Nullable ImageData imageData, @Nullable ImageData imageData2, @Nullable ImageData imageData3) {
        this.g = imageData;
        this.f = imageData2;
        Bitmap bitmap = imageData3 != null ? imageData3.getBitmap() : null;
        if (bitmap != null) {
            this.a.a(bitmap, true);
            RelativeLayout.LayoutParams layoutParams = this.b;
            int i = -this.a.getMeasuredWidth();
            layoutParams.leftMargin = i;
            layoutParams.bottomMargin = i;
        }
        b();
    }

    public final void b() {
        WindowManager windowManager = (WindowManager) getContext().getApplicationContext().getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            ImageData imageData = ((float) defaultDisplay.getWidth()) / ((float) defaultDisplay.getHeight()) > 1.0f ? this.g : this.f;
            if (imageData == null && (imageData = this.g) == null) {
                imageData = this.f;
            }
            if (imageData != null) {
                this.c.setImageData(imageData);
            }
        }
    }

    @NonNull
    public fx getCloseButton() {
        return this.a;
    }

    @NonNull
    public ImageView getImageView() {
        return this.c;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void setAgeRestrictions(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d.e(1, -7829368);
            this.d.setPadding(this.e.L(2), 0, 0, 0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int L = this.e.L(10);
            layoutParams.topMargin = L;
            layoutParams.leftMargin = L;
            int i = h;
            layoutParams.addRule(5, i);
            layoutParams.addRule(6, i);
            this.d.setLayoutParams(layoutParams);
            this.d.setTextColor(MediaAdView.COLOR_PLACEHOLDER_GRAY);
            this.d.a(1, MediaAdView.COLOR_PLACEHOLDER_GRAY, this.e.L(3));
            this.d.setBackgroundColor(1711276032);
            this.d.setText(str);
            return;
        }
        this.d.setVisibility(8);
    }
}
