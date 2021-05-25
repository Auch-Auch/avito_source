package io.reactivex.rxkotlin;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b7\u00108Jh\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00028\u00020\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bH\b¢\u0006\u0004\b\u000b\u0010\fJ]\u0010\u000b\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \n*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r0\r0\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\u000eJ\u0001\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00038\u00030\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052 \b\u0004\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0011H\b¢\u0006\u0004\b\u000b\u0010\u0012J}\u0010\u000b\u001a4\u00120\u0012.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \n*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00130\u00130\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\u0014J\u0001\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00048\u00040\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052&\b\u0004\u0010\t\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0017H\b¢\u0006\u0004\b\u000b\u0010\u0018J¶\u0001\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00058\u00050\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052,\b\u0004\u0010\t\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001bH\b¢\u0006\u0004\b\u000b\u0010\u001cJÐ\u0001\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00068\u00060\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u001d\"\u0004\b\u0006\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00050\u000522\b\u0004\u0010\t\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u001fH\b¢\u0006\u0004\b\u000b\u0010 Jê\u0001\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00078\u00070\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u001d\"\u0004\b\u0006\u0010!\"\u0004\b\u0007\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00060\u000528\b\u0004\u0010\t\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070#H\b¢\u0006\u0004\b\u000b\u0010$J\u0002\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\b8\b0\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u001d\"\u0004\b\u0006\u0010!\"\u0004\b\u0007\u0010%\"\u0004\b\b\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052>\b\u0004\u0010\t\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0'H\b¢\u0006\u0004\b\u000b\u0010(J\u0002\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\t8\t0\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u001d\"\u0004\b\u0006\u0010!\"\u0004\b\u0007\u0010%\"\u0004\b\b\u0010)\"\u0004\b\t\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\b0\u00052D\b\u0004\u0010\t\u001a>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0+H\b¢\u0006\u0004\b\u000b\u0010,JH\u00104\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00008\u00000\u0005\"\u0004\b\u0000\u0010-2\u0006\u0010/\u001a\u00020.2\u001a\b\u0004\u00103\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000001\u0012\u0004\u0012\u00020200H\b¢\u0006\u0004\b4\u00105Jh\u00106\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00028\u00020\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bH\b¢\u0006\u0004\b6\u0010\fJ]\u00106\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \n*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r0\r0\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b6\u0010\u000eJ\u0001\u00106\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00038\u00030\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052 \b\u0004\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0011H\b¢\u0006\u0004\b6\u0010\u0012J}\u00106\u001a4\u00120\u0012.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \n*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00130\u00130\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0007¢\u0006\u0004\b6\u0010\u0014J\u0001\u00106\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00048\u00040\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052&\b\u0004\u0010\t\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0017H\b¢\u0006\u0004\b6\u0010\u0018J¶\u0001\u00106\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00058\u00050\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052,\b\u0004\u0010\t\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001bH\b¢\u0006\u0004\b6\u0010\u001cJÐ\u0001\u00106\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00068\u00060\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u001d\"\u0004\b\u0006\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00050\u000522\b\u0004\u0010\t\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u001fH\b¢\u0006\u0004\b6\u0010 Jê\u0001\u00106\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00078\u00070\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u001d\"\u0004\b\u0006\u0010!\"\u0004\b\u0007\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00060\u000528\b\u0004\u0010\t\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070#H\b¢\u0006\u0004\b6\u0010$J\u0002\u00106\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\b8\b0\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u001d\"\u0004\b\u0006\u0010!\"\u0004\b\u0007\u0010%\"\u0004\b\b\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052>\b\u0004\u0010\t\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0'H\b¢\u0006\u0004\b6\u0010(J\u0002\u00106\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\t8\t0\u0005\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0019\"\u0004\b\u0005\u0010\u001d\"\u0004\b\u0006\u0010!\"\u0004\b\u0007\u0010%\"\u0004\b\b\u0010)\"\u0004\b\t\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\b0\u00052D\b\u0004\u0010\t\u001a>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0+H\b¢\u0006\u0004\b6\u0010,¨\u00069"}, d2 = {"Lio/reactivex/rxkotlin/Flowables;", "", "T1", "T2", "R", "Lio/reactivex/Flowable;", "source1", "source2", "Lkotlin/Function2;", "combineFunction", "kotlin.jvm.PlatformType", "combineLatest", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Flowable;", "Lkotlin/Pair;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", "T3", "source3", "Lkotlin/Function3;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function3;)Lio/reactivex/Flowable;", "Lkotlin/Triple;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", "T4", "source4", "Lkotlin/Function4;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function4;)Lio/reactivex/Flowable;", "T5", "source5", "Lkotlin/Function5;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function5;)Lio/reactivex/Flowable;", "T6", "source6", "Lkotlin/Function6;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function6;)Lio/reactivex/Flowable;", "T7", "source7", "Lkotlin/Function7;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function7;)Lio/reactivex/Flowable;", "T8", "source8", "Lkotlin/Function8;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function8;)Lio/reactivex/Flowable;", "T9", "source9", "Lkotlin/Function9;", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lio/reactivex/Flowable;Lkotlin/jvm/functions/Function9;)Lio/reactivex/Flowable;", "T", "Lio/reactivex/BackpressureStrategy;", "mode", "Lkotlin/Function1;", "Lio/reactivex/FlowableEmitter;", "", "source", "create", "(Lio/reactivex/BackpressureStrategy;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Flowable;", "zip", "<init>", "()V", "rxkotlin"}, k = 1, mv = {1, 4, 0})
public final class Flowables {
    public static final Flowables INSTANCE = new Flowables();

