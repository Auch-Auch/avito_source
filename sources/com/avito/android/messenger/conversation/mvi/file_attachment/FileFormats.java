package com.avito.android.messenger.conversation.mvi.file_attachment;

import android.webkit.MimeTypeMap;
import androidx.annotation.VisibleForTesting;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKAttachments;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileFormats;", "", "", "", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getMimeTypes", "()[Ljava/lang/String;", "mimeTypes", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting(otherwise = 2)
public final class FileFormats {
    @NotNull
    public static final FileFormats INSTANCE = new FileFormats();
    @NotNull
    public static final Lazy a = c.lazy(a.a);

    public static final class a extends Lambda implements Function0<String[]> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String[] invoke() {
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            List<String> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"pdf", "txt", VKAttachments.TYPE_DOC, "docx", "xls", "xlsx", "ppt", "pptx", "odt", "ods", "rtf"});
            ArrayList arrayList = new ArrayList();
            for (String str : listOf) {
                String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(str);
                if (mimeTypeFromExtension != null) {
                    arrayList.add(mimeTypeFromExtension);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[]) array;
        }
    }

    @NotNull
    public final String[] getMimeTypes() {
        return (String[]) a.getValue();
    }
}
