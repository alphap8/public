object Riddle {
  case class legged(val legsCount: Int = 0) {
    def totalLegsCount = legsCount
    def `with`(c: Int, t: legged) = new legged(legsCount + t.legsCount * c)
  }

  val desert = legged(0)
  val bedvi = legged(2)
  val camel = legged(4)
  val sack = legged(0)
  val cat = legged(4)
  val kitten = legged(4)

  def solve() =
    desert
      .`with`(3, bedvi
        .`with`(3, camel
          .`with`(3, sack
            .`with`(3, cat
              .`with`(3, kitten))))).totalLegsCount
}

println(s"Total legs count: ${Riddle.solve()}")
