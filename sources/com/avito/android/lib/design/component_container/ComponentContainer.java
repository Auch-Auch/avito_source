package com.avito.android.lib.design.component_container;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewGroupsKt;
import com.avito.android.util.Views;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.model.VKApiUserFull;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001:\b\u0001\u0001\u0001\u0001B\u0016\b\u0016\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010u¢\u0006\u0006\b\u0001\u0010\u0001B \b\u0016\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010u\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0006\b\u0001\u0010\u0001B)\b\u0016\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010u\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\u0007\u0010\u0001\u001a\u00020\u000b¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001b\u0010\u0017J%\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J1\u0010#\u001a\u00020\u00042\n\u0010\"\u001a\u00020!\"\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b#\u0010$J%\u0010%\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b%\u0010 J1\u0010&\u001a\u00020\u00042\n\u0010\"\u001a\u00020!\"\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b&\u0010$J\u0019\u0010'\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b'\u0010\u0017J%\u0010(\u001a\u00020\u00042\n\u0010\"\u001a\u00020!\"\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020!2\u0006\u0010,\u001a\u00020\u000bH\u0014¢\u0006\u0004\b-\u0010.J+\u00104\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u0010+J\u0019\u00108\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b8\u00109J\u001f\u0010<\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u000bH\u0016¢\u0006\u0004\b>\u0010\u0014J\u0017\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u000202H\u0014¢\u0006\u0004\bA\u0010BJ\u0017\u0010A\u001a\u00020@2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bA\u0010EJ\u000f\u0010G\u001a\u00020FH\u0014¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u00022\u0006\u00103\u001a\u000202H\u0014¢\u0006\u0004\bI\u0010JJ-\u0010N\u001a\u00020\u0004\"\b\b\u0000\u0010K*\u00020/2\u0006\u00107\u001a\u00028\u00002\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000L¢\u0006\u0004\bN\u0010OJ\u0017\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u000bH\u0016¢\u0006\u0004\bQ\u0010\u0014J\u000f\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\u0019\u0010V\u001a\u00020\u00042\b\u0010U\u001a\u0004\u0018\u00010RH\u0016¢\u0006\u0004\bV\u0010WJ;\u0010X\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00072\n\u0010\"\u001a\u00020!\"\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\bX\u0010YJ/\u0010Z\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\\\u0010+J\u000f\u0010]\u001a\u00020\u0004H\u0002¢\u0006\u0004\b]\u0010+R\u0016\u0010`\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010aR\u0016\u0010e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010dR$\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010dR\u0018\u0010o\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\"\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020u0t0s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010z\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\by\u0010nR\u001e\u0010}\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010~\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010nR:\u0010\u0001\u001a#\u0012\u001f\u0012\u001d\u0012\u0005\u0012\u00030\u0001\u0012\u0011\u0012\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0L0\u00010\u000108\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0017\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b]\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/lib/design/component_container/ComponentContainer;", "Landroid/widget/LinearLayout;", "", "enabled", "", "setEnabled", "(Z)V", "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "getState", "()Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setComponentsResetListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setContainerResetListener", "(Lkotlin/jvm/functions/Function0;)V", "titleRes", "setTitle", "(I)V", "", "title", "(Ljava/lang/CharSequence;)V", "subtitleRes", "setSubtitle", MessengerShareContentUtility.SUBTITLE, "setMessage", "message", "Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;", "resetCondition", "showErrorForAll", "(Ljava/lang/CharSequence;Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;)V", "", "viewsId", "showError", "([ILjava/lang/CharSequence;Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;)V", "showWarningForAll", "showWarning", "showNormalForAll", "showNormal", "([ILjava/lang/CharSequence;)V", "resetAll", "()V", "extraSpace", "onCreateDrawableState", "(I)[I", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "removeAllViews", "view", "removeView", "(Landroid/view/View;)V", Tracker.Events.CREATIVE_START, "count", "removeViews", "(II)V", "removeViewAt", "layoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "generateLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Landroid/widget/LinearLayout$LayoutParams;", "Landroid/util/AttributeSet;", "attrs", "(Landroid/util/AttributeSet;)Landroid/widget/LinearLayout$LayoutParams;", "Lcom/avito/android/lib/design/component_container/ComponentContainer$LayoutParams;", "generateDefaultLayoutParams", "()Lcom/avito/android/lib/design/component_container/ComponentContainer$LayoutParams;", "checkLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)Z", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "targetBehavior", "changeBehavior", "(Landroid/view/View;Lcom/avito/android/lib/design/component_container/ComponentBehavior;)V", "orientation", "setOrientation", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", AuthSource.SEND_ABUSE, "(Lcom/avito/android/lib/design/component_container/ComponentContainer$State;[ILjava/lang/CharSequence;Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;)V", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/lib/design/component_container/ComponentContainer$State;Ljava/lang/CharSequence;Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;)V", "d", "e", "j", "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "currentState", "Landroid/widget/LinearLayout;", "contentContainer", AuthSource.OPEN_CHANNEL_LIST, "I", "titleMarginBottom", "k", "contentMarginTop", "h", "Lkotlin/jvm/functions/Function1;", "componentsResetListener", "l", "contentMarginBottom", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "subtitleView", "f", "Ljava/lang/CharSequence;", "defaultMessage", "", "Ljava/lang/Class;", "Landroid/content/Context;", "n", "[Ljava/lang/Class;", "CONSTRUCTOR_PARAMS", "c", "messageView", "i", "Lkotlin/jvm/functions/Function0;", "containerResetListener", "titleView", "Ljava/lang/ThreadLocal;", "", "", "Ljava/lang/reflect/Constructor;", a2.g.r.g.a, "Ljava/lang/ThreadLocal;", "behaviorConstructors", "Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Condition", "LayoutParams", "SavedState", "State", "components_release"}, k = 1, mv = {1, 4, 2})
public class ComponentContainer extends LinearLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    public LinearLayout d;
    public Condition e;
    public CharSequence f;
    public final ThreadLocal<Map<String, Constructor<ComponentBehavior<View>>>> g;
    public Function1<? super Integer, Unit> h;
    public Function0<Unit> i;
    public State j;
    public int k;
    public int l;
    public int m;
    public final Class<Context>[] n;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;", "", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "", "apply", "(Lcom/avito/android/lib/design/component_container/ComponentContainer;)V", "MANUAL", "AT_LEAST_ONE", "ALL_RESET", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Condition extends Enum<Condition> {
        public static final Condition ALL_RESET;
        public static final Condition AT_LEAST_ONE;
        public static final Condition MANUAL;
        public static final /* synthetic */ Condition[] a;

        public static final class a extends Condition {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.avito.android.lib.design.component_container.ComponentContainer.Condition
            public void apply(@NotNull ComponentContainer componentContainer) {
                Iterator<View> children;
                State state;
                Intrinsics.checkNotNullParameter(componentContainer, "container");
                LinearLayout linearLayout = componentContainer.d;
                boolean z = true;
                if (!(linearLayout == null || (children = ViewGroupsKt.getChildren(linearLayout)) == null)) {
                    while (children.hasNext()) {
                        ComponentBehavior<View> behavior = ComponentContainerKt.getBehavior(children.next());
                        if (behavior == null || (state = behavior.getState()) == null) {
                            state = State.NORMAL;
                        }
                        if (state != State.NORMAL) {
                            z = false;
                        }
                    }
                }
                if (z) {
                    Function0 function0 = componentContainer.i;
                    if (function0 != null) {
                        Unit unit = (Unit) function0.invoke();
                    }
                    componentContainer.resetAll();
                }
            }
        }

        public static final class b extends Condition {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.avito.android.lib.design.component_container.ComponentContainer.Condition
            public void apply(@NotNull ComponentContainer componentContainer) {
                Intrinsics.checkNotNullParameter(componentContainer, "container");
                Function0 function0 = componentContainer.i;
                if (function0 != null) {
                    Unit unit = (Unit) function0.invoke();
                }
                componentContainer.resetAll();
            }
        }

        public static final class c extends Condition {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.avito.android.lib.design.component_container.ComponentContainer.Condition
            public void apply(@NotNull ComponentContainer componentContainer) {
                Intrinsics.checkNotNullParameter(componentContainer, "container");
            }
        }

        static {
            c cVar = new c("MANUAL", 0);
            MANUAL = cVar;
            b bVar = new b("AT_LEAST_ONE", 1);
            AT_LEAST_ONE = bVar;
            a aVar = new a("ALL_RESET", 2);
            ALL_RESET = aVar;
            a = new Condition[]{cVar, bVar, aVar};
        }

        public Condition(String str, int i, j jVar) {
        }

        public static Condition valueOf(String str) {
            return (Condition) Enum.valueOf(Condition.class, str);
        }

        public static Condition[] values() {
            return (Condition[]) a.clone();
        }

        public abstract void apply(@NotNull ComponentContainer componentContainer);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "", "", AuthSource.SEND_ABUSE, "[I", "getIntArray", "()[I", "intArray", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getValue", "()Ljava/lang/Integer;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "NORMAL", "WARNING", "ERROR", "components_release"}, k = 1, mv = {1, 4, 2})
    public enum State {
        NORMAL(null),
        WARNING(Integer.valueOf(R.attr.state_warning)),
        ERROR(Integer.valueOf(R.attr.state_error));
        
        @NotNull
        public final int[] a;
        @Nullable
        public final Integer b;

        /* access modifiers changed from: public */
        State(Integer num) {
            this.b = num;
            this.a = num != null ? new int[]{num.intValue()} : new int[0];
        }

        @NotNull
        public final int[] getIntArray() {
            return this.a;
        }

        @Nullable
        public final Integer getValue() {
            return this.b;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<View, Boolean> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(View view) {
            int i = this.a;
            boolean z = false;
            if (i == 0) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "it");
                if (view2.getVisibility() != 8) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (i == 1) {
                View view3 = view;
                Intrinsics.checkNotNullParameter(view3, "it");
                if (view3.getVisibility() != 8) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<View, Boolean> {
        public final /* synthetic */ int[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int[] iArr) {
            super(1);
            this.a = iArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "view");
            return Boolean.valueOf(ArraysKt___ArraysKt.contains(this.a, view2.getId()));
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ComponentContainer a;
        public final /* synthetic */ View b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentContainer componentContainer, View view) {
            super(0);
            this.a = componentContainer;
            this.b = view;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Function1 function1 = this.a.h;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(Integer.valueOf(this.b.getId()));
            }
            this.a.e.apply(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ComponentContainer a;
        public final /* synthetic */ Parcelable b;

        public d(ComponentContainer componentContainer, Parcelable parcelable) {
            this.a = componentContainer;
            this.b = parcelable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.resetAll();
            ComponentContainer componentContainer = this.a;
            State currentState = ((SavedState) this.b).getCurrentState();
            String message = ((SavedState) this.b).getMessage();
            Condition resetCondition = ((SavedState) this.b).getResetCondition();
            int[] viewIds = ((SavedState) this.b).getViewIds();
            componentContainer.a(currentState, Arrays.copyOf(viewIds, viewIds.length), message, resetCondition);
        }
    }

    public static final class e extends Lambda implements Function1<View, Boolean> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "it");
            return Boolean.valueOf(view2.getId() != -1);
        }
    }

    public static final class f extends Lambda implements Function1<View, Boolean> {
        public final /* synthetic */ ComponentContainer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentContainer componentContainer) {
            super(1);
            this.a = componentContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "it");
            ComponentBehavior<View> behavior = ComponentContainerKt.getBehavior(view2);
            return Boolean.valueOf((behavior != null ? behavior.getState() : null) == this.a.j);
        }
    }

    public static final class g extends Lambda implements Function1<View, Integer> {
        public static final g a = new g();

        public g() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Integer invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "it");
            return Integer.valueOf(view2.getId());
        }
    }

    public static final class h extends Lambda implements Function1<View, Boolean> {
        public static final h a = new h();

        public h() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "it");
            return Boolean.valueOf(view2.getVisibility() != 8);
        }
    }

    public static final class i extends Lambda implements Function1<View, Boolean> {
        public final /* synthetic */ ComponentContainer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentContainer componentContainer) {
            super(1);
            this.a = componentContainer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, "it");
            return Boolean.valueOf(!Intrinsics.areEqual(view2, this.a.d));
        }
    }

    public ComponentContainer(@Nullable Context context) {
        super(context);
        this.e = Condition.MANUAL;
        this.g = new ThreadLocal<>();
        this.j = State.NORMAL;
        this.n = new Class[]{Context.class};
        c(this, null, 0, 0, 6, null);
    }

    public static void c(ComponentContainer componentContainer, AttributeSet attributeSet, int i2, int i3, int i4, Object obj) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        Integer valueOf = Integer.valueOf(i2);
        Integer num = null;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : com.avito.android.lib.design.R.attr.componentContainer;
        Integer valueOf2 = Integer.valueOf(i3);
        if (valueOf2.intValue() > 0) {
            num = valueOf2;
        }
        TypedArray obtainStyledAttributes = componentContainer.getContext().obtainStyledAttributes(attributeSet, com.avito.android.lib.design.R.styleable.ComponentContainer, intValue, num != null ? num.intValue() : com.avito.android.lib.design.R.style.Design_Widget_ComponentContainer);
        LayoutInflater.from(componentContainer.getContext()).inflate(obtainStyledAttributes.getResourceId(com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_layout, 0), (ViewGroup) componentContainer, true);
        super.setOrientation(1);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        int i5 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_titleAppearance;
        if (obtainStyledAttributes.hasValue(i5) && (textView6 = componentContainer.a) != null) {
            TextViews.setTextAppearanceCompat(textView6, obtainStyledAttributes.getResourceId(i5, 0));
        }
        int i6 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_subtitleAppearance;
        if (obtainStyledAttributes.hasValue(i6) && (textView5 = componentContainer.b) != null) {
            TextViews.setTextAppearanceCompat(textView5, obtainStyledAttributes.getResourceId(i6, 0));
        }
        int i7 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_messageAppearance;
        if (obtainStyledAttributes.hasValue(i7) && (textView4 = componentContainer.c) != null) {
            TextViews.setTextAppearanceCompat(textView4, obtainStyledAttributes.getResourceId(i7, 0));
        }
        int i8 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_titleColor;
        if (obtainStyledAttributes.hasValue(i8) && (textView3 = componentContainer.a) != null) {
            textView3.setTextColor(obtainStyledAttributes.getColorStateList(i8));
        }
        int i9 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_subtitleColor;
        if (obtainStyledAttributes.hasValue(i9) && (textView2 = componentContainer.b) != null) {
            textView2.setTextColor(obtainStyledAttributes.getColorStateList(i9));
        }
        int i10 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_messageColor;
        if (obtainStyledAttributes.hasValue(i10) && (textView = componentContainer.c) != null) {
            textView.setTextColor(obtainStyledAttributes.getColorStateList(i10));
        }
        int i11 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_contentSpacing;
        if (obtainStyledAttributes.hasValue(i11)) {
            LinearLayout linearLayout = componentContainer.d;
            if (linearLayout != null) {
                linearLayout.setShowDividers(2);
            }
            LinearLayout linearLayout2 = componentContainer.d;
            if (linearLayout2 != null) {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i11, 0);
                ShapeDrawable shapeDrawable = new ShapeDrawable();
                shapeDrawable.setIntrinsicHeight(dimensionPixelSize);
                shapeDrawable.setIntrinsicWidth(dimensionPixelSize);
                Paint paint = shapeDrawable.getPaint();
                Intrinsics.checkNotNullExpressionValue(paint, "paint");
                paint.setColor(0);
                linearLayout2.setDividerDrawable(shapeDrawable);
            }
        }
        int i12 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_contentMarginTop;
        if (obtainStyledAttributes.hasValue(i12)) {
            componentContainer.k = obtainStyledAttributes.getDimensionPixelSize(i12, 0);
        }
        int i13 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_contentMarginBottom;
        if (obtainStyledAttributes.hasValue(i13)) {
            componentContainer.l = obtainStyledAttributes.getDimensionPixelSize(i13, 0);
        }
        int i14 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_titleSpacing;
        if (obtainStyledAttributes.hasValue(i14)) {
            componentContainer.m = obtainStyledAttributes.getDimensionPixelSize(i14, 0);
        }
        int i15 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_textPaddingLeft;
        if (obtainStyledAttributes.hasValue(i15)) {
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(i15, 0);
            TextView textView7 = componentContainer.a;
            if (textView7 != null) {
                Views.changePadding$default(textView7, dimensionPixelSize2, 0, 0, 0, 14, null);
            }
            TextView textView8 = componentContainer.b;
            if (textView8 != null) {
                Views.changePadding$default(textView8, dimensionPixelSize2, 0, 0, 0, 14, null);
            }
            TextView textView9 = componentContainer.c;
            if (textView9 != null) {
                Views.changePadding$default(textView9, dimensionPixelSize2, 0, 0, 0, 14, null);
            }
        }
        int i16 = com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_textPaddingRight;
        if (obtainStyledAttributes.hasValue(i16)) {
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(i16, 0);
            TextView textView10 = componentContainer.a;
            if (textView10 != null) {
                Views.changePadding$default(textView10, 0, 0, dimensionPixelSize3, 0, 11, null);
            }
            TextView textView11 = componentContainer.b;
            if (textView11 != null) {
                Views.changePadding$default(textView11, 0, 0, dimensionPixelSize3, 0, 11, null);
            }
            TextView textView12 = componentContainer.c;
            if (textView12 != null) {
                Views.changePadding$default(textView12, 0, 0, dimensionPixelSize3, 0, 11, null);
            }
        }
        componentContainer.setTitle(obtainStyledAttributes.getString(com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_title));
        componentContainer.setSubtitle(obtainStyledAttributes.getString(com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_subtitle));
        componentContainer.setMessage(obtainStyledAttributes.getString(com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_message));
        componentContainer.setOrientation(obtainStyledAttributes.getInt(com.avito.android.lib.design.R.styleable.ComponentContainer_android_orientation, 1));
        Condition condition = (Condition) ArraysKt___ArraysKt.getOrNull(Condition.values(), obtainStyledAttributes.getInt(com.avito.android.lib.design.R.styleable.ComponentContainer_componentContainer_resetCondition, 0));
        if (condition == null) {
            condition = Condition.MANUAL;
        }
        componentContainer.e = condition;
        obtainStyledAttributes.recycle();
        componentContainer.setEnabled(componentContainer.isEnabled());
    }

    public static /* synthetic */ void showError$default(ComponentContainer componentContainer, int[] iArr, CharSequence charSequence, Condition condition, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                charSequence = null;
            }
            if ((i2 & 4) != 0) {
                condition = null;
            }
            componentContainer.showError(iArr, charSequence, condition);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
    }

    public static /* synthetic */ void showErrorForAll$default(ComponentContainer componentContainer, CharSequence charSequence, Condition condition, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = null;
            }
            if ((i2 & 2) != 0) {
                condition = null;
            }
            componentContainer.showErrorForAll(charSequence, condition);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorForAll");
    }

    public static /* synthetic */ void showNormal$default(ComponentContainer componentContainer, int[] iArr, CharSequence charSequence, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                charSequence = componentContainer.f;
            }
            componentContainer.showNormal(iArr, charSequence);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNormal");
    }

    public static /* synthetic */ void showNormalForAll$default(ComponentContainer componentContainer, CharSequence charSequence, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = componentContainer.f;
            }
            componentContainer.showNormalForAll(charSequence);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNormalForAll");
    }

    public static /* synthetic */ void showWarning$default(ComponentContainer componentContainer, int[] iArr, CharSequence charSequence, Condition condition, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                charSequence = null;
            }
            if ((i2 & 4) != 0) {
                condition = null;
            }
            componentContainer.showWarning(iArr, charSequence, condition);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showWarning");
    }

    public static /* synthetic */ void showWarningForAll$default(ComponentContainer componentContainer, CharSequence charSequence, Condition condition, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = null;
            }
            if ((i2 & 2) != 0) {
                condition = null;
            }
            componentContainer.showWarningForAll(charSequence, condition);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showWarningForAll");
    }

    public final void a(State state, int[] iArr, CharSequence charSequence, Condition condition) {
        Iterator<View> children;
        Sequence asSequence;
        Sequence<View> filter;
        resetAll();
        this.j = state;
        refreshDrawableState();
        if (condition != null) {
            this.e = condition;
        }
        LinearLayout linearLayout = this.d;
        if (!(linearLayout == null || (children = ViewGroupsKt.getChildren(linearLayout)) == null || (asSequence = SequencesKt__SequencesKt.asSequence(children)) == null || (filter = SequencesKt___SequencesKt.filter(asSequence, new b(iArr))) == null)) {
            for (View view : filter) {
                ComponentBehavior<View> behavior = ComponentContainerKt.getBehavior(view);
                if (behavior != null) {
                    behavior.setState(state);
                }
            }
        }
        TextView textView = this.c;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
        d();
        e();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(@Nullable View view, int i2, @Nullable ViewGroup.LayoutParams layoutParams) {
        ComponentBehavior<View> componentBehavior;
        ComponentBehavior<View> componentBehavior2 = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = com.avito.android.lib.design.R.id.design_container_title;
        if (valueOf != null && valueOf.intValue() == i3) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.a = (TextView) view;
            super.addView(view, i2, layoutParams);
            return;
        }
        int i4 = com.avito.android.lib.design.R.id.design_container_subtitle;
        if (valueOf != null && valueOf.intValue() == i4) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.b = (TextView) view;
            super.addView(view, i2, layoutParams);
            return;
        }
        int i5 = com.avito.android.lib.design.R.id.design_container_message;
        if (valueOf != null && valueOf.intValue() == i5) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) view;
            this.c = textView;
            if (textView != null) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            super.addView(view, i2, layoutParams);
            return;
        }
        int i6 = com.avito.android.lib.design.R.id.design_container_content;
        if (valueOf != null && valueOf.intValue() == i6) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
            this.d = (LinearLayout) view;
            super.addView(view, i2, layoutParams);
            return;
        }
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.addView(view, i2, layoutParams);
        }
        if (!(layoutParams instanceof LayoutParams)) {
            layoutParams = null;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            if (view != null) {
                if (layoutParams2.getBehavior() != null) {
                    componentBehavior2 = layoutParams2.getBehavior();
                } else {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    String behaviorClass = layoutParams2.getBehaviorClass();
                    if (behaviorClass == null || behaviorClass.length() == 0) {
                        componentBehavior = null;
                    } else {
                        try {
                            Map<String, Constructor<ComponentBehavior<View>>> map = this.g.get();
                            if (map == null) {
                                map = new LinkedHashMap<>();
                                this.g.set(map);
                            }
                            Constructor<ComponentBehavior<View>> constructor = map.get(behaviorClass);
                            if (constructor == null) {
                                Class<?> cls = Class.forName(behaviorClass, true, context.getClassLoader());
                                if (cls != 0) {
                                    Class<Context>[] clsArr = this.n;
                                    constructor = cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                                    Intrinsics.checkNotNull(constructor);
                                    constructor.setAccessible(true);
                                    map.put(behaviorClass, constructor);
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<com.avito.android.lib.design.component_container.ComponentBehavior<android.view.View>>");
                                }
                            }
                            componentBehavior = constructor.newInstance(context);
                        } catch (Exception e2) {
                            throw new RuntimeException(a2.b.a.a.a.c3("Could not inflate Behavior subclass ", behaviorClass), e2);
                        }
                    }
                    if (componentBehavior != null) {
                        componentBehavior.setAutoResetCondition(layoutParams2.getAutoReset());
                        changeBehavior(view, componentBehavior);
                        componentBehavior2 = componentBehavior;
                    }
                }
            }
            if (componentBehavior2 != null) {
                Intrinsics.checkNotNull(view);
                componentBehavior2.attach(view);
            }
        }
        if (view != null) {
            view.setEnabled(isEnabled());
        }
    }

    public final void b(State state, CharSequence charSequence, Condition condition) {
        Iterator<View> children;
        this.j = state;
        refreshDrawableState();
        if (condition != null) {
            this.e = condition;
        }
        LinearLayout linearLayout = this.d;
        if (!(linearLayout == null || (children = ViewGroupsKt.getChildren(linearLayout)) == null)) {
            while (children.hasNext()) {
                ComponentBehavior<View> behavior = ComponentContainerKt.getBehavior(children.next());
                if (behavior != null) {
                    behavior.setState(state);
                }
            }
        }
        TextView textView = this.c;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
        d();
        e();
    }

    public final <V extends View> void changeBehavior(@NotNull V v, @NotNull ComponentBehavior<V> componentBehavior) {
        Intrinsics.checkNotNullParameter(v, "view");
        Intrinsics.checkNotNullParameter(componentBehavior, "targetBehavior");
        componentBehavior.setValueResetListener(new c(this, v));
        ComponentBehavior<View> behavior = ComponentContainerKt.getBehavior(v);
        if (behavior != null) {
            behavior.setValueResetListener(null);
        }
        ComponentContainerKt.access$setBehavior$p(v, componentBehavior);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "params");
        return layoutParams instanceof LayoutParams;
    }

    public final void d() {
        LinearLayout linearLayout = this.d;
        if (linearLayout != null && linearLayout.getVisibility() != 8) {
            int indexOfChild = indexOfChild(linearLayout);
            int i2 = ((View) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.take(SequencesKt__SequencesKt.asSequence(ViewGroupsKt.getChildren(this)), indexOfChild), a.c))) != null ? this.k : 0;
            int i3 = ((View) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.drop(SequencesKt__SequencesKt.asSequence(ViewGroupsKt.getChildren(this)), indexOfChild + 1), a.b))) != null ? this.l : 0;
            if (linearLayout.getPaddingTop() != i2 || linearLayout.getPaddingBottom() != i3) {
                Views.changePadding$default(linearLayout, 0, i2, 0, i3, 5, null);
            }
        }
    }

    public final void e() {
        TextView textView = this.a;
        if (textView != null && textView.getVisibility() != 8) {
            int i2 = ((View) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.drop(SequencesKt__SequencesKt.asSequence(ViewGroupsKt.getChildren(this)), indexOfChild(textView) + 1), h.a), new i(this)))) != null ? this.m : 0;
            if (textView.getPaddingBottom() != i2) {
                Views.changePadding$default(textView, 0, 0, 0, i2, 7, null);
            }
        }
    }

    @NotNull
    public final State getState() {
        return this.j;
    }

    @Override // android.view.View, android.view.ViewGroup
    @NotNull
    public int[] onCreateDrawableState(int i2) {
        int[] mergeDrawableStates = View.mergeDrawableStates(super.onCreateDrawableState(i2 + this.j.getIntArray().length), this.j.getIntArray());
        Intrinsics.checkNotNullExpressionValue(mergeDrawableStates, "View.mergeDrawableStates…s, currentState.intArray)");
        return mergeDrawableStates;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            super.onRestoreInstanceState(((SavedState) parcelable).getSuperState());
            post(new d(this, parcelable));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        int[] iArr;
        Iterator<View> children;
        Sequence asSequence;
        Sequence filter;
        Sequence filter2;
        Sequence map;
        List list;
        CharSequence text;
        State state = this.j;
        Condition condition = this.e;
        TextView textView = this.c;
        String str = null;
        if (textView != null) {
            if (!Views.isVisible(textView)) {
                textView = null;
            }
            if (!(textView == null || (text = textView.getText()) == null)) {
                str = text.toString();
            }
        }
        LinearLayout linearLayout = this.d;
        if (linearLayout == null || (children = ViewGroupsKt.getChildren(linearLayout)) == null || (asSequence = SequencesKt__SequencesKt.asSequence(children)) == null || (filter = SequencesKt___SequencesKt.filter(asSequence, e.a)) == null || (filter2 = SequencesKt___SequencesKt.filter(filter, new f(this))) == null || (map = SequencesKt___SequencesKt.map(filter2, g.a)) == null || (list = SequencesKt___SequencesKt.toList(map)) == null || (iArr = CollectionsKt___CollectionsKt.toIntArray(list)) == null) {
            iArr = new int[0];
        }
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        return new SavedState(state, condition, str, iArr, onSaveInstanceState);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Iterator<View> children;
        LinearLayout linearLayout = this.d;
        if (!(linearLayout == null || (children = ViewGroupsKt.getChildren(linearLayout)) == null)) {
            while (children.hasNext()) {
                ComponentBehavior<View> behavior = ComponentContainerKt.getBehavior(children.next());
                if (behavior != null) {
                    behavior.detach();
                }
            }
        }
        LinearLayout linearLayout2 = this.d;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@Nullable View view) {
        ComponentBehavior<View> behavior;
        if (!(view == null || (behavior = ComponentContainerKt.getBehavior(view)) == null)) {
            behavior.detach();
        }
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        View childAt;
        ComponentBehavior<View> behavior;
        LinearLayout linearLayout = this.d;
        if (!(linearLayout == null || (childAt = linearLayout.getChildAt(i2)) == null || (behavior = ComponentContainerKt.getBehavior(childAt)) == null)) {
            behavior.detach();
        }
        LinearLayout linearLayout2 = this.d;
        if (linearLayout2 != null) {
            linearLayout2.removeViewAt(i2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        View childAt;
        ComponentBehavior<View> behavior;
        Iterator it = new IntRange(i2, i2 + i3).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            LinearLayout linearLayout = this.d;
            if (!(linearLayout == null || (childAt = linearLayout.getChildAt(nextInt)) == null || (behavior = ComponentContainerKt.getBehavior(childAt)) == null)) {
                behavior.detach();
            }
        }
        LinearLayout linearLayout2 = this.d;
        if (linearLayout2 != null) {
            linearLayout2.removeViews(i2, i3);
        }
    }

    public final void resetAll() {
        Iterator<View> children;
        State state = State.NORMAL;
        this.j = state;
        refreshDrawableState();
        LinearLayout linearLayout = this.d;
        if (!(linearLayout == null || (children = ViewGroupsKt.getChildren(linearLayout)) == null)) {
            while (children.hasNext()) {
                ComponentBehavior<View> behavior = ComponentContainerKt.getBehavior(children.next());
                if (behavior != null) {
                    behavior.setState(state);
                }
            }
        }
        TextView textView = this.c;
        if (textView != null) {
            TextViews.bindText$default(textView, this.f, false, 2, null);
        }
    }

    public final void setComponentsResetListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.h = function1;
    }

    public final void setContainerResetListener(@Nullable Function0<Unit> function0) {
        this.i = function0;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Iterator<View> children;
        super.setEnabled(z);
        LinearLayout linearLayout = this.d;
        if (linearLayout != null && (children = ViewGroupsKt.getChildren(linearLayout)) != null) {
            while (children.hasNext()) {
                children.next().setEnabled(z);
            }
        }
    }

    public final void setMessage(@StringRes int i2) {
        setMessage(getContext().getString(i2));
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.setOrientation(i2);
        }
    }

    public final void setSubtitle(@StringRes int i2) {
        setSubtitle(getContext().getString(i2));
    }

    public final void setTitle(@StringRes int i2) {
        setTitle(getContext().getString(i2));
    }

    public final void showError(@NotNull int[] iArr, @Nullable CharSequence charSequence, @Nullable Condition condition) {
        Intrinsics.checkNotNullParameter(iArr, "viewsId");
        a(State.ERROR, Arrays.copyOf(iArr, iArr.length), charSequence, condition);
    }

    public final void showErrorForAll(@Nullable CharSequence charSequence, @Nullable Condition condition) {
        b(State.ERROR, charSequence, condition);
    }

    public final void showNormal(@NotNull int[] iArr, @Nullable CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(iArr, "viewsId");
        a(State.NORMAL, Arrays.copyOf(iArr, iArr.length), charSequence, null);
    }

    public final void showNormalForAll(@Nullable CharSequence charSequence) {
        b(State.NORMAL, charSequence, null);
    }

    public final void showWarning(@NotNull int[] iArr, @Nullable CharSequence charSequence, @Nullable Condition condition) {
        Intrinsics.checkNotNullParameter(iArr, "viewsId");
        a(State.WARNING, Arrays.copyOf(iArr, iArr.length), charSequence, condition);
    }

    public final void showWarningForAll(@Nullable CharSequence charSequence, @Nullable Condition condition) {
        b(State.WARNING, charSequence, condition);
    }

    public final void setMessage(@Nullable CharSequence charSequence) {
        this.f = charSequence;
        TextView textView = this.c;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
        d();
        e();
    }

    public final void setSubtitle(@Nullable CharSequence charSequence) {
        TextView textView = this.b;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
        d();
        e();
    }

    public final void setTitle(@Nullable CharSequence charSequence) {
        TextView textView = this.a;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
        d();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    @NotNull
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    @NotNull
    public LinearLayout.LayoutParams generateLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        return new LayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    @NotNull
    public LinearLayout.LayoutParams generateLayoutParams(@NotNull AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new LayoutParams(context, attributeSet);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#B\u0019\b\u0016\u0012\u0006\u0010$\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\u000e¢\u0006\u0004\b\"\u0010&B!\b\u0016\u0012\u0006\u0010$\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\u000e\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b\"\u0010)B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b\"\u0010,B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020-¢\u0006\u0004\b\"\u0010.B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020\u0001¢\u0006\u0004\b\"\u0010/J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00060"}, d2 = {"Lcom/avito/android/lib/design/component_container/ComponentContainer$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "Landroid/view/View;", "c", "Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "getBehavior", "()Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "setBehavior", "(Lcom/avito/android/lib/design/component_container/ComponentBehavior;)V", "behavior", "", AuthSource.BOOKING_ORDER, "I", "getAutoReset", "()I", "setAutoReset", "(I)V", "autoReset", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getBehaviorClass", "()Ljava/lang/String;", "setBehaviorClass", "(Ljava/lang/String;)V", "behaviorClass", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(II)V", "", "weight", "(IIF)V", "Landroid/view/ViewGroup$LayoutParams;", "source", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Landroid/widget/LinearLayout$LayoutParams;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class LayoutParams extends LinearLayout.LayoutParams {
        @Nullable
        public String a;
        public int b;
        @Nullable
        public ComponentBehavior<View> c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull Context context, @NotNull AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.avito.android.lib.design.R.styleable.ComponentContainer_Layout);
            this.a = obtainStyledAttributes.getString(com.avito.android.lib.design.R.styleable.ComponentContainer_Layout_layout_behaviorClass);
            this.b = obtainStyledAttributes.getInt(com.avito.android.lib.design.R.styleable.ComponentContainer_Layout_layout_autoReset, 0);
            obtainStyledAttributes.recycle();
        }

        public final int getAutoReset() {
            return this.b;
        }

        @Nullable
        public final ComponentBehavior<View> getBehavior() {
            return this.c;
        }

        @Nullable
        public final String getBehaviorClass() {
            return this.a;
        }

        @NotNull
        public final Parcelable onSaveInstanceState() {
            return new Bundle();
        }

        public final void setAutoReset(int i) {
            this.b = i;
        }

        public final void setBehavior(@Nullable ComponentBehavior<View> componentBehavior) {
            this.c = componentBehavior;
        }

        public final void setBehaviorClass(@Nullable String str) {
            this.a = str;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Intrinsics.checkNotNullParameter(layoutParams, "source");
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.c = layoutParams2.c;
                this.a = layoutParams2.a;
                this.b = layoutParams2.b;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Intrinsics.checkNotNullParameter(marginLayoutParams, "source");
            if (marginLayoutParams instanceof LayoutParams) {
                LayoutParams layoutParams = (LayoutParams) marginLayoutParams;
                this.c = layoutParams.c;
                this.a = layoutParams.a;
                this.b = layoutParams.b;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NotNull LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            Intrinsics.checkNotNullParameter(layoutParams, "source");
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.c = layoutParams2.c;
                this.a = layoutParams2.a;
                this.b = layoutParams2.b;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#B3\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b\"\u0010&J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/avito/android/lib/design/component_container/ComponentContainer$SavedState;", "Landroid/view/AbsSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "getCurrentState", "()Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "currentState", "", "d", "[I", "getViewIds", "()[I", "viewIds", "", "c", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;", "getResetCondition", "()Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;", "resetCondition", "parcel", "<init>", "(Landroid/os/Parcel;)V", "Landroid/os/Parcelable;", "superState", "(Lcom/avito/android/lib/design/component_container/ComponentContainer$State;Lcom/avito/android/lib/design/component_container/ComponentContainer$Condition;Ljava/lang/String;[ILandroid/os/Parcelable;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends AbsSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final State a;
        @NotNull
        public final Condition b;
        @Nullable
        public final String c;
        @NotNull
        public final int[] d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/component_container/ComponentContainer$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/lib/design/component_container/ComponentContainer$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SavedState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.a = (State) ParcelsKt.readEnum(parcel, State.values());
            this.b = (Condition) ParcelsKt.readEnum(parcel, Condition.values());
            this.c = parcel.readString();
            int[] createIntArray = parcel.createIntArray();
            this.d = createIntArray == null ? new int[0] : createIntArray;
        }

        @NotNull
        public final State getCurrentState() {
            return this.a;
        }

        @Nullable
        public final String getMessage() {
            return this.c;
        }

        @NotNull
        public final Condition getResetCondition() {
            return this.b;
        }

        @NotNull
        public final int[] getViewIds() {
            return this.d;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@Nullable Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            if (parcel != null) {
                ParcelsKt.writeEnum(parcel, this.a);
                ParcelsKt.writeEnum(parcel, this.b);
                parcel.writeString(this.c);
                parcel.writeIntArray(this.d);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull State state, @NotNull Condition condition, @Nullable String str, @NotNull int[] iArr, @NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(state, "currentState");
            Intrinsics.checkNotNullParameter(condition, "resetCondition");
            Intrinsics.checkNotNullParameter(iArr, "viewIds");
            Intrinsics.checkNotNullParameter(parcelable, "superState");
            this.a = state;
            this.b = condition;
            this.c = str;
            this.d = iArr;
        }
    }

    public ComponentContainer(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = Condition.MANUAL;
        this.g = new ThreadLocal<>();
        this.j = State.NORMAL;
        this.n = new Class[]{Context.class};
        c(this, attributeSet, 0, 0, 6, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ComponentContainer(@org.jetbrains.annotations.Nullable android.content.Context r11, @org.jetbrains.annotations.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            int r1 = r0.intValue()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L_0x000e
            r1 = 1
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            if (r1 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            if (r0 == 0) goto L_0x001a
            int r0 = r0.intValue()
            goto L_0x001c
        L_0x001a:
            int r0 = com.avito.android.lib.design.R.attr.componentContainer
        L_0x001c:
            r10.<init>(r11, r12, r0)
            com.avito.android.lib.design.component_container.ComponentContainer$Condition r11 = com.avito.android.lib.design.component_container.ComponentContainer.Condition.MANUAL
            r10.e = r11
            java.lang.ThreadLocal r11 = new java.lang.ThreadLocal
            r11.<init>()
            r10.g = r11
            com.avito.android.lib.design.component_container.ComponentContainer$State r11 = com.avito.android.lib.design.component_container.ComponentContainer.State.NORMAL
            r10.j = r11
            java.lang.Class[] r11 = new java.lang.Class[r2]
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r11[r3] = r0
            r10.n = r11
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r10
            r5 = r12
            r6 = r13
            c(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.component_container.ComponentContainer.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
