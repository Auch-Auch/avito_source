package com.avito.android.publish.cpa_tariff;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.publish.R;
import com.avito.android.publish.cpa_tariff.CpaTariffViewModel;
import com.avito.android.publish.cpa_tariff.di.CpaTariffDependencies;
import com.avito.android.publish.cpa_tariff.di.DaggerCpaTariffComponent;
import com.avito.android.ui.activity.BaseActivity;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/cpa_tariff/CpaTariffActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModelFactory;)V", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel;", "l", "Lcom/avito/android/publish/cpa_tariff/CpaTariffViewModel;", "viewModel", "Lcom/avito/android/publish/cpa_tariff/CpaTariffView;", "k", "Lcom/avito/android/publish/cpa_tariff/CpaTariffView;", "view", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CpaTariffActivity extends BaseActivity {
    public CpaTariffView k;
    public CpaTariffViewModel l;
    @Inject
    public CpaTariffViewModelFactory viewModelFactory;

    public static final class a<T> implements Observer<CpaTariffViewModel.RoutingAction> {
        public final /* synthetic */ CpaTariffActivity a;

        public a(CpaTariffActivity cpaTariffActivity) {
            this.a = cpaTariffActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(CpaTariffViewModel.RoutingAction routingAction) {
            CpaTariffViewModel.RoutingAction routingAction2 = routingAction;
            CpaTariffActivity cpaTariffActivity = this.a;
            Intrinsics.checkNotNullExpressionValue(routingAction2, "it");
            CpaTariffActivity.access$handleRoutingAction(cpaTariffActivity, routingAction2);
        }
    }

    public static final class b<T> implements Observer<CpaTariffViewModel.ScreenEvents> {
        public final /* synthetic */ CpaTariffActivity a;

        public b(CpaTariffActivity cpaTariffActivity) {
            this.a = cpaTariffActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(CpaTariffViewModel.ScreenEvents screenEvents) {
            CpaTariffViewModel.ScreenEvents screenEvents2 = screenEvents;
            CpaTariffActivity cpaTariffActivity = this.a;
            Intrinsics.checkNotNullExpressionValue(screenEvents2, "it");
            CpaTariffActivity.access$handleScreenEvents(cpaTariffActivity, screenEvents2);
        }
    }

    public static final void access$handleRoutingAction(CpaTariffActivity cpaTariffActivity, CpaTariffViewModel.RoutingAction routingAction) {
        Objects.requireNonNull(cpaTariffActivity);
        if (routingAction instanceof CpaTariffViewModel.RoutingAction.Back) {
            cpaTariffActivity.finish();
        } else if (routingAction instanceof CpaTariffViewModel.RoutingAction.BackWithToast) {
            String string = cpaTariffActivity.getString(R.string.cpa_tariff_success_toast);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.cpa_tariff_success_toast)");
            Toast.makeText(cpaTariffActivity, string, 1).show();
            cpaTariffActivity.finish();
        }
    }

    public static final void access$handleScreenEvents(CpaTariffActivity cpaTariffActivity, CpaTariffViewModel.ScreenEvents screenEvents) {
        Objects.requireNonNull(cpaTariffActivity);
        if (screenEvents instanceof CpaTariffViewModel.ScreenEvents.NameInputError) {
            CpaTariffView cpaTariffView = cpaTariffActivity.k;
            if (cpaTariffView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
            }
            cpaTariffView.handleNameInputError();
        } else if (screenEvents instanceof CpaTariffViewModel.ScreenEvents.PhoneInputError) {
            CpaTariffView cpaTariffView2 = cpaTariffActivity.k;
            if (cpaTariffView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
            }
            cpaTariffView2.handlePhoneInputError();
        } else if (screenEvents instanceof CpaTariffViewModel.ScreenEvents.CreateTariffRequestError) {
            CpaTariffView cpaTariffView3 = cpaTariffActivity.k;
            if (cpaTariffView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
            }
            cpaTariffView3.handleRequestError(((CpaTariffViewModel.ScreenEvents.CreateTariffRequestError) screenEvents).getMessage());
        } else if (screenEvents instanceof CpaTariffViewModel.ScreenEvents.ContactInfoLoaded) {
            CpaTariffView cpaTariffView4 = cpaTariffActivity.k;
            if (cpaTariffView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
            }
            CpaTariffViewModel.ScreenEvents.ContactInfoLoaded contactInfoLoaded = (CpaTariffViewModel.ScreenEvents.ContactInfoLoaded) screenEvents;
            cpaTariffView4.fillFieldsWithContactInfo(contactInfoLoaded.getName(), contactInfoLoaded.getPhone());
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.activity_cpa_tariff;
    }

    @NotNull
    public final CpaTariffViewModelFactory getViewModelFactory() {
        CpaTariffViewModelFactory cpaTariffViewModelFactory = this.viewModelFactory;
        if (cpaTariffViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return cpaTariffViewModelFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.k = new CpaTariffViewImpl(getContainerView());
        CpaTariffViewModelFactory cpaTariffViewModelFactory = this.viewModelFactory;
        if (cpaTariffViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = new ViewModelProvider(this, cpaTariffViewModelFactory).get(CpaTariffViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …iffViewModel::class.java)");
        CpaTariffViewModel cpaTariffViewModel = (CpaTariffViewModel) viewModel;
        this.l = cpaTariffViewModel;
        if (cpaTariffViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cpaTariffViewModel.routingActions().observe(this, new a(this));
        CpaTariffViewModel cpaTariffViewModel2 = this.l;
        if (cpaTariffViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cpaTariffViewModel2.screenEvents().observe(this, new b(this));
        CpaTariffViewModel cpaTariffViewModel3 = this.l;
        if (cpaTariffViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        CpaTariffView cpaTariffView = this.k;
        if (cpaTariffView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }
        cpaTariffViewModel3.init(cpaTariffView);
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerCpaTariffComponent.builder().cpaTariffDependencies((CpaTariffDependencies) ComponentDependenciesKt.getDependencies(CpaTariffDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withCategoryId(getIntent().getIntExtra("category_id", 0)).build().inject(this);
        return true;
    }

    public final void setViewModelFactory(@NotNull CpaTariffViewModelFactory cpaTariffViewModelFactory) {
        Intrinsics.checkNotNullParameter(cpaTariffViewModelFactory, "<set-?>");
        this.viewModelFactory = cpaTariffViewModelFactory;
    }
}
