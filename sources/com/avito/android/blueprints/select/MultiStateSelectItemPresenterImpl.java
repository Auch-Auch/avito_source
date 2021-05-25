package com.avito.android.blueprints.select;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.ItemWithState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R:\u0010\u0019\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00040\u0004 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenterImpl;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenter;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/select/MultiStateSelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Select;I)V", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getClickEventObservable", "()Lio/reactivex/Observable;", "clickEventObservable", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "clickEventStream", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateSelectItemPresenterImpl implements MultiStateSelectItemPresenter {
    public final PublishRelay<ParameterElement.Select> a;
    @NotNull
    public final Observable<ParameterElement.Select> b;
    public final AttributedTextFormatter c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MultiStateSelectItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Select b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MultiStateSelectItemPresenterImpl multiStateSelectItemPresenterImpl, ParameterElement.Select select) {
            super(0);
            this.a = multiStateSelectItemPresenterImpl;
            this.b = select;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public MultiStateSelectItemPresenterImpl(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.c = attributedTextFormatter;
        PublishRelay<ParameterElement.Select> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "clickEventStream");
        this.b = create;
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemPresenter
    @NotNull
    public Observable<ParameterElement.Select> getClickEventObservable() {
        return this.b;
    }

    public void bindView(@NotNull MultiStateSelectItemView multiStateSelectItemView, @NotNull ParameterElement.Select select, int i) {
        Intrinsics.checkNotNullParameter(multiStateSelectItemView, "view");
        Intrinsics.checkNotNullParameter(select, "item");
        multiStateSelectItemView.setTitle(select.getHideTitle() ? "" : select.getTitle());
        multiStateSelectItemView.setPlaceholder(select.getPlaceholder());
        multiStateSelectItemView.setValue(select.getValue());
        ItemWithState.State state = select.getState();
        if (state instanceof ItemWithState.State.Error) {
            multiStateSelectItemView.setErrorState(((ItemWithState.State.Error) state).getMessage());
        } else if (state instanceof ItemWithState.State.Warning) {
            multiStateSelectItemView.setWarningState(((ItemWithState.State.Warning) state).getMessage());
        } else if (state instanceof ItemWithState.State.Normal) {
            CharSequence message = ((ItemWithState.State.Normal) state).getMessage();
            if (message == null) {
                AttributedText motivation = select.getMotivation();
                message = motivation != null ? this.c.format(motivation) : null;
            }
            multiStateSelectItemView.setNormalState(message);
        }
        multiStateSelectItemView.setOnClickListener(new a(this, select));
        multiStateSelectItemView.setEnabled(select.isEnabled());
    }
}
