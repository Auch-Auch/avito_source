package com.avito.android.publish.slots.information_with_user_id;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.DeepLinkClicksStreamHolder;
import com.avito.android.publish.slots.ReactiveSlot;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.publish.slots.information_with_user_id.item.InformationWithUserIdItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Profile;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.information.InformationSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.information.InformationWithUserIdSlot;
import com.avito.android.remote.model.text.Attribute;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DateAttribute;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import com.avito.android.remote.model.text.FontAttribute;
import com.avito.android.remote.model.text.LinkAttribute;
import com.avito.android.remote.model.text.UnknownAttribute;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$¨\u00063"}, d2 = {"Lcom/avito/android/publish/slots/information_with_user_id/InformationWithUserIdSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/information/InformationWithUserIdSlot;", "Lcom/avito/android/publish/slots/DeepLinkClicksStreamHolder;", "Lcom/avito/android/publish/slots/ReactiveSlot;", "", "getId", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "getElements", "()Ljava/util/List;", "", "clear", "()V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "dataChangesRelay", g.a, "Lcom/avito/android/remote/model/category_parameters/slot/information/InformationWithUserIdSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/information/InformationWithUserIdSlot;", "slot", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "deepLinksRelay", "Lcom/avito/android/remote/model/text/AttributedText;", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "replacedText", "Lio/reactivex/Observable;", "e", "Lio/reactivex/Observable;", "getDeepLinkClicks", "()Lio/reactivex/Observable;", "deepLinkClicks", "Lio/reactivex/rxjava3/disposables/Disposable;", "c", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscription", "f", "getDataChangesObservable", "dataChangesObservable", "Lcom/avito/android/publish/ProfileSourceInteractor;", "profileSource", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/information/InformationWithUserIdSlot;Lcom/avito/android/publish/ProfileSourceInteractor;Lcom/avito/android/util/SchedulersFactory3;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InformationWithUserIdSlotWrapper implements SlotWrapper<InformationWithUserIdSlot>, DeepLinkClicksStreamHolder, ReactiveSlot {
    public final PublishRelay<DeepLink> a;
    public final PublishRelay<ConsumeValueChangeResult> b;
    public final Disposable c;
    public AttributedText d;
    @NotNull
    public final Observable<DeepLink> e;
    @NotNull
    public final Observable<ConsumeValueChangeResult> f;
    @NotNull
    public final InformationWithUserIdSlot g;

    public static final class a<T> implements Consumer<Profile> {
        public final /* synthetic */ InformationWithUserIdSlotWrapper a;

        public a(InformationWithUserIdSlotWrapper informationWithUserIdSlotWrapper) {
            this.a = informationWithUserIdSlotWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.jakewharton.rxrelay2.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Profile profile) {
            InformationWithUserIdSlotWrapper informationWithUserIdSlotWrapper = this.a;
            AttributedText text = ((InformationSlotConfig) informationWithUserIdSlotWrapper.getSlot().getWidget().getConfig()).getText();
            String userId = profile.getUserId();
            if (userId == null) {
                userId = "";
            }
            informationWithUserIdSlotWrapper.d = InformationWithUserIdSlotWrapper.access$replaceUserId(informationWithUserIdSlotWrapper, text, userId);
            this.a.b.accept(new ConsumeValueChangeResult.NeedViewUpdate(SlotType.INFORMATION_WITH_USER_ID));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public InformationWithUserIdSlotWrapper(@NotNull InformationWithUserIdSlot informationWithUserIdSlot, @NotNull ProfileSourceInteractor profileSourceInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(informationWithUserIdSlot, "slot");
        Intrinsics.checkNotNullParameter(profileSourceInteractor, "profileSource");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.g = informationWithUserIdSlot;
        PublishRelay<DeepLink> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        PublishRelay<ConsumeValueChangeResult> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.b = create2;
        ((InformationSlotConfig) getSlot().getWidget().getConfig()).getText().setOnDeepLinkClickListener(new OnDeepLinkClickListener(this) { // from class: com.avito.android.publish.slots.information_with_user_id.InformationWithUserIdSlotWrapper.1
            public final /* synthetic */ InformationWithUserIdSlotWrapper a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
            public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                this.a.a.accept(deepLink);
            }
        });
        Disposable subscribe = InteropKt.toV3(profileSourceInteractor.getProfile()).subscribeOn(schedulersFactory3.io()).observeOn(schedulersFactory3.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "profileSource\n          …          }\n            )");
        this.c = subscribe;
        this.e = create;
        this.f = create2;
    }

    public static final AttributedText access$replaceUserId(InformationWithUserIdSlotWrapper informationWithUserIdSlotWrapper, AttributedText attributedText, String str) {
        Object obj;
        Objects.requireNonNull(informationWithUserIdSlotWrapper);
        ArrayList arrayList = new ArrayList();
        for (Attribute attribute : attributedText.getAttributes()) {
            String replace$default = m.replace$default(attribute.getTitle(), "{{userID}}", str, false, 4, (Object) null);
            if (attribute instanceof FontAttribute) {
                obj = FontAttribute.copy$default((FontAttribute) attribute, null, replace$default, null, 5, null);
            } else if (attribute instanceof LinkAttribute) {
                obj = LinkAttribute.copy$default((LinkAttribute) attribute, null, replace$default, null, 5, null);
            } else if (attribute instanceof DeepLinkAttribute) {
                obj = DeepLinkAttribute.copy$default((DeepLinkAttribute) attribute, null, replace$default, null, null, null, 29, null);
            } else if (attribute instanceof UnknownAttribute) {
                obj = UnknownAttribute.copy$default((UnknownAttribute) attribute, null, replace$default, null, 5, null);
            } else if (attribute instanceof DateAttribute) {
                obj = DateAttribute.copy$default((DateAttribute) attribute, null, replace$default, null, null, 13, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(obj);
        }
        return new AttributedText(attributedText.getText(), arrayList);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.ReactiveSlot
    public void clear() {
        this.c.dispose();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        return SlotWrapper.DefaultImpls.consumeItemValueChange(this, item, parameterSlot);
    }

    @Override // com.avito.android.publish.slots.ReactiveSlot
    @NotNull
    public Observable<ConsumeValueChangeResult> getDataChangesObservable() {
        return this.f;
    }

    @Override // com.avito.android.publish.slots.DeepLinkClicksStreamHolder
    @NotNull
    public Observable<DeepLink> getDeepLinkClicks() {
        return this.e;
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        List<Item> listOf;
        AttributedText attributedText = this.d;
        return (attributedText == null || (listOf = d.listOf(new InformationWithUserIdItem(getId(), attributedText))) == null) ? CollectionsKt__CollectionsKt.emptyList() : listOf;
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
    public InformationWithUserIdSlot getSlot() {
        return this.g;
    }
}
