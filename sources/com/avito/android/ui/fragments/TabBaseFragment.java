package com.avito.android.ui.fragments;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.avito.android.Features;
import com.avito.android.bottom_navigation.NavigationProvider;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.ui.fragment.ResultDispatcher;
import com.avito.android.bottom_navigation.ui.fragment.factory.Navigable;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.di.DaggerTabBaseComponent;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\bS\u0010\u001aJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u001dH\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\rH\u0017¢\u0006\u0004\b \u0010\u001aJ\u000f\u0010!\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\u001aJ\u0015\u0010#\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001bH\u0004¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u000bH\u0004¢\u0006\u0004\b*\u0010\u000fJ\u0011\u0010+\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0002¢\u0006\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010E\u001a\u00020?2\u0006\u0010@\u001a\u00020?8\u0006@BX\u000e¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\"\u0010N\u001a\u00020\u00128\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/bottom_navigation/ui/fragment/ResultDispatcher;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/Navigable;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "currentTab", "()Lcom/avito/android/bottom_navigation/NavigationTab;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "currentState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "Lcom/avito/android/ui/fragments/ResultReportData;", "data", "reportResults", "(Lcom/avito/android/ui/fragments/ResultReportData;)V", "finish", "()V", "", "resultCode", "Landroid/content/Intent;", "setResult", "(ILandroid/content/Intent;)V", "handleActivityResult", "onDestroy", "Lcom/avito/android/ui/fragments/ResultFragmentData;", "setTargetFragment", "(Lcom/avito/android/ui/fragments/ResultFragmentData;)V", "intent", "requestCode", "startForResult", "(Landroid/content/Intent;I)V", "bundle", "saveInRetainStorage", "retainStorage", "()Landroid/os/Bundle;", "getSavedInstance", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "Lcom/avito/android/bottom_navigation/NavigationProvider;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/bottom_navigation/NavigationProvider;", "Lcom/avito/android/ui/fragments/StoreFragment;", AuthSource.BOOKING_ORDER, "()Lcom/avito/android/ui/fragments/StoreFragment;", "Lcom/avito/android/ui/fragments/InjectHolder;", "i", "Lcom/avito/android/ui/fragments/InjectHolder;", "injectHolder", "e", "Lcom/avito/android/ui/fragments/ResultFragmentData;", "reportTarget", "d", "Lcom/avito/android/ui/fragments/ResultReportData;", "report", "", "<set-?>", "h", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "f", "Lcom/avito/android/ui/fragments/StoreFragment;", "store", "c", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "", g.a, "Z", "isOnCreateCalled", "<init>", "core_release"}, k = 1, mv = {1, 4, 2})
public abstract class TabBaseFragment extends BaseFragment implements ResultDispatcher, LifecycleObserver, Navigable {
    @NotNull
    public NavigationState c = new NavigationState(true);
    public ResultReportData d;
    public ResultFragmentData e;
    public StoreFragment f;
    public boolean g;
    @NotNull
    public String h = a.I2("UUID.randomUUID().toString()");
    public final InjectHolder i = new InjectHolder();

