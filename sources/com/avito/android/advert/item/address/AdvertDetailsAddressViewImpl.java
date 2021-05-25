package com.avito.android.advert.item.address;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.avito.android.advert.item.address.AdvertDetailsAddressView;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.analytics.address.GeoFromBlock;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001a¢\u0006\u0004\b \u0010!JA\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c¨\u0006\""}, d2 = {"Lcom/avito/android/advert/item/address/AdvertDetailsAddressViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressView;", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "advertTitle", "", "hasReducedPadding", "showArrow", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showAddress", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;ZZLcom/avito/android/advert/item/address/AdvertDetailsAddressView$Listener;)V", "", "u", "Lkotlin/Lazy;", "getPaddingTopNormal", "()I", "paddingTopNormal", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "addressText", "Landroid/view/View;", "s", "Landroid/view/View;", "addressContainer", VKApiConst.VERSION, "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAddressViewImpl extends BaseViewHolder implements AdvertDetailsAddressView {
    public View s;
    public TextView t;
    public final Lazy u = t6.c.lazy(new a(this));
    public final View v;

    public static final class a extends Lambda implements Function0<Integer> {
        public final /* synthetic */ AdvertDetailsAddressViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsAddressViewImpl advertDetailsAddressViewImpl) {
            super(0);
            this.a = advertDetailsAddressViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            return Integer.valueOf(this.a.v.getResources().getDimensionPixelSize(R.dimen.advert_details_address_padding_top));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsAddressView.Listener a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Coordinates c;
        public final /* synthetic */ String d;

        public b(AdvertDetailsAddressView.Listener listener, String str, Coordinates coordinates, String str2) {
            this.a = listener;
            this.b = str;
            this.c = coordinates;
            this.d = str2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onAddressClick(this.b, this.c, this.d, GeoFromBlock.ADDRESS);
        }
    }

    public static final class c implements View.OnLongClickListener {
        public final /* synthetic */ AdvertDetailsAddressView.Listener a;
        public final /* synthetic */ String b;

        public c(AdvertDetailsAddressView.Listener listener, String str) {
            this.a = listener;
            this.b = str;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            this.a.onAddressLongClick(this.b);
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsAddressViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        this.s = view.findViewById(com.avito.android.advert_details.R.id.address_container);
        this.t = (TextView) view.findViewById(com.avito.android.advert_details.R.id.advert_address);
        if (this.s == null) {
            View findViewById = view.findViewById(R.id.part_address_stub);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(advert…e_R.id.part_address_stub)");
            View inflate = ((ViewStub) findViewById).inflate();
            this.s = inflate.findViewById(R.id.address_container);
            this.t = (TextView) inflate.findViewById(R.id.advert_address);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v1, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.advert.item.address.AdvertDetailsAddressView
    public void showAddress(@NotNull String str, @Nullable Coordinates coordinates, @NotNull String str2, boolean z, boolean z2, @NotNull AdvertDetailsAddressView.Listener listener) {
        int i;
        Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(str2, "advertTitle");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (coordinates != null) {
            View view = this.s;
            if (view != null) {
                view.setOnClickListener(new b(listener, str, coordinates, str2));
            }
            TextView textView = this.t;
            if (textView != null) {
                if (z) {
                    i = 0;
                } else {
                    i = ((Number) this.u.getValue()).intValue();
                }
                Views.changePadding$default(textView, 0, i, 0, 0, 13, null);
            }
            View view2 = this.s;
            if (view2 != null) {
                view2.setOnLongClickListener(new c(listener, str));
            }
            TextView textView2 = this.t;
            if (textView2 != null) {
                if (z2) {
                    SpannableString spannableString = new SpannableString(a2.b.a.a.a.c3(str, " >"));
                    Drawable drawable = this.v.getContext().getDrawable(com.avito.android.advert_details.R.drawable.advert_details_address_arrow);
                    Intrinsics.checkNotNull(drawable);
                    Intrinsics.checkNotNullExpressionValue(drawable, "view.context.getDrawable…_details_address_arrow)!!");
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    spannableString.setSpan(new ImageSpan(drawable, 0), spannableString.length() - 1, spannableString.length(), 33);
                    str = spannableString;
                }
                textView2.setText(str);
            }
        }
    }
}
