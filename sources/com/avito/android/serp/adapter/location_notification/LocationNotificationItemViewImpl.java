package com.avito.android.serp.adapter.location_notification;

import android.view.View;
import android.widget.TextView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemView;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0014R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001b¨\u0006."}, d2 = {"Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemViewImpl;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitleText", "(Ljava/lang/String;)V", "text", "setConfirmText", "setChangeText", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "titleText", "Lio/reactivex/rxjava3/core/Observable;", "", "x", "Lio/reactivex/rxjava3/core/Observable;", "getConfirmClicks", "()Lio/reactivex/rxjava3/core/Observable;", "confirmClicks", "z", "getVisibilityCallback", "visibilityCallback", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", "changeButton", "", "y", "Z", "once", "Lcom/jakewharton/rxrelay3/PublishRelay;", VKApiConst.VERSION, "Lcom/jakewharton/rxrelay3/PublishRelay;", "visibilityRelay", "w", "getChangeClicks", "changeClicks", "t", "confirmButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class LocationNotificationItemViewImpl extends BaseViewHolder implements LocationNotificationItemView {
    public final Button s;
    public final Button t;
    public final TextView u;
    public final PublishRelay<Unit> v;
    @NotNull
    public final Observable<Unit> w;
    @NotNull
    public final Observable<Integer> x;
    public boolean y = true;
    @NotNull
    public final Observable<Unit> z;

    public static final class a<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ LocationNotificationItemViewImpl a;

        public a(LocationNotificationItemViewImpl locationNotificationItemViewImpl) {
            this.a = locationNotificationItemViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(Unit unit) {
            return Integer.valueOf(this.a.getAdapterPosition());
        }
    }

    public static final class b<T> implements Predicate<Unit> {
        public final /* synthetic */ LocationNotificationItemViewImpl a;

        public b(LocationNotificationItemViewImpl locationNotificationItemViewImpl) {
            this.a = locationNotificationItemViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Unit unit) {
            if (!this.a.y) {
                return false;
            }
            this.a.y = false;
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationNotificationItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.change);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById;
        this.s = button;
        View findViewById2 = view.findViewById(R.id.confirm);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button2 = (Button) findViewById2;
        this.t = button2;
        View findViewById3 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.v = create;
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) { // from class: com.avito.android.serp.adapter.location_notification.LocationNotificationItemViewImpl.1
            public final /* synthetic */ LocationNotificationItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
                this.a.v.accept(Unit.INSTANCE);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
            }
        });
        this.w = RxView.clicks(button);
        Observable<R> map = RxView.clicks(button2).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "confirmButton.clicks().map { adapterPosition }");
        this.x = map;
        Observable<Unit> filter = create.filter(new b(this));
        Intrinsics.checkNotNullExpressionValue(filter, "visibilityRelay.filter {…    false\n        }\n    }");
        this.z = filter;
    }

    @Override // com.avito.android.serp.adapter.location_notification.LocationNotificationItemView
    @NotNull
    public Observable<Unit> getChangeClicks() {
        return this.w;
    }

    @Override // com.avito.android.serp.adapter.location_notification.LocationNotificationItemView
    @NotNull
    public Observable<Integer> getConfirmClicks() {
        return this.x;
    }

    @Override // com.avito.android.serp.adapter.location_notification.LocationNotificationItemView
    @NotNull
    public Observable<Unit> getVisibilityCallback() {
        return this.z;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        LocationNotificationItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.serp.adapter.location_notification.LocationNotificationItemView
    public void setChangeText(@Nullable String str) {
        ButtonsKt.bindText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.android.serp.adapter.location_notification.LocationNotificationItemView
    public void setConfirmText(@Nullable String str) {
        ButtonsKt.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.serp.adapter.location_notification.LocationNotificationItemView
    public void setTitleText(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }
}
