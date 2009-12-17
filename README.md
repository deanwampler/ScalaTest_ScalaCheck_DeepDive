<h1 id="scalatest_and_scalacheck_deep_dive">ScalaTest and ScalaCheck Deep Dive</h1>

<p>Chicago-Area Scala Enthusiasts
December 17, 2009</p>

<h2 id="introduction">Introduction</h2>

<p>This meeting is a deeper dive into <a href="http://www.scalatest.org/">ScalaTest</a>, covering the major &#8220;style&#8221; options available. Then we&#8217;ll talk about <a href="http://code.google.com/p/scalacheck/">ScalaCheck</a>, a port of Haskell&#8217;s <a href="http://www.cs.chalmers.se/~rjmh/QuickCheck/">QuickCheck</a>, which approaches testing from a functional perspective.</p>

<p>In <code>ScalaCheck</code>, you specify the properties for a type and verify that those properties are satisfied using an automatically-generated and representative sample of instances of the type. It&#8217;s a very different style than XUnit or BDD style testing that you might already know.</p>

<p>We&#8217;ll work through examples of all these approaches using a simple Complex number class. Then you can play with the test styles using a provided Rational number class. (There isn&#8217;t a presentation to go with this code&#8230;)</p>

<h2 id="getting_the_code">Getting the Code</h2>

<pre><code>git clone git://github.com/deanwampler/ScalaTest_ScalaCheck_DeepDive.git
</code></pre>

<p>Project <a href="http://github.com/deanwampler/ScalaTest_ScalaCheck_DeepDive">Web site</a>.</p>

<h2 id="building_and_testing">Building and Testing</h2>

<p>The code uses <a href="http://code.google.com/p/simple-build-tool/">sbt</a>, the <em>Simple Build Tool</em>. The jar for it is in the <code>lib</code> directory and two driver scripts are provided in the <code>bin</code> directory.</p>

<pre><code>bin/sbt       # Mac OS, Linux, or Unix (maybe Cygwin?)
bin\sbt.bat   # Windows
</code></pre>

<p>I assume you have Scala 2.7.7 installed. If you are using a different version of
Scala, edit the <code>project/build.properties</code> file and change the value for the <code>scala.version</code> property to match your version. </p>

<p>If you are using 2.8, please check the SBT website to find out if you need a different <code>sbt-launcher-X.Y.Z.jar</code> version. If so, replace the one in the <code>lib</code> directory.</p>

<h3 id="startin_sbt">Startin SBT</h3>

<p>To begin, run either <code>bin/sbt</code> or <code>bin\sbt.bat</code>.</p>

<p>At the prompt Run the following two commands.</p>

<pre><code>&gt; help
&gt; update
&gt; test
</code></pre>

<p>The <code>help</code> <em>action</em>, isn&#8217;t really required, but now you know what to do when you have questions&#8230;</p>

<p>The <code>update</code> action pulls down the other dependencies (required). </p>

<p>The <code>test</code> action will first compile all the files, then run the tests. The (lengthy) output should end with the following:</p>

<pre><code>[info] ...
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
&gt;
</code></pre>

<p>SBT has the cool feature that you can define an action to run after every change to the file system. This saves you the trouble of manually invoking a target, like <code>test</code> each time.</p>

<pre><code>&gt; ~ test
</code></pre>

<p>I recommend you do this for the rest of the session. (You can hit <code>&lt;return&gt;</code> to break out of it at any time.)</p>

<h2 id="learning_about_scalatest_and_scalacheck">Learning about ScalaTest and ScalaCheck</h2>

<p>We&#8217;ll walk through all the examples using different syntax options for ScalaTest and the different approach of ScalaCheck, both using a simple Complex number class. Feel free to use any editor to view the files. </p>

<p>The file <code>complex.scala</code> is in <code>src/main/scala</code>. (You&#8217;ll also find <code>rational.scala</code>, which we&#8217;ll discuss shortly.)</p>

<p>The corresponding ScalaTest files are <code>src/test/scala/complex-*-test.scala</code>. The ScalaCheck file is <code>src/test/scala/complex-check.scala</code>. </p>

<h2 id="your_exercise_should_you_choose_to_accept_it">Your Exercise, Should You Choose to Accept It</h2>

<p>The <code>rational.scala</code> file defines a <code>Rational</code> class with a little more detail than the <code>Complex</code> class. Pick one or more of the ScalaTest styles and create tests that exercise the Rational class. Do the same thing for ScalaCheck testing.</p>

<p>See the <a href="http://www.scalatest.org/">ScalaTest</a> and <a href="http://code.google.com/p/scalacheck/">ScalaCheck</a> documentation for more detailed examples, &#8220;scaladocs&#8221;, etc. </p>
