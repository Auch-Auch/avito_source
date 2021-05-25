package com.sumsub.sns.core.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.presentation.base.SNSBaseViewModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b0\u0010\u0012J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H$¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u0017H\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u001e2\b\b\u0001\u0010\u001a\u001a\u00020\u0017H\u0004¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/sumsub/sns/core/presentation/BaseFragment;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "Lcom/sumsub/sns/core/data/model/Error;", "error", "onHandleError", "(Lcom/sumsub/sns/core/data/model/Error;)V", "", "getLayoutId", "()I", "id", "", "getTextResource", "(I)Ljava/lang/CharSequence;", "", "getStringResource", "(I)Ljava/lang/String;", "Lcom/sumsub/sns/core/ServiceLocator;", "getServiceLocator", "()Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "getViewModel", "()Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "viewModel", "Lcom/sumsub/sns/core/common/SNSSession;", "getSession", "()Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "Lbutterknife/Unbinder;", AuthSource.SEND_ABUSE, "Lbutterknife/Unbinder;", "unbinder", "<init>", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseFragment<VM extends SNSBaseViewModel> extends Fragment {
    public Unbinder a;

    public abstract int getLayoutId();

    @NotNull
    public final ServiceLocator getServiceLocator() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.sumsub.sns.core.presentation.BaseActivity<*>");
        return ((BaseActivity) activity).getServiceLocator();
    }

    @NotNull
    public final SNSSession getSession() {
        return getServiceLocator().getSession();
    }

    @NotNull
    public final String getStringResource(@StringRes int i) {
        return getTextResource(i).toString();
    }

    @NotNull
    public final CharSequence getTextResource(@StringRes int i) {
        return getServiceLocator().getStringResourceRepository().getString(i);
    }

    @NotNull
    public abstract VM getViewModel();

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        this.a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Unbinder unbinder = this.a;
        if (unbinder != null) {
            unbinder.unbind();
        }
        this.a = null;
    }

    public final void onHandleError(@NotNull Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        getViewModel().onHandleError(error);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r2 != null) goto L_0x0057;
     */
    @Override // androidx.fragment.app.Fragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(@org.jetbrains.annotations.NotNull android.view.View r4, @org.jetbrains.annotations.Nullable android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            super.onViewCreated(r4, r5)
            int r5 = com.sumsub.sns.core.R.id.tv_powered
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x001b
            int r0 = com.sumsub.sns.core.R.string.sns_general_poweredBy
            java.lang.CharSequence r0 = r3.getTextResource(r0)
            r5.setText(r0)
        L_0x001b:
            int r5 = com.sumsub.sns.core.R.string.sns_general_progress_text
            java.lang.CharSequence r5 = r3.getTextResource(r5)
            int r0 = r5.length()
            r1 = 0
            if (r0 <= 0) goto L_0x002a
            r0 = 1
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            r2 = 0
            if (r0 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r5 = r2
        L_0x0030:
            if (r5 == 0) goto L_0x0046
            int r0 = com.sumsub.sns.core.R.id.progress_text
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0043
            r0.setVisibility(r1)
            r0.setText(r5)
            r2 = r0
        L_0x0043:
            if (r2 == 0) goto L_0x0046
            goto L_0x0057
        L_0x0046:
            int r5 = com.sumsub.sns.core.R.id.progress_text
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0055
            r5 = 8
            r4.setVisibility(r5)
        L_0x0055:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x0057:
            com.sumsub.sns.core.presentation.base.SNSBaseViewModel r4 = r3.getViewModel()
            androidx.lifecycle.LiveData r4 = r4.getThrowError()
            androidx.lifecycle.LifecycleOwner r5 = r3.getViewLifecycleOwner()
            java.lang.String r0 = "viewLifecycleOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            com.sumsub.sns.core.presentation.BaseFragment$onViewCreated$$inlined$observeEvent$1 r0 = new com.sumsub.sns.core.presentation.BaseFragment$onViewCreated$$inlined$observeEvent$1
            r0.<init>(r3)
            r4.observe(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.BaseFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
