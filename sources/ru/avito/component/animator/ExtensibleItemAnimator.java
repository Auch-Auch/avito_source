package ru.avito.component.animator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B\u0013\u0012\b\b\u0002\u0010z\u001a\u00020\u000b¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0016\u0010\u0010J7\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010!\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001f\u0010 JA\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0000¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\u0010J\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0007H\u0000¢\u0006\u0004\b,\u0010\u0012J\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u0012J\u001d\u00103\u001a\u00020\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050/H\u0000¢\u0006\u0004\b1\u00102J%\u00107\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u0002050/H\u0016¢\u0006\u0004\b7\u00108J\u001b\u0010;\u001a\u000209*\u0002092\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\u0011\u0010=\u001a\u00020\u000b*\u00020\u0005¢\u0006\u0004\b=\u0010\u0014J\u0011\u0010>\u001a\u00020\u000b*\u00020\u0005¢\u0006\u0004\b>\u0010\u0014J1\u0010?\u001a\u00020\u000b*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b?\u0010\u001eJ;\u0010D\u001a\u00020\u000b*\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u0018¢\u0006\u0004\bD\u0010%J\u0011\u0010\u0013\u001a\u00020E*\u00020\u0005¢\u0006\u0004\b\u0013\u0010FJ\u0011\u0010\u0015\u001a\u00020E*\u00020\u0005¢\u0006\u0004\b\u0015\u0010FJ1\u0010\u001d\u001a\u00020E*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010GJ;\u0010H\u001a\u00020E*\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\bH\u0010IJ;\u0010J\u001a\u00020E*\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\bJ\u0010IR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00050K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001e\u0010S\u001a\n P*\u0004\u0018\u00010O0O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0017\u0010W\u001a\u00020T*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\bU\u0010VR(\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00050K8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bX\u0010M\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R(\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050K8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b^\u0010M\u001a\u0004\b_\u0010Z\"\u0004\b`\u0010\\R\u001d\u0010g\u001a\u00020b8B@\u0002X\u0002¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR.\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030K0K8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bh\u0010M\u001a\u0004\bi\u0010Z\"\u0004\bj\u0010\\R(\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00050K8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bl\u0010M\u001a\u0004\bm\u0010Z\"\u0004\bn\u0010\\R\u001c\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00050K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010MR\u0017\u0010s\u001a\u00020T*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\br\u0010VR\u0017\u0010w\u001a\u00020t*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0016\u0010z\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR(\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00050K8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b{\u0010M\u001a\u0004\b|\u0010Z\"\u0004\b}\u0010\\R1\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050K0K8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0004\b\u0010M\u001a\u0005\b\u0001\u0010Z\"\u0005\b\u0001\u0010\\R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030K8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010MR3\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010K0K8\u0000@\u0000X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010M\u001a\u0005\b\u0001\u0010Z\"\u0005\b\u0001\u0010\\R\u0019\u0010\u0001\u001a\u00020T*\u00020\u00058F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010VR\u001f\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010K8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010M¨\u0006\u0001"}, d2 = {"Lru/avito/component/animator/ExtensibleItemAnimator;", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "", "Lru/avito/component/animator/ExtensibleItemAnimator$ChangeInfo;", "infoList", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "", AuthSource.BOOKING_ORDER, "(Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "changeInfo", "", "c", "(Lru/avito/component/animator/ExtensibleItemAnimator$ChangeInfo;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "holder", "d", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "runPendingAnimations", "()V", "animateRemove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "animateAdd", "animateAddImpl$ui_components_release", "animateAddImpl", "", "fromX", "fromY", "toX", "toY", "animateMove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Z", "animateMoveImpl$ui_components_release", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "animateMoveImpl", "oldHolder", "newHolder", "animateChange", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Z", "animateChangeImpl$ui_components_release", "(Lru/avito/component/animator/ExtensibleItemAnimator$ChangeInfo;)V", "animateChangeImpl", "endAnimation", "isRunning", "()Z", "dispatchFinishedWhenDone$ui_components_release", "dispatchFinishedWhenDone", "endAnimations", "", "viewHolders", "cancelAll$ui_components_release", "(Ljava/util/List;)V", "cancelAll", "viewHolder", "", "payloads", "canReuseUpdatedViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)Z", "Landroidx/core/view/ViewPropertyAnimatorListener;", "delegate", "combine", "(Landroidx/core/view/ViewPropertyAnimatorListener;Landroidx/core/view/ViewPropertyAnimatorListener;)Landroidx/core/view/ViewPropertyAnimatorListener;", "preAnimateRemove", "preAnimateAdd", "preAnimateMove", "fromLeft", "fromTop", "toLeft", "toTop", "preAnimateChange", "Lru/avito/component/animator/AnimatorInfo;", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Lru/avito/component/animator/AnimatorInfo;", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Lru/avito/component/animator/AnimatorInfo;", "animateChangeOld", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Lru/avito/component/animator/AnimatorInfo;", "animateChangeNew", "Ljava/util/ArrayList;", "h", "Ljava/util/ArrayList;", "mPendingRemovals", "Landroid/animation/TimeInterpolator;", "kotlin.jvm.PlatformType", "s", "Landroid/animation/TimeInterpolator;", "defaultInterpolator", "", "getMoveDurationMs", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)J", "moveDurationMs", "o", "getMAddAnimations$ui_components_release", "()Ljava/util/ArrayList;", "setMAddAnimations$ui_components_release", "(Ljava/util/ArrayList;)V", "mAddAnimations", VKApiConst.Q, "getMRemoveAnimations$ui_components_release", "setMRemoveAnimations$ui_components_release", "mRemoveAnimations", "Lru/avito/component/animator/DefaultAnimatorStrategy;", "t", "Lkotlin/Lazy;", "getDefaultAnimatorStrategy", "()Lru/avito/component/animator/DefaultAnimatorStrategy;", "defaultAnimatorStrategy", "n", "getMChangesList$ui_components_release", "setMChangesList$ui_components_release", "mChangesList", "r", "getMChangeAnimations$ui_components_release", "setMChangeAnimations$ui_components_release", "mChangeAnimations", "i", "mPendingAdditions", "getRemoveDurationMs", "removeDurationMs", "Lru/avito/component/animator/AnimatorStrategy;", "getAnimatorStrategy", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Lru/avito/component/animator/AnimatorStrategy;", "animatorStrategy", "u", "Z", "isDebug", "p", "getMMoveAnimations$ui_components_release", "setMMoveAnimations$ui_components_release", "mMoveAnimations", "l", "getMAdditionsList$ui_components_release", "setMAdditionsList$ui_components_release", "mAdditionsList", "k", "mPendingChanges", "Lru/avito/component/animator/ExtensibleItemAnimator$MoveInfo;", AuthSource.OPEN_CHANNEL_LIST, "getMMovesList$ui_components_release", "setMMovesList$ui_components_release", "mMovesList", "getChangeDurationMs", "changeDurationMs", "j", "mPendingMoves", "<init>", "(Z)V", "ChangeInfo", "MoveInfo", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ExtensibleItemAnimator extends SimpleItemAnimator {
    public final ArrayList<RecyclerView.ViewHolder> h;
    public final ArrayList<RecyclerView.ViewHolder> i;
    public final ArrayList<MoveInfo> j;
    public final ArrayList<ChangeInfo> k;
    @NotNull
    public ArrayList<ArrayList<RecyclerView.ViewHolder>> l;
    @NotNull
    public ArrayList<ArrayList<MoveInfo>> m;
    @NotNull
    public ArrayList<ArrayList<ChangeInfo>> n;
    @NotNull
    public ArrayList<RecyclerView.ViewHolder> o;
    @NotNull
    public ArrayList<RecyclerView.ViewHolder> p;
    @NotNull
    public ArrayList<RecyclerView.ViewHolder> q;
    @NotNull
    public ArrayList<RecyclerView.ViewHolder> r;
    public final TimeInterpolator s;
    public final Lazy t;
    public final boolean u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B=\b\u0010\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010$\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R$\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\"\u0010$\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013¨\u0006'"}, d2 = {"Lru/avito/component/animator/ExtensibleItemAnimator$ChangeInfo;", "", "", "toString", "()Ljava/lang/String;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "f", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getNewHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setNewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "newHolder", "", "c", "I", "getToX", "()I", "setToX", "(I)V", "toX", AuthSource.BOOKING_ORDER, "getFromY", "setFromY", "fromY", "d", "getToY", "setToY", "toY", "e", "getOldHolder", "setOldHolder", "oldHolder", AuthSource.SEND_ABUSE, "getFromX", "setFromX", "fromX", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChangeInfo {
        public int a;
        public int b;
        public int c;
        public int d;
        @Nullable
        public RecyclerView.ViewHolder e;
        @Nullable
        public RecyclerView.ViewHolder f;

        public ChangeInfo(@Nullable RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this.e = viewHolder;
            this.f = viewHolder2;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public final int getFromX() {
            return this.a;
        }

        public final int getFromY() {
            return this.b;
        }

        @Nullable
        public final RecyclerView.ViewHolder getNewHolder() {
            return this.f;
        }

        @Nullable
        public final RecyclerView.ViewHolder getOldHolder() {
            return this.e;
        }

        public final int getToX() {
            return this.c;
        }

        public final int getToY() {
            return this.d;
        }

        public final void setFromX(int i) {
            this.a = i;
        }

        public final void setFromY(int i) {
            this.b = i;
        }

        public final void setNewHolder(@Nullable RecyclerView.ViewHolder viewHolder) {
            this.f = viewHolder;
        }

        public final void setOldHolder(@Nullable RecyclerView.ViewHolder viewHolder) {
            this.e = viewHolder;
        }

        public final void setToX(int i) {
            this.c = i;
        }

        public final void setToY(int i) {
            this.d = i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ChangeInfo{oldHolder=");
            L.append(this.e);
            L.append(", newHolder=");
            L.append(this.f);
            L.append(", fromX=");
            L.append(this.a);
            L.append(", fromY=");
            L.append(this.b);
            L.append(", toX=");
            L.append(this.c);
            L.append(", toY=");
            return a2.b.a.a.a.i(L, this.d, '}');
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lru/avito/component/animator/ExtensibleItemAnimator$MoveInfo;", "", "", "c", "I", "getFromY", "()I", "setFromY", "(I)V", "fromY", "d", "getToX", "setToX", "toX", AuthSource.BOOKING_ORDER, "getFromX", "setFromX", "fromX", "e", "getToY", "setToY", "toY", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "holder", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class MoveInfo {
        @NotNull
        public RecyclerView.ViewHolder a;
        public int b;
        public int c;
        public int d;
        public int e;

        public MoveInfo(@NotNull RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            this.a = viewHolder;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        public final int getFromX() {
            return this.b;
        }

        public final int getFromY() {
            return this.c;
        }

        @NotNull
        public final RecyclerView.ViewHolder getHolder() {
            return this.a;
        }

        public final int getToX() {
            return this.d;
        }

        public final int getToY() {
            return this.e;
        }

        public final void setFromX(int i) {
            this.b = i;
        }

        public final void setFromY(int i) {
            this.c = i;
        }

        public final void setHolder(@NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "<set-?>");
            this.a = viewHolder;
        }

        public final void setToX(int i) {
            this.d = i;
        }

        public final void setToY(int i) {
            this.e = i;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a;
            if (i == 0) {
                Iterator it = ((ArrayList) this.c).iterator();
                while (it.hasNext()) {
                    RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it.next();
                    Intrinsics.checkNotNullExpressionValue(viewHolder, "holder");
                    ((ExtensibleItemAnimator) this.b).animateAddImpl$ui_components_release(viewHolder);
                }
                ((ArrayList) this.c).clear();
                ((ExtensibleItemAnimator) this.b).getMAdditionsList$ui_components_release().remove((ArrayList) this.c);
            } else if (i == 1) {
                Iterator it2 = ((ArrayList) this.c).iterator();
                while (it2.hasNext()) {
                    ChangeInfo changeInfo = (ChangeInfo) it2.next();
                    Intrinsics.checkNotNullExpressionValue(changeInfo, "change");
                    ((ExtensibleItemAnimator) this.b).animateChangeImpl$ui_components_release(changeInfo);
                }
                ((ArrayList) this.c).clear();
                ((ExtensibleItemAnimator) this.b).getMChangesList$ui_components_release().remove((ArrayList) this.c);
            } else if (i == 2) {
                Iterator it3 = ((ArrayList) this.c).iterator();
                while (it3.hasNext()) {
                    MoveInfo moveInfo = (MoveInfo) it3.next();
                    ((ExtensibleItemAnimator) this.b).animateMoveImpl$ui_components_release(moveInfo.getHolder(), moveInfo.getFromX(), moveInfo.getFromY(), moveInfo.getToX(), moveInfo.getToY());
                }
                ((ArrayList) this.c).clear();
                ((ExtensibleItemAnimator) this.b).getMMovesList$ui_components_release().remove((ArrayList) this.c);
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<DefaultAnimatorStrategy> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public DefaultAnimatorStrategy invoke() {
            return new DefaultAnimatorStrategy();
        }
    }

    public ExtensibleItemAnimator() {
        this(false, 1, null);
    }

    public ExtensibleItemAnimator(boolean z) {
        this.u = z;
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = new ValueAnimator().getInterpolator();
        this.t = c.lazy(b.a);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: animateAdd  reason: collision with other method in class */
    public boolean mo732animateAdd(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        d(viewHolder);
        if (preAnimateAdd(viewHolder)) {
            this.i.add(viewHolder);
            return true;
        }
        dispatchAddFinished(viewHolder);
        return false;
    }

    public final void animateAddImpl$ui_components_release(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        this.o.add(viewHolder);
        AnimatorInfo animateAdd = mo732animateAdd(viewHolder);
        animateAdd.getAnimation().setListener(combine(new VpaListenerAdapter(animateAdd, this, viewHolder) { // from class: ru.avito.component.animator.ExtensibleItemAnimator$animateAddImpl$$inlined$with$lambda$1
            public final /* synthetic */ AnimatorInfo a;
            public final /* synthetic */ ExtensibleItemAnimator b;
            public final /* synthetic */ RecyclerView.ViewHolder c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.a.getAnimation().setListener(null);
                this.b.dispatchAddFinished(this.c);
                this.b.getMAddAnimations$ui_components_release().remove(this.c);
                this.b.dispatchFinishedWhenDone$ui_components_release();
            }

            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.b.dispatchAddStarting(this.c);
            }
        }, animateAdd.getAnimationListener())).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "oldHolder");
        if (viewHolder == viewHolder2) {
            return mo733animateMove(viewHolder, i2, i3, i4, i5);
        }
        if (preAnimateChange(viewHolder, viewHolder2, i2, i3, i4, i5)) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "oldHolder.itemView");
            float translationX = view.getTranslationX();
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "oldHolder.itemView");
            float translationY = view2.getTranslationY();
            View view3 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "oldHolder.itemView");
            float alpha = view3.getAlpha();
            d(viewHolder);
            int i6 = (int) ((((float) i4) - ((float) i2)) - translationX);
            int i7 = (int) ((((float) i5) - ((float) i3)) - translationY);
            View view4 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view4, "oldHolder.itemView");
            view4.setTranslationX(translationX);
            View view5 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view5, "oldHolder.itemView");
            view5.setTranslationY(translationY);
            View view6 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view6, "oldHolder.itemView");
            view6.setAlpha(alpha);
            if (viewHolder2 != null) {
                d(viewHolder2);
                View view7 = viewHolder2.itemView;
                Intrinsics.checkNotNullExpressionValue(view7, "newHolder.itemView");
                view7.setTranslationX((float) (-i6));
                View view8 = viewHolder2.itemView;
                Intrinsics.checkNotNullExpressionValue(view8, "newHolder.itemView");
                view8.setTranslationY((float) (-i7));
                View view9 = viewHolder2.itemView;
                Intrinsics.checkNotNullExpressionValue(view9, "newHolder.itemView");
                view9.setAlpha(0.0f);
            }
            this.k.add(new ChangeInfo(viewHolder, viewHolder2, i2, i3, i4, i5));
            return true;
        }
        dispatchChangeFinished(viewHolder, true);
        return false;
    }

    public final void animateChangeImpl$ui_components_release(@NotNull ChangeInfo changeInfo) {
        Intrinsics.checkNotNullParameter(changeInfo, "changeInfo");
        RecyclerView.ViewHolder oldHolder = changeInfo.getOldHolder();
        View view = null;
        View view2 = oldHolder != null ? oldHolder.itemView : null;
        RecyclerView.ViewHolder newHolder = changeInfo.getNewHolder();
        if (newHolder != null) {
            view = newHolder.itemView;
        }
        if (view2 != null) {
            this.r.add(oldHolder);
            AnimatorInfo animateChangeOld = animateChangeOld(oldHolder, newHolder, changeInfo.getFromX(), changeInfo.getFromY(), changeInfo.getToX(), changeInfo.getToY());
            oldHolder.itemView.animate();
            animateChangeOld.getAnimation().setListener(combine(new VpaListenerAdapter(animateChangeOld, this, oldHolder) { // from class: ru.avito.component.animator.ExtensibleItemAnimator$animateChangeImpl$$inlined$with$lambda$1
                public final /* synthetic */ AnimatorInfo a;
                public final /* synthetic */ ExtensibleItemAnimator b;
                public final /* synthetic */ RecyclerView.ViewHolder c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(@NotNull View view3) {
                    Intrinsics.checkNotNullParameter(view3, "view");
                    this.a.getAnimation().setListener(null);
                    this.b.dispatchChangeFinished(this.c, true);
                    this.b.getMChangeAnimations$ui_components_release().remove(this.c);
                    this.b.dispatchFinishedWhenDone$ui_components_release();
                }

                @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(@NotNull View view3) {
                    Intrinsics.checkNotNullParameter(view3, "view");
                    this.b.dispatchChangeStarting(this.c, true);
                }
            }, animateChangeOld.getAnimationListener())).start();
        }
        if (view != null) {
            this.r.add(newHolder);
            AnimatorInfo animateChangeNew = animateChangeNew(newHolder, oldHolder, changeInfo.getFromX(), changeInfo.getFromY(), changeInfo.getToX(), changeInfo.getToY());
            animateChangeNew.getAnimation().setListener(combine(new VpaListenerAdapter(animateChangeNew, this, newHolder) { // from class: ru.avito.component.animator.ExtensibleItemAnimator$animateChangeImpl$$inlined$with$lambda$2
                public final /* synthetic */ AnimatorInfo a;
                public final /* synthetic */ ExtensibleItemAnimator b;
                public final /* synthetic */ RecyclerView.ViewHolder c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(@NotNull View view3) {
                    Intrinsics.checkNotNullParameter(view3, "view");
                    this.a.getAnimation().setListener(null);
                    this.b.dispatchChangeFinished(this.c, false);
                    this.b.getMChangeAnimations$ui_components_release().remove(this.c);
                    this.b.dispatchFinishedWhenDone$ui_components_release();
                }

                @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(@NotNull View view3) {
                    Intrinsics.checkNotNullParameter(view3, "view");
                    this.b.dispatchChangeStarting(this.c, false);
                }
            }, animateChangeNew.getAnimationListener())).start();
        }
    }

    @NotNull
    public final AnimatorInfo animateChangeNew(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$animateChangeNew");
        return getAnimatorStrategy(viewHolder).animateChangeNew(viewHolder2, viewHolder, i2, i3, i4, i5);
    }

    @NotNull
    public final AnimatorInfo animateChangeOld(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$animateChangeOld");
        return getAnimatorStrategy(viewHolder).animateChangeOld(viewHolder, viewHolder2, i2, i3, i4, i5);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: animateMove  reason: collision with other method in class */
    public boolean mo733animateMove(@NotNull RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int translationX = i2 + ((int) view.getTranslationX());
        View view2 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        int translationY = i3 + ((int) view2.getTranslationY());
        d(viewHolder);
        if (preAnimateMove(viewHolder, translationX, translationY, i4, i5)) {
            this.j.add(new MoveInfo(viewHolder, translationX, translationY, i4, i5));
            return true;
        }
        dispatchMoveFinished(viewHolder);
        return false;
    }

    public final void animateMoveImpl$ui_components_release(@NotNull RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        this.p.add(viewHolder);
        AnimatorInfo animateMove = mo733animateMove(viewHolder, i2, i3, i4, i5);
        animateMove.getAnimation().setListener(combine(new VpaListenerAdapter(animateMove, this, viewHolder) { // from class: ru.avito.component.animator.ExtensibleItemAnimator$animateMoveImpl$$inlined$with$lambda$1
            public final /* synthetic */ AnimatorInfo a;
            public final /* synthetic */ ExtensibleItemAnimator b;
            public final /* synthetic */ RecyclerView.ViewHolder c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.a.getAnimation().setListener(null);
                this.b.dispatchMoveFinished(this.c);
                this.b.getMMoveAnimations$ui_components_release().remove(this.c);
                this.b.dispatchFinishedWhenDone$ui_components_release();
            }

            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.b.dispatchMoveStarting(this.c);
            }
        }, animateMove.getAnimationListener())).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: animateRemove  reason: collision with other method in class */
    public boolean mo734animateRemove(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        d(viewHolder);
        if (preAnimateRemove(viewHolder)) {
            this.h.add(viewHolder);
            return true;
        }
        dispatchRemoveFinished(viewHolder);
        return false;
    }

    public final void b(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                ChangeInfo changeInfo = list.get(size);
                if (c(changeInfo, viewHolder) && changeInfo.getOldHolder() == null && changeInfo.getNewHolder() == null) {
                    list.remove(changeInfo);
                }
            } else {
                return;
            }
        }
    }

    public final boolean c(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.getNewHolder() == viewHolder) {
            changeInfo.setNewHolder(null);
        } else if (changeInfo.getOldHolder() != viewHolder) {
            return false;
        } else {
            changeInfo.setOldHolder(null);
            z = true;
        }
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "item.itemView");
        view.setAlpha(1.0f);
        View view2 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
        view2.setTranslationX(0.0f);
        View view3 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view3, "item.itemView");
        view3.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    public final void cancelAll$ui_components_release(@NotNull List<? extends RecyclerView.ViewHolder> list) {
        Intrinsics.checkNotNullParameter(list, "viewHolders");
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                ViewCompat.animate(((RecyclerView.ViewHolder) list.get(size)).itemView).cancel();
            } else {
                return;
            }
        }
    }

    @NotNull
    public final ViewPropertyAnimatorListener combine(@NotNull ViewPropertyAnimatorListener viewPropertyAnimatorListener, @Nullable ViewPropertyAnimatorListener viewPropertyAnimatorListener2) {
        Intrinsics.checkNotNullParameter(viewPropertyAnimatorListener, "$this$combine");
        return new ViewPropertyAnimatorListener(viewPropertyAnimatorListener, viewPropertyAnimatorListener2) { // from class: ru.avito.component.animator.ExtensibleItemAnimator$combine$1
            public final /* synthetic */ ViewPropertyAnimatorListener a;
            public final /* synthetic */ ViewPropertyAnimatorListener b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.a.onAnimationCancel(view);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener3 = this.b;
                if (viewPropertyAnimatorListener3 != null) {
                    viewPropertyAnimatorListener3.onAnimationCancel(view);
                }
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.a.onAnimationEnd(view);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener3 = this.b;
                if (viewPropertyAnimatorListener3 != null) {
                    viewPropertyAnimatorListener3.onAnimationEnd(view);
                }
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.a.onAnimationStart(view);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener3 = this.b;
                if (viewPropertyAnimatorListener3 != null) {
                    viewPropertyAnimatorListener3.onAnimationStart(view);
                }
            }
        };
    }

    public final void d(RecyclerView.ViewHolder viewHolder) {
        ViewPropertyAnimator animate = viewHolder.itemView.animate();
        Intrinsics.checkNotNullExpressionValue(animate, "holder.itemView.animate()");
        animate.setInterpolator(this.s);
        endAnimation(viewHolder);
    }

    public final void dispatchFinishedWhenDone$ui_components_release() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "item");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "item.itemView");
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.j.get(size);
            Intrinsics.checkNotNullExpressionValue(moveInfo, "mPendingMoves[i]");
            if (moveInfo.getHolder() == viewHolder) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                dispatchMoveFinished(viewHolder);
                this.j.remove(size);
            }
        }
        b(this.k, viewHolder);
        if (this.h.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.i.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        int size2 = this.n.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList<ChangeInfo> arrayList = this.n.get(size2);
            Intrinsics.checkNotNullExpressionValue(arrayList, "mChangesList[i]");
            ArrayList<ChangeInfo> arrayList2 = arrayList;
            b(arrayList2, viewHolder);
            if (arrayList2.isEmpty()) {
                this.n.remove(size2);
            }
        }
        int size3 = this.m.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList<MoveInfo> arrayList3 = this.m.get(size3);
            Intrinsics.checkNotNullExpressionValue(arrayList3, "mMovesList[i]");
            ArrayList<MoveInfo> arrayList4 = arrayList3;
            int size4 = arrayList4.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                }
                MoveInfo moveInfo2 = arrayList4.get(size4);
                Intrinsics.checkNotNullExpressionValue(moveInfo2, "moves[j]");
                if (moveInfo2.getHolder() == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList4.remove(size4);
                    if (arrayList4.isEmpty()) {
                        this.m.remove(size3);
                    }
                }
            }
        }
        int size5 = this.l.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                break;
            }
            ArrayList<RecyclerView.ViewHolder> arrayList5 = this.l.get(size5);
            Intrinsics.checkNotNullExpressionValue(arrayList5, "mAdditionsList[i]");
            ArrayList<RecyclerView.ViewHolder> arrayList6 = arrayList5;
            if (arrayList6.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList6.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        if (this.q.remove(viewHolder) && this.u) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mRemoveAnimations list");
        } else if (this.o.remove(viewHolder) && this.u) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mAddAnimations list");
        } else if (this.r.remove(viewHolder) && this.u) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mChangeAnimations list");
        } else if (!this.p.remove(viewHolder) || !this.u) {
            dispatchFinishedWhenDone$ui_components_release();
        } else {
            throw new IllegalStateException("after animation is cancelled, item should not be in mMoveAnimations list");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.j.get(size);
            Intrinsics.checkNotNullExpressionValue(moveInfo, "mPendingMoves[i]");
            MoveInfo moveInfo2 = moveInfo;
            View view = moveInfo2.getHolder().itemView;
            Intrinsics.checkNotNullExpressionValue(view, "item.holder.itemView");
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            dispatchMoveFinished(moveInfo2.getHolder());
            this.j.remove(size);
        }
        int size2 = this.h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.h.get(size2);
            Intrinsics.checkNotNullExpressionValue(viewHolder, "mPendingRemovals[i]");
            dispatchRemoveFinished(viewHolder);
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder2 = this.i.get(size3);
            Intrinsics.checkNotNullExpressionValue(viewHolder2, "mPendingAdditions[i]");
            RecyclerView.ViewHolder viewHolder3 = viewHolder2;
            View view2 = viewHolder3.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
            view2.setAlpha(1.0f);
            dispatchAddFinished(viewHolder3);
            this.i.remove(size3);
        }
        int size4 = this.k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            ChangeInfo changeInfo = this.k.get(size4);
            Intrinsics.checkNotNullExpressionValue(changeInfo, "mPendingChanges[i]");
            ChangeInfo changeInfo2 = changeInfo;
            RecyclerView.ViewHolder oldHolder = changeInfo2.getOldHolder();
            if (oldHolder != null) {
                c(changeInfo2, oldHolder);
            }
            RecyclerView.ViewHolder newHolder = changeInfo2.getNewHolder();
            if (newHolder != null) {
                c(changeInfo2, newHolder);
            }
        }
        this.k.clear();
        if (isRunning()) {
            int size5 = this.m.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList<MoveInfo> arrayList = this.m.get(size5);
                Intrinsics.checkNotNullExpressionValue(arrayList, "mMovesList[i]");
                ArrayList<MoveInfo> arrayList2 = arrayList;
                int size6 = arrayList2.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        MoveInfo moveInfo3 = arrayList2.get(size6);
                        Intrinsics.checkNotNullExpressionValue(moveInfo3, "moves[j]");
                        MoveInfo moveInfo4 = moveInfo3;
                        View view3 = moveInfo4.getHolder().itemView;
                        Intrinsics.checkNotNullExpressionValue(view3, "item.itemView");
                        view3.setTranslationX(0.0f);
                        view3.setTranslationY(0.0f);
                        dispatchMoveFinished(moveInfo4.getHolder());
                        arrayList2.remove(size6);
                        if (arrayList2.isEmpty()) {
                            this.m.remove(arrayList2);
                        }
                    }
                }
            }
            int size7 = this.l.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList<RecyclerView.ViewHolder> arrayList3 = this.l.get(size7);
                Intrinsics.checkNotNullExpressionValue(arrayList3, "mAdditionsList[i]");
                ArrayList<RecyclerView.ViewHolder> arrayList4 = arrayList3;
                int size8 = arrayList4.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        RecyclerView.ViewHolder viewHolder4 = arrayList4.get(size8);
                        Intrinsics.checkNotNullExpressionValue(viewHolder4, "additions[j]");
                        RecyclerView.ViewHolder viewHolder5 = viewHolder4;
                        View view4 = viewHolder5.itemView;
                        Intrinsics.checkNotNullExpressionValue(view4, "item.itemView");
                        view4.setAlpha(1.0f);
                        dispatchAddFinished(viewHolder5);
                        arrayList4.remove(size8);
                        if (arrayList4.isEmpty()) {
                            this.l.remove(arrayList4);
                        }
                    }
                }
            }
            int size9 = this.n.size();
            while (true) {
                size9--;
                if (size9 >= 0) {
                    ArrayList<ChangeInfo> arrayList5 = this.n.get(size9);
                    Intrinsics.checkNotNullExpressionValue(arrayList5, "mChangesList[i]");
                    ArrayList<ChangeInfo> arrayList6 = arrayList5;
                    int size10 = arrayList6.size();
                    while (true) {
                        size10--;
                        if (size10 >= 0) {
                            ChangeInfo changeInfo3 = arrayList6.get(size10);
                            Intrinsics.checkNotNullExpressionValue(changeInfo3, "changes[j]");
                            ChangeInfo changeInfo4 = changeInfo3;
                            RecyclerView.ViewHolder oldHolder2 = changeInfo4.getOldHolder();
                            if (oldHolder2 != null) {
                                c(changeInfo4, oldHolder2);
                            }
                            RecyclerView.ViewHolder newHolder2 = changeInfo4.getNewHolder();
                            if (newHolder2 != null) {
                                c(changeInfo4, newHolder2);
                            }
                            if (arrayList6.isEmpty()) {
                                this.n.remove(arrayList6);
                            }
                        }
                    }
                } else {
                    cancelAll$ui_components_release(this.q);
                    cancelAll$ui_components_release(this.p);
                    cancelAll$ui_components_release(this.o);
                    cancelAll$ui_components_release(this.r);
                    dispatchAnimationsFinished();
                    return;
                }
            }
        }
    }

    @NotNull
    public final AnimatorStrategy getAnimatorStrategy(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$animatorStrategy");
        if (viewHolder instanceof AnimatorViewHolder) {
            return ((AnimatorViewHolder) viewHolder).getAnimatorStrategy();
        }
        return (DefaultAnimatorStrategy) this.t.getValue();
    }

    public final long getChangeDurationMs(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$changeDurationMs");
        return getAnimatorStrategy(viewHolder).getChangeDurationMs();
    }

    @NotNull
    public final ArrayList<RecyclerView.ViewHolder> getMAddAnimations$ui_components_release() {
        return this.o;
    }

    @NotNull
    public final ArrayList<ArrayList<RecyclerView.ViewHolder>> getMAdditionsList$ui_components_release() {
        return this.l;
    }

    @NotNull
    public final ArrayList<RecyclerView.ViewHolder> getMChangeAnimations$ui_components_release() {
        return this.r;
    }

    @NotNull
    public final ArrayList<ArrayList<ChangeInfo>> getMChangesList$ui_components_release() {
        return this.n;
    }

    @NotNull
    public final ArrayList<RecyclerView.ViewHolder> getMMoveAnimations$ui_components_release() {
        return this.p;
    }

    @NotNull
    public final ArrayList<ArrayList<MoveInfo>> getMMovesList$ui_components_release() {
        return this.m;
    }

    @NotNull
    public final ArrayList<RecyclerView.ViewHolder> getMRemoveAnimations$ui_components_release() {
        return this.q;
    }

    public final long getMoveDurationMs(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$moveDurationMs");
        return getAnimatorStrategy(viewHolder).getMoveDurationMs();
    }

    public final long getRemoveDurationMs(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$removeDurationMs");
        return getAnimatorStrategy(viewHolder).getRemoveDurationMs();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return !this.i.isEmpty() || !this.k.isEmpty() || !this.j.isEmpty() || !this.h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }

    public final boolean preAnimateAdd(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$preAnimateAdd");
        return getAnimatorStrategy(viewHolder).preAnimateAdd(viewHolder);
    }

    public final boolean preAnimateChange(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$preAnimateChange");
        return getAnimatorStrategy(viewHolder).preAnimateChange(viewHolder, viewHolder2, i2, i3, i4, i5);
    }

    public final boolean preAnimateMove(@NotNull RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$preAnimateMove");
        return getAnimatorStrategy(viewHolder).preAnimateMove(viewHolder, i2, i3, i4, i5);
    }

    public final boolean preAnimateRemove(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$preAnimateRemove");
        return getAnimatorStrategy(viewHolder).preAnimateRemove(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        T t2;
        T t3;
        T t4;
        RecyclerView.ViewHolder oldHolder;
        RecyclerView.ViewHolder holder;
        boolean z = !this.h.isEmpty();
        boolean z2 = !this.j.isEmpty();
        boolean z3 = !this.k.isEmpty();
        boolean z4 = !this.i.isEmpty();
        Iterator<T> it = this.h.iterator();
        if (!it.hasNext()) {
            t2 = null;
        } else {
            t2 = it.next();
            if (it.hasNext()) {
                long removeDurationMs = getRemoveDurationMs(t2);
                do {
                    T next = it.next();
                    long removeDurationMs2 = getRemoveDurationMs(next);
                    if (removeDurationMs < removeDurationMs2) {
                        t2 = next;
                        removeDurationMs = removeDurationMs2;
                    }
                } while (it.hasNext());
            }
        }
        T t5 = t2;
        long removeDurationMs3 = t5 != null ? getRemoveDurationMs(t5) : 0;
        Iterator<T> it2 = this.j.iterator();
        if (!it2.hasNext()) {
            t3 = null;
        } else {
            t3 = it2.next();
            if (it2.hasNext()) {
                long moveDurationMs = getMoveDurationMs(t3.getHolder());
                do {
                    T next2 = it2.next();
                    long moveDurationMs2 = getMoveDurationMs(next2.getHolder());
                    if (moveDurationMs < moveDurationMs2) {
                        t3 = next2;
                        moveDurationMs = moveDurationMs2;
                    }
                } while (it2.hasNext());
            }
        }
        T t7 = t3;
        long moveDurationMs3 = (t7 == null || (holder = t7.getHolder()) == null) ? 0 : getMoveDurationMs(holder);
        Iterator<T> it3 = this.k.iterator();
        if (!it3.hasNext()) {
            t4 = null;
        } else {
            t4 = it3.next();
            if (it3.hasNext()) {
                RecyclerView.ViewHolder oldHolder2 = t4.getOldHolder();
                long changeDurationMs = oldHolder2 != null ? getChangeDurationMs(oldHolder2) : 0;
                do {
                    T next3 = it3.next();
                    RecyclerView.ViewHolder oldHolder3 = next3.getOldHolder();
                    long changeDurationMs2 = oldHolder3 != null ? getChangeDurationMs(oldHolder3) : 0;
                    if (changeDurationMs < changeDurationMs2) {
                        changeDurationMs = changeDurationMs2;
                        t4 = next3;
                    }
                } while (it3.hasNext());
            }
        }
        T t8 = t4;
        long changeDurationMs3 = (t8 == null || (oldHolder = t8.getOldHolder()) == null) ? 0 : getChangeDurationMs(oldHolder);
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it4 = this.h.iterator();
            while (it4.hasNext()) {
                RecyclerView.ViewHolder next4 = it4.next();
                Intrinsics.checkNotNullExpressionValue(next4, "holder");
                this.q.add(next4);
                AnimatorInfo animateRemove = mo734animateRemove(next4);
                animateRemove.getAnimation().setListener(combine(new VpaListenerAdapter(this, next4) { // from class: ru.avito.component.animator.ExtensibleItemAnimator$animateRemoveImpl$$inlined$with$lambda$1
                    public final /* synthetic */ ExtensibleItemAnimator b;
                    public final /* synthetic */ RecyclerView.ViewHolder c;

                    {
                        this.b = r2;
                        this.c = r3;
                    }

                    @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "view");
                        AnimatorInfo.this.getAnimation().setListener(null);
                        this.b.dispatchRemoveFinished(this.c);
                        this.b.getMRemoveAnimations$ui_components_release().remove(this.c);
                        this.b.dispatchFinishedWhenDone$ui_components_release();
                    }

                    @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationStart(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "view");
                        this.b.dispatchRemoveStarting(this.c);
                    }
                }, animateRemove.getAnimationListener())).start();
            }
            this.h.clear();
            if (z2) {
                ArrayList<MoveInfo> arrayList = new ArrayList<>();
                arrayList.addAll(this.j);
                this.m.add(arrayList);
                this.j.clear();
                a aVar = new a(2, this, arrayList);
                if (z) {
                    View view = arrayList.get(0).getHolder().itemView;
                    Intrinsics.checkNotNullExpressionValue(view, "moves[0].holder.itemView");
                    ViewCompat.postOnAnimationDelayed(view, aVar, removeDurationMs3);
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.k);
                this.n.add(arrayList2);
                this.k.clear();
                a aVar2 = new a(1, this, arrayList2);
                if (z) {
                    RecyclerView.ViewHolder oldHolder4 = arrayList2.get(0).getOldHolder();
                    Intrinsics.checkNotNull(oldHolder4);
                    ViewCompat.postOnAnimationDelayed(oldHolder4.itemView, aVar2, removeDurationMs3);
                } else {
                    aVar2.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.i);
                this.l.add(arrayList3);
                this.i.clear();
                a aVar3 = new a(0, this, arrayList3);
                if (z || z2 || z3) {
                    if (!z) {
                        removeDurationMs3 = 0;
                    }
                    if (!z2) {
                        moveDurationMs3 = 0;
                    }
                    long j2 = z3 ? changeDurationMs3 : 0;
                    View view2 = arrayList3.get(0).itemView;
                    Intrinsics.checkNotNullExpressionValue(view2, "additions[0].itemView");
                    ViewCompat.postOnAnimationDelayed(view2, aVar3, Math.max(moveDurationMs3, j2) + removeDurationMs3);
                    return;
                }
                aVar3.run();
            }
        }
    }

    public final void setMAddAnimations$ui_components_release(@NotNull ArrayList<RecyclerView.ViewHolder> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.o = arrayList;
    }

    public final void setMAdditionsList$ui_components_release(@NotNull ArrayList<ArrayList<RecyclerView.ViewHolder>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.l = arrayList;
    }

    public final void setMChangeAnimations$ui_components_release(@NotNull ArrayList<RecyclerView.ViewHolder> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.r = arrayList;
    }

    public final void setMChangesList$ui_components_release(@NotNull ArrayList<ArrayList<ChangeInfo>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.n = arrayList;
    }

    public final void setMMoveAnimations$ui_components_release(@NotNull ArrayList<RecyclerView.ViewHolder> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.p = arrayList;
    }

    public final void setMMovesList$ui_components_release(@NotNull ArrayList<ArrayList<MoveInfo>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.m = arrayList;
    }

    public final void setMRemoveAnimations$ui_components_release(@NotNull ArrayList<RecyclerView.ViewHolder> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.q = arrayList;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @NotNull
    /* renamed from: animateAdd */
    public final AnimatorInfo mo732animateAdd(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$animateAdd");
        return getAnimatorStrategy(viewHolder).animateAdd(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @NotNull
    /* renamed from: animateRemove */
    public final AnimatorInfo mo734animateRemove(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$animateRemove");
        return getAnimatorStrategy(viewHolder).animateRemove(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @NotNull
    /* renamed from: animateMove */
    public final AnimatorInfo mo733animateMove(@NotNull RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "$this$animateMove");
        return getAnimatorStrategy(viewHolder).animateMove(viewHolder, i2, i3, i4, i5);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExtensibleItemAnimator(boolean z, int i2, j jVar) {
        this((i2 & 1) != 0 ? false : z);
    }
}
