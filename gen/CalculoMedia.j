.class public CalculoMedia
.super java/lang/Object
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method


.method public static calcularMedia(IIF)F
    .limit stack 100
    .limit locals 100
    iload 0
    iload 1
    iadd
    i2f
    fload 2
    fadd
    ldc 3
    i2f
    fdiv
    fstore 3
    fload 3
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
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "Programa Media. Digite as duas primeiras notas (inteiras)?"
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
   aload 1
    invokevirtual java/util/Scanner/nextInt()I
   istore 3
   aload 1
    invokevirtual java/util/Scanner/nextInt()I
   istore 4
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "Digite a terceira nota (real)?"
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
   aload 1
    invokevirtual java/util/Scanner/nextFloat()F
   fstore 5
    iload 3
    iload 4
    fload 5
    invokestatic CalculoMedia/calcularMedia(IIF)F
    i2f
    fstore 6
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
   astore 2
   aload 2
    ldc "A media das notas eh: "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
   aload 2
    fload 6
    invokevirtual java/lang/StringBuilder/append(F)Ljava/lang/StringBuilder;
    ldc " "
    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    return
.end method