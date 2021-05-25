package com.jakewharton.rxbinding3.widget;

import android.database.DataSetObserver;
import com.jakewharton.rxbinding3.widget.AdapterDataChangeObservable;
import io.reactivex.Observer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/jakewharton/rxbinding3/widget/AdapterDataChangeObservable$ObserverDisposable$dataSetObserver$1", "Landroid/database/DataSetObserver;", "", "onChanged", "()V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class AdapterDataChangeObservable$ObserverDisposable$dataSetObserver$1 extends DataSetObserver {
    public final /* synthetic */ AdapterDataChangeObservable.ObserverDisposable a;
    public final /* synthetic */ Observer b;

    public AdapterDataChangeObservable$ObserverDisposable$dataSetObserver$1(AdapterDataChangeObservable.ObserverDisposable observerDisposable, Observer observer) {
        this.a = observerDisposable;
        this.b = observer;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        if (!this.a.isDisposed()) {
            this.b.onNext(this.a.c);
        }
    }
}
