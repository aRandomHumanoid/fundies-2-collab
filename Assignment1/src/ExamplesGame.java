//interface that reperesents a Resource (either a Captain, Crewmemeber, or Ship)
interface IResource {
}

//repersents the resource type Captain, the captain of a ship
class Captain implements IResource {
  String name;
  int battles;

  Captain(String name, int battles) {
    this.name = name;
    this.battles = battles;
  }
}

//repersents the resource type CrewMemember, part of the crew of a ship
class Crewmember implements IResource {
  String name;
  String description;
  int wealth;

  Crewmember(String name, String description, int wealth) {
    this.name = name;
    this.description = description;
    this.wealth = wealth;
  }
}

//repersents the resource type Ship, a sailing ship
class Ship implements IResource {
  String purpose;
  boolean hostile;

  Ship(String purpose, boolean hostile) {
    this.purpose = purpose;
    this.hostile = hostile;
  }
}

//interface that repersents possible actions to take
interface IAction {
}

//repersents a purchanse of a reasource using money that can be made
class Purchase implements IAction {
  int cost;
  IResource item;

  Purchase(int cost, IResource item) {
    this.cost = cost;
    this.item = item; 
  }
}

//repersetns a trade between two resources that can be made
class Barter implements IAction {
  IResource sold;
  IResource acquired;

  Barter(IResource sold, IResource acquired) {
    this.sold = sold;
    this.acquired = acquired;
  }
}

//examples of potential resources and actions
class ExamplesGame {
  IResource jackSparrow = new Captain("Jack Sparrow", 89);
  IResource hectorBarbossa = new Crewmember("Hector Barbossa", "first mate", 52);
  IResource flyingDutchman = new Ship("sail the oceans forever", true);
  IResource bobbyDuke = new Captain("Bobbison Duke", 90);
  IResource christian = new Captain("Christina the Rizzler", 420);
  IResource swissCheese = new Ship("don't sink from all the holes", true);

  IAction purchase1 = new Purchase(50, jackSparrow);
  IAction purchase2 = new Purchase(45, hectorBarbossa);
  IAction barter1 = new Barter(flyingDutchman, swissCheese);
  IAction barter2 = new Barter(jackSparrow, bobbyDuke);
}
