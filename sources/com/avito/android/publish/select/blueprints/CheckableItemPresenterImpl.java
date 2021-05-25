package com.avito.android.publish.select.blueprints;

import com.avito.android.publish.select.CheckableItem;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR:\u0010\u0010\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/publish/select/blueprints/CheckableItemPresenterImpl;", "Lcom/avito/android/publish/select/blueprints/CheckableItemPresenter;", "Lcom/avito/android/publish/select/blueprints/CheckableItemView;", "view", "Lcom/avito/android/publish/select/CheckableItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/select/blueprints/CheckableItemView;Lcom/avito/android/publish/select/CheckableItem;I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "itemClickStream", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getItemClickObservable", "()Lio/reactivex/Observable;", "itemClickObservable", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CheckableItemPresenterImpl implements CheckableItemPresenter {
    public final PublishRelay<String> a;
    @NotNull
    public final Observable<String> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CheckableItemPresenterImpl a;
        public final /* synthetic */ CheckableItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CheckableItemPresenterImpl checkableItemPresenterImpl, CheckableItem checkableItem) {
            super(0);
            this.a = checkableItemPresenterImpl;
            this.b = checkableItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b.getStringId());
            return Unit.INSTANCE;
        }
    }

    public CheckableItemPresenterImpl() {
        PublishRelay<String> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "itemClickStream");
        this.b = create;
    }

    @Override // com.avito.android.publish.select.blueprints.CheckableItemPresenter
    @NotNull
    public Observable<String> getItemClickObservable() {
        return this.b;
    }

    public void bindView(@NotNull CheckableItemView checkableItemView, @NotNull CheckableItem checkableItem, int i) {
        Intrinsics.checkNotNullParameter(checkableItemView, "view");
        Intrinsics.checkNotNullParameter(checkableItem, "item");
        checkableItemView.setTitle(checkableItem.getTitle());
        checkableItemView.setChecked(checkableItem.isChecked());
        checkableItemView.setOnClickListener(new a(this, checkableItem));
    }
}
