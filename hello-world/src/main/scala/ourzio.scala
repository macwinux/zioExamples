object ourzio:

  final case class ZIO[A](thunk: () => A):
    def flatMap[B](azb: A => ZIO[B]): ZIO[B] = ZIO.succeed {
      val a = thunk()
      val zb = azb(a)
      zb.thunk()
    }
    def map[B](ab: A => B): ZIO[B] = ZIO.succeed {
      val a = thunk()
      ab(a)
    }
  end ZIO

  object ZIO:
    def succeed[A](a: => A): ZIO[A] = ZIO(() => a)
  object console:
    def putStrLn(line: => String) =
      ZIO.succeed(println(line))

    val getStrLn =
      ZIO.succeed(scala.io.StdIn.readLine())