package com.yandex.mobile.ads.nativeads.template;

import android.content.Context;
import android.widget.RatingBar;
import com.yandex.mobile.ads.nativeads.Rating;
public final class f extends RatingBar implements Rating {
    public f(Context context) {
        super(context, null, 16842877);
    }

    @Override // android.widget.RatingBar, com.yandex.mobile.ads.nativeads.Rating
    public final float getRating() {
        return super.getRating();
    }

    @Override // com.yandex.mobile.ads.nativeads.Rating
    public final void setRating(Float f) {
        setRating(f.floatValue());
    }
}
