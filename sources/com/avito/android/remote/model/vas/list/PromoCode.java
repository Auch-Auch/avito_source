package com.avito.android.remote.model.vas.list;

import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/vas/list/PromoCode;", "Lcom/avito/android/remote/model/vas/list/VasElement;", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Action;", "terms", "Lcom/avito/android/remote/model/Action;", "getTerms", "()Lcom/avito/android/remote/model/Action;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "action", "getAction", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Action;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class PromoCode implements VasElement {
    @Nullable
    private final Action action;
    @Nullable
    private final String description;
    @NotNull
    private final Image icon;
    @Nullable
    private final Action terms;
    @NotNull
    private final String title;

    public PromoCode(@NotNull Image image, @NotNull String str, @Nullable String str2, @Nullable Action action2, @Nullable Action action3) {
        Intrinsics.checkNotNullParameter(image, "icon");
        Intrinsics.checkNotNullParameter(str, "title");
        this.icon = image;
        this.title = str;
        this.description = str2;
        this.terms = action2;
        this.action = action3;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final Image getIcon() {
        return this.icon;
    }

    @Nullable
    public final Action getTerms() {
        return this.terms;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
