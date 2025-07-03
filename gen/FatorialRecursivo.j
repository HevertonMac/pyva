.class public FatorialRecursivo
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
    iload 0
    iload 0
    ldc 1
    isub
    invokestatic FatorialRecursivo/fatorial(I)I
    imul
    ireturn
L1:
    ldc 1
    ireturn
L2:
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 100
    .limit locals 100
    new java/util/Scanner
    dup
    getstatic java/lang/System/in Ljava/io/InputStream;
    invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
   astore 1
    ldc 5
    istore 5
    ldc 0
    istore 0
    iload 0
    iload 5
    if_icmplt L5
    iconst_0
    goto L6
L5:
    iconst_1
L6:
    iload 0
    ldc 10
    istore 4
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
    ldc "Programa Fatorial. Digite o valor?"
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
   aload 1
    invokevirtual java/util/Scanner/nextInt()I
   istore 2
    iload 2
    invokestatic FatorialRecursivo/fatorial(I)I
    istore 3
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
    ldc "O fatorial de "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iload 2
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " eh: "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iload 3
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    return
.end method