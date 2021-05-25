package com.otaliastudios.cameraview.filter;

import androidx.annotation.NonNull;
public interface Filter {
    @NonNull
    Filter copy();

    void draw(long j, @NonNull float[] fArr);

    @NonNull
    String getFragmentShader();

    @NonNull
    String getVertexShader();

    void onCreate(int i);

    void onDestroy();

    void setSize(int i, int i2);
}
