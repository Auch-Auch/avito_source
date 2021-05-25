package com.avito.android.photo_view;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_view/PhotoViewResourceProviderImpl;", "Lcom/avito/android/photo_view/PhotoViewResourceProvider;", "", "getPhotoAndVideoTitle", "()Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoViewResourceProviderImpl implements PhotoViewResourceProvider {
    public final Resources a;

    @Inject
    public PhotoViewResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.photo_view.PhotoViewResourceProvider
    @NotNull
    public String getPhotoAndVideoTitle() {
        String string = this.a.getString(R.string.photo_and_video_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng.photo_and_video_title)");
        return string;
    }
}
