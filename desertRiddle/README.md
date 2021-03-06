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


# Running the code
How can you test the program?  
You should just copy the code and paste it to any online Scala editor that can execute it,  
such as https://scastie.scala-lang.org/

# Reading the code
The code is actually divided into 3 sections.

### part 1:
Here we implement the legged object:
```scala
case class legged(legsCount: Int = 0) {
    def `with`(c: Int, that: legged) = copy(this.legsCount + c * that.legsCount)
  }
```
### part 2:
Now we declare instances of legged object.  
These instances will later be used to construct the riddle:
```scala
  val desert = legged(0)
  val bedvi = legged(2)
  val camel = legged(4)
  val sack = legged(0)
  val cat = legged(4)
  val kitten = legged(4)
```

### part 3:
```scala
  def solve() =
    desert
      .`with`(3, bedvi
        .`with`(3, camel
          .`with`(3, sack
            .`with`(3, cat
              .`with`(3, kitten))))).legsCount
```
As you can see we can read this just like we read the riddle itself:

The Desert contain 3 bedvis.

Each bedvi contain 3 camels.

Each camel contains 3 sacks.

Each sack contain 3 cats.

Each cat have 3 kitties.

### part 4:
Here we actually executing our nice little program  
by calling Riddle.solve().  
The result is printed so the user can see it on the screen 
```scala
println(s"Total legs count: ${Riddle.solve()}")
```


