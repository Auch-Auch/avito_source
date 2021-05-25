package com.sumsub.sns.presentation.screen.verification;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.SNSAppListener;
import com.sumsub.sns.core.data.model.ApplicantStatus;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.base.SNSBaseFragment;
import com.sumsub.sns.presentation.screen.documents.require.SNSRequireDocumentsFragment;
import com.sumsub.sns.presentation.screen.documents.reviewed.SNSReviewedDocumentsFragment;
import com.sumsub.sns.presentation.screen.documents.reviewing.SNSReviewingDocumentsFragment;
import com.sumsub.sns.presentation.screen.documents.submitting.SNSSubmittingDocumentsFragment;
import com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/presentation/screen/verification/SNSVerificationFragment;", "Lcom/sumsub/sns/presentation/screen/base/SNSBaseFragment;", "Lcom/sumsub/sns/presentation/screen/verification/SNSVerificationViewModel;", "", "getLayoutId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onBackPressed", "()V", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/presentation/screen/verification/SNSVerificationViewModel;", "viewModel", "<init>", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSVerificationFragment extends SNSBaseFragment<SNSVerificationViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "VerificationFragment";
    @NotNull
    public final Lazy b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSVerificationViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.presentation.screen.verification.SNSVerificationFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.presentation.screen.verification.SNSVerificationFragment$$special$$inlined$viewModels$2
        public final /* synthetic */ Function0 a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.a.invoke()).getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }, new a(this));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/presentation/screen/verification/SNSVerificationFragment$Companion;", "", "Landroidx/fragment/app/Fragment;", "newInstance", "()Landroidx/fragment/app/Fragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance() {
            return new SNSVerificationFragment();
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicantStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            iArr[4] = 5;
        }
    }

    public static final class a extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSVerificationFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSVerificationFragment sNSVerificationFragment) {
            super(0);
            this.a = sNSVerificationFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSVerificationFragment sNSVerificationFragment = this.a;
            return new SNSVerificationViewModelFactory(sNSVerificationFragment, sNSVerificationFragment.getServiceLocator(), this.a.getArguments());
        }
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    public int getLayoutId() {
        return R.layout.sns_fragment_verification;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    @NotNull
    public SNSVerificationViewModel getViewModel() {
        return (SNSVerificationViewModel) this.b.getValue();
    }

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
        LiveData<Boolean> showProgress = getViewModel().getShowProgress();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        showProgress.observe(viewLifecycleOwner, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.verification.SNSVerificationFragment$onViewCreated$$inlined$observe$1
            public final /* synthetic */ SNSVerificationFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                boolean booleanValue = t.booleanValue();
                FragmentActivity activity = this.a.getActivity();
                if (!(activity instanceof SNSAppListener)) {
                    activity = null;
                }
                SNSAppListener sNSAppListener = (SNSAppListener) activity;
                if (sNSAppListener != null) {
                    sNSAppListener.onProgress(booleanValue);
                }
            }
        });
        LiveData<Event<SNSVerificationViewModel.Params>> showDocumentsStatusScreen = getViewModel().getShowDocumentsStatusScreen();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        showDocumentsStatusScreen.observe(viewLifecycleOwner2, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.verification.SNSVerificationFragment$onViewCreated$$inlined$observeEvent$1
            public final /* synthetic */ SNSVerificationFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    SNSVerificationViewModel.Params params = (SNSVerificationViewModel.Params) contentIfNotHandled;
                    FragmentTransaction beginTransaction = this.a.getChildFragmentManager().beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
                    int ordinal = params.getStatus().ordinal();
                    if (ordinal == 0) {
                        beginTransaction.replace(R.id.vg_container, SNSRequireDocumentsFragment.Companion.newInstance(params.getApplicant(), params.getDocuments()), SNSRequireDocumentsFragment.TAG);
                    } else if (ordinal == 1) {
                        beginTransaction.replace(R.id.vg_container, SNSSubmittingDocumentsFragment.Companion.newInstance(params.getApplicant(), params.getDocuments()), SNSSubmittingDocumentsFragment.TAG);
                    } else if (ordinal == 2) {
                        beginTransaction.replace(R.id.vg_container, SNSReviewingDocumentsFragment.Companion.newInstance(params.getApplicant(), params.getDocuments()), SNSReviewingDocumentsFragment.TAG);
                    } else if (ordinal == 3) {
                        beginTransaction.replace(R.id.vg_container, SNSReviewedDocumentsFragment.Companion.newInstance(params.getApplicant(), params.getDocuments()), SNSReviewedDocumentsFragment.TAG);
                    } else if (ordinal == 4) {
                        FragmentActivity activity = this.a.getActivity();
                        if (!(activity instanceof SNSAppListener)) {
                            activity = null;
                        }
                        SNSAppListener sNSAppListener = (SNSAppListener) activity;
                        if (sNSAppListener != null) {
                            sNSAppListener.onClose();
                        }
                    }
                    beginTransaction.addToBackStack(null);
                    beginTransaction.commit();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
    }
}
