import tester.*;



///////////////////////
//  Website Content  //
///////////////////////


// To represent website content
interface IContent {
  // Return the cost of this content in megabytes
  double megabyteCost();
  
  // Returns the picture info of this content
  String pictureInfo();
  
  // Returns that list of content that costs money
  ILoContent costMoney(ILoContent c);
  
  // Returns true if that equals this
  boolean sameContent(IContent that);
  
  // Return true if this equals that
  boolean sameName(String name);
}



// To represent a text block in a website
class Text implements IContent {

  String name;        // The name of this text block
  int numLines;       // The number of lines in this text block
  boolean inMarkdown; // Is this text block written in markdown
  
  // Text Constructor
  public Text(String name, int numLines, boolean inMarkdown) {
    this.name = name;
    this.numLines = numLines;
    this.inMarkdown = inMarkdown;
  }
  
  /* TEMPLATE
   * Fields:
   * ... this.name ...          -- String
   * ... this.numLines ...      -- int
   * ... this.inMarkdown ...    -- boolean
   * 
   * Methods:
   * ... this.megabyteCost() ...    -- double
   * ... this.pictureInfo() ...     -- String
   * ... this.costMoney() ...       -- ILoContent
   * ... this.sameContent() ...     -- boolean
   * ... this.sameName() ...        -- boolean
   */
  
  // Returns the cost of this text block
  public double megabyteCost() {
    // Web provider doesn't charge for text blocks
    // so the cost is 0
    return 0;
  }
  
  // Returns the picture info
  public String pictureInfo() {
    // Text blocks have no picture info
    return "";
  }
  
  // Returns that list of content
  public ILoContent costMoney(ILoContent c) {
    return c;
  }
  
  //Returns true if that equals this
  public boolean sameContent(IContent that) {
    return that.sameName(this.name);
  }
   
  // Return true if this equals that
  public boolean sameName(String name) {
    return this.name.equals(name);
  }
  
}



// To represent a picture in a website
class Picture implements IContent {
  
  String name;          // The name of this picture
  String description;   // A description of this picture
  double megabytes;     // The number of megabytes this picture is
  
  // Picture Constructor
  public Picture(String name, String description, double megabytes) {
    this.name = name;
    this.description = description;
    this.megabytes = megabytes;
  }
  
  /* TEMPLATE
   * Fields:
   * ... this.name ...            -- String
   * ... this.description ...     -- String
   * ... this.megabytes ...       -- double
   * 
   * Methods:
   * ... this.megabyteCost() ...    -- double
   * ... this.pictureInfo() ...     -- String
   * ... this.costMoney() ...       -- ILoContent
   * ... this.sameContent() ...     -- boolean
   * ... this.sameName() ...        -- boolean
   */
  
  // Returns the megabyteCost of this picture
  public double megabyteCost() {
    // Web provider charges per megabyte
    return this.megabytes;
  }
  
  // Returns the picture info of this picture
  public String pictureInfo() {
    return this.name + " (" + this.description + ")";
  }
  
  // Returns that list of content
  public ILoContent costMoney(ILoContent c) {
    return new ConsLoContent(this, c);
  }
  
  //Returns true if that equals this
  public boolean sameContent(IContent that) {
    return that.sameName(this.name);
  }
   
  // Return true if this equals that
  public boolean sameName(String name) {
    return this.name.equals(name);
  }
  
}



// To represent a hyperlink
class Hyperlink implements IContent {
  
  String text;          // The text of this link
  Webpage destination;  // The destination of this link
  
  // Link constructor
  public Hyperlink(String text, Webpage destination) {
    this.text = text;
    this.destination = destination;
  }
  
  /* TEMPLATE
   * Fields:
   * ... this.text ...          -- String
   * ... this.destination ...   -- Webpage
   * 
   * Methods:
   * ... this.megabyteCost() ...  -- double
   * ... this.pictureInfo() ...   -- String
   * ... this.costMoney() ...     -- ILoContent
   * ... this.sameContent() ...   -- boolean
   * ... this.sameName() ...      -- boolean
   * 
   * Methods on Fields:
   * ... this.destination.workingCredits() ...  -- double
   * ... this.destination.pictureInfo() ...     -- String
   */
  
  public double megabyteCost() {
    return this.destination.totalMegabytes();
  }
  
  public String pictureInfo() {
    return this.destination.pictureInfo();
  }

  // Returns that list of content
  public ILoContent costMoney(ILoContent c) {
    return this.destination.costMoney(c);
  }
  
  //Returns true if that equals this
  public boolean sameContent(IContent that) {
    return that.sameName(this.text);
  }
   
