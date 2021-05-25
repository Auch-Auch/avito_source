package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.R;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
public class SimpleDraweeView extends GenericDraweeView {
    public static Supplier<? extends AbstractDraweeControllerBuilder> h;
    public AbstractDraweeControllerBuilder g;

    public SimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        c(context, null);
    }

    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> supplier) {
        h = supplier;
    }

    public static void shutDown() {
        h = null;
    }

    public final void c(Context context, @Nullable AttributeSet attributeSet) {
        int resourceId;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("SimpleDraweeView#init");
            }
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                Preconditions.checkNotNull(h, "SimpleDraweeView was not initialized!");
                this.g = (AbstractDraweeControllerBuilder) h.get();
            }
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleDraweeView);
                try {
                    int i = R.styleable.SimpleDraweeView_actualImageUri;
                    if (obtainStyledAttributes.hasValue(i)) {
                        setImageURI(Uri.parse(obtainStyledAttributes.getString(i)), (Object) null);
                    } else {
                        int i2 = R.styleable.SimpleDraweeView_actualImageResource;
                        if (obtainStyledAttributes.hasValue(i2) && (resourceId = obtainStyledAttributes.getResourceId(i2, -1)) != -1) {
                            if (isInEditMode()) {
                                setImageResource(resourceId);
                            } else {
                                setActualImageResource(resourceId);
                            }
                        }
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.g;
    }

    public void setActualImageResource(@DrawableRes int i) {
        setActualImageResource(i, null);
    }

    public void setImageRequest(ImageRequest imageRequest) {
        setController(this.g.setImageRequest(imageRequest).setOldController(getController()).build());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageURI(uri, (Object) null);
    }

    public void setActualImageResource(@DrawableRes int i, @Nullable Object obj) {
        setImageURI(UriUtil.getUriForResourceId(i), obj);
    }

    public void setImageURI(@Nullable String str) {
        setImageURI(str, (Object) null);
    }

    public SimpleDraweeView(Context context) {
        super(context);
        c(context, null);
    }

    public void setImageURI(Uri uri, @Nullable Object obj) {
        setController(this.g.setCallerContext(obj).setUri(uri).setOldController(getController()).build());
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
    }

    @TargetApi(21)
    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        c(context, attributeSet);
    }

    public void setImageURI(@Nullable String str, @Nullable Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }
}
