package a2.a.a.w1;

import com.avito.android.photo_gallery.LegacyPhotoGalleryActivity;
import com.avito.android.photo_gallery.adapter.FullscreenGalleryAdapter;
import com.avito.android.photo_gallery.adapter.GalleryItem;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<AutotekaTeaserGalleryModel> {
    public final /* synthetic */ LegacyPhotoGalleryActivity a;

    public b(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        this.a = legacyPhotoGalleryActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        AutotekaTeaserGalleryModel autotekaTeaserGalleryModel2 = autotekaTeaserGalleryModel;
        if (autotekaTeaserGalleryModel2.getHasAnotherPhotoInReport()) {
            List list = this.a.x;
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (t instanceof GalleryItem.GalleryTeaserAutoteka) {
                    arrayList.add(t);
                }
            }
            if (arrayList.isEmpty()) {
                LegacyPhotoGalleryActivity legacyPhotoGalleryActivity = this.a;
                List list2 = legacyPhotoGalleryActivity.x;
                Intrinsics.checkNotNullExpressionValue(autotekaTeaserGalleryModel2, "teaser");
                legacyPhotoGalleryActivity.x = CollectionsKt___CollectionsKt.plus((Collection<? extends GalleryItem.GalleryTeaserAutoteka>) list2, new GalleryItem.GalleryTeaserAutoteka(autotekaTeaserGalleryModel2));
                FullscreenGalleryAdapter fullscreenGalleryAdapter = this.a.r;
                if (fullscreenGalleryAdapter != null) {
                    fullscreenGalleryAdapter.updateList(this.a.x);
                }
                this.a.C = true;
            }
        }
    }
}
