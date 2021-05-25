package com.avito.android.photo_picker.legacy.thumbnail_list;

import a2.a.a.x1.q.o.b;
import android.net.Uri;
import com.avito.android.photo_picker.legacy.RotationInteractor;
import com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Flowables;
import com.avito.android.util.Rotation;
import com.avito.android.util.Uris;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemPresenterImpl;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemPresenter;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemView;", "view", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemView;Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;I)V", "Lcom/avito/android/util/Rotation;", "newRotation", "setRotation", "(Lcom/avito/android/util/Rotation;)V", "Ldagger/Lazy;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemPresenter$Listener;", "d", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Rotation;", "rotation", "Lio/reactivex/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/Disposable;", "rotationSubscription", "Ljava/util/ArrayList;", "c", "Ljava/util/ArrayList;", "boundViews", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "e", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "rotationInteractor", "<init>", "(Ldagger/Lazy;Lcom/avito/android/photo_picker/legacy/RotationInteractor;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ThumbnailItemPresenterImpl implements ThumbnailItemPresenter {
    public Rotation a = new Rotation.Rotation_0();
    public Disposable b;
    public final ArrayList<ThumbnailItemView> c = new ArrayList<>();
    public final Lazy<? extends ThumbnailItemPresenter.Listener> d;
    public final RotationInteractor e;

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
                ((ThumbnailItemPresenter.Listener) ((ThumbnailItemPresenterImpl) this.b).d.get()).onThumbnailClicked(((BasePhotoItem) this.d).getStringId());
                return Unit.INSTANCE;
            } else if (i == 1) {
                ThumbnailItemPresenterImpl.access$unbindView((ThumbnailItemPresenterImpl) this.b, (ThumbnailItemView) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public ThumbnailItemPresenterImpl(@NotNull Lazy<? extends ThumbnailItemPresenter.Listener> lazy, @NotNull RotationInteractor rotationInteractor) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(rotationInteractor, "rotationInteractor");
        this.d = lazy;
        this.e = rotationInteractor;
    }

    public static final void access$handleRotation(ThumbnailItemPresenterImpl thumbnailItemPresenterImpl, Rotation rotation) {
        thumbnailItemPresenterImpl.a = rotation;
        Iterator<T> it = thumbnailItemPresenterImpl.c.iterator();
        while (it.hasNext()) {
            it.next().setRotation(rotation, true);
        }
    }

    public static final void access$unbindView(ThumbnailItemPresenterImpl thumbnailItemPresenterImpl, ThumbnailItemView thumbnailItemView) {
        thumbnailItemPresenterImpl.c.remove(thumbnailItemView);
        if (thumbnailItemPresenterImpl.c.isEmpty()) {
            Disposable disposable = thumbnailItemPresenterImpl.b;
            if (disposable != null) {
                disposable.dispose();
            }
            thumbnailItemPresenterImpl.b = null;
        }
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemPresenter
    public void setRotation(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "newRotation");
        this.a = rotation;
    }

    public void bindView(@NotNull ThumbnailItemView thumbnailItemView, @NotNull BasePhotoItem basePhotoItem, int i) {
        Intrinsics.checkNotNullParameter(thumbnailItemView, "view");
        Intrinsics.checkNotNullParameter(basePhotoItem, "item");
        if (this.b == null) {
            Flowable<Rotation> filter = this.e.getRotationFlowable().filter(a2.a.a.x1.q.o.a.a);
            Intrinsics.checkNotNullExpressionValue(filter, "rotationInteractor.getRo…Rotation.Rotation_180() }");
            this.b = Flowables.subscribeOnNext(filter, new b(this));
        }
        this.c.add(thumbnailItemView);
        thumbnailItemView.setRotation(this.a, false);
        thumbnailItemView.setSelected(basePhotoItem.getSelected());
        thumbnailItemView.setClickListener(new a(0, this, thumbnailItemView, basePhotoItem));
        if (basePhotoItem instanceof UriPhotoItem) {
            UriPhotoItem uriPhotoItem = (UriPhotoItem) basePhotoItem;
            if (Uris.isNullOrEmpty(uriPhotoItem.getImageUri())) {
                thumbnailItemView.setProgressVisibility(uriPhotoItem.isLoading());
                thumbnailItemView.hideImage();
            } else {
                Uri imageUri = uriPhotoItem.getImageUri();
                Intrinsics.checkNotNull(imageUri);
                thumbnailItemView.showImage(imageUri);
                thumbnailItemView.setProgressVisibility(false);
            }
        } else if (basePhotoItem instanceof ResourcePhotoItem) {
            ResourcePhotoItem resourcePhotoItem = (ResourcePhotoItem) basePhotoItem;
            thumbnailItemView.showImage(resourcePhotoItem.getDrawableId());
            thumbnailItemView.setProgressVisibility(resourcePhotoItem.isLoading());
        }
        thumbnailItemView.setUnbindListener(new a(1, this, thumbnailItemView, basePhotoItem));
    }
}
