# JustEatTest_BMO

Hi this is the Just Eat Test Website

I can currently going to make a better readMe on github but this is simply to see to test out the code

^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
NOTE: This was done on a linux computer with an eclipse IDE
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

***********************************************************************************************
BASIC NEEDS
Have maven installed
Have latest Java installed
Have cucumber plugin installed (I had it for eclipse, its not nessary but it helps)
Don't use a vpn (just-eat.co.uk doesn't allow for vpn)
also firefox was used for selenium so you might need to install firefox, but I don't think you have to
*************************************************************************************************


The Project is called JustEatSimpleTest
********************************************************
Files of Interest
**********************************************************

------------------------------
pom.xml
______________________________
Has all the dependicies
if error, delete the depencies one at a time to see which one has an error
I think there might be a bug with some of the dependicies relating to windows 10, but 
if you have everything installed and update it should be fine on windows 10
------------------------------


------------------------------
scr/test/resouces/features.features
______________________________
This is a cucumber file that is called within the application
It has three scenarios
First one is the one that was asked
And the other two were one's I made up that I believe would help expand the testing
------------------------------

------------------------------
scr/test/java/TestRunner.java
______________________________
This runs the Junit test, the test can also be runned from the features.features, but this
is recommended as their is a details about the test 
------------------------------

------------------------------
scr/test/java/JustEatTest.java
______________________________
This opperates the given command from the features.features files, and actually does the commands
within codeing language, it is called by the TestRunner.java class and features.features class
------------------------------


RUNNING THE PROGRAM
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Unzip the JustEatSimpleTest.Zip
Open the project within your ide
Right-CLick on TestRunner.java from your Ide
Run as Junit
Watch the results
Firefox browswer should Open and close three times
each time it opens it should do something slightly different
Right of the box should say all junit test have passed
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
