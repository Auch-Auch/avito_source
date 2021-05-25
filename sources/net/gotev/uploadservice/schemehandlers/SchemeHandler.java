package net.gotev.uploadservice.schemehandlers;

import android.content.Context;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "", "", MessageMetaInfo.COLUMN_PATH, "", "init", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "", "size", "(Landroid/content/Context;)J", "Ljava/io/InputStream;", "stream", "(Landroid/content/Context;)Ljava/io/InputStream;", "contentType", "(Landroid/content/Context;)Ljava/lang/String;", "name", "", PhoneActionStrings.REMOVE, "(Landroid/content/Context;)Z", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public interface SchemeHandler {
    @NotNull
    String contentType(@NotNull Context context);

    boolean delete(@NotNull Context context);

    void init(@NotNull String str);

    @NotNull
    String name(@NotNull Context context);

    long size(@NotNull Context context);

    @NotNull
    InputStream stream(@NotNull Context context);
}
