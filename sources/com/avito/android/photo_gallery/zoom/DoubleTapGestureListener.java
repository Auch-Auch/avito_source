package com.avito.android.photo_gallery.zoom;

import android.graphics.PointF;
import android.view.GestureDetector;
public class DoubleTapGestureListener extends GestureDetector.SimpleOnGestureListener {
    public final ZoomableDraweeView a;
    public final PointF b = new PointF();
    public final PointF c = new PointF();
    public float d = 1.0f;
    public boolean e = false;

    public DoubleTapGestureListener(ZoomableDraweeView zoomableDraweeView) {
        this.a = zoomableDraweeView;
    }

    public final float a(PointF pointF) {
        float f = pointF.y - this.b.y;
        float abs = (Math.abs(f) * 0.001f) + 1.0f;
        return f < 0.0f ? this.d / abs : this.d * abs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0048, code lost:
        if ((java.lang.Math.hypot((double) (r11 - r2.x), (double) (r4.y - r2.y)) > 20.0d) != false) goto L_0x004a;
     */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onDoubleTapEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            com.avito.android.photo_gallery.zoom.ZoomableDraweeView r0 = r10.a
            com.avito.android.photo_gallery.zoom.ZoomableController r0 = r0.getZoomableController()
            r1 = r0
            com.avito.android.photo_gallery.zoom.AbstractAnimatedZoomableController r1 = (com.avito.android.photo_gallery.zoom.AbstractAnimatedZoomableController) r1
            android.graphics.PointF r4 = new android.graphics.PointF
            float r0 = r11.getX()
            float r2 = r11.getY()
            r4.<init>(r0, r2)
            android.graphics.PointF r3 = r1.mapViewToImage(r4)
            int r11 = r11.getActionMasked()
            r0 = 1
            if (r11 == 0) goto L_0x0095
            r9 = 0
            if (r11 == r0) goto L_0x005b
            r2 = 2
            if (r11 == r2) goto L_0x0029
            goto L_0x00a5
        L_0x0029:
            boolean r11 = r10.e
            if (r11 != 0) goto L_0x004a
            float r11 = r4.x
            android.graphics.PointF r2 = r10.b
            float r3 = r2.x
            float r11 = r11 - r3
            double r5 = (double) r11
            float r11 = r4.y
            float r2 = r2.y
            float r11 = r11 - r2
            double r2 = (double) r11
            double r2 = java.lang.Math.hypot(r5, r2)
            r5 = 4626322717216342016(0x4034000000000000, double:20.0)
            int r11 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r11 <= 0) goto L_0x0047
            r11 = 1
            goto L_0x0048
        L_0x0047:
            r11 = 0
        L_0x0048:
            if (r11 == 0) goto L_0x004b
        L_0x004a:
            r9 = 1
        L_0x004b:
            r10.e = r9
            if (r9 == 0) goto L_0x00a5
            float r11 = r10.a(r4)
            android.graphics.PointF r2 = r10.c
            android.graphics.PointF r3 = r10.b
            r1.zoomToPoint(r11, r2, r3)
            goto L_0x00a5
        L_0x005b:
            boolean r11 = r10.e
            if (r11 == 0) goto L_0x006b
            float r11 = r10.a(r4)
            android.graphics.PointF r2 = r10.c
            android.graphics.PointF r3 = r10.b
            r1.zoomToPoint(r11, r2, r3)
            goto L_0x0092
        L_0x006b:
            float r2 = r1.getMaxScaleFactor()
            float r11 = r1.getMinScaleFactor()
            float r5 = r1.getScaleFactor()
            float r6 = r2 + r11
            r7 = 1073741824(0x40000000, float:2.0)
            float r6 = r6 / r7
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0089
            r5 = 11
            r6 = 300(0x12c, double:1.48E-321)
            r8 = 0
            r1.zoomToPoint(r2, r3, r4, r5, r6, r8)
            goto L_0x0092
        L_0x0089:
            r5 = 11
            r6 = 300(0x12c, double:1.48E-321)
            r8 = 0
            r2 = r11
            r1.zoomToPoint(r2, r3, r4, r5, r6, r8)
        L_0x0092:
            r10.e = r9
            goto L_0x00a5
        L_0x0095:
            android.graphics.PointF r11 = r10.b
            r11.set(r4)
            android.graphics.PointF r11 = r10.c
            r11.set(r3)
            float r11 = r1.getScaleFactor()
            r10.d = r11
        L_0x00a5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.photo_gallery.zoom.DoubleTapGestureListener.onDoubleTapEvent(android.view.MotionEvent):boolean");
    }
}
