package com.avito.android.profile.tfa.settings;

import a2.a.a.b2.i1.a.e;
import a2.g.r.g;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.HelpCenterUrlShowLink;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.profile.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import ru.avito.component.appbar.AppBar;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001e\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fR\u001e\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0018RD\u00101\u001a0\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00020\u0002 \u0010*\u0017\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00020\u0002\u0018\u00010-¢\u0006\u0002\b.0-¢\u0006\u0002\b.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\"\u00105\u001a\b\u0012\u0004\u0012\u0002020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018R\u0016\u00109\u001a\u0002068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006B"}, d2 = {"Lcom/avito/android/profile/tfa/settings/TfaSettingsViewImpl;", "Lcom/avito/android/profile/tfa/settings/TfaSettingsView;", "", "isEnabled", "", "setToggleEnabled", "(Z)V", "isChecked", "showToggleChecked", "", "warning", "bindWarning", "(Ljava/lang/String;)V", "message", "showSnackbar", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lio/reactivex/rxjava3/core/Observable;", "h", "Lio/reactivex/rxjava3/core/Observable;", "getNavigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "description", "com/avito/android/profile/tfa/settings/TfaSettingsViewImpl$listener$1", g.a, "Lcom/avito/android/profile/tfa/settings/TfaSettingsViewImpl$listener$1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View;", "k", "Landroid/view/View;", "rootView", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "d", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "banner", "i", "getSwitcherChanges", "switcherChanges", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "switcherChangesRelay", "Lcom/avito/android/deep_linking/links/DeepLink;", "j", "getLinkClicks", "linkClicks", "Lcom/avito/android/remote/model/text/AttributedText;", "f", "Lcom/avito/android/remote/model/text/AttributedText;", "descriptionText", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "switcher", "Lru/avito/component/appbar/AppBar;", "appBar", "<init>", "(Landroid/view/View;Lru/avito/component/appbar/AppBar;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class TfaSettingsViewImpl implements TfaSettingsView {
    public final Context a;
    public final SwitcherListItem b;
    public final TextView c;
    public final AlertBanner d;
    public final PublishRelay<Boolean> e;
    public AttributedText f;
    public final TfaSettingsViewImpl$listener$1 g;
    @NotNull
    public final Observable<Unit> h;
    @NotNull
    public final Observable<Boolean> i;
    @NotNull
    public final Observable<DeepLink> j;
    public final View k;

    public TfaSettingsViewImpl(@NotNull View view, @NotNull AppBar appBar) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(appBar, "appBar");
        this.k = view;
        Context context = view.getContext();
        this.a = context;
        View findViewById = view.findViewById(R.id.switcher);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.switcher)");
        SwitcherListItem switcherListItem = (SwitcherListItem) findViewById;
        this.b = switcherListItem;
        View findViewById2 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.description)");
        TextView textView = (TextView) findViewById2;
        this.c = textView;
        View findViewById3 = view.findViewById(R.id.banner);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.banner)");
        this.d = (AlertBanner) findViewById3;
        PublishRelay<Boolean> create = PublishRelay.create();
        this.e = create;
        TfaSettingsViewImpl$listener$1 tfaSettingsViewImpl$listener$1 = new TfaSettingsViewImpl$listener$1(this);
        this.g = tfaSettingsViewImpl$listener$1;
        AppBar.DefaultImpls.setNavigationIcon$default(appBar, com.avito.android.ui_components.R.drawable.ic_back_24_black, null, 2, null);
        appBar.setTitle(R.string.tfa_settings_title);
        switcherListItem.addOnCheckedChangeListener(tfaSettingsViewImpl$listener$1);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String string = context.getString(R.string.tfa_settings_description_link);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ettings_description_link)");
        List listOf = d.listOf(new DeepLinkAttribute(ErrorBundle.DETAIL_ENTRY, string, new HelpCenterUrlShowLink("articles/1567"), null, null, 24, null));
        String string2 = context.getString(R.string.tfa_settings_description);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…tfa_settings_description)");
        this.f = new AttributedText(string2, listOf);
        textView.post(new e(this));
        this.h = appBar.navigationCallbacks();
        Intrinsics.checkNotNullExpressionValue(create, "switcherChangesRelay");
        this.i = create;
        AttributedText attributedText = this.f;
        if (attributedText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionText");
        }
        this.j = InteropKt.toV3(attributedText.linkClicks());
    }

    public static final /* synthetic */ AttributedText access$getDescriptionText$p(TfaSettingsViewImpl tfaSettingsViewImpl) {
        AttributedText attributedText = tfaSettingsViewImpl.f;
        if (attributedText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionText");
        }
        return attributedText;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsView
    public void bindWarning(@Nullable String str) {
        if (str == null || str.length() == 0) {
            Views.hide(this.d);
            return;
        }
        Views.show(this.d);
        this.d.getContent().setBody(str);
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsView
    @NotNull
    public Observable<DeepLink> getLinkClicks() {
        return this.j;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return this.h;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsView
    @NotNull
    public Observable<Boolean> getSwitcherChanges() {
        return this.i;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsView
    public void setToggleEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        SnackbarExtensionsKt.showSnackbar$default(this.k, str, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 254, (Object) null);
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsView
    public void showToggleChecked(boolean z) {
        this.b.removeOnCheckedChangeListener(this.g);
        this.b.setChecked(z);
        this.b.addOnCheckedChangeListener(this.g);
    }
}
