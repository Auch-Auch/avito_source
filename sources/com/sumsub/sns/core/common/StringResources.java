package com.sumsub.sns.core.common;

import a2.b.a.a.a;
import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/sumsub/sns/core/common/StringResources;", "Landroid/content/res/Resources;", "", "id", "", "getText", "(I)Ljava/lang/CharSequence;", "def", "(ILjava/lang/CharSequence;)Ljava/lang/CharSequence;", "Ljava/lang/ref/WeakReference;", "Lcom/sumsub/sns/core/common/StringRepository;", AuthSource.BOOKING_ORDER, "Ljava/lang/ref/WeakReference;", "stringRepository", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "getBaseResources", "()Landroid/content/res/Resources;", "baseResources", "<init>", "(Landroid/content/res/Resources;Ljava/lang/ref/WeakReference;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class StringResources extends Resources {
    @NotNull
    public final Resources a;
    public final WeakReference<StringRepository> b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringResources(@NotNull Resources resources, @NotNull WeakReference<StringRepository> weakReference) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        Intrinsics.checkNotNullParameter(resources, "baseResources");
        Intrinsics.checkNotNullParameter(weakReference, "stringRepository");
        this.a = resources;
        this.b = weakReference;
    }

    @NotNull
    public final Resources getBaseResources() {
        return this.a;
    }

    @Override // android.content.res.Resources
    @NotNull
    public CharSequence getText(int i) throws Resources.NotFoundException {
        CharSequence charSequence;
        String resourceEntryName = getResourceEntryName(i);
        StringRepository stringRepository = this.b.get();
        if (stringRepository != null) {
            Intrinsics.checkNotNullExpressionValue(resourceEntryName, "resourceName");
            charSequence = stringRepository.getText(resourceEntryName);
        } else {
            charSequence = null;
        }
        if (charSequence != null) {
            return charSequence;
        }
        CharSequence text = super.getText(i);
        StringBuilder R = a.R("StringResources.getText for ", resourceEntryName, " = ");
        R.append(super.getText(i));
        R.append(" is not found");
        Timber.e(R.toString(), new Object[0]);
        Intrinsics.checkNotNullExpressionValue(text, "super.getText(id).also {… is not found\")\n        }");
        return text;
    }

    @Override // android.content.res.Resources
    @NotNull
    public CharSequence getText(int i, @NotNull CharSequence charSequence) {
        CharSequence charSequence2;
        Intrinsics.checkNotNullParameter(charSequence, "def");
        String resourceEntryName = getResourceEntryName(i);
        StringRepository stringRepository = this.b.get();
        if (stringRepository != null) {
            Intrinsics.checkNotNullExpressionValue(resourceEntryName, "resourceName");
            charSequence2 = stringRepository.getText(resourceEntryName);
        } else {
            charSequence2 = null;
        }
        if (charSequence2 != null) {
            return charSequence2;
        }
        CharSequence text = super.getText(i, charSequence);
        Timber.e("StringResources.getText with def=" + charSequence + " for " + resourceEntryName + " = " + super.getText(i) + " is not found", new Object[0]);
        Intrinsics.checkNotNullExpressionValue(text, "super.getText(id, def).a… is not found\")\n        }");
        return text;
    }
}
