# Code Kata Boilerplate for Java 8

[![LoC](https://tokei.rs/b1/github/chrysocode/java-code-kata-boilerplate?category=code)](https://github.com/chrysocode/java-code-kata-boilerplate)
[![Files](https://tokei.rs/b1/github/chrysocode/java-code-kata-boilerplate?category=files)](https://github.com/chrysocode/java-code-kata-boilerplate)
[![Total lines](https://tokei.rs/b1/github/chrysocode/java-code-kata-boilerplate?category=lines)](https://github.com/chrysocode/java-code-kata-boilerplate)
[![Comments](https://tokei.rs/b1/github/chrysocode/java-code-kata-boilerplate?category=comments)](https://github.com/chrysocode/java-code-kata-boilerplate)
[![Blank lines](https://tokei.rs/b1/github/chrysocode/java-code-kata-boilerplate?category=blanks)](https://github.com/chrysocode/java-code-kata-boilerplate)

Use the below badge if you use TestAsYouThink Core to write high-quality tests.
[![TestAsYouThink badge](https://img.shields.io/badge/Tests%20as%20first--class%20citizens%20with-TestAsYouThink-brightgreen.svg)](https://testasyouthink.org)

## Getting started

Firstly, either you fork this [repository](https://github.com/chrysocode/java-code-kata-boilerplate) to put all your katas in the same repository, either you create a new repository per kata and push the kata boilerplate into it. Then replace the artifact coordinates used by the build system. Name the code kata too.  
Make changes only in the "kata" branch.  
You can use this shortened link if needed: [tinyurl.com/yyekn5rf](https://tinyurl.com/yyekn5rf).

### Tips

You may want to commit with another identifier to publish your code later. Nothing's easier:  
```
git config user.email "public@example.com"
git config user.name "Your Pseudo" # if needed
```

Take advantage of your IDE shortcuts while resolving any code kata. Download and print the [keymap](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf) of IntelliJ IDEA.

### Command Line Interface as a GUI

You can invoke a standalone JAR after building it with the "standalone" Maven profile.
```
mvn package -Pstandalone # to build it
java -jar target/kata-standalone.jar # to use it
```

### Updating your fork

Update your fork as follows. It is assumed you did not commit in the "master" branch. Otherwise please send me a pull request.
```
git fetch origin master && git rebase -p --onto origin/master master develop && git branch -f master origin/master
```

## Definition of Done (DoD)

What should be a DoD for the code katas?
- The kata is done by applying [Test-Driven Development (TDD)](https://en.wikipedia.org/wiki/Test-driven_development).
- The code is versioned by applying [TDDflow](https://gearsoftesting.org/tddflow.html).
- The path to the solution is discovered according to the [Transformation Priority Premise](https://en.wikipedia.org/wiki/Transformation_Priority_Premise).
- The path of successive transformations is as simple as possible.
- The code coverage is greater than 95%.
- The problem to solve is described in the kata documentation.

## License

This code kata boilerplate is distributed under the GNU GPLv3 license. The GPLv3 license is included in the LICENSE.txt file. More information about this license is available at [GNU.org](http://www.gnu.org).
