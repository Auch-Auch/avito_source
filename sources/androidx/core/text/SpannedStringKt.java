package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a<\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0004*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "Landroid/text/Spanned;", "toSpanned", "(Ljava/lang/CharSequence;)Landroid/text/Spanned;", "", "T", "", Tracker.Events.CREATIVE_START, "end", "", "getSpans", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class SpannedStringKt {
    @NotNull
    public static final /* synthetic */ <T> T[] getSpans(@NotNull Spanned spanned, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(spanned, "$this$getSpans");
        Intrinsics.reifiedOperationMarker(4, "T");
        T[] tArr = (T[]) spanned.getSpans(i, i2, Object.class);
        Intrinsics.checkExpressionValueIsNotNull(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = spanned.length();
        }
        Intrinsics.checkParameterIsNotNull(spanned, "$this$getSpans");
        Intrinsics.reifiedOperationMarker(4, "T");
        Object[] spans = spanned.getSpans(i, i2, Object.class);
        Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    @NotNull
    public static final Spanned toSpanned(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$toSpanned");
        SpannedString valueOf = SpannedString.valueOf(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "SpannedString.valueOf(this)");
        return valueOf;
    }
}
