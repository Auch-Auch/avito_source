package com.sumsub.sns.presentation.screen.base;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.sumsub.sns.core.common.SNSAppListener;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.presentation.BaseFragment;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.core.presentation.dialog.SupportBottomSheet;
import com.sumsub.sns.presentation.screen.SNSAppActivity;
import com.sumsub.sns.presentation.screen.base.SNSBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import saschpe.android.customtabs.CustomTabsHelper;
import saschpe.android.customtabs.WebViewFallback;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0010\u0010\fJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/presentation/screen/base/SNSBaseFragment;", "Lcom/sumsub/sns/presentation/screen/base/SNSBaseViewModel;", "VM", "Lcom/sumsub/sns/core/presentation/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onBackPressed", "()V", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "onCancelResult", "()Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "<init>", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseFragment<VM extends SNSBaseViewModel> extends BaseFragment<VM> {
    public void onBackPressed() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof SNSAppListener)) {
            activity = null;
        }
        SNSAppListener sNSAppListener = (SNSAppListener) activity;
        if (sNSAppListener != null) {
            sNSAppListener.onMoveToVerificationScreen(true);
        }
    }

    @NotNull
    public SNSCompletionResult onCancelResult() {
        return SNSCompletionResult.SuccessTermination.INSTANCE;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LiveData<Event<SNSCompletionResult>> cancelVerification = ((SNSBaseViewModel) getViewModel()).getCancelVerification();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        cancelVerification.observe(viewLifecycleOwner, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.base.SNSBaseFragment$onViewCreated$$inlined$observeEvent$1
            public final /* synthetic */ SNSBaseFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    SNSCompletionResult sNSCompletionResult = (SNSCompletionResult) contentIfNotHandled;
                    FragmentActivity activity = this.a.getActivity();
                    if (!(activity instanceof SNSAppActivity)) {
                        activity = null;
                    }
                    SNSAppActivity sNSAppActivity = (SNSAppActivity) activity;
                    if (sNSAppActivity != null) {
                        sNSAppActivity.onCancel(sNSCompletionResult);
                    }
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        LiveData<Event<Document>> showDocumentPreview = ((SNSBaseViewModel) getViewModel()).getShowDocumentPreview();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        showDocumentPreview.observe(viewLifecycleOwner2, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.base.SNSBaseFragment$onViewCreated$$inlined$observeEvent$2
            public final /* synthetic */ SNSBaseFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    Document document = (Document) contentIfNotHandled;
                    FragmentActivity activity = this.a.getActivity();
                    if (!(activity instanceof SNSAppActivity)) {
                        activity = null;
                    }
                    SNSAppActivity sNSAppActivity = (SNSAppActivity) activity;
                    if (sNSAppActivity != null) {
                        sNSAppActivity.onDocumentClicked(document);
                    }
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        LiveData<Event<Uri>> showWebUrl = ((SNSBaseViewModel) getViewModel()).getShowWebUrl();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        showWebUrl.observe(viewLifecycleOwner3, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.base.SNSBaseFragment$onViewCreated$$inlined$observeEvent$3
            public final /* synthetic */ SNSBaseFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    CustomTabsIntent build = new CustomTabsIntent.Builder().setShowTitle(true).build();
                    Intrinsics.checkNotNullExpressionValue(build, "CustomTabsIntent.Builder…\n                .build()");
                    CustomTabsHelper.addKeepAliveExtra(this.a.getContext(), build.intent);
                    CustomTabsHelper.openCustomTab(this.a.getContext(), build, (Uri) contentIfNotHandled, new WebViewFallback());
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        ActionLiveData<Event<Object>> showSupport = ((SNSBaseViewModel) getViewModel()).getShowSupport();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        showSupport.observe(viewLifecycleOwner4, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.base.SNSBaseFragment$onViewCreated$$inlined$observeEvent$4
            public final /* synthetic */ SNSBaseFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null && this.a.getParentFragmentManager().findFragmentByTag(SupportBottomSheet.TAG) == null) {
                    SupportBottomSheet.Companion.newInstance().show(this.a.getParentFragmentManager(), SupportBottomSheet.TAG);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
    }
}
