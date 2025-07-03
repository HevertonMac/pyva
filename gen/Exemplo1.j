.class public Exemplo1
.super java/lang/Object
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method


.method public static fatorial(I)I
    .limit stack 100
    .limit locals 100
    iload 0
    ldc 1
    if_icmpgt L3
    iconst_0
    goto L4
L3:
    iconst_1
L4:
    ifeq L1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 0
    invokevirtual java/io/PrintStream/println(I)V
    iload 0
    iload 0
    ldc 1
    isub
    invokestatic Exemplo1/fatorial(I)I
    imul
    ireturn
L1:
    ldc 1
    ireturn
L2:
.end method

.method public static mostrarMedia(FF)V
    .limit stack 100
    .limit locals 100
    fload 0
    fload 1
    fadd
    i2f
    ldc 2.0
    fdiv
    fstore 2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Resultado: "
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    getstatic java/lang/System/out Ljava/io/PrintStream;
    fload 2
    invokevirtual java/io/PrintStream/println(F)V
    return
.end method

.method public static media(FF)F
    .limit stack 100
    .limit locals 100
    fload 0
    fload 1
    fadd
    i2f
    ldc 2.0
    fdiv
    fstore 2
    fload 2
    freturn
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100
    new java/util/Scanner
    dup
    getstatic java/lang/System/in Ljava/io/InputStream;
    invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
   astore 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Programa Fatorial. Digite o valor?"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
   aload 1
    invokevirtual java/util/Scanner/nextInt()I
   istore 2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 2
    invokestatic Exemplo1/fatorial(I)I
    invokevirtual java/io/PrintStream/println(I)V
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Programa Media. Digite os valores?"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
   aload 1
    invokevirtual java/util/Scanner/nextFloat()F
   fstore 3
   aload 1
    invokevirtual java/util/Scanner/nextFloat()F
   fstore 4
    fload 3
    fload 4
    invokestatic Exemplo1/mostrarMedia(FF)V
    return
.end method