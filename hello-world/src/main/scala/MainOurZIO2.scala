import ourzioerror.*

object MainOurZIO2 extends scala.App :
  val program =
  for 
    _ <- console.putStrLn("-" * 100)
    _ <- console.putStrLn("What's your name?")
    name <- ZIO.succeed("Carlos")
    _ <- console.putStrLn(s"Hello, $name!")
    _<- ZIO.effect(throw RuntimeException("boom"))
    //.catchAll(_ => console.putStrLn("All good43"))
    .mapError(_.getMessage)
    _ <- console.putStrLn("-" * 100)
  yield ()
  Runtime.default.unsafeRunSync(program)