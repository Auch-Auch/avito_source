package com.avito.android.util;

import a2.a.a.n3.n;
import a2.a.a.n3.o;
import a2.a.a.n3.p;
import arrow.core.None;
import arrow.core.Some;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.sequences.Sequence;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000î\u0001\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a3\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\f\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u0006H\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0007¢\u0006\u0004\b\n\u0010\u0011\u001a,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u0006H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u00122\u000e\b\u0004\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001a\u001a;\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"\u001a-\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0015¢\u0006\u0004\b$\u0010\u0018\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0006*\u00020%¢\u0006\u0004\b'\u0010(\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020*0\u0006*\u00020)¢\u0006\u0004\b'\u0010+\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020-0\u0006*\u00020,¢\u0006\u0004\b'\u0010.\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u0002000\u0006*\u00020/¢\u0006\u0004\b'\u00101\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0006*\u000202¢\u0006\u0004\b'\u00103\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u0002050\u0006*\u000204¢\u0006\u0004\b'\u00106\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u0002080\u0006*\u000207¢\u0006\u0004\b'\u00109\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u0002000\u0006*\u00020:¢\u0006\u0004\b'\u0010;\u001a'\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000<¢\u0006\u0004\b'\u0010=\u001a'\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000>¢\u0006\u0004\b'\u0010?\u001a'\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000@¢\u0006\u0004\b'\u0010A\u001a$\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\u00028\u0000H\b¢\u0006\u0004\bB\u0010\u000f\u001a!\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\u00020\u0000¢\u0006\u0004\b'\u0010C\u001a/\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060>¢\u0006\u0004\bD\u0010?\u001a/\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060>¢\u0006\u0004\bE\u0010?\u001a;\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\bF\u0010G\u001aK\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012\"\b\b\u0001\u0010H*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010@0\u0007¢\u0006\u0004\bI\u0010G\u001a-\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0006¢\u0006\u0004\bJ\u0010\u0014\u001a\\\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010H*\u00020\u0012*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060K2'\u0010O\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000K¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\bP\u0010Q\u001aX\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010H*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060K2'\u0010R\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000K¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\bS\u0010Q\u001a*\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010H\u0018\u0001*\u00020\u0012*\u0006\u0012\u0002\b\u00030\u0006H\b¢\u0006\u0004\bT\u0010\u0014\u001a7\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012\"\u000e\b\u0001\u0010V*\b\u0012\u0004\u0012\u00028\u00000U*\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\bW\u0010\u0014\u001a;\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020&0\u0007¢\u0006\u0004\bY\u0010G\u001a*\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010H\u0018\u0001*\u00020\u0012*\u0006\u0012\u0002\b\u00030\u0006H\b¢\u0006\u0004\bZ\u0010\u0014\u001ao\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\"\b\b\u0000\u0010[*\u00020\u0012\"\u0004\b\u0001\u0010\\\"\b\b\u0002\u0010]*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00010\u00062\u0014\b\u0004\u0010^\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00072\u001a\b\u0004\u0010_\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00060\u0007H\bø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001ak\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\"\b\b\u0000\u0010b*\u00020\u0012\"\b\b\u0001\u0010c*\u00020\u0012\"\b\b\u0002\u0010H*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u001a\b\u0004\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020eH\bø\u0001\u0000¢\u0006\u0004\bf\u0010g\u001aN\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010h0\u0006\"\b\b\u0000\u0010b*\u00020\u0012\"\b\b\u0001\u0010c*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\b¢\u0006\u0004\bf\u0010i\u001a\u0001\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00030\u0006\"\b\b\u0000\u0010b*\u00020\u0012\"\b\b\u0001\u0010c*\u00020\u0012\"\b\b\u0002\u0010j*\u00020\u0012\"\b\b\u0003\u0010H*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00020\u00062 \b\u0004\u0010O\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030lH\bø\u0001\u0000¢\u0006\u0004\bf\u0010m\u001al\u0010f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020n0\u0006\"\b\b\u0000\u0010b*\u00020\u0012\"\b\b\u0001\u0010c*\u00020\u0012\"\b\b\u0002\u0010j*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006H\b¢\u0006\u0004\bf\u0010o\u001ao\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\"\b\b\u0000\u0010b*\u00020\u0012\"\b\b\u0001\u0010c*\u00020\u0012\"\b\b\u0002\u0010H*\u00020\u00122\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u001a\b\u0004\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020eH\bø\u0001\u0000¢\u0006\u0004\bq\u0010g\u001aR\u0010q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010h0\u0006\"\b\b\u0000\u0010b*\u00020\u0012\"\b\b\u0001\u0010c*\u00020\u00122\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\b¢\u0006\u0004\bq\u0010i\u001a\u0001\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00030\u0006\"\b\b\u0000\u0010b*\u00020\u0012\"\b\b\u0001\u0010c*\u00020\u0012\"\b\b\u0002\u0010j*\u00020\u0012\"\b\b\u0003\u0010H*\u00020\u00122\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00020\u00062 \b\u0004\u0010O\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030lH\bø\u0001\u0000¢\u0006\u0004\bq\u0010m\u001ap\u0010q\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020n0\u0006\"\b\b\u0000\u0010b*\u00020\u0012\"\b\b\u0001\u0010c*\u00020\u0012\"\b\b\u0002\u0010j*\u00020\u00122\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006H\b¢\u0006\u0004\bq\u0010o\u001a«\u0001\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00040\u0006\"\b\b\u0000\u0010b*\u00020\u0012\"\b\b\u0001\u0010c*\u00020\u0012\"\b\b\u0002\u0010j*\u00020\u0012\"\b\b\u0003\u0010r*\u00020\u0012\"\b\b\u0004\u0010H*\u00020\u00122\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00020\u00062\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00030\u00062&\b\u0004\u0010O\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040tH\bø\u0001\u0000¢\u0006\u0004\bq\u0010u\u001a8\u0010w\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\f¢\u0006\u0004\bw\u0010i\u001a8\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\f¢\u0006\u0004\bx\u0010i\u001a?\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010y\u001a\u00020&2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\bz\u0010{\u001ae\u0010|\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\"\u0004\b\u0000\u0010b\"\u0004\b\u0001\u0010c\"\u0004\b\u0002\u0010H*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00152\f\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u001a\b\u0004\u0010R\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020eH\bø\u0001\u0000¢\u0006\u0004\b|\u0010}\u001aO\u0010|\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010h0\u0006\"\u0004\b\u0000\u0010b\"\u0004\b\u0001\u0010c*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00152\f\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\bø\u0001\u0000¢\u0006\u0004\b|\u0010~\u001a_\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\"\u0004\b\u0000\u0010b\"\u0004\b\u0001\u0010c\"\u0004\b\u0002\u0010H*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u001a\b\u0004\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020eH\bø\u0001\u0000¢\u0006\u0004\b\u0010g\u001aF\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010h0\u0006\"\u0004\b\u0000\u0010b\"\u0004\b\u0001\u0010c*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\b¢\u0006\u0004\b\u0010i\u001aN\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0007\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001fH\b¢\u0006\u0006\b\u0001\u0010\u0001\u001aH\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010h0\u0006\"\u0004\b\u0000\u0010b\"\u0004\b\u0001\u0010c*\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\b¢\u0006\u0005\b\u0001\u0010i\u001ad\u0010\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020n0\u0006\"\u0004\b\u0000\u0010b\"\u0004\b\u0001\u0010c\"\u0004\b\u0002\u0010j*\b\u0012\u0004\u0012\u00028\u00000\u00062\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006H\b¢\u0006\u0005\b\u0001\u0010o\u001aA\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0014\b\u0004\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0007H\bø\u0001\u0000¢\u0006\u0005\b\u0001\u0010G\u001a\u0001\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\"\u0004\b\u0000\u0010[\"\b\b\u0001\u0010\\*\u00020\u0012\"\b\b\u0002\u0010]*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00010\u00062\u0016\b\u0004\u0010^\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00072)\b\u0004\u0010\u0001\u001a\"\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00060eH\bø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001a8\u0010\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u00010\u0001\"\u0004\b\u0000\u0010\u0005*\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u00010\u0006H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001aB\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0007\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\b¢\u0006\u0005\b\u0001\u0010\"\u001am\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010H*\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u00010\u00062\u0015\b\u0004\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00152\u001b\b\u0004\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0007H\bø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001\"$\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"", "throwable", "", "noOpErrorHandler", "(Ljava/lang/Throwable;)V", "T", "Lio/reactivex/Observable;", "Lkotlin/Function1;", "onNext", "Lio/reactivex/disposables/Disposable;", "subscribeOnNext", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "subscribeIgnoreResult", "(Lio/reactivex/Observable;)Lio/reactivex/disposables/Disposable;", "just", "(Ljava/lang/Object;)Lio/reactivex/Observable;", "Lio/reactivex/functions/Consumer;", "(Lio/reactivex/Observable;Lio/reactivex/functions/Consumer;)Lio/reactivex/disposables/Disposable;", "", "distinctTypes", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlin/Function0;", "block", "observableFromCallableWithoutComplete", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/Observable;", "emptyObservable", "()Lio/reactivex/Observable;", "", "minDelay", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Lio/reactivex/Scheduler;", "scheduler", "delayNotLess", "(Lio/reactivex/Observable;JLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;)Lio/reactivex/Observable;", SDKConstants.PARAM_A2U_BODY, "deferredObservable", "", "", "toObservable", "([Z)Lio/reactivex/Observable;", "", "", "([B)Lio/reactivex/Observable;", "", "", "([S)Lio/reactivex/Observable;", "", "", "([I)Lio/reactivex/Observable;", "", "([J)Lio/reactivex/Observable;", "", "", "([F)Lio/reactivex/Observable;", "", "", "([D)Lio/reactivex/Observable;", "Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/IntProgression;)Lio/reactivex/Observable;", "", "(Ljava/util/Iterator;)Lio/reactivex/Observable;", "", "(Ljava/lang/Iterable;)Lio/reactivex/Observable;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lio/reactivex/Observable;", "toSingletonObservable", "(Ljava/lang/Throwable;)Lio/reactivex/Observable;", "merge", "mergeDelayError", "onError", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "R", "flatMapSequence", "switchOnNext", "", "Lkotlin/ParameterName;", "name", "args", "combineFunction", "combineLatest", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "zipFunction", "zip", "cast", "Lorg/funktionale/option/Option;", "O", "filterDefined", "predicate", "filterNot", "ofType", "KeyT", "EventT", "OutT", "keySelector", "mapper", "switchMapByKey", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "T1", "T2", "o2", "Lkotlin/Function2;", "combineLatestWith", "(Lio/reactivex/Observable;Lio/reactivex/Observable;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Observable;", "Lkotlin/Pair;", "(Lio/reactivex/Observable;Lio/reactivex/Observable;)Lio/reactivex/Observable;", "T3", "o3", "Lkotlin/Function3;", "(Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lkotlin/jvm/functions/Function3;)Lio/reactivex/Observable;", "Lkotlin/Triple;", "(Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;)Lio/reactivex/Observable;", "o1", "observableCombineLatest", "T4", "o4", "Lkotlin/Function4;", "(Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lio/reactivex/Observable;Lkotlin/jvm/functions/Function4;)Lio/reactivex/Observable;", "other", "concatWith", "mergeWith", "condition", "doOnNextIf", "(Lio/reactivex/Observable;ZLkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "reverseZipWith", "(Lkotlin/jvm/functions/Function0;Lio/reactivex/Observable;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Observable;", "(Lkotlin/jvm/functions/Function0;Lio/reactivex/Observable;)Lio/reactivex/Observable;", "reverseCombineLatestWith", "count", "timeout", "unit", "debounceAfter", "(Lio/reactivex/Observable;JJLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;)Lio/reactivex/Observable;", "withLatestFrom", "other1", "other2", "doOnFirst", "transformer", "transformByKey", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Observable;", "Larrow/core/Option;", "Lio/reactivex/Single;", "firstOrNone", "(Lio/reactivex/Observable;)Lio/reactivex/Single;", "delay", "delayCompletion", "ifEmpty", "some", "switchMapFold", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "noOpErrorConsumer", "Lio/reactivex/functions/Consumer;", "getNoOpErrorConsumer", "()Lio/reactivex/functions/Consumer;", "rx"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Observables")
public final class Observables {

    public static final class a<T, R> implements Function<Object[], R> {
        public final /* synthetic */ Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            Object[] objArr2 = objArr;
            Intrinsics.checkNotNullParameter(objArr2, "it");
            Function1 function1 = this.a;
            List asList = ArraysKt___ArraysJvmKt.asList(objArr2);
            Objects.requireNonNull(asList, "null cannot be cast to non-null type kotlin.collections.List<T>");
            return function1.invoke(asList);
        }
    }

    public static final class b<V> implements Callable<Long> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Long call() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    public static final class c<T, R> implements Function<Long, ObservableSource<? extends Pair<? extends T, ? extends Long>>> {
        public final /* synthetic */ Observable a;

        public c(Observable observable) {
            this.a = observable;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Object apply(Long l) {
            Long l2 = l;
            Intrinsics.checkNotNullParameter(l2, "startTime");
            return this.a.map(new n(l2));
        }
    }

    public static final class d<T, R> implements Function<Pair<? extends T, ? extends Long>, ObservableSource<? extends T>> {
        public final /* synthetic */ TimeUnit a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Scheduler c;

        public d(TimeUnit timeUnit, long j, Scheduler scheduler) {
            this.a = timeUnit;
            this.b = j;
            this.c = scheduler;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Pair pair = (Pair) obj;
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            Object component1 = pair.component1();
            Long l = (Long) pair.component2();
            Observable just = Observable.just(component1);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(result)");
            TimeUnit timeUnit = this.a;
            long j = this.b;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            long convert = timeUnit.convert(j, timeUnit2);
            long currentTimeMillis = System.currentTimeMillis();
            Intrinsics.checkNotNullExpressionValue(l, "startTime");
            if (currentTimeMillis - l.longValue() >= convert) {
                return just;
            }
            return just.delay(l.longValue() + (convert - currentTimeMillis), timeUnit2, this.c);
        }
    }

    public static final class e<T> implements Predicate<O> {
        public static final e a = new e();

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkNotNullParameter(option, "it");
            return option.isDefined();
        }
    }

    public static final class f<T, R> implements Function<O, T> {
        public static final f a = new f();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Option option = (Option) obj;
            Intrinsics.checkNotNullParameter(option, "it");
            return option.get();
        }
    }

    public static final class g<T> implements Predicate<T> {
        public final /* synthetic */ Function1 a;

        public g(Function1 function1) {
            this.a = function1;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(@NotNull T t) {
            Intrinsics.checkNotNullParameter(t, "it");
            return !((Boolean) this.a.invoke(t)).booleanValue();
        }
    }

    public static final class h<T, R> implements Function<T, ObservableSource<? extends R>> {
        public final /* synthetic */ Function1 a;

        public h(Function1 function1) {
            this.a = function1;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return Observables.toObservable((Sequence) this.a.invoke(obj));
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullExpressionValue(th2, "throwable");
            Observables.noOpErrorHandler(th2);
        }
    }

    public static final class j<T> implements Consumer<Object> {
        public static final j a = new j();

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object obj) {
        }
    }

    public static final class m<T, R> implements Function<Object[], R> {
        public final /* synthetic */ Function1 a;

        public m(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Object apply(Object[] objArr) {
            Object[] objArr2 = objArr;
            Intrinsics.checkNotNullParameter(objArr2, "it");
            Function1 function1 = this.a;
            List asList = ArraysKt___ArraysJvmKt.asList(objArr2);
            Objects.requireNonNull(asList, "null cannot be cast to non-null type kotlin.collections.List<T>");
            return function1.invoke(asList);
        }
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.Observable<U>, java.lang.Object, io.reactivex.Observable<R> */
    public static final /* synthetic */ <R> Observable<R> cast(Observable<?> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Observable observable2 = (Observable<U>) observable.cast(Object.class);
        Intrinsics.checkNotNullExpressionValue(observable2, "cast(R::class.java)");
        return observable2;
    }

    @NotNull
    public static final <T, R> Observable<R> combineLatest(@NotNull List<? extends Observable<T>> list, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$combineLatest");
        Intrinsics.checkNotNullParameter(function1, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(list, new a(function1));
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…it.asList() as List<T>) }");
        return combineLatest;
    }

    @NotNull
    public static final <T1, T2, R> Observable<R> combineLatestWith(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(observable, "$this$combineLatestWith");
        Intrinsics.checkNotNullParameter(observable2, "o2");
        Intrinsics.checkNotNullParameter(function2, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, new BiFunction<T1, T2, R>(function2) { // from class: com.avito.android.util.Observables$combineLatestWith$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                return (R) this.a.invoke(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        return combineLatest;
    }

    @NotNull
    public static final <T> Observable<T> concatWith(@NotNull Observable<T> observable, @NotNull Observable<T> observable2) {
        Intrinsics.checkNotNullParameter(observable, "$this$concatWith");
        Intrinsics.checkNotNullParameter(observable2, "other");
        Observable<T> concatWith = observable.concatWith(observable2);
        Intrinsics.checkNotNullExpressionValue(concatWith, "concatWith(other)");
        return concatWith;
    }

    /* JADX DEBUG: Type inference failed for r8v1. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<T> */
    @NotNull
    public static final <T> Observable<T> debounceAfter(@NotNull Observable<T> observable, long j2, long j3, @NotNull TimeUnit timeUnit, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(observable, "$this$debounceAfter");
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Observable observable2 = (Observable<R>) observable.publish(new Observables$debounceAfter$1(j2, j3, timeUnit, scheduler));
        Intrinsics.checkNotNullExpressionValue(observable2, "publish { shared ->\n    …cheduler)\n        )\n    }");
        return observable2;
    }

    public static /* synthetic */ Observable debounceAfter$default(Observable observable, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            scheduler = Schedulers.computation();
            Intrinsics.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
        }
        Intrinsics.checkNotNullParameter(observable, "$this$debounceAfter");
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Observable publish = observable.publish(new Observables$debounceAfter$1(j2, j3, timeUnit, scheduler));
        Intrinsics.checkNotNullExpressionValue(publish, "publish { shared ->\n    …cheduler)\n        )\n    }");
        return publish;
    }

    @NotNull
    public static final <T> Observable<T> deferredObservable(@NotNull Function0<? extends Observable<T>> function0) {
        Intrinsics.checkNotNullParameter(function0, SDKConstants.PARAM_A2U_BODY);
        Observable<T> defer = Observable.defer(new p(function0));
        Intrinsics.checkNotNullExpressionValue(defer, "Observable.defer(body)");
        return defer;
    }

    @NotNull
    public static final <T> Observable<T> delayCompletion(@NotNull Observable<T> observable, long j2, @NotNull TimeUnit timeUnit, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(observable, "$this$delayCompletion");
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Observable<T> concatWith = observable.concatWith(Completable.timer(j2, timeUnit, scheduler));
        Intrinsics.checkNotNullExpressionValue(concatWith, "concatWith(Completable.t…(delay, unit, scheduler))");
        return concatWith;
    }

    @NotNull
    public static final <T> Observable<T> delayNotLess(@NotNull Observable<T> observable, long j2, @NotNull TimeUnit timeUnit, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(observable, "$this$delayNotLess");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Observable<T> flatMap = Observable.fromCallable(b.a).flatMap(new c(observable)).flatMap(new d(timeUnit, j2, scheduler));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable\n        .from…e\n            }\n        }");
        return flatMap;
    }

    public static final /* synthetic */ <T> Observable<T> distinctTypes(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$distinctTypes");
        Observable<T> distinctUntilChanged = observable.distinctUntilChanged(Observables$distinctTypes$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "this.distinctUntilChange…vaClass == t2.javaClass }");
        return distinctUntilChanged;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<T> */
    @NotNull
    public static final <T> Observable<T> doOnFirst(@NotNull Observable<T> observable, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(observable, "$this$doOnFirst");
        Intrinsics.checkNotNullParameter(function1, "block");
        Observable observable2 = (Observable<R>) observable.publish(new Observables$doOnFirst$1(function1));
        Intrinsics.checkNotNullExpressionValue(observable2, "publish { obs ->\n       …ock(it) }\n        )\n    }");
        return observable2;
    }

    @NotNull
    public static final <T> Observable<T> doOnNextIf(@NotNull Observable<T> observable, boolean z, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(observable, "$this$doOnNextIf");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!z) {
            return observable;
        }
        Observable<T> doOnNext = observable.doOnNext(new o(function1));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "doOnNext(block)");
        return doOnNext;
    }

    @NotNull
    public static final <T> Observable<T> emptyObservable() {
        Observable<T> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<T> */
    @NotNull
    public static final <T, O extends Option<? extends T>> Observable<T> filterDefined(@NotNull Observable<O> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$filterDefined");
        Observable observable2 = (Observable<R>) observable.filter(e.a).map(f.a);
        Intrinsics.checkNotNullExpressionValue(observable2, "filter { it.isDefined() }.map { it.get() }");
        return observable2;
    }

    @NotNull
    public static final <T> Observable<T> filterNot(@NotNull Observable<T> observable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(observable, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Observable<T> filter = observable.filter(new g(function1));
        Intrinsics.checkNotNullExpressionValue(filter, "this\n    .filter { !predicate(it) }");
        return filter;
    }

    @NotNull
    public static final <T> Single<arrow.core.Option<T>> firstOrNone(@NotNull Observable<arrow.core.Option<T>> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$firstOrNone");
        Single<arrow.core.Option<T>> onErrorReturn = observable.firstOrError().onErrorReturn(Observables$firstOrNone$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "firstOrError().onErrorReturn { none() }");
        return onErrorReturn;
    }

    @NotNull
    public static final <T, R> Observable<R> flatMapSequence(@NotNull Observable<T> observable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(observable, "$this$flatMapSequence");
        Intrinsics.checkNotNullParameter(function1, SDKConstants.PARAM_A2U_BODY);
        Observable<R> flatMap = observable.flatMap(new h(function1));
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { body(it).toObservable() }");
        return flatMap;
    }

    @NotNull
    public static final Consumer<Throwable> getNoOpErrorConsumer() {
        return i.a;
    }

    @NotNull
    public static final <T> Observable<T> just(T t) {
        Observable<T> just = Observable.just(t);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just;
    }

    @NotNull
    public static final <T> Observable<T> merge(@NotNull Iterable<? extends Observable<? extends T>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$merge");
        Observable<T> merge = Observable.merge(toObservable(iterable));
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(this.toObservable())");
        return merge;
    }

    @NotNull
    public static final <T> Observable<T> mergeDelayError(@NotNull Iterable<? extends Observable<? extends T>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mergeDelayError");
        Observable<T> mergeDelayError = Observable.mergeDelayError(toObservable(iterable));
        Intrinsics.checkNotNullExpressionValue(mergeDelayError, "Observable.mergeDelayError(this.toObservable())");
        return mergeDelayError;
    }

    @NotNull
    public static final <T> Observable<T> mergeWith(@NotNull Observable<T> observable, @NotNull Observable<T> observable2) {
        Intrinsics.checkNotNullParameter(observable, "$this$mergeWith");
        Intrinsics.checkNotNullParameter(observable2, "other");
        Observable<T> mergeWith = observable.mergeWith(observable2);
        Intrinsics.checkNotNullExpressionValue(mergeWith, "mergeWith(other)");
        return mergeWith;
    }

    @Deprecated(message = "Define your own custom onError handler")
    public static final void noOpErrorHandler(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
    }

    @NotNull
    public static final <T1, T2, R> Observable<R> observableCombineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(observable, "o1");
        Intrinsics.checkNotNullParameter(observable2, "o2");
        Intrinsics.checkNotNullParameter(function2, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, new BiFunction<T1, T2, R>(function2) { // from class: com.avito.android.util.Observables$observableCombineLatest$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                return (R) this.a.invoke(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…eFunction(t1, t2) }\n    )");
        return combineLatest;
    }

    @NotNull
    public static final <T> Observable<T> observableFromCallableWithoutComplete(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        Observable<T> create = Observable.create(new ObservableOnSubscribe<T>(function0) { // from class: com.avito.android.util.Observables$observableFromCallableWithoutComplete$1
            public final /* synthetic */ Function0 a;

            {
                this.a = r1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.ObservableEmitter<T> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(@NotNull ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
                if (!observableEmitter.isDisposed()) {
                    try {
                        observableEmitter.onNext(this.a.invoke());
                    } catch (Throwable th) {
                        observableEmitter.tryOnError(th);
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…        }\n        }\n    }");
        return create;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: io.reactivex.Observable<U>, java.lang.Object, io.reactivex.Observable<R> */
    public static final /* synthetic */ <R> Observable<R> ofType(Observable<?> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Observable observable2 = (Observable<U>) observable.ofType(Object.class);
        Intrinsics.checkNotNullExpressionValue(observable2, "ofType(R::class.java)");
        return observable2;
    }

    @NotNull
    public static final <T> Observable<T> onError(@NotNull Observable<T> observable, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(observable, "$this$onError");
        Intrinsics.checkNotNullParameter(function1, "block");
        Observable<T> doOnError = observable.doOnError(new o(function1));
        Intrinsics.checkNotNullExpressionValue(doOnError, "doOnError(block)");
        return doOnError;
    }

    @NotNull
    public static final <T1, T2, R> Observable<R> reverseCombineLatestWith(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(observable, "$this$reverseCombineLatestWith");
        Intrinsics.checkNotNullParameter(observable2, "other");
        Intrinsics.checkNotNullParameter(function2, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable2, observable, new BiFunction<T2, T1, R>(function2) { // from class: com.avito.android.util.Observables$reverseCombineLatestWith$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(T2 t2, T1 t1) {
                return (R) this.a.invoke(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…eFunction(t1, t2) }\n    )");
        return combineLatest;
    }

    @NotNull
    public static final <T1, T2, R> Observable<R> reverseZipWith(@NotNull Function0<? extends Observable<T1>> function0, @NotNull Observable<T2> observable, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function0, "$this$reverseZipWith");
        Intrinsics.checkNotNullParameter(observable, "other");
        Intrinsics.checkNotNullParameter(function2, "zipFunction");
        Observable<R> zip = Observable.zip(observable, (ObservableSource) function0.invoke(), new BiFunction<T2, T1, R>(function2) { // from class: com.avito.android.util.Observables$reverseZipWith$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(T2 t2, T1 t1) {
                return (R) this.a.invoke(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "Observable.zip(\n        …pFunction(t1, t2) }\n    )");
        return zip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [a2.a.a.n3.o] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(message = "Define your own custom onError handler")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.disposables.Disposable subscribeIgnoreResult(@org.jetbrains.annotations.NotNull io.reactivex.Observable<?> r3) {
        /*
            java.lang.String r0 = "$this$subscribeIgnoreResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.avito.android.util.Observables$j r0 = com.avito.android.util.Observables.j.a
            com.avito.android.util.Observables$k r1 = com.avito.android.util.Observables.k.a
            if (r1 == 0) goto L_0x0011
            a2.a.a.n3.o r2 = new a2.a.a.n3.o
            r2.<init>(r1)
            r1 = r2
        L_0x0011:
            io.reactivex.functions.Consumer r1 = (io.reactivex.functions.Consumer) r1
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r0, r1)
            java.lang.String r0 = "subscribe({}, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.Observables.subscribeIgnoreResult(io.reactivex.Observable):io.reactivex.disposables.Disposable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [a2.a.a.n3.o] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.Deprecated(message = "Define your own custom onError handler")
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> io.reactivex.disposables.Disposable subscribeOnNext(@org.jetbrains.annotations.NotNull io.reactivex.Observable<T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "$this$subscribeOnNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onNext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            a2.a.a.n3.o r0 = new a2.a.a.n3.o
            r0.<init>(r3)
            com.avito.android.util.Observables$l r3 = com.avito.android.util.Observables.l.a
            if (r3 == 0) goto L_0x0019
            a2.a.a.n3.o r1 = new a2.a.a.n3.o
            r1.<init>(r3)
            r3 = r1
        L_0x0019:
            io.reactivex.functions.Consumer r3 = (io.reactivex.functions.Consumer) r3
            io.reactivex.disposables.Disposable r2 = r2.subscribe(r0, r3)
            java.lang.String r3 = "subscribe(onNext, ::noOpErrorHandler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.Observables.subscribeOnNext(io.reactivex.Observable, kotlin.jvm.functions.Function1):io.reactivex.disposables.Disposable");
    }

    @NotNull
    public static final <KeyT, EventT, OutT> Observable<OutT> switchMapByKey(@NotNull Observable<EventT> observable, @NotNull Function1<? super EventT, ? extends KeyT> function1, @NotNull Function1<? super EventT, ? extends Observable<OutT>> function12) {
        Intrinsics.checkNotNullParameter(observable, "$this$switchMapByKey");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "mapper");
        return new Observables$switchMapByKey$1(observable, function1, function12);
    }

    @NotNull
    public static final <T, R> Observable<R> switchMapFold(@NotNull Observable<arrow.core.Option<T>> observable, @NotNull Function0<? extends Observable<R>> function0, @NotNull Function1<? super T, ? extends Observable<R>> function1) {
        Intrinsics.checkNotNullParameter(observable, "$this$switchMapFold");
        Intrinsics.checkNotNullParameter(function0, "ifEmpty");
        Intrinsics.checkNotNullParameter(function1, "some");
        Observable<R> switchMap = observable.switchMap(new Function<arrow.core.Option<? extends T>, ObservableSource<? extends R>>(function0, function1) { // from class: com.avito.android.util.Observables$switchMapFold$1
            public final /* synthetic */ Function0 a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            public final ObservableSource<? extends R> apply(@NotNull arrow.core.Option<? extends T> option) {
                Object obj;
                Intrinsics.checkNotNullParameter(option, "it");
                if (option instanceof None) {
                    obj = this.a.invoke();
                } else if (option instanceof Some) {
                    obj = this.b.invoke(((Some) option).getT());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return (ObservableSource) obj;
            }

            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((arrow.core.Option) ((arrow.core.Option) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "switchMap { it.fold(ifEmpty, some) }");
        return switchMap;
    }

    @NotNull
    public static final <T> Observable<T> switchOnNext(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkNotNullParameter(observable, "$this$switchOnNext");
        Observable<T> switchOnNext = Observable.switchOnNext(observable);
        Intrinsics.checkNotNullExpressionValue(switchOnNext, "Observable.switchOnNext(this)");
        return switchOnNext;
    }

    @NotNull
    public static final <T> Observable<T> toObservable(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "$this$toObservable");
        return toObservable(new Object(it) { // from class: com.avito.android.util.Observables$toIterable$1
            public final /* synthetic */ Iterator a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<T> iterator() {
                return this.a;
            }
        });
    }

    @NotNull
    public static final <T> Observable<T> toSingletonObservable(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "$this$toSingletonObservable");
        Observable<T> just = Observable.just(t);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<OutT> */
    @NotNull
    public static final <KeyT, EventT, OutT> Observable<OutT> transformByKey(@NotNull Observable<EventT> observable, @NotNull Function1<? super EventT, ? extends KeyT> function1, @NotNull Function2<? super KeyT, ? super Observable<EventT>, ? extends Observable<OutT>> function2) {
        Intrinsics.checkNotNullParameter(observable, "$this$transformByKey");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function2, "transformer");
        Observable observable2 = (Observable<R>) observable.groupBy(new Function<EventT, KeyT>(function1) { // from class: com.avito.android.util.Observables$transformByKey$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function
            @Nullable
            public final KeyT apply(@NotNull EventT eventt) {
                Intrinsics.checkNotNullParameter(eventt, "event");
                return (KeyT) this.a.invoke(eventt);
            }
        }).flatMap(new Function<GroupedObservable<KeyT, EventT>, ObservableSource<? extends OutT>>(function2) { // from class: com.avito.android.util.Observables$transformByKey$2
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            public final ObservableSource<? extends OutT> apply(@NotNull GroupedObservable<KeyT, EventT> groupedObservable) {
                Intrinsics.checkNotNullParameter(groupedObservable, "groupedObs");
                return (ObservableSource) this.a.invoke(groupedObservable.getKey(), groupedObservable);
            }

            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((GroupedObservable) ((GroupedObservable) obj));
            }
        });
        Intrinsics.checkNotNullExpressionValue(observable2, "groupBy { event ->\n     …bs.key, groupedObs)\n    }");
        return observable2;
    }

    @NotNull
    public static final <T1, T2> Observable<Pair<T1, T2>> withLatestFrom(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkNotNullParameter(observable, "$this$withLatestFrom");
        Intrinsics.checkNotNullParameter(observable2, "other");
        Observable<R> withLatestFrom = observable.withLatestFrom(observable2, Observables$withLatestFrom$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(withLatestFrom, "withLatestFrom(other, Bi…n { t1, t2 -> t1 to t2 })");
        return withLatestFrom;
    }

    @NotNull
    public static final <T, R> Observable<R> zip(@NotNull List<? extends Observable<T>> list, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$zip");
        Intrinsics.checkNotNullParameter(function1, "zipFunction");
        Observable<R> zip = Observable.zip(list, new m(function1));
        Intrinsics.checkNotNullExpressionValue(zip, "Observable.zip(this) { z…it.asList() as List<T>) }");
        return zip;
    }

    @NotNull
    public static final <T1, T2, T3, R> Observable<R> combineLatestWith(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(observable, "$this$combineLatestWith");
        Intrinsics.checkNotNullParameter(observable2, "o2");
        Intrinsics.checkNotNullParameter(observable3, "o3");
        Intrinsics.checkNotNullParameter(function3, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, new io.reactivex.functions.Function3<T1, T2, T3, R>(function3) { // from class: com.avito.android.util.Observables$combineLatestWith$3
            public final /* synthetic */ Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                Intrinsics.checkNotNullParameter(t3, "t3");
                return (R) this.a.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…neFunction(t1, t2, t3) })");
        return combineLatest;
    }

    @Deprecated(message = "Define your own custom onError handler")
    @NotNull
    public static final <T> Disposable subscribeOnNext(@NotNull Observable<T> observable, @NotNull Consumer<T> consumer) {
        Intrinsics.checkNotNullParameter(observable, "$this$subscribeOnNext");
        Intrinsics.checkNotNullParameter(consumer, "onNext");
        Disposable subscribe = observable.subscribe(consumer, i.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(onNext, noOpErrorConsumer)");
        return subscribe;
    }

    @NotNull
    public static final <T1, T2, T3> Observable<Triple<T1, T2, T3>> withLatestFrom(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3) {
        Intrinsics.checkNotNullParameter(observable, "$this$withLatestFrom");
        Intrinsics.checkNotNullParameter(observable2, "other1");
        Intrinsics.checkNotNullParameter(observable3, "other2");
        Observable<R> withLatestFrom = observable.withLatestFrom(observable2, observable3, Observables$withLatestFrom$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(withLatestFrom, "withLatestFrom(other1, o… -> Triple(t1, t2, t3) })");
        return withLatestFrom;
    }

    @NotNull
    public static final <T1, T2> Observable<Pair<T1, T2>> observableCombineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkNotNullParameter(observable, "o1");
        Intrinsics.checkNotNullParameter(observable2, "o2");
        Observable<Pair<T1, T2>> combineLatest = Observable.combineLatest(observable, observable2, Observables$observableCombineLatest$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…1, t2 -> t1 to t2 }\n    )");
        return combineLatest;
    }

    @NotNull
    public static final <T1, T2> Observable<Pair<T1, T2>> reverseCombineLatestWith(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkNotNullParameter(observable, "$this$reverseCombineLatestWith");
        Intrinsics.checkNotNullParameter(observable2, "other");
        Observable<Pair<T1, T2>> combineLatest = Observable.combineLatest(observable2, observable, Observables$reverseCombineLatestWith$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…2, t1 -> t1 to t2 }\n    )");
        return combineLatest;
    }

    @NotNull
    public static final Observable<Boolean> toObservable(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.toList(zArr));
    }

    @NotNull
    public static final <T1, T2> Observable<Pair<T1, T2>> combineLatestWith(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkNotNullParameter(observable, "$this$combineLatestWith");
        Intrinsics.checkNotNullParameter(observable2, "o2");
        Observable<Pair<T1, T2>> combineLatest = Observable.combineLatest(observable, observable2, new BiFunction<T1, T2, R>() { // from class: com.avito.android.util.Observables$combineLatestWith$$inlined$combineLatestWith$1
            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                return (R) TuplesKt.to(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        return combineLatest;
    }

    @NotNull
    public static final <T1, T2> Observable<Pair<T1, T2>> reverseZipWith(@NotNull Function0<? extends Observable<T1>> function0, @NotNull Observable<T2> observable) {
        Intrinsics.checkNotNullParameter(function0, "$this$reverseZipWith");
        Intrinsics.checkNotNullParameter(observable, "other");
        Observable<Pair<T1, T2>> zip = Observable.zip(observable, (ObservableSource) function0.invoke(), Observables$reverseZipWith$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(zip, "Observable.zip(\n        …2, t1 -> t1 to t2 }\n    )");
        return zip;
    }

    @NotNull
    public static final Observable<Byte> toObservable(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.toList(bArr));
    }

    @NotNull
    public static final <T1, T2, T3> Observable<Triple<T1, T2, T3>> combineLatestWith(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3) {
        Intrinsics.checkNotNullParameter(observable, "$this$combineLatestWith");
        Intrinsics.checkNotNullParameter(observable2, "o2");
        Intrinsics.checkNotNullParameter(observable3, "o3");
        Observable<Triple<T1, T2, T3>> combineLatest = Observable.combineLatest(observable, observable2, observable3, new io.reactivex.functions.Function3<T1, T2, T3, R>() { // from class: com.avito.android.util.Observables$combineLatestWith$$inlined$combineLatestWith$2
            @Override // io.reactivex.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                Intrinsics.checkNotNullParameter(t3, "t3");
                return (R) new Triple(t1, t2, t3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…neFunction(t1, t2, t3) })");
        return combineLatest;
    }

    @NotNull
    public static final <T1, T2, T3, R> Observable<R> observableCombineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(observable, "o1");
        Intrinsics.checkNotNullParameter(observable2, "o2");
        Intrinsics.checkNotNullParameter(observable3, "o3");
        Intrinsics.checkNotNullParameter(function3, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, new io.reactivex.functions.Function3<T1, T2, T3, R>(function3) { // from class: com.avito.android.util.Observables$observableCombineLatest$3
            public final /* synthetic */ Function3 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                Intrinsics.checkNotNullParameter(t3, "t3");
                return (R) this.a.invoke(t1, t2, t3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ction(t1, t2, t3) }\n    )");
        return combineLatest;
    }

    @NotNull
    public static final Observable<Short> toObservable(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.toList(sArr));
    }

    @NotNull
    public static final Observable<Integer> toObservable(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.toList(iArr));
    }

    @NotNull
    public static final <T1, T2, T3> Observable<Triple<T1, T2, T3>> observableCombineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3) {
        Intrinsics.checkNotNullParameter(observable, "o1");
        Intrinsics.checkNotNullParameter(observable2, "o2");
        Intrinsics.checkNotNullParameter(observable3, "o3");
        Observable<Triple<T1, T2, T3>> combineLatest = Observable.combineLatest(observable, observable2, observable3, Observables$observableCombineLatest$4.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…riple(t1, t2, t3) }\n    )");
        return combineLatest;
    }

    @NotNull
    public static final Observable<Long> toObservable(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.toList(jArr));
    }

    @NotNull
    public static final Observable<Float> toObservable(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.toList(fArr));
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Observable<R> observableCombineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(observable, "o1");
        Intrinsics.checkNotNullParameter(observable2, "o2");
        Intrinsics.checkNotNullParameter(observable3, "o3");
        Intrinsics.checkNotNullParameter(observable4, "o4");
        Intrinsics.checkNotNullParameter(function4, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, new io.reactivex.functions.Function4<T1, T2, T3, T4, R>(function4) { // from class: com.avito.android.util.Observables$observableCombineLatest$5
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function4
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                Intrinsics.checkNotNullParameter(t3, "t3");
                Intrinsics.checkNotNullParameter(t4, "t4");
                return (R) this.a.invoke(t1, t2, t3, t4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…n(t1, t2, t3, t4) }\n    )");
        return combineLatest;
    }

    @NotNull
    public static final Observable<Double> toObservable(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.toList(dArr));
    }

    @NotNull
    public static final Observable<Integer> toObservable(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "$this$toObservable");
        if (intProgression.getStep() != 1 || ((long) intProgression.getLast()) - ((long) intProgression.getFirst()) >= ((long) Integer.MAX_VALUE)) {
            Observable<Integer> fromIterable = Observable.fromIterable(intProgression);
            Intrinsics.checkNotNullExpressionValue(fromIterable, "Observable.fromIterable(this)");
            return fromIterable;
        }
        Observable<Integer> range = Observable.range(intProgression.getFirst(), Math.max(0, (intProgression.getLast() - intProgression.getFirst()) + 1));
        Intrinsics.checkNotNullExpressionValue(range, "Observable.range(\n      …st - first + 1)\n        )");
        return range;
    }

    @NotNull
    public static final <T> Observable<T> toObservable(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toObservable");
        Observable<T> fromIterable = Observable.fromIterable(iterable);
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Observable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final <T> Observable<T> toObservable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toObservable");
        Observable<T> fromIterable = Observable.fromIterable(new Object(sequence) { // from class: com.avito.android.util.Observables$toObservable$1
            public final /* synthetic */ Sequence a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<T> iterator() {
                return this.a.iterator();
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Observable.fromIterable(…ervable.iterator()\n    })");
        return fromIterable;
    }

    @NotNull
    public static final <T> Observable<T> toObservable(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$toObservable");
        Observable<T> error = Observable.error(th);
        Intrinsics.checkNotNullExpressionValue(error, "Observable.error(this)");
        return error;
    }
}
