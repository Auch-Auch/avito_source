package androidx.browser.trusted.sharing;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
public final class ShareTarget {
    public static final String ENCODING_TYPE_MULTIPART = "multipart/form-data";
    public static final String ENCODING_TYPE_URL_ENCODED = "application/x-www-form-urlencoded";
    @SuppressLint({"IntentName"})
    public static final String KEY_ACTION = "androidx.browser.trusted.sharing.KEY_ACTION";
    public static final String KEY_ENCTYPE = "androidx.browser.trusted.sharing.KEY_ENCTYPE";
    public static final String KEY_METHOD = "androidx.browser.trusted.sharing.KEY_METHOD";
    public static final String KEY_PARAMS = "androidx.browser.trusted.sharing.KEY_PARAMS";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    @NonNull
    public final String action;
    @Nullable
    public final String encodingType;
    @Nullable
    public final String method;
    @NonNull
    public final Params params;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface EncodingType {
    }

    public static final class FileFormField {
        public static final String KEY_ACCEPTED_TYPES = "androidx.browser.trusted.sharing.KEY_ACCEPTED_TYPES";
        public static final String KEY_NAME = "androidx.browser.trusted.sharing.KEY_FILE_NAME";
        @NonNull
        public final List<String> acceptedTypes;
        @NonNull
        public final String name;

        public FileFormField(@NonNull String str, @NonNull List<String> list) {
            this.name = str;
            this.acceptedTypes = Collections.unmodifiableList(list);
        }
    }

    public static class Params {
        public static final String KEY_FILES = "androidx.browser.trusted.sharing.KEY_FILES";
        public static final String KEY_TEXT = "androidx.browser.trusted.sharing.KEY_TEXT";
        public static final String KEY_TITLE = "androidx.browser.trusted.sharing.KEY_TITLE";
        @Nullable
        public final List<FileFormField> files;
        @Nullable
        public final String text;
        @Nullable
        public final String title;

        public Params(@Nullable String str, @Nullable String str2, @Nullable List<FileFormField> list) {
            this.title = str;
            this.text = str2;
            this.files = list;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface RequestMethod {
    }

    public ShareTarget(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull Params params2) {
        this.action = str;
        this.method = str2;
        this.encodingType = str3;
        this.params = params2;
    }

    @Nullable
    public static ShareTarget fromBundle(@NonNull Bundle bundle) {
        Params params2;
        ArrayList arrayList;
        FileFormField fileFormField;
        String string = bundle.getString(KEY_ACTION);
        String string2 = bundle.getString(KEY_METHOD);
        String string3 = bundle.getString(KEY_ENCTYPE);
        Bundle bundle2 = bundle.getBundle(KEY_PARAMS);
        if (bundle2 == null) {
            params2 = null;
        } else {
            ArrayList<Bundle> parcelableArrayList = bundle2.getParcelableArrayList(Params.KEY_FILES);
            if (parcelableArrayList != null) {
                arrayList = new ArrayList();
                for (Bundle bundle3 : parcelableArrayList) {
                    if (bundle3 != null) {
                        String string4 = bundle3.getString(FileFormField.KEY_NAME);
                        ArrayList<String> stringArrayList = bundle3.getStringArrayList(FileFormField.KEY_ACCEPTED_TYPES);
                        if (!(string4 == null || stringArrayList == null)) {
                            fileFormField = new FileFormField(string4, stringArrayList);
                            arrayList.add(fileFormField);
                        }
                    }
                    fileFormField = null;
                    arrayList.add(fileFormField);
                }
            } else {
                arrayList = null;
            }
            params2 = new Params(bundle2.getString("androidx.browser.trusted.sharing.KEY_TITLE"), bundle2.getString("androidx.browser.trusted.sharing.KEY_TEXT"), arrayList);
        }
        if (string == null || params2 == null) {
            return null;
        }
        return new ShareTarget(string, string2, string3, params2);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_ACTION, this.action);
        bundle.putString(KEY_METHOD, this.method);
        bundle.putString(KEY_ENCTYPE, this.encodingType);
        Params params2 = this.params;
        Objects.requireNonNull(params2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("androidx.browser.trusted.sharing.KEY_TITLE", params2.title);
        bundle2.putString("androidx.browser.trusted.sharing.KEY_TEXT", params2.text);
        if (params2.files != null) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (FileFormField fileFormField : params2.files) {
                Objects.requireNonNull(fileFormField);
                Bundle bundle3 = new Bundle();
                bundle3.putString(FileFormField.KEY_NAME, fileFormField.name);
                bundle3.putStringArrayList(FileFormField.KEY_ACCEPTED_TYPES, new ArrayList<>(fileFormField.acceptedTypes));
                arrayList.add(bundle3);
            }
            bundle2.putParcelableArrayList(Params.KEY_FILES, arrayList);
        }
        bundle.putBundle(KEY_PARAMS, bundle2);
        return bundle;
    }
}
