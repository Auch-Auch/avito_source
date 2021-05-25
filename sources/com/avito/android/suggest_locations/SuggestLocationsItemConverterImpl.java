package com.avito.android.suggest_locations;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.SuggestLocation;
import com.avito.android.remote.model.SuggestLocationsResponse;
import com.avito.android.suggest_locations.SuggestLocationsResult;
import com.avito.android.suggest_locations.adapter.SuggestLocationItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\fJ\u0015\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000fJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsItemConverterImpl;", "Lcom/avito/android/suggest_locations/SuggestLocationsItemsConverter;", "Lcom/avito/android/remote/model/SuggestLocationsResponse;", "result", "", "query", "Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "convert", "(Lcom/avito/android/remote/model/SuggestLocationsResponse;Ljava/lang/String;)Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "", "Lcom/avito/android/remote/model/SuggestLocation;", "locations", "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "entity", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "(Lcom/avito/android/remote/model/SuggestLocation;)Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "entities", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsItemConverterImpl implements SuggestLocationsItemsConverter {
    public final List<SuggestLocationItem> a(List<SuggestLocation> list) {
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(convert(it.next()));
        }
        return arrayList;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsItemsConverter
    @NotNull
    public SuggestLocationsResult convert(@NotNull SuggestLocationsResponse suggestLocationsResponse, @NotNull String str) {
        Intrinsics.checkNotNullParameter(suggestLocationsResponse, "result");
        Intrinsics.checkNotNullParameter(str, "query");
        if (suggestLocationsResponse instanceof SuggestLocationsResponse.Ok) {
            return new SuggestLocationsResult.Ok(a(((SuggestLocationsResponse.Ok) suggestLocationsResponse).getLocations()), str);
        }
        if (suggestLocationsResponse instanceof SuggestLocationsResponse.NetworkError) {
            return SuggestLocationsResult.NetworkError.INSTANCE;
        }
        if (suggestLocationsResponse instanceof SuggestLocationsResponse.Error) {
            return new SuggestLocationsResult.Error(((SuggestLocationsResponse.Error) suggestLocationsResponse).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsItemsConverter
    @NotNull
    public SuggestLocationsResult convert(@Nullable List<SuggestLocation> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        if (list != null) {
            return new SuggestLocationsResult.Ok(a(list), str);
        }
        return new SuggestLocationsResult.Error("");
    }

    @NotNull
    public final SuggestLocationItem convert(@NotNull SuggestLocation suggestLocation) {
        SuggestLocationItem.SuggestType suggestType;
        Intrinsics.checkNotNullParameter(suggestLocation, "entity");
        String id = suggestLocation.getId();
        if (id == null) {
            id = "";
        }
        CaseText names = suggestLocation.getNames();
        if (names == null) {
            names = new CaseText();
        }
        SuggestLocation.From from = suggestLocation.getFrom();
        SuggestLocationItem.Parent parent = null;
        SuggestLocationItem.From from2 = from != null ? new SuggestLocationItem.From(from.getInternalId(), from.getName(), from.getPath()) : null;
        SuggestLocation.Parent parent2 = suggestLocation.getParent();
        if (parent2 != null) {
            String id2 = parent2.getId();
            CaseText names2 = parent2.getNames();
            if (names2 == null) {
                names2 = new CaseText();
            }
            parent = new SuggestLocationItem.Parent(id2, names2);
        }
        String suggestType2 = suggestLocation.getSuggestType();
        SuggestLocationItem.SuggestType[] values = SuggestLocationItem.SuggestType.values();
        int i = 0;
        while (true) {
            if (i >= 2) {
                suggestType = SuggestLocationItem.SuggestType.DEFAULT;
                break;
            }
            SuggestLocationItem.SuggestType suggestType3 = values[i];
            if (Intrinsics.areEqual(suggestType3.getValue(), suggestType2)) {
                suggestType = suggestType3;
                break;
            }
            i++;
        }
        return new SuggestLocationItem(id, names, from2, parent, suggestType);
    }
}
