package com.avito.android.html_editor;

import android.text.Spanned;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u001a£\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062`\u0010\u000f\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"T", "R", "Landroid/text/Spanned;", "", Tracker.Events.CREATIVE_START, "end", "Ljava/lang/Class;", "type", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "span", "from", "to", "action", "", "iterateThroughSpansInOrder", "(Landroid/text/Spanned;IILjava/lang/Class;Lkotlin/jvm/functions/Function4;)Ljava/util/List;", "html-editor_release"}, k = 2, mv = {1, 4, 2})
public final class SpannedUtilsKt {
    @NotNull
    public static final <T, R> List<R> iterateThroughSpansInOrder(@NotNull Spanned spanned, int i, int i2, @NotNull Class<T> cls, @NotNull Function4<? super Integer, ? super T, ? super Integer, ? super Integer, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(spanned, "$this$iterateThroughSpansInOrder");
        Intrinsics.checkNotNullParameter(cls, "type");
        Intrinsics.checkNotNullParameter(function4, "action");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int nextSpanTransition = spanned.nextSpanTransition(i, i2, cls);
            Object[] spans = spanned.getSpans(i, nextSpanTransition, cls);
            if (spans != null) {
                for (Object obj : spans) {
                    arrayList.add(function4.invoke(Integer.valueOf(i3), obj, Integer.valueOf(spanned.getSpanStart(obj)), Integer.valueOf(spanned.getSpanEnd(obj))));
                }
            }
            i3++;
            if (nextSpanTransition == i2) {
                return arrayList;
            }
            i = nextSpanTransition;
        }
    }
}
