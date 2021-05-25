package com.avito.android.rating.check;

import android.view.View;
import com.avito.android.rating.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/rating/check/RatingPublishCheckViewImpl;", "Lcom/avito/android/rating/check/RatingPublishCheckView;", "", "showProgress", "()V", "hideProgress", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", AuthSource.SEND_ABUSE, "progress", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishCheckViewImpl implements RatingPublishCheckView {
    public final View a;
    public final View b;

    public RatingPublishCheckViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = view;
        View findViewById = view.findViewById(R.id.progress);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckView
    public void hideProgress() {
        Views.hide(this.a);
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckView
    public void showProgress() {
        Views.show(this.a);
    }
}
