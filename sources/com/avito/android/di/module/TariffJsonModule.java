package com.avito.android.di.module;

import com.avito.android.remote.model.HighDemandIcon;
import com.avito.android.remote.model.IconSection;
import com.avito.android.remote.model.TariffLandingSection;
import com.avito.android.remote.model.TextSection;
import com.avito.android.remote.model.change.TariffBenefit;
import com.avito.android.remote.model.edit.DeepLinkAction;
import com.avito.android.remote.model.edit.PackageElement;
import com.avito.android.remote.model.edit.ShowNextAction;
import com.avito.android.remote.model.edit.TariffAlertAction;
import com.avito.android.remote.model.edit.TariffEditPackage;
import com.avito.android.remote.model.edit.TariffSheetAction;
import com.avito.android.remote.parse.adapter.HighDemandIconAdapter;
import com.avito.android.remote.parse.adapter.RuntimeTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.TariffBenefitAdapter;
import com.avito.android.remote.parse.adapter.stream_gson.OptimalRuntimeTypeAdapterFactory;
import com.avito.android.util.TypeAdapterEntry;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/di/module/TariffJsonModule;", "", "", "Lcom/google/gson/TypeAdapterFactory;", "provideTariffTypeAdapterFactories", "()Ljava/util/Set;", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class TariffJsonModule {
    @NotNull
    public static final TariffJsonModule INSTANCE = new TariffJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterFactory> provideTariffTypeAdapterFactories() {
        OptimalRuntimeTypeAdapterFactory.Companion companion = OptimalRuntimeTypeAdapterFactory.Companion;
        return y.setOf((Object[]) new TypeAdapterFactory[]{companion.of(TariffLandingSection.class).registerSubtype(TextSection.class, "textSection").registerSubtype(IconSection.class, "iconSection"), companion.of(PackageElement.class).registerSubtype(TariffEditPackage.class, "package"), RuntimeTypeAdapterFactory.of(TariffAlertAction.class).registerSubtype(DeepLinkAction.class, "deeplink").registerSubtype(TariffSheetAction.class, "tariffSheet").registerSubtype(ShowNextAction.class, "showNext")});
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(TariffBenefit.class, new TariffBenefitAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(HighDemandIcon.class, new HighDemandIconAdapter()));
        return linkedHashSet;
    }
}
