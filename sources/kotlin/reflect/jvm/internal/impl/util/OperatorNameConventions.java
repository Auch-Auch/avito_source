package kotlin.reflect.jvm.internal.impl.util;

import java.util.Set;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
public final class OperatorNameConventions {
    @JvmField
    @NotNull
    public static final Name AND;
    @JvmField
    @NotNull
    public static final Set<Name> ASSIGNMENT_OPERATIONS;
    @JvmField
    @NotNull
    public static final Set<Name> BINARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Name COMPARE_TO;
    @JvmField
    @NotNull
    public static final Regex COMPONENT_REGEX = new Regex("component\\d+");
    @JvmField
    @NotNull
    public static final Name CONTAINS;
    @JvmField
    @NotNull
    public static final Name DEC;
    @JvmField
    @NotNull
    public static final Set<Name> DELEGATED_PROPERTY_OPERATORS;
    @JvmField
    @NotNull
    public static final Name DIV;
    @JvmField
    @NotNull
    public static final Name DIV_ASSIGN;
    @JvmField
    @NotNull
    public static final Name EQUALS;
    @JvmField
    @NotNull
    public static final Name GET;
    @JvmField
    @NotNull
    public static final Name GET_VALUE;
    @JvmField
    @NotNull
    public static final Name HAS_NEXT;
    @JvmField
    @NotNull
    public static final Name INC;
    @NotNull
    public static final OperatorNameConventions INSTANCE = new OperatorNameConventions();
    @JvmField
    @NotNull
    public static final Name INVOKE;
    @JvmField
    @NotNull
    public static final Name ITERATOR;
    @JvmField
    @NotNull
    public static final Name MINUS;
    @JvmField
    @NotNull
    public static final Name MINUS_ASSIGN;
    @JvmField
    @NotNull
    public static final Name MOD;
    @JvmField
    @NotNull
    public static final Name MOD_ASSIGN;
    @JvmField
    @NotNull
    public static final Name NEXT;
    @JvmField
    @NotNull
    public static final Name NOT;
    @JvmField
    @NotNull
    public static final Name OR;
    @JvmField
    @NotNull
    public static final Name PLUS;
    @JvmField
    @NotNull
    public static final Name PLUS_ASSIGN;
    @JvmField
    @NotNull
    public static final Name PROVIDE_DELEGATE;
    @JvmField
    @NotNull
    public static final Name RANGE_TO;
    @JvmField
    @NotNull
    public static final Name REM;
    @JvmField
    @NotNull
    public static final Name REM_ASSIGN;
    @JvmField
    @NotNull
    public static final Name SET;
    @JvmField
    @NotNull
    public static final Name SET_VALUE;
    @JvmField
    @NotNull
    public static final Set<Name> SIMPLE_UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Name TIMES;
    @JvmField
    @NotNull
    public static final Name TIMES_ASSIGN;
    @JvmField
    @NotNull
    public static final Name TO_STRING;
    @JvmField
    @NotNull
    public static final Name UNARY_MINUS;
    @JvmField
    @NotNull
    public static final Set<Name> UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Name UNARY_PLUS;

