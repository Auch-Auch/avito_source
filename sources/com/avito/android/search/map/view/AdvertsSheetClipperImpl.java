package com.avito.android.search.map.view;

import a2.a.a.k2.b.h.a;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\tJ!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/search/map/view/AdvertsSheetClipperImpl;", "Lcom/avito/android/search/map/view/AdvertsSheetClipper;", "Landroid/view/View;", "view", "container", "", "clip", "(Landroid/view/View;Landroid/view/View;)V", "invalidate", "()V", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "La2/a/a/k2/b/h/a;", AuthSource.SEND_ABUSE, "La2/a/a/k2/b/h/a;", "outlineProvider", "<init>", "map_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertsSheetClipperImpl implements AdvertsSheetClipper {
    public final a a = new a();
    public View b;

    @Override // com.avito.android.search.map.view.AdvertsSheetClipper
    public void clip(@NotNull View view, @Nullable View view2) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a.a = view2;
        this.b = view;
        view.setClipToOutline(true);
        view.setOutlineProvider(this.a);
    }

    @Override // com.avito.android.search.map.view.AdvertsSheetClipper
    public void invalidate() {
        View view = this.b;
        if (view != null) {
            view.invalidateOutline();
        }
    }
}
