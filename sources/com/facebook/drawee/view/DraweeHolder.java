package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;
public class DraweeHolder<DH extends DraweeHierarchy> implements VisibilityCallback {
    public boolean a = false;
    public boolean b = false;
    public boolean c = true;
    public DH d;
    public DraweeController e = null;
    public final DraweeEventTracker f = DraweeEventTracker.newInstance();

    public DraweeHolder(@Nullable DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public static <DH extends DraweeHierarchy> DraweeHolder<DH> create(@Nullable DH dh, Context context) {
        DraweeHolder<DH> draweeHolder = new DraweeHolder<>(dh);
        draweeHolder.registerWithContext(context);
        return draweeHolder;
    }

    public final void a() {
        if (!this.a) {
            this.f.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
            this.a = true;
            DraweeController draweeController = this.e;
            if (draweeController != null && draweeController.getHierarchy() != null) {
                this.e.onAttach();
            }
        }
    }

    public final void b() {
        if (!this.b || !this.c) {
            c();
        } else {
            a();
        }
    }

    public final void c() {
        if (this.a) {
            this.f.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.a = false;
            if (isControllerValid()) {
                this.e.onDetach();
            }
        }
    }

    @Nullable
    public DraweeController getController() {
        return this.e;
    }

    public DraweeEventTracker getDraweeEventTracker() {
        return this.f;
    }

    public DH getHierarchy() {
        return (DH) ((DraweeHierarchy) Preconditions.checkNotNull(this.d));
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        DH dh = this.d;
        if (dh == null) {
            return null;
        }
        return dh.getTopLevelDrawable();
    }

    public boolean hasHierarchy() {
        return this.d != null;
    }

    public boolean isAttached() {
        return this.b;
    }

    public boolean isControllerValid() {
        DraweeController draweeController = this.e;
        return draweeController != null && draweeController.getHierarchy() == this.d;
    }

    public void onAttach() {
        this.f.recordEvent(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.b = true;
        b();
    }

    public void onDetach() {
        this.f.recordEvent(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.b = false;
        b();
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onDraw() {
        if (!this.a) {
            FLog.w(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.e)), toString());
            this.b = true;
            this.c = true;
            b();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isControllerValid()) {
            return false;
        }
        return this.e.onTouchEvent(motionEvent);
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onVisibilityChange(boolean z) {
        if (this.c != z) {
            this.f.recordEvent(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.c = z;
            b();
        }
    }

    public void registerWithContext(Context context) {
    }

    public void setController(@Nullable DraweeController draweeController) {
        boolean z = this.a;
        if (z) {
            c();
        }
        if (isControllerValid()) {
            this.f.recordEvent(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.e.setHierarchy(null);
        }
        this.e = draweeController;
        if (draweeController != null) {
            this.f.recordEvent(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.e.setHierarchy(this.d);
        } else {
            this.f.recordEvent(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            a();
        }
    }

    public void setHierarchy(DH dh) {
        this.f.recordEvent(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean isControllerValid = isControllerValid();
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) topLevelDrawable).setVisibilityCallback(null);
        }
        DH dh2 = (DH) ((DraweeHierarchy) Preconditions.checkNotNull(dh));
        this.d = dh2;
        Drawable topLevelDrawable2 = dh2.getTopLevelDrawable();
        onVisibilityChange(topLevelDrawable2 == null || topLevelDrawable2.isVisible());
        Drawable topLevelDrawable3 = getTopLevelDrawable();
        if (topLevelDrawable3 instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) topLevelDrawable3).setVisibilityCallback(this);
        }
        if (isControllerValid) {
            this.e.setHierarchy(dh);
        }
    }

    public String toString() {
        return Objects.toStringHelper(this).add("controllerAttached", this.a).add("holderAttached", this.b).add("drawableVisible", this.c).add("events", this.f.toString()).toString();
    }
}
