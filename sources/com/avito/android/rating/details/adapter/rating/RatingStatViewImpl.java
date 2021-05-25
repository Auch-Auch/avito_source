package com.avito.android.rating.details.adapter.rating;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.lib.expected.progress_bar.ProgressBar;
import com.avito.android.rating.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/rating/details/adapter/rating/RatingStatViewImpl;", "Lcom/avito/android/rating/details/adapter/rating/RatingStatView;", "", "Lcom/avito/android/rating/details/adapter/rating/RatingStatEntry;", "stat", "", "bindData", "(Ljava/util/List;)V", "", "visible", "setVisible", "(Z)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/widget/TableLayout;", AuthSource.BOOKING_ORDER, "Landroid/widget/TableLayout;", "table", "<init>", "(Landroid/widget/TableLayout;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingStatViewImpl implements RatingStatView {
    public final LayoutInflater a;
    public final TableLayout b;

    public RatingStatViewImpl(@NotNull TableLayout tableLayout) {
        Intrinsics.checkNotNullParameter(tableLayout, "table");
        this.b = tableLayout;
        this.a = LayoutInflater.from(tableLayout.getContext());
    }

    @Override // com.avito.android.rating.details.adapter.rating.RatingStatView
    public void bindData(@NotNull List<RatingStatEntry> list) {
        Intrinsics.checkNotNullParameter(list, "stat");
        this.b.removeAllViews();
        for (T t : list) {
            View inflate = this.a.inflate(R.layout.rating_table_row, (ViewGroup) this.b, false);
            View findViewById = inflate.findViewById(R.id.rating_row_stars);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
            ((RatingBar) findViewById).setRating((float) t.getRating());
            View findViewById2 = inflate.findViewById(R.id.rating_row_bar);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.expected.progress_bar.ProgressBar");
            ((ProgressBar) findViewById2).setProgress(t.getCounterProgress());
            View findViewById3 = inflate.findViewById(R.id.rating_row_count);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById3).setText(t.getTitle());
            this.b.addView(inflate);
        }
    }

    @Override // com.avito.android.rating.details.adapter.rating.RatingStatView
    public void setVisible(boolean z) {
        Views.setVisible(this.b, z);
    }
}
