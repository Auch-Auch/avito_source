package com.otaliastudios.cameraview.filter;

import androidx.annotation.NonNull;
public final class SimpleFilter extends BaseFilter {
    public final String e;

    public SimpleFilter(@NonNull String str) {
        this.e = str;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    @NonNull
    public BaseFilter onCopy() {
        return new SimpleFilter(this.e);
    }
}
