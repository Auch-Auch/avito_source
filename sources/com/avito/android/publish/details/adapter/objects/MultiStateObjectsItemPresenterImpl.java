package com.avito.android.publish.details.adapter.objects;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR.\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\f0\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemPresenterImpl;", "Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemPresenter;", "Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Objects;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemView;Lcom/avito/android/category_parameters/ParameterElement$Objects;I)V", "Lio/reactivex/Observable;", "Lkotlin/Pair;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getObjectItemClicks", "()Lio/reactivex/Observable;", "objectItemClicks", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "objectItemClicksRelay", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateObjectsItemPresenterImpl implements MultiStateObjectsItemPresenter {
    public final PublishRelay<Pair<ParameterElement.Objects, Integer>> a;
    @NotNull
    public final Observable<Pair<ParameterElement.Objects, Integer>> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ MultiStateObjectsItemView b;
        public final /* synthetic */ MultiStateObjectsItemPresenterImpl c;
        public final /* synthetic */ ParameterElement.Objects d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, MultiStateObjectsItemView multiStateObjectsItemView, MultiStateObjectsItemPresenterImpl multiStateObjectsItemPresenterImpl, ParameterElement.Objects objects) {
            super(0);
            this.a = i;
            this.b = multiStateObjectsItemView;
            this.c = multiStateObjectsItemPresenterImpl;
            this.d = objects;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.c.a.accept(TuplesKt.to(this.d, Integer.valueOf(this.a)));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MultiStateObjectsItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Objects b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MultiStateObjectsItemPresenterImpl multiStateObjectsItemPresenterImpl, ParameterElement.Objects objects) {
            super(0);
            this.a = multiStateObjectsItemPresenterImpl;
            this.b = objects;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(TuplesKt.to(this.b, -1));
            return Unit.INSTANCE;
        }
    }

    public MultiStateObjectsItemPresenterImpl() {
        PublishRelay<Pair<ParameterElement.Objects, Integer>> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        Observable<Pair<ParameterElement.Objects, Integer>> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "objectItemClicksRelay.hide()");
        this.b = hide;
    }

    @Override // com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemPresenter
    @NotNull
    public Observable<Pair<ParameterElement.Objects, Integer>> getObjectItemClicks() {
        return this.b;
    }

    public void bindView(@NotNull MultiStateObjectsItemView multiStateObjectsItemView, @NotNull ParameterElement.Objects objects, int i) {
        Intrinsics.checkNotNullParameter(multiStateObjectsItemView, "view");
        Intrinsics.checkNotNullParameter(objects, "item");
        multiStateObjectsItemView.clearItems();
        int i2 = 0;
        for (T t : objects.getItems()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            multiStateObjectsItemView.addItem(MultiStateObjectsItemPresenterKt.access$composeTextForSelect(t), new a(i2, multiStateObjectsItemView, this, objects));
            i2 = i3;
        }
        if (objects.getAddMoreVisible()) {
            multiStateObjectsItemView.appendAddMoreButton(new b(this, objects));
        }
        multiStateObjectsItemView.setTitle(objects.getHideTitle() ? null : objects.getTitle());
        multiStateObjectsItemView.setTag(objects.getTitle());
    }
}
