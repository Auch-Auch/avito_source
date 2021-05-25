package com.avito.android.beduin.component.image;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.RemotePictureKt;
import com.avito.android.image_loader.SimpleImageRequestListener;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.color.ColorFormatter;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@BeduinApiTypeName(types = {"image"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0014\u001a\u00020\u0013*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/beduin/component/image/BeduinImageComponent;", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/component/image/BeduinImageModel;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/view/ViewGroup;", "parent", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "createView", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)Lcom/facebook/drawee/view/SimpleDraweeView;", "view", "Lcom/avito/android/beduin/core/ComponentsContext;", "ctx", "", "updateWithData", "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/avito/android/beduin/core/ComponentsContext;)V", "Lcom/avito/android/remote/model/UniversalColor;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/ColorDrawable;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/UniversalColor;Landroid/content/Context;)Landroid/graphics/drawable/ColorDrawable;", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "c", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "getActionHandler", "()Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "actionHandler", AuthSource.BOOKING_ORDER, "Lcom/avito/android/beduin/component/image/BeduinImageModel;", "getModel", "()Lcom/avito/android/beduin/component/image/BeduinImageModel;", "setModel", "(Lcom/avito/android/beduin/component/image/BeduinImageModel;)V", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "<init>", "(Lcom/avito/android/beduin/component/image/BeduinImageModel;Lcom/avito/android/beduin/core/action/BeduinActionHandler;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinImageComponent extends BeduinComponent<BeduinImageModel, SimpleDraweeView> {
    @NotNull
    public BeduinImageModel b;
    @NotNull
    public final BeduinActionHandler c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BeduinImageComponent a;

        public a(BeduinImageComponent beduinImageComponent, SimpleDraweeView simpleDraweeView) {
            this.a = beduinImageComponent;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.handleClick();
        }
    }

    public BeduinImageComponent(@NotNull BeduinImageModel beduinImageModel, @NotNull BeduinActionHandler beduinActionHandler) {
        Intrinsics.checkNotNullParameter(beduinImageModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Intrinsics.checkNotNullParameter(beduinActionHandler, "actionHandler");
        this.b = beduinImageModel;
        this.c = beduinActionHandler;
    }

    public final ColorDrawable a(UniversalColor universalColor, Context context) {
        return new ColorDrawable(ColorFormatter.INSTANCE.formatColor(context, universalColor));
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinActionHandler getActionHandler() {
        return this.c;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public SimpleDraweeView createView(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(viewGroup.getContext());
        simpleDraweeView.setId(View.generateViewId());
        layoutParams.width = ViewSizeKt.getDp(getModel().getSize().getWidth());
        layoutParams.height = ViewSizeKt.getDp(getModel().getSize().getHeight());
        Unit unit = Unit.INSTANCE;
        simpleDraweeView.setLayoutParams(layoutParams);
        return simpleDraweeView;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinImageModel getModel() {
        return this.b;
    }

    public void setModel(@NotNull BeduinImageModel beduinImageModel) {
        Intrinsics.checkNotNullParameter(beduinImageModel, "<set-?>");
        this.b = beduinImageModel;
    }

    public void updateWithData(@NotNull SimpleDraweeView simpleDraweeView, @NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "view");
        Intrinsics.checkNotNullParameter(componentsContext, "ctx");
        simpleDraweeView.setTag(getModel().getId());
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources());
        ImageRequest.Builder picture = SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).picture(RemotePictureKt.simplePictureOf$default(getModel().getImage(), true, 0.0f, 0.0f, 12, null));
        ImageStyle style = getModel().getStyle();
        if (style != null) {
            UniversalColor loadingColor = style.getLoadingColor();
            if (loadingColor != null) {
                Context context = simpleDraweeView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                picture.placeholder(a(loadingColor, context));
            }
            UniversalColor errorColor = style.getErrorColor();
            if (errorColor != null) {
                Context context2 = simpleDraweeView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                genericDraweeHierarchyBuilder.setFailureImage(a(errorColor, context2));
            }
            OverlayStyle overlay = style.getOverlay();
            if (overlay != null) {
                picture.listener(new SimpleImageRequestListener(overlay, simpleDraweeView, picture, genericDraweeHierarchyBuilder, this, simpleDraweeView) { // from class: com.avito.android.beduin.component.image.BeduinImageComponent$updateWithData$$inlined$with$lambda$1
                    public final /* synthetic */ OverlayStyle a;
                    public final /* synthetic */ SimpleDraweeView b;
                    public final /* synthetic */ BeduinImageComponent c;

                    {
                        this.a = r1;
                        this.b = r2;
                        this.c = r5;
                    }

                    @Override // com.avito.android.image_loader.SimpleImageRequestListener, com.avito.android.image_loader.ImageRequestListener
                    public void onLoaded(int i, int i2) {
                        BeduinImageComponent beduinImageComponent = this.c;
                        UniversalColor color = this.a.getColor();
                        Context context3 = this.b.getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "context");
                        ((GenericDraweeHierarchy) this.b.getHierarchy()).setOverlayImage(beduinImageComponent.a(color, context3));
                    }
                });
            }
            Integer cornerRadius = style.getCornerRadius();
            if (cornerRadius != null) {
                RoundingParams roundingMethod = RoundingParams.fromCornersRadius((float) ViewSizeKt.getDp(cornerRadius.intValue())).setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
                Intrinsics.checkNotNullExpressionValue(roundingMethod, "roundingParams");
                roundingMethod.setPadding(1.0f);
                genericDraweeHierarchyBuilder.setRoundingParams(roundingMethod);
            }
            BorderStyle border = style.getBorder();
            if (border != null) {
                if (genericDraweeHierarchyBuilder.getRoundingParams() == null) {
                    genericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
                }
                RoundingParams roundingParams = genericDraweeHierarchyBuilder.getRoundingParams();
                if (roundingParams != null) {
                    roundingParams.setPadding(1.0f);
                }
                RoundingParams roundingParams2 = genericDraweeHierarchyBuilder.getRoundingParams();
                if (roundingParams2 != null) {
                    roundingParams2.setBorder(ColorFormatter.INSTANCE.formatColor(simpleDraweeView.getContext(), border.getColor()), (float) border.getWidth());
                }
            }
        }
        simpleDraweeView.setHierarchy(genericDraweeHierarchyBuilder.build());
        picture.load();
        simpleDraweeView.setOnClickListener(new a(this, simpleDraweeView));
    }
}
