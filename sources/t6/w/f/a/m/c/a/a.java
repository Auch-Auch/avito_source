package t6.w.f.a.m.c.a;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
public final class a extends Lambda implements Function2<EnumValue, AnnotationQualifierApplicabilityType, Boolean> {
    public static final a a = new a();

    public a() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Boolean invoke(EnumValue enumValue, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        EnumValue enumValue2 = enumValue;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = annotationQualifierApplicabilityType;
        Intrinsics.checkNotNullParameter(enumValue2, "<this>");
        Intrinsics.checkNotNullParameter(annotationQualifierApplicabilityType2, "it");
        return Boolean.valueOf(Intrinsics.areEqual(enumValue2.getEnumEntryName().getIdentifier(), annotationQualifierApplicabilityType2.getJavaTarget()));
    }
}
