package com.avito.android.delivery.profile_settings;

import a2.a.a.k0.c.a;
import a2.a.a.k0.c.b;
import a2.a.a.k0.c.c;
import a2.a.a.k0.c.d;
import a2.a.a.k0.c.e;
import a2.a.a.k0.c.f;
import a2.g.r.g;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.analytics.Analytics;
import com.avito.android.component.switch_list_element.SwitchListElementImpl;
import com.avito.android.delivery.R;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettings;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsView;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\n \b*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001f\u001a\n \b*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010!\u001a\n \b*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u00101\u001a\n \b*\u0004\u0018\u00010.0.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00066"}, d2 = {"Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewImpl;", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsView;", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;)V", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/component/switch_list_element/SwitchListElementImpl;", g.a, "Lcom/avito/android/component/switch_list_element/SwitchListElementImpl;", "toggle", "Lcom/facebook/drawee/view/SimpleDraweeView;", "d", "Lcom/facebook/drawee/view/SimpleDraweeView;", "image", "Lcom/avito/android/util/text/AttributedTextFormatter;", "k", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "disclaimer", "e", "text", "Landroidx/lifecycle/LifecycleOwner;", "i", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/view/View;", "h", "Landroid/view/View;", "view", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsView$Listener;", "j", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Landroid/view/View;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsView$Listener;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryProfileSettingsViewImpl implements DeliveryProfileSettingsView {
    public final Context a;
    public final Toolbar b;
    public final ProgressOverlay c;
    public final SimpleDraweeView d;
    public final TextView e;
    public final TextView f;
    public final SwitchListElementImpl g;
    public final View h;
    public final LifecycleOwner i;
    public final DeliveryProfileSettingsView.Listener j;
    public final AttributedTextFormatter k;

    public DeliveryProfileSettingsViewImpl(@NotNull Analytics analytics, @NotNull View view, @NotNull LifecycleOwner lifecycleOwner, @NotNull DeliveryProfileSettingsView.Listener listener, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.h = view;
        this.i = lifecycleOwner;
        this.j = listener;
        this.k = attributedTextFormatter;
        Context context = view.getContext();
        this.a = context;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.b = toolbar;
        View findViewById = view.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.content_holder)");
        this.c = new ProgressOverlay((ViewGroup) findViewById, R.id.content, analytics, false, 0, 24, null);
        this.d = (SimpleDraweeView) view.findViewById(R.id.image);
        this.e = (TextView) view.findViewById(R.id.text);
        this.f = (TextView) view.findViewById(R.id.disclaimer);
        this.g = new SwitchListElementImpl(view);
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setTitle(context.getString(R.string.delivery_profile_settings));
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24_blue);
        toolbar.setNavigationOnClickListener(new f(this));
    }

    public static final void access$dataChanged(DeliveryProfileSettingsViewImpl deliveryProfileSettingsViewImpl, DeliveryProfileSettings deliveryProfileSettings) {
        Objects.requireNonNull(deliveryProfileSettingsViewImpl);
        DeliveryProfileSettings.Body body = deliveryProfileSettings.getBody();
        SimpleDraweeView simpleDraweeView = deliveryProfileSettingsViewImpl.d;
        Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "image");
        SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).picture(AvitoPictureKt.pictureOf$default(body.getImage(), false, 0.0f, 0.0f, null, 28, null)).load();
        TextView textView = deliveryProfileSettingsViewImpl.e;
        Intrinsics.checkNotNullExpressionValue(textView, "text");
        AttributedText text = body.getText();
        CharSequence charSequence = null;
        textView.setText(text != null ? deliveryProfileSettingsViewImpl.k.formatIgnoreColors(text) : null);
        DeliveryProfileSettings.Switch r0 = deliveryProfileSettings.getSwitch();
        deliveryProfileSettingsViewImpl.g.setTitle(r0.getTitle());
        boolean value = r0.getValue();
        SwitchListElementImpl switchListElementImpl = deliveryProfileSettingsViewImpl.g;
        switchListElementImpl.setCheckedChangeListener(e.a);
        switchListElementImpl.setChecked(value, false);
        switchListElementImpl.setCheckedChangeListener(new d(deliveryProfileSettingsViewImpl, value));
        AttributedText disclaimer = deliveryProfileSettings.getDisclaimer();
        TextView textView2 = deliveryProfileSettingsViewImpl.f;
        Intrinsics.checkNotNullExpressionValue(textView2, "disclaimer");
        if (disclaimer != null) {
            disclaimer.setOnDeepLinkClickListener(deliveryProfileSettingsViewImpl.j);
            charSequence = deliveryProfileSettingsViewImpl.k.formatIgnoreColors(disclaimer);
        }
        textView2.setText(charSequence);
        TextView textView3 = deliveryProfileSettingsViewImpl.f;
        Intrinsics.checkNotNullExpressionValue(textView3, "disclaimer");
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final void access$setToggleValue(DeliveryProfileSettingsViewImpl deliveryProfileSettingsViewImpl, boolean z) {
        SwitchListElementImpl switchListElementImpl = deliveryProfileSettingsViewImpl.g;
        switchListElementImpl.setCheckedChangeListener(e.a);
        switchListElementImpl.setChecked(z, false);
        switchListElementImpl.setCheckedChangeListener(new d(deliveryProfileSettingsViewImpl, z));
    }

    @Override // com.avito.android.delivery.profile_settings.DeliveryProfileSettingsView
    public void bindTo(@NotNull DeliveryProfileSettingsViewModel deliveryProfileSettingsViewModel) {
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsViewModel, "viewModel");
        deliveryProfileSettingsViewModel.getProgressChanges().observe(this.i, new b(this));
        deliveryProfileSettingsViewModel.getSwitchProgressChanges().observe(this.i, new c(this));
        deliveryProfileSettingsViewModel.getDataChanges().observe(this.i, new a(this));
    }
}
