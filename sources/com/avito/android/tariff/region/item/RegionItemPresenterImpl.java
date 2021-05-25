package com.avito.android.tariff.region.item;

import android.os.Bundle;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00100\u00100\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/tariff/region/item/RegionItemPresenterImpl;", "Lcom/avito/android/tariff/region/item/RegionItemPresenter;", "Lcom/avito/android/tariff/region/item/RegionItemView;", "view", "Lcom/avito/android/tariff/region/item/RegionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tariff/region/item/RegionItemView;Lcom/avito/android/tariff/region/item/RegionItem;I)V", "", "", "payloads", "(Lcom/avito/android/tariff/region/item/RegionItemView;Lcom/avito/android/tariff/region/item/RegionItem;ILjava/util/List;)V", "Lio/reactivex/Observable;", "", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getRegionSelectionObservable", "()Lio/reactivex/Observable;", "regionSelectionObservable", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lio/reactivex/subjects/PublishSubject;", "regionSelectionSubject", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class RegionItemPresenterImpl implements RegionItemPresenter {
    public final PublishSubject<String> a;
    @NotNull
    public final Observable<String> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RegionItemPresenterImpl a;
        public final /* synthetic */ RegionItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RegionItemPresenterImpl regionItemPresenterImpl, RegionItem regionItem) {
            super(0);
            this.a = regionItemPresenterImpl;
            this.b = regionItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onNext(this.b.getStringId());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public RegionItemPresenterImpl() {
        PublishSubject<String> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create<String>()");
        this.a = create;
        this.b = create;
    }

    @Override // com.avito.android.tariff.region.item.RegionItemPresenter
    @NotNull
    public Observable<String> getRegionSelectionObservable() {
        return this.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(RegionItemView regionItemView, RegionItem regionItem, int i, List list) {
        bindView(regionItemView, regionItem, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull RegionItemView regionItemView, @NotNull RegionItem regionItem, int i) {
        Intrinsics.checkNotNullParameter(regionItemView, "view");
        Intrinsics.checkNotNullParameter(regionItem, "item");
        regionItemView.setTitle(regionItem.getTitle());
        regionItemView.setSelected(regionItem.isChecked());
        regionItemView.setItemClickListener(new a(this, regionItem));
    }

    public void bindView(@NotNull RegionItemView regionItemView, @NotNull RegionItem regionItem, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(regionItemView, "view");
        Intrinsics.checkNotNullParameter(regionItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof Bundle) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(regionItemView, regionItem, i);
        } else {
            regionItemView.setSelected(t3.getBoolean("checked"));
        }
    }
}
