package com.avito.android.advert.consultation_form;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.advert.consultation_form.ConsultationFormViewModel;
import com.avito.android.advert.consultation_form.di.ConsultationFormComponentKt;
import com.avito.android.advert.consultation_form.di.ConsultationFormDependencies;
import com.avito.android.advert.consultation_form.di.DaggerConsultationFormComponent;
import com.avito.android.advert_details.R;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.ui.activity.BaseActivity;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b,\u0010-J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel;", "k", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModel;", "viewModel", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModelFactory;", "viewModelFactory", "Lcom/avito/android/advert/consultation_form/ConsultationFormViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/advert/consultation_form/ConsultationFormViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/advert/consultation_form/ConsultationFormViewModelFactory;)V", "<init>", "()V", "Factory", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationFormActivity extends BaseActivity {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    public ConsultationFormViewModel k;
    @Inject
    public ConsultationFormViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormActivity$Factory;", "", "Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "developmentId", "Lcom/avito/android/remote/model/ConsultationFormData;", "form", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ConsultationFormData;)Landroid/content/Intent;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent createIntent(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable ConsultationFormData consultationFormData) {
            Intent X0 = a2.b.a.a.a.X0(context, "context", context, ConsultationFormActivity.class);
            if (str != null) {
                X0.putExtra("advert_id", str);
            }
            if (str2 != null) {
                X0.putExtra(ConsultationFormComponentKt.DEVELOPMENT_ID, str2);
            }
            if (consultationFormData != null) {
                X0.putExtra("form", consultationFormData);
            }
            return X0;
        }
    }

    public static final class a<T> implements Observer<ConsultationFormViewModel.RoutingAction> {
        public final /* synthetic */ ConsultationFormActivity a;

        public a(ConsultationFormActivity consultationFormActivity) {
            this.a = consultationFormActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(ConsultationFormViewModel.RoutingAction routingAction) {
            ConsultationFormViewModel.RoutingAction routingAction2 = routingAction;
            ConsultationFormActivity consultationFormActivity = this.a;
            Intrinsics.checkNotNullExpressionValue(routingAction2, "it");
            ConsultationFormActivity.access$handleRoutingAction(consultationFormActivity, routingAction2);
        }
    }

    public static final void access$handleRoutingAction(ConsultationFormActivity consultationFormActivity, ConsultationFormViewModel.RoutingAction routingAction) {
        Objects.requireNonNull(consultationFormActivity);
        if (routingAction instanceof ConsultationFormViewModel.RoutingAction.Back) {
            consultationFormActivity.finish();
        } else if (routingAction instanceof ConsultationFormViewModel.RoutingAction.BackWithToast) {
            String message = ((ConsultationFormViewModel.RoutingAction.BackWithToast) routingAction).getMessage();
            if (message == null) {
                message = consultationFormActivity.getString(R.string.advert_details_consultation_success_toast);
                Intrinsics.checkNotNullExpressionValue(message, "getString(R.string.adver…nsultation_success_toast)");
            }
            Toast.makeText(consultationFormActivity, message, 1).show();
            consultationFormActivity.finish();
        } else if (routingAction instanceof ConsultationFormViewModel.RoutingAction.ToPhoneVerification) {
            String phone = ((ConsultationFormViewModel.RoutingAction.ToPhoneVerification) routingAction).getPhone();
            ActivityIntentFactory activityIntentFactory = consultationFormActivity.intentFactory;
            if (activityIntentFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
            }
            consultationFormActivity.startActivityForResult(activityIntentFactory.phoneVerificationIntent(phone, null, false, true), 0);
        } else if (routingAction instanceof ConsultationFormViewModel.RoutingAction.BackWithAction) {
            DeepLink link = ((ConsultationFormViewModel.RoutingAction.BackWithAction) routingAction).getLink();
            DeepLinkIntentFactory deepLinkIntentFactory2 = consultationFormActivity.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            Intent intent = deepLinkIntentFactory2.getIntent(link);
            if (intent != null) {
                consultationFormActivity.startActivity(intent);
            }
            consultationFormActivity.finish();
        } else if (routingAction instanceof ConsultationFormViewModel.RoutingAction.OpenDeepLink) {
            DeepLink link2 = ((ConsultationFormViewModel.RoutingAction.OpenDeepLink) routingAction).getLink();
            DeepLinkIntentFactory deepLinkIntentFactory3 = consultationFormActivity.deepLinkIntentFactory;
            if (deepLinkIntentFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            Intent intent2 = deepLinkIntentFactory3.getIntent(link2);
            if (intent2 != null) {
                consultationFormActivity.startActivity(intent2);
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.activity_consultation_form;
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final ConsultationFormViewModelFactory getViewModelFactory() {
        ConsultationFormViewModelFactory consultationFormViewModelFactory = this.viewModelFactory;
        if (consultationFormViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return consultationFormViewModelFactory;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        ConsultationFormViewModel consultationFormViewModel = this.k;
        if (consultationFormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (!consultationFormViewModel.onResult(i, i2)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ConsultationFormViewModelFactory consultationFormViewModelFactory = this.viewModelFactory;
        if (consultationFormViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = new ViewModelProvider(this, consultationFormViewModelFactory).get(ConsultationFormViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ormViewModel::class.java)");
        ConsultationFormViewModel consultationFormViewModel = (ConsultationFormViewModel) viewModel;
        this.k = consultationFormViewModel;
        if (consultationFormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        consultationFormViewModel.routingActions().observe(this, new a(this));
        ConsultationFormViewModel consultationFormViewModel2 = this.k;
        if (consultationFormViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        consultationFormViewModel2.init(new ConsultationFormViewImpl(getContainerView()));
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("advert_id");
        DaggerConsultationFormComponent.builder().consultationFormDependencies((ConsultationFormDependencies) ComponentDependenciesKt.getDependencies(ConsultationFormDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withAdvertId(stringExtra).withDevelopmentId(getIntent().getStringExtra(ConsultationFormComponentKt.DEVELOPMENT_ID)).withForm((ConsultationFormData) getIntent().getParcelableExtra("form")).build().inject(this);
        return true;
    }

    public final void setViewModelFactory(@NotNull ConsultationFormViewModelFactory consultationFormViewModelFactory) {
        Intrinsics.checkNotNullParameter(consultationFormViewModelFactory, "<set-?>");
        this.viewModelFactory = consultationFormViewModelFactory;
    }
}
