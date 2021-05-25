package com.avito.android.avito_map;

import android.graphics.Bitmap;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u001c¢\u0006\u0004\b\"\u0010#R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010!\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapMarkerOptions;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", AuthSource.BOOKING_ORDER, "getSnippet", "setSnippet", "snippet", "Lcom/avito/android/avito_map/AvitoMapPoint;", "d", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getPosition", "()Lcom/avito/android/avito_map/AvitoMapPoint;", VKApiConst.POSITION, "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "icon", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "e", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "getAnchor", "()Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", "<init>", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMapMarkerOptions {
    @Nullable
    public String a;
    @Nullable
    public String b;
    @Nullable
    public Bitmap c;
    @NotNull
    public final AvitoMapPoint d;
    @NotNull
    public final AvitoMapMarker.Anchor e;

    public AvitoMapMarkerOptions(@NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapMarker.Anchor anchor) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this.d = avitoMapPoint;
        this.e = anchor;
    }

    @NotNull
    public final AvitoMapMarker.Anchor getAnchor() {
        return this.e;
    }

    @Nullable
    public final Bitmap getIcon() {
        return this.c;
    }

    @NotNull
    public final AvitoMapPoint getPosition() {
        return this.d;
    }

    @Nullable
    public final String getSnippet() {
        return this.b;
    }

    @Nullable
    public final String getTitle() {
        return this.a;
    }

    public final void setIcon(@Nullable Bitmap bitmap) {
        this.c = bitmap;
    }

    public final void setSnippet(@Nullable String str) {
        this.b = str;
    }

    public final void setTitle(@Nullable String str) {
        this.a = str;
    }
}
