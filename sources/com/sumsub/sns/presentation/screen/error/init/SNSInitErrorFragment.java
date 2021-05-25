package com.sumsub.sns.presentation.screen.error.init;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0014\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/sumsub/sns/presentation/screen/error/init/SNSInitErrorFragment;", "Lcom/sumsub/sns/presentation/screen/error/SNSBaseErrorFragment;", "Lcom/sumsub/sns/presentation/screen/error/init/SNSInitErrorViewModel;", "", "getLayoutId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "onCancelResult", "()Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/presentation/screen/error/init/SNSInitErrorViewModel;", "viewModel", "Landroid/widget/ImageButton;", "btnRefresh", "Landroid/widget/ImageButton;", "getBtnRefresh", "()Landroid/widget/ImageButton;", "setBtnRefresh", "(Landroid/widget/ImageButton;)V", "<init>", "()V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSInitErrorFragment extends SNSBaseErrorFragment<SNSInitErrorViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "InitErrorFragment";
    @NotNull
    public final Lazy b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSInitErrorViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.presentation.screen.error.init.SNSInitErrorFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.presentation.screen.error.init.SNSInitErrorFragment$$special$$inlined$viewModels$2
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
    @BindView(2077)
    public ImageButton btnRefresh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/presentation/screen/error/init/SNSInitErrorFragment$Companion;", "", "Lcom/sumsub/sns/core/data/model/Error$Init;", "error", "Landroidx/fragment/app/Fragment;", "newInstance", "(Lcom/sumsub/sns/core/data/model/Error$Init;)Landroidx/fragment/app/Fragment;", "", "ARG_ERROR", "Ljava/lang/String;", "TAG", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance(@NotNull Error.Init init) {
            Intrinsics.checkNotNullParameter(init, "error");
            SNSInitErrorFragment sNSInitErrorFragment = new SNSInitErrorFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("arg_error", init);
            Unit unit = Unit.INSTANCE;
            sNSInitErrorFragment.setArguments(bundle);
            return sNSInitErrorFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SNSInitErrorFragment a;

        public a(SNSInitErrorFragment sNSInitErrorFragment) {
            this.a = sNSInitErrorFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getViewModel().onCloseClicked();
        }
    }

    public static final class b extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSInitErrorFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSInitErrorFragment sNSInitErrorFragment) {
            super(0);
            this.a = sNSInitErrorFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSInitErrorFragment sNSInitErrorFragment = this.a;
            return new SNSInitErrorViewModelFactory(sNSInitErrorFragment, sNSInitErrorFragment.getServiceLocator(), this.a.getArguments());
        }
    }

    @NotNull
    public final ImageButton getBtnRefresh() {
        ImageButton imageButton = this.btnRefresh;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
        }
        return imageButton;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    public int getLayoutId() {
        return R.layout.sns_fragment_init_error;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    @NotNull
    public SNSInitErrorViewModel getViewModel() {
        return (SNSInitErrorViewModel) this.b.getValue();
    }

    @Override // com.sumsub.sns.presentation.screen.base.SNSBaseFragment
    @NotNull
    public SNSCompletionResult onCancelResult() {
        Bundle arguments = getArguments();
        Exception exc = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("arg_error") : null;
        if (!(serializable instanceof Error.Init)) {
            serializable = null;
        }
        Error.Init init = (Error.Init) serializable;
        if (init != null) {
            exc = init.getException();
        }
        return new SNSCompletionResult.AbnormalTermination(exc);
    }

    @Override // com.sumsub.sns.presentation.screen.error.SNSBaseErrorFragment, com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ImageButton imageButton = this.btnRefresh;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
        }
        imageButton.setOnClickListener(new a(this));
    }

    public final void setBtnRefresh(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.btnRefresh = imageButton;
    }
}
