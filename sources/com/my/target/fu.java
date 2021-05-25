package com.my.target;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.badge.BadgeDrawable;
public class fu extends FrameLayout {
    public final int a;
    @NonNull
    public final BitmapDrawable b;
    public final int c;
    public final int d;
    public final int e;
    @NonNull
    public final Rect f = new Rect();
    @NonNull
    public final Rect g = new Rect();
    @NonNull
    public final Rect h = new Rect();
    @NonNull
    public final Rect i = new Rect();
    @Nullable
    public a j;
    public boolean k;
    public boolean l;
    public int m = BadgeDrawable.TOP_END;

    public interface a {
        void onClose();
    }

    public fu(@NonNull Context context) {
        super(context);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(fh.z(io.af(context).L(30)));
        this.b = bitmapDrawable;
        bitmapDrawable.setState(FrameLayout.EMPTY_STATE_SET);
        bitmapDrawable.setCallback(this);
        this.a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.c = io.c(50, context);
        this.d = io.c(30, context);
        this.e = io.c(8, context);
        setWillNotDraw(false);
    }

    public void a(int i2, Rect rect, Rect rect2) {
        int i3 = this.d;
        Gravity.apply(i2, i3, i3, rect, rect2);
    }

    @VisibleForTesting
    public boolean b(int i2, int i3, int i4) {
        Rect rect = this.g;
        return i2 >= rect.left - i4 && i3 >= rect.top - i4 && i2 < rect.right + i4 && i3 < rect.bottom + i4;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.k) {
            this.k = false;
            this.f.set(0, 0, getWidth(), getHeight());
            int i2 = this.c;
            Gravity.apply(this.m, i2, i2, this.f, this.g);
            this.i.set(this.g);
            Rect rect = this.i;
            int i3 = this.e;
            rect.inset(i3, i3);
            int i4 = this.d;
            Gravity.apply(this.m, i4, i4, this.i, this.h);
            this.b.setBounds(this.h);
        }
        if (this.b.isVisible()) {
            this.b.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return b((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.k = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r5 != 3) goto L_0x003c;
     */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            float r0 = r5.getX()
            int r0 = (int) r0
            float r1 = r5.getY()
            int r1 = (int) r1
            android.graphics.drawable.BitmapDrawable r2 = r4.b
            boolean r2 = r2.isVisible()
            r3 = 0
            if (r2 == 0) goto L_0x003d
            int r2 = r4.a
            boolean r0 = r4.b(r0, r1, r2)
            if (r0 == 0) goto L_0x003d
            int r5 = r5.getAction()
            r0 = 1
            if (r5 == 0) goto L_0x003a
            if (r5 == r0) goto L_0x002b
            r1 = 3
            if (r5 == r1) goto L_0x0028
            goto L_0x003c
        L_0x0028:
            r4.l = r3
            goto L_0x003c
        L_0x002b:
            boolean r5 = r4.l
            if (r5 == 0) goto L_0x003c
            r4.playSoundEffect(r3)
            com.my.target.fu$a r5 = r4.j
            if (r5 == 0) goto L_0x0028
            r5.onClose()
            goto L_0x0028
        L_0x003a:
            r4.l = r0
        L_0x003c:
            return r0
        L_0x003d:
            super.onTouchEvent(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.fu.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @VisibleForTesting
    public void setCloseBounds(@NonNull Rect rect) {
        this.g.set(rect);
    }

    public void setCloseGravity(int i2) {
        this.m = i2;
    }

    public void setCloseVisible(boolean z) {
        io.b(this, z ? "close_button" : "closeable_layout");
        if (this.b.setVisible(z, false)) {
            invalidate(this.g);
        }
    }

    public void setOnCloseListener(@Nullable a aVar) {
        this.j = aVar;
    }
}
