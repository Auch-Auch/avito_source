package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParameters;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.category_parameters.GroupParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/parse/adapter/TabletDisplayTypeFallbackTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "T", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/parse/adapter/SearchDeviceResourcesProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/parse/adapter/SearchDeviceResourcesProvider;", "resources", "<init>", "(Lcom/avito/android/remote/parse/adapter/SearchDeviceResourcesProvider;)V", "SearchParamsResultTypeAdapter", "SerpElementResultTypeAdapter", "search_release"}, k = 1, mv = {1, 4, 2})
public final class TabletDisplayTypeFallbackTypeAdapterFactory implements TypeAdapterFactory {
    public final SearchDeviceResourcesProvider a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/parse/adapter/TabletDisplayTypeFallbackTypeAdapterFactory$SearchParamsResultTypeAdapter;", "T", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/SearchParameters;", AuthSource.SEND_ABUSE, "Lcom/google/gson/TypeAdapter;", "getOriginAdapter", "()Lcom/google/gson/TypeAdapter;", "originAdapter", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/TypeAdapterFactory;", "factory", "Lcom/google/gson/reflect/TypeToken;", "type", "<init>", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapterFactory;Lcom/google/gson/reflect/TypeToken;)V", "search_release"}, k = 1, mv = {1, 4, 2})
    public static final class SearchParamsResultTypeAdapter<T> extends TypeAdapter<SearchParameters> {
        @NotNull
        public final TypeAdapter<SearchParameters> a;

        public SearchParamsResultTypeAdapter(@NotNull Gson gson, @NotNull TypeAdapterFactory typeAdapterFactory, @NotNull TypeToken<T> typeToken) {
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(typeAdapterFactory, "factory");
            Intrinsics.checkNotNullParameter(typeToken, "type");
            TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(typeAdapterFactory, typeToken);
            Objects.requireNonNull(delegateAdapter, "null cannot be cast to non-null type com.google.gson.TypeAdapter<com.avito.android.remote.model.SearchParameters>");
            this.a = delegateAdapter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.gson.TypeAdapter
        public SearchParameters read(JsonReader jsonReader) {
            SelectParameter.Displaying displaying;
            Intrinsics.checkNotNullParameter(jsonReader, "reader");
            SearchParameters read = this.a.read(jsonReader);
            if (read == null) {
                return null;
            }
            List<ParameterSlot> parameters = read.getParameters();
            ArrayList arrayList = new ArrayList();
            for (T t : parameters) {
                T t2 = t;
                boolean z = false;
                if (t2 instanceof GroupParameter) {
                    ParameterSlot parameterSlot = t2.getParameters().get(0);
                    if (!(parameterSlot instanceof SelectParameter)) {
                        parameterSlot = null;
                    }
                    SelectParameter selectParameter = (SelectParameter) parameterSlot;
                    if (Intrinsics.areEqual((selectParameter == null || (displaying = selectParameter.getDisplaying()) == null) ? null : displaying.getType(), "serpDisplayType")) {
                        z = true;
                    }
                }
                if (!z) {
                    arrayList.add(t);
                }
            }
            return SearchParameters.copy$default(read, arrayList, null, 2, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.JsonWriter, java.lang.Object] */
        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, SearchParameters searchParameters) {
            SearchParameters searchParameters2 = searchParameters;
            Intrinsics.checkNotNullParameter(jsonWriter, "writer");
            Intrinsics.checkNotNullParameter(searchParameters2, "value");
            this.a.write(jsonWriter, searchParameters2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/parse/adapter/TabletDisplayTypeFallbackTypeAdapterFactory$SerpElementResultTypeAdapter;", "T", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/SerpElementResult;", AuthSource.SEND_ABUSE, "Lcom/google/gson/TypeAdapter;", "getOriginAdapter", "()Lcom/google/gson/TypeAdapter;", "originAdapter", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/TypeAdapterFactory;", "factory", "Lcom/google/gson/reflect/TypeToken;", "type", "<init>", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapterFactory;Lcom/google/gson/reflect/TypeToken;)V", "search_release"}, k = 1, mv = {1, 4, 2})
    public static final class SerpElementResultTypeAdapter<T> extends TypeAdapter<SerpElementResult> {
        @NotNull
        public final TypeAdapter<SerpElementResult> a;

        public SerpElementResultTypeAdapter(@NotNull Gson gson, @NotNull TypeAdapterFactory typeAdapterFactory, @NotNull TypeToken<T> typeToken) {
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(typeAdapterFactory, "factory");
            Intrinsics.checkNotNullParameter(typeToken, "type");
            TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(typeAdapterFactory, typeToken);
            Objects.requireNonNull(delegateAdapter, "null cannot be cast to non-null type com.google.gson.TypeAdapter<com.avito.android.remote.model.SerpElementResult>");
            this.a = delegateAdapter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.gson.TypeAdapter
        public SerpElementResult read(JsonReader jsonReader) {
            Intrinsics.checkNotNullParameter(jsonReader, "reader");
            SerpElementResult read = this.a.read(jsonReader);
            if (read != null) {
                return SerpElementResult.copy$default(read, null, 0, 0, null, SerpDisplayType.Grid, null, null, null, null, null, null, null, 4079, null);
            }
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.gson.stream.JsonWriter, java.lang.Object] */
        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, SerpElementResult serpElementResult) {
            SerpElementResult serpElementResult2 = serpElementResult;
            Intrinsics.checkNotNullParameter(jsonWriter, "writer");
            Intrinsics.checkNotNullParameter(serpElementResult2, "value");
            this.a.write(jsonWriter, serpElementResult2);
        }
    }

    public TabletDisplayTypeFallbackTypeAdapterFactory(@NotNull SearchDeviceResourcesProvider searchDeviceResourcesProvider) {
        Intrinsics.checkNotNullParameter(searchDeviceResourcesProvider, "resources");
        this.a = searchDeviceResourcesProvider;
    }

    @Override // com.google.gson.TypeAdapterFactory
    @Nullable
    public <T> TypeAdapter<T> create(@NotNull Gson gson, @NotNull TypeToken<T> typeToken) {
        TypeAdapter<T> typeAdapter;
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        if (!this.a.isTablet()) {
            return null;
        }
        Class<? super T> rawType = typeToken.getRawType();
        if (Intrinsics.areEqual(rawType, SerpElementResult.class)) {
            typeAdapter = new SerpElementResultTypeAdapter<>(gson, this, typeToken);
        } else {
            typeAdapter = Intrinsics.areEqual(rawType, SearchParameters.class) ? new SearchParamsResultTypeAdapter<>(gson, this, typeToken) : null;
        }
        if (!(typeAdapter instanceof TypeAdapter)) {
            return null;
        }
        return typeAdapter;
    }
}