    public static /* synthetic */ void setResult$default(TabBaseFragment tabBaseFragment, int i2, Intent intent, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                intent = null;
            }
            tabBaseFragment.setResult(i2, intent);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setResult");
    }

    public final NavigationProvider a() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.bottom_navigation.NavigationProvider");
        return (NavigationProvider) activity;
    }

    public final StoreFragment b() {
        if (this.g) {
            StoreFragment storeFragment = (StoreFragment) getChildFragmentManager().findFragmentByTag("tab_base_store_fragment");
            if (storeFragment != null) {
                return storeFragment;
            }
            StoreFragment storeFragment2 = new StoreFragment();
            getChildFragmentManager().beginTransaction().add(storeFragment2, "tab_base_store_fragment").commit();
            return storeFragment2;
        }
        throw new IllegalArgumentException("Should be used only after onCreate!".toString());
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.Navigable
    @NotNull
    public NavigationState currentState() {
        return getNavigationState();
    }

    @Nullable
    public final NavigationTab currentTab() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof NavigationProvider)) {
            return null;
        }
        NavigationTab currentTab = ((NavigationProvider) activity).currentTab();
        if (!(currentTab instanceof NavigationTab)) {
            return null;
        }
        return currentTab;
    }

    @NotNull
    public final Features features() {
        return this.i.getFeatures();
    }

    public final void finish() {
        a().finishFragment();
    }

    @Override // androidx.fragment.app.Fragment, com.avito.android.bottom_navigation.ui.fragment.ResultDispatcher
    @NotNull
    public final String getId() {
        return this.h;
    }

    @NotNull
    public NavigationState getNavigationState() {
        return this.c;
    }

    @Nullable
    public final Bundle getSavedInstance(@Nullable Bundle bundle) {
        return retainStorage();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void handleActivityResult() {
        ResultReportData resultReportData = this.d;
        if (resultReportData != null) {
            onActivityResult(resultReportData.getRequestCode(), resultReportData.getResultCode(), resultReportData.getData());
            this.d = null;
        }
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        DaggerTabBaseComponent.factory().create((CoreComponentDependencies) ComponentDependenciesKt.getDependencies(CoreComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this.i);
        setDelegateSetUp$core_release(true);
        getLifecycle().addObserver(this);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof NavigationProvider)) {
            activity = null;
        }
        NavigationProvider navigationProvider = (NavigationProvider) activity;
        if (navigationProvider != null) {
            navigationProvider.registerSelf(this);
        }
        if (bundle == null) {
            this.h = a.I2("UUID.randomUUID().toString()");
        } else {
            String string = bundle.getString("tab_base_id");
            if (string == null) {
                string = "";
            }
            this.h = string;
            this.d = (ResultReportData) bundle.getParcelable("tab_base_report_results");
            this.e = (ResultFragmentData) bundle.getParcelable("tab_base_report_target");
        }
        super.onCreate(bundle);
        this.g = true;
        setUpFragmentComponent(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        getLifecycle().removeObserver(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("tab_base_report_results", this.d);
        bundle.putParcelable("tab_base_report_target", this.e);
        bundle.putString("tab_base_id", this.h);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ResultDispatcher
    public void reportResults(@NotNull ResultReportData resultReportData) {
        Intrinsics.checkNotNullParameter(resultReportData, "data");
        this.d = resultReportData;
    }

    @Nullable
    public final Bundle retainStorage() {
        StoreFragment storeFragment = this.f;
        if (storeFragment == null) {
            storeFragment = b();
        }
        this.f = storeFragment;
        if (storeFragment != null) {
            return storeFragment.getBundle$core_release();
        }
        return null;
    }

    public final void saveInRetainStorage(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        StoreFragment storeFragment = this.f;
        if (storeFragment == null) {
            storeFragment = b();
        }
        this.f = storeFragment;
        if (storeFragment != null) {
            storeFragment.setBundle$core_release(bundle);
        }
    }

    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.c = navigationState;
    }

    public final void setResult(int i2, @Nullable Intent intent) {
        ResultFragmentData resultFragmentData = this.e;
        if (resultFragmentData != null) {
            a().reportFragmentResult(resultFragmentData.getFragmentId(), new ResultReportData(resultFragmentData.getRequestCode(), i2, intent));
        }
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ResultDispatcher
    public final void setTargetFragment(@NotNull ResultFragmentData resultFragmentData) {
        Intrinsics.checkNotNullParameter(resultFragmentData, "data");
        this.e = resultFragmentData;
    }

    public final void startForResult(@NotNull Intent intent, int i2) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (IntentsKt.getTabFragmentData(intent) != null) {
            a().registerStartForResult(new ResultFragmentData(this.h, i2));
            requireActivity().startActivity(intent);
            return;
        }
        throw new IllegalArgumentException("Data should be presented!".toString());
    }
}
