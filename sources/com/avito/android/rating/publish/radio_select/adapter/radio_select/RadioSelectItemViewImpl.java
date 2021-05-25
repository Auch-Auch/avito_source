package com.avito.android.rating.publish.radio_select.adapter.radio_select;

import android.view.View;
import com.avito.android.component.radio_button.RadioButton;
import com.avito.android.component.radio_button.RadioButtonImpl;
import com.avito.android.rating.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/avito/android/rating/publish/radio_select/adapter/radio_select/RadioSelectItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/rating/publish/radio_select/adapter/radio_select/RadioSelectItemView;", "Lio/reactivex/rxjava3/core/Observable;", "", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "", "title", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", "isChecked", "setChecked", "(Z)V", "t", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/avito/android/component/radio_button/RadioButton;", "s", "Lcom/avito/android/component/radio_button/RadioButton;", "radioButtonView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RadioSelectItemViewImpl extends BaseViewHolder implements RadioSelectItemView {
    public final RadioButton s;
    public Function0<Unit> t;

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ RadioSelectItemViewImpl a;

        /* renamed from: com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemViewImpl$a$a  reason: collision with other inner class name */
        public static final class C0153a implements Cancellable {
            public final /* synthetic */ a a;

            public C0153a(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.s.setOnClickListener(null);
            }
        }

        public static final class b extends Lambda implements Function1<RadioButton, Unit> {
            public final /* synthetic */ ObservableEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(ObservableEmitter observableEmitter) {
                super(1);
                this.a = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(RadioButton radioButton) {
                Intrinsics.checkNotNullParameter(radioButton, "it");
                ObservableEmitter observableEmitter = this.a;
                Unit unit = Unit.INSTANCE;
                observableEmitter.onNext(unit);
                return unit;
            }
        }

        public a(RadioSelectItemViewImpl radioSelectItemViewImpl) {
            this.a = radioSelectItemViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            observableEmitter.setCancellable(new C0153a(this));
            this.a.s.setOnClickListener(new b(observableEmitter));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioSelectItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.radio_button_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = new RadioButtonImpl(findViewById);
    }

    @Override // com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemView
    @NotNull
    public Observable<Unit> clicks() {
        Observable<Unit> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ext(Unit)\n        }\n    }");
        return create;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.t;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemView
    public void setChecked(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemView
    public void setDescription(@Nullable String str) {
        this.s.setSubtitle(str);
    }

    @Override // com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.t = function0;
    }
}
