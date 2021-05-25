package com.jakewharton.rxbinding3.viewpager;

import a2.b.a.a.a;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/jakewharton/rxbinding3/viewpager/ViewPagerPageScrollEvent;", "", "Landroidx/viewpager/widget/ViewPager;", "component1", "()Landroidx/viewpager/widget/ViewPager;", "", "component2", "()I", "", "component3", "()F", "component4", "viewPager", VKApiConst.POSITION, "positionOffset", "positionOffsetPixels", "copy", "(Landroidx/viewpager/widget/ViewPager;IFI)Lcom/jakewharton/rxbinding3/viewpager/ViewPagerPageScrollEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "F", "getPositionOffset", AuthSource.BOOKING_ORDER, "I", "getPosition", "d", "getPositionOffsetPixels", AuthSource.SEND_ABUSE, "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "<init>", "(Landroidx/viewpager/widget/ViewPager;IFI)V", "rxbinding-viewpager_release"}, k = 1, mv = {1, 4, 0})
public final class ViewPagerPageScrollEvent {
    @NotNull
    public final ViewPager a;
    public final int b;
    public final float c;
    public final int d;

    public ViewPagerPageScrollEvent(@NotNull ViewPager viewPager, int i, float f, int i2) {
        Intrinsics.checkParameterIsNotNull(viewPager, "viewPager");
        this.a = viewPager;
        this.b = i;
        this.c = f;
        this.d = i2;
    }

    public static /* synthetic */ ViewPagerPageScrollEvent copy$default(ViewPagerPageScrollEvent viewPagerPageScrollEvent, ViewPager viewPager, int i, float f, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            viewPager = viewPagerPageScrollEvent.a;
        }
        if ((i3 & 2) != 0) {
            i = viewPagerPageScrollEvent.b;
        }
        if ((i3 & 4) != 0) {
            f = viewPagerPageScrollEvent.c;
        }
        if ((i3 & 8) != 0) {
            i2 = viewPagerPageScrollEvent.d;
        }
        return viewPagerPageScrollEvent.copy(viewPager, i, f, i2);
    }

    @NotNull
    public final ViewPager component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final float component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    @NotNull
    public final ViewPagerPageScrollEvent copy(@NotNull ViewPager viewPager, int i, float f, int i2) {
        Intrinsics.checkParameterIsNotNull(viewPager, "viewPager");
        return new ViewPagerPageScrollEvent(viewPager, i, f, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ViewPagerPageScrollEvent) {
                ViewPagerPageScrollEvent viewPagerPageScrollEvent = (ViewPagerPageScrollEvent) obj;
                if (Intrinsics.areEqual(this.a, viewPagerPageScrollEvent.a)) {
                    if ((this.b == viewPagerPageScrollEvent.b) && Float.compare(this.c, viewPagerPageScrollEvent.c) == 0) {
                        if (this.d == viewPagerPageScrollEvent.d) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getPosition() {
        return this.b;
    }

    public final float getPositionOffset() {
        return this.c;
    }

    public final int getPositionOffsetPixels() {
        return this.d;
    }

    @NotNull
    public final ViewPager getViewPager() {
        return this.a;
    }

    public int hashCode() {
        ViewPager viewPager = this.a;
        return a.i1(this.c, (((viewPager != null ? viewPager.hashCode() : 0) * 31) + this.b) * 31, 31) + this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ViewPagerPageScrollEvent(viewPager=");
        L.append(this.a);
        L.append(", position=");
        L.append(this.b);
        L.append(", positionOffset=");
        L.append(this.c);
        L.append(", positionOffsetPixels=");
        return a.j(L, this.d, ")");
    }
}