    public static final class a<T1, T2, R> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
        public static final a a = new a();

        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return TuplesKt.to(obj, obj2);
        }
    }

    public static final class b<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return new Triple(obj, obj2, obj3);
        }
    }

    public static final class c<T1, T2, R> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
        public static final c a = new c();

        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return TuplesKt.to(obj, obj2);
        }
    }

    public static final class d<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
        public static final d a = new d();

        @Override // io.reactivex.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return new Triple(obj, obj2, obj3);
        }
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, R> Flowable<R> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, new BiFunction<T1, T2, R>(function2) { // from class: io.reactivex.rxkotlin.Flowables$combineLatest$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(T1 t1, T2 t2) {
                return (R) this.a.invoke(t1, t2);
            }
        });
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <T> Flowable<T> create(@NotNull BackpressureStrategy backpressureStrategy, @NotNull Function1<? super FlowableEmitter<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(backpressureStrategy, "mode");
        Intrinsics.checkParameterIsNotNull(function1, "source");
        Flowable<T> create = Flowable.create(new FlowableOnSubscribe<T>(function1) { // from class: io.reactivex.rxkotlin.Flowables$create$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(@NotNull FlowableEmitter<T> flowableEmitter) {
                Intrinsics.checkParameterIsNotNull(flowableEmitter, "it");
                this.a.invoke(flowableEmitter);
            }
        }, backpressureStrategy);
        if (create == null) {
            Intrinsics.throwNpe();
        }
        return create;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, R> Flowable<R> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        Flowable<R> zip = Flowable.zip(flowable, flowable2, new BiFunction<T1, T2, R>(function2) { // from class: io.reactivex.rxkotlin.Flowables$zip$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(T1 t1, T2 t2) {
                return (R) this.a.invoke(t1, t2);
            }
        });
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2> Flowable<Pair<T1, T2>> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Flowable<Pair<T1, T2>> combineLatest = Flowable.combineLatest(flowable, flowable2, a.a);
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2> Flowable<Pair<T1, T2>> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Flowable<Pair<T1, T2>> zip = Flowable.zip(flowable, flowable2, c.a);
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, R> Flowable<R> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, new Function3<T1, T2, T3, R>(function3) { // from class: io.reactivex.rxkotlin.Flowables$combineLatest$3
            public final /* synthetic */ kotlin.jvm.functions.Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function3
            public final R apply(T1 t1, T2 t2, T3 t3) {
                return (R) this.a.invoke(t1, t2, t3);
            }
        });
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, R> Flowable<R> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        Flowable<R> zip = Flowable.zip(flowable, flowable2, flowable3, new Function3<T1, T2, T3, R>(function3) { // from class: io.reactivex.rxkotlin.Flowables$zip$3
            public final /* synthetic */ kotlin.jvm.functions.Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function3
            public final R apply(T1 t1, T2 t2, T3 t3) {
                return (R) this.a.invoke(t1, t2, t3);
            }
        });
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3> Flowable<Triple<T1, T2, T3>> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Flowable<Triple<T1, T2, T3>> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, b.a);
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3> Flowable<Triple<T1, T2, T3>> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Flowable<Triple<T1, T2, T3>> zip = Flowable.zip(flowable, flowable2, flowable3, d.a);
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Flowable<R> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, flowable4, new io.reactivex.functions.Function4<T1, T2, T3, T4, R>(function4) { // from class: io.reactivex.rxkotlin.Flowables$combineLatest$5
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function4
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                return (R) this.a.invoke(t1, t2, t3, t4);
            }
        });
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Flowable<R> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        Flowable<R> zip = Flowable.zip(flowable, flowable2, flowable3, flowable4, new io.reactivex.functions.Function4<T1, T2, T3, T4, R>(function4) { // from class: io.reactivex.rxkotlin.Flowables$zip$5
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function4
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
                return (R) this.a.invoke(t1, t2, t3, t4);
            }
        });
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Flowable<R> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, flowable4, flowable5, new io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R>(function5) { // from class: io.reactivex.rxkotlin.Flowables$combineLatest$6
            public final /* synthetic */ Function5 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function5
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5);
            }
        });
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, R> Flowable<R> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        Flowable<R> zip = Flowable.zip(flowable, flowable2, flowable3, flowable4, flowable5, new io.reactivex.functions.Function5<T1, T2, T3, T4, T5, R>(function5) { // from class: io.reactivex.rxkotlin.Flowables$zip$6
            public final /* synthetic */ Function5 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function5
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5);
            }
        });
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Flowable<R> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Flowable<T6> flowable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(flowable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, flowable4, flowable5, flowable6, new io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R>(function6) { // from class: io.reactivex.rxkotlin.Flowables$combineLatest$7
            public final /* synthetic */ Function6 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function6
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62);
            }
        });
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, R> Flowable<R> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Flowable<T6> flowable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(flowable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        Flowable<R> zip = Flowable.zip(flowable, flowable2, flowable3, flowable4, flowable5, flowable6, new io.reactivex.functions.Function6<T1, T2, T3, T4, T5, T6, R>(function6) { // from class: io.reactivex.rxkotlin.Flowables$zip$7
            public final /* synthetic */ Function6 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function6
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62);
            }
        });
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Flowable<T6> flowable6, @NotNull Flowable<T7> flowable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(flowable6, "source6");
        Intrinsics.checkParameterIsNotNull(flowable7, "source7");
        Intrinsics.checkParameterIsNotNull(function7, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, flowable4, flowable5, flowable6, flowable7, new io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>(function7) { // from class: io.reactivex.rxkotlin.Flowables$combineLatest$8
            public final /* synthetic */ Function7 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function7
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7);
            }
        });
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Flowable<T6> flowable6, @NotNull Flowable<T7> flowable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(flowable6, "source6");
        Intrinsics.checkParameterIsNotNull(flowable7, "source7");
        Intrinsics.checkParameterIsNotNull(function7, "combineFunction");
        Flowable<R> zip = Flowable.zip(flowable, flowable2, flowable3, flowable4, flowable5, flowable6, flowable7, new io.reactivex.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>(function7) { // from class: io.reactivex.rxkotlin.Flowables$zip$8
            public final /* synthetic */ Function7 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function7
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7);
            }
        });
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Flowable<T6> flowable6, @NotNull Flowable<T7> flowable7, @NotNull Flowable<T8> flowable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(flowable6, "source6");
        Intrinsics.checkParameterIsNotNull(flowable7, "source7");
        Intrinsics.checkParameterIsNotNull(flowable8, "source8");
        Intrinsics.checkParameterIsNotNull(function8, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, flowable4, flowable5, flowable6, flowable7, flowable8, new io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>(function8) { // from class: io.reactivex.rxkotlin.Flowables$combineLatest$9
            public final /* synthetic */ Function8 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function8
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8);
            }
        });
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Flowable<T6> flowable6, @NotNull Flowable<T7> flowable7, @NotNull Flowable<T8> flowable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(flowable6, "source6");
        Intrinsics.checkParameterIsNotNull(flowable7, "source7");
        Intrinsics.checkParameterIsNotNull(flowable8, "source8");
        Intrinsics.checkParameterIsNotNull(function8, "combineFunction");
        Flowable<R> zip = Flowable.zip(flowable, flowable2, flowable3, flowable4, flowable5, flowable6, flowable7, flowable8, new io.reactivex.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>(function8) { // from class: io.reactivex.rxkotlin.Flowables$zip$9
            public final /* synthetic */ Function8 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function8
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8);
            }
        });
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> combineLatest(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Flowable<T6> flowable6, @NotNull Flowable<T7> flowable7, @NotNull Flowable<T8> flowable8, @NotNull Flowable<T9> flowable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(flowable6, "source6");
        Intrinsics.checkParameterIsNotNull(flowable7, "source7");
        Intrinsics.checkParameterIsNotNull(flowable8, "source8");
        Intrinsics.checkParameterIsNotNull(flowable9, "source9");
        Intrinsics.checkParameterIsNotNull(function9, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(flowable, flowable2, flowable3, flowable4, flowable5, flowable6, flowable7, flowable8, flowable9, new io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>(function9) { // from class: io.reactivex.rxkotlin.Flowables$combineLatest$10
            public final /* synthetic */ Function9 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function9
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8, T9 t9) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8, t9);
            }
        });
        if (combineLatest == null) {
            Intrinsics.throwNpe();
        }
        return combineLatest;
    }

    @NotNull
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> zip(@NotNull Flowable<T1> flowable, @NotNull Flowable<T2> flowable2, @NotNull Flowable<T3> flowable3, @NotNull Flowable<T4> flowable4, @NotNull Flowable<T5> flowable5, @NotNull Flowable<T6> flowable6, @NotNull Flowable<T7> flowable7, @NotNull Flowable<T8> flowable8, @NotNull Flowable<T9> flowable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(flowable, "source1");
        Intrinsics.checkParameterIsNotNull(flowable2, "source2");
        Intrinsics.checkParameterIsNotNull(flowable3, "source3");
        Intrinsics.checkParameterIsNotNull(flowable4, "source4");
        Intrinsics.checkParameterIsNotNull(flowable5, "source5");
        Intrinsics.checkParameterIsNotNull(flowable6, "source6");
        Intrinsics.checkParameterIsNotNull(flowable7, "source7");
        Intrinsics.checkParameterIsNotNull(flowable8, "source8");
        Intrinsics.checkParameterIsNotNull(flowable9, "source9");
        Intrinsics.checkParameterIsNotNull(function9, "combineFunction");
        Flowable<R> zip = Flowable.zip(flowable, flowable2, flowable3, flowable4, flowable5, flowable6, flowable7, flowable8, flowable9, new io.reactivex.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>(function9) { // from class: io.reactivex.rxkotlin.Flowables$zip$10
            public final /* synthetic */ Function9 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function9
            public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8, T9 t9) {
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8, t9);
            }
        });
        if (zip == null) {
            Intrinsics.throwNpe();
        }
        return zip;
    }
}
