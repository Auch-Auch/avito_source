package com.avito.android.publish_limits_info;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.avito.android.lib.design.R;
import com.avito.android.lib.expected.progress_bar.ProgressBar;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.internal.AnalyticsEvents;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0018¨\u0006."}, d2 = {"Lcom/avito/android/publish_limits_info/PublishLimitsInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setDescription", "setProgressHint", "setCategory", "setLocation", "", "setExtraInfo", "(Ljava/lang/CharSequence;)V", "", "value", "Lcom/avito/android/remote/model/LimitsInfo$Progress$Style;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setProgress", "(FLcom/avito/android/remote/model/LimitsInfo$Progress$Style;)V", "hideProgress", "()V", "Landroid/widget/TextView;", "w", "Landroid/widget/TextView;", "extraInfo", "t", "progressHint", "r", "description", VKApiConst.VERSION, "location", "Lcom/avito/android/lib/expected/progress_bar/ProgressBar;", "s", "Lcom/avito/android/lib/expected/progress_bar/ProgressBar;", "spentProgress", "u", "category", VKApiConst.Q, "title", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class PublishLimitsInfoView extends ConstraintLayout {
    public final TextView q;
    public final TextView r;
    public final ProgressBar s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            LimitsInfo.Progress.Style.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            LimitsInfo.Progress.Style style = LimitsInfo.Progress.Style.WARNING;
            iArr[1] = 1;
            LimitsInfo.Progress.Style style2 = LimitsInfo.Progress.Style.NORMAL;
            iArr[0] = 2;
            LimitsInfo.Progress.Style.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[1] = 1;
            iArr2[0] = 2;
        }
    }

    @JvmOverloads
    public PublishLimitsInfoView(@NotNull Context context) {
        this(context, null, 2, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublishLimitsInfoView(Context context, AttributeSet attributeSet, int i, j jVar) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void hideProgress() {
        Views.hide(this.s);
    }

    public final void setCategory(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.r.setText(str);
    }

    public final void setExtraInfo(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.w, charSequence, false, 2, null);
        this.w.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void setLocation(@Nullable String str) {
        TextViews.bindText$default(this.v, str, false, 2, null);
    }

    public final void setProgress(float f, @NotNull LimitsInfo.Progress.Style style) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(style, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        Views.show(this.s);
        this.s.setProgress(f);
        ProgressBar progressBar = this.s;
        int ordinal = style.ordinal();
        if (ordinal == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = Contexts.getColorByAttr(context, R.attr.green600);
        } else if (ordinal == 1) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            i = Contexts.getColorByAttr(context2, R.attr.red600);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        progressBar.setFillColor(i);
        ProgressBar progressBar2 = this.s;
        int ordinal2 = style.ordinal();
        if (ordinal2 == 0) {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            i2 = Contexts.getColorByAttr(context3, R.attr.green200);
        } else if (ordinal2 == 1) {
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            i2 = Contexts.getColorByAttr(context4, R.attr.red100);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        progressBar2.setEmptyColor(i2);
    }

    public final void setProgressHint(@Nullable String str) {
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    public final void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.q, str, false, 2, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishLimitsInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.publish_limits_info, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        this.q = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.description)");
        this.r = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.limits_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.limits_progress)");
        this.s = (ProgressBar) findViewById3;
        View findViewById4 = findViewById(R.id.progress_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.progress_hint)");
        this.t = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.category);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.category)");
        this.u = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.location);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.location)");
        this.v = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.extra_info);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.extra_info)");
        this.w = (TextView) findViewById7;
    }
}
