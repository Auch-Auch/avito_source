package com.my.target;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public interface gn {

    public interface a {
        void b(int i, @NonNull Context context);

        void b(@NonNull View view, int i);

        void b(@NonNull int[] iArr, @NonNull Context context);
    }

    void dispose();

    @Nullable
    Parcelable getState();

    @NonNull
    int[] getVisibleCardNumbers();

    void restoreState(@NonNull Parcelable parcelable);

    void setPromoCardSliderListener(@Nullable a aVar);
}
