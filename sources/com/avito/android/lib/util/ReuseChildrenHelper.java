package com.avito.android.lib.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/util/ReuseChildrenHelper;", "D", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "createChild", "()Landroid/view/View;", "view", "data", "", VKApiConst.POSITION, "", "bindData", "(Landroid/view/View;Ljava/lang/Object;I)V", "Landroid/view/ViewGroup;", "container", "", "reuseChildrenView", "(Landroid/view/ViewGroup;Ljava/util/List;)V", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public abstract class ReuseChildrenHelper<D, V extends View> {
    public abstract void bindData(@NotNull V v, D d, int i);

    @NotNull
    public abstract V createChild();

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.lib.util.ReuseChildrenHelper<D, V extends android.view.View> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void reuseChildrenView(@NotNull ViewGroup viewGroup, @NotNull List<? extends D> list) {
        int size;
        int i;
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(list, "data");
        if (viewGroup.getChildCount() > list.size() && viewGroup.getChildCount() - 1 >= (size = list.size())) {
            while (true) {
                viewGroup.removeViewAt(i);
                if (i == size) {
                    break;
                }
                i--;
            }
        }
        if (viewGroup.getChildCount() < list.size()) {
            int size2 = list.size();
            for (int childCount = viewGroup.getChildCount(); childCount < size2; childCount++) {
                viewGroup.addView(createChild());
            }
        }
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View childAt = viewGroup.getChildAt(i2);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type V");
            bindData(childAt, t, i2);
            i2 = i3;
        }
    }
}
