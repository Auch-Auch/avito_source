package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.model.ProfileTab;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.bindings.ContextTranslator;
import org.kodein.di.bindings.ExternalSource;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0001\u0010\u000f\u001aL\u0012H\u0012F\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e0\f0\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u0010JW\u0010\u000f\u001aB\u0012>\u0012<\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r0\u000b\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000e0\f0\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u000f\u0010\u0013J\u0001\u0010\u0014\u001aN\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r0\u000b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e\u0018\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0004*\u00020\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H¦\u0002¢\u0006\u0004\b\u0014\u0010\u0015RD\u0010\u001a\u001a0\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r0\u000b0\u0016j\u0002`\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001c¨\u0006!"}, d2 = {"Lorg/kodein/di/KodeinTree;", "", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "T", "Lorg/kodein/di/Kodein$Key;", "key", "", "overrideLevel", "", ProfileTab.ALL, "", "Lkotlin/Triple;", "Lorg/kodein/di/KodeinDefinition;", "Lorg/kodein/di/bindings/ContextTranslator;", "find", "(Lorg/kodein/di/Kodein$Key;IZ)Ljava/util/List;", "Lorg/kodein/di/SearchSpecs;", "search", "(Lorg/kodein/di/SearchSpecs;)Ljava/util/List;", "get", "(Lorg/kodein/di/Kodein$Key;)Lkotlin/Triple;", "", "Lorg/kodein/di/BindingsMap;", "getBindings", "()Ljava/util/Map;", "bindings", "getRegisteredTranslators", "()Ljava/util/List;", "registeredTranslators", "Lorg/kodein/di/bindings/ExternalSource;", "getExternalSources", "externalSources", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface KodeinTree {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ List find$default(KodeinTree kodeinTree, Kodein.Key key, int i, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                if ((i2 & 4) != 0) {
                    z = false;
                }
                return kodeinTree.find(key, i, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: find");
        }
    }

    @NotNull
    <C, A, T> List<Triple<Kodein.Key<Object, A, T>, KodeinDefinition<Object, A, T>, ContextTranslator<C, Object>>> find(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key, int i, boolean z);

    @NotNull
    List<Triple<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>, ContextTranslator<?, ?>>> find(@NotNull SearchSpecs searchSpecs);

    @Nullable
    <C, A, T> Triple<Kodein.Key<Object, A, T>, List<KodeinDefinition<Object, A, T>>, ContextTranslator<C, Object>> get(@NotNull Kodein.Key<? super C, ? super A, ? extends T> key);

    @NotNull
    Map<Kodein.Key<?, ?, ?>, List<KodeinDefinition<?, ?, ?>>> getBindings();

    @NotNull
    List<ExternalSource> getExternalSources();

    @NotNull
    List<ContextTranslator<?, ?>> getRegisteredTranslators();
}