  // Return true if this equals that
  public boolean sameName(String name) {
    return this.text.equals(name);
  }
  
}





///////////////////////////////
//  List of Website Content  //
///////////////////////////////


// To represent a list of website content
interface ILoContent {
  // Returns the total megabytes charged by the web provider
  double megabyteCost();
  
  // Returns the picture info of the list of content
  String pictureInfo();
  
  // Returns that list of content
  ILoContent costMoney(ILoContent c);
  
  // Combines that list of content with this list of content
  ILoContent combine(ILoContent that);
  
  // Returns true if this contains that
  boolean contains(IContent that);
  
  // Returns this with duplicates removed
  ILoContent removeDuplicates();
}

// To represent a cons of website content
class ConsLoContent implements ILoContent {
  
  IContent first;     // The website content in this cons
  ILoContent rest;    // The rest of this list of content
  
  // Cons Constructor
  public ConsLoContent(IContent first, ILoContent rest) {
    this.first = first;
    this.rest = rest;
  }
  
  /* TEMPLATE
   * Fields:
   * ... this.first ...   -- IContent
   * ... this.rest ...    -- ILoContent
   * 
   * Methods:
   * ... this.totalMegabytes() ...    -- double
   * ... this.pictureInfo() ...       -- String
   * ... this.costMoney() ...         -- ILoContent
   * ... this.combine() ...           -- ILoContent
   * ... this.contains() ...          -- boolean
   * ... this.removeDuplicates() ...  -- ILoContent
   * 
   * Methods on Fields:
   * ... this.first.megabyteCost() ...  -- double
   * ... this.first.pictureInfo() ...   -- String
   * ... this.rest.megabyteCost() ...   -- double
   * ... this.rest.pictureInfo() ...    -- String
   */
  
  // Returns the megabyte cost of this list of content
  public double megabyteCost() {
    return this.first.megabyteCost() + this.rest.megabyteCost();
  }
  
  // Returns the picture info of this list of content
  public String pictureInfo() {
    if (this.first.pictureInfo().equals("")) {
      return this.rest.pictureInfo();
    }
    else if (this.rest.pictureInfo().equals("")) {
      return this.first.pictureInfo();
    }
    else {
      return this.first.pictureInfo() + ", " + this.rest.pictureInfo();
    }
  }

  // Returns that list of content
  public ILoContent costMoney(ILoContent c) {
    return this.rest.costMoney(this.first.costMoney(c));
  }
  
  // Combines that list of content with this list of content
  public ILoContent combine(ILoContent that) {
    return new ConsLoContent(this.first, this.rest.combine(that));
  }
  
  //Returns true if this contains that
  public boolean contains(IContent that) {
    return this.first.equals(that) || this.rest.contains(that);
  }
  
  //Returns this with duplicates removed
  public ILoContent removeDuplicates() {
    if (this.rest.contains(this.first)) {
      return rest.removeDuplicates();
    } else {
      return new ConsLoContent(this.first, this.rest.removeDuplicates());
    }
  }
  
}


// To represent an empty list of content
class MtLoContent implements ILoContent {
  
  /* TEMPLATE
   * Methods:
   * ... this.megabyteCost() ...      -- double
   * ... this.pictureInfo() ...       -- String
   * ... this.costMoney() ...         -- ILoContent
   * ... this.combine() ...           -- ILoContent
   * ... this.contains() ...          -- boolean
   * ... this.removeDuplicates() ...  -- ILoContent
   */
  
  // Returns the megabyte cost of this list of content
  public double megabyteCost() {
    return 0;
  }
  
  // Returns the picture info of this list of content
  public String pictureInfo() {
    return "";
  }
  
  //Returns that list of content
  public ILoContent costMoney(ILoContent c) {
    return c;
  }
  
  // Combines that list of content with this list of content
  public ILoContent combine(ILoContent that) {
    return that;
  }
  
  // Returns true if this contains that
  public boolean contains(IContent that) {
    return false;
  }
  
  // Returns this with duplicates removed
  public ILoContent removeDuplicates() {
    return this;
  }
  
}






///////////////
//  Webpage  //
///////////////

// To represent a webpage
class Webpage {
  
  String name;          // The name of this webpage
  ILoContent content;   // The content on this webpage
  
  // Webpage constructor
  public Webpage(String name, ILoContent content) {
    this.name = name;
    this.content = content;
  }
  
