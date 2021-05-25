package com.avito.android.html_editor;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.avito.android.html_editor.di.EditorHistoryModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import com.google.gson.Gson;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0019\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/html_editor/PrefEditorHistoryProvider;", "Lcom/avito/android/html_editor/EditorHistoryProvider;", "", "id", "", VKApiConst.POSITION, "Lcom/avito/android/html_editor/HistorySnapshot;", "getHistorySnapshot", "(Ljava/lang/String;I)Lcom/avito/android/html_editor/HistorySnapshot;", "state", "", "saveHistorySnapshot", "(Ljava/lang/String;ILcom/avito/android/html_editor/HistorySnapshot;)V", "fromPosition", "toPosition", "clearSnapshots", "(Ljava/lang/String;II)V", "clearAllHistories", "()V", AuthSource.SEND_ABUSE, "(Ljava/lang/String;I)Ljava/lang/String;", "Lcom/google/gson/Gson;", AuthSource.BOOKING_ORDER, "Lcom/google/gson/Gson;", "serializer", "Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/util/preferences/Preferences;", "pref", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Lcom/google/gson/Gson;)V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public final class PrefEditorHistoryProvider implements EditorHistoryProvider {
    public final Preferences a;
    public final Gson b;

    @Inject
    public PrefEditorHistoryProvider(@EditorHistoryModule.EditorPreferences @NotNull Preferences preferences, @EditorHistoryModule.EditorSerializer @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(preferences, "pref");
        Intrinsics.checkNotNullParameter(gson, "serializer");
        this.a = preferences;
        this.b = gson;
    }

    public final String a(String str, int i) {
        return EditorHistoryContract.KEY_PREFIX_EDITOR_HISTORY_STATE + str + "_" + i;
    }

    @Override // com.avito.android.html_editor.EditorHistoryProvider
    @SuppressLint({"ApplySharedPref"})
    public void clearAllHistories() {
        this.a.getSharedPreferences().edit().clear().apply();
    }

    @Override // com.avito.android.html_editor.EditorHistoryProvider
    @SuppressLint({"ApplySharedPref"})
    public void clearSnapshots(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (i != i2) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences().edit();
            Iterator it = new IntRange(i, i2).iterator();
            while (it.hasNext()) {
                edit.remove(a(str, ((IntIterator) it).nextInt()));
            }
            edit.apply();
        }
    }

    @Override // com.avito.android.html_editor.EditorHistoryProvider
    @Nullable
    public HistorySnapshot getHistorySnapshot(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        String string = this.a.getString(a(str, i));
        if (string != null) {
            return (HistorySnapshot) this.b.fromJson(string, (Class<Object>) HistorySnapshot.class);
        }
        return null;
    }

    @Override // com.avito.android.html_editor.EditorHistoryProvider
    public void saveHistorySnapshot(@NotNull String str, int i, @NotNull HistorySnapshot historySnapshot) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(historySnapshot, "state");
        this.a.putString(a(str, i), this.b.toJson(historySnapshot));
    }
}
