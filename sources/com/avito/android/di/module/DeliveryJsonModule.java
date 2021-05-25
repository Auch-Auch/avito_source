package com.avito.android.di.module;

import com.avito.android.remote.model.delivery.DeliveryPointsResult;
import com.avito.android.remote.model.delivery.InfoBlock;
import com.avito.android.remote.model.delivery.LocationSuggestion;
import com.avito.android.remote.model.delivery.Overlay;
import com.avito.android.remote.parse.adapter.AdvertBlockDeserializer;
import com.avito.android.remote.parse.adapter.AttributesBlockDeserializer;
import com.avito.android.remote.parse.adapter.DeliveryPointsSuccessAdapter;
import com.avito.android.remote.parse.adapter.InfoBlockTypeAdapter;
import com.avito.android.remote.parse.adapter.LocationSuggestionTypeAdapter;
import com.avito.android.remote.parse.adapter.OverlayTypeAdapter;
import com.avito.android.remote.parse.adapter.PriceBlockDeserializer;
import com.avito.android.remote.parse.adapter.TextBlockDeserializer;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import com.avito.android.util.TypeAdapterEntry;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/di/module/DeliveryJsonModule;", "", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "()Ljava/util/Set;", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class DeliveryJsonModule {
    @NotNull
    public static final DeliveryJsonModule INSTANCE = new DeliveryJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return GsonSetsKt.registerCustomType(new LinkedHashSet(), DeliveryPointsResult.class, r.mapOf(TuplesKt.to("ok", DeliveryPointsResult.Success.class), TuplesKt.to("delivery-unavailable", DeliveryPointsResult.DeliveryUnavailable.class)));
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(LocationSuggestion.class, new LocationSuggestionTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(InfoBlock.class, new InfoBlockTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(InfoBlock.TextBlock.class, new TextBlockDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(InfoBlock.PriceBlock.class, new PriceBlockDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(InfoBlock.AttributesBlock.class, new AttributesBlockDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(InfoBlock.AdvertBlock.class, new AdvertBlockDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(DeliveryPointsResult.Success.class, new DeliveryPointsSuccessAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(Overlay.class, new OverlayTypeAdapter()));
        return linkedHashSet;
    }
}
