package com.avito.android.shop.detailed.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.Features;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.FloatsKt;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u001d\u0010\u0013\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0019\u0010(\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/avito/android/shop/detailed/item/RatingViewImpl;", "Lcom/avito/android/shop/detailed/item/RatingView;", "", "setRatingTextInactive", "()V", "", "text", "setRatingTextActive", "(Ljava/lang/String;)V", "setRatingTextNonActionable", "showRatingScore", "hideRatingScore", "", "score", "setRatingScore", "(F)V", "showRatings", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRatingClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "ratingNumber", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "ratingContainer", "Lcom/avito/android/lib/design/rating/RatingBar;", "c", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingScore", "d", "ratingText", "Landroid/view/View;", "f", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class RatingViewImpl implements RatingView {
    public final Context a;
    public final ViewGroup b;
    public final RatingBar c;
    public final TextView d;
    public final TextView e;
    @NotNull
    public final View f;

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

    public RatingViewImpl(@NotNull View view, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(features, "features");
        this.f = view;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.a = context;
        View findViewById = view.findViewById(R.id.rating_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.b = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.rating_score);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.c = (RatingBar) findViewById2;
        View findViewById3 = view.findViewById(R.id.rating_text);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.rating_number);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById4;
    }

    @NotNull
    public final View getView() {
        return this.f;
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void hideRatingScore() {
        Views.hide(this.c);
        Views.hide(this.e);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingScore(float f2) {
        this.c.setFloatingRatingIsEnabled(true);
        this.c.setRating(f2);
        Views.setVisible(this.e, true);
        this.e.setText(FloatsKt.formatWithSeparator$default(f2, null, 0, 3, null));
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingTextActive(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.d.setTextColor(Contexts.getColorByAttr(this.a, com.avito.android.lib.design.R.attr.blue));
        this.d.setText(str);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingTextInactive() {
        this.d.setTextColor(Contexts.getColorByAttr(this.a, com.avito.android.lib.design.R.attr.gray28));
        this.d.setText(this.a.getResources().getString(R.string.no_reviews_yet));
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingTextNonActionable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.d.setTextColor(Contexts.getColorByAttr(this.a, com.avito.android.lib.design.R.attr.black));
        this.d.setText(str);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void showRatingScore() {
        Views.show(this.c);
        Views.setVisible(this.e, true);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void showRatings() {
        Views.show(this.b);
    }
}
