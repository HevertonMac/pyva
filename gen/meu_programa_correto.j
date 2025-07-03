.class public meu_programa_correto
.super java/lang/Object
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method


.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100
    new java/util/Scanner
    dup
    getstatic java/lang/System/in Ljava/io/InputStream;
    invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
   astore 1
    ldc 15
    istore 0
    ldc 30
    istore 1
    iload 0
    iload 1
    iadd
    istore 2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 2
    invokevirtual java/io/PrintStream/println(I)V
    return
.end method