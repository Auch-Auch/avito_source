package com.avito.android.messenger.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u0019\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001e\u0010\"B!\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010$B)\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010&J\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\b¢\u0006\u0004\b\u0006\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168Â\u0002@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/widget/ChatListAdBannerTitleContainer;", "Landroid/view/ViewGroup;", "Lkotlin/Pair;", "", "getWidthAndHeightOfBadges", "()Lkotlin/Pair;", "getEndAndTopOfLastCharInTitle", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", "l", "t", "r", AuthSource.BOOKING_ORDER, "onLayout", "(ZIIII)V", "I", "badgesTop", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", AuthSource.SEND_ABUSE, "badgesStart", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatListAdBannerTitleContainer extends ViewGroup {
    public int a;
    public int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatListAdBannerTitleContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final int access$spToPx(ChatListAdBannerTitleContainer chatListAdBannerTitleContainer, float f) {
        Context context = chatListAdBannerTitleContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return (int) TypedValue.applyDimension(2, f, resources.getDisplayMetrics());
    }

    private final Pair<Integer, Integer> getEndAndTopOfLastCharInTitle() {
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        ViewGroup.LayoutParams layoutParams = getTitleView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            paddingStart += marginLayoutParams.getMarginEnd();
        }
        CharSequence text = getTitleView().getText();
        Intrinsics.checkNotNullExpressionValue(text, "titleView.text");
        int lastIndex = StringsKt__StringsKt.getLastIndex(text);
        if (lastIndex >= 0) {
            Layout layout = getTitleView().getLayout();
            int lineForOffset = layout.getLineForOffset(lastIndex);
            float primaryHorizontal = layout.getPrimaryHorizontal(lastIndex + 1);
            int lineTop = layout.getLineTop(lineForOffset);
            paddingStart += c.roundToInt(primaryHorizontal);
            paddingTop += lineTop;
        }
        return TuplesKt.to(Integer.valueOf(paddingStart), Integer.valueOf(paddingTop));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final TextView getTitleView() {
        View childAt = getChildAt(0);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
        return (TextView) childAt;
    }

    private final Pair<Integer, Integer> getWidthAndHeightOfBadges() {
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        for (int i3 = 1; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth() + i2;
                i = Math.max(i, childAt.getMeasuredHeight());
                i2 = measuredWidth;
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return TuplesKt.to(Integer.valueOf(i2), Integer.valueOf(i + ((int) TypedValue.applyDimension(2, 3.0f, resources.getDisplayMetrics()))));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        View childAt = getChildAt(0);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
        if (((TextView) childAt).getVisibility() != 8) {
            View childAt2 = getChildAt(0);
            Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
            View childAt3 = getChildAt(0);
            Objects.requireNonNull(childAt3, "null cannot be cast to non-null type android.widget.TextView");
            int measuredWidth = ((TextView) childAt3).getMeasuredWidth();
            View childAt4 = getChildAt(0);
            Objects.requireNonNull(childAt4, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) childAt2).layout(paddingStart, paddingTop, measuredWidth, ((TextView) childAt4).getMeasuredHeight());
        }
        int i5 = this.a;
        int childCount = getChildCount();
        for (int i6 = 1; i6 < childCount; i6++) {
            View childAt5 = getChildAt(i6);
            Intrinsics.checkNotNullExpressionValue(childAt5, "badge");
            if (childAt5.getVisibility() != 8) {
                int measuredWidth2 = childAt5.getMeasuredWidth() + i5;
                int i7 = this.b;
                childAt5.layout(i5, i7, measuredWidth2, childAt5.getMeasuredHeight() + i7);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Resources resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                i5 = measuredWidth2 + ((int) TypedValue.applyDimension(2, 4.0f, resources.getDisplayMetrics()));
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            Intrinsics.checkNotNullExpressionValue(childAt, VKApiUserFull.RelativeType.CHILD);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                i4 = ViewGroup.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        ViewGroup.LayoutParams layoutParams = getTitleView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            paddingStart += marginLayoutParams.getMarginEnd();
        }
        CharSequence text = getTitleView().getText();
        Intrinsics.checkNotNullExpressionValue(text, "titleView.text");
        int lastIndex = StringsKt__StringsKt.getLastIndex(text);
        if (lastIndex >= 0) {
            Layout layout = getTitleView().getLayout();
            int lineForOffset = layout.getLineForOffset(lastIndex);
            float primaryHorizontal = layout.getPrimaryHorizontal(lastIndex + 1);
            int lineTop = layout.getLineTop(lineForOffset);
            paddingStart += c.roundToInt(primaryHorizontal);
            paddingTop += lineTop;
        }
        Pair pair = TuplesKt.to(Integer.valueOf(paddingStart), Integer.valueOf(paddingTop));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        int childCount2 = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < childCount2; i8++) {
            View childAt2 = getChildAt(i8);
            Intrinsics.checkNotNullExpressionValue(childAt2, VKApiUserFull.RelativeType.CHILD);
            if (childAt2.getVisibility() != 8) {
                i7 += childAt2.getMeasuredWidth();
                i6 = Math.max(i6, childAt2.getMeasuredHeight());
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        Pair pair2 = TuplesKt.to(Integer.valueOf(i7), Integer.valueOf(i6 + ((int) TypedValue.applyDimension(2, 3.0f, resources.getDisplayMetrics()))));
        int intValue3 = ((Number) pair2.component1()).intValue();
        int intValue4 = ((Number) pair2.component2()).intValue();
        int coerceAtLeast = e.coerceAtLeast(intValue + intValue3, getSuggestedMinimumWidth());
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(coerceAtLeast, i, i4);
        if (resolveSizeAndState < coerceAtLeast) {
            resolveSizeAndState = ViewGroup.resolveSizeAndState(e.coerceAtLeast(Math.max(intValue, intValue3), getSuggestedMinimumWidth()), i, i4);
            View childAt3 = getChildAt(0);
            Objects.requireNonNull(childAt3, "null cannot be cast to non-null type android.widget.TextView");
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Resources resources2 = context2.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "context.resources");
            i3 = ViewGroup.resolveSizeAndState(((TextView) childAt3).getMeasuredHeight() + intValue4 + ((int) TypedValue.applyDimension(2, 3.0f, resources2.getDisplayMetrics())), i2, i4 << 16);
            this.a = getPaddingStart();
            int paddingTop2 = getPaddingTop();
            View childAt4 = getChildAt(0);
            Objects.requireNonNull(childAt4, "null cannot be cast to non-null type android.widget.TextView");
            int measuredHeight = ((TextView) childAt4).getMeasuredHeight() + paddingTop2;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            Resources resources3 = context3.getResources();
            Intrinsics.checkNotNullExpressionValue(resources3, "context.resources");
            this.b = measuredHeight + ((int) TypedValue.applyDimension(2, 3.0f, resources3.getDisplayMetrics()));
        } else {
            View childAt5 = getChildAt(0);
            Objects.requireNonNull(childAt5, "null cannot be cast to non-null type android.widget.TextView");
            int measuredHeight2 = ((TextView) childAt5).getMeasuredHeight();
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            Resources resources4 = context4.getResources();
            Intrinsics.checkNotNullExpressionValue(resources4, "context.resources");
            i3 = ViewGroup.resolveSizeAndState(Math.max(measuredHeight2, intValue4 + ((int) TypedValue.applyDimension(2, 3.0f, resources4.getDisplayMetrics()))), i2, i4 << 16);
            int paddingStart2 = getPaddingStart() + intValue;
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            Resources resources5 = context5.getResources();
            Intrinsics.checkNotNullExpressionValue(resources5, "context.resources");
            this.a = paddingStart2 + ((int) TypedValue.applyDimension(2, 6.0f, resources5.getDisplayMetrics()));
            int paddingTop3 = getPaddingTop() + intValue2;
            Context context6 = getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "context");
            Resources resources6 = context6.getResources();
            Intrinsics.checkNotNullExpressionValue(resources6, "context.resources");
            this.b = paddingTop3 + ((int) TypedValue.applyDimension(2, 3.0f, resources6.getDisplayMetrics()));
        }
        setMeasuredDimension(resolveSizeAndState, i3);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatListAdBannerTitleContainer(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatListAdBannerTitleContainer(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatListAdBannerTitleContainer(@NotNull Context context, @NotNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }
}
