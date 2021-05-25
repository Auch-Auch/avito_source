package com.avito.android.job.cv_packages.item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.TextView;
import com.avito.android.job.cv_packages.Action;
import com.avito.android.job.cv_packages.Package;
import com.avito.android.job.cv_packages.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.drawable.ShapeStateDrawable;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u001e\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\n¨\u0006 "}, d2 = {"Lcom/avito/android/job/cv_packages/item/PackageItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/job/cv_packages/item/PackageItemView;", "Lcom/avito/android/job/cv_packages/Package;", "pckg", "", "bind", "(Lcom/avito/android/job/cv_packages/Package;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "title", "u", "badge", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "w", "Landroid/content/Context;", "context", "x", "Lcom/avito/android/job/cv_packages/Package;", VKApiConst.VERSION, "price", "t", MessengerShareContentUtility.SUBTITLE, "Landroid/view/View;", "root", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/job/cv_packages/Action;", "actionConsumer", "<init>", "(Landroid/view/View;Lio/reactivex/rxjava3/functions/Consumer;)V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
public final class PackageItemViewImpl extends BaseViewHolder implements PackageItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final Context w;
    public Package x;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PackageItemViewImpl a;
        public final /* synthetic */ Consumer b;

        public a(PackageItemViewImpl packageItemViewImpl, Consumer consumer) {
            this.a = packageItemViewImpl;
            this.b = consumer;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.accept(new Action.PackageClicked(PackageItemViewImpl.access$getPckg$p(this.a).getDeeplink()));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PackageItemViewImpl(@NotNull View view, @NotNull Consumer<Action> consumer) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.badge);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        Context context = view.getContext();
        this.w = context;
        view.setOnClickListener(new a(this, consumer));
        ShapeAppearanceModel build = ShapeAppearanceModel.builder().setAllCorners(0, (float) ViewSizeKt.getDp(5)).build();
        Intrinsics.checkNotNullExpressionValue(build, "ShapeAppearanceModel.bui…t())\n            .build()");
        ShapeStateDrawable.Companion companion = ShapeStateDrawable.Companion;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ColorStateList colorStateListByAttr = Contexts.getColorStateListByAttr(context, com.avito.android.lib.design.avito.R.attr.gray4);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        view.setBackground(ShapeStateDrawable.Companion.invoke$default(companion, build, 0, 0, 0, 0, colorStateListByAttr, Contexts.getColorStateListByAttr(context, com.avito.android.lib.design.avito.R.attr.gray12), 30, null));
    }

    public static final /* synthetic */ Package access$getPckg$p(PackageItemViewImpl packageItemViewImpl) {
        Package r1 = packageItemViewImpl.x;
        if (r1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pckg");
        }
        return r1;
    }

    @Override // com.avito.android.job.cv_packages.item.PackageItemView
    public void bind(@NotNull Package r7) {
        Intrinsics.checkNotNullParameter(r7, "pckg");
        this.x = r7;
        this.s.setText(r7.getTitle());
        TextViews.bindText$default(this.t, r7.getSinglePrice(), false, 2, null);
        TextViews.bindText$default(this.u, r7.getDiscount(), false, 2, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(r7.getPrice());
        if (r7.getOriginalPrice() != null) {
            spannableStringBuilder.append(' ');
            spannableStringBuilder.append((CharSequence) r7.getOriginalPrice());
            int length = r7.getPrice().length() + 1;
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(new StrikethroughSpan(), length, length2, 33);
            Context context = this.w;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Contexts.getColorByAttr(context, com.avito.android.lib.design.avito.R.attr.gray48)), length, length2, 33);
        }
        this.v.setText(spannableStringBuilder);
    }
}
