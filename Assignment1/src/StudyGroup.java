//intereface for StudyGroup; repersents either a Person or a StudyBuddy
interface IStudyGroup {
}

//a Person; repersents the leader of a StudyGroup
class Person implements IStudyGroup {
  String name;

  Person(String name) {
    this.name = name;
  }
}

//a StudyBuddy; reperesents part of a StudyGroup
class StudyBuddy implements IStudyGroup {
  IStudyGroup connection;
  String name;

  StudyBuddy(IStudyGroup connection, String name) {
    this.connection = connection;
    this.name = name;
  }
}

//Examples of a StudyGroup
class ExamplesStudyGroup {
  IStudyGroup labs = new StudyBuddy(new Person("Margaryta"), "Regan");
  IStudyGroup largeGroup = new StudyBuddy(new StudyBuddy(new StudyBuddy(new Person("Ted"), 
              "Liz"), "Jenny"), "Cornelius");
}