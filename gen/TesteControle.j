.class public TesteControle
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
    ldc "--- Teste com WHILE ---"
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    iload 2
    pop
    ldc 5
    istore 3
    iload 3
    ldc 0
    if_icmpgt L1
    iconst_0
    goto L2
L1:
    iconst_1
L2:
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "Contagem regressiva: "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
   aload 2
    iload 3
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    iload 3
    ldc 1
    isub
    istore 3
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "--- Teste com FOR e IF-ELSE ---"
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    ldc 0
    istore 4
    iload 4
    iload 1
    if_icmplt L3
    iconst_0
    goto L4
L3:
    iconst_1
L4:
    iload 4
    ldc 1
    iadd
    istore 4
    iload 4
    ldc 5
    iconst_0
    goto L8
L7:
    iconst_1
L8:
    ifeq L5
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "Estamos na metade!"
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    goto L6
L5:
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "Contagem progressiva: "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
   aload 2
    iload 4
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
L6:
    return
.end method