package com.sumsub.sns.core.presentation;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.avito.android.util.preferences.SessionContract;
import com.sumsub.sns.core.R;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSLogTree;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.presentation.base.SNSBaseViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\"\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b-\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0015¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0011H$¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\u0014\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00028\u00008$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/sumsub/sns/core/presentation/BaseActivity;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "VM", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "()V", "outState", "onSaveInstanceState", "init", "onClose", "onResume", "onPause", "", "getLayoutId", "()I", "id", "", "getTextResource", "(I)Ljava/lang/CharSequence;", "Lcom/sumsub/sns/core/ServiceLocator;", "c", "Lkotlin/Lazy;", "getServiceLocator", "()Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "Lbutterknife/Unbinder;", "d", "Lbutterknife/Unbinder;", "unbinder", "com/sumsub/sns/core/presentation/BaseActivity$broadcastReceiver$1", "e", "Lcom/sumsub/sns/core/presentation/BaseActivity$broadcastReceiver$1;", "broadcastReceiver", "getViewModel", "()Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "viewModel", "Lcom/sumsub/sns/core/common/SNSSession;", "getSession", "()Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "<init>", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseActivity<VM extends SNSBaseViewModel> extends AppCompatActivity {
    @NotNull
    public final Lazy c = c.lazy(new a(this));
    public Unbinder d;
    public final BaseActivity$broadcastReceiver$1 e = new BaseActivity$broadcastReceiver$1(this);

    public static final class a extends Lambda implements Function0<ServiceLocator> {
        public final /* synthetic */ BaseActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BaseActivity baseActivity) {
            super(0);
            this.a = baseActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ServiceLocator invoke() {
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            BaseActivity baseActivity = this.a;
            return companion.instance(baseActivity, baseActivity.getSession());
        }
    }

    public abstract int getLayoutId();

    @NotNull
    public final ServiceLocator getServiceLocator() {
        return (ServiceLocator) this.c.getValue();
    }

    @NotNull
    public final SNSSession getSession() {
        Parcelable parcelableExtra = getIntent().getParcelableExtra(SNSConstants.Intent.SNS_EXTRA_SESSION);
        Intrinsics.checkNotNull(parcelableExtra);
        return (SNSSession) parcelableExtra;
    }

    @NotNull
    public final CharSequence getTextResource(@StringRes int i) {
        return getServiceLocator().getStringResourceRepository().getString(i);
    }

    @NotNull
    public abstract VM getViewModel();

    @CallSuper
    public void init() {
        if (SNSMobileSDK.INSTANCE.isDebug()) {
            List<Timber.Tree> forest = Timber.forest();
            Intrinsics.checkNotNullExpressionValue(forest, "Timber.forest()");
            ArrayList<SNSLogTree> arrayList = new ArrayList();
            for (T t : forest) {
                if (t instanceof SNSLogTree) {
                    arrayList.add(t);
                }
            }
            for (SNSLogTree sNSLogTree : arrayList) {
                Timber.uproot(sNSLogTree);
            }
            Timber.plant(SNSMobileSDK.INSTANCE.getLogTree());
        }
    }

    @Override // com.sumsub.sns.core.common.SNSAppListener
    public void onClose() {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        init();
        TextView textView = null;
        if (bundle != null && bundle.containsKey(SNSConstants.Intent.SNS_EXTRA_SESSION)) {
            Parcelable parcelable = bundle.getParcelable(SNSConstants.Intent.SNS_EXTRA_SESSION);
            if (!(parcelable instanceof SNSSession)) {
                parcelable = null;
            }
            SNSSession sNSSession = (SNSSession) parcelable;
            if (sNSSession != null) {
                getIntent().putExtra(SNSConstants.Intent.SNS_EXTRA_SESSION, sNSSession);
            }
        }
        super.onCreate(bundle);
        boolean z = true;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(getLayoutId());
        this.d = ButterKnife.bind(this);
        TextView textView2 = (TextView) findViewById(R.id.tv_powered);
        if (textView2 != null) {
            textView2.setText(getTextResource(R.string.sns_general_poweredBy));
        }
        CharSequence textResource = getTextResource(R.string.sns_general_progress_text);
        if (textResource.length() <= 0) {
            z = false;
        }
        if (!z) {
            textResource = null;
        }
        if (textResource != null) {
            TextView textView3 = (TextView) findViewById(R.id.progress_text);
            if (textView3 != null) {
                textView3.setVisibility(0);
                textView3.setText(textResource);
                textView = textView3;
            }
            if (textView != null) {
                return;
            }
        }
        TextView textView4 = (TextView) findViewById(R.id.progress_text);
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.d;
        if (unbinder != null) {
            unbinder.unbind();
        }
        this.d = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        unregisterReceiver(this.e);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerReceiver(this.e, new IntentFilter(SNSConstants.Intent.SNS_ACTION_CLOSE));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(SNSConstants.Intent.SNS_EXTRA_SESSION, getServiceLocator().getSession());
    }
}
