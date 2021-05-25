package com.avito.android.search.filter.adapter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.common.InputData;
import com.avito.android.common.InputFormatter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.search.filter.InputItemFormatterProvider;
import com.avito.android.util.preferences.GeoContract;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\r\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/search/filter/adapter/InputItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/InputItemPresenter;", "Lcom/avito/android/search/filter/adapter/InputItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/filter/adapter/InputItemView;Lcom/avito/android/category_parameters/ParameterElement$Input;I)V", "Lcom/avito/android/common/InputFormatter;", "formatter", AuthSource.SEND_ABUSE, "(Lcom/avito/android/search/filter/adapter/InputItemView;Lcom/avito/android/category_parameters/ParameterElement$Input;Lcom/avito/android/common/InputFormatter;)V", "Lcom/avito/android/search/filter/InputItemFormatterProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/filter/InputItemFormatterProvider;", "formatterProvider", "Lio/reactivex/rxjava3/functions/Consumer;", "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", GeoContract.PROVIDER, "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;Lcom/avito/android/search/filter/InputItemFormatterProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemPresenterImpl implements InputItemPresenter {
    public final Consumer<ParameterElement.Input> a;
    public final InputItemFormatterProvider b;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ InputItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Input b;
        public final /* synthetic */ InputFormatter c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputItemPresenterImpl inputItemPresenterImpl, ParameterElement.Input input, InputFormatter inputFormatter) {
            super(1);
            this.a = inputItemPresenterImpl;
            this.b = input;
            this.c = inputFormatter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            this.b.setValue(str);
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ InputItemView a;
        public final /* synthetic */ InputItemPresenterImpl b;
        public final /* synthetic */ ParameterElement.Input c;
        public final /* synthetic */ InputFormatter d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(InputItemView inputItemView, InputItemPresenterImpl inputItemPresenterImpl, ParameterElement.Input input, InputFormatter inputFormatter) {
            super(1);
            this.a = inputItemView;
            this.b = inputItemPresenterImpl;
            this.c = input;
            this.d = inputFormatter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (!bool.booleanValue()) {
                this.a.hideKeyboard();
                this.b.a(this.a, this.c, this.d);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public InputItemPresenterImpl(@NotNull FiltersChangeProvider filtersChangeProvider, @NotNull InputItemFormatterProvider inputItemFormatterProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, GeoContract.PROVIDER);
        Intrinsics.checkNotNullParameter(inputItemFormatterProvider, "formatterProvider");
        this.b = inputItemFormatterProvider;
        this.a = filtersChangeProvider.getInputItemConsumer();
    }

    public final void a(InputItemView inputItemView, ParameterElement.Input input, InputFormatter inputFormatter) {
        String value = input.getValue();
        if (value == null || inputFormatter == null) {
            inputItemView.setValue(value);
        } else {
            inputItemView.setValue(inputFormatter.format(new InputData(value, 0, 0)).getValue().toString());
        }
    }

    public void bindView(@NotNull InputItemView inputItemView, @NotNull ParameterElement.Input input, int i) {
        Intrinsics.checkNotNullParameter(inputItemView, "view");
        Intrinsics.checkNotNullParameter(input, "item");
        InputFormatter provide = this.b.provide(input.getFormat());
        inputItemView.setTitle(input.getTitle());
        inputItemView.setInputType(input.getAndroidSdkInputType());
        inputItemView.setMinLines(input.getLines());
        inputItemView.setMaxLines(input.getLines());
        inputItemView.setPrefix(input.getPrefix());
        inputItemView.setPostfix(input.getPostfix());
        inputItemView.setFormatter(provide);
        a(inputItemView, input, provide);
        inputItemView.setOnValueChangeListener(new a(this, input, provide));
        inputItemView.setOnFocusChangeListener(new b(inputItemView, this, input, provide));
    }
}
