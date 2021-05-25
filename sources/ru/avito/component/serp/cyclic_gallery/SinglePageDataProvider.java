package ru.avito.component.serp.cyclic_gallery;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000bR\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/SinglePageDataProvider;", "Lru/avito/component/serp/cyclic_gallery/GalleryDataProvider;", "", "getPagesCount", "()I", "pagePosition", "Lcom/avito/android/image_loader/Picture;", "getPictureForPage", "(I)Lcom/avito/android/image_loader/Picture;", "page", "getPicturePositionByPage", "(I)I", "imagePosition", "getPageByPicturePosition", AuthSource.SEND_ABUSE, "Lcom/avito/android/image_loader/Picture;", "getPage", "()Lcom/avito/android/image_loader/Picture;", "setPage", "(Lcom/avito/android/image_loader/Picture;)V", "<init>", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SinglePageDataProvider implements GalleryDataProvider {
    @NotNull
    public Picture a;

    public SinglePageDataProvider(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "page");
        this.a = picture;
    }

    @NotNull
    public final Picture getPage() {
        return this.a;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.GalleryDataProvider
    public int getPageByPicturePosition(int i) {
        return i;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.GalleryDataProvider
    public int getPagesCount() {
        return 1;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.GalleryDataProvider
    @NotNull
    public Picture getPictureForPage(int i) {
        return this.a;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.GalleryDataProvider
    public int getPicturePositionByPage(int i) {
        return i;
    }

    public final void setPage(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "<set-?>");
        this.a = picture;
    }
}
