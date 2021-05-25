package com.avito.android.advert.closed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.advert.closed.di.ClosedAdvertComponent;
import com.avito.android.advert.closed.di.ClosedAdvertDependencies;
import com.avito.android.advert.closed.di.DaggerClosedAdvertComponent;
import com.avito.android.advert_details.R;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/advert/closed/ClosedAdvertActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/advert/closed/ClosedAdvertRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "closeScreen", "", "getContentLayoutId", "()I", "setUpCustomToolbar", "()Z", "Lcom/avito/android/advert/closed/ClosedAdvertPresenter;", "presenter", "Lcom/avito/android/advert/closed/ClosedAdvertPresenter;", "getPresenter", "()Lcom/avito/android/advert/closed/ClosedAdvertPresenter;", "setPresenter", "(Lcom/avito/android/advert/closed/ClosedAdvertPresenter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "<init>", "Factory", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ClosedAdvertActivity extends BaseActivity implements ClosedAdvertRouter {
    @Inject
    public Features features;
    @Inject
    public ClosedAdvertPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/closed/ClosedAdvertActivity$Factory;", "", "Landroid/content/Context;", "context", "", "itemId", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intent addFlags = new Intent(context, ClosedAdvertActivity.class).putExtra("advert_id", str).addFlags(65536);
            Intrinsics.checkNotNullExpressionValue(addFlags, "context.createActivityIn…AG_ACTIVITY_NO_ANIMATION)");
            return addFlags;
        }
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertRouter
    public void closeScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.ac_advert_details_closed;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ClosedAdvertPresenter getPresenter() {
        ClosedAdvertPresenter closedAdvertPresenter = this.presenter;
        if (closedAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return closedAdvertPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ClosedAdvertPresenter closedAdvertPresenter = this.presenter;
        if (closedAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        closedAdvertPresenter.attachView(new ClosedAdvertViewImpl(getContainerView()));
        ClosedAdvertPresenter closedAdvertPresenter2 = this.presenter;
        if (closedAdvertPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        closedAdvertPresenter2.attachRouter(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ClosedAdvertPresenter closedAdvertPresenter = this.presenter;
        if (closedAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        closedAdvertPresenter.detachRouter();
        ClosedAdvertPresenter closedAdvertPresenter2 = this.presenter;
        if (closedAdvertPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        closedAdvertPresenter2.detachView();
        super.onDestroy();
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setPresenter(@NotNull ClosedAdvertPresenter closedAdvertPresenter) {
        Intrinsics.checkNotNullParameter(closedAdvertPresenter, "<set-?>");
        this.presenter = closedAdvertPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("advert_id");
        if (stringExtra != null) {
            ClosedAdvertComponent.Builder withAdvertId = DaggerClosedAdvertComponent.builder().closedAdvertDependencies((ClosedAdvertDependencies) ComponentDependenciesKt.getDependencies(ClosedAdvertDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withAdvertId(stringExtra);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            withAdvertId.withResources(resources).build().inject(this);
            return true;
        }
        throw new IllegalArgumentException(("advert_id was not passed to " + this).toString());
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}
