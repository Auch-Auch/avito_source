package com.avito.android.str_calendar.calendar.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001BA\u0012\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R.\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00198\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0011¨\u0006#"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/CalendarRecyclerViewDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/view/View;", "view", "", "viewSpanPosition", "(Landroid/view/View;)I", "Landroid/graphics/Rect;", "outRect", "", "alignOutRect", "(Landroid/graphics/Rect;I)V", "backgroundViewId", "textViewContainer", "alignView", "(Landroid/view/View;IILandroid/view/View;)V", AuthSource.SEND_ABUSE, "I", "itemScreenMargin", "f", "verticalMargin", "c", "gridSize", "e", "itemsMargin", "Lkotlin/Function2;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function2;", "getSpan", "()Lkotlin/jvm/functions/Function2;", "span", "d", "screenMargin", "<init>", "(Lkotlin/jvm/functions/Function2;IIII)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public abstract class CalendarRecyclerViewDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    @NotNull
    public final Function2<Integer, Integer, Integer> b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            Position.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[3] = 3;
            Position.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            iArr2[3] = 3;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    public CalendarRecyclerViewDecoration(@NotNull Function2<? super Integer, ? super Integer, Integer> function2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(function2, "span");
        this.b = function2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.a = i2 - i3;
    }

    public static void a(CalendarRecyclerViewDecoration calendarRecyclerViewDecoration, ConstraintLayout constraintLayout, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = R.id.text_view_container;
        }
        if ((i3 & 8) != 0) {
            z = false;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(i, 1, z ? i2 : 0, 1);
        if (!z2) {
            i2 = 0;
        }
        constraintSet.connect(i, 2, i2, 2);
        constraintSet.applyTo(constraintLayout);
    }

    public static void b(CalendarRecyclerViewDecoration calendarRecyclerViewDecoration, Rect rect, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        rect.left = i;
        rect.right = i2;
        int i4 = calendarRecyclerViewDecoration.f;
        rect.top = i4;
        rect.bottom = i4;
    }

    public static void c(CalendarRecyclerViewDecoration calendarRecyclerViewDecoration, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = calendarRecyclerViewDecoration.e;
        }
        if ((i3 & 4) != 0) {
            i2 = calendarRecyclerViewDecoration.e;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = i2;
        view.setLayoutParams(layoutParams2);
    }

    public final void alignOutRect(@NotNull Rect rect, int i) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        if (i == 0) {
            b(this, rect, -this.a, 0, 4, null);
        } else if (i == this.c - 1) {
            b(this, rect, 0, -this.a, 2, null);
        } else {
            b(this, rect, 0, 0, 6, null);
        }
    }

    public final void alignView(@NotNull View view, int i, int i2, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(view2, "textViewContainer");
        View findViewById = view.findViewById(i);
        Position position = null;
        Object tag = findViewById != null ? findViewById.getTag() : null;
        if (tag instanceof Position) {
            position = tag;
        }
        Position position2 = position;
        if (position2 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int ordinal = position2.ordinal();
            if (ordinal == 0) {
                a(this, constraintLayout, i, 0, true, false, 20, null);
            } else if (ordinal == 1) {
                a(this, constraintLayout, i, 0, false, true, 12, null);
            } else if (ordinal != 3) {
                a(this, constraintLayout, i, 0, true, true, 4, null);
            } else {
                a(this, constraintLayout, i, 0, false, false, 28, null);
            }
            int ordinal2 = position2.ordinal();
            if (ordinal2 != 0) {
                if (ordinal2 != 1) {
                    if (ordinal2 != 3) {
                        if (i2 == 0) {
                            c(this, view2, this.d, 0, 4, null);
                        } else if (i2 == this.c - 1) {
                            c(this, view2, 0, this.d, 2, null);
                        } else {
                            c(this, view2, 0, 0, 6, null);
                        }
                    } else if (i2 == 0) {
                        c(this, view2, this.d, 0, 4, null);
                    } else if (i2 == this.c - 1) {
                        c(this, view2, 0, this.d, 2, null);
                    } else {
                        c(this, view2, 0, 0, 6, null);
                    }
                } else if (i2 == 0) {
                    c(this, view2, this.d, 0, 4, null);
                } else if (i2 == this.c - 1) {
                    c(this, view2, 0, this.d, 2, null);
                } else {
                    c(this, view2, 0, 0, 6, null);
                }
            } else if (i2 == 0) {
                c(this, view2, this.d, 0, 4, null);
            } else if (i2 == this.c - 1) {
                c(this, view2, 0, this.d, 2, null);
            } else {
                c(this, view2, 0, 0, 6, null);
            }
        }
    }

    @NotNull
    public final Function2<Integer, Integer, Integer> getSpan() {
        return this.b;
    }

    public final int viewSpanPosition(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Function2<Integer, Integer, Integer> function2 = this.b;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        return function2.invoke(Integer.valueOf(((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition()), Integer.valueOf(this.c)).intValue();
    }
}
