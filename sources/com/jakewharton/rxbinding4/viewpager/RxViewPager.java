package com.jakewharton.rxbinding4.viewpager;

import a2.k.b.e.a;
import a2.k.b.e.b;
import a2.k.b.e.c;
import androidx.annotation.CheckResult;
import androidx.viewpager.widget.ViewPager;
import com.jakewharton.rxbinding4.InitialValueObservable;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxViewPager {
    @CheckResult
    @NotNull
    public static final Observable<ViewPagerPageScrollEvent> pageScrollEvents(@NotNull ViewPager viewPager) {
        Intrinsics.checkParameterIsNotNull(viewPager, "$this$pageScrollEvents");
        return new b(viewPager);
    }

    @CheckResult
    @NotNull
    public static final Observable<Integer> pageScrollStateChanges(@NotNull ViewPager viewPager) {
        Intrinsics.checkParameterIsNotNull(viewPager, "$this$pageScrollStateChanges");
        return new a(viewPager);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> pageSelections(@NotNull ViewPager viewPager) {
        Intrinsics.checkParameterIsNotNull(viewPager, "$this$pageSelections");
        return new c(viewPager);
    }
}
