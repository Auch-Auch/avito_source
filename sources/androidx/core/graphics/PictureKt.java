package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/graphics/Picture;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "block", "record", "(Landroid/graphics/Picture;IILkotlin/jvm/functions/Function1;)Landroid/graphics/Picture;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class PictureKt {
    @NotNull
    public static final Picture record(@NotNull Picture picture, int i, int i2, @NotNull Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(picture, "$this$record");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Canvas beginRecording = picture.beginRecording(i, i2);
        int i3 = 1;
        try {
            Intrinsics.checkExpressionValueIsNotNull(beginRecording, "c");
            function1.invoke(beginRecording);
            return picture;
        } finally {
            InlineMarker.finallyStart(i3);
            picture.endRecording();
            InlineMarker.finallyEnd(i3);
        }
    }
}
