package org.kodein.di.internal;

import a2.g.r.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Copy;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinDefining;
import org.kodein.di.bindings.ExternalSource;
import t6.n.e;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001bJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000eR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lorg/kodein/di/internal/KodeinMainBuilderImpl;", "Lorg/kodein/di/internal/KodeinBuilderImpl;", "Lorg/kodein/di/Kodein$MainBuilder;", "Lorg/kodein/di/Kodein;", "kodein", "", "allowOverride", "Lorg/kodein/di/Copy;", "copy", "", "extend", "(Lorg/kodein/di/Kodein;ZLorg/kodein/di/Copy;)V", "Lorg/kodein/di/DKodein;", "dkodein", "(Lorg/kodein/di/DKodein;ZLorg/kodein/di/Copy;)V", "", "Lorg/kodein/di/bindings/ExternalSource;", "f", "Ljava/util/List;", "getExternalSources", "()Ljava/util/List;", "externalSources", g.a, "Z", "getFullDescriptionOnError", "()Z", "setFullDescriptionOnError", "(Z)V", "fullDescriptionOnError", "allowSilentOverride", "<init>", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public class KodeinMainBuilderImpl extends KodeinBuilderImpl implements Kodein.MainBuilder {
    @NotNull
    public final List<ExternalSource> f = new ArrayList();
    public boolean g = Kodein.Companion.getDefaultFullDescriptionOnError();

    public KodeinMainBuilderImpl(boolean z) {
        super(null, "", new HashSet(), new KodeinContainerBuilderImpl(true, z, new HashMap(), new ArrayList(), new ArrayList()));
    }

    @Override // org.kodein.di.Kodein.MainBuilder
    public void extend(@NotNull Kodein kodein, boolean z, @NotNull Copy copy) {
        Intrinsics.checkParameterIsNotNull(kodein, "kodein");
        Intrinsics.checkParameterIsNotNull(copy, "copy");
        getContainerBuilder().extend(kodein.getContainer(), z, copy.keySet(kodein.getContainer().getTree()));
        h.addAll(getExternalSources(), kodein.getContainer().getTree().getExternalSources());
        Set<String> importedModules$kodein_di_core = getImportedModules$kodein_di_core();
        Map<Kodein.Key<?, ?, ?>, List<KodeinDefining<?, ?, ?>>> bindingsMap$kodein_di_core = getContainerBuilder().getBindingsMap$kodein_di_core();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Kodein.Key<?, ?, ?>, List<KodeinDefining<?, ?, ?>>> entry : bindingsMap$kodein_di_core.entrySet()) {
            List<KodeinDefining<?, ?, ?>> value = entry.getValue();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getFromModule());
            }
            h.addAll(arrayList, arrayList2);
        }
        importedModules$kodein_di_core.addAll(CollectionsKt___CollectionsKt.filterNotNull(arrayList));
    }

    @Override // org.kodein.di.Kodein.MainBuilder
    @Nullable
    public ExternalSource getExternalSource() {
        return Kodein.MainBuilder.DefaultImpls.getExternalSource(this);
    }

    @Override // org.kodein.di.Kodein.MainBuilder
    @NotNull
    public List<ExternalSource> getExternalSources() {
        return this.f;
    }

    @Override // org.kodein.di.Kodein.MainBuilder
    public boolean getFullDescriptionOnError() {
        return this.g;
    }

    @Override // org.kodein.di.Kodein.MainBuilder
    public void setExternalSource(@Nullable ExternalSource externalSource) {
        Kodein.MainBuilder.DefaultImpls.setExternalSource(this, externalSource);
    }

    @Override // org.kodein.di.Kodein.MainBuilder
    public void setFullDescriptionOnError(boolean z) {
        this.g = z;
    }

    @Override // org.kodein.di.Kodein.MainBuilder
    public void extend(@NotNull DKodein dKodein, boolean z, @NotNull Copy copy) {
        Intrinsics.checkParameterIsNotNull(dKodein, "dkodein");
        Intrinsics.checkParameterIsNotNull(copy, "copy");
        getContainerBuilder().extend(dKodein.getContainer(), z, copy.keySet(dKodein.getContainer().getTree()));
        h.addAll(getExternalSources(), dKodein.getContainer().getTree().getExternalSources());
        Set<String> importedModules$kodein_di_core = getImportedModules$kodein_di_core();
        Map<Kodein.Key<?, ?, ?>, List<KodeinDefining<?, ?, ?>>> bindingsMap$kodein_di_core = getContainerBuilder().getBindingsMap$kodein_di_core();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Kodein.Key<?, ?, ?>, List<KodeinDefining<?, ?, ?>>> entry : bindingsMap$kodein_di_core.entrySet()) {
            List<KodeinDefining<?, ?, ?>> value = entry.getValue();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getFromModule());
            }
            h.addAll(arrayList, arrayList2);
        }
        importedModules$kodein_di_core.addAll(CollectionsKt___CollectionsKt.filterNotNull(arrayList));
    }
}
