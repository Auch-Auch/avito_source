package a2.k.b.e;

import androidx.viewpager.widget.ViewPager;
import com.jakewharton.rxbinding4.InitialValueObservable;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class c extends InitialValueObservable<Integer> {
    public final ViewPager a;

    public static final class a extends MainThreadDisposable implements ViewPager.OnPageChangeListener {
        public final ViewPager b;
        public final Observer<? super Integer> c;

        public a(@NotNull ViewPager viewPager, @NotNull Observer<? super Integer> observer) {
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
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (!isDisposed()) {
                this.c.onNext(Integer.valueOf(i));
            }
        }
    }

    public c(@NotNull ViewPager viewPager) {
        Intrinsics.checkParameterIsNotNull(viewPager, "view");
        this.a = viewPager;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public Integer getInitialValue() {
        return Integer.valueOf(this.a.getCurrentItem());
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        a aVar = new a(this.a, observer);
        observer.onSubscribe(aVar);
        this.a.addOnPageChangeListener(aVar);
    }
}
