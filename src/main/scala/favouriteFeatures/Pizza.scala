package favouriteFeatures

case class Pizza(ingredients: Seq[String] = Seq.empty, base: String = "Normal", topping: String = "Mozzarella"):


  override def toString(): String = "Pizza:\n" +
    "Base:" + base +
    "\nTopping: " + topping +
    "\nIngredients: " + ingredients.mkString(", ")
