package models

case class Student(name:String, username: String)

object StudentModel {
  private val data = """Asjal Ahmad, Senior, aahmad@trinity.edu
Olivia C. Bangs, Senior, obangs@trinity.edu
Ashley M. Breu, Senior, abreu@trinity.edu
Justin M. Burns, II, Senior, jburns1@trinity.edu
Kenneth M. Cadungog, Senior, kcadungo@trinity.edu
Samuel M. Cohen, Junior, scohen@trinity.edu
Audrey E. Deering, Junior, adeerin2@trinity.edu
David M. Dokupil, Junior, ddokupil@trinity.edu
Joshua H. Gammon, Senior, jgammon1@trinity.edu
Cade R. Harger, Junior, charger@trinity.edu
Tyler D. Jarrett, Junior, tjarrett@trinity.edu
Kai Kallingal, Junior, akalling@trinity.edu
Christian G. Kennedy, Senior, ckenned1@trinity.edu
Quang Minh Le, Junior, qle1@trinity.edu
Cole Joseph Lee, Senior, clee9@trinity.edu
Logan D. Martinez, Senior, lmartin9@trinity.edu
Jennalynn E. Morton, Senior, jmorton1@trinity.edu
Seth A. Owirodu, Junior, sowirodu@trinity.edu
Samuel B. Pappas, Senior, spappas@trinity.edu
Dohoon Park, Senior, dpark@trinity.edu
Matvei Popov, Junior, mpopov@trinity.edu
Vaughan J. Schulte, Senior, vschulte@trinity.edu
Ryan N. Soto, Junior, rsoto@trinity.edu
Hejun Xiao, Senior, hxiao@trinity.edu"""


  val parsedData = data.split("\n").map(row => row.split(", "))

  // def readData(): Unit = {
  //   val source = scala.io.Source.fromFile("data/StudentData.csv")
  //   val students = (for (line <- souce.getLines()) yield {
  //     val parts = line.split(", ")
  //     val username = parts(2).split("@")[0]
  //     val name = parts(1)
  //     Student(name, username)
  //   }).toList
  //   source.close()
  // }

  def getStudentData():Array[Array[String]] = {
    return parsedData
  }
}
