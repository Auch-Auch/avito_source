package defpackage;

import android.text.Layout;
import android.widget.TextView;
import com.avito.android.messenger.conversation.chat_header.ItemTitleAndPriceView;
import com.avito.android.util.TextViews;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import t6.v.e;
import t6.y.a;
/* compiled from: kotlin-style lambda group */
/* renamed from: v5  reason: default package */
public final class v5 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v5(int i, Object obj, Object obj2, Object obj3) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        String str;
        int i = this.a;
        boolean z = false;
        if (i == 0) {
            Layout layout = ((ItemTitleAndPriceView) this.b).s.getLayout();
            if ((layout != null ? layout.getEllipsisStart(0) : 0) > 0) {
                String str2 = "… " + ((String) this.c);
                float measuredWidth = (float) ((ItemTitleAndPriceView) this.b).s.getMeasuredWidth();
                float measureText = measuredWidth - ((ItemTitleAndPriceView) this.b).t.getPaint().measureText(str2);
                if (measureText > ((float) 0)) {
                    TextView textView = ((ItemTitleAndPriceView) this.b).s;
                    StringBuilder sb = new StringBuilder();
                    TextView textView2 = ((ItemTitleAndPriceView) this.b).s;
                    String str3 = (String) this.d;
                    String take = StringsKt___StringsKt.take(str3, textView2.getPaint().breakText(str3, true, e.coerceAtLeast(measureText, 0.0f), null));
                    Objects.requireNonNull(take, "null cannot be cast to non-null type kotlin.CharSequence");
                    sb.append(StringsKt__StringsKt.trim(take).toString());
                    sb.append(str2);
                    TextViews.bindText(textView, sb.toString(), true);
                } else {
                    TextView textView3 = ((ItemTitleAndPriceView) this.b).s;
                    TextView textView4 = ((ItemTitleAndPriceView) this.b).s;
                    String str4 = (String) this.d;
                    String take2 = StringsKt___StringsKt.take(str4, textView4.getPaint().breakText(str4, true, e.coerceAtLeast(measuredWidth, 0.0f), null));
                    Objects.requireNonNull(take2, "null cannot be cast to non-null type kotlin.CharSequence");
                    TextViews.bindText(textView3, StringsKt__StringsKt.trim(take2).toString(), true);
                }
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (i == 1) {
            Layout layout2 = ((ItemTitleAndPriceView) this.b).s.getLayout();
            int ellipsisStart = layout2 != null ? layout2.getEllipsisStart(0) : 0;
            if (ellipsisStart > ((String) this.c).length() + 1) {
                TextViews.bindText(((ItemTitleAndPriceView) this.b).s, (String) this.c, true);
                TextViews.bindText$default(((ItemTitleAndPriceView) this.b).t, (String) this.d, false, 2, null);
            } else if (ellipsisStart > 0) {
                float measuredWidth2 = (float) ((ItemTitleAndPriceView) this.b).s.getMeasuredWidth();
                TextView textView5 = ((ItemTitleAndPriceView) this.b).s;
                String str5 = (String) this.c;
                int breakText = textView5.getPaint().breakText(str5, true, e.coerceAtLeast(measuredWidth2, 0.0f), null);
                int coerceIn = e.coerceIn(breakText, 0, str5.length() - 1);
                while (coerceIn >= 0 && !a.isWhitespace(str5.charAt(coerceIn))) {
                    coerceIn--;
                }
                if (coerceIn < 0) {
                    str = StringsKt___StringsKt.take(str5, breakText);
                } else {
                    str = StringsKt___StringsKt.take(str5, coerceIn);
                }
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj = StringsKt__StringsKt.trim(str).toString();
                String drop = StringsKt___StringsKt.drop((String) this.c, obj.length());
                Objects.requireNonNull(drop, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj2 = StringsKt__StringsKt.trim(drop).toString();
                String str6 = "… " + ((String) this.d);
                float measureText2 = measuredWidth2 - ((ItemTitleAndPriceView) this.b).t.getPaint().measureText(str6);
                if (measureText2 > ((float) 0)) {
                    if (obj2.length() > 0) {
                        String take3 = StringsKt___StringsKt.take(obj2, ((ItemTitleAndPriceView) this.b).t.getPaint().breakText(obj2, true, e.coerceAtLeast(measureText2, 0.0f), null));
                        Objects.requireNonNull(take3, "null cannot be cast to non-null type kotlin.CharSequence");
                        String obj3 = StringsKt__StringsKt.trim(take3).toString();
                        int length = obj3.length() + obj.length();
                        if (ellipsisStart >= length) {
                            TextViews.bindText(((ItemTitleAndPriceView) this.b).s, (String) this.c, true);
                            TextViews.bindText$default(((ItemTitleAndPriceView) this.b).t, (String) this.d, false, 2, null);
                        } else {
                            TextViews.bindText$default(((ItemTitleAndPriceView) this.b).s, obj, false, 2, null);
                            if (length < ((String) this.c).length()) {
                                TextViews.bindText$default(((ItemTitleAndPriceView) this.b).t, obj3 + str6, false, 2, null);
                            } else {
                                TextViews.bindText$default(((ItemTitleAndPriceView) this.b).t, obj3 + ' ' + ((String) this.d), false, 2, null);
                            }
                        }
                    }
                }
                TextViews.bindText(((ItemTitleAndPriceView) this.b).s, (String) this.c, true);
                TextViews.bindText$default(((ItemTitleAndPriceView) this.b).t, (String) this.d, false, 2, null);
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        } else {
            throw null;
        }
    }
}
