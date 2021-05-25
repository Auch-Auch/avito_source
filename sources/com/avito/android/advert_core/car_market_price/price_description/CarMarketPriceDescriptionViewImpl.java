package com.avito.android.advert_core.car_market_price.price_description;

import a2.a.a.g.d.a.a;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.advert_core.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0013\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0016R\u001e\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\n \u001e*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010)\u001a\n \u001e*\u0004\u0018\u00010&0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010-\u001a\n \u001e*\u0004\u0018\u00010*0*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u00101\u001a\n \u001e*\u0004\u0018\u00010.0.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010$R\u001e\u00105\u001a\n \u001e*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010$R\u001e\u0010\u0004\u001a\n \u001e*\u0004\u0018\u00010&0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010(R\u001e\u00108\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010 ¨\u0006="}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionViewImpl;", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "buttonText", "", "isActivated", "Lkotlin/Function0;", "clickListener", "setLeftFeatureButtonParams", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "setRightFeatureButtonParams", "", "stubIconId", "stubText", "setStubParams", "(Ljava/lang/Integer;Ljava/lang/String;)V", "showStub", "()V", "", "features", "setFeatures", "(Ljava/util/List;)V", "showFeatures", "onUnbind", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", VKApiConst.VERSION, "Landroid/view/ViewGroup;", "featuresContainer", "Lcom/avito/android/lib/design/button/Button;", "t", "Lcom/avito/android/lib/design/button/Button;", "leftButton", "Landroid/widget/TextView;", "y", "Landroid/widget/TextView;", "stubMessage", "Landroid/widget/ImageView;", "x", "Landroid/widget/ImageView;", "stubIcon", "Landroid/content/Context;", "z", "Landroid/content/Context;", "context", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "lastSelectedButton", "u", "rightButton", "s", "w", "stubContainer", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CarMarketPriceDescriptionViewImpl extends BaseViewHolder implements CarMarketPriceDescriptionView {
    public Button A;
    public final TextView s;
    public final Button t;
    public final Button u;
    public final ViewGroup v;
    public final ViewGroup w;
    public final ImageView x;
    public final TextView y;
    public final Context z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarMarketPriceDescriptionViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (Button) view.findViewById(R.id.left_feature_button);
        this.u = (Button) view.findViewById(R.id.right_feature_button);
        this.v = (ViewGroup) view.findViewById(R.id.features_container);
        this.w = (ViewGroup) view.findViewById(R.id.stub_container);
        this.x = (ImageView) view.findViewById(R.id.stub_icon);
        this.y = (TextView) view.findViewById(R.id.stub_message);
        this.z = view.getContext();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.A = null;
        this.v.removeAllViews();
    }

    @Override // com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionView
    public void setFeatures(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "features");
        this.v.removeAllViews();
        LayoutInflater from = LayoutInflater.from(this.z);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            View inflate = from.inflate(R.layout.car_market_price_feature, this.v, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            textView.setText(it.next());
            this.v.addView(textView);
        }
    }

    @Override // com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionView
    public void setLeftFeatureButtonParams(@NotNull String str, boolean z2, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "buttonText");
        Button button = this.t;
        Intrinsics.checkNotNullExpressionValue(button, "leftButton");
        button.setText(str);
        button.setOnClickListener(new a(this, button, function0));
        button.setActivated(z2);
        if (z2) {
            this.A = button;
        }
    }

    @Override // com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionView
    public void setRightFeatureButtonParams(@NotNull String str, boolean z2, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "buttonText");
        Button button = this.u;
        Intrinsics.checkNotNullExpressionValue(button, "rightButton");
        button.setText(str);
        button.setOnClickListener(new a(this, button, function0));
        button.setActivated(z2);
        if (z2) {
            this.A = button;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if ((r5.length() > 0) != false) goto L_0x0032;
     */
    @Override // com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStubParams(@org.jetbrains.annotations.Nullable java.lang.Integer r4, @org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x000b
            android.widget.ImageView r0 = r3.x
            int r1 = r4.intValue()
            r0.setImageResource(r1)
        L_0x000b:
            android.widget.ImageView r0 = r3.x
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L_0x0013
            r4 = 1
            goto L_0x0014
        L_0x0013:
            r4 = 0
        L_0x0014:
            com.avito.android.util.Views.setVisible(r0, r4)
            android.widget.TextView r4 = r3.y
            java.lang.String r0 = "stubMessage"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r4.setText(r5)
            android.widget.TextView r4 = r3.y
            if (r5 == 0) goto L_0x0031
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            if (r5 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            com.avito.android.util.Views.setVisible(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionViewImpl.setStubParams(java.lang.Integer, java.lang.String):void");
    }

    @Override // com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "this.title");
        textView.setText(str);
    }

    @Override // com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionView
    public void showFeatures() {
        Views.setVisible(this.w, false);
        Views.setVisible(this.v, true);
    }

    @Override // com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionView
    public void showStub() {
        Views.setVisible(this.v, false);
        Views.setVisible(this.w, true);
    }
}
