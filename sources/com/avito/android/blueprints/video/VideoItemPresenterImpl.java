package com.avito.android.blueprints.video;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.item_temporary.R;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.items.ItemWithState;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.VideoChangePayload;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b.\u0010/J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R.\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eRj\u0010'\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a %*\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00180\u0018 %**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a %*\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00180\u0018\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010&R:\u0010)\u001a&\u0012\f\u0012\n %*\u0004\u0018\u00010 0  %*\u0012\u0012\f\u0012\n %*\u0004\u0018\u00010 0 \u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010&R:\u0010*\u001a&\u0012\f\u0012\n %*\u0004\u0018\u00010\u001a0\u001a %*\u0012\u0012\f\u0012\n %*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010&R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001e¨\u00060"}, d2 = {"Lcom/avito/android/blueprints/video/VideoItemPresenterImpl;", "Lcom/avito/android/blueprints/video/VideoItemPresenter;", "Lcom/avito/android/blueprints/video/VideoItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Video;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/video/VideoItemView;Lcom/avito/android/category_parameters/ParameterElement$Video;I)V", "", "", "payloads", "(Lcom/avito/android/blueprints/video/VideoItemView;Lcom/avito/android/category_parameters/ParameterElement$Video;ILjava/util/List;)V", "Lcom/avito/android/items/ItemWithState$State;", "state", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/blueprints/video/VideoItemView;Lcom/avito/android/items/ItemWithState$State;)V", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "previewState", AuthSource.SEND_ABUSE, "(Lcom/avito/android/blueprints/video/VideoItemView;Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;Lcom/avito/android/items/ItemWithState$State;)V", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/avito/android/items/BasicInputItem;", "e", "Lio/reactivex/Observable;", "getFocusChangesObservable", "()Lio/reactivex/Observable;", "focusChangesObservable", "Lcom/avito/android/items/ItemWithAdditionalButton;", "f", "getRightIconClickObservable", "rightIconClickObservable", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "focusChangesStream", "c", "rightIconClickStream", "valueChangesStream", "d", "getValueChangesObservable", "valueChangesObservable", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class VideoItemPresenterImpl implements VideoItemPresenter {
    public final PublishRelay<BasicInputItem> a;
    public final PublishRelay<Pair<Boolean, BasicInputItem>> b;
    public final PublishRelay<ItemWithAdditionalButton> c;
    @NotNull
    public final Observable<BasicInputItem> d;
    @NotNull
    public final Observable<Pair<Boolean, BasicInputItem>> e;
    @NotNull
    public final Observable<ItemWithAdditionalButton> f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ItemWithAdditionalButton.AdditionalButtonType.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
        }
    }

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ VideoItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Video b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VideoItemPresenterImpl videoItemPresenterImpl, ParameterElement.Video video) {
            super(1);
            this.a = videoItemPresenterImpl;
            this.b = video;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.b.accept(TuplesKt.to(Boolean.valueOf(bool.booleanValue()), this.b));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ VideoItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Video b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(VideoItemPresenterImpl videoItemPresenterImpl, ParameterElement.Video video) {
            super(1);
            this.a = videoItemPresenterImpl;
            this.b = video;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.b.setValue(str2);
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ VideoItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Video b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(VideoItemPresenterImpl videoItemPresenterImpl, ParameterElement.Video video) {
            super(1);
            this.a = videoItemPresenterImpl;
            this.b = video;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.b.setValue(str2);
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ VideoItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Video b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(VideoItemPresenterImpl videoItemPresenterImpl, ParameterElement.Video video) {
            super(1);
            this.a = videoItemPresenterImpl;
            this.b = video;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.b.accept(TuplesKt.to(Boolean.valueOf(bool.booleanValue()), this.b));
            return Unit.INSTANCE;
        }
    }

    @Inject
    public VideoItemPresenterImpl() {
        PublishRelay<BasicInputItem> create = PublishRelay.create();
        this.a = create;
        PublishRelay<Pair<Boolean, BasicInputItem>> create2 = PublishRelay.create();
        this.b = create2;
        PublishRelay<ItemWithAdditionalButton> create3 = PublishRelay.create();
        this.c = create3;
        Intrinsics.checkNotNullExpressionValue(create, "valueChangesStream");
        this.d = create;
        Intrinsics.checkNotNullExpressionValue(create2, "focusChangesStream");
        this.e = create2;
        Intrinsics.checkNotNullExpressionValue(create3, "rightIconClickStream");
        this.f = create3;
    }

    public final void a(VideoItemView videoItemView, ParameterElement.Video.PreviewState previewState, ItemWithState.State state) {
        if ((state instanceof ItemWithState.State.Error) || (state instanceof ItemWithState.State.Warning)) {
            videoItemView.setEmptyState();
        } else if (previewState instanceof ParameterElement.Video.PreviewState.Content) {
            ParameterElement.Video.PreviewState.Content content = (ParameterElement.Video.PreviewState.Content) previewState;
            videoItemView.setLoadedState(content.getImage(), content.getTitle());
        } else if (previewState instanceof ParameterElement.Video.PreviewState.Error) {
            videoItemView.setErrorState(((ParameterElement.Video.PreviewState.Error) previewState).getMessage());
        } else if (previewState instanceof ParameterElement.Video.PreviewState.Loading) {
            videoItemView.setLoadingState();
        } else if (previewState instanceof ParameterElement.Video.PreviewState.Empty) {
            videoItemView.setEmptyState();
        }
    }

    public final void b(VideoItemView videoItemView, ItemWithState.State state) {
        if (state instanceof ItemWithState.State.Error) {
            videoItemView.setInputErrorState(((ItemWithState.State.Error) state).getMessage());
        } else if (state instanceof ItemWithState.State.Warning) {
            videoItemView.setInputWarningState(((ItemWithState.State.Warning) state).getMessage());
        } else if (state instanceof ItemWithState.State.Normal) {
            videoItemView.setInputNormalState();
        }
    }

    @Override // com.avito.android.blueprints.video.VideoItemPresenter
    @NotNull
    public Observable<Pair<Boolean, BasicInputItem>> getFocusChangesObservable() {
        return this.e;
    }

    @Override // com.avito.android.blueprints.video.VideoItemPresenter
    @NotNull
    public Observable<ItemWithAdditionalButton> getRightIconClickObservable() {
        return this.f;
    }

    @Override // com.avito.android.blueprints.video.VideoItemPresenter
    @NotNull
    public Observable<BasicInputItem> getValueChangesObservable() {
        return this.d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(VideoItemView videoItemView, ParameterElement.Video video, int i, List list) {
        bindView(videoItemView, video, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull VideoItemView videoItemView, @NotNull ParameterElement.Video video, int i) {
        Intrinsics.checkNotNullParameter(videoItemView, "view");
        Intrinsics.checkNotNullParameter(video, "item");
        ItemWithAdditionalButton.AdditionalButtonType additionalButtonType = null;
        videoItemView.setOnValueChangeListener(null);
        videoItemView.removeTextWatcher();
        videoItemView.setTitle(video.getTitle());
        videoItemView.setPlaceholder(video.getPlaceholder());
        videoItemView.setInputType(new FormatterType(Integer.MAX_VALUE, "", 1, null));
        videoItemView.setSingleLine();
        videoItemView.setMaxLength(Integer.MAX_VALUE);
        videoItemView.setValue(video.getValue());
        videoItemView.setFocusChangeListener(new a(this, video));
        videoItemView.setOnValueChangeListener(new b(this, video));
        b(videoItemView, video.getState());
        a(videoItemView, video.getPreviewState(), video.getState());
        ItemWithAdditionalButton.AdditionalButton additionalButton = video.getAdditionalButton();
        if (additionalButton != null) {
            additionalButtonType = additionalButton.getType();
        }
        if (additionalButtonType != null && additionalButtonType.ordinal() == 0) {
            videoItemView.setRightIconClickListener(new a2.a.a.t.c.a(this, video));
            videoItemView.setRightIcon(R.drawable.ic_question_sign, com.avito.android.lib.design.R.attr.gray28);
        }
    }

    public void bindView(@NotNull VideoItemView videoItemView, @NotNull ParameterElement.Video video, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(videoItemView, "view");
        Intrinsics.checkNotNullParameter(video, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof VideoChangePayload) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(videoItemView, video, i);
            return;
        }
        if (t3.getState() != null) {
            b(videoItemView, t3.getState());
        }
        if (t3.getPreviewState() != null) {
            a(videoItemView, t3.getPreviewState(), t3.getState());
        }
        videoItemView.setOnValueChangeListener(new c(this, video));
        videoItemView.setFocusChangeListener(new d(this, video));
    }
}
