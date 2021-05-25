package com.avito.android.photo_gallery.zoom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.ScrollingView;
import com.avito.android.photo_gallery.zoom.ZoomableController;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import javax.annotation.Nullable;
public class ZoomableDraweeView extends SimpleDraweeView implements ScrollingView {
    public static final Class<?> t = ZoomableDraweeView.class;
    public final RectF i = new RectF();
    public final RectF j = new RectF();
    public DraweeController k;
    public ZoomableController l;
    public GestureDetector m;
    public ZoomListener n;
    public boolean o = true;
    public boolean p = false;
    public final ControllerListener q = new a();
    public final ZoomableController.Listener r = new b();
    public final GestureListenerWrapper s = new GestureListenerWrapper();

    public class a extends BaseControllerListener<Object> {
        public a() {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.t;
            FLog.v(zoomableDraweeView.getLogTag(), "onFinalImageSet: view %x", Integer.valueOf(zoomableDraweeView.hashCode()));
            if (!zoomableDraweeView.l.isEnabled()) {
                zoomableDraweeView.l.setEnabled(true);
                zoomableDraweeView.updateZoomableControllerBounds();
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onRelease(String str) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.t;
            FLog.v(zoomableDraweeView.getLogTag(), "onRelease: view %x", Integer.valueOf(zoomableDraweeView.hashCode()));
            zoomableDraweeView.l.setEnabled(false);
        }
    }

    public class b implements ZoomableController.Listener {
        public b() {
        }

        @Override // com.avito.android.photo_gallery.zoom.ZoomableController.Listener
        public void onTransformBegin(Matrix matrix) {
        }

        @Override // com.avito.android.photo_gallery.zoom.ZoomableController.Listener
        public void onTransformChanged(Matrix matrix) {
            ZoomableDraweeView.this.onTransformChanged(matrix);
        }

        @Override // com.avito.android.photo_gallery.zoom.ZoomableController.Listener
        public void onTransformEnd(Matrix matrix) {
            ZoomListener zoomListener = ZoomableDraweeView.this.n;
            if (zoomListener != null) {
                zoomListener.onEndTransformZoom();
            }
        }
    }

    public ZoomableDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
        d();
    }

    public boolean allowsTouchInterceptionWhileZoomed() {
        return this.o;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return this.l.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        return this.l.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return this.l.computeHorizontalScrollRange();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return this.l.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        return this.l.computeVerticalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        return this.l.computeVerticalScrollRange();
    }

    public ZoomableController createZoomableController() {
        return AnimatedZoomableController.newInstance();
    }

    public final void d() {
        ZoomableController createZoomableController = createZoomableController();
        this.l = createZoomableController;
        createZoomableController.setListener(this.r);
        this.m = new GestureDetector(getContext(), this.s);
    }

    public final void e(@Nullable DraweeController draweeController, @Nullable DraweeController draweeController2) {
        DraweeController controller = getController();
        if (controller instanceof AbstractDraweeController) {
            ((AbstractDraweeController) controller).removeControllerListener(this.q);
        }
        if (draweeController instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController).addControllerListener(this.q);
        }
        this.k = draweeController2;
        super.setController(draweeController);
    }

    public void getImageBounds(RectF rectF) {
        ((GenericDraweeHierarchy) getHierarchy()).getActualImageBounds(rectF);
    }

    public void getLimitBounds(RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    public Class<?> getLogTag() {
        return t;
    }

    public ZoomableController getZoomableController() {
        return this.l;
    }

    @Override // com.facebook.drawee.view.GenericDraweeView
    public void inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        GenericDraweeHierarchyBuilder actualImageScaleType = new GenericDraweeHierarchyBuilder(context.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchyInflater.updateBuilder(actualImageScaleType, context, attributeSet);
        setAspectRatio(actualImageScaleType.getDesiredAspectRatio());
        setHierarchy(actualImageScaleType.build());
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Object callerContext;
        int save = canvas.save();
        canvas.concat(this.l.getTransform());
        try {
            super.onDraw(canvas);
            canvas.restoreToCount(save);
        } catch (Exception e) {
            DraweeController controller = getController();
            if (controller == null || !(controller instanceof AbstractDraweeController) || (callerContext = ((AbstractDraweeController) controller).getCallerContext()) == null) {
                throw e;
            }
            throw new RuntimeException(String.format("Exception in onDraw, callerContext=%s", callerContext.toString()), e);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        FLog.v(getLogTag(), "onLayout: view %x", Integer.valueOf(hashCode()));
        super.onLayout(z, i2, i3, i4, i5);
        updateZoomableControllerBounds();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        FLog.v(getLogTag(), "onTouchEvent: %d, view %x, received", Integer.valueOf(actionMasked), Integer.valueOf(hashCode()));
        if (!this.p && this.m.onTouchEvent(motionEvent)) {
            FLog.v(getLogTag(), "onTouchEvent: %d, view %x, handled by tap gesture detector", Integer.valueOf(actionMasked), Integer.valueOf(hashCode()));
            return true;
        } else if (!this.p && this.l.onTouchEvent(motionEvent)) {
            FLog.v(getLogTag(), "onTouchEvent: %d, view %x, handled by zoomable controller", Integer.valueOf(actionMasked), Integer.valueOf(hashCode()));
            if (!this.o && !this.l.isIdentity()) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        } else if (super.onTouchEvent(motionEvent)) {
            FLog.v(getLogTag(), "onTouchEvent: %d, view %x, handled by the super", Integer.valueOf(actionMasked), Integer.valueOf(hashCode()));
            return true;
        } else {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            this.m.onTouchEvent(obtain);
            this.l.onTouchEvent(obtain);
            obtain.recycle();
            return false;
        }
    }

    public void onTransformChanged(Matrix matrix) {
        FLog.v(getLogTag(), "onTransformChanged: view %x, transform: %s", Integer.valueOf(hashCode()), matrix);
        if (this.k != null && this.l.getScaleFactor() > 1.1f) {
            e(this.k, null);
        }
        invalidate();
    }

    public void setAllowTouchInterceptionWhileZoomed(boolean z) {
        this.o = z;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(@Nullable DraweeController draweeController) {
        setControllers(draweeController, null);
    }

    public void setControllers(@Nullable DraweeController draweeController, @Nullable DraweeController draweeController2) {
        e(null, null);
        this.l.setEnabled(false);
        e(draweeController, draweeController2);
    }

    public void setIsDialtoneEnabled(boolean z) {
        this.p = z;
    }

    public void setIsLongpressEnabled(boolean z) {
        this.m.setIsLongpressEnabled(z);
    }

    public void setTapListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.s.setListener(simpleOnGestureListener);
    }

    public void setZoomListener(ZoomListener zoomListener) {
        this.n = zoomListener;
    }

    public void setZoomableController(ZoomableController zoomableController) {
        Preconditions.checkNotNull(zoomableController);
        this.l.setListener(null);
        this.l = zoomableController;
        zoomableController.setListener(this.r);
    }

    public void updateZoomableControllerBounds() {
        getImageBounds(this.i);
        getLimitBounds(this.j);
        this.l.setImageBounds(this.i);
        this.l.setViewBounds(this.j);
        FLog.v(getLogTag(), "updateZoomableControllerBounds: view %x, view bounds: %s, image bounds: %s", Integer.valueOf(hashCode()), this.j, this.i);
    }

    public ZoomableDraweeView(Context context) {
        super(context);
        inflateHierarchy(context, null);
        d();
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
        d();
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        inflateHierarchy(context, attributeSet);
        d();
    }
}
