import zio.*

object Main2 extends scala.App :
  val trace = s"[${Console.YELLOW}TRACE${Console.RESET}]"
  val program =
  for 
    _ <- console.putStrLn("-" * 100)
    _ <- console.putStrLn("What's your name?")
    //name <- console.getStrLn
    name <- ZIO.succeed("Carlos").debug(trace)
    _ <- console.putStrLn(s"Hello, $name!").repeatN(1)
    //_ <- ZIO.fail(sys.error("boom"))
    //_<- ZIO.effect(throw RuntimeException("boom"))
    _ <- console.putStrLn("-" * 100)
  yield ()

  //run it three times
  Runtime.default.unsafeRunSync(program)