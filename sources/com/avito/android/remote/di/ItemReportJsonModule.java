package com.avito.android.remote.di;

import com.avito.android.remote.model.AdvertReport;
import com.avito.android.remote.parse.adapter.AdvertReportDeserializer;
import com.avito.android.util.TypeAdapterEntry;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/di/ItemReportJsonModule;", "", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "()Ljava/util/Set;", "<init>", "()V", "item-report_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ItemReportJsonModule {
    @NotNull
    public static final ItemReportJsonModule INSTANCE = new ItemReportJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(AdvertReport.class, new AdvertReportDeserializer()));
        return linkedHashSet;
    }
}
