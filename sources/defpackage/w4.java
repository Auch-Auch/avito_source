package defpackage;

import a2.a.a.o1.d.a0.m.h;
import android.view.View;
import com.jakewharton.rxrelay2.Relay;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: w4  reason: default package */
public final class w4 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w4(int i, Object obj, Object obj2) {
        super(1);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(view, "it");
            Relay relay = ((h) this.b).a.i;
            Unit unit = Unit.INSTANCE;
            relay.accept(unit);
            return unit;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(view, "it");
            Relay<Unit> attachItemClicks = ((h) this.b).a.getAttachItemClicks();
            Unit unit2 = Unit.INSTANCE;
            attachItemClicks.accept(unit2);
            return unit2;
        } else if (i == 2) {
            Intrinsics.checkNotNullParameter(view, "it");
            Relay<Unit> attachFileClicks = ((h) this.b).a.getAttachFileClicks();
            Unit unit3 = Unit.INSTANCE;
            attachFileClicks.accept(unit3);
            return unit3;
        } else if (i == 3) {
            Intrinsics.checkNotNullParameter(view, "it");
            Relay<Unit> sendLocationClicks = ((h) this.b).a.getSendLocationClicks();
            Unit unit4 = Unit.INSTANCE;
            sendLocationClicks.accept(unit4);
            return unit4;
        } else {
            throw null;
        }
    }
}
