package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.AspectRatioMeasure;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
public class DraweeView<DH extends DraweeHierarchy> extends ImageView {
    public static boolean f = false;
    public final AspectRatioMeasure.Spec a = new AspectRatioMeasure.Spec();
    public float b = 0.0f;
    public DraweeHolder<DH> c;
    public boolean d = false;
    public boolean e = false;

    public DraweeView(Context context) {
        super(context);
        a(context);
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        f = z;
    }

    public final void a(Context context) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DraweeView#init");
            }
            if (!this.d) {
                boolean z = true;
                this.d = true;
                this.c = DraweeHolder.create(null, context);
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                    if (!f || context.getApplicationInfo().targetSdkVersion < 24) {
                        z = false;
                    }
                    this.e = z;
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } else if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public final void b() {
        Drawable drawable;
        if (this.e && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    public void doAttach() {
        this.c.onAttach();
    }

    public void doDetach() {
        this.c.onDetach();
    }

    public float getAspectRatio() {
        return this.b;
    }

    @Nullable
    public DraweeController getController() {
        return this.c.getController();
    }

    public DH getHierarchy() {
        return this.c.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.c.getTopLevelDrawable();
    }

    public boolean hasController() {
        return this.c.getController() != null;
    }

    public boolean hasHierarchy() {
        return this.c.hasHierarchy();
    }

    public void onAttach() {
        doAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
        onAttach();
    }

    public void onDetach() {
        doDetach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        AspectRatioMeasure.Spec spec = this.a;
        spec.width = i;
        spec.height = i2;
        AspectRatioMeasure.updateMeasureSpec(spec, this.b, getLayoutParams(), getPaddingRight() + getPaddingLeft(), getPaddingBottom() + getPaddingTop());
        AspectRatioMeasure.Spec spec2 = this.a;
        super.onMeasure(spec2.width, spec2.height);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        b();
        onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.c.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        b();
    }

    public void setAspectRatio(float f2) {
        if (f2 != this.b) {
            this.b = f2;
            requestLayout();
        }
    }

    public void setController(@Nullable DraweeController draweeController) {
        this.c.setController(draweeController);
        super.setImageDrawable(this.c.getTopLevelDrawable());
    }

    public void setHierarchy(DH dh) {
        this.c.setHierarchy(dh);
        super.setImageDrawable(this.c.getTopLevelDrawable());
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        a(getContext());
        this.c.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        a(getContext());
        this.c.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        a(getContext());
        this.c.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        a(getContext());
        this.c.setController(null);
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.e = z;
    }

    @Override // android.view.View, java.lang.Object
    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        DraweeHolder<DH> draweeHolder = this.c;
        return stringHelper.add("holder", draweeHolder != null ? draweeHolder.toString() : "<no holder set>").toString();
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }
}
