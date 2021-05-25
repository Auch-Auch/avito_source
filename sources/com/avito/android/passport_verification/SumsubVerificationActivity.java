package com.avito.android.passport_verification;

import a2.a.a.s1.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.passport_verification.PassportVerificationModel;
import com.avito.android.passport_verification.SnsSdkNavigation;
import com.avito.android.passport_verification.di.DaggerPassportVerificationComponent;
import com.avito.android.passport_verification.di.PassportVerificationDependencies;
import com.avito.android.passport_verification.di.PassportVerificationModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.prooface.SNSProoface;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007*\u0001/\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b3\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\u000eJ'\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/avito/android/passport_verification/SumsubVerificationActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "onResume", "()V", "onPause", "onDestroy", "", "message", "success", "Landroid/content/Intent;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;Ljava/lang/Boolean;)Landroid/content/Intent;", "Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "k", "Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "snsSdk", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "navigationDisposables", "l", "disposables", "Lcom/avito/android/passport_verification/PassportVerificationModel;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "Lcom/avito/android/passport_verification/PassportVerificationModel;", "getModel", "()Lcom/avito/android/passport_verification/PassportVerificationModel;", "setModel", "(Lcom/avito/android/passport_verification/PassportVerificationModel;)V", "com/avito/android/passport_verification/SumsubVerificationActivity$tokenExpirationHandler$1", "n", "Lcom/avito/android/passport_verification/SumsubVerificationActivity$tokenExpirationHandler$1;", "tokenExpirationHandler", "<init>", "Companion", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
public final class SumsubVerificationActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public SNSMobileSDK.SDK k;
    public final CompositeDisposable l = new CompositeDisposable();
    public final CompositeDisposable m = new CompositeDisposable();
    @Inject
    public PassportVerificationModel model;
    public final SumsubVerificationActivity$tokenExpirationHandler$1 n = new SumsubVerificationActivity$tokenExpirationHandler$1(this);
    @Inject
    public SchedulersFactory3 schedulers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/passport_verification/SumsubVerificationActivity$Companion;", "", "Landroid/content/Context;", "context", "", "urlForSumSubSdk", "sumSubFlowName", "Landroid/content/Intent;", "createSumsubVerificationActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent createSumsubVerificationActivity(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "urlForSumSubSdk");
            Intrinsics.checkNotNullParameter(str2, "sumSubFlowName");
            Intent intent = new Intent(context, SumsubVerificationActivity.class);
            intent.putExtra("urk_for_sdk", str);
            intent.putExtra("flow_name", str2);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<SnsSdkNavigation> {
        public final /* synthetic */ SumsubVerificationActivity a;

        public a(SumsubVerificationActivity sumsubVerificationActivity) {
            this.a = sumsubVerificationActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SnsSdkNavigation snsSdkNavigation) {
            SNSMobileSDK.SDK sdk;
            SnsSdkNavigation snsSdkNavigation2 = snsSdkNavigation;
            if (snsSdkNavigation2 instanceof SnsSdkNavigation.OpenSnsSdk) {
                SnsSdkNavigation.OpenSnsSdk openSnsSdk = (SnsSdkNavigation.OpenSnsSdk) snsSdkNavigation2;
                SumsubVerificationActivity.access$startSdkFlow(this.a, openSnsSdk.getUrl(), openSnsSdk.getFlowName(), openSnsSdk.getAccessToken());
            } else if (Intrinsics.areEqual(snsSdkNavigation2, SnsSdkNavigation.DismissSnsSdk.INSTANCE) && (sdk = this.a.k) != null) {
                sdk.dismiss();
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to observe launch data", th);
        }
    }

    public static final class c<T> implements Consumer<PassportVerificationModel.Navigation> {
        public final /* synthetic */ SumsubVerificationActivity a;

        public c(SumsubVerificationActivity sumsubVerificationActivity) {
            this.a = sumsubVerificationActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(PassportVerificationModel.Navigation navigation) {
            PassportVerificationModel.Navigation navigation2 = navigation;
            if (navigation2 instanceof PassportVerificationModel.Navigation.FinishWithError) {
                SumsubVerificationActivity sumsubVerificationActivity = this.a;
                SumsubVerificationActivity.access$setResultError(sumsubVerificationActivity, sumsubVerificationActivity.getString(R.string.sdk_init_error));
            } else {
                String str = null;
                if (navigation2 instanceof PassportVerificationModel.Navigation.FinishWithChanges) {
                    SumsubVerificationActivity sumsubVerificationActivity2 = this.a;
                    if (((PassportVerificationModel.Navigation.FinishWithChanges) navigation2).getWithSuccessMessage()) {
                        str = this.a.getString(R.string.photos_sent_message);
                    }
                    SumsubVerificationActivity.access$setResultSuccess(sumsubVerificationActivity2, str);
                } else if (navigation2 instanceof PassportVerificationModel.Navigation.FinishWithNoChanges) {
                    SumsubVerificationActivity sumsubVerificationActivity3 = this.a;
                    Companion companion = SumsubVerificationActivity.Companion;
                    sumsubVerificationActivity3.setResult(0, sumsubVerificationActivity3.a(null, null));
                }
            }
            this.a.finish();
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to observe navigation events", th);
        }
    }

    public static final void access$setResultError(SumsubVerificationActivity sumsubVerificationActivity, String str) {
        sumsubVerificationActivity.setResult(-1, sumsubVerificationActivity.a(str, Boolean.FALSE));
    }

    public static final void access$setResultSuccess(SumsubVerificationActivity sumsubVerificationActivity, String str) {
        sumsubVerificationActivity.setResult(-1, sumsubVerificationActivity.a(str, Boolean.TRUE));
    }

    public static final void access$startSdkFlow(SumsubVerificationActivity sumsubVerificationActivity, String str, String str2, String str3) {
        Objects.requireNonNull(sumsubVerificationActivity);
        SNSMobileSDK.SDK build = SNSMobileSDK.Builder.withHandlers$default(new SNSMobileSDK.Builder(sumsubVerificationActivity, str, str2).withAccessToken(str3, sumsubVerificationActivity.n).withModules(t6.n.d.listOf(new SNSProoface(0, 1, null))), a2.a.a.s1.d.a, new a2.a.a.s1.c(sumsubVerificationActivity), new e(sumsubVerificationActivity), null, null, 24, null).build();
        sumsubVerificationActivity.k = build;
        if (build != null) {
            build.launch();
        }
    }

    public final Intent a(String str, Boolean bool) {
        if (str == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("result_message", str);
        if (bool == null) {
            return intent;
        }
        intent.putExtra("result_success", bool.booleanValue());
        return intent;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.passport_verification;
    }

    @NotNull
    public final PassportVerificationModel getModel() {
        PassportVerificationModel passportVerificationModel = this.model;
        if (passportVerificationModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        }
        return passportVerificationModel;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        CompositeDisposable compositeDisposable = this.l;
        PassportVerificationModel passportVerificationModel = this.model;
        if (passportVerificationModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        }
        Observable<SnsSdkNavigation> sdkLaunchData = passportVerificationModel.sdkLaunchData();
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Disposable subscribe = sdkLaunchData.observeOn(schedulersFactory3.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "model.sdkLaunchData()\n  …          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.l.clear();
        PassportVerificationModel passportVerificationModel = this.model;
        if (passportVerificationModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        }
        passportVerificationModel.clear();
        super.onDestroy();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.m.clear();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        CompositeDisposable compositeDisposable = this.m;
        PassportVerificationModel passportVerificationModel = this.model;
        if (passportVerificationModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        }
        Observable<PassportVerificationModel.Navigation> navigationEvents = passportVerificationModel.navigationEvents();
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Disposable subscribe = navigationEvents.observeOn(schedulersFactory3.mainThread()).subscribe(new c(this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "model.navigationEvents()…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void setModel(@NotNull PassportVerificationModel passportVerificationModel) {
        Intrinsics.checkNotNullParameter(passportVerificationModel, "<set-?>");
        this.model = passportVerificationModel;
    }

    public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulers = schedulersFactory3;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("urk_for_sdk");
        String stringExtra2 = getIntent().getStringExtra("flow_name");
        if (stringExtra == null || stringExtra2 == null) {
            throw new IllegalStateException(a2.b.a.a.a.d("Obligatory parameters absent urlForSdk: ", stringExtra, ", flowName: ", stringExtra2));
        }
        DaggerPassportVerificationComponent.builder().passportVerificationModule(new PassportVerificationModule(stringExtra, stringExtra2, bundle == null)).passportVerificationDependencies((PassportVerificationDependencies) ComponentDependenciesKt.getDependencies(PassportVerificationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        return true;
    }
}
