package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import models._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  val data = """team                 won lost min  fgm  fga   3m   3a  ftm  fta   or   tr   as   st   to   bk   pf   pts  tc  ej  ff
    AtlantaHawks         41   41 19443 3658 7574  882 2505 1513 1850  920 3639 2049  580 1013  401 1541  9711   0   0   0
    BostonCeltics        57   25 19567 3460 7278 1315 3494 1436 1769  796 3717 2186  521 1043  431 1542  9671   0   0   0
    CharlotteHornets     27   55 19440 3385 7413  881 2669 1447 1933  901 3649 2062  633 1118  425 1661  9098   0   0   0
    ChicagoBulls         40   42 19500 3488 7116  854 2366 1446 1788  695 3471 2004  643 1042  370 1551  9276   0   0   0
    ClevelandCavaliers   51   31 19470 3408 6985  950 2588 1439 1844  794 3367 2045  585 1019  386 1560  9205   0   0   0
    DallasMavericks      38   44 19505 3283 6909 1246 3363 1554 2057  625 3181 1880  514  957  304 1697  9366   0   0   0
    DenverNuggets        53   29 19315 3574 7088  969 2559 1378 1834  827 3526 2369  619 1134  368 1525  9495   0   0   0
    DetroitPistons       17   65 19410 3244 7140  934 2659 1623 2106  916 3480 1884  574 1189  307 1813  9045   0   0   0
    GSWarriors           44   38 19409 3538 7393 1363 3540 1314 1655  865 3659 2446  587 1287  322 1754  9753   0   0   0
    HoustonRockets       22   60 19326 3329 7286  856 2619 1567 2078 1100 3795 1835  600 1267  373 1679  9081   0   0   0
    IndianaPacers        35   47 19342 3444 7345 1112 3029 1535 1944  832 3407 2213  631 1157  478 1741  9535   0   0   0
    LAClippers           44   38 19404 3370 7058 1041 2734 1533 1962  803 3546 1958  580 1109  365 1598  9314   0   0   0
    LALakers             43   39 19459 3516 7298  885 2558 1691 2182  818 3749 2072  526 1104  378 1466  9608   0   0   0
    MemphisGrizzlies     51   31 19353 3585 7551  985 2807 1432 1954  988 3823 2135  680 1060  473 1643  9587   0   0   0
    MiamiHeat            44   38 19421 3215 6991  980 2852 1567 1885  795 3328 1955  655 1047  243 1516  8977   0   0   0
    MilwaukeeBucks       58   24 19399 3504 7411 1217 3305 1364 1837  915 3989 2115  521 1139  404 1481  9589   0   0   0
    MinnesotaT-wolves    42   40 19420 3514 7166  997 2731 1467 1942  749 3435 2145  657 1212  444 1767  9492   0   0   0
    BrooklynNets         45   37 19324 3399 6978 1048 2769 1449 1811  674 3322 2093  585 1056  508 1729  9295   0   0   0
    NOrleansPelicans     42   40 19440 3447 7179  899 2469 1583 1998  866 3583 2122  681 1150  337 1678  9376   0   0   0
    NYKnicks             47   35 19555 3444 7329 1037 2931 1589 2087 1031 3821 1880  527  988  340 1666  9514   0   0   0
    OrlandoMagic         34   48 19358 3323 7075  883 2551 1607 2050  833 3545 1906  603 1178  383 1652  9136   0   0   0
    Philadelphia76ers    54   28 19458 3347 6869 1035 2676 1719 2058  714 3354 2063  635 1052  389 1674  9448   0   0   0
    PhoenixSuns          45   37 19350 3453 7388 1001 2675 1412 1781  971 3627 2235  585 1055  431 1739  9319   0   0   0
    PortlandTrailBlazers 33   49 19334 3316 7000 1055 2893 1609 2021  773 3324 1981  553 1120  376 1642  9296   0   0   0
    SacramentoKings      48   34 19379 3573 7232 1128 3060 1624 2055  782 3480 2237  574 1075  275 1617  9898   0   0   0
    SanAntonioSpurs      22   60 19428 3533 7593  911 2640 1292 1739  965 3585 2232  573 1208  322 1630  9269   0   0   0
    OklahomaCityThunder  40   42 19415 3533 7588  995 2795 1572 1944  933 3579 2002  676 1023  341 1722  9633   0   0   0
    TorontoRaptors       41   41 19418 3434 7489  880 2626 1506 1922 1043 3528 1961  772  920  424 1641  9254   0   0   0
    UtahJazz             37   45 19393 3485 7365 1094 3099 1536 1955  968 3762 2129  499 1221  430 1679  9600   0   0   0
    WashingtonWizards    35   47 19315 3456 7125  925 2601 1442 1838  773 3577 2083  562 1093  425 1539  9279   0   0   0
  """.split('\n').map(arr => arr.split(' ').filter(_ != ""))



  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def newRoute = Action {
    Ok(views.html.newRoute(data))
  }

  def newRoute2(name: String, color: String) = Action { 
    Ok(views.html.task2(name, color))
  }

  def postUser() = Action { request => 
    val args = request.body.asFormUrlEncoded
    args.map{ args => 
      val name = args("name").head
      Ok(views.html.postUser(name))
    }.getOrElse(Ok(""))
  }



  def getUsername() = Action {
    Ok(views.html.getUsername())
  } 

  def getStudentData() = Action {
    val data = StudentModel.getStudentData()
    val combinedData = data.map(student => student.mkString(" ")).mkString("\n")
    Ok(combinedData)
  }

  def validate1(username: String) = Action { implicit request => 
    val studentData = StudentModel.getStudentData()
    var studentExists = false
    for (student <- studentData) {
      val studentUsername = student(2).split('@')(0)
      if (studentUsername == username) {
        studentExists = true
      }
    }
    if (studentExists) {
      Redirect(routes.Application.schedulepage1).withSession("username" -> username)
    } else {
      Redirect(routes.Application.login)
    }
  }

  def schedulepage1() = Action { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username => 
      Redirect(routes.Application.loggedIn)
    }.getOrElse(Redirect(routes.Application.login))
  }

  def login = Action {
    Ok(views.html.loginPage())
  }

  def logout = Action {
    Redirect(routes.Application.login).withNewSession
  }

  def loggedIn() = Action { implicit request => 
    val usernameOption = request.session.get("username")
    usernameOption.map( username => 
      Ok(views.html.LoggedInPage(username))
    ).getOrElse(Redirect(routes.Application.login))
    
  }
  
  def counter() = Action { implicit request =>
    val count = CounterValue.get()
    Ok(views.html.counterView(count))
  }
  
  def incrementCounter() = Action { implicit request => 
    CounterValue.increment()
    val count = CounterValue.get()
    Ok(count.toString())
  }

}
