package com.avito.android.profile.cards.phones;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.PhoneClickedEvent;
import com.avito.android.component.clickable_info_block.ClickableInfoBlock;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.profile.cards.phones.PhonesCardItemPresenterOld;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.util.rx3.InteropKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOldImpl;", "Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld;", "Lcom/avito/android/profile/cards/phones/PhonesCardItemViewOld;", "view", "Lcom/avito/android/profile/cards/CardItem$PhonesCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/cards/phones/PhonesCardItemViewOld;Lcom/avito/android/profile/cards/CardItem$PhonesCardItem;I)V", "Lcom/avito/android/profile/cards/phones/PhonesActionResourceProvider;", "c", "Lcom/avito/android/profile/cards/phones/PhonesActionResourceProvider;", "resourceProvider", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld$Action;", AuthSource.BOOKING_ORDER, "Lio/reactivex/functions/Consumer;", "actionsConsumer", AuthSource.SEND_ABUSE, "valueConsumer", "<init>", "(Lio/reactivex/functions/Consumer;Lio/reactivex/functions/Consumer;Lcom/avito/android/profile/cards/phones/PhonesActionResourceProvider;Lcom/avito/android/analytics/Analytics;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesCardItemPresenterOldImpl implements PhonesCardItemPresenterOld {
    public final Consumer<CardItem.PhonesCardItem> a;
    public final Consumer<PhonesCardItemPresenterOld.Action> b;
    public final PhonesActionResourceProvider c;
    public final Analytics d;

    public static final class a<T, R> implements Function<ClickableInfoBlock, ObservableSource<? extends ClickableInfoBlock.Action>> {
        public final /* synthetic */ Phone a;
        public final /* synthetic */ PhonesCardItemPresenterOldImpl b;
        public final /* synthetic */ PhonesCardItemViewOld c;
        public final /* synthetic */ CardItem.PhonesCardItem d;

        public a(Phone phone, PhonesCardItemPresenterOldImpl phonesCardItemPresenterOldImpl, PhonesCardItemViewOld phonesCardItemViewOld, CardItem.PhonesCardItem phonesCardItem) {
            this.a = phone;
            this.b = phonesCardItemPresenterOldImpl;
            this.c = phonesCardItemViewOld;
            this.d = phonesCardItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ClickableInfoBlock.Action> apply(ClickableInfoBlock clickableInfoBlock) {
            ClickableInfoBlock clickableInfoBlock2 = clickableInfoBlock;
            Intrinsics.checkNotNullParameter(clickableInfoBlock2, "infoBlock");
            this.b.d.track(new PhoneClickedEvent(this.a, Math.max(this.d.getPhones().size() - 1, 0)));
            return InteropKt.toV2(clickableInfoBlock2.showActions(PhonesCardItemPresenterOldImpl.access$generateActions(this.b, this.a, this.d.getPhones().size()))).toObservable();
        }
    }

    public static final class b<T, R> implements Function<ClickableInfoBlock.Action, Pair<? extends ClickableInfoBlock.Action, ? extends Phone>> {
        public final /* synthetic */ Phone a;

        public b(Phone phone) {
            this.a = phone;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends ClickableInfoBlock.Action, ? extends Phone> apply(ClickableInfoBlock.Action action) {
            ClickableInfoBlock.Action action2 = action;
            Intrinsics.checkNotNullParameter(action2, "it");
            return TuplesKt.to(action2, this.a);
        }
    }

    public static final class c<T> implements Consumer<Pair<? extends ClickableInfoBlock.Action, ? extends Phone>> {
        public final /* synthetic */ PhonesCardItemPresenterOldImpl a;

        public c(PhonesCardItemPresenterOldImpl phonesCardItemPresenterOldImpl) {
            this.a = phonesCardItemPresenterOldImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: io.reactivex.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends ClickableInfoBlock.Action, ? extends Phone> pair) {
            Pair<? extends ClickableInfoBlock.Action, ? extends Phone> pair2 = pair;
            this.a.b.accept(new PhonesCardItemPresenterOld.Action(((ClickableInfoBlock.Action) pair2.component1()).getId(), (Phone) pair2.component2()));
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PhonesCardItemPresenterOldImpl a;
        public final /* synthetic */ CardItem.PhonesCardItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(PhonesCardItemPresenterOldImpl phonesCardItemPresenterOldImpl, CardItem.PhonesCardItem phonesCardItem) {
            super(0);
            this.a = phonesCardItemPresenterOldImpl;
            this.b = phonesCardItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public PhonesCardItemPresenterOldImpl(@NotNull Consumer<CardItem.PhonesCardItem> consumer, @NotNull Consumer<PhonesCardItemPresenterOld.Action> consumer2, @NotNull PhonesActionResourceProvider phonesActionResourceProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        Intrinsics.checkNotNullParameter(consumer2, "actionsConsumer");
        Intrinsics.checkNotNullParameter(phonesActionResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = consumer;
        this.b = consumer2;
        this.c = phonesActionResourceProvider;
        this.d = analytics;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0027: APUT  
      (r0v1 com.avito.android.component.clickable_info_block.ClickableInfoBlock$Action[])
      (1 ??[boolean, int, float, short, byte, char])
      (r1v2 com.avito.android.component.clickable_info_block.ClickableInfoBlock$Action)
     */
    public static final List access$generateActions(PhonesCardItemPresenterOldImpl phonesCardItemPresenterOldImpl, Phone phone, int i) {
        ClickableInfoBlock.Action[] actionArr = new ClickableInfoBlock.Action[3];
        boolean z = false;
        actionArr[0] = new ClickableInfoBlock.Action(0, phonesCardItemPresenterOldImpl.c.getRemovePhone());
        ClickableInfoBlock.Action action = new ClickableInfoBlock.Action(1, phonesCardItemPresenterOldImpl.c.getVerifyPhone());
        ClickableInfoBlock.Action action2 = null;
        if (!(!phone.getVerified())) {
            action = null;
        }
        actionArr[1] = action;
        ClickableInfoBlock.Action action3 = new ClickableInfoBlock.Action(2, phonesCardItemPresenterOldImpl.c.getSetForAll());
        if (phone.getVerified() && i > 1) {
            z = true;
        }
        if (z) {
            action2 = action3;
        }
        actionArr[2] = action2;
        return CollectionsKt__CollectionsKt.listOfNotNull((Object[]) actionArr);
    }

    public void bindView(@NotNull PhonesCardItemViewOld phonesCardItemViewOld, @NotNull CardItem.PhonesCardItem phonesCardItem, int i) {
        Intrinsics.checkNotNullParameter(phonesCardItemViewOld, "view");
        Intrinsics.checkNotNullParameter(phonesCardItem, "item");
        phonesCardItemViewOld.removePhones();
        List<Phone> phones = phonesCardItem.getPhones();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(phones, 10));
        for (T t : phones) {
            arrayList.add(phonesCardItemViewOld.addPhone(t.getPhone(), t.getVerified(), t.isLocked()).flatMap(new a(t, this, phonesCardItemViewOld, phonesCardItem)).map(new b(t)));
        }
        Observable.merge(arrayList).subscribe(new c(this));
        phonesCardItemViewOld.setActionListener(new d(this, phonesCardItem));
    }
}
