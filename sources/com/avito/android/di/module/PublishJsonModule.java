package com.avito.android.di.module;

import com.avito.android.remote.model.PostAdvertResult;
import com.avito.android.remote.model.PublishDraftResponse;
import com.avito.android.remote.model.SaveDraftResponse;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
import com.avito.android.remote.model.category_parameters.AttributeNode;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import com.avito.android.remote.model.search.suggest.SuggestDeeplink;
import com.avito.android.remote.model.search.suggest.SuggestNewQuery;
import com.avito.android.remote.parse.adapter.AttributeNodeDeserializer;
import com.avito.android.remote.parse.adapter.AttributeNodeSerializer;
import com.avito.android.remote.parse.adapter.DisplayingOptionsDeserializer;
import com.avito.android.remote.parse.adapter.DisplayingSelectParameterDeserializer;
import com.avito.android.remote.parse.adapter.PostAdvertResultDeserializer;
import com.avito.android.remote.parse.adapter.ProactiveModerationDuplicateDeserializer;
import com.avito.android.remote.parse.adapter.ProactiveModerationWrongCategoryDeserializer;
import com.avito.android.remote.parse.adapter.RuntimeTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.stream_gson.OptimalRuntimeTypeAdapterFactory;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import com.avito.android.util.TypeAdapterEntry;
import com.google.gson.TypeAdapterFactory;
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
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/avito/android/di/module/PublishJsonModule;", "", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "()Ljava/util/Set;", "Lcom/google/gson/TypeAdapterFactory;", "provideTypeAdapterFactories", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishJsonModule {
    @NotNull
    public static final PublishJsonModule INSTANCE = new PublishJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(new LinkedHashSet(), AdvertProactiveModerationResult.class, r.mapOf(TuplesKt.to("ok", AdvertProactiveModerationResult.Ok.class), TuplesKt.to("duplicate-found", AdvertProactiveModerationResult.Duplicate.class), TuplesKt.to("wrong-category-found", AdvertProactiveModerationResult.WrongCategory.class))), PublishDraftResponse.class, r.mapOf(TuplesKt.to("ok", PublishDraftResponse.Ok.class), TuplesKt.to("not-found", PublishDraftResponse.NotFound.class))), SaveDraftResponse.class, r.mapOf(TuplesKt.to("ok", SaveDraftResponse.Ok.class), TuplesKt.to("conflict", SaveDraftResponse.Conflict.class)));
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterFactory> provideTypeAdapterFactories() {
        return y.setOf((Object[]) new TypeAdapterFactory[]{RuntimeTypeAdapterFactory.of(CategoryPublishStep.class).registerSubtype(CategoryPublishStep.Wizard.class, "wizard").registerSubtype(CategoryPublishStep.Params.class, "params").registerSubtype(CategoryPublishStep.Select.class, "select").registerSubtype(CategoryPublishStep.Vin.class, "vin").registerSubtype(CategoryPublishStep.Premoderation.class, "premoderation").registerSubtype(CategoryPublishStep.SuggestCategory.class, "suggestCategory").registerSubtype(CategoryPublishStep.Request.class, "request").registerSubtype(CategoryPublishStep.Params.class, "contacts"), OptimalRuntimeTypeAdapterFactory.Companion.of(SuggestAction.class).registerSubtype(SuggestNewQuery.class, "new_query").registerSubtype(SuggestAnalyticsEvent.class, "clickstream").registerSubtype(SuggestDeeplink.class, "deeplink")});
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(AdvertProactiveModerationResult.WrongCategory.class, new ProactiveModerationWrongCategoryDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(AdvertProactiveModerationResult.Duplicate.class, new ProactiveModerationDuplicateDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(PostAdvertResult.class, new PostAdvertResultDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(AttributeNode.class, new AttributeNodeDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(AttributeNode.class, new AttributeNodeSerializer()));
        linkedHashSet.add(new TypeAdapterEntry(DisplayingOptions.class, new DisplayingOptionsDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(SelectParameter.Displaying.class, new DisplayingSelectParameterDeserializer()));
        return linkedHashSet;
    }
}
