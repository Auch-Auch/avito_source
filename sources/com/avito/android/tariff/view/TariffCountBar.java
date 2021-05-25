package com.avito.android.tariff.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.lib.design.R;
import com.avito.android.lib.expected.progress_bar.ProgressAnimator;
import com.avito.android.lib.expected.progress_bar.ProgressBar;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\u001f¢\u0006\u0004\b2\u00103J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010 \u001a\u00020\u001f*\u00020\u0013H\u0002¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u001f*\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010%R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010%¨\u00064"}, d2 = {"Lcom/avito/android/tariff/view/TariffCountBar;", "Landroid/widget/LinearLayout;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "bindSubtitle", "description", "bindDescription", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "status", "setDescriptionStatus", "(Lcom/avito/android/paid_services/routing/TariffCountStatus;)V", "", "value", "setProgress", "(F)V", "Lcom/avito/android/paid_services/routing/ProgressState;", "progressState", "setProgressState", "(Lcom/avito/android/paid_services/routing/ProgressState;)V", "startProgress", "startState", "finishProgress", "finishState", "", "delay", "showProgressAnimation", "(FLcom/avito/android/paid_services/routing/ProgressState;FLcom/avito/android/paid_services/routing/ProgressState;J)V", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/paid_services/routing/ProgressState;)I", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "descriptionTextView", "Lcom/avito/android/lib/expected/progress_bar/ProgressBar;", "d", "Lcom/avito/android/lib/expected/progress_bar/ProgressBar;", "progressBar", "subtitleTextView", "titleTextView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountBar extends LinearLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    public ProgressBar d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            TariffCountStatus.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
            ProgressState.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[1] = 1;
            iArr2[0] = 2;
            ProgressState.values();
            int[] iArr3 = new int[2];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[1] = 1;
            iArr3[0] = 2;
        }
    }

    @JvmOverloads
    public TariffCountBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public TariffCountBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TariffCountBar(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void showProgressAnimation$default(TariffCountBar tariffCountBar, float f, ProgressState progressState, float f2, ProgressState progressState2, long j, int i, Object obj) {
        if ((i & 16) != 0) {
            j = 0;
        }
        tariffCountBar.showProgressAnimation(f, progressState, f2, progressState2, j);
    }

    public final int a(ProgressState progressState) {
        int ordinal = progressState.ordinal();
        if (ordinal == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return Contexts.getColorByAttr(context, R.attr.green200);
        } else if (ordinal == 1) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            return Contexts.getColorByAttr(context2, R.attr.red100);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final int b(ProgressState progressState) {
        int ordinal = progressState.ordinal();
        if (ordinal == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return Contexts.getColorByAttr(context, R.attr.green600);
        } else if (ordinal == 1) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            return Contexts.getColorByAttr(context2, R.attr.red600);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void bindDescription(@Nullable String str) {
        TextView textView = this.c;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
        }
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    public final void bindSubtitle(@Nullable String str) {
        TextView textView = this.b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitleTextView");
        }
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    public final void setDescriptionStatus(@NotNull TariffCountStatus tariffCountStatus) {
        int i;
        Intrinsics.checkNotNullParameter(tariffCountStatus, "status");
        int ordinal = tariffCountStatus.ordinal();
        if (ordinal == 0) {
            i = R.attr.gray48;
        } else if (ordinal == 1) {
            i = R.attr.red600;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        TextView textView = this.c;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(Contexts.getColorByAttr(context, i));
    }

    public final void setProgress(float f) {
        ProgressBar progressBar = this.d;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setProgress(f);
    }

    public final void setProgressState(@NotNull ProgressState progressState) {
        Intrinsics.checkNotNullParameter(progressState, "progressState");
        ProgressBar progressBar = this.d;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setFillColor(b(progressState));
        ProgressBar progressBar2 = this.d;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar2.setEmptyColor(a(progressState));
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        }
        textView.setText(str);
    }

    public final void showProgressAnimation(float f, @NotNull ProgressState progressState, float f2, @NotNull ProgressState progressState2, long j) {
        Intrinsics.checkNotNullParameter(progressState, "startState");
        Intrinsics.checkNotNullParameter(progressState2, "finishState");
        ProgressAnimator progressAnimator = new ProgressAnimator(0, 0, j, 3, null);
        ProgressBar progressBar = this.d;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressAnimator.start(progressBar, f, f2, b(progressState), b(progressState2), a(progressState), a(progressState2));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TariffCountBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(com.avito.android.tariff.R.layout.count_bar_view, (ViewGroup) this, true);
        View findViewById = findViewById(com.avito.android.tariff.R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.a = (TextView) findViewById;
        View findViewById2 = findViewById(com.avito.android.tariff.R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        this.b = (TextView) findViewById2;
        View findViewById3 = findViewById(com.avito.android.tariff.R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.description)");
        this.c = (TextView) findViewById3;
        View findViewById4 = findViewById(com.avito.android.tariff.R.id.bar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.bar)");
        this.d = (ProgressBar) findViewById4;
        setOrientation(1);
        Resources resources = getResources();
        int i2 = com.avito.android.tariff.R.dimen.bar_vertical_padding;
        Views.changePadding$default(this, 0, resources.getDimensionPixelOffset(i2), 0, getResources().getDimensionPixelOffset(i2), 5, null);
    }
}
