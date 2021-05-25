package com.avito.android.soa_stat.profile_settings;

import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.analytics.Analytics;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.soa_stat.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001+\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010\u001dR\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R:\u00109\u001a&\u0012\f\u0012\n 6*\u0004\u0018\u00010\u00150\u0015 6*\u0012\u0012\f\u0012\n 6*\u0004\u0018\u00010\u00150\u0015\u0018\u000105058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010\u0017\u001a\u0004\b;\u0010\u0019¨\u0006C"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewImpl;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsView;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", "data", "", "showContent", "(Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;)V", "showLoading", "()V", "showError", "", "textResId", "showSnackBar", "(I)V", "Landroidx/appcompat/widget/Toolbar;", "h", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lio/reactivex/Observable;", "", "j", "Lio/reactivex/Observable;", "getSwitchObserver", "()Lio/reactivex/Observable;", "switchObserver", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "titleTextView", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "contentHolderView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.SEND_ABUSE, "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "com/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewImpl$listener$1", "k", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewImpl$listener$1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "c", "bodyTextView", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "d", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "switchView", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", g.a, "Lcom/jakewharton/rxrelay2/PublishRelay;", "switchValueChangesStream", "i", "getOnRefreshObserver", "onRefreshObserver", "Landroid/view/View;", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;)V", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
public final class SoaStatProfileSettingsViewImpl implements SoaStatProfileSettingsView {
    public final SimpleDraweeView a;
    public final TextView b;
    public final TextView c;
    public final SwitcherListItem d;
    public final ViewGroup e;
    public final ProgressOverlay f;
    public final PublishRelay<Boolean> g;
    @NotNull
    public final Toolbar h;
    @NotNull
    public final Observable<Unit> i;
    @NotNull
    public final Observable<Boolean> j;
    public final SoaStatProfileSettingsViewImpl$listener$1 k = new SoaStatProfileSettingsViewImpl$listener$1(this);

    public SoaStatProfileSettingsViewImpl(@NotNull View view, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        View findViewById = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.image)");
        this.a = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.text)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.switcher);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.switcher)");
        this.d = (SwitcherListItem) findViewById4;
        View findViewById5 = view.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.content_holder)");
        ViewGroup viewGroup = (ViewGroup) findViewById5;
        this.e = viewGroup;
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, R.id.content, analytics, false, 0, 24, null);
        this.f = progressOverlay;
        PublishRelay<Boolean> create = PublishRelay.create();
        this.g = create;
        View findViewById6 = view.findViewById(com.avito.android.ui_components.R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(ui_R.id.toolbar)");
        this.h = (Toolbar) findViewById6;
        this.i = progressOverlay.refreshes();
        Intrinsics.checkNotNullExpressionValue(create, "switchValueChangesStream");
        this.j = create;
    }

    @Override // com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsView
    @NotNull
    public Observable<Unit> getOnRefreshObserver() {
        return this.i;
    }

    @Override // com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsView
    @NotNull
    public Observable<Boolean> getSwitchObserver() {
        return this.j;
    }

    @Override // com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsView
    @NotNull
    public Toolbar getToolbar() {
        return this.h;
    }

    @Override // com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsView
    public void showContent(@NotNull SoaStatSettingsPageData soaStatSettingsPageData) {
        Intrinsics.checkNotNullParameter(soaStatSettingsPageData, "data");
        if (soaStatSettingsPageData.getImage() != null) {
            SimpleDraweeViewsKt.getRequestBuilder(this.a).picture(AvitoPictureKt.pictureOf$default(soaStatSettingsPageData.getImage(), false, 0.0f, 0.0f, null, 28, null)).load();
        }
        if (soaStatSettingsPageData.getTitle() != null) {
            this.b.setText(soaStatSettingsPageData.getTitle());
            this.d.setTitle(soaStatSettingsPageData.getTitle());
        }
        if (soaStatSettingsPageData.getText() != null) {
            this.c.setText(soaStatSettingsPageData.getText());
        }
        this.d.removeOnCheckedChangeListener(this.k);
        Boolean switcherValue = soaStatSettingsPageData.getSwitcherValue();
        if (switcherValue != null) {
            switcherValue.booleanValue();
            this.d.setChecked(soaStatSettingsPageData.getSwitcherValue().booleanValue());
        }
        this.d.addOnCheckedChangeListener(this.k);
        this.d.setEnabled(soaStatSettingsPageData.getSwitcherEnabled());
        this.f.showContent();
    }

    @Override // com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsView
    public void showError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.f, null, 1, null);
    }

    @Override // com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsView
    public void showLoading() {
        this.f.showLoading();
    }

    @Override // com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsView
    public void showSnackBar(int i2) {
        Views.showSnackBar$default(this.e, i2, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
    }
}
