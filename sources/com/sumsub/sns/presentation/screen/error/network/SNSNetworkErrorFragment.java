package com.sumsub.sns.presentation.screen.error.network;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import butterknife.BindView;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.presentation.screen.error.SNSBaseErrorFragment;
import java.io.Serializable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001d\u0010\u001e\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/sumsub/sns/presentation/screen/error/network/SNSNetworkErrorFragment;", "Lcom/sumsub/sns/presentation/screen/error/SNSBaseErrorFragment;", "Lcom/sumsub/sns/presentation/screen/error/network/SNSNetworkErrorViewModel;", "", "getLayoutId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "onCancelResult", "()Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "Landroid/widget/TextView;", "tvSubTitle", "Landroid/widget/TextView;", "getTvSubTitle", "()Landroid/widget/TextView;", "setTvSubTitle", "(Landroid/widget/TextView;)V", "tvTitle", "getTvTitle", "setTvTitle", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/presentation/screen/error/network/SNSNetworkErrorViewModel;", "viewModel", "Landroid/widget/Button;", "btnTryAgain", "Landroid/widget/Button;", "getBtnTryAgain", "()Landroid/widget/Button;", "setBtnTryAgain", "(Landroid/widget/Button;)V", "<init>", "()V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSNetworkErrorFragment extends SNSBaseErrorFragment<SNSNetworkErrorViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "NetworkErrorFragment";
    @NotNull
    public final Lazy b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSNetworkErrorViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.presentation.screen.error.network.SNSNetworkErrorFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.presentation.screen.error.network.SNSNetworkErrorFragment$$special$$inlined$viewModels$2
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
    @BindView(2085)
    public Button btnTryAgain;
    @BindView(2481)
    public TextView tvSubTitle;
    @BindView(2483)
    public TextView tvTitle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/presentation/screen/error/network/SNSNetworkErrorFragment$Companion;", "", "Lcom/sumsub/sns/core/data/model/Error$Network;", "error", "Landroidx/fragment/app/Fragment;", "newInstance", "(Lcom/sumsub/sns/core/data/model/Error$Network;)Landroidx/fragment/app/Fragment;", "", "ARG_ERROR", "Ljava/lang/String;", "TAG", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance(@NotNull Error.Network network) {
            Intrinsics.checkNotNullParameter(network, "error");
            SNSNetworkErrorFragment sNSNetworkErrorFragment = new SNSNetworkErrorFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("arg_error", network);
            Unit unit = Unit.INSTANCE;
            sNSNetworkErrorFragment.setArguments(bundle);
            return sNSNetworkErrorFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SNSNetworkErrorFragment a;

        public a(SNSNetworkErrorFragment sNSNetworkErrorFragment) {
            this.a = sNSNetworkErrorFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getViewModel().onCloseClicked();
        }
    }

    public static final class b extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSNetworkErrorFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSNetworkErrorFragment sNSNetworkErrorFragment) {
            super(0);
            this.a = sNSNetworkErrorFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSNetworkErrorFragment sNSNetworkErrorFragment = this.a;
            return new SNSNetworkErrorViewModelFactory(sNSNetworkErrorFragment, sNSNetworkErrorFragment.getServiceLocator(), this.a.getArguments());
        }
    }

    @NotNull
    public final Button getBtnTryAgain() {
        Button button = this.btnTryAgain;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTryAgain");
        }
        return button;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    public int getLayoutId() {
        return R.layout.sns_fragment_network_error;
    }

    @NotNull
    public final TextView getTvSubTitle() {
        TextView textView = this.tvSubTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvTitle() {
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        return textView;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    @NotNull
    public SNSNetworkErrorViewModel getViewModel() {
        return (SNSNetworkErrorViewModel) this.b.getValue();
    }

    @Override // com.sumsub.sns.presentation.screen.base.SNSBaseFragment
    @NotNull
    public SNSCompletionResult onCancelResult() {
        Bundle arguments = getArguments();
        Exception exc = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("arg_error") : null;
        if (!(serializable instanceof Error.Network)) {
            serializable = null;
        }
        Error.Network network = (Error.Network) serializable;
        if (network != null) {
            exc = network.getException();
        }
        return new SNSCompletionResult.AbnormalTermination(exc);
    }

    @Override // com.sumsub.sns.presentation.screen.error.SNSBaseErrorFragment, com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        textView.setText(getTextResource(R.string.sns_oops_network_title));
        TextView textView2 = this.tvSubTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
        }
        textView2.setText(getTextResource(R.string.sns_oops_network_html));
        Button button = this.btnTryAgain;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTryAgain");
        }
        button.setText(getTextResource(R.string.sns_oops_action_retry));
        Button button2 = this.btnTryAgain;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTryAgain");
        }
        button2.setOnClickListener(new a(this));
    }

    public final void setBtnTryAgain(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnTryAgain = button;
    }

    public final void setTvSubTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvSubTitle = textView;
    }

    public final void setTvTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTitle = textView;
    }
}
