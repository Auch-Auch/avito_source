package com.avito.android.spare_parts.bottom_sheet;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetView;", "", "", "title", "", "closeButtonIconRes", "Lkotlin/Function0;", "", "closeListener", "setDialogHeaderParams", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "", "shouldAnimate", "reversed", "onDataChanged", "(ZZ)V", "onDetach", "()V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public interface SparePartsBottomSheetView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onDataChanged$default(SparePartsBottomSheetView sparePartsBottomSheetView, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z2 = false;
                }
                sparePartsBottomSheetView.onDataChanged(z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDataChanged");
        }
    }

    @NotNull
    Context getContext();

    void onDataChanged(boolean z, boolean z2);

    void onDetach();

    void setDialogHeaderParams(@NotNull String str, int i, @NotNull Function0<Unit> function0);
}
