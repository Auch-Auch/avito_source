package com.avito.android.str_calendar.seller.edit.konveyor.input;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.common.InputFormatter;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemPresenterImpl;", "Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemPresenter;", "Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemView;Lcom/avito/android/category_parameters/ParameterElement$Input;I)V", "", "value", AuthSource.SEND_ABUSE, "(Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemView;Ljava/lang/String;)V", "Lcom/avito/android/provider/InputItemFormatterProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/provider/InputItemFormatterProvider;", "formatterProvider", "Lio/reactivex/functions/Consumer;", "Lio/reactivex/functions/Consumer;", "changeConsumer", "<init>", "(Lio/reactivex/functions/Consumer;Lcom/avito/android/provider/InputItemFormatterProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class RdsInputItemPresenterImpl implements RdsInputItemPresenter {
    public final Consumer<ParameterElement.Input> a;
    public final InputItemFormatterProvider b;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ RdsInputItemPresenterImpl a;
        public final /* synthetic */ RdsInputItemView b;
        public final /* synthetic */ ParameterElement.Input c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RdsInputItemPresenterImpl rdsInputItemPresenterImpl, RdsInputItemView rdsInputItemView, ParameterElement.Input input) {
            super(1);
            this.a = rdsInputItemPresenterImpl;
            this.b = rdsInputItemView;
            this.c = input;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (!bool.booleanValue()) {
                this.b.hideKeyboard();
            }
            this.a.a(this.b, this.c.getValue());
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ RdsInputItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Input b;
        public final /* synthetic */ RdsInputItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(RdsInputItemPresenterImpl rdsInputItemPresenterImpl, ParameterElement.Input input, RdsInputItemView rdsInputItemView) {
            super(1);
            this.a = rdsInputItemPresenterImpl;
            this.b = input;
            this.c = rdsInputItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            RdsInputItemPresenterImpl.access$setupNewValue(this.a, this.b, str, this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RdsInputItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Input b;
        public final /* synthetic */ RdsInputItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(RdsInputItemPresenterImpl rdsInputItemPresenterImpl, ParameterElement.Input input, RdsInputItemView rdsInputItemView) {
            super(0);
            this.a = rdsInputItemPresenterImpl;
            this.b = input;
            this.c = rdsInputItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            RdsInputItemPresenterImpl.access$setupNewValue(this.a, this.b, "", this.c);
            return Unit.INSTANCE;
        }
    }

    public RdsInputItemPresenterImpl(@NotNull Consumer<ParameterElement.Input> consumer, @NotNull InputItemFormatterProvider inputItemFormatterProvider) {
        Intrinsics.checkNotNullParameter(consumer, "changeConsumer");
        Intrinsics.checkNotNullParameter(inputItemFormatterProvider, "formatterProvider");
        this.a = consumer;
        this.b = inputItemFormatterProvider;
    }

    public static final void access$setupNewValue(RdsInputItemPresenterImpl rdsInputItemPresenterImpl, ParameterElement.Input input, String str, RdsInputItemView rdsInputItemView) {
        Objects.requireNonNull(rdsInputItemPresenterImpl);
        input.setValue(str);
        rdsInputItemPresenterImpl.a.accept(input);
        rdsInputItemPresenterImpl.a(rdsInputItemView, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        if ((r4.length() > 0) != false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView r3, java.lang.String r4) {
        /*
            r2 = this;
            r3.setValue(r4)
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0013
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x000f
            r4 = 1
            goto L_0x0010
        L_0x000f:
            r4 = 0
        L_0x0010:
            if (r4 == 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            r3.setClearVisible(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemPresenterImpl.a(com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView, java.lang.String):void");
    }

    public void bindView(@NotNull RdsInputItemView rdsInputItemView, @NotNull ParameterElement.Input input, int i) {
        Intrinsics.checkNotNullParameter(rdsInputItemView, "view");
        Intrinsics.checkNotNullParameter(input, "item");
        InputFormatter provide = this.b.provide(input.getDisplayingOptions());
        rdsInputItemView.setTitle(input.getTitle());
        String error = input.getError();
        if (error != null) {
            rdsInputItemView.setError(error);
        }
        rdsInputItemView.initInput(provide, input.getAndroidSdkInputType(), input.getPrefix(), input.getPostfix());
        rdsInputItemView.setOnFocusChangeListener(new a(this, rdsInputItemView, input));
        rdsInputItemView.setOnValueChangeListener(new b(this, input, rdsInputItemView));
        rdsInputItemView.setOnClearClickListener(new c(this, input, rdsInputItemView));
        a(rdsInputItemView, input.getValue());
    }
}
