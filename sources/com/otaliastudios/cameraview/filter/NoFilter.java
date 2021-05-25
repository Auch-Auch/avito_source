package com.otaliastudios.cameraview.filter;

import androidx.annotation.NonNull;
public final class NoFilter extends BaseFilter {
    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return createDefaultFragmentShader();
    }
}
