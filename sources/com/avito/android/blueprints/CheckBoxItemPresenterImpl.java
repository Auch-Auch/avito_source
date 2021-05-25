package com.avito.android.blueprints;

import com.avito.android.items.CheckBoxItem;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015R:\u0010\u001b\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00040\u0004 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/blueprints/CheckBoxItemPresenterImpl;", "Lcom/avito/android/blueprints/CheckBoxItemPresenter;", "Lcom/avito/android/blueprints/CheckBoxItemView;", "view", "Lcom/avito/android/items/CheckBoxItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/CheckBoxItemView;Lcom/avito/android/items/CheckBoxItem;I)V", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getValueChangesObservable", "()Lio/reactivex/Observable;", "valueChangesObservable", "Lio/reactivex/functions/Consumer;", "c", "Lio/reactivex/functions/Consumer;", "getValueConsumer$annotations", "()V", "valueConsumer", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "valueChangesStream", "<init>", "(Lio/reactivex/functions/Consumer;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class CheckBoxItemPresenterImpl implements CheckBoxItemPresenter {
    public final PublishRelay<CheckBoxItem> a;
    @NotNull
    public final Observable<CheckBoxItem> b;
    public final Consumer<CheckBoxItem> c;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CheckBoxItemPresenterImpl a;
        public final /* synthetic */ CheckBoxItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CheckBoxItemPresenterImpl checkBoxItemPresenterImpl, CheckBoxItem checkBoxItem) {
            super(1);
            this.a = checkBoxItemPresenterImpl;
            this.b = checkBoxItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.b.setChecked(bool.booleanValue());
            this.a.a.accept(this.b);
            Consumer consumer = this.a.c;
            if (consumer != null) {
                consumer.accept(this.b);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            bool.booleanValue();
            return Unit.INSTANCE;
        }
    }

    public CheckBoxItemPresenterImpl() {
        this(null, 1, null);
    }

    public CheckBoxItemPresenterImpl(@Nullable Consumer<CheckBoxItem> consumer) {
        this.c = consumer;
        PublishRelay<CheckBoxItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "valueChangesStream");
        this.b = create;
    }

    @Override // com.avito.android.blueprints.CheckBoxItemPresenter
    @NotNull
    public Observable<CheckBoxItem> getValueChangesObservable() {
        return this.b;
    }

    public void bindView(@NotNull CheckBoxItemView checkBoxItemView, @NotNull CheckBoxItem checkBoxItem, int i) {
        Intrinsics.checkNotNullParameter(checkBoxItemView, "view");
        Intrinsics.checkNotNullParameter(checkBoxItem, "item");
        checkBoxItemView.setCheckListener(b.a);
        checkBoxItemView.setText(checkBoxItem.getText());
        checkBoxItemView.setChecked(checkBoxItem.isChecked());
        checkBoxItemView.setCheckListener(new a(this, checkBoxItem));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckBoxItemPresenterImpl(Consumer consumer, int i, j jVar) {
        this((i & 1) != 0 ? null : consumer);
    }
}
