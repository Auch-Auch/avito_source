package com.avito.android.advert;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deprecated_design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.MenuItemsKt;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Toolbars;
import com.google.android.material.badge.BadgeDrawable;
import com.jakewharton.rxbinding4.view.RxMenuItem;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.dialog.Dialogs;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010<\u001a\u00020\u000f¢\u0006\u0004\bJ\u0010KJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\rJ\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\rJ\u0019\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010\rJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016¢\u0006\u0004\b&\u0010\"J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016¢\u0006\u0004\b'\u0010\"J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016¢\u0006\u0004\b(\u0010\"J\u0017\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\u0016¢\u0006\u0004\b*\u0010\u0012R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u00103R\u0016\u00105\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010,R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsToolbarViewImpl;", "Lcom/avito/android/advert/AdvertDetailsToolbarView;", "", "d", "()V", "Landroid/view/MenuItem;", AuthSource.BOOKING_ORDER, "()Landroid/view/MenuItem;", "c", AuthSource.SEND_ABUSE, "", "isExpanded", "setupExpandedState", "(Z)V", "setupToolbar", "", "title", "setToolbarTitle", "(Ljava/lang/String;)V", "setupCollapsedToolbar", "setupExpandedToolbar", "getIsExpanded", "()Z", "setupUpButton", "visible", "setSharingVisible", "setAddNoteMenuItemVisible", "", "setAddNoteMenuItemTitle", "(I)V", "favorite", "setFavorite", "Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showInfoBubble", "showWarningBubble", "detach", "favoriteButtonClicks", "shareButtonClicks", "addNoteMenuItemClicks", "message", "showMessage", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "popUpTitle", "Landroid/view/View;", "h", "Landroid/view/View;", "view", "Landroidx/appcompat/widget/Toolbar;", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "popUpText", "Lcom/avito/android/lib/design/button/Button;", "e", "Lcom/avito/android/lib/design/button/Button;", "popUpButton", "j", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, g.a, "Z", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "popUp", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "f", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "i", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "<init>", "(Landroid/view/View;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsToolbarViewImpl implements AdvertDetailsToolbarView {
    public final Toolbar a;
    public final PopupWindow b;
    public TextView c;
    public TextView d;
    public Button e;
    public final CompositeDisposable f = new CompositeDisposable();
    public boolean g = true;
    public final View h;
    public final AdvertDetailsAnalyticsInteractor i;
    public final String j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsToolbarViewImpl a;

        public a(AdvertDetailsToolbarViewImpl advertDetailsToolbarViewImpl) {
            this.a = advertDetailsToolbarViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.a.b.isShowing()) {
                this.a.b.dismiss();
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsToolbarViewImpl a;

        public static final class a<T> implements Consumer<Unit> {
            public static final a a = new a();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Consumer
            public void accept(Unit unit) {
            }
        }

        public b(AdvertDetailsToolbarViewImpl advertDetailsToolbarViewImpl) {
            this.a = advertDetailsToolbarViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.a.b.isShowing()) {
                this.a.b.dismiss();
            }
            this.a.i.sendClickToEnableNotifications(this.a.j);
            CompositeDisposable compositeDisposable = this.a.f;
            Dialogs dialogs = Dialogs.INSTANCE;
            Context context = this.a.h.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            Disposable subscribe = dialogs.showEnableNotifications(context).subscribe(a.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "Dialogs.showEnableNotifi… /*Nothing to do here*/ }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public AdvertDetailsToolbarViewImpl(@NotNull View view, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.h = view;
        this.i = advertDetailsAnalyticsInteractor;
        this.j = str;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.a = (Toolbar) findViewById;
        View inflate = LayoutInflater.from(view.getContext()).inflate(com.avito.android.advert_details.R.layout.advert_details_price_subscription_popup, (ViewGroup) null);
        View findViewById2 = inflate.findViewById(com.avito.android.advert_details.R.id.price_subscription_popup_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "popUpView.findViewById(R…subscription_popup_title)");
        this.c = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(com.avito.android.advert_details.R.id.price_subscription_popup_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "popUpView.findViewById(R…_subscription_popup_text)");
        this.d = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(com.avito.android.advert_details.R.id.price_subscription_popup_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "popUpView.findViewById(R…ubscription_popup_button)");
        this.e = (Button) findViewById4;
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        this.b = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        popupWindow.setAnimationStyle(com.avito.android.lib.design.R.style.Design_Animation_AppCompat_DropDownUp);
    }

    public final MenuItem a() {
        MenuItem findItem = this.a.getMenu().findItem(com.avito.android.advert_details.R.id.menu_add_note);
        if (findItem != null) {
            return findItem;
        }
        throw new IllegalArgumentException("Toolbar was not inflated".toString());
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    @NotNull
    public Observable<Unit> addNoteMenuItemClicks() {
        return RxMenuItem.clicks$default(a(), null, 1, null);
    }

    public final MenuItem b() {
        MenuItem findItem = this.a.getMenu().findItem(com.avito.android.advert_details.R.id.menu_subscription);
        if (findItem != null) {
            return findItem;
        }
        throw new IllegalArgumentException("Toolbar was not inflated".toString());
    }

    public final MenuItem c() {
        MenuItem findItem = this.a.getMenu().findItem(com.avito.android.advert_details.R.id.menu_share);
        if (findItem != null) {
            return findItem;
        }
        throw new IllegalArgumentException("Toolbar was not inflated".toString());
    }

    public final void d() {
        PopupWindow popupWindow = this.b;
        View view = this.h;
        popupWindow.showAtLocation(view, BadgeDrawable.TOP_END, view.getResources().getDimensionPixelSize(com.avito.android.advert_details.R.dimen.price_subscription_popup_margin_horizontal), this.h.getResources().getDimensionPixelSize(com.avito.android.advert_details.R.dimen.price_subscription_popup_margin_vertical));
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void detach() {
        this.f.clear();
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    @NotNull
    public Observable<Unit> favoriteButtonClicks() {
        return RxMenuItem.clicks$default(b(), null, 1, null);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public boolean getIsExpanded() {
        return this.g;
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setAddNoteMenuItemTitle(@StringRes int i2) {
        a().setTitle(i2);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setAddNoteMenuItemVisible(boolean z) {
        a().setVisible(z);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setFavorite(boolean z) {
        MenuItem b2 = b();
        b2.setChecked(z);
        b2.setIcon(z ? com.avito.android.ui_components.R.drawable.ic_fav_24_rich_selected : com.avito.android.ui_components.R.drawable.ic_fav_24_rich);
        MenuItem b3 = b();
        if (z) {
            Context context = this.h.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            MenuItemsKt.tintIconByColorRes(b3, context, com.avito.android.lib.design.avito.R.color.expected_favorites_icon_selected);
            return;
        }
        Context context2 = this.h.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        MenuItemsKt.tintIconByAttr(b3, context2, com.avito.android.lib.design.R.attr.blue);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setSharingVisible(boolean z) {
        c().setVisible(z);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setToolbarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setTitle(str);
        this.a.setTitleTextAppearance(this.h.getContext(), com.avito.android.lib.design.R.style.TextAppearance_Avito_Body);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setupCollapsedToolbar() {
        this.g = false;
        Toolbars.setBackIconByAttr(this.a, com.avito.android.lib.design.R.attr.black);
        Toolbar toolbar = this.a;
        int i2 = com.avito.android.lib.design.R.attr.blue;
        Toolbars.tintMenuByAttr(toolbar, i2);
        Drawable overflowIcon = this.a.getOverflowIcon();
        if (overflowIcon != null) {
            Context context = this.h.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            overflowIcon.setTint(Contexts.getColorByAttr(context, i2));
        }
        Toolbar toolbar2 = this.a;
        Context context2 = this.h.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        toolbar2.setBackground(new ColorDrawable(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.transparentBlack)));
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setupExpandedState(boolean z) {
        this.g = z;
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setupExpandedToolbar() {
        this.g = true;
        Toolbar toolbar = this.a;
        int i2 = com.avito.android.lib.design.R.attr.white;
        Toolbars.setBackIconByAttr(toolbar, i2);
        Toolbars.tintMenuByAttr(this.a, i2);
        Drawable overflowIcon = this.a.getOverflowIcon();
        if (overflowIcon != null) {
            Context context = this.h.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            overflowIcon.setTint(Contexts.getColorByAttr(context, i2));
        }
        Toolbar toolbar2 = this.a;
        Drawable drawable = this.h.getContext().getDrawable(com.avito.android.advert_core.R.drawable.toolbar_bg);
        Intrinsics.checkNotNull(drawable);
        toolbar2.setBackground(drawable);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setupToolbar() {
        if (!this.a.getMenu().hasVisibleItems()) {
            this.a.inflateMenu(com.avito.android.advert_details.R.menu.advert_details);
            Toolbars.setBackIconByAttr(this.a, com.avito.android.lib.design.R.attr.black);
            Toolbar toolbar = this.a;
            int i2 = com.avito.android.lib.design.R.attr.blue;
            Toolbars.tintMenuByAttr(toolbar, i2);
            Drawable overflowIcon = this.a.getOverflowIcon();
            if (overflowIcon != null) {
                Context context = this.h.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                overflowIcon.setTint(Contexts.getColorByAttr(context, i2));
            }
        }
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void setupUpButton() {
        Toolbars.setBackIconByAttr(this.a, com.avito.android.lib.design.R.attr.black);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    @NotNull
    public Observable<Unit> shareButtonClicks() {
        return RxMenuItem.clicks$default(c(), null, 1, null);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void showInfoBubble() {
        this.c.setText(com.avito.android.advert_details.R.string.price_subscription_popup_info_title);
        this.d.setText(com.avito.android.advert_details.R.string.price_subscription_popup_info_text);
        this.e.setText(com.avito.android.advert_details.R.string.price_subscription_popup_info_button);
        this.e.setOnClickListener(new a(this));
        d();
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.h.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast(context, str, 0);
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    public void showWarningBubble() {
        this.c.setText(com.avito.android.advert_details.R.string.price_subscription_popup_warning_title);
        this.d.setText(com.avito.android.advert_details.R.string.price_subscription_popup_warning_text);
        this.e.setText(com.avito.android.advert_details.R.string.price_subscription_popup_warning_button);
        this.e.setOnClickListener(new b(this));
        d();
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        return Toolbars.upClicks(this.a);
    }
}
