package com.avito.android.bundles.ui.recycler.item.bundle;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.bundles.R;
import com.avito.android.bundles.ui.recycler.item.benefit.BundleBenefitItem;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView;
import com.avito.android.bundles.ui.view.DiscountView;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.remote.model.BundleDiscount;
import com.avito.android.remote.model.UniversalImage;
import com.avito.android.remote.model.UniversalImageKt;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.color.ContextsKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u0018J%\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010,R\u0016\u0010;\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010,R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006L"}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemViewImpl;", "Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/UniversalImage;", "image", "", "setPicture", "(Lcom/avito/android/remote/model/UniversalImage;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/BundleDiscount;", FirebaseAnalytics.Param.DISCOUNT, "setDiscount", "(Lcom/avito/android/remote/model/BundleDiscount;)V", "", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItem;", "benefits", "setBenefits", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "price", "setPrice", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "oldPrice", "setOldPrice", "priceHint", "setPriceHint", "text", "Lkotlin/Function0;", "onClickListener", "configureChooseButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "C", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/lib/design/button/Button;", "z", "Lcom/avito/android/lib/design/button/Button;", "chooseButton", "Landroid/widget/TextView;", "x", "Landroid/widget/TextView;", "oldPriceView", "y", "priceHintView", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "view", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "pictureView", "w", "priceView", "t", "titleView", "Lcom/avito/android/bundles/ui/view/DiscountView;", "u", "Lcom/avito/android/bundles/ui/view/DiscountView;", "discountView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "B", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroidx/recyclerview/widget/RecyclerView;", VKApiConst.VERSION, "Landroidx/recyclerview/widget/RecyclerView;", "benefitsView", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundleItemViewImpl extends BaseViewHolder implements VasBundleItemView {
    public final View A;
    public final AttributedTextFormatter B;
    public final AdapterPresenter C;
    public final SimpleDraweeView s;
    public final TextView t;
    public final DiscountView u;
    public final RecyclerView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final Button z;

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
    @Inject
    public VasBundleItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.A = view;
        this.B = attributedTextFormatter;
        this.C = adapterPresenter;
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.discount);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.bundles.ui.view.DiscountView");
        this.u = (DiscountView) findViewById3;
        View findViewById4 = view.findViewById(R.id.benefits);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.v = recyclerView;
        View findViewById5 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.old_price);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.price_hint);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.y = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.choose_button);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.z = (Button) findViewById8;
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @Override // com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView
    public void configureChooseButton(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "onClickListener");
        this.z.setText(str);
        this.z.setOnClickListener(new a(function0));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        VasBundleItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView
    public void setBenefits(@NotNull List<BundleBenefitItem> list) {
        Intrinsics.checkNotNullParameter(list, "benefits");
        a2.b.a.a.a.s1(list, this.C);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView
    public void setDiscount(@Nullable BundleDiscount bundleDiscount) {
        if (bundleDiscount != null) {
            Views.show(this.u);
            DiscountView discountView = this.u;
            Context context = this.A.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            discountView.setDiscountBackgroundColor(ContextsKt.getColorFrom(context, bundleDiscount.getColor()));
            this.u.setDiscountTitle(bundleDiscount.getTitle());
            return;
        }
        Views.hide(this.u);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView
    public void setOldPrice(@Nullable AttributedText attributedText) {
        if (attributedText != null) {
            TextViewsKt.bindAttributedText$default(this.x, attributedText, null, 2, null);
            Views.show(this.x);
            return;
        }
        Views.hide(this.x);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView
    public void setPicture(@Nullable UniversalImage universalImage) {
        if (universalImage != null) {
            Context context = this.A.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            SimpleDraweeViewsKt.loadPicture$default(this.s, AvitoPictureKt.pictureOf$default(UniversalImageKt.getImageDependsOnTheme(universalImage, DarkThemeManagerKt.isLightTheme(context)), false, 0.0f, 0.0f, null, 28, null), null, null, 6, null);
            Views.show(this.s);
            return;
        }
        Views.hide(this.s);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView
    public void setPrice(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "price");
        TextViewsKt.bindAttributedText$default(this.w, attributedText, null, 2, null);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView
    public void setPriceHint(@Nullable AttributedText attributedText) {
        TextViewsKt.bindAttributedText(this.y, attributedText, this.B);
    }

    @Override // com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }
}
