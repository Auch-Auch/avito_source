package com.avito.android.publish.objects.blueprints;

import com.avito.android.publish.objects.DeleteObjectElement;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonItemPresenterImpl;", "Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonItemPresenter;", "Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonView;", "view", "Lcom/avito/android/publish/objects/DeleteObjectElement;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonView;Lcom/avito/android/publish/objects/DeleteObjectElement;I)V", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getClicksObservable", "()Lio/reactivex/Observable;", "clicksObservable", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "clicksRelay", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteObjectButtonItemPresenterImpl implements DeleteObjectButtonItemPresenter {
    public final PublishRelay<DeleteObjectElement> a;
    @NotNull
    public final Observable<DeleteObjectElement> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DeleteObjectButtonItemPresenterImpl a;
        public final /* synthetic */ DeleteObjectElement b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeleteObjectButtonItemPresenterImpl deleteObjectButtonItemPresenterImpl, DeleteObjectElement deleteObjectElement) {
            super(0);
            this.a = deleteObjectButtonItemPresenterImpl;
            this.b = deleteObjectElement;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DeleteObjectButtonView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DeleteObjectButtonView deleteObjectButtonView) {
            super(0);
            this.a = deleteObjectButtonView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setOnClickListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public DeleteObjectButtonItemPresenterImpl() {
        PublishRelay<DeleteObjectElement> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        Observable<DeleteObjectElement> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "clicksRelay.hide()");
        this.b = hide;
    }

    @Override // com.avito.android.publish.objects.blueprints.DeleteObjectButtonItemPresenter
    @NotNull
    public Observable<DeleteObjectElement> getClicksObservable() {
        return this.b;
    }

    public void bindView(@NotNull DeleteObjectButtonView deleteObjectButtonView, @NotNull DeleteObjectElement deleteObjectElement, int i) {
        Intrinsics.checkNotNullParameter(deleteObjectButtonView, "view");
        Intrinsics.checkNotNullParameter(deleteObjectElement, "item");
        deleteObjectButtonView.setOnClickListener(new a(this, deleteObjectElement));
        deleteObjectButtonView.setUnbindListener(new b(deleteObjectButtonView));
    }
}
