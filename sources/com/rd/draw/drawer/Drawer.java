package com.rd.draw.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.type.BasicDrawer;
import com.rd.draw.drawer.type.ColorDrawer;
import com.rd.draw.drawer.type.DropDrawer;
import com.rd.draw.drawer.type.FillDrawer;
import com.rd.draw.drawer.type.ScaleDownDrawer;
import com.rd.draw.drawer.type.ScaleDrawer;
import com.rd.draw.drawer.type.SlideDrawer;
import com.rd.draw.drawer.type.SwapDrawer;
import com.rd.draw.drawer.type.ThinWormDrawer;
import com.rd.draw.drawer.type.WormDrawer;
public class Drawer {
    public BasicDrawer a;
    public ColorDrawer b;
    public ScaleDrawer c;
    public WormDrawer d;
    public SlideDrawer e;
    public FillDrawer f;
    public ThinWormDrawer g;
    public DropDrawer h;
    public SwapDrawer i;
    public ScaleDownDrawer j;
    public int k;
    public int l;
    public int m;

    public Drawer(@NonNull Indicator indicator) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.a = new BasicDrawer(paint, indicator);
        this.b = new ColorDrawer(paint, indicator);
        this.c = new ScaleDrawer(paint, indicator);
        this.d = new WormDrawer(paint, indicator);
        this.e = new SlideDrawer(paint, indicator);
        this.f = new FillDrawer(paint, indicator);
        this.g = new ThinWormDrawer(paint, indicator);
        this.h = new DropDrawer(paint, indicator);
        this.i = new SwapDrawer(paint, indicator);
        this.j = new ScaleDownDrawer(paint, indicator);
    }

    public void drawBasic(@NonNull Canvas canvas, boolean z) {
        if (this.b != null) {
            this.a.draw(canvas, this.k, z, this.l, this.m);
        }
    }

    public void drawColor(@NonNull Canvas canvas, @NonNull Value value) {
        ColorDrawer colorDrawer = this.b;
        if (colorDrawer != null) {
            colorDrawer.draw(canvas, value, this.k, this.l, this.m);
        }
    }

    public void drawDrop(@NonNull Canvas canvas, @NonNull Value value) {
        DropDrawer dropDrawer = this.h;
        if (dropDrawer != null) {
            dropDrawer.draw(canvas, value, this.l, this.m);
        }
    }

    public void drawFill(@NonNull Canvas canvas, @NonNull Value value) {
        FillDrawer fillDrawer = this.f;
        if (fillDrawer != null) {
            fillDrawer.draw(canvas, value, this.k, this.l, this.m);
        }
    }

    public void drawScale(@NonNull Canvas canvas, @NonNull Value value) {
        ScaleDrawer scaleDrawer = this.c;
        if (scaleDrawer != null) {
            scaleDrawer.draw(canvas, value, this.k, this.l, this.m);
        }
    }

    public void drawScaleDown(@NonNull Canvas canvas, @NonNull Value value) {
        ScaleDownDrawer scaleDownDrawer = this.j;
        if (scaleDownDrawer != null) {
            scaleDownDrawer.draw(canvas, value, this.k, this.l, this.m);
        }
    }

    public void drawSlide(@NonNull Canvas canvas, @NonNull Value value) {
        SlideDrawer slideDrawer = this.e;
        if (slideDrawer != null) {
            slideDrawer.draw(canvas, value, this.l, this.m);
        }
    }

    public void drawSwap(@NonNull Canvas canvas, @NonNull Value value) {
        SwapDrawer swapDrawer = this.i;
        if (swapDrawer != null) {
            swapDrawer.draw(canvas, value, this.k, this.l, this.m);
        }
    }

    public void drawThinWorm(@NonNull Canvas canvas, @NonNull Value value) {
        ThinWormDrawer thinWormDrawer = this.g;
        if (thinWormDrawer != null) {
            thinWormDrawer.draw(canvas, value, this.l, this.m);
        }
    }

    public void drawWorm(@NonNull Canvas canvas, @NonNull Value value) {
        WormDrawer wormDrawer = this.d;
        if (wormDrawer != null) {
            wormDrawer.draw(canvas, value, this.l, this.m);
        }
    }

    public void setup(int i2, int i3, int i4) {
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }
}
