package com.avito.android.rating.user_contacts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.rating.R;
import com.avito.android.rating.RatingParamsKt;
import com.avito.android.rating.user_contacts.di.DaggerUserContactsComponent;
import com.avito.android.rating.user_contacts.di.UserContactsComponent;
import com.avito.android.rating.user_contacts.di.UserContactsDependencies;
import com.avito.android.rating.user_contacts.event.UserContactsOpenEvent;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bJ\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\fJ)\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006K"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "outState", "onSaveInstanceState", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/rating/user_contacts/UserContactsPresenter;", "presenter", "Lcom/avito/android/rating/user_contacts/UserContactsPresenter;", "getPresenter", "()Lcom/avito/android/rating/user_contacts/UserContactsPresenter;", "setPresenter", "(Lcom/avito/android/rating/user_contacts/UserContactsPresenter;)V", "Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "spanProvider", "Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "getSpanProvider", "()Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "setSpanProvider", "(Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;)V", "com/avito/android/rating/user_contacts/UserContactsActivity$router$1", "l", "Lcom/avito/android/rating/user_contacts/UserContactsActivity$router$1;", "router", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "k", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "startDisposables", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserContactsActivity extends BaseActivity {
    @Inject
    public ResponsiveAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ItemBinder itemBinder;
    public final CompositeDisposable k = new CompositeDisposable();
    public final UserContactsActivity$router$1 l = new UserContactsActivity$router$1(this);
    @Inject
    public UserContactsPresenter presenter;
    @Inject
    public UserContactsSpanProvider spanProvider;

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ UserContactsActivity a;

        public a(UserContactsActivity userContactsActivity) {
            this.a = userContactsActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            UserContactsActivity userContactsActivity = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "hasChanges");
            userContactsActivity.setResult(bool2.booleanValue() ? -1 : 0);
        }
    }

    @NotNull
    public final ResponsiveAdapterPresenter getAdapterPresenter() {
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return responsiveAdapterPresenter;
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
        return R.layout.user_contacts;
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
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final UserContactsPresenter getPresenter() {
        UserContactsPresenter userContactsPresenter = this.presenter;
        if (userContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return userContactsPresenter;
    }

    @NotNull
    public final UserContactsSpanProvider getSpanProvider() {
        UserContactsSpanProvider userContactsSpanProvider = this.spanProvider;
        if (userContactsSpanProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanProvider");
        }
        return userContactsSpanProvider;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String publishedRatingUserKey;
        boolean z = true;
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (i2 != -1 || intent == null || (publishedRatingUserKey = RatingParamsKt.getPublishedRatingUserKey(intent)) == null) {
            z = false;
        } else {
            UserContactsPresenter userContactsPresenter = this.presenter;
            if (userContactsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            userContactsPresenter.onRatingPublished(publishedRatingUserKey, RatingParamsKt.getMessage(intent));
        }
        if (!z) {
            UserContactsPresenter userContactsPresenter2 = this.presenter;
            if (userContactsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            userContactsPresenter2.resetScores();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        UserContactsPresenter userContactsPresenter = this.presenter;
        if (userContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        UserContactsSpanProvider userContactsSpanProvider = this.spanProvider;
        if (userContactsSpanProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spanProvider");
        }
        userContactsPresenter.attachView(new UserContactsViewImpl(findViewById, responsiveAdapterPresenter, itemBinder2, userContactsSpanProvider));
        if (bundle == null && (stringExtra = getIntent().getStringExtra("context")) != null) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new UserContactsOpenEvent(stringExtra));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        UserContactsPresenter userContactsPresenter = this.presenter;
        if (userContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", userContactsPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        UserContactsPresenter userContactsPresenter = this.presenter;
        if (userContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userContactsPresenter.attachRouter(this.l);
        CompositeDisposable compositeDisposable = this.k;
        UserContactsPresenter userContactsPresenter2 = this.presenter;
        if (userContactsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Disposable subscribe = userContactsPresenter2.getChangesObservable().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "presenter.changesObserva…ESULT_CANCELED)\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.k.clear();
        UserContactsPresenter userContactsPresenter = this.presenter;
        if (userContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userContactsPresenter.detachRouter();
        super.onStop();
    }

    public final void setAdapterPresenter(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "<set-?>");
        this.adapterPresenter = responsiveAdapterPresenter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull UserContactsPresenter userContactsPresenter) {
        Intrinsics.checkNotNullParameter(userContactsPresenter, "<set-?>");
        this.presenter = userContactsPresenter;
    }

    public final void setSpanProvider(@NotNull UserContactsSpanProvider userContactsSpanProvider) {
        Intrinsics.checkNotNullParameter(userContactsSpanProvider, "<set-?>");
        this.spanProvider = userContactsSpanProvider;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("context");
        UserContactsComponent.Factory factory = DaggerUserContactsComponent.factory();
        UserContactsDependencies userContactsDependencies = (UserContactsDependencies) ComponentDependenciesKt.getDependencies(UserContactsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this));
        Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(userContactsDependencies, kundle, resources, stringExtra).inject(this);
        return true;
    }
}
