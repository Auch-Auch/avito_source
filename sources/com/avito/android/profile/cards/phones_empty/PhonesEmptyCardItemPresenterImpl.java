package com.avito.android.profile.cards.phones_empty;

import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00040\u000bj\u0002`\f¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00040\u000bj\u0002`\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/cards/phones_empty/PhonesEmptyCardItemPresenterImpl;", "Lcom/avito/android/profile/cards/phones_empty/PhonesEmptyCardItemPresenter;", "Lcom/avito/android/profile/cards/phones_empty/PhonesEmptyCardItemView;", "view", "Lcom/avito/android/profile/cards/CardItem$PhonesEmptyCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/cards/phones_empty/PhonesEmptyCardItemView;Lcom/avito/android/profile/cards/CardItem$PhonesEmptyCardItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/profile/cards/phones_empty/AddPhoneActionConsumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesEmptyCardItemPresenterImpl implements PhonesEmptyCardItemPresenter {
    public final Consumer<CardItem.PhonesEmptyCardItem> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PhonesEmptyCardItemPresenterImpl a;
        public final /* synthetic */ CardItem.PhonesEmptyCardItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PhonesEmptyCardItemPresenterImpl phonesEmptyCardItemPresenterImpl, CardItem.PhonesEmptyCardItem phonesEmptyCardItem) {
            super(0);
            this.a = phonesEmptyCardItemPresenterImpl;
            this.b = phonesEmptyCardItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public PhonesEmptyCardItemPresenterImpl(@NotNull Consumer<CardItem.PhonesEmptyCardItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull PhonesEmptyCardItemView phonesEmptyCardItemView, @NotNull CardItem.PhonesEmptyCardItem phonesEmptyCardItem, int i) {
        Intrinsics.checkNotNullParameter(phonesEmptyCardItemView, "view");
        Intrinsics.checkNotNullParameter(phonesEmptyCardItem, "item");
        phonesEmptyCardItemView.setActionListener(new a(this, phonesEmptyCardItem));
    }
}
