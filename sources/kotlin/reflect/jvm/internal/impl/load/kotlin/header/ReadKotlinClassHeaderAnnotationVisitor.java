package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import com.avito.android.analytics.event.CallToSellerEventKt;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class ReadKotlinClassHeaderAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
    public static final boolean j = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(System.getProperty("kotlin.ignore.old.metadata"));
    public static final Map<ClassId, KotlinClassHeader.Kind> k;
    public int[] a = null;
    public JvmBytecodeBinaryVersion b = null;
    public String c = null;
    public int d = 0;
    public String e = null;
    public String[] f = null;
    public String[] g = null;
    public String[] h = null;
    public KotlinClassHeader.Kind i = null;

    public static abstract class b implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        public final List<String> a = new ArrayList();

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "enumEntryName";
            } else if (i != 2) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classLiteralValue";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i != 2) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitClassLiteral";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public abstract void b(@NotNull String[] strArr);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visit(@Nullable Object obj) {
            if (obj instanceof String) {
                this.a.add((String) obj);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitClassLiteral(@NotNull ClassLiteralValue classLiteralValue) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnd() {
            b((String[]) this.a.toArray(new String[0]));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnum(@NotNull ClassId classId, @NotNull Name name) {
            if (classId == null) {
                a(0);
                throw null;
            } else if (name == null) {
                a(1);
                throw null;
            }
        }
    }

    public class c implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        public c(a aVar) {
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable Name name, @Nullable Object obj) {
            if (name != null) {
                String asString = name.asString();
                if ("k".equals(asString)) {
                    if (obj instanceof Integer) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.i = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                    }
                } else if ("mv".equals(asString)) {
                    if (obj instanceof int[]) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.a = (int[]) obj;
                    }
                } else if ("bv".equals(asString)) {
                    if (obj instanceof int[]) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.b = new JvmBytecodeBinaryVersion((int[]) obj);
                    }
                } else if (CallToSellerEventKt.CALL_SOURCE_XL_ITEM.equals(asString)) {
                    if (obj instanceof String) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.c = (String) obj;
                    }
                } else if ("xi".equals(asString)) {
                    if (obj instanceof Integer) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.d = ((Integer) obj).intValue();
                    }
                } else if ("pn".equals(asString) && (obj instanceof String)) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.e = (String) obj;
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name name, @NotNull ClassId classId) {
            if (name == null) {
                a(6);
                throw null;
            } else if (classId != null) {
                return null;
            } else {
                a(7);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name name) {
            if (name != null) {
                String asString = name.asString();
                if ("d1".equals(asString)) {
                    return new t6.w.f.a.m.c.b.a.a(this);
                }
                if ("d2".equals(asString)) {
                    return new t6.w.f.a.m.c.b.a.b(this);
                }
                return null;
            }
            a(2);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@NotNull Name name, @NotNull ClassLiteralValue classLiteralValue) {
            if (name == null) {
                a(0);
                throw null;
            } else if (classLiteralValue == null) {
                a(1);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@NotNull Name name, @NotNull ClassId classId, @NotNull Name name2) {
            if (name == null) {
                a(3);
                throw null;
            } else if (classId == null) {
                a(4);
                throw null;
            } else if (name2 == null) {
                a(5);
                throw null;
            }
        }
    }

    public class d implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        public d(a aVar) {
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable Name name, @Nullable Object obj) {
            if (name != null) {
                String asString = name.asString();
                if ("version".equals(asString)) {
                    if (obj instanceof int[]) {
                        ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = ReadKotlinClassHeaderAnnotationVisitor.this;
                        int[] iArr = (int[]) obj;
                        readKotlinClassHeaderAnnotationVisitor.a = iArr;
                        if (readKotlinClassHeaderAnnotationVisitor.b == null) {
                            readKotlinClassHeaderAnnotationVisitor.b = new JvmBytecodeBinaryVersion(iArr);
                        }
                    }
                } else if ("multifileClassName".equals(asString)) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.c = obj instanceof String ? (String) obj : null;
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name name, @NotNull ClassId classId) {
            if (name == null) {
                a(6);
                throw null;
            } else if (classId != null) {
                return null;
            } else {
                a(7);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name name) {
            if (name != null) {
                String asString = name.asString();
                if ("data".equals(asString) || "filePartClassNames".equals(asString)) {
                    return new t6.w.f.a.m.c.b.a.c(this);
                }
                if ("strings".equals(asString)) {
                    return new t6.w.f.a.m.c.b.a.d(this);
                }
                return null;
            }
            a(2);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@NotNull Name name, @NotNull ClassLiteralValue classLiteralValue) {
            if (name == null) {
                a(0);
                throw null;
            } else if (classLiteralValue == null) {
                a(1);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@NotNull Name name, @NotNull ClassId classId, @NotNull Name name2) {
            if (name == null) {
                a(3);
                throw null;
            } else if (classId == null) {
                a(4);
                throw null;
            } else if (name2 == null) {
                a(5);
                throw null;
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        k = hashMap;
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    public static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Nullable
    public KotlinClassHeader createHeader() {
        if (this.i == null || this.a == null) {
            return null;
        }
        boolean z = true;
        JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(this.a, (this.d & 8) != 0);
        if (!jvmMetadataVersion.isCompatible()) {
            this.h = this.f;
            this.f = null;
        } else {
            KotlinClassHeader.Kind kind = this.i;
            if (!(kind == KotlinClassHeader.Kind.CLASS || kind == KotlinClassHeader.Kind.FILE_FACADE || kind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART)) {
                z = false;
            }
            if (z && this.f == null) {
                return null;
            }
        }
        KotlinClassHeader.Kind kind2 = this.i;
        JvmBytecodeBinaryVersion jvmBytecodeBinaryVersion = this.b;
        if (jvmBytecodeBinaryVersion == null) {
            jvmBytecodeBinaryVersion = JvmBytecodeBinaryVersion.INSTANCE;
        }
        return new KotlinClassHeader(kind2, jvmMetadataVersion, jvmBytecodeBinaryVersion, this.f, this.h, this.g, this.c, this.d, this.e);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement) {
        KotlinClassHeader.Kind kind;
        if (classId == null) {
            a(0);
            throw null;
        } else if (sourceElement == null) {
            a(1);
            throw null;
        } else if (classId.asSingleFqName().equals(JvmAnnotationNames.METADATA_FQ_NAME)) {
            return new c(null);
        } else {
            if (j || this.i != null || (kind = k.get(classId)) == null) {
                return null;
            }
            this.i = kind;
            return new d(null);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public void visitEnd() {
    }
}
