package com.avito.android.util;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\t\u0010\nJG\u0010\u0011\u001a\u00020\u000726\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/util/MenuWrapper;", "", "Lkotlin/Function1;", "Landroid/view/MenuItem;", "Lkotlin/ParameterName;", "name", "item", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnItemClicked", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "Landroid/view/Menu;", "menu", "Landroid/view/MenuInflater;", "inflater", "callback", "changeMenu", "(Lkotlin/jvm/functions/Function2;)V", "onCreateMenu", "(Landroid/view/Menu;Landroid/view/MenuInflater;)V", "onItemClicked", "(Landroid/view/MenuItem;)V", "Lio/reactivex/rxjava3/core/Observable;", "itemClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clear", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface MenuWrapper {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a<T> implements ObservableOnSubscribe<MenuItem> {
            public final /* synthetic */ MenuWrapper a;

            /* renamed from: com.avito.android.util.MenuWrapper$DefaultImpls$a$a  reason: collision with other inner class name */
            public static final class C0167a extends Lambda implements Function1<MenuItem, Unit> {
                public final /* synthetic */ ObservableEmitter a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0167a(ObservableEmitter observableEmitter) {
                    super(1);
                    this.a = observableEmitter;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(MenuItem menuItem) {
                    MenuItem menuItem2 = menuItem;
                    Intrinsics.checkNotNullParameter(menuItem2, "it");
                    this.a.onNext(menuItem2);
                    return Unit.INSTANCE;
                }
            }

            public a(MenuWrapper menuWrapper) {
                this.a = menuWrapper;
            }

            @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter<MenuItem> observableEmitter) {
                this.a.setOnItemClicked(new C0167a(observableEmitter));
            }
        }

        @NotNull
        public static Observable<MenuItem> itemClicks(@NotNull MenuWrapper menuWrapper) {
            Observable<MenuItem> create = Observable.create(new a(menuWrapper));
            Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…mitter.onNext(it) }\n    }");
            return create;
        }
    }

    void changeMenu(@NotNull Function2<? super Menu, ? super MenuInflater, Unit> function2);

    void clear();

    @NotNull
    Observable<MenuItem> itemClicks();

    void onCreateMenu(@NotNull Menu menu, @NotNull MenuInflater menuInflater);

    void onItemClicked(@NotNull MenuItem menuItem);

    void setOnItemClicked(@NotNull Function1<? super MenuItem, Unit> function1);
}
