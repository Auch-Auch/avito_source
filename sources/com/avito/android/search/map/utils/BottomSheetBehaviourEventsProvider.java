package com.avito.android.search.map.utils;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "Lio/reactivex/rxjava3/core/Observable;", "", "panelStateChanges", "()Lio/reactivex/rxjava3/core/Observable;", "", "panelSlideOffsetChanges", "Landroid/view/View;", "bottomSheet", "slideOffset", "", "onSlide", "(Landroid/view/View;F)V", "", "newState", "onStateChanged", "(Landroid/view/View;I)V", "c", "I", "previousState", "Lcom/jakewharton/rxrelay3/Relay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/Relay;", "stateRelay", AuthSource.BOOKING_ORDER, "slideOffsetRelay", "<init>", "()V", "Companion", "map_release"}, k = 1, mv = {1, 4, 2})
public final class BottomSheetBehaviourEventsProvider extends BottomSheetBehavior.BottomSheetCallback {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final float MAX_OFFSET = 1.0f;
    public static final float MID_OFFSET = 0.0f;
    public static final float MIN_OFFSET = -1.0f;
    public final Relay<String> a;
    public final Relay<Float> b;
    public int c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider$Companion;", "", "", "MAX_OFFSET", "F", "MID_OFFSET", "MIN_OFFSET", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<Float, Float> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Float apply(Float f) {
            Float f2 = f;
            if (f2.floatValue() > 1.0f) {
                return Float.valueOf(1.0f);
            }
            return f2.floatValue() < -1.0f ? Float.valueOf(-1.0f) : f2;
        }
    }

    public BottomSheetBehaviourEventsProvider() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.b = create2;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onSlide(@NotNull View view, float f) {
        Intrinsics.checkNotNullParameter(view, "bottomSheet");
        this.b.accept(Float.valueOf(f));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r7 == 3) goto L_0x0028;
     */
    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStateChanged(@org.jetbrains.annotations.NotNull android.view.View r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "bottomSheet"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r6 = 0
            r0 = 1
            if (r7 != r0) goto L_0x000c
            r5.c = r0
            goto L_0x0032
        L_0x000c:
            int r1 = r5.c
            java.lang.String r2 = "expanded"
            r3 = 3
            r4 = 2
            if (r1 == r0) goto L_0x002a
            if (r1 != 0) goto L_0x0017
            goto L_0x002a
        L_0x0017:
            if (r1 != r4) goto L_0x0032
            if (r7 == r3) goto L_0x0028
            r0 = 4
            if (r7 == r0) goto L_0x0025
            r0 = 5
            if (r7 == r0) goto L_0x0022
            goto L_0x0032
        L_0x0022:
            java.lang.String r6 = "hidden"
            goto L_0x0032
        L_0x0025:
            java.lang.String r6 = "collapsed"
            goto L_0x0032
        L_0x0028:
            r6 = r2
            goto L_0x0032
        L_0x002a:
            if (r7 != r4) goto L_0x002f
            r5.c = r4
            goto L_0x0032
        L_0x002f:
            if (r7 != r3) goto L_0x0032
            goto L_0x0028
        L_0x0032:
            if (r6 == 0) goto L_0x003c
            r7 = 0
            r5.c = r7
            com.jakewharton.rxrelay3.Relay<java.lang.String> r7 = r5.a
            r7.accept(r6)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.utils.BottomSheetBehaviourEventsProvider.onStateChanged(android.view.View, int):void");
    }

    @NotNull
    public final Observable<Float> panelSlideOffsetChanges() {
        Observable<R> map = this.b.map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "slideOffsetRelay\n       …          }\n            }");
        return map;
    }

    @NotNull
    public final Observable<String> panelStateChanges() {
        return this.a;
    }
}
