package com.avito.android.publish.details;

import a2.g.r.g;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.VideoPreview;
import com.avito.android.util.LoadingState;
import com.avito.android.util.NetworkException;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/publish/details/VideoItemWrapper;", "Lcom/avito/android/publish/details/ItemWrapper;", "Lcom/avito/android/category_parameters/ParameterElement$Video;", "item", "", "update", "(Lcom/avito/android/category_parameters/ParameterElement$Video;)V", "transform", "(Lcom/avito/android/category_parameters/ParameterElement$Video;)Lcom/avito/android/category_parameters/ParameterElement$Video;", "clear", "()V", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "disposable", "Lio/reactivex/Observable;", "e", "Lio/reactivex/Observable;", "getDataChanged", "()Lio/reactivex/Observable;", "dataChanged", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "dataChangedRelay", "Lcom/avito/android/publish/details/PublishDetailsResourceProvider;", g.a, "Lcom/avito/android/publish/details/PublishDetailsResourceProvider;", "resourceProvider", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "d", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "videoPreviewState", "Lcom/avito/android/publish/details/VideoInteractor;", "f", "Lcom/avito/android/publish/details/VideoInteractor;", "interactor", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "oldValue", "<init>", "(Lcom/avito/android/publish/details/VideoInteractor;Lcom/avito/android/publish/details/PublishDetailsResourceProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class VideoItemWrapper implements ItemWrapper<ParameterElement.Video> {
    public final PublishRelay<Unit> a;
    public String b;
    public Disposable c;
    public ParameterElement.Video.PreviewState d = ParameterElement.Video.PreviewState.Empty.INSTANCE;
    @NotNull
    public final Observable<Unit> e;
    public final VideoInteractor f;
    public final PublishDetailsResourceProvider g;

    public static final class a<T> implements Consumer<LoadingState<? super VideoPreview>> {
        public final /* synthetic */ VideoItemWrapper a;

        public a(VideoItemWrapper videoItemWrapper) {
            this.a = videoItemWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super VideoPreview> loadingState) {
            LoadingState<? super VideoPreview> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Error) {
                VideoItemWrapper.access$handleErrorState(this.a, ((LoadingState.Error) loadingState2).getError());
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                VideoItemWrapper.access$handleLoadedState(this.a, (LoadingState.Loaded) loadingState2);
            }
        }
    }

    @Inject
    public VideoItemWrapper(@NotNull VideoInteractor videoInteractor, @NotNull PublishDetailsResourceProvider publishDetailsResourceProvider) {
        Intrinsics.checkNotNullParameter(videoInteractor, "interactor");
        Intrinsics.checkNotNullParameter(publishDetailsResourceProvider, "resourceProvider");
        this.f = videoInteractor;
        this.g = publishDetailsResourceProvider;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        this.e = create;
    }

    public static final void access$handleErrorState(VideoItemWrapper videoItemWrapper, TypedError typedError) {
        String str;
        Objects.requireNonNull(videoItemWrapper);
        if (typedError instanceof ErrorWithMessage) {
            str = ((ErrorWithMessage) typedError).getMessage();
        } else if (typedError instanceof NetworkException) {
            str = videoItemWrapper.g.getNetworkError();
        } else {
            str = videoItemWrapper.g.getVideoLoadingError();
        }
        videoItemWrapper.d = new ParameterElement.Video.PreviewState.Error(str);
        videoItemWrapper.a.accept(Unit.INSTANCE);
    }

    public static final void access$handleLoadedState(VideoItemWrapper videoItemWrapper, LoadingState.Loaded loaded) {
        Objects.requireNonNull(videoItemWrapper);
        videoItemWrapper.d = new ParameterElement.Video.PreviewState.Content(((VideoPreview) loaded.getData()).getVideoTitle(), ((VideoPreview) loaded.getData()).getVideo().getPreviewImage(), ((VideoPreview) loaded.getData()).getVideo().getVideoUrl());
        videoItemWrapper.a.accept(Unit.INSTANCE);
    }

    @Override // com.avito.android.publish.details.ItemWrapper
    public void clear() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.publish.details.ItemWrapper
    @NotNull
    public Observable<Unit> getDataChanged() {
        return this.e;
    }

    @NotNull
    public ParameterElement.Video transform(@NotNull ParameterElement.Video video) {
        Intrinsics.checkNotNullParameter(video, "item");
        video.setPreviewState(this.d);
        return video;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(@org.jetbrains.annotations.NotNull com.avito.android.category_parameters.ParameterElement.Video r7) {
        /*
            r6 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.avito.android.items.ItemWithState$State r0 = r7.getState()
            java.lang.String r1 = r7.getValue()
            boolean r2 = r0 instanceof com.avito.android.items.ItemWithState.State.Normal
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x004e
            if (r1 == 0) goto L_0x0022
            int r5 = r1.length()
            if (r5 <= 0) goto L_0x001d
            r5 = 1
            goto L_0x001e
        L_0x001d:
            r5 = 0
        L_0x001e:
            if (r5 == 0) goto L_0x0022
            r5 = 1
            goto L_0x0023
        L_0x0022:
            r5 = 0
        L_0x0023:
            if (r5 == 0) goto L_0x004e
            java.lang.String r5 = r6.b
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            r5 = r5 ^ r4
            if (r5 == 0) goto L_0x004e
            com.avito.android.category_parameters.ParameterElement$Video$PreviewState$Loading r0 = com.avito.android.category_parameters.ParameterElement.Video.PreviewState.Loading.INSTANCE
            r6.d = r0
            io.reactivex.disposables.Disposable r0 = r6.c
            if (r0 == 0) goto L_0x0039
            r0.dispose()
        L_0x0039:
            com.avito.android.publish.details.VideoInteractor r0 = r6.f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            io.reactivex.Observable r0 = r0.getVideoPreview(r1)
            com.avito.android.publish.details.VideoItemWrapper$a r2 = new com.avito.android.publish.details.VideoItemWrapper$a
            r2.<init>(r6)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2)
            r6.c = r0
            goto L_0x0068
        L_0x004e:
            if (r2 == 0) goto L_0x0060
            if (r1 == 0) goto L_0x0058
            int r2 = r1.length()
            if (r2 != 0) goto L_0x0059
        L_0x0058:
            r3 = 1
        L_0x0059:
            if (r3 == 0) goto L_0x0060
            com.avito.android.category_parameters.ParameterElement$Video$PreviewState$Empty r0 = com.avito.android.category_parameters.ParameterElement.Video.PreviewState.Empty.INSTANCE
            r6.d = r0
            goto L_0x0068
        L_0x0060:
            boolean r0 = r0 instanceof com.avito.android.items.ItemWithState.State.Error
            if (r0 == 0) goto L_0x0068
            com.avito.android.category_parameters.ParameterElement$Video$PreviewState$Empty r0 = com.avito.android.category_parameters.ParameterElement.Video.PreviewState.Empty.INSTANCE
            r6.d = r0
        L_0x0068:
            r6.b = r1
            com.avito.android.category_parameters.ParameterElement$Video$PreviewState r7 = r7.getPreviewState()
            com.avito.android.category_parameters.ParameterElement$Video$PreviewState r0 = r6.d
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            r7 = r7 ^ r4
            if (r7 == 0) goto L_0x007e
            com.jakewharton.rxrelay2.PublishRelay<kotlin.Unit> r7 = r6.a
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r7.accept(r0)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.details.VideoItemWrapper.update(com.avito.android.category_parameters.ParameterElement$Video):void");
    }
}
