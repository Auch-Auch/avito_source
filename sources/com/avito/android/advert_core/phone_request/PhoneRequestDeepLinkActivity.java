package com.avito.android.advert_core.phone_request;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.PhoneRequestDeepLinkIntentFactoryKt;
import com.avito.android.advert_core.phone_request.di.DaggerPhoneRequestDeepLinkActivityComponent;
import com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkActivityComponent;
import com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies;
import com.avito.android.advert_core.phone_request.di.PhoneRequestScreen;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.async_phone.AsyncPhoneViewImpl;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.DialogRouterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.PhoneNumberFormatterModule;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b4\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ'\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R.\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110,8\u0006@\u0006X.¢\u0006\u0018\n\u0004\b-\u0010.\u0012\u0004\b3\u0010\t\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/avito/android/advert_core/phone_request/PhoneRequestDeepLinkActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/advert_core/phone_request/PhoneRequestRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "Landroid/content/Intent;", "intent", "startActivitySafely", "(Landroid/content/Intent;)V", "leaveScreen", "Lcom/avito/android/async_phone/AsyncPhoneItem;", "item", "", "src", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "showAuth", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "(Ljava/lang/String;)V", "Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenter;", "presenter", "Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenter;", "getPresenter", "()Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenter;", "setPresenter", "(Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Lcom/avito/android/util/Formatter;", "getPhoneNumberFormatter", "()Lcom/avito/android/util/Formatter;", "setPhoneNumberFormatter", "(Lcom/avito/android/util/Formatter;)V", "getPhoneNumberFormatter$annotations", "<init>", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneRequestDeepLinkActivity extends BaseActivity implements PhoneRequestRouter {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Formatter<String> phoneNumberFormatter;
    @Inject
    public PhoneRequestPresenter presenter;

    @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode
    public static /* synthetic */ void getPhoneNumberFormatter$annotations() {
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
    public final Formatter<String> getPhoneNumberFormatter() {
        Formatter<String> formatter = this.phoneNumberFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberFormatter");
        }
        return formatter;
    }

    @NotNull
    public final PhoneRequestPresenter getPresenter() {
        PhoneRequestPresenter phoneRequestPresenter = this.presenter;
        if (phoneRequestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return phoneRequestPresenter;
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestRouter
    public void leaveScreen() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == 0) {
            finish();
        } else if (i2 == -1) {
            PhoneRequestPresenter phoneRequestPresenter = this.presenter;
            if (phoneRequestPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            phoneRequestPresenter.onAuthSuccess();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PhoneRequestDeepLinkActivityComponent.Factory factory = DaggerPhoneRequestDeepLinkActivityComponent.factory();
        Intrinsics.checkNotNullExpressionValue(factory, "DaggerPhoneRequestDeepLi…tivityComponent.factory()");
        PhoneRequestDeepLinkDependencies phoneRequestDeepLinkDependencies = (PhoneRequestDeepLinkDependencies) ComponentDependenciesKt.getDependencies(PhoneRequestDeepLinkDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this));
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        PhoneRequestLink phoneRequestDeepLink = PhoneRequestDeepLinkIntentFactoryKt.getPhoneRequestDeepLink(intent);
        if (phoneRequestDeepLink != null) {
            PhoneRequestScreen phoneRequestScreen = PhoneRequestScreen.INSTANCE;
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            factory.create(phoneRequestDeepLinkDependencies, this, phoneRequestScreen, phoneRequestDeepLink, PhoneRequestDeepLinkIntentFactoryKt.getPhoneRequestAnalyticsData(intent2)).inject(this);
            super.onCreate(bundle);
            PhoneRequestPresenter phoneRequestPresenter = this.presenter;
            if (phoneRequestPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            View containerView = getContainerView();
            DialogRouterImpl dialogRouterImpl = new DialogRouterImpl(this);
            Formatter<String> formatter = this.phoneNumberFormatter;
            if (formatter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNumberFormatter");
            }
            PhoneRequestPresenter phoneRequestPresenter2 = this.presenter;
            if (phoneRequestPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            phoneRequestPresenter.attachView(new PhoneRequestViewImpl(containerView, dialogRouterImpl, formatter, phoneRequestPresenter2, new AsyncPhoneViewImpl(getContainerView())));
            PhoneRequestPresenter phoneRequestPresenter3 = this.presenter;
            if (phoneRequestPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            phoneRequestPresenter3.attachRouter(this);
            return;
        }
        throw new IllegalArgumentException("Link not specified");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PhoneRequestPresenter phoneRequestPresenter = this.presenter;
        if (phoneRequestPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneRequestPresenter.detachView();
        PhoneRequestPresenter phoneRequestPresenter2 = this.presenter;
        if (phoneRequestPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        phoneRequestPresenter2.detachRouter();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setPhoneNumberFormatter(@NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "<set-?>");
        this.phoneNumberFormatter = formatter;
    }

    public final void setPresenter(@NotNull PhoneRequestPresenter phoneRequestPresenter) {
        Intrinsics.checkNotNullParameter(phoneRequestPresenter, "<set-?>");
        this.presenter = phoneRequestPresenter;
    }

    @Override // com.avito.android.async_phone.AsyncPhoneAuthRouter
    public void showAuth(@NotNull AsyncPhoneItem asyncPhoneItem, @NotNull String str, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(asyncPhoneItem, "item");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        showAuth(str);
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestRouter
    public void startActivitySafely(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            startActivity(IntentsKt.makeSafeForExternalApps(intent));
        } catch (Exception unused) {
            Logs.error$default("Can't open intent " + intent, null, 2, null);
        }
    }

    @Override // com.avito.android.async_phone.AsyncPhoneAuthRouter
    public void showAuth(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "src");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        try {
            startActivityForResult(IntentsKt.makeSafeForExternalApps(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, str, null, 5, null)), 1);
        } catch (Exception unused) {
            StringBuilder L = a.L("Can't open intent ");
            L.append(getIntent());
            Logs.error$default(L.toString(), null, 2, null);
        }
    }
}
