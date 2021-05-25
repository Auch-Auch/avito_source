package com.avito.android.settings.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.DebugIntentFactory;
import com.avito.android.NotificationCenterIntentFactory;
import com.avito.android.SuggestLocationsIntentFactory;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.license.ui.LicenseFragment;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.remote.model.Location;
import com.avito.android.settings.R;
import com.avito.android.settings.SettingsPresenter;
import com.avito.android.settings.SettingsResourceProvider;
import com.avito.android.settings.SettingsViewImpl;
import com.avito.android.settings.di.DaggerSettingsComponent;
import com.avito.android.settings.di.SettingsComponent;
import com.avito.android.settings.di.SettingsDependencies;
import com.avito.android.suggest_locations.OpenEventFromBlock;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bd\u0010\u0011J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u0011J\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010\u0011J\u000f\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\u0011J\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\"\u0010\u0011J\u000f\u0010#\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010\u0011J\u000f\u0010$\u001a\u00020\u000fH\u0016¢\u0006\u0004\b$\u0010\u0011J\u000f\u0010%\u001a\u00020\u000fH\u0016¢\u0006\u0004\b%\u0010\u0011J\u0017\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J'\u0010.\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000fH\u0016¢\u0006\u0004\b0\u0010\u0011J\u000f\u00101\u001a\u00020\u000fH\u0016¢\u0006\u0004\b1\u0010\u0011R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010U\u001a\u00020N8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010c¨\u0006e"}, d2 = {"Lcom/avito/android/settings/ui/SettingsFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/settings/SettingsPresenter$Router;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onStart", "()V", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "openHelpCenter", "openB2bHub", "openAppsLicenceScreen", "openUserAgreementScreen", "openOfferScreen", "openThemeSettings", "openSourceLicencesScreen", "openDebugScreen", "Lcom/avito/android/remote/model/Location;", "location", "openLocationScreen", "(Lcom/avito/android/remote/model/Location;)V", "", "email", "subject", "text", "openSupportInfoScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "openNotifications", "close", "Lcom/avito/android/settings/SettingsResourceProvider;", "resourceProvider", "Lcom/avito/android/settings/SettingsResourceProvider;", "getResourceProvider", "()Lcom/avito/android/settings/SettingsResourceProvider;", "setResourceProvider", "(Lcom/avito/android/settings/SettingsResourceProvider;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/settings/SettingsPresenter;", "settingsPresenter", "Lcom/avito/android/settings/SettingsPresenter;", "getSettingsPresenter", "()Lcom/avito/android/settings/SettingsPresenter;", "setSettingsPresenter", "(Lcom/avito/android/settings/SettingsPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "j", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/DebugIntentFactory;", "debugIntentFactory", "Lcom/avito/android/DebugIntentFactory;", "getDebugIntentFactory", "()Lcom/avito/android/DebugIntentFactory;", "setDebugIntentFactory", "(Lcom/avito/android/DebugIntentFactory;)V", "<init>", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class SettingsFragment extends TabBaseFragment implements SettingsPresenter.Router {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public DebugIntentFactory debugIntentFactory;
    @Inject
    public ItemBinder itemBinder;
    @NotNull
    public NavigationState j = new NavigationState(false);
    @Inject
    public SettingsResourceProvider resourceProvider;
    @Inject
    public SettingsPresenter settingsPresenter;

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void close() {
        if (features().getSettingsWithoutActivity().invoke().booleanValue()) {
            finish();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
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
    public final DebugIntentFactory getDebugIntentFactory() {
        DebugIntentFactory debugIntentFactory2 = this.debugIntentFactory;
        if (debugIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("debugIntentFactory");
        }
        return debugIntentFactory2;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.j;
    }

    @NotNull
    public final SettingsResourceProvider getResourceProvider() {
        SettingsResourceProvider settingsResourceProvider = this.resourceProvider;
        if (settingsResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        return settingsResourceProvider;
    }

    @NotNull
    public final SettingsPresenter getSettingsPresenter() {
        SettingsPresenter settingsPresenter2 = this.settingsPresenter;
        if (settingsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        }
        return settingsPresenter2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            Location location = intent != null ? (Location) intent.getParcelableExtra("location") : null;
            SettingsPresenter settingsPresenter2 = this.settingsPresenter;
            if (settingsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            }
            settingsPresenter2.onLocationSelected(location);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.settings_fragment, viewGroup, false);
        SettingsPresenter settingsPresenter2 = this.settingsPresenter;
        if (settingsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        }
        View findViewById = inflate.findViewById(R.id.settings_screen_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.settings_screen_root)");
        ViewGroup viewGroup2 = (ViewGroup) findViewById;
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        settingsPresenter2.attachView(new SettingsViewImpl(viewGroup2, adapterPresenter2, itemBinder2));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SettingsPresenter settingsPresenter2 = this.settingsPresenter;
        if (settingsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        }
        settingsPresenter2.detachView();
        super.onDestroyView();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (features().getSettingsWithoutActivity().invoke().booleanValue()) {
            Bundle bundle2 = new Bundle();
            SettingsPresenter settingsPresenter2 = this.settingsPresenter;
            if (settingsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            }
            Bundles.putKundle(bundle2, "settings_presenter", settingsPresenter2.onSaveState());
            Unit unit = Unit.INSTANCE;
            saveInRetainStorage(bundle2);
            return;
        }
        SettingsPresenter settingsPresenter3 = this.settingsPresenter;
        if (settingsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        }
        Bundles.putKundle(bundle, "settings_presenter", settingsPresenter3.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SettingsPresenter settingsPresenter2 = this.settingsPresenter;
        if (settingsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        }
        settingsPresenter2.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        SettingsPresenter settingsPresenter2 = this.settingsPresenter;
        if (settingsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        }
        settingsPresenter2.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openAppsLicenceScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.infoForAppsLicenceIntent());
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openB2bHub() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        SettingsResourceProvider settingsResourceProvider = this.resourceProvider;
        if (settingsResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        Uri parse = Uri.parse(settingsResourceProvider.getB2bHubUrl());
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(resourceProvider.b2bHubUrl)");
        startActivity(NotificationCenterIntentFactory.DefaultImpls.promoIntent$default(activityIntentFactory2, parse, false, false, 6, null));
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openDebugScreen() {
        DebugIntentFactory debugIntentFactory2 = this.debugIntentFactory;
        if (debugIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("debugIntentFactory");
        }
        Intent debugIntent = debugIntentFactory2.debugIntent();
        if (debugIntent != null) {
            startActivity(debugIntent);
        }
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openHelpCenter() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.helpCenterIntent(null));
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openLocationScreen(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent suggestLocationsIntent$default = SuggestLocationsIntentFactory.DefaultImpls.suggestLocationsIntent$default(activityIntentFactory2, location.getId(), null, Integer.valueOf(OpenEventFromBlock.SETTINGS.getValue()), null, null, currentTab(), false, null, null, false, false, 1984, null);
        if (!features().getLocationSelectWithoutActivity().invoke().booleanValue() || currentTab() == null) {
            startActivityForResult(suggestLocationsIntent$default, 1);
        } else {
            startForResult(suggestLocationsIntent$default, 1);
        }
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openNotifications() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.notificationsSettingsIntent());
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openOfferScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.infoForOfferIntent());
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openSourceLicencesScreen() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        if (childFragmentManager.findFragmentByTag(LicenseFragment.TAG) == null) {
            childFragmentManager.beginTransaction().add(LicenseFragment.Companion.newInstance(), LicenseFragment.TAG).commitAllowingStateLoss();
        }
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openSupportInfoScreen(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "subject");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intent putExtra = new Intent("android.intent.action.SEND").setType("plain/text").putExtra("android.intent.extra.EMAIL", new String[]{str}).putExtra("android.intent.extra.SUBJECT", str2).putExtra("android.intent.extra.TEXT", str3);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_SEN…(Intent.EXTRA_TEXT, text)");
        startActivity(Intent.createChooser(putExtra, getString(R.string.sending_message)));
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openThemeSettings() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.themeSettingsIntent());
    }

    @Override // com.avito.android.settings.SettingsPresenter.Router
    public void openUserAgreementScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.infoForUserAgreementIntent());
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setDebugIntentFactory(@NotNull DebugIntentFactory debugIntentFactory2) {
        Intrinsics.checkNotNullParameter(debugIntentFactory2, "<set-?>");
        this.debugIntentFactory = debugIntentFactory2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.j = navigationState;
    }

    public final void setResourceProvider(@NotNull SettingsResourceProvider settingsResourceProvider) {
        Intrinsics.checkNotNullParameter(settingsResourceProvider, "<set-?>");
        this.resourceProvider = settingsResourceProvider;
    }

    public final void setSettingsPresenter(@NotNull SettingsPresenter settingsPresenter2) {
        Intrinsics.checkNotNullParameter(settingsPresenter2, "<set-?>");
        this.settingsPresenter = settingsPresenter2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        if (features().getSettingsWithoutActivity().invoke().booleanValue()) {
            bundle = retainStorage();
        }
        SettingsComponent.Factory factory = DaggerSettingsComponent.factory();
        SettingsDependencies settingsDependencies = (SettingsDependencies) ComponentDependenciesKt.getDependencies(SettingsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this));
        LocationDependencies locationDependencies = (LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this));
        Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "settings_presenter") : null;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        PublishRelay<String> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        factory.create(settingsDependencies, locationDependencies, kundle, resources, create).inject(this);
        return true;
    }
}
