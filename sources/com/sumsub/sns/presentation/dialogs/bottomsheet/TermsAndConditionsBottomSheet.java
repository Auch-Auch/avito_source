package com.sumsub.sns.presentation.dialogs.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.presentation.base.SNSBaseBottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/presentation/dialogs/bottomsheet/TermsAndConditionsBottomSheet;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseBottomSheetDialogFragment;", "", "getLayoutId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "<init>", "()V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class TermsAndConditionsBottomSheet extends SNSBaseBottomSheetDialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "TermsAndConditionsBottomSheet";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/presentation/dialogs/bottomsheet/TermsAndConditionsBottomSheet$Companion;", "", "", "data", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "newInstance", "(Ljava/lang/String;)Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "ARGS_DATA", "Ljava/lang/String;", "TAG", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final BottomSheetDialogFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "data");
            TermsAndConditionsBottomSheet termsAndConditionsBottomSheet = new TermsAndConditionsBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString("ARGS_DATA", str);
            termsAndConditionsBottomSheet.setArguments(bundle);
            return termsAndConditionsBottomSheet;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TermsAndConditionsBottomSheet a;

        public a(TermsAndConditionsBottomSheet termsAndConditionsBottomSheet) {
            this.a = termsAndConditionsBottomSheet;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.dismissAllowingStateLoss();
        }
    }

    @Override // com.sumsub.sns.core.presentation.base.SNSBaseBottomSheetDialogFragment
    public int getLayoutId() {
        return R.layout.sns_bottom_sheet_terms_and_conditions;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Button button = (Button) view.findViewById(R.id.btn_close);
        Intrinsics.checkNotNullExpressionValue(button, "btnClose");
        Context context = getContext();
        String str = null;
        button.setText(context != null ? ExtensionsKt.getStringResource$default(context, R.string.sns_tos_action_accept, (String) null, 2, (Object) null) : null);
        button.setOnClickListener(new a(this));
        WebView webView = (WebView) view.findViewById(R.id.webview);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("ARGS_DATA");
        }
        webView.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
    }
}
