package com.avito.android.authorization.select_social;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.R;
import com.avito.android.authorization.login.di.LoginModule;
import com.avito.android.authorization.select_social.SelectSocialPresenter;
import com.avito.android.authorization.select_social.di.DaggerSelectSocialComponent;
import com.avito.android.authorization.select_social.di.SelectSocialComponent;
import com.avito.android.authorization.select_social.di.SelectSocialDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.social.SocialActivity;
import com.avito.android.social.SocialType;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.IntentsKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b>\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J)\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/avito/android/authorization/select_social/SelectSocialActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/select_social/SelectSocialPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "leaveScreen", "completeAuthorization", "", "socialType", "openSocialLogin", "(Ljava/lang/String;)V", "Lcom/avito/android/authorization/select_social/SelectSocialPresenter;", "presenter", "Lcom/avito/android/authorization/select_social/SelectSocialPresenter;", "getPresenter", "()Lcom/avito/android/authorization/select_social/SelectSocialPresenter;", "setPresenter", "(Lcom/avito/android/authorization/select_social/SelectSocialPresenter;)V", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Lcom/avito/android/social/SocialTypeToStringMapper;", "getSocialTypeToStringMapper", "()Lcom/avito/android/social/SocialTypeToStringMapper;", "setSocialTypeToStringMapper", "(Lcom/avito/android/social/SocialTypeToStringMapper;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SelectSocialActivity extends BaseActivity implements SelectSocialPresenter.Router {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SelectSocialPresenter presenter;
    @Inject
    public SocialTypeToStringMapper socialTypeToStringMapper;

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter.Router
    public void completeAuthorization() {
        startActivity(IntentsKt.withClearTopFlags(com.avito.android.authorization.IntentsKt.withResult(AuthParamsKt.getTargetIntent(this), -1)));
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
    public final SelectSocialPresenter getPresenter() {
        SelectSocialPresenter selectSocialPresenter = this.presenter;
        if (selectSocialPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return selectSocialPresenter;
    }

    @NotNull
    public final SocialTypeToStringMapper getSocialTypeToStringMapper() {
        SocialTypeToStringMapper socialTypeToStringMapper2 = this.socialTypeToStringMapper;
        if (socialTypeToStringMapper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialTypeToStringMapper");
        }
        return socialTypeToStringMapper2;
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            String str = null;
            String stringExtra = intent != null ? intent.getStringExtra(SocialActivity.EXTRA_SOCIAL_EMAIL) : null;
            String stringExtra2 = intent != null ? intent.getStringExtra(SocialActivity.EXTRA_SOCIAL_TOKEN) : null;
            SocialType socialType = (SocialType) (intent != null ? intent.getSerializableExtra(SocialActivity.EXTRA_SOCIAL_TYPE) : null);
            if (intent != null) {
                str = intent.getStringExtra(SocialActivity.EXTRA_SOCIAL_USER);
            }
            SelectSocialPresenter selectSocialPresenter = this.presenter;
            if (selectSocialPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            SocialTypeToStringMapper socialTypeToStringMapper2 = this.socialTypeToStringMapper;
            if (socialTypeToStringMapper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socialTypeToStringMapper");
            }
            selectSocialPresenter.onSocialLoginSuccess(socialTypeToStringMapper2.mapToString(socialType), stringExtra2, stringExtra, str);
        } else if (i2 == 0) {
            SelectSocialPresenter selectSocialPresenter2 = this.presenter;
            if (selectSocialPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            selectSocialPresenter2.onSocialLoginCanceled();
        } else if (i2 == 1) {
            SelectSocialPresenter selectSocialPresenter3 = this.presenter;
            if (selectSocialPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            selectSocialPresenter3.onSocialLoginFailure();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        SelectSocialComponent.Builder dependentOn = DaggerSelectSocialComponent.builder().dependentOn((SelectSocialDependencies) ComponentDependenciesKt.getDependencies(SelectSocialDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        SelectSocialComponent.Builder withPresenterState = dependentOn.withResources(resources).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("social");
        if (parcelableArrayListExtra != null) {
            SelectSocialComponent.Builder withSocialList = withPresenterState.withSocialList(parcelableArrayListExtra);
            Intent intent = getIntent();
            if (intent == null || (str = intent.getStringExtra(LoginModule.SUGGEST_KEY)) == null) {
                str = "";
            }
            withSocialList.withSuggestKey(str).build().inject(this);
            super.onCreate(bundle);
            setContentView(R.layout.select_social);
            SelectSocialPresenter selectSocialPresenter = this.presenter;
            if (selectSocialPresenter == null) {
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
            selectSocialPresenter.attachView(new SelectSocialViewImpl(findViewById, adapterPresenter2, itemBinder2));
            return;
        }
        throw new IllegalStateException("Social list mustn't be null");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SelectSocialPresenter selectSocialPresenter = this.presenter;
        if (selectSocialPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectSocialPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SelectSocialPresenter selectSocialPresenter = this.presenter;
        if (selectSocialPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", selectSocialPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        SelectSocialPresenter selectSocialPresenter = this.presenter;
        if (selectSocialPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectSocialPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        SelectSocialPresenter selectSocialPresenter = this.presenter;
        if (selectSocialPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectSocialPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter.Router
    public void openSocialLogin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "socialType");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.createSocialLoginIntent(str), 1);
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull SelectSocialPresenter selectSocialPresenter) {
        Intrinsics.checkNotNullParameter(selectSocialPresenter, "<set-?>");
        this.presenter = selectSocialPresenter;
    }

    public final void setSocialTypeToStringMapper(@NotNull SocialTypeToStringMapper socialTypeToStringMapper2) {
        Intrinsics.checkNotNullParameter(socialTypeToStringMapper2, "<set-?>");
        this.socialTypeToStringMapper = socialTypeToStringMapper2;
    }
}
