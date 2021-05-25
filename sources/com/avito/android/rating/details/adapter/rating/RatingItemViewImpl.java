package com.avito.android.rating.details.adapter.rating;

import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.rating.R;
import com.avito.android.util.FloatsKt;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/avito/android/rating/details/adapter/rating/RatingItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/rating/details/adapter/rating/RatingItemView;", "", "score", "", "setScore", "(F)V", "", "description", "setDescription", "(Ljava/lang/CharSequence;)V", "", "Lcom/avito/android/rating/details/adapter/rating/RatingStatEntry;", "data", "setRatingStat", "(Ljava/util/List;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "ratingDescription", "Lcom/avito/android/rating/details/adapter/rating/RatingStatView;", VKApiConst.VERSION, "Lcom/avito/android/rating/details/adapter/rating/RatingStatView;", "ratingStat", "t", "ratingValue", "Lcom/avito/android/lib/design/rating/RatingBar;", "s", "Lcom/avito/android/lib/design/rating/RatingBar;", "rating", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingItemViewImpl extends BaseViewHolder implements RatingItemView {
    public final RatingBar s;
    public final TextView t;
    public final TextView u;
    public final RatingStatView v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.rating);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.s = (RatingBar) findViewById;
        View findViewById2 = view.findViewById(R.id.rating_value);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rating_description);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.rating_stat);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TableLayout");
        this.v = new RatingStatViewImpl((TableLayout) findViewById4);
    }

    @Override // com.avito.android.rating.details.adapter.rating.RatingItemView
    public void setDescription(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.u, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.details.adapter.rating.RatingItemView
    public void setRatingStat(@Nullable List<RatingStatEntry> list) {
        if (list == null) {
            this.v.setVisible(false);
            return;
        }
        this.v.setVisible(true);
        this.v.bindData(list);
    }

    @Override // com.avito.android.rating.details.adapter.rating.RatingItemView
    public void setScore(float f) {
        this.s.setFloatingRatingIsEnabled(true);
        this.s.setRating(f);
        this.t.setText(FloatsKt.formatWithSeparator$default(f, null, 0, 3, null));
    }
}
