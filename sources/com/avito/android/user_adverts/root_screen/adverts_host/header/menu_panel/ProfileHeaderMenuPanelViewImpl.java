package com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContent;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.root_screen.adverts_host.header.CardData;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010<\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010P\u001a\u00020\u0003¢\u0006\u0004\b[\u0010\\J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u000eJ\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0016\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0017\u0010\u000eJ \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0018\u0010\u0014J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\tH\u0001¢\u0006\u0004\b\u001c\u0010\fJ\u0010\u0010\u001d\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\u000eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u001e8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b-\u0010 R\u0016\u00100\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010(R\"\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010 R\u0016\u00106\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010(R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010(R:\u0010A\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00010\u00110\u0011 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00010\u00110\u0011\u0018\u00010=0=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010E\u001a\n >*\u0004\u0018\u00010B0B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010HR\u0016\u0010T\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010LR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00110\u001e8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bU\u0010 R\u0016\u0010X\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010(R\u0016\u0010Z\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010H¨\u0006]"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/ProfileHeaderMenuPanelViewImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/ProfileHeaderMenuPanelView;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/LeftCardView;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/OrdersView;", "", "reverse", "", "animateOrdersToParentWidth", "(Z)V", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "data", "setTopCardData", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;)V", "hideTopCardContent", "()V", "", "text", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "onDismissClickTarget", "showTopCardTooltip", "(Ljava/lang/String;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;)V", "collapseSoaUpdateProgress", "setLeftCardContent", "setLeftCardLoading", "showLeftCardTooltip", "showSoaUpdateProgress", "(Ljava/lang/String;)V", "info", "setOrdersInfo", "setOrdersLoading", "Lio/reactivex/Observable;", "getSoaProgressCollapsedEvents", "()Lio/reactivex/Observable;", "soaProgressCollapsedEvents", "Landroid/widget/ImageView;", AuthSource.BOOKING_ORDER, "Landroid/widget/ImageView;", "topCardImageView", "Landroid/view/View;", "h", "Landroid/view/View;", "leftCard", "p", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/LeftCardView;", "leftCardView", "getRightCardClicks", "rightCardClicks", "e", "topCardContainerView", "n", "Lio/reactivex/Observable;", "getTopCardClicks", "topCardClicks", "f", "topCardContentView", "Lcom/avito/android/lib/design/tooltip/Tooltip;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/tooltip/Tooltip;", "tooltip", "o", "parentView", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "l", "Lcom/jakewharton/rxrelay2/PublishRelay;", "topCardClicksRelay", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "topCardTitleView", "Landroidx/constraintlayout/widget/ConstraintLayout;", g.a, "Landroidx/constraintlayout/widget/ConstraintLayout;", "menuPanelContainerView", VKApiConst.Q, "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/OrdersView;", "ordersView", "k", "ordersTitleView", "j", "ordersContent", "getLeftCardClicks", "leftCardClicks", "i", "ordersCard", "c", "topCardSubTitleViewView", "<init>", "(Landroid/view/View;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/LeftCardView;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/OrdersView;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileHeaderMenuPanelViewImpl implements ProfileHeaderMenuPanelView, LeftCardView, OrdersView {
    public final Context a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final View f;
    public final ConstraintLayout g;
    public final View h;
    public final View i;
    public final ConstraintLayout j;
    public final TextView k;
    public final PublishRelay<ProfileHeaderView.ClickTarget> l;
    public Tooltip m;
    @NotNull
    public final Observable<ProfileHeaderView.ClickTarget> n;
    public final View o;
    public final LeftCardView p;
    public final OrdersView q;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ProfileHeaderMenuPanelViewImpl a;
        public final /* synthetic */ CardData b;

        public a(ProfileHeaderMenuPanelViewImpl profileHeaderMenuPanelViewImpl, CardData cardData) {
            this.a = profileHeaderMenuPanelViewImpl;
            this.b = cardData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.l.accept(this.b.getClickTarget());
        }
    }

    public static final class b implements PopupWindow.OnDismissListener {
        public final /* synthetic */ ProfileHeaderMenuPanelViewImpl a;
        public final /* synthetic */ ProfileHeaderView.ClickTarget b;

        public b(ProfileHeaderMenuPanelViewImpl profileHeaderMenuPanelViewImpl, ProfileHeaderView.ClickTarget clickTarget) {
            this.a = profileHeaderMenuPanelViewImpl;
            this.b = clickTarget;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            this.a.l.accept(this.b);
            this.a.m = null;
        }
    }

    public static final class c extends Lambda implements Function1<TooltipContent, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(TooltipContent tooltipContent) {
            TooltipContent tooltipContent2 = tooltipContent;
            Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
            tooltipContent2.setBody(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ProfileHeaderMenuPanelViewImpl a;

        public d(ProfileHeaderMenuPanelViewImpl profileHeaderMenuPanelViewImpl) {
            this.a = profileHeaderMenuPanelViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tooltip tooltip = this.a.m;
            if (tooltip != null) {
                tooltip.dismiss();
            }
        }
    }

    public ProfileHeaderMenuPanelViewImpl(@NotNull View view, @NotNull LeftCardView leftCardView, @NotNull OrdersView ordersView) {
        Intrinsics.checkNotNullParameter(view, "parentView");
        Intrinsics.checkNotNullParameter(leftCardView, "leftCardView");
        Intrinsics.checkNotNullParameter(ordersView, "ordersView");
        this.o = view;
        this.p = leftCardView;
        this.q = ordersView;
        this.a = view.getContext();
        View findViewById = view.findViewById(R.id.menu_panel_top_card_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parentView.findViewById(…enu_panel_top_card_image)");
        this.b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.menu_panel_top_card_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "parentView.findViewById(…panel_top_card_sub_title)");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.menu_panel_top_card_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "parentView.findViewById(…enu_panel_top_card_title)");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.menu_panel_top_card_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById4;
        View findViewById5 = view.findViewById(R.id.menu_panel_top_card_content);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById5;
        View findViewById6 = view.findViewById(R.id.menu_panel_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "parentView.findViewById(R.id.menu_panel_container)");
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById6;
        this.g = constraintLayout;
        View findViewById7 = constraintLayout.findViewById(R.id.menu_panel_left_card_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "menuPanelContainerView.f…anel_left_card_container)");
        this.h = findViewById7;
        View findViewById8 = view.findViewById(R.id.orders_card);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "parentView.findViewById(R.id.orders_card)");
        this.i = findViewById8;
        View findViewById9 = findViewById8.findViewById(R.id.orders_content);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "ordersCard.findViewById(R.id.orders_content)");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById9;
        this.j = constraintLayout2;
        View findViewById10 = constraintLayout2.findViewById(R.id.orders_title);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "ordersContent.findViewById(R.id.orders_title)");
        this.k = (TextView) findViewById10;
        PublishRelay<ProfileHeaderView.ClickTarget> create = PublishRelay.create();
        this.l = create;
        Intrinsics.checkNotNullExpressionValue(create, "topCardClicksRelay");
        this.n = create;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    public void animateOrdersToParentWidth(boolean z) {
        int i2;
        if (this.h.getVisibility() == 8 && !z) {
            return;
        }
        if (this.h.getVisibility() != 0 || !z) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.load(this.a, R.layout.orders_info_card_content);
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.load(this.o.getContext(), R.layout.orders_info_card_full_panel_width);
            ConstraintSet constraintSet3 = new ConstraintSet();
            constraintSet3.load(this.a, R.layout.user_adverts_header_menu_panel);
            ConstraintSet constraintSet4 = new ConstraintSet();
            constraintSet4.clone(constraintSet3);
            constraintSet4.centerHorizontally(this.i.getId(), 0);
            constraintSet4.setVisibility(this.h.getId(), 8);
            if (!z) {
                constraintSet3 = constraintSet4;
            }
            constraintSet3.applyTo(this.g);
            if (!z) {
                constraintSet = constraintSet2;
            }
            constraintSet.applyTo(this.j);
            if (z) {
                i2 = com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Heading_Small;
            } else {
                i2 = com.avito.android.lib.design.R.style.Design_TextAppearance_Avito_Heading_Large;
            }
            TextViewCompat.setTextAppearance(this.k, i2);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void collapseSoaUpdateProgress() {
        this.p.collapseSoaUpdateProgress();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    @NotNull
    public Observable<ProfileHeaderView.ClickTarget> getLeftCardClicks() {
        return this.p.getLeftCardClicks();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersView
    @NotNull
    public Observable<ProfileHeaderView.ClickTarget> getRightCardClicks() {
        return this.q.getRightCardClicks();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    @NotNull
    public Observable<Unit> getSoaProgressCollapsedEvents() {
        return this.p.getSoaProgressCollapsedEvents();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    @NotNull
    public Observable<ProfileHeaderView.ClickTarget> getTopCardClicks() {
        return this.n;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    public void hideTopCardContent() {
        Views.hide(this.e);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void setLeftCardContent(@NotNull CardData cardData) {
        Intrinsics.checkNotNullParameter(cardData, "data");
        this.p.setLeftCardContent(cardData);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void setLeftCardLoading() {
        this.p.setLeftCardLoading();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersView
    public void setOrdersInfo(@NotNull CardData cardData) {
        Intrinsics.checkNotNullParameter(cardData, "info");
        this.q.setOrdersInfo(cardData);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersView
    public void setOrdersLoading() {
        this.q.setOrdersLoading();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    public void setTopCardData(@NotNull CardData cardData) {
        Intrinsics.checkNotNullParameter(cardData, "data");
        Integer icon = cardData.getIcon();
        if (icon != null) {
            int intValue = icon.intValue();
            ImageView imageView = this.b;
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), intValue));
        }
        this.c.setText(cardData.getSubTitle());
        this.d.setText(cardData.getTitle());
        this.f.setOnClickListener(new a(this, cardData));
        Views.show(this.e);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void showLeftCardTooltip(@NotNull String str, @NotNull ProfileHeaderView.ClickTarget clickTarget) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(clickTarget, "onDismissClickTarget");
        this.p.showLeftCardTooltip(str, clickTarget);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void showSoaUpdateProgress(@Nullable String str) {
        this.p.showSoaUpdateProgress(str);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    public void showTopCardTooltip(@NotNull String str, @NotNull ProfileHeaderView.ClickTarget clickTarget) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(clickTarget, "onDismissClickTarget");
        if (this.m == null) {
            Context context = this.f.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "topCardContentView.context");
            Tooltip tooltipClickListener = TooltipContentKt.content(Tooltip.setSize$default(new Tooltip(context, 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Bottom(new TailPositions.Center(new AnchorPositions.Center()))), -1, 0, 2, null), new c(str)).setTooltipClickListener(new d(this));
            tooltipClickListener.setTouchable(true);
            tooltipClickListener.setOutsideTouchable(true);
            tooltipClickListener.setOnDismissListener(new b(this, clickTarget));
            this.m = tooltipClickListener.show(this.f);
        }
    }
}
