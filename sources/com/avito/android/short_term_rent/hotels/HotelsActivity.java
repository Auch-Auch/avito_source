package com.avito.android.short_term_rent.hotels;

import a2.a.a.v2.b.b;
import a2.a.a.v2.b.c;
import a2.a.a.v2.b.d;
import a2.a.a.v2.b.e;
import a2.a.a.v2.b.f;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.di.component.DaggerHotelsComponent;
import com.avito.android.short_term_rent.di.component.HotelsDependencies;
import com.avito.android.short_term_rent.hotels.HotelsViewModel;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog;
import com.avito.android.short_term_rent.hotels.dialogs.guests.HotelsGuestsDialog;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialog;
import com.avito.android.ui.activity.BaseActivity;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b9\u0010:J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsCalendarDialog;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsCalendarDialog;", "datesDialog", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel;", "k", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel;", "viewModel", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialog;", "l", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialog;", "locationDialog", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModelFactory;", "viewModelFactory", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/short_term_rent/hotels/HotelsViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/short_term_rent/hotels/HotelsViewModelFactory;)V", "Lcom/avito/android/short_term_rent/hotels/dialogs/guests/HotelsGuestsDialog;", "n", "Lcom/avito/android/short_term_rent/hotels/dialogs/guests/HotelsGuestsDialog;", "guestsDialog", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "()V", "Factory", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsActivity extends BaseActivity {
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    public HotelsViewModel k;
    public HotelsLocationDialog l;
    public HotelsCalendarDialog m;
    public HotelsGuestsDialog n;
    @Inject
    public HotelsViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsActivity$Factory;", "", "Landroid/content/Context;", "context", "", "marker", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent createIntent(@NotNull Context context, @Nullable String str) {
            Intent X0 = a2.b.a.a.a.X0(context, "context", context, HotelsActivity.class);
            if (str != null) {
                X0.putExtra("marker", str);
            }
            return X0;
        }
    }

    public static final class a<T> implements Observer<HotelsViewModel.RoutingAction> {
        public final /* synthetic */ HotelsActivity a;

        public a(HotelsActivity hotelsActivity) {
            this.a = hotelsActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(HotelsViewModel.RoutingAction routingAction) {
            HotelsViewModel.RoutingAction routingAction2 = routingAction;
            HotelsActivity hotelsActivity = this.a;
            Intrinsics.checkNotNullExpressionValue(routingAction2, "it");
            HotelsActivity.access$handleRoutingAction(hotelsActivity, routingAction2);
        }
    }

    public static final /* synthetic */ HotelsCalendarDialog access$getDatesDialog$p(HotelsActivity hotelsActivity) {
        HotelsCalendarDialog hotelsCalendarDialog = hotelsActivity.m;
        if (hotelsCalendarDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("datesDialog");
        }
        return hotelsCalendarDialog;
    }

    public static final /* synthetic */ HotelsGuestsDialog access$getGuestsDialog$p(HotelsActivity hotelsActivity) {
        HotelsGuestsDialog hotelsGuestsDialog = hotelsActivity.n;
        if (hotelsGuestsDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guestsDialog");
        }
        return hotelsGuestsDialog;
    }

    public static final /* synthetic */ HotelsLocationDialog access$getLocationDialog$p(HotelsActivity hotelsActivity) {
        HotelsLocationDialog hotelsLocationDialog = hotelsActivity.l;
        if (hotelsLocationDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationDialog");
        }
        return hotelsLocationDialog;
    }

    public static final /* synthetic */ HotelsViewModel access$getViewModel$p(HotelsActivity hotelsActivity) {
        HotelsViewModel hotelsViewModel = hotelsActivity.k;
        if (hotelsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return hotelsViewModel;
    }

    public static final void access$handleRoutingAction(HotelsActivity hotelsActivity, HotelsViewModel.RoutingAction routingAction) {
        Objects.requireNonNull(hotelsActivity);
        if (routingAction instanceof HotelsViewModel.RoutingAction.Back) {
            hotelsActivity.finish();
        } else if (routingAction instanceof HotelsViewModel.RoutingAction.OpenCalendar) {
            HotelsViewModel.RoutingAction.OpenCalendar openCalendar = (HotelsViewModel.RoutingAction.OpenCalendar) routingAction;
            HotelsCalendarDialog hotelsCalendarDialog = new HotelsCalendarDialog(hotelsActivity, new a2.a.a.v2.b.a(hotelsActivity), new b(hotelsActivity), openCalendar.getSelected(), openCalendar.getRestrictions(), null);
            hotelsActivity.m = hotelsCalendarDialog;
            hotelsCalendarDialog.show();
        } else if (routingAction instanceof HotelsViewModel.RoutingAction.OpenLocationDialog) {
            HotelsLocationDialog hotelsLocationDialog = new HotelsLocationDialog(hotelsActivity, ((HotelsViewModel.RoutingAction.OpenLocationDialog) routingAction).getPreselected(), null, new e(hotelsActivity), new f(hotelsActivity), null, 32, null);
            hotelsActivity.l = hotelsLocationDialog;
            hotelsLocationDialog.show();
        } else if (routingAction instanceof HotelsViewModel.RoutingAction.OpenGuestsDialog) {
            HotelsViewModel.RoutingAction.OpenGuestsDialog openGuestsDialog = (HotelsViewModel.RoutingAction.OpenGuestsDialog) routingAction;
            HotelsGuestsDialog hotelsGuestsDialog = new HotelsGuestsDialog(hotelsActivity, openGuestsDialog.getSelected(), openGuestsDialog.getAdults(), openGuestsDialog.getChildren(), null, new c(hotelsActivity), new d(hotelsActivity), null, 128, null);
            hotelsActivity.n = hotelsGuestsDialog;
            hotelsGuestsDialog.show();
        } else if (routingAction instanceof HotelsViewModel.RoutingAction.OpenDeepLink) {
            DeepLink link = ((HotelsViewModel.RoutingAction.OpenDeepLink) routingAction).getLink();
            DeepLinkIntentFactory deepLinkIntentFactory2 = hotelsActivity.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            Intent intent = deepLinkIntentFactory2.getIntent(link);
            if (intent != null) {
                hotelsActivity.startActivity(intent);
            }
        }
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.activity_hotels;
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final HotelsViewModelFactory getViewModelFactory() {
        HotelsViewModelFactory hotelsViewModelFactory = this.viewModelFactory;
        if (hotelsViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return hotelsViewModelFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        HotelsViewModelFactory hotelsViewModelFactory = this.viewModelFactory;
        if (hotelsViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = new ViewModelProvider(this, hotelsViewModelFactory).get(HotelsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …elsViewModel::class.java)");
        HotelsViewModel hotelsViewModel = (HotelsViewModel) viewModel;
        this.k = hotelsViewModel;
        if (hotelsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        hotelsViewModel.routingActions().observe(this, new a(this));
        HotelsViewModel hotelsViewModel2 = this.k;
        if (hotelsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        View containerView = getContainerView();
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        hotelsViewModel2.init(new HotelsViewImpl(containerView, analytics2));
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerHotelsComponent.builder().hotelsDependencies((HotelsDependencies) ComponentDependenciesKt.getDependencies(HotelsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withMarker(getIntent().getStringExtra("marker")).build().inject(this);
        return true;
    }

    public final void setViewModelFactory(@NotNull HotelsViewModelFactory hotelsViewModelFactory) {
        Intrinsics.checkNotNullParameter(hotelsViewModelFactory, "<set-?>");
        this.viewModelFactory = hotelsViewModelFactory;
    }
}
