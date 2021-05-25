package a2.a.a.b2.e1.c0;

import android.net.Uri;
import com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar;
import com.avito.android.profile.edit.refactoring.avatar.UriAvatar;
import io.reactivex.functions.Function;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<File, ProfileAvatar> {
    public final /* synthetic */ Uri a;

    public e(Uri uri) {
        this.a = uri;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ProfileAvatar apply(File file) {
        Intrinsics.checkNotNullParameter(file, "it");
        Uri uri = this.a;
        Intrinsics.checkNotNullExpressionValue(uri, "result");
        return new UriAvatar(uri);
    }
}
