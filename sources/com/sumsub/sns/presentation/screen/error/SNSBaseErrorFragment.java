package com.sumsub.sns.presentation.screen.error;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.sumsub.sns.core.common.SNSAppListener;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.base.SNSBaseFragment;
import com.sumsub.sns.presentation.screen.error.SNSBaseErrorViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\r\u0010\fJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/presentation/screen/error/SNSBaseErrorFragment;", "Lcom/sumsub/sns/presentation/screen/error/SNSBaseErrorViewModel;", "VM", "Lcom/sumsub/sns/presentation/screen/base/SNSBaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onBackPressed", "()V", "<init>", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseErrorFragment<VM extends SNSBaseErrorViewModel> extends SNSBaseFragment<VM> {
    @Override // com.sumsub.sns.presentation.screen.base.SNSBaseFragment
    public void onBackPressed() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof SNSAppListener)) {
            activity = null;
        }
        SNSAppListener sNSAppListener = (SNSAppListener) activity;
        if (sNSAppListener != null) {
            sNSAppListener.onClose();
        }
    }

    @Override // com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LiveData<Event<Error>> close = ((SNSBaseErrorViewModel) getViewModel()).getClose();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        close.observe(viewLifecycleOwner, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.error.SNSBaseErrorFragment$onViewCreated$$inlined$observeEvent$1
            public final /* synthetic */ SNSBaseErrorFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    Error error = (Error) contentIfNotHandled;
                    FragmentActivity activity = this.a.getActivity();
                    if (!(activity instanceof SNSAppListener)) {
                        activity = null;
                    }
                    SNSAppListener sNSAppListener = (SNSAppListener) activity;
                    if (sNSAppListener != null) {
                        sNSAppListener.onErrorAction(error);
                    }
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
    }
}
