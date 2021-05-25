package com.avito.android.abuse.details;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.abuse.R;
import com.avito.android.abuse.details.AbuseDetailsPresenter;
import com.avito.android.abuse.details.adapter.AbuseField;
import com.avito.android.abuse.details.di.AbuseDetailsComponent;
import com.avito.android.abuse.details.di.AbuseDetailsDependencies;
import com.avito.android.abuse.details.di.DaggerAbuseDetailsComponent;
import com.avito.android.abuse.event.AbuseDetailsEvent;
import com.avito.android.abuse.event.AuthQueryEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.ArrayList;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bQ\u0010\u000eJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0010\u0010\u000eJ)\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u000eJ\u0019\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010\u000eJ\u000f\u0010!\u001a\u00020\u0011H\u0014¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b&\u0010%R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006R"}, d2 = {"Lcom/avito/android/abuse/details/AbuseDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/abuse/details/AbuseDetailsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "setUpCustomToolbar", "()Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "openAuthQueryScreen", "close", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "closeWithResult", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onBackPressed", "getContentLayoutId", "()I", "", AuthSource.SEND_ABUSE, "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory$abuse_release", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory$abuse_release", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures$abuse_release", "()Lcom/avito/android/Features;", "setFeatures$abuse_release", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/abuse/details/AbuseDetailsPresenter;", "presenter", "Lcom/avito/android/abuse/details/AbuseDetailsPresenter;", "getPresenter", "()Lcom/avito/android/abuse/details/AbuseDetailsPresenter;", "setPresenter", "(Lcom/avito/android/abuse/details/AbuseDetailsPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$abuse_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$abuse_release", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseDetailsActivity extends BaseActivity implements AbuseDetailsPresenter.Router {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public Features features;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public AbuseDetailsPresenter presenter;

    public final String a() {
        return getIntent().getStringExtra("itemId");
    }

    public final String b() {
        return getIntent().getStringExtra("src");
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter.Router
    public void close() {
        setResult(0);
        finish();
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter.Router
    public void closeWithResult(@Nullable DeepLink deepLink) {
        if (deepLink != null) {
            Intent putExtra = new Intent().putExtra("deep_link", deepLink);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(EXTRA_DEEP_LINK, deepLink)");
            setResult(-1, putExtra);
        } else {
            setResult(-1);
        }
        finish();
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics$abuse_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.abuse_details;
    }

    @NotNull
    public final Features getFeatures$abuse_release() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory$abuse_release() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final AbuseDetailsPresenter getPresenter() {
        AbuseDetailsPresenter abuseDetailsPresenter = this.presenter;
        if (abuseDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return abuseDetailsPresenter;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        boolean z = i2 == -1;
        if (i != AbuseDetailsActivityKt.access$getREQ_AUTH_QUERY$p()) {
            super.onActivityResult(i, i2, intent);
        } else if (z) {
            AbuseDetailsPresenter abuseDetailsPresenter = this.presenter;
            if (abuseDetailsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            abuseDetailsPresenter.onSendingAccepted();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AbuseDetailsPresenter abuseDetailsPresenter = this.presenter;
        if (abuseDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        abuseDetailsPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String a;
        super.onCreate(bundle);
        AbuseDetailsPresenter abuseDetailsPresenter = this.presenter;
        if (abuseDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View containerView = getContainerView();
        Objects.requireNonNull(containerView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) containerView;
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        abuseDetailsPresenter.attachView(new AbuseDetailsViewImpl(viewGroup, adapterPresenter2, itemBinder2, analytics2));
        if (bundle == null && (a = a()) != null) {
            int intExtra = getIntent().getIntExtra("categoryId", AbuseDetailsActivityKt.access$getCATEGORY_ID_INVALID$p());
            String b = b();
            if (b == null) {
                b = "";
            }
            Analytics analytics3 = this.analytics;
            if (analytics3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics3.track(new AbuseDetailsEvent(a, intExtra, b));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AbuseDetailsPresenter abuseDetailsPresenter = this.presenter;
        if (abuseDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        abuseDetailsPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        String access$getKEY_PRESENTER_STATE$p = AbuseDetailsActivityKt.access$getKEY_PRESENTER_STATE$p();
        AbuseDetailsPresenter abuseDetailsPresenter = this.presenter;
        if (abuseDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, access$getKEY_PRESENTER_STATE$p, abuseDetailsPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        AbuseDetailsPresenter abuseDetailsPresenter = this.presenter;
        if (abuseDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        abuseDetailsPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AbuseDetailsPresenter abuseDetailsPresenter = this.presenter;
        if (abuseDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        abuseDetailsPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsPresenter.Router
    public void openAuthQueryScreen() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.authQueryIntent(), AbuseDetailsActivityKt.access$getREQ_AUTH_QUERY$p());
        String a = a();
        if (a != null) {
            String b = b();
            if (b == null) {
                b = "";
            }
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new AuthQueryEvent(a, b));
        }
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics$abuse_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setFeatures$abuse_release(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setIntentFactory$abuse_release(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull AbuseDetailsPresenter abuseDetailsPresenter) {
        Intrinsics.checkNotNullParameter(abuseDetailsPresenter, "<set-?>");
        this.presenter = abuseDetailsPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        String a = a();
        if (a != null) {
            String b = b();
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("actions");
            int intExtra = getIntent().getIntExtra("categoryId", AbuseDetailsActivityKt.access$getCATEGORY_ID_INVALID$p());
            if (intExtra != AbuseDetailsActivityKt.access$getCATEGORY_ID_INVALID$p()) {
                AbuseDetailsComponent.Builder dependentOn = DaggerAbuseDetailsComponent.builder().dependentOn((AbuseDetailsDependencies) ComponentDependenciesKt.getDependencies(AbuseDetailsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                AbuseDetailsComponent.Builder with = dependentOn.with(resources).with(intExtra).withItemId(a).withSrc(b).with(parcelableArrayListExtra).with(bundle != null ? Bundles.getKundle(bundle, AbuseDetailsActivityKt.access$getKEY_PRESENTER_STATE$p()) : null);
                PublishRelay<AbuseField> create = PublishRelay.create();
                Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
                AbuseDetailsComponent.Builder withChanged = with.withChanged(create);
                PublishRelay<AbuseField> create2 = PublishRelay.create();
                Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
                AbuseDetailsComponent.Builder withFocused = withChanged.withFocused(create2);
                PublishRelay<DeepLink> create3 = PublishRelay.create();
                Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
                withFocused.withClicked(create3).build().inject(this);
                return true;
            }
            throw new IllegalArgumentException("categoryId must be specified");
        }
        throw new IllegalArgumentException("advertId must be specified");
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}
