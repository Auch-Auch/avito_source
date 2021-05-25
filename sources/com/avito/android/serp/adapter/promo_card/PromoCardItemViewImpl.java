package com.avito.android.serp.adapter.promo_card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.serp.adapter.promo_card.PromoCardItemView;
import com.avito.android.serp_core.R;
import com.avito.android.util.color.ColorFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010-\u001a\u00020*\u0012\b\b\u0001\u00102\u001a\u00020\f\u0012\n\b\u0003\u0010<\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u00105\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u001b\u0010\u000e\u001a\u00020\u00052\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0019\u00102\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00105\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010\u001cR\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010<\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010\u001cR\u0016\u0010>\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010(¨\u0006A"}, d2 = {"Lcom/avito/android/serp/adapter/promo_card/PromoCardItemViewImpl;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "text", "setButtonText", "", "drawableId", "setImage", "(Ljava/lang/Integer;)V", "Lcom/avito/android/remote/model/UniversalColor;", "color", "pressedColor", "setBackgroundColor", "(Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "B", "Ljava/lang/Integer;", "getButtonId", "()Ljava/lang/Integer;", "buttonId", "Landroid/content/Context;", "t", "Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "u", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "subtitleView", "Landroid/view/View;", "x", "Landroid/view/View;", "root", "y", "I", "getTitleId", "()I", "titleId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getSubtitleId", "subtitleId", "Lcom/avito/android/lib/design/button/Button;", "w", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "z", "getImageId", "imageId", "s", "titleView", "<init>", "(Landroid/view/View;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class PromoCardItemViewImpl extends BaseViewHolder implements PromoCardItemView {
    @Nullable
    public final Integer A;
    @Nullable
    public final Integer B;
    public final TextView s;
    public final Context t;
    public final ImageView u;
    public final TextView v;
    public final Button w;
    public final View x;
    public final int y;
    @Nullable
    public final Integer z;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((Function0) this.b).invoke();
            } else if (i == 1) {
                ((Function0) this.b).invoke();
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoCardItemViewImpl(View view, int i, Integer num, Integer num2, Integer num3, int i2, j jVar) {
        this(view, i, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : num3);
    }

    @Nullable
    public final Integer getButtonId() {
        return this.B;
    }

    @Nullable
    public final Integer getImageId() {
        return this.z;
    }

    @Nullable
    public final Integer getSubtitleId() {
        return this.A;
    }

    public final int getTitleId() {
        return this.y;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PromoCardItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItemView
    public void setBackgroundColor(@NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        Intrinsics.checkNotNullParameter(universalColor2, "pressedColor");
        ColorFormatter colorFormatter = ColorFormatter.INSTANCE;
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842910}}, new int[]{colorFormatter.formatColor(this.t, universalColor2), colorFormatter.formatColor(this.t, universalColor)});
        View view = this.x;
        ShapeAppearanceModel build = ShapeAppearanceModel.builder().setAllCorners(0, this.x.getResources().getDimension(R.dimen.report_banner_corners)).build();
        Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel\n   …rs))\n            .build()");
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
        materialShapeDrawable.setFillColor(colorStateList);
        view.setBackground(materialShapeDrawable);
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItemView
    public void setButtonText(@Nullable String str) {
        Button button = this.w;
        if (button != null) {
            ButtonsKt.bindText$default(button, str, false, 2, null);
        }
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItemView
    public void setImage(@DrawableRes @Nullable Integer num) {
        if (num == null) {
            ImageView imageView = this.u;
            if (imageView != null) {
                imageView.setImageDrawable(null);
                return;
            }
            return;
        }
        ImageView imageView2 = this.u;
        if (imageView2 != null) {
            imageView2.setImageResource(num.intValue());
        }
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Button button = this.w;
        if (button != null) {
            button.setOnClickListener(new a(0, function0));
        } else {
            this.x.setOnClickListener(new a(1, function0));
        }
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItemView
    public void setSubtitle(@Nullable String str) {
        TextView textView = this.v;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoCardItemViewImpl(@NotNull View view, @IdRes int i, @IdRes @Nullable Integer num, @IdRes @Nullable Integer num2, @IdRes @Nullable Integer num3) {
        super(view);
        ImageView imageView;
        TextView textView;
        Intrinsics.checkNotNullParameter(view, "root");
        this.x = view;
        this.y = i;
        this.z = num;
        this.A = num2;
        this.B = num3;
        View findViewById = view.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        this.t = context;
        Button button = null;
        if (num != null) {
            View findViewById2 = view.findViewById(num.intValue());
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            imageView = (ImageView) findViewById2;
        } else {
            imageView = null;
        }
        this.u = imageView;
        if (num2 != null) {
            View findViewById3 = view.findViewById(num2.intValue());
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            textView = (TextView) findViewById3;
        } else {
            textView = null;
        }
        this.v = textView;
        if (num3 != null) {
            View findViewById4 = view.findViewById(num3.intValue());
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
            button = (Button) findViewById4;
        }
        this.w = button;
    }
}
