package com.otaliastudios.cameraview.filter;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.program.GlProgram;
import com.otaliastudios.opengl.program.GlTextureProgram;
import com.otaliastudios.opengl.texture.GlFramebuffer;
import com.otaliastudios.opengl.texture.GlTexture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MultiFilter implements Filter, OneParameterFilter, TwoParameterFilter {
    @VisibleForTesting
    public final List<Filter> a;
    @VisibleForTesting
    public final Map<Filter, a> b;
    public final Object c;
    public Size d;
    public float e;
    public float f;

    @VisibleForTesting
    public static class a {
        @VisibleForTesting
        public boolean a = false;
        @VisibleForTesting
        public boolean b = false;
        public boolean c = false;
        @VisibleForTesting
        public Size d = null;
        public int e = -1;
        public GlFramebuffer f = null;
        public GlTexture g = null;
    }

    public MultiFilter(@NonNull Filter... filterArr) {
        this(Arrays.asList(filterArr));
    }

    public final void a(@NonNull Filter filter, boolean z) {
        a aVar = this.b.get(filter);
        if (z) {
            aVar.c = false;
            return;
        }
        if (aVar.c) {
            c(filter);
            aVar.c = false;
        }
        if (!aVar.b) {
            aVar.b = true;
            aVar.g = new GlTexture(33984, 3553, aVar.d.getWidth(), aVar.d.getHeight());
            GlFramebuffer glFramebuffer = new GlFramebuffer();
            aVar.f = glFramebuffer;
            glFramebuffer.attach(aVar.g);
        }
    }

    public void addFilter(@NonNull Filter filter) {
        if (filter instanceof MultiFilter) {
            for (Filter filter2 : ((MultiFilter) filter).a) {
                addFilter(filter2);
            }
            return;
        }
        synchronized (this.c) {
            if (!this.a.contains(filter)) {
                this.a.add(filter);
                this.b.put(filter, new a());
            }
        }
    }

    public final void b(@NonNull Filter filter, boolean z) {
        String str;
        a aVar = this.b.get(filter);
        if (!aVar.a) {
            aVar.a = true;
            if (z) {
                str = filter.getFragmentShader();
            } else {
                str = filter.getFragmentShader().replace("samplerExternalOES ", "sampler2D ");
            }
            int create = GlProgram.create(filter.getVertexShader(), str);
            aVar.e = create;
            filter.onCreate(create);
        }
    }

    public final void c(@NonNull Filter filter) {
        a aVar = this.b.get(filter);
        if (aVar.b) {
            aVar.b = false;
            aVar.f.release();
            aVar.f = null;
            aVar.g.release();
            aVar.g = null;
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public Filter copy() {
        MultiFilter multiFilter;
        synchronized (this.c) {
            multiFilter = new MultiFilter(new Filter[0]);
            Size size = this.d;
            if (size != null) {
                multiFilter.setSize(size.getWidth(), this.d.getHeight());
            }
            for (Filter filter : this.a) {
                multiFilter.addFilter(filter.copy());
            }
        }
        return multiFilter;
    }

    public final void d(@NonNull Filter filter) {
        a aVar = this.b.get(filter);
        Size size = this.d;
        if (size != null && !size.equals(aVar.d)) {
            Size size2 = this.d;
            aVar.d = size2;
            aVar.c = true;
            filter.setSize(size2.getWidth(), this.d.getHeight());
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void draw(long j, @NonNull float[] fArr) {
        synchronized (this.c) {
            int i = 0;
            while (i < this.a.size()) {
                boolean z = true;
                boolean z2 = i == 0;
                if (i != this.a.size() - 1) {
                    z = false;
                }
                Filter filter = this.a.get(i);
                a aVar = this.b.get(filter);
                d(filter);
                b(filter, z2);
                a(filter, z);
                GLES20.glUseProgram(aVar.e);
                if (!z) {
                    aVar.f.bind();
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                } else {
                    GLES20.glBindFramebuffer(36160, 0);
                }
                if (z2) {
                    filter.draw(j, fArr);
                } else {
                    filter.draw(j, Egloo.IDENTITY_MATRIX);
                }
                if (!z) {
                    aVar.g.bind();
                } else {
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glActiveTexture(33984);
                }
                GLES20.glUseProgram(0);
                i++;
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return GlTextureProgram.SIMPLE_FRAGMENT_SHADER;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public float getParameter2() {
        return this.f;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getVertexShader() {
        return GlTextureProgram.SIMPLE_VERTEX_SHADER;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        synchronized (this.c) {
            for (Filter filter : this.a) {
                c(filter);
                a aVar = this.b.get(filter);
                if (aVar.a) {
                    aVar.a = false;
                    filter.onDestroy();
                    GLES20.glDeleteProgram(aVar.e);
                    aVar.e = -1;
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f2) {
        this.e = f2;
        synchronized (this.c) {
            for (Filter filter : this.a) {
                if (filter instanceof OneParameterFilter) {
                    ((OneParameterFilter) filter).setParameter1(f2);
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public void setParameter2(float f2) {
        this.f = f2;
        synchronized (this.c) {
            for (Filter filter : this.a) {
                if (filter instanceof TwoParameterFilter) {
                    ((TwoParameterFilter) filter).setParameter2(f2);
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i, int i2) {
        this.d = new Size(i, i2);
        synchronized (this.c) {
            for (Filter filter : this.a) {
                d(filter);
            }
        }
    }

    public MultiFilter(@NonNull Collection<Filter> collection) {
        this.a = new ArrayList();
        this.b = new HashMap();
        this.c = new Object();
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        for (Filter filter : collection) {
            addFilter(filter);
        }
    }
}
