package com.avito.android.user_adverts.root_screen.adverts_host.header;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010]\u001a\u00020\u0002\u0012\u0006\u0010_\u001a\u00020^¢\u0006\u0004\b`\u0010aJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0016\u0010\u0015J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001b\u0010\u0015J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001e\u0010\u001aJ \u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\b%\u0010&J \u0010'\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0001¢\u0006\u0004\b'\u0010$R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020!0(8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\"\u00102\u001a\b\u0012\u0004\u0012\u00020!0(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010*R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020!0(8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b3\u0010*R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050(8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b9\u0010*R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020!0(8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bC\u0010*R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020!0Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006b"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderViewImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/ProfileHeaderMenuPanelView;", "", "isVisible", "", "showItemsSearch", "(Z)V", "Lcom/avito/android/remote/model/ProfileInfo;", "info", "setProfileInfo", "(Lcom/avito/android/remote/model/ProfileInfo;)V", "isInitialized", "()Z", "", "unreadCount", "updateNotificationCounter", "(I)V", "reverse", "animateOrdersToParentWidth", "collapseSoaUpdateProgress", "()V", "hideTopCardContent", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "data", "setLeftCardContent", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;)V", "setLeftCardLoading", "setOrdersInfo", "setOrdersLoading", "setTopCardData", "", "text", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "onDismissClickTarget", "showLeftCardTooltip", "(Ljava/lang/String;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;)V", "showSoaUpdateProgress", "(Ljava/lang/String;)V", "showTopCardTooltip", "Lio/reactivex/Observable;", "getRightCardClicks", "()Lio/reactivex/Observable;", "rightCardClicks", g.a, "Z", "profileInfoIsSet", "i", "Lio/reactivex/Observable;", "getClicks", "clicks", "getTopCardClicks", "topCardClicks", "Landroid/view/View;", "j", "Landroid/view/View;", "view", "getSoaProgressCollapsedEvents", "soaProgressCollapsedEvents", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleTextView", "Lcom/avito/android/Features;", "k", "Lcom/avito/android/Features;", "features", "getLeftCardClicks", "leftCardClicks", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "profileButtonView", "Lcom/avito/android/lib/design/input/Input;", "f", "Lcom/avito/android/lib/design/input/Input;", "advertsSearch", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "Lcom/jakewharton/rxrelay2/PublishRelay;", "h", "Lcom/jakewharton/rxrelay2/PublishRelay;", "clicksRelay", "profileHeaderMenuPanelView", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "tabTestGroup", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/menu_panel/ProfileHeaderMenuPanelView;Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileHeaderViewImpl implements ProfileHeaderView, ProfileHeaderMenuPanelView {
    public final Resources a;
    public final Toolbar b;
    public final SimpleDraweeView c;
    public final TextView d;
    public final LinearLayout e;
    public final Input f;
    public boolean g;
    public final PublishRelay<ProfileHeaderView.ClickTarget> h;
    @NotNull
    public final Observable<ProfileHeaderView.ClickTarget> i;
    public final View j;
    public final Features k;
    public final /* synthetic */ ProfileHeaderMenuPanelView l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ProfileHeaderViewImpl a;

        public a(ProfileHeaderViewImpl profileHeaderViewImpl) {
            this.a = profileHeaderViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.h.accept(ProfileHeaderView.ClickTarget.Profile.INSTANCE);
        }
    }

    public static final class b implements View.OnFocusChangeListener {
        public final /* synthetic */ ProfileHeaderViewImpl a;

        public b(ProfileHeaderViewImpl profileHeaderViewImpl) {
            this.a = profileHeaderViewImpl;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            if (z) {
                this.a.h.accept(ProfileHeaderView.ClickTarget.Search.INSTANCE);
            }
        }
    }

    public ProfileHeaderViewImpl(@NotNull View view, @NotNull Features features, @NotNull ProfileHeaderMenuPanelView profileHeaderMenuPanelView, @NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(profileHeaderMenuPanelView, "profileHeaderMenuPanelView");
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "tabTestGroup");
        this.l = profileHeaderMenuPanelView;
        this.j = view;
        this.k = features;
        Intrinsics.checkNotNullExpressionValue(view.getContext(), "view.context");
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        this.a = resources;
        View findViewById = view.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById;
        this.b = toolbar;
        View findViewById2 = view.findViewById(R.id.avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.avatar)");
        this.c = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.title)");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.profile);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.profile)");
        LinearLayout linearLayout = (LinearLayout) findViewById4;
        this.e = linearLayout;
        View findViewById5 = view.findViewById(R.id.adverts_search);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.adverts_search)");
        this.f = (Input) findViewById5;
        PublishRelay<ProfileHeaderView.ClickTarget> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.h = create;
        toolbar.setNavigationIcon((Drawable) null);
        if (userAdvertsTabTestGroup.isTest()) {
            toolbar.setTitle(resources.getString(R.string.my_adverts_list_title));
            Views.hide(linearLayout);
            if (userAdvertsTabTestGroup.isToolbarAddAdvertButton()) {
                toolbar.inflateMenu(R.menu.user_adverts_menu_with_publish);
                toolbar.setOnMenuItemClickListener(new g0(0, this));
                Toolbars.tintMenuByAttr(toolbar, com.avito.android.lib.design.R.attr.blue);
            }
        } else {
            toolbar.setTitle((CharSequence) null);
            toolbar.inflateMenu(R.menu.user_adverts_menu);
            toolbar.setOnMenuItemClickListener(new g0(1, this));
        }
        linearLayout.setOnClickListener(new a(this));
        Observable<ProfileHeaderView.ClickTarget> mergeWith = create.mergeWith(profileHeaderMenuPanelView.getLeftCardClicks()).mergeWith(profileHeaderMenuPanelView.getTopCardClicks()).mergeWith(profileHeaderMenuPanelView.getRightCardClicks());
        Intrinsics.checkNotNullExpressionValue(mergeWith, "clicksRelay\n        .mer…anelView.rightCardClicks)");
        this.i = mergeWith;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    public void animateOrdersToParentWidth(boolean z) {
        this.l.animateOrdersToParentWidth(z);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void collapseSoaUpdateProgress() {
        this.l.collapseSoaUpdateProgress();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView
    @NotNull
    public Observable<ProfileHeaderView.ClickTarget> getClicks() {
        return this.i;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    @NotNull
    public Observable<ProfileHeaderView.ClickTarget> getLeftCardClicks() {
        return this.l.getLeftCardClicks();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersView
    @NotNull
    public Observable<ProfileHeaderView.ClickTarget> getRightCardClicks() {
        return this.l.getRightCardClicks();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    @NotNull
    public Observable<Unit> getSoaProgressCollapsedEvents() {
        return this.l.getSoaProgressCollapsedEvents();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    @NotNull
    public Observable<ProfileHeaderView.ClickTarget> getTopCardClicks() {
        return this.l.getTopCardClicks();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    public void hideTopCardContent() {
        this.l.hideTopCardContent();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView
    public boolean isInitialized() {
        return this.g;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void setLeftCardContent(@NotNull CardData cardData) {
        Intrinsics.checkNotNullParameter(cardData, "data");
        this.l.setLeftCardContent(cardData);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void setLeftCardLoading() {
        this.l.setLeftCardLoading();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersView
    public void setOrdersInfo(@NotNull CardData cardData) {
        Intrinsics.checkNotNullParameter(cardData, "info");
        this.l.setOrdersInfo(cardData);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.OrdersView
    public void setOrdersLoading() {
        this.l.setOrdersLoading();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView
    public void setProfileInfo(@NotNull ProfileInfo profileInfo) {
        Intrinsics.checkNotNullParameter(profileInfo, "info");
        if (profileInfo.getName() == null && profileInfo.getImage() == null) {
            Views.hide(this.e);
            this.b.setTitle(R.string.profile_title);
            this.g = false;
            return;
        }
        Views.show(this.e);
        SimplePicture simplePicture = null;
        this.b.setTitle((CharSequence) null);
        this.d.setText(profileInfo.getName());
        Context context = this.j.getContext();
        Drawable drawable = context.getDrawable(com.avito.android.deprecated_design.R.drawable.ic_user_32);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ((GenericDraweeHierarchy) this.c.getHierarchy()).setPlaceholderImage(Contexts.getTintedDrawable(drawable, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray12)), ScalingUtils.ScaleType.CENTER);
        String image = profileInfo.getImage();
        if (image != null) {
            Uri parse = Uri.parse(image);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(it)");
            simplePicture = new SimplePicture(parse);
        }
        SimpleDraweeViewsKt.loadPicture$default(this.c, simplePicture, null, null, 6, null);
        this.g = true;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    public void setTopCardData(@NotNull CardData cardData) {
        Intrinsics.checkNotNullParameter(cardData, "data");
        this.l.setTopCardData(cardData);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView
    public void showItemsSearch(boolean z) {
        Views.setVisible(this.f, z && this.k.getProfileItemsSearch().invoke().booleanValue());
        this.f.setFocusChangeListener(new b(this));
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void showLeftCardTooltip(@NotNull String str, @NotNull ProfileHeaderView.ClickTarget clickTarget) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(clickTarget, "onDismissClickTarget");
        this.l.showLeftCardTooltip(str, clickTarget);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.LeftCardView
    public void showSoaUpdateProgress(@Nullable String str) {
        this.l.showSoaUpdateProgress(str);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.ProfileHeaderMenuPanelView
    public void showTopCardTooltip(@NotNull String str, @NotNull ProfileHeaderView.ClickTarget clickTarget) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(clickTarget, "onDismissClickTarget");
        this.l.showTopCardTooltip(str, clickTarget);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView
    public void updateNotificationCounter(int i2) {
        MenuItem findItem;
        int i3;
        Menu menu = this.b.getMenu();
        if (menu != null && (findItem = menu.findItem(R.id.notification)) != null) {
            if (i2 == 0) {
                i3 = R.drawable.ic_ua_notifications_24;
            } else {
                i3 = R.drawable.ic_ua_notifications_red_24;
            }
            findItem.setIcon(i3);
        }
    }
}
