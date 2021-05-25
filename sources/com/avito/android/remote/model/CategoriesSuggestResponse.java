package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/CategoriesSuggestResponse;", "", "", "Lcom/avito/android/remote/model/WizardParameter;", "suggests", "Ljava/util/List;", "getSuggests", "()Ljava/util/List;", "selectedCategory", "Lcom/avito/android/remote/model/WizardParameter;", "getSelectedCategory", "()Lcom/avito/android/remote/model/WizardParameter;", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/WizardParameter;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesSuggestResponse {
    @SerializedName("selectedCategory")
    @Nullable
    private final WizardParameter selectedCategory;
    @SerializedName("list")
    @NotNull
    private final List<WizardParameter> suggests;

    public CategoriesSuggestResponse(@NotNull List<WizardParameter> list, @Nullable WizardParameter wizardParameter) {
        Intrinsics.checkNotNullParameter(list, "suggests");
        this.suggests = list;
        this.selectedCategory = wizardParameter;
    }

    @Nullable
    public final WizardParameter getSelectedCategory() {
        return this.selectedCategory;
    }

    @NotNull
    public final List<WizardParameter> getSuggests() {
        return this.suggests;
    }
}
