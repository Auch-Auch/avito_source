package com.avito.android.notifications_settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.notifications_settings.di.DaggerNotificationsSettingsComponent;
import com.avito.android.notifications_settings.di.NotificationsSettingsDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.dialog.SimpleDialogImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bF\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00102\u001a\b\u0012\u0004\u0012\u00020\u0005018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/avito/android/notifications_settings/NotificationsSettingsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/notifications_settings/NotificationsSettingsRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "outState", "onSaveInstanceState", "onStop", "onDestroy", "closeScreen", "openDialog", "openSettings", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroid/app/AlertDialog;", "k", "Landroid/app/AlertDialog;", "alertDialog", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/notifications_settings/NotificationsSettingsPresenter;", "presenter", "Lcom/avito/android/notifications_settings/NotificationsSettingsPresenter;", "getPresenter", "()Lcom/avito/android/notifications_settings/NotificationsSettingsPresenter;", "setPresenter", "(Lcom/avito/android/notifications_settings/NotificationsSettingsPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/jakewharton/rxrelay2/Relay;", "consumer", "Lcom/jakewharton/rxrelay2/Relay;", "getConsumer", "()Lcom/jakewharton/rxrelay2/Relay;", "setConsumer", "(Lcom/jakewharton/rxrelay2/Relay;)V", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "getNotificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "setNotificationManagerProvider", "(Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsSettingsActivity extends BaseActivity implements NotificationsSettingsRouter {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public Relay<Unit> consumer;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ItemBinder itemBinder;
    public AlertDialog k;
    @Inject
    public NotificationManagerProvider notificationManagerProvider;
    @Inject
    public NotificationsSettingsPresenter presenter;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ NotificationsSettingsActivity a;

        public a(NotificationsSettingsActivity notificationsSettingsActivity) {
            this.a = notificationsSettingsActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.finish();
        }
    }

    @Override // com.avito.android.notifications_settings.NotificationsSettingsRouter
    public void closeScreen() {
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
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final Relay<Unit> getConsumer() {
        Relay<Unit> relay = this.consumer;
        if (relay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consumer");
        }
        return relay;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
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
    public final NotificationManagerProvider getNotificationManagerProvider() {
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        return notificationManagerProvider2;
    }

    @NotNull
    public final NotificationsSettingsPresenter getPresenter() {
        NotificationsSettingsPresenter notificationsSettingsPresenter = this.presenter;
        if (notificationsSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return notificationsSettingsPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerNotificationsSettingsComponent.builder().dependencies((NotificationsSettingsDependencies) ComponentDependenciesKt.getDependencies(NotificationsSettingsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withPresenterState(bundle != null ? (Kundle) bundle.getParcelable("key_state") : null).build().inject(this);
        setContentView(R.layout.notifications_settings);
        View findViewById = findViewById(R.id.outside);
        if (findViewById != null) {
            findViewById.setOnClickListener(new a(this));
        }
        NotificationsSettingsPresenter notificationsSettingsPresenter = this.presenter;
        if (notificationsSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View containerView = getContainerView();
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
        notificationsSettingsPresenter.attachView(new NotificationsSettingsViewImpl(containerView, adapterPresenter2, itemBinder2, analytics2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NotificationsSettingsPresenter notificationsSettingsPresenter = this.presenter;
        if (notificationsSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationsSettingsPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NotificationsSettingsPresenter notificationsSettingsPresenter = this.presenter;
        if (notificationsSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key_state", notificationsSettingsPresenter.getState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        NotificationsSettingsPresenter notificationsSettingsPresenter = this.presenter;
        if (notificationsSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationsSettingsPresenter.attachRouter(this);
        NotificationsSettingsPresenter notificationsSettingsPresenter2 = this.presenter;
        if (notificationsSettingsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        notificationsSettingsPresenter2.checkNotificationsEnabled(notificationManagerProvider2.getAreNotificationsEnabled());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        NotificationsSettingsPresenter notificationsSettingsPresenter = this.presenter;
        if (notificationsSettingsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationsSettingsPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.notifications_settings.NotificationsSettingsRouter
    public void openDialog() {
        if (this.k == null) {
            View inflate = getLayoutInflater().inflate(R.layout.simple_dialog, (ViewGroup) null);
            AlertDialog create = new AlertDialog.Builder(this).setView(inflate).create();
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            SimpleDialogImpl simpleDialogImpl = new SimpleDialogImpl(inflate);
            simpleDialogImpl.setImage(Contexts.getResourceIdByAttr(this, com.avito.android.lib.design.R.attr.img_dialogNotifications));
            simpleDialogImpl.showImage();
            simpleDialogImpl.setTitle(R.string.notifications_settings_dialog_title);
            simpleDialogImpl.setBody(R.string.notifications_settings_dialog_body);
            simpleDialogImpl.setPrimaryButtonText(R.string.notifications_settings_dialog_button_primary);
            simpleDialogImpl.setSecondaryButtonText(R.string.notifications_settings_dialog_button_secondary);
            simpleDialogImpl.setPrimaryClickListener(new c5(0, this, create));
            simpleDialogImpl.setSecondaryClickListener(new c5(1, this, create));
            create.setOnCancelListener(new a2.a.a.q1.a(this));
            create.show();
            this.k = create;
        }
    }

    @Override // com.avito.android.notifications_settings.NotificationsSettingsRouter
    public void openSettings() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.notificationsSettingsIntent());
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setConsumer(@NotNull Relay<Unit> relay) {
        Intrinsics.checkNotNullParameter(relay, "<set-?>");
        this.consumer = relay;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setNotificationManagerProvider(@NotNull NotificationManagerProvider notificationManagerProvider2) {
        Intrinsics.checkNotNullParameter(notificationManagerProvider2, "<set-?>");
        this.notificationManagerProvider = notificationManagerProvider2;
    }

    public final void setPresenter(@NotNull NotificationsSettingsPresenter notificationsSettingsPresenter) {
        Intrinsics.checkNotNullParameter(notificationsSettingsPresenter, "<set-?>");
        this.presenter = notificationsSettingsPresenter;
    }
}