  /* TEMPLATE
   * Fields:
   * ... this.name ...      -- String
   * ... this.content ...   -- ILoContent
   * 
   * Methods:
   * ... this.totalCredits() ...    -- int
   * ... this.totalMegabytes() ...  -- double
   * ... this.pictureInfo() ...     -- String
   * ... this.costMoney() ...       -- ILoContent
   * 
   * Methods on Fields:
   * ... this.content.megabyteCost() ...  -- double
   * ... this.content.pictureInfo() ...   -- String
   * ... this.content.costMoney() ...     -- ILoString
   */
  
  // Returns the total charged credits of this website
  public int totalCredits() {
    return (int) Math.ceil(this.totalMegabytes()) * 50;
  }
  
  // Returns the current number of megabytes of this website
  public double totalMegabytes() {
    return this.content.costMoney(new MtLoContent())
        .removeDuplicates().megabyteCost();
  }
  
  // Returns the picture info of this website
  public String pictureInfo() {
    return this.content.costMoney(new MtLoContent())
        .removeDuplicates().pictureInfo();
  }
  
  // Returns that list of content
  public ILoContent costMoney(ILoContent c) {
    return this.content.costMoney(c);
  }
  
}


// Unique Webpage Examples
class ExamplesWebpages {
  
  // Assignment One
  IContent submission = new Picture("Submission", "submission screenshot", 13.7);
  ILoContent aOneContent = new ConsLoContent(submission, new MtLoContent());
  Webpage assignmentOne = new Webpage("Assignment 1", aOneContent);
  
  IContent aOneHyperlink = new Hyperlink("First Assignment", assignmentOne);
  
  // Assignments
  IContent pairProgramming = new Text("Pair Programming", 10, false);
  IContent expectations = new Text("Expectations", 15, false);
  ILoContent assignContent = new ConsLoContent(pairProgramming,
      new ConsLoContent(expectations, new ConsLoContent(aOneHyperlink, new MtLoContent())));
  Webpage assignments = new Webpage("Assignments", assignContent);
  
  IContent assignHyperlink = new Hyperlink("Course Assignments", assignments);
  
  // Syllabus
  IContent java = new Picture("Java", "HD Java logo", 4);
  IContent weekOne = new Text("Week 1", 10, true);
  ILoContent syllabusContent = new ConsLoContent(java, new ConsLoContent(weekOne,
      new ConsLoContent(aOneHyperlink, new MtLoContent())));
  Webpage syllabus = new Webpage("Syllabus", syllabusContent);
  
  IContent syllabusHyperlink = new Hyperlink("Course Syllabus", syllabus);
  
  // Fundies 2 Homepage
  IContent courseGoals = new Text("Course Goals", 5, true);
  IContent instructorContact = new Text("Instructor Contact", 1, false);
  IContent eclipse = new Picture("Eclipse", "Eclipse logo", 0.13);
  IContent codingBG = new Picture("Coding Background", "digital rain from the Matrix", 30.2);
  ILoContent homepageContent = new ConsLoContent(courseGoals, new ConsLoContent(instructorContact,
      new ConsLoContent(eclipse, new ConsLoContent(codingBG, new ConsLoContent(syllabusHyperlink,
          new ConsLoContent(assignHyperlink, new MtLoContent()))))));
  Webpage homepage = new Webpage("Fundies 2 Homepage", homepageContent);
  
  boolean testTotalCredits(Tester t) {
    return t.checkExpect(assignmentOne.totalCredits(), 700)
        && t.checkExpect(assignments.totalCredits(), 700)
        && t.checkExpect(syllabus.totalCredits(), 900);
  }
  
  boolean testPictureInfo(Tester t) {
    return t.checkExpect(assignmentOne.pictureInfo(), "Submission (submission screenshot)")
        && t.checkExpect(assignments.pictureInfo(), "Submission (submission screenshot)")
        && t.checkExpect(syllabus.pictureInfo(), 
            "Java (HD Java logo), Submission (submission screenshot)")
        && t.checkExpect(homepage.pictureInfo(), 
                "Eclipse (Eclipse logo), Coding Background (digital rain from the Matrix), "
                        + "Java (HD Java logo), Submission (submission screenshot), "
                                    + "Submission (submission screenshot)");
  }
  
  boolean testCostMoney(Tester t) {
    return t.checkExpect(homepage.costMoney(new MtLoContent()),
        new ConsLoContent(submission, 
            new ConsLoContent(submission, 
                new ConsLoContent(java, 
                    new ConsLoContent(codingBG, 
                        new ConsLoContent(eclipse, new MtLoContent()))))));
  }
  
  boolean testTotalMegabytes(Tester t) {
    return t.checkExpect(homepage.totalMegabytes(), 0.0);
  }
  
  
}