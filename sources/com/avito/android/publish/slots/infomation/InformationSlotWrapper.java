package com.avito.android.publish.slots.infomation;

import com.avito.android.component.disclaimer.DisclaimerItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.DeepLinkClicksStreamHolder;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.information.InformationSlot;
import com.avito.android.remote.model.category_parameters.slot.information.InformationSlotConfig;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u001b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/publish/slots/infomation/InformationSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/information/InformationSlot;", "Lcom/avito/android/publish/slots/DeepLinkClicksStreamHolder;", "", "getId", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "getElements", "()Ljava/util/List;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "deepLinksRelay", "d", "Lcom/avito/android/remote/model/category_parameters/slot/information/InformationSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/information/InformationSlot;", "slot", "Lio/reactivex/Observable;", "c", "Lio/reactivex/Observable;", "getDeepLinkClicks", "()Lio/reactivex/Observable;", "deepLinkClicks", "com/avito/android/publish/slots/infomation/InformationSlotWrapper$deepLinkClickListener$1", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/slots/infomation/InformationSlotWrapper$deepLinkClickListener$1;", "deepLinkClickListener", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/information/InformationSlot;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InformationSlotWrapper implements SlotWrapper<InformationSlot>, DeepLinkClicksStreamHolder {
    public final PublishRelay<DeepLink> a;
    public final InformationSlotWrapper$deepLinkClickListener$1 b = new InformationSlotWrapper$deepLinkClickListener$1(this);
    @NotNull
    public final Observable<DeepLink> c;
    @NotNull
    public final InformationSlot d;

    public InformationSlotWrapper(@NotNull InformationSlot informationSlot) {
        Intrinsics.checkNotNullParameter(informationSlot, "slot");
        this.d = informationSlot;
        PublishRelay<DeepLink> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        Observable<DeepLink> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "deepLinksRelay.hide()");
        this.c = hide;
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        return SlotWrapper.DefaultImpls.consumeItemValueChange(this, item, parameterSlot);
    }

    @Override // com.avito.android.publish.slots.DeepLinkClicksStreamHolder
    @NotNull
    public Observable<DeepLink> getDeepLinkClicks() {
        return this.c;
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        AttributedText text = ((InformationSlotConfig) getSlot().getWidget().getConfig()).getText();
        text.setOnDeepLinkClickListener(this.b);
        return d.listOf(new DisclaimerItem(getSlot().getId(), text));
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public String getId() {
        return getSlot().getId();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<Unit>> prepare() {
        return SlotWrapper.DefaultImpls.prepare(this);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public InformationSlot getSlot() {
        return this.d;
    }
}
