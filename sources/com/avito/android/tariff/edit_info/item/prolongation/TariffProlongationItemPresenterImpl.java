package com.avito.android.tariff.edit_info.item.prolongation;

import android.os.Bundle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b(\u0010)J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R:\u0010\u0017\u001a&\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00040\u0004 \u0015*\u0012\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItemPresenterImpl;", "Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItemPresenter;", "Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItemView;", "view", "Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItemView;Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItem;I)V", "", "", "payloads", "(Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItemView;Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItem;ILjava/util/List;)V", "", "isSwitchOn", "itemView", AuthSource.SEND_ABUSE, "(ZLcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItem;Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItemView;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "prolongationClicksSubject", "Lcom/avito/android/remote/model/text/AttributedText;", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "offDescriptionWithTimestamp", AuthSource.BOOKING_ORDER, "descriptionWithTimestamp", "Lio/reactivex/Observable;", "d", "Lio/reactivex/Observable;", "getProlongationClicks", "()Lio/reactivex/Observable;", "prolongationClicks", "Lcom/avito/android/tariff/edit_info/item/prolongation/ResourceProvider;", "e", "Lcom/avito/android/tariff/edit_info/item/prolongation/ResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/tariff/edit_info/item/prolongation/ResourceProvider;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffProlongationItemPresenterImpl implements TariffProlongationItemPresenter {
    public final PublishRelay<TariffProlongationItem> a;
    public AttributedText b;
    public AttributedText c;
    @NotNull
    public final Observable<TariffProlongationItem> d;
    public final ResourceProvider e;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TariffProlongationItemPresenterImpl a;
        public final /* synthetic */ TariffProlongationItem b;
        public final /* synthetic */ TariffProlongationItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TariffProlongationItemPresenterImpl tariffProlongationItemPresenterImpl, TariffProlongationItem tariffProlongationItem, TariffProlongationItemView tariffProlongationItemView) {
            super(0);
            this.a = tariffProlongationItemPresenterImpl;
            this.b = tariffProlongationItem;
            this.c = tariffProlongationItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a(!this.b.isSwitchOn(), this.b, this.c);
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public TariffProlongationItemPresenterImpl(@NotNull ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        this.e = resourceProvider;
        PublishRelay<TariffProlongationItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "prolongationClicksSubject");
        this.d = create;
    }

    public final void a(boolean z, TariffProlongationItem tariffProlongationItem, TariffProlongationItemView tariffProlongationItemView) {
        AttributedText attributedText;
        tariffProlongationItem.setSwitchOn(z);
        if (z) {
            attributedText = this.b;
        } else {
            attributedText = this.c;
        }
        tariffProlongationItemView.setCurrentText(attributedText);
        tariffProlongationItemView.setSwitcherOn(z);
    }

    @Override // com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemPresenter
    @NotNull
    public Observable<TariffProlongationItem> getProlongationClicks() {
        return this.d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(TariffProlongationItemView tariffProlongationItemView, TariffProlongationItem tariffProlongationItem, int i, List list) {
        bindView(tariffProlongationItemView, tariffProlongationItem, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull TariffProlongationItemView tariffProlongationItemView, @NotNull TariffProlongationItem tariffProlongationItem, int i) {
        Intrinsics.checkNotNullParameter(tariffProlongationItemView, "view");
        Intrinsics.checkNotNullParameter(tariffProlongationItem, "item");
        this.b = tariffProlongationItem.getDescription();
        this.c = tariffProlongationItem.getOffDescription();
        tariffProlongationItemView.setTitle(tariffProlongationItem.getTitle());
        tariffProlongationItemView.setSwitherEnabled(tariffProlongationItem.isSwitchEnabled());
        a(tariffProlongationItem.isSwitchOn(), tariffProlongationItem, tariffProlongationItemView);
        tariffProlongationItemView.setOnClickListener(new a(this, tariffProlongationItem, tariffProlongationItemView));
    }

    public void bindView(@NotNull TariffProlongationItemView tariffProlongationItemView, @NotNull TariffProlongationItem tariffProlongationItem, int i, @NotNull List<? extends Object> list) {
        AttributedText attributedText;
        Intrinsics.checkNotNullParameter(tariffProlongationItemView, "view");
        Intrinsics.checkNotNullParameter(tariffProlongationItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        Boolean bool = null;
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof Bundle) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(tariffProlongationItemView, tariffProlongationItem, i);
        } else if (t3.containsKey("payload")) {
            TariffProlongationPayload tariffProlongationPayload = (TariffProlongationPayload) t3.getParcelable("payload");
            if ((tariffProlongationPayload != null ? tariffProlongationPayload.isChecked() : null) != null) {
                a(tariffProlongationPayload.isChecked().booleanValue(), tariffProlongationItem, tariffProlongationItemView);
            }
            if (tariffProlongationPayload != null) {
                bool = tariffProlongationPayload.isEnabled();
            }
            if (bool != null) {
                boolean booleanValue = tariffProlongationPayload.isEnabled().booleanValue();
                tariffProlongationItemView.setSwitherEnabled(booleanValue);
                if (booleanValue) {
                    if (tariffProlongationItem.isSwitchOn()) {
                        attributedText = this.b;
                    } else {
                        attributedText = this.c;
                    }
                    tariffProlongationItemView.setCurrentText(attributedText);
                    return;
                }
                tariffProlongationItemView.setCurrentText(this.e.getAutoProlongInProgress());
            }
        }
    }
}
