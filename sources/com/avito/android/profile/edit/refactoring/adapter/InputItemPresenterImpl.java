package com.avito.android.profile.edit.refactoring.adapter;

import com.avito.android.profile.edit.refactoring.adapter.item.InputItem;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/InputItemPresenterImpl;", "Lcom/avito/android/profile/edit/refactoring/adapter/InputItemPresenter;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditTextSingleLineItemView;", "view", "Lcom/avito/android/profile/edit/refactoring/adapter/item/InputItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/edit/refactoring/adapter/EditTextSingleLineItemView;Lcom/avito/android/profile/edit/refactoring/adapter/item/InputItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemPresenterImpl implements InputItemPresenter {
    public final Consumer<EditProfileItem> a;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ EditTextSingleLineItemView a;
        public final /* synthetic */ InputItemPresenterImpl b;
        public final /* synthetic */ InputItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(EditTextSingleLineItemView editTextSingleLineItemView, InputItemPresenterImpl inputItemPresenterImpl, InputItem inputItem) {
            super(1);
            this.a = editTextSingleLineItemView;
            this.b = inputItemPresenterImpl;
            this.c = inputItem;
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
        public final /* synthetic */ EditTextSingleLineItemView a;
        public final /* synthetic */ InputItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(EditTextSingleLineItemView editTextSingleLineItemView, InputItemPresenterImpl inputItemPresenterImpl, InputItem inputItem) {
            super(1);
            this.a = editTextSingleLineItemView;
            this.b = inputItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean z;
            boolean booleanValue = bool.booleanValue();
            EditTextSingleLineItemView editTextSingleLineItemView = this.a;
            if (booleanValue) {
                z = false;
            } else {
                z = this.b.getHasError();
            }
            editTextSingleLineItemView.setHasError(z);
            return Unit.INSTANCE;
        }
    }

    public InputItemPresenterImpl(@NotNull Consumer<EditProfileItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull EditTextSingleLineItemView editTextSingleLineItemView, @NotNull InputItem inputItem, int i) {
        Intrinsics.checkNotNullParameter(editTextSingleLineItemView, "view");
        Intrinsics.checkNotNullParameter(inputItem, "item");
        editTextSingleLineItemView.setTextChangeListener(new a(editTextSingleLineItemView, this, inputItem));
        editTextSingleLineItemView.setFocusChangeListener(new b(editTextSingleLineItemView, this, inputItem));
        editTextSingleLineItemView.setHint(inputItem.getTitle());
        editTextSingleLineItemView.setText(inputItem.getValue());
        editTextSingleLineItemView.setHasError(inputItem.getHasError());
    }
}
