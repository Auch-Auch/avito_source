package com.avito.android.delivery.profile_settings;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.delivery.R;
import com.avito.android.delivery.di.component.DaggerDeliveryProfileSettingsComponent;
import com.avito.android.delivery.di.component.DeliveryDependencies;
import com.avito.android.delivery.di.module.DeliveryProfileSettingsModule;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsView;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.text.AttributedTextFormatter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b5\u0010\rJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsView$Listener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "value", "onSwitchToggleChanges", "(Z)V", "onCloseClicked", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;", "viewModel", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;", "getViewModel", "()Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;", "setViewModel", "(Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "getTracker", "()Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "setTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryProfileSettingsActivity extends BaseActivity implements DeliveryProfileSettingsView.Listener {
    @Inject
    public Analytics analytics;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public BaseScreenPerformanceTracker tracker;
    @Inject
    public DeliveryProfileSettingsViewModel viewModel;

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final BaseScreenPerformanceTracker getTracker() {
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return baseScreenPerformanceTracker;
    }

    @NotNull
    public final DeliveryProfileSettingsViewModel getViewModel() {
        DeliveryProfileSettingsViewModel deliveryProfileSettingsViewModel = this.viewModel;
        if (deliveryProfileSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryProfileSettingsViewModel;
    }

    @Override // com.avito.android.delivery.profile_settings.DeliveryProfileSettingsView.Listener
    public void onCloseClicked() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Timer B1 = a.B1();
        DaggerDeliveryProfileSettingsComponent.builder().deliveryDependencies((DeliveryDependencies) ComponentDependenciesKt.getDependencies(DeliveryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).deliveryProfileSettingsModule(new DeliveryProfileSettingsModule(this)).build().inject(this);
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.trackDiInject(B1.elapsed());
        BaseScreenPerformanceTracker baseScreenPerformanceTracker2 = this.tracker;
        if (baseScreenPerformanceTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker2.startInit();
        View inflate = LayoutInflater.from(this).inflate(R.layout.delivery_profile_settings, (ViewGroup) null, false);
        setContentView(inflate);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "inflatedView");
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        DeliveryProfileSettingsViewImpl deliveryProfileSettingsViewImpl = new DeliveryProfileSettingsViewImpl(analytics2, inflate, this, this, attributedTextFormatter2);
        DeliveryProfileSettingsViewModel deliveryProfileSettingsViewModel = this.viewModel;
        if (deliveryProfileSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryProfileSettingsViewImpl.bindTo(deliveryProfileSettingsViewModel);
        BaseScreenPerformanceTracker baseScreenPerformanceTracker3 = this.tracker;
        if (baseScreenPerformanceTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker3.trackInit();
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override // com.avito.android.delivery.profile_settings.DeliveryProfileSettingsView.Listener
    public void onSwitchToggleChanges(boolean z) {
        DeliveryProfileSettingsViewModel deliveryProfileSettingsViewModel = this.viewModel;
        if (deliveryProfileSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryProfileSettingsViewModel.deliveryToggleUserDefault(z);
        setResult(-1);
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setTracker(@NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "<set-?>");
        this.tracker = baseScreenPerformanceTracker;
    }

    public final void setViewModel(@NotNull DeliveryProfileSettingsViewModel deliveryProfileSettingsViewModel) {
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsViewModel, "<set-?>");
        this.viewModel = deliveryProfileSettingsViewModel;
    }
}
