package interfaces

sealed abstract class Shape(edges: List[Int]):
  final def calculatePerimeter(): Int = edges.sum

  def calculateArea(): Double
end Shape

case class Rectangle(height: Int, width: Int) extends Shape(List(height, height, width, width)) :
  override def calculateArea(): Double = height * width
end Rectangle

case class Triangle(edge1: Int, edge2: Int, edge3: Int) extends Shape(List(edge1, edge2, edge3)) :
  override def calculateArea(): Double =
    val halfPerimeter: Double = calculatePerimeter() / 2
    Math.sqrt(halfPerimeter *
      (halfPerimeter * edge1) *
      (halfPerimeter * edge2) *
      (halfPerimeter * edge3))
end Triangle
