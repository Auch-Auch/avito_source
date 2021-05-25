package com.avito.android.saved_searches;

import a2.g.r.g;
import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/avito/android/saved_searches/SavedSearchResourceProviderImpl;", "Lcom/avito/android/saved_searches/SavedSearchResourceProvider;", "", "subscriptionMessage", "()Ljava/lang/String;", "subscriptionEditedMessage", "unsubscriptionMessage", "errorMessage", "dialogHeader", "actionButtonTitle", "subscribeBtnText", "saveBtnText", "f", "Ljava/lang/String;", "d", AuthSource.SEND_ABUSE, g.a, "e", AuthSource.BOOKING_ORDER, "c", "h", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "saved-searches_release"}, k = 1, mv = {1, 4, 2})
public final class SavedSearchResourceProviderImpl implements SavedSearchResourceProvider {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public SavedSearchResourceProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.saved_search_subscription_message);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…rch_subscription_message)");
        this.a = string;
        String string2 = context.getString(R.string.saved_search_subscription_edited_message);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…scription_edited_message)");
        this.b = string2;
        String string3 = context.getString(R.string.saved_search_unsubscription_message);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…h_unsubscription_message)");
        this.c = string3;
        String string4 = context.getString(R.string.saved_search_error_message);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…ved_search_error_message)");
        this.d = string4;
        String string5 = context.getString(R.string.saved_search_dialog_header);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri…ved_search_dialog_header)");
        this.e = string5;
        String string6 = context.getString(R.string.saved_search_action_button_title);
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri…arch_action_button_title)");
        this.f = string6;
        String string7 = context.getString(R.string.saved_search_subscribe_btn_text);
        Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.stri…earch_subscribe_btn_text)");
        this.g = string7;
        String string8 = context.getString(R.string.saved_search_save_btn_text);
        Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.stri…ved_search_save_btn_text)");
        this.h = string8;
    }

    @Override // com.avito.android.saved_searches.SavedSearchResourceProvider
    @NotNull
    public String actionButtonTitle() {
        return this.f;
    }

    @Override // com.avito.android.saved_searches.SavedSearchResourceProvider
    @NotNull
    public String dialogHeader() {
        return this.e;
    }

    @Override // com.avito.android.saved_searches.SavedSearchResourceProvider
    @NotNull
    public String errorMessage() {
        return this.d;
    }

    @Override // com.avito.android.saved_searches.SavedSearchResourceProvider
    @NotNull
    public String saveBtnText() {
        return this.h;
    }

    @Override // com.avito.android.saved_searches.SavedSearchResourceProvider
    @NotNull
    public String subscribeBtnText() {
        return this.g;
    }

    @Override // com.avito.android.saved_searches.SavedSearchResourceProvider
    @NotNull
    public String subscriptionEditedMessage() {
        return this.b;
    }

    @Override // com.avito.android.saved_searches.SavedSearchResourceProvider
    @NotNull
    public String subscriptionMessage() {
        return this.a;
    }

    @Override // com.avito.android.saved_searches.SavedSearchResourceProvider
    @NotNull
    public String unsubscriptionMessage() {
        return this.c;
    }
}
