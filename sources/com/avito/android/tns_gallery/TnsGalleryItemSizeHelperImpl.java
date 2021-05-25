package com.avito.android.tns_gallery;

import android.app.Activity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.ViewSize;
import com.avito.android.util.Views;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/tns_gallery/TnsGalleryItemSizeHelperImpl;", "Lcom/avito/android/tns_gallery/TnsGalleryItemSizeHelper;", "", "imageRatio", "Lcom/avito/android/util/ViewSize;", "getContainerViewSize", "(F)Lcom/avito/android/util/ViewSize;", "containerSize", "", "isImageMustFitContainer", "(FLcom/avito/android/util/ViewSize;)Z", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "context", "c", "F", "maxWidth", AuthSource.BOOKING_ORDER, "minWidth", "", AuthSource.SEND_ABUSE, "I", "baseHeight", "Lcom/avito/android/tns_gallery/TnsGallerySettings;", "settings", "<init>", "(Landroid/app/Activity;Lcom/avito/android/tns_gallery/TnsGallerySettings;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TnsGalleryItemSizeHelperImpl implements TnsGalleryItemSizeHelper {
    public final int a;
    public final float b;
    public final float c;
    public final Activity d;

    @Inject
    public TnsGalleryItemSizeHelperImpl(@NotNull Activity activity, @NotNull TnsGallerySettings tnsGallerySettings) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(tnsGallerySettings, "settings");
        this.d = activity;
        int baseHeightDp = tnsGallerySettings.getBaseHeightDp();
        this.a = baseHeightDp;
        this.b = ((float) baseHeightDp) * 0.667f;
        this.c = ((float) baseHeightDp) * 1.6f;
    }

    @Override // com.avito.android.tns_gallery.TnsGalleryItemSizeHelper
    @NotNull
    public ViewSize getContainerViewSize(float f) {
        Activity activity = this.d;
        float coerceAtMost = e.coerceAtMost(((float) Contexts.pxToDp(activity, Contexts.getRealDisplayWidth(activity))) / ((float) 320), 1.5f);
        int i = this.a;
        return new ViewSize(Views.dpToPx(activity, (int) (e.coerceIn(((float) i) * f, this.b, this.c) * coerceAtMost)), Views.dpToPx(activity, (int) (((float) i) * coerceAtMost)));
    }

    @Override // com.avito.android.tns_gallery.TnsGalleryItemSizeHelper
    public boolean isImageMustFitContainer(float f, @NotNull ViewSize viewSize) {
        Intrinsics.checkNotNullParameter(viewSize, "containerSize");
        return ((double) Math.abs((((float) viewSize.getWidth()) / ((float) viewSize.getHeight())) - f)) < 0.0125d;
    }
}
