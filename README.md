# ScalaTest and ScalaCheck Deep Dive #

Chicago-Area Scala Enthusiasts
December 17, 2009

## Introduction ##

This meeting is a deeper dive into [ScalaTest](http://www.scalatest.org/), covering the major "style" options available. Then we'll talk about [ScalaCheck](http://code.google.com/p/scalacheck/), a port of Haskell's [QuickCheck](http://www.cs.chalmers.se/~rjmh/QuickCheck/), which approaches testing from a functional perspective.

In `ScalaCheck`, you specify the properties for a type and verify that those properties are satisfied using an automatically-generated and representative sample of instances of the type. It's a very different style than XUnit or BDD style testing that you might already know.

We'll work through examples of all these approaches using a simple Complex number class. Then you can play with the test styles using a provided Rational number class. (There isn't a presentation to go with this code...)

## Getting the Code ##

    git clone git://github.com/deanwampler/ScalaTest_ScalaCheck_DeepDive.git

Here is the GitHub [project web site](http://github.com/deanwampler/ScalaTest_ScalaCheck_DeepDive).

## Building and Testing ##

The code uses [sbt](http://code.google.com/p/simple-build-tool/), the *Simple Build Tool*. The jar for it is in the `lib` directory and two driver scripts are provided in the `bin` directory.

    bin/sbt       # Mac OS, Linux, or Unix (maybe Cygwin?)
    bin\sbt.bat   # Windows

The code works with Scala 2.7.7 (which the SBT build will install). The code may work with earlier versions of Scala and possibly with Scala 2.8.0. You can experiment with different versions by changing the value for the `scala.version` property in `project/build.properties`. See also the additional dependencies that are defined in `project/build/ScalaTestingDeepDive.scala`.

Also, if you want to are 2.8, please check the SBT website to find out if you need a different `sbt-launcher-X.Y.Z.jar` version. If so, replace the one in the `lib` directory.

### Starting SBT ###

To begin, run either `bin/sbt` or `bin\sbt.bat`.

At the prompt Run the following commands.

    > help
    > update
    > test

The `help` *action* isn't really required, but now you know what to do when you have questions&#8230;

The `update` action pulls down the other dependencies (required). 

The `test` action will first compile all the files, then run the tests. The (lengthy) output should end with the following:

    [info] ...
    [info] == test-finish ==
    [info] Run: 24, Passed: 24, Errors: 0, Failed: 0
    [info]  
    [info] All tests PASSED.
    [info] == test-finish ==
    [info] 
    [info] == test-cleanup ==
    [info] == test-cleanup ==
    [info] 
    [info] == test ==
    [info] == test ==
    [success] Successful.
    [info] 
    [info] Total time: 6 s
    >

SBT has the cool feature that you can define an action to run after every change to the file system. This saves you the trouble of manually invoking a target, like `test` each time.

    > ~ test

I recommend you do this for the rest of the session. (You can hit `<return>` to break out of it at any time.)

## Learning about ScalaTest and ScalaCheck ##

We'll walk through all the examples using different syntax options for ScalaTest and the different approach of ScalaCheck, both using a simple Complex number class. Feel free to use any editor to view the files. 

The file `complex.scala` is in `src/main/scala`. (You'll also find `rational.scala`, which we'll discuss shortly.)

The corresponding ScalaTest files are `src/test/scala/complex-*-test.scala`. The ScalaCheck file is `src/test/scala/complex-check.scala`. 

## Your Exercise, Should You Choose to Accept It ##

The `rational.scala` file defines a `Rational` class with a little more detail than the `Complex` class. Pick one or more of the ScalaTest styles and create tests that exercise the Rational class. Do the same thing for ScalaCheck testing.

See the [ScalaTest](http://www.scalatest.org/) and [ScalaCheck](http://code.google.com/p/scalacheck/) documentation for more detailed examples, "scaladocs", etc. 
