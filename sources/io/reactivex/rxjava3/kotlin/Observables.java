package io.reactivex.rxjava3.kotlin;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function3;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.Jl\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bH\b¢\u0006\u0004\b\n\u0010\u000bJQ\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\n\u0010\rJ\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052 \b\u0004\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0010H\b¢\u0006\u0004\b\n\u0010\u0011Jo\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00120\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\u0013J¨\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00040\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052&\b\u0004\u0010\t\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0016H\b¢\u0006\u0004\b\n\u0010\u0017JÆ\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00050\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052,\b\u0004\u0010\t\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001aH\b¢\u0006\u0004\b\n\u0010\u001bJä\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00060\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u001c*\u00020\u0001\"\b\b\u0006\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00050\u000522\b\u0004\u0010\t\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u001eH\b¢\u0006\u0004\b\n\u0010\u001fJ\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00070\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u001c*\u00020\u0001\"\b\b\u0006\u0010 *\u00020\u0001\"\b\b\u0007\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00060\u000528\b\u0004\u0010\t\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\"H\b¢\u0006\u0004\b\n\u0010#J \u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\b0\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u001c*\u00020\u0001\"\b\b\u0006\u0010 *\u00020\u0001\"\b\b\u0007\u0010$*\u00020\u0001\"\b\b\b\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052>\b\u0004\u0010\t\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0&H\b¢\u0006\u0004\b\n\u0010'J¾\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\t0\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u001c*\u00020\u0001\"\b\b\u0006\u0010 *\u00020\u0001\"\b\b\u0007\u0010$*\u00020\u0001\"\b\b\b\u0010(*\u00020\u0001\"\b\b\t\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\b0\u00052D\b\u0004\u0010\t\u001a>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0*H\b¢\u0006\u0004\b\n\u0010+Jl\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bH\b¢\u0006\u0004\b,\u0010\u000bJQ\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b,\u0010\rJ\u0001\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052 \b\u0004\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0010H\b¢\u0006\u0004\b,\u0010\u0011Jo\u0010,\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00120\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0007¢\u0006\u0004\b,\u0010\u0013J¨\u0001\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00040\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052&\b\u0004\u0010\t\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0016H\b¢\u0006\u0004\b,\u0010\u0017JÆ\u0001\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00050\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052,\b\u0004\u0010\t\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001aH\b¢\u0006\u0004\b,\u0010\u001bJä\u0001\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00060\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u001c*\u00020\u0001\"\b\b\u0006\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00050\u000522\b\u0004\u0010\t\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u001eH\b¢\u0006\u0004\b,\u0010\u001fJ\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00070\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u001c*\u00020\u0001\"\b\b\u0006\u0010 *\u00020\u0001\"\b\b\u0007\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00060\u000528\b\u0004\u0010\t\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\"H\b¢\u0006\u0004\b,\u0010#J \u0002\u0010,\u001a\b\u0012\u0004\u0012\u00028\b0\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u001c*\u00020\u0001\"\b\b\u0006\u0010 *\u00020\u0001\"\b\b\u0007\u0010$*\u00020\u0001\"\b\b\b\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052>\b\u0004\u0010\t\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0&H\b¢\u0006\u0004\b,\u0010'J¾\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00028\t0\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0014*\u00020\u0001\"\b\b\u0004\u0010\u0018*\u00020\u0001\"\b\b\u0005\u0010\u001c*\u00020\u0001\"\b\b\u0006\u0010 *\u00020\u0001\"\b\b\u0007\u0010$*\u00020\u0001\"\b\b\b\u0010(*\u00020\u0001\"\b\b\t\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00040\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00050\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00060\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00070\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\b0\u00052D\b\u0004\u0010\t\u001a>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0*H\b¢\u0006\u0004\b,\u0010+¨\u0006/"}, d2 = {"Lio/reactivex/rxjava3/kotlin/Observables;", "", "T1", "T2", "R", "Lio/reactivex/rxjava3/core/Observable;", "source1", "source2", "Lkotlin/Function2;", "combineFunction", "combineLatest", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "T3", "source3", "Lkotlin/Function3;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function3;)Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Triple;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "T4", "source4", "Lkotlin/Function4;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function4;)Lio/reactivex/rxjava3/core/Observable;", "T5", "source5", "Lkotlin/Function5;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function5;)Lio/reactivex/rxjava3/core/Observable;", "T6", "source6", "Lkotlin/Function6;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function6;)Lio/reactivex/rxjava3/core/Observable;", "T7", "source7", "Lkotlin/Function7;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function7;)Lio/reactivex/rxjava3/core/Observable;", "T8", "source8", "Lkotlin/Function8;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function8;)Lio/reactivex/rxjava3/core/Observable;", "T9", "source9", "Lkotlin/Function9;", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function9;)Lio/reactivex/rxjava3/core/Observable;", "zip", "<init>", "()V", "rxkotlin"}, k = 1, mv = {1, 4, 0})
public final class Observables {
    public static final Observables INSTANCE = new Observables();

