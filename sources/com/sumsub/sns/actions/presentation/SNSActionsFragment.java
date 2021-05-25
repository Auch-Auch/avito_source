package com.sumsub.sns.actions.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import butterknife.BindView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import com.google.android.material.button.MaterialButton;
import com.sumsub.sns.actions.R;
import com.sumsub.sns.actions.presentation.SNSActionsViewModel;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSAppListener;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.data.listener.SNSCompleteHandler;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.presentation.BaseFragment;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceActivity;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010+\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010#\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001d\u00109\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010:\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/sumsub/sns/actions/presentation/SNSActionsFragment;", "Lcom/sumsub/sns/core/presentation/BaseFragment;", "Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel;", "", "getLayoutId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/google/android/material/button/MaterialButton;", "btnTryAgain", "Lcom/google/android/material/button/MaterialButton;", "getBtnTryAgain", "()Lcom/google/android/material/button/MaterialButton;", "setBtnTryAgain", "(Lcom/google/android/material/button/MaterialButton;)V", "Landroid/widget/ImageView;", "ivResultIcon", "Landroid/widget/ImageView;", "getIvResultIcon", "()Landroid/widget/ImageView;", "setIvResultIcon", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "tvErrorTitle", "Landroid/widget/TextView;", "getTvErrorTitle", "()Landroid/widget/TextView;", "setTvErrorTitle", "(Landroid/widget/TextView;)V", "tvResultMessage", "getTvResultMessage", "setTvResultMessage", "tvErrorSubtitle", "getTvErrorSubtitle", "setTvErrorSubtitle", "Landroid/view/ViewGroup;", "vgError", "Landroid/view/ViewGroup;", "getVgError", "()Landroid/view/ViewGroup;", "setVgError", "(Landroid/view/ViewGroup;)V", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel;", "viewModel", "vgResult", "Landroid/view/View;", "getVgResult", "()Landroid/view/View;", "setVgResult", "(Landroid/view/View;)V", "<init>", "()V", "Companion", "idensic-mobile-sdk-actions_release"}, k = 1, mv = {1, 4, 2})
public final class SNSActionsFragment extends BaseFragment<SNSActionsViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int REQUEST_ID_ACTION = 1;
    @NotNull
    public static final String TAG = "SNSActionsFragment";
    @NotNull
    public final Lazy b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSActionsViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.actions.presentation.SNSActionsFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.actions.presentation.SNSActionsFragment$$special$$inlined$viewModels$2
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
    }, new b(this));
    @BindView(1952)
    public MaterialButton btnTryAgain;
    @BindView(2064)
    public ImageView ivResultIcon;
    @BindView(2271)
    public TextView tvErrorSubtitle;
    @BindView(2272)
    public TextView tvErrorTitle;
    @BindView(2278)
    public TextView tvResultMessage;
    @BindView(2286)
    public ViewGroup vgError;
    @BindView(2289)
    public View vgResult;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/actions/presentation/SNSActionsFragment$Companion;", "", "", "actionId", "Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "Landroidx/fragment/app/Fragment;", "newInstance", "(Ljava/lang/String;Lcom/sumsub/sns/core/common/SNSSession;)Landroidx/fragment/app/Fragment;", "", "REQUEST_ID_ACTION", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk-actions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance(@NotNull String str, @NotNull SNSSession sNSSession) {
            Intrinsics.checkNotNullParameter(str, "actionId");
            Intrinsics.checkNotNullParameter(sNSSession, SessionContract.SESSION);
            SNSActionsFragment sNSActionsFragment = new SNSActionsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(SNSConstants.Arguments.ARGS_ACTION_ID, str);
            bundle.putParcelable(SNSConstants.Intent.SNS_EXTRA_SESSION, sNSSession);
            Unit unit = Unit.INSTANCE;
            sNSActionsFragment.setArguments(bundle);
            return sNSActionsFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SNSActionsFragment a;

        public a(SNSActionsFragment sNSActionsFragment) {
            this.a = sNSActionsFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getViewModel().onLoad();
        }
    }

    public static final class b extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSActionsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSActionsFragment sNSActionsFragment) {
            super(0);
            this.a = sNSActionsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSActionsFragment sNSActionsFragment = this.a;
            return new SNSActionsViewModelFactory(sNSActionsFragment, sNSActionsFragment.getServiceLocator(), this.a.getArguments());
        }
    }

    @NotNull
    public final MaterialButton getBtnTryAgain() {
        MaterialButton materialButton = this.btnTryAgain;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTryAgain");
        }
        return materialButton;
    }

    @NotNull
    public final ImageView getIvResultIcon() {
        ImageView imageView = this.ivResultIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivResultIcon");
        }
        return imageView;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    public int getLayoutId() {
        return R.layout.sns_fragment_actions;
    }

    @NotNull
    public final TextView getTvErrorSubtitle() {
        TextView textView = this.tvErrorSubtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvErrorSubtitle");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvErrorTitle() {
        TextView textView = this.tvErrorTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvErrorTitle");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvResultMessage() {
        TextView textView = this.tvResultMessage;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResultMessage");
        }
        return textView;
    }

    @NotNull
    public final ViewGroup getVgError() {
        ViewGroup viewGroup = this.vgError;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgError");
        }
        return viewGroup;
    }

    @NotNull
    public final View getVgResult() {
        View view = this.vgResult;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgResult");
        }
        return view;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    @NotNull
    public SNSActionsViewModel getViewModel() {
        return (SNSActionsViewModel) this.b.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            getViewModel().onHandleActionResult(i2, intent);
        }
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        MaterialButton materialButton = this.btnTryAgain;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTryAgain");
        }
        materialButton.setText(getTextResource(R.string.sns_oops_action_retry));
        MaterialButton materialButton2 = this.btnTryAgain;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTryAgain");
        }
        materialButton2.setOnClickListener(new a(this));
        getViewModel().getFinish().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.actions.presentation.SNSActionsFragment$onViewCreated$$inlined$observeEvent$1
            public final /* synthetic */ SNSActionsFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    try {
                        SNSMobileSDK sNSMobileSDK = SNSMobileSDK.INSTANCE;
                        SNSCompleteHandler completeHandler = sNSMobileSDK.getCompleteHandler();
                        if (completeHandler != null) {
                            completeHandler.onComplete((SNSCompletionResult) contentIfNotHandled, sNSMobileSDK.getState());
                        }
                    } catch (Exception e) {
                        Timber.e(e);
                    }
                    SNSMobileSDK.INSTANCE.shutdown();
                    FragmentActivity activity = this.a.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        LiveData<Boolean> showProgress = getViewModel().getShowProgress();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        showProgress.observe(viewLifecycleOwner, new Observer<T>(this) { // from class: com.sumsub.sns.actions.presentation.SNSActionsFragment$onViewCreated$$inlined$observe$1
            public final /* synthetic */ SNSActionsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
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
            }
        });
        LiveData<Boolean> showError = getViewModel().getShowError();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        showError.observe(viewLifecycleOwner2, new Observer<T>(this) { // from class: com.sumsub.sns.actions.presentation.SNSActionsFragment$onViewCreated$$inlined$observe$2
            public final /* synthetic */ SNSActionsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ExtensionsKt.visibleIf(this.a.getVgError(), t.booleanValue());
                }
            }
        });
        LiveData<SNSActionsViewModel.Error> error = getViewModel().getError();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        error.observe(viewLifecycleOwner3, new Observer<T>(this) { // from class: com.sumsub.sns.actions.presentation.SNSActionsFragment$onViewCreated$$inlined$observe$3
            public final /* synthetic */ SNSActionsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    this.a.getTvErrorTitle().setText(ExtensionsKt.asHtml(SNSActionsFragment.access$getStringResource(this.a, t2.getTitle())));
                    this.a.getTvErrorSubtitle().setText(t2.getSubtitle() > 0 ? ExtensionsKt.asHtml(SNSActionsFragment.access$getStringResource(this.a, t2.getSubtitle())) : null);
                }
            }
        });
        LiveData<Boolean> showResult = getViewModel().getShowResult();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        showResult.observe(viewLifecycleOwner4, new Observer<T>(this) { // from class: com.sumsub.sns.actions.presentation.SNSActionsFragment$onViewCreated$$inlined$observe$4
            public final /* synthetic */ SNSActionsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ExtensionsKt.visibleIf(this.a.getVgResult(), t.booleanValue());
                }
            }
        });
        LiveData<SNSActionsViewModel.Result> result = getViewModel().getResult();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        result.observe(viewLifecycleOwner5, new Observer<T>(this) { // from class: com.sumsub.sns.actions.presentation.SNSActionsFragment$onViewCreated$$inlined$observe$5
            public final /* synthetic */ SNSActionsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    this.a.getIvResultIcon().setImageResource(t2.getIconId());
                    this.a.getTvResultMessage().setText(t2.getMessage() > 0 ? ExtensionsKt.asHtml(SNSActionsFragment.access$getStringResource(this.a, t2.getMessage())) : null);
                }
            }
        });
        LiveData<Event<SNSActionsViewModel.LivenessParams>> showPassiveLiveness3d = getViewModel().getShowPassiveLiveness3d();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "viewLifecycleOwner");
        showPassiveLiveness3d.observe(viewLifecycleOwner6, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.actions.presentation.SNSActionsFragment$onViewCreated$$inlined$observeEvent$2
            public final /* synthetic */ SNSActionsFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    SNSActionsViewModel.LivenessParams livenessParams = (SNSActionsViewModel.LivenessParams) contentIfNotHandled;
                    SNSActionsFragment sNSActionsFragment = this.a;
                    Intent intent = new Intent(this.a.getContext(), SNSLiveness3dFaceActivity.class);
                    Bundle arguments = this.a.getArguments();
                    sNSActionsFragment.startActivityForResult(intent.putExtra(SNSConstants.Intent.SNS_EXTRA_SESSION, arguments != null ? (SNSSession) arguments.getParcelable(SNSConstants.Intent.SNS_EXTRA_SESSION) : null).putExtra("EXTRA_ID_DOC_SET_TYPE", livenessParams.getIdDocSetType()).putExtra("EXTRA_ACTION_ID", livenessParams.getActionId()).putExtra("EXTRA_ACTION_TYPE", livenessParams.getActionType().getValue()), 1);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        if (bundle == null) {
            getViewModel().onLoad();
        }
    }

    public final void setBtnTryAgain(@NotNull MaterialButton materialButton) {
        Intrinsics.checkNotNullParameter(materialButton, "<set-?>");
        this.btnTryAgain = materialButton;
    }

    public final void setIvResultIcon(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivResultIcon = imageView;
    }

    public final void setTvErrorSubtitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvErrorSubtitle = textView;
    }

    public final void setTvErrorTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvErrorTitle = textView;
    }

    public final void setTvResultMessage(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvResultMessage = textView;
    }

    public final void setVgError(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.vgError = viewGroup;
    }

    public final void setVgResult(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.vgResult = view;
    }
}
