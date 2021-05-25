package com.avito.android.html_editor.di;

import android.app.Application;
import com.avito.android.html_editor.EditorHistoryProvider;
import com.avito.android.html_editor.PrefEditorHistoryProvider;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.preferences.Names;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/html_editor/di/EditorHistoryModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "Lcom/avito/android/util/preferences/Preferences;", "provideEditorPreferences", "(Landroid/app/Application;Lcom/avito/android/util/preferences/PreferenceFactory;)Lcom/avito/android/util/preferences/Preferences;", "Lcom/google/gson/Gson;", "provideEditorSerializer", "()Lcom/google/gson/Gson;", "<init>", "()V", "Declarations", "EditorPreferences", "EditorSerializer", "html-editor_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class EditorHistoryModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/html_editor/di/EditorHistoryModule$Declarations;", "", "Lcom/avito/android/html_editor/PrefEditorHistoryProvider;", GeoContract.PROVIDER, "Lcom/avito/android/html_editor/EditorHistoryProvider;", "bindEditorHistoryProvider", "(Lcom/avito/android/html_editor/PrefEditorHistoryProvider;)Lcom/avito/android/html_editor/EditorHistoryProvider;", "html-editor_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        EditorHistoryProvider bindEditorHistoryProvider(@NotNull PrefEditorHistoryProvider prefEditorHistoryProvider);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/html_editor/di/EditorHistoryModule$EditorPreferences;", "", "<init>", "()V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface EditorPreferences {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/html_editor/di/EditorHistoryModule$EditorSerializer;", "", "<init>", "()V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface EditorSerializer {
    }

    @Provides
    @EditorPreferences
    @NotNull
    public final Preferences provideEditorPreferences(@NotNull Application application, @NotNull PreferenceFactory preferenceFactory) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        return preferenceFactory.getCustomPreferences(application, Names.HTML_EDITOR);
    }

    @Provides
    @EditorSerializer
    @NotNull
    public final Gson provideEditorSerializer() {
        Gson create = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().create()");
        return create;
    }
}
