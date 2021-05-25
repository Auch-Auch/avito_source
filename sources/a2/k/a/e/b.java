package a2.k.a.e;

import androidx.viewpager.widget.ViewPager;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.viewpager.ViewPagerPageScrollEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b extends Observable<ViewPagerPageScrollEvent> {
    public final ViewPager a;

    public static final class a extends MainThreadDisposable implements ViewPager.OnPageChangeListener {
        public final ViewPager b;
        public final Observer<? super ViewPagerPageScrollEvent> c;

        public a(@NotNull ViewPager viewPager, @NotNull Observer<? super ViewPagerPageScrollEvent> observer) {
            Intrinsics.checkParameterIsNotNull(viewPager, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = viewPager;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.removeOnPageChangeListener(this);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (!isDisposed()) {
                this.c.onNext(new ViewPagerPageScrollEvent(this.b, i, f, i2));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    public b(@NotNull ViewPager viewPager) {
        Intrinsics.checkParameterIsNotNull(viewPager, "view");
        this.a = viewPager;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super ViewPagerPageScrollEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.addOnPageChangeListener(aVar);
        }
    }
}
