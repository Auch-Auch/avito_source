package com.avito.android.profile.cards.phones;

import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.user_profile.Phone;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0010\u0010\u0017\u001a\f\u0012\u0004\u0012\u00020\u00040\u0014j\u0002`\u0015\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\b*\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0017\u001a\f\u0012\u0004\u0012\u00020\u00040\u0014j\u0002`\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterImpl;", "Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenter;", "Lcom/avito/android/profile/cards/phones/PhonesCardItemView;", "view", "Lcom/avito/android/profile/cards/CardItem$PhonesCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/cards/phones/PhonesCardItemView;Lcom/avito/android/profile/cards/CardItem$PhonesCardItem;I)V", "", "Lcom/avito/android/remote/model/user_profile/Phone;", "phones", AuthSource.SEND_ABUSE, "(Lcom/avito/android/profile/cards/phones/PhonesCardItemView;Ljava/util/List;)V", "Lcom/avito/android/profile/cards/phones/PhonesCardItemResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/cards/phones/PhonesCardItemResourceProvider;", "resourceProvider", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/profile/cards/phones/PhonesCardActionConsumer;", "Lio/reactivex/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/functions/Consumer;Lcom/avito/android/profile/cards/phones/PhonesCardItemResourceProvider;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesCardItemPresenterImpl implements PhonesCardItemPresenter {
    public final Consumer<CardItem.PhonesCardItem> a;
    public final PhonesCardItemResourceProvider b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PhonesCardItemPresenterImpl a;
        public final /* synthetic */ CardItem.PhonesCardItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PhonesCardItemPresenterImpl phonesCardItemPresenterImpl, CardItem.PhonesCardItem phonesCardItem) {
            super(0);
            this.a = phonesCardItemPresenterImpl;
            this.b = phonesCardItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public PhonesCardItemPresenterImpl(@NotNull Consumer<CardItem.PhonesCardItem> consumer, @NotNull PhonesCardItemResourceProvider phonesCardItemResourceProvider) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        Intrinsics.checkNotNullParameter(phonesCardItemResourceProvider, "resourceProvider");
        this.a = consumer;
        this.b = phonesCardItemResourceProvider;
    }

    public final void a(PhonesCardItemView phonesCardItemView, List<Phone> list) {
        for (T t : list) {
            phonesCardItemView.addPhone(t.getPhone(), t.getVerified(), t.isLocked());
        }
    }

    public void bindView(@NotNull PhonesCardItemView phonesCardItemView, @NotNull CardItem.PhonesCardItem phonesCardItem, int i) {
        Intrinsics.checkNotNullParameter(phonesCardItemView, "view");
        Intrinsics.checkNotNullParameter(phonesCardItem, "item");
        phonesCardItemView.removePhones();
        if (phonesCardItem.getPhones().size() > 3) {
            a(phonesCardItemView, phonesCardItem.getPhones().subList(0, 3));
            phonesCardItemView.addMorePhonesView(this.b.morePhonesText(phonesCardItem.getPhones().size() - 3));
        } else {
            a(phonesCardItemView, phonesCardItem.getPhones());
        }
        phonesCardItemView.setActionListener(new a(this, phonesCardItem));
    }
}
