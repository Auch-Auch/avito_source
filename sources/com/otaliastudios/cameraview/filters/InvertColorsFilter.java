package com.otaliastudios.cameraview.filters;

import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.BaseFilter;
public class InvertColorsFilter extends BaseFilter {
    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float colorR = (1.0 - color.r) / 1.0;\n  float colorG = (1.0 - color.g) / 1.0;\n  float colorB = (1.0 - color.b) / 1.0;\n  gl_FragColor = vec4(colorR, colorG, colorB, color.a);\n}\n";
    }
}
