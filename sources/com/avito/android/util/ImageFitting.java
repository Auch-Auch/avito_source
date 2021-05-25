package com.avito.android.util;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Size;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0013\u0018\u00002\u00020\u0001BG\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\b\b\u0001\u0010 \u001a\u00020\f¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\bJ4\u0010\u0010\u001a\u0004\u0018\u00010\u00062#\u0010\u000f\u001a\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u0010\u0010\u0011JJ\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u00122#\u0010\u000f\u001a\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\b\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001a¨\u0006%"}, d2 = {"Lcom/avito/android/util/ImageFitting;", "", "Lcom/avito/android/util/ImageContainer;", "getWidthImageContainer", "()Lcom/avito/android/util/ImageContainer;", "getHeightImageContainer", "Landroid/net/Uri;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "()Landroid/net/Uri;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lkotlin/Function3;", "Lcom/avito/android/remote/model/Size;", "", "", "Lkotlin/ExtensionFunctionType;", "estimation", "using", "(Lkotlin/jvm/functions/Function3;)Landroid/net/Uri;", "", "variants", AuthSource.SEND_ABUSE, "(Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Lcom/avito/android/remote/model/Size;", "e", "F", "maxScale", AuthSource.BOOKING_ORDER, "I", "targetWidth", "Ljava/util/Map;", "d", "minScale", "f", "notFoundReturnStrategy", "c", "targetHeight", "<init>", "(Ljava/util/Map;IIFFI)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class ImageFitting {
    public final Map<Size, Uri> a;
    public final int b;
    public final int c;
    public final float d;
    public final float e;
    public final int f;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Map<com.avito.android.remote.model.Size, ? extends android.net.Uri> */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageFitting(@Nullable Map<Size, ? extends Uri> map, int i, int i2, float f2, float f3, @NotFoundReturnStrategy int i3) {
        this.a = map;
        this.b = i;
        this.c = i2;
        this.d = f2;
        this.e = f3;
        this.f = i3;
        if (f2 > ((float) 0) || f2 < 1.0f) {
            if (!(f3 > 0.0f)) {
                throw new IllegalArgumentException(("expected maxScale to be > 0, maxScale was " + f3).toString());
            } else if (!ArraysKt___ArraysKt.contains(new Integer[]{0, 2, 1}, Integer.valueOf(i3))) {
                throw new IllegalArgumentException("expected notFoundReturnStrategy to be any of STRATEGY_RETURN_NULL (0), STRATEGY_RETURN_MIN (2), STRATEGY_RETURN_MAX (1)".toString());
            }
        } else {
            throw new IllegalArgumentException(("expected minScale to be > 0 and < 1, minScale was " + f2).toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.remote.model.Size a(java.util.Map<com.avito.android.remote.model.Size, ? extends android.net.Uri> r8, kotlin.jvm.functions.Function3<? super com.avito.android.remote.model.Size, ? super java.lang.Integer, ? super java.lang.Integer, java.lang.Float> r9) {
        /*
            r7 = this;
            java.util.Set r8 = r8.keySet()
            int r0 = r7.b
            int r1 = r7.c
            int r2 = r7.f
            r3 = 1
            if (r2 == r3) goto L_0x002d
            r3 = 2
            if (r2 == r3) goto L_0x0011
            goto L_0x0049
        L_0x0011:
            java.util.Map<com.avito.android.remote.model.Size, android.net.Uri> r2 = r7.a
            if (r2 == 0) goto L_0x0049
            java.util.Set r2 = r2.keySet()
            if (r2 == 0) goto L_0x0049
            com.avito.android.util.ImageFitting$getInitialSize$$inlined$sortedBy$1 r3 = new com.avito.android.util.ImageFitting$getInitialSize$$inlined$sortedBy$1
            r3.<init>()
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r2, r3)
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r2)
            com.avito.android.remote.model.Size r2 = (com.avito.android.remote.model.Size) r2
            goto L_0x004a
        L_0x002d:
            java.util.Map<com.avito.android.remote.model.Size, android.net.Uri> r2 = r7.a
            if (r2 == 0) goto L_0x0049
            java.util.Set r2 = r2.keySet()
            if (r2 == 0) goto L_0x0049
            com.avito.android.util.ImageFitting$getInitialSize$$inlined$sortedByDescending$1 r3 = new com.avito.android.util.ImageFitting$getInitialSize$$inlined$sortedByDescending$1
            r3.<init>()
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r2, r3)
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r2)
            com.avito.android.remote.model.Size r2 = (com.avito.android.remote.model.Size) r2
            goto L_0x004a
        L_0x0049:
            r2 = 0
        L_0x004a:
            r3 = 2139095039(0x7f7fffff, float:3.4028235E38)
            java.util.Iterator r8 = r8.iterator()
        L_0x0051:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0084
            java.lang.Object r4 = r8.next()
            com.avito.android.remote.model.Size r4 = (com.avito.android.remote.model.Size) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            java.lang.Object r5 = r9.invoke(r4, r5, r6)
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            boolean r6 = com.avito.android.util.Images.access$isBetter(r5, r3)
            if (r6 == 0) goto L_0x0051
            float r6 = r7.d
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0051
            float r6 = r7.e
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0051
            r2 = r4
            r3 = r5
            goto L_0x0051
        L_0x0084:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.ImageFitting.a(java.util.Map, kotlin.jvm.functions.Function3):com.avito.android.remote.model.Size");
    }

    @Nullable
    public final ImageContainer getHeightImageContainer() {
        Size a3;
        Uri uri;
        Map<Size, Uri> map = this.a;
        if (map == null || (a3 = a(map, a.a)) == null || (uri = map.get(a3)) == null) {
            return null;
        }
        return new ImageContainer(a3, uri);
    }

    @Nullable
    public final ImageContainer getWidthImageContainer() {
        Size a3;
        Uri uri;
        Map<Size, Uri> map = this.a;
        if (map == null || (a3 = a(map, b.a)) == null || (uri = map.get(a3)) == null) {
            return null;
        }
        return new ImageContainer(a3, uri);
    }

    @Nullable
    public final Uri height() {
        return using(c.a);
    }

    @Nullable
    public final Uri using(@NotNull Function3<? super Size, ? super Integer, ? super Integer, Float> function3) {
        Size a3;
        Intrinsics.checkNotNullParameter(function3, "estimation");
        Map<Size, Uri> map = this.a;
        if (map == null || (a3 = a(map, function3)) == null) {
            return null;
        }
        return map.get(a3);
    }

    @Nullable
    public final Uri width() {
        return using(d.a);
    }
}
