package com.avito.android.rating.publish.select_advert.adapter.advert;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItemPresenterImpl;", "Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItemPresenter;", "Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItemView;", "view", "Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItemView;Lcom/avito/android/rating/publish/select_advert/adapter/advert/AdvertItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "actionConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemPresenterImpl implements AdvertItemPresenter {
    public final Consumer<SelectAdvertAction> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ AdvertItemPresenterImpl a;
        public final /* synthetic */ AdvertItem b;

        public a(AdvertItemPresenterImpl advertItemPresenterImpl, AdvertItem advertItem) {
            this.a = advertItemPresenterImpl;
            this.b = advertItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(new SelectAdvertAction.AdvertItemClick(this.b));
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AdvertItemView advertItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = advertItemView;
            this.b = compositeDisposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.clear();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertItemPresenterImpl(@NotNull Consumer<SelectAdvertAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull AdvertItemView advertItemView, @NotNull AdvertItem advertItem, int i) {
        Intrinsics.checkNotNullParameter(advertItemView, "view");
        Intrinsics.checkNotNullParameter(advertItem, "item");
        String title = advertItem.getSummary().getTitle();
        if (title == null) {
            title = "";
        }
        advertItemView.setTitle(title);
        advertItemView.setPrice(advertItem.getSummary().getPrice());
        advertItemView.setPicture(AvitoPictureKt.pictureOf$default(advertItem.getSummary().getImage(), false, 0.0f, 1.5f, null, 20, null));
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        advertItemView.setUnbindListener(new b(advertItemView, compositeDisposable));
        Disposable subscribe = advertItemView.clicks().subscribe(new a(this, advertItem));
        Intrinsics.checkNotNullExpressionValue(subscribe, "clicks().subscribe {\n   …lick(item))\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
