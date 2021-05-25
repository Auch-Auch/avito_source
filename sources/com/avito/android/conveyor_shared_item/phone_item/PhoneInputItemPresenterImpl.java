package com.avito.android.conveyor_shared_item.phone_item;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemPresenterImpl;", "Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemPresenter;", "Lcom/avito/android/conveyor_shared_item/phone_item/EditTextPhoneItemView;", "view", "Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/conveyor_shared_item/phone_item/EditTextPhoneItemView;Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItem;I)V", "Lio/reactivex/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneInputItemPresenterImpl implements PhoneInputItemPresenter {
    public final Consumer<PhoneInputItem> a;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ PhoneInputItemPresenterImpl a;
        public final /* synthetic */ PhoneInputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PhoneInputItemPresenterImpl phoneInputItemPresenterImpl, PhoneInputItem phoneInputItem) {
            super(1);
            this.a = phoneInputItemPresenterImpl;
            this.b = phoneInputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "newValue");
            if (!Intrinsics.areEqual(this.b.getValue(), str2)) {
                this.a.a.accept(PhoneInputItem.copy$default(this.b, null, null, str2, false, 11, null));
            }
            return Unit.INSTANCE;
        }
    }

    public PhoneInputItemPresenterImpl(@NotNull Consumer<PhoneInputItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull EditTextPhoneItemView editTextPhoneItemView, @NotNull PhoneInputItem phoneInputItem, int i) {
        Intrinsics.checkNotNullParameter(editTextPhoneItemView, "view");
        Intrinsics.checkNotNullParameter(phoneInputItem, "item");
        editTextPhoneItemView.setRawListener(new a(this, phoneInputItem));
        editTextPhoneItemView.setHint((CharSequence) phoneInputItem.getTitle());
        editTextPhoneItemView.setText(phoneInputItem.getValue());
        editTextPhoneItemView.setHasError(phoneInputItem.getHasError());
    }
}
