package com.avito.android.location;

import android.util.SparseArray;
import com.avito.android.location.FileLocation;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SimpleLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0004¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/Location;", "location", "", "timestamp", "Lcom/avito/android/location/FileLocation;", "convertToSave", "(Lcom/avito/android/remote/model/Location;J)Lcom/avito/android/location/FileLocation;", "toFileLocation", "convertFromSaved", "(Lcom/avito/android/location/FileLocation;)Lcom/avito/android/remote/model/Location;", "toLocation", "user-location_release"}, k = 2, mv = {1, 4, 2})
public final class FileLocationKt {
    @NotNull
    public static final Location convertFromSaved(@NotNull FileLocation fileLocation) {
        SimpleLocation simpleLocation;
        Intrinsics.checkNotNullParameter(fileLocation, "location");
        String id = fileLocation.getId();
        CaseText caseText = new CaseText(fileLocation.getNames());
        boolean hasMetro = fileLocation.getHasMetro();
        boolean hasChildren = fileLocation.getHasChildren();
        boolean hasDirections = fileLocation.getHasDirections();
        boolean hasDistricts = fileLocation.getHasDistricts();
        FileLocation.Parent parent = fileLocation.getParent();
        if (parent == null) {
            simpleLocation = null;
        } else {
            simpleLocation = new SimpleLocation(parent.getId(), new CaseText(parent.getNames()));
        }
        return new Location(id, caseText, hasMetro, hasChildren, hasDirections, hasDistricts, simpleLocation, false, fileLocation.getCoordinates(), fileLocation.getForcedLocationForRecommendation(), 128, null);
    }

    @NotNull
    public static final FileLocation convertToSave(@NotNull Location location, long j) {
        FileLocation.Parent parent;
        Intrinsics.checkNotNullParameter(location, "location");
        String id = location.getId();
        SparseArray<String> names = location.getNames().getNames();
        Intrinsics.checkNotNullExpressionValue(names, "location.names.names");
        boolean hasMetro = location.getHasMetro();
        boolean hasChildren = location.getHasChildren();
        boolean hasDirections = location.getHasDirections();
        boolean hasDistricts = location.getHasDistricts();
        SimpleLocation parent2 = location.getParent();
        if (parent2 == null) {
            parent = null;
        } else {
            String id2 = parent2.getId();
            SparseArray<String> names2 = parent2.getNames().getNames();
            Intrinsics.checkNotNullExpressionValue(names2, "parent.names.names");
            parent = new FileLocation.Parent(id2, names2);
        }
        return new FileLocation(id, names, hasMetro, hasChildren, hasDirections, hasDistricts, parent, j, location.getCoordinates(), location.getForcedLocationForRecommendation());
    }

    @NotNull
    public static final FileLocation toFileLocation(@NotNull Location location, long j) {
        Intrinsics.checkNotNullParameter(location, "$this$toFileLocation");
        return convertToSave(location, j);
    }

    @NotNull
    public static final Location toLocation(@NotNull FileLocation fileLocation) {
        Intrinsics.checkNotNullParameter(fileLocation, "$this$toLocation");
        return convertFromSaved(fileLocation);
    }
}
