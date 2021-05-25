package com.avito.android.advert.closed;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Toolbars;
import com.jakewharton.rxbinding4.view.RxMenuItem;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert/closed/ClosedAdvertViewImpl;", "Lcom/avito/android/advert/closed/ClosedAdvertView;", "", "setupToolbar", "()V", "", "message", "showMessage", "(Ljava/lang/String;)V", "", "visible", "setFavoriteVisible", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "favoriteButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "Landroid/view/MenuItem;", AuthSource.SEND_ABUSE, "()Landroid/view/MenuItem;", "Landroidx/appcompat/widget/Toolbar;", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ClosedAdvertViewImpl implements ClosedAdvertView {
    public final Toolbar a;
    public final View b;

    public ClosedAdvertViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = view;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.a = (Toolbar) findViewById;
    }

    public final MenuItem a() {
        MenuItem findItem = this.a.getMenu().findItem(com.avito.android.advert_details.R.id.menu_subscription);
        if (findItem != null) {
            return findItem;
        }
        throw new IllegalArgumentException("Toolbar was not inflated".toString());
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertView
    @NotNull
    public Observable<Unit> favoriteButtonClicks() {
        return RxMenuItem.clicks$default(a(), null, 1, null);
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertView
    public void setFavoriteVisible(boolean z) {
        a().setVisible(z);
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertView
    public void setupToolbar() {
        if (!this.a.getMenu().hasVisibleItems()) {
            this.a.inflateMenu(com.avito.android.advert_details.R.menu.inactive_item);
            Toolbars.tintMenuByAttr(this.a, com.avito.android.lib.design.R.attr.blue);
        }
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.b.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast(context, str, 0);
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        return Toolbars.upClicks(this.a);
    }
}
