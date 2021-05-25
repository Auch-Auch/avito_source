package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
public interface SourceElement {
    public static final SourceElement NO_SOURCE = new a();

    public static class a implements SourceElement {
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        @NotNull
        public SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            if (sourceFile != null) {
                return sourceFile;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    @NotNull
    SourceFile getContainingFile();
}
