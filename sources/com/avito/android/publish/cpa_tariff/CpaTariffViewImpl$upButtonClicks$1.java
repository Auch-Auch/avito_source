package com.avito.android.publish.cpa_tariff;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.Unit;
import ru.avito.component.toolbar.AppbarClickListener;
public final class CpaTariffViewImpl$upButtonClicks$1<T> implements ObservableOnSubscribe<Unit> {
    public final /* synthetic */ CpaTariffViewImpl a;

    public static final class a implements Cancellable {
        public final /* synthetic */ CpaTariffViewImpl$upButtonClicks$1 a;

        public a(CpaTariffViewImpl$upButtonClicks$1 cpaTariffViewImpl$upButtonClicks$1) {
            this.a = cpaTariffViewImpl$upButtonClicks$1;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.b.setClickListener(null);
        }
    }

    public CpaTariffViewImpl$upButtonClicks$1(CpaTariffViewImpl cpaTariffViewImpl) {
        this.a = cpaTariffViewImpl;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(final ObservableEmitter<Unit> observableEmitter) {
        observableEmitter.setCancellable(new a(this));
        this.a.b.setClickListener(new AppbarClickListener() { // from class: com.avito.android.publish.cpa_tariff.CpaTariffViewImpl$upButtonClicks$1.2
            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                observableEmitter.onNext(Unit.INSTANCE);
            }
        });
    }
}
