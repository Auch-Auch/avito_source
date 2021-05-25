package com.my.target.nativeads;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
public interface INativeAd {
    int getAdChoicesPlacement();

    int getCachePolicy();

    void handleData(@NonNull String str);

    void load();

    void loadFromBid(@NonNull String str);

    void registerView(@NonNull View view);

    void registerView(@NonNull View view, @Nullable List<View> list);

    void setAdChoicesPlacement(int i);

    void setCachePolicy(int i);

    void unregisterView();
}
