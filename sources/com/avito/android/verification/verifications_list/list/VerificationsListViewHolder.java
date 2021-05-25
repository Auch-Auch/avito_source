package com.avito.android.verification.verifications_list.list;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import com.avito.android.util.Contexts;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.verification.R;
import com.avito.android.verification.VerificationStatus;
import com.avito.android.verification.verifications_list.list.VerificationsListView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00052\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00052\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0016\u0010$\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001f¨\u0006)"}, d2 = {"Lcom/avito/android/verification/verifications_list/list/VerificationsListViewHolder;", "Lcom/avito/android/verification/verifications_list/list/VerificationsListView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setSubTitle", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Landroid/view/View$OnClickListener;)V", "Lcom/avito/android/verification/VerificationStatus;", "status", "setStatus", "(Lcom/avito/android/verification/VerificationStatus;)V", "", "iconResAttr", "t", "(Ljava/lang/Integer;)V", "colorResAttr", "u", VKApiConst.VERSION, "(I)V", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconView", "subTitleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationsListViewHolder extends BaseViewHolder implements VerificationsListView {
    public final Context s;
    public final TextView t;
    public final TextView u;
    public final ImageView v;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VerificationStatus.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            VerificationStatus verificationStatus = VerificationStatus.IN_PROGRESS;
            iArr[0] = 1;
            VerificationStatus verificationStatus2 = VerificationStatus.INFO;
            iArr[2] = 2;
            VerificationStatus verificationStatus3 = VerificationStatus.ERROR;
            iArr[1] = 3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationsListViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = view.getContext();
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.subtitle)");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.icon)");
        this.v = (ImageView) findViewById3;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        VerificationsListView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.verification.verifications_list.list.VerificationsListView
    public void setClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.itemView.setOnClickListener(onClickListener);
    }

    @Override // com.avito.android.verification.verifications_list.list.VerificationsListView
    public void setStatus(@NotNull VerificationStatus verificationStatus) {
        Intrinsics.checkNotNullParameter(verificationStatus, "status");
        int ordinal = verificationStatus.ordinal();
        if (ordinal == 0) {
            t(Integer.valueOf(com.avito.android.lib.design.R.attr.ic_time16));
            u(Integer.valueOf(com.avito.android.lib.design.R.attr.gray28));
            v(com.avito.android.lib.design.R.attr.gray48);
        } else if (ordinal == 1) {
            t(Integer.valueOf(com.avito.android.lib.design.R.attr.ic_attentionRound16));
            int i = com.avito.android.lib.design.R.attr.red;
            u(Integer.valueOf(i));
            v(i);
        } else if (ordinal == 2) {
            t(null);
            u(null);
            v(com.avito.android.lib.design.R.attr.gray48);
        }
    }

    @Override // com.avito.android.verification.verifications_list.list.VerificationsListView
    public void setSubTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.u.setText(str);
    }

    @Override // com.avito.android.verification.verifications_list.list.VerificationsListView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.t.setText(str);
    }

    public final void t(@AttrRes Integer num) {
        Drawable drawable;
        ImageView imageView = this.v;
        if (num != null) {
            int intValue = num.intValue();
            Context context = this.s;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            drawable = Contexts.getDrawableByAttr(context, intValue);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void u(@AttrRes Integer num) {
        ColorStateList colorStateList;
        ImageView imageView = this.v;
        if (num != null) {
            int intValue = num.intValue();
            Context context = this.s;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            colorStateList = Contexts.getColorStateListByAttr(context, intValue);
        } else {
            colorStateList = null;
        }
        ImageViewsKt.setImageTintListCompat(imageView, colorStateList);
    }

    public final void v(@AttrRes int i) {
        TextView textView = this.u;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(Contexts.getColorByAttr(context, i));
    }
}
