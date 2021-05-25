package androidx.databinding;

import androidx.annotation.Nullable;
import java.io.Serializable;
import l6.k.a;
public class ObservableField<T> extends a implements Serializable {
    public static final long serialVersionUID = 1;
    public T b;

    public ObservableField(T t) {
        this.b = t;
    }

    @Nullable
    public T get() {
        return this.b;
    }

    public void set(T t) {
        if (t != this.b) {
            this.b = t;
            notifyChange();
        }
    }

    public ObservableField() {
    }

    public ObservableField(Observable... observableArr) {
        super(observableArr);
    }
}
