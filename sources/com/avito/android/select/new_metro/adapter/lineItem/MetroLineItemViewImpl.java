package com.avito.android.select.new_metro.adapter.lineItem;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.select.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001d\u001a\n \u0016*\u0004\u0018\u00010\u001a0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010!\u001a\n \u0016*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010#\u001a\n \u0016*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemView;", "", "name", "", "setName", "(Ljava/lang/String;)V", "", "color", "setLineColor", "(I)V", "", PanelStateKt.PANEL_EXPANDED, "withAnimation", "setIsExpanded", "(ZZ)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", VKApiConst.VERSION, "Landroid/widget/RelativeLayout;", "container", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "lineNameTv", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "lineColorImageView", "u", "lineExpandedIv", "Landroid/animation/ValueAnimator;", "w", "Landroid/animation/ValueAnimator;", "rotationAnimator", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public class MetroLineItemViewImpl extends BaseViewHolder implements MetroLineItemView {
    public final TextView s;
    public final ImageView t;
    public final ImageView u;
    public final RelativeLayout v;
    public ValueAnimator w;

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
    public MetroLineItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.metro_line_item_name_tv);
        this.t = (ImageView) view.findViewById(R.id.metro_line_item_color_iv);
        this.u = (ImageView) view.findViewById(R.id.metro_line_item_chevron_iv);
        this.v = (RelativeLayout) view.findViewById(R.id.metro_line_item_root);
    }

    @Override // com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v.setOnClickListener(new a(function0));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0023: APUT  (r6v3 float[]), (1 ??[boolean, int, float, short, byte, char]), (r0v4 float) */
    @Override // com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemView
    public void setIsExpanded(boolean z, boolean z2) {
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f = 0.0f;
        if (z2) {
            float[] fArr = new float[2];
            ImageView imageView = this.u;
            Intrinsics.checkNotNullExpressionValue(imageView, "lineExpandedIv");
            fArr[0] = imageView.getRotation();
            if (!z) {
                f = -90.0f;
            }
            fArr[1] = f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
            ofFloat.setDuration(150L);
            ofFloat.addUpdateListener(new a2.a.a.m2.m.a.a.a(this));
            this.w = ofFloat;
            ofFloat.start();
            return;
        }
        ImageView imageView2 = this.u;
        Intrinsics.checkNotNullExpressionValue(imageView2, "lineExpandedIv");
        if (!z) {
            f = -90.0f;
        }
        imageView2.setRotation(f);
    }

    @Override // com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemView
    public void setLineColor(int i) {
        this.t.setColorFilter(i);
    }

    @Override // com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemView
    public void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "lineNameTv");
        textView.setText(str);
    }
}
