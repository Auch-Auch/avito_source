package com.avito.android.tariff.count.item;

import android.os.Bundle;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eR:\u0010\u0013\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004 \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/tariff/count/item/CountItemPresenterImpl;", "Lcom/avito/android/tariff/count/item/CountItemPresenter;", "Lcom/avito/android/tariff/count/item/CountItemView;", "view", "Lcom/avito/android/tariff/count/item/CountItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tariff/count/item/CountItemView;Lcom/avito/android/tariff/count/item/CountItem;I)V", "", "", "payloads", "(Lcom/avito/android/tariff/count/item/CountItemView;Lcom/avito/android/tariff/count/item/CountItem;ILjava/util/List;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "itemClickSubject", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getItemClicks", "()Lio/reactivex/Observable;", "itemClicks", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class CountItemPresenterImpl implements CountItemPresenter {
    public final PublishRelay<CountItem> a;
    @NotNull
    public final Observable<CountItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CountItemPresenterImpl a;
        public final /* synthetic */ CountItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CountItemPresenterImpl countItemPresenterImpl, CountItem countItem) {
            super(0);
            this.a = countItemPresenterImpl;
            this.b = countItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CountItemPresenterImpl() {
        PublishRelay<CountItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "itemClickSubject");
        this.b = create;
    }

    @Override // com.avito.android.tariff.count.item.CountItemPresenter
    @NotNull
    public Observable<CountItem> getItemClicks() {
        return this.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(CountItemView countItemView, CountItem countItem, int i, List list) {
        bindView(countItemView, countItem, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull CountItemView countItemView, @NotNull CountItem countItem, int i) {
        Intrinsics.checkNotNullParameter(countItemView, "view");
        Intrinsics.checkNotNullParameter(countItem, "item");
        countItemView.setTitle(countItem.getTitle());
        countItemView.setDescription(countItem.getDescription());
        countItemView.setSelected(countItem.isChecked());
        countItemView.setItemClickListener(new a(this, countItem));
    }

    public void bindView(@NotNull CountItemView countItemView, @NotNull CountItem countItem, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(countItemView, "view");
        Intrinsics.checkNotNullParameter(countItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof Bundle) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(countItemView, countItem, i);
        } else if (t3.containsKey("checked")) {
            countItemView.setSelected(t3.getBoolean("checked"));
        }
    }
}
