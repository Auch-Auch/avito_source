package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
public class BaseObservable implements Observable {
    public transient PropertyChangeRegistry a;

    @Override // androidx.databinding.Observable
    public void addOnPropertyChangedCallback(@NonNull Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            if (this.a == null) {
                this.a = new PropertyChangeRegistry();
            }
        }
        this.a.add(onPropertyChangedCallback);
    }

    public void notifyChange() {
        synchronized (this) {
            PropertyChangeRegistry propertyChangeRegistry = this.a;
            if (propertyChangeRegistry != null) {
                propertyChangeRegistry.notifyCallbacks(this, 0, null);
            }
        }
    }

    public void notifyPropertyChanged(int i) {
        synchronized (this) {
            PropertyChangeRegistry propertyChangeRegistry = this.a;
            if (propertyChangeRegistry != null) {
                propertyChangeRegistry.notifyCallbacks(this, i, null);
            }
        }
    }

    @Override // androidx.databinding.Observable
    public void removeOnPropertyChangedCallback(@NonNull Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            PropertyChangeRegistry propertyChangeRegistry = this.a;
            if (propertyChangeRegistry != null) {
                propertyChangeRegistry.remove(onPropertyChangedCallback);
            }
        }
    }
}
