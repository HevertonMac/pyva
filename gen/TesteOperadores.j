.class public TesteOperadores
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
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "oi"
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    ldc 10
    istore 3
    ldc 5
    istore 4
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "Soma: "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
   aload 2
    iload 3
    iload 4
    iadd
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "Divisao inteira: "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
   aload 2
    iload 3
    iload 4
    idiv
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    ldc 5.5
    fstore 5
    ldc 2.0
    fstore 6
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "Multiplicacao real: "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
   aload 2
    fload 5
    fload 6
    fmul
    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    istore 7
    iload 7
    istore 8
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "Valor de flag2: "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
   aload 2
    iload 8
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    ldc "Javython"
    ldc "Python"
    if_acmpne L3
    iconst_0
    goto L4
L3:
    iconst_1
L4:
    ifeq L1
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
   aload 2
    ldc " eh diferente de "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
   aload 2
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto L2
L1:
L2:
    return
.end method