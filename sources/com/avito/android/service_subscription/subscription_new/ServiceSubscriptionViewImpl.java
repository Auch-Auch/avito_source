package com.avito.android.service_subscription.subscription_new;

import a2.a.a.p2.a.c;
import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.profile.DescriptionAttribute;
import com.avito.android.service_subscription.R;
import com.avito.android.service_subscription.subscription_new.PackageAttributeViewData;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.color.ContextsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.jakewharton.rxbinding3.appcompat.RxToolbar;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010P\u001a\u00020\n\u0012\u0006\u0010b\u001a\u00020a¢\u0006\u0004\bc\u0010dJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u0019\u0010\u0016\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u0011J\u000f\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b \u0010\u0011J\u0017\u0010#\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\u000f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\tH\u0016¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\u00020\u000f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020)0\tH\u0016¢\u0006\u0004\b*\u0010(J\u000f\u0010+\u001a\u00020\u000fH\u0016¢\u0006\u0004\b+\u0010\u001eJ\u000f\u0010,\u001a\u00020\u000fH\u0016¢\u0006\u0004\b,\u0010\u001eJ-\u0010/\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b/\u00100R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u00109R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000f0;8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R:\u0010C\u001a&\u0012\f\u0012\n @*\u0004\u0018\u00010\u000f0\u000f @*\u0012\u0012\f\u0012\n @*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010?0?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0;8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bD\u0010=R\u0016\u0010H\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR:\u0010N\u001a&\u0012\f\u0012\n @*\u0004\u0018\u00010\u000f0\u000f @*\u0012\u0012\f\u0012\n @*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010?0?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010BR\u0016\u0010P\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u00102R\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010SR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0;8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bW\u0010=R\u0016\u0010Z\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010SR\u0016\u0010\\\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010SR\u0016\u0010^\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010SR\u0016\u0010`\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010G¨\u0006e"}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionViewImpl;", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionView;", "Landroid/view/ViewGroup;", "container", "monsterLayout", "Landroid/view/LayoutInflater;", "inflater", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Details;", "attribute", "", "Landroid/view/View;", AuthSource.SEND_ABUSE, "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Landroid/view/LayoutInflater;Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData$Monster$Details;)Ljava/util/List;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "setPackagesTitle", "error", "showLoadingError", "showActionError", "setSubscriptionTitle", MessengerShareContentUtility.SUBTITLE, "setSubscriptionSubtitle", "actionName", "initActionButton", "text", "showSnackbar", "showDivider", "()V", "footer", "setFooter", "", "isEnabled", "setActionEnabled", "(Z)V", "Lcom/avito/android/remote/model/profile/DescriptionAttribute;", Navigation.ATTRIBUTES, "setAttributes", "(Ljava/util/List;)V", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData;", "setPackageAttributes", "showProgress", "hideProgress", "Lcom/avito/android/remote/model/UniversalColor;", "color", "showBanner", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;)V", "c", "Landroid/view/View;", "divider", "Lru/avito/component/button/ButtonImpl;", "j", "Lru/avito/component/button/ButtonImpl;", "action", "Landroidx/appcompat/widget/Toolbar;", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lio/reactivex/Observable;", "getSubscriptionActionClicks", "()Lio/reactivex/Observable;", "subscriptionActionClicks", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "l", "Lcom/jakewharton/rxrelay2/PublishRelay;", "actionCLickEvents", "getRefreshClicks", "refreshClicks", "i", "Landroid/view/ViewGroup;", "packageAttributesContainer", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "k", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", AuthSource.OPEN_CHANNEL_LIST, "refreshEvents", "n", "rootView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "subscriptionSubtitle", g.a, "packagesTitle", "getNavigationClicks", "navigationClicks", "d", "subscriptionTitle", "h", "footerView", AuthSource.BOOKING_ORDER, "toolbarTitle", "f", "attributesContainer", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceSubscriptionViewImpl implements ServiceSubscriptionView {
    public final Toolbar a;
    public final TextView b;
    public final View c;
    public final TextView d;
    public final TextView e;
    public final ViewGroup f;
    public final TextView g;
    public final TextView h;
    public final ViewGroup i;
    public final ButtonImpl j;
    public final ProgressOverlay k;
    public final PublishRelay<Unit> l = PublishRelay.create();
    public final PublishRelay<Unit> m = PublishRelay.create();
    public final View n;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ServiceSubscriptionViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ServiceSubscriptionViewImpl serviceSubscriptionViewImpl) {
            super(0);
            this.a = serviceSubscriptionViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.m;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ServiceSubscriptionViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ServiceSubscriptionViewImpl serviceSubscriptionViewImpl) {
            super(0);
            this.a = serviceSubscriptionViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.l;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public ServiceSubscriptionViewImpl(@NotNull View view, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.n = view;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        View findViewById2 = view.findViewById(R.id.toolbar_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.divider);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.service_subscription_title);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.service_subscription_subtitle);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.service_subscription_attributes);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f = (ViewGroup) findViewById6;
        View findViewById7 = view.findViewById(R.id.service_subscription_packages_title);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.footer);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.h = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.service_subscription_packages_attributes);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.ViewGroup");
        this.i = (ViewGroup) findViewById9;
        View findViewById10 = view.findViewById(R.id.action);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.View");
        this.j = new ButtonImpl(findViewById10);
        View findViewById11 = view.findViewById(R.id.content);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById11, R.id.scroll_view, analytics, false, 0, 24, null);
        this.k = progressOverlay;
        toolbar.setNavigationIcon(toolbar.getContext().getDrawable(com.avito.android.ui_components.R.drawable.ic_back_24));
        progressOverlay.setOnRefreshListener(new a(this));
    }

    public static final void access$animateMonsterPackageExpansion(ServiceSubscriptionViewImpl serviceSubscriptionViewImpl, View view, List list, List list2) {
        Objects.requireNonNull(serviceSubscriptionViewImpl);
        view.addOnLayoutChangeListener(new ServiceSubscriptionViewImpl$animateMonsterPackageExpansion$$inlined$runOnNextLayoutChange$1(view, serviceSubscriptionViewImpl, list, list2, view));
    }

    public final List<View> a(ViewGroup viewGroup, ViewGroup viewGroup2, LayoutInflater layoutInflater, PackageAttributeViewData.Monster.Details details) {
        View inflate = layoutInflater.inflate(R.layout.subscription_monster_subcategories_container, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup3 = (ViewGroup) inflate;
        viewGroup3.setAlpha(0.0f);
        for (T t : details.getSubcategories()) {
            View inflate2 = layoutInflater.inflate(R.layout.subscription_monster_subcategory, viewGroup, false);
            View findViewById = inflate2.findViewById(R.id.subcategory);
            Intrinsics.checkNotNullExpressionValue(findViewById, "subcategoryView.findView…xtView>(R.id.subcategory)");
            TextViews.bindText$default((TextView) findViewById, t.getTitle(), false, 2, null);
            View findViewById2 = inflate2.findViewById(R.id.microcategories);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "subcategoryView.findView…ew>(R.id.microcategories)");
            TextViews.bindText$default((TextView) findViewById2, t.getMicrocategories(), false, 2, null);
            viewGroup3.addView(inflate2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(viewGroup3.getLayoutParams());
        layoutParams.addRule(3, R.id.title);
        viewGroup3.setLayoutParams(layoutParams);
        viewGroup2.addView(viewGroup3);
        View inflate3 = layoutInflater.inflate(R.layout.subscription_monster_locations_container, viewGroup, false);
        Objects.requireNonNull(inflate3, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup4 = (ViewGroup) inflate3;
        viewGroup4.setAlpha(0.0f);
        Iterator<T> it = details.getLocations().iterator();
        while (it.hasNext()) {
            View inflate4 = layoutInflater.inflate(R.layout.subscription_monster_location, viewGroup, false);
            View findViewById3 = inflate4.findViewById(R.id.location);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "locationsView.findViewBy…<TextView>(R.id.location)");
            TextViews.bindText$default((TextView) findViewById3, it.next(), false, 2, null);
            viewGroup4.addView(inflate4);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(viewGroup4.getLayoutParams());
        layoutParams2.addRule(3, viewGroup3.getId());
        viewGroup4.setLayoutParams(layoutParams2);
        viewGroup2.addView(viewGroup4);
        return CollectionsKt__CollectionsKt.listOf((Object[]) new ViewGroup[]{viewGroup3, viewGroup4});
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return RxToolbar.navigationClicks(this.a);
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    @NotNull
    public Observable<Unit> getRefreshClicks() {
        PublishRelay<Unit> publishRelay = this.m;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "refreshEvents");
        return publishRelay;
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    @NotNull
    public Observable<Unit> getSubscriptionActionClicks() {
        PublishRelay<Unit> publishRelay = this.l;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "actionCLickEvents");
        return publishRelay;
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void hideProgress() {
        this.k.showContent();
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void initActionButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "actionName");
        this.j.setVisible(true);
        this.j.setText(str);
        this.j.setClickListener(new b(this));
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void setActionEnabled(boolean z) {
        if (z) {
            this.j.setEnabled(true);
        } else {
            this.j.setEnabled(false);
        }
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void setAttributes(@NotNull List<DescriptionAttribute> list) {
        Intrinsics.checkNotNullParameter(list, Navigation.ATTRIBUTES);
        ViewGroup viewGroup = this.f;
        int i2 = R.layout.subscription_details_attribute_item;
        Views.show(viewGroup);
        viewGroup.removeAllViews();
        LayoutInflater from = LayoutInflater.from(this.n.getContext());
        for (T t : list) {
            View inflate = from.inflate(i2, viewGroup, false);
            View findViewById = inflate.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "(attributeView.findViewById<TextView>(R.id.title))");
            ((TextView) findViewById).setText(t.getTitle());
            View findViewById2 = inflate.findViewById(R.id.value);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "(attributeView.findViewById<TextView>(R.id.value))");
            ((TextView) findViewById2).setText(t.getValue());
            viewGroup.addView(inflate);
        }
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void setFooter(@Nullable String str) {
        TextViews.bindText$default(this.h, str, false, 2, null);
        if (str != null) {
            Views.show(this.c);
        }
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void setPackageAttributes(@NotNull List<? extends PackageAttributeViewData> list) {
        ServiceSubscriptionViewImpl serviceSubscriptionViewImpl = this;
        Intrinsics.checkNotNullParameter(list, Navigation.ATTRIBUTES);
        ViewGroup viewGroup = serviceSubscriptionViewImpl.i;
        int i2 = R.layout.subscription_regular_package_attribute_item;
        int i3 = R.layout.subscription_monster_package_attribute_item;
        Views.show(viewGroup);
        viewGroup.removeAllViews();
        LayoutInflater from = LayoutInflater.from(serviceSubscriptionViewImpl.n.getContext());
        for (T t : list) {
            if (t instanceof PackageAttributeViewData.Regular) {
                View inflate = from.inflate(i2, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "attributeView");
                T t2 = t;
                View findViewById = inflate.findViewById(R.id.title);
                Intrinsics.checkNotNullExpressionValue(findViewById, "attributeView.findViewById<TextView>(R.id.title)");
                TextViews.bindText$default((TextView) findViewById, t2.getTitle(), false, 2, null);
                View findViewById2 = inflate.findViewById(R.id.category);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "attributeView.findViewBy…<TextView>(R.id.category)");
                TextViews.bindText$default((TextView) findViewById2, t2.getSubtitle(), false, 2, null);
                View findViewById3 = inflate.findViewById(R.id.description);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "attributeView.findViewBy…xtView>(R.id.description)");
                TextViews.bindText$default((TextView) findViewById3, t2.getDescription(), false, 2, null);
                View findViewById4 = inflate.findViewById(R.id.count);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "attributeView.findViewById<TextView>(R.id.count)");
                TextViews.bindText$default((TextView) findViewById4, t2.getCount(), false, 2, null);
                View findViewById5 = inflate.findViewById(R.id.expiration);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "attributeView.findViewBy…extView>(R.id.expiration)");
                TextViews.bindText$default((TextView) findViewById5, t2.getExpiration(), false, 2, null);
                viewGroup.addView(inflate);
            } else if (t instanceof PackageAttributeViewData.Monster) {
                View inflate2 = from.inflate(i3, viewGroup, false);
                Objects.requireNonNull(inflate2, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup2 = (ViewGroup) inflate2;
                T t3 = t;
                Intrinsics.checkNotNullExpressionValue(from, "inflater");
                View findViewById6 = viewGroup2.findViewById(R.id.title);
                Intrinsics.checkNotNullExpressionValue(findViewById6, "attributeView.findViewById<TextView>(R.id.title)");
                TextViews.bindText$default((TextView) findViewById6, t3.getTitle(), false, 2, null);
                View findViewById7 = viewGroup2.findViewById(R.id.count);
                Intrinsics.checkNotNullExpressionValue(findViewById7, "attributeView.findViewById<TextView>(R.id.count)");
                TextViews.bindText$default((TextView) findViewById7, t3.getCount(), false, 2, null);
                TextView textView = (TextView) viewGroup2.findViewById(R.id.subcategories);
                TextView textView2 = (TextView) viewGroup2.findViewById(R.id.locations);
                TextView textView3 = (TextView) viewGroup2.findViewById(R.id.expand);
                Intrinsics.checkNotNullExpressionValue(textView, "categoriesView");
                Intrinsics.checkNotNullExpressionValue(textView2, "locationsView");
                Intrinsics.checkNotNullExpressionValue(textView3, "expandView");
                List<View> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{textView, textView2, textView3});
                if (t3.isExpanded()) {
                    Iterator<T> it = serviceSubscriptionViewImpl.a(viewGroup, viewGroup2, from, t3.getDetails()).iterator();
                    while (it.hasNext()) {
                        it.next().setAlpha(1.0f);
                    }
                    for (View view : listOf) {
                        Views.hide(view);
                    }
                    Views.disable(textView3);
                } else {
                    TextViews.bindText$default(textView, t3.getSummary().getSubcategories(), false, 2, null);
                    TextViews.bindText$default(textView2, t3.getSummary().getLocations(), false, 2, null);
                    textView3.setOnClickListener(new c(this, t3, textView3, viewGroup, viewGroup2, from, listOf));
                }
                viewGroup.addView(viewGroup2);
            }
            serviceSubscriptionViewImpl = this;
        }
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void setPackagesTitle(@Nullable String str) {
        TextViews.bindText$default(this.g, str, false, 2, null);
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void setSubscriptionSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.e, str, false, 2, null);
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void setSubscriptionTitle(@Nullable String str) {
        TextViews.bindText$default(this.d, str, false, 2, null);
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.b, str, false, 2, null);
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void showActionError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        showSnackbar(str);
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void showBanner(@Nullable String str, @Nullable String str2, @Nullable UniversalColor universalColor) {
        View findViewById = this.n.findViewById(R.id.banner_root);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        Views.show(viewGroup);
        Drawable drawable = this.n.getContext().getDrawable(R.drawable.bg_subscription_banner);
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        if (universalColor != null) {
            Context context = this.n.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            gradientDrawable.setColor(ContextsKt.getColorFrom(context, universalColor));
        }
        Views.setBackgroundCompat(viewGroup, gradientDrawable);
        View findViewById2 = this.n.findViewById(R.id.banner_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextViews.bindText((TextView) findViewById2, str, true);
        View findViewById3 = this.n.findViewById(R.id.banner_text);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextViews.bindText((TextView) findViewById3, str2, true);
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void showDivider() {
        Views.show(this.c);
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void showLoadingError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.k.showLoadingProblem(str);
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void showProgress() {
        this.k.showLoading();
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Views.showSnackBar$default(this.n, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
