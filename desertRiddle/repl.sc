class solver(val legsCount: Int = 0)  {
  def totalLegsCount = legsCount
  def `with`(c:Int, t: solver) = new solver(legsCount + t.legsCount * c)
}

case class desert(override val legsCount:Int = 0) extends solver

case class sack(override val legsCount:Int = 0) extends solver

case class bedvi(override val legsCount:Int = 2) extends solver

case class camel(override val legsCount:Int = 4) extends solver

case class cat(override val legsCount:Int = 4) extends solver

case class kitten(override val legsCount:Int = 4) extends solver

def totalLegsCount = {
  desert()
    .`with`(3, bedvi()
      .`with`(3, camel()
        .`with`(3, sack()
          .`with`(3, cat()
            .`with`(3, kitten()))))).totalLegsCount
}

println(s"Total legs count: $totalLegsCount")
