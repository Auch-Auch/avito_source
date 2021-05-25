package com.avito.android.payment.wallet.history.details.item;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.payment.R;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Images;
import com.avito.android.util.ViewTreeObservers;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u000f\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010 \u001a\n \u0019*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u001e\u0010$\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001bR\u001e\u0010&\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001bR\u001e\u0010(\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001bR\u001e\u0010,\u001a\n \u0019*\u0004\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010.\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001b¨\u00064"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/item/AdvertItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/payment/wallet/history/details/item/AdvertItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "amount", "setAmount", "description", "setDescription", "Lcom/avito/android/remote/model/Image;", "image", "setImageUrl", "(Lcom/avito/android/remote/model/Image;)V", "servicesKey", "setServicesKey", "", VKApiConst.SERVICES, "setServices", "(Ljava/util/List;)V", "measureTitleWidth", "()V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "w", "Landroid/widget/TextView;", "advertAmountTextView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "advertImageView", VKApiConst.VERSION, "advertTitleTextView", "x", "advertDotTextView", "z", "advertServices", "y", "advertServicesTitle", "Landroid/widget/LinearLayout;", "t", "Landroid/widget/LinearLayout;", "advertTitleAndPriceContainer", "u", "advertDescriptionTextView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Companion", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemViewHolder extends BaseViewHolder implements AdvertItemView {
    public static final int A = R.layout.payment_history_details_advert_item;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final SimpleDraweeView s;
    public final LinearLayout t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/item/AdvertItemViewHolder$Companion;", "", "", "LAYOUT_ID", "I", "getLAYOUT_ID", "()I", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final int getLAYOUT_ID() {
            return AdvertItemViewHolder.A;
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (SimpleDraweeView) view.findViewById(R.id.advert_image_view);
        this.t = (LinearLayout) view.findViewById(R.id.advert_title_and_price_container);
        this.u = (TextView) view.findViewById(R.id.advert_id_text_view);
        this.v = (TextView) view.findViewById(R.id.advert_title_text_view);
        this.w = (TextView) view.findViewById(R.id.advert_amount_text_view);
        this.x = (TextView) view.findViewById(R.id.advert_dot_text_view);
        this.y = (TextView) view.findViewById(R.id.advert_services_title_view);
        this.z = (TextView) view.findViewById(R.id.advert_services_text_view);
    }

    @Override // com.avito.android.payment.wallet.history.details.item.AdvertItemView
    public void measureTitleWidth() {
        AdvertItemViewHolder$measureTitleWidth$onGlobalLayoutListener$1 advertItemViewHolder$measureTitleWidth$onGlobalLayoutListener$1 = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.avito.android.payment.wallet.history.details.item.AdvertItemViewHolder$measureTitleWidth$onGlobalLayoutListener$1
            public final /* synthetic */ AdvertItemViewHolder a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LinearLayout linearLayout = this.a.t;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "advertTitleAndPriceContainer");
                ViewTreeObserver viewTreeObserver = linearLayout.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "advertTitleAndPriceContainer.viewTreeObserver");
                ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver, this);
                this.a.x.measure(0, 0);
                this.a.w.measure(0, 0);
                this.a.v.measure(0, 0);
                LinearLayout linearLayout2 = this.a.t;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "advertTitleAndPriceContainer");
                int measuredWidth = linearLayout2.getMeasuredWidth();
                TextView textView = this.a.w;
                Intrinsics.checkNotNullExpressionValue(textView, "advertAmountTextView");
                int measuredWidth2 = textView.getMeasuredWidth();
                TextView textView2 = this.a.x;
                Intrinsics.checkNotNullExpressionValue(textView2, "advertDotTextView");
                int measuredWidth3 = textView2.getMeasuredWidth();
                TextView textView3 = this.a.v;
                Intrinsics.checkNotNullExpressionValue(textView3, "advertTitleTextView");
                if (textView3.getMeasuredWidth() + measuredWidth3 + measuredWidth2 > measuredWidth) {
                    TextView textView4 = this.a.v;
                    Intrinsics.checkNotNullExpressionValue(textView4, "advertTitleTextView");
                    textView4.setMaxWidth((measuredWidth - measuredWidth2) - measuredWidth3);
                }
            }
        };
        LinearLayout linearLayout = this.t;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "advertTitleAndPriceContainer");
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(advertItemViewHolder$measureTitleWidth$onGlobalLayoutListener$1);
    }

    @Override // com.avito.android.payment.wallet.history.details.item.AdvertItemView
    public void setAmount(@Nullable String str) {
        TextView textView = this.w;
        Intrinsics.checkNotNullExpressionValue(textView, "advertAmountTextView");
        textView.setText(str);
        if (str == null) {
            Views.hide(this.x);
        } else {
            Views.show(this.x);
        }
    }

    @Override // com.avito.android.payment.wallet.history.details.item.AdvertItemView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        TextView textView = this.u;
        Intrinsics.checkNotNullExpressionValue(textView, "advertDescriptionTextView");
        textView.setText(str);
    }

    @Override // com.avito.android.payment.wallet.history.details.item.AdvertItemView
    public void setImageUrl(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        SimpleDraweeView simpleDraweeView = this.s;
        Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "advertImageView");
        this.s.setImageURI(Images.fit$default(image, simpleDraweeView, 0.0f, 0.0f, 2, 6, null).width(), (Object) null);
    }

    @Override // com.avito.android.payment.wallet.history.details.item.AdvertItemView
    public void setServices(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, VKApiConst.SERVICES);
        TextView textView = this.z;
        Intrinsics.checkNotNullExpressionValue(textView, "advertServices");
        textView.setText(CollectionsKt___CollectionsKt.joinToString$default(list, ", \n", null, null, 0, null, null, 62, null));
    }

    @Override // com.avito.android.payment.wallet.history.details.item.AdvertItemView
    public void setServicesKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "servicesKey");
        TextView textView = this.y;
        Intrinsics.checkNotNullExpressionValue(textView, "advertServicesTitle");
        textView.setText(str);
    }

    @Override // com.avito.android.payment.wallet.history.details.item.AdvertItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.v;
        Intrinsics.checkNotNullExpressionValue(textView, "advertTitleTextView");
        textView.setText(str);
    }
}
