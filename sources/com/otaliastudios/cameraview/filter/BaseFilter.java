package com.otaliastudios.cameraview.filter;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.opengl.draw.GlDrawable;
import com.otaliastudios.opengl.draw.GlRect;
import com.otaliastudios.opengl.program.GlTextureProgram;
public abstract class BaseFilter implements Filter {
    public static final String DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME = "vTextureCoord";
    public static final String DEFAULT_VERTEX_MVP_MATRIX_NAME = "uMVPMatrix";
    public static final String DEFAULT_VERTEX_POSITION_NAME = "aPosition";
    public static final String DEFAULT_VERTEX_TEXTURE_COORDINATE_NAME = "aTextureCoord";
    public static final String DEFAULT_VERTEX_TRANSFORM_MATRIX_NAME = "uTexMatrix";
    public static final CameraLogger d = CameraLogger.create(BaseFilter.class.getSimpleName());
    @VisibleForTesting
    public GlTextureProgram a = null;
    public GlDrawable b = null;
    @VisibleForTesting
    public Size c;
    public String fragmentTextureCoordinateName = DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME;
    public String vertexModelViewProjectionMatrixName = DEFAULT_VERTEX_MVP_MATRIX_NAME;
    public String vertexPositionName = DEFAULT_VERTEX_POSITION_NAME;
    public String vertexTextureCoordinateName = DEFAULT_VERTEX_TEXTURE_COORDINATE_NAME;
    public String vertexTransformMatrixName = DEFAULT_VERTEX_TRANSFORM_MATRIX_NAME;

    @NonNull
    public String createDefaultFragmentShader() {
        String str = this.fragmentTextureCoordinateName;
        return a.f("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 ", str, ";\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, ", str, ");\n}\n");
    }

    @NonNull
    public String createDefaultVertexShader() {
        String str = this.vertexPositionName;
        String str2 = this.vertexTextureCoordinateName;
        String str3 = this.vertexModelViewProjectionMatrixName;
        String str4 = this.vertexTransformMatrixName;
        String str5 = this.fragmentTextureCoordinateName;
        StringBuilder W = a.W("uniform mat4 ", str3, ";\nuniform mat4 ", str4, ";\nattribute vec4 ");
        a.n1(W, str, ";\nattribute vec4 ", str2, ";\nvarying vec2 ");
        a.n1(W, str5, ";\nvoid main() {\n    gl_Position = ", str3, " * ");
        a.n1(W, str, ";\n    ", str5, " = (");
        return a.v(W, str4, " * ", str2, ").xy;\n}\n");
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void draw(long j, @NonNull float[] fArr) {
        if (this.a == null) {
            d.w("Filter.draw() called after destroying the filter. This can happen rarely because of threading.");
            return;
        }
        onPreDraw(j, fArr);
        onDraw(j);
        onPostDraw(j);
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getVertexShader() {
        return createDefaultVertexShader();
    }

    @NonNull
    public BaseFilter onCopy() {
        try {
            return (BaseFilter) getClass().newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e2);
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        this.a = new GlTextureProgram(i, this.vertexPositionName, this.vertexModelViewProjectionMatrixName, this.vertexTextureCoordinateName, this.vertexTransformMatrixName);
        this.b = new GlRect();
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        this.a.release();
        this.a = null;
        this.b = null;
    }

    public void onDraw(long j) {
        this.a.onDraw(this.b);
    }

    public void onPostDraw(long j) {
        this.a.onPostDraw(this.b);
    }

    public void onPreDraw(long j, @NonNull float[] fArr) {
        this.a.setTextureTransform(fArr);
        GlTextureProgram glTextureProgram = this.a;
        GlDrawable glDrawable = this.b;
        glTextureProgram.onPreDraw(glDrawable, glDrawable.getModelMatrix());
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i, int i2) {
        this.c = new Size(i, i2);
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public final BaseFilter copy() {
        BaseFilter onCopy = onCopy();
        Size size = this.c;
        if (size != null) {
            onCopy.setSize(size.getWidth(), this.c.getHeight());
        }
        if (this instanceof OneParameterFilter) {
            ((OneParameterFilter) onCopy).setParameter1(((OneParameterFilter) this).getParameter1());
        }
        if (this instanceof TwoParameterFilter) {
            ((TwoParameterFilter) onCopy).setParameter2(((TwoParameterFilter) this).getParameter2());
        }
        return onCopy;
    }
}