    static {
        Name identifier = Name.identifier("getValue");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"getValue\")");
        GET_VALUE = identifier;
        Name identifier2 = Name.identifier("setValue");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"setValue\")");
        SET_VALUE = identifier2;
        Name identifier3 = Name.identifier("provideDelegate");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"provideDelegate\")");
        PROVIDE_DELEGATE = identifier3;
        Name identifier4 = Name.identifier("equals");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(\"equals\")");
        EQUALS = identifier4;
        Name identifier5 = Name.identifier("compareTo");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(\"compareTo\")");
        COMPARE_TO = identifier5;
        Name identifier6 = Name.identifier("contains");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(\"contains\")");
        CONTAINS = identifier6;
        Name identifier7 = Name.identifier("invoke");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(\"invoke\")");
        INVOKE = identifier7;
        Name identifier8 = Name.identifier("iterator");
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(\"iterator\")");
        ITERATOR = identifier8;
        Name identifier9 = Name.identifier("get");
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(\"get\")");
        GET = identifier9;
        Name identifier10 = Name.identifier("set");
        Intrinsics.checkNotNullExpressionValue(identifier10, "identifier(\"set\")");
        SET = identifier10;
        Name identifier11 = Name.identifier("next");
        Intrinsics.checkNotNullExpressionValue(identifier11, "identifier(\"next\")");
        NEXT = identifier11;
        Name identifier12 = Name.identifier("hasNext");
        Intrinsics.checkNotNullExpressionValue(identifier12, "identifier(\"hasNext\")");
        HAS_NEXT = identifier12;
        Name identifier13 = Name.identifier("toString");
        Intrinsics.checkNotNullExpressionValue(identifier13, "identifier(\"toString\")");
        TO_STRING = identifier13;
        Name identifier14 = Name.identifier("and");
        Intrinsics.checkNotNullExpressionValue(identifier14, "identifier(\"and\")");
        AND = identifier14;
        Name identifier15 = Name.identifier("or");
        Intrinsics.checkNotNullExpressionValue(identifier15, "identifier(\"or\")");
        OR = identifier15;
        Name identifier16 = Name.identifier("inc");
        Intrinsics.checkNotNullExpressionValue(identifier16, "identifier(\"inc\")");
        INC = identifier16;
        Name identifier17 = Name.identifier("dec");
        Intrinsics.checkNotNullExpressionValue(identifier17, "identifier(\"dec\")");
        DEC = identifier17;
        Name identifier18 = Name.identifier("plus");
        Intrinsics.checkNotNullExpressionValue(identifier18, "identifier(\"plus\")");
        PLUS = identifier18;
        Name identifier19 = Name.identifier("minus");
        Intrinsics.checkNotNullExpressionValue(identifier19, "identifier(\"minus\")");
        MINUS = identifier19;
        Name identifier20 = Name.identifier("not");
        Intrinsics.checkNotNullExpressionValue(identifier20, "identifier(\"not\")");
        NOT = identifier20;
        Name identifier21 = Name.identifier("unaryMinus");
        Intrinsics.checkNotNullExpressionValue(identifier21, "identifier(\"unaryMinus\")");
        UNARY_MINUS = identifier21;
        Name identifier22 = Name.identifier("unaryPlus");
        Intrinsics.checkNotNullExpressionValue(identifier22, "identifier(\"unaryPlus\")");
        UNARY_PLUS = identifier22;
        Name identifier23 = Name.identifier("times");
        Intrinsics.checkNotNullExpressionValue(identifier23, "identifier(\"times\")");
        TIMES = identifier23;
        Name identifier24 = Name.identifier("div");
        Intrinsics.checkNotNullExpressionValue(identifier24, "identifier(\"div\")");
        DIV = identifier24;
        Name identifier25 = Name.identifier("mod");
        Intrinsics.checkNotNullExpressionValue(identifier25, "identifier(\"mod\")");
        MOD = identifier25;
        Name identifier26 = Name.identifier("rem");
        Intrinsics.checkNotNullExpressionValue(identifier26, "identifier(\"rem\")");
        REM = identifier26;
        Name identifier27 = Name.identifier("rangeTo");
        Intrinsics.checkNotNullExpressionValue(identifier27, "identifier(\"rangeTo\")");
        RANGE_TO = identifier27;
        Name identifier28 = Name.identifier("timesAssign");
        Intrinsics.checkNotNullExpressionValue(identifier28, "identifier(\"timesAssign\")");
        TIMES_ASSIGN = identifier28;
        Name identifier29 = Name.identifier("divAssign");
        Intrinsics.checkNotNullExpressionValue(identifier29, "identifier(\"divAssign\")");
        DIV_ASSIGN = identifier29;
        Name identifier30 = Name.identifier("modAssign");
        Intrinsics.checkNotNullExpressionValue(identifier30, "identifier(\"modAssign\")");
        MOD_ASSIGN = identifier30;
        Name identifier31 = Name.identifier("remAssign");
        Intrinsics.checkNotNullExpressionValue(identifier31, "identifier(\"remAssign\")");
        REM_ASSIGN = identifier31;
        Name identifier32 = Name.identifier("plusAssign");
        Intrinsics.checkNotNullExpressionValue(identifier32, "identifier(\"plusAssign\")");
        PLUS_ASSIGN = identifier32;
        Name identifier33 = Name.identifier("minusAssign");
        Intrinsics.checkNotNullExpressionValue(identifier33, "identifier(\"minusAssign\")");
        MINUS_ASSIGN = identifier33;
        UNARY_OPERATION_NAMES = y.setOf((Object[]) new Name[]{identifier16, identifier17, identifier22, identifier21, identifier20});
        SIMPLE_UNARY_OPERATION_NAMES = y.setOf((Object[]) new Name[]{identifier22, identifier21, identifier20});
        BINARY_OPERATION_NAMES = y.setOf((Object[]) new Name[]{identifier23, identifier18, identifier19, identifier24, identifier25, identifier26, identifier27});
        ASSIGNMENT_OPERATIONS = y.setOf((Object[]) new Name[]{identifier28, identifier29, identifier30, identifier31, identifier32, identifier33});
        DELEGATED_PROPERTY_OPERATORS = y.setOf((Object[]) new Name[]{identifier, identifier2, identifier3});
    }
}
