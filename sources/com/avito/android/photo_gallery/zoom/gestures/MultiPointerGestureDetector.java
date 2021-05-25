package com.avito.android.photo_gallery.zoom.gestures;
public class MultiPointerGestureDetector {
    public boolean a;
    public int b;
    public int c;
    public final int[] d = new int[2];
    public final float[] e = new float[2];
    public final float[] f = new float[2];
    public final float[] g = new float[2];
    public final float[] h = new float[2];
    public Listener i = null;

    public interface Listener {
        void onGestureBegin(MultiPointerGestureDetector multiPointerGestureDetector);

        void onGestureEnd(MultiPointerGestureDetector multiPointerGestureDetector);

        void onGestureUpdate(MultiPointerGestureDetector multiPointerGestureDetector);
    }

    public MultiPointerGestureDetector() {
        reset();
    }

    public static MultiPointerGestureDetector newInstance() {
        return new MultiPointerGestureDetector();
    }

    public final void a() {
        if (!this.a) {
            Listener listener = this.i;
            if (listener != null) {
                listener.onGestureBegin(this);
            }
            this.a = true;
        }
    }

    public final void b() {
        if (this.a) {
            this.a = false;
            Listener listener = this.i;
            if (listener != null) {
                listener.onGestureEnd(this);
            }
        }
    }

    public float[] getCurrentX() {
        return this.g;
    }

    public float[] getCurrentY() {
        return this.h;
    }

    public int getNewPointerCount() {
        return this.c;
    }

    public int getPointerCount() {
        return this.b;
    }

    public float[] getStartX() {
        return this.e;
    }

    public float[] getStartY() {
        return this.f;
    }

    public boolean isGestureInProgress() {
        return this.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r0 != 6) goto L_0x00cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getActionMasked()
            r1 = 0
            r2 = 6
            r3 = 2
            r4 = -1
            r5 = 1
            if (r0 == 0) goto L_0x0060
            if (r0 == r5) goto L_0x0060
            if (r0 == r3) goto L_0x0023
            r6 = 3
            if (r0 == r6) goto L_0x0019
            r6 = 5
            if (r0 == r6) goto L_0x0060
            if (r0 == r2) goto L_0x0060
            goto L_0x00cd
        L_0x0019:
            r9.c = r1
            r9.b()
            r9.reset()
            goto L_0x00cd
        L_0x0023:
            if (r1 >= r3) goto L_0x0042
            int[] r0 = r9.d
            r0 = r0[r1]
            int r0 = r10.findPointerIndex(r0)
            if (r0 == r4) goto L_0x003f
            float[] r2 = r9.g
            float r6 = r10.getX(r0)
            r2[r1] = r6
            float[] r2 = r9.h
            float r0 = r10.getY(r0)
            r2[r1] = r0
        L_0x003f:
            int r1 = r1 + 1
            goto L_0x0023
        L_0x0042:
            boolean r10 = r9.a
            if (r10 != 0) goto L_0x0053
            int r10 = r9.b
            if (r10 <= 0) goto L_0x0053
            boolean r10 = r9.shouldStartGesture()
            if (r10 == 0) goto L_0x0053
            r9.a()
        L_0x0053:
            boolean r10 = r9.a
            if (r10 == 0) goto L_0x00cd
            com.avito.android.photo_gallery.zoom.gestures.MultiPointerGestureDetector$Listener r10 = r9.i
            if (r10 == 0) goto L_0x00cd
            r10.onGestureUpdate(r9)
            goto L_0x00cd
        L_0x0060:
            int r0 = r10.getPointerCount()
            int r6 = r10.getActionMasked()
            if (r6 == r5) goto L_0x006c
            if (r6 != r2) goto L_0x006e
        L_0x006c:
            int r0 = r0 + -1
        L_0x006e:
            r9.c = r0
            r9.b()
            r9.b = r1
        L_0x0075:
            if (r1 >= r3) goto L_0x00c0
            int r0 = r10.getPointerCount()
            int r6 = r10.getActionMasked()
            int r7 = r10.getActionIndex()
            if (r6 == r5) goto L_0x0087
            if (r6 != r2) goto L_0x008c
        L_0x0087:
            if (r1 < r7) goto L_0x008c
            int r6 = r1 + 1
            goto L_0x008d
        L_0x008c:
            r6 = r1
        L_0x008d:
            if (r6 >= r0) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            r6 = -1
        L_0x0091:
            if (r6 != r4) goto L_0x0098
            int[] r0 = r9.d
            r0[r1] = r4
            goto L_0x00bd
        L_0x0098:
            int[] r0 = r9.d
            int r7 = r10.getPointerId(r6)
            r0[r1] = r7
            float[] r0 = r9.g
            float[] r7 = r9.e
            float r8 = r10.getX(r6)
            r7[r1] = r8
            r0[r1] = r8
            float[] r0 = r9.h
            float[] r7 = r9.f
            float r6 = r10.getY(r6)
            r7[r1] = r6
            r0[r1] = r6
            int r0 = r9.b
            int r0 = r0 + r5
            r9.b = r0
        L_0x00bd:
            int r1 = r1 + 1
            goto L_0x0075
        L_0x00c0:
            int r10 = r9.b
            if (r10 <= 0) goto L_0x00cd
            boolean r10 = r9.shouldStartGesture()
            if (r10 == 0) goto L_0x00cd
            r9.a()
        L_0x00cd:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.photo_gallery.zoom.gestures.MultiPointerGestureDetector.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void reset() {
        this.a = false;
        this.b = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            this.d[i2] = -1;
        }
    }

    public void restartGesture() {
        if (this.a) {
            b();
            for (int i2 = 0; i2 < 2; i2++) {
                this.e[i2] = this.g[i2];
                this.f[i2] = this.h[i2];
            }
            a();
        }
    }

    public void setListener(Listener listener) {
        this.i = listener;
    }

    public boolean shouldStartGesture() {
        return true;
    }
}