    public static final class a<T1, T2, R> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
        public static final a a = new a();

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return TuplesKt.to(obj, obj2);
        }
    }

    public static final class b<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return new Triple(obj, obj2, obj3);
        }
    }

    public static final class c<T1, T2, R> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
        public static final c a = new c();

        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Object apply(Object obj, Object obj2) {
            return TuplesKt.to(obj, obj2);
        }
    }

    public static final class d<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
        public static final d a = new d();

        @Override // io.reactivex.rxjava3.functions.Function3
        public Object apply(Object obj, Object obj2, Object obj3) {
            return new Triple(obj, obj2, obj3);
        }
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, new BiFunction<T1, T2, R>(function2) { // from class: io.reactivex.rxjava3.kotlin.Observables$combineLatest$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.BiFunction
            @NotNull
            public final R apply(T1 t1, T2 t2) {
                Function2 function22 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                return (R) function22.invoke(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, new BiFunction<T1, T2, R>(function2) { // from class: io.reactivex.rxjava3.kotlin.Observables$zip$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.BiFunction
            @NotNull
            public final R apply(T1 t1, T2 t2) {
                Function2 function22 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(t1, "t1");
                Intrinsics.checkExpressionValueIsNotNull(t2, "t2");
                return (R) function22.invoke(t1, t2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …ombineFunction(t1, t2) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2> Observable<Pair<T1, T2>> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<Pair<T1, T2>> combineLatest = Observable.combineLatest(observable, observable2, a.a);
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…> { t1, t2 -> t1 to t2 })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2> Observable<Pair<T1, T2>> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<Pair<T1, T2>> zip = Observable.zip(observable, observable2, c.a);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …> { t1, t2 -> t1 to t2 })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, new Function3<T1, T2, T3, R>(function3) { // from class: io.reactivex.rxjava3.kotlin.Observables$combineLatest$3
            public final /* synthetic */ kotlin.jvm.functions.Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return (R) this.a.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…neFunction(t1, t2, t3) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, new Function3<T1, T2, T3, R>(function3) { // from class: io.reactivex.rxjava3.kotlin.Observables$zip$3
            public final /* synthetic */ kotlin.jvm.functions.Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                return (R) this.a.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …neFunction(t1, t2, t3) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<Triple<T1, T2, T3>> combineLatest = Observable.combineLatest(observable, observable2, observable3, b.a);
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest… -> Triple(t1, t2, t3) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<Triple<T1, T2, T3>> zip = Observable.zip(observable, observable2, observable3, d.a);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, … -> Triple(t1, t2, t3) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, new io.reactivex.rxjava3.functions.Function4<T1, T2, T3, T4, R>(function4) { // from class: io.reactivex.rxjava3.kotlin.Observables$combineLatest$5
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function4
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                return (R) this.a.invoke(t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…nction(t1, t2, t3, t4) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, new io.reactivex.rxjava3.functions.Function4<T1, T2, T3, T4, R>(function4) { // from class: io.reactivex.rxjava3.kotlin.Observables$zip$5
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function4
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                return (R) this.a.invoke(t1, t2, t3, t4);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …nction(t1, t2, t3, t4) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, new io.reactivex.rxjava3.functions.Function5<T1, T2, T3, T4, T5, R>(function5) { // from class: io.reactivex.rxjava3.kotlin.Observables$combineLatest$6
            public final /* synthetic */ Function5 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function5
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                return (R) this.a.invoke(t1, t2, t3, t4, t5);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…on(t1, t2, t3, t4, t5) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, observable5, new io.reactivex.rxjava3.functions.Function5<T1, T2, T3, T4, T5, R>(function5) { // from class: io.reactivex.rxjava3.kotlin.Observables$zip$6
            public final /* synthetic */ Function5 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function5
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                return (R) this.a.invoke(t1, t2, t3, t4, t5);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …on(t1, t2, t3, t4, t5) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, new io.reactivex.rxjava3.functions.Function6<T1, T2, T3, T4, T5, T6, R>(function6) { // from class: io.reactivex.rxjava3.kotlin.Observables$combineLatest$7
            public final /* synthetic */ Function6 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function6
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5, @NotNull T6 t62) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t62, "t6");
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…1, t2, t3, t4, t5, t6) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, new io.reactivex.rxjava3.functions.Function6<T1, T2, T3, T4, T5, T6, R>(function6) { // from class: io.reactivex.rxjava3.kotlin.Observables$zip$7
            public final /* synthetic */ Function6 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function6
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5, @NotNull T6 t62) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t62, "t6");
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …1, t2, t3, t4, t5, t6) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(function7, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, observable7, new io.reactivex.rxjava3.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>(function7) { // from class: io.reactivex.rxjava3.kotlin.Observables$combineLatest$8
            public final /* synthetic */ Function7 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function7
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5, @NotNull T6 t62, @NotNull T7 t7) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t62, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…2, t3, t4, t5, t6, t7) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(function7, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, observable7, new io.reactivex.rxjava3.functions.Function7<T1, T2, T3, T4, T5, T6, T7, R>(function7) { // from class: io.reactivex.rxjava3.kotlin.Observables$zip$8
            public final /* synthetic */ Function7 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function7
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5, @NotNull T6 t62, @NotNull T7 t7) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t62, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …2, t3, t4, t5, t6, t7) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(function8, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, new io.reactivex.rxjava3.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>(function8) { // from class: io.reactivex.rxjava3.kotlin.Observables$combineLatest$9
            public final /* synthetic */ Function8 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function8
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5, @NotNull T6 t62, @NotNull T7 t7, @NotNull T8 t8) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t62, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                Intrinsics.checkParameterIsNotNull(t8, "t8");
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…3, t4, t5, t6, t7, t8) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(function8, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, new io.reactivex.rxjava3.functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>(function8) { // from class: io.reactivex.rxjava3.kotlin.Observables$zip$9
            public final /* synthetic */ Function8 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function8
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5, @NotNull T6 t62, @NotNull T7 t7, @NotNull T8 t8) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t62, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                Intrinsics.checkParameterIsNotNull(t8, "t8");
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …3, t4, t5, t6, t7, t8) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Observable<T9> observable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(observable9, "source9");
        Intrinsics.checkParameterIsNotNull(function9, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, new io.reactivex.rxjava3.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>(function9) { // from class: io.reactivex.rxjava3.kotlin.Observables$combineLatest$10
            public final /* synthetic */ Function9 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function9
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5, @NotNull T6 t62, @NotNull T7 t7, @NotNull T8 t8, @NotNull T9 t9) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t62, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                Intrinsics.checkParameterIsNotNull(t8, "t8");
                Intrinsics.checkParameterIsNotNull(t9, "t9");
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8, t9);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…4, t5, t6, t7, t8, t9) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Observable<T9> observable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(observable7, "source7");
        Intrinsics.checkParameterIsNotNull(observable8, "source8");
        Intrinsics.checkParameterIsNotNull(observable9, "source9");
        Intrinsics.checkParameterIsNotNull(function9, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, new io.reactivex.rxjava3.functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>(function9) { // from class: io.reactivex.rxjava3.kotlin.Observables$zip$10
            public final /* synthetic */ Function9 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.functions.Function9
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4, @NotNull T5 t5, @NotNull T6 t62, @NotNull T7 t7, @NotNull T8 t8, @NotNull T9 t9) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                Intrinsics.checkParameterIsNotNull(t4, "t4");
                Intrinsics.checkParameterIsNotNull(t5, "t5");
                Intrinsics.checkParameterIsNotNull(t62, "t6");
                Intrinsics.checkParameterIsNotNull(t7, "t7");
                Intrinsics.checkParameterIsNotNull(t8, "t8");
                Intrinsics.checkParameterIsNotNull(t9, "t9");
                return (R) this.a.invoke(t1, t2, t3, t4, t5, t62, t7, t8, t9);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …4, t5, t6, t7, t8, t9) })");
        return zip;
    }
}
