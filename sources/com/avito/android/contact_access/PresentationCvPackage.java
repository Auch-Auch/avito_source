package com.avito.android.contact_access;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/avito/android/contact_access/PresentationCvPackage;", "", "", "getCountDetails", "()Ljava/lang/String;", "getDetails", "", "getProgressDrawable", "()I", "getMaxValue", "getProgress", "getDescription", "getName", "getTitle", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public interface PresentationCvPackage {
    @NotNull
    String getCountDetails();

    @NotNull
    String getDescription();

    @NotNull
    String getDetails();

    int getMaxValue();

    @NotNull
    String getName();

    int getProgress();

    int getProgressDrawable();

    @NotNull
    String getTitle();
}
