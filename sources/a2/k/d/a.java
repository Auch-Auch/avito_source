package a2.k.d;

import com.jakewharton.rxrelay3.AppendOnlyLinkedArrayList;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.Observer;
public final class a<T> extends Relay<T> {
    public final Relay<T> a;
    public boolean b;
    public AppendOnlyLinkedArrayList<T> c;

    public a(Relay<T> relay) {
        this.a = relay;
    }

    @Override // com.jakewharton.rxrelay3.Relay, io.reactivex.rxjava3.functions.Consumer
    public void accept(T t) {
        AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList;
        synchronized (this) {
            if (this.b) {
                AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList2 = this.c;
                if (appendOnlyLinkedArrayList2 == null) {
                    appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList<>(4);
                    this.c = appendOnlyLinkedArrayList2;
                }
                appendOnlyLinkedArrayList2.a(t);
                return;
            }
            this.b = true;
        }
        this.a.accept(t);
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.c;
                if (appendOnlyLinkedArrayList == null) {
                    this.b = false;
                    return;
                }
                this.c = null;
            }
            Relay<T> relay = this.a;
            for (Object[] objArr = appendOnlyLinkedArrayList.a; objArr != null; objArr = objArr[4]) {
                for (int i = 0; i < 4; i++) {
                    Object[] objArr2 = objArr[i];
                    if (objArr2 == null) {
                        break;
                    }
                    relay.accept(objArr2);
                }
            }
        }
    }

    @Override // com.jakewharton.rxrelay3.Relay
    public boolean hasObservers() {
        return this.a.hasObservers();
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(observer);
    }
}
