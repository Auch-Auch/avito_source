package com.avito.android.advert.item.safedeal.trust_factors;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsView;
import com.avito.android.advert_details.R;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SafeDeal;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.Logs;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b)\u0010*J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsView;", "Lcom/avito/android/remote/model/SafeDeal;", "safeDeal", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsView$Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showTrustFactors", "(Lcom/avito/android/remote/model/SafeDeal;Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsView$Router;)V", "Landroid/view/View;", "u", "Landroid/view/View;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "headerTitle", "Lcom/avito/android/util/text/AttributedTextFormatter;", "z", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "", "t", "I", "initialChildCount", "Landroid/widget/ImageView;", "w", "Landroid/widget/ImageView;", "headerTitleDropdown", "x", "headerInfoIcon", "Landroid/view/ViewGroup;", "y", "Landroid/view/ViewGroup;", "container", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "s", "Landroid/view/LayoutInflater;", "inflater", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealTrustFactorsViewImpl extends BaseViewHolder implements AdvertDetailsSafeDealTrustFactorsView {
    public final LayoutInflater s;
    public final int t;
    public final View u;
    public final TextView v;
    public final ImageView w;
    public final ImageView x;
    public final ViewGroup y;
    public final AttributedTextFormatter z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            SafeDeal.About.Icon.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            SafeDeal.About.Icon icon = SafeDeal.About.Icon.COURIER;
            iArr[1] = 1;
            SafeDeal.About.Icon icon2 = SafeDeal.About.Icon.DELIVERY;
            iArr[0] = 2;
            SafeDeal.About.Icon icon3 = SafeDeal.About.Icon.RETURN;
            iArr[2] = 3;
            SafeDeal.About.ListComponent.ListItem.Alignment.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            SafeDeal.About.ListComponent.ListItem.Alignment alignment = SafeDeal.About.ListComponent.ListItem.Alignment.LEFT;
            iArr2[0] = 1;
            SafeDeal.About.ListComponent.ListItem.Alignment alignment2 = SafeDeal.About.ListComponent.ListItem.Alignment.CENTER;
            iArr2[1] = 2;
            SafeDeal.About.ListComponent.ListItem.Alignment alignment3 = SafeDeal.About.ListComponent.ListItem.Alignment.RIGHT;
            iArr2[2] = 3;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;

        public a(int i, Object obj, Object obj2, Object obj3, Object obj4) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
            this.e = obj4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((AdvertDetailsSafeDealTrustFactorsView.Router) this.d).followTrustFactorsDeepLink((DeepLink) this.b, ((SafeDeal) this.e).getFormattedOrderTypes());
            } else if (i == 1) {
                ((AdvertDetailsSafeDealTrustFactorsView.Router) this.d).followTrustFactorsDeepLink((DeepLink) this.b, ((SafeDeal) this.e).getFormattedOrderTypes());
            } else if (i == 2) {
                ((AdvertDetailsSafeDealTrustFactorsView.Router) this.d).followTrustFactorsDeepLink((DeepLink) this.b, ((SafeDeal) this.e).getFormattedOrderTypes());
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsSafeDealTrustFactorsViewImpl(@NotNull ViewGroup viewGroup, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.y = viewGroup;
        this.z = attributedTextFormatter;
        this.s = LayoutInflater.from(viewGroup.getContext());
        this.t = viewGroup.getChildCount();
        View findViewById = viewGroup.findViewById(R.id.header);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.u = findViewById;
        View findViewById2 = findViewById.findViewById(R.id.header_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById2;
        View findViewById3 = findViewById.findViewById(R.id.header_dropdown_icon);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.w = (ImageView) findViewById3;
        View findViewById4 = findViewById.findViewById(R.id.header_info_icon);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.x = (ImageView) findViewById4;
    }

    @Override // com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsView
    public void showTrustFactors(@NotNull SafeDeal safeDeal, @NotNull AdvertDetailsSafeDealTrustFactorsView.Router router) {
        List<SafeDeal.About.ListComponent> listComponents;
        int ordinal;
        DeepLink deeplink;
        Intrinsics.checkNotNullParameter(safeDeal, "safeDeal");
        Intrinsics.checkNotNullParameter(router, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SafeDeal.About about = safeDeal.getAbout();
        if (about != null) {
            SafeDeal.About.Header header = about.getHeader();
            if (header != null) {
                TextView textView = this.v;
                AttributedTextFormatter attributedTextFormatter = this.z;
                Context context = this.y.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "container.context");
                textView.setText(attributedTextFormatter.format(context, header.getTitle()));
                SafeDeal.About.Header.Info info = header.getInfo();
                if (info == null || (deeplink = info.getDeeplink()) == null) {
                    Views.hide(this.x);
                } else {
                    this.x.setOnClickListener(new a(0, deeplink, this, router, safeDeal));
                }
                DeepLink titleDeeplink = header.getTitleDeeplink();
                if (titleDeeplink != null) {
                    this.v.setOnClickListener(new a(1, titleDeeplink, this, router, safeDeal));
                    this.w.setOnClickListener(new a(2, titleDeeplink, this, router, safeDeal));
                } else {
                    Views.hide(this.w);
                }
            } else {
                Views.hide(this.u);
            }
            if (this.y.getChildCount() == this.t && (listComponents = about.getListComponents()) != null) {
                int i = 0;
                for (T t2 : listComponents) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    T t3 = t2;
                    Integer num = null;
                    if (t3 instanceof SafeDeal.About.ListComponent.ListItem) {
                        ViewGroup viewGroup = this.y;
                        View inflate = this.s.inflate(R.layout.advert_details_safedeal_trust_factor, viewGroup, false);
                        Intrinsics.checkNotNullExpressionValue(inflate, "inflatedView");
                        Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                        if (i == 0 && this.u.getVisibility() == 8) {
                            Views.changeMargin$default(inflate, 0, 0, 0, 0, 13, null);
                        }
                        int i3 = R.id.trust_factor_icon;
                        T t4 = t3;
                        SafeDeal.About.ListComponent.ListItem.Alignment titleAlignment = t4.getTitleAlignment();
                        float f = 0.0f;
                        if (!(titleAlignment == null || (ordinal = titleAlignment.ordinal()) == 0)) {
                            if (ordinal == 1) {
                                f = 0.5f;
                            } else if (ordinal == 2) {
                                f = 1.0f;
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.clone(constraintLayout);
                        constraintSet.setHorizontalBias(i3, f);
                        constraintSet.applyTo(constraintLayout);
                        View findViewById = inflate.findViewById(i3);
                        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                        TextView textView2 = (TextView) findViewById;
                        View findViewById2 = inflate.findViewById(R.id.trust_factor_text);
                        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
                        TextView textView3 = (TextView) findViewById2;
                        SafeDeal.About.Icon icon = t4.getIcon();
                        if (icon != null) {
                            int ordinal2 = icon.ordinal();
                            if (ordinal2 == 0) {
                                num = Integer.valueOf(R.drawable.ic_delivery_outline);
                            } else if (ordinal2 == 1) {
                                num = Integer.valueOf(R.drawable.ic_delivery_courier_outline);
                            } else if (ordinal2 == 2) {
                                num = Integer.valueOf(R.drawable.ic_delivery_return);
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        if (num != null) {
                            TextViews.setCompoundDrawables$default(textView2, num.intValue(), 0, 0, 0, 14, (Object) null);
                        } else {
                            Views.hide(textView2);
                        }
                        textView3.setMovementMethod(LinkMovementMethod.getInstance());
                        AttributedTextFormatter attributedTextFormatter2 = this.z;
                        Context context2 = this.y.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "container.context");
                        textView3.setText(attributedTextFormatter2.format(context2, t4.getTitle()));
                        viewGroup.addView(inflate);
                    } else if (t3 instanceof SafeDeal.About.ListComponent.Spacing) {
                        Integer height = t3.getHeight();
                        if (height != null) {
                            int intValue = height.intValue();
                            ViewGroup viewGroup2 = this.y;
                            View inflate2 = this.s.inflate(R.layout.advert_details_safedeal_space, viewGroup2, false);
                            Intrinsics.checkNotNullExpressionValue(inflate2, "inflatedView");
                            ViewGroup.LayoutParams layoutParams = inflate2.getLayoutParams();
                            layoutParams.height = ViewSizeKt.getDp(intValue);
                            inflate2.setLayoutParams(layoutParams);
                            viewGroup2.addView(inflate2);
                        }
                    } else if (t3 instanceof SafeDeal.About.ListComponent.Unknown) {
                        Logs.error$default("Unsupported listComponent's type at delivery trust factors", null, 2, null);
                    }
                    i = i2;
                }
            }
        }
    }
}
