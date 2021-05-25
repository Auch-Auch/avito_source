package com.my.target;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public interface gs {

    public interface a {
        void dy();
    }

    void ek();

    @NonNull
    View getCloseButton();

    @NonNull
    View getView();

    void setBanner(@NonNull ce ceVar);

    void setClickArea(@NonNull bq bqVar);

    void setInterstitialPromoViewListener(@Nullable a aVar);
}
