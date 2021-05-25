package com.avito.android.remote.model.category_parameters;

import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$Sectioned$Section;", "it", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "invoke", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$Sectioned$Section;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SelectParameter$Sectioned$listToShow$1 extends Lambda implements Function1<SelectParameter.Sectioned.Section, List<? extends ParcelableEntity<String>>> {
    public static final SelectParameter$Sectioned$listToShow$1 INSTANCE = new SelectParameter$Sectioned$listToShow$1();

    public SelectParameter$Sectioned$listToShow$1() {
        super(1);
    }

    @Nullable
    public final List<ParcelableEntity<String>> invoke(@NotNull SelectParameter.Sectioned.Section section) {
        Intrinsics.checkNotNullParameter(section, "it");
        if (section.getValues().isEmpty()) {
            return null;
        }
        String sectionTitle = section.getSectionTitle();
        if (sectionTitle == null || sectionTitle.length() == 0) {
            return section.getValues();
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(new SectionTitle(section.getSectionTitle()));
        Object[] array = section.getValues().toArray(new SelectParameter.Value[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        spreadBuilder.addSpread(array);
        return CollectionsKt__CollectionsKt.listOf((Object[]) ((ParcelableEntity[]) spreadBuilder.toArray(new ParcelableEntity[spreadBuilder.size()])));
    }
}
