package com.avito.android.component.detail_rating_stars;

import android.view.View;
import android.widget.TextView;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/component/detail_rating_stars/DetailRatingStarsImpl;", "Lcom/avito/android/component/detail_rating_stars/DetailRatingStars;", "", "score", "", "setRating", "(F)V", "", "title", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "show", "()V", "hide", "Lcom/avito/android/lib/design/rating/RatingBar;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/rating/RatingBar;", "getRating", "()Lcom/avito/android/lib/design/rating/RatingBar;", "rating", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "c", "getSubtitle", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class DetailRatingStarsImpl implements DetailRatingStars {
    @NotNull
    public final RatingBar a;
    @NotNull
    public final TextView b;
    @NotNull
    public final TextView c;
    public final View d;

    public DetailRatingStarsImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        View findViewById = view.findViewById(R.id.rating);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.a = (RatingBar) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
    }

    @NotNull
    public final RatingBar getRating() {
        return this.a;
    }

    @NotNull
    public final TextView getSubtitle() {
        return this.c;
    }

    @NotNull
    public final TextView getTitle() {
        return this.b;
    }

    @Override // com.avito.android.component.detail_rating_stars.DetailRatingStars
    public void hide() {
        Views.hide(this.d);
    }

    @Override // com.avito.android.component.detail_rating_stars.DetailRatingStars
    public void setRating(float f) {
        this.a.setRating(f);
    }

    @Override // com.avito.android.component.detail_rating_stars.DetailRatingStars
    public void setSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.c, str, false, 2, null);
    }

    @Override // com.avito.android.component.detail_rating_stars.DetailRatingStars
    public void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.b, str, false, 2, null);
    }

    @Override // com.avito.android.component.detail_rating_stars.DetailRatingStars
    public void show() {
        Views.show(this.d);
    }
}
