package com.avito.android.module.serp.adapter.ad.dfp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoader;", "", "", "createLoadOperationId", "()I", "newOperationId", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/content/Context;", "context", "Lio/reactivex/rxjava3/core/Single;", "Landroid/graphics/drawable/Drawable;", "loadImage", "(ILandroid/net/Uri;Landroid/content/Context;)Lio/reactivex/rxjava3/core/Single;", "takeImageFromCache", "(Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;", "anOperationId", "", "cancel", "(I)V", "getLastOperationId", "setLastOperationId", "lastOperationId", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface DfpImageLoader {
    void cancel(int i);

    int createLoadOperationId();

    int getLastOperationId();

    @NotNull
    Single<Drawable> loadImage(int i, @NotNull Uri uri, @NotNull Context context);

    void setLastOperationId(int i);

    @Nullable
    Drawable takeImageFromCache(@NotNull Uri uri);
}
