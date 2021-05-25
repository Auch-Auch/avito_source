package com.avito.android.vas_discount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ComponentProvider;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DiscountResponse;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Views;
import com.avito.android.vas_discount.di.DaggerVasDiscountComponent;
import com.avito.android.vas_discount.di.DiscountDependencies;
import com.avito.android.vas_discount.di.DiscountModule;
import com.avito.android.vas_discount.di.VasDiscountComponent;
import com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\"\u0010\u000bJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u00038\u0016@\u0016X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/avito/android/vas_discount/VasDiscountActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/ComponentProvider;", "Lcom/avito/android/vas_discount/di/VasDiscountComponent;", "Lcom/avito/android/vas_discount/DiscountListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "closeWithError", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/vas_discount/DiscountActivityViewModelFactory;", "factory", "Lcom/avito/android/vas_discount/DiscountActivityViewModelFactory;", "getFactory", "()Lcom/avito/android/vas_discount/DiscountActivityViewModelFactory;", "setFactory", "(Lcom/avito/android/vas_discount/DiscountActivityViewModelFactory;)V", "Lcom/avito/android/vas_discount/DiscountActivityViewModel;", "l", "Lcom/avito/android/vas_discount/DiscountActivityViewModel;", "viewModel", "Landroid/view/View;", "k", "Landroid/view/View;", "progressView", "component", "Lcom/avito/android/vas_discount/di/VasDiscountComponent;", "getComponent", "()Lcom/avito/android/vas_discount/di/VasDiscountComponent;", "setComponent", "(Lcom/avito/android/vas_discount/di/VasDiscountComponent;)V", "<init>", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public final class VasDiscountActivity extends BaseActivity implements ComponentProvider<VasDiscountComponent>, DiscountListener {
    public VasDiscountComponent component;
    @Inject
    public DiscountActivityViewModelFactory factory;
    public View k;
    public DiscountActivityViewModel l;

    public static final class a<T> implements Observer<LoadingState<? super DiscountResponse>> {
        public final /* synthetic */ VasDiscountActivity a;

        public a(VasDiscountActivity vasDiscountActivity) {
            this.a = vasDiscountActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(LoadingState<? super DiscountResponse> loadingState) {
            LoadingState<? super DiscountResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                VasDiscountActivity.access$showDialog(this.a, (DiscountResponse) ((LoadingState.Loaded) loadingState2).getData());
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.a();
            } else if (loadingState2 instanceof LoadingState.Loading) {
                VasDiscountActivity.access$showProgress(this.a);
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VasDiscountActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(VasDiscountActivity vasDiscountActivity) {
            super(0);
            this.a = vasDiscountActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.finish();
            return Unit.INSTANCE;
        }
    }

    public static final void access$showDialog(VasDiscountActivity vasDiscountActivity, DiscountResponse discountResponse) {
        View view = vasDiscountActivity.k;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        }
        Views.hide(view);
        if (vasDiscountActivity.getSupportFragmentManager().findFragmentByTag("dialog") == null) {
            DiscountDialogFragment.Companion.newInstance(discountResponse).show(vasDiscountActivity.getSupportFragmentManager(), "dialog");
        }
    }

    public static final void access$showProgress(VasDiscountActivity vasDiscountActivity) {
        View view = vasDiscountActivity.k;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        }
        Views.show(view);
    }

    public final void a() {
        View view = this.k;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        }
        Views.hide(view);
        View view2 = this.k;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        }
        Views.showSnackBar$default(view2, R.string.unknown_server_error, 0, (Integer) null, 0, (Function0) null, new b(this), 0, 92, (Object) null);
    }

    @Override // com.avito.android.vas_discount.DiscountListener
    public void closeWithError() {
        a();
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("dialog");
        if (findFragmentByTag != null) {
            getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
    }

    @NotNull
    public final DiscountActivityViewModelFactory getFactory() {
        DiscountActivityViewModelFactory discountActivityViewModelFactory = this.factory;
        if (discountActivityViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("factory");
        }
        return discountActivityViewModelFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        setComponent(DaggerVasDiscountComponent.builder().module(new DiscountModule(intent != null ? intent.getStringExtra("discount_context") : null)).dependencies((DiscountDependencies) ComponentDependenciesKt.getDependencies(DiscountDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build());
        getComponent().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.vas_discount_activity);
        View findViewById = findViewById(R.id.progress_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.progress_view)");
        this.k = findViewById;
        DiscountActivityViewModelFactory discountActivityViewModelFactory = this.factory;
        if (discountActivityViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("factory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, discountActivityViewModelFactory).get(DiscountActivityViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…iewModelImpl::class.java)");
        DiscountActivityViewModel discountActivityViewModel = (DiscountActivityViewModel) viewModel;
        this.l = discountActivityViewModel;
        if (discountActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        discountActivityViewModel.getDataChanges().observe(this, new a(this));
    }

    public void setComponent(@NotNull VasDiscountComponent vasDiscountComponent) {
        Intrinsics.checkNotNullParameter(vasDiscountComponent, "<set-?>");
        this.component = vasDiscountComponent;
    }

    public final void setFactory(@NotNull DiscountActivityViewModelFactory discountActivityViewModelFactory) {
        Intrinsics.checkNotNullParameter(discountActivityViewModelFactory, "<set-?>");
        this.factory = discountActivityViewModelFactory;
    }

    @Override // com.avito.android.ComponentProvider
    @NotNull
    public VasDiscountComponent getComponent() {
        VasDiscountComponent vasDiscountComponent = this.component;
        if (vasDiscountComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        return vasDiscountComponent;
    }
}
