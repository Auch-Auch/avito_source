package com.avito.android.soa_stat.profile_settings;

import a2.a.a.x2.a.b;
import a2.a.a.x2.a.c;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.soa_stat.R;
import com.avito.android.soa_stat.di.DaggerSoaStatProfileSettingsComponent;
import com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies;
import com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsViewModel;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "onBackPressed", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModelFactory;", "viewModelFactory", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModelFactory;)V", "Lio/reactivex/disposables/CompositeDisposable;", "l", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel;", "k", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel;", "viewModel", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
public final class SoaStatProfileSettingsActivity extends BaseActivity {
    @Inject
    public Analytics analytics;
    public SoaStatProfileSettingsViewModel k;
    public final CompositeDisposable l = new CompositeDisposable();
    @Inject
    public SoaStatProfileSettingsViewModelFactory viewModelFactory;

    public static final class a<T> implements Observer<SoaStatProfileSettingsViewModel.State> {
        public final /* synthetic */ SoaStatProfileSettingsView a;

        public a(SoaStatProfileSettingsView soaStatProfileSettingsView) {
            this.a = soaStatProfileSettingsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(SoaStatProfileSettingsViewModel.State state) {
            SoaStatProfileSettingsViewModel.State state2 = state;
            if (state2 instanceof SoaStatProfileSettingsViewModel.State.Loaded) {
                this.a.showContent(((SoaStatProfileSettingsViewModel.State.Loaded) state2).getPageData());
            } else if (state2 instanceof SoaStatProfileSettingsViewModel.State.Loading) {
                this.a.showLoading();
            } else if (state2 instanceof SoaStatProfileSettingsViewModel.State.Error) {
                this.a.showError();
            } else if (state2 instanceof SoaStatProfileSettingsViewModel.State.ToggleError) {
                SoaStatProfileSettingsViewModel.State.ToggleError toggleError = (SoaStatProfileSettingsViewModel.State.ToggleError) state2;
                this.a.showContent(toggleError.getPageData());
                this.a.showSnackBar(toggleError.getTextResId());
            }
        }
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
    public final SoaStatProfileSettingsViewModelFactory getViewModelFactory() {
        SoaStatProfileSettingsViewModelFactory soaStatProfileSettingsViewModelFactory = this.viewModelFactory;
        if (soaStatProfileSettingsViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return soaStatProfileSettingsViewModelFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this).inflate(R.layout.soa_stat_profile_settings, (ViewGroup) null, false);
        setContentView(inflate);
        DaggerSoaStatProfileSettingsComponent.builder().soaStatDependencies((SoaStatProfileSettingsDependencies) ComponentDependenciesKt.getDependencies(SoaStatProfileSettingsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withFormatter(new AttributedTextFormatterImpl()).build().inject(this);
        SoaStatProfileSettingsViewModelFactory soaStatProfileSettingsViewModelFactory = this.viewModelFactory;
        if (soaStatProfileSettingsViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, soaStatProfileSettingsViewModelFactory).get(SoaStatProfileSettingsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(\n …ngsViewModel::class.java)");
        this.k = (SoaStatProfileSettingsViewModel) viewModel;
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SoaStatProfileSettingsViewModel soaStatProfileSettingsViewModel = this.k;
        if (soaStatProfileSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        SoaStatProfileSettingsViewImpl soaStatProfileSettingsViewImpl = new SoaStatProfileSettingsViewImpl(inflate, analytics2);
        soaStatProfileSettingsViewImpl.getToolbar().setTitle("");
        soaStatProfileSettingsViewImpl.getToolbar().setNavigationOnClickListener(new c(this));
        CompositeDisposable compositeDisposable = this.l;
        Disposable subscribe = soaStatProfileSettingsViewImpl.getOnRefreshObserver().subscribe(new a2.a.a.x2.a.a(soaStatProfileSettingsViewModel), s0.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "pageView.onRefreshObserv…ad click\", it)\n        })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.l;
        Disposable subscribe2 = soaStatProfileSettingsViewImpl.getSwitchObserver().subscribe(new b(soaStatProfileSettingsViewModel), s0.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "pageView.switchObserver.… changed\", it)\n        })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        SoaStatProfileSettingsViewModel soaStatProfileSettingsViewModel2 = this.k;
        if (soaStatProfileSettingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaStatProfileSettingsViewModel2.getStateLiveData().observe(this, new a(soaStatProfileSettingsViewImpl));
        SoaStatProfileSettingsViewModel soaStatProfileSettingsViewModel3 = this.k;
        if (soaStatProfileSettingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        soaStatProfileSettingsViewModel3.loadData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.l.clear();
        super.onDestroy();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setViewModelFactory(@NotNull SoaStatProfileSettingsViewModelFactory soaStatProfileSettingsViewModelFactory) {
        Intrinsics.checkNotNullParameter(soaStatProfileSettingsViewModelFactory, "<set-?>");
        this.viewModelFactory = soaStatProfileSettingsViewModelFactory;
    }
}
