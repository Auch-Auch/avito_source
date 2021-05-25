package com.avito.android.profile.edit.refactoring.adapter;

import com.avito.android.profile.edit.refactoring.adapter.item.PhoneInputItem;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/PhoneInputItemPresenterImpl;", "Lcom/avito/android/profile/edit/refactoring/adapter/PhoneInputItemPresenter;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditTextPhoneItemView;", "view", "Lcom/avito/android/profile/edit/refactoring/adapter/item/PhoneInputItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/edit/refactoring/adapter/EditTextPhoneItemView;Lcom/avito/android/profile/edit/refactoring/adapter/item/PhoneInputItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneInputItemPresenterImpl implements PhoneInputItemPresenter {
    public final Consumer<EditProfileItem> a;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ EditTextPhoneItemView a;
        public final /* synthetic */ PhoneInputItemPresenterImpl b;
        public final /* synthetic */ PhoneInputItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(EditTextPhoneItemView editTextPhoneItemView, PhoneInputItemPresenterImpl phoneInputItemPresenterImpl, PhoneInputItem phoneInputItem) {
            super(1);
            this.a = editTextPhoneItemView;
            this.b = phoneInputItemPresenterImpl;
            this.c = phoneInputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            if (!Intrinsics.areEqual(this.c.getValue(), str2)) {
                this.c.setValue(str2);
                this.b.a.accept(this.c);
                if (this.c.getHasError()) {
                    this.c.setHasError(false);
                    this.a.setHasError(this.c.getHasError());
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ EditTextPhoneItemView a;
        public final /* synthetic */ PhoneInputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(EditTextPhoneItemView editTextPhoneItemView, PhoneInputItemPresenterImpl phoneInputItemPresenterImpl, PhoneInputItem phoneInputItem) {
            super(1);
            this.a = editTextPhoneItemView;
            this.b = phoneInputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean z;
            boolean booleanValue = bool.booleanValue();
            EditTextPhoneItemView editTextPhoneItemView = this.a;
            if (booleanValue) {
                z = false;
            } else {
                z = this.b.getHasError();
            }
            editTextPhoneItemView.setHasError(z);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditTextPhoneItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(EditTextPhoneItemView editTextPhoneItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = editTextPhoneItemView;
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

    public PhoneInputItemPresenterImpl(@NotNull Consumer<EditProfileItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull EditTextPhoneItemView editTextPhoneItemView, @NotNull PhoneInputItem phoneInputItem, int i) {
        Intrinsics.checkNotNullParameter(editTextPhoneItemView, "view");
        Intrinsics.checkNotNullParameter(phoneInputItem, "item");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        editTextPhoneItemView.setUnbindListener(new c(editTextPhoneItemView, compositeDisposable));
        DisposableKt.plusAssign(compositeDisposable, editTextPhoneItemView.setFormattedInputListener(new a(editTextPhoneItemView, this, phoneInputItem)));
        DisposableKt.plusAssign(compositeDisposable, editTextPhoneItemView.setFocusChangeListener(new b(editTextPhoneItemView, this, phoneInputItem)));
        editTextPhoneItemView.setHint((CharSequence) phoneInputItem.getTitle());
        editTextPhoneItemView.setText(phoneInputItem.getValue());
        editTextPhoneItemView.setHasError(phoneInputItem.getHasError());
    }
}
