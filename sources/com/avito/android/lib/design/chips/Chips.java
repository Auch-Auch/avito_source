package com.avito.android.lib.design.chips;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewGroupsKt;
import com.avito.android.util.Views;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00012\u00020\u0001:\t\u0001\u0001\u0001\u0001\nB\u0015\b\u0016\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001B!\b\u0016\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0006\b\u0001\u0010\u0001B*\b\u0017\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\u0007\u0010\u0001\u001a\u00020\u0006¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001d¢\u0006\u0004\b&\u0010 J\u0015\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u001d¢\u0006\u0004\b(\u0010 J\u0017\u0010)\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b)\u0010 J\u001b\u0010-\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020+¢\u0006\u0004\b0\u00101J\u001b\u00100\u001a\u00020\t2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020+02¢\u0006\u0004\b0\u00103J\u0013\u0010/\u001a\b\u0012\u0004\u0012\u00020+0*¢\u0006\u0004\b/\u00104J\r\u00105\u001a\u00020\t¢\u0006\u0004\b5\u0010\rJ\u0015\u00107\u001a\u00020\t2\u0006\u00106\u001a\u00020+¢\u0006\u0004\b7\u00101J\u0017\u0010:\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u000108¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u0006¢\u0006\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010L\u001a\u00020F2\u0006\u0010G\u001a\u00020F8F@FX\u000e¢\u0006\f\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010QR\u0016\u0010S\u001a\u00020B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010DR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR$\u0010Z\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00068\u0002@BX\u000e¢\u0006\f\n\u0004\bX\u0010@\"\u0004\bY\u0010>R\u0016\u0010\\\u001a\u00020B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010DR\u0016\u0010_\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010^R\u0016\u0010c\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010^R\u0016\u0010e\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010@R*\u0010l\u001a\u00020f2\u0006\u0010G\u001a\u00020f8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010p\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u000f8F@FX\u000e¢\u0006\f\u001a\u0004\bm\u0010n\"\u0004\bo\u0010\u001cR\u0016\u0010r\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010@R\u0018\u0010u\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u0010tR$\u0010|\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0016\u0010~\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010^R\u0017\u0010\u0001\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010@R\u0018\u0010\u0001\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010@R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00068\u0002@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010@\"\u0005\b\u0001\u0010>¨\u0006\u0001"}, d2 = {"Lcom/avito/android/lib/design/chips/Chips;", "Landroid/widget/LinearLayout;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", AuthSource.BOOKING_ORDER, "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/widget/TextView;", "", "startMargin", "endMargin", "", "d", "(Landroid/widget/TextView;II)V", "c", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "", AuthSource.SEND_ABUSE, "(Landroidx/recyclerview/widget/RecyclerView;)Z", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "setChildrenHorizontalMargin", "(II)V", "enabled", "setEnabled", "(Z)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "(Ljava/lang/CharSequence;)V", "hint", "setHint", "error", "setError", "setErrorOnTop", "", "Lcom/avito/android/lib/design/chips/Chipable;", "newData", "setData", "(Ljava/util/List;)V", "selected", "select", "(Lcom/avito/android/lib/design/chips/Chipable;)V", "", "(Ljava/util/Collection;)V", "()Ljava/util/List;", "clearSelected", "item", "scrollTo", "Lcom/avito/android/lib/design/chips/Chips$OnScrollPositionChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnScrollPositionChangeListener", "(Lcom/avito/android/lib/design/chips/Chips$OnScrollPositionChangeListener;)V", "maxSelected", "setMaxSelected", "(I)V", "s", "I", "titleSmallMargin", "Landroid/content/res/ColorStateList;", "f", "Landroid/content/res/ColorStateList;", "normalSubtitleTextColor", "Lcom/avito/android/lib/design/chips/SelectStrategy;", "value", "getSelectStrategy", "()Lcom/avito/android/lib/design/chips/SelectStrategy;", "setSelectStrategy", "(Lcom/avito/android/lib/design/chips/SelectStrategy;)V", "selectStrategy", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/recyclerview/widget/RecyclerView;", "chipsRecyclerView", "Lcom/avito/android/lib/design/chips/ChipsAdapter;", "Lcom/avito/android/lib/design/chips/ChipsAdapter;", "chipsAdapter", "normalHintTextColor", "Lcom/avito/android/lib/design/chips/ChipsSelectManager;", "n", "Lcom/avito/android/lib/design/chips/ChipsSelectManager;", "chipsSelectManager", "h", "setSelectedAppearance", "selectedAppearance", "e", "errorHintTextColor", "j", "Landroid/widget/TextView;", "subtitleTextView", "i", "titleTextView", "l", "hintTextView", VKApiConst.Q, "chipVerticalMargin", "Lcom/avito/android/lib/design/chips/Chips$DisplayType;", "Lcom/avito/android/lib/design/chips/Chips$DisplayType;", "getDisplayType", "()Lcom/avito/android/lib/design/chips/Chips$DisplayType;", "setDisplayType", "(Lcom/avito/android/lib/design/chips/Chips$DisplayType;)V", "displayType", "getKeepSelected", "()Z", "setKeepSelected", "keepSelected", "r", "minChildWidth", "o", "Lcom/avito/android/lib/design/chips/Chips$OnScrollPositionChangeListener;", "scrollPositionChangeListener", "Lcom/avito/android/lib/design/chips/Chips$ChipSelectedListener;", "Lcom/avito/android/lib/design/chips/Chips$ChipSelectedListener;", "getChipsSelectedListener", "()Lcom/avito/android/lib/design/chips/Chips$ChipSelectedListener;", "setChipsSelectedListener", "(Lcom/avito/android/lib/design/chips/Chips$ChipSelectedListener;)V", "chipsSelectedListener", "k", "topErrorTextView", "t", "contentTopMargin", "p", "chipHorizontalMargin", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "u", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalDecoration", g.a, "setUnselectedAppearance", "unselectedAppearance", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "ChipSelectedListener", "DisplayType", "OnScrollPositionChangeListener", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Chips extends LinearLayout {
    public static final int CHIPS_MAX_SELECTED_NOT_SPECIFIED = -1;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    public ChipSelectedListener a;
    @NotNull
    public DisplayType b;
    public ChipsAdapter c;
    public ColorStateList d;
    public ColorStateList e;
    public ColorStateList f;
    public int g;
    public int h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final RecyclerView m;
    public final ChipsSelectManager n;
    public OnScrollPositionChangeListener o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public RecyclerView.ItemDecoration u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/chips/Chips$ChipSelectedListener;", "", "Lcom/avito/android/lib/design/chips/Chipable;", "item", "", "onChipSelected", "(Lcom/avito/android/lib/design/chips/Chipable;)V", "onChipUnSelected", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface ChipSelectedListener {
        void onChipSelected(@NotNull Chipable chipable);

        void onChipUnSelected(@NotNull Chipable chipable);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/lib/design/chips/Chips$Companion;", "", "", "CHIPS_MAX_SELECTED_NOT_SPECIFIED", "I", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/chips/Chips$DisplayType;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE_LINE_FIXED", "SINGLE_LINE_STRETCH", "SINGLE_LINE_SCROLLABLE", "MULTIPLE_LINES", "components_release"}, k = 1, mv = {1, 4, 2})
    public enum DisplayType {
        SINGLE_LINE_FIXED,
        SINGLE_LINE_STRETCH,
        SINGLE_LINE_SCROLLABLE,
        MULTIPLE_LINES
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/avito/android/lib/design/chips/Chips$OnScrollPositionChangeListener;", "Lkotlin/Function1;", "", "", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface OnScrollPositionChangeListener extends Function1<Integer, Unit> {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            DisplayType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            DisplayType.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[2] = 2;
            iArr2[3] = 3;
            iArr2[1] = 4;
        }
    }

    public final class d extends RecyclerView.OnScrollListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                    if (findFirstVisibleItemPosition == -1) {
                        findFirstVisibleItemPosition = 0;
                    }
                    OnScrollPositionChangeListener onScrollPositionChangeListener = Chips.this.o;
                    if (onScrollPositionChangeListener != null) {
                        Unit unit = (Unit) onScrollPositionChangeListener.invoke(Integer.valueOf(findFirstVisibleItemPosition));
                    }
                }
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Chips(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void access$correctView(Chips chips) {
        RecyclerView recyclerView = chips.m;
        if (chips.a(recyclerView)) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if ((layoutManager instanceof FlexboxLayoutManager) && ((FlexboxLayoutManager) layoutManager).getFlexLines().size() == 1) {
                Context context = recyclerView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                SafeFlexboxLayoutManager safeFlexboxLayoutManager = new SafeFlexboxLayoutManager(context);
                safeFlexboxLayoutManager.setFlexWrap(1);
                safeFlexboxLayoutManager.setFlexDirection(0);
                recyclerView.setLayoutManager(safeFlexboxLayoutManager);
                recyclerView.post(new a2.a.a.k1.a.b.a(recyclerView));
                return;
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public static final void access$onMaxSelectedStateChanged(Chips chips) {
        RecyclerView.Adapter adapter = chips.m.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public static final void access$onSelected(Chips chips, int i2) {
        RecyclerView.Adapter adapter = chips.m.getAdapter();
        if (!(adapter instanceof ChipsAdapter)) {
            adapter = null;
        }
        ChipsAdapter chipsAdapter = (ChipsAdapter) adapter;
        if (chipsAdapter != null) {
            chipsAdapter.notifyItemChanged(i2);
            ChipSelectedListener chipSelectedListener = chips.a;
            if (chipSelectedListener != null) {
                chipSelectedListener.onChipSelected(chipsAdapter.itemAtPos(i2));
            }
        }
    }

    public static final void access$onUnSelected(Chips chips, int i2) {
        RecyclerView.Adapter adapter = chips.m.getAdapter();
        if (!(adapter instanceof ChipsAdapter)) {
            adapter = null;
        }
        ChipsAdapter chipsAdapter = (ChipsAdapter) adapter;
        if (chipsAdapter != null) {
            chipsAdapter.notifyItemChanged(i2);
            ChipSelectedListener chipSelectedListener = chips.a;
            if (chipSelectedListener != null) {
                chipSelectedListener.onChipUnSelected(chipsAdapter.itemAtPos(i2));
            }
        }
    }

    private final void setSelectedAppearance(int i2) {
        this.h = i2;
        ChipsAdapter chipsAdapter = this.c;
        if (chipsAdapter != null) {
            chipsAdapter.setUnselectedButtonAppearance(i2);
        }
        ChipsAdapter chipsAdapter2 = this.c;
        if (chipsAdapter2 != null) {
            chipsAdapter2.notifyDataSetChanged();
        }
    }

    private final void setUnselectedAppearance(int i2) {
        this.g = i2;
        ChipsAdapter chipsAdapter = this.c;
        if (chipsAdapter != null) {
            chipsAdapter.setSelectedButtonAppearance(i2);
        }
        ChipsAdapter chipsAdapter2 = this.c;
        if (chipsAdapter2 != null) {
            chipsAdapter2.notifyDataSetChanged();
        }
    }

    public final boolean a(RecyclerView recyclerView) {
        Iterator<View> children = ViewGroupsKt.getChildren(recyclerView);
        while (children.hasNext()) {
            View next = children.next();
            Objects.requireNonNull(next, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
            if (((Button) next).isEllipsized()) {
                return false;
            }
        }
        return true;
    }

    public final RecyclerView.LayoutManager b() {
        int ordinal = this.b.ordinal();
        boolean z = false;
        if (ordinal != 0) {
            if (ordinal == 1) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                SafeFlexboxLayoutManager safeFlexboxLayoutManager = new SafeFlexboxLayoutManager(context);
                safeFlexboxLayoutManager.setFlexWrap(1);
                safeFlexboxLayoutManager.setFlexDirection(0);
                return safeFlexboxLayoutManager;
            } else if (ordinal != 2) {
                if (ordinal == 3) {
                    return new MultilineLayoutManager(this.p, this.q, null, 4, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int i2 = this.p * 2;
        int i3 = this.r;
        if (this.b == DisplayType.SINGLE_LINE_FIXED) {
            z = true;
        }
        return new FixedChipsLinearLayoutManager(context2, i2, i3, z);
    }

    public final void c() {
        int i2 = 0;
        if (Views.isVisible(this.i) || Views.isVisible(this.j) || Views.isVisible(this.k)) {
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).topMargin = this.t;
            if (Views.isVisible(this.j)) {
                ViewGroup.LayoutParams layoutParams2 = this.j.getLayoutParams();
                Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                ((LinearLayout.LayoutParams) layoutParams2).topMargin = Views.isVisible(this.i) ? this.s : 0;
            }
            if (Views.isVisible(this.k)) {
                ViewGroup.LayoutParams layoutParams3 = this.k.getLayoutParams();
                Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                if (Views.isVisible(this.j) || Views.isVisible(this.i)) {
                    i2 = this.s;
                }
                layoutParams4.topMargin = i2;
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams5 = this.m.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams5).topMargin = 0;
    }

    public final void clearSelected() {
        Iterator<T> it = this.n.clearSelected().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            RecyclerView.Adapter adapter = this.m.getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(intValue);
            }
        }
    }

    public final void d(TextView textView, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i3;
    }

    @Nullable
    public final ChipSelectedListener getChipsSelectedListener() {
        return this.a;
    }

    @NotNull
    public final DisplayType getDisplayType() {
        return this.b;
    }

    public final boolean getKeepSelected() {
        return this.n.getKeepLastSelected();
    }

    @NotNull
    public final SelectStrategy getSelectStrategy() {
        return this.n.getSelectStrategy();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void scrollTo(@NotNull Chipable chipable) {
        Intrinsics.checkNotNullParameter(chipable, "item");
        RecyclerView.Adapter adapter = this.m.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.avito.android.lib.design.chips.ChipsAdapter");
        int i2 = 0;
        Iterator<Chipable> it = ((ChipsAdapter) adapter).getData().iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (chipable.equalsAsChipable(it.next())) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            this.m.scrollToPosition(i2);
        }
    }

    public final void select(@NotNull Chipable chipable) {
        List<Chipable> data;
        Intrinsics.checkNotNullParameter(chipable, "selected");
        RecyclerView.Adapter adapter = this.m.getAdapter();
        if (!(adapter instanceof ChipsAdapter)) {
            adapter = null;
        }
        ChipsAdapter chipsAdapter = (ChipsAdapter) adapter;
        if (chipsAdapter != null && (data = chipsAdapter.getData()) != null) {
            int i2 = 0;
            Iterator<Chipable> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (chipable.equalsAsChipable(it.next())) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                this.n.select(i2);
                chipsAdapter.notifyItemChanged(i2);
            }
        }
    }

    @NotNull
    public final List<Chipable> selected() {
        RecyclerView.Adapter adapter = this.m.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.avito.android.lib.design.chips.ChipsAdapter");
        return ((ChipsAdapter) adapter).selected();
    }

    public final void setChildrenHorizontalMargin(int i2, int i3) {
        d(this.i, i2, i3);
        d(this.j, i2, i3);
        d(this.k, i2, i3);
        d(this.l, i2, i3);
        this.m.setPadding(i2, 0, i3, 0);
    }

    public final void setChipsSelectedListener(@Nullable ChipSelectedListener chipSelectedListener) {
        this.a = chipSelectedListener;
    }

    public final void setData(@NotNull List<? extends Chipable> list) {
        Intrinsics.checkNotNullParameter(list, "newData");
        RecyclerView.Adapter adapter = this.m.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.avito.android.lib.design.chips.ChipsAdapter");
        ChipsAdapter chipsAdapter = (ChipsAdapter) adapter;
        List<Chipable> data = chipsAdapter.getData();
        data.clear();
        data.addAll(list);
        chipsAdapter.notifyDataSetChanged();
        addOnLayoutChangeListener(new Chips$scheduleFitCheck$$inlined$runOnNextLayoutChange$1(this, this));
    }

    public final void setDisplayType(@NotNull DisplayType displayType) {
        Intrinsics.checkNotNullParameter(displayType, "value");
        this.b = displayType;
        RecyclerView recyclerView = this.m;
        recyclerView.setLayoutManager(b());
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        RecyclerView.ItemDecoration itemDecoration = this.u;
        if (itemDecoration != null) {
            recyclerView.removeItemDecoration(itemDecoration);
        }
        if (this.b != DisplayType.MULTIPLE_LINES) {
            HorizontalChipsDecoration horizontalChipsDecoration = new HorizontalChipsDecoration(this.p);
            recyclerView.addItemDecoration(horizontalChipsDecoration);
            this.u = horizontalChipsDecoration;
        }
        if (this.b.ordinal() == 0) {
            addOnLayoutChangeListener(new Chips$scheduleFitCheck$$inlined$runOnNextLayoutChange$1(this, this));
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        RecyclerView.Adapter adapter = this.m.getAdapter();
        if (!(adapter instanceof ChipsAdapter)) {
            adapter = null;
        }
        ChipsAdapter chipsAdapter = (ChipsAdapter) adapter;
        if (chipsAdapter != null) {
            chipsAdapter.setContainerEnabled(z);
        }
        Iterator<View> children = ViewGroupsKt.getChildren(this.m);
        while (children.hasNext()) {
            children.next().setEnabled(z);
        }
    }

    public final void setError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.l.setTextColor(this.e);
        TextViews.bindText$default(this.l, str, false, 2, null);
    }

    public final void setErrorOnTop(@Nullable String str) {
        TextViews.bindText$default(this.k, str, false, 2, null);
        c();
    }

    public final void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.l.setTextColor(this.d);
        TextViews.bindText$default(this.l, str, false, 2, null);
    }

    public final void setKeepSelected(boolean z) {
        this.n.setKeepLastSelected(z);
    }

    public final void setMaxSelected(int i2) {
        this.n.setMaxSelected(i2);
    }

    public final void setOnScrollPositionChangeListener(@Nullable OnScrollPositionChangeListener onScrollPositionChangeListener) {
        this.o = onScrollPositionChangeListener;
    }

    public final void setSelectStrategy(@NotNull SelectStrategy selectStrategy) {
        Intrinsics.checkNotNullParameter(selectStrategy, "value");
        this.n.setSelectStrategy(selectStrategy);
    }

    public final void setSubtitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, MessengerShareContentUtility.SUBTITLE);
        this.j.setTextColor(this.f);
        TextViews.bindText$default(this.j, charSequence, false, 2, null);
        c();
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.i, str, false, 2, null);
        c();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Chips(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chips);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SuppressLint({"CustomViewStyleable"})
    public Chips(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayType displayType = DisplayType.SINGLE_LINE_SCROLLABLE;
        this.b = displayType;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.d = Contexts.getColorStateListByAttr(context2, R.attr.gray48);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.e = Contexts.getColorStateListByAttr(context3, R.attr.red);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        TypedValue typedValue = new TypedValue();
        if (context4.getTheme().resolveAttribute(R.attr.chips, typedValue, true)) {
            i3 = typedValue.resourceId;
        } else {
            i3 = R.style.Design_Widget_Chips;
        }
        ContextWrapper contextWrapper = new ContextWrapper(context4);
        contextWrapper.setTheme(i3);
        LayoutInflater.from(contextWrapper).inflate(R.layout.design_chips_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        this.i = textView;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        TextView textView2 = (TextView) findViewById2;
        this.j = textView2;
        View findViewById3 = findViewById(R.id.error_top);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.error_top)");
        this.k = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.hint);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.hint)");
        TextView textView3 = (TextView) findViewById4;
        this.l = textView3;
        View findViewById5 = findViewById(R.id.chips_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.chips_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById5;
        this.m = recyclerView;
        recyclerView.addOnScrollListener(new d());
        ColorStateList textColors = textView2.getTextColors();
        Intrinsics.checkNotNullExpressionValue(textColors, "subtitleTextView.textColors");
        this.f = textColors;
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DesignChips, i2, R.style.Design_Widget_Chips);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.DesignChips_chips_title);
        TextViews.bindText$default(textView, text != null ? text.toString() : null, false, 2, null);
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.DesignChips_chips_subtitle);
        TextViews.bindText$default(textView2, text2 != null ? text2.toString() : null, false, 2, null);
        CharSequence text3 = obtainStyledAttributes.getText(R.styleable.DesignChips_chips_hint);
        TextViews.bindText$default(textView3, text3 != null ? text3.toString() : null, false, 2, null);
        c();
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, Navigation.ATTRIBUTES);
        int i4 = R.styleable.DesignChips_chips_childMinWidth;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.r = obtainStyledAttributes.getDimensionPixelSize(i4, 0);
        }
        int i5 = R.styleable.DesignChips_chips_childHorizontalMargin;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.p = obtainStyledAttributes.getDimensionPixelSize(i5, 0);
        }
        int i6 = R.styleable.DesignChips_chips_childVerticalMargin;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.q = obtainStyledAttributes.getDimensionPixelSize(i6, 0);
        }
        int i7 = R.styleable.DesignChips_chips_titleSmallMargin;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.s = obtainStyledAttributes.getDimensionPixelSize(i7, 0);
        }
        int i8 = R.styleable.DesignChips_chips_contentTopMargin;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.t = obtainStyledAttributes.getDimensionPixelSize(i8, 0);
        }
        int i9 = R.styleable.DesignChips_chips_maxSelected;
        int i10 = obtainStyledAttributes.hasValue(i9) ? obtainStyledAttributes.getInt(i9, -1) : -1;
        setUnselectedAppearance(obtainStyledAttributes.getResourceId(R.styleable.DesignChips_chips_unselectedAppearance, R.style.Deprecated_Button_Appearance_Default));
        setSelectedAppearance(obtainStyledAttributes.getResourceId(R.styleable.DesignChips_chips_selectedAppearance, R.style.Deprecated_Button_Appearance_Primary));
        setEnabled(obtainStyledAttributes.getBoolean(R.styleable.DesignChips_android_enabled, true));
        ChipsSelectManagerImpl chipsSelectManagerImpl = new ChipsSelectManagerImpl(SelectStrategy.values()[obtainStyledAttributes.getInt(R.styleable.DesignChips_chips_selectStrategy, 0)], obtainStyledAttributes.getBoolean(R.styleable.DesignChips_chips_keepLastSelected, false), new Function1<Integer, Unit>(this) { // from class: com.avito.android.lib.design.chips.Chips.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Integer num) {
                Chips.access$onSelected((Chips) this.receiver, num.intValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Integer, Unit>(this) { // from class: com.avito.android.lib.design.chips.Chips.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Integer num) {
                Chips.access$onUnSelected((Chips) this.receiver, num.intValue());
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>(this) { // from class: com.avito.android.lib.design.chips.Chips.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                Chips.access$onMaxSelectedStateChanged((Chips) this.receiver);
                return Unit.INSTANCE;
            }
        }, i10);
        this.n = chipsSelectManagerImpl;
        DisplayType displayType2 = (DisplayType) ArraysKt___ArraysKt.getOrNull(DisplayType.values(), obtainStyledAttributes.getInt(R.styleable.DesignChips_chips_displayType, 0));
        setDisplayType(displayType2 != null ? displayType2 : displayType);
        int i11 = R.styleable.DesignChips_android_padding;
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(i11, -1);
        if (layoutDimension > 0) {
            setChildrenHorizontalMargin(layoutDimension, layoutDimension);
            setPadding(0, layoutDimension, 0, layoutDimension);
        } else {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignChips_android_paddingStart, 0);
            dimensionPixelSize = dimensionPixelSize == 0 ? obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignChips_android_paddingLeft, 0) : dimensionPixelSize;
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignChips_android_paddingEnd, 0);
            dimensionPixelSize2 = dimensionPixelSize2 == 0 ? obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignChips_android_paddingRight, 0) : dimensionPixelSize2;
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignChips_android_paddingTop, 0);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(i11, 0);
            setChildrenHorizontalMargin(dimensionPixelSize, dimensionPixelSize2);
            setPadding(0, dimensionPixelSize3, 0, dimensionPixelSize4);
        }
        obtainStyledAttributes.recycle();
        recyclerView.setLayoutManager(b());
        ChipsAdapter chipsAdapter = new ChipsAdapter(chipsSelectManagerImpl, isEnabled(), this.h, this.g);
        this.c = chipsAdapter;
        recyclerView.setAdapter(chipsAdapter);
    }

    public final void select(@NotNull Collection<? extends Chipable> collection) {
        Intrinsics.checkNotNullParameter(collection, "selected");
        RecyclerView recyclerView = this.m;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.avito.android.lib.design.chips.ChipsAdapter");
        List<Chipable> data = ((ChipsAdapter) adapter).getData();
        ArrayList<Number> arrayList = new ArrayList(e.collectionSizeOrDefault(collection, 10));
        for (T t2 : collection) {
            int i2 = 0;
            Iterator<Chipable> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (t2.equalsAsChipable(it.next())) {
                    break;
                } else {
                    i2++;
                }
            }
            arrayList.add(Integer.valueOf(i2));
        }
        this.n.select(arrayList);
        for (Number number : arrayList) {
            int intValue = number.intValue();
            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyItemChanged(intValue);
            }
        }
    }
}
