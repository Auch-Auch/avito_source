package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
public class Transformations {

    public static class a implements Observer<X> {
        public final /* synthetic */ MediatorLiveData a;
        public final /* synthetic */ Function b;

        public a(MediatorLiveData mediatorLiveData, Function function) {
            this.a = mediatorLiveData;
            this.b = function;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable X x) {
            this.a.setValue(this.b.apply(x));
        }
    }

    public static class b implements Observer<X> {
        public LiveData<Y> a;
        public final /* synthetic */ Function b;
        public final /* synthetic */ MediatorLiveData c;

        public class a implements Observer<Y> {
            public a() {
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable Y y) {
                b.this.c.setValue(y);
            }
        }

        public b(Function function, MediatorLiveData mediatorLiveData) {
            this.b = function;
            this.c = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable X x) {
            LiveData<Y> liveData = (LiveData) this.b.apply(x);
            LiveData<Y> liveData2 = this.a;
            if (liveData2 != liveData) {
                if (liveData2 != null) {
                    this.c.removeSource(liveData2);
                }
                this.a = liveData;
                if (liveData != null) {
                    this.c.addSource(liveData, new a());
                }
            }
        }
    }

    public static class c implements Observer<X> {
        public boolean a = true;
        public final /* synthetic */ MediatorLiveData b;

        public c(MediatorLiveData mediatorLiveData) {
            this.b = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(X x) {
            Object value = this.b.getValue();
            if (this.a || ((value == null && x != null) || (value != null && !value.equals(x)))) {
                this.a = false;
                this.b.setValue(x);
            }
        }
    }

    @NonNull
    @MainThread
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new c(mediatorLiveData));
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull Function<X, Y> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new a(mediatorLiveData, function));
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull Function<X, LiveData<Y>> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new b(function, mediatorLiveData));
        return mediatorLiveData;
    }
}
