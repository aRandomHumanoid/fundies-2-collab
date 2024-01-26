//repersents a univeristy and it's associated statistics
class University {
  String name;
  String city;
  int studentSize;
  String mostPopularMajor;
  double averageGPA;
  boolean hasCoop;
  
  University(String name, String city, int studentSize, String mostPopularMajor, 
            double averageGPA, boolean hasCoop) {
    this.name = name;
    this.city = city;
    this.studentSize = studentSize;
    this.mostPopularMajor = mostPopularMajor;
    this.averageGPA = averageGPA;
    this.hasCoop = hasCoop;
  }
}

//examples of University objects
class ExamplesUniversity {
  University yale = new University("Yale", "New Haven", 14567, "economics", 4.14, false);
  University neu = new University("Northeastern", "Boston", 19940, "engineering", 4.04, true);
  University mit = new University("MIT", "Cambridge", 11858, "computer science", 4.19, false);
} 

