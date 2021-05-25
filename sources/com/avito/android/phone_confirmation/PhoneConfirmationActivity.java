package com.avito.android.phone_confirmation;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.phone_confirmation.di.DaggerPhoneConfirmationComponent;
import com.avito.android.phone_confirmation.di.PhoneConfirmationDependencies;
import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.view.PhoneConfirmationView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Constants;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u0006R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X.¢\u0006\u0006\n\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/avito/android/phone_confirmation/PhoneConfirmationActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "outState", "onSaveInstanceState", "Lcom/avito/android/util/BuildInfo;", "build", "Lcom/avito/android/util/BuildInfo;", "getBuild", "()Lcom/avito/android/util/BuildInfo;", "setBuild", "(Lcom/avito/android/util/BuildInfo;)V", "Lcom/avito/android/phone_confirmation/PhoneConfirmationSmsReceiver;", "k", "Lcom/avito/android/phone_confirmation/PhoneConfirmationSmsReceiver;", "confirmationReceiver", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory;)V", "Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;", "interactor", "Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;", "getInteractor", "()Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;", "setInteractor", "(Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;)V", "Lio/reactivex/disposables/Disposable;", "n", "Lio/reactivex/disposables/Disposable;", "subscription", "Landroid/content/IntentFilter;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/content/IntentFilter;", "confirmationIntentFilter", "Lcom/avito/android/phone_confirmation/PhoneConfirmationRouter;", "router", "Lcom/avito/android/phone_confirmation/PhoneConfirmationRouter;", "getRouter", "()Lcom/avito/android/phone_confirmation/PhoneConfirmationRouter;", "setRouter", "(Lcom/avito/android/phone_confirmation/PhoneConfirmationRouter;)V", "Lcom/google/android/gms/auth/api/phone/SmsRetrieverClient;", "l", "Lcom/google/android/gms/auth/api/phone/SmsRetrieverClient;", "smsRetrieverClient", "<init>", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationActivity extends BaseActivity {
    @Inject
    public BuildInfo build;
    @Inject
    public PhoneConfirmationInteractor interactor;
    public PhoneConfirmationSmsReceiver k;
    public SmsRetrieverClient l;
    public final IntentFilter m = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
    public Disposable n;
    @Inject
    public PhoneConfirmationRouter router;
    @Inject
    public SchedulersFactory schedulers;

    public static final class a<TResult> implements OnCompleteListener<Void> {
        public static final a a = new a();

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(@NotNull Task<Void> task) {
            Intrinsics.checkNotNullParameter(task, "it");
            Logs.info$default("PhoneConfirmationActivity", "Sms retriever started", null, 4, null);
        }
    }

    public static final class b implements OnFailureListener {
        public static final b a = new b();

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(@NotNull Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            Logs.error$default("PhoneConfirmationActivity", "Failed to start sms retriever", null, 4, null);
        }
    }

    @NotNull
    public final BuildInfo getBuild() {
        BuildInfo buildInfo = this.build;
        if (buildInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("build");
        }
        return buildInfo;
    }

    @NotNull
    public final PhoneConfirmationInteractor getInteractor() {
        PhoneConfirmationInteractor phoneConfirmationInteractor = this.interactor;
        if (phoneConfirmationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return phoneConfirmationInteractor;
    }

    @NotNull
    public final PhoneConfirmationRouter getRouter() {
        PhoneConfirmationRouter phoneConfirmationRouter = this.router;
        if (phoneConfirmationRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return phoneConfirmationRouter;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        setContentView(R.layout.phone_confirmation_activity);
        super.onCreate(bundle);
        SmsRetrieverClient client = SmsRetriever.getClient((Activity) this);
        Intrinsics.checkNotNullExpressionValue(client, "SmsRetriever.getClient(this)");
        this.l = client;
        if (client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smsRetrieverClient");
        }
        client.startSmsRetriever().addOnCompleteListener(a.a).addOnFailureListener(b.a);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        PhoneConfirmationInteractor phoneConfirmationInteractor = this.interactor;
        if (phoneConfirmationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putParcelable("EX_SAVED_STATE", phoneConfirmationInteractor.getCurrentState());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        View findViewById = findViewById(R.id.phone_confirmation_screen_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.phone_confirmation_screen_root)");
        PhoneConfirmationView phoneConfirmationView = new PhoneConfirmationView(findViewById);
        PhoneConfirmationSmsReceiver phoneConfirmationSmsReceiver = new PhoneConfirmationSmsReceiver(phoneConfirmationView.getSetConfirmationCode());
        this.k = phoneConfirmationSmsReceiver;
        if (phoneConfirmationSmsReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationReceiver");
        }
        registerReceiver(phoneConfirmationSmsReceiver, this.m);
        PhoneConfirmationInteractor phoneConfirmationInteractor = this.interactor;
        if (phoneConfirmationInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        PhoneConfirmationRouter phoneConfirmationRouter = this.router;
        if (phoneConfirmationRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        BuildInfo buildInfo = this.build;
        if (buildInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("build");
        }
        this.n = PhoneConfirmationBinderKt.bind(phoneConfirmationView, phoneConfirmationView, phoneConfirmationInteractor, schedulersFactory, phoneConfirmationRouter, buildInfo);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Disposable disposable = this.n;
        if (disposable != null) {
            disposable.dispose();
        }
        PhoneConfirmationSmsReceiver phoneConfirmationSmsReceiver = this.k;
        if (phoneConfirmationSmsReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationReceiver");
        }
        unregisterReceiver(phoneConfirmationSmsReceiver);
        super.onStop();
    }

    public final void setBuild(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "<set-?>");
        this.build = buildInfo;
    }

    public final void setInteractor(@NotNull PhoneConfirmationInteractor phoneConfirmationInteractor) {
        Intrinsics.checkNotNullParameter(phoneConfirmationInteractor, "<set-?>");
        this.interactor = phoneConfirmationInteractor;
    }

    public final void setRouter(@NotNull PhoneConfirmationRouter phoneConfirmationRouter) {
        Intrinsics.checkNotNullParameter(phoneConfirmationRouter, "<set-?>");
        this.router = phoneConfirmationRouter;
    }

    public final void setSchedulers(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "<set-?>");
        this.schedulers = schedulersFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        boolean z;
        PhoneConfirmationScreenState phoneConfirmationScreenState;
        String stringExtra = getIntent().getStringExtra("phone");
        if (stringExtra == null) {
            stringExtra = "";
        }
        boolean booleanExtra = getIntent().getBooleanExtra(Constants.IS_COMPANY, false);
        boolean booleanExtra2 = getIntent().getBooleanExtra(Constants.CONSULTATION_FORM, false);
        if (bundle == null || (phoneConfirmationScreenState = (PhoneConfirmationScreenState) bundle.getParcelable("EX_SAVED_STATE")) == null) {
            z = booleanExtra2;
            phoneConfirmationScreenState = new PhoneConfirmationScreenState(stringExtra, booleanExtra, false, false, null, false, null, null, null, null, 1020, null);
        } else {
            z = booleanExtra2;
        }
        DaggerPhoneConfirmationComponent.builder().dependentOn((PhoneConfirmationDependencies) ComponentDependenciesKt.getDependencies(PhoneConfirmationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this).withInitialState(phoneConfirmationScreenState).withConfirmationType(z).build().inject(this);
        return true;
    }
}
