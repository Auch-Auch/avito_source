package com.avito.android.photo_picker.gallery.gallery_list;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR:\u0010\u0010\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemPresenterImpl;", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemPresenter;", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemView;", "view", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryUriPhotoItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemView;Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryUriPhotoItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "photoClickStream", "Ljava/util/ArrayList;", AuthSource.SEND_ABUSE, "Ljava/util/ArrayList;", "boundViews", "Lio/reactivex/Observable;", "c", "Lio/reactivex/Observable;", "getPhotoClickObservable", "()Lio/reactivex/Observable;", "photoClickObservable", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryItemPresenterImpl implements GalleryItemPresenter {
    public final ArrayList<GalleryItemView> a = new ArrayList<>();
    public final PublishRelay<String> b;
    @NotNull
    public final Observable<String> c;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2, Object obj3) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((GalleryItemPresenterImpl) this.b).b.accept(((GalleryUriPhotoItem) this.c).getStringId());
                return Unit.INSTANCE;
            } else if (i == 1) {
                GalleryItemPresenterImpl.access$unbindView((GalleryItemPresenterImpl) this.b, (GalleryItemView) this.d);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public GalleryItemPresenterImpl() {
        PublishRelay<String> create = PublishRelay.create();
        this.b = create;
        Intrinsics.checkNotNullExpressionValue(create, "photoClickStream");
        this.c = create;
    }

    public static final void access$unbindView(GalleryItemPresenterImpl galleryItemPresenterImpl, GalleryItemView galleryItemView) {
        galleryItemPresenterImpl.a.remove(galleryItemView);
    }

    @Override // com.avito.android.photo_picker.gallery.gallery_list.GalleryItemPresenter
    @NotNull
    public Observable<String> getPhotoClickObservable() {
        return this.c;
    }

    public void bindView(@NotNull GalleryItemView galleryItemView, @NotNull GalleryUriPhotoItem galleryUriPhotoItem, int i) {
        Intrinsics.checkNotNullParameter(galleryItemView, "view");
        Intrinsics.checkNotNullParameter(galleryUriPhotoItem, "item");
        this.a.add(galleryItemView);
        galleryItemView.showImage(galleryUriPhotoItem.getImageUri());
        galleryItemView.setSelected(galleryUriPhotoItem.getSelectedPosition());
        galleryItemView.setClickListener(new a(0, this, galleryUriPhotoItem, galleryItemView));
        galleryItemView.setUnbindListener(new a(1, this, galleryUriPhotoItem, galleryItemView));
    }
}
