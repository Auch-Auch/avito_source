package com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
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
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010=\u001a\u00020\u001c¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\"R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001aR\u0016\u0010/\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\"R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010\u001eR\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010\u0014\u001a\u0004\b;\u0010\u0016¨\u0006@"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/LeftCardViewImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/LeftCardView;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "data", "", "setLeftCardContent", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;)V", "setLeftCardLoading", "()V", "", "text", "showSoaUpdateProgress", "(Ljava/lang/String;)V", "collapseSoaUpdateProgress", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "onDismissClickTarget", "showLeftCardTooltip", "(Ljava/lang/String;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;)V", "Lio/reactivex/Observable;", "l", "Lio/reactivex/Observable;", "getSoaProgressCollapsedEvents", "()Lio/reactivex/Observable;", "soaProgressCollapsedEvents", "Lcom/jakewharton/rxrelay2/PublishRelay;", "j", "Lcom/jakewharton/rxrelay2/PublishRelay;", "soaProgressCollapsedRelay", "Landroid/view/View;", g.a, "Landroid/view/View;", "soaUpdateView", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "soaUpdateTextView", "e", "cardSkeletonView", "Lcom/avito/android/lib/design/tooltip/Tooltip;", "k", "Lcom/avito/android/lib/design/tooltip/Tooltip;", "tooltip", "c", "cardSubTitleViewView", "f", "cardClicksRelay", "d", "cardTitleView", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "imageView", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/CollapsingProgressView;", "i", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/CollapsingProgressView;", "soaUpdateProgressView", AuthSource.BOOKING_ORDER, "cardContentView", AuthSource.OPEN_CHANNEL_LIST, "getLeftCardClicks", "leftCardClicks", "view", "<init>", "(Landroid/view/View;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class LeftCardViewImpl implements LeftCardView {
    public final ImageView a;
    public final View b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final PublishRelay<ProfileHeaderView.ClickTarget> f;
    public final View g;
    public final TextView h;
    public final CollapsingProgressView i;
    public final PublishRelay<Unit> j;
    public Tooltip k;
    @NotNull
    public final Observable<Unit> l;
    @NotNull
    public final Observable<ProfileHeaderView.ClickTarget> m;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ LeftCardViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LeftCardViewImpl leftCardViewImpl) {
            super(0);
            this.a = leftCardViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.j;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LeftCardViewImpl a;
        public final /* synthetic */ CardData b;

        public b(LeftCardViewImpl leftCardViewImpl, CardData cardData) {
            this.a = leftCardViewImpl;
            this.b = cardData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.f.accept(this.b.getClickTarget());
        }
    }

    public static final class c implements PopupWindow.OnDismissListener {
        public final /* synthetic */ LeftCardViewImpl a;
        public final /* synthetic */ ProfileHeaderView.ClickTarget b;

        public c(LeftCardViewImpl leftCardViewImpl, ProfileHeaderView.ClickTarget clickTarget) {
            this.a = leftCardViewImpl;
            this.b = clickTarget;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            this.a.f.accept(this.b);
            this.a.k = null;
        }
    }

    public static final class d extends Lambda implements Function1<TooltipContent, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
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

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ LeftCardViewImpl a;

        public e(LeftCardViewImpl leftCardViewImpl) {
            this.a = leftCardViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tooltip tooltip = this.a.k;
            if (tooltip != null) {
                tooltip.dismiss();
            }
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ LeftCardViewImpl a;

        public f(LeftCardViewImpl leftCardViewImpl) {
            this.a = leftCardViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.i.startProgressAnimation();
        }
    }

    public LeftCardViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.menu_panel_left_card_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.menu_panel_left_card_image)");
        this.a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.menu_panel_left_card_content);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.menu_panel_left_card_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.m…anel_left_card_sub_title)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.menu_panel_left_card_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.menu_panel_left_card_title)");
        this.d = (TextView) findViewById4;
        this.e = view.findViewById(R.id.menu_panel_left_card_skeleton);
        PublishRelay<ProfileHeaderView.ClickTarget> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.f = create;
        View findViewById5 = view.findViewById(R.id.soa_update_view);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.soa_update_view)");
        this.g = findViewById5;
        View findViewById6 = findViewById5.findViewById(R.id.soa_update_text);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "soaUpdateView.findViewById(R.id.soa_update_text)");
        this.h = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.soa_update_progress);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.CollapsingProgressView");
        CollapsingProgressView collapsingProgressView = (CollapsingProgressView) findViewById7;
        this.i = collapsingProgressView;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.j = create2;
        this.l = create2;
        this.m = create;
        collapsingProgressView.setAnimationFinishListener(new a(this));
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void collapseSoaUpdateProgress() {
        this.i.startCollapseAnimation();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    @NotNull
    public Observable<ProfileHeaderView.ClickTarget> getLeftCardClicks() {
        return this.m;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    @NotNull
    public Observable<Unit> getSoaProgressCollapsedEvents() {
        return this.l;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void setLeftCardContent(@NotNull CardData cardData) {
        Intrinsics.checkNotNullParameter(cardData, "data");
        Integer icon = cardData.getIcon();
        if (icon != null) {
            icon.intValue();
            ImageView imageView = this.a;
            int intValue = cardData.getIcon().intValue();
            if (intValue == R.drawable.ic_soa_pig) {
                Context context = imageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Views.changeMargin$default(imageView, Views.dpToPx(context, -6), 0, 0, 0, 14, null);
            } else {
                Context context2 = imageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                Views.changeMargin$default(imageView, Views.dpToPx(context2, 0), 0, 0, 0, 14, null);
            }
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), intValue));
        }
        this.c.setText(cardData.getSubTitle());
        this.d.setText(cardData.getTitle());
        this.b.setOnClickListener(new b(this, cardData));
        if (Views.isVisible(this.g)) {
            this.i.stopAnimation();
            Views.hide(this.g);
        }
        View view = this.e;
        if (view != null && Views.isVisible(view)) {
            Views.hide(this.e);
        }
        if (!Views.isVisible(this.b)) {
            Views.show(this.b);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void setLeftCardLoading() {
        if (Views.isVisible(this.b)) {
            Views.hide(this.b);
        }
        if (Views.isVisible(this.g)) {
            this.i.stopAnimation();
            Views.hide(this.g);
        }
        Views.show(this.e);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void showLeftCardTooltip(@NotNull String str, @NotNull ProfileHeaderView.ClickTarget clickTarget) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(clickTarget, "onDismissClickTarget");
        if (this.k == null) {
            Context context = this.b.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "cardContentView.context");
            Tooltip tooltipClickListener = TooltipContentKt.content(Tooltip.setSize$default(new Tooltip(context, 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Bottom(new TailPositions.Start(new AnchorPositions.Start()))), -1, 0, 2, null), new d(str)).setTooltipClickListener(new e(this));
            tooltipClickListener.setTouchable(true);
            tooltipClickListener.setOutsideTouchable(true);
            tooltipClickListener.setOnDismissListener(new c(this, clickTarget));
            this.k = tooltipClickListener.show(this.b);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void showSoaUpdateProgress(@Nullable String str) {
        if (Views.isVisible(this.b)) {
            Views.hide(this.b);
        }
        View view = this.e;
        if (view != null && Views.isVisible(view)) {
            Views.hide(this.e);
        }
        if (!Views.isVisible(this.g)) {
            this.i.prepareAnimation();
            Views.show(this.g);
            TextViews.bindText$default(this.h, str, false, 2, null);
            this.i.postDelayed(new f(this), 200);
        }
    }
}
