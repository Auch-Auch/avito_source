package com.avito.android.photo_picker.legacy.details_list;

import a2.a.a.x1.q.m.m;
import a2.a.a.x1.q.m.n;
import a2.g.r.g;
import android.net.Uri;
import androidx.collection.ArrayMap;
import com.avito.android.PublishIntentFactory;
import com.avito.android.krop.util.Transformation;
import com.avito.android.photo_picker.legacy.RotationInteractor;
import com.avito.android.photo_picker.legacy.details_list.EditorItemPresenter;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.android.photo_picker.legacy.thumbnail_list.UriPhotoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Flowables;
import com.avito.android.util.Rotation;
import com.avito.android.util.Uris;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b)\u0010*J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenterImpl;", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter;", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemView;", "view", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/photo_picker/legacy/details_list/EditorItemView;Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;I)V", AuthSource.SEND_ABUSE, "(Lcom/avito/android/photo_picker/legacy/details_list/EditorItemView;Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;)V", "Lcom/avito/android/util/Rotation;", "c", "Lcom/avito/android/util/Rotation;", "rotation", "Landroidx/collection/ArrayMap;", AuthSource.BOOKING_ORDER, "Landroidx/collection/ArrayMap;", "boundViews", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", g.a, "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "mode", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "e", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "rotationInteractor", "", "f", "Z", "withCrop", "Ldagger/Lazy;", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter$Listener;", "d", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "rotationSubscription", "<init>", "(Ldagger/Lazy;Lcom/avito/android/photo_picker/legacy/RotationInteractor;ZLcom/avito/android/PublishIntentFactory$PhotoPickerMode;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class EditorItemPresenterImpl implements EditorItemPresenter {
    public Disposable a;
    public final ArrayMap<EditorItemView, BasePhotoItem> b = new ArrayMap<>();
    public Rotation c = new Rotation.Rotation_0();
    public final Lazy<? extends EditorItemPresenter.Listener> d;
    public final RotationInteractor e;
    public final boolean f;
    public final PublishIntentFactory.PhotoPickerMode g;

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
                ((EditorItemPresenter.Listener) ((EditorItemPresenterImpl) this.b).d.get()).onRemovePhoto(((BasePhotoItem) this.c).getStringId());
                return Unit.INSTANCE;
            } else if (i == 1) {
                EditorItemPresenterImpl.access$unbindView((EditorItemPresenterImpl) this.b, (EditorItemView) this.d);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<Transformation, Unit> {
        public final /* synthetic */ EditorItemPresenterImpl a;
        public final /* synthetic */ BasePhotoItem b;
        public final /* synthetic */ EditorItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(EditorItemPresenterImpl editorItemPresenterImpl, BasePhotoItem basePhotoItem, EditorItemView editorItemView) {
            super(1);
            this.a = editorItemPresenterImpl;
            this.b = basePhotoItem;
            this.c = editorItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Transformation transformation) {
            Transformation transformation2 = transformation;
            Intrinsics.checkNotNullParameter(transformation2, "transformation");
            ((EditorItemPresenter.Listener) this.a.d.get()).onPhotoCropped(this.b.getStringId(), transformation2);
            return Unit.INSTANCE;
        }
    }

    public EditorItemPresenterImpl(@NotNull Lazy<? extends EditorItemPresenter.Listener> lazy, @NotNull RotationInteractor rotationInteractor, boolean z, @NotNull PublishIntentFactory.PhotoPickerMode photoPickerMode) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(rotationInteractor, "rotationInteractor");
        Intrinsics.checkNotNullParameter(photoPickerMode, "mode");
        this.d = lazy;
        this.e = rotationInteractor;
        this.f = z;
        this.g = photoPickerMode;
    }

    public static final void access$handleRotation(EditorItemPresenterImpl editorItemPresenterImpl, Rotation rotation) {
        editorItemPresenterImpl.c = rotation;
        Set<EditorItemView> keySet = editorItemPresenterImpl.b.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "boundViews.keys");
        for (T t : keySet) {
            t.rotateUi(rotation);
            BasePhotoItem basePhotoItem = editorItemPresenterImpl.b.get(t);
            if (basePhotoItem != null) {
                Intrinsics.checkNotNullExpressionValue(t, "view");
                editorItemPresenterImpl.a(t, basePhotoItem);
            }
        }
    }

    public static final void access$unbindView(EditorItemPresenterImpl editorItemPresenterImpl, EditorItemView editorItemView) {
        editorItemPresenterImpl.b.remove(editorItemView);
        if (editorItemPresenterImpl.b.isEmpty()) {
            Disposable disposable = editorItemPresenterImpl.a;
            if (disposable != null) {
                disposable.dispose();
            }
            editorItemPresenterImpl.a = null;
        }
    }

    public final void a(EditorItemView editorItemView, BasePhotoItem basePhotoItem) {
        if (basePhotoItem instanceof UriPhotoItem) {
            UriPhotoItem uriPhotoItem = (UriPhotoItem) basePhotoItem;
            if (Uris.isNullOrEmpty(uriPhotoItem.getImageUri())) {
                editorItemView.hideImage();
            } else if (this.f) {
                Uri imageUri = uriPhotoItem.getImageUri();
                Intrinsics.checkNotNull(imageUri);
                editorItemView.showCrop(imageUri);
            } else {
                Uri imageUri2 = uriPhotoItem.getImageUri();
                Intrinsics.checkNotNull(imageUri2);
                editorItemView.showPreview(imageUri2, this.c);
            }
        }
    }

    public void bindView(@NotNull EditorItemView editorItemView, @NotNull BasePhotoItem basePhotoItem, int i) {
        Intrinsics.checkNotNullParameter(editorItemView, "view");
        Intrinsics.checkNotNullParameter(basePhotoItem, "item");
        if (this.a == null) {
            Flowable<Rotation> filter = this.e.getRotationFlowable().filter(m.a);
            Intrinsics.checkNotNullExpressionValue(filter, "rotationInteractor.getRo…Rotation.Rotation_180() }");
            this.a = Flowables.subscribeOnNext(filter, new n(this));
        }
        this.b.put(editorItemView, basePhotoItem);
        if (this.g == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
            editorItemView.setRemoveClickListener(new a(0, this, basePhotoItem, editorItemView));
        } else {
            editorItemView.setRemoveClickListener(null);
        }
        editorItemView.setCropListener(new b(this, basePhotoItem, editorItemView));
        editorItemView.setProgressVisibility(basePhotoItem.isLoading());
        a(editorItemView, basePhotoItem);
        editorItemView.rotateUi(this.c);
        editorItemView.setOnUnbindListener(new a(1, this, basePhotoItem, editorItemView));
    }
}
