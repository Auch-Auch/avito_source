package com.avito.android.messenger.conversation.adapter.platform.from_avito;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMarginsDelegate;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/MessageViewMargins;", "", "overrideTopMarginDp", "overrideBottomMarginDp", "", "overrideMargins", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", AuthSource.BOOKING_ORDER, "I", "messageViewId", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroidx/constraintlayout/widget/ConstraintLayout;", "layout", "Landroid/view/View;", "view", "layoutId", "<init>", "(Landroid/view/View;II)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageViewMarginsDelegate implements MessageViewMargins {
    public final ConstraintLayout a;
    public final int b;

    public MessageViewMarginsDelegate(@NotNull View view, @IdRes int i, @IdRes int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = i2;
        this.a = (ConstraintLayout) view.findViewById(i);
    }

    @Override // com.avito.android.messenger.conversation.adapter.platform.from_avito.MessageViewMargins
    public void overrideMargins(@Nullable Integer num, @Nullable Integer num2) {
        Integer num3;
        Integer num4 = null;
        if (num != null) {
            ConstraintLayout constraintLayout = this.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "layout");
            Resources resources = constraintLayout.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "layout.resources");
            num3 = Integer.valueOf((int) TypedValue.applyDimension(1, (float) num.intValue(), resources.getDisplayMetrics()));
        } else {
            num3 = null;
        }
        if (num2 != null) {
            ConstraintLayout constraintLayout2 = this.a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "layout");
            Resources resources2 = constraintLayout2.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "layout.resources");
            num4 = Integer.valueOf((int) TypedValue.applyDimension(1, (float) num2.intValue(), resources2.getDisplayMetrics()));
        }
        if (num3 != null || num4 != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.a);
            if (num3 != null) {
                int intValue = num3.intValue();
                constraintSet.setMargin(this.b, 3, intValue);
                constraintSet.setGoneMargin(this.b, 3, intValue);
            }
            if (num4 != null) {
                int intValue2 = num4.intValue();
                constraintSet.setMargin(this.b, 4, intValue2);
                constraintSet.setGoneMargin(this.b, 4, intValue2);
            }
            constraintSet.applyTo(this.a);
        }
    }
}
