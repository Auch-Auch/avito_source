package arrow.syntax.function;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import n6.c.a.a8;
import n6.c.a.b8;
import n6.c.a.c8;
import n6.c.a.d8;
import n6.c.a.e8;
import n6.c.a.f8;
import n6.c.a.g8;
import n6.c.a.h8;
import n6.c.a.i8;
import n6.c.a.j8;
import n6.c.a.k8;
import n6.c.a.l8;
import n6.c.a.m8;
import n6.c.a.n8;
import n6.c.a.o8;
import n6.c.a.p8;
import n6.c.a.q8;
import n6.c.a.r8;
import n6.c.a.s8;
import n6.c.a.t8;
import n6.c.a.v8;
import n6.c.a.x7;
import n6.c.a.y7;
import n6.c.a.z7;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a5\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006\u001aG\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\u0000*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\u0002\u0010\t\u001aY\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\u0000*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b¢\u0006\u0004\b\u0002\u0010\f\u001ak\u0010\u0002\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000e\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0000* \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000e¢\u0006\u0004\b\u0002\u0010\u000f\u001a}\u0010\u0002\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0011\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0000*&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0011¢\u0006\u0004\b\u0002\u0010\u0012\u001a\u0001\u0010\u0002\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u0014\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0000*,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u0014¢\u0006\u0004\b\u0002\u0010\u0015\u001a¡\u0001\u0010\u0002\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u0017\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0000*2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u0017¢\u0006\u0004\b\u0002\u0010\u0018\u001a³\u0001\u0010\u0002\u001a8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u001a\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u0000*8\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u001a¢\u0006\u0004\b\u0002\u0010\u001b\u001aÅ\u0001\u0010\u0002\u001a>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0\u001d\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u0000*>\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t0\u001d¢\u0006\u0004\b\u0002\u0010\u001e\u001a×\u0001\u0010\u0002\u001aD\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n0 \"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\u0000*D\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n0 ¢\u0006\u0004\b\u0002\u0010!\u001aé\u0001\u0010\u0002\u001aJ\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b0#\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010\u0000*J\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b0#¢\u0006\u0004\b\u0002\u0010$\u001aû\u0001\u0010\u0002\u001aP\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f0&\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010\u0000*P\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f0&¢\u0006\u0004\b\u0002\u0010'\u001a\u0002\u0010\u0002\u001aV\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r0)\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010\u0000*V\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r0)¢\u0006\u0004\b\u0002\u0010*\u001a\u0002\u0010\u0002\u001a\\\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e0,\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010+\"\u0004\b\u000e\u0010\u0000*\\\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e0,¢\u0006\u0004\b\u0002\u0010-\u001a±\u0002\u0010\u0002\u001ab\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f0/\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010+\"\u0004\b\u000e\u0010.\"\u0004\b\u000f\u0010\u0000*b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f0/¢\u0006\u0004\b\u0002\u00100\u001aÃ\u0002\u0010\u0002\u001ah\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u001002\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010+\"\u0004\b\u000e\u0010.\"\u0004\b\u000f\u00101\"\u0004\b\u0010\u0010\u0000*h\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u001002¢\u0006\u0004\b\u0002\u00103\u001aÕ\u0002\u0010\u0002\u001an\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u001105\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010+\"\u0004\b\u000e\u0010.\"\u0004\b\u000f\u00101\"\u0004\b\u0010\u00104\"\u0004\b\u0011\u0010\u0000*n\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u001105¢\u0006\u0004\b\u0002\u00106\u001aç\u0002\u0010\u0002\u001at\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u001208\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010+\"\u0004\b\u000e\u0010.\"\u0004\b\u000f\u00101\"\u0004\b\u0010\u00104\"\u0004\b\u0011\u00107\"\u0004\b\u0012\u0010\u0000*t\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u001208¢\u0006\u0004\b\u0002\u00109\u001aù\u0002\u0010\u0002\u001az\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u00130;\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010+\"\u0004\b\u000e\u0010.\"\u0004\b\u000f\u00101\"\u0004\b\u0010\u00104\"\u0004\b\u0011\u00107\"\u0004\b\u0012\u0010:\"\u0004\b\u0013\u0010\u0000*z\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u00130;¢\u0006\u0004\b\u0002\u0010<\u001a\u0003\u0010\u0002\u001a\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u00140>\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010+\"\u0004\b\u000e\u0010.\"\u0004\b\u000f\u00101\"\u0004\b\u0010\u00104\"\u0004\b\u0011\u00107\"\u0004\b\u0012\u0010:\"\u0004\b\u0013\u0010=\"\u0004\b\u0014\u0010\u0000*\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u00140>¢\u0006\u0004\b\u0002\u0010?\u001a\u0003\u0010\u0002\u001a\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u00150A\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010+\"\u0004\b\u000e\u0010.\"\u0004\b\u000f\u00101\"\u0004\b\u0010\u00104\"\u0004\b\u0011\u00107\"\u0004\b\u0012\u0010:\"\u0004\b\u0013\u0010=\"\u0004\b\u0014\u0010@\"\u0004\b\u0015\u0010\u0000*\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u00150A¢\u0006\u0004\b\u0002\u0010B\u001a±\u0003\u0010\u0002\u001a\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u0015\u0012\u0004\u0012\u00028\u00160D\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0013\"\u0004\b\u0006\u0010\u0016\"\u0004\b\u0007\u0010\u0019\"\u0004\b\b\u0010\u001c\"\u0004\b\t\u0010\u001f\"\u0004\b\n\u0010\"\"\u0004\b\u000b\u0010%\"\u0004\b\f\u0010(\"\u0004\b\r\u0010+\"\u0004\b\u000e\u0010.\"\u0004\b\u000f\u00101\"\u0004\b\u0010\u00104\"\u0004\b\u0011\u00107\"\u0004\b\u0012\u0010:\"\u0004\b\u0013\u0010=\"\u0004\b\u0014\u0010@\"\u0004\b\u0015\u0010C\"\u0004\b\u0016\u0010\u0000*\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u0015\u0012\u0004\u0012\u00028\u00160D¢\u0006\u0004\b\u0002\u0010E¨\u0006F"}, d2 = {"R", "Lkotlin/Function0;", "memoize", "(Lkotlin/jvm/functions/Function0;)Lkotlin/jvm/functions/Function0;", "P1", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "P2", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "P3", "Lkotlin/Function3;", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "P4", "Lkotlin/Function4;", "(Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function4;", "P5", "Lkotlin/Function5;", "(Lkotlin/jvm/functions/Function5;)Lkotlin/jvm/functions/Function5;", "P6", "Lkotlin/Function6;", "(Lkotlin/jvm/functions/Function6;)Lkotlin/jvm/functions/Function6;", "P7", "Lkotlin/Function7;", "(Lkotlin/jvm/functions/Function7;)Lkotlin/jvm/functions/Function7;", "P8", "Lkotlin/Function8;", "(Lkotlin/jvm/functions/Function8;)Lkotlin/jvm/functions/Function8;", "P9", "Lkotlin/Function9;", "(Lkotlin/jvm/functions/Function9;)Lkotlin/jvm/functions/Function9;", "P10", "Lkotlin/Function10;", "(Lkotlin/jvm/functions/Function10;)Lkotlin/jvm/functions/Function10;", "P11", "Lkotlin/Function11;", "(Lkotlin/jvm/functions/Function11;)Lkotlin/jvm/functions/Function11;", "P12", "Lkotlin/Function12;", "(Lkotlin/jvm/functions/Function12;)Lkotlin/jvm/functions/Function12;", "P13", "Lkotlin/Function13;", "(Lkotlin/jvm/functions/Function13;)Lkotlin/jvm/functions/Function13;", "P14", "Lkotlin/Function14;", "(Lkotlin/jvm/functions/Function14;)Lkotlin/jvm/functions/Function14;", "P15", "Lkotlin/Function15;", "(Lkotlin/jvm/functions/Function15;)Lkotlin/jvm/functions/Function15;", "P16", "Lkotlin/Function16;", "(Lkotlin/jvm/functions/Function16;)Lkotlin/jvm/functions/Function16;", "P17", "Lkotlin/Function17;", "(Lkotlin/jvm/functions/Function17;)Lkotlin/jvm/functions/Function17;", "P18", "Lkotlin/Function18;", "(Lkotlin/jvm/functions/Function18;)Lkotlin/jvm/functions/Function18;", "P19", "Lkotlin/Function19;", "(Lkotlin/jvm/functions/Function19;)Lkotlin/jvm/functions/Function19;", "P20", "Lkotlin/Function20;", "(Lkotlin/jvm/functions/Function20;)Lkotlin/jvm/functions/Function20;", "P21", "Lkotlin/Function21;", "(Lkotlin/jvm/functions/Function21;)Lkotlin/jvm/functions/Function21;", "P22", "Lkotlin/Function22;", "(Lkotlin/jvm/functions/Function22;)Lkotlin/jvm/functions/Function22;", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class MemoizationKt {
    @NotNull
    public static final <R> Function0<R> memoize(@NotNull Function0<? extends R> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "$receiver");
        return new Function0<R>(function0) { // from class: arrow.syntax.function.MemoizationKt$memoize$1
            public final v8<Function0<R>, x7<R>, R> a;
            public final /* synthetic */ Function0 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function0
            public R invoke() {
                return this.a.a(new x7<>((byte) 0));
            }
        };
    }

    @NotNull
    public static final <P1, R> Function1<P1, R> memoize(@NotNull Function1<? super P1, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "$receiver");
        return new Function1<P1, R>(function1) { // from class: arrow.syntax.function.MemoizationKt$memoize$2
            public final v8<Function1<P1, R>, i8<? extends P1, R>, R> a;
            public final /* synthetic */ Function1 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function1
            public R invoke(P1 p1) {
                return this.a.a(new i8<>(p1));
            }
        };
    }

    @NotNull
    public static final <P1, P2, R> Function2<P1, P2, R> memoize(@NotNull Function2<? super P1, ? super P2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "$receiver");
        return new Function2<P1, P2, R>(function2) { // from class: arrow.syntax.function.MemoizationKt$memoize$3
            public final v8<Function2<P1, P2, R>, m8<? extends P1, ? extends P2, R>, R> a;
            public final /* synthetic */ Function2 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function2
            public R invoke(P1 p1, P2 p2) {
                return this.a.a(new m8<>(p1, p2));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, R> Function3<P1, P2, P3, R> memoize(@NotNull Function3<? super P1, ? super P2, ? super P3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "$receiver");
        return new Function3<P1, P2, P3, R>(function3) { // from class: arrow.syntax.function.MemoizationKt$memoize$4
            public final v8<Function3<P1, P2, P3, R>, n8<? extends P1, ? extends P2, ? extends P3, R>, R> a;
            public final /* synthetic */ Function3 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function3
            public R invoke(P1 p1, P2 p2, P3 p3) {
                return this.a.a(new n8<>(p1, p2, p3));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, R> Function4<P1, P2, P3, P4, R> memoize(@NotNull Function4<? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "$receiver");
        return new Function4<P1, P2, P3, P4, R>(function4) { // from class: arrow.syntax.function.MemoizationKt$memoize$5
            public final v8<Function4<P1, P2, P3, P4, R>, o8<? extends P1, ? extends P2, ? extends P3, ? extends P4, R>, R> a;
            public final /* synthetic */ Function4 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function4
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4) {
                return this.a.a(new o8<>(p1, p2, p3, p4));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, R> Function5<P1, P2, P3, P4, P5, R> memoize(@NotNull Function5<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(function5, "$receiver");
        return new Function5<P1, P2, P3, P4, P5, R>(function5) { // from class: arrow.syntax.function.MemoizationKt$memoize$6
            public final v8<Function5<P1, P2, P3, P4, P5, R>, p8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, R>, R> a;
            public final /* synthetic */ Function5 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function5
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) {
                return this.a.a(new p8<>(p1, p2, p3, p4, p5));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, R> Function6<P1, P2, P3, P4, P5, P6, R> memoize(@NotNull Function6<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(function6, "$receiver");
        return new Function6<P1, P2, P3, P4, P5, P6, R>(function6) { // from class: arrow.syntax.function.MemoizationKt$memoize$7
            public final v8<Function6<P1, P2, P3, P4, P5, P6, R>, q8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, R>, R> a;
            public final /* synthetic */ Function6 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function6
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62) {
                return this.a.a(new q8<>(p1, p2, p3, p4, p5, p62));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, R> Function7<P1, P2, P3, P4, P5, P6, P7, R> memoize(@NotNull Function7<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function7) {
        Intrinsics.checkParameterIsNotNull(function7, "$receiver");
        return new Function7<P1, P2, P3, P4, P5, P6, P7, R>(function7) { // from class: arrow.syntax.function.MemoizationKt$memoize$8
            public final v8<Function7<P1, P2, P3, P4, P5, P6, P7, R>, r8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, R>, R> a;
            public final /* synthetic */ Function7 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function7
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7) {
                return this.a.a(new r8<>(p1, p2, p3, p4, p5, p62, p7));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, R> Function8<P1, P2, P3, P4, P5, P6, P7, P8, R> memoize(@NotNull Function8<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? extends R> function8) {
        Intrinsics.checkParameterIsNotNull(function8, "$receiver");
        return new Function8<P1, P2, P3, P4, P5, P6, P7, P8, R>(function8) { // from class: arrow.syntax.function.MemoizationKt$memoize$9
            public final v8<Function8<P1, P2, P3, P4, P5, P6, P7, P8, R>, s8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, R>, R> a;
            public final /* synthetic */ Function8 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function8
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8) {
                return this.a.a(new s8<>(p1, p2, p3, p4, p5, p62, p7, p8));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, R> Function9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> memoize(@NotNull Function9<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? extends R> function9) {
        Intrinsics.checkParameterIsNotNull(function9, "$receiver");
        return new Function9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R>(function9) { // from class: arrow.syntax.function.MemoizationKt$memoize$10
            public final v8<Function9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R>, t8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, R>, R> a;
            public final /* synthetic */ Function9 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function9
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9) {
                return this.a.a(new t8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> Function10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> memoize(@NotNull Function10<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? extends R> function10) {
        Intrinsics.checkParameterIsNotNull(function10, "$receiver");
        return new Function10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R>(function10) { // from class: arrow.syntax.function.MemoizationKt$memoize$11
            public final v8<Function10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R>, y7<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, R>, R> a;
            public final /* synthetic */ Function10 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function10
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10) {
                return this.a.a(new y7<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R> Function11<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R> memoize(@NotNull Function11<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? extends R> function11) {
        Intrinsics.checkParameterIsNotNull(function11, "$receiver");
        return new Function11<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R>(function11) { // from class: arrow.syntax.function.MemoizationKt$memoize$12
            public final v8<Function11<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R>, z7<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, R>, R> a;
            public final /* synthetic */ Function11 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function11
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11) {
                return this.a.a(new z7<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R> Function12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R> memoize(@NotNull Function12<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? extends R> function12) {
        Intrinsics.checkParameterIsNotNull(function12, "$receiver");
        return new Function12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R>(function12) { // from class: arrow.syntax.function.MemoizationKt$memoize$13
            public final v8<Function12<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R>, a8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, R>, R> a;
            public final /* synthetic */ Function12 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function12
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12) {
                return this.a.a(new a8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, R> Function13<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, R> memoize(@NotNull Function13<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? extends R> function13) {
        Intrinsics.checkParameterIsNotNull(function13, "$receiver");
        return new Function13<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, R>(function13) { // from class: arrow.syntax.function.MemoizationKt$memoize$14
            public final v8<Function13<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, R>, b8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, R>, R> a;
            public final /* synthetic */ Function13 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function13
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13) {
                return this.a.a(new b8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, R> Function14<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, R> memoize(@NotNull Function14<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? extends R> function14) {
        Intrinsics.checkParameterIsNotNull(function14, "$receiver");
        return new Function14<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, R>(function14) { // from class: arrow.syntax.function.MemoizationKt$memoize$15
            public final v8<Function14<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, R>, c8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, ? extends P14, R>, R> a;
            public final /* synthetic */ Function14 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function14
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14) {
                return this.a.a(new c8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13, p14));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, R> Function15<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, R> memoize(@NotNull Function15<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? extends R> function15) {
        Intrinsics.checkParameterIsNotNull(function15, "$receiver");
        return new Function15<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, R>(function15) { // from class: arrow.syntax.function.MemoizationKt$memoize$16
            public final v8<Function15<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, R>, d8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, ? extends P14, ? extends P15, R>, R> a;
            public final /* synthetic */ Function15 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function15
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15) {
                return this.a.a(new d8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13, p14, p15));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, R> Function16<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, R> memoize(@NotNull Function16<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? super P16, ? extends R> function16) {
        Intrinsics.checkParameterIsNotNull(function16, "$receiver");
        return new Function16<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, R>(function16) { // from class: arrow.syntax.function.MemoizationKt$memoize$17
            public final v8<Function16<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, R>, e8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, ? extends P14, ? extends P15, ? extends P16, R>, R> a;
            public final /* synthetic */ Function16 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function16
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16) {
                return this.a.a(new e8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, R> Function17<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, R> memoize(@NotNull Function17<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? super P16, ? super P17, ? extends R> function17) {
        Intrinsics.checkParameterIsNotNull(function17, "$receiver");
        return new Function17<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, R>(function17) { // from class: arrow.syntax.function.MemoizationKt$memoize$18
            public final v8<Function17<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, R>, f8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, ? extends P14, ? extends P15, ? extends P16, ? extends P17, R>, R> a;
            public final /* synthetic */ Function17 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function17
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17) {
                return this.a.a(new f8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, R> Function18<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, R> memoize(@NotNull Function18<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? super P16, ? super P17, ? super P18, ? extends R> function18) {
        Intrinsics.checkParameterIsNotNull(function18, "$receiver");
        return new Function18<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, R>(function18) { // from class: arrow.syntax.function.MemoizationKt$memoize$19
            public final v8<Function18<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, R>, g8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, ? extends P14, ? extends P15, ? extends P16, ? extends P17, ? extends P18, R>, R> a;
            public final /* synthetic */ Function18 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function18
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17, P18 p18) {
                return this.a.a(new g8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, R> Function19<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, R> memoize(@NotNull Function19<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? super P16, ? super P17, ? super P18, ? super P19, ? extends R> function19) {
        Intrinsics.checkParameterIsNotNull(function19, "$receiver");
        return new Function19<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, R>(function19) { // from class: arrow.syntax.function.MemoizationKt$memoize$20
            public final v8<Function19<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, R>, h8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, ? extends P14, ? extends P15, ? extends P16, ? extends P17, ? extends P18, ? extends P19, R>, R> a;
            public final /* synthetic */ Function19 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function19
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17, P18 p18, P19 p19) {
                return this.a.a(new h8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, R> Function20<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, R> memoize(@NotNull Function20<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? super P16, ? super P17, ? super P18, ? super P19, ? super P20, ? extends R> function20) {
        Intrinsics.checkParameterIsNotNull(function20, "$receiver");
        return new Function20<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, R>(function20) { // from class: arrow.syntax.function.MemoizationKt$memoize$21
            public final v8<Function20<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, R>, j8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, ? extends P14, ? extends P15, ? extends P16, ? extends P17, ? extends P18, ? extends P19, ? extends P20, R>, R> a;
            public final /* synthetic */ Function20 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function20
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17, P18 p18, P19 p19, P20 p20) {
                return this.a.a(new j8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, R> Function21<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, R> memoize(@NotNull Function21<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? super P16, ? super P17, ? super P18, ? super P19, ? super P20, ? super P21, ? extends R> function21) {
        Intrinsics.checkParameterIsNotNull(function21, "$receiver");
        return new Function21<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, R>(function21) { // from class: arrow.syntax.function.MemoizationKt$memoize$22
            public final v8<Function21<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, R>, k8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, ? extends P14, ? extends P15, ? extends P16, ? extends P17, ? extends P18, ? extends P19, ? extends P20, ? extends P21, R>, R> a;
            public final /* synthetic */ Function21 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function21
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17, P18 p18, P19 p19, P20 p20, P21 p21) {
                return this.a.a(new k8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21));
            }
        };
    }

    @NotNull
    public static final <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, R> Function22<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, R> memoize(@NotNull Function22<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? super P16, ? super P17, ? super P18, ? super P19, ? super P20, ? super P21, ? super P22, ? extends R> function22) {
        Intrinsics.checkParameterIsNotNull(function22, "$receiver");
        return new Function22<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, R>(function22) { // from class: arrow.syntax.function.MemoizationKt$memoize$23
            public final v8<Function22<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, R>, l8<? extends P1, ? extends P2, ? extends P3, ? extends P4, ? extends P5, ? extends P6, ? extends P7, ? extends P8, ? extends P9, ? extends P10, ? extends P11, ? extends P12, ? extends P13, ? extends P14, ? extends P15, ? extends P16, ? extends P17, ? extends P18, ? extends P19, ? extends P20, ? extends P21, ? extends P22, R>, R> a;
            public final /* synthetic */ Function22 b;

            {
                this.b = r2;
                this.a = new v8<>(r2);
            }

            @Override // kotlin.jvm.functions.Function22
            public R invoke(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15, P16 p16, P17 p17, P18 p18, P19 p19, P20 p20, P21 p21, P22 p22) {
                return this.a.a(new l8<>(p1, p2, p3, p4, p5, p62, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22));
            }
        };
    }
}
