import ourzio.*

abstract class Animal
final case class Dog(name: String) extends Animal


//Covariance
abstract class AnimalShelter[+A <: Animal]:
  def adopt(name: String): Animal

final class DogShelter extends AnimalShelter[Dog]:
  override def adopt(name: String): Animal = Dog(name)

//Contravariance
abstract class Vet[-A >: Dog]:
  def diagnose(dog: A): String

final class ExperiencedVet extends Vet[Animal]:
  override def diagnose(animal: Animal): String = 
    s"$animal will be fine for sure"

object MainourZio extends scala.App:
  println("-" * 100)
  //With +A <: Animal we can define it like animal
  val shelter: AnimalShelter[Animal] = new DogShelter
  val animal = shelter.adopt("snoppy")
  println(animal)

  val dog = new Dog("Timmy")
  val vet: Vet[Animal] = new ExperiencedVet
  println(vet.diagnose(dog))
  println("-" * 100)