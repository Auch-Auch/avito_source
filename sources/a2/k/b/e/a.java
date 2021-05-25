package a2.k.b.e;

import androidx.viewpager.widget.ViewPager;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends Observable<Integer> {
    public final ViewPager a;

    /* renamed from: a2.k.b.e.a$a  reason: collision with other inner class name */
    public static final class C0098a extends MainThreadDisposable implements ViewPager.OnPageChangeListener {
        public final ViewPager b;
        public final Observer<? super Integer> c;

        public C0098a(@NotNull ViewPager viewPager, @NotNull Observer<? super Integer> observer) {
            Intrinsics.checkParameterIsNotNull(viewPager, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = viewPager;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.removeOnPageChangeListener(this);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (!isDisposed()) {
                this.c.onNext(Integer.valueOf(i));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    public a(@NotNull ViewPager viewPager) {
        Intrinsics.checkParameterIsNotNull(viewPager, "view");
        this.a = viewPager;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            C0098a aVar = new C0098a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.addOnPageChangeListener(aVar);
        }
    }
}
