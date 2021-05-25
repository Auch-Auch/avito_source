package com.avito.android.authorization.select_profile;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.R;
import com.avito.android.authorization.select_profile.SelectProfilePresenter;
import com.avito.android.authorization.select_profile.di.DaggerSelectProfileComponent;
import com.avito.android.authorization.select_profile.di.SelectProfileComponent;
import com.avito.android.authorization.select_profile.di.SelectProfileDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.model.registration.ProfileSocial;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b<\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u001d\u0010\u0012\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\tR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/avito/android/authorization/select_profile/SelectProfileActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/select_profile/SelectProfilePresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "leaveScreen", "", "Lcom/avito/android/remote/model/registration/ProfileSocial;", "social", "openSelectSocial", "(Ljava/util/List;)V", "", "login", "openLogin", "(Ljava/lang/String;)V", "openCompleteRegistration", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/authorization/select_profile/SelectProfilePresenter;", "presenter", "Lcom/avito/android/authorization/select_profile/SelectProfilePresenter;", "getPresenter", "()Lcom/avito/android/authorization/select_profile/SelectProfilePresenter;", "setPresenter", "(Lcom/avito/android/authorization/select_profile/SelectProfilePresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SelectProfileActivity extends BaseActivity implements SelectProfilePresenter.Router {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SelectProfilePresenter presenter;

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
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
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final SelectProfilePresenter getPresenter() {
        SelectProfilePresenter selectProfilePresenter = this.presenter;
        if (selectProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return selectProfilePresenter;
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfilePresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        SelectProfileComponent.Builder dependentOn = DaggerSelectProfileComponent.builder().dependentOn((SelectProfileDependencies) ComponentDependenciesKt.getDependencies(SelectProfileDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        SelectProfileComponent.Builder withPresenterState = dependentOn.withResources(resources).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null);
        String stringExtra = getIntent().getStringExtra("hash");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_HASH)");
        withPresenterState.withHash(stringExtra).build().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.select_profile);
        SelectProfilePresenter selectProfilePresenter = this.presenter;
        if (selectProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
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
        selectProfilePresenter.attachView(new SelectProfileViewImpl(findViewById, adapterPresenter2, itemBinder2, analytics2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SelectProfilePresenter selectProfilePresenter = this.presenter;
        if (selectProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectProfilePresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SelectProfilePresenter selectProfilePresenter = this.presenter;
        if (selectProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", selectProfilePresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        SelectProfilePresenter selectProfilePresenter = this.presenter;
        if (selectProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectProfilePresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        SelectProfilePresenter selectProfilePresenter = this.presenter;
        if (selectProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectProfilePresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfilePresenter.Router
    public void openCompleteRegistration() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(activityIntentFactory.completeRegistrationIntent(AuthParamsKt.getTargetIntent(this), AuthParamsKt.getLogin(this), AuthParamsKt.getHash(this)));
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfilePresenter.Router
    public void openLogin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(AuthIntentFactory.DefaultImpls.loginIntent$default(activityIntentFactory, AuthParamsKt.getTargetIntent(this), str, null, true, null, false, 48, null));
    }

    @Override // com.avito.android.authorization.select_profile.SelectProfilePresenter.Router
    public void openSelectSocial(@NotNull List<ProfileSocial> list) {
        Intrinsics.checkNotNullParameter(list, "social");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(AuthIntentFactory.DefaultImpls.selectSocialIntent$default(activityIntentFactory, AuthParamsKt.getTargetIntent(this), list, null, 4, null));
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull SelectProfilePresenter selectProfilePresenter) {
        Intrinsics.checkNotNullParameter(selectProfilePresenter, "<set-?>");
        this.presenter = selectProfilePresenter;
    }
}
