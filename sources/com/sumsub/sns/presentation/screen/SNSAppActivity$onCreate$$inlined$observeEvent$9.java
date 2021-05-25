package com.sumsub.sns.presentation.screen;

import android.content.DialogInterface;
import androidx.lifecycle.Observer;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.error.common.SNSCommonErrorFragment;
import com.sumsub.sns.presentation.screen.error.network.SNSNetworkErrorFragment;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lcom/sumsub/sns/core/presentation/base/Event;", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Lcom/sumsub/sns/core/presentation/base/Event;)V", "com/sumsub/sns/core/common/ExtensionsKt$observeEvent$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SNSAppActivity$onCreate$$inlined$observeEvent$9<T> implements Observer<Event<? extends T>> {
    public final /* synthetic */ SNSAppActivity a;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Error a;
        public final /* synthetic */ SNSAppActivity$onCreate$$inlined$observeEvent$9 b;

        public a(Error error, SNSAppActivity$onCreate$$inlined$observeEvent$9 sNSAppActivity$onCreate$$inlined$observeEvent$9) {
            this.a = error;
            this.b = sNSAppActivity$onCreate$$inlined$observeEvent$9;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            SNSException.Api exception = ((Error.Upload) this.a).getException();
            Integer errorCode = exception != null ? exception.getErrorCode() : null;
            if ((errorCode != null && errorCode.intValue() == 1001) || (errorCode != null && errorCode.intValue() == 1006)) {
                this.b.a.getViewModel().onMoveToVerificationScreen(false);
            }
            dialogInterface.dismiss();
        }
    }

    public SNSAppActivity$onCreate$$inlined$observeEvent$9(SNSAppActivity sNSAppActivity) {
        this.a = sNSAppActivity;
    }

    public final void onChanged(Event<? extends T> event) {
        Object contentIfNotHandled;
        if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
            Error error = (Error) contentIfNotHandled;
            if (error instanceof Error.Common) {
                SNSAppActivity.access$showFragment(this.a, SNSCommonErrorFragment.Companion.newInstance((Error.Common) error), SNSCommonErrorFragment.TAG);
            } else if (error instanceof Error.Network) {
                SNSAppActivity.access$showFragment(this.a, SNSNetworkErrorFragment.Companion.newInstance((Error.Network) error), SNSNetworkErrorFragment.TAG);
            } else if (error instanceof Error.Init) {
                this.a.getViewModel().onCancel(new SNSCompletionResult.AbnormalTermination(((Error.Init) error).getException()));
            } else if (error instanceof Error.Upload) {
                new MaterialAlertDialogBuilder(this.a).setMessage((CharSequence) ((Error.Upload) error).getDescription()).setPositiveButton(this.a.getTextResource(R.string.sns_alert_action_ok), (DialogInterface.OnClickListener) new a(error, this)).show();
            }
        }
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object obj) {
        onChanged((Event) ((Event) obj));
    }
}
