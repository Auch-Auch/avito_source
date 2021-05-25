package com.avito.android.orders.feature.list.adapter.order;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.image_loader.ImageRequestListener;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.orders.R;
import com.avito.android.orders.feature.list.adapter.order.OrderItemView;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.orders.model.OrderStatus;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.android.util.color.ColorFormatter;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010N\u001a\u00020K\u0012\u0006\u0010F\u001a\u00020C¢\u0006\u0004\bO\u0010PJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u001f\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J'\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b&\u0010'J\u001d\u0010)\u001a\u00020\u0005*\u00020(2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010,R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010,R\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001e\u0010<\u001a\n 9*\u0004\u0018\u000108088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010,R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u00100R\u0016\u0010J\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u00100R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006Q"}, d2 = {"Lcom/avito/android/orders/feature/list/adapter/order/OrderItemViewImpl;", "Lcom/avito/android/orders/feature/list/adapter/order/OrderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", Sort.DATE, "setDate", "price", "setPrice", "Lcom/avito/android/remote/orders/model/OrderStatus;", "status", "setStatus", "(Lcom/avito/android/remote/orders/model/OrderStatus;)V", "", "items", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPictureOne", "(Lcom/avito/android/image_loader/Picture;)V", "setPictureTwo", "setPictureThree", "Lcom/avito/android/orders/feature/list/adapter/order/OrderItemView$ItemsConstraint;", "constraint", "", "margin", "setItemsConstraint", "(Lcom/avito/android/orders/feature/list/adapter/order/OrderItemView$ItemsConstraint;I)V", "endID", "endSide", "t", "(III)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "u", "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/avito/android/image_loader/Picture;)V", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "dateView", "titleView", "y", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageOne", VKApiConst.VERSION, "priceView", "Landroid/widget/LinearLayout;", "x", "Landroid/widget/LinearLayout;", "itemsView", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "B", "Landroid/view/LayoutInflater;", "inflater", "Landroidx/constraintlayout/widget/ConstraintLayout;", "s", "Landroidx/constraintlayout/widget/ConstraintLayout;", "parentView", "w", "statusView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "D", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "z", "imageTwo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "imageThree", "Landroid/view/View;", "C", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrderItemViewImpl extends BaseViewHolder implements OrderItemView {
    public final SimpleDraweeView A;
    public final LayoutInflater B;
    public final View C;
    public final AttributedTextFormatter D;
    public final ConstraintLayout s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final LinearLayout x;
    public final SimpleDraweeView y;
    public final SimpleDraweeView z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            OrderItemView.ItemsConstraint.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.C = view;
        this.D = attributedTextFormatter;
        Objects.requireNonNull(view, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        this.s = (ConstraintLayout) view;
        View findViewById = view.findViewById(R.id.order_item_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.order_item_date);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.order_item_price);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.order_item_status);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.order_item_ll_items);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.x = (LinearLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.order_item_image_one);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.y = (SimpleDraweeView) findViewById6;
        View findViewById7 = view.findViewById(R.id.order_item_image_two);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.z = (SimpleDraweeView) findViewById7;
        View findViewById8 = view.findViewById(R.id.order_item_image_three);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.A = (SimpleDraweeView) findViewById8;
        this.B = LayoutInflater.from(view.getContext());
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        OrderItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.C.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setDate(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, Sort.DATE);
        TextViewsKt.bindAttributedText(this.u, attributedText, this.D);
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setItems(@NotNull List<AttributedText> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.x.removeAllViews();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            View inflate = this.B.inflate(R.layout.order_list_item_text_view, (ViewGroup) null);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            TextViewsKt.bindAttributedText(textView, it.next(), this.D);
            this.x.addView(textView);
        }
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setItemsConstraint(@NotNull OrderItemView.ItemsConstraint itemsConstraint, int i) {
        Intrinsics.checkNotNullParameter(itemsConstraint, "constraint");
        int ordinal = itemsConstraint.ordinal();
        if (ordinal == 0) {
            t(0, 7, i);
        } else if (ordinal == 1) {
            t(R.id.order_item_image_one, 6, i);
        } else if (ordinal == 2) {
            t(R.id.order_item_image_two, 6, i);
        } else if (ordinal == 3) {
            t(R.id.order_item_image_three, 6, i);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setPictureOne(@Nullable Picture picture) {
        u(this.y, picture);
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setPictureThree(@Nullable Picture picture) {
        u(this.A, picture);
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setPictureTwo(@Nullable Picture picture) {
        u(this.z, picture);
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setPrice(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "price");
        TextViewsKt.bindAttributedText(this.v, attributedText, this.D);
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setStatus(@NotNull OrderStatus orderStatus) {
        Intrinsics.checkNotNullParameter(orderStatus, "status");
        ShapeAppearanceModel build = new ShapeAppearanceModel().toBuilder().setAllCorners(0, (float) ViewSizeKt.getDp(3)).build();
        Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel()\n …t())\n            .build()");
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
        ColorFormatter colorFormatter = ColorFormatter.INSTANCE;
        materialShapeDrawable.setTint(colorFormatter.formatColor(this.C.getContext(), orderStatus.getBackgroundColor()));
        materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        ViewCompat.setBackground(this.w, materialShapeDrawable);
        this.w.setTextColor(colorFormatter.formatColor(this.C.getContext(), orderStatus.getTextColor()));
        TextViews.bindText$default(this.w, orderStatus.getText(), false, 2, null);
    }

    @Override // com.avito.android.orders.feature.list.adapter.order.OrderItemView
    public void setTitle(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        TextViewsKt.bindAttributedText(this.t, attributedText, this.D);
    }

    public final void t(int i, int i2, int i3) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.s);
        constraintSet.connect(R.id.order_item_ll_items, 7, i, i2, ViewSizeKt.getDp(i3));
        constraintSet.applyTo(this.s);
    }

    public final void u(SimpleDraweeView simpleDraweeView, Picture picture) {
        if (picture == null) {
            simpleDraweeView.setVisibility(8);
            return;
        }
        simpleDraweeView.setVisibility(0);
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy();
        Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchy, "hierarchy");
        RoundingParams roundingParams = genericDraweeHierarchy.getRoundingParams();
        if (roundingParams != null) {
            roundingParams.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
        }
        SimpleDraweeViewsKt.loadPicture(simpleDraweeView, picture, new ImageRequestListener(simpleDraweeView) { // from class: com.avito.android.orders.feature.list.adapter.order.OrderItemViewImpl$loadItemPicture$1
            public final /* synthetic */ SimpleDraweeView a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.image_loader.ImageRequestListener
            public void onFailed() {
            }

            @Override // com.avito.android.image_loader.ImageRequestListener
            public void onLoaded(int i, int i2) {
                Drawable drawable;
                GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) this.a.getHierarchy();
                Context context = this.a.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (DarkThemeManagerKt.isDarkTheme(context)) {
                    drawable = null;
                } else {
                    drawable = Views.getDrawable(this.a, R.color.overlay_color);
                }
                genericDraweeHierarchy2.setOverlayImage(drawable);
            }

            @Override // com.avito.android.image_loader.ImageRequestListener
            public void onStarted() {
            }
        });
    }
}
