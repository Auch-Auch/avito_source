package com.otaliastudios.opengl.program;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/otaliastudios/opengl/program/GlFlatProgram;", "Lcom/otaliastudios/opengl/program/GlNativeFlatProgram;", "", "color", "", "setColor", "(I)V", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class GlFlatProgram extends GlNativeFlatProgram {
    public final void setColor(@ColorInt int i) {
        setColor(new float[]{((float) Color.red(i)) / 255.0f, ((float) Color.green(i)) / 255.0f, ((float) Color.blue(i)) / 255.0f, ((float) Color.alpha(i)) / 255.0f});
    }
}
