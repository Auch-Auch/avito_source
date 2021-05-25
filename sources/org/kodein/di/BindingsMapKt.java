package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.bindings.KodeinBinding;
import t6.y.m;
import x6.d.a.b;
import x6.d.a.c;
import x6.d.a.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0001\u0010\u000f\u001a\u00020\n*0\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u00020\u0000j\u0002`\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072#\u0010\f\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b2#\u0010\u000e\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001aS\u0010\u0011\u001a\u00020\n*0\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u00020\u0000j\u0002`\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aS\u0010\u0013\u001a\u00020\n*0\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u00020\u0000j\u0002`\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0012*^\u0010\u0014\",\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u00020\u00002,\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u00020\u0000¨\u0006\u0015"}, d2 = {"", "Lorg/kodein/di/Kodein$Key;", "", "Lorg/kodein/di/KodeinDefinition;", "Lorg/kodein/di/BindingsMap;", "", "withOverrides", "", "ident", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "keyBindDisp", "Lorg/kodein/di/bindings/KodeinBinding;", "bindingDisp", AuthSource.SEND_ABUSE, "(Ljava/util/Map;ZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "description", "(Ljava/util/Map;ZI)Ljava/lang/String;", "fullDescription", "BindingsMap", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class BindingsMapKt {

    public static final class a extends Lambda implements Function3<StringBuilder, Integer, List<? extends Map.Entry<? extends Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>>>, Unit> {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1, Function1 function12, boolean z) {
            super(3);
            this.a = function1;
            this.b = function12;
            this.c = z;
        }

        public final void a(@NotNull StringBuilder sb, int i, @NotNull List<? extends Map.Entry<? extends Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>>> list) {
            Intrinsics.checkParameterIsNotNull(sb, "$this$appendBindings");
            Intrinsics.checkParameterIsNotNull(list, "entries");
            for (T t : list) {
                String str = (String) this.a.invoke(t.getKey());
                sb.append(m.repeat(" ", i) + str + " with " + ((String) this.b.invoke(((KodeinDefinition) CollectionsKt___CollectionsKt.first((List<? extends Object>) ((List) t.getValue()))).getBinding())));
                if (this.c) {
                    int length = str.length() - 4;
                    Iterator it = ((List) t.getValue()).subList(1, ((List) t.getValue()).size()).iterator();
                    while (it.hasNext()) {
                        sb.append(m.repeat(" ", length) + "overrides " + ((String) this.b.invoke(((KodeinDefinition) it.next()).getBinding())));
                    }
                }
                sb.append("\n");
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(StringBuilder sb, Integer num, List<? extends Map.Entry<? extends Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>>> list) {
            a(sb, num.intValue(), list);
            return Unit.INSTANCE;
        }
    }

    public static final String a(@NotNull Map<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>> map, boolean z, int i, Function1<? super Kodein.Key<?, ?, ?>, String> function1, Function1<? super KodeinBinding<?, ?, ?>, String> function12) {
        a aVar = new a(function1, function12, z);
        Set<Map.Entry<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>>> entrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : entrySet) {
            String fromModule = ((KodeinDefinition) CollectionsKt___CollectionsKt.first((List<? extends Object>) ((List) t.getValue()))).getFromModule();
            Object obj = linkedHashMap.get(fromModule);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(fromModule, obj);
            }
            ((List) obj).add(t);
        }
        List<String> sorted = CollectionsKt___CollectionsKt.sorted(CollectionsKt___CollectionsKt.filterNotNull(linkedHashMap.keySet()));
        StringBuilder sb = new StringBuilder();
        List<? extends Map.Entry<? extends Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>>> list = (List) linkedHashMap.get(null);
        if (list != null) {
            aVar.a(sb, i, list);
        }
        for (String str : sorted) {
            sb.append(m.repeat(" ", i) + "module " + str + " {\n");
            int i2 = i + 4;
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                Intrinsics.throwNpe();
            }
            aVar.a(sb, i2, (List) obj2);
            sb.append(m.repeat(" ", i) + "}\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public static final String description(@NotNull Map<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>> map, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(map, "$this$description");
        return a(map, z, i, x6.d.a.a.a, b.a);
    }

    public static /* synthetic */ String description$default(Map map, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            i = 8;
        }
        return description(map, z, i);
    }

    @NotNull
    public static final String fullDescription(@NotNull Map<Kodein.Key<?, ?, ?>, ? extends List<? extends KodeinDefinition<?, ?, ?>>> map, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(map, "$this$fullDescription");
        return a(map, z, i, c.a, d.a);
    }

    public static /* synthetic */ String fullDescription$default(Map map, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            i = 8;
        }
        return fullDescription(map, z, i);
    }
}
