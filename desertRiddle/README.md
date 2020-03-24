# Legs Count Riddle
במדבר יש 3 בדואים   
לכל בדואי יש 3 גמלים   
לכל גמל 3 שקים   
בכל שק 3 חתולים   
לכל חתול 3 גורים   
כמה רגליים יש בסיפור ?  


# Solution
I have decided to try solving this problem by writing a Scala program.  
The program should be minimalist, and most importantly - Readable !  
That is, I want that any non-programmer will read it and understand how it works.

See my code here: https://github.com/alphap8/public/blob/master/desertRiddle/repl.sc


# Testing
How can you test the program?  
You should just copy the code and paste it to any online Scala editor that can execute it,  
such as https://scastie.scala-lang.org/

# Reading the code
The code is actually divided into 3 sections.

**Please note**: The parts are out of order - in the actual code  
we first declare our components  
(desert; bedvi; camel; sack; cat; kitten)  
and then use them to construct the actual riddle.

### part 1:
Here we 'build' the riddle using our components:
```scala
def totalLegsCount = 
  desert()
    .`with`(3, bedvi()
      .`with`(3, camel()
        .`with`(3, sack()
          .`with`(3, cat()
            .`with`(3, kitten()))))).totalLegsCount
```
As you can see we can read this just like we read the riddle itself:

The Desert contain 3 bedvis.

Each bedvi contain 3 camels.

Each camel contains 3 sacks.

Each sack contain 3 cats.

Each cat have 3 kitties.

### part 2:
Here we decalare all the components needed for our riddle:
```scala
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

```

### part 3:
The last part just prints the results to our screen so we can see the result:
```scala
println(s"Total legs count: $totalLegsCount")
```


