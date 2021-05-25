package com.yandex.mapkit;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
public class SpannableString implements Serializable {
    private NativeObject nativeObject;
    private List<Span> spans;
    private boolean spans__is_initialized = false;
    private String text;
    private boolean text__is_initialized = false;

    public SpannableString() {
    }

    public static String getNativeName() {
        return "yandex::maps::mapkit::SpannableString";
    }

    private native List<Span> getSpans__Native();

    private native String getText__Native();

    private native NativeObject init(String str, List<Span> list);

    private static native NativeObject loadNative(ByteBuffer byteBuffer);

    private native ByteBuffer saveNative();

    @NonNull
    public synchronized List<Span> getSpans() {
        if (!this.spans__is_initialized) {
            this.spans = getSpans__Native();
            this.spans__is_initialized = true;
        }
        return this.spans;
    }

    @NonNull
    public synchronized String getText() {
        if (!this.text__is_initialized) {
            this.text = getText__Native();
            this.text__is_initialized = true;
        }
        return this.text;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        if (archive.isReader()) {
            this.nativeObject = loadNative(archive.add((ByteBuffer) null));
            return;
        }
        ByteBuffer.allocateDirect(10);
        archive.add(saveNative());
    }

    public static class Span implements Serializable {
        private int begin;
        private int end;

        public Span(int i, int i2) {
            this.begin = i;
            this.end = i2;
        }

        public int getBegin() {
            return this.begin;
        }

        public int getEnd() {
            return this.end;
        }

        @Override // com.yandex.runtime.bindings.Serializable
        public void serialize(Archive archive) {
            this.begin = archive.add(this.begin);
            this.end = archive.add(this.end);
        }

        public Span() {
        }
    }

    public SpannableString(@NonNull String str, @NonNull List<Span> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required field \"text\" cannot be null");
        } else if (list != null) {
            this.nativeObject = init(str, list);
            this.text = str;
            this.text__is_initialized = true;
            this.spans = list;
            this.spans__is_initialized = true;
        } else {
            throw new IllegalArgumentException("Required field \"spans\" cannot be null");
        }
    }

    private SpannableString(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }
}
