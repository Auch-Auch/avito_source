package com.avito.android.rating.user_reviews.adapter.placeholder;

import android.view.View;
import android.widget.TextView;
import com.avito.android.rating.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/rating/user_reviews/adapter/placeholder/PlaceholderItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/rating/user_reviews/adapter/placeholder/PlaceholderItemView;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class PlaceholderItemViewImpl extends BaseViewHolder implements PlaceholderItemView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlaceholderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.placeholder_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(R.string.review_placeholder_text);
    }
}
