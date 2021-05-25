package com.caverock.androidsvg;

import a2.e.a.b;
import com.caverock.androidsvg.SVG;
import java.util.List;
public class RenderOptions {
    public b.r a = null;
    public PreserveAspectRatio b = null;
    public String c = null;
    public SVG.a d = null;
    public String e = null;
    public SVG.a f = null;

    public RenderOptions() {
    }

    public static RenderOptions create() {
        return new RenderOptions();
    }

    public RenderOptions css(String str) {
        this.a = new b(b.u.RenderOptions).c(str);
        return this;
    }

    public boolean hasCss() {
        b.r rVar = this.a;
        if (rVar == null) {
            return false;
        }
        List<b.p> list = rVar.a;
        if ((list != null ? list.size() : 0) > 0) {
            return true;
        }
        return false;
    }

    public boolean hasPreserveAspectRatio() {
        return this.b != null;
    }

    public boolean hasTarget() {
        return this.c != null;
    }

    public boolean hasView() {
        return this.e != null;
    }

    public boolean hasViewBox() {
        return this.d != null;
    }

    public boolean hasViewPort() {
        return this.f != null;
    }

    public RenderOptions preserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        this.b = preserveAspectRatio;
        return this;
    }

    public RenderOptions target(String str) {
        this.c = str;
        return this;
    }

    public RenderOptions view(String str) {
        this.e = str;
        return this;
    }

    public RenderOptions viewBox(float f2, float f3, float f4, float f5) {
        this.d = new SVG.a(f2, f3, f4, f5);
        return this;
    }

    public RenderOptions viewPort(float f2, float f3, float f4, float f5) {
        this.f = new SVG.a(f2, f3, f4, f5);
        return this;
    }

    public RenderOptions(RenderOptions renderOptions) {
        if (renderOptions != null) {
            this.a = renderOptions.a;
            this.b = renderOptions.b;
            this.d = renderOptions.d;
            this.e = renderOptions.e;
            this.f = renderOptions.f;
        }
    }
}
