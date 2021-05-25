package com.avito.android.feedback_adverts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import arrow.core.OptionKt;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.feedback_adverts.di.DaggerFeedbackAdvertsComponent;
import com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001RB\u0007¢\u0006\u0004\bQ\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010 \u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0014¢\u0006\u0004\b\"\u0010\fR\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\"\u00106\u001a\u0002058\u0000@\u0000X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "outState", "onSaveInstanceState", "", "getContentLayoutId", "()I", "closeScreen", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "item", "onAdvertSelected", "(Lcom/avito/android/remote/feedback/FeedbackAdvertItem;)V", "onAuthRequired", "onBackButtonPressed", "setUpCustomToolbar", "()Z", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroy", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroid/os/Handler;", "k", "Landroid/os/Handler;", "handler", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$feedback_adverts_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$feedback_adverts_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures$feedback_adverts_release", "()Lcom/avito/android/Features;", "setFeatures$feedback_adverts_release", "(Lcom/avito/android/Features;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenter;", "presenter", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenter;", "getPresenter", "()Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenter;", "setPresenter", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenter;)V", "<init>", "IntentFactory", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackAdvertsActivity extends BaseActivity implements FeedbackAdvertsRouter {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public Features features;
    @Inject
    public ItemBinder itemBinder;
    public final Handler k = new Handler();
    @Inject
    public FeedbackAdvertsPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsActivity$IntentFactory;", "", "Landroid/content/Context;", "context", "", "itemId", "selectedItemId", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class IntentFactory {
        public static /* synthetic */ Intent create$default(IntentFactory intentFactory, Context context, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return intentFactory.create(context, str, str2);
        }

        @NotNull
        public final Intent create(@NotNull Context context, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent putExtra = new Intent(context, FeedbackAdvertsActivity.class).putExtra("item_id", str).putExtra("selected_item_id", str2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…_ITEM_ID, selectedItemId)");
            return putExtra;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ FeedbackAdvertsActivity a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Intent d;

        public a(FeedbackAdvertsActivity feedbackAdvertsActivity, int i, int i2, Intent intent) {
            this.a = feedbackAdvertsActivity;
            this.b = i;
            this.c = i2;
            this.d = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.b;
            boolean z = true;
            if (i != 1) {
                FeedbackAdvertsActivity.super.onActivityResult(i, this.c, this.d);
                return;
            }
            FeedbackAdvertsPresenter presenter = this.a.getPresenter();
            if (this.c != -1) {
                z = false;
            }
            presenter.onLoginComplete(z);
        }
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsRouter
    public void closeScreen() {
        finish();
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
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
    public final Analytics getAnalytics$feedback_adverts_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fr_feedback_items;
    }

    @NotNull
    public final Features getFeatures$feedback_adverts_release() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
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
    public final FeedbackAdvertsPresenter getPresenter() {
        FeedbackAdvertsPresenter feedbackAdvertsPresenter = this.presenter;
        if (feedbackAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return feedbackAdvertsPresenter;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        this.k.post(new a(this, i, i2, intent));
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsRouter
    public void onAdvertSelected(@NotNull FeedbackAdvertItem feedbackAdvertItem) {
        Intrinsics.checkNotNullParameter(feedbackAdvertItem, "item");
        Intent intent = new Intent();
        intent.putExtra("item", feedbackAdvertItem);
        setResult(-1, intent);
        finish();
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsRouter
    public void onAuthRequired() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent authIntent$default = AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.OPEN_CHANNEL, null, 5, null);
        authIntent$default.setFlags(603979776);
        startActivityForResult(authIntent$default, 1);
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsRouter
    public void onBackButtonPressed() {
        onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View containerView = getContainerView();
        Objects.requireNonNull(containerView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) containerView;
        FeedbackAdvertsPresenter feedbackAdvertsPresenter = this.presenter;
        if (feedbackAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
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
        FeedbackAdvertsViewImpl feedbackAdvertsViewImpl = new FeedbackAdvertsViewImpl(viewGroup, feedbackAdvertsPresenter, adapterPresenter2, itemBinder2, analytics2);
        FeedbackAdvertsPresenter feedbackAdvertsPresenter2 = this.presenter;
        if (feedbackAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        feedbackAdvertsPresenter2.attachView(feedbackAdvertsViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        FeedbackAdvertsPresenter feedbackAdvertsPresenter = this.presenter;
        if (feedbackAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        feedbackAdvertsPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        FeedbackAdvertsPresenter feedbackAdvertsPresenter = this.presenter;
        if (feedbackAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key_presenter_state", feedbackAdvertsPresenter.onSaveState());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        FeedbackAdvertsPresenter feedbackAdvertsPresenter = this.presenter;
        if (feedbackAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        feedbackAdvertsPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        FeedbackAdvertsPresenter feedbackAdvertsPresenter = this.presenter;
        if (feedbackAdvertsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        feedbackAdvertsPresenter.detachRouter();
        this.k.removeCallbacksAndMessages(null);
        super.onStop();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics$feedback_adverts_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setFeatures$feedback_adverts_release(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull FeedbackAdvertsPresenter feedbackAdvertsPresenter) {
        Intrinsics.checkNotNullParameter(feedbackAdvertsPresenter, "<set-?>");
        this.presenter = feedbackAdvertsPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        FeedbackAdvertsPresenterState feedbackAdvertsPresenterState = bundle != null ? (FeedbackAdvertsPresenterState) bundle.getParcelable("key_presenter_state") : null;
        String stringExtra = getIntent().getStringExtra("item_id");
        String stringExtra2 = getIntent().getStringExtra("selected_item_id");
        String string = getString(R.string.feedback_adverts_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.feedback_adverts_title)");
        DaggerFeedbackAdvertsComponent.builder().feedbackAdvertsDependencies((FeedbackAdvertsDependencies) ComponentDependenciesKt.getDependencies(FeedbackAdvertsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).presenterState(feedbackAdvertsPresenterState).itemId(OptionKt.toOption(stringExtra)).selectedItemId(stringExtra2).title(string).build().inject(this);
        return true;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}
