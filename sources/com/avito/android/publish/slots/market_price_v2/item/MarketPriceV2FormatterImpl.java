package com.avito.android.publish.slots.market_price_v2.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.publish.R;
import com.avito.android.remote.model.badge.Badge;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.BadgesKt;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2FormatterImpl;", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Formatter;", "Landroid/content/Context;", "context", "", "description", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "", "formatPriceDescription", "(Landroid/content/Context;Ljava/lang/String;Lcom/avito/android/remote/model/badge/Badge;)Ljava/lang/CharSequence;", "notice", "", "userPrice", "marketPrice", "formatPriceNotice", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Ljava/lang/String;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceV2FormatterImpl implements MarketPriceV2Formatter {
    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Formatter
    @NotNull
    public CharSequence formatPriceDescription(@NotNull Context context, @NotNull String str, @Nullable Badge badge) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "description");
        if (badge == null) {
            return str;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.market_price_badge, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) linearLayout.findViewById(R.id.badge);
        Intrinsics.checkNotNullExpressionValue(textView, "badgeView");
        BadgesKt.setBadge(textView, badge);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        linearLayout.layout(0, 0, linearLayout.getMeasuredWidth(), linearLayout.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(linearLayout.getMeasuredWidth(), linearLayout.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        linearLayout.draw(new Canvas(createBitmap));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) "⁠").append((CharSequence) " ");
        spannableStringBuilder.setSpan(new ImageSpan(context, createBitmap), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Formatter
    @NotNull
    public String formatPriceNotice(@NotNull String str, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, "notice");
        if (l == null || l2 == null) {
            return str;
        }
        long abs = Math.abs(l2.longValue() - l.longValue());
        String format = NumberFormat.getInstance(new Locale("ru", "RU")).format(l2.longValue());
        String format2 = NumberFormat.getInstance(new Locale("ru", "RU")).format(abs);
        Intrinsics.checkNotNullExpressionValue(format, "formattedMarketPrice");
        String replace$default = m.replace$default(str, "${marketPrice}", format, false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(format2, "formattedPriceDiff");
        return m.replace$default(replace$default, "${diffWithMarketPrice}", format2, false, 4, (Object) null);
    }
}
