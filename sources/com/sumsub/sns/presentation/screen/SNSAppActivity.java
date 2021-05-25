package com.sumsub.sns.presentation.screen;

import a2.g.r.g;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.R;
import com.sumsub.sns.actions.presentation.SNSActionsFragment;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.common.SNSAppListener;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSErrorListener;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.data.model.SNSLivenessResult;
import com.sumsub.sns.core.presentation.BaseActivity;
import com.sumsub.sns.core.presentation.BaseFragment;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.base.SNSBaseFragment;
import com.sumsub.sns.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentFragment;
import com.sumsub.sns.presentation.screen.preview.photo.common.SNSPreviewCommonDocumentFragment;
import com.sumsub.sns.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentFragment;
import com.sumsub.sns.presentation.screen.preview.selfie.SNSPreviewSelfieFragment;
import com.sumsub.sns.presentation.screen.verification.SNSVerificationFragment;
import com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceActivity;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001>B\u0007¢\u0006\u0004\b=\u0010\u0014J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u001b\u0010!\u001a\u00020\u00072\n\u0010 \u001a\u00060\u001ej\u0002`\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0015H\u0016¢\u0006\u0004\b,\u0010\u0018J\u000f\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010\u0014J\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u0014J\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u0014R\u001d\u00104\u001a\u00020\u00028T@\u0014X\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/sumsub/sns/presentation/screen/SNSAppActivity;", "Lcom/sumsub/sns/core/presentation/BaseActivity;", "Lcom/sumsub/sns/presentation/screen/SNSAppViewModel;", "Lcom/sumsub/sns/core/common/SNSAppListener;", "Lcom/sumsub/sns/core/common/SNSErrorListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "getLayoutId", "()I", "onMoveToNextDocument", "()V", "", "isCancelled", "onMoveToVerificationScreen", "(Z)V", "Lcom/sumsub/sns/core/data/model/Document;", "document", "onDocumentUploaded", "(Lcom/sumsub/sns/core/data/model/Document;)V", "onDocumentClicked", "Ljava/lang/Exception;", "Lkotlin/Exception;", OkListener.KEY_EXCEPTION, "onThrowError", "(Ljava/lang/Exception;)V", "Lcom/sumsub/sns/core/data/model/Error;", "error", "onErrorAction", "(Lcom/sumsub/sns/core/data/model/Error;)V", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "result", "onCancel", "(Lcom/sumsub/sns/core/data/model/SNSCompletionResult;)V", "show", "onProgress", "onClose", "onBackPressed", AuthSource.BOOKING_ORDER, "f", "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/presentation/screen/SNSAppViewModel;", "viewModel", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "()Landroid/view/ViewGroup;", "vgProgress", "Ljava/lang/Runnable;", g.a, "Ljava/lang/Runnable;", "slowConnectionCallback", "<init>", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSAppActivity extends BaseActivity<SNSAppViewModel> implements SNSAppListener, SNSErrorListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final Lazy f = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SNSAppViewModel.class), new Function0<ViewModelStore>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$$special$$inlined$viewModels$2
        public final /* synthetic */ ComponentActivity a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.a.getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }, new e(this));
    public final Runnable g = new d(this);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/presentation/screen/SNSAppActivity$Companion;", "", "", "REQUEST_ID_LIVENESS_3DFACE", "I", "", "SLOW_CONNECTION_TIMEOUT", "J", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Observer<Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Boolean bool) {
            TextView textView;
            int i = this.a;
            if (i == 0) {
                Boolean bool2 = bool;
                Intrinsics.checkNotNullExpressionValue(bool2, "show");
                ((SNSAppActivity) this.b).onProgress(bool2.booleanValue());
            } else if (i == 1) {
                Boolean bool3 = bool;
                Intrinsics.checkNotNullExpressionValue(bool3, "show");
                if (bool3.booleanValue()) {
                    SNSAppActivity.access$scheduleSlowConnectionTimer((SNSAppActivity) this.b);
                    ViewGroup a3 = ((SNSAppActivity) this.b).a();
                    if (a3 != null) {
                        a3.setVisibility(0);
                        return;
                    }
                    return;
                }
                ViewGroup a4 = ((SNSAppActivity) this.b).a();
                if (a4 != null) {
                    a4.removeCallbacks(((SNSAppActivity) this.b).g);
                }
                ViewGroup a5 = ((SNSAppActivity) this.b).a();
                if (!(a5 == null || (textView = (TextView) a5.findViewById(R.id.progress_text)) == null)) {
                    textView.setText(((SNSAppActivity) this.b).getTextResource(R.string.sns_general_progress_text));
                }
                ViewGroup a6 = ((SNSAppActivity) this.b).a();
                if (a6 != null) {
                    a6.setVisibility(8);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Observer<Map<String, ? extends String>> {
        public final /* synthetic */ SNSAppActivity a;

        public b(SNSAppActivity sNSAppActivity) {
            this.a = sNSAppActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Map<String, ? extends String> map) {
            TextView textView;
            Map<String, ? extends String> map2 = map;
            ServiceLocator serviceLocator = this.a.getServiceLocator();
            Intrinsics.checkNotNullExpressionValue(map2, "strings");
            serviceLocator.setStrings(map2);
            ViewGroup a3 = this.a.a();
            if (a3 != null && (textView = (TextView) a3.findViewById(R.id.progress_text)) != null) {
                textView.setText(this.a.getTextResource(R.string.sns_general_progress_text));
            }
        }
    }

    public static final class c<T> implements Observer<Map<String, ? extends Map<String, ? extends String>>> {
        public final /* synthetic */ SNSAppActivity a;

        public c(SNSAppActivity sNSAppActivity) {
            this.a = sNSAppActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Map<String, ? extends Map<String, ? extends String>> map) {
            Map<String, ? extends Map<String, ? extends String>> map2 = map;
            ServiceLocator serviceLocator = this.a.getServiceLocator();
            Intrinsics.checkNotNullExpressionValue(map2, "dict");
            serviceLocator.setDictionaries(map2);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ SNSAppActivity a;

        public d(SNSAppActivity sNSAppActivity) {
            this.a = sNSAppActivity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextView textView;
            ViewGroup a3 = this.a.a();
            if (a3 != null && (textView = (TextView) a3.findViewById(R.id.progress_text)) != null) {
                textView.setText(this.a.getTextResource(R.string.sns_general_loadingTakesTooLong));
            }
        }
    }

    public static final class e extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSAppActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SNSAppActivity sNSAppActivity) {
            super(0);
            this.a = sNSAppActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSAppActivity sNSAppActivity = this.a;
            return new SNSAppViewModelFactory(sNSAppActivity, sNSAppActivity.getServiceLocator(), null, 4, null);
        }
    }

    public static final void access$scheduleSlowConnectionTimer(SNSAppActivity sNSAppActivity) {
        ViewGroup a3 = sNSAppActivity.a();
        if (a3 != null) {
            a3.removeCallbacks(sNSAppActivity.g);
        }
        ViewGroup a4 = sNSAppActivity.a();
        if (a4 != null) {
            a4.postDelayed(sNSAppActivity.g, TimeUnit.SECONDS.toMillis(7));
        }
    }

    public static final void access$showFragment(SNSAppActivity sNSAppActivity, Fragment fragment, String str) {
        FragmentManager supportFragmentManager = sNSAppActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
        beginTransaction.add(R.id.vg_container, fragment, str);
        beginTransaction.addToBackStack(str);
        beginTransaction.commit();
    }

    public final ViewGroup a() {
        return (ViewGroup) findViewById(R.id.vg_progress);
    }

    public final void b() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.vg_container);
        if (findFragmentById != null) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
            beginTransaction.remove(findFragmentById);
            beginTransaction.commit();
        }
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity
    public int getLayoutId() {
        return R.layout.sns_activity_app;
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity
    @NotNull
    public SNSAppViewModel getViewModel() {
        return (SNSAppViewModel) this.f.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3) {
            SNSLivenessReason sNSLivenessReason = null;
            SNSLivenessResult.FaceDetection faceDetection = intent != null ? (SNSLivenessResult.FaceDetection) intent.getParcelableExtra("EXTRA_RESULT") : null;
            Document document = intent != null ? (Document) intent.getParcelableExtra(SNSConstants.Intent.SNS_EXTRA_DOCUMENT) : null;
            if (faceDetection != null) {
                sNSLivenessReason = faceDetection.getReason();
            }
            boolean z = false;
            if (sNSLivenessReason instanceof SNSLivenessReason.VeritifcationSuccessfully) {
                if (document != null) {
                    onDocumentUploaded(document);
                    return;
                }
                if (i2 == 0) {
                    z = true;
                }
                onMoveToVerificationScreen(z);
            } else if (sNSLivenessReason instanceof SNSLivenessReason.UserCancelled) {
                onMoveToVerificationScreen(true);
            } else if (sNSLivenessReason instanceof SNSLivenessReason.CompletedUnsuccessfullyAllowContinue) {
                onMoveToNextDocument();
            } else {
                if (i2 == 0) {
                    z = true;
                }
                onMoveToVerificationScreen(z);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.vg_container);
        if (!(findFragmentById instanceof SNSBaseFragment)) {
            findFragmentById = null;
        }
        SNSBaseFragment sNSBaseFragment = (SNSBaseFragment) findFragmentById;
        if (sNSBaseFragment != null) {
            sNSBaseFragment.onBackPressed();
        } else {
            onClose();
        }
    }

    @Override // com.sumsub.sns.core.common.SNSAppListener
    public void onCancel(@NotNull SNSCompletionResult sNSCompletionResult) {
        Intrinsics.checkNotNullParameter(sNSCompletionResult, "result");
        getViewModel().onCancel(sNSCompletionResult);
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity, com.sumsub.sns.core.common.SNSAppListener
    public void onClose() {
        SNSCompletionResult sNSCompletionResult;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.vg_container);
        if (!(findFragmentById instanceof SNSBaseFragment)) {
            findFragmentById = null;
        }
        SNSBaseFragment sNSBaseFragment = (SNSBaseFragment) findFragmentById;
        if (sNSBaseFragment == null || (sNSCompletionResult = sNSBaseFragment.onCancelResult()) == null) {
            sNSCompletionResult = SNSCompletionResult.SuccessTermination.INSTANCE;
        }
        getViewModel().onCancel(sNSCompletionResult);
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Timber.i("SNS App Activity is started", new Object[0]);
        Timber.i(SNSMobileSDK.INSTANCE.toString(), new Object[0]);
        int i = R.id.toolbar;
        setSupportActionBar((Toolbar) findViewById(i));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) null);
        }
        Toolbar toolbar = (Toolbar) findViewById(i);
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new a2.q.a.d.a.a(this));
        }
        getViewModel().getStringsData().observe(this, new b(this));
        getViewModel().getDictData().observe(this, new c(this));
        getViewModel().getShowProgress().observe(this, new a(0, this));
        getViewModel().getProgress().observe(this, new a(1, this));
        getViewModel().getCancel().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$onCreate$$inlined$observeEvent$1
            public final /* synthetic */ SNSAppActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    SNSCompletionResult sNSCompletionResult = (SNSCompletionResult) contentIfNotHandled;
                    this.a.finish();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getShowVerificationScreen().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$onCreate$$inlined$observeEvent$2
            public final /* synthetic */ SNSAppActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null) {
                    FragmentManager supportFragmentManager = this.a.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
                    beginTransaction.replace(R.id.vg_container, SNSVerificationFragment.Companion.newInstance(), SNSVerificationFragment.TAG);
                    beginTransaction.commit();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getShowActionsScreen().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$onCreate$$inlined$observeEvent$3
            public final /* synthetic */ SNSAppActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    FragmentManager supportFragmentManager = this.a.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
                    beginTransaction.replace(R.id.vg_container, SNSActionsFragment.Companion.newInstance((String) contentIfNotHandled, this.a.getServiceLocator().getSession()), SNSActionsFragment.TAG);
                    beginTransaction.commit();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getShowPreviewIdentity().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$onCreate$$inlined$observeEvent$4
            public final /* synthetic */ SNSAppActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    FragmentManager supportFragmentManager = this.a.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
                    beginTransaction.replace(R.id.vg_container, SNSPreviewIdentityDocumentFragment.Companion.newInstance((Document) contentIfNotHandled), SNSPreviewIdentityDocumentFragment.TAG);
                    beginTransaction.commit();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getShowPreviewSelfie().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$onCreate$$inlined$observeEvent$5
            public final /* synthetic */ SNSAppActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    FragmentManager supportFragmentManager = this.a.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
                    beginTransaction.replace(R.id.vg_container, SNSPreviewSelfieFragment.Companion.newInstance(this.a.getServiceLocator().getSession(), (Document) contentIfNotHandled), SNSPreviewSelfieFragment.TAG);
                    beginTransaction.commit();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getShowPreviewApplicant().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$onCreate$$inlined$observeEvent$6
            public final /* synthetic */ SNSAppActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    FragmentManager supportFragmentManager = this.a.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
                    beginTransaction.replace(R.id.vg_container, SNSApplicantDataDocumentFragment.Companion.newInstance((Document) contentIfNotHandled), SNSApplicantDataDocumentFragment.TAG);
                    beginTransaction.commit();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getShowPreviewCommonData().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$onCreate$$inlined$observeEvent$7
            public final /* synthetic */ SNSAppActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    FragmentManager supportFragmentManager = this.a.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
                    beginTransaction.replace(R.id.vg_container, SNSPreviewCommonDocumentFragment.Companion.newInstance((Document) contentIfNotHandled), SNSPreviewCommonDocumentFragment.TAG);
                    beginTransaction.commit();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getShowLiveness().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$onCreate$$inlined$observeEvent$8
            public final /* synthetic */ SNSAppActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    Document document = (Document) contentIfNotHandled;
                    this.a.startActivityForResult(new Intent(this.a, SNSLiveness3dFaceActivity.class).putExtra("EXTRA_ID_DOC_SET_TYPE", document.getType().getValue()).putExtra(SNSConstants.Intent.SNS_EXTRA_SESSION, this.a.getSession()).putExtra(SNSConstants.Intent.SNS_EXTRA_DOCUMENT, document), 3);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getShowError().observe(this, new SNSAppActivity$onCreate$$inlined$observeEvent$9(this));
        getViewModel().getHandleErrorAction().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.SNSAppActivity$onCreate$$inlined$observeEvent$10
            public final /* synthetic */ SNSAppActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (!(event == null || (contentIfNotHandled = event.getContentIfNotHandled()) == null)) {
                    Error error = (Error) contentIfNotHandled;
                    FragmentManager supportFragmentManager = this.a.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    List<Fragment> fragments = supportFragmentManager.getFragments();
                    Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
                    for (T t : fragments) {
                        if (!(t instanceof BaseFragment)) {
                            t = null;
                        }
                        T t2 = t;
                        if (t2 != null) {
                            t2.onHandleError(error);
                        }
                    }
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
    }

    @Override // com.sumsub.sns.core.common.SNSAppListener
    public void onDocumentClicked(@NotNull Document document) {
        Intrinsics.checkNotNullParameter(document, "document");
        getViewModel().onDocumentClicked(document);
    }

    @Override // com.sumsub.sns.core.common.SNSAppListener
    public void onDocumentUploaded(@NotNull Document document) {
        Intrinsics.checkNotNullParameter(document, "document");
        getViewModel().onDocumentUploaded(document);
    }

    @Override // com.sumsub.sns.core.common.SNSAppListener
    public void onErrorAction(@NotNull Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        getSupportFragmentManager().popBackStackImmediate();
        getViewModel().onHandleError(error);
    }

    @Override // com.sumsub.sns.core.common.SNSAppListener
    public void onMoveToNextDocument() {
        b();
        SNSAppViewModel.onMoveToNextDocument$default(getViewModel(), false, 1, null);
    }

    @Override // com.sumsub.sns.core.common.SNSAppListener
    public void onMoveToVerificationScreen(boolean z) {
        b();
        getViewModel().onMoveToVerificationScreen(z);
    }

    @Override // com.sumsub.sns.core.common.SNSAppListener
    public void onProgress(boolean z) {
        getViewModel().onProgress(z);
    }

    @Override // com.sumsub.sns.core.common.SNSErrorListener
    public void onThrowError(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
        getViewModel().onThrowError(exc);
    }
}
