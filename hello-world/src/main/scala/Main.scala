import zio.*

object Main extends scala.App :
  val program =
  for 
    _ <- console.putStrLn("-" * 100)
    _ <- console.putStrLn("Hello world")
    _ <- console.putStrLn("-" * 100)
  yield ()

  //run it three times
  Runtime.default.unsafeRunSync(program.repeatN(2))