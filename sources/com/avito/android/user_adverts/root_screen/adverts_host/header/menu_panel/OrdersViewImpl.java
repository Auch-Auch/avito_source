package com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel;

import a2.g.r.g;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.root_screen.adverts_host.header.CardData;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0012¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0010¨\u0006%"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/OrdersViewImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/OrdersView;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "info", "", "setOrdersInfo", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;)V", "setOrdersLoading", "()V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "f", "Lcom/jakewharton/rxrelay2/PublishRelay;", "cardClicksRelay", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "ordersTitle", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "ordersContentView", "e", "ordersSubtitleDot", AuthSource.SEND_ABUSE, "ordersSkeleton", "Lio/reactivex/Observable;", g.a, "Lio/reactivex/Observable;", "getRightCardClicks", "()Lio/reactivex/Observable;", "rightCardClicks", "d", "ordersSubtitle", "view", "<init>", "(Landroid/view/View;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersViewImpl implements OrdersView {
    public final View a;
    public final View b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final PublishRelay<ProfileHeaderView.ClickTarget> f;
    @NotNull
    public final Observable<ProfileHeaderView.ClickTarget> g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OrdersViewImpl a;
        public final /* synthetic */ CardData b;

        public a(OrdersViewImpl ordersViewImpl, CardData cardData) {
            this.a = ordersViewImpl;
            this.b = cardData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.f.accept(this.b.getClickTarget());
        }
    }

    public OrdersViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.orders_skeleton);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.orders_skeleton)");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.orders_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.orders_content)");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.orders_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.orders_title)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.orders_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.orders_subtitle)");
        this.d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.orders_subtitle_dot);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.orders_subtitle_dot)");
        this.e = findViewById5;
        PublishRelay<ProfileHeaderView.ClickTarget> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.f = create;
        this.g = create;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersView
    @NotNull
    public Observable<ProfileHeaderView.ClickTarget> getRightCardClicks() {
        return this.g;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersView
    public void setOrdersInfo(@NotNull CardData cardData) {
        Intrinsics.checkNotNullParameter(cardData, "info");
        Views.hide(this.a);
        this.c.setText(cardData.getTitle());
        this.d.setText(cardData.getSubTitle());
        Views.setVisible(this.e, Intrinsics.areEqual(cardData.getHasNotification(), Boolean.TRUE));
        this.b.setOnClickListener(new a(this, cardData));
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersView
    public void setOrdersLoading() {
        Views.show(this.a);
    }
}
