package com.avito.android.lib.design.notification_badge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StyleRes;
import com.avito.android.lib.design.R;
import com.avito.android.lib.util.VerticalCenteredImageSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0003\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/widget/TextView;", "", "text", "badgeText", "", "badgeStyle", "", "withNotificationBadge", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;I)V", "Landroid/content/Context;", "context", "pattern", "Landroid/text/SpannableString;", "createSpannableStringWithNotificationBadge", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;ILjava/lang/String;)Landroid/text/SpannableString;", "components_release"}, k = 2, mv = {1, 4, 2})
public final class NotificationBadgeFuncionsKt {
    @NotNull
    public static final SpannableString createSpannableStringWithNotificationBadge(@NotNull String str, @NotNull String str2, @NotNull Context context, @StyleRes int i, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "badgeText");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str3, "pattern");
        NotificationBadge notificationBadge = new NotificationBadge(context, null, 0, 0, 14, null);
        notificationBadge.setAppearance(i);
        notificationBadge.setText(str2);
        notificationBadge.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        Bitmap createBitmap = Bitmap.createBitmap(notificationBadge.getMeasuredWidth(), notificationBadge.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        notificationBadge.layout(0, 0, notificationBadge.getMeasuredWidth(), notificationBadge.getMeasuredHeight());
        notificationBadge.draw(canvas);
        String replace$default = m.replace$default(m.replace$default(str3, "$\\text", str, false, 4, (Object) null), "$\\badgeText", str2, false, 4, (Object) null);
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) replace$default, str2, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(replace$default);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        spannableString.setSpan(new VerticalCenteredImageSpan(context, createBitmap), indexOf$default, str2.length() + indexOf$default, 33);
        return spannableString;
    }

    public static /* synthetic */ SpannableString createSpannableStringWithNotificationBadge$default(String str, String str2, Context context, int i, String str3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = R.style.Design_Widget_NotificationBadge;
        }
        if ((i2 & 16) != 0) {
            str3 = "$\\text $\\badgeText";
        }
        return createSpannableStringWithNotificationBadge(str, str2, context, i, str3);
    }

    public static final void withNotificationBadge(@NotNull TextView textView, @NotNull String str, @NotNull String str2, @StyleRes int i) {
        Intrinsics.checkNotNullParameter(textView, "$this$withNotificationBadge");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "badgeText");
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(createSpannableStringWithNotificationBadge$default(str, str2, context, i, null, 16, null));
    }

    public static /* synthetic */ void withNotificationBadge$default(TextView textView, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = R.style.Design_Widget_NotificationBadge;
        }
        withNotificationBadge(textView, str, str2, i);
    }
}
