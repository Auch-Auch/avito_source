package l6.k;

import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
public abstract class a extends BaseObservable {

    /* renamed from: l6.k.a$a  reason: collision with other inner class name */
    public class C0529a extends Observable.OnPropertyChangedCallback {
        public C0529a() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            a.this.notifyChange();
        }
    }

    public a() {
    }

    public a(Observable... observableArr) {
        if (!(observableArr == null || observableArr.length == 0)) {
            C0529a aVar = new C0529a();
            for (Observable observable : observableArr) {
                observable.addOnPropertyChangedCallback(aVar);
            }
        }
    }
}
