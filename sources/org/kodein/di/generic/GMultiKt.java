package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAware;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.KodeinPropertyMap;
import org.kodein.di.Multi2;
import org.kodein.di.Multi3;
import org.kodein.di.Multi4;
import org.kodein.di.Multi5;
import org.kodein.di.TypeReference;
import org.kodein.di.TypeToken;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.BindingKodein;
import org.kodein.di.bindings.Factory;
import org.kodein.di.bindings.Multiton;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Scope;
import org.kodein.di.bindings.SimpleBindingKodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0001\u0010\f\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u0004\u0012\u00028\u00030\n\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\n\b\u0003\u0010\u0004\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00052+\b\b\u0010\t\u001a%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\b\bH\b¢\u0006\u0004\b\f\u0010\r\u001a\u0001\u0010\f\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0010\u0012\u0004\u0012\u00028\u00040\n\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u000e\u0018\u0001\"\n\b\u0004\u0010\u0004\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u000521\b\b\u0010\t\u001a+\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000f¢\u0006\u0002\b\bH\b¢\u0006\u0004\b\f\u0010\u0011\u001a¯\u0001\u0010\f\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0014\u0012\u0004\u0012\u00028\u00050\n\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u000e\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\n\b\u0005\u0010\u0004\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u000527\b\b\u0010\t\u001a1\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0013¢\u0006\u0002\b\bH\b¢\u0006\u0004\b\f\u0010\u0015\u001aÃ\u0001\u0010\f\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0018\u0012\u0004\u0012\u00028\u00060\n\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u000e\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\n\b\u0006\u0010\u0004\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00052=\b\b\u0010\t\u001a7\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u0017¢\u0006\u0002\b\bH\b¢\u0006\u0004\b\f\u0010\u0019\u001a\u0001\u0010!\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u0004\u0012\u00028\u00030 \"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\n\b\u0003\u0010\u0004\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2+\b\b\u0010\t\u001a%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\b\bH\b¢\u0006\u0004\b!\u0010\"\u001a±\u0001\u0010!\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0010\u0012\u0004\u0012\u00028\u00040 \"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u000e\u0018\u0001\"\n\b\u0004\u0010\u0004\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d21\b\b\u0010\t\u001a+\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000f¢\u0006\u0002\b\bH\b¢\u0006\u0004\b!\u0010#\u001aÅ\u0001\u0010!\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0014\u0012\u0004\u0012\u00028\u00050 \"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u000e\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\n\b\u0005\u0010\u0004\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d27\b\b\u0010\t\u001a1\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0013¢\u0006\u0002\b\bH\b¢\u0006\u0004\b!\u0010$\u001aÙ\u0001\u0010!\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0018\u0012\u0004\u0012\u00028\u00060 \"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u000e\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\n\b\u0006\u0010\u0004\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2=\b\b\u0010\t\u001a7\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u0017¢\u0006\u0002\b\bH\b¢\u0006\u0004\b!\u0010%\u001a<\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0001H\b¢\u0006\u0004\b(\u0010)\u001aR\u0010(\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u00012\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u00012\u0006\u0010*\u001a\u00028\u0002H\b¢\u0006\u0004\b(\u0010+\u001ah\u0010(\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0014\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u00012\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u00012\u0006\u0010*\u001a\u00028\u00022\u0006\u0010,\u001a\u00028\u0003H\b¢\u0006\u0004\b(\u0010-\u001a~\u0010(\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0018\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0016\u0018\u00012\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u00012\u0006\u0010*\u001a\u00028\u00022\u0006\u0010,\u001a\u00028\u00032\u0006\u0010.\u001a\u00028\u0004H\b¢\u0006\u0004\b(\u0010/\u001ar\u00105\u001a8\u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u000203\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020402\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\n\b\u0002\u0010\u0004\u0018\u0001*\u00020\u0003*\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b5\u00106\u001a\u0001\u00107\u001aD\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010\u0012\u0004\u0012\u00028\u000303\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000602\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\n\b\u0003\u0010\u0004\u0018\u0001*\u00020\u0003*\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b7\u00106\u001a\u0001\u00108\u001aP\u0012(\u0012&\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0014\u0012\u0004\u0012\u00028\u000403\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000f02\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\n\b\u0004\u0010\u0004\u0018\u0001*\u00020\u0003*\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b8\u00106\u001a®\u0001\u00109\u001a\\\u0012.\u0012,\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0018\u0012\u0004\u0012\u00028\u000503\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001302\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0016\u0018\u0001\"\n\b\u0005\u0010\u0004\u0018\u0001*\u00020\u0003*\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b9\u00106\u001av\u0010:\u001a<\u0012\u001e\u0012\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0002\u0018\u000103\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010402\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\n\b\u0002\u0010\u0004\u0018\u0001*\u00020\u0003*\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b:\u00106\u001a\u0001\u0010;\u001aH\u0012$\u0012\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010\u0012\u0004\u0012\u00028\u0003\u0018\u000103\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u000602\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\n\b\u0003\u0010\u0004\u0018\u0001*\u00020\u0003*\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b;\u00106\u001a\u0001\u0010<\u001aT\u0012*\u0012(\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0014\u0012\u0004\u0012\u00028\u0004\u0018\u000103\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0018\u00010\u000f02\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\n\b\u0004\u0010\u0004\u0018\u0001*\u00020\u0003*\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b<\u00106\u001a²\u0001\u0010=\u001a`\u00120\u0012.\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0018\u0012\u0004\u0012\u00028\u0005\u0018\u000103\u0012*\u0012(\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u001302\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0016\u0018\u0001\"\n\b\u0005\u0010\u0004\u0018\u0001*\u00020\u0003*\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b=\u00106\u001aN\u00105\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u000204\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\n\b\u0002\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020>2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b5\u0010?\u001a\\\u00107\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\n\b\u0003\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020>2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b7\u0010@\u001aj\u00108\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u000f\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\n\b\u0004\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020>2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b8\u0010A\u001ax\u00109\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0013\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0016\u0018\u0001\"\n\b\u0005\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020>2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b9\u0010B\u001aP\u0010:\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u000104\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\n\b\u0002\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020>2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b:\u0010?\u001a^\u0010;\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0006\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\n\b\u0003\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020>2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b;\u0010@\u001al\u0010<\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0018\u00010\u000f\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\n\b\u0004\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020>2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b<\u0010A\u001az\u0010=\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u0013\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u000e\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0016\u0018\u0001\"\n\b\u0005\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020>2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b=\u0010B¨\u0006C"}, d2 = {"C", "A1", "A2", "", "T", "Lorg/kodein/di/Kodein$BindBuilder$WithContext;", "Lkotlin/Function3;", "Lorg/kodein/di/bindings/BindingKodein;", "Lkotlin/ExtensionFunctionType;", "creator", "Lorg/kodein/di/bindings/Factory;", "Lorg/kodein/di/Multi2;", "factory", "(Lorg/kodein/di/Kodein$BindBuilder$WithContext;Lkotlin/jvm/functions/Function3;)Lorg/kodein/di/bindings/Factory;", "A3", "Lkotlin/Function4;", "Lorg/kodein/di/Multi3;", "(Lorg/kodein/di/Kodein$BindBuilder$WithContext;Lkotlin/jvm/functions/Function4;)Lorg/kodein/di/bindings/Factory;", "A4", "Lkotlin/Function5;", "Lorg/kodein/di/Multi4;", "(Lorg/kodein/di/Kodein$BindBuilder$WithContext;Lkotlin/jvm/functions/Function5;)Lorg/kodein/di/bindings/Factory;", "A5", "Lkotlin/Function6;", "Lorg/kodein/di/Multi5;", "(Lorg/kodein/di/Kodein$BindBuilder$WithContext;Lkotlin/jvm/functions/Function6;)Lorg/kodein/di/bindings/Factory;", "Lorg/kodein/di/Kodein$BindBuilder$WithScope;", "Lorg/kodein/di/bindings/RefMaker;", "ref", "", "sync", "Lorg/kodein/di/bindings/SimpleBindingKodein;", "Lorg/kodein/di/bindings/Multiton;", "multiton", "(Lorg/kodein/di/Kodein$BindBuilder$WithScope;Lorg/kodein/di/bindings/RefMaker;ZLkotlin/jvm/functions/Function3;)Lorg/kodein/di/bindings/Multiton;", "(Lorg/kodein/di/Kodein$BindBuilder$WithScope;Lorg/kodein/di/bindings/RefMaker;ZLkotlin/jvm/functions/Function4;)Lorg/kodein/di/bindings/Multiton;", "(Lorg/kodein/di/Kodein$BindBuilder$WithScope;Lorg/kodein/di/bindings/RefMaker;ZLkotlin/jvm/functions/Function5;)Lorg/kodein/di/bindings/Multiton;", "(Lorg/kodein/di/Kodein$BindBuilder$WithScope;Lorg/kodein/di/bindings/RefMaker;ZLkotlin/jvm/functions/Function6;)Lorg/kodein/di/bindings/Multiton;", "a1", "a2", "M", "(Ljava/lang/Object;Ljava/lang/Object;)Lorg/kodein/di/Multi2;", "a3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lorg/kodein/di/Multi3;", "a4", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lorg/kodein/di/Multi4;", "a5", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lorg/kodein/di/Multi5;", "Lorg/kodein/di/KodeinAware;", "tag", "Lorg/kodein/di/KodeinPropertyMap;", "Lkotlin/Function1;", "Lkotlin/Function2;", "factory2", "(Lorg/kodein/di/KodeinAware;Ljava/lang/Object;)Lorg/kodein/di/KodeinPropertyMap;", "factory3", "factory4", "factory5", "factory2OrNull", "factory3OrNull", "factory4OrNull", "factory5OrNull", "Lorg/kodein/di/DKodein;", "(Lorg/kodein/di/DKodein;Ljava/lang/Object;)Lkotlin/jvm/functions/Function2;", "(Lorg/kodein/di/DKodein;Ljava/lang/Object;)Lkotlin/jvm/functions/Function3;", "(Lorg/kodein/di/DKodein;Ljava/lang/Object;)Lkotlin/jvm/functions/Function4;", "(Lorg/kodein/di/DKodein;Ljava/lang/Object;)Lkotlin/jvm/functions/Function5;", "kodein-di-generic-jvm"}, k = 2, mv = {1, 4, 0})
public final class GMultiKt {
    @NotNull
    public static final /* synthetic */ <A1, A2> Multi2<A1, A2> M(A1 a1, A2 a22) {
        return new Multi2<>(a1, a22, TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$M$$inlined$generic$1
        }));
    }

    @NotNull
    public static final /* synthetic */ <C, A1, A2, T> Factory<C, Multi2<A1, A2>, T> factory(@NotNull Kodein.BindBuilder.WithContext<C> withContext, @NotNull Function3<? super BindingKodein<? extends C>, ? super A1, ? super A2, ? extends T> function3) {
        Intrinsics.checkParameterIsNotNull(withContext, "$this$factory");
        Intrinsics.checkParameterIsNotNull(function3, "creator");
        TypeToken<C> contextType = withContext.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new Factory<>(contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory$$inlined$generic$2
        }), new Function2<BindingKodein<? extends C>, Multi2<A1, A2>, T>(function3) { // from class: org.kodein.di.generic.GMultiKt$factory$1
            public final /* synthetic */ Function3 a;

            {
                this.a = r1;
            }

            @NotNull
            public final T invoke(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Multi2<A1, A2> multi2) {
                Intrinsics.checkParameterIsNotNull(bindingKodein, "$receiver");
                Intrinsics.checkParameterIsNotNull(multi2, "it");
                return (T) this.a.invoke(bindingKodein, multi2.getA1(), multi2.getA2());
            }
        });
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, T> KodeinPropertyMap<Function1<? super Multi2<A1, A2>, ? extends T>, Function2<A1, A2, T>> factory2(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory2");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory2$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap<>(KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory2$$inlined$generic$2
        }), obj), GMultiKt$factory2$1.INSTANCE);
    }

    public static /* synthetic */ KodeinPropertyMap factory2$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory2");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory2$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap(KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory2$$inlined$generic$4
        }), obj), GMultiKt$factory2$1.INSTANCE);
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, T> KodeinPropertyMap<Function1<? super Multi2<A1, A2>, ? extends T>, Function2<A1, A2, T>> factory2OrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory2OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory2OrNull$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap<>(KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory2OrNull$$inlined$generic$2
        }), obj), GMultiKt$factory2OrNull$1.INSTANCE);
    }

    public static /* synthetic */ KodeinPropertyMap factory2OrNull$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory2OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory2OrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap(KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory2OrNull$$inlined$generic$4
        }), obj), GMultiKt$factory2OrNull$1.INSTANCE);
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, T> KodeinPropertyMap<Function1<? super Multi3<A1, A2, A3>, ? extends T>, Function3<A1, A2, A3, T>> factory3(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory3");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$factory3$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap<>(KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory3$$inlined$generic$2
        }), obj), GMultiKt$factory3$1.INSTANCE);
    }

    public static /* synthetic */ KodeinPropertyMap factory3$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory3");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$factory3$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap(KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory3$$inlined$generic$4
        }), obj), GMultiKt$factory3$1.INSTANCE);
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, T> KodeinPropertyMap<Function1<? super Multi3<A1, A2, A3>, ? extends T>, Function3<A1, A2, A3, T>> factory3OrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory3OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$factory3OrNull$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap<>(KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory3OrNull$$inlined$generic$2
        }), obj), GMultiKt$factory3OrNull$1.INSTANCE);
    }

    public static /* synthetic */ KodeinPropertyMap factory3OrNull$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory3OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$factory3OrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap(KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory3OrNull$$inlined$generic$4
        }), obj), GMultiKt$factory3OrNull$1.INSTANCE);
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, A4, T> KodeinPropertyMap<Function1<? super Multi4<A1, A2, A3, A4>, ? extends T>, Function4<A1, A2, A3, A4, T>> factory4(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory4");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory4$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap<>(KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory4$$inlined$generic$2
        }), obj), GMultiKt$factory4$1.INSTANCE);
    }

    public static /* synthetic */ KodeinPropertyMap factory4$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory4");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory4$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap(KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory4$$inlined$generic$4
        }), obj), GMultiKt$factory4$1.INSTANCE);
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, A4, T> KodeinPropertyMap<Function1<? super Multi4<A1, A2, A3, A4>, ? extends T>, Function4<A1, A2, A3, A4, T>> factory4OrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory4OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap<>(KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$$inlined$generic$2
        }), obj), GMultiKt$factory4OrNull$1.INSTANCE);
    }

    public static /* synthetic */ KodeinPropertyMap factory4OrNull$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory4OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap(KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$$inlined$generic$4
        }), obj), GMultiKt$factory4OrNull$1.INSTANCE);
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, A4, A5, T> KodeinPropertyMap<Function1<? super Multi5<A1, A2, A3, A4, A5>, ? extends T>, Function5<A1, A2, A3, A4, A5, T>> factory5(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory5");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$factory5$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap<>(KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory5$$inlined$generic$2
        }), obj), GMultiKt$factory5$1.INSTANCE);
    }

    public static /* synthetic */ KodeinPropertyMap factory5$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory5");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$factory5$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap(KodeinAwareKt.Factory(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory5$$inlined$generic$4
        }), obj), GMultiKt$factory5$1.INSTANCE);
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, A4, A5, T> KodeinPropertyMap<Function1<? super Multi5<A1, A2, A3, A4, A5>, ? extends T>, Function5<A1, A2, A3, A4, A5, T>> factory5OrNull(@NotNull KodeinAware kodeinAware, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory5OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$factory5OrNull$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap<>(KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory5OrNull$$inlined$generic$2
        }), obj), GMultiKt$factory5OrNull$1.INSTANCE);
    }

    public static /* synthetic */ KodeinPropertyMap factory5OrNull$default(KodeinAware kodeinAware, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(kodeinAware, "$this$factory5OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$factory5OrNull$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new KodeinPropertyMap(KodeinAwareKt.FactoryOrNull(kodeinAware, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory5OrNull$$inlined$generic$4
        }), obj), GMultiKt$factory5OrNull$1.INSTANCE);
    }

    @NotNull
    public static final /* synthetic */ <C, A1, A2, T> Multiton<C, Multi2<A1, A2>, T> multiton(@NotNull Kodein.BindBuilder.WithScope<C> withScope, @Nullable RefMaker refMaker, boolean z, @NotNull Function3<? super SimpleBindingKodein<? extends C>, ? super A1, ? super A2, ? extends T> function3) {
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function3, "creator");
        Scope<C> scope = withScope.getScope();
        TypeToken<C> contextType = withScope.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new Multiton<>(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$2
        }), refMaker, z, new GMultiKt$multiton$1(function3));
    }

    public static /* synthetic */ Multiton multiton$default(Kodein.BindBuilder.WithScope withScope, RefMaker refMaker, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            refMaker = null;
        }
        boolean z2 = (i & 2) != 0 ? true : z;
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function3, "creator");
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new Multiton(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$4
        }), refMaker, z2, new GMultiKt$multiton$1(function3));
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3> Multi3<A1, A2, A3> M(A1 a1, A2 a22, A3 a3) {
        return new Multi3<>(a1, a22, a3, TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$M$$inlined$generic$2
        }));
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, T> Function2<A1, A2, T> factory2(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory2");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory2$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return new GMultiKt$factory2$2$1(dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory2$$inlined$generic$6
        }), obj));
    }

    @Nullable
    public static final /* synthetic */ <A1, A2, T> Function2<A1, A2, T> factory2OrNull(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory2OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory2OrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dKodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory2OrNull$$inlined$generic$6
        }), obj);
        if (FactoryOrNull != null) {
            return new GMultiKt$factory2OrNull$2$1$1(FactoryOrNull);
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, T> Function3<A1, A2, A3, T> factory3(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory3");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$factory3$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return new GMultiKt$factory3$2$1(dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory3$$inlined$generic$6
        }), obj));
    }

    @Nullable
    public static final /* synthetic */ <A1, A2, A3, T> Function3<A1, A2, A3, T> factory3OrNull(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory3OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$factory3OrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dKodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory3OrNull$$inlined$generic$6
        }), obj);
        if (FactoryOrNull != null) {
            return new GMultiKt$factory3OrNull$2$1$1(FactoryOrNull);
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, A4, T> Function4<A1, A2, A3, A4, T> factory4(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory4");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory4$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return new GMultiKt$factory4$2$1(dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory4$$inlined$generic$6
        }), obj));
    }

    @Nullable
    public static final /* synthetic */ <A1, A2, A3, A4, T> Function4<A1, A2, A3, A4, T> factory4OrNull(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory4OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dKodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$$inlined$generic$6
        }), obj);
        if (FactoryOrNull != null) {
            return new GMultiKt$factory4OrNull$2$1$1(FactoryOrNull);
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, A4, A5, T> Function5<A1, A2, A3, A4, A5, T> factory5(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory5");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$factory5$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return new GMultiKt$factory5$2$1(dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory5$$inlined$generic$6
        }), obj));
    }

    @Nullable
    public static final /* synthetic */ <A1, A2, A3, A4, A5, T> Function5<A1, A2, A3, A4, A5, T> factory5OrNull(@NotNull DKodein dKodein, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory5OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$factory5OrNull$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dKodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory5OrNull$$inlined$generic$6
        }), obj);
        if (FactoryOrNull != null) {
            return new GMultiKt$factory5OrNull$2$1$1(FactoryOrNull);
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, A4> Multi4<A1, A2, A3, A4> M(A1 a1, A2 a22, A3 a3, A4 a4) {
        return new Multi4<>(a1, a22, a3, a4, TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$M$$inlined$generic$3
        }));
    }

    @NotNull
    public static final /* synthetic */ <C, A1, A2, A3, T> Factory<C, Multi3<A1, A2, A3>, T> factory(@NotNull Kodein.BindBuilder.WithContext<C> withContext, @NotNull Function4<? super BindingKodein<? extends C>, ? super A1, ? super A2, ? super A3, ? extends T> function4) {
        Intrinsics.checkParameterIsNotNull(withContext, "$this$factory");
        Intrinsics.checkParameterIsNotNull(function4, "creator");
        TypeToken<C> contextType = withContext.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$factory$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new Factory<>(contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory$$inlined$generic$4
        }), new Function2<BindingKodein<? extends C>, Multi3<A1, A2, A3>, T>(function4) { // from class: org.kodein.di.generic.GMultiKt$factory$2
            public final /* synthetic */ Function4 a;

            {
                this.a = r1;
            }

            @NotNull
            public final T invoke(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Multi3<A1, A2, A3> multi3) {
                Intrinsics.checkParameterIsNotNull(bindingKodein, "$receiver");
                Intrinsics.checkParameterIsNotNull(multi3, "it");
                return (T) this.a.invoke(bindingKodein, multi3.getA1(), multi3.getA2(), multi3.getA3());
            }
        });
    }

    public static /* synthetic */ Function2 factory2$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory2");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory2$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        return new GMultiKt$factory2$2$1(dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory2$$inlined$generic$8
        }), obj));
    }

    public static /* synthetic */ Function2 factory2OrNull$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory2OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi2<A1, A2>>() { // from class: org.kodein.di.generic.GMultiKt$factory2OrNull$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dKodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory2OrNull$$inlined$generic$8
        }), obj);
        if (FactoryOrNull != null) {
            return new GMultiKt$factory2OrNull$2$1$1(FactoryOrNull);
        }
        return null;
    }

    public static /* synthetic */ Function3 factory3$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory3");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$factory3$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        return new GMultiKt$factory3$2$1(dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory3$$inlined$generic$8
        }), obj));
    }

    public static /* synthetic */ Function3 factory3OrNull$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory3OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$factory3OrNull$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dKodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory3OrNull$$inlined$generic$8
        }), obj);
        if (FactoryOrNull != null) {
            return new GMultiKt$factory3OrNull$2$1$1(FactoryOrNull);
        }
        return null;
    }

    public static /* synthetic */ Function4 factory4$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory4");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory4$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        return new GMultiKt$factory4$2$1(dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory4$$inlined$generic$8
        }), obj));
    }

    public static /* synthetic */ Function4 factory4OrNull$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory4OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dKodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory4OrNull$$inlined$generic$8
        }), obj);
        if (FactoryOrNull != null) {
            return new GMultiKt$factory4OrNull$2$1$1(FactoryOrNull);
        }
        return null;
    }

    public static /* synthetic */ Function5 factory5$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory5");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$factory5$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        return new GMultiKt$factory5$2$1(dKodein.Factory(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory5$$inlined$generic$8
        }), obj));
    }

    public static /* synthetic */ Function5 factory5OrNull$default(DKodein dKodein, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(dKodein, "$this$factory5OrNull");
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$factory5OrNull$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        Function1 FactoryOrNull = dKodein.FactoryOrNull(TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory5OrNull$$inlined$generic$8
        }), obj);
        if (FactoryOrNull != null) {
            return new GMultiKt$factory5OrNull$2$1$1(FactoryOrNull);
        }
        return null;
    }

    @NotNull
    public static final /* synthetic */ <C, A1, A2, A3, T> Multiton<C, Multi3<A1, A2, A3>, T> multiton(@NotNull Kodein.BindBuilder.WithScope<C> withScope, @Nullable RefMaker refMaker, boolean z, @NotNull Function4<? super SimpleBindingKodein<? extends C>, ? super A1, ? super A2, ? super A3, ? extends T> function4) {
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function4, "creator");
        Scope<C> scope = withScope.getScope();
        TypeToken<C> contextType = withScope.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return new Multiton<>(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$6
        }), refMaker, z, new GMultiKt$multiton$2(function4));
    }

    public static /* synthetic */ Multiton multiton$default(Kodein.BindBuilder.WithScope withScope, RefMaker refMaker, boolean z, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            refMaker = null;
        }
        boolean z2 = (i & 2) != 0 ? true : z;
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function4, "creator");
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi3<A1, A2, A3>>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        return new Multiton(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$8
        }), refMaker, z2, new GMultiKt$multiton$2(function4));
    }

    @NotNull
    public static final /* synthetic */ <A1, A2, A3, A4, A5> Multi5<A1, A2, A3, A4, A5> M(A1 a1, A2 a22, A3 a3, A4 a4, A5 a5) {
        return new Multi5<>(a1, a22, a3, a4, a5, TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$M$$inlined$generic$4
        }));
    }

    @NotNull
    public static final /* synthetic */ <C, A1, A2, A3, A4, T> Factory<C, Multi4<A1, A2, A3, A4>, T> factory(@NotNull Kodein.BindBuilder.WithContext<C> withContext, @NotNull Function5<? super BindingKodein<? extends C>, ? super A1, ? super A2, ? super A3, ? super A4, ? extends T> function5) {
        Intrinsics.checkParameterIsNotNull(withContext, "$this$factory");
        Intrinsics.checkParameterIsNotNull(function5, "creator");
        TypeToken<C> contextType = withContext.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$factory$$inlined$generic$5
        });
        Intrinsics.needClassReification();
        return new Factory<>(contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory$$inlined$generic$6
        }), new Function2<BindingKodein<? extends C>, Multi4<A1, A2, A3, A4>, T>(function5) { // from class: org.kodein.di.generic.GMultiKt$factory$3
            public final /* synthetic */ Function5 a;

            {
                this.a = r1;
            }

            @NotNull
            public final T invoke(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Multi4<A1, A2, A3, A4> multi4) {
                Intrinsics.checkParameterIsNotNull(bindingKodein, "$receiver");
                Intrinsics.checkParameterIsNotNull(multi4, "it");
                return (T) this.a.invoke(bindingKodein, multi4.getA1(), multi4.getA2(), multi4.getA3(), multi4.getA4());
            }
        });
    }

    @NotNull
    public static final /* synthetic */ <C, A1, A2, A3, A4, T> Multiton<C, Multi4<A1, A2, A3, A4>, T> multiton(@NotNull Kodein.BindBuilder.WithScope<C> withScope, @Nullable RefMaker refMaker, boolean z, @NotNull Function5<? super SimpleBindingKodein<? extends C>, ? super A1, ? super A2, ? super A3, ? super A4, ? extends T> function5) {
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function5, "creator");
        Scope<C> scope = withScope.getScope();
        TypeToken<C> contextType = withScope.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$9
        });
        Intrinsics.needClassReification();
        return new Multiton<>(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$10
        }), refMaker, z, new GMultiKt$multiton$3(function5));
    }

    public static /* synthetic */ Multiton multiton$default(Kodein.BindBuilder.WithScope withScope, RefMaker refMaker, boolean z, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            refMaker = null;
        }
        boolean z2 = (i & 2) != 0 ? true : z;
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function5, "creator");
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi4<A1, A2, A3, A4>>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$11
        });
        Intrinsics.needClassReification();
        return new Multiton(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$12
        }), refMaker, z2, new GMultiKt$multiton$3(function5));
    }

    @NotNull
    public static final /* synthetic */ <C, A1, A2, A3, A4, A5, T> Factory<C, Multi5<A1, A2, A3, A4, A5>, T> factory(@NotNull Kodein.BindBuilder.WithContext<C> withContext, @NotNull Function6<? super BindingKodein<? extends C>, ? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? extends T> function6) {
        Intrinsics.checkParameterIsNotNull(withContext, "$this$factory");
        Intrinsics.checkParameterIsNotNull(function6, "creator");
        TypeToken<C> contextType = withContext.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$factory$$inlined$generic$7
        });
        Intrinsics.needClassReification();
        return new Factory<>(contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$factory$$inlined$generic$8
        }), new Function2<BindingKodein<? extends C>, Multi5<A1, A2, A3, A4, A5>, T>(function6) { // from class: org.kodein.di.generic.GMultiKt$factory$4
            public final /* synthetic */ Function6 a;

            {
                this.a = r1;
            }

            @NotNull
            public final T invoke(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Multi5<A1, A2, A3, A4, A5> multi5) {
                Intrinsics.checkParameterIsNotNull(bindingKodein, "$receiver");
                Intrinsics.checkParameterIsNotNull(multi5, "it");
                return (T) this.a.invoke(bindingKodein, multi5.getA1(), multi5.getA2(), multi5.getA3(), multi5.getA4(), multi5.getA5());
            }
        });
    }

    @NotNull
    public static final /* synthetic */ <C, A1, A2, A3, A4, A5, T> Multiton<C, Multi5<A1, A2, A3, A4, A5>, T> multiton(@NotNull Kodein.BindBuilder.WithScope<C> withScope, @Nullable RefMaker refMaker, boolean z, @NotNull Function6<? super SimpleBindingKodein<? extends C>, ? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? extends T> function6) {
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function6, "creator");
        Scope<C> scope = withScope.getScope();
        TypeToken<C> contextType = withScope.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$13
        });
        Intrinsics.needClassReification();
        return new Multiton<>(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$14
        }), refMaker, z, new GMultiKt$multiton$4(function6));
    }

    public static /* synthetic */ Multiton multiton$default(Kodein.BindBuilder.WithScope withScope, RefMaker refMaker, boolean z, Function6 function6, int i, Object obj) {
        if ((i & 1) != 0) {
            refMaker = null;
        }
        boolean z2 = (i & 2) != 0 ? true : z;
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function6, "creator");
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        TypeToken TT = TypesKt.TT(new TypeReference<Multi5<A1, A2, A3, A4, A5>>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$15
        });
        Intrinsics.needClassReification();
        return new Multiton(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GMultiKt$multiton$$inlined$generic$16
        }), refMaker, z2, new GMultiKt$multiton$4(function6));
    }
}
