package com.sumsub.sns.core.presentation.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.sumsub.sns.core.R;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.data.model.SNSSupportItem;
import com.sumsub.sns.core.presentation.base.SNSBaseBottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/sumsub/sns/core/presentation/dialog/SupportBottomSheet;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseBottomSheetDialogFragment;", "", "getLayoutId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/widget/TextView;", "tvSubtitle", "Landroid/widget/TextView;", "getTvSubtitle", "()Landroid/widget/TextView;", "setTvSubtitle", "(Landroid/widget/TextView;)V", "tvTitle", "getTvTitle", "setTvTitle", "Landroid/view/ViewGroup;", "vgItems", "Landroid/view/ViewGroup;", "getVgItems", "()Landroid/view/ViewGroup;", "setVgItems", "(Landroid/view/ViewGroup;)V", "<init>", "()V", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SupportBottomSheet extends SNSBaseBottomSheetDialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "SupportBottomSheet";
    public TextView tvSubtitle;
    public TextView tvTitle;
    public ViewGroup vgItems;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/presentation/dialog/SupportBottomSheet$Companion;", "", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "newInstance", "()Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final BottomSheetDialogFragment newInstance() {
            return new SupportBottomSheet();
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SNSSupportItem a;
        public final /* synthetic */ SupportBottomSheet b;

        public a(SNSSupportItem sNSSupportItem, SupportBottomSheet supportBottomSheet, LayoutInflater layoutInflater) {
            this.a = sNSSupportItem;
            this.b = supportBottomSheet;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SNSSupportItem sNSSupportItem = this.a;
            Context requireContext = this.b.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            if (!ExtensionsKt.resolve(sNSSupportItem, requireContext)) {
                StringBuilder L = a2.b.a.a.a.L("The SDK is not possible to resolve a click on support item (");
                L.append(this.a);
                L.append(')');
                Timber.e(L.toString(), new Object[0]);
            }
        }
    }

    @Override // com.sumsub.sns.core.presentation.base.SNSBaseBottomSheetDialogFragment
    public int getLayoutId() {
        return R.layout.sns_bottom_sheet_support;
    }

    @NotNull
    public final TextView getTvSubtitle() {
        TextView textView = this.tvSubtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
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

    @NotNull
    public final ViewGroup getVgItems() {
        ViewGroup viewGroup = this.vgItems;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgItems");
        }
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String stringResource$default;
        String stringResource$default2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(16908310);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(android.R.id.title)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = view.findViewById(16908299);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(android.R.id.message)");
        this.tvSubtitle = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.vg_items);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.vg_items)");
        this.vgItems = (ViewGroup) findViewById3;
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        Context context = getContext();
        textView.setText(context != null ? ExtensionsKt.getStringResource$default(context, R.string.sns_support_title, (String) null, 2, (Object) null) : null);
        TextView textView2 = this.tvSubtitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
        }
        Context context2 = getContext();
        textView2.setText(context2 != null ? ExtensionsKt.getStringResource$default(context2, R.string.sns_support_subtitle, (String) null, 2, (Object) null) : null);
        LayoutInflater from = LayoutInflater.from(requireContext());
        for (T t : SNSMobileSDK.INSTANCE.getSupportItems()) {
            String isValid = t.isValid();
            if (isValid == null || isValid.length() == 0) {
                int i = R.layout.sns_layout_support_item;
                ViewGroup viewGroup = this.vgItems;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vgItems");
                }
                View inflate = from.inflate(i, viewGroup, false);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_title);
                TextView textView4 = (TextView) inflate.findViewById(R.id.tv_subtitle);
                ((ImageView) inflate.findViewById(R.id.iv_icon)).setImageResource(t.getIconResId());
                Intrinsics.checkNotNullExpressionValue(textView3, "tvTitle");
                Context context3 = getContext();
                textView3.setText((context3 == null || (stringResource$default2 = ExtensionsKt.getStringResource$default(context3, t.getTitleResId(), null, 2, null)) == null) ? null : ExtensionsKt.asHtml(stringResource$default2));
                Intrinsics.checkNotNullExpressionValue(textView4, "tvSubtitle");
                Context context4 = getContext();
                textView4.setText((context4 == null || (stringResource$default = ExtensionsKt.getStringResource$default(context4, t.getSubtitleResId(), null, 2, null)) == null) ? null : ExtensionsKt.asHtml(stringResource$default));
                inflate.setOnClickListener(new a(t, this, from));
                ViewGroup viewGroup2 = this.vgItems;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vgItems");
                }
                viewGroup2.addView(inflate);
            }
        }
    }

    public final void setTvSubtitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvSubtitle = textView;
    }

    public final void setTvTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTitle = textView;
    }

    public final void setVgItems(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.vgItems = viewGroup;
    }
}
