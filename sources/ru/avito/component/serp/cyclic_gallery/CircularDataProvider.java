package ru.avito.component.serp.cyclic_gallery;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/CircularDataProvider;", "Lru/avito/component/serp/cyclic_gallery/GalleryDataProvider;", "Lru/avito/component/serp/cyclic_gallery/PageIndicatorLabelProvider;", "", "getPagesCount", "()I", "pagePosition", "Lcom/avito/android/image_loader/Picture;", "getPictureForPage", "(I)Lcom/avito/android/image_loader/Picture;", VKApiConst.POSITION, "", "getIndicatorForPosition", "(I)Ljava/lang/String;", "page", "getPicturePositionByPage", "(I)I", "imagePosition", "getPageByPicturePosition", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "pictures", "<init>", "(Ljava/util/List;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CircularDataProvider implements GalleryDataProvider, PageIndicatorLabelProvider {
    public List<? extends Picture> a;

    public CircularDataProvider(@NotNull List<? extends Picture> list) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        this.a = list;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.PageIndicatorLabelProvider
    @NotNull
    public String getIndicatorForPosition(int i) {
        return (getPicturePositionByPage(i) + 1) + " · " + this.a.size();
    }

    @Override // ru.avito.component.serp.cyclic_gallery.GalleryDataProvider
    public int getPageByPicturePosition(int i) {
        int i2 = 1000;
        int size = 1000 % this.a.size();
        if (size > 0) {
            i2 = 1000 - size;
        }
        return i2 + i;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.GalleryDataProvider
    public int getPagesCount() {
        return 2000;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.GalleryDataProvider
    @NotNull
    public Picture getPictureForPage(int i) {
        return (Picture) this.a.get(getPicturePositionByPage(i));
    }

    @Override // ru.avito.component.serp.cyclic_gallery.GalleryDataProvider
    public int getPicturePositionByPage(int i) {
        return i % this.a.size();
    }
}
