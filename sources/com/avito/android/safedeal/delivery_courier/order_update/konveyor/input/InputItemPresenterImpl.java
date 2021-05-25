package com.avito.android.safedeal.delivery_courier.order_update.konveyor.input;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/input/InputItemPresenterImpl;", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/input/InputItemPresenter;", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/input/InputItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/input/InputItemView;Lcom/avito/android/category_parameters/ParameterElement$Input;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "textChangeConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemPresenterImpl implements InputItemPresenter {
    public final Consumer<ParameterElement> a;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ InputItemView a;
        public final /* synthetic */ InputItemPresenterImpl b;
        public final /* synthetic */ ParameterElement.Input c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputItemView inputItemView, InputItemPresenterImpl inputItemPresenterImpl, ParameterElement.Input input) {
            super(1);
            this.a = inputItemView;
            this.b = inputItemPresenterImpl;
            this.c = input;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "text");
            this.c.setValue(str2);
            this.a.setClearVisible(str2.length() > 0);
            this.b.a.accept(this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ InputItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(InputItemView inputItemView) {
            super(1);
            this.a = inputItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (!bool.booleanValue()) {
                this.a.hideKeyboard();
            }
            return Unit.INSTANCE;
        }
    }

    public InputItemPresenterImpl(@NotNull Consumer<ParameterElement> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "textChangeConsumer");
        this.a = consumer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
        if ((r5.length() > 0) != false) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView r3, @org.jetbrains.annotations.NotNull com.avito.android.category_parameters.ParameterElement.Input r4, int r5) {
        /*
            r2 = this;
            java.lang.String r5 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            java.lang.String r5 = r4.getTitle()
            r3.setTitle(r5)
            com.avito.android.lib.design.input.FormatterType r5 = r4.getInputType()
            r3.setFormatterType(r5)
            java.lang.String r5 = r4.getPlaceholder()
            r3.setHint(r5)
            int r5 = r4.getLines()
            r3.setMinLines(r5)
            java.lang.String r5 = r4.getValue()
            if (r5 == 0) goto L_0x0038
            java.lang.String r5 = r4.getValue()
            r3.setText(r5)
            io.reactivex.functions.Consumer<com.avito.android.category_parameters.ParameterElement> r5 = r2.a
            r5.accept(r4)
        L_0x0038:
            com.avito.android.remote.model.text.AttributedText r5 = r4.getMotivation()
            r3.setMotivation(r5)
            java.lang.String r5 = r4.getError()
            if (r5 == 0) goto L_0x0048
            r3.showError(r5)
        L_0x0048:
            java.lang.String r5 = r4.getValue()
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x005c
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0058
            r5 = 1
            goto L_0x0059
        L_0x0058:
            r5 = 0
        L_0x0059:
            if (r5 == 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r0 = 0
        L_0x005d:
            r3.setClearVisible(r0)
            java.lang.String r5 = r4.getPrefix()
            if (r5 == 0) goto L_0x0069
            r3.setPrefix(r5)
        L_0x0069:
            java.lang.String r5 = r4.getPostfix()
            if (r5 == 0) goto L_0x0072
            r3.setPostfix(r5)
        L_0x0072:
            com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemPresenterImpl$b r5 = new com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemPresenterImpl$b
            r5.<init>(r3)
            r3.setOnFocusChangeListener(r5)
            com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemPresenterImpl$a r5 = new com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemPresenterImpl$a
            r5.<init>(r3, r2, r4)
            r3.setTextChangeListener(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemPresenterImpl.bindView(com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView, com.avito.android.category_parameters.ParameterElement$Input, int):void");
    }
}
